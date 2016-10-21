package ict.monitor.collection.dao;

import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

import ict.monitor.collection.entity.AgentInfoEntity;
import ict.monitor.collection.entity.DevInfoEntity;
import ict.monitor.collection.entity.MetricEntity;

/**
 * 负责接收主机监控数据处理的dao
 * @author Tian
 *
 */
@Repository(value = "metricStoreDao")
@Transactional
public interface MetricStoreDao {
	void insertMetric(MetricEntity entity);

	void insertDevInfo(DevInfoEntity devInfo);

	void insertAgentInfo(AgentInfoEntity agentInfo);

	int existsDevInfo(DevInfoEntity devInfo);

	void updateDevInfo(DevInfoEntity devInfo);

	int existsAgentInfo(AgentInfoEntity agentInfo);

	void updateAgentInfo(AgentInfoEntity agentInfo);

	void insertFlushMetric(MetricEntity entity);

	void deleteFlushMetric(MetricEntity entity);
}
