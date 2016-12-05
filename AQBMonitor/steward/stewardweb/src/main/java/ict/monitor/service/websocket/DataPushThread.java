package ict.monitor.service.websocket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import ict.monitor.collection.entity.MetricEntity;
import ict.monitor.common.ExceptionUtil;
import ict.monitor.dao.MetricDao;
import ict.monitor.web.ApplicationContextUtil;

public class DataPushThread extends TimerTask {
	private static Logger logger = LogManager.getLogger(DataPushThread.class.getName());
	private MetricDao metricDao = (MetricDao) ApplicationContextUtil.getBean("metricDao");;

	@Override
	public void run() {
		ArrayList<WebSocketSession> users = MonitorWebsocketEndPoint.getUsers();
		logger.trace("推送数据开始执行,当前连接数目："+ users.size());
		for (WebSocketSession session : users) {
			String agentID = (String) session.getAttributes().get("agentID");
			if (agentID == null) {
				continue;
			}
			List<MetricEntity> findFlushMetric = metricDao.findFlushMetric(agentID);
			if (findFlushMetric.isEmpty()) {
				continue;
			}
			ObjectMapper mapper = new ObjectMapper();
			try {
				String list4json = mapper.writeValueAsString(findFlushMetric);
				logger.trace("目标："+agentID+" push数据size："+list4json.length());
				TextMessage message = new TextMessage(list4json);
				session.sendMessage(message);
			} catch (IOException e) {
				ExceptionUtil.printStackTrace(e);
			}
		}
	}

}
