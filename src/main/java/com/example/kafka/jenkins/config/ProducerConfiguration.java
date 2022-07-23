package com.example.kafka.jenkins.config;

import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.config.SslConfigs;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ProducerConfiguration {

    @Value("")
    private String bootstrapServers;

    private String protocolName = "SSL";
    private String protocolVersion = "TLSv1.2";

    @Bean
    public ProducerFactory producerFactory() {
        Map<String, Object> props= new HashMap<>();
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ProducerConfig.REQUEST_TIMEOUT_MS_CONFIG, 30000);
        props.put(ProducerConfig.BATCH_SIZE_CONFIG, 98304);
        props.put(ProducerConfig.RETRIES_CONFIG, 3);
        props.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, protocolName);
        props.put(SslConfigs.DEFAULT_SSL_ENABLED_PROTOCOLS, protocolVersion);
        return new DefaultKafkaProducerFactory(props);
    }

    @Bean
    public KafkaTemplate<String, String> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

}
