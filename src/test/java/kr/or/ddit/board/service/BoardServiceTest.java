package kr.or.ddit.board.service;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.board.dao.BoardDao;
import kr.or.ddit.board.dao.BoardDaoInf;
import kr.or.ddit.board.model.BoardVo;

import org.junit.Before;
import org.junit.Test;

public class BoardServiceTest {

	private BoardServiceInf bdService;
	
	/**
	* Method : setup
	* 최초작성일 : 2018. 7. 25.
	* 작성자 : PC05
	* 변경이력 :
	* Method 설명 : BoarService 객체화
	*/
	@Before
	public void setup(){
		bdService = new BoardService();
	}
	
	/**
	* Method : getAllBoardListTest
	* 최초작성일 : 2018. 7. 25.
	* 작성자 : PC05
	* 변경이력 :
	* Method 설명 : 게시판의 목록 반환 테스트
	*/
	@Test
	public void getAllBoardListTest() {
		/***Given***/

		/***When***/
		List<BoardVo> bdList = bdService.getAllBoardList();
		
		/***Then***/
		assertEquals(5, bdList.size());
		
	}
	
	/**
	* Method : getBoardDetailTest
	* 최초작성일 : 2018. 7. 25.
	* 작성자 : PC05
	* 변경이력 :
	* Method 설명 : 게시판 번호를 매개변수로 받아 해당 게시판의 정보를 반환하는 테스트
	*/
	@Test
	public void getBoardDetailTest(){
		/***Given***/
		int board_no = 1;

		/***When***/
		BoardVo boardVo = bdService.getBoardDetail(board_no);

		/***Then***/
		assertEquals("자유게시판", boardVo.getBoard_name());
		assertEquals("y", boardVo.getUseYn());

	}
	
	/**
	* Method : insertBoard
	* 최초작성일 : 2018. 7. 25.
	* 작성자 : PC05
	* 변경이력 :
	* Method 설명 : 게시판 객체를 매개변수로 받아 게시판 생성 테스트
	*/
	@Test
	public void insertBoard(){
		/***Given***/
		BoardVo boardVo = new BoardVo();
		boardVo.setBoard_name("게시판");
		boardVo.setId(23);
		boardVo.setUseYn("y");

		/***When***/
		int cnt = bdService.insertBoard(boardVo);

		/***Then***/
		assertEquals(1, cnt);

	}
	
	/**
	* Method : updateBoard
	* 최초작성일 : 2018. 7. 25.
	* 작성자 : PC05
	* 변경이력 :
	* Method 설명 : 게시판 객체를 매개변수로 받아 게시판 수정 테스트
	*/
	@Test
	public void updateBoard(){
		/***Given***/
		BoardVo boardVo = new BoardVo();
		boardVo.setBoard_name("게시판2");
		boardVo.setBoard_no(7);
		boardVo.setId(23);
		boardVo.setUseYn("y");

		/***When***/
		int cnt = bdService.updateBoard(boardVo);

		/***Then***/
		assertEquals(1, cnt);

	}

}
