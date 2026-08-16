package crudnew.web.spring_boot.spring_boot_rest.controller;

import crudnew.web.spring_boot.spring_boot_rest.model.User;
import crudnew.web.spring_boot.spring_boot_rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping
    public String listUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users";
    }

    @GetMapping("/new")
    public String newUserForm(Model model) {
       model.addAttribute("user", new User());
        model.addAttribute("action", "save");
        model.addAttribute("title", "New user");
        return "user-form";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/api/users";
    }


    @GetMapping("/edit")
    public String editUserForm(@RequestParam("id") Long id, Model model) {
        model.addAttribute("user", userService.findById(id));
        model.addAttribute("action", "update");
        model.addAttribute("title", "Edit user");
        return "user-form";
    }


    @PostMapping("/update")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.update(user);
        return "redirect:/api/users";
    }


    @PostMapping("/delete")
    public String deleteUser(@RequestParam("id") Long id) {
        userService.deleteById(id);
        return "redirect:/api/users";
    }
}




