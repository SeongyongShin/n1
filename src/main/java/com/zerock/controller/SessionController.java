package com.zerock.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("session")
public class SessionController {
	//1.메인처리
	@RequestMapping("mainPage")
	public String mainPage() {
		
		return "session/mainPage";
	}
	//2.로그인화면처리
	
	@RequestMapping("loginPage")
	public String loinPage() {
		return "session/loginPage";
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
	
	//5. 이아디 abc, 비밀번호 1234면 로그인 성공이라하고 mypage 고고
	@RequestMapping("sessionLogin")
	public String sessionLogin(@RequestParam("id") String a, @RequestParam("pw") String b, HttpSession session){
		String msg = "redirect:session/loginPage";
		
		if(a.equals("abc")&&b.equals("1234")) {
			session.setAttribute("user_id", a); // 세션에 아이디를 저장
			session.setAttribute("user_name", "홍길자"); // 세션에 이름 저장
			msg = "redirect:/session/myPage";
		}
		
		return msg;
		
	}
	
}
