package com.example.capacitacionJava23.controller;

import com.example.capacitacionJava23.domain.Proyecto;
import com.example.capacitacionJava23.service.ServiceProyecto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/proyecto")
public class ControllerProyecto {

    @Autowired
    private ServiceProyecto serviceProyecto;

    @GetMapping
    public String findAll(Model model){
        List<Proyecto> lisProyects = serviceProyecto.findAll();
        model.addAttribute("proyectos", lisProyects);
        return "proyectos";
    }

    @PostMapping
    public ModelAndView postProyect(@ModelAttribute Proyecto proyecto){
        serviceProyecto.save(proyecto);
        return new ModelAndView("redirect:/proyecto");
    }

    @PostMapping("/delete")
    public ModelAndView deleteProyect(@RequestParam("id") Long id){
        serviceProyecto.delete(id);
        return new ModelAndView("redirect:/proyecto");
    }
}
