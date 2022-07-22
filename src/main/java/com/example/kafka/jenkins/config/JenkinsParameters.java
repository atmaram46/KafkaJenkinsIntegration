package com.example.kafka.jenkins.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class JenkinsParameters {

    @Value("${jenkins.url}")
    private String jenkinsUrl;

    @Value("${jenkins.header.content}")
    private String contentType;

}
