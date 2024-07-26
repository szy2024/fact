
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/jsp/incTop.jsp" %>
<%@ taglib prefix="pn" uri="http://partnernet.jfc.go.jp/tags/pn"%>

<%--================================================================================================
 * Project Name : パートナーネット開発
 * System Name  : パートナーネット
 * File Name    : se006_16.jsp
 *
 * <<Modification History>>
 * Version | Date       | Updated By            | Content
 * --------+------------+-----------------------+---------------------------------------------------
 * 2.0.0   | 2017/10/04 | 百々　諒馬            | H29年追加開発案件対応
================================================================================================--%>

<html>
	<%@ include file="/jsp/incHeader.jsp"%>
	<head>
		<title><parts:message code="title.screenName"/></title>

		<script lang="JavaScript" type="text/javascript">
		<!--
		<%-- 戻るボタン処理 --%>
		function click_backBtn() {
			executeAction('../../se006/se006_16/Se006_16Back.form');
		}

		//-->
		</script>
		<link href="<%=request.getContextPath()%>/css/se006_16.css" type="text/css" rel="stylesheet" />
	</head>
	<body onload = "initTextFormat();">
		<parts:form modelAttribute="se006_16Form" action="./se006_16Init.form" id="Form1" method="post">
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
					<c:if test="${se006_16Form.getLblID_BizErrorCount() != 0}" >
						<div style="color:red;font-weight:bold;">
							<parts:errors path="*"/>
						</div>
						<div class="buttons">
							<parts:button id="btnBack2" value="戻る" onclick="click_backBtn();"/>
						</div>
					</c:if>

					<%-- 該当データありの場合 --%>
					<c:if test="${se006_16Form.getLblID_BizErrorCount() == 0}" >
						<div class="buttons">
							<parts:button id="btnBack2" value="戻る" onclick="click_backBtn();"/>
						</div>
						<div style="color:red;font-weight:bold;">
							<parts:errors path="*"/>
						</div>

						<div class="reportDate" id="reportDate">報告日：
							<parts:dlabel path="lblID_Date_Report" />
						</div>
							<div id="se006_16M1Table">
							<paging:table path="se006_16m1Table" pagingDisplay="false">
								<parts:table cssClass="se006_16List">
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
											<parts:dlabel path="lblID_Su_HokatsuInin" />
											<span class="unit">通</span>
										</td>
									</tr>
									<tr align="left">
										<td class="kindItem" colspan="2" valign="top">
											<span class="kind">現在事項一部証明書　役員<BR>（登記簿抄本　農林水産事業本部長）</span>
										</td>
										<td class="suryoItem">
											<parts:dlabel path="lblID_Su_GenzaiJiko" />
											<span class="unit">通</span>
										</td>
									</tr>
									<tr align="left">
										<td class="kindItem" colspan="2" valign="top">
											<span class="kind">印鑑証明書（農林水産事業本部長）</span>
										</td>
										<td class="suryoItem">
											<parts:dlabel path="lblID_Su_InkanShohmei" />
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
											<parts:dlabel path="lblID_Su_HenkoShohhon" />
											 <span class="unit">通</span>
										</td>
									</tr>
									<tr align="left">
										<td class="kindItem"valign="top">
											 <span class="kind">新閉鎖謄本（S37.10.22移転登記）</span>
										</td>
										<td class="suryoItem">
											<parts:dlabel path="lblID_Su_SinHeisa" />
											 <span class="unit">通</span>
										</td>
									</tr>
									<tr align="left">
										<td class="kindItem" valign="top">
											 <span class="kind">旧閉鎖抄本（S31.8.7移転登記）</span>
										</td>
										<td class="suryoItem">
											<parts:dlabel path="lblID_Su_KyuHeisa" />
											 <span class="unit">通</span>
										</td>
									</tr>
									<tr align="left">
										<td class="kindItem" valign="top">
											 <span class="kind">閉鎖事項全部証明書</span>
										</td>
										<td class="suryoItem">
											<parts:dlabel path="lblID_Su_HeisaJiko" />
											 <span class="unit">通</span>
										</td>
									</tr>
									</paging:record>
								</parts:table>
								<br>
								<br>
								<parts:table cssClass="se006_16List" >
									<col width="480px">
									<col width="200px" align="center">
									<paging:record>
										<tr align="left">
											<td class="kindItem">
												<span class="kind">至急発行を希望します。<BR>【希望する場合はチェックを入れる。ただし、数量は各３通を上限とする。】</span>
											</td>
											<td class="suryoItem">
												<parts:checkbox path="chkID_ShikyuHakko" id="chkID_ShikyuHakko" name="chkID_ShikyuHakko" value="1" disabled="true" />
											</td>
										</tr>
									</paging:record>
								</parts:table>
							</paging:table>
							</div>
					</c:if>
				</div>
			</div>

		</parts:form><%@ include file="/jsp/incFooter.jsp"%>
	</body>
</html>