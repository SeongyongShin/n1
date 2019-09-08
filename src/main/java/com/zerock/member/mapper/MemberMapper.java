package com.zerock.member.mapper;

import com.zerock.command.MemberVO;

public interface MemberMapper {
	public int checkId(String id);
	public int join(MemberVO vo);
	public int login(MemberVO vo);
}
