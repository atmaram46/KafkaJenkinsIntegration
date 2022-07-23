package com.example.kafka.jenkins.utils;

import com.example.kafka.jenkins.Test.KafkaDto;
import okhttp3.Response;

public class KafkaDataTransformation {

    public KafkaDto generateKafkaObject(Response response) {
        KafkaDto kafkaRequestData = new KafkaDto();
        //Data transformation will happen here
        //String data = response.readData();
        //kafkaRequestData.setData(data);
        return kafkaRequestData;
    }

}
