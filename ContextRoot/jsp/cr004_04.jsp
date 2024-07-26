
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/jsp/incTop.jsp"%>
<%@ page import="jp.go.jfc.partnernet.common.PNCommonConstants" %>

<%--================================================================================================
 * Project Name : パートナーネット開発
 * System Name  : パートナーネット
 * File Name    : cr004_04.jsp
 *
 * <<Modification History>>
 * Version | Date       | Updated By            | Content
 * --------+------------+-----------------------+---------------------------------------------------
 * 1.0.0   | 2015/07/01 | ○○　○○            | 新規作成
 * 2.0.0   | 2017/12/04 | 嶋田　美保            | 委託貸付報告等における機能改善対応
 * 3.0.0   | 2019/01/11 | 林　晃平              | 農林PN元号対応
================================================================================================--%>

<html>
	<%@ include file="/jsp/incHeader.jsp"%>
	<head>
		<title><parts:message code="title.screenName"/></title>
		<link href="<%=request.getContextPath()%>/css/cr004.css" type="text/css" rel="stylesheet" />
		<script lang="JavaScript">
		<!--
			<%--
			- 送信ボタン押下時の処理
			--%>
			function click_sendBtn() {
				executeAction('../../cr004/cr004_04/Cr004_04Send.form');
			}

			<%--
			- 戻るボタン押下時の処理
			--%>
			function click_backBtn() {
				executeAction('../../cr004/cr004_04/Cr004_04Back.form');
			}

			<%--
			- 入金日変更時の処理
			--%>
			function change_dateNyukin(JtkshoriConfigMode, bizDateGengo,
					bizDateNen, bizDateTsuki, bizDatePrevMonthGengo, bizDatePrevMonthNen, bizDatePrevMonthTsuki) {

				<%-- 入金日 取得 --%>
				nyukinGengo = document.getElementById('drpID_Date_Nyukin_Gengo').value;
				nyukinNen = document.getElementById('txtID_Date_Nyukin_Nen').value;
				nyukinTsuki = document.getElementById('drpID_Date_Nyukin_Tsuki').value;

				<%-- 仮受金(一般口)からの充当額(円) 取得 --%>
				kariukeIppanJuto = document.getElementById('txtID_M_KariukeIppanJuto').value;

				<%-- 日付形式チェック --%>
				if ( !chkDate( nyukinNen, nyukinTsuki) ) {
					return;
				}

				<%-- 和暦→西暦変換 --%>
				nyukinYYYY = warekiToSeireki( nyukinGengo, nyukinNen)
				bizDateYYYY = warekiToSeireki( bizDateGengo, bizDateNen)

				<%-- 月差分計算 ： 業務日付 - 入金日 --%>
				dm = diffMonth( bizDateYYYY, bizDateTsuki, nyukinYYYY, nyukinTsuki);

				<%-- 受託者勘定処理年月設定 --%>
				<%-- 仮受金（一般口）からの充当額（円）が 0 または ブランク --%>
				if ( kariukeIppanJuto == 0 || kariukeIppanJuto.length == 0 ) {

					if ( JtkshoriConfigMode == <%=PNCommonConstants.JTKSHORI_CONFIGMODE_1%>
						|| JtkshoriConfigMode == <%=PNCommonConstants.JTKSHORI_CONFIGMODE_3%>) {
						<%-- 受託者勘定処理年月設定モードが 1（決算期かつ第1～4営業日）または --%>
						<%-- 受託者勘定処理年月設定モードが 3（通常期かつ第1～10営業日）の場合 --%>
						if ( 2 <= dm ) {
							<%-- 入金日が業務日付の前々月以前の場合 --%>
							<%-- 業務日付の前月を設定 --%>
							setDateJtkshori( bizDatePrevMonthGengo, bizDatePrevMonthNen, bizDatePrevMonthTsuki);

						}
						else {

							<%-- 上記以外 入金日 を設定 --%>
							setDateJtkshori( nyukinGengo, nyukinNen, nyukinTsuki);

						}

					}
					else if ( JtkshoriConfigMode == <%=PNCommonConstants.JTKSHORI_CONFIGMODE_2%>
						|| JtkshoriConfigMode == <%=PNCommonConstants.JTKSHORI_CONFIGMODE_4%>) {
						<%-- 受託者勘定処理年月設定モードが 2（決算期かつ第5～最終営業日）または --%>
						<%-- 受託者勘定処理年月設定モードが 4（通常期かつ第11～最終営業日）の場合 --%>

						<%-- 業務日付を設定 --%>
						setDateJtkshori( bizDateGengo, bizDateNen, bizDateTsuki);

					}

				}
				else {
					<%-- 上記以外上記以外（仮受金一般口からの充当） --%>
					if ( JtkshoriConfigMode == <%=PNCommonConstants.JTKSHORI_CONFIGMODE_1%>
						|| JtkshoriConfigMode == <%=PNCommonConstants.JTKSHORI_CONFIGMODE_3%>) {
						<%-- 受託者勘定処理年月設定モードが 1（決算期かつ第1～4営業日）または --%>
						<%-- 受託者勘定処理年月設定モードが 3（通常期かつ第1～10営業日）の場合 --%>

						<%-- 業務日付の前月を設定 --%>
						setDateJtkshori( bizDatePrevMonthGengo, bizDatePrevMonthNen, bizDatePrevMonthTsuki);

					}
					else if ( JtkshoriConfigMode == <%=PNCommonConstants.JTKSHORI_CONFIGMODE_2%>
						 || JtkshoriConfigMode == <%=PNCommonConstants.JTKSHORI_CONFIGMODE_4%>) {
						<%-- 受託者勘定処理年月設定モードが 2（決算期かつ第5～最終営業日）または --%>
						<%-- 受託者勘定処理年月設定モードが 4（通常期かつ第11～最終営業日）の場合 --%>

						<%-- 業務日付を設定 --%>
						setDateJtkshori( bizDateGengo, bizDateNen, bizDateTsuki);

					}

				}

			}

			<%-- 月差分計算 --%>
			function diffMonth( y1, m1, y2, m2) {
				return (y1 - y2) * 12 + (m1 - m2);

			}

			<%-- 日付形式チェック --%>
			function chkDate( year, month) {

				strYear = String(year)
				strMonth = String(month)

				<%-- 未入力チェック --%>
				if ( strYear.length == 0 ) {
					return false;
				}

				if ( strMonth.length == 0 ) {
					return false;
				}

				<%-- 数値属性チェック --%>
				if( strYear.match(/^\d*$/) == null ){
					return false;
				}

				if( strMonth.match(/^\d*$/) == null ){
					return false;
				}

				<%-- 数値範囲チェック --%>
				if ( !( 1 <= year && year <= 99 )) {
					return false;
				}

				if ( !( 1 <= month && month <= 12 )) {
					return false;
				}

				return true;

			}

			<%-- 受託者勘定処理年月 元号、年、月設定 --%>
			function setDateJtkshori( gengo, nen, tsuki) {

				<%-- 受託者勘定処理年月 取得 --%>
				jtkGengo = document.getElementById('drpID_Date_JtkShori_Gengo');
				jtkNen = document.getElementById('txtID_Date_JtkShori_Nen');
				jtkTsuki = document.getElementById('drpID_Date_JtkShori_Tsuki');

				hdnJtkGengo = document.getElementById('hdnID_Date_Jtkshori_Gengo');
				hdnJtkTsuki = document.getElementById('hdnID_Date_JtkshoriTsuki_Candidate');

				<%-- 受託者勘定処理年月（元号）--%>
				jtkGengo.value = gengo;
				hdnJtkGengo.value = gengo;

				<%-- 受託者勘定処理年月（年）--%>
				jtkNen.value = nen;

				<%-- 受託者勘定処理年月（月）--%>
				jtkTsuki.value = tsuki;
				hdnJtkTsuki.value = tsuki;

			}

			<%-- 受託者勘定処理年月 隠しフィールド設定 --%>
			function setHdnJtkshori() {

				<%-- 受託者勘定処理年月 取得 --%>
				jtkGengo = document.getElementById('drpID_Date_JtkShori_Gengo').value;
				jtkTsuki = document.getElementById('drpID_Date_JtkShori_Tsuki').value;

				document.getElementById('hdnID_Date_Jtkshori_Gengo').value = jtkGengo;
				document.getElementById('hdnID_Date_JtkshoriTsuki_Candidate').value = jtkTsuki;

			}
		//-->

		</script>
	</head>
	<body onload="initTextFormat()">
		<parts:form modelAttribute="cr004_04Form" id="Form1" method="post">
			<%@ include file="/jsp/incCommonHidden.jsp" %>
			<%@ include file="/jsp/incHeaderArea.jsp" %>
			<div id="main_scroll_area">
			<div>
			<div class="header">
				<div class="title">
					<label id="lblTitle" class="Title"><parts:message code="title.screenName"/></label><br />
				</div>
			</div>
			<div class="help">
				<a href="#" onclick="openNewWindow('<%= request.getContextPath() %>/help/main_cr004.html', false, false, false, 'width=800', 'height=500', false)">
					<font class="help">ヘルプ</font>
				</a>
			</div>
			<div class="main">
				<div class="greeting">
					必要な項目を入力し、「送信」ボタンを押してください。
				</div>

				<br />
				<div class="buttons">
					<parts:button id="btnID_Send" value="送信" title="送信" onclick="clearTextFormat();click_sendBtn();"/>
					<parts:button id="btnBack" value="戻る" title="戻る" onclick="clearTextFormat();click_backBtn();"/>
				</div>
				<div class="reportDate">報告年月日：
					<parts:dlabel path="txtID_Date_Report" />
				</div>
				<div class="status">
					ステータス：
					<div style="color:red;font-weight:bold;">
						<parts:errors path="*" /><span id="lblError"><parts:dlabel path="lblErr"/></span><br>
						<parts:dlabel path="lblMessage" />
					</div>
				</div>


				<parts:table id="reportArea">
				<parts:tr><td>

				<div align="center" >
					<div class="report">
						<!-- 報告書の一行分(複数可) -->
						<div class="report_a_line">
							<!-- 出力用 -->
							<div class="item-output-cust" style="width:350px">
								<div><!-- 項目名 --> 顧客名</div>
								<div><!-- 値 -->
									<parts:text path="txtID_Name_Customer" id="txtID_Name_Customer" maxlength="40" size="50" tabindex="-1" readonly="true" />
								</div>
							</div>
							<!-- 出力用 -->
							<div class="item-output-org" style="width:350px">
								<div><!-- 項目名 --> 扱店名</div>
								<div><!-- 値 -->
									<parts:text path="txtID_Name_Organization" id="txtID_Name_Organization	" maxlength="40" size="50" tabindex="-1" readonly="true" />
								</div>
							</div>
						</div>
						<!-- 報告書の一行分(複数可) -->
						<div class="report_a_line">
							<!-- 出力用 -->
							<div class="item-output">
								<div><!-- 項目名 --> 公庫支店</div>
								<div><!-- 値 -->
									<parts:text path="txtID_Code_ShokanHonShiten" id="txtID_Code_ShokanHonShiten" style="text-align:center;" maxlength="2" size="2" tabindex="-1" readonly="true" />
								</div>
							</div>
							<!-- 出力用 -->
							<div class="item-output">
								<div><!-- 項目名 --> 扱店</div>
								<div><!-- 値 -->
									<parts:text path="txtID_Code_Organization" id="txtID_Code_Organization" style="text-align:center;" maxlength="4" size="4" tabindex="-1" readonly="true" />
								</div>
							</div>
							<!-- 出力用 -->
							<div class="item-output">
								<div><!-- 項目名 --> 店舗</div>
								<div><!-- 値 -->
									<parts:text path="txtID_Code_Tenpo" id="txtID_Code_Tenpo" style="text-align:center;" maxlength="3" size="3" tabindex="-1" readonly="true" />
								</div>
							</div>
							<!-- 出力用 -->
							<div class="item-output">
								<div><!-- 項目名 --> 年度</div>
								<div><!-- 値 -->
									<parts:text path="txtID_Year" id="txtID_Year" style="text-align:center;" maxlength="4" size="4" tabindex="-1" readonly="true" />
								</div>
							</div>
							<!-- 出力用 -->
							<div class="item-output">
								<div><!-- 項目名 --> 方式資金</div>
								<div><!-- 値 -->
									<parts:text path="txtID_Code_HoshikiShikin" id="txtID_Code_HoshikiShikin" style="text-align:center;" maxlength="2" size="2" tabindex="-1" readonly="true" />
								</div>
							</div>
							<!-- 出力用 -->
							<div class="item-output">
								<div><!-- 項目名 --> 番号</div>
								<div><!-- 値 -->
									<parts:text path="txtID_ID_Ringi" id="txtID_ID_Ringi" style="text-align:center;" maxlength="5" size="5" tabindex="-1" readonly="true" />
								</div>
							</div>
							<!-- 出力用 -->
							<div class="item-output">
								<div><!-- 項目名 --> 枝番</div>
								<div><!-- 値 -->
									<parts:text path="txtID_ID_RingiBranch" id="txtID_ID_RingiBranch" style="text-align:center;" maxlength="3" size="3" tabindex="-1" readonly="true" />
								</div>
							</div>
						</div>
						<!-- 報告書の一行分(複数可) -->
						<div class="report_a_line">
							<!-- 入力用 -->
							<div class="item-input">
								<div><!-- 項目名 --> 償還後第1回払込期日</div>
								<div><!-- 値 -->
									<parts:select path="drpID_Date_FirstHaraikomiAfterKurisho_Gengo" id="drpID_Date_FirstHaraikomiAfterKurisho_Gengo" style="color:#003399;" tabindex="1">
<%-- [UPD] Ver 3.0.0 - START --%>
<%-- 									<parts:option value="S">S</parts:option> --%>
<%-- 									<parts:option value="H">H</parts:option> --%>
										<parts:codeListOption categoryCode="00002" />
<%-- [UPD] Ver 3.0.0 - END --%>
									</parts:select>
									<parts:text path="txtID_Date_FirstHaraikomiAfterKurisho_Nen" id="txtID_Date_FirstHaraikomiAfterKurisho_Nen" style="width:30px;text-align:center;" maxlength="2" tabindex="1" value="" size="2" />
									<label id="lblDateFirstHaraikomiAfterKurisho_Nen">年</label>
									<parts:select path="drpID_Date_FirstHaraikomiAfterKurisho_Tsuki" id="drpID_Date_FirstHaraikomiAfterKurisho_Tsuki" style="color:#003399;" tabindex="1">
										<parts:codeListOption categoryCode="00003" />
									</parts:select>
									<label id="lblDateFirstHaraikomiAfterKurisho_Tsuki">月</label>
									<parts:select path="drpID_Date_FirstHaraikomiAfterKurisho_Bi" id="drpID_Date_FirstHaraikomiAfterKurisho_Bi" style="color:#003399;" tabindex="1">
										<parts:codeListOption categoryCode="00004" />
									</parts:select>
									<label id="lblDateFirstHaraikomiAfterKurisho_Bi">日</label>
								</div>
							</div>
							<!-- 入力用 -->
							<div class="item-input">
								<div><!-- 項目名 --> 入金日</div>
								<div><!-- 値 -->
									<parts:select path="drpID_Date_Nyukin_Gengo" id="drpID_Date_Nyukin_Gengo" style="color:#003399;" tabindex="1"
										onchange='change_dateNyukin(
											"${cr004_04Form.lblID_JtkshoriConfigMode}",
											"${cr004_04Form.lblID_BizDate_Gengo}",
											"${cr004_04Form.lblID_BizDate_Nen}",
											"${cr004_04Form.lblID_BizDate_Tsuki}",
											"${cr004_04Form.lblID_BizDate_PrevMonth_Gengo}",
											"${cr004_04Form.lblID_BizDate_PrevMonth_Nen}",
											"${cr004_04Form.lblID_BizDate_PrevMonth_Tsuki}")'>
										<parts:codeListOption categoryCode="00002" />
									</parts:select>
									<parts:text path="txtID_Date_Nyukin_Nen" id="txtID_Date_Nyukin_Nen" style="width:30px;text-align:center;" maxlength="2" tabindex="1" value="" size="2"
										onkeyup='change_dateNyukin(
											"${cr004_04Form.lblID_JtkshoriConfigMode}",
											"${cr004_04Form.lblID_BizDate_Gengo}",
											"${cr004_04Form.lblID_BizDate_Nen}",
											"${cr004_04Form.lblID_BizDate_Tsuki}",
											"${cr004_04Form.lblID_BizDate_PrevMonth_Gengo}",
											"${cr004_04Form.lblID_BizDate_PrevMonth_Nen}",
											"${cr004_04Form.lblID_BizDate_PrevMonth_Tsuki}")' />
									<label id="lblDateNyukin_Nen">年</label>
									<parts:select path="drpID_Date_Nyukin_Tsuki" id="drpID_Date_Nyukin_Tsuki" style="color:#003399;" tabindex="1"
										onchange='change_dateNyukin(
											"${cr004_04Form.lblID_JtkshoriConfigMode}",
											"${cr004_04Form.lblID_BizDate_Gengo}",
											"${cr004_04Form.lblID_BizDate_Nen}",
											"${cr004_04Form.lblID_BizDate_Tsuki}",
											"${cr004_04Form.lblID_BizDate_PrevMonth_Gengo}",
											"${cr004_04Form.lblID_BizDate_PrevMonth_Nen}",
											"${cr004_04Form.lblID_BizDate_PrevMonth_Tsuki}")'>
										<parts:codeListOption categoryCode="00003" />
									</parts:select>
									<label id="lblDateNyukin_Tsuki">月</label>
									<parts:select path="drpID_Date_Nyukin_Bi" id="drpID_Date_Nyukin_Bi" style="color:#003399;" tabindex="1"
										onchange='change_dateNyukin(
											"${cr004_04Form.lblID_JtkshoriConfigMode}",
											"${cr004_04Form.lblID_BizDate_Gengo}",
											"${cr004_04Form.lblID_BizDate_Nen}",
											"${cr004_04Form.lblID_BizDate_Tsuki}",
											"${cr004_04Form.lblID_BizDate_PrevMonth_Gengo}",
											"${cr004_04Form.lblID_BizDate_PrevMonth_Nen}",
											"${cr004_04Form.lblID_BizDate_PrevMonth_Tsuki}")'>
										<parts:codeListOption categoryCode="00004" />
									</parts:select>
									<label id="lblDateNyukin_Bi">日</label>
								</div>
							</div>
							<!-- 入力用 -->
							<div class="item-input">
								<div><!-- 項目名 --> 繰償事由コード</div>
								<div><!-- 値 -->
									<parts:select path="drpID_Code_Kurishojiyu" id="drpID_Code_Kurishojiyu" style="color:#003399;" tabindex="1">
										<parts:options items="${cr004_04Form.ID_Code_Kurishojiyu_List}" />
									</parts:select>
								</div>
							</div>

						</div>
						<!-- 報告書の一行分(複数可) -->
						<div class="report_a_line">
							<!-- 入力用 -->
							<div class="item-input">
								<div><!-- 項目名 --> 利息(円)</div>
								<div><!-- 値 -->
									<parts:text path="txtID_M_KurishoRisoku" cssClass="format-number" id="txtID_M_KurishoRisoku" style="text-align: right;" maxlength="11" size="15" tabindex="1" />
								</div>
							</div>
							<!-- 入力用 -->
							<div class="item-input">
								<div>元金(円)</div>
								<div>
									<parts:text path="txtID_M_KurishoGankin" cssClass="format-number" id="txtID_M_KurishoGankin" style="text-align: right;" maxlength="11" size="15" tabindex="1" />
								</div>
							</div>
							<!-- 入力用 -->
							<div class="item-input">
								<div><!-- 項目名 --> 控除利息(円)</div>
								<div><!-- 値 -->
									<parts:text path="txtID_M_KojoRisoku" cssClass="format-number" id="txtID_M_KojoRisoku" style="text-align: right;" maxlength="11" size="15" tabindex="1" />
								</div>
							</div>
							<!-- 入力用 -->
							<div class="item-input">
								<div>繰上償還手数料(円)</div>
								<div>
									<parts:text path="txtID_M_KurishoCommision" cssClass="format-number" id="txtID_M_KurishoCommision" style="text-align: right;" maxlength="11" size="15" tabindex="1" />
								</div>
							</div>
						</div>
						<!-- 報告書の一行分(複数可) -->
						<div class="report_a_line">
							<!-- 入力用 -->
							<div class="item-input">
								<div>仮受金からの充当額(円)</div>
								<div>
									<parts:text path="txtID_M_KariukeIppanJuto" cssClass="format-number" id="txtID_M_KariukeIppanJuto" style="text-align: right;" maxlength="11" size="15" tabindex="1"
										onkeyup='change_dateNyukin(
											"${cr004_04Form.lblID_JtkshoriConfigMode}",
											"${cr004_04Form.lblID_BizDate_Gengo}",
											"${cr004_04Form.lblID_BizDate_Nen}",
											"${cr004_04Form.lblID_BizDate_Tsuki}",
											"${cr004_04Form.lblID_BizDate_PrevMonth_Gengo}",
											"${cr004_04Form.lblID_BizDate_PrevMonth_Nen}",
											"${cr004_04Form.lblID_BizDate_PrevMonth_Tsuki}")'/>
								</div>
							</div>
							<!-- 出力用 -->
							<div class="item-output" style="width: 135px;">
								<div><!-- 項目名 --> 送金額(円)</div>
								<div class="styleMoney" style="margin-right: 4px;"><!-- 値 -->
									<parts:text path="txtID_M_Sokin" id="txtID_M_Sokin" cssClass="format-number" style="text-align: right;" maxlength="11" size="15" tabindex="-1" readonly="true" />
								</div>
							</div>
							<!-- 出力用 -->
							<div class="item-output" style="width: 135px;">
								<div><!-- 項目名 --> 繰償後残元金(円)</div>
								<div class="styleMoney" style="margin-right: 4px;"><!-- 値 -->
									<parts:text path="txtID_M_ZanGankinAfterKurisho" cssClass="format-number" style="text-align: right;" id="txtID_M_ZanGankinAfterKurisho" maxlength="11" size="15" tabindex="-1" readonly="true" />
								</div>
							</div>
						</div>
						<!-- 報告書の一行分(複数可) -->
						<div class="report_a_line">
							<!-- 入力用 -->
							<div class="item-input">
								<div><!-- 項目名 --> 受託者勘定処理年月</div>
								<div><!-- 値 -->
									<parts:select path="drpID_Date_JtkShori_Gengo" id="drpID_Date_JtkShori_Gengo" style="color:#003399;" tabindex="1"
										onchange="setHdnJtkshori()">
<%-- [UPD] Ver 3.0.0 - START --%>
<%--									<parts:option value="S">S</parts:option> --%>
<%--									<parts:option value="H">H</parts:option> --%>
										<parts:codeListOption categoryCode="00002" />
<%-- [UPD] Ver 3.0.0 - END --%>
									</parts:select>
									<parts:hidden path="hdnID_Date_Jtkshori_Gengo" id="hdnID_Date_Jtkshori_Gengo" value=""></parts:hidden>
									<c:if test='${cr004_04Form.lblID_JtkshoriConfigMode == "3"}'>
										<parts:text path="txtID_Date_JtkShori_Nen" id="txtID_Date_JtkShori_Nen"
											 style="width:30px;text-align:center;" maxlength="2" tabindex="1" value="" size="2" />
									</c:if>
									<c:if test='${cr004_04Form.lblID_JtkshoriConfigMode != "3"}'>
										<parts:text path="txtID_Date_JtkShori_Nen" id="txtID_Date_JtkShori_Nen"
											style="width:30px;text-align:center;" maxlength="2" tabindex="-1" value="" size="2"/>
									</c:if>
									<label id="lblDateJtkShori_Nen">年</label>
									<parts:select path="drpID_Date_JtkShori_Tsuki" id="drpID_Date_JtkShori_Tsuki" style="color:#003399;" tabindex="1"
										onchange="setHdnJtkshori()">
										<parts:codeListOption categoryCode="00003" />
									</parts:select>
									<label id="lblDateJtkShori_Tsuki">月</label>
									<parts:hidden path="hdnID_Date_JtkshoriTsuki_Candidate" id="hdnID_Date_JtkshoriTsuki_Candidate" value=""></parts:hidden>
								</div>
							</div>


							<!-- 入力用 -->
							<div class="item-input">
								<div><!-- 項目名 --> 送金日</div>
								<div><!-- 値 -->
									<parts:select path="drpID_Date_Sokin_Gengo" id="drpID_Date_Sokin_Gengo" style="color:#003399;" tabindex="1">
										<parts:option value=""></parts:option>
										<parts:codeListOption categoryCode="00002" />
									</parts:select>
									<parts:text path="txtID_Date_Sokin_Nen" id="txtID_Date_Sokin_Nen" style="width:30px;text-align:center;" maxlength="2" tabindex="1" value="" size="2" />
									<label id="lblDateSokin_Nen">年</label>
									<parts:select path="drpID_Date_Sokin_Tsuki" id="drpID_Date_Sokin_Tsuki" style="color:#003399;" tabindex="1">
										<parts:codeListOption categoryCode="00003" />
									</parts:select>
									<label id="lblDateSokin_Tsuki">月</label>
									<parts:select path="drpID_Date_Sokin_Bi" id="drpID_Date_Sokin_Bi" style="color:#003399;" tabindex="1">
										<parts:codeListOption categoryCode="00004" />
									</parts:select>
									<label id="lblDateSokin_Bi">日</label>
								</div>
							</div>
							<!-- 入力用 -->
							<div class="item-input">
								<div><!-- 項目名 --> 送金日番号</div>
								<div><!-- 値 -->
									<parts:text path="txtID_ID_Sokinbi" id="txtID_ID_Sokinbi" style="text-align: right;" maxlength="3" size="3" tabindex="1" />
								</div>
							</div>
							<!-- 入力用 -->
							<div class="item-input">
								<div>&nbsp;</div>
								<div><!-- 項目名 -->
									<span>
										<parts:checkbox path="chkID_ID_After_Daiibensai" id="chkID_ID_After_Daiibensai" style="text-align: right;" name="chkID_ID_After_Daiibensai" tabindex="1" value="1" ></parts:checkbox>
										<label id="chkID_ID_After_Daiibensai">代弁履行後の作成</label>
									</span>
								</div>
							</div>
						</div>
						<!-- 報告書の一行分(複数可) -->
						<div class="report_a_line" >
							<div class="teikishokan">
								<fieldset id="teiki" style="width:350px;"><legend style="font-size: 9pt; color: #0066ff;" align="left">◆定期償還の場合</legend>
									<!-- 入力用 -->
									<div class="item-input">
										<parts:table>
											<tr>
												<td>払込期日</td>
												<td>払込元金(円)</td>
											</tr>
											<tr>
												<td>
													<!-- 払込期日１ -->
													<parts:select path="drpID_Date_Haraikomi1_Gengo" id="drpID_Date_Haraikomi1_Gengo" style="color:#003399;" tabindex="1">
														<parts:option value=""></parts:option>
														<parts:codeListOption categoryCode="00002" />
													</parts:select>
													<parts:text path="txtID_Date_Haraikomi1_Nen" id="txtID_Date_Haraikomi1_Nen" style="width:30px;text-align:center;" maxlength="2" tabindex="2" value="" size="2" />
													<label id="lblDateHaraikomi1_Nen">年</label>
													<parts:select path="drpID_Date_Haraikomi1_Tsuki" id="drpID_Date_Haraikomi1_Tsuki" style="color:#003399;" tabindex="3">
														<parts:codeListOption categoryCode="00003" />
													</parts:select>
													<label id="lblDateHaraikomi1_Tsuki">月</label>
													<parts:select path="drpID_Date_Haraikomi1_Bi" id="drpID_Date_Haraikomi1_Bi" style="color:#003399;" tabindex="4">
														<parts:codeListOption categoryCode="00004" />
													</parts:select>
													<label id="lblDateHaraikomi1_Bi">日</label><br />
													<!-- 払込期日２ -->
													<parts:select path="drpID_Date_Haraikomi2_Gengo" id="drpID_Date_Haraikomi2_Gengo" style="color:#003399;" tabindex="6">
														<parts:option value=""></parts:option>
														<parts:codeListOption categoryCode="00002" />
													</parts:select>
													<parts:text path="txtID_Date_Haraikomi2_Nen" id="txtID_Date_Haraikomi2_Nen" style="width:30px;text-align:center;" maxlength="2" tabindex="7" value="" size="2" />
													<label id="lblDateHaraikomi2_Nen">年</label>
													<parts:select path="drpID_Date_Haraikomi2_Tsuki" id="drpID_Date_Haraikomi2_Tsuki" style="color:#003399;" tabindex="8">
														<parts:codeListOption categoryCode="00003" />
													</parts:select>
													<label id="lblDateHaraikomi2_Tsuki">月</label>
													<parts:select path="drpID_Date_Haraikomi2_Bi" id="drpID_Date_Haraikomi2_Bi" style="color:#003399;" tabindex="9">
														<parts:codeListOption categoryCode="00004" />
													</parts:select>
													<label id="lblDateHaraikomi2_Bi">日</label><br />
													<!-- 払込期日３ -->
													<parts:select path="drpID_Date_Haraikomi3_Gengo" id="drpID_Date_Haraikomi3_Gengo" style="color:#003399;" tabindex="11">
														<parts:option value=""></parts:option>
														<parts:codeListOption categoryCode="00002" />
													</parts:select>
													<parts:text path="txtID_Date_Haraikomi3_Nen" id="txtID_Date_Haraikomi3_Nen" style="width:30px;text-align:center;" maxlength="2" tabindex="12" value="" size="2" />
													<label id="lblDateHaraikomi3_Nen">年</label>
													<parts:select path="drpID_Date_Haraikomi3_Tsuki" id="drpID_Date_Haraikomi3_Tsuki" style="color:#003399;" tabindex="13">
														<parts:codeListOption categoryCode="00003" />
													</parts:select>
													<label id="lblDateHaraikomi3_Tsuki">月</label>
													<parts:select path="drpID_Date_Haraikomi3_Bi" id="drpID_Date_Haraikomi3_Bi" style="color:#003399;" tabindex="14">
														<parts:codeListOption categoryCode="00004" />
													</parts:select>
													<label id="lblDateHaraikomi3_Bi">日</label><br />
													<!-- 払込期日４ -->
													<parts:select path="drpID_Date_Haraikomi4_Gengo" id="drpID_Date_Haraikomi4_Gengo" style="color:#003399;" tabindex="16">
														<parts:option value=""></parts:option>
														<parts:codeListOption categoryCode="00002" />
													</parts:select>
													<parts:text path="txtID_Date_Haraikomi4_Nen" id="txtID_Date_Haraikomi4_Nen" style="width:30px;text-align:center;" maxlength="2" tabindex="17" value="" size="2" />
													<label id="lblDateHaraikomi4_Nen">年</label>
													<parts:select path="drpID_Date_Haraikomi4_Tsuki" id="drpID_Date_Haraikomi4_Tsuki" style="color:#003399;" tabindex="18">
														<parts:codeListOption categoryCode="00003" />
													</parts:select>
													<label id="lblDateHaraikomi4_Tsuki">月</label>
													<parts:select path="drpID_Date_Haraikomi4_Bi" id="drpID_Date_Haraikomi4_Bi" style="color:#003399;" tabindex="19">
														<parts:codeListOption categoryCode="00004" />
													</parts:select>
													<label id="lblDateHaraikomi4_Bi">日</label>
												</td>
												<td>
													<!-- 払込元金１〜４ -->
													<parts:text path="txtID_M_HaraikomiGankin1" cssClass="format-number" id="txtID_M_HaraikomiGankin1" style="text-align: right;" maxlength="11" size="15" tabindex="5" /><br />
													<parts:text path="txtID_M_HaraikomiGankin2" cssClass="format-number" id="txtID_M_HaraikomiGankin2" style="text-align: right;" maxlength="11" size="15" tabindex="10" /><br />
													<parts:text path="txtID_M_HaraikomiGankin3" cssClass="format-number" id="txtID_M_HaraikomiGankin3" style="text-align: right;" maxlength="11" size="15" tabindex="15" /><br />
													<parts:text path="txtID_M_HaraikomiGankin4" cssClass="format-number" id="txtID_M_HaraikomiGankin4" style="text-align: right;" maxlength="11" size="15" tabindex="20" />
												</td>
											</tr>
										</parts:table>
									</div>
								</fieldset>
							</div>
							<div>
								<fieldset id="gankin"><legend style="font-size: 9pt; color: #0066ff;" align="left">◆元金均等償還・期限固定の場合</legend>
									<!-- 入力用 -->
									<div class="item-input">
										<div><!-- 項目名 --> 繰償後元金均等額(円)</div>
										<div><!-- 値 -->
											<parts:text path="txtID_M_GankinKintoAfterKurisho" cssClass="format-number" style="text-align: right;" id="txtID_M_GankinKintoAfterKurisho" maxlength="11" size="15" tabindex="20" />
										</div>
									</div>
									<!-- 入力用 -->
									<div class="item-input">
										<div><!-- 項目名 --> 繰償後元金不均等額(円)</div>
										<div><!-- 値 -->
											<parts:text path="txtID_M_GankinFukintoAfterKurisho" cssClass="format-number" style="text-align: right;" id="txtID_M_GankinFukintoAfterKurisho" maxlength="11" size="15" tabindex="20" />
										</div>
									</div>
									<div class="item-clear">
										<!-- 入力用 -->
										<div class="item-input" style="height: 60px">
											調整コード<br/>
											<div style="margin-top: 10px;">
											<span id="rdoID_Code_chosei" TabIndex="20">
												<span>
													<parts:radioButton path="rdoID_Code_chosei" id="rdoID_Code_chosei_0" value="1" name="rdoID_Code_chosei" />
													<label for="rdoID_Code_chosei" >初回</label>
												</span>
												<span>
													<parts:radioButton path="rdoID_Code_chosei" id="rdoID_Code_chosei_1" value="2" name="rdoID_Code_chosei" />
													<label for="rdoID_Code_chosei" >最終回</label>
												</span>
												<span>
													<parts:radioButton path="rdoID_Code_chosei" id="rdoID_Code_chosei" value="" name="rdoID_Code_chosei" />
													<label for="rdoID_Code_chosei" >なし</label>
												</span>

											</span>
											</div>
										</div>
									</div>
								</fieldset>
							</div >

						</div>

					</div> <!-- 報告書一枚終わり -->
				</div>


				</td></parts:tr>
				</parts:table>
			</div>
			</div>
		</div>
		</parts:form><%@ include file="/jsp/incFooter.jsp"%>
	</body>
</html>