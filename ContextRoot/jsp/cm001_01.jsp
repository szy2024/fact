<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/jsp/incTop.jsp" %>
<%--================================================================================================
 * Project Name : パートナーネット開発
 * System Name  : パートナーネット
 * File Name    : cm001_01.jsp
 *
 * <<Modification History>>
 * Version | Date       | Updated By            | Content
 * --------+------------+-----------------------+---------------------------------------------------
 * 1.0.0   | 2015/07/31 | 乃村　賢司            | 新規作成
================================================================================================--%>
<html>
<head>
<%@ include file="/jsp/lgnHeader.jsp"%>
<title><parts:message code="title.screenName"/></title>
<link href="<%= request.getContextPath() %>/css/cm001.css" type="text/css" rel="stylesheet" />
<script lang="JavaScript">
<!--
<%--
- 検索ボタン押下時の処理
--%>
    function click_logonBtn() {
        var form1 = document.forms.form1;
        if (form1.LogonID.value.length > 16 || form1.Password.value.length > 20) {
            errorMessage = "ユーザIDまたはパスワードに誤りがあります。";
            flushErrorMessage("cm001_ID01_Lonon_UC_lblError");
            return false;
        }
        executeAction('../../cm001/cm001_01/Cm001_01Logon.form');
    }
    function click_changePasswordBtn() {
        executeAction('../../cm001/cm001_01/Cm001_01ChangePassword.form');
    }
//-->
</script>
</head>
    <body>
        <parts:form  modelAttribute="cm001_01Form" id="form1" action="./Cm001_01Logon.form" method="post"  autocomplete="off" onsubmit="click_logonBtn(); return false;">
            <div style="width:100%; text-align:right;color:#ffffff;"><%

    String svnurl = "$URL: file:///C:/Users/2014P14026/Desktop/svn_repository/tags/20160418_%E9%9A%9C%E5%AE%B3%E5%AF%BE%E5%BF%9C%E6%B8%88%E3%81%BF%E3%82%BD%E3%83%BC%E3%82%B9/PartnerNet/ContextRoot/jsp/cm001_01.jsp $";
    String svntag = "$Revision: 1659 $";
    if (svnurl.indexOf("/tags/") > -1) {
        svntag = svnurl.substring(svnurl.indexOf("/tags/") + 6);
        svntag = svntag.substring(0, svntag.indexOf("/"));
    }
    out.print(svntag);

            %></div>
            <%@ include file="/jsp/incCommonHiddenLogon.jsp" %>
            <div class="main">
                <div class="greeting"></div>
                <div class="status">
                    <span id="cm001_ID01_Lonon_UC_lblError" class="errorMessage">
                        <parts:errors path="*" />
                        <br />
                    </span>
                </div>
                <br />
                <parts:table>
                    <tr>
                        <td class="lowerright" style="vertical-align:top;" >
                            <div class="login_entry-box">
                                <div></div>
                                <div style="background-color:#C0C0C0;padding:10px 20px 20px 10px">
                                    <parts:table cssClass="login_entry">
                                        <tr >
                                            <th class="user"><parts:message code="LogonID" /></th>
                                        </tr>
                                        <tr>
                                            <td style="width:150px;">
                                                <parts:text path="LogonID" size="8" maxlength="16" style="width:200px;" cssErrorClass="inputError" />
                                            </td>
                                        </tr>
                                        <tr>
                                            <th class="pass"><parts:message code="Password" /></th>
                                        </tr>
                                        <tr>
                                            <td style="width:150px;">
                                                <parts:password path="Password" size="8" maxlength="20" style="width:200px;" cssErrorClass="inputError" /></td>
                                        </tr>
                                        <tr>
                                            <td><br/></td>
                                        </tr>
                                        <tr>
                                            <td><span class="btn">
                                                <input type="submit" id="btnLogon" style="width:120px;" value="<parts:message code="button.btnLogon" />" />
                                                </span>
                                            </td>
                                        </tr>
                                        <tr>
                                        	<td><br/>
                                        		○ログオンの場合<br/>
                                        		　ユーザ名とパスワードの２項目を入力して、<br/>
                                        		「ログオン」ボタンをクリックしてください。<br/>
                                        		<div style="color:red;">※「パスワード変更」ボタンをクリックしないこと。<br/></div>
                                        		<br/>
                                        		○ユーザにおいてパスワードの変更を行う場合<br/>
                                        		　ユーザ名とパスワードの２項目を入力して、<br/>
                                        		「パスワード変更」ボタンをクリックしてください。<br/>
                                        		パスワード変更画面が表示されますので、変更<br/>
                                        		手続きを行ってください。<br/>
                                        	<br/></td>
                                        </tr>
                                        <tr>
                                            <td><span class="btn">
                                                <parts:button id="btnChangePassword" style="width:120px;" onclick="click_changePasswordBtn();"><parts:message code="button.btnChangePassword" /></parts:button>
                                                </span>
                                            </td>
                                        </tr>
                                    </parts:table>
                                </div>
                            </div>
                        </td>
                        <td style="padding-left: 100px;"></td>
                        <td>
                            <parts:table cssClass="login_image">
                                <tr><td><br/></td></tr>
                            </parts:table>
                        </td>
                    </tr>
                </parts:table>
            </div>
        </parts:form><%@ include file="/jsp/incFooter.jsp"%>

    </body>
</html>