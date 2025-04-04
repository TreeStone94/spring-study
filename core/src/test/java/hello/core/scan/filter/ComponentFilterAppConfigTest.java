package hello.core.scan.filter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import static org.springframework.context.annotation.ComponentScan.*;

public class ComponentFilterAppConfigTest {

	@Test
	void filterScan() {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ComponentFilterAppConfig.class);
		BeanA beanA = ac.getBean("beanA", BeanA.class);
		Assertions.assertNotNull(beanA);


		Assertions.assertThrows(
				NoSuchBeanDefinitionException.class,
				() -> ac.getBean("beanB", BeanB.class)
		);
	}

	@Configuration
	@ComponentScan(
			includeFilters = @Filter(type = FilterType.ANNOTATION, classes = MyIncludeComponentScan.class),
			excludeFilters = @Filter(type = FilterType.ANNOTATION, classes = MyExcludeComponentScan.class)
	)
	static class ComponentFilterAppConfig {

	}
}
