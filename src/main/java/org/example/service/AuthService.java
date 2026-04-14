package org.example.service;

import org.example.repository.UserRepository;

public class AuthService {
    private final UserRepository repository = new UserRepository();
    public boolean register(String username, String password){
        if(username == null || username.isBlank()){
            System.out.println("Username is empty");
            return false;
        }
        if (password == null || password.isBlank()){
            System.out.println("passwoerd is empty");
            return false;
        }
        return repository.saveUser(username,password,"Admin");
    }



}
