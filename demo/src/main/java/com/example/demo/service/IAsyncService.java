package com.example.demo.service;

import java.util.concurrent.CompletableFuture;

public interface IAsyncService {

	CompletableFuture<String> callAsync();

}
