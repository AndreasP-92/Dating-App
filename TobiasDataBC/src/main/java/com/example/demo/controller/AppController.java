package com.example.demo.controller;

import com.example.demo.model.Message;
import com.example.demo.service.MessageDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
public class AppController {

    @Autowired
    private MessageDAO dao;

    @RequestMapping("/")
    public String viewHomePage(Model model){
        List<Message> listMessage = dao.list();
        model.addAttribute("listMessage", listMessage);
        System.out.println(listMessage);
        return "index";
    }

}
