package com.zerock.command;

public class PageVO {

	private int total;
	private int startPage;
	private int endPage;
	private int realEnd;
	private boolean prev;
	private boolean next = true;
	
	private Criteria cri;

	
	public PageVO(Criteria cri, int total) {
		this.total = total;
		this.cri = cri;
		
		this.endPage = (int)Math.ceil(cri.getPageNum()/(double)10.0)*cri.getCount();
		this.startPage = this.endPage - 9;
		this.realEnd = (int)Math.ceil(total/(double)cri.getCount());
		
		//endPage = endPage>realEnd? realEnd:endPage;
		if(endPage >= realEnd) {
			endPage = realEnd;
			this.next = false;
		}
		this.prev = (this.startPage != 1);
		System.out.println("endPage : " + endPage +"\nstartPage : " + startPage);
	}

	
	
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getRealEnd() {
		return realEnd;
	}

	public void setRealEnd(int realEnd) {
		this.realEnd = realEnd;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public Criteria getCri() {
		return cri;
	}

	public void setCri(Criteria cri) {
		this.cri = cri;
	}
	
	
}
