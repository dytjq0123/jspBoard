package kr.or.ddit.file.service;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.file.model.AddFileVo;

import org.junit.Before;
import org.junit.Test;

public class AddFileServiceTest {

	private AddFileServiceInf addfileService;
	
	/**
	* Method : setup
	* 최초작성일 : 2018. 7. 25.
	* 작성자 : PC05
	* 변경이력 :
	* Method 설명 : addfileService 객체화
	*/
	@Before
	public void setup() {
		addfileService = new AddFileService();
	}

	/**
	* Method : getAddFileListTest
	* 최초작성일 : 2018. 7. 25.
	* 작성자 : PC05
	* 변경이력 :
	* Method 설명 : 게시판 번호를 매개변수로 받아 해당 게시판의 첨부파일 목록을 반환하는 테스트
	*/
	@Test
	public void getAddFileListTest() {
		/***Given***/
		int post_no = 1;

		/***When***/
		List<AddFileVo> addfileList = addfileService.getAddFileList(post_no);

		/***Then***/
		assertEquals(2, addfileList.size());

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
		addfileVo.setFile_upload("a247dbe7-5e45-4699-a689-e48623a633d6");
		addfileVo.setFile_path("D:\\A_TeachingMaterial\7.JspSpring\fileUpload");
		addfileVo.setFile_name("moon.png");

		/***When***/
		int cnt = addfileService.insertAddFile(addfileVo);

		/***Then***/
		assertEquals(1, cnt);

	}

}
