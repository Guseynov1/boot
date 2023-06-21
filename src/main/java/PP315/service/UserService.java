package PP315.service;

import PP315.model.Role;
import PP315.model.User;

import java.util.List;


public interface UserService {
    void addUser(User user);
    List<User> getAllUsers();
    User getUserById(Long id);
    List<Role> getAllRoles();
    void updateUser(User user, Long id);
    void deleteUser(Long id);
    User getByUsername(String userName);
    User getCurrentUser();
}
