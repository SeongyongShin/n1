package com.zerock.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zerock.command.MemberVO;
import com.zerock.member.service.MemberService;
import com.zerock.member.service.MemberServiceImpl;

@Controller
@RequestMapping("member")
public class MemberController {
	
	@Autowired
	//@Qualifier("memberservice")
	MemberService memberservice;
/*
 * create table test.tbl_member(
id varchar(50) not null primary key,
pw varchar(50) not null,
name varchar(50) not null,
regdate datetime default current_timestamp
);
 */
	//�쉶�썝媛��엯 �럹�씠吏� �솕硫댁쿂由�
	@RequestMapping("join")
	public String join() {
		
		
		return "member/join";
	}
	
	
	
	//濡쒓렇�씤 �럹�씠吏� �솕硫댁쿂由�
	@RequestMapping("login")
	public String login() {
		
		return "member/login";
	}
	
	//ajax �슂泥�諛쏄린
	@RequestMapping("checkId")
	@ResponseBody // json �삎�떇�쓣 諛쏆븘二쇰뒗 �뼱�끂�뀒�씠�뀡 �씠寃껋� �옄�떊�쓣 �샇異쒗븳 �쐞移섎줈 �룎�븘媛꾨떎 利� ajax 援щЦ�쑝濡� �룎�븘媛꾨떎�뒗寃�
	public int checkId(@RequestParam("id") String id) {
		//1. service 에 인터페이스 MemberService 생성- 추상메서드 IdCheck() 
		//2. 해당 인터페이스를 구현하는 service 를 만들어서 연결.
		//3. MemberMapper mybatis 인터페이스를 생성하고 구현하는 xml 파일을 생성
		//4. 마이바티스에서는 select count(*)  as result from tbl_member where id = ${#id}
		
		
		return memberservice.IdCheck(id);
	}
	
	
	@RequestMapping("joinForm")
	public String joinForm(MemberVO vo, RedirectAttributes ra) {
		///1. VO 객체 생성, 커맨드객체로 form 값을 받습니다.
		//2. service 에서는 join 메서드를 이용하여 mapper 에서 join 을 이용하려 insert 작업을 진행
		//3. 컨트롤러에서 join 실행결과로 1이 돌아오면 login페이지로 리다이렉트
		//0이 돌아오면 join 페이지로 리다이렉트
		int a = memberservice.join(vo);
		if(a == 1) {
			ra.addFlashAttribute("msg","회원가입이 정상 처리되었습니다.");
		}else {
			ra.addFlashAttribute("msg","회원가입에 실패했습니다.");
			return "redirect:/member/join";
		}
		return "redirect:/member/login";
	}
	
	@RequestMapping("loginForm")
	public String loginForm(MemberVO vo , RedirectAttributes ra, HttpSession session) {
		//1. MemberVO 타입으로 form 값을 받는다.
		//2. mapper 에서는 select 태그 내에 int login()메서드 실행시켜서 회원조회여부 실행 
		//3. select count(*) as result from tbl_member where id = 'asd' and pw = '1234';
		//4. 결과가 1이 나왔으면 세션에 user_id 라는 이름으로 id 저장하고 home 화면으로 리다이렉트
		//5. 결과가 0이 나왔다면 RA 객체에 msg 를 "아이디, 비밀번호를 확인하세요 띄워서 login페이지로 리다이렉트
		int a = memberservice.login(vo);
		
		if(a == 1) {
			session.setAttribute("user_id", vo.getId());
			return "redirect:/";
		}else {
			ra.addFlashAttribute("msg","아이디, 비밀번호를 확인하세요");
			return "redirect:/member/login";
		}
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
