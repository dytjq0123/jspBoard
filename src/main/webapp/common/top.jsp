<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">

<title>Jsp</title>

<!-- jQuery -->
<!-- <script type="text/javascript" src="/js/jquery.js"></script>
<script type="text/javascript" src="/js/jquery-ui.min.js"></script>-->

<!-- <script type="text/javascript" src="/js/jquery/jquery-3.2.1.js"></script> -->
<script type="text/javascript" src="/js/jquery-1.12.4.js"></script>


<script src="/SE2/js/HuskyEZCreator.js"></script>

<!-- <script src="/js/jquery-1.12.4.js"></script> -->
<link href="/bootstrap/css/bootstrap.css" rel="stylesheet">
<!-- Bootstrap core CSS -->
<script src="/bootstrap/js/bootstrap.js"></script>
<!-- Custom styles for this template -->
<link href="/css/dashboard.css" rel="stylesheet">
<link href="/css/blog.css" rel="stylesheet">
<link href="/css/common.css" rel="stylesheet">


<script>
$(function(){
	$("table tbody tr").on("click", function(){
		//tr태그의 data-id 속성 값을 읽어서 input 태그의 id 값으로 설정
		//form 태그를 submit
		if($(this).data("id2") == 'n'){
			$("#id").val($(this).data("id"));
			$("#frm0").submit();
		}
		
	});
	
	
	
	$("#update").on("click", function(){
		$("#upd").val($(this).data("upd"));
		$("#frmUpdate").submit();
	});
	
	$("#delete").on("click", function(){
		alert("삭제하시겠습니까?");
		$("#del").val($(this).data("del"));
		$("#frmDelete").submit();
	});
	
	$("#answer").on("click", function(){
		$("#ans").val($(this).data("ans"));
		$("#frmAnswer").submit();
	});
	
	
});

</script>








</head>

<body>   
<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> 
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">JSP/SPRING 			
			<c:if test="${studentVo != null }">
				[${studentVo.std_id }]
			</c:if>
			</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#">Dashboard</a></li>
				<li><a href="#">Settings</a></li>
				<li><a href="#">Profile</a></li>
				<li><a href="#">Help</a></li>
				<li><a href="/logout">Logout</a></li>
			</ul>
			<form class="navbar-form navbar-right">
				<input type="text" class="form-control" placeholder="Search...">
			</form>
		</div>
	</div>
</nav>