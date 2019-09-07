package com.zerock.board.mapper;

import java.util.ArrayList;

import com.zerock.command.BoardVO;
import com.zerock.command.Criteria;

public interface BoardMapper {
	public void regist(BoardVO vo);
	//public ArrayList<BoardVO> getList();
	public ArrayList<BoardVO> getList(Criteria cri);
	public int getTotal();
	public BoardVO getContent(int num);
	public void updateBoard(BoardVO vo);
	public void deleteBoard(int num);
}
