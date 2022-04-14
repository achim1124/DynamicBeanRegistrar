package com.example.dynamicbeanregistrar.bean.lifecycle;

import com.example.dynamicbeanregistrar.bean.QuotationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
@RequiredArgsConstructor
public class CustomBeanPostProcessorMethod {
  
  private final ConfigurableBeanFactory configurableBeanFactory;
  private final ApplicationContext applicationContext;

  
  @Bean
  public BeanPostProcessor methodBeanPostProcessor() {
    return new BeanPostProcessor() {
      @Override
      public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof QuotationService) {
          log.info("=====================CustomBeanPostProcessorMethod :: postProcessAfterInitialization=====================");
        }
        return bean;
      }
    };
  }
}
