package PP315.service;


import PP315.model.Role;

import java.util.List;

public interface RoleService {
    public Role findRoleById(Long id);

    public List<Role> getAllRoles();

    List<Role> getRoles();

    public void addRole(Role role);
}
