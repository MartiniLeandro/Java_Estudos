package com.sistema_despesas.demo.services;

import com.sistema_despesas.demo.entities.DTOS.LaunchDTO;
import com.sistema_despesas.demo.entities.Launch;
import com.sistema_despesas.demo.repositories.LaunchRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaunchService {

    private final LaunchRepository launchRepository;

    public LaunchService(LaunchRepository launchRepository) {
        this.launchRepository = launchRepository;
    }

    public List<Launch> allLaunch(){
        return launchRepository.findAll();
    }

    public Launch findById(Long id){
        return launchRepository.findById(id).orElseThrow(() -> new RuntimeException("Não existe User com este ID"));
    }

    public LaunchDTO createLaunch(Launch launch){
        launchRepository.save(launch);
        return new LaunchDTO(launch);
    }

    public LaunchDTO updateLaunch(Long id, Launch launch){
        Launch updatedLaunch = launchRepository.findById(id).orElseThrow(() -> new RuntimeException("Não existe User com este ID"));
        updatedLaunch.setCategoria(launch.getCategoria());
        updatedLaunch.setValor(launch.getValor());
        updatedLaunch.setDescription(launch.getDescription());
        launchRepository.save(updatedLaunch);
        return new LaunchDTO(updatedLaunch);
    }

    public void deleteLaunch(Long id){
        launchRepository.deleteById(id);
    }
}
