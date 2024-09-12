package com.ecommerce.admin.user;

import com.ecommerce.common.entity.Role;
import com.ecommerce.common.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String listAllUsers(Model model){
        List<User> userList = userService.listAllUsers();
        model.addAttribute("userList", userList);
        return "users";
    }

    @GetMapping("/users/new")
    public String newUser(Model model){
        List<Role> roles = userService.listRoles();
        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("roles", roles);
        return "user_form";
    }

    @PostMapping("/users/save")
    public String saveUser(User user){
        System.out.println(user);
        return "redirect:/users";
    }
}
