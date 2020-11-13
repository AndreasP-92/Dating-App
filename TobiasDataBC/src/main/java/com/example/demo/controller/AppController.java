package com.example.demo.controller;



import com.example.demo.model.Msg;
import com.example.demo.service.MessageDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
public class AppController {

    @Autowired
    private MessageDAO dao;

    @RequestMapping("/")
    public String viewHomePage(Model model){

        String test = "test";

//        List<Msg> listMsg = dao.list();
        model.addAttribute("listMsg","test");

        return "index";
    }



}
