package kr.or.ddit.post.dao;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.post.model.PostVo;

import org.junit.Before;
import org.junit.Test;

public class PostDaoTest {

	private PostDaoInf postDao;
	
	/**
	* Method : setup
	* 최초작성일 : 2018. 7. 25.
	* 작성자 : PC05
	* 변경이력 :
	* Method 설명 : PostDao 객체화
	*/
	@Before
	public void setup(){
		postDao = new PostDao();
	}
	
	/**
	* Method : getPostPageListTest
	* 최초작성일 : 2018. 7. 25.
	* 작성자 : PC05
	* 변경이력 :
	* Method 설명 : 최대 10개의 게시글 목록을 반환하는 테스트 
	*/
	@Test
	public void getPostPageListTest() {
		/***Given***/
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("page", 1);
		map.put("pageSize", 10);
		map.put("board_no", 1);

		/***When***/
		List<PostVo> postList = postDao.getPostPageList(map);
		System.out.println(postList.size());
		for(PostVo post : postList){
			System.out.println(post.getPost_title());
		}
		/***Then***/
		assertEquals(3, postList.size());

	}
	
	/**
	* Method : getPostTotCntTest
	* 최초작성일 : 2018. 7. 25.
	* 작성자 : PC05
	* 변경이력 :
	* Method 설명 : 게시판 번호를 매개변수로 받아 해당 게시판의 게시글 갯수 반환 테스트
	*/
	@Test
	public void getPostTotCntTest(){
		/***Given***/
		int board_no = 1;

		/***When***/
		int cnt = postDao.getPostTotCnt(board_no);

		/***Then***/
		assertEquals(3, cnt);

	}
	
	/**
	* Method : getPostDetailTest
	* 최초작성일 : 2018. 7. 25.
	* 작성자 : PC05
	* 변경이력 :
	* Method 설명 : 게시글 번호를 매개변수로 받아 해당 게시글의 정보를 반환하는 테스트
	*/
	@Test
	public void getPostDetailTest(){
		/***Given***/
		int post_no = 1;

		/***When***/
		PostVo postVo = postDao.getPostDetail(post_no);

		/***Then***/
		assertEquals("첫번째 글", postVo.getPost_title());
		assertEquals(1, postVo.getPost_no());

	}
	
	/**
	* Method : insertPostTest
	* 최초작성일 : 2018. 7. 25.
	* 작성자 : PC05
	* 변경이력 :
	* Method 설명 : 게시글 객체를 매개변수로 받아 게시글 생성하는 테스트
	*/
	@Test
	public void insertPostTest(){
		/***Given***/
		PostVo postVo = new PostVo();
		postVo.setBoard_no(1);
		postVo.setId(23);
		postVo.setPost_title("제목");
		postVo.setPost_content("내용");

		/***When***/
		int cnt = postDao.insertPost(postVo);

		/***Then***/
		assertEquals(1, cnt);

	}
	
	/**
	* Method : updatePostTest
	* 최초작성일 : 2018. 7. 25.
	* 작성자 : PC05
	* 변경이력 :
	* Method 설명 : 게시글 객체를 매개변수로 받아 게시글 수정하는 테스트
	*/
	@Test
	public void updatePostTest(){
		/***Given***/
		PostVo postVo = new PostVo();
		postVo.setPost_no(4);
		postVo.setPost_title("제목 수정");
		postVo.setPost_content("내용 수정");

		/***When***/
		int cnt = postDao.updatePost(postVo);

		/***Then***/
		assertEquals(1, cnt);
	}
	
	/**
	* Method : deletePostTest
	* 최초작성일 : 2018. 7. 25.
	* 작성자 : PC05
	* 변경이력 :
	* Method 설명 : 게시글 번호를 매개변수로 받아 게시글을 삭제처리하는 테스트
	*/
	@Test
	public void deletePostTest(){
		/***Given***/
		int post_no = 2;

		/***When***/
		int cnt = postDao.deletePost(post_no);

		/***Then***/
		assertEquals(1, cnt);

	}
	
	/**
	* Method : answerPostTest
	* 최초작성일 : 2018. 7. 25.
	* 작성자 : PC05
	* 변경이력 :
	* Method 설명 : 게시글 객체를 매개변수로 받아 답글을 생성하는 테스트
	*/
	@Test
	public void answerPostTest(){
		/***Given***/
		PostVo postVo = new PostVo();
		postVo.setBoard_no(1);
		postVo.setId(23);
		postVo.setPost_title("제목2");
		postVo.setPost_content("내용2");
		postVo.setPno(2);
		postVo.setGno(2);

		/***When***/
		int cnt = postDao.answerPost(postVo);

		/***Then***/
		assertEquals(1, cnt);

	}
	
	/**
	* Method : getAllCount
	* 최초작성일 : 2018. 7. 25.
	* 작성자 : PC05
	* 변경이력 :
	* Method 설명 : 게시글 생성후 해당 게시글의 상세 페이지로 이동하기 위해 게시글 번호로 사용되는 게시글 갯수 테스트
	*/
	@Test
	public void getAllCount(){
		/***Given***/
		

		/***When***/
		int cnt = postDao.getAllCount();

		/***Then***/
		assertEquals(5, cnt);

	}
	
	

}
