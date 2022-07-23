package com.example.kafka.jenkins.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@NoArgsConstructor
@Configuration
public class JenkinsParameters {

//    public JenkinsParameters() {
//    }
//
    public JenkinsParameters(String url, String contentType, String imgUrl) {
        this.jenkinsUrl = url;
        this.contentType = contentType;
//        this.jenkinsImgUrl = imgUrl;
    }

    @Value("${jenkins.url}")
    private String jenkinsUrl;

    @Value("${jenkins.header.content}")
    private String contentType;

//    private String jenkinsImgUrl;

}
