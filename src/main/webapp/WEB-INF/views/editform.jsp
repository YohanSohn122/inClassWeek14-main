<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: son-yohan
  Date: 2022/12/02
  Time: 5:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="boardVO" method="post" action="../editok">
  <form:hidden path="seq" name="seq"/>
  <table id="edit">
    <tr><td>cnt</td><td><form:input type="text" path="cnt"/></td></tr>
    <tr><td>제목</td><td><form:input type="text" path="title"/></td></tr>
    <tr><td>글쓴이</td><td><form:input type="text" path="writer"/></td></tr>
    <tr><td>내용</td><td><form:textarea cols="50" rows="5" path="content"/></td></tr>
  </table>
  <input type="submit" value="수정하기"/>
  <input type="button" value="취소하기" onclick="history.back()">
</form:form>
</body>
</html>
