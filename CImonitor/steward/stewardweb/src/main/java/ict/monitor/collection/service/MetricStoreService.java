package ict.monitor.collection.service;

import org.springframework.transaction.annotation.Transactional;

import ict.monitor.collection.dao.MetricStoreDao;
import ict.monitor.collection.entity.AgentInfoEntity;
import ict.monitor.collection.entity.DevInfoEntity;
import ict.monitor.collection.entity.MetricEntity;
import ict.monitor.web.ApplicationContextUtil;

public class MetricStoreService {
	private MetricStoreDao store = null;

	public MetricStoreService() {
		store = (MetricStoreDao) ApplicationContextUtil.getBean("metricStoreDao");
	}
	@Transactional
	public void insertUpdate(MetricEntity entity) {
		store.insertMetric(entity);
		store.deleteFlushMetric(entity);
		store.insertFlushMetric(entity);
	}

	public void insertUpdate(DevInfoEntity devInfo) {
		if (store.existsDevInfo(devInfo)==0) {
			store.insertDevInfo(devInfo);
		} else {
			store.updateDevInfo(devInfo);
		}
	}

	public void insertUpdate(AgentInfoEntity agentInfo) {
		if(store.existsAgentInfo(agentInfo)==0) {
			store.insertAgentInfo(agentInfo);
		} else {
			store.updateAgentInfo(agentInfo);
		}
	}

}
