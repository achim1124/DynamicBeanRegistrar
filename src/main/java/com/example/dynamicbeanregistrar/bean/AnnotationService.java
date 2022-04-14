package com.example.dynamicbeanregistrar.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

//@Service
@Slf4j
public class AnnotationService implements InitializingBean, DisposableBean {

  @Override
  public void afterPropertiesSet() throws Exception {
    log.info("call afterPropertiesSet");
    // 빈 초기화 시 코드 구현
  }

  @Override
  public void destroy() throws Exception {
    // 빈 소멸 시 코드 구현
    log.info("call destroy");
  }
  
  public String getName(String name){
    return name;
  }

}
