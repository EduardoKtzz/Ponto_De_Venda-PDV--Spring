package com.klitzke.pdv.exception;

import com.klitzke.pdv.services.exception.RecursoNaoEncontradoException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

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

    @ExceptionHandler(RecursoNaoEncontradoException.class)
    public ResponseEntity<ErrorResponse> resultadoNaoEncontrado(RecursoNaoEncontradoException exception, HttpServletRequest request) {
        String mensagem = exception.getMessage();
        ErrorResponse erro = new ErrorResponse(HttpStatus.NOT_FOUND.value(), "Nenhum resultado encontrado.", mensagem, request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponse> dadosObrigatorios (DataIntegrityViolationException exception, HttpServletRequest request) {
        String mensagem = exception.getMessage();
        ErrorResponse erro = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "Dados duplicados, verifique se esse produto já existe no sistema.", mensagem, request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }
}