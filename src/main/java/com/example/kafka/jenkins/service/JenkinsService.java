package com.example.kafka.jenkins.service;

import com.example.kafka.jenkins.config.JenkinsParameters;
import com.example.kafka.jenkins.utils.APICall;
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

    public String invokeJenkinsCall() {
        String result = "";
        Response response = apiCall.sendDataToRequestedUrl(jParams.getJenkinsUrl(), generateRequetHeader(), generateRequestBody());

        return result;
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
