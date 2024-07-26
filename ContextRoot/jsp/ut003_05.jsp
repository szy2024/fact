<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/jsp/incTop.jsp"%>

<%--================================================================================================
 * Project Name : パートナーネット開発
 * System Name  : パートナーネット
 * File Name    : ut003_05.jsp
 *
 * <<Modification History>>
 * Version | Date       | Updated By            | Content
 * --------+------------+-----------------------+---------------------------------------------------
 * 1.0.0   | 2015/10/02 | 松井　元気            | 新規作成
================================================================================================--%>
<html>
	<%@ include file="/jsp/incHeader.jsp"%>
	<head>
		<title><parts:message code="title.screenName"/></title>
		<script lang="JavaScript">
		<!--
			<%-- 検索ボタン押下時の処理 --%>
			function click_btnBack() {
				executeAction('../../ut003/ut003_05/Ut003_05Back.form');
			}
			<%-- 削除ボタン押下時の処理 --%>
			function click_btnUpdate() {
				executeAction('../../ut003/ut003_05/Ut003_05Delete.form');
			}
			<%-- 再表示ボタン押下時の処理 --%>
			function click_btnReload() {
				executeAction('../../ut003/ut003_05/Ut003_05Reload.form');
			}
			<%-- 全選択ボタン押下時の処理 --%>
			function click_btnDeleteAllCheck() {
				executeAction('../../ut003/ut003_05/Ut003_05Deleteallcheck.form');
			}
			<%-- 全解除ボタン押下時の処理 --%>
			function click_btnDeleteAllDelete() {
				executeAction('../../ut003/ut003_05/Ut003_05Deletealldelete.form');
			}
			<%-- アンカークリック処理 --%>
			function click_ID_ID_DocName(selectedIndex) {
				document.forms[0].elements["selectedIndex"].value = selectedIndex;
				executeAction('../../ut003/ut003_05/Ut003_05Name.form');
			}
			<%-- ページング処理 --%>
			function click_pageNo() {
				executeAction('../../ut003/ut003_05/Ut003_05Pageing.form');
			}
			function click_prePage() {
				executeAction('../../ut003/ut003_05/Ut003_05Pageing.form');
			}
			function click_nextPage() {
				executeAction('../../ut003/ut003_05/Ut003_05Pageing.form');
			}
		//-->
		</script>
		<link href="<%=request.getContextPath()%>/css/ut003.css" type="text/css" rel="stylesheet" />
	</head>
	<body>
		<parts:form modelAttribute="ut003_05Form" action="./ut003_05Init.form" method="post" onsubmit="return false;">
			<%@ include file="/jsp/incCommonHidden.jsp" %>
			<%@ include file="/jsp/incHeaderArea.jsp" %>
			<div id="main_scroll_area">
			<parts:hidden path="selectedIndex"/>
			<div class="header">
				<div class="title">
					<span class="Title" id="lblTitle"><parts:message code="title.screenName"/></span>
				</div>
			</div>
			<div class="main">
				<label id="Label_info">様式名をクリックしてファイルの内容を確認した後、[削除]チェックボックスにチェックをし、<br />[削除]ボタンをクリックしてください。<br />[削除]チェックボックスのチェックは複数行行えます。<br /></label>
				<div class="status">
					<span id="ut003_05" class="errorMessage">
						<parts:errors path="*"/><span id="lblError"></span>
					</span>
				</div>
				<parts:table id="Ut003_05M1Table">
					<table class="tbldel" style="border-style:none;">
						<tr>
							<td class="td_noborder" colSpan="2">
								<div align="right">
									<parts:button id="btnUpdate" value="削除" style="width:70px;" onclick="click_btnUpdate();"/><parts:button id="btnReload" value="再表示" style="width:70px;" onclick="click_btnReload();"/>
								</div>
							</td>
						</tr>
						<tr>
							<td class="td_noborder" colSpan="2">
								<div align="right">
									<parts:button id="btnDeleteAllCheck" value="全選択" style="width:70px;height:20px;" onclick="click_btnDeleteAllCheck();"/><parts:button id="btnDeleteAllDelete" value="全解除" style="width:70px;height:20px;" onclick="click_btnDeleteAllDelete();"/>
								</div>
							</td>
						</tr>
					</table>
					<paging:table width="690px" path="Ut003_05M1Table" pageNoClick="click_pageNo();return false;" prePageClick="click_prePage();return false;" nextPageClick="click_nextPage();return false;" maxPageAnchor="5" basePosition="3">
						<%-- 検索結果 ヘッダー --%>
						<parts:table cssClass="tbldel" frame="void" border="1">
							<table border="1" class="tbldel">
								<tr>
									<td class="NumHeader">
										様式番号
									</td>
									<td class="FileNameHeader">
										様式名
									</td>
									<td class="DelItemHeader">
										削除
									</td>
								</tr>
							</table>
						</parts:table>
						<%-- 検索結果 --%>
						<div id="scrollArea">
							<parts:table cssClass="tbldelRecord" border="1">
								<table border="1" class="tbldelRecord">
									<paging:record>
										<tr>
											<td style="display:none;">
												<parts:dlabel path="ID_Data" />
											</td>
											<td class="NumItem" style="white-space:nowrap;">
												<parts:dlabel path="ID_FormatNumber" />
											</td>
											<td class="FileName" style="white-space:nowrap;">
												<parts:link id="Select_ID_ID_DocName" href="javascript:void(0);" onclick="click_ID_ID_DocName(${index});">
													<parts:dlabel path="ID_DocName" />
												</parts:link>
											</td>
											<td class="DelItem" style="white-space:nowrap;">
												<div Align="center">
													<parts:checkbox path="chkDelete" id="chkDelete" value="1"/>
												</div>
											</td>
										</tr>
									</paging:record>
								</table>
							</parts:table>
						</div>
					</paging:table>
				</parts:table>
				<div align="left">
					<parts:button id="btnBack" value="戻る" onclick="click_btnBack();"/>
				</div>
			</div>
		<br />
		</div>
		</parts:form>
		<%@ include file="/jsp/incDownloadArea.jsp"%>
		<%@ include file="/jsp/incFooter.jsp"%>
	</body>
</html>