package dev.matheuslf.desafio.inscritos.entities.DTOS;

import java.util.Date;

public record ProjectRequestDTO(Long id, String name, String description, Date startDate, Date endDate) {
}
