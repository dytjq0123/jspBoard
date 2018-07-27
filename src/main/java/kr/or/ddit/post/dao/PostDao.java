package kr.or.ddit.post.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.mybatis.SqlMapSessionFactory;
import kr.or.ddit.post.model.PostVo;
import kr.or.ddit.student.model.StudentVo;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import oracle.jdbc.proxy.annotation.Post;

public class PostDao implements PostDaoInf {
	private SqlSessionFactory sqlSessionFactory = SqlMapSessionFactory.getSqlSessionFactory();

	/**
	* Method : getPostPageList
	* 최초작성일 : 2018. 7. 24.
	* 작성자 : PC05
	* 변경이력 :
	* @param map
	* @return
	* Method 설명 : map을 매개변수로 받아 10개의 목록이 나오는 리스트 반환
	*/
	@Override
	public List<PostVo> getPostPageList(Map<String, Integer> map) {
		SqlSession session = sqlSessionFactory.openSession();
		List<PostVo> postList = session.selectList("post.getPostPageList", map);
		session.close();
		return postList;
	}

	/**
	* Method : getPostTotCnt
	* 최초작성일 : 2018. 7. 24.
	* 작성자 : PC05
	* 변경이력 :
	* @param board_no
	* @return
	* Method 설명 : 게시판 번호를 매개변수로 받아 해당 게시판의 게시물 갯수 반환
	*/
	@Override
	public int getPostTotCnt(int board_no) {
		SqlSession session = sqlSessionFactory.openSession();
		int cnt = session.selectOne("post.getPostTotCnt", board_no);
		session.close();
		return cnt;
	}

	/**
	* Method : getPostDetail
	* 최초작성일 : 2018. 7. 24.
	* 작성자 : PC05
	* 변경이력 :
	* @param post_no
	* @return
	* Method 설명 : 해당 게시글 번호를 매개변수로 받아 해당 게시글의 상세페이지 반환
	*/
	@Override
	public PostVo getPostDetail(int post_no) {
		SqlSession session = sqlSessionFactory.openSession();
		PostVo postVo = session.selectOne("post.getPostDetail", post_no);
		session.close();
		return postVo;
	}

	/**
	* Method : insertPost
	* 최초작성일 : 2018. 7. 24.
	* 작성자 : PC05
	* 변경이력 :
	* @param postVo
	* @return
	* Method 설명 : 게시글 객체를 매개변수로 받아 게시글 생성
	*/
	@Override
	public int insertPost(PostVo postVo) {
		SqlSession session = sqlSessionFactory.openSession();
		int cnt = session.insert("post.insertPost", postVo);
		session.commit();
		session.close();
		return cnt;
	}

	/**
	* Method : updatePost
	* 최초작성일 : 2018. 7. 24.
	* 작성자 : PC05
	* 변경이력 :
	* @param postVo
	* @return
	* Method 설명 : 게시글 객체를 매개변수로 받아 게시글 수정
	*/
	@Override
	public int updatePost(PostVo postVo) {
		SqlSession session = sqlSessionFactory.openSession();
		int cnt = session.update("post.updatePost", postVo);
		session.commit();
		session.close();
		return cnt;
	}

	/**
	* Method : deletePost
	* 최초작성일 : 2018. 7. 24.
	* 작성자 : PC05
	* 변경이력 :
	* @param post_no
	* @return
	* Method 설명 : 해당 게시글 번호를 매개변수로 받아 게시글 삭제
	*/
	@Override
	public int deletePost(int post_no) {
		SqlSession session = sqlSessionFactory.openSession();
		int cnt = session.delete("post.deletePost", post_no);
		session.commit();
		session.close();
		return cnt;
	}

	/**
	* Method : answerPost
	* 최초작성일 : 2018. 7. 24.
	* 작성자 : PC05
	* 변경이력 :
	* @param postVo
	* @return
	* Method 설명 : 게시글 객체를 매개변수로 받아 답글 생성
	*/
	@Override
	public int answerPost(PostVo postVo) {
		SqlSession session = sqlSessionFactory.openSession();
		int cnt = session.insert("post.answerPost", postVo);
		session.commit();
		session.close();
		return cnt;
	}

	/**
	* Method : getAllCount
	* 최초작성일 : 2018. 7. 24.
	* 작성자 : PC05
	* 변경이력 :
	* @return
	* Method 설명 : 게시글 생성 후 해당 게시글의 상세페이지로 가기위해 게시판 갯수를 게시글 번호로 반환
	*/
	@Override
	public int getAllCount() {
		SqlSession session = sqlSessionFactory.openSession();
		int cnt = session.selectOne("post.getAllCount");
		session.close();
		return cnt;
	}

}
