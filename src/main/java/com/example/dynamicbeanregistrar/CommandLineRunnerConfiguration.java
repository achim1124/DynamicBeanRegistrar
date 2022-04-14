package com.example.dynamicbeanregistrar;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class CommandLineRunnerConfiguration {

  @Bean
  public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
    return args -> {
      log.info(">>>> 스프링부트 러너  <<<< ");
      log.info("스프링 부트 애플리케이션 구동시 시작되는 프로그램을 살펴보자");
      String[] beanNames = ctx.getBeanDefinitionNames();
      for (String beanName : beanNames) {
        log.info(beanName);
      }
    };
  }
}
