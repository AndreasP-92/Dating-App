package com.example.dating_app02.controller;

import com.example.dating_app02.model.Authorities;
import com.example.dating_app02.model.Profile;
import com.example.dating_app02.model.User;
import com.example.dating_app02.repository.ProfileDAO;
import com.example.dating_app02.repository.UsersDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EndPoints {
    //DATA ACCESS OBJECTS ====================
    @Autowired
    private UsersDAO daoUser;
    @Autowired
    private ProfileDAO daoProfile;

//    MAIN ====================================

    @GetMapping("/")
    public String home(){

        return "main/index";
    }
    @GetMapping("/kontakt")
    public String Kontakt(){

        return "main/kontakt";
    }

    @GetMapping("/privatliv")
    public String privatliv(){

        return "main/privacy";
    }

    @GetMapping("/faq")
    public String faq(){

        return "main/faq";
    }

    @GetMapping("/profile/{profile_mail}")
    public ModelAndView profile(@PathVariable(name = "profile_mail") String profile_mail){
        ModelAndView mav = new ModelAndView("user/profile");
        Profile profile = daoProfile.get(profile_mail);
        mav.addObject("profile", profile);

        return mav;
    }

//    LOGIN =======================================

    @GetMapping("/403")
    public String error(){

        return "log/403";
    }

    @GetMapping("/login")
    public String loginPage(){

        return "log/login";
    }




//    USER ==============================



    @GetMapping("/opretbruger")
    public String registrer(Model model){

        User user = new User();
        model.addAttribute("user", user);

        return "user/createUser";
    }

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public String save(@ModelAttribute("user") User user){
        Authorities auth = new Authorities(user.getUser_mail(), "ROLE_USER");
        Profile profile = new Profile("Tobias","Cho","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.","/images/image_01.jpg",0,"Gaming, Rejser, Andet",user.getUser_mail());
        daoUser.saveUser(user);
        daoUser.saveAuth(auth);
        daoProfile.save(profile);
        return "redirect:/";
    }

//   PROFIL ===========================



@RequestMapping("/opretprofil")
    public String createProfile(Model model) {
        Profile profile = new Profile();
        model.addAttribute("profile",profile);
        return "main/createProfile";
}
    @RequestMapping(value = "/saveprofile", method = RequestMethod.POST)
    public String saveProfile(@ModelAttribute("profile") Profile profile){
//        System.out.println(user);

        daoProfile.save(profile);


        return "redirect:/";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("user") User user){
        daoUser.update(user);

        return "redirect:/";
    }

//    @GetMapping("/login_success")
//    public String loginSuccess(){
//
//        return "login_success";
//    }
//
//    @GetMapping("/login_error")
//    public String loginError(){
//
//        return "login_error";
//    }
}
