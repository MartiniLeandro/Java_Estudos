package com.relembrando_springboot.demo.services;

import com.relembrando_springboot.demo.entities.User;
import com.relembrando_springboot.demo.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> allUsers(){
        return userRepository.findAll();
    }

    public User userById(Long id){
        return userRepository.findById(id).orElseThrow();
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public User updateUser(User user,Long id){
        User updatedUser = userRepository.findById(id).orElseThrow();
        updatedUser.setName(user.getName());
        updatedUser.setEmail(user.getEmail());
        updatedUser.setCpf(user.getCpf());
        updatedUser.setPassword(user.getPassword());
        return userRepository.save(updatedUser);
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
}
