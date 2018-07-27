<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="col-sm-3 col-md-2 sidebar">
	<ul class="nav nav-sidebar nav-hover">
		<li class="active"><a href="/jsp/main.jsp">Main <span class="sr-only">(current)</span></a></li>
		<li id="selectedBoard" name="selectedBoard"><a href="/boardManagement">게시판 관리 <span class="sr-only">(current)</span></a></li>
		<c:forEach items="${boardList }" var="boardVo"> 
			<c:if test="${boardVo.useYn == 'y' }"><li id="selectedBoard" name="selectedBoard" class="class"><a href="/postList?id=${boardVo.board_no }&useYn=${boardVo.useYn}">${boardVo.board_name } </a></li></c:if>
		</c:forEach>
	</ul>
</div>
