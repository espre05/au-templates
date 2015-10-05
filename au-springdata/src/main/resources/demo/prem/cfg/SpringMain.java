package demo.prem.cfg;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {
	
	private static final String CONFIG_PATH= "classpath*:demo/prem/cfg/jetty.xml";

	public static void main(final String[] args) {
		final ApplicationContext context =new ClassPathXmlApplicationContext(CONFIG_PATH);
	}

}
