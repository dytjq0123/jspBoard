package kr.or.ddit.post.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;
import kr.or.ddit.post.model.PostVo;
import kr.or.ddit.post.service.PostService;
import kr.or.ddit.post.service.PostServiceInf;
import kr.or.ddit.student.model.StudentVo;
import kr.or.ddit.student.service.StudentService;
import kr.or.ddit.student.service.StudentServiceInf;

/**
 * Servlet implementation class PostServlet
 */
@WebServlet("/postList")
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		
		int board_no = Integer.parseInt(request.getParameter("id"));
		
		session.setAttribute("board_no", board_no);
		
		String useYn = request.getParameter("useYn");
		
//		if(useYn.equals("n")){
//			HttpSession session = request.getSession();
//			
//			List<BoardVo> boardList = (List<BoardVo>) session.getAttribute("boardList");
//			
//			session.setAttribute("boardList", boardList);
//			
//			
//			request.getRequestDispatcher("/jsp/main.jsp").forward(request, response);
//		}
		
		
		String pageStr = request.getParameter("page");
		int page = pageStr == null ? 1 : Integer.parseInt(pageStr);
		
		String pageSizeStr = request.getParameter("pageSize");
		int pageSize = pageSizeStr == null ? 10 : Integer.parseInt(pageSizeStr);
		
		Map<String, Integer> paramMap =  new HashMap<String, Integer>();
		paramMap.put("page", page);
		paramMap.put("pageSize", pageSize);
		paramMap.put("board_no", board_no);
		
		BoardServiceInf boardService = new BoardService();
		BoardVo boardVo = boardService.getBoardDetail(board_no);
		
		request.setAttribute("boardVo", boardVo);
		PostServiceInf postService = new PostService();
		
		
		
		Map<String, Object> resultMap = postService.getPostPageList(paramMap);
		
		List<PostVo> postList = (List<PostVo>) resultMap.get("pageList");
		request.setAttribute("postList", postList);
		
		String pageNavi = (String) resultMap.get("pageNavi");
		request.setAttribute("pageNavi", pageNavi);
		
		request.getRequestDispatcher("/post/postList.jsp").forward(request, response);
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
