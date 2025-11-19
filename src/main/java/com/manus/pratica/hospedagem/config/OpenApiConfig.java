package com.manus.pratica.hospedagem.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Documentação e Hospedagem")
                        .version("1.0.0")
                        .description("API de CRUD para Documentos e Categorias, desenvolvida para a Prática 09."));
    }
}
