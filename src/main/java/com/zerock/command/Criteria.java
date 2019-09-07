package com.zerock.command;

public class Criteria {
	//쿼리 : select * from 테이블명 order by num desc list 어디부터 시작할지, 몇개 출력할지
	private int pageNum;
	private int count;
	
	public Criteria() {
		pageNum = 1;
		count = 10;
	}
	
	public Criteria(int pageNum, int count) {
		this.pageNum = pageNum;
		this.count = count;
	}
	
	public int getPageStart() {
		return (pageNum-1)*count;
	}

	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
}
