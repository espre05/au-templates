package com.example;

import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringStart {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				new String[] { "/com/example/spring-jaxrs.xml" });

		// 'simple' is the id of the jaxrs server bean
		JAXRSServerFactoryBean sfb = (JAXRSServerFactoryBean) ctx.getBean("jaxServer");
		sfb.create();
	}

}
