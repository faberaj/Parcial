package com.example.capacitacionJava23.repository;

import com.example.capacitacionJava23.domain.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryTarea extends JpaRepository<Tarea, Long> {

}
