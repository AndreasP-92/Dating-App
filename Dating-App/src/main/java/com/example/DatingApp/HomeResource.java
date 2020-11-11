package com.example.DatingApp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeResource {

    @GetMapping("/")
    @ResponseBody
    public String home(){

        return ("<h1>Welcome</h1>");
    }

    @GetMapping("/user")
    public String user(){

        return "user";
    }

    @GetMapping("/admin")
    @ResponseBody
    public String admin(){

        return "admin";
    }

    @GetMapping("/403")
    public String error(){

        return "403";
    }

    @GetMapping("/login")
    public String loginPage(){

        return "login";
    }

    @GetMapping("/login_success")
    public String loginSuccess(){

        return "login_success";
    }

    @GetMapping("/login_error")
    public String loginError(){

        return "login_error";
    }

//  =========  SUCCESS MAPPING VIA POST METHOD ===================

//    @PostMapping("/login_success_handler")
//    public String loginSuccessHandler(){
//
//        System.out.println("Login Success...");
//
//        return "redirect:/login_success";
//    }
//
//    @PostMapping("/login_failure_handler")
//    public String loginFailureHandler(){
//
//        System.out.println("Login failed...");
//
//        return "redirect:/login_error";
//    }

//    @PostMapping("/doLogin")
//    public String doLogin(){
//
//        System.out.println("Login failed...");
//
//        return "user";
//    }


}
