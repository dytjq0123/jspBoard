<%@page import="kr.or.ddit.board.model.BoardVo"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.student.model.StudentVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ include file="/common/top.jsp" %>

<form action="/postDetail" method="get" id="frm0">
	<input type="hidden" name="id" id="id">
</form>

<div class="container-fluid">
		<div class="row">
			
<%@ include file="/common/left.jsp" %>
<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				

<div class="row">
	<div class="col-sm-8 blog-main">
<%-- 	<% BoardVo boardVo = (BoardVo)request.getAttribute("boardVo"); %> --%>
		<h2 class="sub-header">${boardVo.board_name }</h2>
		<div class="table-responsive">
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th>게시글 번호</th>
						<th>제목</th>
						<th>작성자 아이디</th>
						<th>작성일시</th>
					</tr>
				</thead>
				<tbody>
				<% request.setAttribute("nbsp", " "); %>
					<%int a = 1; %>
					<c:forEach items="${postList }" var="vo">
					<%-- tr 태그 클릭시 상세 페이지로 이동 --%>
						<c:choose>
							<c:when test="${vo.delYn == 'n' }">
								<tr data-id="${vo.post_no }" data-id2="${vo.delYn }">
									<td>${vo.rn }</td>
									<td>${fn:replace(vo.post_title, nbsp, '&nbsp&nbsp;')}</td>
									<td>${vo.std_id }</td>
									<td><fmt:formatDate value="${vo.post_date }" pattern="yyyy-MM-dd"/> </td>
								</tr>
							</c:when>
							<c:when test="${vo.delYn == 'y' }">
								<tr>
									<td>${vo.rn }</td>
									<td>${fn:replace('삭제된 게시글 입니다.', nbsp, '&nbsp&nbsp&nbsp;')}</td>
									<td></td>
									<td></td>
								</tr>
							</c:when>
						</c:choose>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<form action="/insertPost" method="get">
			<button type="submit" class="btn btn-default pull-right" id="insert" name="insert" value="${boardVo.board_no }">새글 등록</button>
		</form>
		<div class="text-center">
			<ul class="pagination">
				<%=request.getAttribute("pageNavi") %>
			</ul>
		</div>
	</div>
</div>
	</div>
		</div>
	</div>
</body>
</html>
	