package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.IAsyncService;

@RestController
public class AsyncController {

	@Autowired
	IAsyncService asyncService;
	
	@GetMapping("async")
	public ResponseEntity<String> getAsyncData() {
		System.out.println("Inside Controller ------------"+Thread.currentThread());
		asyncService.callAsync();
	
		return ResponseEntity.status(HttpStatus.OK).body("Get Async Data");
	}
	
}
