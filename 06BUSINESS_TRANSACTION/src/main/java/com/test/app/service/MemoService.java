package com.test.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.app.domain.dto.MemoDto;
import com.test.app.domain.mapper.MemoMapper;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class MemoService {
	
	@Autowired
	private MemoMapper mapper;
	
//	전체메모 가져오기
	public List<MemoDto> getAllMemo(){
		log.info("MemoService's getAllMemo 콜~!");
		return mapper.selectAll();
	}

	public int addMemo(MemoDto dto) {
		log.info("MemoService's addMemo 콜~!");
		return mapper.insert(dto);
	}
	
	
//	메모 작성
	@Transactional(rollbackFor = Exception.class)
	public void addMemoTx(MemoDto dto) {
		log.info("MemoService's addMemoTx 콜~!");
		int id = dto.getId();
		mapper.insert(dto);//01 정상 insert
		dto.setId(id);	//pk오류 발생예정인 dto
		mapper.insert(dto);//02	pk오류 발생~!~!~!~!~!~~!~!~!~!~!
	}
//	메모 수정
//	메모 삭제

}
