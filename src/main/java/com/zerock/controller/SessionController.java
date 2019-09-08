package com.zerock.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("session")
public class SessionController {
	//1.硫붿씤泥섎━
	@RequestMapping("mainPage")
	public String mainPage() {
		
		return "session/mainPage";
	}
	//2.濡쒓렇�씤�솕硫댁쿂由�
	
	@RequestMapping("loginPage")
	public String loinPage() {
		return "session/loginPage";
	}
	
	//3.留덉씠�럹�씠吏� �솕硫댁쿂由�
	@RequestMapping("myPage")
	public String myPage(HttpSession session) {
		//�씤�꽣�뀎�꽣瑜� �넻�븳 �꽭�뀡泥섎━
		
		//�꽭�뀡 �뾾�쑝硫� �젒洹쇰텋媛�
//		if(session.getAttribute("user_id") == null) {
//			return "redirect:/session/loginPage";
//		}
		return "session/myPage";
	}
	
	//4. �닔�젙�솕硫댁쿂由�
	@RequestMapping("updatePage")
	public String updatePage() {
		//紐⑤뱺 �럹�씠吏� �꽭�뀡泥섎━�븯湲� �꼫臾� 洹�李����뜲 諛⑸쾿�씠 �엳�쓬 
		
		
		return "session/updatePage";
	}
	
	//5. �씠�븘�뵒 abc, 鍮꾨�踰덊샇 1234硫� 濡쒓렇�씤 �꽦怨듭씠�씪�븯怨� mypage 怨좉퀬
	@RequestMapping("sessionLogin")
	public String sessionLogin(@RequestParam("id") String a, @RequestParam("pw") String b
			, HttpSession session, RedirectAttributes ra){
		String msg = "redirect:/session/loginPage";
		
		if(a.equals("abc")&&b.equals("1234")) {
			session.setAttribute("user_id", a); // �꽭�뀡�뿉 �븘�씠�뵒瑜� ���옣
			session.setAttribute("user_name", "�솉湲몄옄"); // �꽭�뀡�뿉 �씠由� ���옣
			msg = "redirect:/session/myPage";
		}else{
			ra.addFlashAttribute("msg","�븘�씠�뵒 鍮꾨�踰덊샇 �젙蹂대�� �솗�씤�븯�꽭�슂");
		}
		
		return msg;
		
	}
	
	//濡쒓렇�븘�썐
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		//session.removeAttribute("user_id");// �듅�젙 �꽭�뀡�궘�젣�꽩
		session.invalidate();//�쟾泥댁꽭�뀡�궘�젣
		
		return "redirect:/session/mainPage";
	}
	
	@RequestMapping("ajax_test")
	public String ajax_test() {
		
		return "session/ajax_test";
	}
	
	@RequestMapping("check")
	@ResponseBody
	public int check(@RequestParam("apple") String apple, @RequestParam("melon") String melon, @RequestParam("peach") String peach) {
		System.out.println(apple + "\n" + melon + "\n" + peach);
		return 1;
	}
}
