<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="css/styles2.css" rel="stylesheet" type="text/css">
<title>Login</title>
</head>
<body>

	<h2 align="center">Login To Moving Walls</h2>

	<div align="center">
		<table class="table" style="width: 450px">
			<form action="/movingwalls/loginForm" method="post">
				<tr>
					<td>User Name :</td>
					<td><input type="text" name="username" class="form-control"></td>

				</tr>
				<tr>
					<td>Password :</td>
					<td><input type="password" name="password"
						class="form-control"></td>
				</tr>
		</table>
		<p align="center">
			<input type="submit" value="Login" class="btn btn-default">
		</p>
		</form>
	</div>

</body>
</html>