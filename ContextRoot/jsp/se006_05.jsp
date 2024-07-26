<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/jsp/incTop.jsp" %>
<%@ taglib prefix="pn" uri="http://partnernet.jfc.go.jp/tags/pn"%>
<%--================================================================================================
 * Project Name : パートナーネット開発
 * System Name  : パートナーネット
 * File Name    : se006_05.jsp
 *
 * <<Modification History>>
 * Version | Date       | Updated By            | Content
 * --------+------------+-----------------------+---------------------------------------------------
 * 1.0.0   | 2015/07/01 | 小柳　暁子            | 新規作成
 * 2.0.0   | 2017/11/29 | 林　晃平              | 委託貸付報告等における機能改善対応
================================================================================================--%>

<html>
	<head>
		<%@ include file="/jsp/incHeader.jsp"%>
		<title><parts:message code="title.screenName"/></title>
		<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/se006.css" />
		<script lang="JavaScript">
		<!--
			<%-- 戻るボタン処理 --%>
			function click_backBtn() {
					executeAction('../../se006/se006_05/Se006_05Back.form');
			}
		//-->
		</script>
	</head>
	<body>
		<parts:form modelAttribute="se006_05Form" action="./se006_05Init.form" id="form1" method="post" onsubmit="return false;">
		<%@ include file="/jsp/incCommonHidden.jsp" %>
		<%@ include file="/jsp/incHeaderArea.jsp" %>
			<div id="main_scroll_area">
						<div class="header">
				<div class="title">
					<label id="lblTitle" class="Title"><parts:message code="title.screenName"/></label>
				</div>
			</div>
			<div class="main">
				<div class="status">
					<span id="se006_ID05_Detail_UC_lblError" class="errorMessage">
						<parts:errors path="*"/>
					</span>
				</div>
				<p>
					<parts:button id="btnBack" value="戻る" onclick="click_backBtn()" />
				</p>
				<div class="status">
					<span class="errorMessage">
						<parts:dlabel path="lblMessage" />
					</span>
				</div>
				<parts:table id="se006_05Table" cssStyle="border-style:none;background-color:#ffffff;">
					<parts:tr>
						<td style="border:none;padding-right:2px;">
							<!-- 報告書一枚(borderで囲んである,複数可) -->
							<!-- 実装時はASP.NETのユーザコントロールよびだし -->
							<div class="report" style="margin-top:0px;">
								<!-- 報告書の一行分(複数可) -->
								<div class="report_a_line">
									<!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 --> 報告書番号：</div>
										<div><!-- 値 -->
											<parts:dlabel path="ID_ID_Report" />
										</div>
									</div>
									<!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 --> 報告年月日</div>
										<div><!-- 値 -->
											<pn:printWareki date="${se006_05Form.getID_Date_Report()}" pattern="GYMD" />
										</div>
									</div>
									<!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 --> 報告時分秒</div>
										<div><!-- 値 -->
											<parts:dlabel path="ID_Time_Report" />
										</div>
									</div>
									<div style="display:none;">
										<!-- 出力用 -->
										<parts:dlabel path="ID_DataCode" />
									</div>
								</div>
								<div class="report_a_line">
									<!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 --> 顧客名</div>
										<div><!-- 値 -->
											<parts:dlabel path="ID_Name_Customer" />
										</div>
									</div>
									<!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 --> 扱店名</div>
										<div><!-- 値 -->
											<parts:dlabel path="ID_Name_Organization" />
										</div>
									</div>
								</div>
								<!-- 報告書の一行分(複数可) -->
								<div class="report_a_line">
									<!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 --> 公庫支店</div>
										<div><!-- 値 -->
											<parts:dlabel path="ID_Code_KoukoShiten" />
										</div>
									</div>
									<!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 --> 扱店</div>
										<div><!-- 値 -->
											<parts:dlabel path="ID_Code_Organization" />
										</div>
									</div>
									<!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 --> 店舗</div>
										<div><!-- 値 -->
											<parts:dlabel path="ID_Code_Tenpo" />
										</div>
									</div>
									<!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 --> 年度</div>
										<div><!-- 値 -->
												<pn:printWareki date="${se006_05Form.getID_Year()}" pattern="GY" />
										</div>
									</div>
									<!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 --> 方式資金</div>
										<div><!-- 値 -->
											<parts:dlabel path="ID_Kubun_Hoshiki" />
										</div>
									</div>
									<!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 --> 番号</div>
										<div><!-- 値 -->
											<parts:dlabel path="ID_ID_Ringi" />
										</div>
									</div>
									<!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 --> 枝番</div>
										<div><!-- 値 -->
											<parts:dlabel path="ID_ID_RingiBranch" />
										</div>
									</div>
									<!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 --> 資金使途</div>
										<div><!-- 値 -->
											<parts:dlabel path="ID_Code_ShikinShito" />
										</div>
									</div>
									<!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 --> 事業別</div>
										<div><!-- 値 -->
											<parts:dlabel path="ID_Code_Jigyobetsu" />
										</div>
									</div>
								</div>
								<!-- 報告書の一行分(複数可) -->
								<div class="report_a_line">
									<!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 --> 利率(％)</div>
										<div><!-- 値 -->
											<parts:dlabel path="ID_Riritsu" />
										</div>
									</div>
									<!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 --> 特利区分</div>
										<div><!-- 値 -->
											<parts:dlabel path="ID_Kubun_Tokuri" />
										</div>
									</div>
									<!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 --> 特利(％)</div>
										<div><!-- 値 -->
											<parts:dlabel path="ID_Tokuri" />
										</div>
									</div>
									<!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 --> 据置期限</div>
										<div><!-- 値 -->
											<pn:printWareki date="${se006_05Form.getID_Date_SueokiKigen()}" pattern="GYM" />
										</div>
									</div>
									<!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 --> 償還期限</div>
										<div><!-- 値 -->
											<pn:printWareki date="${se006_05Form.getID_Date_ShokanKigen()}" pattern="GYM" />
										</div>
									</div>
									<!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 --> 元利金払込日</div>
										<div><!-- 値 -->
											<parts:dlabel path="ID_Date_GanrikinHaraiKomi" />
										</div>
									</div>
									<!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 --> 貸付実行日</div>
										<div><!-- 値 -->
											<pn:printWareki date="${se006_05Form.getID_Date_Kashitsukejikko()}" pattern="GYMD" />
										</div>
									</div>
								</div>
								<!-- 報告書の一行分(複数可) -->
								<div class="report_a_line">
									<!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 --> 受託者勘定処理年月</div>
										<div><!-- 値 -->
											<pn:printWareki date="${se006_05Form.getID_Date_Jtkshori()}" pattern="GYM" />
										</div>
									</div>
									<!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 --> 貸付実行金額(円)</div>
										<div class="styleMoney"><!-- 値 -->
											<parts:dlabel path="ID_M_Kashitsuke" />
										</div>
									</div>
									<!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 --> 資金交付額(円)</div>
										<div class="styleMoney"><!-- 値 -->
											<parts:dlabel path="ID_M_ShikinKofu" />
										</div>
									</div>
									<!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 --> 貸付受入金受入額(円)</div>
										<div class="styleMoney"><!-- 値 -->
											<parts:dlabel path="ID_M_KashitsukeUkeire" />
										</div>
									</div>
								</div>
							</div>
							<!-- 報告書一枚終わり -->
						</td>
					</parts:tr>
				</parts:table>
			</div>
		</div>
			</parts:form>
		<%@ include file="/jsp/incFooter.jsp"%>
	</body>
</html>