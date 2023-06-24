package PP315.controller;

import PP315.model.User;
import PP315.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserRestController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<User> getAuthUser() {
        return ResponseEntity.ok(userService.getCurrentUser());
    }
}
