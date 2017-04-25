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
    <script src="js/parsley.min.js" charset="utf-8"></script>

    <link rel="stylesheet" href="styles/bootstrap.min.css">
    <link rel="stylesheet" href="styles/parsley.css">
    <link rel="stylesheet" href="styles/index.css">


</head>
<body>
<c:import url="jsp/header-content.jsp" />
<div class="bs-callout bs-callout-warning hidden">
    <h4>Oh snap!</h4>
    <p>This form seems to be invalid :(</p>
</div>

<div class="bs-callout bs-callout-info hidden">
    <h4>Yay!</h4>
    <p>Everything seems to be ok :)</p>
</div>


    <form action="register" method="post" id="demo-form" data-parsley-validate="">

                <label for="username">Username:</label>

                <input name="username" type="text" required="" class="form-control"/>

                <label for="first_password">Password:</label>

                <input id="first_password" name="first_password" type="password" required="" class="form-control" />

                <label for="second_password">Retype Password:</label>

                <input id="second_password" name="second_password" type="password" required="" class="form-control"/>

                <input type="submit" name="submit" value="Submit" />

    </form>


<script type="text/javascript">
    $(function () {
        $('#demo-form').parsley().on('field:validated', function() {
            var ok = $('.parsley-error').length === 0;
            $('.bs-callout-info').toggleClass('hidden', !ok);
            $('.bs-callout-warning').toggleClass('hidden', ok);
        })
            .on('form:submit', function() {


            });
    });
</script>
</body>

</html>
