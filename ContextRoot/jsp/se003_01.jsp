<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/jsp/incTop.jsp"%>

<%--================================================================================================
 * Project Name : パートナーネット開発
 * System Name  : パートナーネット
 * File Name    : se003_01.jsp
 *
 * <<Modification History>>
 * Version | Date       | Updated By            | Content
 * --------+------------+-----------------------+---------------------------------------------------
 * 1.0.0   | 2015/07/01 | 西本　比呂            | 新規作成
================================================================================================--%>

<html>
	<%@ include file="/jsp/incHeader.jsp"%>
	<head>
		<title><parts:message code="title.screenName"/></title>
		<link href="<%= request.getContextPath() %>/css/se003.css" type="text/css" rel="stylesheet" />

			<script lang="JavaScript">

		    <%-- 検索ボタン処理 --%>
		    function click_backBtn() {
		        executeAction('../../se003/se003_01/Se003_01Search.form');
		    }

		 	</script>

	</head>
	<body>
		<parts:form modelAttribute="se003_01Form"  action="./Se003_01Init.form" id="Form1" method="post"  onsubmit="return false;">
			<%@ include file="/jsp/incCommonHidden.jsp" %>
			<%@ include file="/jsp/incHeaderArea.jsp" %>
			<div id="main_scroll_area">
			<div class="header">
				<div class="title">
					<label id="lblTitle" class="Title"><parts:message code="title.screenName"/></label>
				</div>
			</div>
			<div class="main">
				<div class="subtitle">
				    <label id="lblTitle" class="subtitle">債権情報照会・対象案件の検索</label>
				</div>
                <div class="greeting">
				   融資番号を入力し、「検索」を押してください。<br />
					※H方式を照会する場合は、扱店に「9937」を入力してください。
				</div>
                <div class="status" style="color: red; font-weight: bold;">
                    <parts:errors path="*" cssClass="Error" />
                </div>
               <span>
					融資番号：<br />
					<parts:table id="Table1" cssStyle="border-style:outset;border-width:1px;">
							<tr style="border-style:solid;border-width:1px;text-align: center;">
								<td class="recordHeader1" style="border-style:inset;border-width:1px;">公庫支店</td>
								<td id="codeOrg" class="recordHeader2" style="border-style:inset;border-width:1px;">扱店</td>
								<td class="recordHeader1" style="border-style:inset;border-width:1px;">店舗</td>
								<td class="recordHeader1" style="border-style:inset;border-width:1px;">年度</td>
								<td class="recordHeader1" style="border-style:inset;border-width:1px;">方式資金</td>
								<td class="recordHeader1" style="border-style:inset;border-width:1px;">番号</td>
								<td class="recordHeader1" style="border-style:inset;border-width:1px;">枝番</td>
							</tr>
							<tr>
								<td style="border-style:solid;border-width:1px;padding-right:2px;">
									<parts:select path="drpID_Code_ShokanHonShiten"><parts:options items="${se003_01Form.shokanHonShitenLIST}" /></parts:select>
								</td>
								<td style="border-style:solid;border-width:1px;padding-right:2px;">
									<parts:text path="txtID_Code_Organization" maxlength="4" size="6" cssStyle="text-align: right;" />
								</td>
								<td style="border-style:solid;border-width:1px;padding-right:2px;">
									<parts:text path="txtID_Code_Tenpo" maxlength="3" size="6" cssStyle="text-align: right;" />
								</td>
								<td style="border-style:solid;border-width:1px;padding-right:2px;">
									<parts:text path="txtID_Year" maxlength="3" size="4" cssStyle="text-align: right;" />
								</td>
								<td style="border-style:solid;border-width:1px;padding-right:2px;">
									<parts:text path="txtID_Kubun_Hoshiki" maxlength="2" size="8" cssStyle="text-align: right;" />
								</td>
								<td style="border-style:solid;border-width:1px;padding-right:2px;">
									<parts:text path="txtID_ID_Ringi" maxlength="5" size="6" cssStyle="text-align: right;" />
								</td>
								<td style="border-style:solid;border-width:1px;padding-right:2px;">
									<parts:text path="txtID_ID_RingiBranch" maxlength="3" size="4" cssStyle="text-align: right;" />
								</td>
							</tr>
					</parts:table>
				</span><span>
					<parts:button id="btnSearch" value="検索" onclick="click_backBtn()" />
				</span>
			</div>
		</div>
		</parts:form><%@ include file="/jsp/incFooter.jsp"%>

	</body>
</html>