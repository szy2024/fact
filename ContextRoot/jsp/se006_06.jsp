<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/jsp/incTop.jsp" %>
<%@ taglib prefix="pn" uri="http://partnernet.jfc.go.jp/tags/pn"%>
<%--================================================================================================
 * Project Name : パートナーネット開発
 * System Name  : パートナーネット
 * File Name    : se006_06.jsp
 *
 * <<Modification History>>
 * Version | Date       | Updated By            | Content
 * --------+------------+-----------------------+---------------------------------------------------
 * 1.0.0   | 2015/07/01 | 小柳　暁子            | 新規作成
 * 2.0.0   | 2017/11/29 | 嶋田　美保            | 委託貸付報告等における機能改善対応
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
					executeAction('../../se006/se006_06/Se006_06Back.form');
			}
		//-->
		</script>
	</head>
	<body>
		<parts:form modelAttribute="se006_06Form" action="./Se006_06Init.form" id="Form1" method="post">
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
					<span id="se006_ID06_Detail_UC_lblError" class="errorMessage">
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
				<parts:table id="se006_06Table" cssStyle="border-style:none;background-color:#ffffff;">
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
										<pn:printWareki date="${se006_06Form.getID_Date_Report()}" pattern="GYMD" />
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
											<pn:printWareki date="${se006_06Form.getID_Year()}" pattern="GY" />
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
											<pn:printWareki date="${se006_06Form.getID_Date_SueokiKigen()}" pattern="GYM" />
										</div>
									</div>
									<!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 --> 償還期限</div>
										<div><!-- 値 -->
											<pn:printWareki date="${se006_06Form.getID_Date_ShokanKigen()}" pattern="GYM" />
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
											<pn:printWareki date="${se006_06Form.getID_Date_Kashitsukejikko()}" pattern="GYMD" />
										</div>
									</div>
								</div>
								<!-- 報告書の一行分(複数可) -->
								<div class="report_a_line">
									<!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 --> 貸付実行金額(円)</div>
										<div class="styleMoney"><!-- 値 -->
											<parts:dlabel path="ID_M_Kashitsuke" />
										</div>
									</div>
									<!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 -->資金交付額(円)</div>
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
									<!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 --> 貸付受入金残高(円)</div>
										<div class="styleMoney"><!-- 値 -->
											<parts:dlabel path="ID_M_KashitsukeukeireZan" />
										</div>
									</div>
								</div>
								<!-- 報告書の一行分(複数可) -->
								<div class="report_a_line">
									<!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 --> 払出・元金充当日</div>
										<div><!-- 値 -->
											<pn:printWareki date="${se006_06Form.getID_Date_HaraidashiJuto()}" pattern="GYMD" />
										</div>
									</div>
									<!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 --> 受託者勘定処理年月</div>
										<div><!-- 値 -->
											<pn:printWareki date="${se006_06Form.getID_Date_Jtkshori()}" pattern="GYM" />
										</div>
									</div>
									<!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 --> 資金払出額(円)</div>
										<div class="styleMoney"><!-- 値 -->
											<parts:dlabel path="ID_M_Haraidashi" />
										</div>
									</div>
									<!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 --> 元金充当額(貸付受入金からの繰上償還)(円)</div>
										<div class="styleMoney"><!-- 値 -->
											<parts:dlabel path="ID_M_Ganju" />
										</div>
									</div>
								</div>
								<!-- 報告書の一行分(複数可) -->
								<div class="report_a_line">
									<fieldset style="padding:4.9px 10.5px 8.75px 4px;">
										<legend style="font-size: 9pt; color: #0066ff;text-align:left;">元金充当の場合</legend>
										<!-- 出力用 -->
										<div class="item-output">
											<div><!-- 項目名 --> 元金充当後貸付金残高(円)</div>
											<div class="styleMoney"><!-- 値 -->
												<parts:dlabel path="ID_M_KashitsukeZandakaAfterGanju" />
											</div>
										</div>
										<!-- 出力用 -->
										<div class="item-output">
											<div><!-- 項目名 --> 元金充当後第１回約定日</div>
											<div><!-- 値 -->
												<pn:printWareki date="${se006_06Form.getID_Date_FirstYakujoAfterGanju()}" pattern="GYMD" />
											</div>
										</div>
										<!-- 出力用 -->
										<div class="item-output">
											<div><!-- 項目名 --> 繰上償還事由コード</div>
											<div><!-- 値 -->
												<parts:dlabel path="ID_Code_KurishoJiyu" />
											</div>
										</div>
										<!-- 報告書の一行分(複数可) -->
										<div class="report_a_line">
											<fieldset style="padding:4.9px 10.5px 8.75px 4px;">
												<legend style="font-size: 9pt; color: #0066ff;text-align:left;">期限固定償還の場合</legend>
												<!-- 出力用 -->
												<div class="item-output">
													<div><!-- 項目名 --> 元金充当後の元金均等額(円)</div>
													<div class="styleMoney"><!-- 値 -->
														<parts:dlabel path="ID_M_GankinKintoAfterGanju" />
													</div>
												</div>
												<!-- 出力用 -->
												<div class="item-output">
													<div><!-- 項目名 --> 元金充当後の元金不均等額(円)</div>
													<div class="styleMoney"><!-- 値 -->
														<parts:dlabel path="ID_M_GankinFukintoAfterGanju" />
													</div>
												</div>
												<!-- 出力用 -->
												<div class="item-output">
													<div><!-- 項目名 --> 調整コード</div>
													<div><!-- 値 -->
														<span id="rdoID_Code_Chosei" disabled="true">
															<span disabled="true">
																<parts:radioButton path="rdoID_Code_Chosei" id="rdoID_Code_Chosei" value="1" disabled="true"/>
																<label for="rdoID_Code_Chosei">初回</label>
															</span>
															<span disabled="true">
																<parts:radioButton path="rdoID_Code_Chosei" id="rdoID_Code_Chosei" value="2" disabled="true"/>
																<label for="rdoID_Code_Chosei">最終回</label>
															</span>
															<span disabled="true">
																<parts:radioButton path="rdoID_Code_Chosei" id="rdoID_Code_Chosei" value="" disabled="true"/>
																<label for="rdoID_Code_Chosei">なし</label>
															</span>
														</span>
													</div>
												</div>
											</fieldset>
										</div>
									</fieldset>
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