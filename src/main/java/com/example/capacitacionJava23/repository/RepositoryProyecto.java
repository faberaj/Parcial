package com.example.capacitacionJava23.repository;

import com.example.capacitacionJava23.domain.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryProyecto extends JpaRepository<Proyecto, Long> {}