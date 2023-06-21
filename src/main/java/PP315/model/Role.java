package PP315.model;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@RequiredArgsConstructor
@NoArgsConstructor(force = true)
@Getter @Setter
@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @NonNull
    @Column(name = "rolename")
    private String rolename;

    @Override
    public String getAuthority() {
        return rolename;
    }
    @Override
    public String toString() {
        return rolename;
    }
}