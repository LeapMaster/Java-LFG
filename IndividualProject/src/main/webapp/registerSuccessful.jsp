<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 5/9/17
  Time: 5:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration Successful!</title>

    <link rel="stylesheet" href="styles/bootstrap.min.css">
    <link rel="stylesheet" href="styles/index.css">

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

</head>
<body>
    <c:import url="jsp/header-content.jsp" />

<table class="table formTable">
    <tr>
        <td>
            <label>Registration successful! <a href="login">Click here</a> to login.</label>
        </td>
    </tr>
</table>
</body>
</html>
