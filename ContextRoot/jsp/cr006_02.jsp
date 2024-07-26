
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/jsp/incTop.jsp"%>
<%@ taglib prefix="pn" uri="http://partnernet.jfc.go.jp/tags/pn"%>
<%@ page import="jp.go.jfc.partnernet.common.PNCommonConstants" %>

<%--================================================================================================
 * Project Name : パートナーネット開発
 * System Name  : パートナーネット
 * File Name    : cr006_02.jsp
 *
 * <<Modification History>>
 * Version | Date       | Updated By            | Content
 * --------+------------+-----------------------+---------------------------------------------------
 * 1.0.0   | 2015/07/01 | 橋本　亮　            | 新規作成
 * 2.0.0   | 2017/11/29 | 林　晃平              | 委託貸付報告等における機能改善対応
 * 3.0.0   | 2019/01/11 | 林　晃平              | 農林PN元号対応
================================================================================================--%>

<html>
	<%@ include file="/jsp/incHeader.jsp"%>
	<head>
		<title><parts:message code="title.screenName"/></title>

<script lang="JavaScript">
//<!--
                <%--
                - 送信ボタン押下時の処理
                --%>
                function click_send() {
                    executeAction('../../cr006/cr006_02/Cr006_02Send.form');
                }

                <%--
                - 戻るボタン押下時の処理
                --%>
                function click_back() {
                    executeAction('../../cr006/cr006_02/Cr006_02Back.form');
                }

                <%--
                - 入金日変更時の処理
                --%>
                function change_dateNyukin(JtkshoriConfigMode, bizDateGengo,
                        bizDateNen, bizDateTsuki, bizDatePrevMonthGengo, bizDatePrevMonthNen, bizDatePrevMonthTsuki) {

                    <%-- 入金日 取得 --%>
                    nyukinGengo = document.getElementById('drpID_Date_Nyukin_Gengou').value;
                    nyukinNen = document.getElementById('txtID_Date_Nyukin_Year').value;
                    nyukinTsuki = document.getElementById('drpID_Date_Nyukin_Month').value;

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

                            <%--  業務日付の前月を設定 --%>
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
                    jtkGengo = document.getElementById('drpID_Date_Jtkshori_Gengou');
                    jtkNen = document.getElementById('txtID_Date_Jtkshori_Year');
                    jtkTsuki = document.getElementById('drpID_Date_Jtkshori_Month');

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
                    jtkGengo = document.getElementById('drpID_Date_Jtkshori_Gengou').value;
                    jtkTsuki = document.getElementById('drpID_Date_Jtkshori_Month').value;

                    document.getElementById('hdnID_Date_Jtkshori_Gengo').value = jtkGengo;
                    document.getElementById('hdnID_Date_JtkshoriTsuki_Candidate').value = jtkTsuki;

                }

//-->
</script>

		<link href="<%=request.getContextPath()%>/css/cr006.css" type="text/css" rel="stylesheet" />
		<script language="JavaScript" type="text/javascript" src="<%= request.getContextPath() %>/js/ptncommon.js"></script>
	</head>
	<body onload="initTextFormat()">
		<parts:form id="Form1" modelAttribute="cr006_02Form" action="./Cr006_02Init.form" method="post" onsubmit="return false;">
			<%@ include file="/jsp/incCommonHidden.jsp" %>
			<%@ include file="/jsp/incHeaderArea.jsp" %>
			<div id="main_scroll_area">
			<div class="header">
				<div class="title">
					<span class="Title" id="lblTitle"><parts:message code="title.screenName"/></span>
				</div>
			</div>
			<div class="help">
				<a href="#" onclick="openNewWindow('<%= request.getContextPath() %>/help/main_cr006.html', false, false, false, 'width=800', 'height=500', false)">
					<font class="help">ヘルプ</font>
				</a>
			</div>
			<div class="main">
				<div class="greeting">
					必要な項目を入力したうえで「送信」ボタンを押してください。
				</div>
				<div class="buttons">
					<parts:button id="btnID_Send" value="送信" title="送信" onclick="clearTextFormat();click_send()"/>
					<parts:button id="btnBack" value="戻る" title="戻る" onclick="click_back()" />
				</div>
				<div class="reportDate">報告年月日：
					<parts:dlabel path="txtID_Date_Report" />
				</div>
				<div class="status">
					ステータス：<br />
					<div style="color:red;font-weight:bold;">
						<parts:errors path="*" cssClass="Error" />
					</div>
				</div>
				<parts:table id="pnl" cssStyle="border-style:none;">
					<parts:tr>
					<td>
						<parts:text path="Cr006_02_ID_ID_Credit" id="txtID_ID_Credit" maxlength="8" size="8" style="display: none;"/>
						<parts:text path="ID_Data_LastUpDate" id="txtID_Data_LastUpDate" maxlength="10" size="9" style="display: none;" />
						<parts:text path="ID_M_KaribaraiZanAfterSeisan" id="txtID_M_KaribaraiZanAfterSeisan" maxlength="14" size="11" style="display: none;" />
						<parts:text path="Cr006_02_ID_Code_KanjoKamoku" id="txtID_Code_TatekaeShurui_Code" maxlength="1" size="1" style="display: none;" />
						<parts:text path="ID_Code_HonShiten" id="txtID_Code_HonShiten" maxlength="2" size="2" style="display: none;" />
						<parts:text path="ID_ID_Karibarai" id="txtID_ID_Karibarai" maxlength="10" size="10" style="display: none;"/>
						<div></div>
						<div class="report" style="overflow:hidden; width:750px; ">
							<!-- 報告書の一行分(複数可) -->
							<div class="report_a_line">
								<!-- 出力用 -->
								<div class="item-output-cust" style="width: 350px;">
									<div><!-- 項目名 --> 顧客名：</div>
									<div><!-- 値 -->
										<parts:text path="txtID_Name_Customer" id="txtID_Name_Customer" style="text-align: left;" maxlength="40" size="50" tabindex="-1" readonly="true" /></div>
								</div>
								<!-- 出力用 -->
								<div class="item-output-org" style="width: 350px;">
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
										<parts:text path="txtID_Code_KoukoShiten" id="txtID_Code_KoukoShiten" style="text-align: center;" maxlength="2" size="6" tabindex="-1" readonly="true" /></div>
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
<!--
										<parts:text path="txtID_Year" id="txtID_Year" style="text-align: center;" maxlength="4" size="4" tabindex="-1" readonly="true" /></div>
-->
									  <input type= "text" class="protect" style="text-align: center;" maxlength="4" size="4" tabindex="-1" readonly value="<pn:printWareki date='${cr006_02Form.txtID_Year}' pattern='GY'/>"/></div>
								</div>
								<!-- 出力用 -->
								<div class="item-output">
									<div><!-- 項目名 --> 方式資金</div>
									<div><!-- 値 -->
										<parts:text path="txtID_Code_HoshikiShikin" id="txtID_Code_HoshikiShikin" style="text-align: center;" maxlength="2" size="6" tabindex="-1" readonly="true" /></div>
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
							<br><br><br>
							<!-- 報告書の一行分(複数可) -->
							<div class="report_a_line">
								<!-- 出力用 -->
								<div class="item-input">
									<div><!-- 項目名 --> 入金日</div>
									<div><!-- 値 -->
										<parts:select path="drpID_Date_Nyukin_Gengou" id="drpID_Date_Nyukin_Gengou"
											onchange='change_dateNyukin(
												"${cr006_02Form.lblID_JtkshoriConfigMode}",
												"${cr006_02Form.lblID_BizDate_Gengo}",
												"${cr006_02Form.lblID_BizDate_Nen}",
												"${cr006_02Form.lblID_BizDate_Tsuki}",
												"${cr006_02Form.lblID_BizDate_PrevMonth_Gengo}",
												"${cr006_02Form.lblID_BizDate_PrevMonth_Nen}",
												"${cr006_02Form.lblID_BizDate_PrevMonth_Tsuki}")'>
											<parts:codeListOption categoryCode="00002" />
										</parts:select>
										<parts:text path="txtID_Date_Nyukin_Year" id="txtID_Date_Nyukin_Year" style="width:30px;text-align: center;" maxlength="2" size="2"
											onkeyup='change_dateNyukin(
												"${cr006_02Form.lblID_JtkshoriConfigMode}",
												"${cr006_02Form.lblID_BizDate_Gengo}",
												"${cr006_02Form.lblID_BizDate_Nen}",
												"${cr006_02Form.lblID_BizDate_Tsuki}",
												"${cr006_02Form.lblID_BizDate_PrevMonth_Gengo}",
												"${cr006_02Form.lblID_BizDate_PrevMonth_Nen}",
												"${cr006_02Form.lblID_BizDate_PrevMonth_Tsuki}")'/>年
										<parts:select path="drpID_Date_Nyukin_Month" id="drpID_Date_Nyukin_Month"
											onchange='change_dateNyukin(
												"${cr006_02Form.lblID_JtkshoriConfigMode}",
												"${cr006_02Form.lblID_BizDate_Gengo}",
												"${cr006_02Form.lblID_BizDate_Nen}",
												"${cr006_02Form.lblID_BizDate_Tsuki}",
												"${cr006_02Form.lblID_BizDate_PrevMonth_Gengo}",
												"${cr006_02Form.lblID_BizDate_PrevMonth_Nen}",
												"${cr006_02Form.lblID_BizDate_PrevMonth_Tsuki}")'>
											<parts:codeListOption categoryCode="00003" />
										</parts:select>月
										<parts:select path="drpID_Date_Nyukin_Day" id="drpID_Date_Nyukin_Day"
											onchange='change_dateNyukin(
												"${cr006_02Form.lblID_JtkshoriConfigMode}",
												"${cr006_02Form.lblID_BizDate_Gengo}",
												"${cr006_02Form.lblID_BizDate_Nen}",
												"${cr006_02Form.lblID_BizDate_Tsuki}",
												"${cr006_02Form.lblID_BizDate_PrevMonth_Gengo}",
												"${cr006_02Form.lblID_BizDate_PrevMonth_Nen}",
												"${cr006_02Form.lblID_BizDate_PrevMonth_Tsuki}")'>
											<parts:codeListOption categoryCode="00004" />
										</parts:select>日
									</div>
								</div>
								<!-- 出力用 -->
								<div class="item-input">
									<div><!-- 項目名 --> 立替金利息(円)</div>
									<div><!-- 値 -->
										<parts:text path="txtID_M_TatekaeRisoku" id="txtID_M_TatekaeRisoku" style="text-align: right;" maxlength="11" size="15" cssClass="format-number"/>
									</div>
								</div>
								<!-- 出力用 -->
								<div class="item-input">
									<div><!-- 項目名 --> 立替金(円)</div>
									<div ><!-- 値 -->
										<parts:text path="txtID_M_Tatekae" id="txtID_M_Tatekae" style="text-align: right;" maxlength="11" size="15" cssClass="format-number"/>
									</div>
								</div>
								<!-- 出力用 -->
								<div class="item-input">
									<div><!-- 項目名 --> 仮受金(一般口)からの充当額(円)</div>
									<div ><!-- 値 -->
										<parts:text path="txtID_M_KariukeIppanJuto" id="txtID_M_KariukeIppanJuto" style="text-align: right;" maxlength="11" size="15" cssClass="format-number"
										onkeyup='change_dateNyukin(
												"${cr006_02Form.lblID_JtkshoriConfigMode}",
												"${cr006_02Form.lblID_BizDate_Gengo}",
												"${cr006_02Form.lblID_BizDate_Nen}",
												"${cr006_02Form.lblID_BizDate_Tsuki}",
												"${cr006_02Form.lblID_BizDate_PrevMonth_Gengo}",
												"${cr006_02Form.lblID_BizDate_PrevMonth_Nen}",
												"${cr006_02Form.lblID_BizDate_PrevMonth_Tsuki}")'/>
									</div>
								</div>
							</div>
							<!-- 報告書の一行分(複数可) -->
							<br><br><br>
							<div class="report_a_line">
								<!-- 出力用 -->
								<div class="item-output">
									<div><!-- 項目名 --> 立替金の種類</div>
									<div><!-- 値 -->
										<input type= "text" class="protect" style="text-align: center;" tabindex="-1" readonly value="<parts:codeName code='${cr006_02Form.txtID_Code_TatekaekinShurui}' categoryCode='00006'/>"/>
									</div>
								</div>
								<!-- 出力用 -->
								<div class="item-output">
									<div><!-- 項目名 --> 公庫立替日</div>
									<div><!-- 値 -->
<!--
										<parts:text path="txtID_Date_KoukoTatekae" id="txtID_Date_KoukoTatekae" style="text-align:center;" tabindex="-1" readonly="true" />
-->
									   <input type= "text" class="protect" style="text-align: center;" tabindex="-1" readonly value="<pn:printWareki date='${cr006_02Form.txtID_Date_KoukoTatekae}' pattern='GYMD'/>"/></div>
									</div>
								</div>
								<!-- 出力用 -->
								<div class="item-output">
									<div><!-- 項目名 --> 計(円)</div>
									<div ><!-- 値 -->
										<parts:text path="txtID_M_Kei" id="txtID_M_Kei" style="text-align: right;" maxlength="11" size="15" tabindex="-1" readonly="true" cssClass="format-number"/>
									</div>
								</div>
								<!-- 出力用 -->
								<div class="item-output">
									<div><!-- 項目名 --> 送金額(円)</div>
									<div ><!-- 値 -->
										<parts:text path="txtID_M_Sokin" id="txtID_M_Sokin" style="text-align: right;" maxlength="11" size="15" tabindex="-1" readonly="true" cssClass="format-number"/>
									</div>
								</div>

							<!-- 報告書の一行分(複数可) -->
							<br><br><br>
							<div class="report_a_line">
								<!-- 出力用 -->
								<div class="item-output">
									<div>受入後立替金残高(円)</div>
									<div >
										<parts:text path="txtID_M_TatekaeZanAfterUkeire" id="txtID_M_TatekaeZanAfterUkeire" style="text-align: right;" maxlength="11" size="15" tabindex="-1" readonly="true" cssClass="format-number" />
									</div>
								</div>
							</div>


							<!-- 報告書の一行分(複数可) -->
							<br><br><br>
							<div class="report_a_line">
								<!-- 出力用 -->
								<div class="item-input">
									<div><!-- 項目名 --> 受託者勘定処理年月</div>
									<div><!-- 値 -->
										<parts:select path="drpID_Date_Jtkshori_Gengou" id="drpID_Date_Jtkshori_Gengou" onchange="setHdnJtkshori()">
											<parts:codeListOption categoryCode="00002" />
										</parts:select>
                                        <parts:hidden path="hdnID_Date_Jtkshori_Gengo" id="hdnID_Date_Jtkshori_Gengo" value=""></parts:hidden>
										<c:if test='${cr006_02Form.lblID_JtkshoriConfigMode == "3"}'>
											<parts:text path="txtID_Date_Jtkshori_Year" id="txtID_Date_Jtkshori_Year"
											  style="width:30px;text-align: center;" maxlength="2" size="2" />年
										</c:if>
										<c:if test='${cr006_02Form.lblID_JtkshoriConfigMode != "3"}'>
											<parts:text path="txtID_Date_Jtkshori_Year" id="txtID_Date_Jtkshori_Year"
											  style="width:30px;text-align: center;" maxlength="2" size="2" tabindex="-1" />年
										</c:if>
										<parts:select path="drpID_Date_Jtkshori_Month" id="drpID_Date_Jtkshori_Month" onchange="setHdnJtkshori()">
											<parts:codeListOption categoryCode="00003" />
										</parts:select>月
                                        <parts:hidden path="hdnID_Date_JtkshoriTsuki_Candidate" id="hdnID_Date_JtkshoriTsuki_Candidate" value=""></parts:hidden>
									</div>
								</div>
								<!-- 出力用 -->
								<div class="item-input">
									<div><!-- 項目名 --> 送金年月日</div>
									<div><!-- 値 -->
										<parts:select path="drpID_Date_Sokin_Gengou" id="drpID_Date_Sokin_Gengou">
<%-- [UPD] Ver 3.0.0 - START --%>
<%-- 										<parts:option value="" /> --%>
<%-- 										<parts:option value="S">S</parts:option> --%>
<%-- 										<parts:option value="H">H</parts:option> --%>
											<parts:codeListOption categoryCode="00002" />
<%-- [UPD] Ver 3.0.0 - END --%>
										</parts:select>
										<parts:text path="txtID_Date_Sokin_Year" id="txtID_Date_Sokin_Year" style="width:30px;text-align: center;" maxlength="2" size="2" />年
										<parts:select path="drpID_Date_Sokin_Month" id="drpID_Date_Sokin_Month">
											<parts:codeListOption categoryCode="00003" />
										</parts:select>月
										<parts:select path="drpID_Date_Sokin_Day" id="drpID_Date_Sokin_Day">
											<parts:codeListOption categoryCode="00004" />
										</parts:select>日
									</div>
								</div>
								<!-- 出力用 -->
								<div class="item-input">
									<div><!-- 項目名 --> 送金日番号</div>
									<div><!-- 値 -->
										<parts:text path="txtID_Code_Sokin" id="txtID_ID_Sokinbi" style="text-align: center;" maxlength="3" size="6" />
									</div>
								</div>
							</div>
						</div> <!-- 報告書一枚終わり -->
					</td>
					</parts:tr>
				</parts:table>
			</div>
			</div>
		</parts:form><%@ include file="/jsp/incFooter.jsp"%>
	</body>
</html>