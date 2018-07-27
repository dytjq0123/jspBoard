package kr.or.ddit.board.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;
import kr.or.ddit.student.model.StudentVo;

/**
 * Servlet implementation class UpdateBoardServlet
 */
@WebServlet("/updateBoard")
public class UpdateBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		response.setContentType("text/html; charset=utf-8");
		
		HttpSession session = request.getSession();
		
		String board_name = request.getParameter("title");
		System.out.println("board_name"+board_name);
		int board_no = Integer.parseInt(request.getParameter("num"));
		System.out.println(board_no);
		String useYn = request.getParameter("select");
		System.out.println("useYn"+useYn);
		StudentVo studentVo = (StudentVo) session.getAttribute("studentVo");
		int id = studentVo.getId();
		System.out.println("id"+id);
		
		BoardVo boardVo = new BoardVo();
		boardVo.setBoard_name(board_name);
		boardVo.setUseYn(useYn);
		boardVo.setId(id);
		boardVo.setBoard_no(board_no);
		
		int cnt = 0;
		
		BoardServiceInf boardService = new BoardService();
		cnt = boardService.updateBoard(boardVo);
		System.out.println(cnt+"cnt");
		if(cnt > 0){
			System.out.println("성공");
		}else{
			System.out.println("실패");
		}
		
		List<BoardVo> boardList = boardService.getAllBoardList();
		
		ServletContext application = getServletConfig().getServletContext();
		
		application.setAttribute("boardList", boardList);
		
		response.sendRedirect("/board/boardManagement.jsp");
//		request.getRequestDispatcher("/board/boardManagement.jsp").forward(request, response);
	}

}
