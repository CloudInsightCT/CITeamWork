package ict.monitor.web;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ApplicationContextUtil implements ApplicationContextAware {
	private static ApplicationContext context;// 声明一个静态变量保存

	public void setApplicationContext(ApplicationContext contex) throws BeansException {
		this.context = contex;
	}

	public static ApplicationContext getContext() {
		return context;
	}

	public final static Object getBean(String beanName) {
		return context.getBean(beanName);
	}

	public final static Object getBean(String beanName, Class<?> requiredType) {
		return context.getBean(beanName, requiredType);
	}
}
