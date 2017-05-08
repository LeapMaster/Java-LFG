<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 4/19/17
  Time: 8:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="panel-group" id="accordion">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h4 class="panel-title">
                <a data-toggle="collapse" data-parent="#accordion" href="#collapse1">New Listing</a>
            </h4>
        </div>
        <div id="collapse1" class="panel-collapse collapse">
            <div class="panel-body">
                <div>
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
                                        <option value="North America">North America</option>
                                        <option value="Europe">Europe</option>
                                        <option value="Asia">Asia</option>
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
                </div>
            </div>
        </div>
    </div>

</div>
