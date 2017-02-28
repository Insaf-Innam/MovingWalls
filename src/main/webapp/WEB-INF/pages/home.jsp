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
<title>home</title>
</head>
<body>
	<h2 align="center">My Tours</h2>

	<h3 align="center">
		<c:if test="${userType == '2'}">
			<a href="/movingwalls/create" style="margin-right: 25px">New Tour</a>
		</c:if>
		<a href="/movingwalls/logout">Logout</a>
	</h3>

	<table align="center" class="table-bordered"
		style="text-align: center;">
		<tr>
			<td>Description</td>
			<td>Start Date</td>
			<td>End Date</td>
			<td>Mode</td>
			<td>Ticket Cost</td>
			<td>Home city Cab Cost</td>
			<td>Destination City Cab Cost</td>
			<td>Hotel Cost</td>
			<td>Manager/Employee</td>
			<td>Finance Approval</td>
			<td>Approval Status</td>
			<td>change status</td>
		</tr>
		<c:forEach items="${toursList}" var="item">
			<c:if test="${userType == '3'}">
				<!-- Manager = 3-->
				<c:if test="${item.approvalstatus.id != '1'}">
					<!-- Draft = 1 -->
					<!--<c:out value="${item.approvalstatus.id}"></c:out>-->
					<tr>
						<td><c:out value="${item.description}"></c:out></td>
						<td><c:out value="${item.startDate}"></c:out></td>
						<td><c:out value="${item.endDate}"></c:out></td>
						<td><c:out value="${item.mode}"></c:out></td>
						<td><c:out value="${item.ticketCost}"></c:out></td>
						<td><c:out value="${item.homeCityCabCost}"></c:out></td>
						<td><c:out value="${item.destinationCityCabCost}"></c:out></td>
						<td><c:out value="${item.hotelCost}"></c:out></td>
						<td><c:out value="${item.managerUserName}"></c:out></td>
						<td><c:out value="${item.financeApproval}"></c:out></td>
						<td><c:if test="${item.approvalstatus.id == '2'}">
								Submitted
							</c:if> <c:if test="${item.approvalstatus.id == '3'}">
								Approved
							</c:if> <c:if test="${item.approvalstatus.id == '4'}">
								Rejected
							</c:if> <c:if test="${item.approvalstatus.id == '5'}">
								Request for information
							</c:if></td>
						<td>
							<form action="/movingwalls/changeStatus" method="post">
								<input type="hidden" value="${item.id}" name="tourId"> <select
									name="approvalstatus">
									<option value="3">Approve</option>
									<option value="4">Reject</option>
									<option value="5">Request for more information</option>
								</select> <input type="submit" value="change" class="btn btn-default">
							</form>

							<form action="/movingwalls/sendToFinance" method="post">
								<select name="managerUserName">
									<c:forEach items="${getAllFinanceManagers}" var="item2">
										<option value="${item2.userName}">${item2.userName}</option>
									</c:forEach>
								</select> <input type="hidden" value="${item.id}" name="tourId">
								<input type="hidden" value="submit" name="approvalstatus">
								<input type="submit" value="submit to finance"
									class="btn btn-default">
							</form>
						</td>
					</tr>
				</c:if>
			</c:if>

			<c:if test="${userType == '2'}">
				<!-- Employee = 2-->
				<tr>
					<form action="/movingwalls/checking" method="post">
						<td><c:if test="${item.approvalstatus.id == '1'}">
								<input type="text" value="${item.description}"
									name="description" class="form-control">
							</c:if> <c:if test="${item.approvalstatus.id != '1'}">
								<c:out value="${item.description}"></c:out>
							</c:if></td>
						<td><c:if test="${item.approvalstatus.id == '1'}">
								<input type="date" value="${item.startDate}" name="startDate"
									class="form-control">
							</c:if> <c:if test="${item.approvalstatus.id != '1'}">
								<c:out value="${item.startDate}"></c:out>
							</c:if></td>
						<td><c:if test="${item.approvalstatus.id == '1'}">
								<input type="date" value="${item.endDate}" name="endDate"
									class="form-control">
							</c:if> <c:if test="${item.approvalstatus.id != '1'}">
								<c:out value="${item.endDate}"></c:out>
							</c:if></td>
						<td><c:if test="${item.approvalstatus.id == '1'}">
								<input type="text" value="${item.mode}" name="mode"
									class="form-control">
							</c:if> <c:if test="${item.approvalstatus.id != '1'}">
								<c:out value="${item.mode}"></c:out>
							</c:if></td>
						<td><c:if test="${item.approvalstatus.id == '1'}">
								<input type="number" value="${item.ticketCost}"
									name="ticketCost" class="form-control">
							</c:if> <c:if test="${item.approvalstatus.id != '1'}">
								<c:out value="${item.ticketCost}"></c:out>
							</c:if></td>
						<td><c:if test="${item.approvalstatus.id == '1'}">
								<input type="number" value="${item.homeCityCabCost}"
									name="homeCityCabCost" class="form-control">
							</c:if> <c:if test="${item.approvalstatus.id != '1'}">
								<c:out value="${item.homeCityCabCost}"></c:out>
							</c:if></td>
						<td><c:if test="${item.approvalstatus.id == '1'}">
								<input type="number" value="${item.destinationCityCabCost}"
									name="destinationCityCabCost" class="form-control">
								<input type="hidden" value="${item.id}" name="tourId">
							</c:if> <c:if test="${item.approvalstatus.id != '1'}">
								<c:out value="${item.destinationCityCabCost}"></c:out>
							</c:if></td>
						<td><c:if test="${item.approvalstatus.id == '1'}">
								<input type="number" value="${item.hotelCost}" name="hotelCost"
									class="form-control">
							</c:if> <c:if test="${item.approvalstatus.id != '1'}">
								<c:out value="${item.hotelCost}"></c:out>
							</c:if></td>
						<td><c:if test="${item.approvalstatus.id == '1'}">

								<!-- 									item.managerUserName -->
								<select name="managerUserName" class="form-control">
									<c:forEach items="${managerList}" var="item2">
										<option value="${item2.name}" selected="selected">${item2.name}</option>
									</c:forEach>
								</select>
							           manager - ${item.managerUserName}
							</c:if> <c:if test="${item.approvalstatus.id != '1'}">
								<c:out value="${item.managerUserName}"></c:out>
							</c:if></td>
						<td><c:if test="${item.approvalstatus.id == '1'}">
								<c:out value="${item.financeApproval}"></c:out>
								<input type="hidden" value="${item.financeApproval}"
									name="financeApproval" class="form-control">
							</c:if> <c:if test="${item.approvalstatus.id != '1'}">
								<c:out value="${item.financeApproval}"></c:out>
							</c:if></td>

						<td><c:if test="${item.approvalstatus.id == '1'}">
						
								Draft
								<input type="submit" value="Update Draft"
									class="btn btn-default">
					</form>
			</c:if>
			<c:if test="${item.approvalstatus.id == '2'}">
								Submit
							</c:if>
			<c:if test="${item.approvalstatus.id == '3'}">
								Approved
							</c:if>
			<c:if test="${item.approvalstatus.id == '4'}">
								Rejected
							</c:if>
			<c:if test="${item.approvalstatus.id == '5'}">
								Request for more information
							</c:if>
			</td>
			<td>
				<form action="/movingwalls/changeStatus" method="post">
					<input type="hidden" value="${item.id}" name="tourId"> <select
						name="approvalstatus" class="form-control">

						<c:if test="${item.approvalstatus.id == '1'}">
							<option value="1">Draft</option>
							<option value="3">Submitted</option>
							<input type="submit" value="change" class="btn btn-default">
						</c:if>

						<c:if test="${item.approvalstatus.id != '1'}">
							<option value="2" disabled="disabled" selected="selected">Submitted</option>
						</c:if>
					</select>
				</form>
			</td>
			</tr>
			</c:if>
		</c:forEach>
	</table>

</body>
</html>
