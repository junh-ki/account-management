<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Home</title>
</head>
<body>
<h2>Welcome ${user.firstName}!</h2>
<input type="hidden" name="userId" value="${user.id}">
Click here to create a new account - <a href="showCreate">Create</a><br/>
Click here to display your accounts - <a href="displayAccs">Display</a>
</body>
</html>