package com.zerock.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String myPage(HttpSession session) {
		//인터셉터를 통한 세션처리
		
		//세션 없으면 접근불가
//		if(session.getAttribute("user_id") == null) {
//			return "redirect:/session/loginPage";
//		}
		return "session/myPage";
	}
	
	//4. 수정화면처리
	@RequestMapping("updatePage")
	public String updatePage() {
		//모든 페이지 세션처리하기 너무 귀찮은데 방법이 있음 
		
		
		return "session/updatePage";
	}
	
	//5. 이아디 abc, 비밀번호 1234면 로그인 성공이라하고 mypage 고고
	@RequestMapping("sessionLogin")
	public String sessionLogin(@RequestParam("id") String a, @RequestParam("pw") String b
			, HttpSession session, RedirectAttributes ra){
		String msg = "redirect:/session/loginPage";
		
		if(a.equals("abc")&&b.equals("1234")) {
			session.setAttribute("user_id", a); // 세션에 아이디를 저장
			session.setAttribute("user_name", "홍길자"); // 세션에 이름 저장
			msg = "redirect:/session/myPage";
		}else{
			ra.addFlashAttribute("msg","아이디 비밀번호 정보를 확인하세요");
		}
		
		return msg;
		
	}
	
	//로그아웃
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		//session.removeAttribute("user_id");// 특정 세션삭제ㄴ
		session.invalidate();//전체세션삭제
		
		return "redirect:/session/mainPage";
	}
}
