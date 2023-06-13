package PP313.controllers;

import PP313.model.User;
import PP313.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@AllArgsConstructor
@Controller
@RequestMapping("/user")
public class AuthController {

    private final UserService userService;

    @GetMapping
    public String getUser(Model model, Principal principal) {
        User user = userService.findByName(principal.getName());
        model.addAttribute("user", userService.getUser(user.getId()));
        System.out.println("Успешно: user id" + user.getClass());
        model.addAttribute("titleUser", "Страница пользователя: ");
        return "user";
    }
}