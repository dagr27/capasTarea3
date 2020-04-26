package com.uca.capas.tarea3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

@Configuration
public class webConfig {
	@Bean
	public ViewResolver viewResolver() {
		ThymeleafViewResolver vr = new ThymeleafViewResolver();
		vr.setTemplateEngine(templateEngine());
		vr.setCharacterEncoding("UTF-8");
		return vr;
	}
	@Bean
	public ClassLoaderTemplateResolver templateResolver() {
		ClassLoaderTemplateResolver tr = new ClassLoaderTemplateResolver();
		tr.setPrefix("templates/");
		tr.setSuffix(".html");
		tr.setTemplateMode("HTML");
		tr.setCharacterEncoding("UTF-8");
		return tr;
	}
	@Bean
	public SpringTemplateEngine templateEngine() {
		SpringTemplateEngine te = new SpringTemplateEngine();
		te.setTemplateResolver(templateResolver());
		return te;
	}
	public void addResourcesHandler(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("resources/**").addResourceLocations("/resources/");
	}
	
}
