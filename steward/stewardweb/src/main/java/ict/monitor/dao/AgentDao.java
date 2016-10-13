package ict.monitor.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ict.monitor.bean.Agent;

@Repository
@Transactional
public interface AgentDao extends BaseDao<Agent> {

	ArrayList<Agent> findAgentByUserIDAndAgentID(int id,String agentID);
	ArrayList<Agent> findAgentIDsByUserID(int id);
	int getUserID(String agentID);
	int isAgentID(String agentID);
}
