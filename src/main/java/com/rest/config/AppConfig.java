package com.rest.config;

import java.util.Arrays;
import java.util.concurrent.Executor;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import javax.ws.rs.ext.RuntimeDelegate;

import org.apache.cxf.Bus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.rest.service.InventoryService;
import com.rest.service.impl.InventoryServiceImpl;

/**
 * The Class AppConfig.
 */
@Configuration
@EnableAsync
public class AppConfig implements AsyncConfigurer {

	/** The cxf bus. */
	@Autowired
	@Qualifier("cxf")
	private Bus cxfBus;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.scheduling.annotation.AsyncConfigurer#
	 * getAsyncExecutor()
	 */
	@Override
	public Executor getAsyncExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(10);
		executor.setMaxPoolSize(50);
		executor.setQueueCapacity(6000);
		executor.setThreadNamePrefix("MyExecutor-");
		executor.initialize();
		return executor;
	}

	/**
	 * The Class InventoryApplication.
	 */
	@ApplicationPath("/v1")
	public static class InventoryApplication extends Application {
	}

	/**
	 * Gets the inventory application.
	 *
	 * @return the inventory application
	 */
	@Bean
	public InventoryApplication getInventoryApplication() {
		return new InventoryApplication();
	}

	/**
	 * Jax rs server.
	 *
	 * @return the server
	 */
	@Bean
	public Server jaxRsServer() {
		final JAXRSServerFactoryBean factory = RuntimeDelegate.getInstance().createEndpoint(getInventoryApplication(),
				JAXRSServerFactoryBean.class);
		// Add all the resource beans
		factory.setServiceBeans(Arrays.<Object>asList(restService()));
		factory.setProviders(Arrays.<Object> asList(jsonProvider()));
		factory.setBus(cxfBus);
		return factory.create();
	}

	/**
	 * Json provider.
	 *
	 * @return the jackson json provider
	 */
	@Bean
	public JacksonJsonProvider jsonProvider() {
		return new JacksonJsonProvider();
	}
	
	/**
	 * Rest service.
	 *
	 * @return the inventory service
	 */
	@Bean
	public InventoryService restService() {
		return new InventoryServiceImpl();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.scheduling.annotation.AsyncConfigurer#
	 * getAsyncUncaughtExceptionHandler()
	 */
	@Override
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
		return null;
	}

}