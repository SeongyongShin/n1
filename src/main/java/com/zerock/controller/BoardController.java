package com.zerock.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zerock.board.service.BoardService;
import com.zerock.command.BoardVO;
import com.zerock.command.Criteria;
import com.zerock.command.PageVO;

@Controller
@RequestMapping("board")
public class BoardController {
	@Autowired
	@Qualifier("boardService") // 이름이 같으면 굳이 안써도됨
	BoardService boardservice;
	/*
	  	create table test.tbl_board(
		num int(10) primary key auto_increment,
		title varchar(200) not null,
		content varchar(2000) not null,
		writer varchar(50) not null,
		regdate datetime default current_timestamp,
		updatedate datetime default current_timestamp
);
	 */
	
//	@RequestMapping("list")
//	public String list(Model model) {
//		ArrayList<BoardVO> list =
//		boardservice.getList();
//		model.addAttribute("board_list",list);
//		return "/board/list";
//	}

	@RequestMapping("list")
	public String list(Model model, Criteria cri) {
		ArrayList<BoardVO> list = boardservice.getList(cri);
		model.addAttribute("board_list",list);
		model.addAttribute("pageMaker",new PageVO(cri,boardservice.getTotal()));
		return "/board/list";
	}
	
	@RequestMapping("register")
	public String register() {
		return "/board/register";
		
	}
	@RequestMapping("regist")
	public String regist(BoardVO vo) {
		//뷰에서 전달받고 서비스로 보냅시다
			boardservice.regist(vo);
		return "redirect:/board/list";
	}
	
//	@RequestMapping("content")
//	public String Content(@RequestParam("num") int num, Model model) {
//		BoardVO vo = boardservice.getContent(num);
//		model.addAttribute("board_content",vo);
//		return "/board/content";
//	}
//	
//	//1. 화면에서 넘어오는 요청 처리
//	//2. getContent() 메서드를 재활용해서 db 처리 후 "board_content" 이름으로 modify.jsp 로 이동
//	//3. modify에 출럭
//	@RequestMapping("modify")
//	public String content(@RequestParam("num") int num, Model model) {
//		BoardVO vo = boardservice.getContent(num);
//		model.addAttribute("board_content",vo);
//		return "/board/modify";
//	}
	//상세보기, 수정페이지 처리 한번에 사용
	@RequestMapping({"/modify","/content"}) // void 형이면 요청값 그대로 따라간다. 이 경로대로 페이지 처리가된다.
	public void content(@RequestParam("num") int num, Model model,@ModelAttribute("cri") Criteria cri) {
		BoardVO vo = boardservice.getContent(num);
		model.addAttribute("board_content",vo);
	}
	//1. 서비스 계층에 폼 값을 전달받는 update  메서드 작성
	//2. update() 메서드 안에서는 updateBoard 생성
	//3. mapper.xml 에서 update 태그를 사용하여 변경
	//4. 이후에 list.jsp 로 이동
	@RequestMapping("update")
	public String update(BoardVO vo) {
		boardservice.updateBoard(vo);
		return "redirect:/board/content?num="+vo.getNum();
	}
	
	//1.delete 명령 실행하는거 실행
	@RequestMapping("delete")
	public String delete(@RequestParam int num) {
		boardservice.delete(num);
		return "redirect:/board/list";
	}
	
	
}
