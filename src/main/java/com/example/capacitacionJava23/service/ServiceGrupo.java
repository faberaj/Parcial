package com.example.capacitacionJava23.service;


import com.example.capacitacionJava23.domain.grupo;
import com.example.capacitacionJava23.repository.RepositoryGrupo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceGrupo {

    @Autowired
    private RepositoryGrupo RepositoryGrupo;

    public List<grupo> findAll() {
        return RepositoryGrupo.findAll();
    }

    public Optional<grupo> findById(Long id) {
        return RepositoryGrupo.findById(id);
    }

    public grupo save(grupo grupo) {
        return RepositoryGrupo.save(grupo);
    }


    public void delete(Long id) {
        RepositoryGrupo.deleteById(id);
    }


}
