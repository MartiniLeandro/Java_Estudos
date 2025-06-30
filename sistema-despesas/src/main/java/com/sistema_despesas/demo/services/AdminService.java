package com.sistema_despesas.demo.services;

import com.sistema_despesas.demo.entities.Categorias;
import com.sistema_despesas.demo.entities.DTOS.UserDTO;
import com.sistema_despesas.demo.entities.User;
import com.sistema_despesas.demo.exceptions.NotFoundException;
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
        User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("Não existe User com este ID"));
        return new UserDTO(user);
    }

    public UserDTO updateUser(Long id, User user){
        User updateUser = userRepository.findById(id).orElseThrow(() -> new NotFoundException("Não existe User com este ID"));
        updateUser.setEmail(user.getEmail());
        updateUser.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(updateUser);
        return new UserDTO(user);
    }

    public void deleteUser(Long id){
        if(userRepository.existsById(id)) {
            userRepository.deleteById(id);
        }else{
            throw new NotFoundException("Não existe User com este ID");
        }
    }

    public List<Categorias> allCategorias(){
        return categoriasRepository.findAll();
    }

    public Categorias createCategoria(Categorias categoria){
        return categoriasRepository.save(categoria);
    }

    public Categorias updateCategoria(Long id, Categorias categoria){
        Categorias updateCategoria = categoriasRepository.findById(id).orElseThrow(() -> new NotFoundException("Não há categoria com este ID"));
        updateCategoria.setNome(categoria.getNome());
        updateCategoria.setTipoCategoria(categoria.getTipoCategoria());
        return categoriasRepository.save(updateCategoria);
    }

    public void deleteCategoria(Long id){
        if(categoriasRepository.existsById(id)){
            categoriasRepository.deleteById(id);
        }else{
            throw new NotFoundException("Não existe Categoria com este ID");
        }
    }


}
