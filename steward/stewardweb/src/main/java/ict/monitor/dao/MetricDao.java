package ict.monitor.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ict.monitor.collection.entity.MetricEntity;

@Repository
@Transactional
public interface MetricDao {
	List<MetricEntity> findMetricCycle(String agentID, String devID, int tag, long cycle);
	List<MetricEntity> findFlushMetric(String agentID);
	void cleanMetric(long timestamp);
}
