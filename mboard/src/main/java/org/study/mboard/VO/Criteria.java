package org.study.mboard.VO;

/**
 * 현제 리스트 페이지의 번호와 리스트 개수를 갖는 VO클래스. 
 * @author Song
 *
 */
public class Criteria {

	private int page;
	private int perPageNum;

	private int rowStart;
	private int rowEnd;

	public Criteria() {
		this.page = 1;
		this.perPageNum = 5;
	}

	public void setPage(int page) {

		if (page <= 0) {
			this.page = 1;
			return;
		}

		this.page = page;
	}

	public void setPerPageNum(int perPageNum) {

		if (perPageNum <= 0 || perPageNum > 100) {
			this.perPageNum = 10;
			return;
		}

		this.perPageNum = perPageNum;
	}

	public int getPage() {
		return page;
	}


	public int getPageStart() {

		return (this.page - 1) * perPageNum;
	}


	public int getPerPageNum() {

		return this.perPageNum;
	}

  	//오라클 버전
	public int getRowStart() {
		return ((page - 1) * perPageNum) + 1;
	}
	
	public int getRowEnd() {
		return getRowStart() + perPageNum - 1;
	}

	@Override
	public String toString() {
		return "Criteria [page=" + page + ", " + "perPageNum=" + perPageNum + "]";
	}
}

