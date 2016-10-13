package ict.monitor.collection;

import java.io.IOException;
import java.net.Socket;
import java.util.Observable;
import java.util.Observer;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import ict.communication.impl.TCPServer;
import ict.monitor.common.ExceptionUtil;
import ict.monitor.context.WebContext;

public class DefaultCollection implements Observer {
	private static Logger logger = LogManager.getLogger(DefaultCollection.class.getName());
	private TCPServer server;

	public void startCollection() {
		try {
			server = new TCPServer(WebContext.PORT);
			server.addObserver(this);
			logger.trace("收集服务启动："+WebContext.PORT);
			server.startTcpServer();
		} catch (IOException e) {
			ExceptionUtil.printStackTrace(e);
			logger.error("Server建立失败");
			return;
		}
	}

	public void update(Observable o, Object socketObj) {
		try {
			Socket socket = (Socket) socketObj;
			logger.trace("Socket接入："+socket);
			new SimpleSocketHandlerThread(socket).start(); 
		} catch (Exception e) {
			ExceptionUtil.printStackTrace(e);
		}
	}

	public void stopCollection() {
		server.stopTcpServer();
	}

}
