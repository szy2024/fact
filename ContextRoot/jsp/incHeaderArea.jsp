<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="parts" uri="http://www.fujitsu.com/pnfw/tags/parts"%>
<%@ taglib prefix="logic" uri="http://www.fujitsu.com/pnfw/tags/logic"%>
<%-- styleシート読込 --%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/header.css" type="text/css" />
<script type="text/javascript" lang="JavaScript">
<!--
	<%
	String str = request.getContextPath();
	%>
	<%-- ログアウトボタン処理 --%>
    function click_btnLogout() {
        executeAction('<%= str %>/cm002/cm002_05/Cm002_05Init.form');
    }

	<%-- お知らせボタン処理 --%>
    function click_btnMenuInfo() {
        executeAction('<%= str %>/ut001/ut001_01/Ut001_01Init.form');
    }

	<%-- 報告書作成ボタン処理 --%>
    function click_btnMenuCreate() {
        executeAction('<%= str %>/cm002/cm002_02/Cm002_02Init.form');
    }

	<%-- 報告書取消･修正ボタン処理 --%>
    function click_btnMenuUpdate() {
        executeAction('<%= str %>/md000/md000_01/Md000_01Init.form');
    }

	<%-- 照会ボタン処理 --%>
    function click_btnMenuInquiry() {
        executeAction('<%= str %>/cm002/cm002_03/Cm002_03Init.form');
    }

	<%-- システム運用ボタン処理 --%>
    function click_btnMenuSysman() {
        executeAction('<%= str %>/cm002/cm002_04/Cm002_04Init.form');
    }

-->
</script>
<logic:notEmpty path="commonInfo">
<style type="text/css">
#btnMenuInfo {
	background-color: <parts:dlabel path="btnMenuInfoBGColor" />
}
#btnMenuCreate {
	background-color: <parts:dlabel path="btnMenuCreateBGColor" />
}
#btnMenuUpdate {
	background-color: <parts:dlabel path="btnMenuUpdateBGColor" />
}
#btnMenuInquiry {
	background-color: <parts:dlabel path="btnMenuInquiryBGColor" />
}
#btnMenuSysman {
	background-color: <parts:dlabel path="btnMenuSysmanBGColor" />
}
</style>
	<table class="header">
        <tr>
        	<%-- ヘッダーイメージ表示 --%>
            <td class="upperleft" rowspan="3">
            	<%-- ログアウトボタン --%>
            	<parts:button cssClass="logout_button" id="btnLogout" onclick="click_btnLogout();">
            		<parts:message code="PN_CM002_01_LBL_09"/>
            	</parts:button>
            </td>
           	<%-- ログインユーザ名（漢字）表示 --%>
            <td class="loginname">
    			<parts:dlabel path="commonInfo.Name_Kanji" />
    			<parts:message code="PN_CM002_01_LBL_02"/>
    		</td>
        </tr>
        <tr>
           	<%-- 前回ログイン日時表示 --%>
            <td class="logintime">
            	<%-- パスワード残り日数表示 --%>
                <logic:notEqual path="commonInfo.PasswordValidMsg" value="">
                    <parts:message code="PN_CM002_01_LBL_10"/>
                    <span style="color:red;font-weight:bold;">
                        <parts:dlabel path = "commonInfo.PasswordValidMsg" />
                    </span>
                    <parts:message code="PN_CM002_01_LBL_11"/>
                </logic:notEqual>
                <parts:message code="PN_CM002_01_LBL_03"/>
            	<%-- <parts:dlabel path="commonInfo.DateTime_LastLogon" /> --%>
            	<parts:dlabel path="lastLogonDateTimeWereki" />
    		</td>
        </tr>
        <tr>
        	<%-- ヘッダーメニュー表示 --%>
        	<%-- 改行によるメニュー間の隙間をなくすため、改行をコメントアウト --%>
            <td class="headermenu">
            	<%-- お知らせボタン --%>
				<parts:button cssClass="headerBotton" id="btnMenuInfo" onclick="click_btnMenuInfo();">
					<parts:message code="PN_CM002_01_LBL_04"/>
				</parts:button><%--
				    報告書作成ボタン
           		--%><parts:button cssClass="headerBotton" id="btnMenuCreate" onclick="click_btnMenuCreate();">
           			<parts:message code="PN_CM002_01_LBL_05"/>
           		</parts:button><%--
           		    報告書取消・修正ボタン
           		--%><parts:button cssClass="headerBotton" id="btnMenuUpdate" onclick="click_btnMenuUpdate();">
           			<parts:message code="PN_CM002_01_LBL_06"/>
           		</parts:button><%--
           		    照会ボタン
           		--%><parts:button cssClass="headerBotton" id="btnMenuInquiry" onclick="click_btnMenuInquiry();">
           			<parts:message code="PN_CM002_01_LBL_07"/>
           		</parts:button><%--
           		    システム運用ボタン
          		--%><parts:button cssClass="headerBotton" id="btnMenuSysman" onclick="click_btnMenuSysman();">
          			<parts:message code="PN_CM002_01_LBL_08"/>
          		</parts:button>
            </td>
        </tr>
    </table>
</logic:notEmpty>
<logic:empty path="commonInfo">
    <table class="header">
 	   <tr>
            <td class="upperleft">
            	<%-- ログアウトボタン --%>
            	<parts:button cssClass="logout_button" id="btnLogout" onclick="click_btnLogout();">
            		<parts:message code="PN_CM002_01_LBL_09"/>
            	</parts:button>
            </td>
       </tr>
    </table>
</logic:empty>
