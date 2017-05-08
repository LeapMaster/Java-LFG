<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 4/27/17
  Time: 5:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <link rel="stylesheet" href="styles/bootstrap.min.css">
    <link rel="stylesheet" href="styles/index.css">
</head>
<body>
    <c:choose>
        <c:when test="${PageMessage == ''}">
            <c:import url="jsp/header-content-logged.jsp" />
            <form action="profile" method="post" id="editProfileForm">
                <table class="table formTable">
                    <tr>
                        <td>
                            <label>Edit Profile:</label>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="username">Username:</label>
                            <input id="username" name="username" type="text" value="${username}" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="wowUsername">WoW Username:</label>
                            <input id="wowUsername" name="wowUsername" type="text" value="" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="wowRealm">WoW Region:</label>

                            <select id="wowRealm" name="wowRealm" class="form-control" required>

                                <option value="">Select a Region</option>
                                <option value="Blackrock">Blackrock</option>
                                <option value="Blackwing Lair">Blackwing Lair</option>
                                <option value="Bonechewer">Bonechewer</option>
                                <option value="Boulderfist">Boulderfist</option>
                                <option value="Coilfang">Coilfang</option>
                                <option value="Crushridge">Crushridge</option>
                                <option value="Daggerspine">Daggerspine</option>
                                <option value="Dark Iron">Dark Iron</option>
                                <option value="Destromath">Destromath</option>
                                <option value="Dethecus">Dethecus</option>
                                <option value="Dragonmaw">Dragonmaw</option>
                                <option value="Dunemaul">Dunemaul</option>
                                <option value="Frostwolf">Frostwolf</option>
                                <option value="Gorgonnash">Gorgonnash</option>
                                <option value="Gurubashi">Gurubashi</option>
                                <option value="Kalecgos">Kalecgos</option>
                                <option value="Kil'Jaeden">Kil'Jaeden</option>
                                <option value="Lethon">Lethon</option>
                                <option value="Maiev">Maiev</option>
                                <option value="Nazjatar">Nazjatar</option>
                                <option value="Ner'zhul">Ner'zhul</option>
                                <option value="Onyxia">Onyxia</option>
                                <option value="Rivendare">Rivendare</option>
                                <option value="Shattered Halls">Shattered Halls</option>
                                <option value="Spinebreaker">Spinebreaker</option>
                                <option value="Spirestone">Spirestone</option>
                                <option value="Stonemaul">Stonemaul</option>
                                <option value="Stormscale">Stormscale</option>
                                <option value="Tichondrius">Tichondrius</option>
                                <option value="Ursin">Ursin</option>
                                <option value="Vashj">Vashj</option>

                            <%--<option value="">Select a Region</option>--%>
                                <%--<option value="Aerie Peak">Aerie Peak</option>--%>
                                <%--<option value="Anvilmar">Anvilmar</option>--%>
                                <%--<option value="Arathor">Arathor</option>--%>
                                <%--<option value="Antonidas">Antonidas</option>--%>
                                <%--<option value="Azuremyst">Azuremyst</option>--%>
                                <%--<option value="Baelgun">Baelgun</option>--%>
                                <%--<option value="Blade's Edge">Blade's Edge</option>--%>
                                <%--<option value="Bladefist">Bladefist</option>--%>
                                <%--<option value="Bronzebeard">Bronzebeard</option>--%>
                                <%--<option value="Cenarius">Cenarius</option>--%>
                                <%--<option value="Darrowmere">Darrowmere</option>--%>
                                <%--<option value="Draenor">Draenor</option>--%>
                                <%--<option value="Dragonblight">Dragonblight</option>--%>
                                <%--<option value="Echo Isles">Echo Isles</option>--%>
                                <%--<option value="Galakrond">Galakrond</option>--%>
                                <%--<option value="Gnomeregan">Gnomeregan</option>--%>
                                <%--<option value="Hyjal">Hyjal</option>--%>
                                <%--<option value="Kilrogg">Kilrogg</option>--%>
                                <%--<option value="Korialstrasz">Korialstrasz</option>--%>
                                <%--<option value="Lightbringer">Lightbringer</option>--%>
                                <%--<option value="Misha">Misha</option>--%>
                                <%--<option value="Moonrunner">Moonrunner</option>--%>
                                <%--<option value="Nordrassil">Nordrassil</option>--%>
                                <%--<option value="Proudmoore">Proudmoore</option>--%>
                                <%--<option value="Shadowsong">Shadowsong</option>--%>
                                <%--<option value="Shu'Halo">Shu'Halo</option>--%>
                                <%--<option value="Silvermoon">Silvermoon</option>--%>
                                <%--<option value="Skywall">Hyjal</option>--%>
                                <%--<option value="Suramar">Suramar</option>--%>
                                <%--<option value="Uldum">Uldum</option>--%>
                                <%--<option value="Uther">Uther</option>--%>
                                <%--<option value="Velen">Velen</option>--%>
                                <%--<option value="Windrunner">Windrunner</option>--%>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>

                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="submit" value="Submit Changes" />
                            User ID: ${userID}
                            Username: ${username}
                        </td>
                    </tr>


                </table>
            </form>

        </c:when>
        <c:otherwise>
            <c:import url="jsp/header-content.jsp" />
            ${PageMessage}
        </c:otherwise>
    </c:choose>
</body>
</html>
