package com.warba.abcstore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.google.common.base.Predicates;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class Swagger2Config  {
	
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.warba.abcstore.controller"))
	            .paths(Predicates.not(PathSelectors.regex("/error.*")))
				.build().apiInfo(apiEndPointsInfo());
	}	
	
	private ApiInfo apiEndPointsInfo() {

		return new ApiInfoBuilder().title("ABC Store Receipt")
				.description("ABC Store Receipt for all the customers type")
				.contact(new Contact("Abdullah Areedh", "www.github.com", "aboodalarabi1@gmail.com"))
				.license("Apache 2.0")
				.licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
				.version("1.0.0")
				.build();
	}
	
	

}
