package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.board.dao.BoardDao;
import kr.or.ddit.board.dao.BoardDaoInf;
import kr.or.ddit.board.model.BoardVo;

public class BoardService implements BoardServiceInf {

	private BoardDaoInf boardDao = new BoardDao();
	
	
	/**
	* Method : getAllBoardList
	* 최초작성일 : 2018. 7. 24.
	* 작성자 : PC05
	* 변경이력 :
	* @return
	* Method 설명 : 모든 게시판 리스트 반환
	*/
	@Override
	public List<BoardVo> getAllBoardList() {
		return boardDao.getAllBoardList();
	}

	/**
	* Method : getBoardDetail
	* 최초작성일 : 2018. 7. 24.
	* 작성자 : PC05
	* 변경이력 :
	* @param board_no
	* @return
	* Method 설명 : 게시판 번호를 매개변수로 받아 해당 게시판의 정보를 반환
	*/
	@Override
	public BoardVo getBoardDetail(int board_no) {
		return boardDao.getBoardDetail(board_no);
	}

	/**
	* Method : insertBoard
	* 최초작성일 : 2018. 7. 24.
	* 작성자 : PC05
	* 변경이력 :
	* @param boardVo
	* @return
	* Method 설명 : 게시판 객체를 매개변수로 받아 게시판 생성
	*/
	@Override
	public int insertBoard(BoardVo boardVo) {
		return boardDao.insertBoard(boardVo);
	}

	/**
	* Method : updateBoard
	* 최초작성일 : 2018. 7. 24.
	* 작성자 : PC05
	* 변경이력 :
	* @param boardVo
	* @return
	* Method 설명 : 게시판 객체를 매개변수로 받아 게시판 수정
	*/
	@Override
	public int updateBoard(BoardVo boardVo) {
		return boardDao.updateBoard(boardVo);
	}

}
