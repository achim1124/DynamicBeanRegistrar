package com.example.dynamicbeanregistrar.bean;

import com.example.dynamicbeanregistrar.bean.lifecycle.CustomImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(CustomImportBeanDefinitionRegistrar.class)
public class ImportConfiguration {
}
