package ict.monitor.service.websocket;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import ict.monitor.dao.AgentDao;

public class HandshakeInterceptor extends HttpSessionHandshakeInterceptor {
	@Autowired
	private AgentDao agentDao;
	@Override
	public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
		String urlStr = request.getURI().toString();
		String agentID = urlStr.substring(urlStr.lastIndexOf("agentid=")+8, urlStr.length());
		if(agentDao.isAgentID(agentID)==0) {
			return false;
		}
		attributes.put("agentID", agentID);
		return true;
	}

	@Override
	public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception ex) {
		
	}

}