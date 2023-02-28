package com.epam.xmlparser.controller;

import com.epam.xmlparser.model.exception.InvalidEPaperXMLFileException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class EpaperControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(JAXBException.class)
    public ResponseEntity<Object> handleJAXBException(
            JAXBException ex, WebRequest request) {
        return new ResponseEntity<>(mapValueByAttribute(ex), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity<Object> handleIOException(
            InvalidEPaperXMLFileException ex, WebRequest request) {
        return new ResponseEntity<>(mapValueByAttribute(ex), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private static Map<String, Object> mapValueByAttribute(Exception ex) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", ex.getMessage());
        return body;
    }


}
