package PP315.controller;

import PP315.model.User;
import PP315.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/")
public class UserRestController {

    private final UserService userService;

    @GetMapping("/user")
    public ResponseEntity<User> getAuthUser() {
        return new ResponseEntity<> (userService.getCurrentUser(), HttpStatus.OK);
    }
}
