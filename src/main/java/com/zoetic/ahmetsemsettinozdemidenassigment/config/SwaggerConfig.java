package com.zoetic.ahmetsemsettinozdemidenassigment.config;

import com.google.common.base.Predicates;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${swagger.enabled}")
    private Boolean enabled;

    @Value("${swagger.host.url}")
    private String host;

    @Value("${swagger.host.path}")
    private String path;

    public String getHost() {
        return host;
    }

    public String getPath() {
        return path;
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).host(host).pathMapping(path).enable(enabled)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.zoetic.ahmetsemsettinozdemidenassigment.controller"))
                .paths(Predicates.not(PathSelectors.regex("/_monitoring/*")))
                .build();
    }

}
