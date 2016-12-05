package ict.monitor.agent;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class DefaultAgentTest {
	@Test
	public void TaskTest() {
		DefaultAgent agent = new DefaultAgent();
		agent.start();

		try {
			TimeUnit.SECONDS.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
