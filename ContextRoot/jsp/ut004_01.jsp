<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%--================================================================================================
 * Project Name : パートナーネット開発
 * System Name  : パートナーネット
 * File Name    : ut004_01.jsp
 *
 * <<Modification History>>
 * Version | Date       | Updated By            | Content
 * --------+------------+-----------------------+---------------------------------------------------
 * 1.0.0   | 2015/09/25 | 譚　暁玉              | 新規作成
 * 2.0.0   | 2019/01/11 | 林　晃平              | 農林PN元号対応
================================================================================================--%>
<%@ include file="/jsp/incTop.jsp" %>
<html>
<head>
<%@ include file="/jsp/incHeader.jsp"%>
<title><parts:message code="title.screenName"/></title>
<script lang="JavaScript">
<!--

	<%-- 登録ボタン押下時の処理 --%>
	function click_btnUpdate() {
		executeAction('../../ut004/ut004_01/Ut004_01Update.form');
	}

	function changeDropDown() {
		if ($("#drpID_ID_InfoType").val() == "1") {
			$("#txtID_ID_DocNumber").attr("readonly", false);
		} else {
			$("#txtID_ID_DocNumber").val("");
			$("#txtID_ID_DocNumber").attr("readonly", true);
		}
		if ($("#drpID_ID_InfoType").val() == "4") {
			$("#txtID_ID_FormatNumber").attr("readonly", false);
		} else {
			$("#txtID_ID_FormatNumber").val("");
			$("#txtID_ID_FormatNumber").attr("readonly", true);
		}

	}

//-->
</script>
<%-- styleシート読込 --%>
<%-- <link href="<%=strResourceURL%>/ut001.css" type="text/css" rel="stylesheet" />--%>
<link href="<%=request.getContextPath()%>/css/ut004.css" type="text/css" rel="stylesheet"/>
</head>
<body onload="changeDropDown()">
	<parts:form modelAttribute="ut004_01Form" method="post" enctype="multipart/form-data">
		<%@ include file="/jsp/incCommonHidden.jsp" %>
		<%@ include file="/jsp/incHeaderArea.jsp" %>
		<div id="main_scroll_area">
<div class="header">
	<div class="title" id="Button1">
		<div class="title">
			<label id="lblTitle" class="Title"><parts:message code="title.screenName"/></label>
		</div>
	</div>
</div>

<div class="main">
	<div class="status">
	    <span class="errorMessage">
	        <parts:errors path="*" />
	        <br />
	    </span>
	</div>

	<div>
<%-- 業務エリア --%>
		<div class="greeting">
			※登録を行う文書情報を「文書種別」ドロップダウンリストより選択して下さい。<br>
			　「日付」項目に以下の年月日を指定して下さい。
			<div style="margin-left:30px">
				・通知･事務連絡：日付<br>
				・金利改定情報：改定日<br>
				・要領･マニュアルの改正情報：改正日<br>
				・様式集の改正情報：改正日
			</div>
		</div>
		<br />

		<parts:table>
			<tr>
				<td>文書種別
				</td>
				<td>
<%-- 					<parts:dlabel path="lblID_ID_InfoType_Display" /> --%>
						<parts:select path="drpID_ID_InfoType" id="drpID_ID_InfoType" onchange="changeDropDown()" >
						<parts:codeListOption categoryCode="00005" />
						</parts:select>

				</td>
			</tr>
			<tr>
				<td>文書名
				</td>
				<td>
					<parts:text path="txtID_ID_DocName" id="txtID_ID_DocName" style="width:431px;" maxlength="256" size="256" />
				</td>
			</tr>
			<tr>
				<td>文書番号</td>
				<td>
					<parts:text path="txtID_ID_DocNumber" id="txtID_ID_DocNumber" style="width:360px;" maxlength="50" size="50" />
				</td>
			</tr>
			<tr>
				<td>様式番号</td>
				<td>
					<parts:text path="txtID_ID_FormatNumber" id="txtID_ID_FormatNumber" style="width:150px;" maxlength="20" size="20" />
				</td>
			</tr>
			<tr>
				<td style="height: 20px;">日付</td>
				<td style="height: 20px;">
<%-- [UPD] Ver 2.0.0 - START --%>
<%-- 					平成 --%>
					<parts:select path="drpID_DateTime_DocUpdate_Gengo" id="drpID_DateTime_DocUpdate_Gengo" style="width:40px;">
						<parts:codeListOption categoryCode="00002" />
					</parts:select>
<%-- [UPD] Ver 2.0.0 - END --%>
					<parts:text path="txtID_DateTime_DocUpdate_Year" id="txtID_DateTime_DocUpdate_Year" style="width:30px;" maxlength="2" size="10" />年
					<parts:select path="drpID_DateTime_DocUpdate_Month" id="drpID_DateTime_DocUpdate_Month" style="width:40px;">
						<parts:codeListOption categoryCode="00003" />
					</parts:select>月
					<parts:select path="drpID_DateTime_DocUpdate_Day" id="drpID_DateTime_DocUpdate_Day" style="width:40px;">
						<parts:codeListOption categoryCode="00004" />
					</parts:select>日
				</td>
			</tr>
			<tr>
				<td>登録ファイル名
				</td>
				<td>
					<parts:file path="fileUpload" size="30" />
				</td>
			</tr>
		</parts:table>
		<br />
	</div>
	<div class="button">
		<parts:button id="btnUpdate" value="登録" onclick="click_btnUpdate();" /><br />
	</div>
</div>
	</div>
	</parts:form>
			<div><font face="MS UI Gothic"></font></div>
			<%@ include file="/jsp/incFooter.jsp"%>

</body>
</html>