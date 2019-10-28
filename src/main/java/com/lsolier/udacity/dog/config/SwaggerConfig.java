package com.lsolier.udacity.dog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.any())
        .paths(PathSelectors.any()).build()
        .useDefaultResponseMessages(Boolean.FALSE);
  }

  private ApiInfo apiInfo() {
    return new ApiInfo(
        "Dog Api",
        "This API return a list of dogs",
        "1.0",
        "https://github.com/lsolier",
        new Contact(
            "Luis Solier Sajami",
            "https://www.linkedin.com/in/lsolier/",
            "luis.sajami@gmail.com"),
        "License of API", "MIT Licence", Collections.emptyList());
  }

}