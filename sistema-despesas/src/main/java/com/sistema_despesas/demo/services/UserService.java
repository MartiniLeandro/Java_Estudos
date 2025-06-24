package com.sistema_despesas.demo.services;

import com.sistema_despesas.demo.entities.DTOS.UserDTO;
import com.sistema_despesas.demo.entities.User;
import com.sistema_despesas.demo.repositories.UserRepository;
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

    public User findById(Long id){
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("Não existe User com este ID"));
    }

    public UserDTO CreateUser(User user){
        userRepository.save(user);
        return new UserDTO(user);
    }

    public UserDTO updateUser(Long id, User user){
        User updateUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Não existe User com este ID"));
        updateUser.setEmail(user.getEmail());
        updateUser.setPassword(user.getPassword());
        userRepository.save(updateUser);
        return new UserDTO(user);
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
}
