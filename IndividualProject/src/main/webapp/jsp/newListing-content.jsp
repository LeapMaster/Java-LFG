<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 4/19/17
  Time: 8:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="panel-group" id="accordion">
    <div class="panel panel-default formTable">
        <div class="panel-heading ">
            <h4 class="panel-title">
                <a data-toggle="collapse" data-parent="#accordion" href="#collapse1">New Listing</a>
            </h4>
        </div>
        <div id="collapse1" class="panel-collapse collapse ">
            <div class="panel-body">
                <div>
                    <c:choose>
                        <c:when test="${currentUser.wowUser != null}">
                            <form action="newPost" method="post" id="newListingForm">
                                <table class="table formTable" >
                                    <tr>
                                        <td colspan="2" class="col2">
                                            Platform<br />
                                            <select name="platform" class="form-control" required>
                                                <option value="">-Choose a Platform-</option>
                                                <option value="Xbox">Xbox</option>
                                                <option value="Playstation">Playstation</option>
                                                <option value="PC">PC</option>
                                            </select>

                                        </td>
                                        <td colspan="2" class="col2">
                                            Username<br />
                                            <input type="text" name="username" class="textField readOnlyText" value="${currentUser.wowUser}" readonly>

                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="2" class="col2">
                                            Region<br />
                                            <select name="region" class="form-control" required>
                                                <option value="">-Choose a Region-</option>
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
                                        <td colspan="2" class="col2">
                                            Looking For<br />
                                            <select name="lookingFor" class="form-control" required>
                                                <option value="">-Choose Looking For-</option>
                                                <option value="LFG">Looking for Group</option>
                                                <option value="LFM">Looking for More</option>

                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="2" class="col2">
                                            Player Class<br />
                                            <select name="playerClass" class="form-control" disabled>
                                                <option value="">Choose a Class</option>
                                                <option value="Tank">Tank</option>
                                                <option value="Healer">Healer</option>
                                                <option value="DPS">DPS</option>
                                                <option value="Warrior" ${currentUser.playerClass.equals("Warrior") ? "selected" : ""}>Warrior</option>
                                                <option value="Paladin" ${currentUser.playerClass.equals("Paladin") ? "selected" : ""}>Paladin</option>
                                                <option value="Hunter" ${currentUser.playerClass.equals("Hunter") ? "selected" : ""}>Hunter</option>
                                                <option value="Rogue" ${currentUser.playerClass.equals("Rogue") ? "selected" : ""}>Rogue</option>
                                                <option value="Priest" ${currentUser.playerClass.equals("Priest") ? "selected" : ""}>Priest</option>
                                                <option value="Death Knight" ${currentUser.playerClass.equals("Death Knight") ? "selected" : ""}>Death Knight</option>
                                                <option value="Shaman" ${currentUser.playerClass.equals("Shaman") ? "selected" : ""}>Shaman</option>
                                                <option value="Mage" ${currentUser.playerClass.equals("Mage") ? "selected" : ""}>Mage</option>
                                                <option value="Warlock" ${currentUser.playerClass.equals("Warlock") ? "selected" : ""}>Warlock</option>
                                                <option value="Monk" ${currentUser.playerClass.equals("Monk") ? "selected" : ""}>Monk</option>
                                                <option value="Druid" ${currentUser.playerClass.equals("Druid") ? "selected" : ""}>Druid</option>
                                                <option value="Demon Hunter" ${currentUser.playerClass.equals("Demon Hunter") ? "selected" : ""}>Demon Hunter</option>
                                                <input type="text" name="playerClass" value="${currentUser.playerClass}" hidden/>

                                            </select>

                                        </td>
                                        <td>
                                            Level<br />
                                            <input type="number" class="numberInput, textField" name="level" value="${currentUser.characterLevel}" >

                                        </td>
                                        <td>
                                            Item Level<br />
                                            <input type="number" class="numberInput, textField" name="gearRating" value="${currentUser.itemLevel}" >

                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="2" class="col2">
                                            Activity<br />
                                            <select name="activity" class="form-control" required>
                                                <option value="">Choose an Activity</option>
                                                <option value="Vault Of Glass">Vault of Glass</option>
                                                <option value="Crystal Tower">Crystal Tower</option>
                                                <option value="Undercover">Undercover</option>
                                            </select>

                                        </td>
                                        <td colspan="2" class="col2">
                                            Experience (Optional) <br />
                                            <!--<input type="button" value="Novice"/>
                                            <input type="button" value="Sherpa"/>-->
                                            <select name="experience" class="form-control">
                                                <option value=""></option>
                                                <option value="Sherpa">Sherpa</option>
                                                <option value="Beginner">Beginner</option>

                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="4" class="col4">
                                            Description<br />
                                            <input type="text" name="description" class="descriptionInput" required/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="2" class="col2">
                                            <div class="checkbox">
                                                <label><input type="checkbox" name="haveMic" value="true">I have a mic</label>
                                            </div>
                                        </td>
                                        <td>
                                            <input type="submit" name="submit" value="Submit" />
                                        </td>
                                        <td>
                                            <input type="reset" name="reset" value="Clear" />
                                        </td>
                                    </tr>
                                </table>
                            </form>

                        </c:when>
                        <c:otherwise>
                            <form action="newPost" method="post" id="newListingForm">
                                <table class="table formTable" >
                                    <tr>
                                        <td colspan="2" class="col2">
                                            Platform<br />
                                            <select name="platform" class="form-control" required>
                                                <option value="">-Choose a Platform-</option>
                                                <option value="Xbox">Xbox</option>
                                                <option value="Playstation">Playstation</option>
                                                <option value="PC">PC</option>

                                            </select>

                                        </td>
                                        <td colspan="2" class="col2">
                                            Username<br />
                                            <input type="text" name="username" class="textField" required>

                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="2" class="col2">
                                            Region<br />
                                            <select name="region" class="form-control" required>
                                                <option value="">-Choose a Region-</option>
                                                <option value="Blackrock" >Blackrock</option>
                                                <option value="Blackwing Lair" >Blackwing Lair</option>
                                                <option value="Bonechewer" >Bonechewer</option>
                                                <option value="Boulderfist" >Boulderfist</option>
                                                <option value="Coilfang" >Coilfang</option>
                                                <option value="Crushridge" >Crushridge</option>
                                                <option value="Daggerspine" >Daggerspine</option>
                                                <option value="Dark Iron" >Dark Iron</option>
                                                <option value="Destromath" >Destromath</option>
                                                <option value="Dethecus" >Dethecus</option>
                                                <option value="Dragonmaw" >Dragonmaw</option>
                                                <option value="Dunemaul" >Dunemaul</option>
                                                <option value="Frostwolf" >Frostwolf</option>
                                                <option value="Gorgonnash" >Gorgonnash</option>
                                                <option value="Gurubashi" >Gurubashi</option>
                                                <option value="Kalecgos" >Kalecgos</option>
                                                <option value="Kil'Jaeden" >Kil'Jaeden</option>
                                                <option value="Lethon" >Lethon</option>
                                                <option value="Maiev" >Maiev</option>
                                                <option value="Nazjatar" >Nazjatar</option>
                                                <option value="Ner'zhul" >Ner'zhul</option>
                                                <option value="Onyxia" >Onyxia</option>
                                                <option value="Rivendare" >Rivendare</option>
                                                <option value="Shattered Halls" >Shattered Halls</option>
                                                <option value="Spinebreaker" >Spinebreaker</option>
                                                <option value="Spirestone" >Spirestone</option>
                                                <option value="Stonemaul" >Stonemaul</option>
                                                <option value="Stormscale" >Stormscale</option>
                                                <option value="Tichondrius" >Tichondrius</option>
                                                <option value="Ursin" >Ursin</option>
                                                <option value="Vashj" >Vashj</option>
                                            </select>

                                        </td>
                                        <td colspan="2" class="col2">
                                            Looking For<br />
                                            <select name="lookingFor" class="form-control" required>
                                                <option value="">-Choose Looking For-</option>
                                                <option value="LFG">Looking for Group</option>
                                                <option value="LFM">Looking for More</option>

                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="2" class="col2">
                                            Player Class<br />
                                            <select name="playerClass" class="form-control" required>
                                                <option value="">Choose a Class</option>
                                                <option value="Tank">Tank</option>
                                                <option value="Healer">Healer</option>
                                                <option value="DPS">DPS</option>
                                                <option value="Warrior">Warrior</option>
                                                <option value="Paladin">Paladin</option>
                                                <option value="Hunter">Hunter</option>
                                                <option value="Rogue">Rogue</option>
                                                <option value="Priest">Priest</option>
                                                <option value="Death Knight">Death Knight</option>
                                                <option value="Shaman">Shaman</option>
                                                <option value="Mage">Mage</option>
                                                <option value="Warlock">Warlock</option>
                                                <option value="Monk">Monk</option>
                                                <option value="Druid">Druid</option>
                                                <option value="Demon Hunter">Demon Hunter</option>

                                            </select>

                                        </td>
                                        <td>
                                            Level<br />
                                            <input type="number" class="numberInput, textField" name="level" value="" required>

                                        </td>
                                        <td>
                                            Item Level<br />
                                            <input type="number" class="numberInput, textField" name="gearRating" value="" required>

                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="2" class="col2">
                                            Activity<br />
                                            <select name="activity" class="form-control" required>
                                                <option value="">Choose an Activity</option>
                                                <option value="Vault Of Glass">Vault of Glass</option>
                                                <option value="Crystal Tower">Crystal Tower</option>
                                                <option value="Undercover">Undercover</option>
                                            </select>

                                        </td>
                                        <td colspan="2" class="col2">
                                            Experience (Optional) <br />
                                            <!--<input type="button" value="Novice"/>
                                            <input type="button" value="Sherpa"/>-->
                                            <select name="experience" class="form-control">
                                                <option value=""></option>
                                                <option value="Sherpa">Sherpa</option>
                                                <option value="Beginner">Beginner</option>

                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="4" class="col4">
                                            Description<br />
                                            <input type="text" name="description" class="descriptionInput" required/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="2" class="col2">
                                            <div class="checkbox">
                                                <label><input type="checkbox" name="haveMic" value="true">I have a mic</label>
                                            </div>
                                        </td>
                                        <td>
                                            <input type="submit" name="submit" value="Submit" />
                                        </td>
                                        <td>
                                            <input type="reset" name="reset" value="Clear" />
                                        </td>
                                    </tr>
                                </table>
                            </form>
                        </c:otherwise>
                    </c:choose>

                </div>
            </div>
        </div>
    </div>

</div>
