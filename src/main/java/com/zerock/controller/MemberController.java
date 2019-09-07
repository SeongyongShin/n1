package com.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("member")
public class MemberController {
/*
 * create table test.tbl_member(
id varchar(50) not null primary key,
pw varchar(50) not null,
name varchar(50) not null,
regdate datetime default current_timestamp
);
 */
	//회원가입 페이지 화면처리
	@RequestMapping("join")
	public String join() {
		
		
		return "member/join";
	}
	
	
	
	//로그인 페이지 화면처리
	@RequestMapping("login")
	public String login() {
		
		return "member/login";
	}
	
	//ajax 요청받기
	@RequestMapping("checkId")
	@ResponseBody // json 형식을 받아주는 어노테이션 이것은 자신을 호출한 위치로 돌아간다 즉 ajax 구문으로 돌아간다는것
	public int checkId(@RequestParam("id") String id) {
		
		return 1;
	}
	
	
	
	
}
