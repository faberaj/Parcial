// ServiceTarea.java
package com.example.capacitacionJava23.service;

import com.example.capacitacionJava23.domain.Tarea;
import com.example.capacitacionJava23.repository.RepositoryTarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceTarea {

    @Autowired
    private RepositoryTarea repositoryTarea;

    public List<Tarea> findAll() {
        return repositoryTarea.findAll();
    }

    public Optional<Tarea> findById(Long id) {
        return repositoryTarea.findById(id);
    }

    public Tarea save(Tarea tarea) {
        return repositoryTarea.save(tarea);
    }

    public void delete(Long id) {
        repositoryTarea.deleteById(id);
    }
}
