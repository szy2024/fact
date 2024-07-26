
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/jsp/incTop.jsp" %>
<%@ page import="jp.go.jfc.partnernet.common.PNCommonMessageConstants" %>
<%@ page import="jp.go.jfc.partnernet.pnfw.common.PNMessageUtils" %>

<%--================================================================================================
 * Project Name : パートナーネット開発
 * System Name  : パートナーネット
 * File Name    : md012_01.jsp
 *
 * <<Modification History>>
 * Version | Date       | Updated By            | Content
 * --------+------------+-----------------------+---------------------------------------------------
 * 2.0.0   | 2017/09/15 | 木村　しのぶ          | 新規作成（H29年追加開発案件対応）
===============================================================================================--%>

<html>
	<%@ include file="/jsp/incHeader.jsp"%>
	<head>
		<title><parts:message code="title.screenName"/></title>
		<link href="<%=request.getContextPath()%>/css/md012.css" type="text/css" rel="stylesheet" />
		<script lang="JavaScript">
		<!--
			<%-- 登録ボタン押下時の処理 --%>
			function click_updateBtn(operationSelect) {
				if (operationSelect == 3) {
					if (confirm("<%=PNMessageUtils.getString(PNCommonMessageConstants.PM1140I)%>")) {
							clearTextFormat();
					 		executeAction('../../md012/md012_01/Md012_01Update.form');
					}
				} else {
					if (confirm("<%=PNMessageUtils.getString(PNCommonMessageConstants.PM1130I)%>")) {
							clearTextFormat();
						 	executeAction('../../md012/md012_01/Md012_01Update.form');
					}
				}
			}

			<%-- 戻るボタン押下時の処理 --%>
			function click_backBtn() {
				executeAction('../../md012/md012_01/Md012_01Back.form');
			}
		//-->
		</script>
	</head>
	<body onload = "initTextFormat()">
		<parts:form modelAttribute="md012_01Form" action="./Md012_01Init.form" id="Form1" method="post" onsubmit="return false;">
			<%@ include file="/jsp/incCommonHidden.jsp" %>
			<%@ include file="/jsp/incHeaderArea.jsp" %>
			<div id="main_scroll_area">
				<div class="header">
					<div class="title">
						<label id="lblTitle" class="title"><parts:message code="title.screenName"/></label>
					</div>
				</div>
				<div class="main">
					<%-- 該当データなしの場合 --%>
					<logic:equal value="" path="lblID_ProcessMode">
						<div class="buttons">
							<parts:button id="btnBack2" value="戻る" title="取消・修正対象報告書の一覧画面へ戻る" onclick="click_backBtn();"/>
						</div>
						<div style="color:red;font-weight:bold;">
							<parts:errors path="*"/>
						</div>
					</logic:equal>
					<%-- 該当データありの場合 --%>
					<logic:notEqual value="" path="lblID_ProcessMode">
							<div class="greeting" id="greeting">
								<logic:equal value="3" path="lblID_ProcessMode">
									以下の報告書の取消を行います。内容をご確認のうえ「登録」ボタンを押してください。<BR>
								</logic:equal>
								<logic:equal value="4" path="lblID_ProcessMode">
									以下の報告書の修正を行います。内容をご確認のうえ「登録」ボタンを押してください。<BR>
									・毎月第５営業日17時時点の交付依頼内容に基づき、当月下旬に発送いたします。<BR>
									・「至急発行を希望します。」にチェックを入れた場合は、登録日の17時時点の交付依頼内容に基づき、翌営業日以降に郵送いたします。
								</logic:equal>
							</div>
						<div class="buttons">
							<parts:button id="btnUpdate2" value="登録" title="登録" onclick="click_updateBtn(${md012_01Form.getLblID_ProcessMode()});" />
							<parts:button id="btnBack2" value="戻る" title="取消・修正対象報告書の一覧画面へ戻る" onclick="click_backBtn();"/>
						</div>
						<div class="reportDate" id="reportDate">報告日：
							<parts:dlabel path="lblID_Date_Report" />
						</div>
						<div style="color:red;font-weight:bold;">
							<parts:errors path="*"/>
						</div>
						<div id="md012_01M1Table">
							<paging:table path="md012_01M1Table" pagingDisplay="false">
								<parts:table cssClass="md12List">
									<col width="200px">
									<col width="280px">
									<col width="200px" align="center">
									<%-- テーブル ヘッダ領域 --%>
									<paging:head>
										<tr align="center">
											<th class="kindHeader" colspan="2">種　　　別</th>
											<th class="suryoHeader" >数　量</th>
										</tr>
									</paging:head>
									<%-- テーブル 明細部 --%>
									<paging:record>
									<tr align="left">
										<td class="kindItem" colspan="2" valign="top">
											<span class="kind">包括委任状（様式Ｆ－６１号）</span>
										</td>
										<td class="suryoItem">
											<parts:text path="txtID_Su_HokatsuInin" id="txtID_Su_HokatsuInin" name="txtID_Su_HokatsuInin" maxlength="3" size="4" cssClass="format-number" cssStyle=";text-align:right;" />
											<span class="unit">通</span>
										</td>
									</tr>
									<tr align="left">
										<td class="kindItem" colspan="2" valign="top">
											<span class="kind">現在事項一部証明書　役員<BR>（登記簿抄本　農林水産事業本部長）</span>
										</td>
										<td class="suryoItem">
													<parts:text path="txtID_Su_GenzaiJiko" id="txtID_Su_GenzaiJiko" name="txtID_Su_GenzaiJiko" maxlength="3" size="4" cssClass="format-number" cssStyle=";text-align:right;" />
											<span class="unit">通</span>
										</td>
									</tr>
									<tr align="left">
										<td class="kindItem" colspan="2" valign="top">
											<span class="kind">印鑑証明書（農林水産事業本部長）</span>
										</td>
										<td class="suryoItem">
											<parts:text path="txtID_Su_InkanShohmei" id="txtID_Su_InkanShohmei" name="txtID_Su_InkanShohmei" maxlength="3" size="4" cssClass="format-number" cssStyle=";text-align:right;" />
											<span class="unit">通</span>
										</td>
									</tr>
									<tr align="left">
										<td class="kindItem" rowspan="4" valign="top">
											 <span class="kind">閉鎖登記簿抄本</span>
										</td>
										<td class="kindItem"valign="top">
											 <span class="kind">変更抄本(S45.1.1移転登記）</span>
										</td>
										<td class="suryoItem">
											<parts:text path="txtID_Su_HenkoShohhon" id="txtID_Su_HenkoShohhon" name="txtID_Su_HenkoShohhon" maxlength="3" size="4" cssClass="format-number" cssStyle=";text-align:right;" />
											 <span class="unit">通</span>
										</td>
									</tr>
									<tr align="left">
										<td class="kindItem"valign="top">
											 <span class="kind">新閉鎖謄本（S37.10.22移転登記）</span>
										</td>
										<td class="suryoItem">
											<parts:text path="txtID_Su_SinHeisa" id="txtID_Su_SinHeisa" name="txtID_Su_SinHeisa" maxlength="3" size="4" cssClass="format-number" cssStyle=";text-align:right;" />
											 <span class="unit">通</span>
										</td>
									</tr>
									<tr align="left">
										<td class="kindItem" valign="top">
											 <span class="kind">旧閉鎖抄本（S31.8.7移転登記）</span>
										</td>
										<td class="suryoItem">
											<parts:text path="txtID_Su_KyuHeisa" id="txtID_Su_KyuHeisa" name="txtID_Su_KyuHeisa" maxlength="3" size="4" cssClass="format-number" cssStyle=";text-align:right;" />
											 <span class="unit">通</span>
										</td>
									</tr>
									<tr align="left">
										<td class="kindItem" valign="top">
											 <span class="kind">閉鎖事項全部証明書</span>
										</td>
										<td class="suryoItem">
											<parts:text path="txtID_Su_HeisaJiko" id="txtID_Su_HeisaJiko" name="txtID_Su_HeisaJiko" maxlength="3" size="4" cssClass="format-number" cssStyle=";text-align:right;"/>
											 <span class="unit">通</span>
										</td>
									</tr>
									</paging:record>
								</parts:table>
								<br>
								<br>
								<parts:table cssClass="md12List" >
									<col width="480px">
									<col width="200px" align="center">
									<paging:record>
										<tr align="left">
											<td class="kindItem">
												<span class="kind">至急発行を希望します。<BR>【希望する場合はチェックを入れる。ただし、数量は各３通を上限とする。】</span>
											</td>
											<td class="suryoItem">
												<parts:checkbox path="chkID_ShikyuHakko" id="chkID_ShikyuHakko" name="chkID_ShikyuHakko" value="1" />
											</td>
										</tr>
									</paging:record>
								</parts:table>
							</paging:table>
						</div>
					</logic:notEqual>
				</div>
			</div>
		</parts:form><%@ include file="/jsp/incFooter.jsp"%>
	</body>
</html>