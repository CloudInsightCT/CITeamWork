package ict.monitor.collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import ict.monitor.collection.encode.Decode;
import ict.monitor.collection.encode.SimpleDecode;
import ict.monitor.collection.entity.BaseEntity;
import ict.monitor.collection.service.MetricStoreService;
import ict.monitor.common.ExceptionUtil;

public class SimpleSocketHandlerThread extends Thread {
	private Socket socket;
	private Decode decodeImp = new SimpleDecode();
	private MetricStoreService service = new MetricStoreService();
	
	public SimpleSocketHandlerThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String data = br.readLine();
			while (data!=null) {
				BaseEntity decode = decodeImp.decode(data);
				decode.insertUpdate(service);
				data = br.readLine();
			}
			br.close();
		} catch (IOException e) {
			ExceptionUtil.printStackTrace(e);
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				ExceptionUtil.printStackTrace(e);
			}
		}
	}

}
