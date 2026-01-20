package com.demo.exceptions;

import java.time.LocalDateTime;

public record ErrorResponse(String message, Integer status, LocalDateTime timestamp) {
}
