package com.example.dynamicbeanregistrar;

import com.example.dynamicbeanregistrar.bean.AnnotationService;
import com.example.dynamicbeanregistrar.bean.QuotationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class TestTask {
	
	private final ApplicationContext applicationContext;

	@Autowired
	private List<QuotationService> quotationServices;
	
	@Autowired
	private AnnotationService annotationService;

	@Scheduled(initialDelay = 5000, fixedDelay = 5000)
	public void test() {
		quotationServices.forEach(r -> {
			log.info(r.getInjectName());
		});
	}
}
