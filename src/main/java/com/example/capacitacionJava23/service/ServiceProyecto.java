package com.example.capacitacionJava23.service;

import com.example.capacitacionJava23.domain.Proyecto;
import com.example.capacitacionJava23.repository.RepositoryProyecto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceProyecto {

    @Autowired
    private RepositoryProyecto repositoryProyecto;

    public List<Proyecto> findAll(){
        return repositoryProyecto.findAll();
    }

    public Proyecto save(Proyecto proyecto) {
        return repositoryProyecto.save(proyecto);
    }

    public void delete(Long id){
        repositoryProyecto.deleteById(id);
    }
}