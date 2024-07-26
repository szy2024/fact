
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/jsp/incTop.jsp" %>
<%@ page import="jp.go.jfc.partnernet.common.PNCommonConstants" %>
<%--================================================================================================
 * Project Name : パートナーネット開発
 * System Name  : パートナーネット
 * File Name    : cr009_01.jsp
 *
 * <<Modification History>>
 * Version | Date       | Updated By            | Content
 * --------+------------+-----------------------+---------------------------------------------------
 * 1.0.0   | 2015/07/01 | 佐藤　一樹            | 新規作成
 * 2.0.0   | 2017/12/04 | 嶋田　美保            | 委託貸付報告等における機能改善対応
================================================================================================--%>

<html>
	<%@ include file="/jsp/incHeader.jsp"%>
	<head>
		<title><parts:message code="title.screenName"/></title>



		<link href="<%=request.getContextPath()%>/css/cr009.css" type="text/css" rel="stylesheet" />
		<!-- 2005/05/10 add start SCRIPTタグ追加 -->
		<script lang="JavaScript" type="text/javascript">
         <%-- 送信ボタン押下時の処理 --%>
         function click_sendBtn() {
             executeAction('../../cr009/cr009_01/Cr009_01Send.form');
         }

         <%-- 入金日変更時の処理    --%>
         function change_dateNyukin( JtkshoriConfigMode, bizDateGengo,
             bizDateNen, bizDateTsuki, bizDatePrevMonthGengo, bizDatePrevMonthNen, bizDatePrevMonthTsuki) {

             <%-- 入金日 取得 --%>
             nyukinGengo = document.getElementById('drpID_Date_Nyukin_Gengou').value;
             nyukinNen = document.getElementById('txtID_Date_Nyukin_Year_Input').value;
             nyukinTsuki = document.getElementById('drpID_Date_Nyukin_Month').value;

             <%-- 受託者勘定処理年月 隠しフィールド取得 --%>
             hdnJtkGengo = document.getElementById('hdnID_Date_Jtkshori_Gengo');
             hdnJtkTsuki = document.getElementById('hdnID_Date_JtkshoriTsuki_Candidate');

             <%-- 日付形式チェック --%>
             if ( !chkDate( nyukinNen, nyukinTsuki) ) {

                 return;
             }

             <%-- 和暦→西暦変換 --%>
             nyukinYYYY = warekiToSeireki( nyukinGengo, nyukinNen)

             bizDateYYYY = warekiToSeireki( bizDateGengo, bizDateNen)

             <%-- 月差分計算 ： 業務日付 - 入金日  --%>
             dm = diffMonth( bizDateYYYY, bizDateTsuki, nyukinYYYY, nyukinTsuki);

             <%-- 受託者勘定処理年月設定 --%>
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

                 <%-- 業務日付を設定--%>
                 setDateJtkshori( bizDateGengo, bizDateNen, bizDateTsuki);

             }

         }

         <%-- 月差分計算 --%>
         function diffMonth( y1, m1, y2, m2) {
             return (y1 - y2) * 12 + (m1 - m2) * 1;

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
             jtkNen = document.getElementById('txtID_Date_Jtkshori_Year_Input');
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

		</script>
		<!-- 2005/05/10 add end -->
	</head>
	<body onload = "initTextFormat()">
		<parts:form modelAttribute="cr009_01Form" action="./Cr009_01Init.form" id="Form1" method="post" onsubmit="return false;">
			<%@ include file="/jsp/incCommonHidden.jsp" %>
			<%@ include file="/jsp/incHeaderArea.jsp" %>
			<div id="main_scroll_area">
			<div class="header">
				<div class="title">
					<label id="lblTitle" class="title"><parts:message code="title.screenName"/></label>
				</div>
			</div>
			<div class="help">
				<a href="#" onclick="openNewWindow('<%= request.getContextPath() %>/help/main_cr009.html', false, false, false, 'width=800', 'height=500', false)">
					<font class="help">ヘルプ</font>
				</a>
			</div>
			<div class="main">
				<parts:table id="infoArea" width="400px">
					<div class="greeting" style="width: 100%">
						必要な項目を入力したうえで「送信」ボタンを押してください。
					</div>
				</parts:table>
				<div class="buttons">
					<parts:button id="btnID_Send" value="送信" title="送信" onclick="clearTextFormat();click_sendBtn();" />
				</div>
				<div class="reportDate">報告年月日：
					<parts:dlabel path="lblID_Date_Report" />
				</div>
				<div class="status">
					ステータス：
					<div style="color:red;font-weight:bold;">
						<parts:errors path="*"/>
					</div>
				</div>
				<parts:table id="editArea">
				<tr><td>
					<div class="report">
						<!-- 報告書の一行分(複数可) -->
						<div align="center">
							<div class="report_a_line">
								<!-- 出力用 -->
								<div class="item-output">
									<div><!-- 項目名 --> 扱店名：</div>
									<div><!-- 値 -->
										<parts:text path="txtID_Name_Organization" id="txtID_Name_Organization" style="text-align: left;" maxlength="40" size="50" tabindex="-1" readonly="true" />
									</div>
								</div>
							</div>
							<!-- 報告書の一行分(複数可) -->
							<div class="report_a_line">
								<!-- 入力用 -->
								<div class="item-input">
									<div><!-- 項目名 --> 公庫支店</div>
									<div><!-- 値 -->
										<parts:text path="txtID_Code_ShokanHonShiten" id="txtID_Code_ShokanHonShiten" style="text-align: center;" maxlength="2" size="2" />
									</div>
								</div>
								<!-- 出力用 -->
								<div class="item-output">
									<div><!-- 項目名 --> 扱店</div>
									<div><!-- 値 -->
										<parts:text path="txtID_Code_Organization" id="txtID_Code_Organization" style="text-align: center;" maxlength="4" size="4" tabindex="-1" readonly="true" />
									</div>
								</div>
								<!-- 入力用 -->
								<div class="item-input">
									<div><!-- 項目名 --> 店舗</div>
									<div><!-- 値 -->
										<parts:text path="txtID_Code_Tenpo" id="txtID_Code_Tenpo" style="text-align: center;" maxlength="3" size="3" />
									</div>
								</div>
								<!-- 入力用 -->
								<div class="item-input">
									<div><!-- 項目名 --> 入金日</div>
									<div><!-- 値 -->
										<parts:select path="drpID_Date_Nyukin_Gengou" id="drpID_Date_Nyukin_Gengou" style="color:#003399;"
											onchange='change_dateNyukin(
												"${cr009_01Form.lblID_JtkshoriConfigMode}",
												"${cr009_01Form.lblID_BizDate_Gengo}",
												"${cr009_01Form.lblID_BizDate_Nen}",
												"${cr009_01Form.lblID_BizDate_Tsuki}",
												"${cr009_01Form.lblID_BizDate_PrevMonth_Gengo}",
												"${cr009_01Form.lblID_BizDate_PrevMonth_Nen}",
												"${cr009_01Form.lblID_BizDate_PrevMonth_Tsuki}")'>
										<parts:codeListOption categoryCode="00002" />
										</parts:select>
										<parts:text path="txtID_Date_Nyukin_Year_Input" id="txtID_Date_Nyukin_Year_Input" style="width:30px;text-align: center;" maxlength="2" size="2"
											onkeyup='change_dateNyukin(
												"${cr009_01Form.lblID_JtkshoriConfigMode}",
												"${cr009_01Form.lblID_BizDate_Gengo}",
												"${cr009_01Form.lblID_BizDate_Nen}",
												"${cr009_01Form.lblID_BizDate_Tsuki}",
												"${cr009_01Form.lblID_BizDate_PrevMonth_Gengo}",
												"${cr009_01Form.lblID_BizDate_PrevMonth_Nen}",
												"${cr009_01Form.lblID_BizDate_PrevMonth_Tsuki}")' />年
										<parts:select path="drpID_Date_Nyukin_Month" id="drpID_Date_Nyukin_Month" style="color:#003399;"
											onchange='change_dateNyukin(
												"${cr009_01Form.lblID_JtkshoriConfigMode}",
												"${cr009_01Form.lblID_BizDate_Gengo}",
												"${cr009_01Form.lblID_BizDate_Nen}",
												"${cr009_01Form.lblID_BizDate_Tsuki}",
												"${cr009_01Form.lblID_BizDate_PrevMonth_Gengo}",
												"${cr009_01Form.lblID_BizDate_PrevMonth_Nen}",
												"${cr009_01Form.lblID_BizDate_PrevMonth_Tsuki}")'>
											<parts:codeListOption categoryCode="00003" />
										</parts:select>月
										<parts:select path="drpID_Date_Nyukin_Day" id="drpID_Date_Nyukin_Day" style="color:#003399;"
											onchange='change_dateNyukin(
												"${cr009_01Form.lblID_JtkshoriConfigMode}",
												"${cr009_01Form.lblID_BizDate_Gengo}",
												"${cr009_01Form.lblID_BizDate_Nen}",
												"${cr009_01Form.lblID_BizDate_Tsuki}",
												"${cr009_01Form.lblID_BizDate_PrevMonth_Gengo}",
												"${cr009_01Form.lblID_BizDate_PrevMonth_Nen}",
												"${cr009_01Form.lblID_BizDate_PrevMonth_Tsuki}")'>
											<parts:codeListOption categoryCode="00004" />
										</parts:select>日
									</div>
								</div>
							</div>
							<!-- 報告書の一行分(複数可) -->
							<div class="report_a_line">
								<!-- 入力用 -->
								<div class="item-input">
									<div>留置期間利息(円)</div>
									<div class="styleMoney" style="width:auto;">
										<parts:text path="txtID_M_RyuchiKikanRisoku" id="txtID_M_RyuchiKikanRisoku" style="text-align: right;" maxlength="11" size="15" cssClass="format-number" />
									</div>
								</div>
								<!-- 入力用 -->
								<div class="item-input">
									<div>代弁遅延損害金(円)</div>
									<div class="styleMoney" style="width:auto;"><!-- 値 -->
										<parts:text path="txtID_M_DaibenChienSongai" id="txtID_M_DaibenChienSongai" style="text-align: right;" maxlength="11" size="15" cssClass="format-number" />
									</div>
								</div>
							</div>
							<div class="report_a_line">
								<!-- 出力用 -->
								<div class="item-output">
									<div><!-- 項目名 --> 送金額計(円)</div>
									<div class="styleMoney" style="width:auto;"><!-- 値 -->
										<parts:text path="txtID_M_Sokin" id="txtID_M_Sokin" style="text-align: right;" maxlength="11" size="15" tabindex="-1" readonly="true" cssClass="format-number" />
									</div>
								</div>
							</div>
							<!-- 報告書の一行分(複数可) -->
							<div class="report_a_line">
								<!-- 入力用 -->
								<div class="item-input">
									<div><!-- 項目名 --> 受託者勘定処理年月</div>
									<div><!-- 値 -->
										<parts:select path="drpID_Date_Jtkshori_Gengou" id="drpID_Date_Jtkshori_Gengou" style="color:#003399;" onchange="setHdnJtkshori()">
											<parts:codeListOption categoryCode="00002" />
										</parts:select>
										<parts:hidden path="hdnID_Date_Jtkshori_Gengo" id="hdnID_Date_Jtkshori_Gengo" value=""></parts:hidden>
										<c:if test='${cr009_01Form.lblID_JtkshoriConfigMode == "3"}'>
											<parts:text path="txtID_Date_Jtkshori_Year_Input" id="txtID_Date_Jtkshori_Year_Input"
											  style="width:30px;text-align: center;" maxlength="2" size="2" />年
										</c:if>
										<c:if test='${cr009_01Form.lblID_JtkshoriConfigMode != "3"}'>
											<parts:text path="txtID_Date_Jtkshori_Year_Input" id="txtID_Date_Jtkshori_Year_Input"
											  style="width:30px;text-align: center;" maxlength="2" size="2" tabindex="-1" />年
										</c:if>
										<parts:select path="drpID_Date_Jtkshori_Month" id="drpID_Date_Jtkshori_Month" style="color:#003399;" onchange="setHdnJtkshori()">
											<parts:codeListOption categoryCode="00003" />
										</parts:select>
										<parts:hidden path="hdnID_Date_JtkshoriTsuki_Candidate" id="hdnID_Date_JtkshoriTsuki_Candidate" value=""></parts:hidden>月
									</div>
								</div>
								<!-- 入力用 -->
								<div class="item-input">
									<div><!-- 項目名 --> 送金年月日</div>
									<div><!-- 値 -->
										<parts:select path="drpID_Date_Sokin_Gengou" id="drpID_Date_Sokin_Gengou" style="color:#003399;">
											<parts:codeListOption categoryCode="00002" />
										</parts:select>
										<parts:text path="txtID_Date_Sokin_Year_Input" id="txtID_Date_Sokin_Year_Input" style="width:30px;text-align: center;" maxlength="2" size="2" />年
										<parts:select path="drpID_Date_Sokin_Month" id="drpID_Date_Sokin_Month" style="color:#003399;">
											<parts:codeListOption categoryCode="00003" />
										</parts:select>月
										<parts:select path="drpID_Date_Sokin_Day" id="drpID_Date_Sokin_Day" style="color:#003399;">
											<parts:codeListOption categoryCode="00004" />
										</parts:select>日
									</div>
								</div>
								<div class="item-input">
									<div><!-- 項目名 --> 送金日番号</div>
									<div><!-- 値 -->
										<parts:text path="txtID_Code_Sokin" id="txtID_Code_Sokin" style="text-align:center;" maxlength="3" size="3" />
									</div>
								</div>
							</div>
						</div>
						<!-- 報告書一枚終わり -->
					</div>
				<br />
				<td><tr>
				</parts:table>
			</div>
		</div>
		</parts:form><%@ include file="/jsp/incFooter.jsp"%>
	</body>
</html>