package ict.monitor.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ict.monitor.bean.SlowCallData;

@Repository
@Transactional
public interface SlowCallDataDao extends BaseDao<SlowCallData>{
	void insert(SlowCallData entity);

}
