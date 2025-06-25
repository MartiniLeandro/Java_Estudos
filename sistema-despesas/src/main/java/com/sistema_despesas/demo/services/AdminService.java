package com.sistema_despesas.demo.services;

import com.sistema_despesas.demo.entities.DTOS.UserDTO;
import com.sistema_despesas.demo.entities.User;
import com.sistema_despesas.demo.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AdminService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> allUsers(){
        return userRepository.findAll();
    }

    public User findById(Long id){
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("Não existe User com este ID"));
    }

    public UserDTO updateUser(Long id, User user){
        User updateUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Não existe User com este ID"));
        updateUser.setEmail(user.getEmail());
        updateUser.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(updateUser);
        return new UserDTO(user);
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
}
