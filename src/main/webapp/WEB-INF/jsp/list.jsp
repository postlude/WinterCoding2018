<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- jquery -->
<script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
<!-- bootstrap -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>TODO LIST</title>
</head>
<body>
	<script type="text/javascript">
		$(document).ready(function(){
			// 우선 순위에 맞춰 panel class 추가
			$('.panel').each(function(){
				var priority = $(this).children('input[name=priority]').val();
				
				switch(priority){
					case '3' : {
						$(this).addClass('panel-danger');
						break;
					}
					case '2' : {
						$(this).addClass('panel-info');
						break;
					}
					case '1' : {
						$(this).addClass('panel-default');
						break;
					}
				}
			});
			
			// 삭제 버튼 동작
			$('.btn-danger').click(function(){
				var delete_btn = $(this); 
				var id = delete_btn.siblings('input[name="id"]').val();
				
				$.ajax({
					url: '/remove',
					type: 'POST',
					data: {'id' : id}
				})
				.done(function(){
					console.log('success');
					delete_btn.parent().parent('.panel').remove();
				})
				.fail(function(err){
					console.log(err);
				});
			});
			
			// 마감 날짜 지난 todo 알림
			var now = new Date();
			var passed_deadline = [];
			$('.deadline').each(function(){
				var deadline = new Date($(this).html());
				
				if(now > deadline){
					var title = $(this).parent().parent().siblings('.panel-heading').find('.title').html();
					passed_deadline.push(title);
					$(this).append(' <span style="color:red">마감</span>');
				}
			});
			if(passed_deadline.length !== 0){
				alert('마감 기한이 지난 항목 : ' + passed_deadline);
			}
		});
	</script>
	<div class="container">
		<h1 style="text-align: center">TODO LIST</h1>
		<div class="col-sm-offset-10 btn-group" style="margin-bottom: 20px;">
			<a href="/add" class="btn btn-info">새로운 할 일</a>
			<div class="btn-group">
				<button type="button" class="btn btn-info dropdown-toggle" data-toggle="dropdown">
				정렬 <span class="caret"></span></button>
				<ul class="dropdown-menu" role="menu">
					<li><a href="/list/priority">우선순위</a></li>
					<li><a href="/list/deadline">마감기한</a></li>
				</ul>
			</div>
		</div>
		
		<div class="list-group">
			<c:forEach var="todo" items="${todo_list}">
				<div class="panel">
					<input type="hidden" name="priority" value="${todo.priority}">
					
					<div class="panel-heading">
						<a href="/set/${todo.id}">
							<c:choose>
								<c:when test="${todo.complete eq 'Y'}">
									<del><span class="title">${todo.title}</span>(완료)</del>
								</c:when>
								<c:otherwise>
									<span class="title">${todo.title}</span>
								</c:otherwise>
							</c:choose>
						</a>
						<input type="hidden" name="id" value="${todo.id}">
						<button class="btn btn-danger btn-xs" style="float: right;">삭제</button>
					</div>
					
					<div class="panel-body">
						<p>${todo.content}</p>
						<c:if test="${not empty todo.deadline}">
							<p>
								마감 기한 : <span class="deadline">${todo.deadline}</span>
								
							</p>
						</c:if>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>