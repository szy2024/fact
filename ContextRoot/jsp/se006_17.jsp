
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/jsp/incTop.jsp" %>
<%@ page import="jp.go.jfc.partnernet.common.PNCommonMessageConstants" %>
<%@ page import="jp.go.jfc.partnernet.pnfw.common.PNMessageUtils" %>

<%--================================================================================================
 * Project Name : パートナーネット開発
 * System Name  : パートナーネット
 * File Name    : Se006_17.jsp
 *
 * <<Modification History>>
 * Version | Date       | Updated By            | Content
 * --------+------------+-----------------------+---------------------------------------------------
 * 2.0.0   | 2017/10/05 | 嶋田　美保            | H29年追加開発案件対応
================================================================================================--%>

<html>
	<%@ include file="/jsp/incHeader.jsp"%>
	<head>
		<title><parts:message code="title.screenName"/></title>
		<link href="<%=request.getContextPath()%>/css/se006_17.css" type="text/css" rel="stylesheet" />
		<script lang="JavaScript" type="text/javascript">
		<%-- 戻るボタン押下時の処理 --%>
		function click_backBtn() {
			executeAction('../../se006/se006_17/Se006_17Back.form');
		}

		<%-- ダウンロード押下時の処理 --%>
		function click_btnDownload() {
			executeAction('../../se006/se006_17/Se006_17Download.form');
		}
		</script>
	</head>
	<body onload="initTextFormat()">
		<parts:form modelAttribute="se006_17Form" action="./Se006_17Init.form"
			id="Form1" method="post" enctype="multipart/form-data"
			onsubmit="return false;">
			<%@ include file="/jsp/incCommonHidden.jsp"%>
			<%@ include file="/jsp/incHeaderArea.jsp"%>
			<div id="main_scroll_area">
				<div class="header">
					<div class="title">
						<label id="lblTitle" class="title"><parts:message
								code="title.screenName" /></label>
					</div>
				</div>
				<div class="main">
					<%-- 該当データなしの場合 --%>
					<c:if test="${se006_17Form.getLblID_BizErrorCount() != 0}" >
						<div  class="status">
							<span id="se006_ID17_Detail_UC_lblError" class="errorMessage">
								<parts:errors path="*"/>
							</span>
						</div>
						<div class="buttons">
						<parts:button id="btnBack2" value="戻る" onclick="click_backBtn();" />
						</div>
					</c:if>
					<%-- 該当データありの場合 --%>
					<c:if test="${se006_17Form.getLblID_BizErrorCount() == 0}" >
						<div class="status">
							<span id="se006_ID17_Detail_UC_lblError" class="errorMessage">
								<parts:errors path="*"/>
							</span>
						</div>
						<div class="buttons">
							<parts:button id="btnBack2" value="戻る" onclick="click_backBtn();" />
						</div>
						<div class="status">
							<span class="errorMessage">
								<parts:dlabel path="lblErr" />
							</span>
						</div>
						<parts:table cssClass="se006List">
							<tr>
								<td class="itemName"><span>発信者</span></td>
								<td class="item"><parts:dlabel
										path="lblID_Name_Organization" /></td>
							</tr>
							<tr>
								<td class="itemName"><span>発信日</span></td>
								<td class="item"><parts:dlabel path="lblID_SendDate_Report" />
								</td>
							</tr>
							<tr>
								<td class="itemName"><span>登録済み添付ファイル</span></td>
								<td class="item">
									<table class="fileName">
										<tr>
											<td width="650px"><parts:dlabel path="lblID_Disp_DocName" />
											</td>
											<td><parts:button id="btnDownload" value="ダウンロード" onclick="click_btnDownload();" />
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</parts:table>
					</c:if>
				</div>
			</div>
		</parts:form>
		<%@ include file="/jsp/incDownloadArea.jsp"%>
		<%@ include file="/jsp/incFooter.jsp"%>
	</body>
</html>