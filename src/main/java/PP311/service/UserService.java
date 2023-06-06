package PP311.service;

import PP311.model.User;
import PP311.repo.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {

    private final Repository repository;

    @Autowired
    public UserService(Repository repository) {
        this.repository = repository;
    }

    public User findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public User saveUser(User user) {
        return repository.save(user);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }


}
