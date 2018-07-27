package kr.or.ddit.post.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.post.dao.PostDao;
import kr.or.ddit.post.dao.PostDaoInf;
import kr.or.ddit.post.model.PostVo;
import oracle.jdbc.proxy.annotation.Post;

public class PostService implements PostServiceInf {
	private PostDaoInf postDao = new PostDao();
	
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
	public Map<String, Object> getPostPageList(Map<String, Integer> map) {

		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		List<PostVo> pageList = postDao.getPostPageList(map);
		resultMap.put("pageList", pageList);
		int board_no = map.get("board_no");
		
		int totCnt = postDao.getPostTotCnt(board_no);
		resultMap.put("totCnt", totCnt);
		
		int page = map.get("page");
		int pageSize = map.get("pageSize");
		
		resultMap.put("pageNavi", makePageNavi(page, pageSize, totCnt, board_no));
		
		
		
		return resultMap;
	}
	
	
	private String makePageNavi(int page, int pageSize, int totCnt, int board_no){
		int cnt = totCnt / pageSize;
		int mod = totCnt % pageSize;
		
		if(mod > 0){
			cnt++;
		}
		
		StringBuffer pageNaviStr = new StringBuffer();
		
		int prevPage = page == 1 ? 1 : page-1;
		int nextPage = page == cnt ? page : page+1;
		pageNaviStr.append("<li><a href=\"/postList?id=" +board_no+ "&page=" + 1 + "&pageSize=" + pageSize + "\" aria-label=\"First\"><span aria-hidden=\"true\">&laquo;</span></a></li>");
		pageNaviStr.append("<li><a href=\"/postList?id=" +board_no+ "&page=" + prevPage + "&pageSize=" + pageSize + "\" aria-label=\"Previous\"><span aria-hidden=\"true\">&lt;</span></a></li>");
		
		for(int i = 1; i <= cnt; i++){
			String activeClass = "";
			if(i == page){
				activeClass = "class=\"active\"";
			}
			pageNaviStr.append("<li " + activeClass + "><a href=\"/postList?id=" +board_no+ "&page=" + i + "&pageSize="+ pageSize + "\">" + i + "</a></li>");
		}
		
		
		pageNaviStr.append("<li><a href=\"/postList?id=" +board_no+ "&page=" + nextPage + "&pageSize=" + pageSize + "\" aria-label=\"Next\"><span aria-hidden=\"true\">&gt;</span></a></li>");
		pageNaviStr.append("<li><a href=\"/postList?id=" +board_no+ "&page=" + cnt + "&pageSize=" + pageSize + "\" aria-label=\"Last\"><span aria-hidden=\"true\">&raquo;</span></a></li>");
		
		
		return pageNaviStr.toString();
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
		return postDao.getPostTotCnt(board_no);
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
		return postDao.getPostDetail(post_no);
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
		return postDao.insertPost(postVo);
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
		return postDao.updatePost(postVo);
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
		return postDao.deletePost(post_no);
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
		return postDao.answerPost(postVo);
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
		return postDao.getAllCount();
	}



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
