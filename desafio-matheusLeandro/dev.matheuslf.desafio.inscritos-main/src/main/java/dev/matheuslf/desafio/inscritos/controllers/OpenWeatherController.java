package dev.matheuslf.desafio.inscritos.controllers;

import dev.matheuslf.desafio.inscritos.entities.DTOS.Coord;
import dev.matheuslf.desafio.inscritos.entities.DTOS.OpenWeatherResponseDTO;
import dev.matheuslf.desafio.inscritos.services.OpenWeatherApiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test-api/weather")
public class OpenWeatherController {

    private final OpenWeatherApiService openWeatherApiService;

    public OpenWeatherController(OpenWeatherApiService openWeatherApiService) {
        this.openWeatherApiService = openWeatherApiService;
    }

    @GetMapping("/coord")
    public ResponseEntity<OpenWeatherResponseDTO> getWeatherByCoordinates(@RequestParam Double lat, @RequestParam Double lon){
        Coord coord = new Coord(lat,lon);
        return ResponseEntity.ok().body(openWeatherApiService.getInfosWeatherByCoordinates(coord));
    }

    @GetMapping("/cityName")
    public ResponseEntity<OpenWeatherResponseDTO> getWeatherByCityName(@RequestParam String cityName){
        return ResponseEntity.ok().body(openWeatherApiService.getInfosWeatherByCityName(cityName));
    }
}
