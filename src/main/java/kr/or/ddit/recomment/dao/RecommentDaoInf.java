package kr.or.ddit.recomment.dao;

import java.util.List;

import kr.or.ddit.recomment.model.RecommentVo;

public interface RecommentDaoInf {

	/**
	* Method : getRecList
	* 최초작성일 : 2018. 7. 24.
	* 작성자 : PC05
	* 변경이력 :
	* @param post_no
	* @return
	* Method 설명 : 게시글의 번호를 매개변수로 받아 해당 게시글의 댓글리스트를 반환
	*/
	List<RecommentVo> getRecList(int post_no);
	
	/**
	* Method : insertRec
	* 최초작성일 : 2018. 7. 24.
	* 작성자 : PC05
	* 변경이력 :
	* @param recVo
	* @return
	* Method 설명 : 댓글 객체를 매개변수로 받아 댓글 생성
	*/
	int insertRec(RecommentVo recVo);
	
	/**
	* Method : deleteRec
	* 최초작성일 : 2018. 7. 24.
	* 작성자 : PC05
	* 변경이력 :
	* @param rec_no
	* @return
	* Method 설명 : 댓글 번호를 매개변수로 받아 댓글 삭제
	*/
	int deleteRec(int rec_no);
}
