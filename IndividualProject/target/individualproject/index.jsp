<html>
<head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="pageTitle" value="Home" scope="request" />

    <link rel="stylesheet" href="styles/bootstrap.min.css">
    <link rel="stylesheet" href="styles/index.css">

    <script src="js/jquery-3.1.1.min.js" charset="utf-8"></script>
    <script src="js/bootstrap.min.js" charset="utf-8"></script>


</head>
<body>
    <c:import url="jsp/header-content.jsp" />
    <a href="testQuery">Test LFG Query (Show All Posts)</a>

    <c:import url="jsp/newListing-content.jsp" />

    <c:import url="jsp/filteredSearch-content.jsp" />


    <div>
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
                            ${cusrrentPost.region}
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

        </table>
    </div>
</body>
</html>
