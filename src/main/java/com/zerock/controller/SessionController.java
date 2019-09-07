package com.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("session")
public class SessionController {
	//1.메인처리
	@RequestMapping("mainPage")
	public String mainPage() {
		
		return "session/mainPage";
	}
	//2.로그인화면처리
	
	@RequestMapping("loinPage")
	public String loinPage() {
		return "session/loinPage";
	}
	
	//3.마이페이지 화면처리
	@RequestMapping("myPage")
	public String myPage() {
		return "session/myPage";
	}
	
	//4. 수정화면처리
	@RequestMapping("updatePage")
	public String updatePage() {
		return "session/updatePage";
	}
	
}
