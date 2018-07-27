package kr.or.ddit.post.model;

import java.util.Date;

public class PostVo {
	
	private int post_no;			//게시글 번호
	private int board_no;			//게시판 번호
	private Integer pno;				//부모게시글 번호
	private int gno;				//게시글 그룹번호
	private String post_title;		//게시글 제목
	private String post_content;	//게시글 내용
	private int id;					//작성자
	private Date post_date;			//작성일시
	private String delYn;			//삭제여부
	private String std_id;			//아이디
	private int rn;					//순서
	public int getPost_no() {
		return post_no;
	}
	public void setPost_no(int post_no) {
		this.post_no = post_no;
	}
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	public Integer getPno() {
		return pno;
	}
	public void setPno(Integer pno) {
		this.pno = pno;
	}
	public int getGno() {
		return gno;
	}
	public void setGno(int gno) {
		this.gno = gno;
	}
	public String getPost_title() {
		return post_title;
	}
	public void setPost_title(String post_title) {
		this.post_title = post_title;
	}
	public String getPost_content() {
		return post_content;
	}
	public void setPost_content(String post_content) {
		this.post_content = post_content;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getPost_date() {
		return post_date;
	}
	public void setPost_date(Date post_date) {
		this.post_date = post_date;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	public String getStd_id() {
		return std_id;
	}
	public void setStd_id(String std_id) {
		this.std_id = std_id;
	}
	
	public int getRn() {
		return rn;
	}
	public void setRn(int rn) {
		this.rn = rn;
	}
	@Override
	public String toString() {
		return "PostVo [post_no=" + post_no + ", board_no=" + board_no
				+ ", pno=" + pno + ", gno=" + gno + ", post_title="
				+ post_title + ", post_content=" + post_content + ", id=" + id
				+ ", post_date=" + post_date + ", delYn=" + delYn + ", std_id="
				+ std_id + "]";
	}
	
	
}
