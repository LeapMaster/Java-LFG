<html>
<head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="pageTitle" value="Home" scope="request" />

    <link rel="stylesheet" href="styles/bootstrap.min.css">
    <link rel="stylesheet" href="styles/formValidation.css">
    <link rel="stylesheet" href="styles/index.css">

    <script src="js/jquery-3.1.1.min.js" charset="utf-8"></script>
    <script src="js/bootstrap.min.js" charset="utf-8"></script>
    <script src="js/jquery.validate.js" charset="utf-8"></script>
    <script src="js/index.js" charset="utf-8"></script>

</head>
<body>

    <c:choose>
        <c:when test="${UserMessage == null}">
            <c:import url="jsp/header-content.jsp" />
        </c:when>
        <c:otherwise>
            <c:import url="jsp/header-content-logged.jsp" />

        </c:otherwise>
    </c:choose>

    <br/>
    <c:import url="jsp/newListing-content.jsp" />

    <c:import url="jsp/filteredSearch-content.jsp" />

    <div>

        <table class="table formTable " >
            <tr>
                <td colspan="4">
                    Posts Found: ${allPosts.size()}
                </td>
            </tr>
            <c:forEach var="currentPost" items="${allPosts}">
                <tr>
                    <td id="outputCol1">
                            ${currentPost.username}<br/>
                            ${currentPost.platform}<br/>
                            ${currentPost.region}
                    </td>
                    <td id="outputCol2">
                            ${currentPost.level} ${currentPost.playerClass}<br />
                                IL ${currentPost.gearRating}<br/>

                    </td>
                    <td id="outputCol3">
                            ${currentPost.lookingFor} - ${currentPost.activity}
                        <br/>
                        ${currentPost.description}

                    </td>
                    <td id="outputCol4">
                            ${currentPost.getMinutesAgo()}
                        <c:choose>
                            <c:when test="${currentPost.haveMic == true}">
                                <div class="divCenteredContent">
                                    <img src="img/mic.png" />
                                </div>
                            </c:when>
                        </c:choose>
                            ${currentPost.experience}<br/>
                    </td>
                </tr>

            </c:forEach>

        </table>
    </div>
</body>
</html>
