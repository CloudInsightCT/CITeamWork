package ict.communication.impl;

import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.ArrayList;

import ict.communication.Transmission;

public class UDPClient implements Transmission {
	private DatagramSocket client;
	public UDPClient() throws SocketException {
		client = new DatagramSocket();
	}


	public void send(byte[] data) {
	}


	public void send(String data) {
	}


	public void send(ArrayList<String> datas) {
	}

}
