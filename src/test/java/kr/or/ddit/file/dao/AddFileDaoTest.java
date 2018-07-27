package kr.or.ddit.file.dao;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.file.model.AddFileVo;

import org.junit.Before;
import org.junit.Test;

public class AddFileDaoTest {

	private AddFileDaoInf addfileDao;
	
	/**
	* Method : setup
	* 최초작성일 : 2018. 7. 25.
	* 작성자 : PC05
	* 변경이력 :
	* Method 설명 : addfileDao 객체화
	*/
	@Before
	public void setup(){
		addfileDao = new AddFileDao();
	}

	/**
	* Method : getAddFileListTest
	* 최초작성일 : 2018. 7. 25.
	* 작성자 : PC05
	* 변경이력 :
	* Method 설명 : 게시글 번호를 매개변수로 받아 첨부파일 목록 반환하는 테스트
	*/
	@Test
	public void getAddFileListTest() {
		/***Given***/
		int post_no = 1;

		/***When***/
		List<AddFileVo> addfileList = addfileDao.getAddFileList(post_no);

		/***Then***/
		assertEquals(1, addfileList.size());

	}
	
	/**
	* Method : insertAddFileTest
	* 최초작성일 : 2018. 7. 25.
	* 작성자 : PC05
	* 변경이력 :
	* Method 설명 : 첨부파일 객체를 매개변수로 받아 첨부파일을 추가하는 테스트
	*/
	@Test
	public void insertAddFileTest(){
		/***Given***/
		AddFileVo addfileVo = new AddFileVo();
		addfileVo.setPost_no(1);
		addfileVo.setFile_upload("7f64c00a-01a7-4efd-a1a8-522593960d19");
		addfileVo.setFile_path("D:\\A_TeachingMaterial\7.JspSpring\fileUpload");
		addfileVo.setFile_name("brown.png");

		/***When***/
		int cnt = addfileDao.insertAddFile(addfileVo);

		/***Then***/
		assertEquals(1, cnt);

	}

}
