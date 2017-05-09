<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 2/1/17
  Time: 3:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="styles/header.css">


<ul class="navbar">
    <li class="navitem"><img src="img/lfgLogoSmall.png" /></li>
    <li class="navitem"><a class="active" href=${pageContext.request.contextPath}>Home</a></li>
    <li class="navitem"><a href="${pageContext.request.contextPath}/profile">Profile</a></li>
    <li class="navitem"><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
    <li class="navitem"><a>${UserMessage}</a></li>
</ul>