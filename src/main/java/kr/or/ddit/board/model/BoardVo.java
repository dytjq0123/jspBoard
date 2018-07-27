package kr.or.ddit.board.model;

import java.util.Date;

public class BoardVo {

	private int board_no;		//게시판 번호
	private String board_name;	//게시판 이름
	private String useYn;		//사용여부
	private int id;				//작성자
	private Date board_date;	//작성일시
	
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	public String getBoard_name() {
		return board_name;
	}
	public void setBoard_name(String board_name) {
		this.board_name = board_name;
	}
	public String getUseYn() {
		return useYn;
	}
	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getBoard_date() {
		return board_date;
	}
	public void setBoard_date(Date board_date) {
		this.board_date = board_date;
	}
	
	@Override
	public String toString() {
		return "BoardVo [board_no=" + board_no + ", board_name=" + board_name
				+ ", useYn=" + useYn + ", id=" + id + ", board_date="
				+ board_date + "]";
	}
	
	
	
	
}
