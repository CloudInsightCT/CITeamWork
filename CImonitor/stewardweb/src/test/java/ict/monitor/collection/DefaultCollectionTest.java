package ict.monitor.collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ict.monitor.context.WebContext;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:applicationContext-test.xml")
public class DefaultCollectionTest {
	@Test
	public void useCase() {
		try {
			WebContext.init();
		} catch (Exception e) {
			e.printStackTrace();
		}
		DefaultCollection defaultCollection = new DefaultCollection();
		defaultCollection.startCollection();
	}

}
