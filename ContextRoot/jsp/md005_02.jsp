
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/jsp/incTop.jsp" %>
<%@ taglib prefix="pn" uri="http://partnernet.jfc.go.jp/tags/pn"%>

<%--================================================================================================
 * Project Name : パートナーネット開発
 * System Name  : パートナーネット
 * File Name    : md005_04.jsp
 *
 * <<Modification History>>
 * Version | Date       | Updated By            | Content
 * --------+------------+-----------------------+---------------------------------------------------
 * 1.0.0   | 2015/07/01 | 木村　しのぶ             | 新規作成
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
					executeAction('../../md005/md005_02/Md005_02Create.form');
				}
				<%-- 戻るボタン処理 --%>
				function click_backBtn() {
					executeAction('../../md005/md005_02/Md005_02Back.form');
				}

//-->
		</script>

		<link href="<%=request.getContextPath()%>/css/md005.css" type="text/css" rel="stylesheet" />
	</head>
	<body>
		<parts:form id="Form1" modelAttribute="md005_02Form" method="post">
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
					<!--  取消対象報告書が確定しました。<br /> -->
					<!-- 以下の報告書の登録を行います。内容をご確認のうえ「登録」ボタンを押してください。 -->
					取消・修正報告書のデータ登録を行います。「登録」ボタンを押してください。
				</div>
				<div class="greeting">
					<logic:notEqual path="processMode" value="5">
						<label id="lblBack_Normal">代位弁済金払込・充当報告書の取消・修正の入力画面へ戻る場合には「戻る」ボタンを<br>押してください。</label>
					</logic:notEqual>
					<logic:equal path="processMode" value="5">
						<label id="lblBack_DelCancel">取消・修正対象報告書一覧の画面へ戻る場合には「戻る」ボタンを押してください。</label>
					</logic:equal>
				</div>
				<div class="buttons">
					<div style="display:none;">
						<parts:button id="btnUpdate" />
						<parts:button id="btnBack" />
					</div>
					<parts:button id="btnUpdate2" value="登録"  onclick="click_createBtn();" />
					<!-- <parts:button id="btnBack2" value="戻る" title="代位弁済金払込・充当報告書の取消・修正の入力画面へ戻る" /> -->
				<logic:notEqual path="processMode" value="5">
					<parts:button id="btnBack2" value="戻る" title="代位弁済金払込・充当報告書の取消・修正の入力画面へ戻る" onclick="click_backBtn()"/>
				</logic:notEqual>
				<logic:equal path="processMode" value="5">
					<parts:button id="btnBack2" value="戻る" title="取消・修正対象報告書の一覧画面へ戻る" onclick="click_backBtn()"/>
				</logic:equal>
				</div><br>
				<div class="status">
	                <div class="status" style="color: red; font-weight: bold;">
	                    <parts:errors path="*" cssClass="Error" />
	                </div>
				</div>
				<label id="lblComment"><parts:dlabel path="lblComment"/></label>
				<div class="reportDate">報告年月日：
					<!-- <div class="Error"> -->
						<!-- <parts:dlabel path="lblID_Date_Report" /> -->
					<!-- </div> -->
				    <fmt:parseDate value="${md005_02Form.lblID_Date_Report}" var="lblID_Date_Report" pattern="yyyyMMdd" />
                    <fmt:formatDate value="${lblID_Date_Report}" pattern="yyyy年MM月dd日(E)"/>
				</div>
				<div style="padding-bottom: 15px;">
					<parts:table id="pnl" cssStyle="border-style:none;">
						<parts:tr id="pnl_Red" cssStyle="border-style:none;">
							<td>
								<div class="page-break"><br/></div>
								<div id="pnl_Red" style="padding-bottom: 15px;">
									<!-- 報告書一枚(borderで囲んである,複数可) -->
									<!-- 実装時はASP.NETのユーザコントロールよびだし -->
									<!-- ジャンプ用アンカー(名前) -->
									<parts:link id="" href="" ></parts:link>
									<div class="report">
										<div class="kousei-aka" align="center">
											<!-- <label id="lblID_Head_Red">取消内容</label>&nbsp; -->
											<!--  <label id="lblID_Head_Red2" style="color:red;">赤</label> -->
											<parts:dlabel path="lblID_Head_Red"/>
											<logic:equal path="lblID_Head_Red2"  value="Visible">
												<label id="lblID_Head_Red2" style="color:red;">赤</label>
											</logic:equal>
										</div> <!-- ジャンプ用アンカー(名前) -->
										<div align="center"><!-- 出力用 --> <!-- 報告書の一行分(複数可) -->
											<div class="report_a_line"><!-- 出力用 -->
												<div class="item-output">
													<div><!-- 項目名 -->
														<label id="Label17">顧客名</label></div>
													<div><!-- 値 -->
														<parts:dlabel path="lblID_Name_Customer_Red" /></div>
												</div> <!-- 出力用 -->
												<div class="item-output">
													<div><!-- 項目名 -->
														<label id="Label24">扱店名</label></div>
													<div><!-- 値 -->
														<parts:dlabel path="lblID_Name_Organization_Red" /></div>
												</div>
											</div> <!-- 報告書の一行分(複数可) -->
											<div class="report_a_line"><!-- 出力用 -->
												<div class="item-output">
													<div><!-- 項目名 -->
														<label id="Label26">公庫支店</label></div>
													<div><!-- 値 -->
														<parts:dlabel path="lblID_Code_KoukoShiten_Red" /></div>
												</div> <!-- 出力用 -->
												<div class="item-output">
													<div><!-- 項目名 -->
														<label id="Label28">扱店</label></div>
													<div><!-- 値 -->
														<parts:dlabel path="lblID_Code_Organization_Red" /></div>
												</div> <!-- 出力用 -->
												<div class="item-output">
													<div><!-- 項目名 -->
														<label id="Label30">店舗</label></div>
													<div><!-- 値 -->
														<parts:dlabel path="lblID_Code_Tenpo_Red" /></div>
												</div> <!-- 出力用 -->
												<div class="item-output">
													<div><!-- 項目名 -->
														<label id="Label32">年度</label></div>
													<div><!-- 値 -->
														<!-- <parts:dlabel path="lblID_Year_Red" /></div> -->
														<pn:printWareki date="${md005_02Form.lblID_Year_Red}" pattern='GY'/></div>
												</div> <!-- 出力用 -->
												<div class="item-output">
													<div><!-- 項目名 -->
														<label id="Label34">方式資金</label></div>
													<div><!-- 値 -->
														<parts:dlabel path="lblID_Kubun_HoshikiShikin_Red" /></div>
												</div> <!-- 出力用 -->
												<div class="item-output">
													<div><!-- 項目名 -->
														<label id="Label36">番号</label></div>
													<div><!-- 値 -->
														<parts:dlabel path="lblID_ID_Ringi_Red" /></div>
												</div> <!-- 出力用 -->
												<div class="item-output">
													<div><!-- 項目名 -->
														<label id="Label38">枝番</label></div>
													<div><!-- 値 -->
														<parts:dlabel path="lblID_ID_RingiBranch_Red" /></div>
												</div>
											</div> <!-- 報告書の一行分(複数可) -->
											<div class="report_a_line"><!-- 出力用 -->
												<div class="item-output">
													<div><!-- 項目名 -->
														<label id="Label40">充当対象払込期日</label></div>
													<div><!-- 値 -->
														<!-- <parts:dlabel path="lblID_Date_JutoTaisho_Red" /></div> -->
														<pn:printWareki date="${md005_02Form.lblID_Date_JutoTaisho_Red}" pattern='GYMD'/></div>
												</div> <!-- 出力用 -->
												<div class="item-output">
													<div><!-- 項目名 -->
														<label id="Label42">代弁金払込日</label></div>
													<div><!-- 値 -->
														<!-- <parts:dlabel path="lblID_Date_DaibenkinHaraikomi_Red" /></div> -->
														<pn:printWareki date="${md005_02Form.lblID_Date_DaibenkinHaraikomi_Red}" pattern='GYMD'/></div>
												</div> <!-- 出力用 -->
												<div class="item-output">
													<div><!-- 項目名 -->
														<label id="Label44">遅延損害金(円)</label></div>
													<div class="styleMoney"><!-- 値 -->
														<parts:dlabel path="lblID_M_ChienSongai_Red" /></div>
												</div> <!-- 出力用 -->
												<div class="item-output">
													<div><!-- 項目名 -->
														<label id="Label46">利息(円)</label></div>
													<div class="styleMoney"><!-- 値 -->
														<parts:dlabel path="lblID_M_Risoku_Red" /></div>
												</div>
											</div> <!-- 報告書の一行分(複数可) -->
											<div class="report_a_line"><!-- 出力用 -->
												<div class="item-output">
													<div><!-- 項目名 -->
														<label id="Label48">繰上償還手数料(円)</label></div>
													<div class="styleConfirmMoney"><!-- 値 -->
														<parts:dlabel path="lblID_M_KurishoCommission_Red" />&nbsp;</div>
												</div> <!-- 出力用 -->
												<div class="item-output">
													<div><!-- 項目名 -->
														<label id="Label50">元金(円)</label></div>
													<div class="styleMoney"><!-- 値 -->
														<parts:dlabel path="lblID_M_Gankin_Red" /></div>
												</div> <!-- 出力用 -->
												<div class="item-output">
													<div><!-- 項目名 -->
														<label id="Label52" style="white-space:nowrap;">仮受金(一般口)からの充当額(円)</label></div>
													<div class="styleConfirmMoney"><!-- 値 -->
														<parts:dlabel path="lblID_M_KariukeIppanJuto_Red" /></div>
												</div>
											</div> <!-- 報告書の一行分(複数可) -->
											<div class="report_a_line">
												<div class="item-output">
													<div><!-- 項目名 -->
														<label id="Label23">計(円)</label></div>
													<div class="styleMoney"><!-- 値 -->
														<parts:dlabel path="lblID_M_Kei_Red" /></div>
												</div> <!-- 出力用 -->
												<div class="item-output">
													<div><!-- 項目名 -->
														<label id="Label54">送金額(円)</label></div>
													<div class="styleMoney"><!-- 値 -->
														<parts:dlabel path="lblID_M_Sokin_Red" /></div>
												</div> <!-- 出力用 -->
												<div class="item-output">
													<div><!-- 項目名 -->
														<label id="Label56">代弁金充当後残元金(円)</label></div>
													<div class="styleConfirmMoney"><!-- 値 -->
														<parts:dlabel path="lblID_M_ZanGanAfterDaibenJuto_Red" /></div>
												</div>
											</div> <!-- 報告書の一行分(複数可) -->
											<div class="report_a_line"><!-- 出力用 -->
												<div class="item-output">
													<div><!-- 項目名 -->
														<label id="Label58">受託者勘定処理年月</label></div>
													<div><!-- 値 -->
														<!-- <parts:dlabel path="lblID_Date_Jtkshori_Red" /></div> -->
														<pn:printWareki date="${md005_02Form.lblID_Date_Jtkshori_Red}" pattern='GYM'/></div>
												</div> <!-- 出力用 -->
												<div class="item-output">
													<div><!-- 項目名 -->
														<label id="Label60">送金年月日</label></div>
													<div><!-- 値 -->
														<!-- <parts:dlabel path="lblID_Date_Sokin_Red" /></div> -->
														<pn:printWareki date="${md005_02Form.lblID_Date_Sokin_Red}" pattern='GYMD'/></div>
												</div> <!-- 出力用 -->
												<div class="item-output">
													<div><!-- 項目名 -->
														<label id="Label62">送金日番号</label></div>
													<div><!-- 値 -->
														<parts:dlabel path="lblID_ID_Sokinbi_Red" /></div>
												</div>
											</div>
											<div style="display: none;"><!-- 更正赤情報保持用（非表示・更新時に使用） -->
												<parts:dlabel path="lblID_Name_Customer" />
												<parts:dlabel path="lblID_Name_Organization" />
												<parts:dlabel path="lblID_Code_KoukoShiten" />
												<parts:dlabel path="lblID_Code_Organization" />
												<parts:dlabel path="lblID_Code_Tenpo" />
												<parts:dlabel path="lblID_Year" />
												<parts:dlabel path="lblID_Kubun_HoshikiShikin" />
												<parts:dlabel path="lblID_ID_Ringi" />
												<parts:dlabel path="lblID_ID_RingiBranch" />
												<parts:dlabel path="lblID_Date_JutoTaisho" />
												<parts:dlabel path="lblID_Date_DaibenkinHaraikomi" />
												<parts:dlabel path="lblID_M_ChienSongai" />
												<parts:dlabel path="lblID_M_Risoku" />
												<parts:dlabel path="lblID_M_KurishoCommission" />
												<parts:dlabel path="lblID_M_Gankin" />
												<parts:dlabel path="lblID_M_KariukeIppanJuto" />
												<parts:dlabel path="lblID_M_Kei" />
												<parts:dlabel path="lblID_M_Sokin" />
												<parts:dlabel path="lblID_M_ZanGanAfterDaibenJuto" />
												<parts:dlabel path="lblID_Date_Jtkshori" />
												<parts:dlabel path="lblID_Date_Sokin" />
												<parts:dlabel path="lblID_ID_Sokinbi" />
											</div>
										</div> <!-- 報告書一枚終わり -->
									</div>
								</div>
							</td>
						</parts:tr>
						<parts:tr id="pnl_Mod"  cssStyle="border-style:none;">
							<td>
								<div class="page-break"><br/></div>
								<div id="pnl_Mod">
									<div class="report"><!-- 報告書の一行分(複数可) -->
										<div class="shusei" align="center">
											<!-- <label id="lblID_Head">修正内容</label> -->
											<parts:dlabel path="lblID_Head"/>
										</div>
										<div align="center"><!-- 報告書の一行分(複数可) -->
											<div class="report_a_line"><!-- 出力用 -->
												<div class="item-output">
													<div><!-- 項目名 -->
														<label id="Label2">顧客名</label></div>
													<div><!-- 値 -->
														<parts:dlabel path="lblID_Name_Customer" /></div>
												</div> <!-- 出力用 -->
												<div class="item-output">
													<div><!-- 項目名 -->
														<label id="Label1">扱店名</label></div>
													<div><!-- 値 -->
														<parts:dlabel path="lblID_Name_Organization" /></div>
												</div>
											</div> <!-- 報告書の一行分(複数可) -->
											<div class="report_a_line"><!-- 出力用 -->
												<div class="item-output">
													<div><!-- 項目名 -->
														<label id="Label3">公庫支店</label></div>
													<div><!-- 値 -->
														<parts:dlabel path="lblID_Code_KoukoShiten" /></div>
												</div> <!-- 出力用 -->
												<div class="item-output">
													<div><!-- 項目名 -->
														<label id="Label4">扱店</label></div>
													<div><!-- 値 -->
														<parts:dlabel path="lblID_Code_Organization" /></div>
												</div> <!-- 出力用 -->
												<div class="item-output">
													<div><!-- 項目名 -->
														<label id="Label5">店舗</label></div>
													<div><!-- 値 -->
														<parts:dlabel path="lblID_Code_Tenpo" /></div>
												</div> <!-- 出力用 -->
												<div class="item-output">
													<div><!-- 項目名 -->
														<label id="Label6">年度</label></div>
													<div><!-- 値 -->
														<!-- <parts:dlabel path="lblID_Year" /></div> -->
														<pn:printWareki date="${md005_02Form.lblID_Year}" pattern='GY'/></div>
												</div> <!-- 出力用 -->
												<div class="item-output">
													<div><!-- 項目名 -->
														<label id="Label7">方式資金</label></div>
													<div><!-- 値 -->
														<parts:dlabel path="lblID_Kubun_HoshikiShikin" /></div>
												</div> <!-- 出力用 -->
												<div class="item-output">
													<div><!-- 項目名 -->
														<label id="Label8">番号</label></div>
													<div><!-- 値 -->
														<parts:dlabel path="lblID_ID_Ringi" /></div>
												</div> <!-- 出力用 -->
												<div class="item-output">
													<div><!-- 項目名 -->
														<label id="Label9">枝番</label></div>
													<div><!-- 値 -->
														<parts:dlabel path="lblID_ID_RingiBranch" /></div>
												</div>
											</div> <!-- 報告書の一行分(複数可) -->
											<div class="report_a_line"><!-- 出力用 -->
												<div class="item-output">
													<div><!-- 項目名 -->
														<label id="Label10">充当対象払込期日</label></div>
													<div><!-- 値 -->
														<!-- <parts:dlabel path="lblID_Date_JutoTaisho" /></div> -->
														<pn:printWareki date="${md005_02Form.lblID_Date_JutoTaisho}" pattern='GYMD'/></div>
												</div> <!-- 出力用 -->
												<div class="item-output">
													<div><!-- 項目名 -->
														<label id="Label11">代弁金払込日</label></div>
													<div><!-- 値 -->
														<!-- <parts:dlabel path="lblID_Date_DaibenkinHaraikomi" /></div> -->
														<pn:printWareki date="${md005_02Form.lblID_Date_DaibenkinHaraikomi}" pattern='GYMD'/></div>
												</div> <!-- 出力用 -->
												<div class="item-output">
													<div><!-- 項目名 -->
														<label id="Label12">遅延損害金(円)</label></div>
													<div class="styleMoney"><!-- 値 -->
														<parts:dlabel path="lblID_M_ChienSongai" /></div>
												</div> <!-- 出力用 -->
												<div class="item-output">
													<div><!-- 項目名 -->
														<label id="Label13">利息(円)</label></div>
													<div class="styleMoney"><!-- 値 -->
														<parts:dlabel path="lblID_M_Risoku" /></div>
												</div>
											</div> <!-- 報告書の一行分(複数可) -->
											<div class="report_a_line"><!-- 出力用 -->
												<div class="item-output">
													<div><!-- 項目名 -->
														<label id="Label14">繰上償還手数料(円)</label></div>
													<div class="styleConfirmMoney"><!-- 値 -->
														<parts:dlabel path="lblID_M_KurishoCommission" />&nbsp;</div>
												</div> <!-- 出力用 -->
												<div class="item-output">
													<div><!-- 項目名 -->
														<label id="Label15">元金(円)</label></div>
													<div class="styleMoney"><!-- 値 -->
														<parts:dlabel path="lblID_M_Gankin" /></div>
												</div> <!-- 出力用 -->
												<div class="item-output">
													<div><!-- 項目名 -->
														<label id="Label16"  style="white-space:nowrap;">仮受金(一般口)からの充当額(円)</label></div>
													<div class="styleConfirmMoney"><!-- 値 -->
														<parts:dlabel path="lblID_M_KariukeIppanJuto" /></div>
												</div>
											</div> <!-- 報告書の一行分(複数可) -->
											<div class="report_a_line">
												<div class="item-output">
													<div><!-- 項目名 -->
														<label id="Label25">計(円)</label></div>
													<div class="styleMoney"><!-- 値 -->
														<parts:dlabel path="lblID_M_Kei" /></div>
												</div> <!-- 出力用 -->
												<div class="item-output">
													<div><!-- 項目名 -->
														<label id="Label18">送金額(円)</label></div>
													<div class="styleMoney"><!-- 値 -->
														<parts:dlabel path="lblID_M_Sokin" /></div>
												</div> <!-- 出力用 -->
												<div class="item-output">
													<div><!-- 項目名 -->
														<label id="Label19">代弁金充当後残元金(円)</label></div>
													<div class="styleConfirmMoney"><!-- 値 -->
														<parts:dlabel path="lblID_M_ZanGanAfterDaibenJuto" /></div>
												</div>
											</div> <!-- 報告書の一行分(複数可) -->
											<div class="report_a_line"><!-- 出力用 -->
												<div class="item-output">
													<div><!-- 項目名 -->
														<label id="Label20">受託者勘定処理年月</label></div>
													<div><!-- 値 -->
														<!-- <parts:dlabel path="lblID_Date_Jtkshori" /></div> -->
														<pn:printWareki date="${md005_02Form.lblID_Date_Jtkshori}" pattern='GYM'/></div>
												</div> <!-- 出力用 -->
												<div class="item-output">
													<div><!-- 項目名 -->
														<label id="Label21">送金年月日</label></div>
													<div><!-- 値 -->
														<!-- <parts:dlabel path="lblID_Date_Sokin" /></div> -->
														<pn:printWareki date="${md005_02Form.lblID_Date_Sokin}" pattern='GYMD'/></div>
												</div> <!-- 出力用 -->
												<div class="item-output">
													<div><!-- 項目名 -->
														<label id="Label22">送金日番号</label></div>
													<div><!-- 値 -->
														<parts:dlabel path="lblID_ID_Sokinbi" /></div>
												</div>
											</div>
										</div>
									</div> <!-- 報告書一枚終わり -->
									<div style="display: none;"><!-- 更正赤情報保持用（非表示・更新時に使用） -->
										<parts:dlabel path="lblID_Name_Customer_Red" />
										<parts:dlabel path="lblID_Name_Organization_Red" />
										<parts:dlabel path="lblID_Code_KoukoShiten_Red" />
										<parts:dlabel path="lblID_Code_Organization_Red" />
										<parts:dlabel path="lblID_Code_Tenpo_Red" />
										<parts:dlabel path="lblID_Year_Red" />
										<parts:dlabel path="lblID_Kubun_HoshikiShikin_Red" />
										<parts:dlabel path="lblID_ID_Ringi_Red" />
										<parts:dlabel path="lblID_ID_RingiBranch_Red" />
										<parts:dlabel path="lblID_Date_JutoTaisho_Red" />
										<parts:dlabel path="lblID_Date_DaibenkinHaraikomi_Red" />
										<parts:dlabel path="lblID_M_ChienSongai_Red" />
										<parts:dlabel path="lblID_M_Risoku_Red" />
										<parts:dlabel path="lblID_M_KurishoCommission_Red" />
										<parts:dlabel path="lblID_M_Gankin_Red" />
										<parts:dlabel path="lblID_M_KariukeIppanJuto_Red" />
										<parts:dlabel path="lblID_M_Kei_Red" />
										<parts:dlabel path="lblID_M_Sokin_Red" />
										<parts:dlabel path="lblID_M_ZanGanAfterDaibenJuto_Red" />
										<parts:dlabel path="lblID_Date_Jtkshori_Red" />
										<parts:dlabel path="lblID_Date_Sokin_Red" />
										<parts:dlabel path="lblID_ID_Sokinbi_Red" />
									</div>
								</div>
							</td>
						</parts:tr>
						<parts:tr>
							<td >
								<div style="display: none;">
									<parts:dlabel path="lblMessage" />
									<parts:dlabel path="txtID_Name_Customer_Red" />
									<parts:dlabel path="txtID_Name_Organization_Red" />
									<parts:dlabel path="txtID_Code_KoukoShiten_Red" />
									<parts:dlabel path="txtID_Code_Organization_Red" />
									<parts:dlabel path="txtID_Code_Tenpo_Red" />
									<parts:dlabel path="txtID_Year_Red" />
									<parts:dlabel path="txtID_Code_HoshikiShikin_Red" />
									<parts:dlabel path="txtID_ID_Ringi_Red" />
									<parts:dlabel path="txtID_ID_RingiBranch_Red" />
									<parts:dlabel path="txtID_Date_JutoTaisho_Red" />
									<parts:dlabel path="txtID_Date_DaibenkinHaraikomi_Red" />
									<parts:dlabel path="txtID_M_ChienSongai_Red" />
									<parts:dlabel path="txtID_M_Risoku_Red" />
									<parts:dlabel path="txtID_M_KurishoCommission_Red" />
									<parts:dlabel path="txtID_M_Gankin_Red" />
									<parts:dlabel path="txtID_M_KariukeIppanJuto_Red" />
									<parts:dlabel path="txtID_M_Kei_Red" />
									<parts:dlabel path="txtID_M_Sokin_Red" />
									<parts:dlabel path="txtID_M_ZanGanAfterDaibenJuto_Red" />
									<parts:dlabel path="txtID_Date_Jtkshori_Red" />
									<parts:dlabel path="txtID_Date_Sokin_Red" />
									<parts:dlabel path="txtID_ID_Sokinbi_Red" />
									<parts:dlabel path="drpID_Date_JtkshoriGengou_Red" />
									<parts:dlabel path="txtID_Date_JtkshoriYear_Red" />
									<parts:dlabel path="drpID_Date_JtkshoriMonth_Red" />
									<parts:dlabel path="txtID_Name_Customer" />
									<parts:dlabel path="txtID_Name_Organization" />
									<parts:dlabel path="txtID_Code_KoukoShiten" />
									<parts:dlabel path="txtID_Code_Organization" />
									<parts:dlabel path="txtID_Code_Tenpo" />
									<parts:dlabel path="txtID_Year" />
									<parts:dlabel path="txtID_Code_HoshikiShikin" />
									<parts:dlabel path="txtID_ID_Ringi" />
									<parts:dlabel path="txtID_ID_RingiBranch" />
									<parts:dlabel path="drpID_Date_JutoTaishoGengou" />
									<parts:dlabel path="txtID_Date_JutoTaishoYear" />
									<parts:dlabel path="drpID_Date_JutoTaishoMonth" />
									<parts:dlabel path="drpID_Date_JutoTaishoDay" />
									<parts:dlabel path="drpID_Date_DaibenkinHaraikomiGengou" />
									<parts:dlabel path="txtID_Date_DaibenkinHaraikomiYear" />
									<parts:dlabel path="drpID_Date_DaibenkinHaraikomiMonth" />
									<parts:dlabel path="drpID_Date_DaibenkinHaraikomiDay" />
									<parts:dlabel path="txtID_M_ChienSongai" />
									<parts:dlabel path="txtID_M_Risoku" />
									<parts:dlabel path="txtID_M_KurishoCommission" />
									<parts:dlabel path="txtID_M_Gankin" />
									<parts:dlabel path="txtID_M_KariukeIppanJuto" />
									<parts:dlabel path="txtID_M_Kei" />
									<parts:dlabel path="txtID_M_Sokin" />
									<parts:dlabel path="txtID_M_ZanGanAfterDaibenJuto" />
									<parts:dlabel path="txtID_Date_Jtkshori" />
									<parts:dlabel path="drpID_Date_SokinGengou" />
									<parts:dlabel path="txtID_Date_SokinYear" />
									<parts:dlabel path="drpID_Date_SokinMonth" />
									<parts:dlabel path="drpID_Date_SokinDay" />
									<parts:dlabel path="txtID_ID_Sokinbi" />
									<parts:dlabel path="drpID_Date_JtkshoriGengou" />
									<parts:dlabel path="txtID_Date_JtkshoriYear" />
									<parts:dlabel path="drpID_Date_JtkshoriMonth" />
									<parts:dlabel path="ID_ID_Report" />
									<parts:dlabel path="ID_Date_Report" />
									<parts:dlabel path="ID_Name_Organization" />
									<parts:dlabel path="ID_Name_Customer" />
									<parts:dlabel path="ID_Code_KoukoShiten" />
									<parts:dlabel path="ID_Code_Organization" />
									<parts:dlabel path="ID_Code_Tenpo" />
									<parts:dlabel path="ID_Year" />
									<parts:dlabel path="ID_Code_HoshikiShikin" />
									<parts:dlabel path="ID_ID_Ringi" />
									<parts:dlabel path="ID_ID_RingiBranch" />
									<parts:dlabel path="ID_Date_JutoTaisho" />
									<parts:dlabel path="ID_Date_JutoTaishoGengou" />
									<parts:dlabel path="ID_Date_JutoTaishoYear" />
									<parts:dlabel path="ID_Date_JutoTaishoMonth" />
									<parts:dlabel path="ID_Date_JutoTaishoYear_Input" />
									<parts:dlabel path="ID_Date_JutoTaishoDay" />
									<parts:dlabel path="ID_Date_DaibenkinHaraikomi" />
									<parts:dlabel path="ID_Date_DaibenkinHaraikomiGengou" />
									<parts:dlabel path="ID_Date_DaibenkinHaraikomiYear_Input" />
									<parts:dlabel path="ID_Date_DaibenkinHaraikomiYear" />
									<parts:dlabel path="ID_Date_DaibenkinHaraikomiMonth" />
									<parts:dlabel path="ID_Date_DaibenkinHaraikomiDay" />
									<parts:dlabel path="ID_M_ChienSongai" />
									<parts:dlabel path="ID_M_Risoku" />
									<parts:dlabel path="ID_M_Gankin" />
									<parts:dlabel path="ID_M_Kei" />
									<parts:dlabel path="ID_M_KariukeIppanJuto" />
									<parts:dlabel path="ID_M_ZanGanAfterDaibenJuto" />
									<parts:dlabel path="ID_M_KurishoCommission" />
									<parts:dlabel path="ID_M_Sokin" />
									<parts:dlabel path="ID_Date_Sokin" />
									<parts:dlabel path="ID_Date_SokinGengou" />
									<parts:dlabel path="ID_Date_SokinYear" />
									<parts:dlabel path="ID_Date_SokinYear_Input" />
									<parts:dlabel path="ID_Date_SokinMonth" />
									<parts:dlabel path="ID_Date_SokinDay" />
									<parts:dlabel path="ID_ID_Sokinbi" />
									<parts:dlabel path="ID_Date_Jtkshori" />
									<parts:dlabel path="ID_Date_JtkshoriYear_Input" />
									<parts:dlabel path="ID_Date_JtkshoriGengou" />
									<parts:dlabel path="ID_Date_JtkshoriYear" />
									<parts:dlabel path="ID_Date_JtkshoriMonth" />
									<parts:dlabel path="ID_M_KashitsukeZandaka" />
									<parts:dlabel path="ID_InputHead" />
									<parts:dlabel path="ID_ID_Credit" />
									<parts:dlabel path="ID_M_SeiKuriRisoku" />
									<parts:dlabel path="ID_M_SeiKuriGankin" />
									<parts:dlabel path="ID_Seikyu_M_SeiKuriRisoku" />
									<parts:dlabel path="ID_Seikyu_M_SeiKuriGankin" />
									<parts:dlabel path="ID_M_YakujoRisoku" />
									<parts:dlabel path="ID_M_YakujoGankin" />
									<parts:dlabel path="ID_Keep_M_KashitsukeZan" />
									<parts:dlabel path="ID_Keep_M_YakujoGankin" />
									<parts:dlabel path="ID_Keep_M_YakujoRisoku" />
									<parts:dlabel path="ID_Keep_Seikyu_M_SeiKuriRisoku" />
									<parts:dlabel path="ID_Keep_Seikyu_M_SeiKuriGankin" />
									<parts:dlabel path="ID_Flag_Torikeshizumi" />
									<parts:dlabel path="ID_Keep_Date_ShokanKigen" />
									<parts:dlabel path="ID_Time_Report" />
									<parts:dlabel path="ID_ID_Master" />
									<parts:dlabel path="ID_SignData" />
									<parts:dlabel path="ID_Ins_ID_Credit" />
									<parts:dlabel path="ID_M_KashitsukeZandaka_aRingi" />
									<parts:dlabel path="ID_Date_ShokanKigen_aRingi" />
									<parts:dlabel path="ID_M_YakujoRisoku_Seikyu" />
									<parts:dlabel path="ID_M_YakujoGankin_Yakujo" />
									<parts:dlabel path="ID_ID_History" />
									<parts:dlabel path="ID_Status" />
									<parts:dlabel path="ID_Type_Process" />
									<parts:dlabel path="ID_DataCode" />
									<parts:dlabel path="ID_Data_LastUpDate" />
									<parts:dlabel path="ID_User_ID" />
									<parts:dlabel path="ID_ID_Denso" />
									<parts:dlabel path="ID_Code_Error" />
									<parts:dlabel path="ID_ErrorMessage" />
									<parts:dlabel path="ID_Code_Customer" />
									<parts:dlabel path="ID_Kubun_Hoshiki" />
									<parts:dlabel path="ID_Kubun_Shikin" />
									<parts:dlabel path="ID_Date_ShokanKigen" />
									<parts:dlabel path="ID_Keep_ID_History" />
									<parts:dlabel path="ID_Keep_Flag_Kj" />
									<parts:dlabel path="ID_aRingi_Flag_Kj" />
									<parts:dlabel path="ID_aRingi_Date_ShokanKigen" />
									<parts:dlabel path="processMode" />
								</div>
							</td>
						</parts:tr>
					</parts:table>
				</div>
			</div>
		</div>
		</parts:form>
		<%@ include file="/jsp/incFooter.jsp"%>
	</body>
</html>