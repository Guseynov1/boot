package PP313;

import PP313.model.Role;
import PP313.model.User;
import PP313.repo.RoleRepo;
import PP313.repo.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Component
public class Initial implements CommandLineRunner {

    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    private final PasswordEncoder passwordEncoder;

    public void run(String... arg) throws Exception {
        Role roleAdmin = new Role("ROLE_ADMIN");
        Role roleUser = new Role("ROLE_USER");
        Set<Role> adminRoles = new HashSet<>();
        Set<Role> userRoles = new HashSet<>();
        roleRepo.save(roleAdmin);
        roleRepo.save(roleUser);
        adminRoles.add(roleAdmin);
        adminRoles.add(roleUser);
        userRoles.add(roleUser);

        User admin = new User(1L,"Bob", "Malcolm", 23,"admin@mail.ru", passwordEncoder.encode("admin"), adminRoles);
        User user = new User(2L, "John", "Smith", 25, "user@mail.ru", passwordEncoder.encode("user"), userRoles);
        userRepo.save(admin);
        userRepo.save(user);
    }
}