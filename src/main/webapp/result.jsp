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
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Result</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class="container fullWindowForm">
    <input class="resultString" type="text" name="result" readonly
           value="<c:out value="${result}" />">
    <a class="link" href="shortener.jsp">Short
        other string</a>
</div>
</body>
</html>