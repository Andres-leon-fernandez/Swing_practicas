package com.andresleon.spring_web_de_cero_a_experto.IT;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;

import java.time.Duration;

@TestConfiguration
public class ApiHelper {

    @Bean
    public TestRestTemplate getRestTemplate() {
        return new TestRestTemplate(new RestTemplateBuilder()
                .basicAuthentication("user", "paswword")
                .connectTimeout(Duration.ofSeconds(10))
        );
    }
}
