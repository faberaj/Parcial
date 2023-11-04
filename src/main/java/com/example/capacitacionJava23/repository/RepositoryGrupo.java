package com.example.capacitacionJava23.repository;

import com.example.capacitacionJava23.domain.grupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryGrupo extends JpaRepository<grupo, Long> {

}
