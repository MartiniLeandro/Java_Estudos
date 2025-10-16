package dev.matheuslf.desafio.inscritos.entities.DTOS;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;

import java.util.Date;

public record ProjectRequestDTO(@Null Long id, @NotBlank String name, String description, Date startDate, Date endDate) {
}
