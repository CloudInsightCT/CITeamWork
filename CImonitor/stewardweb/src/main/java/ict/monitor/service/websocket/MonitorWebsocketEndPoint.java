package ict.monitor.service.websocket;

import java.util.ArrayList;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class MonitorWebsocketEndPoint extends TextWebSocketHandler {
	private static final ArrayList<WebSocketSession> users = new ArrayList<WebSocketSession>();
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		users.add(session);
		super.afterConnectionEstablished(session);
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		users.remove(session);
		super.afterConnectionClosed(session, status);
	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		super.handleTransportError(session, exception);
		if (session.isOpen()) {
			session.close();
		}
		users.remove(session);
	}

	public static ArrayList<WebSocketSession> getUsers() {
		return users;
	}

}