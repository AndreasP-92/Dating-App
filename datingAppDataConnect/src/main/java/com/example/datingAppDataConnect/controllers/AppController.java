package com.example.datingAppDataConnect.controllers;

import com.example.datingAppDataConnect.model.User;
import com.example.datingAppDataConnect.services.UsersDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AppController {

    @Autowired
    private UsersDAO dao;

    @RequestMapping("/")
    public String viewHomePage(Model model){
        List<User> listUser= dao.list();
        System.out.println(listUser);
        model.addAttribute("listUser", listUser);

        return "index";
    }

    @RequestMapping("/new")
    public String showNewForm(Model model){
        User user = new User();
        System.out.println(user);
        model.addAttribute("user", user);

        return "new_form";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("user") User user){
        dao.save(user);

        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable(name = "id") int id){
        ModelAndView mav = new ModelAndView("edit_form");
        User user = dao.get(id);
        mav.addObject("user",user);
        System.out.println(mav);
        return mav;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("user") User user){
        dao.update(user);

        return "redirect:/";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") int id){
        dao.delete(id);
        return "redirect:/";
    }
}
