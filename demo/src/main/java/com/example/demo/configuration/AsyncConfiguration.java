package com.example.demo.configuration;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class AsyncConfiguration {
	/*
	Core Pool Size (5): There will always be 5 threads available in the pool to handle tasks. 
	                    Even if these threads are idle, they will not be terminated.
	
	Maximum Pool Size (10): If the number of tasks exceeds the core pool size and the task queue is full,
	                        additional threads can be created, up to a maximum of 10 threads.
	
	Queue Capacity (25): Tasks are held in a queue before being executed. 
	                      If the core pool size is exceeded and the queue is full, 
	                      new threads (up to the maximum pool size) will be created to handle the tasks.
	
	Thread Naming: Threads created by this executor will have names prefixed with "Async-" for easy identification.
	
	Initialization: The executor is prepared and ready to handle tasks after initialization.
	
	*/

	@Bean(name = "asyncExecutor")
	  public Executor asyncExecutor() 
	  {
	    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
	    executor.setCorePoolSize(1);
	    executor.setMaxPoolSize(2);
	    executor.setQueueCapacity(100);
	    executor.setThreadNamePrefix("AsynchThread-");
	    executor.setWaitForTasksToCompleteOnShutdown(true);
	    executor.initialize();
	    return executor;
	  }
}
