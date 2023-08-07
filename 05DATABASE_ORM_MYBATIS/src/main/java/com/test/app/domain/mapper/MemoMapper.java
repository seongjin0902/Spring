package com.test.app.domain.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import com.test.app.domain.dto.MemoDto;

@Mapper
public interface MemoMapper {
	
	@Insert("insert into tbl_memo values(#{id},#{text})")
	public int insert(MemoDto dto);
	
	@Update("update tbl_memo set text=#{text} where id=#{id}")
	public int update(MemoDto dto);
	
	@Delete("delete from tbl_memo where id=#{id}")
	public int delete(int id);
}
