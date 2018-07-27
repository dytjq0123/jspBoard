package kr.or.ddit.recomment.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.mybatis.SqlMapSessionFactory;
import kr.or.ddit.recomment.model.RecommentVo;

public class RecommentDao implements RecommentDaoInf {

	private SqlSessionFactory sqlSessionFactory = SqlMapSessionFactory.getSqlSessionFactory();
	
	/**
	* Method : getRecList
	* 최초작성일 : 2018. 7. 24.
	* 작성자 : PC05
	* 변경이력 :
	* @param post_no
	* @return
	* Method 설명 : 게시글의 번호를 매개변수로 받아 해당 게시글의 댓글리스트를 반환
	*/
	@Override
	public List<RecommentVo> getRecList(int post_no) {
		SqlSession session = sqlSessionFactory.openSession();
		List<RecommentVo> recList = session.selectList("recomment.getRecList", post_no);
		session.close();
		return recList;
	}

	/**
	* Method : insertRec
	* 최초작성일 : 2018. 7. 24.
	* 작성자 : PC05
	* 변경이력 :
	* @param recVo
	* @return
	* Method 설명 : 댓글 객체를 매개변수로 받아 댓글 생성
	*/
	@Override
	public int insertRec(RecommentVo recVo) {
		SqlSession session = sqlSessionFactory.openSession();
		int cnt = session.insert("recomment.insertRec", recVo);
		session.commit();
		session.close();
		return cnt;
	}

	/**
	* Method : deleteRec
	* 최초작성일 : 2018. 7. 24.
	* 작성자 : PC05
	* 변경이력 :
	* @param rec_no
	* @return
	* Method 설명 : 댓글 번호를 매개변수로 받아 댓글 삭제
	*/
	@Override
	public int deleteRec(int rec_no) {
		SqlSession session = sqlSessionFactory.openSession();
		int cnt = session.update("recomment.deleteRec", rec_no);
		session.commit();
		session.close();
		return cnt;
	}

}
