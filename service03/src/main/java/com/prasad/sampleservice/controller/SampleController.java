package com.prasad.sampleservice.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@RestController
@Slf4j
public class SampleController {


    @GetMapping(value="/healthcheck")
    public ResponseEntity<String> healthcheck() {
        log.info("Inside SampleController --> healthcheck");
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String responseText = "sample-service-api Healthcheck @ "+ timeStamp+" - All OK";
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.TEXT_PLAIN).body(responseText.toString());
    }

    @GetMapping(value="/createsample")
    public ResponseEntity<String> createSample() {
        log.info("Inside SampleController --> createSample");
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        Random rand = new Random();
        int sampleId;
        sampleId = rand.nextInt(100000);
        String responseText = "Sample ID "+ sampleId + " created at " + timeStamp;
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.TEXT_PLAIN).body(responseText.toString());
    }

    @GetMapping(value="/createsampletest")
    public ResponseEntity<String> createSampleTest() {
        log.info("Inside SampleController --> createSampleTest");
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        Random rand = new Random();
        int sampleId;
        sampleId = rand.nextInt(100000);
        String responseText = "Sample ID "+ sampleId + " created at " + timeStamp;
        RestTemplate restTemplate = new RestTemplate();
        String appUrl = "http://localhost:9903/testing-service/createtest";
        ResponseEntity<String> response = restTemplate.getForEntity(appUrl, String.class);
        String respTest = "";
        if (response.getStatusCode().is2xxSuccessful()){
            respTest = response.getBody();
        } else {
            respTest = "Unable to generate Test";
        }
        responseText = responseText + respTest;
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.TEXT_PLAIN).body(responseText.toString());
    }

}
