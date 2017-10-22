package com.example.demo.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jaxrs.cfg.JaxRSFeature;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JaxRsJsonProviderConfiguration {

    @Bean
    public JacksonJsonProvider jsonProvider() {
        JacksonJsonProvider provider = new JacksonJsonProvider(objectMapper());
        provider.enable(JaxRSFeature.CACHE_ENDPOINT_WRITERS);
        return provider;
    }

    private ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        return mapper;
    }

}
