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
<title></title>
</head>
<body>
	<script type="text/javascript">
		$(document).ready(function(){
			$('.btn-danger').click(function(){
				var id = $(this).parent().children('input[name="id"]').val();
				console.log(id);
				
				$.ajax({
					url: '/remove',
					type: 'POST',
					data: {'id' : id}
				})
				.done(function(){
					console.log('success');
				})
				.fail(function(err){
					console.log(err);
				});
			});
		});
	</script>
	<div class="container">
		<c:forEach var="todo" items="${todo_list}">
			<div>
				${todo.title}<br>
				${todo.content}<br>
				${todo.deadline}<br>
				${todo.complete}<br>
				${todo.priority}<br>
				<input type="hidden" name="id" value="${todo.id}">
				<button class="btn btn-danger">삭제</button>
			</div>
		</c:forEach>
	</div>
</body>
</html>