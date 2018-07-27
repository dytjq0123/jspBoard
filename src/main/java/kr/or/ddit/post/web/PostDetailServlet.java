package kr.or.ddit.post.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.file.model.AddFileVo;
import kr.or.ddit.file.service.AddFileService;
import kr.or.ddit.file.service.AddFileServiceInf;
import kr.or.ddit.post.model.PostVo;
import kr.or.ddit.post.service.PostService;
import kr.or.ddit.post.service.PostServiceInf;
import kr.or.ddit.recomment.model.RecommentVo;
import kr.or.ddit.recomment.service.RecommentService;
import kr.or.ddit.recomment.service.RecommentServiceInf;

/**
 * Servlet implementation class PostDetialServlet
 */
@WebServlet("/postDetail")
public class PostDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		int post_no = Integer.parseInt(request.getParameter("id"));
		
		
		
		PostServiceInf postService = new PostService();
		PostVo postVo = postService.getPostDetail(post_no);
		
		AddFileServiceInf addfileService = new AddFileService();
		List<AddFileVo> addfileList = addfileService.getAddFileList(post_no);
		
		RecommentServiceInf recService = new RecommentService();
		List<RecommentVo> recList = recService.getRecList(post_no);
		
		request.setAttribute("postVo", postVo);
		
		request.setAttribute("addfileList", addfileList);
		
		request.setAttribute("recList", recList);
		
		request.getRequestDispatcher("/post/postDetail.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
