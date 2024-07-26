
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/jsp/incTop.jsp"%>

<%--================================================================================================
 * Project Name : パートナーネット開発
 * System Name  : パートナーネット
 * File Name    : cr004_03.jsp
 *
 * <<Modification History>>
 * Version | Date       | Updated By            | Content
 * --------+------------+-----------------------+---------------------------------------------------
 * 1.0.0   | 2015/09/18 | 佐藤　晃              | 新規作成
================================================================================================--%>

<html>
<%@ include file="/jsp/incHeader.jsp"%>
<head>
<title><parts:message code="title.screenName"/></title>
<link href="<%=request.getContextPath()%>/css/cr004.css" type="text/css" rel="stylesheet" />
<script lang="JavaScript">
<!--
	<%-- 戻るボタン押下時の処理	--%>
    function click_initBackBtn() {
        executeAction('../../cr004/cr004_03/Cr004_03Back.form');
    }
    <%-- アンカー押下時の処理	--%>
    function click_ancrEdit(selectedIndex) {
    	document.forms[0].elements["selectedIndex"].value = selectedIndex - 1;
    	executeAction('../../cr004/cr004_03/Cr004_03Anchor.form');
    }
//-->
</script>
</head>
<body>
	<parts:form modelAttribute="cr004_03Form" id="Form1" method="post">
		<%@ include file="/jsp/incCommonHidden.jsp" %>
		<%@ include file="/jsp/incHeaderArea.jsp" %>
		<div id="main_scroll_area">
		<parts:hidden path="selectedIndex"/>
		<div>
		<div class="header">
			<div class="title Title">
				<%-- <parts:dlabel path="lblTitle" /><br /> --%>
				<parts:message code="title.screenName"/>
			</div>
		</div>

			<div class="main">
				<h2 class="subtitle">融資債権一覧
				</h2>
				<div class="status">
					<span id="cr005_ID03_Results_UC_lblError" class="errorMessage">
	<%-- 					<div class="Error" style="color:red;font-weight:bold;">
							<parts:dlabel path="lblError" />
						</div><br /> --%>
						<parts:errors path="*" /><br />
					</span>
				</div>
				<div class="buttons">
					<parts:button id="btnBack" value="戻る" title="戻る" onclick="click_initBackBtn();"/>
				</div>
				<div class="greeting">
					<div>顧客名：<parts:dlabel path="lblSearchCustomer" /><br />
						住所：<parts:dlabel path="lblSearchAddr" />
					</div>
					<br />
				</div>
				<parts:table id="YuushiListArea">
					<div class="greeting" style="width:600px">
						下記のリストから報告書作成対象となる債権の融資番号をクリックしてください。<br/>報告書を作成します。
					</div>
					<paging:table path="Cr004_03M1Table" paging="false" pagingDisplay="false">
						<div>
							<parts:table cssStyle="width: 350px;">
								<paging:head sort="false" sortClick="">
										<tr>
											<td class="header" style="white-space:nowrap;border: solid 1px gray;background-color: #ccffcc;text-align: center;font-weight: bold;">
												<label>公庫支店-扱店-店舗-融資番号</label>
											</td>
											<td style="display:none;white-space:nowrap;">
												<label>貸付先コード</label>
											</td>
											<td style="display:none;white-space:nowrap;">
												<label>債権管理番号</label>
											</td>
										</tr>
								</paging:head>
								<paging:record>
									<tr>
										<td class="yuushiNum" style="border: solid 1px gray;background-color: White;text-align: center;">
											<parts:link href="javascript:void(0);" onclick="click_ancrEdit(${dispIndex});">
												<parts:dlabel path="ID_Code_Yuushi" />
											</parts:link>
										</td>
										<td style="display:none;">
											<parts:dlabel path="ID_Code_Customer" />
										</td>
										<td style="display:none;">
											<parts:dlabel path="ID_ID_Credit" />
										</td>
									</tr>
								</paging:record>
							</parts:table>
						</div>
					</paging:table>
				</parts:table>
				<br />
			</div>
		</div>
	</div>
	</parts:form><%@ include file="/jsp/incFooter.jsp"%>
</body>
</html>