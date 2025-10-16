package dev.matheuslf.desafio.inscritos.exceptions;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
    private Integer status;
    private String message;
    private String path;
    private Instant timeStamp;
}
