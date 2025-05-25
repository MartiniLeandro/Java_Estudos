package com.treino_security_noJWT.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.treino_security_noJWT.Models.User;
import com.treino_security_noJWT.repositories.UserRepository;

@Service
public class UserService {
    
    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> listAll(){
        return userRepository.findAll();
    }

    public User createUser(User user){
        return userRepository.save(user);
    }
}
