package PP314.service;

import PP314.model.Role;
import PP314.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class RoleServiceImpl implements RoleService{

    private final RoleRepository roleRepository;
    @Override
    @Transactional
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
    @Override
    @Transactional
    public void addRole(Role role) {
        roleRepository.save(role);
    }
}
