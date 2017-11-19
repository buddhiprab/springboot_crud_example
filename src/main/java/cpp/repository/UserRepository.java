package cpp.repository;

import cpp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE lower(u.lastName) LIKE CONCAT(lower(:lastName),'%')")
    public List<User> search(@Param("lastName") String lastName);
}