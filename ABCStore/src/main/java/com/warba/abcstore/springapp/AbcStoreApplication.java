package com.warba.abcstore.springapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@ComponentScan({"com.warba.abcstore.controller","com.warba.abcstore.service","com.warba.abcstore.bean","com.warba.abcstore.dto"})
@EntityScan("com.warba.abcstore.entity")
@EnableJpaRepositories("com.warba.abcstore.repository")
public class AbcStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(AbcStoreApplication.class, args);
	}

}
