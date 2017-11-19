package cpp.service;

import cpp.model.User;
import cpp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUser(long id){
        return userRepository.getOne(id);
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public void deleteUser(long id) {
        userRepository.delete(id);
    }

    public List<User> searchUser(String searchText){
        return userRepository.search(searchText);
    }
}
