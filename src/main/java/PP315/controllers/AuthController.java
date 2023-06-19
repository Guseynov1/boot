package PP315.controllers;

import PP315.model.User;
import PP315.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class AuthController {
    private final UserService userService;
    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/api/currentUser")
    public ResponseEntity<User> showUser(Principal principal) {
        User user = userService.findByName(principal.getName());
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}