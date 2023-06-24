package PP315.controller;

import PP315.model.User;
import PP315.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/userAuth")
    public ResponseEntity<User> getAuthUser() {
        return ResponseEntity.ok(userService.getCurrentUser());
    }

}
