<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 4/25/17
  Time: 12:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <script src="js/jquery-3.1.1.min.js" charset="utf-8"></script>
    <script src="js/jquery.validate.js" charset="utf-8"></script>

    <link rel="stylesheet" href="styles/bootstrap.min.css">
    <link rel="stylesheet" href="styles/index.css">
    <link rel="stylesheet" href="styles/formValidation.css">

</head>
<body>

<c:import url="jsp/header-content.jsp" />





    <form action="register" method="post" id="registerForm" >
        <table class="table formTable">

            <tr>
                <td>
                    <c:choose>
                        <c:when test="${!PageMessage.equals(null)}">
                            <div class="error">${PageMessage}</div>
                        </c:when>
                    </c:choose>
                    <label for="username">Username: <span>(required, at least 2 characters)</span></label>
                    <input id="username" name="username" type="text" required="" class="form-control" required/>
                </td>
            </tr>
            <tr>
                <td>
                    <label for="first_password">Password: <span>(required, at least 2 characters)</span></label>
                    <input id="first_password" name="first_password" type="password" class="form-control" required/>
                </td>
            </tr>
            <tr>
                <td>
                    <label for="second_password">Retype Password: <span>(Must match)</span></label>
                    <input id="second_password" name="second_password" type="password" class="form-control" required/>
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" name="submit" value="Submit" />
                </td>
            </tr>
        </table>

    </form>


</body>
<script>
    $("#registerForm").validate({
        rules: {
            username: {
                required:true,
                minlength: 2
            },
            first_password: {
                required: true,
                minlength: 2
            },
            second_password: {
                required:true,
                minlength: 2,
                equalTo: "#first_password"
            }
        }
    });

</script>
</html>
