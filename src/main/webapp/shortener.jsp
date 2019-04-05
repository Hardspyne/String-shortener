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
    <title>Shortener</title>
</head>
<body>
<div style="width: 50%;font-size: 20px;margin-left: auto;margin-right: auto;">
    <form style="height:100%;width:100%;display: flex;flex-direction: column;justify-content:center;align-items:center;"
          action="controller" method="get">
        <div style="width:100%;display: flex;flex-direction: row;justify-content:space-around;align-items: flex-end;">
            <label for="full">Get short string</label>
            <label for="short">Get full string</label></div>
        <div style="width:100%;display: flex;flex-direction: row;justify-content:space-around;align-items: flex-end;">
            <input id="full" type="radio" name="option" value="full" checked>
            <input id="short" type="radio" name="option" value="short"></div>
        <label style="margin:10px;font-weight: bold;font-size: 24px" for="str">paste string here</label>
        <input style="width: 100%; height:30px" id="str" type="text" name="string">
        <input type="submit" style="margin-top: 10px" value="confirm">
        <a style="font-size:20px;text-decoration: none;color:black;font-weight:bold;margin-top: 10px" href="index.jsp">Choose
            other storage strategy</a>
    </form>
</div>
</body>
</html>
