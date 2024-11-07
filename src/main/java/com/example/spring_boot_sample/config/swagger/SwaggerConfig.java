package com.example.spring_boot_sample.config.swagger;

// import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
// import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
// import io.swagger.v3.oas.models.security.SecurityRequirement;
// import io.swagger.v3.oas.models.security.SecurityScheme;
// import io.swagger.v3.oas.models.security.SecurityScheme.Type;

@Configuration
@OpenAPIDefinition(info = @Info(title = "Spring boot webflux sample", description = "Spring boot webflux sample swagger Docs", version = "v1"))
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        // SecurityScheme securityScheme = new SecurityScheme()
        // .type(Type.HTTP)
        // .scheme("bearer")
        // .bearerFormat("JWT")
        // .in(SecurityScheme.In.HEADER).name("Authorization");
        // SecurityRequirement securityRequirement = new
        // SecurityRequirement().addList("bearerAuth");

        // return new OpenAPI()
        // .components(new Components().addSecuritySchemes("bearerAuth",
        // securityScheme))
        // .security(Arrays.asList(securityRequirement));
        return new OpenAPI();
    }

}
