package com.restweb.swaggerconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	 
	/*
	 * private ApiInfo metaData() {
	 * 
	 * List<VendorExtension> ve = new ArrayList(); ApiInfo apiInfo = new ApiInfo(
	 * "Spring Boot REST API", "Spring Boot REST API", "1.0", "Terms of service",
	 * new Contact("Yashpal", "https://localhost:8081/swagger-ui.html",
	 * "rajyash881@gmail.com"), "Apache License Version 2.0",
	 * "https://www.apache.org/licenses/LICENSE-2.0", ve); return apiInfo; }
	 * 
	 * private ApiKey apiKey() { return new ApiKey("JWT", "Authorization",
	 * "header"); } private SecurityContext securityContext() { return
	 * SecurityContext.builder().securityReferences(defaultAuth()).build(); }
	 * 
	 * private List<SecurityReference> defaultAuth() { AuthorizationScope
	 * authorizationScope = new AuthorizationScope("global", "accessEverything");
	 * AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
	 * authorizationScopes[0] = authorizationScope; return Arrays.asList(new
	 * SecurityReference("JWT", authorizationScopes)); }
	 * 
	 * @Bean public Docket api() { return new Docket(DocumentationType.SWAGGER_2)
	 * .apiInfo(apiInfo()) .securityContexts(Arrays.asList(securityContext()))
	 * .securitySchemes(Arrays.asList(apiKey())) .select()
	 * .apis(RequestHandlerSelectors.any()) .paths(PathSelectors.any()) .build(); }
	 * 
	 * private ApiInfo apiInfo() { List<VendorExtension> ve = new ArrayList();
	 * ApiInfo apiInfo = new ApiInfo( "Spring Boot REST API",
	 * "Spring Boot REST API", "1.0", "Terms of service", new Contact("Yashpal",
	 * "https://localhost:8081/swagger-ui.html", "rajyash881@gmail.com"),
	 * "Apache License Version 2.0", "https://www.apache.org/licenses/LICENSE-2.0",
	 * ve); return apiInfo; }
	 */
	
	

@Bean
public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.any())
            .paths(PathSelectors.any())
            .build()
            .apiInfo(apiInfo())
            .securitySchemes(Arrays.asList(apiKey()));
}

private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
            .title("Sig-Predict REST API Document")
            .description("work in progress")
            .termsOfServiceUrl("localhost")
            .version("1.0")
            .build();
}

private ApiKey apiKey() {
    return new ApiKey("jwtToken", "Authorization", "header");
}
	  
	  
}
