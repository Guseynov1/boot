package PP315.service;

import PP315.model.User;
import PP315.repositories.UserJpaRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserDetailsService, UserService {
    private final UserJpaRep userJpaRep;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImp(UserJpaRep userJpaRep, @Lazy PasswordEncoder passwordEncoder) {
        this.userJpaRep = userJpaRep;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userJpaRep.findByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new org.springframework.security.core.userdetails
                .User(user.getUsername(), user.getPassword(), user.getAuthorities());
    }

    @Override
    public List<User> findAll() {
        return userJpaRep.findAll();
    }

    @Override
    public User findOne(Long id) {
        return userJpaRep.findById(id).orElseThrow();
    }

    @Override
    public User findByName(String username) {
        return userJpaRep.findByUserName(username);
    }

    @Override
    public User getUser(Long id) {
        return userJpaRep.findById(id).get();
    }

    @Override
    @Transactional
    public void save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userJpaRep.save(user);
    }

    @Override
    @Transactional
    public void update(User user) {
        User oldUser = userJpaRep.findById(user.getId()).get();
        String oldPassword = oldUser.getPassword();
        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            user.setPassword(oldPassword);
        } else {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        userJpaRep.save(user);
    }

    @Override
    public void delete(Long id) {
        userJpaRep.delete(userJpaRep.findById(id).get());
    }
}
