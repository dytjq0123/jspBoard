package kr.or.ddit.file.model;

public class AddFileVo {

	private int file_no;				//첨부파일 번호
	private int post_no;				//게시글 번호
	private String file_upload;			//업로드파일명
	private String file_path;			//파일경로
	private String file_name;			//파일이름
	public int getFile_no() {
		return file_no;
	}
	public void setFile_no(int file_no) {
		this.file_no = file_no;
	}
	public int getPost_no() {
		return post_no;
	}
	public void setPost_no(int post_no) {
		this.post_no = post_no;
	}
	public String getFile_upload() {
		return file_upload;
	}
	public void setFile_upload(String file_upload) {
		this.file_upload = file_upload;
	}
	public String getFile_path() {
		return file_path;
	}
	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	@Override
	public String toString() {
		return "AddFileVo [file_no=" + file_no + ", post_no=" + post_no
				+ ", file_upload=" + file_upload + ", file_path=" + file_path
				+ ", file_name=" + file_name + "]";
	}
	
	
}
