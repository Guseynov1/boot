package PP313.model;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@RequiredArgsConstructor
@Getter @Setter
@NoArgsConstructor(force = true)
@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @NonNull
    @Column(name = "role")
    private String role;

    @Override
    public String toString() {
        return role;
    }

    @Override
    public String getAuthority() {
        return getRole();
    }
}
