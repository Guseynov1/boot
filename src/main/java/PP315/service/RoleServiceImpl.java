package PP315.service;

import PP315.model.Role;
import PP315.repositories.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class RoleServiceImpl implements RoleService{

    private final RoleRepository roleRepository;
    @Override
    public void add(Role role) {
        roleRepository.save(role);
    }
    @Override
    public List<Role> getListRoles() {
        return roleRepository.findAll();
    }
    @Override
    public List<Role> getRolesListById(List<Long> id) {
        return roleRepository.findAllById(id);
    }
    @Override
    public Role getRoleById(Long id) {
        return roleRepository.getById(id);
    }

}
