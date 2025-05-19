package com.treinoSecurity.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.treinoSecurity.Models.User;
import com.treinoSecurity.Repositories.UserRepository;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    
}
