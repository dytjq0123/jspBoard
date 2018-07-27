package kr.or.ddit.student.model;

import java.util.Date;

import kr.or.ddit.encrypt.kisa.sha256.KISA_SHA256;

public class StudentVo {
	// id, name, call_cnt
	
	private int id;			// 학생번호
	private String name;	// 학생이름
	private String std_id;	// 학생 아이디
	private String pass;	// 비밀번호
	private int call_cnt;	// 호출횟수
	private String addr1;	// 주소
	private String addr2;	// 주소2
	private String zipcd;	// 우편번호
	private String pic;		// 프로필사진-실제사진이름
	private String picpath;	// 프로필사진 파일경로
	private String picname; // 프로필사진-물리사진이름
	private Date reg_dt;	// 등록일자
	
	
	public StudentVo(){
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCall_cnt() {
		return call_cnt;
	}
	public void setCall_cnt(int call_cnt) {
		this.call_cnt = call_cnt;
	}
	public Date getReg_dt() {
		return reg_dt;
	}
	public void setReg_dt(Date reg_dt) {
		this.reg_dt = reg_dt;
	}

	public String getAddr1() {
		return addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	public String getAddr2() {
		return addr2;
	}

	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}

	public String getZipcd() {
		return zipcd;
	}

	public void setZipcd(String zipcd) {
		this.zipcd = zipcd;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getPicpath() {
		return picpath;
	}

	public void setPicpath(String picpath) {
		this.picpath = picpath;
	}
	
	public String getPicname() {
		return picname;
	}

	public void setPicname(String picname) {
		this.picname = picname;
	}
	
	

	public String getStd_id() {
		return std_id;
	}

	public void setStd_id(String std_id) {
		this.std_id = std_id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "StudentVo [id=" + id + ", name=" + name + ", std_id=" + std_id
				+ ", pass=" + pass + ", call_cnt=" + call_cnt + ", addr1="
				+ addr1 + ", addr2=" + addr2 + ", zipcd=" + zipcd + ", pic="
				+ pic + ", picpath=" + picpath + ", picname=" + picname
				+ ", reg_dt=" + reg_dt + "]";
	}
	
	
	public boolean validateUser(String userId, String password){
		String pass = KISA_SHA256.encrypt(password);
		System.out.println(password);
		System.out.println(pass);
		if(this.getStd_id().equals(userId) && this.getPass().equals(pass))
			return true;
		else
			return false;
	}
	
	
	
	
	
	
	
}
