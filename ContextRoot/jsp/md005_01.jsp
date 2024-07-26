
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/jsp/incTop.jsp" %>

<%--================================================================================================
 * Project Name : パートナーネット開発
 * System Name  : パートナーネット
 * File Name    : md005_03.jsp
 *
 * <<Modification History>>
 * Version | Date        | Updated By            | Content
 * --------+-------------+-----------------------+---------------------------------------------------
 * 1.0.0   | 2015/07/01 | 木村　しのぶ          | 新規作成
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
		executeAction('../../md005/md005_01/Md005_01Send.form');
	}
<%-- 戻るボタン処理 --%>
	function click_backBtn() {
		executeAction('../../md000/md000_02/Md000_02Return.form');
	}
//-->
</script>

		<link href="<%=request.getContextPath()%>/css/md005.css" type="text/css" rel="stylesheet" />
		<script language="JavaScript" type="text/javascript" src="<%= request.getContextPath() %>/js/ptncommon.js"></script>
	</head>
	<body onload="initTextFormat()">
		<parts:form  id="Form1" modelAttribute="md005_01Form" method="post"  onsubmit="return false;">
			<%@ include file="/jsp/incCommonHidden.jsp" %>
			<%@ include file="/jsp/incHeaderArea.jsp" %>
			<div id="main_scroll_area">
			<div class="header">
				<div class="title">
					<span class="Title" id="lblTitle"><parts:message code="title.screenName"/></span>
				</div>
			</div>
			<div class="help">
				<a href="#" onclick="openNewWindow('<%= request.getContextPath() %>/help/main_md005.html', false, false, false, 'width=800', 'height=500', false)">
					<font class="help">ヘルプ</font>
				</a>
			</div>
			<div class="main">
				<div class="greeting">
					<label id="lblDataMsg">取消対象報告書を用意しました。変更があれば下欄「受託者勘定処理年月」を入力し、<br>「送信」ボタンを押してください。</label>
					<br>取消・修正対象報告書の一覧画面に戻る場合には「戻る」ボタンを押してください。
				</div>
				<!-- 操作ボタン -->
				<div class="buttons">
					<div style="display:none;">
						<parts:button id="btnBack" />
						<parts:button id="btnUpdate" />
					</div>
					<parts:button id="btnUpdate2" value="送信" onclick="clearTextFormat();click_sendBtn();" />
					<parts:button id="btnBack2" value="戻る" title="取消・修正対象報告書の一覧画面へ戻る" onclick="clearTextFormat();click_backBtn();" />
				</div>
				<!-- -------------------- -->
				<!-- status               -->
				<!-- -------------------- -->
				<div class="reportDate">報告年月日：
					<span class="Error">
						<!-- <parts:dlabel path="lblID_Date_Report" /> -->
						<fmt:parseDate value="${md005_01Form.lblID_Date_Report}"
							var="lblID_Date_Report" pattern="yyyyMMdd" />
						<fmt:formatDate value="${lblID_Date_Report}"
							pattern="yyyy年MM月dd日(E)" />
					</span>
				</div>
				<div class="status">ステータス：
					<br />
					<div style="color:red;font-weight:bold;">
						<parts:errors path="*" cssClass="Error" />
					</div>
				</div>
				<div >
					<%-- 取消用データ表示領域 --%>
					<parts:table id="pnl" cssStyle="border-style:none;">
						<parts:tr  id="pnl_Red"  cssStyle="border-style:none;" >
							<td>
								<div class="page-break"><br/></div>
								<div id="pnl_Red" style="padding-bottom: 15px;">
									<!-- 報告書一枚(borderで囲んである,複数可) -->
									<!-- 実装時はASP.NETのユーザコントロールよびだし -->
									<!-- ジャンプ用アンカー(名前) -->
									<parts:link id="" href=""></parts:link>
									<div class="report">
										<div  align="center" class="kousei-aka">
											<!-- <label id="lblID_Head_Red">取消内容</label>&nbsp; -->
											<parts:dlabel path="lblID_Head_Red"/>
											<logic:equal path="lblID_Head_Red2"  value="Visible">
												<label id="lblID_Head_Red2" style="color:red;">赤</label>
											</logic:equal>
										</div> <!-- ジャンプ用アンカー(名前) -->
										<div align="center"><!-- 出力用 --> <!-- 報告書の一行分(複数可) -->
											<div class="report_a_line"><!-- 入力用 --> <!-- 出力用 -->
												<div class="item-output">
													<div><!-- 項目名 --> 顧客名</div>
													<div><!-- 値 -->
														<parts:text path="txtID_Name_Customer_Red" id="txtID_Name_Customer_Red" style="text-align: left;" maxlength="40" size="50" tabindex="-1" readonly="true" />
													</div>
												</div> <!-- 出力用 -->
												<div class="item-output">
													<div><!-- 項目名 --> 扱店名</div>
													<div><!-- 値 -->
														<parts:text path="txtID_Name_Organization_Red" id="txtID_Name_Organization_Red" style="text-align: left;" maxlength="40" size="50" tabindex="-1" readonly="true" />
													</div>
												</div>
											</div>
											<div class="report_a_line"><!-- 出力用 -->
												<div class="item-output">
													<div><!-- 項目名 --> 公庫支店</div>
													<div><!-- 値 -->
														<parts:text path="txtID_Code_KoukoShiten_Red" id="txtID_Code_KoukoShiten_Red" style="text-align: center;" maxlength="2" size="2" tabindex="-1" readonly="true" />
													</div>
												</div> <!-- 出力用 -->
												<div class="item-output">
													<div><!-- 項目名 --> 扱店</div>
													<div><!-- 値 -->
														<parts:text path="txtID_Code_Organization_Red" id="txtID_Code_Organization_Red" style="text-align: center;" maxlength="4" size="4" tabindex="-1" readonly="true" />
													</div>
												</div> <!-- 出力用 -->
												<div class="item-output">
													<div><!-- 項目名 --> 店舗</div>
													<div><!-- 値 -->
														<parts:text path="txtID_Code_Tenpo_Red" id="txtID_Code_Tenpo_Red" style="text-align: center;" maxlength="3" size="3" tabindex="-1" readonly="true" />
													</div>
												</div> <!-- 出力用 -->
												<div class="item-output">
													<div><!-- 項目名 --> 年度</div>
													<div><!-- 値 -->
														<!-- <parts:text path="txtID_Year_Red" id="txtID_Year_Red" style="text-align: center;" maxlength="4" size="4" tabindex="-1" readonly="true" /> -->
														<input type="text" class="protect" style="text-align: center;" maxlength="4" size="4" tabindex="-1" readonly value="<pn:printWareki date='${md005_01Form.txtID_Year_Red}' pattern='GY'/>" />
													</div>
												</div> <!-- 出力用 -->
												<div class="item-output">
													<div><!-- 項目名 --> 方式資金</div>
													<div><!-- 値 -->
														<parts:text path="txtID_Code_HoshikiShikin_Red" id="txtID_Code_HoshikiShikin_Red" style="text-align: center;" maxlength="2" size="2" tabindex="-1" readonly="true" />
													</div>
												</div> <!-- 出力用 -->
												<div class="item-output">
													<div><!-- 項目名 --> 番号</div>
													<div><!-- 値 -->
														<parts:text path="txtID_ID_Ringi_Red" id="txtID_ID_Ringi_Red" style="text-align: center;" maxlength="5" size="5" tabindex="-1" readonly="true" />
													</div>
												</div> <!-- 出力用 -->
												<div class="item-output">
													<div><!-- 項目名 --> 枝番</div>
													<div><!-- 値 -->
														<parts:text path="txtID_ID_RingiBranch_Red" id="txtID_ID_RingiBranch_Red" style="text-align: center;" maxlength="3" size="3" tabindex="-1" readonly="true" />
													</div>
												</div> <!-- 出力用 -->
											</div> <!-- 報告書の一行分(複数可) -->
											<div class="report_a_line"><!-- 出力用 -->
												<div class="item-output">
													<div><!-- 項目名 --> 充当対象払込期日</div>
													<div><!-- 値 -->
														<!-- <parts:text path="txtID_Date_JutoTaisho_Red" id="txtID_Date_JutoTaisho_Red" style="text-align: right;" maxlength="9" size="7" tabindex="-1" readonly="true" /> -->
														<input type="text" class="protect" style="text-align: center;" maxlength="9" size="9" tabindex="-1" readonly value="<pn:printWareki date='${md005_01Form.txtID_Date_JutoTaisho_Red}' pattern='GYMD'/>" />
													</div>
												</div> <!-- 出力用 -->
												<div class="item-output">
													<div><!-- 項目名 --> 代弁金払込日</div>
													<div><!-- 値 -->
														<!-- <parts:text path="txtID_Date_DaibenkinHaraikomi_Red" id="txtID_Date_DaibenkinHaraikomi_Red" style="text-align: right;" maxlength="9" size="7" tabindex="-1" readonly="true" /> -->
														<input type="text" class="protect" style="text-align: center;" maxlength="9" size="9" tabindex="-1" readonly value="<pn:printWareki date='${md005_01Form.txtID_Date_DaibenkinHaraikomi_Red}' pattern='GYMD'/>" />
													</div>
												</div> <!-- 出力用 -->
												<div class="item-output" style="width: 130px">
													<div><!-- 項目名 --> 遅延損害金(円)</div>
													<div class="styleMoney" style="padding-right: 8px"><!-- 値 -->
														<parts:text path="txtID_M_ChienSongai_Red" id="txtID_M_ChienSongai_Red" cssClass="format-number" style="text-align: right;" maxlength="11" size="15" readonly="true" />
													</div>
												</div> <!-- 出力用 -->
												<div class="item-output" style="width: 130px">
													<div><!-- 項目名 --> 利息(円)</div>
													<div class="styleMoney" style="padding-right: 8px"><!-- 値 -->
														<parts:text path="txtID_M_Risoku_Red" id="txtID_M_Risoku_Red" cssClass="format-number"  style="text-align: right;" maxlength="11" size="15" readonly="true" />
													</div>
												</div> <!-- 出力用 -->
											</div> <!-- 報告書の一行分(複数可) -->
											<div class="report_a_line"><!-- 出力用 -->
												<div class="item-output" >
													<div><!-- 項目名 --> 繰上償還手数料(円)</div>
													<div class="styleMoney" style="padding-right: 8px"><!-- 値 -->
														<parts:text path="txtID_M_KurishoCommission_Red" id="txtID_M_KurishoCommission_Red" cssClass="format-number"  style="text-align: right;" maxlength="11" size="15" tabindex="-1" readonly="true" />
													</div>
												</div> <!-- 出力用 -->
												<div class="item-output" style="width: 130px">
													<div><!-- 項目名 --> 元金(円)</div>
													<div class="styleMoney" style="padding-right: 8px"><!-- 値 -->
														<parts:text path="txtID_M_Gankin_Red" id="txtID_M_Gankin_Red" style="text-align: right;" cssClass="format-number"  maxlength="11" size="15" tabindex="-1" readonly="true" />
													</div>
												</div> <!-- 出力用 -->
												<div class="item-output">
													<div><!-- 項目名 --> 仮受金(一般口)からの充当額(円)</div>
													<div class="styleMoney"><!-- 値 -->
														<parts:text path="txtID_M_KariukeIppanJuto_Red" id="txtID_M_KariukeIppanJuto_Red" cssClass="format-number"  style="text-align: right;" maxlength="11" size="15" readonly="true" />
													</div>
												</div>
											</div> <!-- 報告書の一行分(複数可) -->
											<div class="report_a_line"><!-- 出力用 -->
												<div class="item-output" style="width: 130px">
													<div><!-- 項目名 --> 計(円)</div>
													<div class="styleMoney" style="padding-right: 8px"><!-- 値 -->
														<parts:text path="txtID_M_Kei_Red" id="txtID_M_Kei_Red" style="text-align: right;" cssClass="format-number"  maxlength="11" size="15" tabindex="-1" readonly="true" />
													</div>
												</div> <!-- 出力用 -->
												<div class="item-output" style="width: 130px">
													<div><!-- 項目名 --> 送金額(円)</div>
													<div style="padding-right: 8px"><!-- 値 -->
														<parts:text path="txtID_M_Sokin_Red" id="txtID_M_Sokin_Red" style="text-align: right;" cssClass="format-number"  maxlength="11" size="15" tabindex="-1" readonly="true" />
													</div>
												</div> <!-- 出力用 -->
												<div class="item-output">
													<div><!-- 項目名 --> 代弁金充当後残元金(円)</div>
													<div><!-- 値 -->
														<parts:text path="txtID_M_ZanGanAfterDaibenJuto_Red" id="txtID_M_ZanGanAfterDaibenJuto_Red" cssClass="format-number"  style="text-align: right;" maxlength="11" size="15" tabindex="-1" readonly="true" />
													</div>
												</div> <!-- 入力用 -->
											</div> <!-- 報告書の一行分(複数可) -->
											<div class="report_a_line"><!-- 入力用 -->
												<div class="item-output">
													<div>受託者勘定処理年月</div>
													<div>
														<!-- <parts:text path="txtID_Date_Jtkshori_Red" id="txtID_Date_Jtkshori_Red" style="text-align: center;" maxlength="6" size="5" tabindex="-1" readonly="true" /> -->
														<input type="text" class="protect" style="text-align: center;" maxlength="6" size="6" tabindex="-1" readonly value="<pn:printWareki date='${md005_01Form.txtID_Date_Jtkshori_Red}' pattern='GYM'/>" />
													</div>
												</div>
												<div class="item-output">
													<div>送金日</div>
													<div>
														<!-- <parts:text path="txtID_Date_Sokin_Red" id="txtID_Date_Sokin_Red" style="text-align: center;" maxlength="9" size="7" readonly="true" /> -->
														<input type="text" class="protect" style="text-align: center;" maxlength="9" size="9" tabindex="-1" readonly value="<pn:printWareki date='${md005_01Form.txtID_Date_Sokin_Red}' pattern='GYMD'/>" />
													</div>
												</div>
												<div class="item-output">
													<div>送金日番号</div>
													<div>
														<parts:text path="txtID_ID_Sokinbi_Red" id="txtID_ID_Sokinbi_Red" style="text-align: center;" maxlength="3" size="3" readonly="true" />
													</div>
												</div> <!-- 入力用 -->
											</div> <!-- 報告書の一行分(複数可) -->
											<div class="report_a_line"><!-- 入力用 -->
												<div class="item-input">
													<div>受託者勘定処理年月</div>
													<div>
														<parts:select path="drpID_Date_JtkshoriGengou_Red" id="drpID_Date_JtkshoriGengou_Red" style="color:#003399;">
															<parts:codeListOption categoryCode="00002" />
														</parts:select>
														<parts:text path="txtID_Date_JtkshoriYear_Red" id="txtID_Date_JtkshoriYear_Red" style="width:30px;text-align: center;" maxlength="2" size="2" />
														<label id="lblDateJtkshoriYear_Red">年</label>
														<parts:select path="drpID_Date_JtkshoriMonth_Red" id="drpID_Date_JtkshoriMonth_Red" style="color:#003399;">
															<parts:codeListOption categoryCode="00003" />
														</parts:select>
														<label id="lblDateJtkshoriMonth_Red">月</label></div>
												</div>
											</div>
										</div>
									</div> <!-- 報告書一枚終わり -->
									<div></div>
									<div></div>
								</div>
							</td>
						</parts:tr>
						<parts:tr id="pnl_Mod" cssStyle="border-style:none;">
							<td>
								<%-- 修正用データ表示領域 --%>
								<div class="page-break"><br/></div>
								<div id="pnl_Mod">
									<!-- 報告書一枚(borderで囲んである,複数可) -->
									<!-- ジャンプ用アンカー(名前) -->
									<parts:link id=""  href=""></parts:link>
									<div class="report">
										<div align="center" class="shusei">
											<!-- <label id="lblID_Head">修正内容</label> -->
											<parts:dlabel path="lblID_Head"/>
										</div>
										<div align="center"><!-- 報告書の一行分(複数可) -->
											<div class="report_a_line"><!-- 出力用 -->
												<div class="item-output">
													<div><!-- 項目名 --> 顧客名</div>
													<div><!-- 値 -->
														<parts:text path="txtID_Name_Customer" id="txtID_Name_Customer" maxlength="40" size="50" tabindex="-1" readonly="true" />
													</div>
												</div> <!-- 出力用 -->
												<div class="item-output">
													<div><!-- 項目名 --> 扱店名</div>
													<div><!-- 値 -->
														<parts:text path="txtID_Name_Organization" id="txtID_Name_Organization" maxlength="40" size="50" tabindex="-1" readonly="true" />
													</div>
												</div>
											</div> <!-- 報告書の一行分(複数可) -->
											<div class="report_a_line"><!-- 出力用 -->
												<div class="item-output">
													<div><!-- 項目名 --> 公庫支店</div>
													<div><!-- 値 -->
														<parts:text path="txtID_Code_KoukoShiten" id="txtID_Code_KoukoShiten" style="text-align: center;" maxlength="2" size="2" tabindex="-1" readonly="true" />
													</div>
												</div> <!-- 出力用 -->
												<div class="item-output">
													<div><!-- 項目名 --> 扱店</div>
													<div><!-- 値 -->
														<parts:text path="txtID_Code_Organization" id="txtID_Code_Organization" style="text-align: center;" maxlength="4" size="4" tabindex="-1" readonly="true" />
													</div>
												</div> <!-- 出力用 -->
												<div class="item-output">
													<div><!-- 項目名 --> 店舗</div>
													<div><!-- 値 -->
														<parts:text path="txtID_Code_Tenpo" id="txtID_Code_Tenpo" style="text-align: center;" maxlength="3" size="3" tabindex="-1" readonly="true" />
													</div>
												</div> <!-- 出力用 -->
												<div class="item-output">
													<div><!-- 項目名 --> 年度</div>
													<div><!-- 値 -->
														<!-- <parts:text path="txtID_Year" id="txtID_Year" style="text-align: center;" maxlength="4" size="4" tabindex="-1" readonly="true" /> -->
														<input type="text" class="protect" style="text-align: center;" maxlength="4" size="4" tabindex="-1" readonly value="<pn:printWareki date='${md005_01Form.txtID_Year}' pattern='GY'/>" />
													</div>
												</div> <!-- 出力用 -->
												<div class="item-output">
													<div><!-- 項目名 --> 方式資金</div>
													<div><!-- 値 -->
														<parts:text path="txtID_Code_HoshikiShikin" id="txtID_Code_HoshikiShikin" style="text-align: center;" maxlength="2" size="2" tabindex="-1" readonly="true" />
													</div>
												</div> <!-- 出力用 -->
												<div class="item-output">
													<div><!-- 項目名 --> 番号</div>
													<div><!-- 値 -->
														<parts:text path="txtID_ID_Ringi" id="txtID_ID_Ringi" style="text-align: center;" maxlength="5" size="5" tabindex="-1" readonly="true" />
													</div>
												</div> <!-- 出力用 -->
												<div class="item-output">
													<div><!-- 項目名 --> 枝番</div>
													<div><!-- 値 -->
														<parts:text path="txtID_ID_RingiBranch" id="txtID_ID_RingiBranch" style="text-align: center;" maxlength="3" size="3" tabindex="-1" readonly="true" />
													</div>
												</div> <!-- 出力用 -->
											</div> <!-- 報告書の一行分(複数可) -->
											<div class="report_a_line"><!-- 出力用 -->
												<div class="item-input">
													<div><!-- 項目名 --> 充当対象払込期日</div>
													<div><!-- 値 -->
														<parts:select path="drpID_Date_JutoTaishoGengou" id="drpID_Date_JutoTaishoGengou">
															<parts:codeListOption categoryCode="00002" />
														</parts:select>
														<parts:text path="txtID_Date_JutoTaishoYear" id="txtID_Date_JutoTaishoYear" style="width:30px;text-align: center;" maxlength="2" size="2" />年
														<parts:select path="drpID_Date_JutoTaishoMonth" id="drpID_Date_JutoTaishoMonth">
															<parts:codeListOption categoryCode="00003" />
														</parts:select>月
														<parts:select path="drpID_Date_JutoTaishoDay" id="drpID_Date_JutoTaishoDay">
															<parts:codeListOption categoryCode="00004" />
														</parts:select>日
													</div>
												</div> <!-- 出力用 -->
												<div class="item-input">
													<div><!-- 項目名 --> 代弁金払込日</div>
													<div><!-- 値 -->
														<parts:select path="drpID_Date_DaibenkinHaraikomiGengou" id="drpID_Date_DaibenkinHaraikomiGengou">
															<parts:codeListOption categoryCode="00002" />
														</parts:select>
														<parts:text path="txtID_Date_DaibenkinHaraikomiYear" id="txtID_Date_DaibenkinHaraikomiYear" style="width:30px;text-align: center;" maxlength="2" size="2" />年
														<parts:select path="drpID_Date_DaibenkinHaraikomiMonth" id="drpID_Date_DaibenkinHaraikomiMonth">
															<parts:codeListOption categoryCode="00003" />
														</parts:select>月
														<parts:select path="drpID_Date_DaibenkinHaraikomiDay" id="drpID_Date_DaibenkinHaraikomiDay">
															<parts:codeListOption categoryCode="00004" />
														</parts:select>日
													</div>
												</div> <!-- 出力用 -->
												<div class="item-input" style="width: 130px">
													<div><!-- 項目名 --> 遅延損害金(円)</div>
													<div class="styleMoney" style="padding-right: 8px"><!-- 値 -->
														<parts:text path="txtID_M_ChienSongai" id="txtID_M_ChienSongai" style="text-align: right;" maxlength="11" size="15"  cssClass="format-number" />
													</div>
												</div> <!-- 出力用 -->
												<div class="item-input" style="width: 130px">
													<div><!-- 項目名 --> 利息(円)</div>
													<div class="styleMoney" style="padding-right: 8px"><!-- 値 -->
														<parts:text path="txtID_M_Risoku" id="txtID_M_Risoku" style="text-align: right;" maxlength="11" size="15"  cssClass="format-number" />
													</div>
												</div>
											</div> <!-- 報告書の一行分(複数可) -->
											<div class="report_a_line"><!-- 出力用 --> <!-- 出力用 -->
												<div class="item-input">
													<div><!-- 項目名 --> 繰上償還手数料(円)</div>
													<div class="styleMoney" style="padding-right: 8px"><!-- 値 -->
														<parts:text path="txtID_M_KurishoCommission" id="txtID_M_KurishoCommission" style="text-align: right;" maxlength="11" size="15"  cssClass="format-number" />
													</div>
												</div> <!-- 出力用 -->
												<div class="item-input" style="width: 130px">
													<div><!-- 項目名 --> 元金(円)</div>
													<div class="styleMoney" style="padding-right: 8px"><!-- 値 -->
														<parts:text path="txtID_M_Gankin" id="txtID_M_Gankin" style="text-align: right;" maxlength="11" size="15"  cssClass="format-number" />
													</div>
												</div>
												<div class="item-input">
													<div><!-- 項目名 --> 仮受金(一般口)からの充当額(円)</div>
													<div class="styleMoney"><!-- 値 -->
														<parts:text path="txtID_M_KariukeIppanJuto" id="txtID_M_KariukeIppanJuto" style="text-align: right;" maxlength="11" size="15"  cssClass="format-number" />
													</div>
												</div>
											</div> <!-- 報告書の一行分(複数可) -->
											<div class="report_a_line"><!-- 出力用 -->
												<div class="item-output" style="width: 130px">
													<div><!-- 項目名 --> 計(円)</div>
													<div class="styleMoney" style="padding-right: 8px"><!-- 値 -->
														<parts:text path="txtID_M_Kei" id="txtID_M_Kei" cssClass="format-number"  style="text-align: right;" maxlength="11" size="15" tabindex="-1" readonly="true" />
													</div>
												</div> <!-- 出力用 -->
												<div class="item-output" style="width: 130px">
													<div><!-- 項目名 --> 送金額(円)</div>
													<div class="styleMoney" style="padding-right: 8px"><!-- 値 -->
														<parts:text path="txtID_M_Sokin" id="txtID_M_Sokin" cssClass="format-number"  style="text-align: right;" maxlength="11" size="15" tabindex="-1" readonly="true" />
													</div>
												</div> <!-- 出力用 -->
												<div class="item-output">
													<div><!-- 項目名 --> 代弁金充当後残元金(円)</div>
													<div class="styleMoney"><!-- 値 -->
														<parts:text path="txtID_M_ZanGanAfterDaibenJuto" id="txtID_M_ZanGanAfterDaibenJuto" cssClass="format-number"  style="text-align: right;" maxlength="11" size="15" tabindex="-1" readonly="true" />
													</div>
												</div> <!-- 出力用 -->
											</div> <!-- 報告書の一行分(複数可) -->
											<div class="report_a_line"><!-- 入力用 -->
												<div class="item-output">
													<div>受託者勘定処理年月</div>
													<div>
														<!-- <parts:text path="txtID_Date_Jtkshori" id="txtID_Date_Jtkshori" style="text-align: center;" maxlength="6" size="6" tabindex="-1" readonly="true" /> -->
														<input type="text" class="protect" style="text-align: center;" maxlength="6" size="6" tabindex="-1" readonly value="<pn:printWareki date='${md005_01Form.txtID_Date_Jtkshori}' pattern='GYM'/>" />
													</div>
												</div> <!-- 入力用 -->
												<div class="item-input">
													<div>送金日</div>
													<div>
														<parts:select path="drpID_Date_SokinGengou" id="drpID_Date_SokinGengou" style="color:#003399;">
															<parts:option value=""></parts:option>
															<parts:codeListOption categoryCode="00002"/>
														</parts:select>
														<parts:text path="txtID_Date_SokinYear" id="txtID_Date_SokinYear" style="width:30px;text-align: center;" maxlength="2" size="2" />
														<label id="lblDate_SokinYear">年</label>
														<parts:select path="drpID_Date_SokinMonth" id="drpID_Date_SokinMonth" style="color:#003399;">
															<parts:codeListOption categoryCode="00003" />
														</parts:select>
														<label id="lblDate_SokinMonth">月</label>
														<parts:select path="drpID_Date_SokinDay" id="drpID_Date_SokinDay" style="color:#003399;">
															<parts:codeListOption categoryCode="00004" />
														</parts:select>
														<label id="lblDate_SokinDay">日</label></div>
												</div>
												<div class="item-input">
													<div>送金日番号</div>
													<div>
														<parts:text path="txtID_ID_Sokinbi" id="txtID_ID_Sokinbi" style="text-align: center;" maxlength="3" size="3" />
													</div>
												</div> <!-- 入力用 -->
											</div>
											<div class="report_a_line"><!-- 入力用 -->
												<div class="item-input">
													<div>受託者勘定処理年月</div>
													<div>
														<parts:select path="drpID_Date_JtkshoriGengou" id="drpID_Date_JtkshoriGengou" style="color:#003399;">
															<parts:codeListOption categoryCode="00002" />
														</parts:select>
														<parts:text path="txtID_Date_JtkshoriYear" id="txtID_Date_JtkshoriYear" style="width:30px;text-align: center;" maxlength="2" size="2" />
														<label id="lblDateJtkshoriYear">年</label>
														<parts:select path="drpID_Date_JtkshoriMonth" id="drpID_Date_JtkshoriMonth" style="color:#003399;">
															<parts:codeListOption categoryCode="00003" />
														</parts:select>
														<label id="lblDateJtkshoriMonth">月</label></div>
												</div>
											</div> <!-- 報告書の一行分(複数可) -->
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
									</div>
								</div><!-- 報告書一枚終わり -->
							</td>
						</parts:tr>
						<parts:tr>
							<td >
								<div style="display: none;">
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
									<parts:dlabel path="dataCode" />
									<parts:dlabel path="processMode" />
									<parts:dlabel path="modeType" />
									<parts:dlabel path="keep_M_KashitsukeZan" />
								</div>
							</td>
						</parts:tr>
					</parts:table>
					<br />
				</div>
			</div>
		</div>
		</parts:form><%@ include file="/jsp/incFooter.jsp"%>
	</body>
</html>