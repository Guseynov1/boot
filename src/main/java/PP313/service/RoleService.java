package PP313.service;

import PP313.model.Role;

import java.util.List;

public interface RoleService {
    Role findRoleById(Long id);

    List<Role> getAllRoles();

    List<Role> getRoles();

    void addRole(Role role);
}
