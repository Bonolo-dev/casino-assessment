package com.rank.assessment.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Date;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/casino")
public class CasinoController{

    @GetMapping("/test")
    public ResponseEntity<?> test(){

        //time conversion test
        long currentTimestamp = Instant.now().toEpochMilli();
        Date date = new Date(currentTimestamp );

        return ResponseEntity.status(HttpStatus.OK).body("Test Successful: " +  date.toString());
    }

}