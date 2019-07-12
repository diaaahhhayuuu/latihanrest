package com.eksad.latihanrest.config;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig {

	@Bean
	public Docket eksadAPI () {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.eksad.latihanrest"))
				.paths(regex("/api.*"))
				.build()
				.tags(
						new Tag("Brand", "Brand managemen API"),
						new Tag("Product", "Product management API"),
						new Tag("Get Data API", "All GET method from Brand and Product"),
						new Tag("Delete Data API", "All DELETE method from Brand and Product"),
						new Tag("Update Data API", "All UPDATE method from Brand and Product"),
						new Tag("Input Data API", "All INPUT method from Brand and Product")
						)
				.apiInfo(metaInfo() //memanggil method metaInfo 
				);
	}
	
	private ApiInfo metaInfo() {
		ApiInfo apiInfo = new ApiInfo(
				"Supermarket Data Management REST API",
				"Rest API Collection for Supermarket Data Management",
				"1.0.0",
				"http://google.com",
				new Contact("Diah Ayu Anjarwati", "http://www.ciaoanjar.blogspot.com", "diahayu.a@outlook.com"),
				"Diah 2.0", //lisence
				"http://www.ciaoanjar.blogspot.com", //URL lisence
				Collections.emptyList());
		
		return apiInfo;
	}
}
