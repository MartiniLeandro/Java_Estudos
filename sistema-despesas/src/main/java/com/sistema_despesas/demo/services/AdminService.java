package com.sistema_despesas.demo.services;

import com.sistema_despesas.demo.entities.Categorias;
import com.sistema_despesas.demo.entities.DTOS.UserDTO;
import com.sistema_despesas.demo.entities.User;
import com.sistema_despesas.demo.repositories.CategoriasRepository;
import com.sistema_despesas.demo.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final CategoriasRepository categoriasRepository;

    public AdminService(UserRepository userRepository, PasswordEncoder passwordEncoder, CategoriasRepository categoriasRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.categoriasRepository = categoriasRepository;
    }

    public List<UserDTO> allUsers(){
        return userRepository.findAll().stream().map(UserDTO::new).toList();
    }

    public UserDTO findById(Long id){
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Não existe User com este ID"));
        return new UserDTO(user);
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

    public Categorias createCategoria(Categorias categoria){
        return categoriasRepository.save(categoria);
    }


}
