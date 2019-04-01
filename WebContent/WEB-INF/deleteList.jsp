<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <form action="GBC" method="GET">
    비밀번호  <input type="text" name="pwd" value="">
    <input type="hidden" name="no" value=<%= request.getParameter("no") %>>
    <input type="submit" name value="확인">
    <input type="hidden" name="action" value="delete">
  </form>
  <a href="/guestbook2/GBC?action=showList">메인으로 돌아가기</a>
</body>
</html>
