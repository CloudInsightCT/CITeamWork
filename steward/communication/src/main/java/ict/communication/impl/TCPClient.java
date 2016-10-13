package ict.communication.impl;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;

import ict.communication.Transmission;
import ict.monitor.common.ExceptionUtil;

public class TCPClient implements Transmission {
	private String ip;
	private int port;

	public TCPClient(String ip, int port) {
		this.ip = ip;
		this.port = port;
	}

	public void send(final byte[] data) {
		sendTemplate(this.new Send() {
			@Override
			void send(Socket socket) throws Exception {
				OutputStream outputStream = socket.getOutputStream();
				outputStream.write(data);
				outputStream.flush();
				outputStream.close();
			}
		});
	}

	public void send(final String data) {
		sendTemplate(this.new Send() {
			@Override
			void send(Socket socket) throws Exception {
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				bw.write(data);
				bw.flush();
				bw.close();
			}
		});
	}

	public void sendTemplate(Send send) {
		Socket socket = null;
		try {
			socket = new Socket(ip, port);
			send.send(socket);
		} catch (Exception e) {
			ExceptionUtil.printStackTrace(e);
		} finally {
			try {
				if (socket != null) {
					socket.close();
				}
			} catch (IOException e) {
				ExceptionUtil.printStackTrace(e);
			}
		}
	}

	private abstract class Send {
		abstract void send(Socket socket) throws Exception;
	}

	public void send(final ArrayList<String> datas) {
		sendTemplate(this.new Send() {
			@Override
			void send(Socket socket) throws Exception {
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				for (String data : datas) {
					bw.write(data);
					bw.write("\n");
				}
				bw.flush();
				bw.close();
			}
		});
	}
}
