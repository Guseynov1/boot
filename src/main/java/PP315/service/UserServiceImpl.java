package PP315.service;

import PP315.model.Role;
import PP315.model.User;
import PP315.repositories.RoleRepository;
import PP315.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;
    private final RoleRepository roleRepo;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User getByUsername(String firstName) {
        return userRepo.findByUsername(firstName);
    }

    @Override
    @Transactional
    public void addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepo.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepo.findById(id).get();
    }

    @Override
    @Transactional
    public void updateUser(User user, Long id) {
        User oldUser = getUserById(user.getId());
        if (oldUser.getPassword().equals(user.getPassword()) || "".equals(user.getPassword())) {
            user.setPassword(oldUser.getPassword());
        } else user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }

    @Override
    public User getCurrentUser() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
