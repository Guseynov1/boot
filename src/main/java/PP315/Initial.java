package PP315;

import PP315.model.Role;
import PP315.model.User;
import PP315.repositories.RoleJpaRep;
import PP315.repositories.UserJpaRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class Initial implements CommandLineRunner {
    private final UserJpaRep userJpaRep;
    private final RoleJpaRep roleJpaRep;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public Initial(UserJpaRep userJpaRep, RoleJpaRep roleJpaRep, PasswordEncoder passwordEncoder) {
        this.userJpaRep = userJpaRep;
        this.roleJpaRep = roleJpaRep;
        this.passwordEncoder = passwordEncoder;
    }

    public void run(String... arg) throws Exception {
        Role roleAdmin = new Role("ROLE_ADMIN");
        Role roleUser = new Role("ROLE_USER");
        Set<Role> adminRoles = new HashSet<>();
        Set<Role> userRoles = new HashSet<>();
        roleJpaRep.save(roleAdmin);
        roleJpaRep.save(roleUser);
        adminRoles.add(roleAdmin);
        adminRoles.add(roleUser);
        userRoles.add(roleUser);


        // пользователи Admin  и User
        User userAdmin = new User(1L,"Kirill", "Yuni", 10,"admin", passwordEncoder.encode("admin"), adminRoles);
        User userUser = new User(2L, "Regina", "Uni", 25, "user", passwordEncoder.encode("user"), userRoles);
        System.out.println(userAdmin);
        userJpaRep.save(userAdmin);
        System.out.println(userUser);
        userJpaRep.save(userUser);
    }
}