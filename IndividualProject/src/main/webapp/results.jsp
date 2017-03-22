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
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page import="org.ocpsoft.prettytime.PrettyTime" %>
    <title>Title</title>
    <link rel="stylesheet" href="styles/bootstrap.min.css">
    <link rel="stylesheet" href="styles/postPage.css">
</head>
<body>
    <%@include file="jsp/header-content.jsp"%>
    <h2>All Posts</h2>
    <%--${allPosts}<br/>--%>
    Posts Found: ${allPosts.size()}<br/>
    <table class="table">
        <c:forEach var="currentPost" items="${allPosts}">
            <%--<br/>${currentPost}<br/>--%>
            <tr>
                <td>
                    ${currentPost.platform}
                </td>
                <td>
                    ${currentPost.username}<br/>
                    ${currentPost.level}/${currentPost.playerClass}/${currentPost.gearRating}<br/>
                    ${currentPost.region}
                </td>
                <td class="description">
                    ${currentPost.lookingFor} - ${currentPost.activity}
                    <br/>
                    ${currentPost.description}
                </td>
                <td>
                    <c:choose>
                        <c:when test="${currentPost.haveMic == true}">
                            <div class="divCenteredContent">
                                <img src="img/mic.png" />
                            </div>
                        </c:when>
                    </c:choose>
                    ${currentPost.experience}
                </td>
                <td>
                    ${currentPost.getMinutesAgo()}
                </td>
            </tr>

        </c:forEach>
        <%--<tr>--%>
            <%--<td>--%>
                <%--Platform--%>
            <%--</td>--%>
            <%--<td>--%>
                <%--Username<br/>--%>
                <%--Level#/Class/Gear#<br/>--%>
                <%--Region--%>
            <%--</td>--%>
            <%--<td class="description">--%>
                <%--LFG - Activity Name<br/>--%>
                <%--Description Text Goes Here--%>
            <%--</td>--%>
            <%--<td>--%>
                <%--Mic<br/>--%>
                <%--Sherpa<br/>--%>
                <%--Novice<br/>--%>
            <%--</td>--%>
            <%--<td>--%>
                <%--X Minutes Ago--%>
            <%--</td>--%>
        <%--</tr>--%>
    </table>
</body>
</html>