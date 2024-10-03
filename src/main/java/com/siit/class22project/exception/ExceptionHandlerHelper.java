package com.siit.class22project.exception;

import com.siit.class22project.model.CustomErrorMessage;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@ControllerAdvice
public class ExceptionHandlerHelper {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<CustomErrorMessage> handleBusinessException(BusinessException e, HttpServletRequest request) {
        CustomErrorMessage customErrorMessage = new CustomErrorMessage();
        customErrorMessage.setMessage(e.getMessage());
        customErrorMessage.setTimestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-YYYY hh:mm")));
        customErrorMessage.setPath(request.getServletPath());
        if (e.getMessage().contains("not found")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(customErrorMessage);
        }
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(customErrorMessage);
    }
}
