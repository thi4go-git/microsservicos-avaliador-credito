package com.dynns.cloudtecnologia.avaliador.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Avaliação de crédito")
                        .description("API Para Avaliação de crédito")
                        .contact(new Contact()
                                .name("Thiago Junior")
                                .email("thi4go19@gmail.com")
                                .url("https://www.linkedin.com/in/thiago-amorim-melo/")
                        )
                        .version("2023"));

    }
}
