package PP314.service;

import PP314.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAllRoles();
    void addRole(Role role);
}
