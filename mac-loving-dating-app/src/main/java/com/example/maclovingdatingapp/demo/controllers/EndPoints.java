package com.example.maclovingdatingapp.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EndPoints {

    @GetMapping("/")
    public String frontPage(){

        return "index";
    }
}
