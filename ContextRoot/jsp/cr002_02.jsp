
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/jsp/incTop.jsp"%>
<%@ taglib prefix="pn" uri="http://partnernet.jfc.go.jp/tags/pn"%>
<%--================================================================================================
 * Project Name : パートナーネット開発
 * System Name  : パートナーネット
 * File Name    : cr002_02.jsp
 *
 * <<Modification History>>
 * Version | Date       | Updated By            | Content
 * --------+------------+-----------------------+---------------------------------------------------
 * 1.0.0   | 2015/07/01 | 澤田　健一            | 新規作成
 * 2.0.0   | 2017/11/29 | 嶋田　美保            | 委託貸付報告等における機能改善対応
================================================================================================--%>

<html>
	<%@ include file="/jsp/incHeader.jsp"%>
	<head>
		<title><parts:message code="title.screenName"/></title>



		<link href="<%=request.getContextPath()%>/css/ukeireharaidashi_CR.css" type="text/css" rel="stylesheet" />
		<script lang="JavaScript">
		<!--
			<%--
			登録ボタン押下時の処理
			--%>
			function click_ResultBtn() {
					executeAction('../../cr002/cr002_02/Cr002_02Create.form');
			}
			<%--
			戻る押下時の処理
			--%>
			function click_backBtn() {
					executeAction('../../cr002/cr002_02/Cr002_02Back.form');
			}


//-->
</script>

	</head>
	<body>
				<parts:form modelAttribute="cr002_02Form" action="./Cr002_02Init.form" id="Form1" method="post" onsubmit="return false;">
			<%@ include file="/jsp/incCommonHidden.jsp" %>
			<%@ include file="/jsp/incHeaderArea.jsp" %>
			<div id="main_scroll_area">
			<div class="header">
				<div class="title">
					<span class="Title" id="lblTitle"><parts:message code="title.screenName"/></span>
				</div>
			</div>
			<div class="main">
				<div class="greeting">以下の報告書の登録を行います。内容をご確認のうえ「登録」ボタンを押してください。
				</div>
				<div class="greeting">貸付受入金払出充当報告書の作成の入力画面へ戻る場合には「戻る」ボタンを押してください。
				</div>
				<div class="buttons">
				</div>
				<div class="buttons">
					<div style="display:none;">
						<parts:button id="btnSend" />
						<parts:button id="btnBack" />
					</div>
					<parts:button id="btnSend2" value="登録" onclick="click_ResultBtn();" />
					<parts:button id="btnBack2" value="戻る" title="貸付受入金払出・充当報告書作成の入力画面へ戻る" onclick="click_backBtn();"  />
				</div>
				<!-- -------------------- -->
				<!-- status               -->
				<!-- -------------------- -->
				<div class="reportDate">報告年月日：
					<%-- parts:dlabel path="lblID_Date_Report" />--%>
					<fmt:parseDate value="${cr002_02Form.lblID_Date_Report}" var="ID_Date_Report" pattern="yyyyMMdd" />
										<fmt:formatDate value="${ID_Date_Report}" pattern="yyyy年MM月dd日(E)"/>
				</div>
				<div class="status" style="color:red;font-weight:bold;">
										<parts:errors path="*" cssClass="Error" /><br />
				</div>
				<paging:table path="cr002_02M1Table" paging="false" pagingDisplay="false">
					<div>
						<parts:table cssStyle="border-style:none;">
							<paging:record>
								<tr>
									<td>
										<!-- 報告書一枚(borderで囲んである,複数可) -->
										<!-- 実装時はASP.NETのユーザコントロールよびだし -->
										<div class="report">
											<div align="center">
												<!-- 報告書の一行分(複数可) -->
												<div class="report_a_line">
													<!-- 出力用 -->
													<div class="item-output">
														<div><!-- 項目名 -->
															<label id="Label1">案件：</label>
															<parts:dlabel path="lblIndex" />
														</div>
													</div>
												</div>
												<div class="report_a_line">
													<!-- 出力用 -->
													<div class="item-output">
														<div><!-- 項目名 -->
															<label id="Label2">顧客名</label></div>
														<div><!-- 値 -->
															<parts:dlabel path="ID_Name_Customer" />
														</div>
													</div>
													<!-- 出力用 -->
													<div class="item-output">
														<div><!-- 項目名 -->
															<label id="Label3">扱店名</label></div>
														<div><!-- 値 -->
															<parts:dlabel path="ID_Name_Organization" />
														</div>
													</div>
												</div>
												<!-- 報告書の一行分(複数可) -->
												<div class="report_a_line">
													<!-- 出力用 -->
													<div class="item-output">
														<div><!-- 項目名 -->
															<label id="Label4">公庫支店</label></div>
														<div><!-- 値 -->
															<parts:dlabel path="ID_Code_ShokanHonShiten" />
														</div>
													</div>
													<!-- 出力用 -->
													<div class="item-output">
														<div><!-- 項目名 -->
															<label id="Label5">扱店</label></div>
														<div><!-- 値 -->
															<parts:dlabel path="ID_Code_Organization" />
														</div>
													</div>
													<!-- 出力用 -->
													<div class="item-output">
														<div><!-- 項目名 -->
															<label id="Label6">店舗</label></div>
														<div><!-- 値 -->
															<parts:dlabel path="ID_Code_Tenpo" />
														</div>
													</div>
													<!-- 出力用 -->
													<div class="item-output">
														<div><!-- 項目名 -->
															<label id="Label7">年度</label></div>
														<div><!-- 値 -->
															<pn:printWareki date="${record.ID_Year}" pattern="GY"/>
														</div>
													</div>
													<!-- 出力用 -->
													<div class="item-output">
														<div><!-- 項目名 -->
															<label id="Label8">方式資金</label></div>
														<div><!-- 値 -->
															<parts:dlabel path="ID_Code_HoshikiShikin" />
														</div>
													</div>
													<!-- 出力用 -->
													<div class="item-output">
														<div><!-- 項目名 -->
															<label id="Label9">番号</label></div>
														<div><!-- 値 -->
															<parts:dlabel path="ID_ID_Ringi" />
														</div>
													</div>
													<!-- 出力用 -->
													<div class="item-output">
														<div><!-- 項目名 -->
															<label id="Label10">枝番</label></div>
														<div><!-- 値 -->
															<parts:dlabel path="ID_ID_RingiBranch" />
														</div>
													</div>
													<!-- 出力用 -->
													<div class="item-output">
														<div><!-- 項目名 -->
															<label id="Label11">資金使途</label></div>
														<div><!-- 値 -->
															<parts:dlabel path="ID_Code_ShikinShito" />
														</div>
													</div>
													<!-- 出力用 -->
													<div class="item-output">
														<div><!-- 項目名 -->
															<label id="Label12">事業別</label></div>
														<div><!-- 値 -->
															<parts:dlabel path="ID_Code_Jigyobetsu" />
														</div>
													</div>
												</div>
												<!-- 報告書の一行分(複数可) -->
												<div class="report_a_line">
													<!-- 出力用 -->
													<div class="item-output">
														<div><!-- 項目名 -->
															<label id="Label13">利率(％)</label></div>
														<div><!-- 値 -->
															<parts:dlabel path="ID_Riritsu" />
														</div>
													</div>
													<!-- 出力用 -->
													<div class="item-output">
														<div><!-- 項目名 -->
															<label id="Label14">特利区分</label></div>
														<div><!-- 値 -->
															<parts:dlabel path="ID_Kubun_Tokuri" />
														</div>
													</div>
													<!-- 出力用 -->
													<div class="item-output">
														<div><!-- 項目名 -->
															<label id="Label15">特利(％)</label></div>
														<div><!-- 値 -->
															<parts:dlabel path="ID_Tokuri" />
														</div>
													</div>
													<!-- 出力用 -->
													<div class="item-output">
														<div><!-- 項目名 -->
															<label id="Label16">据置期限</label></div>
														<div><!-- 値 -->
															<pn:printWareki date="${record.ID_Date_SueokiKigen}" pattern="GYM"/>
														</div>
													</div>
													<!-- 出力用 -->
													<div class="item-output">
														<div><!-- 項目名 -->
															<label id="Label17">償還期限</label></div>
														<div><!-- 値 -->
															<pn:printWareki date="${record.ID_Date_ShokanKigen}" pattern="GYM"/>
														</div>
													</div>
													<!-- 出力用 -->
													<div class="item-output">
														<div><!-- 項目名 -->
															<label id="Label18">元利金払込日</label></div>
														<div><!-- 値 -->
															<parts:dlabel path="ID_Date_GanrikinHaraiKomi" />
														</div>
													</div>
													<!-- 出力用 -->
													<div class="item-output">
														<div><!-- 項目名 -->
															<label id="Label19">貸付実行日</label></div>
														<div><!-- 値 -->
															<pn:printWareki date="${record.ID_Date_Jikko}" pattern="GYMD"/>
														</div>
													</div>
												</div>
												<!-- 報告書の一行分(複数可) -->
												<div class="report_a_line">
													<!-- 出力用 -->
													<div class="item-output">
														<div><!-- 項目名 -->
															<label id="Label20">貸付実行金額(円)</label></div>
														<div class="kingaku" style="text-align: right;format-number;"><!-- 値 -->
															<parts:dlabel path="ID_M_Kashitsuke"/>
														</div>
													</div>
													<!-- 出力用 -->
													<div class="item-output">
														<div><!-- 項目名 -->
															<label id="Label21">貸付実行時の資金交付額(円)</label></div>
														<div class="kingaku" style="text-align: right;format-number;"><!-- 値 -->
															<parts:dlabel path="ID_M_SikinKofu"/>
														</div>
													</div>
													<!-- 出力用 -->
													<div class="item-output">
														<div><!-- 項目名 -->
															<label id="Label22">貸付実行時の貸付受入金受入額(円)</label></div>
														<div class="kingaku" style="text-align: right;format-number;"><!-- 値 -->
															<parts:dlabel path="ID_M_KashitukeUkeire"/>
														</div>
													</div>
													<!-- 出力用 -->
													<div class="item-output">
														<div><!-- 項目名 -->
															<label id="Label23">貸付受入金残高(円)</label></div>
														<div class="kingaku" style="text-align: right;format-number;"><!-- 値 -->
															<parts:dlabel path="ID_M_KashitsukeUkeireZan"/>
														</div>
													</div>
												</div>
												<!-- 報告書の一行分(複数可) -->
												<div class="report_a_line">
													<!-- 出力用 -->
													<div class="item-output">
														<div><!-- 項目名 -->
															<label id="Label25">払出元金充当日</label></div>
														<div><!-- 値 -->
															<pn:printWareki date="${record.ID_Date_HaraidashiJuto}" pattern="GYMD"/>
														</div>
													</div>
													<!-- 出力用 -->
													<div class="item-output">
														<div><!-- 項目名 -->
															<label id="Label24">受託者勘定処理年月</label></div>
														<div><!-- 値 -->
															<pn:printWareki date="${record.ID_Date_Jtkshori}" pattern="GYM"/>
														</div>
													</div>
													<!-- 出力用 -->
													<div class="item-output">
														<div><!-- 項目名 -->
															<label id="Label26">資金払出額(円)</label></div>
														<div class="kingaku" style="text-align: right;format-number;"><!-- 値 -->
															<parts:dlabel path="ID_M_Haraidashi"/>
														</div>
													</div>
													<!-- 出力用 -->
													<div class="item-output">
														<div><!-- 項目名 -->
															<label id="Label27">元金充当額(円)</label></div>
														<div class="kingaku" style="text-align: right;format-number;"><!-- 値 -->
															<parts:dlabel path="ID_M_Ganju"/>
														</div>
													</div>
												</div>
												<!-- 報告書の一行分(複数可) -->
												<div class="report_a_line">
													<fieldset>
														<legend align="left">
															元金充当した場合</legend>
														<div class="report_a_line">
															<!-- 出力用 -->
															<div class="item-output">
																<div><!-- 項目名 -->
																	<label id="Label28">元金充当後貸付金残高(円)</label></div>
																<div class="kingaku" style="text-align: right;format-number;"><!-- 値 -->
																	<parts:dlabel path="ID_M_KashitsukeZandakaAfterGanju"/>
																</div>
															</div>
															<!-- 出力用 -->
															<div class="item-output">
																<div><!-- 項目名 -->
																	<label id="Label29">元金充当後第１回約定日</label></div>
																<div><!-- 値 -->
																	<pn:printWareki date="${record.ID_Date_FirstYakujoAfterGanju}" pattern="GYMD"/>
																</div>
															</div>
															<!-- 出力用 -->
															<div class="item-output">
																<div><!-- 項目名 -->
																	<label id="Label30">繰償事由コード</label></div>
																<div><!-- 値 -->
																	<parts:dlabel path="ID_Code_KurishoJiyu" />
																</div>
															</div>
														</div>
														<!-- 報告書の一行分(複数可) -->
														<div class="report_a_line">
															<fieldset>
																<legend align="left">
																	期限固定償還の場合</legend>
																<!-- 出力用 -->
																<div class="item-output">
																	<div><!-- 項目名 -->
																		<label id="Label31">元金充当後の元金均等額(円)</label></div>
																	<div class="kingaku" style="text-align: right;format-number;"><!-- 値 -->
																		<parts:dlabel path="ID_M_GankinKintoAfterGanju"/>
																	</div>
																</div>
																<!-- 出力用 -->
																<div class="item-output">
																	<div><!-- 項目名 -->
																		<label id="Label32">元金充当後の元金不均等額(円)</label></div><!-- 値 -->
																	<div class="kingaku" style="text-align: right;format-number;">
																		<parts:dlabel path="ID_M_GankinFukintoAfterGanju"/>
																	</div>
																</div>
																<!-- 出力用 -->
																<div class="item-output">
																	<div><!-- 項目名 -->
																		<label id="Label33">調整コード</label></div>
																	<div><!-- 値 -->
																		<span id="ID_Code_Chosei_Candidate" style="color:#003399;">
																			<parts:radioButton path="ID_Code_Chosei_Candidate" value="1" disabled="true">初回</parts:radioButton>
																			<parts:radioButton path="ID_Code_Chosei_Candidate" value="2" disabled="true">最終回</parts:radioButton>
																			<parts:radioButton path="ID_Code_Chosei_Candidate" value=""  disabled="true">なし</parts:radioButton>
																		</span>
																	</div>
																</div>
															</fieldset>
														</div>
													</fieldset>
												</div>
											</div>
										</div>
										<!-- 報告書一枚終わり -->
									</td>
								</tr>
							</paging:record>
						</parts:table>
					</div>
				</paging:table>
				<br />
			</div>
			<br />
		</div>
		</parts:form><%@ include file="/jsp/incFooter.jsp"%>
	</body>
</html>