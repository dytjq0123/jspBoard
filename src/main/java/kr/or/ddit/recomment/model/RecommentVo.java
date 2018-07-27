package kr.or.ddit.recomment.model;

import java.util.Date;

public class RecommentVo {

	private int rec_no;				//댓글 번호
	private int post_no;			//게시글 번호
	private int id;					//작성자
	private String rec_content;		//댓글내용
	private Date rec_date;			//일시
	private String delYn;			//삭제여부
	private String std_id;			//학생 아이디
	
	public int getRec_no() {
		return rec_no;
	}
	public void setRec_no(int rec_no) {
		this.rec_no = rec_no;
	}
	public int getPost_no() {
		return post_no;
	}
	public void setPost_no(int post_no) {
		this.post_no = post_no;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRec_content() {
		return rec_content;
	}
	public void setRec_content(String rec_content) {
		this.rec_content = rec_content;
	}
	public Date getRec_date() {
		return rec_date;
	}
	public void setRec_date(Date rec_date) {
		this.rec_date = rec_date;
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
	@Override
	public String toString() {
		return "RecommentVo [rec_no=" + rec_no + ", post_no=" + post_no
				+ ", id=" + id + ", rec_content=" + rec_content + ", rec_date="
				+ rec_date + "]";
	}
	
	
	
	
}
