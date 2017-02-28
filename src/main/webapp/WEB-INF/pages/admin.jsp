<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="css/styles2.css" rel="stylesheet" type="text/css">
<title>Finance</title>
</head>
<body>
	<h2 align="center">Finance My Tours</h2>

	<table align="center" class="table-bordered">
		<tr>
			<td>Description</td>
			<td>Start Date</td>
			<td>End Date</td>
			<td>Mode</td>
			<td>Ticket Cost</td>
			<td>Home city Cab Cost</td>
			<td>Destination City Cab Cost</td>
			<td>Hotel Cost</td>
			<td>Manager</td>
			<td>Finance Approval</td>
			<td>change status</td>
		</tr>
		<c:forEach items="${financeList}" var="item">
			<c:if test="${item.approvalstatus.id != '1'}">
				<!-- Draft = 1 -->
				<!--<c:out value="${item.approvalstatus.id}"></c:out>-->
				<tr>
					<td><c:out value="${item.tours.description}"></c:out></td>
					<td><c:out value="${item.tours.startDate}"></c:out></td>
					<td><c:out value="${item.tours.endDate}"></c:out></td>
					<td><c:out value="${item.tours.mode}"></c:out></td>
					<td><c:out value="${item.tours.ticketCost}"></c:out></td>
					<td><c:out value="${item.tours.homeCityCabCost}"></c:out></td>
					<td><c:out value="${item.tours.destinationCityCabCost}"></c:out></td>
					<td><c:out value="${item.tours.hotelCost}"></c:out></td>
					<td><c:out value="${item.tours.managerUserName}"></c:out></td>


					<td><c:out value="${item.tours.financeApproval}"></c:out></td>

					<td>
						<form action="/movingwalls/financeStatus" method="post">
							<input type="hidden" value="${item.tours.id}" name="tourId">
							<select name="approvalstatus">
								<option value="2">Submit</option>
								<option value="3">Approve</option>
								<option value="4">Reject</option>
								<option value="5">Request for more information</option>
							</select> <input type="submit" value="change" class="btn btn-default">
						</form>
					</td>
				</tr>
			</c:if>
		</c:forEach>
	</table>
	<h2 align="center">
		<a href="/movingwalls/logout">logout</a>
	</h2>
</body>
</html>