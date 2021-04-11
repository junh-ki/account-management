<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Complete Deposit</title>
</head>
<body>
<pre>
<h2>Complete Deposit</h2>

Holder ID       : ${account.holderId}<br/>
Account ID      : ${account.id}<br/>
Account Currency: ${account.currency}<br/>
Account Balance : ${account.balance}<br/>

<form action="completeDeposit" method="post"/>
<h2>Details</h2>
Deposit Amount:<input type="number" name="amount" step="0.01"/>
<input type="hidden" name="accountId" value="${account.id}"/>
<input type="submit" value="deposit"/>
</form>
</pre>

</body>
</html>
