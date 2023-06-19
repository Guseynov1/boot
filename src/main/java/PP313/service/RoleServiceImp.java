package PP313.service;

import PP313.model.Role;
import PP313.repo.RoleRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoleServiceImp implements RoleService {

    private final RoleRepo roleRepo;
    @Override
    public List<Role> getRoles() {
        return roleRepo.findAll();
    }
}
