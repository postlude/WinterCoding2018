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
<title>NEW TODO</title>
</head>
<body>
	<div class="container">
		<h2>NEW TODO</h2>
		<form class="form-horizontal" method="post">
			<div class="form-group">
      			<label class="col-sm-2 control-label">Title</label>
      			<div class="col-sm-10">
      				<input type="text" class="form-control" name="title" value="${todo.title}" required>
      			</div>
    		</div>
			<div class="form-group">
      			<label class="col-sm-2 control-label">Content</label>
      			<div class="col-sm-10">
      				<input type="text" class="form-control" name="content" value="${todo.content}" required>
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