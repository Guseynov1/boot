package PP314;

import PP314.model.Role;
import PP314.model.User;
import PP314.repository.RoleRepository;
import PP314.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Component
public class Init implements CommandLineRunner {

    private final UserRepository userJpaRep;
    private final RoleRepository roleJpaRep;
    private final PasswordEncoder passwordEncoder;

    public void run(String... arg) throws Exception {
        Role roleAdmin = new Role("ADMIN");
        Role roleUser = new Role("USER");
        Set<Role> adminRoles = new HashSet<>();
        Set<Role> userRoles = new HashSet<>();
        roleJpaRep.save(roleAdmin);
        roleJpaRep.save(roleUser);
        adminRoles.add(roleAdmin);
        adminRoles.add(roleUser);
        userRoles.add(roleUser);

        User userAdmin = new User(1L, "John", "Smith", 23, "admin@mail.ru", passwordEncoder.encode("admin"), adminRoles);
        User userUser = new User(2L, "Bob", "Trevor", 25, "user@mail.ru", passwordEncoder.encode("user"), userRoles);
        userJpaRep.save(userAdmin);
        userJpaRep.save(userUser);
    }
}