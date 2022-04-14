package com.example.dynamicbeanregistrar.factorybean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

import java.security.MessageDigest;

public class MessageDigestFactoryBean implements FactoryBean<MessageDigest>, InitializingBean {
	private String algorithmName = "MD5";  // algorithmName값에 따라 각 다른 MessageDigest 빈을 얻어와야 한다.

	private MessageDigest messageDigest = null;

	public MessageDigest getObject() throws Exception {  // 스프링이 FactoryBean이 생성한 객체를 얻어오려 할 때 호출되는 메서드
		return messageDigest;
	}

	public Class<MessageDigest> getObjectType() {  // FactoryBean이 어떤 객체 타입을 반환하는지 스프링에게 알려준다.
		return MessageDigest.class;
	}

	public boolean isSingleton() {
		return true;
	}

	public void afterPropertiesSet() throws Exception {  // 여기서 messageDigest 프로퍼티에 인스턴스를 셋팅한다.
		messageDigest = MessageDigest.getInstance(algorithmName);
	}

	public void setAlgorithmName(String algorithmName) {
		this.algorithmName = algorithmName;
	}
}
