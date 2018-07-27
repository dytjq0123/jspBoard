package kr.or.ddit.student.service;

import static org.junit.Assert.*;
import kr.or.ddit.student.model.StudentVo;

import org.junit.Test;

public class StudentServiceTest {

	/**
	* Method : getStudentTest
	* 최초작성일 : 2018. 7. 25.
	* 작성자 : PC05
	* 변경이력 :
	* Method 설명 : 사용자 로그인 아이디를 매개변수로 받아 해당 사용자의 정보를 받아오는 테스트
	*/
	@Test
	public void getStudentTest() {
		/***Given***/
		StudentServiceInf stdService = new StudentService();
		String std_id = "brown";
		
		/***When***/
		StudentVo studentVo = stdService.getStudent(std_id);

		/***Then***/
		assertEquals(23, studentVo.getId());
		assertEquals("brown", studentVo.getStd_id());

	}

}
