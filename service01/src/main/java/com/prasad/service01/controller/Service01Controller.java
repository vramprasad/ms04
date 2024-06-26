package com.prasad.service01.controller;


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
public class Service01Controller {


    @GetMapping(value="/healthcheck")
    public ResponseEntity<String> healthcheck() {
        log.info("Inside Service01Controller --> healthcheck");
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String responseText = "service01 Healthcheck @ "+ timeStamp+" - All OK";
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.TEXT_PLAIN).body(responseText.toString());
    }

    @GetMapping(value="/getservice02")
    public ResponseEntity<String> getService02() {
        log.info("Inside Service01Controller --> getService02");
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String responseText = "Service 01 called at " + timeStamp;
        RestTemplate restTemplate = new RestTemplate();
        String appUrl = "http://localhost:9902/service02/healthcheck";
        ResponseEntity<String> response = restTemplate.getForEntity(appUrl, String.class);
        String respTest = "";
        if (response.getStatusCode().is2xxSuccessful()){
            respTest = response.getBody();
        } else {
            respTest = "Unable to connect to Service 02";
        }
        responseText = responseText + respTest;
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.TEXT_PLAIN).body(responseText.toString());
    }

}
