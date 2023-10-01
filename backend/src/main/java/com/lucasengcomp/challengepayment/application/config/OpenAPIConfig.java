package com.lucasengcomp.challengepayment.application.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenAPIConfig {

    @Value("${lucasengcomp.openapi.dev-url}")
    private String devUrl;

    @PostConstruct
    public void init() {
    }

    @Bean
    public OpenAPI myOpenAPI() {
        Server devServer = new Server();
        devServer.setUrl(devUrl);
        devServer.setDescription("URL's de desenvolvimento da aplicação");

        Contact contact = new Contact();
        contact.setEmail("lucas.engcomp@outlook.com");
        contact.setName("lucasengcomp");
        contact.setUrl("https://github.com/lucasengcomp");

        License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");

        Info info = new Info()
                .title("Tutorial de gerenciamento da API")
                .version("1.0")
                .contact(contact)
                .description("API para gerenciamento de divisão de contas")
                .license(mitLicense);

        return new OpenAPI().info(info).servers(List.of(devServer));
    }
}
