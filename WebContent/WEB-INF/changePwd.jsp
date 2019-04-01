<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Find password</title>
</head>
<body>
  <h1><strong>비밀번호 변경</strong></h1>
  <form action="GBC" method="GET">
    name: <input type="text" name="name" value="" ><br/>
    current password: <input type="text" name="pwd" value="" ><br/>
    new password: <input type="text" name="nPwd" value="" ><br/>
    <input type="hidden" name="action" value="changePassword">
    <input type="submit" value="변경">
  </form>
</body>
</html>
