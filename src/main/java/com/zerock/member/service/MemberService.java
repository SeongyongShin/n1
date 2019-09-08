package com.zerock.member.service;

import com.zerock.command.MemberVO;

public interface MemberService {
	public int IdCheck(String id);
	public int join(MemberVO vo);
	public int login(MemberVO vo);
}
