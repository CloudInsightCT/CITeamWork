package ict.monitor.collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ict.monitor.collection.dao.MetricStoreDao;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:applicationContext.xml")
public class StoreTest {
	@Autowired
	private MetricStoreDao storeImp;
	
	@Test
	public void Test() {
		
	}
}
