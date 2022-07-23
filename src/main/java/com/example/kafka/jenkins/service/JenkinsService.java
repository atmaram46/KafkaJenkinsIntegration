package com.example.kafka.jenkins.service;

import com.example.kafka.jenkins.Test.KafkaDto;
import com.example.kafka.jenkins.config.JenkinsParameters;
import com.example.kafka.jenkins.producer.KafkaPublisher;
import com.example.kafka.jenkins.utils.APICall;
import com.example.kafka.jenkins.utils.KafkaDataTransformation;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class JenkinsService {

    @Autowired
    private JenkinsParameters jParams;

    @Autowired
    private APICall apiCall;

    @Autowired
    private KafkaDataTransformation kDTras;

    @Autowired
    private KafkaPublisher kafkaPub;

    public String invokeJenkinsCall() {
        Response response = apiCall.sendDataToRequestedUrl(jParams.getJenkinsUrl(), generateRequetHeader(), generateRequestBody());
        return callKafka(response);
    }

    private String callKafka(Response response) {
        KafkaDto data = transformForKafka(response);
        try {
            kafkaPub.publishMessage(data);
        } catch (Exception ex) {
            System.out.println("Error while Publishing Message:" + ex.getMessage());
            return "Failure";
        }
        return "Success";
    }

    private KafkaDto transformForKafka(Response response) {
        return kDTras.generateKafkaObject(response);
    }

    private Map<String, String> generateRequetHeader() {
        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("", "");
        return headerMap;
    }

    private Map<String, String> generateRequestBody() {
        Map<String, String> requestBody = new HashMap<>();
        return requestBody;
    }
}
