package PP314.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping("/")
    public String redirect() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "authorization";
    }
}
