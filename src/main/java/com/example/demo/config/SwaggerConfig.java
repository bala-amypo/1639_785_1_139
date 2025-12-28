// package com.example.demo.config;

// import io.swagger.v3.oas.models.OpenAPI;
// import io.swagger.v3.oas.models.servers.Server;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import io.swagger.v3.oas.models.security.SecurityScheme;
// import java.util.List;

// @Configuration
// public class  SwaggerConfig {
        
//     @Bean
//     public OpenAPI customOpenAPI() {
//          SecurityScheme bearerAuth = new SecurityScheme()
//                 .type(SecurityScheme.Type.HTTP)
//                 .scheme("bearer")
//                 .bearerFormat("JWT");
//         return new OpenAPI()
//                 // You need to change the port as per your server
//                 .servers(List.of(
//                         new Server().url("https://9164.pro604cr.amypo.ai/")
//                 ));
//         }
// }







package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                // 1. Project Name and Description
                .info(new Info()
                        .title("Un")
                        .version("1.0")
                        .description("API documentation for Customer Loyalty project"))
                // 2. Your Specific Server URL (Preserved)
                .servers(List.of(
                        new Server().url("https://9202.408procr.amypo.ai/")
                ))
                // 3. Add Authorize Padlock (Security Requirement)
                .addSecurityItem(new SecurityRequirement().addList("Bearer Authentication"))
                // 4. Define JWT Configuration
                .components(new io.swagger.v3.oas.models.Components()
                        .addSecuritySchemes("Bearer Authentication", new SecurityScheme()
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")));
    }
}