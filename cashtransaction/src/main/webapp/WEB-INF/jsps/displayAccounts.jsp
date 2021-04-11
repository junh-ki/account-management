<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display Accounts</title>
</head>
<body>
<h2>Your Accounts:</h2>
<table>

<tr>
<th>AccountID</th>
<th>Currency</th>
<th>Balance</th>
<th>HolderID</th>
</tr>

<c:forEach items="${accounts}" var="account">
<tr>
<td>${account.id}</td>
<td>${account.currency}</td>
<td>${account.balance}</td>
<td>${account.holderId}</td>
<td><a href="showTransaction?accountId=${account.id}">Transaction</a></td>
</tr>
</c:forEach>

</table>
</body>
</html>
