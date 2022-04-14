package com.example.dynamicbeanregistrar.factorybean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageDigesterConfig {
	@Bean
	public MessageDigestFactoryBean shaDigest() {
		MessageDigestFactoryBean factoryOne = new MessageDigestFactoryBean();
		factoryOne.setAlgorithmName("SHA1");
		return factoryOne;
	}

	@Bean
	public MessageDigestFactoryBean defaultDigest() {
		return new MessageDigestFactoryBean();
	}

	@Bean
	public MessageDigester digester() throws Exception {
		MessageDigester messageDigester = new MessageDigester();
		messageDigester.setDigest1(shaDigest().getObject());
		messageDigester.setDigest2(defaultDigest().getObject());
		return messageDigester;
	}
}
