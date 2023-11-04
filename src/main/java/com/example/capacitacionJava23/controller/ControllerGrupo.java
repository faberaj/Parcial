package com.example.capacitacionJava23.controller;


import com.example.capacitacionJava23.domain.grupo;
import com.example.capacitacionJava23.service.ServiceGrupo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/grupo")
public class ControllerGrupo {

    @Autowired
    private ServiceGrupo ServiceGrupo;


    @GetMapping
    public String findAll(Model model) {
        List<grupo> grupo = ServiceGrupo.findAll();
        model.addAttribute("grupo", grupo);
        return "grupo";
    }

    @PostMapping
    public ModelAndView createGrupo(@ModelAttribute grupo grupo) {
        ServiceGrupo.save(grupo);
        return new ModelAndView("redirect:/grupo");
    }



    @PostMapping("/delete")
    public ModelAndView deleteGrupo(@RequestParam("id") Long id) {
        ServiceGrupo.delete(id);
        return new ModelAndView("redirect:/grupo");
    }

}
