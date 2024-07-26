<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/jsp/incTop.jsp"%>

<%--================================================================================================
 * Project Name : パートナーネット開発
 * System Name  : パートナーネット
 * File Name    : cr004_02.jsp
 *
 * <<Modification History>>
 * Version | Date       | Updated By            | Content
 * --------+------------+-----------------------+---------------------------------------------------
 * 1.0.0   | 2015/09/14 | 佐藤 晃               | 新規作成
================================================================================================--%>

<html>
<%@ include file="/jsp/incHeader.jsp"%>
<head>
<title><parts:message code="title.screenName"/></title>

<link href="<%= request.getContextPath() %>/css/cr004.css" rel="stylesheet" />
<script lang="JavaScript">
<!--
	<%-- 戻るボタン押下時の処理	--%>
    function click_initBackBtn() {
        executeAction('../../cr004/cr004_02/Cr004_02Back.form');
    }
    <%-- アンカー押下時の処理	--%>
    function click_ancrEdit(selectedIndex) {
    	document.forms[0].elements["selectedIndex"].value = selectedIndex - 1;
    	executeAction('../../cr004/cr004_02/Cr004_02Anchor.form');
    }
//-->
</script>
</head>
<body>
	<parts:form modelAttribute="cr004_02Form" id="Form1" method="post">
		<%@ include file="/jsp/incCommonHidden.jsp" %>
		<%@ include file="/jsp/incHeaderArea.jsp" %>
		<div id="main_scroll_area">
		<parts:hidden path="selectedIndex"/>
		<div>
			<div class="header Title">
				<div class="title"><parts:message code="title.screenName"/><%-- <parts:dlabel path="lblTitle" /> --%><br />
				</div>
			</div>
			<div class="main">
				<h2 class="subtitle">検索結果
				</h2>
				<div class="status">
					<span class="errorMessage">
						<parts:errors path="*" /><br />
					</span>
				</div>
				<div class="buttons"><parts:button id="btnBack" value="戻る" title="戻る" onclick="click_initBackBtn();"/></div>
				<div class="greeting" style="width: 630px">
					<div>顧客名："<parts:dlabel path="lblSearchCustomer" />" の検索結果
					</div>
					<parts:table id="CustomerListArea" cssClass="tbl1">
					<!-- <div class="tbl1"> -->
						<p>
							下記リストから報告書作成対象の顧客名をクリックしてください。対象顧客の案件一覧が表示されます。
						</p>
						<paging:table path="Cr004_02M1Table" paging="false" pagingDisplay="false">
							<div>
								<parts:table cssClass="pagingTable" cssStyle="width: 600px;">
									<paging:head sort="false" sortClick="">
										<tr>
											<td style="display:none;">
												<label>貸付先コード</label>
											</td>
											<td class="header" style="width:25%;" >
												<label>顧客名</label>
											</td>
											<td style="display:none;">
												<label>扱店コード</label>
											</td>
											<td class="header" style="width:75%;">
												<label>住所</label>
											</td>
										</tr>
									</paging:head>
									<paging:record>
										<tr>
											<td style="display:none;">
												<parts:dlabel path="ID_Code_Customer" />
											</td>
											<td class="custName" style="text-align: center;">
												<%-- <parts:link href="JavaScript:void(0);" onclick="click_ancrEdit(${dispIndex});"> --%>
												<parts:link href="JavaScript:void(0);" onclick="click_ancrEdit(${dispIndex});">
													<parts:dlabel path="ID_Name_Customer" />
												</parts:link>
											</td>
											<td style="display:none;">
												<parts:dlabel path="ID_Code_Organization" />
											</td>
											<td>
												<parts:dlabel path="ID_CustomerAddress" htmlEscape="false" />
											</td>
										</tr>
									</paging:record>
								</parts:table>
							</div>
						</paging:table>
					<!-- </div> -->
					</parts:table>
					<br />
				</div>
			</div>
		</div>
	</div>
	</parts:form><%@ include file="/jsp/incFooter.jsp"%>
</body>
</html>