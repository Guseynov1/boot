package PP313.service;


import PP313.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long id);
    User getByName(String username);
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(Long id);

}

