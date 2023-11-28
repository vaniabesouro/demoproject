package com.ips.tpsi.demo.controller;

import com.ips.tpsi.demo.bc.WebBc;
import com.ips.tpsi.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {

    @Autowired
    WebBc bc;

    //  public WebController(WebBc bc) {
    //      this.bc = bc;
    //  }

    @GetMapping("/home") // @GetMapping("/")
    public ModelAndView getHome() {
        ModelAndView mv = new ModelAndView("index");
        // aceder à business component > acede ao repositorio > obtem dados

        return mv;
    }

    @GetMapping("/name") // @GetMapping("/")
    public ModelAndView getName() {
        ModelAndView mv = new ModelAndView("index");
        // aceder à business component > acede ao repositorio > obtem dados
        mv.addObject("name", "Vania");
        return mv;
    }

    @PostMapping("/login")
    public ModelAndView login(String name, String password) {

        boolean isLoginValid = true; //bc.login(name, password);

        if (isLoginValid) {
            ModelAndView mv = new ModelAndView("index");
            // aceder à business component > acede ao repositorio > obtem dados
            mv.addObject("name", "Vania");
            return mv;
        }
        return null;
    }


    @GetMapping("/username")
    public ModelAndView getUserByUsername(String username) {
        User user = bc.getRepositoryUserInfoByUsername(username);
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("user", user);
        return mv;
    }

}
