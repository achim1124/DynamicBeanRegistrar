package com.example.dynamicbeanregistrar.factorybean;
import java.security.MessageDigest;

public class MessageDigester {
	private MessageDigest digest1;   // FactoryBean으로 주입받을 MessageDigest 타입 의존 객체가 프로퍼티로 선언되어 있다.
	private MessageDigest digest2;

	public void setDigest1(MessageDigest digest1) {
		this.digest1 = digest1;
	}

	public void setDigest2(MessageDigest digest2) {
		this.digest2 = digest2;
	}

	public void digest(String msg) {
		System.out.println("Using digest1");
		digest(msg, digest1);

		System.out.println("Using digest2");
		digest(msg, digest2);
	}

	private void digest(String msg, MessageDigest digest) {
		System.out.println("Using alogrithm: " + digest.getAlgorithm());
		digest.reset();
		byte[] bytes = msg.getBytes();
		byte[] out = digest.digest(bytes);
		System.out.println(out);
	}	
}
