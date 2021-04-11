<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Transaction Confirmation</title>
</head>
<body>

<pre>
<h2>Transaction Result</h2>

Sender Account ID    : ${transaction.senderAccountId}<br/>
Send Amount          : ${transaction.sendAmount}<br/>
Send Currency        : ${transaction.sendCurrency}<br/>
Sender Account Balance After Transaction : ${newbalance}<br/>

Recipient Account ID: ${transaction.recipientAccountId}<br/>
Receive Amount      : ${transaction.receiveAmount}<br/>
Receive Currency    : ${transaction.receiveCurrency}<br/>

</pre>

</body>
</html>
