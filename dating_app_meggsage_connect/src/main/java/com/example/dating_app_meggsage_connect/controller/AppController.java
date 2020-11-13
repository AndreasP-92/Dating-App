package com.example.dating_app_meggsage_connect.controller;

import com.example.dating_app_meggsage_connect.model.Msg;
import com.example.dating_app_meggsage_connect.service.MsgDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AppController {

    @Autowired
    private MsgDAO dao;

    @RequestMapping
    public String index(Model model){
        List<Msg> listMsg = dao.list();

        model.addAttribute("listMsg", listMsg);

        return "index";
    }

}
