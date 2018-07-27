package kr.or.ddit.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;
import javax.xml.ws.spi.http.HttpContext;

import org.apache.catalina.Session;
import org.apache.tomcat.util.net.SecureNioChannel.ApplicationBufferHandler;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;
import kr.or.ddit.student.model.StudentVo;
import kr.or.ddit.student.service.StudentService;
import kr.or.ddit.student.service.StudentServiceInf;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		
		response.setContentType("text/html; charset=utf-8");
		
		// 파라미터를 받아서 sysout으로 console 창에 출력
		String std_id = request.getParameter("std_id");
		String password = request.getParameter("password");
		
		
		
		
		StudentServiceInf studentService = new StudentService();
		StudentVo studentVo = studentService.getStudent(std_id);
//		if(std_id != null){
//			studentVo = studentService.getStudent(std_id);
//		}
		
		BoardServiceInf boardService = new BoardService();
		List<BoardVo> boardList = boardService.getAllBoardList();
		
		ServletContext application = getServletConfig().getServletContext();
		
		// 로그인 성공시 : forward /main.jsp : [main.jsp]
		// 로그인 실패시 : redirect login.jsp
		
		// 로그인 성공시 userVo 객체를 저장하여 (적당한 영역에)
		// main.jsp에서 사용자 아이디를 화면에 출력
		// 단, 새로운 탭에서 main.jsp를 직접 접속해도 사용자 아이디가 화면에 나와야 한다.
		if(studentVo != null && studentVo.validateUser(std_id, password)){		
			HttpSession session = request.getSession();
			
			application.setAttribute("boardList", boardList);
			session.setAttribute("studentVo", studentVo);
			request.getRequestDispatcher("/jsp/main.jsp").forward(request, response);
		}else{
			response.sendRedirect("/login/login.jsp");
//			request.getRequestDispatcher("/login/login.jsp").forward(request, response);
		}
		
	}

}
