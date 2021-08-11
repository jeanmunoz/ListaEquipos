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
		<form action="./teams" method="post">
			<label for="teamName">Team Name:</label>
			<input type="text" name="teamName" id="firstName">
			<input type="submit" name="submit" value="Create Team">
		</form>
	</body>
</html>