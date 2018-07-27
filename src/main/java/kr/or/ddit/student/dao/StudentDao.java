package kr.or.ddit.student.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.mybatis.SqlMapSessionFactory;
import kr.or.ddit.student.model.StudentVo;

public class StudentDao implements StudentDaoInf {

	private SqlSessionFactory sqlSessionFactory = SqlMapSessionFactory.getSqlSessionFactory();
	
	
	
	

	/**
	* Method : getStudent
	* 최초작성일 : 2018. 7. 24.
	* 작성자 : PC05
	* 변경이력 :
	* @param std_id
	* @return
	* Method 설명 : 로그인한 사용자의 아이디를 매개변수로 받아 사용자의 정보 반환
	*/
	@Override
	public StudentVo getStudent(String std_id) {
		SqlSession session = sqlSessionFactory.openSession();
		StudentVo studentVo = session.selectOne("student.selectStudent", std_id);
		session.close();
		return studentVo;
	}
	

}
