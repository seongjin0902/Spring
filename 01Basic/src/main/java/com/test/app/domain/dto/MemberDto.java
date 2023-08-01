package com.test.app.domain.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class MemberDto {
	private int id;
	private String text;
}
