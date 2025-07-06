package com.projectWithTest.demo.services;

import com.projectWithTest.demo.entities.User;
import com.projectWithTest.demo.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(Long id){
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("Não existe user com este ID"));
    }

    public User create(User user){
        if (userRepository.existsByEmail(user.getEmail())){
            throw new RuntimeException("Já existe um User com este email");
        }
        return userRepository.save(user);
    }

    public User update(User user, Long id){
        User updateUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Não existe user com este ID"));
        updateUser.setFirstName(user.getFirstName());
        updateUser.setLastName(user.getLastName());
        updateUser.setAddress(user.getAddress());
        updateUser.setGender(user.getGender());
        updateUser.setEmail(user.getEmail());

        return userRepository.save(updateUser);
    }

    public void delete(Long id){
        userRepository.deleteById(id);
    }

}
