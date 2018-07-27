package kr.or.ddit.file.service;

import java.util.List;

import kr.or.ddit.file.dao.AddFileDao;
import kr.or.ddit.file.dao.AddFileDaoInf;
import kr.or.ddit.file.model.AddFileVo;

public class AddFileService implements AddFileServiceInf {

	AddFileDaoInf addfileDao = new AddFileDao(); 
	
	/**
	* Method : getAddFileList
	* 최초작성일 : 2018. 7. 24.
	* 작성자 : PC05
	* 변경이력 :
	* @param post_no
	* @return
	* Method 설명 : 게시글의 번호를 매개변수로 받아 해당 게시글의 첨부파일 리스트 반환
	*/
	@Override
	public List<AddFileVo> getAddFileList(int post_no) {
		return addfileDao.getAddFileList(post_no);
	}

	/**
	* Method : insertAddFile
	* 최초작성일 : 2018. 7. 24.
	* 작성자 : PC05
	* 변경이력 :
	* @param addfileVo
	* @return
	* Method 설명 : 첨부파일의 객체를 매개변수로 받아 첨부파일 등록
	*/
	@Override
	public int insertAddFile(AddFileVo addfileVo) {
		return addfileDao.insertAddFile(addfileVo);
	}

}
