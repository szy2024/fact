<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/jsp/incTop.jsp"%>
<%@ taglib prefix="pn" uri="http://partnernet.jfc.go.jp/tags/pn"%>

<%--================================================================================================
 * Project Name : パートナーネット開発
 * System Name  : パートナーネット
 * File Name    : cr001_02.jsp
 *
 * <<Modification History>>
 * Version | Date       | Updated By            | Content
 * --------+------------+-----------------------+---------------------------------------------------
 * 1.0.0   | 2015/07/01 | 木村　しのぶ          | 新規作成
 * 2.0.0   | 2017/11/29 | 林　晃平              | 委託貸付報告等における機能改善対応
================================================================================================--%>

<html>
	<%@ include file="/jsp/incHeader.jsp"%>
	<head>
		<title><parts:message code="title.screenName"/></title>

		<script lang="JavaScript">
//<!--
				<%--
				- 登録ボタン押下時の処理
				--%>
				function click_createBtn() {
					executeAction('../../cr001/cr001_02/Cr001_02Create.form');
				}
				<%-- 戻るボタン処理 --%>
				function click_backBtn() {
					executeAction('../../cr001/cr001_02/Cr001_02Back.form');
				}

//-->
		</script>

				<link href="<%=request.getContextPath()%>/css/Jikko_Create.css" type="text/css" rel="stylesheet" />
	</head>
	<body>
		<parts:form  modelAttribute="cr001_02Form" action="./Cr001_02Init.form"  id="Form1" method="post">
			<%@ include file="/jsp/incCommonHidden.jsp" %>
			<%@ include file="/jsp/incHeaderArea.jsp" %>
			<div id="main_scroll_area">
			<div class="header">
				<div class="title"><label class="title" id="lblTitle"><parts:message code="title.screenName"/></label></div>
			</div>
			<div class="main">
				<div class="greeting">以下の報告書の登録を行います。内容をご確認のうえ「登録」ボタンを押してください。
				</div>
				<div class="greeting">貸付実行報告書の作成の入力画面へ戻る場合には「戻る」ボタンを押してください。
				</div>
				<div class="buttons">
				</div>
				<div class="buttons">
					<div style="display:none;">
						<parts:button id="btnSend" />
						<parts:button id="btnBack" />
					</div>
					<parts:button id="btnSend2" value="登録" onclick="click_createBtn();" />
					<parts:button id="btnBack2" value="戻る" title="貸付実行報告書作成の入力画面へ戻る" onclick="click_backBtn()"/><br />
				</div>
				<!-- -------------------- -->
				<!-- status               -->
				<!-- -------------------- -->
				<div class="reportDate">報告年月日：
					<parts:dlabel path="lblID_Date_Report" />
				</div>
				<br>
				<div class="status">
									<div class="status" style="color: red; font-weight: bold;">
											<parts:errors path="*" cssClass="Error" />
									</div>
				</div>
				<paging:table path="Cr001_02M1Table" paging="false" pagingDisplay="false">
					<div>
						<paging:record>
							<!-- 報告書一枚(borderで囲んである,複数可) -->
							<!-- 実装時はASP.NETのユーザコントロールよびだし -->
							<div class="page-break"><br></div>
							<div class="report" style="border:solid 1px green; height:234px;">
								<div align="center">
									<!-- 報告書の一行分(複数可) -->
									<div class="report_a_line">
										<!-- 出力用 -->
										<div class="item-output">
											<div><!-- 項目名 --> 案件：
												<parts:dlabel path="lblIndex" />
											</div>
										</div>
									</div>
									<div class="report_a_line">
										<!-- 出力用 -->
										<div class="item-output-confirm">
											<div><!-- 項目名 --> 顧客名</div>
											<div><!-- 値 -->
												<parts:dlabel path="ID_Name_Customer"  />
											</div>
										</div>
										<!-- 出力用 -->
										<div class="item-output-confirm">
											<div><!-- 項目名 --> 扱店名</div>
											<div><!-- 値 -->
												<parts:dlabel  path="ID_Name_Organization" />
											</div>
										</div>
									</div>
									<!-- 報告書の一行分(複数可) -->
									<div class="report_a_line">
										<!-- 出力用 -->
										<div class="item-output-confirm">
											<div><!-- 項目名 --> 公庫支店</div>
											<div ><!-- 値 -->
												<parts:dlabel  path="ID_Code_ShokanHonShiten"  />
											</div>
										</div>
										<!-- 出力用 -->
										<div class="item-output-confirm">
											<div><!-- 項目名 --> 扱店</div>
											<div ><!-- 値 -->
												<parts:dlabel  path="ID_Code_Organization"  />
											</div>
										</div>
										<!-- 出力用 -->
										<div class="item-output-confirm">
											<div><!-- 項目名 --> 店舗</div>
											<div ><!-- 値 -->
												<parts:dlabel  path="ID_Code_Tenpo" />
											</div>
										</div>
										<!-- 出力用 -->
										<div class="item-output-confirm">
											<div><!-- 項目名 --> 年度</div>
											<div><!-- 値 -->
												<pn:printWareki date="${record.getID_Year()}" pattern="GY" />
											</div>
										</div>
										<!-- 出力用 -->
										<div class="item-output-confirm">
											<div><!-- 項目名 --> 方式資金</div>
											<div><!-- 値 -->
												<parts:dlabel  path="ID_Code_Hoshiki_Shikin" />
											</div>
										</div>
										<!-- 出力用 -->
										<div class="item-output-confirm">
											<div><!-- 項目名 --> 番号</div>
											<div><!-- 値 -->
												<parts:dlabel  path="ID_ID_Ringi" />
											</div>
										</div>
										<!-- 出力用 -->
										<div class="item-output-confirm">
											<div><!-- 項目名 --> 枝番</div>
											<div><!-- 値 -->
												<parts:dlabel  path="ID_ID_RingiBranch" />
											</div>
										</div>
										<!-- 出力用 -->
										<div class="item-output-confirm">
											<div><!-- 項目名 --> 資金使途</div>
											<div><!-- 値 -->
												<parts:dlabel  path="ID_Code_ShikinShito" />
											</div>
										</div>
										<!-- 出力用 -->
										<div class="item-output-confirm">
											<div><!-- 項目名 --> 事業別</div>
											<div><!-- 値 -->
												<parts:dlabel  path="ID_Code_Jigyoubetsu" />
											</div>
										</div>
									</div>
									<!-- 報告書の一行分(複数可) -->
									<div class="report_a_line">
										<%-- BindするDataEntityを入力用のEntityに変更し、入力可能（右詰）項目とする。 --%>
										<!-- 出力用 -->
										<div class="item-output-confirm">
											<div><!-- 項目名 --> 利率(％)</div>
											<div><!-- 値 -->
												<parts:dlabel  path="ID_Riritsu" />
											</div>
										</div>

										<!-- 出力用 -->
										<div class="item-output-confirm">
											<div><!-- 項目名 --> 特利区分</div>
											<div><!-- 値 -->
												<parts:dlabel  path="ID_Kubun_Tokuri" />
											</div>
										</div>
										<!-- 出力用 -->
										<div class="item-output-confirm">
											<div><!-- 項目名 --> 特利(％)</div>
											<div><!-- 値 -->
												<parts:dlabel  path="ID_Tokuri" />
											</div>
										</div>
										<!-- 出力用 -->
										<div class="item-output">
											<div><!-- 項目名 --> 据置期限</div>
											<div><!-- 値 -->
												<pn:printWareki date="${record.getID_Date_SueokiKigen()}" pattern="GYM"  />
											</div>
										</div>
										<!-- 出力用 -->
										<div class="item-output-confirm">
											<div><!-- 項目名 --> 償還期限</div>
											<div><!-- 値 -->
												<pn:printWareki date="${record.getID_Date_ShokanKigen()}" pattern="GYM" />
											</div>
										</div>
										<!-- 出力用 -->
										<div class="item-output-confirm">
											<div><!-- 項目名 --> 元利金払込日</div>
											<div ><!-- 値 -->
												<parts:dlabel  path="ID_Date_GanrikinHaraiKomi" />
											</div>
										</div>
										<!-- 出力用 -->
										<div class="item-output-confirm">
											<div><!-- 項目名 --> 貸付実行日</div>
											<div ><!-- 値 -->
												<pn:printWareki date="${record.getID_Date_Kashitsukejikko()}" pattern="GYMD" />
											</div>
										</div>
									</div>
									<!-- 報告書の一行分(複数可) -->
									<div class="report_a_line">
										<!-- 出力用 -->
										<div class="item-output-confirm">
											<div><!-- 項目名 --> 受託者勘定処理年月</div>
											<div><!-- 値 -->
												<pn:printWareki date="${record.getID_Date_Jtkshori()}" pattern="GYM" />
											</div>
										</div>
										<!-- 出力用 -->
										<div class="item-output-confirm">
											<div><!-- 項目名 --> 貸付実行金額(円)</div>
											<div class="kingaku"><!-- 値 -->
												<parts:dlabel path="ID_M_Kashitsuke" />
											</div>
										</div>
										<!-- 出力用 -->
										<div class="item-output-confirm">
											<div><!-- 項目名 --> 資金交付額(円)</div>
											<div class="kingaku"><!-- 値 -->
												<parts:dlabel path="ID_M_SikinKofu"/>
											</div>
										</div>
										<!-- 出力用 -->
										<div class="item-output-confirm">
											<div><!-- 項目名 --> 貸付受入金受入額(円)</div>
											<div class="kingaku"><!-- 値 -->
												<parts:dlabel path="ID_M_KashitsukeUkeire" />
											</div>
										</div>
									</div>
								</div>
							</div> <!-- 報告書一枚終わり -->
						</paging:record>
					</div>
				</paging:table>
				<br />
			</div>
			<br />
		</div>
		</parts:form>
	</body>
</html>