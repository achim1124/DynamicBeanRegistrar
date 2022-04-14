package com.example.dynamicbeanregistrar.bean.lifecycle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class CustomBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

  /**
   * BeanFactoryPostProcessor는 클라이언트 코드가 bean definition을 커스터마이징 하게끔 할 수 있도록 도와준다.
   * BeanFactoryPostProcessor의 postProcessBeanFactory 메서드는 모든 definition들이 로드된 이후에 스프링의 startup 프로세스에 의해 호출된다.
   * 하지만 어떠한 빈도 아직 초기화되지는 않은 상태이다
   * 즉, 초기화 되지 않았다는건 인스턴스화 되지 않았다는 것이다.
   * @param configurableListableBeanFactory
   * @throws BeansException
   */
  @Override
  public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
    log.info("=====================CustomBeanFactoryPostProcessor :: postProcessBeanFactory [START]=====================");
  }
}
