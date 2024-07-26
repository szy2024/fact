
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/jsp/incTop.jsp"%>

<%--================================================================================================
 * Project Name : パートナーネット開発
 * System Name  : パートナーネット
 * File Name    : se009_01.jsp
 *
 * <<Modification History>>
 * Version | Date       | Updated By            | Content
 * --------+------------+-----------------------+---------------------------------------------------
 * 1.0.0   | 2015/07/01 | ○○　○○            | 新規作成
 * 2.0.0   | 2019/01/29 | 坂　竜太              | 農林PN元号対応
 * 4.0.0   | 2020/11/27 | 三好　一功            | 基盤更改等に伴うパートナーネットシステムの更改
================================================================================================--%>

<html>
	<%@ include file="/jsp/incHeader.jsp"%>
	<head>
		<title><parts:message code="title.screenName"/></title>

		<link href="<%=request.getContextPath()%>/css/se009.css" type="text/css" rel="stylesheet" />
<script lang="JavaScript">
<!--
    <%-- 送信ボタン押下時の処理	--%>
    function click_sendBtn() {
        executeAction('../../se009/se009_01/Se009_01Send.form');
    }
//-->
</script>

	</head>
	<body onload="initTextFormat()">
		<parts:form modelAttribute="se009_01Form" id="Form1" method="post">
			<%@ include file="/jsp/incCommonHidden.jsp" %>
			<%@ include file="/jsp/incHeaderArea.jsp" %>
			<div id="main_scroll_area">
			<div class="header">
				<div class="title">
					<label id="lblTitle" class="Title"><parts:message code="title.screenName"/></label>
				</div>
			</div>
			<div class="main">
				<div class="greeting">
<%-- [UPD] Ver 4.0.0 - START --%>
					この画面では、令和４年３月31日以前に貸付実行した案件の控除利息が計算されます。
					<br />
					令和４年４月１日以降に貸付実行した案件は、払込期日までに払出した金額により求め
					<br />
					た約定利息が計算されます。
					<br />
<%-- [UPD] Ver 4.0.0 - END --%>
					※H方式を照会する場合は、扱店に「9937」を入力してください。
				</div>
				<div class="status">
					<span id="se009_ID01_SearchItem_UC_lblError" class="errorMessage">
						<parts:errors path="*" /><br />
					</span>
				<%--
					<span id="se009_ID01_SearchItem_UC_lblError" class="errorMessage">
						<div class="Error">
							<parts:dlabel path="lblError" />
						</div><br />
					</span>
				--%>
				</div>
			<%--
				<c:choose>
					<c:when test="${se009_01Form.isProtect('txtID_Code_Organization')}">
						<c:set var="headerClassCodeOrganization" value="disableInputHeader"/>
					</c:when>
					<c:otherwise>
						<c:set var="headerClassCodeOrganization" value="enableInputHeader"/>
					</c:otherwise>
				</c:choose>
			--%>
				<span>
					<fieldset><legend>融資番号 </legend>
						<div>
							<parts:table cssStyle="border-style:outset;border-width:1px;">
								<tr style="border-style:solid;border-width:1px;text-align: center;">
									<td class="enableInputHeader" style="border-style:inset;border-width:1px;padding-right:2px;">公庫支店</td>
									<td id="codeOrg" class="disableInputHeader" style="border-style:inset;border-width:1px;padding-right:2px;">扱店コード</td>
									<td class="enableInputHeader" style="border-style:inset;border-width:1px;padding-right:2px;">店舗</td>
									<td class="enableInputHeader" style="border-style:inset;border-width:1px;padding-right:2px;">年度</td>
									<td class="enableInputHeader" style="border-style:inset;border-width:1px;padding-right:2px;">方式資金</td>
									<td class="enableInputHeader" style="border-style:inset;border-width:1px;padding-right:2px;">番号</td>
									<td class="enableInputHeader" style="border-style:inset;border-width:1px;padding-right:2px;">枝番</td>
								</tr>
								<tr>
									<td style="border-style:solid;border-width:1px;padding:2px;">
										<parts:select path="drpID_Code_ShokanHonShiten">
											<parts:options items="${se009_01Form.koukoShitenCodeNameMap}" />
										</parts:select>
									</td>
									<td style="border-style:solid;border-width:1px;padding:2px;">
										<parts:text path="txtID_Code_Organization" maxlength="4" size="6" style="text-align: right;" />
									</td>
									<td style="border-style:solid;border-width:1px;padding:2px;">
										<parts:text path="txtID_Code_Tenpo" maxlength="3" size="6" style="text-align: right;" />
									</td>
									<td style="border-style:solid;border-width:1px;padding:2px;">
										<parts:text path="txtID_Year" maxlength="3" size="4" style="text-align: right;" />
									</td>
									<td style="border-style:solid;border-width:1px;padding:2px;">
										<parts:text path="txtID_HoshikiShikin" maxlength="2" size="8" style="text-align: right;" />
									</td>
									<td style="border-style:solid;border-width:1px;padding:2px;">
										<parts:text path="txtID_ID_Ringi" maxlength="5" size="6" style="text-align: right;" />
									</td>
									<td style="border-style:solid;border-width:1px;padding:2px;">
										<parts:text path="txtID_ID_RingiBranch" maxlength="3" size="4" style="text-align: right;" />
									</td>
								</tr>
							</parts:table>
						</div>
					</fieldset>
					<p>資金払出または元金充当日 <parts:select path="ID_SearchStartWareki" style="width:48px;">
<%-- [UPD] Ver 3.0.0 - START --%>
<%--						<parts:option value="H">H</parts:option>  --%>
<%--						<parts:option value="S">S</parts:option>  --%>
							<parts:codeListOption categoryCode="00002" />
<%-- [UPD] Ver 3.0.0 - END --%>
						</parts:select><parts:text path="ID_SearchStartYear" maxlength="2" size="2" style="width:32px;text-align: right;" />年
						<parts:select path="ID_SearchStartMonth">
							<parts:codeListOption categoryCode="00003" />
						</parts:select>月
						<parts:select path="ID_SearchStartDate">
							<parts:codeListOption categoryCode="00004" />
						</parts:select>日</p>
					<p>資金払出額 <parts:text cssClass="format-number" path="txtID_M_Haraidashi" maxlength="11" size="15" style="text-align: right;" />円</p>
					<p>元金充当額 <parts:text cssClass="format-number" path="txtID_M_Ganju" maxlength="11" size="15" style="text-align: right;" />円</p>
				</span>
				<span>
					<parts:button id="btnID_Send" value="送信" onclick="clearTextFormat();click_sendBtn();"/>
				</span>
			</div>
		</div>
		</parts:form><%@ include file="/jsp/incFooter.jsp"%>
	</body>
</html>