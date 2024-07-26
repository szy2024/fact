
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/jsp/incTop.jsp"%>
<%@ taglib prefix="pn" uri="http://partnernet.jfc.go.jp/tags/pn"%>

<%--================================================================================================
 * Project Name : パートナーネット開発
 * System Name  : パートナーネット
 * File Name    : md003_04.jsp
 *
 * <<Modification History>>
 * Version | Date       | Updated By            | Content
 * --------+------------+-----------------------+---------------------------------------------------
 * 1.0.0   | 2015/07/01 | ○○　○○            | 新規作成
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
					executeAction('../../md003/md003_02/Md003_02Create.form');
				}
				<%-- 戻るボタン処理 --%>
				function click_backBtn() {
					executeAction('../../md003/md003_02/Md003_02Back.form');
				}

//-->
		</script>



		<link href="<%=request.getContextPath()%>/css/gju_Mod.css" type="text/css" rel="stylesheet" />
	</head>
	<body>
		<parts:form modelAttribute="md003_02Form" action="./Md003_02Init.form"  id="Form1" method="post" onsubmit="return false;">
			<%@ include file="/jsp/incCommonHidden.jsp" %>
			<%@ include file="/jsp/incHeaderArea.jsp" %>
			<div id="main_scroll_area">
			<div class="header">
				<div class="title">
					<span class="Title" id="lblTitle"><parts:message code="title.screenName"/></span>
				</div>
			</div>
			<div class="main">
				<div class="greeting">
					取消対象報告書が確定しました。<br />
					以下の報告書の登録を行います。内容をご確認のうえ「登録」ボタンを押してください。
				</div>
				<div class="greeting" style="white-space:nowrap">
					<logic:notEqual path="ProcessMode" value="5">
						<label id="lblBack_Normal">元利金受入・充当報告書の取消・修正の入力画面へ戻る場合には「戻る」ボタンを押してください。</label>
					</logic:notEqual>
					<logic:equal path="ProcessMode" value="5">
						<label id="lblBack_DelCancel">元利金受入・充当報告書の取消・修正対象報告書一覧の画面へ戻る場合には「戻る」ボタンを<br>押してください。</label>
					</logic:equal>
				</div>
			<!-- <div class="buttons">
					<input id="btnSign" onclick="SignTextData(mkdata(this.form),sign_data);" type="button"
						value="署名"  />
				</div>  -->
				<div class="buttons">
					<div style="display:none;">
						<parts:button id="btnUpdate" />
						<parts:button id="btnBack" />
					</div>
					<parts:button id="btnUpdate2" value="登録" onclick="click_createBtn()" />
					<parts:button id="btnBack2" value="戻る" title="元利金受入・充当報告書の取消・修正の入力画面へ戻る" onclick="click_backBtn()" />
				</div>
				<div class="reportDate">報告年月日：
					<fmt:parseDate value="${md003_02Form.lblID_Date_Report}"
						var="lblID_Date_Report" pattern="yyyyMMdd" />
					<fmt:formatDate value="${lblID_Date_Report}"
						pattern="yyyy年MM月dd日(E)" />
				</div>
				<div class="status">
	                <div class="lblErr" style="color: red; font-weight: bold;">
	                    <parts:errors path="*" cssClass="Error" />
	                </div>
					<div style="color:red;font-weight:bold;">
						<parts:dlabel path="lblMessage" />
					</div><br />
				</div>
				<div>
					<label id="lblComment"><parts:dlabel path="lblComment"/></label>
				</div>
				<parts:table id="pnl" cssStyle="border-style:none;">
					<parts:tr id="pnl_Red" cssStyle="border-style:none;">
						<td>
							<div class="page-break"><br/></div>
							<div id="pnl_Red">
							<!-- 報告書一枚(borderで囲んである,複数可) -->
							<!-- 実装時はASP.NETのユーザコントロールよびだし -->
							<!-- ジャンプ用アンカー(名前) -->
								<div class="report" style="height:442px">
									<div class="kousei-aka" align="center">
										<parts:dlabel path="lblID_Head_Red"/>
										<logic:equal path="lblID_Head_Red2"  value="Visible">
											<label id="lblID_Head_Red2" style="color:red;">赤</label>
										</logic:equal>
									</div>
						 			<!-- ジャンプ用アンカー(名前) -->
									<div align="center"><!-- 出力用 --> <!-- 報告書の一行分(複数可) -->
										<div class="report_a_line"><!-- 入力用 --> <!-- 出力用 -->
											<div class="item-output">
												<div><!-- 項目名 -->
													<label id="Label1">顧客名</label></div>
												<div><!-- 値 -->
													<parts:dlabel path="lblID_Name_Customer_Red" /></div>
											</div> <!-- 出力用 -->
											<div class="item-output">
												<div><!-- 項目名 -->
													<label id="Label2">扱店名</label></div>
												<div><!-- 値 -->
													<parts:dlabel path="lblID_Name_Organization_Red" /></div>
											</div>
										</div> <!-- 報告書の一行分(複数可) -->
										<div class="report_a_line"><!-- 出力用 -->
											<div class="item-output">
												<div><!-- 項目名 -->
													<label id="Label3">公庫支店</label></div>
												<div style="text-align: center;"><!-- 値 -->
													<parts:dlabel path="lblID_Code_KoukoShiten_Red" /></div>
											</div> <!-- 出力用 -->
										<div class="item-output">
											<div><!-- 項目名 -->
												<label id="Label4">扱店</label></div>
											<div style="text-align: center;"><!-- 値 -->
												<parts:dlabel path="lblID_Code_Organization_Red" /></div>
										</div> <!-- 出力用 -->
										<div class="item-output">
											<div><!-- 項目名 -->
												<label id="Label5">店舗</label></div>
											<div style="text-align: center;"><!-- 値 -->
												<parts:dlabel path="lblID_Code_Tenpo_Red" /></div>
										</div> <!-- 出力用 -->
										<div class="item-output">
											<div><!-- 項目名 -->
												<label id="Label6">年度</label></div>
											<div style="text-align: center;"><!-- 値 -->
												<pn:printWareki date="${md003_02Form.lblID_Year_Red}" pattern='GY'/></div>
										</div> <!-- 出力用 -->
										<div class="item-output">
											<div><!-- 項目名 -->
												<label id="Label7">方式資金</label></div>
											<div style="text-align: center;"><!-- 値 -->
												<parts:dlabel path="lblID_Code_HoshikiShikin_Red" /></div>
										</div> <!-- 出力用 -->
										<div class="item-output">
											<div><!-- 項目名 -->
												<label id="Label8">番号</label></div>
											<div style="text-align: center;"><!-- 値 -->
												<parts:dlabel path="lblID_ID_Ringi_Red" /></div>
										</div> <!-- 出力用 -->
										<div class="item-output">
											<div><!-- 項目名 -->
												<label id="Label9">枝番</label></div>
											<div style="text-align: center;"><!-- 値 -->
												<parts:dlabel path="lblID_ID_RingiBranch_Red" /></div>
										</div> <!-- 出力用 -->
										<div class="item-output">
											<div><!-- 項目名 -->
												<label id="Label10">貸付実行日</label></div>
											<div style="text-align: center;"><!-- 値 -->
												<pn:printWareki date="${md003_02Form.lblID_Date_Kashitsukejikko_Red}" pattern='GYMD'/></div>
										</div>
										</div> <!-- 報告書の一行分(複数可) -->
											<div class="report_a_line"><!-- 出力用 -->
												<div class="item-output">
													<div><!-- 項目名 -->
														<label id="Label11">貸付金額</label></div>
													<div class="kingaku" style="text-align: right;"><!-- 値 -->
														<parts:dlabel path="lblID_M_Kashitsuke_Red" formatType="number" formatPattern="integer" /></div>
												</div> <!-- 出力用 -->
												<div class="item-output">
													<div><!-- 項目名 -->
														<label id="Label12">資金使途</label></div>
													<div style="text-align: center;"><!-- 値 -->
														<parts:dlabel path="lblID_Code_ShikinShito_Red" /></div>
												</div> <!-- 出力用 -->
												<div class="item-output">
													<div><!-- 項目名 -->
														<label id="Label13">事業別</label></div>
													<div style="text-align: center;"><!-- 値 -->
														<parts:dlabel path="lblID_Code_Jigyobetsu_Red" /></div>
												</div> <!-- 出力用 -->
												<div class="item-output">
													<div><!-- 項目名 -->
														<label id="Label14">利率(％)</label></div>
													<div style="text-align: center;"><!-- 値 -->
														<parts:dlabel path="lblID_Riritsu_Red" /></div>
												</div> <!-- 出力用 -->
												<div class="item-output">
													<div><!-- 項目名 -->
														<label id="Label15">特利区分</label></div>
													<div style="text-align: center;"><!-- 値 -->
														<parts:dlabel path="lblID_Kubun_Tokuri_Red" /></div>
												</div> <!-- 出力用 -->
												<div class="item-output">
													<div><!-- 項目名 -->
														<label id="Label16">特利(％)</label></div>
													<div style="text-align: center;"><!-- 値 -->
														<parts:dlabel path="lblID_Tokuri_Red" /></div>
												</div> <!-- 出力用 -->
												<div class="item-output">
													<div><!-- 項目名 -->
														<label id="Label17">償還方法</label></div>
													<div style="text-align: center;"><!-- 値 -->
														<parts:dlabel path="lblID_Code_Shokan_Red" /></div>
													</div> <!-- 出力用 -->
												<div class="item-output">
													<div><!-- 項目名 -->
														<label id="Label18">据置期限</label></div>
													<div style="text-align: center;"><!-- 値 -->
														<pn:printWareki date="${md003_02Form.lblID_Date_SueokiKigen_Red}" pattern='GYM'/></div>
												</div>
											</div> <!-- 報告書の一行分(複数可) -->
										<div class="report_a_line"><!-- 出力用 -->
											<div class="item-output">
												<div><!-- 項目名 -->
													<label id="Label19">償還期限</label></div>
												<div style="text-align: center;"><!-- 値 -->
													<pn:printWareki date="${md003_02Form.lblID_Date_ShokanKigen_Red}" pattern='GYM'/></div>
											</div> <!-- 出力用 -->
											<div class="item-output">
												<div><!-- 項目名 -->
													<label id="Label20">元利金払込日</label></div>
												<div style="text-align: center;"><!-- 値 -->
													<parts:dlabel path="lblID_Date_GanrikinHaraiKomi_Red" /></div>
											</div> <!-- 出力用 -->
											<div class="item-output">
												<div><!-- 項目名 -->
													<label id="Label21">元利又は元金均等額(円)</label></div>
											<div class="kingaku" style="text-align: right;"><!-- 値 -->
												<parts:dlabel path="lblID_M_GankinKinto_Red" formatType="number" formatPattern="integer" /></div>
											</div> <!-- 出力用 -->
											<div class="item-output">
												<div><!-- 項目名 -->
													<label id="Label22">払込前残元金(円)</label></div>
												<div class="kingaku" style="text-align: right;"><!-- 値 -->
													<parts:dlabel path="lblID_M_KashitsukeZandaka_Red" formatType="number" formatPattern="integer" /></div>
												</div> <!-- 出力用 -->
											<div class="item-output">
												<div><!-- 項目名 -->
													<label id="Label23">払込期日</label></div>
												<div style="text-align: center;"><!-- 値 -->
													<pn:printWareki date="${md003_02Form.lblID_Date_Haraikomi_Red}" pattern='GYMD'/></div>
											</div> <!-- 出力用 -->
											<div class="item-output">
												<div><!-- 項目名 -->
													<label id="Label24">払込金額(円)</label></div>
												<div class="kingaku" style="text-align: right;"><!-- 値 -->
													<parts:dlabel path="lblID_M_Haraikomi_Red" formatType="number" formatPattern="integer" /></div>
											</div>
										</div> <!-- 報告書の一行分(複数可) -->
										<div class="report_a_line"><!-- 出力用 -->
											<div class="item-output">
												<div><!-- 項目名 -->
													<label id="Label25">控除利息(円)</label></div>
												<div class="kingaku" style="text-align: right;"><!-- 値 -->
													<parts:dlabel path="lblID_M_KojoRisoku_Red" formatType="number" formatPattern="integer" /></div>
											</div> <!-- 出力用 -->
											<div class="item-output">
												<div><!-- 項目名 -->
													<label id="Label26">差引払込額(円)</label></div>
												<div class="kingaku" style="text-align: right;"><!-- 値 -->
													<parts:dlabel path="lblID_M_SashihikiHaraikomi_Red" formatType="number" formatPattern="integer" /></div>
											</div> <!-- 出力用 -->
											<div class="item-output">
												<div><!-- 項目名 -->
													<label id="Label27">払込後残元金(円)</label></div>
												<div class="kingaku" style="text-align: right;"><!-- 値 -->
													<parts:dlabel path="lblID_M_ZangankinAfterHaraikomi_Red" formatType="number" formatPattern="integer" /></div>
											</div> <!-- 入力用 -->
											<div class="item-output">
												<div>
													<label id="Label28">約定利息(円)</label></div>
												<div class="kingaku" style="text-align: right;">
													<parts:dlabel path="lblID_M_YakujoRisoku_Red" formatType="number" formatPattern="integer" /></div>
											</div> <!-- 入力用 -->
											<div class="item-output">
												<div>
													<label id="Label29">約定元金(円)</label></div>
												<div class="kingaku" style="text-align: right;">
													<parts:dlabel path="lblID_M_YakujoGankin_Red" formatType="number" formatPattern="integer" /></div>
											</div>
										</div> <!-- 報告書の一行分(複数可) -->
										<div class="report_a_line"><!-- 入力用 -->
											<div class="item-output">
												<div>
													<label id="Label30">遅延損害金(円)</label></div>
												<div class="kingaku" style="text-align: right;">
													<parts:dlabel path="lblID_M_ChienSongai_Red" formatType="number" formatPattern="integer" /></div>
											</div> <!-- 入力用 -->
											<div class="item-output">
												<div>
													<label id="Label31">違約金(円)</label></div>
												<div class="kingaku" style="text-align: right;">
													<parts:dlabel path="lblID_M_Iyaku_Red" formatType="number" formatPattern="integer" /></div>
											</div> <!-- 入力用 -->
											<div class="item-output">
												<div>
													<label id="Label32">違約金(利子軽減分)(円)</label></div>
												<div class="kingaku" style="text-align: right;">
													<parts:dlabel path="lblID_M_IyakuRishikeigen_Red" formatType="number" formatPattern="integer" /></div>
											</div> <!-- 入力用 -->
											<div class="item-output">
												<div>
													<label id="Label33">仮受金からの充当額(円)</label></div>
												<div class="kingaku" style="text-align: right;">
													<parts:dlabel path="lblID_M_KariukeIppanJuto_Red"  /></div>
											</div>
										</div> <!-- 報告書の一行分(複数可) -->
										<div class="report_a_line"><!-- 入力用 -->
											<div class="item-output">
												<div>
													<label id="Label34">入金日</label></div>
												<div style="text-align: right;">
													<pn:printWareki date="${md003_02Form.lblID_Date_Nyukin_Red}" pattern='GYMD'/></div>
												</div>
												<div class="item-output">
													<div>
														<label id="Label35">受託者勘定処理年月</label></div>
													<div style="text-align: center;">
														<pn:printWareki date="${md003_02Form.lblID_Date_Jtkshori_Red}" pattern='GYM'/></div>
												</div>
										</div> <!-- 入力用 -->
										<div class="item-output">
											<div>
												<label id="Label36">送金日</label></div>
											<div style="text-align: right;">
												<pn:printWareki date="${md003_02Form.lblID_Date_Sokin_Red}" pattern='GYMD'/></div>
										</div>
										<div class="report_a_line">
											<div class="item-output">
												<div>
													<label id="Label37">送金日番号</label></div>
												<div style="text-align: center;">
													<parts:dlabel path="lblID_ID_Sokinbi_Red" /></div>
											</div>
											<div class="item-output">
												<div>&nbsp;</div>
												<div><!-- 項目名 -->
													<span disabled="true">
														<parts:checkbox path="ckhAfter_Daibensai_Red" id="ckhAfter_Daibensai_Red" value = "1" style="text-align: right;" name="ckhAfter_Daibensai_Red" disabled="true" />
													<label for="ckhAfter_Daibensai_Red">代弁履行後の作成</label></span>
												</div>
											</div>
										</div>
									</div>
								</div> <!-- 報告書一枚終わり -->
							</div>
						</td>
					</parts:tr>

					<parts:tr id="pnl_Mod"  cssStyle="border-style:none;">
						<td>
							<div class="page-break"><br/></div>
							<div id="pnl_Mod">
							<!-- 報告書一枚(borderで囲んである,複数可) -->
							<!-- ジャンプ用アンカー(名前) -->
								<div class="report" style="height:442px">
									<div class="shusei" align="center">
										<label id="lblID_Head"><parts:dlabel path="lblID_Head"/></label>
									</div>
									<div align="center"><!-- 報告書の一行分(複数可) -->
										<div class="report_a_line"><!-- 入力用 --> <!-- 出力用 -->
											<div class="item-output">
												<div><!-- 項目名 -->
													<label id="Label38">顧客名</label></div>
												<div><!-- 値 -->
													<parts:dlabel path="lblID_Name_Customer" /></div>
											</div> <!-- 出力用 -->
											<div class="item-output">
												<div><!-- 項目名 -->
													<label id="Label39">扱店名</label></div>
												<div><!-- 値 -->
													<parts:dlabel path="lblID_Name_Organization" /></div>
											</div>
										</div> <!-- 報告書の一行分(複数可) -->
										<div class="report_a_line"><!-- 出力用 -->
											<div class="item-output">
												<div><!-- 項目名 -->
													<label id="Label40">公庫支店</label></div>
												<div style="text-align: center;"><!-- 値 -->
													<parts:dlabel path="lblID_Code_KoukoShiten" /></div>
											</div> <!-- 出力用 -->
											<div class="item-output">
												<div><!-- 項目名 -->
													<label id="Label41">扱店</label></div>
												<div style="text-align: center;"><!-- 値 -->
													<parts:dlabel path="lblID_Code_Organization" /></div>
											</div> <!-- 出力用 -->
											<div class="item-output">
												<div><!-- 項目名 -->
													<label id="Label42">店舗</label></div>
												<div style="text-align: center;"><!-- 値 -->
													<parts:dlabel path="lblID_Code_Tenpo" /></div>
											</div> <!-- 出力用 -->
											<div class="item-output">
												<div><!-- 項目名 -->
													<label id="Label43">年度</label></div>
												<div style="text-align: center;"><!-- 値 -->
													<pn:printWareki date="${md003_02Form.lblID_Year}" pattern='GY'/></div>
											</div> <!-- 出力用 -->
											<div class="item-output">
												<div><!-- 項目名 -->
													<label id="Label44">方式資金</label></div>
												<div style="text-align: center;"><!-- 値 -->
													<parts:dlabel path="lblID_Code_HoshikiShikin" /></div>
											</div> <!-- 出力用 -->
											<div class="item-output">
												<div><!-- 項目名 -->
													<label id="Label45">番号</label></div>
												<div style="text-align: center;"><!-- 値 -->
													<parts:dlabel path="lblID_ID_Ringi" /></div>
											</div> <!-- 出力用 -->
											<div class="item-output">
												<div><!-- 項目名 -->
													<label id="Label46">枝番</label></div>
												<div style="text-align: center;"><!-- 値 -->
													<parts:dlabel path="lblID_ID_RingiBranch" /></div>
											</div> <!-- 出力用 -->
											<div class="item-output">
												<div><!-- 項目名 -->
													<label id="Label47">貸付実行日</label></div>
												<div style="text-align: center;"><!-- 値 -->
													<pn:printWareki date="${md003_02Form.lblID_Date_Kashitsukejikko}" pattern='GYMD'/></div>
											</div>
										</div> <!-- 報告書の一行分(複数可) -->
										<div class="report_a_line"><!-- 出力用 -->
											<div class="item-output">
												<div><!-- 項目名 -->
													<label id="Label48">貸付金額</label></div>
												<div class="kingaku" style="text-align: right;"><!-- 値 -->
													<parts:dlabel path="lblID_M_Kashitsuke" formatType="number" formatPattern="integer" /></div>
											</div> <!-- 出力用 -->
											<div class="item-output">
												<div><!-- 項目名 -->
													<label id="Label49">資金使途</label></div>
												<div style="text-align: center;"><!-- 値 -->
													<parts:dlabel path="lblID_Code_ShikinShito" /></div>
											</div> <!-- 出力用 -->
											<div class="item-output">
												<div><!-- 項目名 -->
													<label id="Label50">事業別</label></div>
												<div style="text-align: center;"><!-- 値 -->
													<parts:dlabel path="lblID_Code_Jigyobetsu" /></div>
											</div> <!-- 出力用 -->
											<div class="item-output">
												<div><!-- 項目名 -->
													<label id="Label51">利率(％)</label></div>
												<div style="text-align: center;"><!-- 値 -->
													<parts:dlabel path="lblID_Riritsu" /></div>
											</div> <!-- 出力用 -->
											<div class="item-output">
												<div><!-- 項目名 -->
													<label id="Label52">特利区分</label></div>
												<div style="text-align: center;"><!-- 値 -->
													<parts:dlabel path="lblID_Code_TokuriKubun" /></div>
											</div> <!-- 出力用 -->
											<div class="item-output">
												<div><!-- 項目名 -->
													<label id="Label53">特利(％)</label></div>
												<div style="text-align: center;"><!-- 値 -->
													<parts:dlabel path="lblID_Tokuri" /></div>
											</div> <!-- 出力用 -->
											<div class="item-output">
												<div><!-- 項目名 -->
													<label id="Label54">償還方法</label></div>
												<div style="text-align: center;"><!-- 値 -->
													<parts:dlabel path="lblID_Code_Shokan" /></div>
											</div> <!-- 出力用 -->
											<div class="item-output">
												<div><!-- 項目名 -->
													<label id="Label55">据置期限</label></div>
												<div style="text-align: center;"><!-- 値 -->
													<pn:printWareki date="${md003_02Form.lblID_Date_SueokiKigen}" pattern='GYM'/></div>
											</div>
										</div> <!-- 報告書の一行分(複数可) -->
										<div class="report_a_line"><!-- 出力用 -->
											<div class="item-output">
												<div><!-- 項目名 -->
													<label id="Label56">償還期限</label></div>
												<div style="text-align: center;"><!-- 値 -->
													<pn:printWareki date="${md003_02Form.lblID_Date_ShokanKigen}" pattern='GYM'/></div>
											</div> <!-- 出力用 -->
											<div class="item-output">
												<div><!-- 項目名 -->
													<label id="Label57">元利金払込日</label></div>
												<div style="text-align: center;"><!-- 値 -->
													<parts:dlabel path="lblID_Date_GanrikinHaraikomi" /></div>
											</div> <!-- 出力用 -->
											<div class="item-output">
												<div><!-- 項目名 -->
													<label id="Label58">元利又は元金均等額(円)</label></div>
												<div class="kingaku" style="text-align: right;"><!-- 値 -->
													<parts:dlabel path="lblID_M_GankinKinto" formatType="number" formatPattern="integer" /></div>
											</div> <!-- 出力用 -->
											<div class="item-output">
												<div><!-- 項目名 -->
													<label id="Label59">払込前残元金(円)</label></div>
												<div class="kingaku" style="text-align: right;"><!-- 値 -->
													<parts:dlabel path="lblID_M_KashitsukeZandaka" formatType="number" formatPattern="integer" /></div>
											</div> <!-- 出力用 -->
											<div class="item-output">
												<div><!-- 項目名 -->
													<label id="Label60">払込期日</label></div>
												<div style="text-align: center;"><!-- 値 -->
													<pn:printWareki date="${md003_02Form.lblID_Date_Haraikomi}" pattern='GYMD'/></div>
											</div> <!-- 出力用 -->
											<div class="item-output">
												<div><!-- 項目名 -->
													<label id="Label61">払込金額(円)</label></div>
												<div class="kingaku" style="text-align: right;"><!-- 値 -->
													<parts:dlabel path="lblID_M_Haraikomi" formatType="number" formatPattern="integer" /></div>
											</div>
										</div> <!-- 報告書の一行分(複数可) -->
										<div class="report_a_line"><!-- 出力用 -->
											<div class="item-output">
												<div><!-- 項目名 -->
													<label id="Label62">控除利息(円)</label></div>
												<div class="kingaku" style="text-align: right;"><!-- 値 -->
													<parts:dlabel path="lblID_M_KojoRisoku" formatType="number" formatPattern="integer" /></div>
											</div> <!-- 出力用 -->
											<div class="item-output">
												<div><!-- 項目名 -->
													<label id="Label63">差引払込額(円)</label></div>
												<div class="kingaku" style="text-align: right;"><!-- 値 -->
												<logic:notEqual path="lblID_M_SashihikiHaraikomi" value="">
													<parts:dlabel path="lblID_M_SashihikiHaraikomi" formatType="number" formatPattern="integer" />
												</logic:notEqual>
												<logic:equal path="lblID_M_SashihikiHaraikomi" value="">
													<parts:dlabel path="lblID_M_SashihikiHaraikomi"/>
												</logic:equal>
												</div>
											</div> <!-- 出力用 -->
											<div class="item-output">
												<div><!-- 項目名 -->
													<label id="Label64">払込後残元金(円)</label></div>
												<div class="kingaku" style="text-align: right;"><!-- 値 -->
													<parts:dlabel path="lblID_M_ZangankinAfterHaraikomi" formatType="number" formatPattern="integer" /></div>
											</div> <!-- 入力用 -->
											<div class="item-output">
												<div>
													<label id="Label65">約定利息(円)</label></div>
												<div class="kingaku" style="text-align: right;">
													<parts:dlabel path="lblID_M_YakujoRisoku" formatType="number" formatPattern="integer" /></div>
											</div> <!-- 入力用 -->
											<div class="item-output">
												<div>
													<label id="Label66">約定元金(円)</label></div>
												<div class="kingaku" style="text-align: right;">
													<parts:dlabel path="lblID_M_YakujoGankin" formatType="number" formatPattern="integer" /></div>
											</div>
										</div> <!-- 報告書の一行分(複数可) -->
										<div class="report_a_line"><!-- 入力用 -->
											<div class="item-output">
												<div>
													<label id="Label67">遅延損害金(円)</label></div>
												<div class="kingaku" style="text-align: right;">
													<parts:dlabel path="lblID_M_ChienSongai" formatType="number" formatPattern="integer" /></div>
											</div> <!-- 入力用 -->
											<div class="item-output">
												<div>
													<label id="Label68">違約金(円)</label></div>
												<div class="kingaku" style="text-align: right;">
													<parts:dlabel path="lblID_M_Iyaku" formatType="number" formatPattern="integer" /></div>
											</div> <!-- 入力用 -->
											<div class="item-output">
												<div>
													<label id="Label69">違約金(利子軽減分)(円)</label></div>
												<div class="kingaku" style="text-align: right;">
													<parts:dlabel path="lblID_M_IyakuRishikeigen" formatType="number" formatPattern="integer" /></div>
											</div> <!-- 入力用 -->
											<div class="item-output">
												<div>
													<label id="Label70">仮受金からの充当額(円)</label></div>
												<div class="kingaku" style="text-align: right;">
													<parts:dlabel path="lblID_M_KariukeIppanJuto"  /></div>
											</div>
										</div> <!-- 報告書の一行分(複数可) -->
										<div class="report_a_line"><!-- 入力用 -->
											<div class="item-output">
												<div>
													<label id="Label71">入金日</label></div>
												<div style="text-align: right;">
													<pn:printWareki date="${md003_02Form.lblID_Date_Nyukin}" pattern='GYMD'/></div>
											</div>
											<div class="item-output">
												<div>
													<label id="Label72">受託者勘定処理年月</label></div>
											<div style="text-align: center;">
												<pn:printWareki date="${md003_02Form.lblID_Date_Jtkshori}" pattern='GYM'/></div>
											</div>
										</div> <!-- 入力用 -->
										<div class="item-output">
											<div>
												<label id="Label73">送金日</label></div>
											<div style="text-align: right;">
												<pn:printWareki date="${md003_02Form.lblID_Date_Sokin}" pattern='GYMD'/></div>
										</div>
										<div class="report_a_line">
											<div class="item-output">
												<div>
													<label id="Label74">送金日番号</label></div>
												<div style="text-align: center;">
													<parts:dlabel path="lblID_ID_Sokinbi" /></div>
											</div>
											<div class="item-output">
												<div>&nbsp;</div>
												<div><!-- 項目名 -->
													<span disabled="true">
														<parts:checkbox path="ckhAfter_Daibensai" id="ckhAfter_Daibensai" value = "1" style="text-align: right;" name="ckhAfter_Daibensai" disabled="true" />
													<label for="ckhAfter_Daibensai">代弁履行後の作成</label></span>
												</div>
											</div>
										</div>
									</div>
								</div> <!-- 報告書一枚終わり -->
							</div>
						</td>
					</parts:tr>
				</parts:table>
			</div><br />
		</div>
		</parts:form><%@ include file="/jsp/incFooter.jsp"%>
	</body>
</html>