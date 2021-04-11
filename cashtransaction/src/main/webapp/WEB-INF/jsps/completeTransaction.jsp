<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Complete Transaction</title>
</head>
<body>
<pre>
<h2>Sender Details</h2>

Sender Account ID      : ${account.id}<br/>
Sender Account Currency: ${account.currency}<br/>
Sender Account Balance : ${account.balance}<br/>

<form action="completeTransaction" method="post"/>
<h2>Complete Transaction</h2>

Recipient Account ID: <input type="number" name="recipientAccountID" step="1"/>
Transaction Amount  : <input type="number" name="amount" step="0.01"/>
<input type="hidden" name="senderAccountID" value="${account.id}"/>
<input type="submit" value="Transfer"/>
${msg}
</form>
</pre>

</body>
</html>
