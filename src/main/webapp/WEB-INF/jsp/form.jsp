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
<title>TODO</title>
<style type="text/css">
	.checkbox{
		padding-left: 35px;
	}
</style>
</head>
<body>
	<script type="text/javascript">
		$(document).ready(function(){
			// 완료 체크박스 체크
			var complete_check = $('#complete_check');
			if('${todo.complete}' === 'Y'){
				complete_check.attr('checked', true);
				$('#complete').val('Y');
			}else{
				complete_check.attr('checked', false);
				$('#complete').val('N');
			}
			
			// 완료 체크박스 클릭시 동작
			complete_check.click(function(){
				if(complete_check.is(":checked")){
					$('#complete').val('Y');
				}else{
					$('#complete').val('N');
				}
			});
			
			// 우선순위 체크
			var priority_select_option = $('#priority option');
			priority_select_option.each(function(){
				if($(this).val() === '${todo.priority}'){
					$(this).attr('selected', true);
				}
			});
		});
	</script>
	<div class="container">
		<h1 style="text-align: center">TODO</h1>
		<form class="form-horizontal" method="post">
			<div class="form-group">
      			<label class="col-sm-2 control-label">제목</label>
      			<div class="col-sm-10">
      				<input type="text" class="form-control" name="title" value="${todo.title}" required>
      			</div>
    		</div>
    		
			<div class="form-group">
      			<label class="col-sm-2 control-label">내용</label>
      			<div class="col-sm-10">
      				<input type="text" class="form-control" name="content" value="${todo.content}" required>
      			</div>
    		</div>
    		
			<div class="form-group">
      			<label class="col-sm-2 control-label">마감기한</label>
      			<div class="col-sm-10">
      				<input type="date" class="form-control" name="deadline" value="${todo.deadline}">
      			</div>
    		</div>
    		
    		<div class="form-group">
    			<label class="col-sm-2 control-label" for="priority">우선순위</label>
    			<div class="col-sm-10 ">
					<select class="form-control" name="priority" id="priority">
						<option value="3">상</option>
						<option value="2">중</option>
						<option value="1">하</option>
					</select>
				</div>
    		</div>
    		
			<div class="form-group">
      			<label class="col-sm-2 control-label">완료여부</label>
      			<div class="col-sm-10 checkbox">
      				<input type="checkbox" id="complete_check">
      				<input type="hidden" name="complete" value="${todo.complete}" id="complete">
      			</div>
    		</div>
    		
    		<div class="form-group">        
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default btn-block">Submit</button>
				</div>
		    </div>
		</form>
	</div>
</body>
</html>