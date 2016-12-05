package ict.monitor.collection.service;

import java.util.TimerTask;

import ict.monitor.dao.MetricDao;
import ict.monitor.web.ApplicationContextUtil;

public class CleanDatabaseThread extends TimerTask {
	private MetricDao metricDao = (MetricDao) ApplicationContextUtil.getBean("metricDao");;
	@Override
	public void run() {
		metricDao.cleanMetric(System.currentTimeMillis()-3*24*60*60*1000);
	}

}
