package com.zerock.board.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zerock.board.mapper.BoardMapper;
import com.zerock.command.BoardVO;
import com.zerock.command.Criteria;

//1. 해당 클래스를 서비스 클래스로 사용
//2. 컴포넌트 스캔 추가하기
//3. 컨드롤러의 멤버변수에서 해당 클래스 선언후 자동주입
//4. regist 메소드 안에서 연결
@Service("boardService")
public class BoradServiceImpl implements BoardService{
	
	@Autowired
	BoardMapper boardMapper;
	
	@Override
	public void regist(BoardVO vo) {
		boardMapper.regist(vo);
	}

//	@Override
//	public ArrayList<BoardVO> getList() {
//		
//		
//		return boardMapper.getList();
//	}
	
	@Override
	public ArrayList<BoardVO> getList(Criteria cri) {
		
		return boardMapper.getList(cri);
	}

	@Override
	public BoardVO getContent(int num) {
		
		return boardMapper.getContent(num);
	}

	@Override
	public void updateBoard(BoardVO vo) {
		boardMapper.updateBoard(vo);
	}

	@Override
	public void delete(int num) {
		boardMapper.deleteBoard(num);
		
	}

	@Override
	public int getTotal() {
		
		return boardMapper.getTotal();
	}

	

}
