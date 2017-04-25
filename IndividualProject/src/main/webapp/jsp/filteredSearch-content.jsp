<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 4/24/17
  Time: 11:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="panel-group" id="accordion">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h4 class="panel-title">
                <a data-toggle="collapse" data-parent="#accordion" href="#collapse2">Filters</a>
            </h4>
        </div>
        <div id="collapse2" class="panel-collapse collapse in">
            <div class="panel-body">
                <div>
                    <form action="home" method="post">
                        <table class="table formTable">
                            <tr>
                                <td colspan="2" class="col2">
                                    Platform<br />
                                    <select name="platform" class="form-control">
                                        <option value="any">Any Platform</option>
                                        <option value="Xbox">Xbox</option>
                                        <option value="Playstation">Playstation</option>
                                        <option value="PC">PC</option>

                                    </select>

                                </td>
                                <td colspan="2" class="col2">
                                    Region<br />
                                    <select name="region" class="form-control">
                                        <option value="any">Any Region</option>
                                        <option value="North America">North America</option>
                                        <option value="Europe">Europe</option>
                                        <option value="Asia">Asia</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" class="col2">
                                    Activity<br />
                                    <select name="activity" class="form-control">
                                        <option value="any">Any Activity</option>
                                        <option value="Vault Of Glass">Vault of Glass</option>
                                        <option value="Crystal Tower">Crystal Tower</option>
                                        <option value="Undercover">Undercover</option>
                                    </select>

                                </td>
                                <td colspan="2" class="col2">
                                    Experience<br />
                                    <!--<input type="button" value="Novice"/>
                                    <input type="button" value="Sherpa"/>-->
                                    <select name="experience" class="form-control">
                                        <option value="any">Any</option>
                                        <option value="Sherpa">Sherpa</option>
                                        <option value="Beginner">Beginner</option>

                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2">
                                    Minimum Level<br />
                                    <input type="number" class="numberInput, textField" name="level" value="" placeholder="Any">

                                </td>
                                <td colspan="2">
                                    Minimum Gear Rating<br />
                                    <input type="number" class="numberInput, textField" name="gearRating" value="" placeholder="Any">
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2">
                                    <div class="checkbox">
                                        <label><input type="checkbox" name="requireMic" value="true">Require Mic</label>
                                    </div>
                                </td>
                                <td colspan="2">
                                    Looking For <br />
                                    <select name="lookingFor" class="form-control">
                                        <option value="all">All</option>
                                        <option value="LFG">Group</option>
                                        <option value="LFM">More</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
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