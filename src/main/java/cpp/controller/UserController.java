package cpp.controller;

import cpp.model.User;
import cpp.repository.UserRepository;
import cpp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity getUsers(){
        List<User> users = userService.getAllUsers();
        if (users != null) {
            return new ResponseEntity<List<User>>(users, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity getUser(@PathVariable("id") Long id) {
        User user = userService.getUser(id);
        if (user != null) {
            return new ResponseEntity<User>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/{id}")
    public ResponseEntity saveUser(@PathVariable("id") Long id, @RequestBody User user, UriComponentsBuilder builder) {
        User savedUser = null;
        try{
            savedUser = userService.saveUser(user);
        } catch (Exception e){
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if(savedUser != null){
            return new ResponseEntity<Long>(savedUser.getId(),HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "search/{name}")
    public ResponseEntity searchUser(@PathVariable("name") String name) {
        List<User> users = userService.searchUser(name);
        if (users != null) {
            return new ResponseEntity<List<User>>(users, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}