package com.test.app.domain.service;

import org.springframework.stereotype.Service;

@Service

public class SimpleService {
	
	public void get1() {
		System.out.println("심플서비스 겟원..");
	}
	public void get2() {
		System.out.println("심플서비스 겟투..");
	}
	public void get3() {
		System.out.println("심플서비스 겟삼..");
	}
}
