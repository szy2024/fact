<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%--================================================================================================
 * Project Name : パートナーネット開発
 * System Name  : パートナーネット
 * File Name    : ut001_03.jsp
 *
 * <<Modification History>>
 * Version | Date       | Updated By            | Content
 * --------+------------+-----------------------+---------------------------------------------------
 * 1.0.0   | 2015/09/10 | 譚　暁玉             | 新規作成
================================================================================================--%>
<%@ include file="/jsp/incTop.jsp" %>
<html>
<head>
<%@ include file="/jsp/incHeader.jsp" %>
<title><parts:message code="title.screenName"/></title>
<script lang="JavaScript">
<!--

		<%-- お知らせ画面に戻るボタン押下時の処理 --%>
		function click_backBtn() {
			executeAction('../../ut001/ut001_01/Ut001_01Init.form');
		}
		<%-- アンカー押下時の処理 --%>
		function click_ancr(selectedIndex) {
			document.forms[0].elements["selectedIndex"].value = selectedIndex;
			executeAction('../../ut001/ut001_03/Ut001_03AncrDocName.form');
		}

//-->
</script>
<%-- styleシート読込 --%>
<%-- <link href="<%=strResourceURL%>/ut001.css" type="text/css" rel="stylesheet" />--%>
<link href="<%=request.getContextPath()%>/css/ut001.css" type="text/css" rel="stylesheet"/>
</head>
<body>
<parts:form modelAttribute="ut001_03Form" method="post">
		<%@ include file="/jsp/incCommonHidden.jsp" %>
		<%@ include file="/jsp/incHeaderArea.jsp" %>
		<div id="main_scroll_area">
		<div class="header">
			<div class="title">
		<label id="lblTitle" class="Title"><parts:message code="title.screenName"/></label>

			</div>
		</div>

	<%-- エラーメッセージ --%>
	<div class="main">
			<div class="status">
				<span id="ut001_ID03_Results_UC_lblError" class="errorMessage">
				<label id="lblError" class="Error"></label><br />
				</span>
			</div>

			<div class="greeting" style="width:70%">
				※ 金利改定情報ファイルをクリックすると内容が画面に表示されます。
			</div>
			<br />

			<parts:table cssClass="tblResults" cssStyle="border-collapse :separate;border-style: solid;border-width: 1px;border-color: #000000;">
				<tr align="center">
					<td class="DateHeader">改定日</td>
					<td class="Header">金利改定情報ファイル</td>
				</tr>
			</parts:table>

	<%-- 業務エリア --%>
<%-- 検索結果 ヘッダー --%>
<div id="scrollArea">
	<div class="result02">
	<parts:hidden path="selectedIndex" />
	<paging:table path="Ut001_03M1Table" pagingDisplay="false">

			<parts:table cssClass="tblResults" cssStyle="border-collapse :separate;border-style: solid;border-width: 1px;border-color: #000000;">

			<%-- 検索結果 --%>
			<paging:record evenNumberCssClass="rEven" oddNumberCssClass="rOdd">
					<tr align="center">
						<td class="DateItem" style="white-space:nowrap;" >
							<parts:dlabel path="ID_DateTime_DocUpdate" formatType="date" formatPattern="warekiJpZeroSuppress" />
						</td>
						<td class="FileNameArea" style="white-space:nowrap;">
							<parts:link id="Select_ID_ID_DocName" href="javascript:void(0);" onclick="click_ancr(${index});">
								<parts:dlabel path="ID_ID_DocName" />
							</parts:link>
						</td>
						<td style="white-space:nowrap;display:none;"></td>
						<td style="display:none;">
						</td>
				    </tr>

			</paging:record>
		</parts:table>
	</paging:table>
	</div>

</div>
					<parts:button id="btnBack" value="お知らせ画面に戻る" onclick="click_backBtn();" />

	</div>
</div>
</parts:form>
<%@ include file="/jsp/incDownloadArea.jsp"%>
<%@ include file="/jsp/incFooter.jsp" %>
</body>
</html>