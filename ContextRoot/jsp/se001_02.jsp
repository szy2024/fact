<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%--================================================================================================
 * Project Name : パートナーネット開発
 * System Name  : パートナーネット
 * File Name    : se001_02.jsp
 *
 * <<Modification History>>
 * Version | Date       | Updated By            | Content
 * --------+------------+-----------------------+---------------------------------------------------
 * 1.0.0   | 2015/07/01 | 小林　浩二            | 新規作成
================================================================================================--%>
<%@ include file="/jsp/incTop.jsp" %>
<html>
	<%@ include file="/jsp/incHeader.jsp"%>
	<head>
		<title><parts:message code="title.screenName"/></title>
		<script lang="JavaScript">
<!--

			<%-- 顧客名リンク処理 --%>
			function click_select_record1(linkNo) {
				document.forms[0].linkno.value = linkNo;
				executeAction('../../se001/se001_02/Se001_02Anchor.form');
			}
			<%-- ページ番号リンク処理 --%>
			function click_pageNo() {
				executeAction('../../se001/se001_02/Se001_02Pageing.form');
			}
			<%-- 前へリンク処理 --%>
			function click_prePage() {
				executeAction('../../se001/se001_02/Se001_02Pageing.form');
			}
			<%-- 次へリンク処理 --%>
			function click_nextPage() {
				executeAction('../../se001/se001_02/Se001_02Pageing.form');
			}
			<%-- 戻るボタン処理 --%>
			function click_backBtn() {
				executeAction('../../se001/se001_02/Se001_02Back.form');
			}

//-->
		</script>

		<link href="<%= request.getContextPath() %>/css/se001.css" type="text/css" rel="stylesheet" />

	</head>
	<body>
		<parts:form modelAttribute="se001_02Form" id="Form1" onsubmit="return false;">
			<%@ include file="/jsp/incCommonHidden.jsp" %>
			<%@ include file="/jsp/incHeaderArea.jsp" %>
			<div id="main_scroll_area">
			<parts:hidden path="linkno" />
			<div class="header">
				<div class="title">
					<label id="lblTitle" class="Title"><parts:message code="title.screenName"/></label><br />
				</div>
			</div>
			<div class="main">
				<div class="greeting">
					<div>顧客名：”<parts:dlabel path="lblSearchCustomer" />”の検索結果
					</div>

				</div>
				<div class="greeting">
					<label id="lblDataMsg">下記のリストから報告書作成対象の顧客名をクリックしてください。<br />対象顧客の案件一覧が表示されます。</label>
				</div>
				<div class="status" style="color: red; font-weight: bold;">
					<parts:errors path="*" cssClass="Error" />
				</div>
				<div class="buttons">
					<parts:button cssStyle="display:none;" id="btnBack" />&nbsp;
					<parts:button id="btnBack2" value="戻る" title="顧客情報照会検索画面へ戻る" onclick="click_backBtn()" />
				</div>
				<div class="tbl1">
					<paging:table cssClass="PagerStyle" path="se001_02M1Table" pageNoClick="click_pageNo();return false;" prePageClick="click_prePage();return false;"
							nextPageClick="click_nextPage();return false;" maxPageAnchor="5" basePosition="3">
						<div>
							<parts:table id="se001_02M1Table" cssStyle="border-collapse: collapse;">
								<paging:head sort="true" >
									<tr>
										<td class="recordHeader" style="border:1px double black;display:none;white-space:nowrap;font-weight:bold;">
											貸付先コード
										</td>
										<td class="recordHeader" style="border:1px double black;width:30%;white-space:nowrap;font-weight:bold;">
											顧客名
										</td>
										<td class="recordHeader" style="border:1px double black;white-space:nowrap;font-weight:bold;">
											住所
										</td>
										<td class="recordHeader" style="border:1px double black;white-space:nowrap;display:none;font-weight:bold;">
											<paging:sort sortType="" path="ID_Name_Customer">扱店コード</paging:sort>
										</td>
									</tr>
								</paging:head>
								<paging:record>
									<tr style="white-space:nowrap;">
										<td style="border:1px double black;background-color:white;display:none;">
										</td>
										<td class="ItemStyle" style="border:1px double black;background-color:white;">
											<parts:link id="Select_ID_Name_Customer" href="javascript:void(0);" onclick="click_select_record1('${index}')">
												<parts:dlabel path="ID_Name_Customer" />
											</parts:link>
										</td>
										<td class="ItemStyle" style="border:1px double black;background-color:white;">
											<parts:dlabel path="ID_CustomerAddress" htmlEscape="false" />
										</td>
										<td style="border:1px double black;background-color:white;display:none;">
											<parts:dlabel path="ID_Code_Organization" />
										</td>
									</tr>
								</paging:record>
							</parts:table>
						</div>
					</paging:table>
				</div>
				<br />
			</div>
		</div>
		</parts:form><%@ include file="/jsp/incFooter.jsp"%>
	</body>
</html>