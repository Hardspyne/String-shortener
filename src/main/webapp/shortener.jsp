<%--
  Created by IntelliJ IDEA.
  User: dwe
  Date: 04.04.2019
  Time: 21:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>shortener</title>
</head>
<body>
<form action="controller" method="get">
    <label for="full">get short string</label>
    <input id="full" type="radio" name="option" value="full">
    <label for="short">get full String</label>
    <input id="short" type="radio" name="option" value="short">
    <label for="str">paste string here</label>
    <input id="str" type="text" name="string">
    <input type="submit" value="confirm">
</form>
</body>
</html>
