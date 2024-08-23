package fr.afrogeek.geekhrconnect.exception;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.UUID;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGeekHRConnectException(Exception e) {
        Map<String, Object> body = new LinkedHashMap<>();
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        body.put("id", UUID.randomUUID().toString());
        body.put("message", e.getMessage());
        body.put("timestamp", LocalDateTime.now());
        if(e instanceof EntityNotFoundException){
            httpStatus = HttpStatus.NOT_FOUND;
            body.put("status", httpStatus.value());
        }else{
            body.put("status", httpStatus.value());
        }
        log.error(body.toString(), e);
        return new ResponseEntity<>(body, httpStatus);
    }

}
