package com.example.kafka.jenkins.controller;

import com.example.kafka.jenkins.service.JenkinsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/invoke")
public class RequestController {

    @Autowired
    private JenkinsService jenkinsService;

    @GetMapping("/request")
    public ResponseEntity callJenkinsJob() {
        String response = jenkinsService.invokeJenkinsCall();
        return new ResponseEntity(response, HttpStatus.OK);
    }
}
