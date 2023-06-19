package PP315.repositories;

import PP315.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleJpaRep extends JpaRepository<Role, Long> {
}
