package com.example.demo.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService  implements IAsyncService{

	@Override
	// @Async  // It will take default pool 
	@Async("asyncExecutor")
	public CompletableFuture<String> callAsync() {
		CompletableFuture<String> completableFuture = null;
		try {
			
			System.out.println("----------------------- Inside Call Async Method --------------------------"
					+Thread.currentThread());
			
			 completableFuture =getCustomerDetails()
			.thenApply(action->{
				return action+ "Inside ThenAccept" ;
			});
			Thread.sleep(12000);
			
			System.out.println("----------------------- Inside Call Async Method_End --------------------------"
			+Thread.currentThread());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return completableFuture;
	}

	private CompletableFuture<String> getCustomerDetails() {
	return 	CompletableFuture.supplyAsync(()->{
			return " Inside getCustomerDetails";
		});
		
	}

}
