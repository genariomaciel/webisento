package br.com.isento.webisento.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("WebIsento API")
                        .version("1.0.0")
                        .description("API para gerenciamento de insenção de impostos na compra de veículos")
                        .contact(new Contact()
                                .name("Genário Maciel")
                                .email("contact@example.com"))
                        .license(new License()
                                .name("Privado")));
    }
}
