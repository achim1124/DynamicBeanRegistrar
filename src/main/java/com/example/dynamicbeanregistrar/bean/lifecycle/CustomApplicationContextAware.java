package com.example.dynamicbeanregistrar.bean.lifecycle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CustomApplicationContextAware implements ApplicationContextAware {

	/**
	 * BeanPostProcessor 보다는 먼저 실행 되네
	 * @param applicationContext
	 * @throws BeansException
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		log.info("CustomApplicationContextAware :: setApplicationContext");	
	}
	
}
