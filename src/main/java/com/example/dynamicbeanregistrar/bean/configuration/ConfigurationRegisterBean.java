package com.example.dynamicbeanregistrar.bean.configuration;

import com.example.dynamicbeanregistrar.bean.AnnotationService;
import com.example.dynamicbeanregistrar.bean.QuotationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Configuration 클래스는 final이 되면 안된다.
 * @Bean 메서드는 final이 이 되면 안된다.
 * @Bean 메서드는 private이 되면 안된다.
 */
@Configuration
//@Configuration(proxyBeanMethods = false)
public /*final*/ class ConfigurationRegisterBean {
	
	@Bean
	/*private*/ public /*final*/ AnnotationService annotationService() {
		return new AnnotationService();
	}
	@Bean
	public QuotationService quotationServiceT() {
		return new QuotationService(annotationService());
	}
}
