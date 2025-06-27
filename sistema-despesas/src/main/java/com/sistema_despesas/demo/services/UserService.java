package com.sistema_despesas.demo.services;

import com.sistema_despesas.demo.entities.DTOS.LaunchDTO;
import com.sistema_despesas.demo.entities.Launch;
import com.sistema_despesas.demo.entities.User;
import com.sistema_despesas.demo.repositories.CategoriasRepository;
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
    private final CategoriasRepository categoriasRepository;

    public UserService(TokenService tokenService, UserRepository userRepository, LaunchRepository launchRepository, CategoriasRepository categoriasRepository) {
        this.tokenService = tokenService;
        this.userRepository = userRepository;
        this.launchRepository = launchRepository;
        this.categoriasRepository = categoriasRepository;
    }

    public List<LaunchDTO> getLaunch(String token){
        String email = tokenService.validateToken(token);
        User user = userRepository.findUserByEmail(email);
        return launchRepository.findAllByUserId(user.getId()).stream().map(LaunchDTO::new).toList();
    }

    public List<LaunchDTO> createLaunch(LaunchDTO launch, String token){
        String email = tokenService.validateToken(token);
        User user = userRepository.findUserByEmail(email);

        Launch newLaunch = new Launch();
        newLaunch.setUser(user);
        newLaunch.setCategoria(categoriasRepository.findByNome(launch.getCategoria()));
        newLaunch.setValor(launch.getValor());
        newLaunch.setDescription(launch.getDescription());
        newLaunch.setDataHora(launch.getLocalDateTime());

        launchRepository.save(newLaunch);
        return launchRepository.findAllByUserId(user.getId()).stream().map(LaunchDTO::new).toList();
    }

    public List<LaunchDTO> deleteLaunch(String token, Long id){
        String email = tokenService.validateToken(token);
        User user = userRepository.findUserByEmail(email);
        Launch launch = launchRepository.findById(id).orElseThrow(() -> new RuntimeException("Não existe uma lançamento com este ID"));
        if(!launch.getUser().getId().equals(user.getId())){
            throw new RuntimeException("Este lançamento não pertence a você");
        }
        launchRepository.delete(launch);
        return launchRepository.findAllByUserId(user.getId()).stream().map(LaunchDTO::new).toList();

    }

    public List<LaunchDTO> updateLaunch(LaunchDTO launch, String token, Long id){
        String email = tokenService.validateToken(token);
        User user = userRepository.findUserByEmail(email);
        Launch updateLaunch = launchRepository.findById(id).orElseThrow( ()-> new RuntimeException("Não existe uma lançamento com este ID"));
        if(!updateLaunch.getUser().getId().equals(user.getId())){
            throw new RuntimeException("Este lançamento não pertence a você");
        }
        updateLaunch.setDescription(launch.getDescription());
        updateLaunch.setValor(launch.getValor());
        updateLaunch.setCategoria(categoriasRepository.findByNome(launch.getCategoria()));
        updateLaunch.setDataHora(launch.getLocalDateTime());
        launchRepository.save(updateLaunch);
        return launchRepository.findAllByUserId(user.getId()).stream().map(LaunchDTO::new).toList();
    }
}
