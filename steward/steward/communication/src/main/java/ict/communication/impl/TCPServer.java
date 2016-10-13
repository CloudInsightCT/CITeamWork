package ict.communication.impl;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Observable;

import ict.monitor.common.ExceptionUtil;

public class TCPServer extends Observable {
	private ServerSocket server;
	private boolean runing = true;

	public TCPServer(int port) throws IOException {
		server = new ServerSocket(port);
	}

	public void startTcpServer() {
		while (runing) {
			try {
				Socket socket = server.accept();
				socket.setReuseAddress(true);
				socket.setSoLinger(true, 30);
				this.setChanged();
				this.notifyObservers(socket);
			} catch (SocketException e) {
				continue;
			} catch (IOException e) {
				ExceptionUtil.printStackTrace(e);
			}
		}
	}

	public void stopTcpServer() {
		try {
			runing = false;
			server.close();
		} catch (IOException e) {
			ExceptionUtil.printStackTrace(e);
		}
	}

}
