package ict.monitor.agent;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		DefaultAgent agent = new DefaultAgent();
		agent.start();
		Scanner sc = new Scanner(System.in); 
		while(true){
			String next = sc.next();
			if (next.equals("quit")) {
				sc.close();
				System.exit(0);
			}
		}
	}
}
