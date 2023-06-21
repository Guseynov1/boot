package PP315;//package Kata.Security.Task.util;

import PP315.model.Role;
import PP315.model.User;
import PP315.service.RoleService;
import PP315.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Component
public class Initial {

    private final UserService userService;
    private final RoleService roleService;

    @PostConstruct
    public void init() {

        Role roleAdmin = new Role("ROLE_ADMIN");
        Role roleUser = new Role("ROLE_USER");
        roleService.add(roleUser);
        roleService.add(roleAdmin);
        Set<Role> setRoleAdmin = new HashSet<>();
        Set<Role> setRoleUser = new HashSet<>();
        setRoleUser.add(roleUser);
        setRoleAdmin.add(roleAdmin);

        User admin = new User(1L, "admin", "admin@mail.ru", "Bob", "Malcolm", 23, setRoleAdmin);
        User user = new User(2L, "user", "user@mail.ru", "Kate", "Blanchette", 25, setRoleUser);

        userService.addUser(admin);
        userService.addUser(user);

    }
}
