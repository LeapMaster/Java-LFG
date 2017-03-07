<html>
<head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="pageTitle" value="Home" scope="request" />

    <link rel="stylesheet" href="styles/bootstrap.min.css">
    <script src="js/jquery-3.1.1.min.js" charset="utf-8"></script>
    <script src="js/bootstrap.min.js" charset="utf-8"></script>


</head>
<body>
    <c:import url="jsp/header-content.jsp" />
    <a href="testQuery">Test LFG Query</a>

    <div class="panel-group" id="accordion">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accordion" href="#collapse1">New Listing</a>
                </h4>
            </div>
            <div id="collapse1" class="panel-collapse collapse in">
                <div class="panel-body">
                    <div>
                        <form action="/newPost" methodd="post">
                            <table>
                                <tr>
                                    <td colspan="4">

                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="2">
                                        Platform<br />
                                        <input type="text">

                                    </td>
                                    <td colspan="2">
                                        Username<br />
                                        <input type="text">

                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="2">
                                        Region<br />
                                        <input type="text">

                                    </td>
                                    <td colspan="2">
                                        Looking For<br />
                                        <input type="text">

                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="2">
                                        <select>
                                            <option value="none">Pick a Class</option>
                                            <option value="tank">Tank</option>
                                            <option value="healer">Healer</option>
                                            <option value="dps">DPS</option>

                                        </select>

                                    </td>
                                    <td>
                                        Level<br />
                                        <input type="number" class="numberInput">

                                    </td>
                                    <td>
                                        Gear Rating<br />
                                        <input type="number" class="numberInput">

                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="2">
                                        <select>
                                            <option value="none">Pick an Activity</option>
                                            <option value="vaultofglass">Vault of Glass</option>
                                            <option value="crystaltower">Healer</option>
                                            <option value="undercover">Undercover</option>
                                        </select>

                                    </td>
                                    <td colspan="2">
                                        Experience (Optional) <br />
                                        <input type="button" value="Novice"/>
                                        <input type="button" value="Sherpa"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="4">
                                        Description<br />
                                        <input type="text" />
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="2">
                                        <input type="button" value="I have a mic" />
                                    </td>
                                    <td>
                                        <input type="button" value="Submit" />
                                    </td>
                                    <td>
                                        <input type="button" value="Clear" />
                                    </td>
                                </tr>
                            </table>
                        </form>
                    </div>
                </div>
            </div>
        </div>

    </div>
</body>
</html>
