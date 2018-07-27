<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/common/top.jsp" %>
	
	<div class="container-fluid">
		<div class="row">

			<%@ include file="/common/left.jsp" %>
			
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

	
				<form id="frmAnswer" class="form-horizontal" action="/answerPost" method="post" enctype="multipart/form-data">
					<input type="hidden" id="gno" name="gno" value="${postVo.gno }">
					<input type="hidden" id="ea" name="ea">
					<div class="form-group">
						<label for="id" class="col-sm-2 control-label">제목</label>
						<div class="col-sm-6" name="post_title">
							<input type="text" class="form-control" id="post_title" name="post_title">
						</div>
					</div>
					<div class="form-group">
						<label for="id" class="col-sm-2 control-label">내용</label>
						<div class="col-sm-6" name="post_content">
							<textarea name="smarteditor" id="smarteditor" rows="10" cols="100" style="width:740px; height:412px;"></textarea>
						</div>
					</div>
					
					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">첨부 파일</label>
						<div class="col-sm-10" style="width:100px;">
							<div name="addfile" id="addfile">
								<input type="file" name="pic" id="pic">
							</div>
							<input type="button" name="plusfileBtn" id="plusfileBtn" value="+">
							<input type="button" name="minusfileBtn" id="minusfileBtn" value="-">
						</div>
					</div>
					
					<script type="text/javascript">
					
						// 첨부파일 추가/삭제 버튼(editor 소스보다 위에 있어야 함)
						$(function(){
							var a = 1;
							
							$("#ea").val(a);
							
							$("#plusfileBtn").on("click",function(){
								if(a < 5){
									$("#addfile").append("<div id=\"add\"><input type=\"file\" name=\"pic\" id=\"pic\"></div>");
									a++;
									$("#ea").val(a);
								}
							});
							
							$("#minusfileBtn").on("click",function(){
								$("div[id=add]:last").remove();
								a--;
							});
							
						});
						
					
						// editor
						var oEditors = []; // 개발되어 있는 소스에 맞추느라, 전역변수로 사용하였지만, 지역변수로 사용해도 전혀 무관 함.
						
						$(function() {
							// Editor Setting
							nhn.husky.EZCreator.createInIFrame({
								oAppRef : oEditors, // 전역변수 명과 동일해야 함.
								elPlaceHolder : "smarteditor", // 에디터가 그려질 textarea ID 값과 동일 해야 함.
								sSkinURI : "/SE2/SmartEditor2Skin.html", // Editor HTML
								fCreator : "createSEditor2", // SE2BasicCreator.js 메소드명이니 변경 금지 X
								htParams : {
									// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
									bUseToolbar : true,
									// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
									bUseVerticalResizer : true,
									// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
									bUseModeChanger : true, 
								}
							});
						
							// 전송버튼 클릭이벤트
							$("#savebutton").click(function(){
								if(confirm("저장하시겠습니까?")) {
									// id가 smarteditor인 textarea에 에디터에서 대입
									oEditors.getById["smarteditor"].exec("UPDATE_CONTENTS_FIELD", []);
						
									// 이부분에 에디터 validation 검증
									if(validation()) {
										$("#frmAnswer").submit();
									}
								}
							});
						});
						
						// 필수값 Check
						function validation(){
							var contents = $.trim(oEditors[0].getContents());
							if(contents === '<p>&nbsp;</p>' || contents === ''){ // 기본적으로 아무것도 입력하지 않아도 <p>&nbsp;</p> 값이 입력되어 있음. 
								alert("내용을 입력하세요.");
								oEditors.getById['smarteditor'].exec('FOCUS');
								return false;
							}
						
							return true;
						}
						
						
					</script>
					
					
					
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button id="savebutton" type="button" class="btn btn-default">등록</button>
						</div>
					</div>
				</form>
				
				
			</div>
		</div>
	</div>
</body>
</html>
