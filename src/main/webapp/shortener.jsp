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
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Shortener</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class="alignDiv">
    <form class="container fullWindowForm" action="controller" method="get">
        <div class="chooseShortOption">
            <label for="full">Get short string</label>
            <label for="short">Get full string</label>
        </div>
        <div class="chooseShortOption">
            <input id="full" type="radio" name="option" value="full" checked>
            <input id="short" type="radio" name="option" value="short">
        </div>
        <label class="chooseHeader" for="str">paste string here</label>
        <input class="inputTextToShort" id="str" type="text" name="string">
        <input type="submit" value="confirm">
        <a class="link" href="index.jsp">Choose
            other storage strategy</a>
    </form>
</div>
</body>
</html>
