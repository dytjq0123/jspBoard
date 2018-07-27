<%@page import="kr.or.ddit.board.model.BoardVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


	<!-- top.jsp -->

	<%@ include file="/common/top.jsp"%>

	<div class="container-fluid">
		<div class="row">

			<!--  left.jsp -->
			<%@ include file="/common/left.jsp" %>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">


				<div class="blog-header">
					<h1 class="blog-title">게시판 관리</h1>
				</div>

				<div class="row">

					<div class="col-sm-8 blog-main">

						<div class="blog-post">

							<hr>
							<form action="/insertBoard" method="post" id="frm">
<%-- 							<% List<BoardVo> boardList = (List<BoardVo>)application.getAttribute("boardList"); %> --%>
								<div>게시판 이름 
									<input type="text" id="title" name="title">
										<select id="select" name="select">
											<option value="y">사용</option>
											<option value="n">미사용</option>
										</select>
										<input type="submit" value="생성">
								</div>
							</form>
								<br>
							<c:forEach items="${boardList }" var="boardVo"> 
								<form action="/updateBoard" method="post" id="frm">
								<div>게시판 이름 
									<input type="text" value="${boardVo.board_name }" id="title" name="title">
									<input type="hidden" value="${boardVo.board_no }" id="num" name="num">
										<select id="select" name="select">
											<option ${boardVo.useYn == 'y' ? "selected" : '' } value="y">사용</option>
											<option ${boardVo.useYn == 'n' ? "selected" : '' } value="n">미사용</option>
										</select>
										<input type="submit" value="수정">
								
								</div>
								<br>
								</form>
							</c:forEach>
							
							
						</div>
					</div>
					<!-- /.blog-main -->
				</div>
			</div>
		</div>
	</div>
</body>
</html>
