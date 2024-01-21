package dev.muyiwa.springboot.restfulcrudapi.exception;

import dev.muyiwa.springboot.restfulcrudapi.users.NotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(java.lang.Exception.class)
    public final ResponseEntity<Exception> handleApplicationExceptions(java.lang.Exception exception, WebRequest request) {
        Exception customException = new Exception(exception.getMessage(), request.getDescription(false));

        return new ResponseEntity<>(customException, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NotFoundException.class)
    public final ResponseEntity<Exception> handleNotFoundException(java.lang.Exception exception, WebRequest request) {
        Exception customException = new Exception(exception.getMessage(), request.getDescription(false));

        return new ResponseEntity<>(customException, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<String> errorMessages = ex.getFieldErrors().stream().map(error -> error.getDefaultMessage()).toList();

        Exception customException = new Exception("Invalid argument", errorMessages);

        return new ResponseEntity<>(customException, HttpStatus.BAD_REQUEST);
    }
}
