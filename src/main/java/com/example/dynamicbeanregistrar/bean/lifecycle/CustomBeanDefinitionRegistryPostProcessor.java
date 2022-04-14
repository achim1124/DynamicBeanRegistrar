package com.example.dynamicbeanregistrar.bean.lifecycle;

import com.example.dynamicbeanregistrar.bean.AnnotationService;
import com.example.dynamicbeanregistrar.bean.QuotationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Slf4j
@Configuration
public class CustomBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		log.info("=====================CustomBeanDefinitionRegistryPostProcessor :: postProcessBeanDefinitionRegistry [START]=====================");
		// 
		//    RootBeanDefinition beanDefinition = new RootBeanDefinition(MyServiceImpl.class); //The service implementation
		//    serviceDefinition.setTargetType(MyService.class); //The service interface
		//    serviceDefinition.setRole(BeanDefinition.ROLE_APPLICATION);
		//    registry.registerBeanDefinition("myBeanName", beanDefinition);
		
//		for (int i = 1; i <= 3; i++) {
//			//Consumer 방식
//			BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(QuotationService.class, () -> new QuotationService(new AnnotationService()));
//			AbstractBeanDefinition abstractBeanDefinition = beanDefinitionBuilder.getBeanDefinition();
//			BeanDefinitionHolder holder = new BeanDefinitionHolder(abstractBeanDefinition, QuotationService.class.getName() + '#' + i, new String[0]);
//			BeanDefinitionReaderUtils.registerBeanDefinition(holder, registry);
//		}
//		//
//		for (int i = 10; i <= 11; i++) {
//			BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(QuotationService.class);
//			beanDefinitionBuilder.addPropertyValue("injectName", i);
//			// 생성자 주입
//			beanDefinitionBuilder.addConstructorArgValue(new AnnotationService()); 
//			registry.registerBeanDefinition(QuotationService.class.getName() + '#' + i, beanDefinitionBuilder.getBeanDefinition());
//		}
		log.info("=====================CustomBeanDefinitionRegistryPostProcessor :: postProcessBeanDefinitionRegistry [END]=====================");
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		log.info("=====================CustomBeanDefinitionRegistryPostProcessor :: postProcessBeanFactory [START]=====================");
		GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
		beanDefinition.setBeanClass(QuotationService.class);

		//생성자 주입
		ConstructorArgumentValues constructorArgs = new ConstructorArgumentValues();
		constructorArgs.addGenericArgumentValue(new AnnotationService());
		beanDefinition.setConstructorArgumentValues(constructorArgs);

		//세터 주입
		beanDefinition.getPropertyValues().add("injectName", "postProcessBeanFactory");
		
//		MutablePropertyValues values = new MutablePropertyValues();
//		values.addPropertyValue("annotationService", new AnnotationService());
//		beanDefinition.getPropertyValues().add("injectName", "postProcessBeanFactory");
//		beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(values);
		((DefaultListableBeanFactory) beanFactory).registerBeanDefinition("QuotationService#100", beanDefinition);
		
		
		
		log.info("=====================CustomBeanDefinitionRegistryPostProcessor :: postProcessBeanFactory [END]=====================");
	}
}
