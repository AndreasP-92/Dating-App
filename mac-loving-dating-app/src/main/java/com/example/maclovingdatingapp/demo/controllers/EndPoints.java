package com.example.maclovingdatingapp.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EndPoints {

    @GetMapping("/")
    public String index(){

        return "index";
    }

    @GetMapping("/kontakt")
    public String Kontakt(){

        return "kontakt";
    }

    @GetMapping("/admin")
    public String admin(){

        return "admin";
    }

    @GetMapping("/login")
    public String login(){

        return "login";
    }

    @GetMapping("/register")
    public String register(){

        return "register";
    }

    @GetMapping("/match")
    public String match(){

        return "match";
    }
}
