<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>New Team</title>
</head>
	<body>

		<c:if test="${teamID != '-1'}">
			<h1>Creating a new player in <c:out value="${roster.getTeam(Integer.parseInt(teamID)).getTeamName() }" /> team</h1>
			<form action="./players" method="post">
				<label for="firstName">First Name:</label>
				<input type="text" name="firstName" id="firstName">
				<label for="lastName">Last Name:</label>
				<input type="text" name="lastName" id="lastName">
				<label for="age">age:</label>
				<input type="text" name="age" id="age">
				<input type="submit" name="submit" value="Create Team">
			</form>
		</c:if>
	</body>
</html>