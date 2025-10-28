package dev.matheuslf.desafio.inscritos.entities.DTOS;

import java.util.List;

public record OpenWeatherResponseDTO(Coord coord, List<Weather> weather, Integer visibility, String name, Double id) {
}
