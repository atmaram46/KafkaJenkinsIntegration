package com.example.kafka.jenkins.utils;


import com.example.kafka.jenkins.constants.ApiConstants;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Request.Builder;
import okhttp3.Request;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class APICall {

    @Autowired
    private OkHttpClient client;

    public Response sendDataToRequestedUrl(String reqUrl, Map<String, String> requestHeaders, Map<String, String> requestBody) {
        Response response = null;
        try {
            MediaType mediaType = MediaType.parse(requestHeaders.get(ApiConstants.CONTENT_TYPE));
            RequestBody body = RequestBody.create(mediaType, new ObjectMapper().setSerializationInclusion(Include.NON_NULL).writeValueAsString(requestBody));
            Builder requestBuilder = new Request.Builder().url(reqUrl).post(body);
            requestHeaders.forEach((key, value) -> requestBuilder.addHeader(key, value));
            Request request = requestBuilder.build();
            response = client.newCall(request).execute();
        } catch (Exception ex) {
            System.out.println("Error while calling API:" + ex.getMessage());
        }
        return response;
    }
}
