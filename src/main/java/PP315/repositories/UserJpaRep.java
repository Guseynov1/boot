package PP315.repositories;

import PP315.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserJpaRep extends JpaRepository<User, Long> {
    User findByUserName (String username);
    @Override
    Optional<User> findById(Long id);
}
