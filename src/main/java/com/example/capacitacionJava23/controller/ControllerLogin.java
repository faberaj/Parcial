package com.example.capacitacionJava23.controller;

import com.example.capacitacionJava23.domain.Login;
import com.example.capacitacionJava23.service.ServiceLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/login")
public class ControllerLogin {

    @Autowired
    private ServiceLogin serviceLogin;


    @GetMapping
    public String findAll(Model model) {
        List<Login> lislogin = serviceLogin.findAll();
        model.addAttribute("login", lislogin);
        return "login";
    }

    @GetMapping("/admin")
    public ModelAndView admin() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin");
        return modelAndView;
    }

    @GetMapping("/updateProducto")
    public ModelAndView updateProducto() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("updateProducto");
        return modelAndView;
    }


    @GetMapping("/auth")
    public ModelAndView auth() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("auth");
        return modelAndView;
    }



    @GetMapping("/grupo")
    public ModelAndView grupo() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("grupo");
        return modelAndView;
    }
    @GetMapping("/categorias")
    public ModelAndView categorias() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("categorias");
        return modelAndView;
    }

    @GetMapping("/pagos")
    public ModelAndView pagos() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("pagos");
        return modelAndView;
    }

    @GetMapping("/productos")
    public ModelAndView productos() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("productos");
        return modelAndView;
    }



    @PostMapping
    public ModelAndView postLogin(@ModelAttribute Login login) {
        serviceLogin.save(login);
        return new ModelAndView("redirect:/login/auth");
    }




    @PostMapping("/delete")
    public ModelAndView deleteLogin(@RequestParam("id") Long id) {
        serviceLogin.delete(id);
        return new ModelAndView("redirect:/login");
    }

    @PostMapping("/auth")
    public ModelAndView authenticate(@ModelAttribute Login login, Model model) {
        ModelAndView modelAndView = new ModelAndView();

        boolean authenticated = serviceLogin.authenticateUser(login);

        if (authenticated) {
            modelAndView.setViewName("redirect:/login/admin");
            return modelAndView;
        }

        modelAndView.addObject("error", "Usuario y/o contraseña incorrectos");
        modelAndView.setViewName("auth");
        return modelAndView;
    }

}
