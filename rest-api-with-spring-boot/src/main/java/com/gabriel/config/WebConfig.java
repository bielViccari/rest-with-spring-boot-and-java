package com.gabriel.config;

import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfig implements WebMvcConfigurer {
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        /*Configurer via queryParam http://localhost:8080/api/person/v1?mediaType=xml
        configurer.favorParameter(true);
        configurer.parameterName("mediaType");
        configurer.ignoreAcceptHeader(true).useRegisteredExtensionsOnly(false);
        configurer.defaultContentType(MediaType.APPLICATION_JSON)
        .mediaType("json",MediaType.APPLICATION_JSON)
        .mediaType("xml",MediaType.APPLICATION_XML); */

        configurer.favorParameter(false)
                .ignoreAcceptHeader(false)
                .useRegisteredExtensionsOnly(false)
                .defaultContentType(MediaType.APPLICATION_JSON)
                .mediaType("json", MediaType.APPLICATION_JSON)
                .mediaType("xml", MediaType.APPLICATION_XML);

    }
}
