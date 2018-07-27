package kr.or.ddit.post.web;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import kr.or.ddit.file.model.AddFileVo;
import kr.or.ddit.file.service.AddFileService;
import kr.or.ddit.file.service.AddFileServiceInf;
import kr.or.ddit.file.web.FileUtil;
import kr.or.ddit.post.model.PostVo;
import kr.or.ddit.post.service.PostService;
import kr.or.ddit.post.service.PostServiceInf;
import kr.or.ddit.recomment.model.RecommentVo;
import kr.or.ddit.recomment.service.RecommentService;
import kr.or.ddit.recomment.service.RecommentServiceInf;
import kr.or.ddit.student.model.StudentVo;
import kr.or.ddit.student.service.StudentService;
import kr.or.ddit.student.service.StudentServiceInf;

/**
 * Servlet implementation class UpdatePostServlet
 */
@WebServlet("/updatePost")
@MultipartConfig(maxFileSize=1024*1000*3, maxRequestSize=1024*1000*15)
public class UpdatePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		
		int post_no = Integer.parseInt(request.getParameter("upd"));
		
		PostServiceInf postService = new PostService();
		PostVo postVo = postService.getPostDetail(post_no);
		
		AddFileServiceInf addfileService = new AddFileService();
		List<AddFileVo> addfileList = addfileService.getAddFileList(post_no);
		
		request.setAttribute("addfileList", addfileList);
		
		request.setAttribute("postVo", postVo);
		
		request.getRequestDispatcher("/post/postUpdate.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		response.setContentType("text/html; charset=utf-8");
		
		
		HttpSession session = request.getSession();
		
		int board_no = (int) session.getAttribute("board_no");
		
		StudentVo studentVo = (StudentVo) session.getAttribute("studentVo");	
		
		int post_no = Integer.parseInt(request.getParameter("post_no"));
		
		String post_title = request.getParameter("post_title");
		System.out.println(post_title);
		
		String post_content = request.getParameter("smarteditor");
		System.out.println(post_content);
		
		PostServiceInf postService = new PostService();
		PostVo postVo = postService.getPostDetail(post_no);
		
		postVo.setPost_no(post_no);
		postVo.setPost_title(post_title);
		postVo.setPost_content(post_content);
		
		
		int cnt = 0;
		
		cnt = postService.updatePost(postVo);
		
		
		int ea0 = Integer.parseInt(request.getParameter("ea0"));
		
		int ea = request.getParameter("ea") == null ? ea0 : Integer.parseInt(request.getParameter("ea"));
		System.out.println("ea=="+ea);
		
		Collection<Part> parts = request.getParts();
		
		
		if(cnt > 0){
			System.out.println("update 성공");
			
			AddFileVo addfileVo = new AddFileVo();
			AddFileServiceInf addfileService = new AddFileService();
			int cnt2 = 0;
			
//			List<Part> fileList = new ArrayList<Part>();
			for(Part part : parts){
//				fileList.add(request.getPart("pic"+i));
				if(part.getSize() > 0){
					String contentDisposition = part.getHeader("Content-Disposition");
					String file_name = FileUtil.getFileName(contentDisposition);
					if(!file_name.equals("")){
						
						System.out.println("fileName ===" + file_name);
						String file_path = FileUtil.fileUploadPath;
						System.out.println("filePath ===" + file_path);
						String file_upload = UUID.randomUUID().toString();
						System.out.println("fileUPload ===" + file_upload);
						
						addfileVo.setPost_no(post_no);
						addfileVo.setFile_upload(file_upload);
						addfileVo.setFile_path(file_path);
						addfileVo.setFile_name(file_name);
						
						part.write(file_path + File.separator + file_name);
						part.delete();
						
						
						cnt2 = addfileService.insertAddFile(addfileVo);
						
						if(cnt2 > 0){
							System.out.println("fileInsert 성공");
						}else{
							System.out.println("fileInsert 실패");
						}
					}
					
				}
			}
			
			List<AddFileVo> addfileList = addfileService.getAddFileList(post_no);
		
			RecommentServiceInf recService = new RecommentService();
			List<RecommentVo> recList = recService.getRecList(post_no);
			
			request.setAttribute("postVo", postVo);
			
			request.setAttribute("addfileList", addfileList);
		
			request.setAttribute("recList", recList);
			
			response.sendRedirect("/postDetail?id=" + post_no);
			
		}else{
			System.out.println("update 실패");
			response.sendRedirect("/postInsert.jsp=" + post_no);
		}
		
		
		
		
		
		
		
		
		
		
		
	}

}
