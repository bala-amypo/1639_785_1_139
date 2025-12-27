package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.SecurityScheme;
import java.util.List;

@Configuration
public class  SwaggerConfig {
        
    @Bean
    public OpenAPI customOpenAPI() {
         SecurityScheme bearerAuth = new SecurityScheme()
                .type(SecurityScheme.Type.HTTP)
                .scheme("bearer")
                .bearerFormat("JWT");
        return new OpenAPI()
                // You need to change the port as per your server
                .servers(List.of(
                        new Server().url("https://9164.pro604cr.amypo.ai/")
                ));
        }
}