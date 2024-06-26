package com.prasad.testingservice.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@RestController
@Slf4j
public class TestingController {


    @GetMapping(value="/healthcheck")
    public ResponseEntity<String> healthcheck() {
        log.info("Inside TestingController --> healthcheck");
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String responseText = "testing-service-api Healthcheck @ "+ timeStamp+" - All OK";
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.TEXT_PLAIN).body(responseText.toString());
    }

    @GetMapping(value="/createtest")
    public ResponseEntity<String> createTest() {
        log.info("Inside TestingController --> createTest");
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        Random rand = new Random();
        int testId;
        testId = rand.nextInt(100000);
        String responseText = "Test ID "+ testId + " created at " + timeStamp;
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.TEXT_PLAIN).body(responseText.toString());
    }

}
