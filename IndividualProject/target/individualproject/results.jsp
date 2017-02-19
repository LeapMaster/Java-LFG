<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 2/6/17
  Time: 6:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="styles/bootstrap.min.css">
    <link rel="stylesheet" href="styles/postPage.css">
</head>
<body>
    <%@include file="jsp/header-content.jsp"%>
    <h2>All Posts</h2>
    ${allPosts}
    <table class="table">
        <c:forEach var="currentPost" items="${allPosts}">
            <tr>
                <td>
                    Platform
                </td>
                <td>
                    Username<br/>
                    Level#/Class/Gear#<br/>
                    Region
                </td>
                <td class="description">
                    LFG - Activity Name<br/>
                    Description Text Goes Here
                </td>
                <td>
                    Mic<br/>
                    Sherpa<br/>
                    Novice<br/>
                </td>
                <td>
                    X Minutes Ago
                </td>
            </tr>

        </c:forEach>
    </table>
</body>
</html>