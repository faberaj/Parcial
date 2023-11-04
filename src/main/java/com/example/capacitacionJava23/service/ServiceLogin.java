package com.example.capacitacionJava23.service;

import com.example.capacitacionJava23.domain.Login;
import com.example.capacitacionJava23.repository.RepositoryLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceLogin {

    @Autowired
    private RepositoryLogin repositoryLogin;

    public List<Login> findAll() {
        return repositoryLogin.findAll();
    }

    public Login save(Login login) {
        return repositoryLogin.save(login);
    }

    public void delete(Long id) {
        repositoryLogin.deleteById(id);
    }

    public Login findByEmail(String email) {
        return repositoryLogin.findByEmail(email);
    }

    public boolean authenticateUser(Login login) {
        Login storedLogin = findByEmail(login.getEmail());


        return storedLogin != null && storedLogin.getPassword().equals(login.getPassword());
    }
}
