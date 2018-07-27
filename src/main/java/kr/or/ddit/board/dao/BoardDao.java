package kr.or.ddit.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.mybatis.SqlMapSessionFactory;
import kr.or.ddit.student.model.StudentVo;

public class BoardDao implements BoardDaoInf {

	private SqlSessionFactory sqlSessionFactory = SqlMapSessionFactory.getSqlSessionFactory();
	
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
		SqlSession session = sqlSessionFactory.openSession();
		List<BoardVo> boardList = session.selectList("board.getAllBoard");
		session.close();
		return boardList;
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
		SqlSession session = sqlSessionFactory.openSession();
		BoardVo boardVo = session.selectOne("board.getBoardDetail", board_no);
		session.close();
		return boardVo;
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
		SqlSession session = sqlSessionFactory.openSession();
		int cnt = session.insert("board.insertBoard", boardVo);
		session.commit();
		session.close();
		return cnt;
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
		SqlSession session = sqlSessionFactory.openSession();
		int cnt = session.update("board.updateBoard", boardVo);
		session.commit();
		session.close();
		return cnt;
	}

}
