package com.example.datageneratormicroservice.config;

import com.jcabi.xml.XML;
import com.jcabi.xml.XMLDocument;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class BeanConfig {

    @SneakyThrows
    @Bean
    public XML producerXML() {
        return new XMLDocument(
                new ClassPathResource("kafka/producer.xml").getInputStream()
        );
    }

}
