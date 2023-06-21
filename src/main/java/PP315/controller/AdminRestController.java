package PP315.controller;

import PP315.model.User;
import PP315.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/admins")
public class AdminRestController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") Long id) {
        return new ResponseEntity<> (userService.getUserById(id), HttpStatus.OK);
    }

    @GetMapping("/userAuth")
    public ResponseEntity<User> getAuthUser() {
        return new ResponseEntity<> (userService.getCurrentUser(), HttpStatus.OK);
    }

    @PostMapping("/newAddUser")
    public ResponseEntity<HttpStatus> addNewUser(@RequestBody User user) {
        userService.addUser(user);
        return new ResponseEntity<> (HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<> (HttpStatus.OK);
    }

    @PatchMapping("/users/{id}")
    public ResponseEntity<HttpStatus> userAddEdit(@RequestBody  User user, @PathVariable Long id) {
        user.setId(id);
        userService.updateUser(user, id);
        return new ResponseEntity<> (HttpStatus.OK);
    }
}
