package com.test.app;

import org.junit.Test;

public class lombokTests {

	@Test
	public void test() {
		Person obj = new Person();
		
		obj.setName("아기오구");
		obj.setAddr("대구");
		obj.setAge(55);
		System.out.println(obj);
		
	}

}
