package com.sistema_despesas.demo.services;

import com.sistema_despesas.demo.entities.Launch;
import com.sistema_despesas.demo.entities.User;
import com.sistema_despesas.demo.repositories.LaunchRepository;
import com.sistema_despesas.demo.repositories.UserRepository;
import com.sistema_despesas.demo.security.TokenService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final TokenService tokenService;
    private final UserRepository userRepository;
    private final LaunchRepository launchRepository;

    public UserService(TokenService tokenService, UserRepository userRepository, LaunchRepository launchRepository) {
        this.tokenService = tokenService;
        this.userRepository = userRepository;
        this.launchRepository = launchRepository;
    }

    public List<Launch> getLaunch(String token){
        String email = tokenService.validateToken(token);
        User user = userRepository.findUserByEmail(email);
        return launchRepository.findAllByUserId(user.getId());
    }

    public List<Launch> createLaunch(Launch launch, String token){
        String email = tokenService.validateToken(token);
        User user = userRepository.findUserByEmail(email);
        launch.setUser(user);
        launchRepository.save(launch);
        return launchRepository.findAllByUserId(user.getId());
    }

    public List<Launch> deleteLaunch(String token, Long id){
        String email = tokenService.validateToken(token);
        User user = userRepository.findUserByEmail(email);
        Launch launch = launchRepository.findById(id).orElseThrow(() -> new RuntimeException("Não existe uma lançamento com este ID"));
        if(!launch.getUser().getId().equals(user.getId())){
            throw new RuntimeException("Este lançamento não pertence a você");
        }
        launchRepository.delete(launch);
        return launchRepository.findAllByUserId(user.getId());

    }

    public List<Launch> updateLaunch(Launch launch, String token, Long id){
        String email = tokenService.validateToken(token);
        User user = userRepository.findUserByEmail(email);
        Launch updateLaunch = launchRepository.findById(id).orElseThrow( ()-> new RuntimeException("Não existe uma lançamento com este ID"));
        if(!updateLaunch.getUser().getId().equals(user.getId())){
            throw new RuntimeException("Este lançamento não pertence a você");
        }
        updateLaunch.setDescription(launch.getDescription());
        updateLaunch.setValor(launch.getValor());
        updateLaunch.setCategoria(launch.getCategoria());
        updateLaunch.setDataHora(launch.getDataHora());
        launchRepository.save(updateLaunch);
        return launchRepository.findAllByUserId(user.getId());
    }
}
