<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/jsp/incTop.jsp"%>

<%--================================================================================================
 * Project Name : パートナーネット開発
 * System Name  : パートナーネット
 * File Name    : cr003_01.jsp
 *
 * <<Modification History>>
 * Version | Date       | Updated By            | Content
 * --------+------------+-----------------------+---------------------------------------------------
 * 1.0.0   | 2015/07/01 | 澤田　健一            | 新規作成
================================================================================================--%>

<html>
<%@ include file="/jsp/incHeader.jsp"%>
<head>
	<title><parts:message code="title.screenName"/></title>
	<link href="<%=request.getContextPath()%>/css/gju_Create.css"type="text/css" rel="stylesheet" />
	<script lang="JavaScript" type="text/javascript">
	<!--
		<%--
		- 検索ボタン押下時の処理
		--%>
		function click_searchBtn() {
			executeAction('../../cr003/cr003_01/Cr003_01Search.form');
		}
		<%-- 戻るボタン処理 --%>
		function click_backBtn() {
			executeAction('../../cr003/cr003_01/Cr003_01Return.form');
		}
	//-->
	</script>
</head>
<body>
	<parts:form modelAttribute="cr003_01Form" action="./Cr003_01Init.form"
		id="form1" method="post" onsubmit="return false;">
		<%@ include file="/jsp/incCommonHidden.jsp"%>
		<%@ include file="/jsp/incHeaderArea.jsp"%>
		<div id="main_scroll_area">
		<div class="header">
			<div class="title">
				<label id="lblTitle" class="Title"><parts:message code="title.screenName"/></label>
			</div>
		</div>
		<div class="main">
			<div class="subtitle">払込期日の指定</div>
			<div class="greeting">
				払込期日を選択し、「検索実行」ボタンをクリックしてください。<br /> 報告対象となる案件が検索されます。
			</div>
			<br />
			<div class="status" style="color: red; font-weight: bold;">
				<parts:errors path="*" cssClass="Error" />
			</div>
			<div>払込期日</div>
			<br />
			<div>
				<parts:select path="drpID_Date_Haraikomi_Year"
					id="drpID_Date_Haraikomi_Year" style="color:#003399;">
					<parts:codeListOption categoryCode="00002" />
				</parts:select>
				<parts:text path="txtID_Date_Haraikomi" id="txtID_Date_Haraikomi"
					style="text-align:center;" maxlength="2" size="2" />
				&nbsp;年&nbsp;&nbsp;
				<parts:select path="drpID_Date_Haraikomi_Month"
					id="drpID_Date_Haraikomi_Month" style="color:#003399;">
					<parts:codeListOption categoryCode="00003" />
				</parts:select>
				&nbsp;月&nbsp;&nbsp;
				<parts:select path="drpID_Date_Haraikomi_Date"
					id="drpID_Date_Haraikomi_Date" style="color:#003399;">
					<parts:codeListOption categoryCode="00004" />
				</parts:select>
				&nbsp;日&nbsp;&nbsp;
			</div>
			<div class="buttons">
				<parts:button id="btnSearch2" value="検索" onclick="click_searchBtn()" />
				<div style="display: none;">
					<parts:button id="btnSearch" />
				</div>
			</div>
		</div>
	</div>
	</parts:form><%@ include file="/jsp/incFooter.jsp"%>
</body>
</html>