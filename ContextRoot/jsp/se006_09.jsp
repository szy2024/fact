<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/jsp/incTop.jsp" %>
<%@ taglib prefix="pn" uri="http://partnernet.jfc.go.jp/tags/pn"%>
<%--================================================================================================
 * Project Name : パートナーネット開発
 * System Name  : パートナーネット
 * File Name    : se006_09.jsp
 *
 * <<Modification History>>
 * Version | Date       | Updated By            | Content
 * --------+------------+-----------------------+---------------------------------------------------
 * 1.0.0   | 2015/07/01 | 小柳　暁子            | 新規作成
================================================================================================--%>

<html>
	<%@ include file="/jsp/incHeader.jsp"%>
	<head>
		<title><parts:message code="title.screenName"/></title>
		<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/se006.css" />
		<script lang="JavaScript">
		<!--
			<%-- 戻るボタン処理 --%>
			function click_backBtn() {
		    	executeAction('../../se006/se006_09/Se006_09Back.form');
			}
		//-->
		</script>
	</head>
	<body>
		<parts:form modelAttribute="se006_09Form" action="./Se006_09Init.form" id="Form1" method="post">
			<%@ include file="/jsp/incCommonHidden.jsp" %>
			<%@ include file="/jsp/incHeaderArea.jsp" %>
			<div id="main_scroll_area">
			<div class="header">
				<div class="title">
					<label id="lblTitle" class="Title"><parts:message code="title.screenName"/></label><br />
				</div>
			</div>
			<div class="main">
				<div class="status">
					<span id="se006_ID09_Detail_UC_lblError" class="errorMessage">
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
				<parts:table id="se006_09Table" cssStyle="border-style:none;background-color:#ffffff;">
					<parts:tr>
						<td style="border:none;padding-right:2px;">
							<!-- 報告書一枚(borderで囲んである,複数可) -->
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
                                            <pn:printWareki date="${se006_09Form.getID_Date_Report()}" pattern="GYMD" />
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
								<!-- 報告書の一行分(複数可) -->
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
                                           <pn:printWareki date="${se006_09Form.getID_Year()}" pattern="GY" />
										</div>
									</div>
									<!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 --> 方式資金</div>
										<div><!-- 値 -->
											<parts:dlabel path="ID_Code_HoshikiShikin" />
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
								</div>
								<!-- 報告書の一行分(複数可) -->
								<div class="report_a_line">
									<!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 --> 充当対象払込期日</div>
										<div class="styleMoney"><!-- 値 -->
											<pn:printWareki date="${se006_09Form.getID_Date_JutoTaisho()}" pattern="GYMD" />
										</div>
									</div>
									<!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 --> 代弁金払込日</div>
										<div><!-- 値 -->
											<pn:printWareki date="${se006_09Form.getID_Date_DaibenkinHaraikomi()}" pattern="GYMD" />
										</div>
									</div>
									<!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 --> 遅延損害金(円)</div>
										<div class="styleMoney"><!-- 値 -->
											<parts:dlabel path="ID_M_ChienSongai" />
										</div>
									</div>
									<!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 --> 利息(円)</div>
										<div class="styleMoney"><!-- 値 -->
											<parts:dlabel path="ID_M_Risoku" />
										</div>
									</div>
								</div>
								<!-- 報告書の一行分(複数可) -->
								<div class="report_a_line">
									<!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 --> 繰上償還手数料(円)</div>
										<div class="styleMoney"><!-- 値 -->
											<parts:dlabel path="ID_M_KurishoCommission" />
										</div>
									</div>
									<!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 --> 元金(円)</div>
										<div class="styleMoney"><!-- 値 -->
											<parts:dlabel path="ID_M_Gankin" />
										</div>
									</div>
									<!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 --> 仮受金(一般口)からの充当額(円)</div>
										<div class="styleMoney"><!-- 値 -->
											<parts:dlabel path="ID_M_KariukeIppanJuto" />
										</div>
									</div>
								</div>
								<!-- 報告書の一行分(複数可) -->
								<div class="report_a_line">
									<!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 --> 計(円)</div>
										<div class="styleMoney"><!-- 値 -->
											<parts:dlabel path="ID_M_Kei" />
										</div>
									</div>
									<!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 --> 送金額(円)</div>
										<div class="styleMoney"><!-- 値 -->
											<parts:dlabel path="ID_M_Sokin" />
										</div>
									</div>
									<!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 --> 代弁金充当後残元金(円)</div>
										<div class="styleMoney"><!-- 値 -->
											<parts:dlabel path="ID_M_ZanGanAfterDaibenJuto" />
										</div>
									</div>
								</div>
								<!-- 報告書の一行分(複数可) -->
								<div class="report_a_line">
									<!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 --> 受託者勘定処理年月</div>
										<div><!-- 値 -->
                                           <pn:printWareki date="${se006_09Form.getID_Date_Jtkshori()}" pattern="GYM" />
										</div>
									</div>
									<!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 --> 送金日</div>
										<div><!-- 値 -->
                                           <pn:printWareki date="${se006_09Form.getID_Date_Sokin()}" pattern="GYMD" />
										</div>
									</div>
									<!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 --> 送金日番号</div>
										<div><!-- 値 -->
											<parts:dlabel path="ID_ID_Sokinbi" />
										</div>
									</div>
								</div>
							</div> <!-- 報告書一枚終わり -->
						</td>
					</parts:tr>
				</parts:table>
			</div>
			</div>
		</parts:form>
		<%@ include file="/jsp/incFooter.jsp"%>
	</body>
</html>