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

    public WebController(WebBc bc) {
        this.bc = bc;
    }

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
    public ModelAndView login(String uname, String psw) {

        // aceder à business component para validar o login
        boolean isLoginValid = bc.isLoginValid(uname, psw);

        // uma vez que o login é válido procedemos ao login
        ModelAndView mv = new ModelAndView("index");
        if (isLoginValid) {
            // aceder à business component > acede ao repositorio > obtem dados
            mv.addObject("loginValid", "O Login é válido.");
        } else {
            mv.addObject("loginValid", "O Login é inválido.");
        }
        return mv;
    }


    @GetMapping("/username")
    public ModelAndView getUserByUsername(String username) {
        User user = bc.getRepositoryUserInfoByUsername(username);
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("user", user);
        return mv;
    }

}
