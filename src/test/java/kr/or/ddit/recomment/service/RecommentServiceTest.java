package kr.or.ddit.recomment.service;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.recomment.dao.RecommentDao;
import kr.or.ddit.recomment.dao.RecommentDaoInf;
import kr.or.ddit.recomment.model.RecommentVo;

import org.junit.Before;
import org.junit.Test;

public class RecommentServiceTest {

	private RecommentServiceInf recService;

	/**
	* Method : setup
	* 최초작성일 : 2018. 7. 25.
	* 작성자 : PC05
	* 변경이력 :
	* Method 설명 : recDao 객체화
	*/
	@Before
	public void setup(){
		recService = new RecommentService();
	}

	/**
	* Method : getRecListTest
	* 최초작성일 : 2018. 7. 25.
	* 작성자 : PC05
	* 변경이력 :
	* Method 설명 : 게시글 번호를 매개변수로 받아 해당 게시글의 댓글 목록 반환 테스트
	*/
	@Test
	public void getRecListTest() {
		/***Given***/
		int post_no = 1;
		

		/***When***/
		List<RecommentVo> recList = recService.getRecList(post_no);

		/***Then***/
		assertEquals(4, recList.size());

	}
	
	/**
	* Method : insertRecTest
	* 최초작성일 : 2018. 7. 25.
	* 작성자 : PC05
	* 변경이력 :
	* Method 설명 : 댓글 객체를 매개변수로 받아 댓글 생성하는 테스트
	*/
	@Test
	public void insertRecTest(){
		/***Given***/
		RecommentVo recVo = new RecommentVo();
		recVo.setPost_no(1);
		recVo.setId(23);
		recVo.setRec_content("댓글2");
		recVo.setDelYn("n");

		/***When***/
		int cnt = recService.insertRec(recVo);

		/***Then***/
		assertEquals(1, cnt);

	}
	
	/**
	* Method : deleteRecTest
	* 최초작성일 : 2018. 7. 25.
	* 작성자 : PC05
	* 변경이력 :
	* Method 설명 : 댓글 번호를 매개변수로 받아 해당 댓글을 삭제처리하는 테스트
	*/
	@Test
	public void deleteRecTest(){
		/***Given***/
		int rec_no = 2;

		/***When***/
		int cnt = recService.deleteRec(rec_no);

		/***Then***/
		assertEquals(1, cnt);

	}

}
