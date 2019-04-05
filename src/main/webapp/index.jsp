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
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Strategy selection</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class="container" style="height: 100%">
    <div>Choose a strategy if you want. By default, the "DataBase Storage Strategy" is selected. We recommend using it.
    </div>
    <form class="container" action="controller" method="post">
        <label class="chooseHeader" for="str">Select strategy:</label>
        <select id="str" name="strategy" size="1">
            <option value="DataBaseStorageStrategy">DataBaseStorageStrategy</option>
            <option value="DualHashBidiMapStorageStrategy">DualHashBidiMapStorageStrategy</option>
            <option value="DualHashBidiMapStorageStrategy">DualHashBidiMapStorageStrategy</option>
            <option value="HashBiMapStorageStrategy">HashBiMapStorageStrategy</option>
            <option value="HashMapStorageStrategy">HashMapStorageStrategy</option>
            <option value="OurHashBiMapStorageStrategy">OurHashBiMapStorageStrategy</option>
            <option value="OurHashMapStorageStrategy">OurHashMapStorageStrategy</option>
        </select>
        <input type="submit" value="confirm">
    </form>
</div>
</body>
</html>
