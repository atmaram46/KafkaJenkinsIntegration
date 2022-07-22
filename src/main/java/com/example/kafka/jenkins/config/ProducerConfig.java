package com.example.kafka.jenkins.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProducerConfig {

    @Value("")
    private String bootstrapServers;


}
