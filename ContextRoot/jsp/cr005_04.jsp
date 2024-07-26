
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/jsp/incTop.jsp"%>
<%@ taglib prefix="pn" uri="http://partnernet.jfc.go.jp/tags/pn"%>
<%@ page import="jp.go.jfc.partnernet.common.PNCommonConstants" %>


<%--================================================================================================
 * Project Name : パートナーネット開発
 * System Name  : パートナーネット
 * File Name    : cr005_04.jsp
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
	<script lang="JavaScript">
		<%--
		- 送信ボタン押下時の処理
		--%>
		function click_SendBtn() {
			executeAction('../../cr005/cr005_04/Cr005_04Send.form');
		}

		<%--
		- 戻るボタン押下時の処理
		--%>
		function click_backBtn() {
			executeAction('../../cr005/cr005_04/Cr005_04Back.form');
		}

		<%--
		- 代弁金払込日変更時の処理
		--%>
		function change_DaibenkinHaraikomi(JtkshoriConfigMode, bizDateGengo,
			bizDateNen, bizDateTsuki, bizDatePrevMonthGengo, bizDatePrevMonthNen, bizDatePrevMonthTsuki) {

			<%-- 代弁金払込日 取得 --%>
			daibenkinHaraikomiGengo = document.getElementById('drpID_Date_DaibenkinHaraikomiGengou').value;
			daibenkinHaraikomiNen = document.getElementById('txtID_Date_DaibenkinHaraikomiYear').value;
			daibenkinHaraikomiTsuki = document.getElementById('drpID_Date_DaibenkinHaraikomiMonth').value;

			<%-- 仮受金(一般口)からの充当額(円) 取得 --%>
			kariukeIppanJuto = document.getElementById('txtID_M_KariukeIppanJuto').value;

			<%-- 日付形式チェック --%>
			if ( !chkDate( daibenkinHaraikomiNen, daibenkinHaraikomiTsuki) ) {
				return;
			}

			<%-- 和暦→西暦変換 --%>
			daibenkinHaraikomiYYYY = warekiToSeireki( daibenkinHaraikomiGengo, daibenkinHaraikomiNen)
			bizDateYYYY = warekiToSeireki( bizDateGengo, bizDateNen)

			<%-- 月差分計算 ： 業務日付 - 代弁金払込日 --%>
			dm = diffMonth( bizDateYYYY, bizDateTsuki, daibenkinHaraikomiYYYY, daibenkinHaraikomiTsuki);

			<%-- 受託者勘定処理年月設定 --%>
			<%-- 仮受金（一般口）からの充当額（円）が 0 または ブランク --%>
			if ( kariukeIppanJuto == 0 || kariukeIppanJuto.length == 0 ) {

				if ( JtkshoriConfigMode == <%=PNCommonConstants.JTKSHORI_CONFIGMODE_1%>
					 || JtkshoriConfigMode == <%=PNCommonConstants.JTKSHORI_CONFIGMODE_3%>) {
					<%-- 受託者勘定処理年月設定モードが 1（決算期かつ第1～4営業日）または --%>
					<%-- 受託者勘定処理年月設定モードが 3（通常期かつ第1～10営業日）の場合 --%>
					if ( 2 <= dm ) {
						<%-- 代弁金払込日が業務日付の前々月以前の場合 --%>
						<%-- 業務日付の前月を設定 --%>
						setDateJtkshori( bizDatePrevMonthGengo, bizDatePrevMonthNen, bizDatePrevMonthTsuki);

					}
					else {

						<%-- 上記以外 代弁金払込日 を設定 --%>
						setDateJtkshori( daibenkinHaraikomiGengo, daibenkinHaraikomiNen, daibenkinHaraikomiTsuki);

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
			jtkGengo = document.getElementById('drpID_Date_JtkshoriGengou');
			jtkNen = document.getElementById('txtID_Date_JtkshoriYear');
			jtkTsuki = document.getElementById('drpID_Date_JtkshoriMonth');

			hdnJtkGengo = document.getElementById('hdnID_Date_JtkshoriGengou');
			hdnJtkTsuki = document.getElementById('hdnID_Date_JtkshoriMonth');

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
			jtkGengo = document.getElementById('drpID_Date_JtkshoriGengou').value;
			jtkTsuki = document.getElementById('drpID_Date_JtkshoriMonth').value;

			document.getElementById('hdnID_Date_JtkshoriGengou').value = jtkGengo;
			document.getElementById('hdnID_Date_JtkshoriMonth').value = jtkTsuki;

		}
	</script>


	<link href="<%=request.getContextPath()%>/css/cr005.css" type="text/css" rel="stylesheet" />

	</head>
	<body onload="initTextFormat()">
		<parts:form modelAttribute="cr005_04Form" id="Form1" method="post" onsubmit="return false;">
			<%@ include file="/jsp/incCommonHidden.jsp" %>
			<%@ include file="/jsp/incHeaderArea.jsp" %>
			<div id="main_scroll_area">
			<div class="header">
				<div class="title">
					<span class="Title" id="lblTitle"><parts:message code="title.screenName"/></span>
				</div>
			</div>
			<div class="help">
				<a href="#" onclick="openNewWindow('<%= request.getContextPath() %>/help/main_cr005.html', false, false, false, 'width=800', 'height=500', false)">
					<font class="help">ヘルプ</font>
				</a>
			</div>
			<div class="main">
				<div class="greeting">
					必要な項目を入力したうえで「送信」ボタンを押してください。
				</div>
				<div class="buttons">
					<parts:button id="btnID_Send" value="送信" title="送信" onclick="clearTextFormat();click_SendBtn()"/>
					<parts:button id="btnBack" value="戻る" title="戻る" onclick="click_backBtn()"/>
				</div>
				<div class="reportDate">報告年月日：
					<fmt:parseDate value="${cr005_04Form.txtID_Date_Report}"
						var="txtID_Date_Report" pattern="yyyyMMdd" />
					<fmt:formatDate value="${txtID_Date_Report}"
						pattern="yyyy年MM月dd日(E)" />
				</div>
				<div class="status">
					ステータス：<br />
					<div style="color:red;font-weight:bold;">
						<span class="lblError">
							<parts:errors path="*" />
						</span>
						<parts:dlabel path="lblMessage" />
					</div>
				</div>
				<parts:dlabel path="lblID_ID_Credit_Display" />
				<span style="display:none;">
				<parts:text path="ID_ID_Credit" id="ID_ID_Credit" maxlength="8" size="8" />
				<parts:text path="ID_M_KashitsukeZandaka" id="ID_M_KashitsukeZandaka" maxlength="11" size="11" />
				<parts:text path="ID_Date_ShokanKigen" id="ID_Date_ShokanKigen" maxlength="8" size="8" />
				<parts:text path="ID_Data_LastUpDate" id="ID_Data_LastUpDate" maxlength="8" size="8" />
				<parts:text path="ID_M_YakujoRisoku" id="ID_M_YakujoRisoku" maxlength="11" size="11" />
				<parts:text path="ID_M_YakujoGankin" id="ID_M_YakujoGankin" maxlength="11" size="11" />
				</span>
				<div></div>
				<logic:equal path="report1" value="1">

				<div class="report" style="width: 750px;">
					<!-- 報告書の一行分(複数可) -->
					<div class="report_a_line">
						<!-- 出力用 -->
						<div class="item-output-cust">
							<div><!-- 項目名 --> 顧客名：</div>
							<div><!-- 値 -->
								<parts:text path="txtID_Name_Customer" id="txtID_Name_Customer" style="text-align: left;" maxlength="40" size="50" tabindex="-1" readonly="true" /></div>
						</div>
						<!-- 出力用 -->
						<div class="item-output-org">
							<div><!-- 項目名 --> 扱店：</div>
							<div><!-- 値 -->
								<parts:text path="txtID_Name_Organization" id="txtID_Name_Organization" style="text-align: left;" maxlength="40" size="50" tabindex="-1" readonly="true" /></div>
						</div>
					</div>
					<!-- 報告書の一行分(複数可) -->
					<div class="report_a_line">
						<!-- 出力用 -->
						<div class="item-output">
							<div><!-- 項目名 --> 公庫支店</div>
							<div><!-- 値 -->
								<parts:text path="txtID_Code_ShokanHonShiten" id="txtID_Code_ShokanHonShiten" style="text-align: center;" maxlength="2" size="2" tabindex="-1" readonly="true" /></div>
						</div>
						<!-- 出力用 -->
						<div class="item-output">
							<div><!-- 項目名 --> 扱店</div>
							<div><!-- 値 -->
								<parts:text path="txtID_Code_Organization" id="txtID_Code_Organization" style="text-align: center;" maxlength="4" size="4" tabindex="-1" readonly="true" /></div>
						</div>
						<!-- 出力用 -->
						<div class="item-output">
							<div><!-- 項目名 --> 店舗</div>
							<div><!-- 値 -->
								<parts:text path="txtID_Code_Tenpo" id="txtID_Code_Tenpo" style="text-align: center;" maxlength="3" size="3" tabindex="-1" readonly="true" /></div>
						</div>
						<!-- 出力用 -->
						<div class="item-output">
							<div><!-- 項目名 --> 年度</div>
							<div><!-- 値 -->
								<input type= "text" class="protect" style="text-align: center;" maxlength="4" size="4" tabindex="-1" readonly value="<pn:printWareki date='${cr005_04Form.txtID_Year}' pattern='GY'/>"/></div>
						</div>
						<!-- 出力用 -->
						<div class="item-output">
							<div><!-- 項目名 --> 方式資金</div>
							<div><!-- 値 -->
								<parts:text path="txtID_Code_HoshikiShikin" id="txtID_Code_HoshikiShikin" style="text-align: center;" maxlength="2" size="2" tabindex="-1" readonly="true" /></div>
						</div>
						<!-- 出力用 -->
						<div class="item-output">
							<div><!-- 項目名 --> 番号</div>
							<div><!-- 値 -->
								<parts:text path="txtID_ID_Ringi" id="txtID_ID_Ringi" style="text-align: center;" maxlength="5" size="5" tabindex="-1" readonly="true" /></div>
						</div>
						<!-- 出力用 -->
						<div class="item-output">
							<div><!-- 項目名 --> 枝番</div>
							<div><!-- 値 -->
								<parts:text path="txtID_ID_RingiBranch" id="txtID_ID_RingiBranch" style="text-align: center;" maxlength="3" size="3" tabindex="-1" readonly="true" /></div>
						</div>
					</div>
					<!-- 報告書の一行分(複数可) -->
					<div class="report_a_line">
						<!-- 出力用 -->
						<div class="item-input">
							<div><!-- 項目名 --> 充当対象払込期日</div>
							<div><!-- 値 -->
								<parts:select path="drpID_Date_JutoTaishoGengou" id="drpID_Date_JutoTaishoGengou">
									<parts:codeListOption categoryCode='00002'/>
								</parts:select>
								<parts:text path="txtID_Date_JutoTaishoYear" id="txtID_Date_JutoTaishoYear" style="width:30px;text-align: center;" maxlength="2" size="2" />年
								<parts:select path="drpID_Date_JutoTaishoMonth" id="drpID_Date_JutoTaishoMonth">
									<parts:codeListOption categoryCode="00003" />
								</parts:select>月
								<parts:select path="drpID_Date_JutoTaishoDay" id="drpID_Date_JutoTaishoDay">
									<parts:codeListOption categoryCode="00004" />
								</parts:select>日
							</div>
						</div>
						<!-- 出力用 -->
						<div class="item-input">
							<div><!-- 項目名 --> 代弁金払込日</div>
							<div><!-- 値 -->
								<parts:select path="drpID_Date_DaibenkinHaraikomiGengou" id="drpID_Date_DaibenkinHaraikomiGengou"
									onchange='change_DaibenkinHaraikomi(
										"${cr005_04Form.lblID_JtkshoriConfigMode}",
										"${cr005_04Form.lblID_BizDate_Gengo}",
										"${cr005_04Form.lblID_BizDate_Nen}",
										"${cr005_04Form.lblID_BizDate_Tsuki}",
										"${cr005_04Form.lblID_BizDate_PrevMonth_Gengo}",
										"${cr005_04Form.lblID_BizDate_PrevMonth_Nen}",
										"${cr005_04Form.lblID_BizDate_PrevMonth_Tsuki}")'>
									<parts:codeListOption categoryCode='00002'/>
								</parts:select>
								<parts:text path="txtID_Date_DaibenkinHaraikomiYear" id="txtID_Date_DaibenkinHaraikomiYear" style="width:30px;text-align: center;" maxlength="2" size="2"
									onkeyup='change_DaibenkinHaraikomi(
										"${cr005_04Form.lblID_JtkshoriConfigMode}",
										"${cr005_04Form.lblID_BizDate_Gengo}",
										"${cr005_04Form.lblID_BizDate_Nen}",
										"${cr005_04Form.lblID_BizDate_Tsuki}",
										"${cr005_04Form.lblID_BizDate_PrevMonth_Gengo}",
										"${cr005_04Form.lblID_BizDate_PrevMonth_Nen}",
										"${cr005_04Form.lblID_BizDate_PrevMonth_Tsuki}")' />年
								<parts:select path="drpID_Date_DaibenkinHaraikomiMonth" id="drpID_Date_DaibenkinHaraikomiMonth"
									onchange='change_DaibenkinHaraikomi(
										"${cr005_04Form.lblID_JtkshoriConfigMode}",
										"${cr005_04Form.lblID_BizDate_Gengo}",
										"${cr005_04Form.lblID_BizDate_Nen}",
										"${cr005_04Form.lblID_BizDate_Tsuki}",
										"${cr005_04Form.lblID_BizDate_PrevMonth_Gengo}",
										"${cr005_04Form.lblID_BizDate_PrevMonth_Nen}",
										"${cr005_04Form.lblID_BizDate_PrevMonth_Tsuki}")'>
									<parts:codeListOption categoryCode="00003" />
								</parts:select>月
								<parts:select path="drpID_Date_DaibenkinHaraikomiDay" id="drpID_Date_DaibenkinHaraikomiDay"
									onchange='change_DaibenkinHaraikomi(
										"${cr005_04Form.lblID_JtkshoriConfigMode}",
										"${cr005_04Form.lblID_BizDate_Gengo}",
										"${cr005_04Form.lblID_BizDate_Nen}",
										"${cr005_04Form.lblID_BizDate_Tsuki}",
										"${cr005_04Form.lblID_BizDate_PrevMonth_Gengo}",
										"${cr005_04Form.lblID_BizDate_PrevMonth_Nen}",
										"${cr005_04Form.lblID_BizDate_PrevMonth_Tsuki}")'>
									<parts:codeListOption categoryCode="00004" />
								</parts:select>日
							</div>
						</div>
						<!-- 出力用 -->
						<div class="item-input">
							<div><!-- 項目名 --> 遅延損害金(円)</div>
							<div><!-- 値 -->
								<parts:text path="txtID_M_ChienSongai" cssClass="format-number" id="txtID_M_ChienSongai" style="text-align: right;" maxlength="11" size="15" /></div>
						</div>
						<!-- 出力用 -->
						<div class="item-input">
							<div><!-- 項目名 --> 利息(円)</div>
							<div><!-- 値 -->
								<parts:text path="txtID_M_Risoku" cssClass="format-number" id="txtID_M_Risoku" style="text-align: right;" maxlength="11" size="15" /></div>
						</div>
					</div>
					<!-- 報告書の一行分(複数可) -->
					<div class="report_a_line">
						<!-- 出力用 -->
						<div class="item-input">
							<div><!-- 項目名 --> 繰上償還手数料(円)</div>
							<div><!-- 値 -->
								<parts:text path="txtID_M_KurishoCommission" cssClass="format-number" id="txtID_M_KurishoCommission" style="text-align: right;" maxlength="11" size="15" /></div>
						</div>
						<!-- 出力用 -->
						<div class="item-input">
							<div>元金(円)</div>
							<div>
								<parts:text path="txtID_M_Gankin" cssClass="format-number" id="txtID_M_Gankin" style="text-align: right;" maxlength="11" size="15" /></div>
						</div>
						<!-- 出力用 -->
						<div class="item-input">
							<div>仮受金(一般口)からの充当額(円)</div>
							<div>
								<parts:text path="txtID_M_KariukeIppanJuto" cssClass="format-number" id="txtID_M_KariukeIppanJuto" style="text-align: right;" maxlength="11" size="15"
									onkeyup='change_DaibenkinHaraikomi(
										"${cr005_04Form.lblID_JtkshoriConfigMode}",
										"${cr005_04Form.lblID_BizDate_Gengo}",
										"${cr005_04Form.lblID_BizDate_Nen}",
										"${cr005_04Form.lblID_BizDate_Tsuki}",
										"${cr005_04Form.lblID_BizDate_PrevMonth_Gengo}",
										"${cr005_04Form.lblID_BizDate_PrevMonth_Nen}",
										"${cr005_04Form.lblID_BizDate_PrevMonth_Tsuki}")'/>
							</div>
						</div>
					</div>
					<!-- 報告書の一行分(複数可) -->
					<div class="report_a_line">
						<!-- 出力用 -->
						<div class="item-output">
							<div><!-- 項目名 --> 計(円)</div>
							<div><!-- 値 -->
								<parts:text path="txtID_M_Kei" id="txtID_M_Kei" style="text-align: right;" maxlength="11" size="15" tabindex="-1" readonly="true" cssClass="format-number"/></div>
						</div>
						<!-- 出力用 -->
						<div class="item-output">
							<div><!-- 項目名 --> 送金額(円)</div>
							<div><!-- 値 -->
								<parts:text path="txtID_M_Sokin" id="txtID_M_Sokin" style="text-align: right;" maxlength="11" size="15" tabindex="-1" readonly="true" cssClass="format-number"/></div>
						</div>
						<!-- 出力用 -->
						<div class="item-output">
							<div>代弁金充当後残元金(円)</div>
							<div>
								<parts:text path="txtID_M_ZanGanAfterDaibenJuto" id="txtID_M_ZanGanAfterDaibenJuto" style="text-align: right;" maxlength="11" size="15" tabindex="-1" readonly="true" cssClass="format-number"/></div>
						</div>
					</div>
					<!-- 報告書の一行分(複数可) -->
					<div class="report_a_line">
						<!-- 出力用 -->
						<div class="item-input">
							<div><!-- 項目名 --> 受託者勘定処理年月</div>
							<div><!-- 値 -->
								<parts:select path="drpID_Date_JtkshoriGengou" id="drpID_Date_JtkshoriGengou"
								  onchange="setHdnJtkshori()">
									<parts:codeListOption categoryCode='00002'/>
								</parts:select>
								<parts:hidden path="hdnID_Date_JtkshoriGengou" id="hdnID_Date_JtkshoriGengou" value=""></parts:hidden>
								<c:if test='${cr005_04Form.lblID_JtkshoriConfigMode == "3"}'>
									<parts:text path="txtID_Date_JtkshoriYear" id="txtID_Date_JtkshoriYear"
									  style="width:30px;text-align: center;" maxlength="2" size="2" />年
								</c:if>
								<c:if test='${cr005_04Form.lblID_JtkshoriConfigMode != "3"}'>
									<parts:text path="txtID_Date_JtkshoriYear" id="txtID_Date_JtkshoriYear"
									  style="width:30px;text-align: center;" maxlength="2" size="2" tabindex="-1"/>年
								</c:if>
								<parts:select path="drpID_Date_JtkshoriMonth" id="drpID_Date_JtkshoriMonth"
								  onchange="setHdnJtkshori()">
									<parts:codeListOption categoryCode="00003" />
								</parts:select>月
								<parts:hidden path="hdnID_Date_JtkshoriMonth" id="hdnID_Date_JtkshoriMonth" value=""></parts:hidden>
							</div>
						</div>
						<!-- 出力用 -->
						<div class="item-input">
							<div><!-- 項目名 --> 送金年月日</div>
							<div><!-- 値 -->
								<parts:select path="drpID_Date_SokinGengou" id="drpID_Date_SokinGengou">
<%-- [UPD] Ver 3.0.0 - START --%>
<%-- 									<parts:option value="" /> --%>
<%-- 									<parts:option value="S">S</parts:option> --%>
<%-- 									<parts:option value="H">H</parts:option> --%>
										<parts:codeListOption categoryCode="00002" />
<%-- [UPD] Ver 3.0.0 - END --%>
								</parts:select>
								<parts:text path="txtID_Date_SokinYear" id="txtID_Date_SokinYear" style="width:30px;text-align: center;" maxlength="2" size="2" />年
								<parts:select path="drpID_Date_SokinMonth" id="drpID_Date_SokinMonth">
									<parts:codeListOption categoryCode="00003" />
								</parts:select>月
								<parts:select path="drpID_Date_SokinDay" id="drpID_Date_SokinDay">
									<parts:codeListOption categoryCode="00004" />
								</parts:select>日
							</div>
						</div>
						<!-- 出力用 -->
						<div class="item-input">
							<div><!-- 項目名 --> 送金日番号</div>
							<div><!-- 値 -->
								<parts:text path="txtID_Code_Sokin" id="txtID_Code_Sokin" style="text-align: center;" maxlength="3" size="6" /></div>
						</div>
					</div>
				</div> <!-- 報告書一枚終わり -->
				<br />
				</logic:equal>
				</div>
		</div>
		</parts:form><%@ include file="/jsp/incFooter.jsp"%>
	</body>
</html>