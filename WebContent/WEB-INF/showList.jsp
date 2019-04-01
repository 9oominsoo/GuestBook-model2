<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.josh.dto.GuestBookDto" %>
<%@ page import="com.josh.controller.GuestBookController"%>
<%@ page import="java.util.List"%>

<%
  List<GuestBookDto> list = (List<GuestBookDto>)request.getAttribute("GuestBookList");
  System.out.println(list.toString());
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show List</title>
</head>
<body>
  <h1><strong>GuestBook</strong></h1>
  <p><form action="./GBC" method="GET">
    <table border="2" width="500">
      <tr>
        <td width="10%">이름</td>
        <td width="35%"><input type="text" name="name"></td>
        <td width="20%">비밀번호</td>
        <td width="35%"><input type="text" name="pwd"></td>
      </tr>
      <tr>
        <td colspan="4"><textarea name="content" cols="70" rows="10"></textarea></td>
      </tr>
      <tr>
        <td colspan="4"><input type="submit" name value="확인"></td>
        <td colspan="4"><input type="hidden" name="action" value="insert"></td>
      </tr>
    </table>
  </form></p><br/>

  <% for(GuestBookDto dto: list){ %>
  <p><table border="1" width="500">
    <tr>
      <td width="10%"><%= dto.getNo() %></td>
      <td width="25%"><%= dto.getName() %></td>
      <td width="*"><%= dto.getRegDate() %></td>
      <td width="15%"><a href="/guestbook2/GBC?action=deleteList&no=<%=dto.getNo()%>">삭제</a></td>
    </tr>
    <tr>
      <td colspan="4">첫번째 방명록 내용<br/><%= dto.getContent() %></td>
    </tr>
  </table></p>
  <% } %>

  <p><a href="/guestbook2/GBC?action=changePwd">비밀번호 변경하기</a></p>
</body>
</html>
