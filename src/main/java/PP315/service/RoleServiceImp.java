package PP315.service;

import PP315.model.Role;
import PP315.repositories.RoleJpaRep;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class RoleServiceImp implements RoleService {

    private final RoleJpaRep roleJpaRep;
    @Override
    public Role findRoleById(Long id) {
        return roleJpaRep.findById(id).orElse(null);
    }
    @Override
    public List<Role> getAllRoles() {
        return roleJpaRep.findAll();
    }
    @Override
    public List<Role> getRoles() {
        return roleJpaRep.findAll();
    }
    @Override
    @Transactional
    public void addRole(Role role) {
        roleJpaRep.save(role);
    }
}
