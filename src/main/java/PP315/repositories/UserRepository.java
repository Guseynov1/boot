package PP315.repositories;


import PP315.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select u from User u join fetch u.roles where u.email=:email")
    User findByUsername(String email);
    @Override
    Optional<User> findById(Long id);
}
