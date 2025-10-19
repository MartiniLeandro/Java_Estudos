package dev.matheuslf.desafio.inscritos.entities.DTOS;


import dev.matheuslf.desafio.inscritos.entities.enums.Status;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO usado para request de um Status no filtro de tasks")
public record FiltersDTO(@Schema(description = "Status da task", requiredMode = Schema.RequiredMode.REQUIRED) Status status) {
}
