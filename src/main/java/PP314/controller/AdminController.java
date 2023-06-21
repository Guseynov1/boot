package PP314.controller;

import PP314.model.User;
import PP314.service.RoleService;
import PP314.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@AllArgsConstructor
@Controller
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;


    @GetMapping("/admin")
    public String findAll(Model model, Principal principal) {
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("admin", userService.findByUsername(principal.getName()));
        model.addAttribute("newUser", new User());
        model.addAttribute("allRoles", roleService.getAllRoles());
        return "admin";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/admin";
    }

    @PostMapping(value = "/admin")
    public String updateUser(@ModelAttribute("user") User user, @RequestParam("id") Long id) {
        try {
            userService.updateUser(user);
        } catch (Exception e) {
            System.err.println("the user already exists");
        }
        return "redirect:/admin";
    }

    @RequestMapping(value = "/admin/delete", method = RequestMethod.DELETE)
    public String deleteUser(@RequestParam("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }
}
