<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/jsp/incTop.jsp"%>

<%--================================================================================================
 * Project Name : パートナーネット開発
 * System Name  : パートナーネット
 * File Name    : md001_01.jsp
 *
 * <<Modification History>>
 * Version | Date        | Updated By           | Content
 * --------+-------------+----------------------+---------------------------------------------------
 * 1.0.0   | 2015/07/01 | 木村　しのぶ         | 新規作成
================================================================================================--%>
<%@ taglib prefix="pn" uri="http://partnernet.jfc.go.jp/tags/pn"%>

<html>
<%@ include file="/jsp/incHeader.jsp"%>
<head>
		<title><parts:message code="title.screenName"/></title>


<script lang="JavaScript">

<%--
			- 送信ボタン押下時の処理
			--%>
	function click_sendBtn() {
		executeAction('../../md001/md001_01/Md001_01Send.form');
	}
<%-- 戻るボタン処理 --%>
	function click_backBtn() {
		executeAction('../../md000/md000_02/Md000_02Return.form');
	}
//-->
</script>

<link href="<%=request.getContextPath()%>/css/Jikko_Mod.css"
	rel="stylesheet" />
<script language="JavaScript"
	src="<%=request.getContextPath()%>/js/ptncommon.js"
	type="text/javascript"></script>
</head>
<body onload="initTextFormat()">
	<parts:form modelAttribute="md001_01Form" action="./Md001_01Init.form"
		id="Form1" method="post" onsubmit="return false;">
		<%@ include file="/jsp/incCommonHidden.jsp"%>
		<%@ include file="/jsp/incHeaderArea.jsp"%>
		<div id="main_scroll_area">
		<div class="header">
			<div class="title">
				<span class="Title" id="lblTitle"><parts:message code="title.screenName"/></span>
			</div>
		</div>
		<!-- 2005/03/28 add start ヘルプリンク追加 -->
		<div class="help">
			<a href="#" onclick="openNewWindow('<%= request.getContextPath() %>/help/main_md001.html', false, false, false, 'width=800', 'height=500', false)">
				<font class="help">ヘルプ</font>
			</a>
		</div>
		<!-- 2005/03/28 add end -->
		<!-- 貸付実行画面のフォーマット貼り付け -->
		<div class="main">
			<div class="greeting">
				<label id="lblDataMsg">取消対象報告書を用意しました。変更があれば下欄「受託者勘定処理年月」を入力し、「送信」ボタンを押してください。</label>
			</div>
			<div class="greeting">取消・修正対象報告書の一覧画面に戻る場合には「戻る」ボタンを押してください。</div>
			<div class="greeting" style="white-space:nowrap">
				<label id="lblDataMsg2">なお、「利率」については、貸付実行日をもとに自動計算するため入力の必要はありません。<br></label>
				<label id="lblDataMsg2">自動計算の利率を採用しない場合のみ入力してください。</label>
			</div>
			<!-- 操作ボタン -->
			<div class="buttons">
				<div style="display: none;">
					<parts:button id="btnUpdate" />
					<parts:button id="btnBack" title="取消・修正対象報告書の一覧画面へ戻る" />
				</div>
				<parts:button id="btnUpdate2" value="送信"
					onclick="clearTextFormat();click_sendBtn();" />
				<parts:button id="btnBack2" value="戻る" title="取消・修正対象報告書の一覧画面へ戻る"
					onclick="clearTextFormat();click_backBtn();" />
				<br />
			</div>
			<!-- -------------------- -->
			<!-- status               -->
			<!-- -------------------- -->
			<div class="reportDate">
				報告年月日：
				<!--		<parts:dlabel path="txtID_Date_Report" /> -->
				<fmt:parseDate value="${md001_01Form.txtID_Date_Report}"
					var="txtID_Date_Report" pattern="yyyyMMdd" />
				<fmt:formatDate value="${txtID_Date_Report}"
					pattern="yyyy年MM月dd日(E)" />
			</div>
			<!--
			ステータスはエラーメッセージを出す際に
			エラー発生報告書へのジャンプ用アンカー(リンク)を埋め込む
			-->
			<div class="status">
				ステータス：<br />
				<div class="status" style="color: red; font-weight: bold;">
					<parts:errors path="*" cssClass="Error" />
				</div>
			</div>
			<parts:table id="pnl" cssStyle="border-style:none;">
				<parts:tr id="pnl_Red" cssStyle="border-style:none;">
					<td>
						<div class="page-break"><br/></div>
						<div id="pnl_Red" style="margin-bottom: 15px;">
							<div class="report" style="height:306px;">
								<!-- 報告書の一行分(複数可) -->
								<parts:link id="" href=""></parts:link>
								<div class="kousei-aka" align="center">
									<parts:dlabel path="lblID_Head_Red"/>
									<logic:equal path="lblID_Head_Red2"  value="Visible">
										<label id="lblID_Head_Red2" style="color:red;">赤</label>
									</logic:equal>
								</div>
								 <!-- ジャンプ用アンカー(名前) -->
								<!--DIV class="reportDate">報告年月日：yyyy年 mm月 dd日</DIV -->
								<!-- ジャンプ用アンカー(名前) -->
								<div align="center">
									<div class="report_a_line">
										<!-- 出力用 -->
										<div class="item-output">
											<div>
												<!-- 項目名 -->
												顧客名
											</div>
											<div>
												<!-- 値 -->
												<parts:text path="txtID_Name_Customer_Red"
													id="txtID_Name_Customer_Red" style="text-align:left;"
													maxlength="40" size="50" tabindex="-1" readonly="true" />
											</div>
										</div>
										<!-- 出力用 -->
										<div class="item-output">
											<div>
												<!-- 項目名 -->
												扱店名
											</div>
											<div>
												<!-- 値 -->
												<parts:text path="txtID_Name_Organization_Red"
													id="txtID_Name_Organization_Red" style="text-align:left;"
													maxlength="40" size="50" tabindex="-1" readonly="true" />
											</div>
										</div>
									</div>
									<!-- 報告書の一行分(複数可) -->
									<div class="report_a_line">
										<!-- 出力用 -->
										<div class="item-output">
											<div>
												<!-- 項目名 -->
												公庫支店
											</div>
											<div>
												<!-- 値 -->
												<parts:text path="txtID_Code_KoukoShiten_Red"
													id="txtID_Code_KoukoShiten_Red" style="text-align:center;"
													maxlength="2" size="2" tabindex="-1" readonly="true" />
											</div>
										</div>
										<!-- 出力用 -->
										<div class="item-output">
											<div>
												<!-- 項目名 -->
												扱店
											</div>
											<div>
												<!-- 値 -->
												<parts:text path="txtID_Code_Organization_Red"
													id="txtID_Code_Organization_Red" style="text-align:center;"
													maxlength="4" size="4" tabindex="-1" readonly="true" />
											</div>
										</div>
										<!-- 出力用 -->
										<div class="item-output">
											<div>
												<!-- 項目名 -->
												店舗
											</div>
											<div>
												<!-- 値 -->
												<parts:text path="txtID_Code_Tenpo_Red"
													id="txtID_Code_Tenpo_Red" style="text-align:center;"
													maxlength="3" size="3" tabindex="-1" readonly="true" />
											</div>
										</div>
										<!-- 出力用 -->
										<div class="item-output">
											<div>
												<!-- 項目名 -->
												年度
											</div>
											<div>
												<!-- 値 -->
												<input type="text" class="protect"
													style="text-align: center;" maxlength="4" size="4"
													tabindex="-1" readonly
													value="<pn:printWareki date='${md001_01Form.txtID_Year_Red}' pattern='GY'/>" />
											</div>
										</div>
										<!-- 出力用 -->
										<div class="item-output">
											<div>
												<!-- 項目名 -->
												方式資金
											</div>
											<div>
												<!-- 値 -->
												<parts:text path="txtID_Code_HoshikiShikin_Red"
													id="txtID_Code_HoshikiShikin_Red"
													style="text-align:center;" maxlength="2" size="2"
													tabindex="-1" readonly="true" />
											</div>
										</div>
										<!-- 出力用 -->
										<div class="item-output">
											<div>
												<!-- 項目名 -->
												番号
											</div>
											<div>
												<!-- 値 -->
												<parts:text path="txtID_ID_Ringi_Red"
													id="txtID_ID_Ringi_Red" style="text-align:center;"
													maxlength="5" size="5" tabindex="-1" readonly="true" />
											</div>
										</div>
										<!-- 出力用 -->
										<div class="item-output">
											<div>
												<!-- 項目名 -->
												枝番
											</div>
											<div>
												<!-- 値 -->
												<parts:text path="txtID_ID_RingiBranch_Red"
													id="txtID_ID_RingiBranch_Red" style="text-align:center;"
													maxlength="3" size="3" tabindex="-1" readonly="true" />
											</div>
										</div>
										<!-- 出力用 -->
										<div class="item-output">
											<div>
												<!-- 項目名 -->
												資金使途
											</div>
											<div>
												<!-- 値 -->
												<parts:text path="txtID_Code_ShikinShito_Red"
													id="txtID_Code_ShikinShito_Red" style="text-align:center;"
													maxlength="4" size="4" tabindex="-1" readonly="true" />
											</div>
										</div>
										<!-- 出力用 -->
										<div class="item-output">
											<div>
												<!-- 項目名 -->
												事業別
											</div>
											<div>
												<!-- 値 -->
												<parts:text path="txtID_Code_Jigyobetsu_Red"
													id="txtID_Code_Jigyobetsu_Red" style="text-align:center;"
													maxlength="2" size="2" tabindex="-1" readonly="true" />
											</div>
										</div>
									</div>
									<!-- 報告書の一行分(複数可) -->
									<div class="report_a_line">
										<!-- 出力用 -->
										<div class="item-output">
											<div>
												<!-- 項目名 -->
												利率(%)
											</div>
											<div>
												<!-- 値 -->
												<parts:text path="txtID_Riritsu_Red" id="txtID_Riritsu_Red"
													style="text-align:center;" maxlength="5" size="6"
													tabindex="-1" readonly="true" />
											</div>
										</div>
										<!-- 出力用 -->
										<div class="item-output">
											<div>
												<!-- 項目名 -->
												特利区分
											</div>
											<div>
												<!-- 値 -->
												<parts:text path="txtID_Kubun_Tokuri_Red"
													id="txtID_Kubun_Tokuri_Red" style="text-align:center;"
													maxlength="1" size="1" tabindex="-1" readonly="true" />
											</div>
										</div>
										<!-- 出力用 -->
										<div class="item-output">
											<div>
												<!-- 項目名 -->
												特利(%)
											</div>
											<div>
												<!-- 値 -->
												<parts:text path="txtID_Tokuri_Red" id="txtID_Tokuri_Red"
													style="text-align:center;" maxlength="5" size="6"
													tabindex="-1" readonly="true" />
											</div>
										</div>
										<!-- 出力用 -->
										<div class="item-output">
											<div>
												<!-- 項目名 -->
												据置期限
											</div>
											<div>
												<!-- 値 -->
												<input type="text" class="protect"
													style="text-align: center;" maxlength="6" size="6"
													tabindex="-1" readonly
													value="<pn:printWareki date='${md001_01Form.txtID_Date_SueokiKigen_Red}' pattern='GYM'/>" />
											</div>
										</div>
										<!-- 出力用 -->
										<div class="item-output">
											<div>
												<!-- 項目名 -->
												償還期限
											</div>
											<div>
												<!-- 値 -->
												<input type="text" class="protect"
													style="text-align: center;" maxlength="6" size="6"
													tabindex="-1" readonly
													value="<pn:printWareki date='${md001_01Form.txtID_Date_ShokanKigen_Red}' pattern='GYM'/>" />
											</div>
										</div>
										<!-- 出力用 -->
										<div class="item-output">
											<!-- 出力用 -->
											<div>受託者勘定処理年月</div>
											<div>
												<input type="text" class="protect"
													style="text-align: center;" maxlength="6" size="6"
													tabindex="-1" readonly
													value="<pn:printWareki date='${md001_01Form.txtID_Date_Jtkshori_Red}' pattern='GYM'/>" />
											</div>
										</div>
										<div class="item-output">
											<!-- 出力用 -->
											<div>
												<!-- 項目名 -->
												元利金払込日
											</div>
											<div>
												<!-- 値 -->
												<parts:text path="txtID_Date_GanrikinHaraikomi_Red"
													id="txtID_Date_GanrikinHaraikomi_Red"
													style="text-align:center;" maxlength="5" size="5"
													tabindex="-1" readonly="true" />
											</div>
										</div>
									</div>
									<div class="report_a_line">
										<!-- 出力用 -->
										<div class="item-output">
											<div>貸付実行日</div>
											<div>
												<input type="text" class="protect"
													style="text-align: center;" maxlength="9" size="10"
													tabindex="-1" readonly
													value="<pn:printWareki date='${md001_01Form.txtID_Date_Kashitsukejikko_Red}' pattern='GYMD'/>" />
											</div>
										</div>
									</div>
									<!-- 出力用 -->
									<div class="item-output">
										<div>
											<!-- 項目名 -->
											貸付実行金額(円)
										</div>
										<div>
											<!-- 値 -->
											<parts:text path="txtID_M_Kashitsuke_Red"
												id="txtID_M_Kashitsuke_Red" style="text-align: right;"
												maxlength="11" size="15" tabindex="-1" cssClass="format-number" readonly="true" />
										</div>
									</div>
									<!-- 出力用 -->
									<div class="item-output">
										<div>資金交付額(円)</div>
										<div>
											<parts:text path="txtID_M_ShikinKofu_Red"
												id="txtID_M_ShikinKofu_Red" style="text-align: right;"
												maxlength="11" size="15" tabindex="-1" cssClass="format-number" readonly="true" />
										</div>
									</div>
									<!-- 出力用 -->
									<div class="item-output">
										<div>
											<!-- 項目名 -->
											貸付受入金受入額(円)
										</div>
										<div>
											<!-- 値 -->
											<parts:text path="txtID_M_KashitukeUkeire_Red"
												id="txtID_M_KashitukeUkeire_Red" style="text-align: right;"
												maxlength="11" size="15" tabindex="-1" cssClass="format-number" readonly="true" />
										</div>
									</div>
									<div class="report_a_line">
										<!-- 入力用 -->
										<div class="item-input">
											<div>受託者勘定処理年月</div>
											<div>
												<parts:select path="ID_Date_Jtkshori_Gengo_Red"
													id="ID_Date_Jtkshori_Gengo_Red" style="color:#003399;">
													<parts:codeListOption categoryCode="00002" />
												</parts:select>
												<parts:text path="ID_Date_Jtkshori_Nen_Red"
													id="ID_Date_Jtkshori_Nen_Red"
													style="width:30px;text-align: center;" maxlength="2"
													size="2" />
												<label id="lblDateJtkshoriNen_Red">年</label>
												<parts:select path="drpID_Date_JtkshoriTsuki_Red"
													id="drpID_Date_JtkshoriTsuki_Red" style="color:#003399;">
													<parts:codeListOption categoryCode="00003" />
												</parts:select>
												<label id="lblDateJtkshoriTsuki_Red">月</label>
											</div>
										</div>
									</div>
									<!-- 報告書一枚終わり -->
								</div>
								<div style="display: none;"><!-- 更正赤情報保持用（非表示・更新時に使用） -->
									<parts:dlabel path="txtID_Name_Customer" />
									<parts:dlabel path="txtID_Name_Organization" />
									<parts:dlabel path="txtID_Code_KoukoShiten" />
									<parts:dlabel path="txtID_Code_Organization" />
									<parts:dlabel path="txtID_Code_Tenpo" />
									<parts:dlabel path="txtID_Year" />
									<parts:dlabel path="txtID_Code_HoshikiShikin" />
									<parts:dlabel path="txtID_ID_Ringi" />
									<parts:dlabel path="txtID_ID_RingiBranch" />
									<parts:dlabel path="txtID_Code_ShikinShito" />
									<parts:dlabel path="txtID_Code_Jigyobetsu" />
									<parts:dlabel path="txtID_Riritsu" />
									<parts:dlabel path="txtID_Kubun_Tokuri" />
									<parts:dlabel path="txtID_Tokuri" />
									<parts:dlabel path="txtID_Date_SueokiKigen" />
									<parts:dlabel path="txtID_Date_ShokanKigen" />
									<parts:dlabel path="txtID_Date_Jtkshori" />
									<parts:dlabel path="txtID_Date_GanrikinHaraikomi" />
									<parts:dlabel path="ID_Date_Kashitsukejikko_Gengo" />
									<parts:dlabel path="ID_Date_Kashitsukejikko_Nen" />
									<parts:dlabel path="drpID_Date_KashitsukejikkoTsuki" />
									<parts:dlabel path="drpID_Date_KashitsukejikkoBi" />
									<parts:dlabel path="txtID_M_Kashitsuke" />
									<parts:dlabel path="txtID_M_ShikinKofu" />
									<parts:dlabel path="txtID_M_KashitukeUkeire" />
									<parts:dlabel path="ID_Date_Jtkshori_Gengo" />
									<parts:dlabel path="ID_Date_Jtkshori_Nen" />
									<parts:dlabel path="drpID_Date_JtkshoriTsuki" />
								</div>
							</div>
						</div>
					</td>
				</parts:tr>

				<parts:tr id="pnl_Mod" cssStyle="border-style:none;">
					<td>
						<div class="page-break"><br/></div>
						<div id="pnl_Mod">
							<div class="report" style="height:306px;">
								<!-- 報告書の一行分(複数可) -->
								<parts:link id="" href=""></parts:link>
								<div class="shusei" align="center">
									<label id="lblID_Head"><parts:dlabel path="lblID_Head"/></label>
								</div>
								<!--DIV class="reportDate">報告年月日：yyyy年 mm月 dd日</DIV -->
								<div align="center">
									<div class="report_a_line">
										<!-- 出力用 -->
										<div class="item-output">
											<div>
												<!-- 項目名 -->
												顧客名
											</div>
											<div>
												<!-- 値 -->
												<parts:text path="txtID_Name_Customer"
													id="txtID_Name_Customer" style="text-align:left;"
													maxlength="40" size="50" tabindex="-1" readonly="true" />
											</div>
										</div>
										<!-- 出力用 -->
										<div class="item-output">
											<div>
												<!-- 項目名 -->
												扱店名
											</div>
											<div>
												<!-- 値 -->
												<parts:text path="txtID_Name_Organization"
													id="txtID_Name_Organization" style="text-align:left;"
													maxlength="40" size="50" tabindex="-1" readonly="true" />
											</div>
										</div>
									</div>
									<!-- 報告書の一行分(複数可) -->
									<div class="report_a_line">
										<!-- 出力用 -->
										<div class="item-output">
											<div>
												<!-- 項目名 -->
												公庫支店
											</div>
											<div>
												<!-- 値 -->
												<parts:text path="txtID_Code_KoukoShiten"
													id="txtID_Code_KoukoShiten" style="text-align:center;"
													maxlength="2" size="2" tabindex="-1" readonly="true" />
											</div>
										</div>
										<!-- 出力用 -->
										<div class="item-output">
											<div>
												<!-- 項目名 -->
												扱店
											</div>
											<div>
												<!-- 値 -->
												<parts:text path="txtID_Code_Organization"
													id="txtID_Code_Organization" style="text-align:center;"
													maxlength="4" size="4" tabindex="-1" readonly="true" />
											</div>
										</div>
										<!-- 出力用 -->
										<div class="item-output">
											<div>
												<!-- 項目名 -->
												店舗
											</div>
											<div>
												<!-- 値 -->
												<parts:text path="txtID_Code_Tenpo" id="txtID_Code_Tenpo"
													style="text-align:center;" maxlength="3" size="3"
													tabindex="-1" readonly="true" />
											</div>
										</div>
										<!-- 出力用 -->
										<div class="item-output">
											<div>
												<!-- 項目名 -->
												年度
											</div>
											<div>
												<!-- 値 -->
												<input type="text" class="protect"
													style="text-align: center;" maxlength="4" size="4"
													tabindex="-1" readonly
													value="<pn:printWareki date='${md001_01Form.txtID_Year}' pattern='GY'/>" />
											</div>
										</div>
										<!-- 出力用 -->
										<div class="item-output">
											<div>
												<!-- 項目名 -->
												方式資金
											</div>
											<div>
												<!-- 値 -->
												<parts:text path="txtID_Code_HoshikiShikin"
													id="txtID_Code_HoshikiShikin" style="text-align:center;"
													maxlength="2" size="2" tabindex="-1" readonly="true" />
											</div>
										</div>
										<!-- 出力用 -->
										<div class="item-output">
											<div>
												<!-- 項目名 -->
												番号
											</div>
											<div>
												<!-- 値 -->
												<parts:text path="txtID_ID_Ringi" id="txtID_ID_Ringi"
													style="text-align:center;" maxlength="5" size="5"
													tabindex="-1" readonly="true" />
											</div>
										</div>
										<!-- 出力用 -->
										<div class="item-output">
											<div>
												<!-- 項目名 -->
												枝番
											</div>
											<div>
												<!-- 値 -->
												<parts:text path="txtID_ID_RingiBranch"
													id="txtID_ID_RingiBranch" style="text-align:center;"
													maxlength="3" size="3" tabindex="-1" readonly="true" />
											</div>
										</div>
										<!-- 出力用 -->
										<div class="item-output">
											<div>
												<!-- 項目名 -->
												資金使途
											</div>
											<div>
												<!-- 値 -->
												<parts:text path="txtID_Code_ShikinShito"
													id="txtID_Code_ShikinShito" style="text-align:center;"
													maxlength="4" size="4" tabindex="-1" readonly="true" />
											</div>
										</div>
										<!-- 出力用 -->
										<div class="item-output">
											<div>
												<!-- 項目名 -->
												事業別
											</div>
											<div>
												<!-- 値 -->
												<parts:text path="txtID_Code_Jigyobetsu"
													id="txtID_Code_Jigyobetsu" style="text-align:center;"
													maxlength="2" size="2" tabindex="-1" readonly="true" />
											</div>
										</div>
									</div>
									<!-- 報告書の一行分(複数可) -->
									<div class="report_a_line">
										<!-- 出力用 -->
										<!-- ----- スーパーL資金対応追加 Start ----- -->
										<div class="item-input">
											<div>
												<!-- 項目名 -->
												利率(%)
											</div>
											<div>
												<!-- 値 -->
												<parts:text path="txtID_Riritsu" id="txtID_Riritsu"
													style="text-align:right;" maxlength="6" size="6"
													cssClass="format-point3" />
											</div>
										</div>
										<!-- ----- スーパーL資金対応追加 End ----- -->
										<!-- 出力用 -->
										<div class="item-output">
											<div>
												<!-- 項目名 -->
												特利区分
											</div>
											<div>
												<!-- 値 -->
												<parts:text path="txtID_Kubun_Tokuri"
													id="txtID_Kubun_Tokuri" style="text-align:center;"
													maxlength="1" size="1" tabindex="-1" readonly="true" />
											</div>
										</div>
										<!-- 出力用 -->
										<div class="item-output">
											<div>
												<!-- 項目名 -->
												特利(%)
											</div>
											<div>
												<!-- 値 -->
												<parts:text path="txtID_Tokuri" id="txtID_Tokuri"
													style="text-align:center;" maxlength="5" size="6"
													tabindex="-1" readonly="true" />
											</div>
										</div>
										<!-- 出力用 -->
										<div class="item-output">
											<div>
												<!-- 項目名 -->
												据置期限
											</div>
											<div>
												<!-- 値 -->
												<input type="text" class="protect"
													style="text-align: center;" maxlength="6" size="6"
													tabindex="-1" readonly
													value="<pn:printWareki date='${md001_01Form.txtID_Date_SueokiKigen}' pattern='GYM'/>" />
											</div>
										</div>
										<!-- 出力用 -->
										<div class="item-output">
											<div>
												<!-- 項目名 -->
												償還期限
											</div>
											<div>
												<!-- 値 -->
												<input type="text" class="protect"
													style="text-align: center;" maxlength="6" size="6"
													tabindex="-1" readonly
													value="<pn:printWareki date='${md001_01Form.txtID_Date_ShokanKigen}' pattern='GYM'/>" />
											</div>
										</div>
										<!-- 出力用 -->
										<div class="item-output">
											<!-- 出力用 -->
											<div>受託者勘定処理年月</div>
											<div>
												<input type="text" class="protect"
													style="text-align: center;" maxlength="6" size="6"
													tabindex="-1" readonly
													value="<pn:printWareki date='${md001_01Form.txtID_Date_Jtkshori}' pattern='GYM'/>" />
											</div>
										</div>
										<div class="item-output">
											<div>
												<!-- 項目名 -->
												元利金払込日
											</div>
											<div>
												<!-- 値 -->
												<parts:text path="txtID_Date_GanrikinHaraikomi"
													id="txtID_Date_GanrikinHaraikomi"
													style="text-align:center;" maxlength="5" size="5"
													tabindex="-1" readonly="true" />
											</div>
										</div>
									</div>
									<!-- 報告書の一行分(複数可) -->
									<div class="report_a_line">
										<!-- 出力用 -->
										<!-- 入力用 -->
										<div class="item-input">
											<div>貸付実行日</div>
											<div>
												<parts:select path="ID_Date_Kashitsukejikko_Gengo"
													id="ID_Date_Kashitsukejikko_Gengo" style="color:#003399;">
													<parts:codeListOption categoryCode="00002" />
												</parts:select>
												<parts:text path="ID_Date_Kashitsukejikko_Nen"
													id="ID_Date_Kashitsukejikko_Nen"
													style="width:30px;text-align: center;" maxlength="2"
													size="2" />
												<label id="lblDateKashitsukeJikkoNen">年</label>
												<parts:select path="drpID_Date_KashitsukejikkoTsuki"
													id="drpID_Date_KashitsukejikkoTsuki" style="color:#003399;">
													<parts:codeListOption categoryCode="00003" />
												</parts:select>
												<label id="lblDateKashitsukeJikkoTsuki">月</label>
												<parts:select path="drpID_Date_KashitsukejikkoBi"
													id="drpID_Date_KashitsukejikkoBi" style="color:#003399;">
													<parts:codeListOption categoryCode="00004" />
												</parts:select>
												<label id="lblDateKashitsukeJikkoBi">日</label>
											</div>
										</div>
										<!-- 出力用 -->
										<div class="item-output">
											<div>
												<!-- 項目名 -->
												貸付実行金額(円)
											</div>
											<div>
												<!-- 値 -->
												<parts:text path="txtID_M_Kashitsuke"
													id="txtID_M_Kashitsuke"
													style="width:130px;text-align: right;" maxlength="11"
													size="15" tabindex="-1"  cssClass="format-number" readonly="true" />
											</div>
										</div>
										<!-- 入力用 -->
										<div class="item-input">
											<div>資金交付額(円)</div>
											<div>
												<parts:text path="txtID_M_ShikinKofu"
													id="txtID_M_ShikinKofu"
													style="width:130px;text-align: right;" maxlength="11"
													size="15" cssClass="format-number" />
											</div>
										</div>
										<!-- 出力用 -->
										<div class="item-output">
											<div>
												<!-- 項目名 -->
												貸付受入金受入額(円)
											</div>
											<div>
												<!-- 値 -->
												<parts:text path="txtID_M_KashitukeUkeire"
													id="txtID_M_KashitukeUkeire"
													style="width:130px;text-align: right;" maxlength="11"
													size="15" tabindex="-1"  cssClass="format-number" readonly="true" />
											</div>
										</div>
									</div>
									<div class="report_a_line">
										<!-- 入力用 -->
										<div class="item-input">
											<div>受託者勘定処理年月</div>
											<div>
												<parts:select path="ID_Date_Jtkshori_Gengo"
													id="ID_Date_Jtkshori_Gengo" style="color:#003399;">
													<parts:codeListOption categoryCode="00002" />
												</parts:select>
												<parts:text path="ID_Date_Jtkshori_Nen"
													id="ID_Date_Jtkshori_Nen"
													style="width:30px;text-align: center;" maxlength="2"
													size="2" />
												<label id="lblDateJtkshoriNen">年</label>
												<parts:select path="drpID_Date_JtkshoriTsuki"
													id="drpID_Date_JtkshoriTsuki" style="color:#003399;">
													<parts:codeListOption categoryCode="00003" />
												</parts:select>
												<label id="lblDateJtkshoriTsuki">月</label>
											</div>
										</div>
									</div>
								</div>
								<div style="display: none;"><!-- 更正赤情報保持用（非表示・更新時に使用） -->
									<parts:dlabel path="txtID_Name_Customer_Red" />
									<parts:dlabel path="txtID_Name_Organization_Red" />
									<parts:dlabel path="txtID_Code_KoukoShiten_Red" />
									<parts:dlabel path="txtID_Code_Organization_Red" />
									<parts:dlabel path="txtID_Code_Tenpo_Red" />
									<parts:dlabel path="txtID_Year_Red" />
									<parts:dlabel path="txtID_Code_HoshikiShikin_Red" />
									<parts:dlabel path="txtID_ID_Ringi_Red" />
									<parts:dlabel path="txtID_ID_RingiBranch_Red" />
									<parts:dlabel path="txtID_Code_ShikinShito_Red" />
									<parts:dlabel path="txtID_Code_Jigyobetsu_Red" />
									<parts:dlabel path="txtID_Riritsu_Red" />
									<parts:dlabel path="txtID_Kubun_Tokuri_Red" />
									<parts:dlabel path="txtID_Tokuri_Red" />
									<parts:dlabel path="txtID_Date_SueokiKigen_Red" />
									<parts:dlabel path="txtID_Date_ShokanKigen_Red" />
									<parts:dlabel path="txtID_Date_Jtkshori_Red" />
									<parts:dlabel path="txtID_Date_GanrikinHaraikomi_Red" />
									<parts:dlabel path="txtID_Date_Kashitsukejikko_Red" />
									<parts:dlabel path="txtID_M_Kashitsuke_Red" />
									<parts:dlabel path="txtID_M_ShikinKofu_Red" />
									<parts:dlabel path="txtID_M_KashitukeUkeire_Red" />
									<parts:dlabel path="ID_Date_Jtkshori_Gengo_Red" />
									<parts:dlabel path="ID_Date_Jtkshori_Nen_Red" />
									<parts:dlabel path="drpID_Date_JtkshoriTsuki_Red" />
								</div>
							</div>
						</div> <!-- 報告書一枚終わり -->
					</td>
				</parts:tr>
				<parts:tr>
					<td >
						<div style="display: none;">
							<parts:dlabel path="lblMessage" />
							<parts:dlabel path="Time_Report" />
							<parts:dlabel path="Status" />
							<parts:dlabel path="ID_Report" />
							<parts:dlabel path="ID_OperationSelect" />
							<parts:dlabel path="Type_Process" />
							<parts:dlabel path="ModeType" />
							<parts:dlabel path="ProcessMode" />
							<parts:dlabel path="ID_ID_History_Red" />
							<parts:dlabel path="ID_Type_Process_Red" />
							<parts:dlabel path="ID_Flag_Torikeshizumi_Red" />
							<parts:dlabel path="ID_Type_Process_Red" />
							<parts:dlabel path="ID_Code_Error_Red" />
							<parts:dlabel path="ID_ID_Credit_Red" />
							<parts:dlabel path="ID_ID_Denso_Red" />
							<parts:dlabel path="ID_Count_Kashitsuke_Red" />
							<parts:dlabel path="ID_ID_Maste_Red" />
							<parts:dlabel path="ID_SignData_Red" />
							<parts:dlabel path="ID_Status_Red" />
							<parts:dlabel path="ID_DataCode_Red" />
							<parts:dlabel path="ID_UserID_Red" />
							<parts:dlabel path="ID_Time_Report_Red" />
							<parts:dlabel path="ID_Flag_Kj_Red" />
							<parts:dlabel path="ID_Code_Customer_Red" />
							<parts:dlabel path="ID_Date_JuriKisan_Red" />
							<parts:dlabel path="ID_Date_KetteiKisan_Red" />
							<parts:dlabel path="ID_Keep_Date_ShokanKigen_Red" />
							<parts:dlabel path="ID_keep_ID_History_Red" />
							<parts:dlabel path="ID_Keep_Flag_Kj_Red" />
							<parts:dlabel path="ID_aRingi_Flag_Kj_Red" />
							<parts:dlabel path="ID_aRingi_Date_ShokanKigen_Red" />
							<parts:dlabel path="ID_aRingi_Riritsu_Red" />
							<parts:dlabel path="ID_aRingi_Tokuri_Red" />
							<parts:dlabel path="ID_Data_LastUpDate_Red" />
							<parts:dlabel path="ID_ID_History" />
							<parts:dlabel path="ID_Type_Process" />
							<parts:dlabel path="ID_Flag_Torikeshizumi" />
							<parts:dlabel path="ID_Code_Error" />
							<parts:dlabel path="ID_ID_Credit" />
							<parts:dlabel path="ID_ID_Denso" />
							<parts:dlabel path="ID_Count_Kashitsuke" />
							<parts:dlabel path="ID_ID_Maste" />
							<parts:dlabel path="ID_SignData" />
							<parts:dlabel path="ID_Status" />
							<parts:dlabel path="ID_DataCode" />
							<parts:dlabel path="ID_UserID" />
							<parts:dlabel path="ID_Time_Report" />
							<parts:dlabel path="ID_Flag_Kj" />
							<parts:dlabel path="ID_Code_Customer" />
							<parts:dlabel path="ID_Date_JuriKisan" />
							<parts:dlabel path="ID_Date_KetteiKisan" />
							<parts:dlabel path="ID_Keep_Date_ShokanKigen" />
							<parts:dlabel path="ID_keep_ID_History" />
							<parts:dlabel path="ID_Keep_Flag_Kj" />
							<parts:dlabel path="ID_aRingi_Flag_Kj" />
							<parts:dlabel path="ID_aRingi_Date_ShokanKigen" />
							<parts:dlabel path="ID_aRingi_Riritsu" />
							<parts:dlabel path="ID_aRingi_Tokuri" />
							<parts:dlabel path="ID_Data_LastUpDate" />
						</div>
					</td>
				</parts:tr>
			</parts:table>
			<br />
		</div>
	</div>
	</parts:form>
	<%@ include file="/jsp/incFooter.jsp"%>
	</body>
</html>