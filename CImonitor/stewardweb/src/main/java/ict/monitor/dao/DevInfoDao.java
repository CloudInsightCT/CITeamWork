package ict.monitor.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ict.monitor.collection.entity.DevInfoEntity;
@Repository
@Transactional
public interface DevInfoDao {
	List<DevInfoEntity> findDevInfo(String agentID);

	DevInfoEntity findDevInfoByAgentIDAndDevID(String agentID, String devID);
}
