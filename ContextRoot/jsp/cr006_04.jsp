
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/jsp/incTop.jsp"%>

<%--================================================================================================
 * Project Name : パートナーネット開発
 * System Name  : パートナーネット
 * File Name    : cr006_04.jsp
 *
 * <<Modification History>>
 * Version | Date       | Updated By            | Content
 * --------+------------+-----------------------+---------------------------------------------------
 * 1.0.0   | 2015/07/01 | 橋本　亮　            | 新規作成
================================================================================================--%>

<html>
	<%@ include file="/jsp/incHeader.jsp"%>
	<head>
		<title><parts:message code="title.screenName"/></title>
		<script lang="JavaScript">
<!--
<%--
	- OKボタン押下時の処理
--%>
			function click_okBtn() {
				executeAction('../../cr006/cr006_04/Cr006_04Ok.form');
 			}
//-->
</script>
		<link href="<%=request.getContextPath()%>/css/cr006.css" type="text/css" rel="stylesheet" />
	</head>

	<body>
		<parts:form modelAttribute="cr006_04Form"  id="Form1" method="post">
			<%@ include file="/jsp/incCommonHidden.jsp" %>
			<%@ include file="/jsp/incHeaderArea.jsp" %>
			<div id="main_scroll_area">
			<div class="header" >
				<div class="title">
					<span class="Title" id="lblTitle"><parts:message code="title.screenName"/></span>
				</div>
			</div>
			<div class="main"  style="align:center">
				<div align="center"><b>データ登録完了</b><br /></div>
				<div align="center" >
	                <div class="status" style="color: red; font-weight: bold;">
	                    <parts:errors path="*" cssClass="Error" />
	                </div>
				</div>
				<div align="center"><font face="MS UI Gothic">データの登録が完了しました。<br />
						[OK]ボタンをクリックしてください。</font></div>
				<div align="center">
					<parts:button id="btnOK" value="OK" title="立替金受入・充当報告書の対象案件一覧へ戻る" onclick="click_okBtn();" /></div>
			</div>
		</div>
		</parts:form><%@ include file="/jsp/incFooter.jsp"%>

	</body>
</html>