package ict.monitor.collection.service;

import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import ict.monitor.collection.DefaultCollection;
import ict.monitor.context.WebContext;
import ict.monitor.service.websocket.DataPushThread;

public class ServiceStartServletListener implements ServletContextListener {
	private Timer timer = new Timer();
	private DefaultCollection defaultCollection = new DefaultCollection();
	private Thread collectionThread = new Thread(new Runnable() {
		public void run() {
			try {
				defaultCollection.startCollection();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		try {
			WebContext.init();
			collectionThread.start();
			timer.schedule(new DataPushThread(),5000,10 * 1000);
			timer.schedule(new CleanDatabaseThread(),5000,24*60*60 * 1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		defaultCollection.stopCollection();
		timer.cancel();
	}

}
