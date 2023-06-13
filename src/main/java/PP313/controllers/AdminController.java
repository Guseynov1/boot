package PP313.controllers;

import PP313.model.Role;
import PP313.model.User;
import PP313.service.RoleServiceImp;
import PP313.service.UserServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserServiceImp userServiceImp;
    private final RoleServiceImp roleServiceImp;

    @GetMapping
    public String getAllUsers(Model model) {
        model.addAttribute("users", userServiceImp.findAll());
        model.addAttribute("titleAdmin", "Список всех пользователей:");
        return "admin";
    }

    @GetMapping("/")
    public String getUser(@RequestParam("id") Long id, Model model) {
        model.addAttribute("user", userServiceImp.findOne(id));
        model.addAttribute("titleUser", "Страница пользователя:");
        return "user";
    }

    @GetMapping("/addUser")
    public String addUser(Model model, @ModelAttribute("user") User user) {
        List<Role> roles = roleServiceImp.getRoles();
        model.addAttribute("rolesAdd", roles);
        return "creation";
    }

    @PostMapping
    public String createUser(@ModelAttribute("user") User user) {
        try {
            userServiceImp.save(user);
        } catch (Exception er) {
            System.err.println("the user already exists");
        }
        return "redirect:/admin";
    }

    @GetMapping("/editUser")
    public String editUser(Model model, @RequestParam("id") Long id) {
        model.addAttribute("user", userServiceImp.findOne(id));
        model.addAttribute("rolesAdd", roleServiceImp.getRoles());
        return "update";
    }

    @PostMapping("/")
    public String updateUser(@ModelAttribute("user") User user) {
        try {
            userServiceImp.update(user);
        } catch (Exception e) {
            System.err.println("the user already exists");
        }
        return "redirect:/admin";
    }

    @DeleteMapping("/delete")
    public String deleteUser(@RequestParam("id") Long id) {
        userServiceImp.delete(id);
        return "redirect:/admin";
    }
}
