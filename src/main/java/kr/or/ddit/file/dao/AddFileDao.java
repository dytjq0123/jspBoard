package kr.or.ddit.file.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.file.model.AddFileVo;
import kr.or.ddit.mybatis.SqlMapSessionFactory;

public class AddFileDao implements AddFileDaoInf {

	private SqlSessionFactory sqlSessionFactory = SqlMapSessionFactory.getSqlSessionFactory();

	/**
	* Method : getAddFileList
	* 최초작성일 : 2018. 7. 24.
	* 작성자 : PC05
	* 변경이력 :
	* @param post_no
	* @return
	* Method 설명 : 게시글의 번호를 매개변수로 받아 해당 게시글의 첨부파일 리스트 반환
	*/
	@Override
	public List<AddFileVo> getAddFileList(int post_no) {
		SqlSession session = sqlSessionFactory.openSession();
		List<AddFileVo> addfileList = session.selectList("addfile.getAddFileList", post_no);
		session.close();
		return addfileList;
	}

	/**
	* Method : insertAddFile
	* 최초작성일 : 2018. 7. 24.
	* 작성자 : PC05
	* 변경이력 :
	* @param addfileVo
	* @return
	* Method 설명 : 첨부파일의 객체를 매개변수로 받아 첨부파일 등록
	*/
	@Override
	public int insertAddFile(AddFileVo addfileVo) {
		SqlSession session = sqlSessionFactory.openSession();
		int cnt = session.insert("addfile.insertAddFile", addfileVo);
		session.commit();
		session.close();
		return cnt;
	}

}
