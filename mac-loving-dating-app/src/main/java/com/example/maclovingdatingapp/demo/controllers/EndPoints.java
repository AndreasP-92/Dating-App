package com.example.maclovingdatingapp.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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

//    ADMIN ========================
//INDEX
    @GetMapping("/admin")
    public String admin(){

        return "/admin/adminIndex";
    }
//    SUPPORT
    @GetMapping("/admin/support")
    public String adminSupport(){

        return "/admin/adminSupport";
    }
//    OPRET BRUGER
    @GetMapping("/admin/opretbruger")
    public String adminOprebruger(){

        return "/admin/adminOpretbruger";
    }
//    SE BRUGERE
    @GetMapping("/admin/sebrugere")
    public String adminSebrugere(){

        return "/admin/adminSebrugere";
    }
//    CHAT

    @GetMapping("/admin/support/chat")
    public String adminChat(){

        return "/admin/adminChat";
    }

    @GetMapping("/login")
    public String login(){

        return "login";
    }

    @GetMapping("/opretprofil")
    public String registrer(){

        return "registrer";
    }

    @GetMapping("/match")
    public String match(){

        return "match";
    }

    @GetMapping("/faq")
    public String faq(){

        return "faq";
    }
    @GetMapping("/privat")
    public String privat(){

        return "privat";
    }
}
