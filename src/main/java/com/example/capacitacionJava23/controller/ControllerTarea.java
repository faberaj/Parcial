
package com.example.capacitacionJava23.controller;

import com.example.capacitacionJava23.domain.Tarea;
import com.example.capacitacionJava23.domain.grupo;
import com.example.capacitacionJava23.service.ServiceGrupo;
import com.example.capacitacionJava23.service.ServiceTarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/tarea")
public class ControllerTarea {

    @Autowired
    private ServiceTarea serviceTarea;

    @Autowired
    private ServiceGrupo serviceGrupo;

    @GetMapping
    public String findAll(Model model) {
        List<Tarea> tareas = serviceTarea.findAll();
        List<grupo> grupos = serviceGrupo.findAll();
        model.addAttribute("tareas", tareas);
        model.addAttribute("grupos", grupos);
        return "tarea";
    }

    @PostMapping
    public ModelAndView createTarea(@ModelAttribute Tarea tarea, @RequestParam("idGrupo") Long idGrupo) {
        grupo grupo = serviceGrupo.findById(idGrupo).orElseThrow(() -> new RuntimeException("Grupo no encontrado"));
        tarea.setGrupo(grupo);
        serviceTarea.save(tarea);
        return new ModelAndView("redirect:/tarea");
    }

    @PostMapping("/delete")
    public ModelAndView deleteTarea(@RequestParam("id") Long id) {
        serviceTarea.delete(id);
        return new ModelAndView("redirect:/tarea");
    }

    @GetMapping("/edit/{id}")
    public String editTarea(@PathVariable Long id, Model model) {
        try {
            Tarea tarea = serviceTarea.findById(id)
                    .orElseThrow(() -> new RuntimeException("Tarea no encontrada"));
            List<grupo> grupos = serviceGrupo.findAll();
            model.addAttribute("tarea", tarea);
            model.addAttribute("grupos", grupos);
            return "tarea-editar";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/tarea";
        }
    }
    @PostMapping("/edit/{id}")
    public ModelAndView editTarea(@PathVariable Long id, @ModelAttribute Tarea tarea, @RequestParam("idGrupo") Long idGrupo) {
        try {

            Tarea tareaExistente = serviceTarea.findById(id)
                    .orElseThrow(() -> new RuntimeException("Tarea no encontrada"));

            if (tareaExistente.getGrupo() == null) {
                throw new RuntimeException("La tarea debe tener un grupo asignado");
            }
            tareaExistente.setNombreTarea(tarea.getNombreTarea());
            tareaExistente.setFechaCreacion(tarea.getFechaCreacion());
            tareaExistente.setFechaVencimiento(tarea.getFechaVencimiento());
            grupo grupo = serviceGrupo.findById(idGrupo).orElseThrow(() -> new RuntimeException("Grupo no encontrado"));

            tareaExistente.setGrupo(grupo);
            serviceTarea.save(tareaExistente);
            return new ModelAndView("redirect:/tarea");
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelAndView("redirect:/tarea");
        }
    }



}
