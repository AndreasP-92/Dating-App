package com.example.dating_app02.controller;

import com.example.dating_app02.model.Authorities;
import com.example.dating_app02.model.Message;
import com.example.dating_app02.model.User;
import com.example.dating_app02.repository.MessageDAO;
import com.example.dating_app02.repository.ProfileDAO;
import com.example.dating_app02.repository.UsersDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class adminController {
    //DATA ACCESS OBJECTS ====================
    @Autowired
    private UsersDAO daoUser;
    @Autowired
    private ProfileDAO daoProfile;
    @Autowired
    private MessageDAO daoMessage;

//  INDEX
    @GetMapping("/admin")
    public String admin(Model model){


        return "/admin/adminIndex";
    }

//    CREATE USER
    @GetMapping("/admin/opretbruger")
    public String adminOprebruger(Model model){
        User user = new User();
        System.out.println(user);
        model.addAttribute("user", user);

        return "admin/adminCreateUser";
    }

//    USER LOOKUP
    @GetMapping("/admin/sebrugere")
    public String adminSebrugere(Model model){
        List<User> listUser= daoUser.list();
        model.addAttribute("listUser", listUser);

        return "/admin/adminUserLookups";
    }

//    EDIT USER
    @GetMapping("/admin/sebrugere/{profile_mail}")
    public ModelAndView editUser(@PathVariable(name = "profile_mail") String profile_mail){
        ModelAndView mav = new ModelAndView("admin/adminUserEdit");
        User user = daoUser.getUser(profile_mail);
        mav.addObject("user", user);

        return mav;
    }

//    SUPPORT
    @GetMapping("/admin/support")
    public String adminSupport(Model model){
        List<Message> listMessage = daoMessage.list();
        model.addAttribute("listMessage", listMessage);
        return "/admin/adminSupport";
    }

//    CHAT
    @GetMapping("/admin/support/chat/{message_mail}")
    public ModelAndView adminChat(@PathVariable(name = "message_mail") String message_mail){
        ModelAndView mav = new ModelAndView("/admin/adminChat");
        List<Message> conversation = daoMessage.getConversation();
        Message message = daoMessage.getMessage(message_mail);


        System.out.println(conversation);

        mav.addObject("conversation", conversation);
        mav.addObject("message", message);

        return mav;
    }


//    POST METHODS ==============================

//  CREATE USER
    @RequestMapping(value = "/admin/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("user") User user){
        Authorities auth = new Authorities(user.getUser_mail(), "ROLE_USER");
        daoUser.saveUser(user);
        daoUser.saveAuth(auth);

        return "redirect:/admin";
    }

//  UPDATE USER
    @RequestMapping(value = "/admin/updateUser", method = RequestMethod.POST)
    public String update(@ModelAttribute("user") User user){
        daoUser.update(user);

        return "redirect:/admin/sebrugere/";
    }

//  DELETE USER
    @RequestMapping("/admin/delete/{user_mail}")
    public String delete(@PathVariable(name = "user_mail") String user_mail){
        daoUser.delete(user_mail);

        return "redirect:/admin/sebrugere";
    }

//  POST CHAT
    @RequestMapping(value = "/admin/save/chat", method = RequestMethod.POST)
    public String save(@ModelAttribute("message") Message message){
        System.out.println(message);
        daoMessage.saveChat(message);


        return "redirect:/admin";
    }




}
