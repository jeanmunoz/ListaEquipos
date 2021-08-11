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
	
		<h1><c:out value="${roster.getTeam(Integer.parseInt(teamID)).getTeamName() }" /></h1>
		<a href="./players">Create Player</a>
		++ <c:out value="${teamID }"/> ++ 
		<table>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Age</th>
				<th>Actions</th>
			</tr>
			<c:forEach items="${roster.getTeam(Integer.parseInt(teamID)).getPlayerList()}" var="player" varStatus="loop">
			<tr>
				<td>${player.getFirstName()}</td>
				<td>${player.getLastName()}</td>
				<td>${player.getAge()}</td>
				<td><a href="./deletePlayer?teamID=${loop.index}&playerID=${teamID}">Delete</a> </td>
			</tr>
			</c:forEach>
		</table>
		<a href="./home">back home...</a>
	</body>
</html>