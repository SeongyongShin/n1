package com.zerock.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.zerock.command.MemberVO;
import com.zerock.member.mapper.MemberMapper;

@Service("memberservice")
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	MemberMapper memberMapper;
	
	@Override
	public int IdCheck(String id) {
		
		return memberMapper.checkId(id);
	}

	@Override
	public int join(MemberVO vo) {
		return memberMapper.join(vo);
	}

	@Override
	public int login(MemberVO vo) {
			
		return memberMapper.login(vo);
	}

}
