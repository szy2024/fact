<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%--================================================================================================
 * Project Name : パートナーネット開発
 * System Name  : パートナーネット
 * File Name    : se001_01.jsp
 *
 * <<Modification History>>
 * Version | Date       | Updated By            | Content
 * --------+------------+-----------------------+---------------------------------------------------
 * 1.0.0   | 2015/07/01 | 小林　浩二            | 新規作成
================================================================================================--%>
<%@ include file="/jsp/incTop.jsp"%>

<html>
<%@ include file="/jsp/incHeader.jsp"%>
<head>
<title><parts:message code="title.screenName"/></title>
<link href="<%=request.getContextPath()%>/css/se001.css" type="text/css" rel="stylesheet" />
<script lang="JavaScript">
<!--
<%--
- 検索ボタン押下時の処理
--%>
    function click_searchBtn() {
        executeAction('../../se001/se001_01/Se001_01Search.form');
    }
//-->
</script>
</head>
<body>
	<parts:form modelAttribute="se001_01Form" action="./se001_01Init.form" id="form1" method="post" onsubmit="return false;">
		<%@ include file="/jsp/incCommonHidden.jsp"%>
		<%@ include file="/jsp/incHeaderArea.jsp"%>
		<div id="main_scroll_area">
		<div class="header">
			<div class="title">
				<label id="lblTitle" class="Title"><parts:message code="title.screenName"/></label>
			</div>
		</div>
		<div class="main">
			<div class="greeting">顧客名を入力し［検索］ボタンを押してください。</div>
			<div class="status" style="color: red; font-weight: bold;">
				<parts:errors path="*" cssClass="Error" />
			</div>
			<br>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<parts:text path="txtID_Name_Customer" id="txtID_Name_Customer" maxlength="20" size="50"/>
			<parts:button id="btnSearch2" value="検索" onclick="click_searchBtn();" />
			<div class="buttons">
				<parts:button id="btnSearch" style="display:none;" onclick="click_searchBtn();" />
			</div>
		</div>
	</div>
	</parts:form><%@ include file="/jsp/incFooter.jsp"%>
</body>
</html>