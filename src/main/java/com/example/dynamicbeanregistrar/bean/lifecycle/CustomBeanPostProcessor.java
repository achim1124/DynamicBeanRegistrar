package com.example.dynamicbeanregistrar.bean.lifecycle;

import com.example.dynamicbeanregistrar.bean.QuotationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class CustomBeanPostProcessor implements BeanPostProcessor {

  private final ConfigurableBeanFactory configurableBeanFactory;
  private final ApplicationContext applicationContext;

  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
    if (bean instanceof QuotationService) {
      log.info("=====================CustomBeanPostProcessor :: postProcessBeforeInitialization=====================");
    }
    return bean;
  }

  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    if (bean instanceof QuotationService) {
      log.info("=====================CustomBeanPostProcessor :: postProcessAfterInitialization=====================");
    }
    return bean;
  }
}
