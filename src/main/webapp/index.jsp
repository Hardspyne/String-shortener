<%--
  Created by IntelliJ IDEA.
  User: dwe
  Date: 04.04.2019
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Strategy selection</title>
</head>
<body>
<form action="shortener" method="post">
    <label for="str">Select strategy</label>
    <select id="str" name="strategy" size="1">
        <option value="DualHashBidiMapStorageStrategy">DualHashBidiMapStorageStrategy</option>
        <option value="HashBiMapStorageStrategy">HashBiMapStorageStrategy</option>
        <option value="HashMapStorageStrategy">HashMapStorageStrategy</option>
        <option value="OurHashBiMapStorageStrategy">OurHashBiMapStorageStrategy</option>
        <option value="OurHashMapStorageStrategy">OurHashMapStorageStrategy</option>
    </select>
    <input type="submit" value="confirm">
</form>
</body>
</html>
