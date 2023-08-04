package com.test.app;

import org.junit.Test;

import com.test.app.domain.dto.MemoDto;
import com.test.app.domain.dto.Person;

public class lombokTests {

	@Test 
	public void test() {
		Person obj = new Person();
		
		obj.setName("아기오구");
		obj.setAddr("대구");
		obj.setAge(55);
		System.out.println(obj);
		
	}
	@Test
	public void test2() {
		MemoDto dto = MemoDto.builder()
						.writer("오구")
						.id(2)
						.text("오리너구리")
						.build();
		System.out.println("Dto : " + dto);
	}

}
