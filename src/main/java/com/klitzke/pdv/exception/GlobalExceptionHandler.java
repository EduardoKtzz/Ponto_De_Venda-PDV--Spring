package com.klitzke.pdv.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<ErrorResponse> httpInvalido(NoResourceFoundException exception, HttpServletRequest request) {
        String mensagem = exception.getMessage();
        ErrorResponse erro = new ErrorResponse (HttpStatus.BAD_REQUEST.value(), "Caminho inválido", mensagem, request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ErrorResponse> metodoInvalido(HttpRequestMethodNotSupportedException exception, HttpServletRequest request) {
        String mensagem = exception.getMessage();
        ErrorResponse erro = new ErrorResponse (HttpStatus.METHOD_NOT_ALLOWED.value(), "Parâmetro inválido", mensagem, request.getRequestURI());
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(erro);

    }
}