package com.example.kafka.jenkins.producer;

import com.example.kafka.jenkins.Test.KafkaDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

public class KafkaPublisher {

    @Autowired
    private KafkaTemplate<Object, Object> kafkaTemplate;

    public void publishMessage(KafkaDto reqDta) throws JsonProcessingException {
        String topic = "Test_kafka";
        int partitionNum = 0;
        String key = generateKey(reqDta.getId());
        kafkaTemplate.send(topic, partitionNum, key, generateMessageString(reqDta));
    }

    private String generateKey(String id) {
        return "Test_0_" + id;
    }

    private String generateMessageString(KafkaDto reqData) throws JsonProcessingException {
        String message = new ObjectMapper().writeValueAsString(reqData);
        return message;
    }
}
