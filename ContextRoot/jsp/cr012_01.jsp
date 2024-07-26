
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/jsp/incTop.jsp" %>
<%@ page import="jp.go.jfc.partnernet.common.PNCommonMessageConstants" %>
<%@ page import="jp.go.jfc.partnernet.pnfw.common.PNMessageUtils" %>

<%--================================================================================================
 * Project Name : パートナーネット開発
 * System Name  : パートナーネット
 * File Name    : cr012_01.jsp
 *
 * <<Modification History>>
 * Version | Date       | Updated By            | Content
 * --------+------------+-----------------------+---------------------------------------------------
 * 2.0.0   | 2017/09/05 | 木村　しのぶ          | 新規作成（H29年追加開発案件対応）
================================================================================================--%>

<html>
	<%@ include file="/jsp/incHeader.jsp"%>
	<head>
		<title><parts:message code="title.screenName"/></title>
		<link href="<%=request.getContextPath()%>/css/cr012.css" type="text/css" rel="stylesheet" />
		<script lang="JavaScript">
		<!--
		 <%-- 登録ボタン押下時の処理 --%>
		 function click_updateBtn() {
		        if (confirm("<%=PNMessageUtils.getString(PNCommonMessageConstants.PM1120I)%>")) {
		        	clearTextFormat();
				 	executeAction('../../cr012/cr012_01/Cr012_01Update.form');
		        }
		 }
		//-->
		</script>
	</head>
	<body onload = "initTextFormat()">
		<parts:form modelAttribute="cr012_01Form" action="./Cr012_01Init.form" id="Form1" method="post" onsubmit="return false;">
			<%@ include file="/jsp/incCommonHidden.jsp" %>
			<%@ include file="/jsp/incHeaderArea.jsp" %>
			<div id="main_scroll_area">
				<div class="header">
					<div class="title">
						<label id="lblTitle" class="title"><parts:message code="title.screenName"/></label>
					</div>
				</div>
				<div class="main">
					<div class="greeting">
							以下の報告書の登録を行います。内容をご確認のうえ「登録」ボタンを押してください。<BR>
							・毎月第５営業日17時時点の交付依頼内容に基づき、当月下旬に発送いたします。<BR>
							・「至急発行を希望します。」にチェックを入れた場合は、登録日の17時時点の交付依頼内容に基づき、翌営業日以降に郵送いたします。<BR>
							・本日中の発送を希望する場合は画面登録は行わず、公庫本店までご連絡ください。
						</div>
					<div class="buttons">
						<parts:button id="btnUpdate" value="登録" title="登録" onclick="click_updateBtn();" />
					</div>
					<div class="reportDate">報告日：
						<parts:dlabel path="lblID_Date_Report" />
					</div>
					<div style="color:red;font-weight:bold;">
						<parts:errors path="*"/>
					</div>
					<paging:table path="cr012_01M1Table" pagingDisplay="false">
						<parts:table cssClass="cr12List" >
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
										<parts:text path="txtID_Su_HokatsuInin" id="txtID_Su_HokatsuInin" maxlength="3" size="4" cssClass="format-number" cssStyle=";text-align:right;" />
                                        <span class="unit">通</span>
                                    </td>
								</tr>
                                <tr align="left">
                                    <td class="kindItem" colspan="2" valign="top">
                                        <span class="kind">現在事項一部証明書　役員<BR>（登記簿抄本　農林水産事業本部長）</span>
                                    </td>
                                    <td class="suryoItem">
										<parts:text path="txtID_Su_GenzaiJiko" id="txtID_Su_GenzaiJiko" maxlength="3" size="4" cssClass="format-number" cssStyle=";text-align:right;" />
                                        <span class="unit">通</span>
                                    </td>
                                </tr>
                                <tr align="left">
                                    <td class="kindItem" colspan="2" valign="top">
                                        <span class="kind">印鑑証明書（農林水産事業本部長）</span>
                                    </td>
                                    <td class="suryoItem">
										<parts:text path="txtID_Su_InkanShohmei" id="txtID_Su_InkanShohmei" maxlength="3" size="4" cssClass="format-number" cssStyle=";text-align:right;" />
                                        <span class="unit">通</span>
                                    </td>
                                </tr>
	                            <tr align="left">
	                                <td class="kindItem" rowspan="4" valign="top">
	                                    <span class="kind">閉鎖登記簿抄本</span>
	                                </td>
	                                <td class="kindItem"  valign="top">
	                                    <span class="kind">変更抄本(S45.1.1移転登記）</span>
	                                </td>
	                                <td class="suryoItem">
										<parts:text path="txtID_Su_HenkoShohhon" id="txtID_Su_HenkoShohhon" maxlength="3" size="4" cssClass="format-number" cssStyle=";text-align:right;" />
	                                    <span class="unit">通</span>
	                                </td>
	                            </tr>
	                            <tr align="left">
	                                <td class="kindItem"  valign="top">
	                                    <span class="kind">新閉鎖謄本（S37.10.22移転登記）</span>
	                                </td>
	                                <td class="suryoItem">
										<parts:text path="txtID_Su_SinHeisa" id="txtID_Su_SinHeisa" maxlength="3" size="4" cssClass="format-number" cssStyle=";text-align:right;" />
	                                    <span class="unit">通</span>
	                                </td>
	                            </tr>
	                            <tr align="left">
	                                <td class="kindItem" valign="top">
	                                    <span class="kind">旧閉鎖抄本（S31.8.7移転登記）</span>
	                                </td>
	                                <td class="suryoItem">
										<parts:text path="txtID_Su_KyuHeisa" id="txtID_Su_KyuHeisa" maxlength="3" size="4" cssClass="format-number" cssStyle=";text-align:right;" />
	                                    <span class="unit">通</span>
	                                </td>
	                            </tr>
	                            <tr align="left">
	                                <td class="kindItem" valign="top">
	                                    <span class="kind">閉鎖事項全部証明書</span>
	                                </td>
	                                <td class="suryoItem">
										<parts:text path="txtID_Su_HeisaJiko" id="txtID_Su_HeisaJiko" maxlength="3" size="4" cssClass="format-number" cssStyle=";text-align:right;" />
	                                    <span class="unit">通</span>
	                                </td>
	                            </tr>
  							</paging:record>
                        </parts:table>
                        <br>
                        <br>
                        <parts:table cssClass="cr12List" >
                            <col width="480px">
                            <col width="200px" align="center">
							<paging:record>
                            <tr align="left">
                                <td class="kindItem">
                                    <span class="kind">至急発行を希望します。<BR>【希望する場合はチェックを入れる。ただし、数量は各３通を上限とする。】</span>
                                </td>
                                <td class="suryoItem">
                                	<parts:checkbox path="chkID_ShikyuHakko" id="chkID_ShikyuHakko" name="chkID_ShikyuHakko"  value="1"  />
                                </td>
                            </tr>
							</paging:record>
						</parts:table>
					</paging:table>
				</div>
			</div>
		</parts:form><%@ include file="/jsp/incFooter.jsp"%>
	</body>
</html>