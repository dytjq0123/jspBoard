package kr.or.ddit.student.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.student.dao.StudentDao;
import kr.or.ddit.student.dao.StudentDaoInf;
import kr.or.ddit.student.model.StudentVo;

public class StudentService implements StudentServiceInf {
	
	StudentDaoInf stdDao = new StudentDao();





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
		return stdDao.getStudent(std_id);
	}

}
