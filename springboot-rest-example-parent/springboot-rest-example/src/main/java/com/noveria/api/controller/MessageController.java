package com.noveria.api.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@CrossOrigin
@RequestMapping("/message")
public class MessageController {

    private Logger logger = Logger.getLogger(getClass().getName());

    @Value("${message}")
    private String message;

    @RequestMapping(value = "/message", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getMessage() {

        logger.info("getMessage() invoked");


        logger.info("getMessage() found: " + message);

        return message;
    }
}
