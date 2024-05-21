package io.h3llo.matriculas.exception;

import java.time.LocalDateTime;

public record CustomErrorResponse(

        LocalDateTime dateTime,
        String message,
        String path
) {
}
