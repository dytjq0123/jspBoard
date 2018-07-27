<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 


<form action="/updatePost" method="get" id="frmUpdate">
	<input type="hidden" name="upd" id="upd">
	<input type="hidden" name="post_no" value="${postVo.post_no }">
</form>
<form action="/deletePost" method="get" id="frmDelete">
	<input type="hidden" name="del" id="del">
	<input type="hidden" name="post_no" value="${postVo.post_no }">
</form>
<form action="/answerPost" method="get" id="frmAnswer">
	<input type="hidden" name="ans" id="ans">
	<input type="hidden" name="post_no" value="${postVo.post_no }">
</form>

	
<%@ include file="/common/top.jsp" %>

<div class="container-fluid">
	<div class="row">

		<%@ include file="/common/left.jsp"%>

		<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">


			<div class="form-horizontal col-sm-6">

				<input type="hidden" name="id" value="${postVo.post_no }">

				<div class="form-group">
					<label for="post_title" class="col-sm-2 control-label">제목</label>
					<div class="col-sm-10">
						<label class="control-label" id="post_title" name="post_title">${postVo.post_title }</label>
					</div>
				</div>
				<div class="form-group">
					<label for="post_content" class="col-sm-2 control-label">내용</label>
					<div class="col-sm-10">
						<label class="control-label" id="post_content" name="post_content">${postVo.post_content }</label>
					</div>
				</div>

				<div class="form-group">
					<label for="name" class="col-sm-2 control-label">첨부 파일</label>
					<div class="col-sm-10">
						<c:if test="${addfileList != null }">
							<c:forEach items="${addfileList }" var="vo">
								<a
									href="/fileDownload?file_no=${vo.file_no }&file_name=${vo.file_name }">${vo.file_name }</a>
								<br>
							</c:forEach>
						</c:if>
					</div>
					<div class="pull-right">
						<input type="button" value="수정" id="update"
							data-upd="${postVo.post_no }" name="update"
							class="btn btn-default">
						<c:if test="${postVo.id == studentVo.id }">
							<input type="button" value="삭제" id="delete"
								data-del="${postVo.post_no }" name="delete"
								class="btn btn-default">
						</c:if>
						<input type="button" value="답글" id="answer"
							data-ans="${postVo.post_no }" name="answer"
							class="btn btn-default">
					</div>
				</div>


				<div class="form-group">
					<ul class="no-pad list-disc">
						<c:forEach items="${recList }" var="vo">
							<li>
							<c:choose>
								<c:when test="${vo.delYn == 'n'}">
									${vo.rec_content} [ ${vo.std_id} / <fmt:formatDate value="${vo.rec_date }" pattern="yyyy-MM-dd" /> ]
									<!-- delete btn -->
									<c:if test="${vo.id == studentVo.id }">
										<button type="button" class="del" id="deleteBtn" data-name="${vo.rec_no }">삭제</button>
									</c:if>
								</c:when>
								<c:otherwise>
									<span class="disabled">삭제된 댓글입니다.</span>
								</c:otherwise>
							</c:choose>
							</li>
						</c:forEach>
					</ul>
				</div>
				
					<div class="form-group pull-right">
						<form id="frmRec" action="/rec" method="post">
							<input type="hidden" name="post_no" value="${postVo.post_no }">
							<input type="hidden" name="id" value="${studentVo.id }"> <span id="recList"> 
							<input type="text" name="rec" id="rec" maxlength="500" style="width: 600">
							</span> <input type="button" value="댓글저장" class="btn btn-default"
								id="recSave"><br>
						</form>
					</div>	

			</div>
		</div>


	</div>



	<script type="text/javascript">
		$(function(){
			$("#recSave").on("click", function(){
				$("#recList").append("<br><input type=\"text\" name=\"rec\" id=\"rec\">");
				$("#frmRec").submit();
			});
			
		});
				
	</script>

	<!-- 댓글 삭제 //-->
	<form id="delRec" action="/rec" method="get">
		<input type="hidden" name="post_no" id="post_no" value="${postVo.post_no }"> 
		<input type="hidden" id="rec_no_in" name="rec_no">
	</form>
	<!--// 댓글 삭제 -->
</div>
	<script type="text/javascript">
		$(function(){
			$(".del").on("click", function(){
				$("#rec_no_in").val($(this).data("name"));
				$("#delRec").submit();
			});
		});
	</script>
</body>
</html>
