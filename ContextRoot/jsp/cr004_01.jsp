<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/jsp/incTop.jsp"%>

<%--================================================================================================
 * Project Name : パートナーネット開発
 * System Name  : パートナーネット
 * File Name    : cr004_01.jsp
 *
 * <<Modification History>>
 * Version | Date       | Updated By            | Content
 * --------+------------+-----------------------+---------------------------------------------------
 * 1.0.0   | 2015/09/11 | 佐藤 晃               | 新規作成
================================================================================================--%>


<html>
<%@ include file="/jsp/incHeader.jsp"%>
	<head>
	<title><parts:message code="title.screenName"/></title>
	<link href="<%=request.getContextPath()%>/css/cr004.css" type="text/css" rel="stylesheet" />
	<script lang="JavaScript">
	<!--
		<%-- 作成ボタン押下時の処理	--%>
	    function click_createBtn() {
	        executeAction('../../cr004/cr004_01/Cr004_01Create.form');
	    }
		<%-- 検索ボタン押下時の処理	--%>
	    function click_searchBtn() {
	        executeAction('../../cr004/cr004_01/Cr004_01Search.form');
	    }

	//-->
	</script>
	</head>
	<body>
		<parts:form modelAttribute="cr004_01Form" id="Form1" method="post">
			<%@ include file="/jsp/incCommonHidden.jsp" %>
			<%@ include file="/jsp/incHeaderArea.jsp" %>
			<div id="main_scroll_area">
			<div class="header">
				<div class="title Title">
					<%-- <parts:dlabel path="lblTitle" /> --%>
					<parts:message code="title.screenName"/>
				</div>
			</div>
			<div class="main">
				<h2 class="subtitle">報告対象債権の検索
				</h2>
				<div class="greeting">
					報告書作成対象となる債権を検索します。融資番号か顧客名を入力し、<br>
					「作成」ボタンまたは「検索」ボタンを押してください。
				</div>
				<div class="status">
					<span class="errorMessage" >
						<parts:errors path="*" /><br />
					</span>
				</div>
				<div>
					<p><%-- <parts:dlabel path="Label1" /> --%></p>
						融資番号：
						<div>
							<parts:table border="1" cssStyle="border-style:outset;font-size: 12px;margin: 10px 10px 10px 10px;">
									<tr style="border-style:solid;border-width:1px;text-align: center;">
										<td class="enableInputHeader" style="border-style:inset;border-width:1px;text-align: center;background-color: #ffff66;padding-right:2px;">公庫支店</td>
										<td id="codeOrg" class="disableInputHeader" style="border-style:inset;border-width:1px;text-align: center;background-color: #ccffcc;padding-right:2px;">扱店</td>
										<td class="enableInputHeader" style="border-style:inset;border-width:1px;text-align: center;background-color: #ffff66;padding-right:2px;">店舗</td>
										<td class="enableInputHeader" style="border-style:inset;border-width:1px;text-align: center;background-color: #ffff66;padding-right:2px;">年度</td>
										<td class="enableInputHeader" style="border-style:inset;border-width:1px;text-align: center;background-color: #ffff66;padding-right:2px;">方式資金</td>
										<td class="enableInputHeader" style="border-style:inset;border-width:1px;text-align: center;background-color: #ffff66;padding-right:2px;">番号</td>
										<td class="enableInputHeader" style="border-style:inset;border-width:1px;text-align: center;background-color: #ffff66;padding-right:2px;">枝番</td>
									</tr>
									<tr>
										<td style="border-style:solid;border-width:1px;text-align: center;">
											<parts:select path="drpID_Code_ShokanHonShiten" id="drpID_Code_ShokanHonShiten">
												<parts:options items="${cr004_01Form.shokanHonShitenLIST}" />
											</parts:select>
										</td>
										<td style="border-style:solid;border-width:1px;text-align: center;padding: 2px;">
											<parts:text path="txtID_Code_Organization" class ="protect" maxlength="4" size="6" style="text-align: center; " readonly="true" tabindex="-1" />
										</td>
										<td style="border-style:solid;border-width:1px;text-align: center;padding: 2px;">
											<parts:text path="txtID_Code_Tenpo" maxlength="3" size="6" style="text-align: right;" />
										</td>
										<td style="border-style:solid;border-width:1px;text-align: center;padding: 2px;">
											<parts:text path="txtID_Year" maxlength="3" size="4" style="text-align: right;" />
										</td>
										<td style="border-style:solid;border-width:1px;text-align: center;padding: 2px;">
											<parts:text path="txtID_Kubun_HoshikiShikin" maxlength="2" size="8" style="text-align: right;" />
										</td>
										<td style="border-style:solid;border-width:1px;text-align: center;padding: 2px;">
											<parts:text path="txtID_ID_Ringi" maxlength="5" size="6" style="text-align: right;" />
										</td>
										<td style="border-style:solid;border-width:1px;text-align: center;padding: 2px;">
											<parts:text path="txtID_ID_RingiBranch" maxlength="3" size="4" style="text-align: right;" />
										</td>
									</tr>
							</parts:table>
						</div>
				</div>
				<div>
					<parts:button id="btnID_Create" value="作成" onclick="click_createBtn();"/>
				</div>
				<br />
				<div>
					<br />
					顧客名：<parts:text path="txtID_Name_Customer" id="txtID_Name_Customer" maxlength="20" size="50"/>
				</div>
				<div>
					<parts:button id="btnSearch" value="検索" onclick="click_searchBtn();"/>
				</div>
			</div>
		</div>
		</parts:form><%@ include file="/jsp/incFooter.jsp"%>
	</body>
</html>