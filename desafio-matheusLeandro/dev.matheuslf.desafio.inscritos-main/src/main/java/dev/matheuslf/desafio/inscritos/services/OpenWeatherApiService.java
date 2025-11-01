package dev.matheuslf.desafio.inscritos.services;

import dev.matheuslf.desafio.inscritos.entities.DTOS.Coord;
import dev.matheuslf.desafio.inscritos.entities.DTOS.OpenWeatherResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class OpenWeatherApiService {

    @Value("${api.key}")
    private String apiKey;

    private final WebClient webClient;


    public OpenWeatherApiService() {
        this.webClient = WebClient.builder()
                .baseUrl("https://api.openweathermap.org/data/2.5")
                .build();
    }

    public OpenWeatherResponseDTO getInfosWeatherByCoordinates(Coord coord){
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/weather").queryParam("lat",coord.lat()).queryParam("lon",coord.lon()).queryParam("appid",apiKey).build())
                .retrieve()
                .bodyToMono(OpenWeatherResponseDTO.class)
                .block();
    }

    public OpenWeatherResponseDTO getInfosWeatherByCityName(String city){
        return webClient.get()
                .uri("/weather?q={cityName}&appid={apiKey}",city,this.apiKey)
                .retrieve()
                .bodyToMono(OpenWeatherResponseDTO.class)
                .block();
    }
}
