package cpp.controller;

import cpp.model.Holding;
import cpp.model.User;
import cpp.repository.UserRepository;
import cpp.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static junit.framework.TestCase.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private UserService userService;
    @Test
    public void testSearch() {
        User u = new User();
        u.setFirstName("test");
        u.setLastName("koo");
        entityManager.persist(u);
        List<User> users = userService.searchUser("ko");
        assertEquals("test", users.get(0).getFirstName());
        assertEquals("koo", users.get(0).getLastName());
    }
    @Test
    public void getUser(){
        User u = new User();
        u.setFirstName("test333");
        u.setLastName("koo");
        Object id = entityManager.persistAndGetId(u);
        User user = userService.getUser(Long.parseLong(id.toString()));
        assertEquals("test333", user.getFirstName());
    }
}