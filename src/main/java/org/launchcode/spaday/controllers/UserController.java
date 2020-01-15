package org.launchcode.spaday.controllers;


import org.launchcode.spaday.data.UserData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.launchcode.spaday.models.User;

import java.util.ArrayList;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping
    public String displayAddUserForm() {
        return "user/add";

    }

    //lives@ events/create
    @GetMapping("add")
    public String displayAddUserForm2(){
        return "user/add";
    }

    @PostMapping("add")
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {
        // add form submission handling code here
        if (user.getPassword().equals(verify)) {
            UserData.add(user);
            model.addAttribute("title", "All Users");
            model.addAttribute("users", UserData.getAll());
            return "user/index";
        } else {
            model.addAttribute("username", user.getUsername());
            model.addAttribute("email", user.getEmail());
            model.addAttribute("password", user.getPassword());
            model.addAttribute("verify", verify);
            return "user/add";
        }
    }

    @GetMapping("delete")
    public String renderDeleteUserForm(Model model) {
        model.addAttribute("title", "Delete Users");
        model.addAttribute("users", UserData.getAll());
        return "user/delete";
    }

    @GetMapping("delete/{userId}")
    public String deleteEvent(Model model, @PathVariable int userId) {
        UserData.remove(userId);
        model.addAttribute("users", UserData.getAll());
        return "user/add";
    }

    @PostMapping("delete")
    public String deleteUser(@RequestParam(required = false) int[] userIds) {

        if (userIds != null) {
            for (int id : userIds) {
                UserData.remove(id);
            }
        }
        return "redirect:";
    }

    @GetMapping("details/{Id}")
    public String displayDetails(Model model, @PathVariable int Id) {
        model.addAttribute("user", UserData.getById(Id));
        return "user/details";
    }

}
