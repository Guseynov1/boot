package PP314.service;

import PP314.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    List<User> getAllUsers();
    User getUser(Long id);
    void updateUser(User user);
    void deleteUser(Long id);
    User findByUsername(String username);
}
