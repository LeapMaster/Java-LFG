<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 4/27/17
  Time: 3:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="styles/bootstrap.min.css">
    <link rel="stylesheet" href="styles/index.css">
    <link rel="stylesheet" href="styles/formValidation.css">

    <script src="js/jquery-3.1.1.min.js" charset="utf-8"></script>
    <script src="js/jquery.validate.js" charset="utf-8"></script>
    <script src="js/login.js" charset="utf-8"></script>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

</head>
<body>
<c:import url="jsp/header-content.jsp" />
${PageMessage}
    <form id="loginForm" action="login" method="post">
        <table class="table formTable">
            <c:choose>
                <c:when test="${PageMessage} != null">
                    <tr>
                        <td>
                            ${PageMessage}
                        </td>
                    </tr>
                </c:when>
            </c:choose>
            <tr>
                <td>
                    <label>Please log in.</label>
                </td>
            </tr>
            <tr>
                <td>
                    <label for="usernameField">Username:</label>
                    <input id="usernameField" type="text" name="username" minlength="2" required />
                </td>
            </tr>

        <tr>
            <td>
                <label for="passwordField">Password:</label>
                <input id="passwordField" type="password" name="password" minlength="2" required />
            </td>
        </tr>


            <tr>
                <td>
                    <input type="submit" value="Submit" />
                </td>
            </tr>

        </table>
    </form>
<script>

</script>
</body>
</html>
