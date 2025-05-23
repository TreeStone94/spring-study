package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifecycleTest {
	 @Test
	public void lifeCycleTest() {
		 ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LiftCycleConfig.class);
		 NetworkClient client = ac.getBean(NetworkClient.class);
		 ac.close();
	 }

	 @Configuration
	static class LiftCycleConfig {

//		 @Bean(initMethod = "init", destroyMethod = "close")
		 @Bean
		 public NetworkClient NetworkClient() {
			 NetworkClient networkClient = new NetworkClient();
			 networkClient.setUrl("http://hello-spring.dev");
			 return networkClient;
		 }
	 }
}
