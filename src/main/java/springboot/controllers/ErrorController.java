package springboot.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ErrorController {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity processException(Exception e) {
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
