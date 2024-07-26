 <%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/jsp/incTop.jsp" %>

<%--================================================================================================
 * Project Name : パートナーネット開発
 * System Name  : パートナーネット
 * File Name    : md003_03.jsp
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
//<!--
            <%-- OKボタン処理 --%>
            function click_okBtn() {
                executeAction('../../md003/md003_03/Md003_03Ok.form');
            }
//-->
        </script>

		<link href="<%=request.getContextPath()%>/css/gju_Mod.css" type="text/css" rel="stylesheet" />
	</head>
	<body>
		<parts:form id="Form1" modelAttribute="md003_03Form"  action="./Se003_03Init.form" method="post" onsubmit="return false;" >
			<%@ include file="/jsp/incCommonHidden.jsp" %>
			<%@ include file="/jsp/incHeaderArea.jsp" %>
			<div id="main_scroll_area">
			<div class="header">
				<div class="title">
					<span class="Title" id="lblTitle"><parts:message code="title.screenName"/></span>
				</div>
			</div>
			<div class="main">
				<p align="center"><b>データ登録完了画面</b></p>
				<br />
				<div align="center" >
	                <div class="status" style="color: red; font-weight: bold;">
	                    <parts:errors path="*" cssClass="Error" />
	                </div>
				</div>
				<p align="center">
				<font face="MS UI Gothic">データの登録が完了しました。<br />
						［OK］ﾎﾞﾀﾝを押してください。</font></p>
				<div align="center">
					<div align="center" style="display:none;">
						<parts:button id="btnOK" />
					</div>
					<parts:button id="btnOK2" value=" OK " title="取消・修正対象報告書の一覧画面へ戻る" onclick="click_okBtn()" />
				</div>
			</div>
		</div>
		</parts:form><%@ include file="/jsp/incFooter.jsp"%>
	</body>
</html>