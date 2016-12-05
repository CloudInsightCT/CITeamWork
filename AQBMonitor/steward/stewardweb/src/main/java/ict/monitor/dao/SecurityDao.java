package ict.monitor.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ict.monitor.bean.Security;

@Repository
@Transactional
public interface SecurityDao extends BaseDao<Security> {
	
	public String findUserNameByToken(String token);
	public void delToken(String token);

}
