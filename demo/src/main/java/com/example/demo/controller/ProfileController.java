package com.example.demo.controller;

import com.example.demo.model.Profile;
import com.example.demo.service.ProfileDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProfileController {

    @Autowired
    private ProfileDAO dao;

    @RequestMapping("/")
    public String index(Model model){
        List<Profile> listProfile = dao.list();
        model.addAttribute("listProfile", listProfile);
        return "index";
    }

    @RequestMapping("/new")
    public String showNewForm(Model model) {
        Profile profile = new Profile();
        model.addAttribute("profile",profile);
        return "new_form";
    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("profile") Profile profile) {
        dao.save(profile);

        return "redirect:/";
    }
    @RequestMapping("/edit/{id}")
    public ModelAndView showEditFrom(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_form");
        Profile profile = dao.get(id);
        mav.addObject("profile", profile);

        return mav;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("profile") Profile profile) {
        dao.update(profile);

        return "redirect:/";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") int id) {
        dao.delete(id);

        return "redirect:/";
    }

}
