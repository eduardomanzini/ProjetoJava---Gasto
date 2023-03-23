package com.teste.configs.springFox;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@Configuration
    public class SpringFoxConfig {

    public static final String AUTHORIZATION_HEADER = "Authorization";

    private ApiKey apiKey(){
        return new ApiKey("JWT", AUTHORIZATION_HEADER, "header");
    }

    @Bean
        public Docket GastoApi() {
            return new Docket(DocumentationType.SWAGGER_2)
                    .securityContexts(Arrays.asList(securityContext()))
                    .securitySchemes(Arrays.asList(apiKey()))
                    .select()
                    .apis(RequestHandlerSelectors.basePackage("com.teste.resource"))
                    .paths(PathSelectors.regex("/gastos.*"))
                    .build()
                    .apiInfo(apiInfo());
        }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Gasto API REST",
                "API REST para controle de gastos",
                "API TOS",
                "Terms of service",
                new Contact("Eduardo Manzini", "www.example.com", "eduardo_manzini@hotmail.com"),
                "License of API", "API license URL", Collections.emptyList());
    }

    private SecurityContext securityContext(){
        return SecurityContext.builder().securityReferences(defaultAuth()).build();
    }

    private List<SecurityReference> defaultAuth(){
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Arrays.asList(new SecurityReference("JWT", authorizationScopes));
    }
}

