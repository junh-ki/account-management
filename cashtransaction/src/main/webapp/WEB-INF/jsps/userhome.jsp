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

<form action="displayAccs" method="post"/>
<pre>
Click here to display your accounts
<input type="hidden" name="holderId" value="${user.id}"/>
<input type="submit" value="Display"/>

</body>
</html>