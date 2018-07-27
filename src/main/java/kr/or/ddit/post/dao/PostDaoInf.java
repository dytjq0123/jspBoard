package kr.or.ddit.post.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.post.model.PostVo;
import kr.or.ddit.student.model.StudentVo;
import oracle.jdbc.proxy.annotation.Post;

public interface PostDaoInf {

	/**
	* Method : getPostPageList
	* 최초작성일 : 2018. 7. 24.
	* 작성자 : PC05
	* 변경이력 :
	* @param map
	* @return
	* Method 설명 : map을 매개변수로 받아 10개의 목록이 나오는 리스트 반환
	*/
	List<PostVo> getPostPageList(Map<String, Integer> map);
	
	/**
	* Method : getPostTotCnt
	* 최초작성일 : 2018. 7. 24.
	* 작성자 : PC05
	* 변경이력 :
	* @param board_no
	* @return
	* Method 설명 : 게시판 번호를 매개변수로 받아 해당 게시판의 게시물 갯수 반환
	*/
	int getPostTotCnt(int board_no);
	
	/**
	* Method : getPostDetail
	* 최초작성일 : 2018. 7. 24.
	* 작성자 : PC05
	* 변경이력 :
	* @param post_no
	* @return
	* Method 설명 : 해당 게시글 번호를 매개변수로 받아 해당 게시글의 상세페이지 반환
	*/
	PostVo getPostDetail(int post_no);
	
	/**
	* Method : insertPost
	* 최초작성일 : 2018. 7. 24.
	* 작성자 : PC05
	* 변경이력 :
	* @param postVo
	* @return
	* Method 설명 : 게시글 객체를 매개변수로 받아 게시글 생성
	*/
	int insertPost(PostVo postVo);
	
	/**
	* Method : updatePost
	* 최초작성일 : 2018. 7. 24.
	* 작성자 : PC05
	* 변경이력 :
	* @param postVo
	* @return
	* Method 설명 : 게시글 객체를 매개변수로 받아 게시글 수정
	*/
	int updatePost(PostVo postVo);
	
	/**
	* Method : deletePost
	* 최초작성일 : 2018. 7. 24.
	* 작성자 : PC05
	* 변경이력 :
	* @param post_no
	* @return
	* Method 설명 : 해당 게시글 번호를 매개변수로 받아 게시글 삭제
	*/
	int deletePost(int post_no);
	
	/**
	* Method : answerPost
	* 최초작성일 : 2018. 7. 24.
	* 작성자 : PC05
	* 변경이력 :
	* @param postVo
	* @return
	* Method 설명 : 게시글 객체를 매개변수로 받아 답글 생성
	*/
	int answerPost(PostVo postVo);
	
	/**
	* Method : getAllCount
	* 최초작성일 : 2018. 7. 24.
	* 작성자 : PC05
	* 변경이력 :
	* @return
	* Method 설명 : 게시글 생성 후 해당 게시글의 상세페이지로 가기위해 게시판 갯수를 게시글 번호로 반환
	*/
	int getAllCount();
}
