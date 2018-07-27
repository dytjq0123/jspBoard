package kr.or.ddit.board.dao;

import java.util.List;

import kr.or.ddit.board.model.BoardVo;

public interface BoardDaoInf {

	/**
	* Method : getAllBoardList
	* 최초작성일 : 2018. 7. 24.
	* 작성자 : PC05
	* 변경이력 :
	* @return
	* Method 설명 : 모든 게시판 리스트 반환
	*/
	List<BoardVo> getAllBoardList();
	
	/**
	* Method : getBoardDetail
	* 최초작성일 : 2018. 7. 24.
	* 작성자 : PC05
	* 변경이력 :
	* @param board_no
	* @return
	* Method 설명 : 게시판 번호를 매개변수로 받아 해당 게시판의 정보를 반환
	*/
	BoardVo getBoardDetail(int board_no); 
	
	/**
	* Method : insertBoard
	* 최초작성일 : 2018. 7. 24.
	* 작성자 : PC05
	* 변경이력 :
	* @param boardVo
	* @return
	* Method 설명 : 게시판 객체를 매개변수로 받아 게시판 생성
	*/
	int insertBoard(BoardVo boardVo);
	
	/**
	* Method : updateBoard
	* 최초작성일 : 2018. 7. 24.
	* 작성자 : PC05
	* 변경이력 :
	* @param boardVo
	* @return
	* Method 설명 : 게시판 객체를 매개변수로 받아 게시판 수정
	*/
	int updateBoard(BoardVo boardVo);
}
