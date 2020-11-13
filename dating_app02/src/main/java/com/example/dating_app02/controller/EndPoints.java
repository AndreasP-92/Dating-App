package com.example.dating_app02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
