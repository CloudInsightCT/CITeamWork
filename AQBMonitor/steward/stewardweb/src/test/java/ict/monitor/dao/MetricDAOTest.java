package ict.monitor.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ict.monitor.collection.entity.MetricEntity;
import junit.framework.Assert;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:applicationContext-test.xml")
public class MetricDAOTest {
	@Autowired
	private MetricDao metricDao;
	@Ignore
	@Test
	public void findMetricCycleTest() {
		long cycle = 1456128556580L - 10000;
		List<MetricEntity> metrics = metricDao.findMetricCycle("fa3fa039-fb1a-4cde-8c58-368f7da17edf","CPU0",1,cycle );
		Assert.assertTrue(metrics.size()!=0);
	}
	
	@Test
	public void cleanMetricTest() {
		metricDao.cleanMetric(1000);
	}
}
