<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<title>Tour Form</title>
</head>
<body>
	<h2 align="center">Tour Form</h2>
	<h2 align="center">
		<a href="/movingwalls/viewAll">view all my tours</a>
	</h2>
	<div align="center">
		<form action="/movingwalls/submit" method="post">
			<table class="table-bordered">
				<tr>
					<td>description:</td>
					<td><input type="text" name="description" class="form-control"></td>
				</tr>

				<tr>
					<td>start date :</td>
					<td><input type="date" name="startDate" class="form-control"></td>
				</tr>

				<tr>
					<td>end date:</td>
					<td><input type="date" name="endDate" class="form-control"></td>
				</tr>

				<tr>
					<td>mode :</td>
					<td><input type="text" name="mode" class="form-control"></td>
				</tr>

				<tr>
					<td>ticket cost:</td>
					<td><input type="number" name="ticketCost"
						class="form-control" min="0"></td>
				</tr>

				<tr>
					<td>home city cab cost:</td>
					<td><input type="number" name="homeCityCabCost"
						class="form-control" min="0"></td>
				</tr>

				<tr>
					<td>destination city cab cost :</td>
					<td><input type="number" name="destinationCityCabCost"
						class="form-control" min="0"></td>
				</tr>

				<tr>
					<td>hotel cost:</td>
					<td><input type="number" name="hotelCost" class="form-control"
						min="0"></td>
				</tr>

				<tr>
					<td>manager user name :</td>
					<td><select name="managerUserName" class="form-control">
							<c:forEach items="${managerList}" var="item">
								<option value="${item.name}">${item.name}</option>
							</c:forEach>
					</select></td>
				</tr>

				<tr>
					<td></td>
					<td></td>
				</tr>

				<tr>
					<td><input type="hidden" name="financeApproval" value="submit"
						class="btn btn-default"> status</td>
					<td><select name="status" class="form-control">
							<option value="draft">draft</option>
							<option value="submit">submit</option>
					</select></td>
				</tr>

			</table>
			<br /> <input type="submit" value="save" class="btn btn-default">
		</form>
	</div>
</body>
</html>