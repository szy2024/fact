<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/jsp/incTop.jsp" %>
<%@ taglib prefix="pn" uri="http://partnernet.jfc.go.jp/tags/pn"%>

<%--================================================================================================
 * Project Name : パートナーネット開発
 * System Name  : パートナーネット
 * File Name    : se007_02.jsp
 *
 * <<Modification History>>
 * Version | Date       | Updated By            | Content
 * --------+------------+-----------------------+---------------------------------------------------
 * 1.0.0   | 2015/07/01 | 澤田　健一            | 新規作成
 * 4.0.0   | 2020/11/30 | 番場　千沙都        | 基盤更改等に伴うパートナーネットシステムの更改
================================================================================================--%>

<html>
	<%@ include file="/jsp/incHeader.jsp"%>
	<head>
		<title><parts:message code="title.screenName"/></title>

		<link href="<%=request.getContextPath()%>/css/se007.css" type="text/css" rel="stylesheet" />
	<script lang="JavaScript">
    <%-- 戻るボタン処理 --%>
    function click_backBtn() {
        executeAction('../../se007/se007_02/Se007_02Back.form');
    }
	</script>
	</head>
	<body>
		<parts:form modelAttribute="se007_02Form" action="./Se007_02Init.form" id="form1" method="post"  onsubmit="return false;">
		<%@ include file="/jsp/incCommonHidden.jsp" %>
		<%@ include file="/jsp/incHeaderArea.jsp" %>
		<div id="main_scroll_area">
		<div class="header">
			<label id="lblTitle" class="title"><parts:message code="title.screenName"/></label>
		</div>
		<div class="main">

				<div class="status">
					<span id="se007_ID02_Detail_UC_lblError" class="errorMessage">
						<parts:errors path="*" cssClass="Error" /><br />
					</span>
				</div>
				<div>
					<parts:button path="btnBack" id="btnBack" value="戻る" onclick="click_backBtn()" ></parts:button>
				</div>
				<br />
<div>
	<div>
		<parts:table id ="detailData" cssStyle="border-style:none;line-height:1.0em;" width="100%" >
				<tr>
					<td style="text-align:left;">
						<parts:table id="customerName">
							<tr>
								<td class="Header">
									顧客名:
								</td>
								<td class="DataCell" colSpan="5" width="420">
									<parts:dlabel path="ID_Name_Customer" />
								</td>
								<td class="Header">
									照会日時:
								</td>
								<td class="DataCell">
										<pn:printWareki date="${se007_02Form.ID_DateTime_day}" pattern="GYYMMDD"/>
								</td>
								<td class="Header">
									<parts:dlabel path="ID_Date_Time" />
								</td>
							</tr>
						</parts:table>
						<HR class="custName" />
						<parts:table id="customerInfo" cellspacing="2" cellpadding="2">
							<tr>
								<td class="Header">
									住所:
								</td>
								<td class="DataCell" colspan="5">
									<parts:dlabel path="ID_ID_Postcode" />
									<parts:dlabel path="ID_Name_Todofuken" />
									<parts:dlabel path="ID_Name_Shikugunchoson" />
									<parts:dlabel path="ID_Name_OazaTsusho" />
									<parts:dlabel path="ID_Name_AzameiChome" />
									<parts:dlabel path="ID_Addr_Hojo" />
								</td>
							</tr>
							<tr>
								<td class="Header">
									扱店名:
								</td>
								<td class="DataCell" colspan="5">
									<parts:dlabel path="ID_Name_Organization" />
								</td>
							</tr>
						</parts:table>
						<div id="ringiInfo">
							<parts:table cssClass="RingiRow1" border="1"  width="80%" >
								<tr>
									<td class="Header" rowSpan="2">
										公庫支店名
									</td>
									<td class="Header" rowSpan="2">
										扱店
									</td>
									<td class="Header" rowSpan="2">
										店舗
									</td>
									<td class="Header" colSpan="4">
										融資番号
									</td>
									<td class="Header" rowSpan="2">
										融資契約日
									</td>
									<td class="Header" rowSpan="2">
										融資金額(円)
									</td>
									<td class="Header" rowSpan="2">
										資金使途名
									</td>
								</tr>
								<tr>
									<td class="Header">
										年度
									</td>
									<td class="Header">
										方式資金
									</td>
									<td class="Header">
										番号
									</td>
									<td class="Header">
										枝番
									</td>
								</tr>
								<tr>
									<td class="DataCell" width="75px">
										<parts:dlabel path="ID_Name_KoukoShiten"/>
									</td>
									<td class="DataCell">
										<parts:dlabel path="ID_Code_Organization" />
									</td>
									<td class="DataCell">
										<parts:dlabel path="ID_Code_Tenpo" />
									</td>
									<td class="DataCell">
										<pn:printWareki date="${se007_02Form.ID_Year}" pattern="GY"/>
									</td>
									<td class="DataCell">
										<parts:dlabel path="ID_HoshikiShikin" />
									</td>
									<td class="DataCell">
										<parts:dlabel path="ID_ID_Ringi" />
									</td>
									<td class="DataCell">
										<parts:dlabel path="ID_ID_RingiBranch" />
									</td>
									<td class="DataCell">
										<pn:printWareki date="${se007_02Form.ID_Date_Jikko}" pattern="GYMD"/>
									</td>
									<td class="moneyStyle">
										<parts:dlabel path="ID_M_Kashitsuke" />
									</td>
									<td class="DataCell">
										<parts:dlabel path="ID_Name_ShikinShito" />
									</td>
								</tr>
							</parts:table>
							<parts:table cssClass="RingiRow2" border="1" width="80%">
								<tr>
									<td class="Header">
										利率(%)
									</td>
									<td class="Header" colSpan="2">
										特利(%)
									</td>
									<td class="Header">
										指標率(%)
									</td>
									<td class="Header">
										据置期限
									</td>
									<td class="Header">
										償還期限
									</td>
									<td class="Header">
										元利金払込日
									</td>
									<td class="Header">
										償還方法
									</td>
									<td class="Header">
										元利金又は元金均等額(円)
									</td>
								</tr>
								<tr>
									<td class="DataCell">
										<parts:dlabel path="ID_Riritsu" />
									</td>
									<td class="DataCell">
										<parts:dlabel path="ID_Kubun_Tokuri" />
									</td>
									<td class="DataCell">
										<parts:dlabel path="ID_Tokuri" />
									</td>
									<td class="DataCell">
										<parts:dlabel path="ID_Shihyoritsu" />
									</td>
									<td class="DataCell">
										<pn:printWareki date="${se007_02Form.ID_Date_SueokiKigen}" pattern="GYM"/>
									</td>
									<td class="DataCell">
										<pn:printWareki date="${se007_02Form.ID_Date_ShokanKigen}" pattern="GYM"/>
									</td>
									<td class="DataCell">
										<parts:dlabel path="ID_Date_GanrikinHaraiKomi" />
									</td>
									<td class="DataCell">
										<parts:dlabel path="ID_Code_ShokanHouhou" />
									</td>
									<td class="moneyStyle">
										<parts:dlabel path="ID_M_Fukin" />
									</td>
								</tr>
							</parts:table>
							<div style="width: 80%;">
								<parts:table cssClass="RingiRow3" border="1">
									<tr>
										<td class="recordHeader">
											据置期間中の<br />
											利子助成率(％)
										</td>
									</tr>
									<tr>
										<td class="DataCell">
											<parts:dlabel path="ID_RishijoseiMaeTokuri" />
										</td>
									</tr>
									<tr>
										<td class="recordHeader">
											利子助成率(%)
										</td>
									</tr>
									<tr>
										<td class="DataCell">
											<parts:dlabel path="ID_RishiJoseiMaeRiritsu" />
										</td>
									</tr>
								</parts:table>
								<parts:table cssClass="RingiRow4" cssStyle="border-style:none;" align="left">
									<tr>
										<td>
											<div align="left">
												①本表はパートナーネットに登録された報告書類が処理済であることを前提に表示しています。
											</div>
										</td>
									</tr>
									<tr>
										<td>
											<div align="left">
												②表示される内容は報告書類の登録の都度変動しますので、常に最新の内容を確認してください。
											</div>
										</td>
									</tr>
									<tr>
										<td>
											<div align="left">
												③払込期日は未到来の期日と到来済で入金登録未了の期日が表示されます。
											</div>
										</td>
									</tr>
									<tr>
										<td>
											<div align="left">
												④控除利息欄については次の点に留意してください。
											</div>
										</td>
									</tr>
<%--[ADD] Ver 4.0.0 - START --%>
									<tr>
										<td>
											<div align="left">
												・なお、令和４年４月１日以降に貸付実行した案件については、控除利息は発生しません
											</div>
										</td>
									</tr>
									<tr>
										<td>
											<div align="left">
												　（払込期日までに払出した金額により計算した約定利息となります）。
											</div>
										</td>
									</tr>
<%-- [ADD] Ver 4.0.0 - END --%>
									<tr>
										<td>
											<div align="left">
												・照会日以降の払込期日については、最初に到来する期日のみ、現在の貸付受入金がそのまま継続する前提で
											</div>
										</td>
									</tr>
									<tr>
										<td>
											<div align="left">
												試算します。
											</div>
										</td>
									</tr>
									<tr>
										<td>
											<div align="left">
												・照会日以降の2番目以降の払込期日の控除利息は表示していません。
											</div>
										</td>
									</tr>
<%--[ADD] Ver 4.0.0 - START --%>
									<tr>
										<td>
											<div align="left">
												⑤貸付実行日が令和４年４月１日以降で、利息計算期間内に貸付受入金がある案件につきましては、
											</div>
										</td>
									</tr>
									<tr>
										<td>
											<div align="left">
												払出した金額より計算した約定利息となります（控除利息は発生しません）。
											</div>
										</td>
									</tr>
<%-- [ADD] Ver 4.0.0 - END --%>
									<tr>
										<td>
											<div align="left">
												<parts:dlabel path="lblAttentionMessage1" />
											</div>
										</td>
									</tr>
									<tr>
										<td>
											<div align="left">
												<parts:dlabel path="lblAttentionMessage2" />
											</div>
										</td>
									</tr>
									<tr>
										<td>
											<div align="left">
												<parts:dlabel path="lblAttentionMessage3" />
											</div>
										</td>
									</tr>
									<tr>
										<td>
											<div align="left">
												<parts:dlabel path="lblAttentionMessage4" />
											</div>
										</td>
									</tr>
								</parts:table>
								</div>
						</div>
					</td>
				</tr>
		</parts:table>
	</div>
</div>
<div id="YakujoInf">
	<paging:table path="se007_02M1Table" paging="false" pagingDisplay="false" width="80%">
		<div>
			<parts:table border="1" id="yakujoInf" cssStyle="line-height:1.0em;">
				<paging:head sort="false">
					<tr>
						<td class="recordHeader" rowspan="2">
							回
						</td>
						<td class="recordHeader" rowspan="2">
							払込期日<br />
							年月日
						</td>
						<td class="recordHeader" colspan="2">
							お支払額
						</td>
						<td class="recordHeader" rowspan="2">
							払込後の貸付金<br />
							残高(円)
						</td>
						<td class="recordHeader" rowspan="2">
							利子助成額(円)
						</td>
						<td class="recordHeader" rowspan="2">
							控除利息(円)
						</td>
					</tr>
					<tr>
						<td class="recordHeader">
							約定利息(円)
						</td>
						<td class="recordHeader">
							約定元金(円)
						</td>
					</tr>
				</paging:head>
				<paging:record>
					<tr>
						<td class="YakuInfKai">
							<parts:dlabel path="ArrayListIndex" />
						</td>
						<td>
							<pn:printWareki date="${record.ID_Date_Haraikomi}" pattern="GYMD"/>
						</td>
						<td class="moneyStyleYakuRisoku">
							<parts:dlabel path="ID_YakujoRisoku" />
						</td>
						<td class="moneyStyleYakuKingaku">
							<parts:dlabel path="ID_YakujoGankin" />
						</td>
						<td class="moneyStyle">
							<parts:dlabel path="ID_HaraikomigoKashitsukeZandaka" />
						</td>
						<td class="moneyStyle">
							<parts:dlabel path="ID_M_RishiJosei" />
						</td>
						<td class="moneyStyle">
							<parts:dlabel path="ID_M_KojoRisoku" />
						</td>
					</tr>
				</paging:record>
			</parts:table>
		</div>
	</paging:table>
</div>
<div id="RishiJoseiKei">
	<parts:table id="rishijosei1" border="1" cssStyle="line-height:1.0em;">
		<tr>
			<td class="recordHeader">利子助成額計<br />
				(円)
			</td>
			<td class="recordHeader">控除利息計<br />
				(円)
			</td>
		</tr>
		<tr>
			<td class="moneyStyle"><parts:dlabel path="ID_M_RishiJoseiGaku_Kei" /></td>
			<td class="moneyStyle"><parts:dlabel path="ID_M_KojoRisoku_Kei" /></td>
		</tr>
	</parts:table>
</div>
</div>
			</div>
			</parts:form><%@ include file="/jsp/incFooter.jsp"%>
	</body>
</html>