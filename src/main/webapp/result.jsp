<%--
  Created by IntelliJ IDEA.
  User: dwe
  Date: 04.04.2019
  Time: 21:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Result</title>
</head>
<body>
<div style="height: 100%;font-size:20px;display: flex;flex-direction: column;justify-content: center;align-items: center;">
    <input style="margin-top:30px;height:30px;width: 50%;text-align: center;" type="text" name="result" readonly value="<c:out value="${result}" />">
    <a style="font-size:20px;text-decoration: none;color:black;font-weight:bold;margin-top: 10px" href="shortener.jsp">Short other string</a>
</div>
</body>
</html>