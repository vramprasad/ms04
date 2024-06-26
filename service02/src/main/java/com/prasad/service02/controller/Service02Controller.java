package com.prasad.service02.controller;


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
public class Service02Controller {


    @GetMapping(value="/healthcheck")
    public ResponseEntity<String> healthcheck() {
        log.info("Inside Service02Controller --> healthcheck");
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String responseText = "service02 Healthcheck @ "+ timeStamp+" - All OK";
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.TEXT_PLAIN).body(responseText.toString());
    }


}
