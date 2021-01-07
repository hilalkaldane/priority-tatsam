package com.hk.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SwaggerDocumentationConfig {

	@Bean
	public Docket customImplementation() {
		return new Docket(DocumentationType.OAS_30)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.hk.api"))
				.build()
				.directModelSubstitute(org.threeten.bp.LocalDate.class, java.sql.Date.class)
				.directModelSubstitute(org.threeten.bp.OffsetDateTime.class, java.util.Date.class)
				.apiInfo(apiInfo());
	}

	ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Priority")
				.description("This application lets you visionize your future by assigning priority to different aspects of your life.")
				.license("")
				.licenseUrl("http://unlicense.org")
				.termsOfServiceUrl("")
				.version("1.0.0")
				.contact(new Contact("", "", ""))
				.build();
	}

	@Bean
	public OpenAPI openApi() {
		return new OpenAPI()
				.info(new Info()
						.title("Priority")
						.description("This application lets you visionize your future by assigning priority to different aspects of your life.")
						.termsOfService("")
						.version("1.0.0")
						.license(new License()
								.name("")
								.url("http://unlicense.org"))
						.contact(new io.swagger.v3.oas.models.info.Contact()
								.email("")));
	}

}
