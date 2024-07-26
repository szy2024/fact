<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%--================================================================================================
 * Project Name : パートナーネット開発
 * System Name  : パートナーネット
 * File Name    : se006_04.jsp
 *
 * <<Modification History>>
 * Version | Date       | Updated By            | Content
 * --------+------------+-----------------------+---------------------------------------------------
 * 1.0.0   | 2015/07/01 | 橋本　亮              | 新規作成
================================================================================================--%>
<%@ include file="/jsp/incTop.jsp" %>
<html>
	<%@ include file="/jsp/incHeader.jsp"%>
	<head>
		<title><parts:message code="title.screenName"/></title>

		<script lang="JavaScript">
<!--
		    <%-- 戻るボタン処理 --%>
		    function click_backBtn() {
		        executeAction('../../se006/se006_04/Se006_04Back.form');
		    }
 //-->
		</script>

                <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/se006.css" />
	</head>
	<body>
		<parts:form modelAttribute="se006_04Form" id="Form1" method="post">
		<%@ include file="/jsp/incCommonHidden.jsp" %>
		<%@ include file="/jsp/incHeaderArea.jsp" %>
			<div id="main_scroll_area">
				<div class="header">
				<div class="title">
					<label id="lblTitle" class="Title"><parts:message code="title.screenName"/></label>
				</div>
			</div>
			<div class="main">
				<div class="status">
					<span id="se006_ID04_Detail_UC_lblError" class="errorMessage">
						<parts:errors path="*"/>
					</span>
				</div>
				<div>
					<parts:button path="btnBack" id="btnBack" value="戻る" onclick="click_backBtn()" />
				</div>
				<div>
<p>
	<parts:dlabel path="lblErrorMsg"  />
</p>
				</div>
			</div>
		</div>
		</parts:form><%@ include file="/jsp/incFooter.jsp"%>

	</body>
</html>