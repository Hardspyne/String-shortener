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
<div style="height: 100%;font-size:24px ;display: flex;flex-direction: column;justify-content: center;align-items: center;">
    <div>Choose a strategy if you want. By default, the "DataBase Storage Strategy" is selected. We recommend using it.
    </div>
    <form style="display: flex;flex-direction: column;justify-content: center;align-items: center;" action="controller"
          method="post">
        <label style="margin:10px;font-weight: bold;font-size: 20px" for="str">Select strategy:</label>
        <select id="str" name="strategy" size="1">
            <option value="DataBaseStorageStrategy">DataBaseStorageStrategy</option>
            <option value="DualHashBidiMapStorageStrategy">DualHashBidiMapStorageStrategy</option>
            <option value="DualHashBidiMapStorageStrategy">DualHashBidiMapStorageStrategy</option>
            <option value="HashBiMapStorageStrategy">HashBiMapStorageStrategy</option>
            <option value="HashMapStorageStrategy">HashMapStorageStrategy</option>
            <option value="OurHashBiMapStorageStrategy">OurHashBiMapStorageStrategy</option>
            <option value="OurHashMapStorageStrategy">OurHashMapStorageStrategy</option>
        </select>
        <input style="margin:10px" type="submit" value="confirm">
    </form>
</div>
</body>
</html>
