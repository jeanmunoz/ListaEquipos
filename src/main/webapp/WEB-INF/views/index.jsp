<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>Teams Roster</h1>
		<span>Total Teams: <c:out value="${roster.getNumberOfTeams()}" /> - </span>
		<a href="./teams">New Team</a>
	<table>
		<tr>
			<th>Team</th>
			<th>Players</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${roster.getTeamsList()}" var="team" varStatus="loop">
			<tr>
				<td>${team.getTeamName()}</td>
				<td>${team.getNumberOfPlayers()}</td>
				<td><a href="./teams?id=${loop.index}">Details</a> | <a href="./deleteTeam?id=${loop.index}">Delete</a> </td>
			</tr>
		</c:forEach>
	</table> 
	</body>
</html>