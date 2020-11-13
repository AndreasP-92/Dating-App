package com.example.dating_app02.controller;

import com.example.dating_app02.model.Profile;
import com.example.dating_app02.model.User;
import com.example.dating_app02.service.UsersDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EndPoints {
    @GetMapping("/")
    public String home(){

        return "main/index";
    }

//    LOGIN =======================================
    @GetMapping("/user")
    public String user(){

        return "user/user";
    }

    @GetMapping("/admin")
    @ResponseBody
    public String admin(){

        return "admin/admin";
    }

    @GetMapping("/403")
    public String error(){

        return "log/403";
    }

    @GetMapping("/login")
    public String loginPage(){

        return "log/login";
    }

    @GetMapping("/profile")
    public String profile(){

        return "user/profile02";
    }
//    USER ==============================

    @Autowired
    private UsersDAO dao;

    @GetMapping("/opretbruger")
    public String registrer(Model model){

        User user = new User();
        model.addAttribute("user", user);

        return "user/createUser";
    }

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public String save(@ModelAttribute("user") User user){
//        System.out.println(user);
        dao.save(user);

        return "redirect:/";
    }

//   PROFIL ===========================

@RequestMapping("/opretprofil")
    public String createProfil(Model model) {
        Profile profile = new Profile();
        model.addAttribute("profile",profile);
        return "main/createProfil";
}
//    @GetMapping("/login_success")
//    public String loginSuccess(){
//
//        return "login_success";
//    }
//
//    @GetMapping("/login_error")
//    public String loginError(){
//
//        return "login_error";
//    }
}
