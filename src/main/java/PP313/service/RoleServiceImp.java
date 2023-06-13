package PP313.service;

import PP313.model.Role;
import PP313.repo.RoleRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class RoleServiceImp implements RoleService {

    private final RoleRepo roleRepo;
    @Override
    public Role findRoleById(Long id) {
        return roleRepo.findById(id).orElse(null);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepo.findAll();
    }

    @Override
    public List<Role> getRoles() {
        return roleRepo.findAll();
    }

    @Override
    @Transactional
    public void addRole(Role role) {
        roleRepo.save(role);
    }
}
