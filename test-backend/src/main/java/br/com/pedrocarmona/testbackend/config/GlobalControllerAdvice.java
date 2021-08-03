package br.com.pedrocarmona.testbackend.config;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handlerInternalServerErrorFromExceptions(Exception ex, WebRequest request) {
        return new ResponseEntity<>(getBody(ex.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private Map<String, Object> getBody(String message, HttpStatus httpStatus) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("message", message);
        body.put("status_code", httpStatus.value());
        body.put("status", httpStatus.toString());
        return body;
    }
}
