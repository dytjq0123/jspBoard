package kr.or.ddit.recomment.web;

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
import kr.or.ddit.student.model.StudentVo;

/**
 * Servlet implementation class RecommentServlet
 */
@WebServlet("/rec")
public class RecommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("postpostpostpost");
		HttpSession session = request.getSession();
		
		int post_no = Integer.parseInt(request.getParameter("post_no"));
		System.out.println(post_no);
		System.out.println(request.getParameter("rec_no"));
		
		int rec_no = Integer.parseInt(request.getParameter("rec_no"));
		System.out.println(rec_no);
		int cnt = 0;
		
		RecommentServiceInf recService = new RecommentService();
		cnt = recService.deleteRec(rec_no);
		
		if(cnt > 0){
			System.out.println("recDelete 성공");
		}else{
			System.out.println("recDelete 실패");
		}
		
		PostServiceInf postService = new PostService();
		PostVo postVo = postService.getPostDetail(post_no);
		
		AddFileServiceInf addfileService = new AddFileService();
		List<AddFileVo> addfileList = addfileService.getAddFileList(post_no);
		
		List<RecommentVo> recList = recService.getRecList(post_no);
		
		request.setAttribute("postVo", postVo);
		
		request.setAttribute("addfileList", addfileList);
		
		request.setAttribute("recList", recList);
		
		request.getRequestDispatcher("/post/postDetail.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		response.setContentType("text/html; charset=utf-8");
		
		
		int post_no = Integer.parseInt(request.getParameter("post_no"));
		System.out.println(post_no);
		String rec_content = request.getParameter("rec");
		System.out.println(rec_content);
		HttpSession session = request.getSession();
		
		StudentVo studentVo = (StudentVo) session.getAttribute("studentVo");
		
		int id = studentVo.getId();
		System.out.println(id);
		RecommentVo recVo = new RecommentVo();
		
		recVo.setId(id);
		recVo.setPost_no(post_no);
		recVo.setRec_content(rec_content);
		recVo.setDelYn("n");
		
		int cnt = 0;
		
		RecommentServiceInf recService = new RecommentService();
		cnt = recService.insertRec(recVo);
		
		if(cnt > 0){
			System.out.println("recinsert 성공");
		}else{
			System.out.println("recinsert 실패");
		}
		
		PostServiceInf postService = new PostService();
		PostVo postVo = postService.getPostDetail(post_no);
		
		AddFileServiceInf addfileService = new AddFileService();
		List<AddFileVo> addfileList = addfileService.getAddFileList(post_no);
		
		List<RecommentVo> recList = recService.getRecList(post_no);
		
		request.setAttribute("postVo", postVo);
		
		request.setAttribute("addfileList", addfileList);
		
		request.setAttribute("recList", recList);
		
		request.getRequestDispatcher("/post/postDetail.jsp").forward(request, response);
		
	}

}
