<%--
  Created by IntelliJ IDEA.
  User: son-yohan
  Date: 2022/12/02
  Time: 5:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="addok" method="post">
    <table id="edit">
        <tr><td>cnt</td><td><input type="text" name="cnt"></td></tr>
        <tr><td>제목</td><td><input type="text" name="title"></td></tr>
        <tr><td>글쓴이</td><td><input type="text" name="writer"></td></tr>
        <tr><td>내용</td><td><textarea cols="50" rows="5" name="content"></textarea></td></tr>
    </table>
    <input type="submit" value="추가하기"/>
</form>
</body>
</html>
