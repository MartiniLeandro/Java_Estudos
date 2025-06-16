package com.sistema_barbearia.entities.DTOS;

import java.time.LocalTime;

public record BarbeiroDTO(String inicioTrabalho, String finalTrabalho, Long user_id) {
}
