package ict.communication;

import java.util.ArrayList;

public interface Transmission {
	void send(byte[] data);
	void send(String data);
	void send(ArrayList<String> datas);
}
