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
    <link rel="stylesheet" href="styles/formValidation.css">
</head>
<body>
    <c:choose>
        <c:when test="${PageMessage == ''}">
            <c:import url="jsp/header-content-logged.jsp" />
            <form action="profile" method="post" id="editProfileForm">
                <table class="table formTable">
                    <tr>
                        <td>
                            <c:choose>
                                <c:when test="${!PageErrorMessage.equals(null)}">
                                    <div class="error">${PageErrorMessage}</div>
                                </c:when>
                            </c:choose>
                            <label>Link your WoW Profile to speed up LFG listing!</label>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="username">Username: ${currentUser.username}</label>
                            <input id="username" name="username" type="text" value="${currentUser.username}" hidden/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="wowUsername">WoW Username:</label>
                            <input id="wowUsername" name="wowUsername" type="text" value="${currentUser.wowUser}" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="wowRealm">WoW Region: </label>
                            <c:choose>
                                <c:when test="${currentUser.wowRealm != null}">
                                    <label>(Current Realm: ${currentUser.wowRealm})</label>
                                </c:when>
                            </c:choose>
                            <select id="wowRealm" name="wowRealm" class="form-control" required>
                                <option value="">Select a Region</option>
                                <option value="Blackrock"  ${currentUser.wowRealm.equals("Blackrock") ? "selected" : ""}>Blackrock</option>
                                <option value="Blackwing Lair" ${currentUser.wowRealm.equals("Blackwing Lair") ? "selected" : ""}>Blackwing Lair</option>
                                <option value="Bonechewer" ${currentUser.wowRealm.equals("Bonechewer") ? "selected" : ""}>Bonechewer</option>
                                <option value="Boulderfist" ${currentUser.wowRealm.equals("Boulderfist") ? "selected" : ""}>Boulderfist</option>
                                <option value="Coilfang" ${currentUser.wowRealm.equals("Coilfang") ? "selected" : ""}>Coilfang</option>
                                <option value="Crushridge" ${currentUser.wowRealm.equals("Crushridge") ? "selected" : ""}>Crushridge</option>
                                <option value="Daggerspine" ${currentUser.wowRealm.equals("Daggerspine") ? "selected" : ""}>Daggerspine</option>
                                <option value="Dark Iron" ${currentUser.wowRealm.equals("Dark Iron") ? "selected" : ""}>Dark Iron</option>
                                <option value="Destromath" ${currentUser.wowRealm.equals("Destromath") ? "selected" : ""}>Destromath</option>
                                <option value="Dethecus" ${currentUser.wowRealm.equals("Dethecus") ? "selected" : ""}>Dethecus</option>
                                <option value="Dragonmaw" ${currentUser.wowRealm.equals("Dragonmaw") ? "selected" : ""}>Dragonmaw</option>
                                <option value="Dunemaul" ${currentUser.wowRealm.equals("Dunemaul") ? "selected" : ""}>Dunemaul</option>
                                <option value="Frostwolf" ${currentUser.wowRealm.equals("Frostwolf") ? "selected" : ""}>Frostwolf</option>
                                <option value="Gorgonnash" ${currentUser.wowRealm.equals("Gorgonnash") ? "selected" : ""}>Gorgonnash</option>
                                <option value="Gurubashi" ${currentUser.wowRealm.equals("Gurubashi") ? "selected" : ""}>Gurubashi</option>
                                <option value="Kalecgos" ${currentUser.wowRealm.equals("Kalecgos") ? "selected" : ""}>Kalecgos</option>
                                <option value="Kil'Jaeden" ${currentUser.wowRealm.equals("Kil\'Jaeden") ? "selected" : ""}>Kil'Jaeden</option>
                                <option value="Lethon" ${currentUser.wowRealm.equals("Lethon") ? "selected" : ""}>Lethon</option>
                                <option value="Maiev" ${currentUser.wowRealm.equals("Maiev") ? "selected" : ""}>Maiev</option>
                                <option value="Nazjatar" ${currentUser.wowRealm.equals("Nazjatar") ? "selected" : ""}>Nazjatar</option>
                                <option value="Ner'zhul" ${currentUser.wowRealm.equals("Ner\'zhul") ? "selected" : ""}>Ner'zhul</option>
                                <option value="Onyxia" ${currentUser.wowRealm.equals("Onyxia") ? "selected" : ""}>Onyxia</option>
                                <option value="Rivendare" ${currentUser.wowRealm.equals("Rivendare") ? "selected" : ""}>Rivendare</option>
                                <option value="Shattered Halls" ${currentUser.wowRealm.equals("Shattered Halls") ? "selected" : ""}>Shattered Halls</option>
                                <option value="Spinebreaker" ${currentUser.wowRealm.equals("Spinebreaker") ? "selected" : ""}>Spinebreaker</option>
                                <option value="Spirestone" ${currentUser.wowRealm.equals("Spirestone") ? "selected" : ""}>Spirestone</option>
                                <option value="Stonemaul" ${currentUser.wowRealm.equals("Stonemaul") ? "selected" : ""}>Stonemaul</option>
                                <option value="Stormscale" ${currentUser.wowRealm.equals("Stormscale") ? "selected" : ""}>Stormscale</option>
                                <option value="Tichondrius" ${currentUser.wowRealm.equals("Tichondrius") ? "selected" : ""}>Tichondrius</option>
                                <option value="Ursin" ${currentUser.wowRealm.equals("Ursin") ? "selected" : ""}>Ursin</option>
                                <option value="Vashj" ${currentUser.wowRealm.equals("Vashj") ? "selected" : ""}>Vashj</option>
                            </select>
                        </td>
                    </tr>
                    <c:choose>
                        <c:when test="${currentUser.characterLevel != null}">
                            <tr>
                                <td>
                                    <label>
                                        Player Class: ${currentUser.playerClass}<br />
                                        Character Level: ${currentUser.characterLevel} <br />
                                        Item Level: ${currentUser.itemLevel}
                                    </label>
                                </td>
                            </tr>
                        </c:when>
                    </c:choose>
                    <tr>
                        <td>
                            <input type="submit" value="Submit Changes" />
                        </td>
                    </tr>




                </table>
            </form>

        </c:when>
        <c:otherwise>
            <c:import url="jsp/header-content.jsp" />
                <table class="table formTable">
                    <tr>
                        <td>
                        You must log in to access this page.
                        </td>
                    </tr>
                </table>
        </c:otherwise>
    </c:choose>
</body>
</html>
