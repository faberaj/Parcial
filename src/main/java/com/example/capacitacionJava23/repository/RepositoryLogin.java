package com.example.capacitacionJava23.repository;

import com.example.capacitacionJava23.domain.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryLogin extends JpaRepository<Login, Long> {
    Login findByEmail(String email);
}
