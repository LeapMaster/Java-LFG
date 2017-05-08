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

</head>
<body>
    <c:choose>
        <c:when test="${UserMessage == ''}">
            <c:import url="jsp/header-content.jsp" />
        </c:when>
        <c:otherwise>
            <c:import url="jsp/header-content-logged.jsp" />
            ${UserMessage}
        </c:otherwise>
    </c:choose>

    <%--<a href="testQuery">Test LFG Query (Show All Posts)</a>--%>

    <c:import url="jsp/newListing-content.jsp" />

    <c:import url="jsp/filteredSearch-content.jsp" />


    <div>
        Posts Found: ${allPosts.size()}<br/>
        <table class="table listingTable" >
            <c:forEach var="currentPost" items="${allPosts}">
                <%--<br/>${currentPost}<br/>--%>
                <tr>
                    <td id="outputCol1">
                            ${currentPost.username}<br/>
                            ${currentPost.platform}
                    </td>
                    <td id="outputCol2">
                            ${currentPost.level} ${currentPost.playerClass}<br />
                                IL ${currentPost.gearRating}<br/>
                            ${currentPost.region}
                    </td>
                    <td id="outputCol3">
                            ${currentPost.lookingFor} - ${currentPost.activity}
                        <br/>
                        ${currentPost.description}

                    </td>
                    <td id="outputCol4">
                        <c:choose>
                            <c:when test="${currentPost.haveMic == true}">
                                <div class="divCenteredContent">
                                    <img src="img/mic.png" />
                                </div>
                            </c:when>
                        </c:choose>
                            ${currentPost.experience}
                    </td>
                    <td id="outputCol5">
                            ${currentPost.getMinutesAgo()}
                    </td>
                </tr>

            </c:forEach>

        </table>
    </div>
<script>
    $("#newListingForm").validate({
        rules: {
            level: {
                min: 1,
                max:110
            },
            gearRating: {
                min: 1
            },
            description: {
                required: true,
                maxlength: 250
            }
        }
    });
    $("#filteredSearchForm").validate();
</script>

</body>
</html>
