package com.test.app.scheduled;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class Scheduling {

	@Scheduled(fixedRate = 1000)
	public void test1() {
		System.out.println("Scheduled's test1 함수!");
	}
	
	@Scheduled(cron = "0 * * * * *")
	public void test2() {
		System.out.println("Scheduled's test2 함수!");
	}
}
