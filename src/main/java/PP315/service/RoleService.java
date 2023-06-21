package PP315.service;

import PP315.model.Role;

import java.util.List;

public interface RoleService {
    void add(Role role);
    List<Role> getListRoles();
    List<Role> getRolesListById(List<Long> id);
    Role getRoleById(Long id);
}
