package com.relembrando_springboot.demo.exceptions;

import java.time.Instant;

public record ErrorResponse(Integer status, String error, String message, String path, Instant timeStamp) {
}
