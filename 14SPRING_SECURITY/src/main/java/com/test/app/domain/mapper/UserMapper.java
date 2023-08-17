package com.test.app.domain.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.test.app.domain.dto.UserDto;

@Mapper
public class UserMapper {

	public int insert(UserDto dto);
	
	public UserDto selectAt();
}
