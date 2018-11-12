package com.vipets.mypet.vipetsmypetserver;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

import org.springframework.web.context.ServletConfigAware;
import org.springframework.web.context.ServletContextAware;

public class Application implements ServletContextAware, ServletConfigAware {

	private static Application instance;

	private ServletContext context;
	private ServletConfig config;

	private Application() {
	}

	public static Application getInstance() {
		if (instance == null) {
			instance = new Application();
		}
		return instance;
	}

	public ServletContext getServletContext() {
		return this.context;
	}

	public ServletConfig getServletConfig() {
		return this.config;
	}

	@Override
	public void setServletConfig(ServletConfig servletConfig) {
		this.config = servletConfig;
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.context = servletContext;
	}

}
