<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Account</title>
</head>
<body>

<form action="saveAcc" method="post">
<pre>
<h2>Create a new account:</h2>
HolderID              : ${holderId}
Currency              : EUR <input type="radio" name="currency" value="EUR"/>
                        USD <input type="radio" name="currency" value="USD"/>
Initial Deposit Amount: <input type="text" name="balance"/>
<input type="hidden" name="holderId" value="${holderId}"/>
<input type="submit" value="save"/>
</pre>
</form>

${msg}

<a href="displayAccounts">View Accounts</a>

</body>
</html>
