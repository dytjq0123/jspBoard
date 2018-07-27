package kr.or.ddit.file.dao;

import java.util.List;

import kr.or.ddit.file.model.AddFileVo;

public interface AddFileDaoInf {

	/**
	* Method : getAddFileList
	* 최초작성일 : 2018. 7. 24.
	* 작성자 : PC05
	* 변경이력 :
	* @param post_no
	* @return
	* Method 설명 : 게시글의 번호를 매개변수로 받아 해당 게시글의 첨부파일 리스트 반환
	*/
	List<AddFileVo> getAddFileList(int post_no);
	
	/**
	* Method : insertAddFile
	* 최초작성일 : 2018. 7. 24.
	* 작성자 : PC05
	* 변경이력 :
	* @param addfileVo
	* @return
	* Method 설명 : 첨부파일의 객체를 매개변수로 받아 첨부파일 등록
	*/
	int insertAddFile(AddFileVo addfileVo);
	
}
