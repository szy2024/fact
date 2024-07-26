<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/jsp/incTop.jsp"%>
<%@ page import="jp.go.jfc.partnernet.common.PNCommonConstants"%>

<%--================================================================================================
 * Project Name : パートナーネット開発
 * System Name  : パートナーネット
 * File Name    : cr003_02.jsp
 *
 * <<Modification History>>
 * Version | Date       | Updated By            | Content
 * --------+------------+-----------------------+---------------------------------------------------
 * 1.0.0   | 2015/07/01 | 澤田　健一            | 新規作成
 * 2.0.0   | 2017/11/29 | 林　晃平              | 委託貸付報告等における機能改善対応
 * 4.0.0   | 2020/11/27 | 三好　一功            | 基盤更改等に伴うパートナーネットシステムの更改
================================================================================================--%>

<html>
<%@ include file="/jsp/incHeader.jsp"%>
<head>
	<title><parts:message code="title.screenName"/></title>
	<script lang="JavaScript">
		<!--
			<%--
			- 送信ボタン押下時の処理
			--%>
			function click_SendBtn() {
				executeAction('../../cr003/cr003_02/Cr003_02Send.form');
			}
			<%--
			- 戻るボタン押下時の処理
			--%>
			function click_backBtn() {
				executeAction('../../cr003/cr003_01/Cr003_01Return.form');
			}
			<%--
			- 一括ボタン押下時の処理
			--%>
			function click_copyBtn() {
				executeAction('../../cr003/cr003_02/Cr003_02Copy.form');
			}

			<%--
			- 一括入力入金日変更時の処理
			--%>
			function change_dateNyukinCopy( JtkshoriConfigMode, bizDateGengo,
					bizDateNen, bizDateTsuki, bizDatePrevMonthGengo, bizDatePrevMonthNen, bizDatePrevMonthTsuki) {

				<%-- 入金日 取得 --%>
				nyukinGengo = document.getElementById('Dropdownlist1').value;
				nyukinNen = document.getElementById('Textbox1').value;
				nyukinTsuki = document.getElementById('Dropdownlist2').value;

				<%-- 受託者勘定処理年月 隠しフィールド取得 --%>
				hdnJtkGengo = document.getElementById('hdnDropdownlist4');
				hdnJtkTsuki = document.getElementById('hdnDropdownlist5');

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
				if ( JtkshoriConfigMode == <%=PNCommonConstants.JTKSHORI_CONFIGMODE_1%>
					|| JtkshoriConfigMode == <%=PNCommonConstants.JTKSHORI_CONFIGMODE_3%>) {
					<%-- 受託者勘定処理年月設定モードが 1（決算期かつ第1～4営業日）または --%>
					<%-- 受託者勘定処理年月設定モードが 3（通常期かつ第1～10営業日）の場合 --%>
					if ( 2 <= dm ) {
						<%-- 入金日が業務日付の前々月以前の場合 --%>
						<%-- 業務日付の前月を設定 --%>
						setDateJtkshoriCopy( bizDatePrevMonthGengo, bizDatePrevMonthNen, bizDatePrevMonthTsuki);

					}
					else {
						<%-- 上記以外 入金日 を設定 --%>
						setDateJtkshoriCopy( nyukinGengo, nyukinNen, nyukinTsuki);

					}

				}
				else if ( JtkshoriConfigMode == <%=PNCommonConstants.JTKSHORI_CONFIGMODE_2%>
					|| JtkshoriConfigMode == <%=PNCommonConstants.JTKSHORI_CONFIGMODE_4%>) {
					<%-- 受託者勘定処理年月設定モードが 2（決算期かつ第5～最終営業日）または --%>
					<%-- 受託者勘定処理年月設定モードが 4（通常期かつ第11～最終営業日）の場合 --%>

					<%-- 業務日付を設定--%>
					setDateJtkshoriCopy( bizDateGengo, bizDateNen, bizDateTsuki);

				}

			}

			<%-- 一括入力受託者勘定処理年月 元号、年、月設定 --%>
			function setDateJtkshoriCopy( gengo, nen, tsuki) {

				<%-- 受託者勘定処理年月 取得 --%>
				jtkGengo = document.getElementById('Dropdownlist4');
				jtkNen = document.getElementById('Textbox2');
				jtkTsuki = document.getElementById('Dropdownlist5');

				hdnJtkGengo = document.getElementById('hdnDropdownlist4');
				hdnJtkTsuki = document.getElementById('hdnDropdownlist5');

				<%-- 受託者勘定処理年月（元号）--%>
				jtkGengo.value = gengo;
				hdnJtkGengo.value = gengo;

				<%-- 受託者勘定処理年月（年）--%>
				jtkNen.value = nen;

				<%-- 受託者勘定処理年月（月）--%>
				jtkTsuki.value = tsuki;
				hdnJtkTsuki.value = tsuki;

			}

			<%-- 一括入力受託者勘定処理年月 隠しフィールド設定 --%>
			function setHdnJtkshoriCopy() {

				<%-- 受託者勘定処理年月 取得 --%>
				jtkGengo = document.getElementById('Dropdownlist4').value;
				jtkTsuki = document.getElementById('Dropdownlist5').value;

				document.getElementById('hdnDropdownlist4').value = jtkGengo;
				document.getElementById('hdnDropdownlist5').value = jtkTsuki;

			}

			<%--
			- 入金日変更時の処理
			--%>
			function change_dateNyukin( index, JtkshoriConfigMode, bizDateGengo,
					bizDateNen, bizDateTsuki, bizDatePrevMonthGengo, bizDatePrevMonthNen, bizDatePrevMonthTsuki) {

				<%-- 入金日 取得 --%>
				nyukinGengo = document.getElementsByName(
						'cr003_02M1Table.recordList[' + index + '].ID_Date_Nyukin_Gengo')[0].value;
				nyukinNen = document.getElementsByName(
						'cr003_02M1Table.recordList[' + index + '].ID_Date_Nyukin_Nen')[0].value;
				nyukinTsuki = document.getElementsByName(
						'cr003_02M1Table.recordList[' + index + '].ID_Date_NyukinTsuki')[0].value;

				<%-- 仮受金(一般口)からの充当額(円) 取得 --%>
				kariukeIppanJuto = document.getElementsByName(
						'cr003_02M1Table.recordList[' + index + '].ID_M_KariukeIppanJuto')[0].value;

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
							setDateJtkshori( index, bizDatePrevMonthGengo, bizDatePrevMonthNen, bizDatePrevMonthTsuki);

						}
						else {

							<%-- 上記以外 入金日 を設定 --%>
							setDateJtkshori( index, nyukinGengo, nyukinNen, nyukinTsuki);

						}

					}
					else if ( JtkshoriConfigMode == <%=PNCommonConstants.JTKSHORI_CONFIGMODE_2%>
						|| JtkshoriConfigMode == <%=PNCommonConstants.JTKSHORI_CONFIGMODE_4%>) {
						<%-- 受託者勘定処理年月設定モードが 2（決算期かつ第5～最終営業日）または --%>
						<%-- 受託者勘定処理年月設定モードが 4（通常期かつ第11～最終営業日）の場合 --%>

						<%-- 業務日付を設定 --%>
						setDateJtkshori( index, bizDateGengo, bizDateNen, bizDateTsuki);

					}

				}
				else {
					<%-- 上記以外上記以外（仮受金一般口からの充当） --%>
					if ( JtkshoriConfigMode == <%=PNCommonConstants.JTKSHORI_CONFIGMODE_1%>
						|| JtkshoriConfigMode == <%=PNCommonConstants.JTKSHORI_CONFIGMODE_3%>) {
						<%-- 受託者勘定処理年月設定モードが 1（決算期かつ第1～4営業日）または --%>
						<%-- 受託者勘定処理年月設定モードが 3（通常期かつ第1～10営業日）の場合 --%>

						<%--  業務日付の前月を設定 --%>
						setDateJtkshori( index, bizDatePrevMonthGengo, bizDatePrevMonthNen, bizDatePrevMonthTsuki);

					}
					else if ( JtkshoriConfigMode == <%=PNCommonConstants.JTKSHORI_CONFIGMODE_2%>
					   || JtkshoriConfigMode == <%=PNCommonConstants.JTKSHORI_CONFIGMODE_4%>) {
						<%-- 受託者勘定処理年月設定モードが 2（決算期かつ第5～最終営業日）または --%>
						<%-- 受託者勘定処理年月設定モードが 4（通常期かつ第11～最終営業日）の場合 --%>

						<%-- 業務日付を設定 --%>
						setDateJtkshori( index, bizDateGengo, bizDateNen, bizDateTsuki);

					}

				}

			}

			<%-- 受託者勘定処理年月 元号、年、月設定 --%>
			function setDateJtkshori( index, gengo, nen, tsuki) {

				<%-- 受託者勘定処理年月 取得 --%>
				jtkGengo = document.getElementsByName(
						'cr003_02M1Table.recordList[' + index + '].ID_Date_Jtkshori_Gengo')[0];
				jtkNen = document.getElementsByName(
						'cr003_02M1Table.recordList[' + index + '].ID_Date_Jtkshori_Nen')[0];
				jtkTsuki = document.getElementsByName(
						'cr003_02M1Table.recordList[' + index + '].ID_Date_JtkshoriTsuki')[0];

				hdnJtkGengo = document.getElementById('hdnID_Date_Jtkshori_Gengo' + index);
				hdnJtkTsuki = document.getElementById('hdnID_Date_JtkshoriTsuki' + index);

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
			function setHdnJtkshori(index) {

				<%-- 受託者勘定処理年月 取得 --%>
				jtkGengo = document.getElementsByName(
						'cr003_02M1Table.recordList[' + index + '].ID_Date_Jtkshori_Gengo')[0].value;
				jtkTsuki = document.getElementsByName(
						'cr003_02M1Table.recordList[' + index + '].ID_Date_JtkshoriTsuki')[0].value;

				document.getElementById('hdnID_Date_Jtkshori_Gengo' + index).value = jtkGengo;
				document.getElementById('hdnID_Date_JtkshoriTsuki' + index).value = jtkTsuki;

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

		//-->
	</script>
</head>
<link href="<%=request.getContextPath()%>/css/gju_Create.css" type="text/css" rel="stylesheet" />
<body onload="initTextFormat()">
	<parts:form modelAttribute="cr003_02Form"
		id="form1" method="post" onsubmit="return false;">
		<%@ include file="/jsp/incCommonHidden.jsp"%>
		<%@ include file="/jsp/incHeaderArea.jsp"%>
		<div id="main_scroll_area">
		<div class="header">
			<div class="title">
				<label id="lblTitle"><parts:message code="title.screenName"/></label>
			</div>
		</div>
		<div class="help">
			<a href="#" onclick="openNewWindow('<%= request.getContextPath() %>/help/main_cr003.html', false, false, false, 'width=800', 'height=500', false)">
				<font class="help">ヘルプ</font>
			</a>
		</div>
		<div class="main">
			<c:if test="${cr003_02Form.getCr003_02Count() != 0 }">
				<div class="greeting">
					登録予定案件の一覧です。今回報告する案件の「選択」チェックボックスをチェックし、必要な項目を入力したうえで「送信」ボタンを押してください。
					（１００件以上を送信する場合は１分以上かかることがあります。）
<%-- [UPD] Ver 4.0.0 - START --%>
					<br />
					令和４年４月１日以降に貸付実行した案件は、実際に払出した金額をもとに約定利息を
					<br />
					計算する方法に変更となるため、控除利息はすべて「０」円で表示されます。
<%-- [UPD] Ver 4.0.0 - END --%>
				</div>
			</c:if>
			<div class="buttons">
				<parts:button id="btnUpdate2" value="送信" onclick="clearTextFormat();click_SendBtn();"/>
				<parts:button id="btnBack2" value="戻る" title="元利金受入・充当報告書の検索画面へ戻る"  onclick="click_backBtn()"/>
				<br />
			</div>
			<c:if test="${cr003_02Form.getCr003_02Count() == 0 }">
				<span class="status" style="color: red; font-weight: bold;">
					<parts:errors path="*" cssClass="Error" /><br />
				</span>
			</c:if>
			<c:if test="${cr003_02Form.getCr003_02Count() != 0 }">
				<div class="copyData" style="width:664px;margin:4px">
					<div>
						<label id="greeting2">送金を伴う場合の報告書で送金情報（入金日、受託者勘定処理年月、送金日、送金日番号）が
							<br />同一で約定どおりの案件が複数ある時にご利用ください。<br /> 送金情報に入力後「一括」ボタンを押してください。
						</label>
					</div>
					<div>
						<div class="item-copy">
							<label id="copy1" style="text-align: center;">送金情報</label>
						</div>
						<c:if test="${cr003_02Form.getErrFromCopy() == true }">
							<c:if test="${cr003_02Form.getErrCount() != '0' }">
								<div class="status" style="color: red; font-weight: bold;"><parts:errors path="*" cssClass="Error" /></div>
							</c:if>
						</c:if>
						<div class="status_2">
							<div class="copy" id="copy" >
								<div class="report_a_line">
									<div class="item-input">
										<div>
											<label id="Label12">入金日</label>
										</div>
										<div>
											<parts:select path="Dropdownlist1" id="Dropdownlist1"
												style="color:#003399;"
												onchange='change_dateNyukinCopy(
														"${cr003_02Form.lblID_JtkshoriConfigMode}",
														"${cr003_02Form.lblID_BizDate_Gengo}",
														"${cr003_02Form.lblID_BizDate_Nen}",
														"${cr003_02Form.lblID_BizDate_Tsuki}",
														"${cr003_02Form.lblID_BizDate_PrevMonth_Gengo}",
														"${cr003_02Form.lblID_BizDate_PrevMonth_Nen}",
														"${cr003_02Form.lblID_BizDate_PrevMonth_Tsuki}")'>
												<parts:codeListOption categoryCode="00002" />
											</parts:select>
											<parts:text path="Textbox1" id="Textbox1"
												style="width:30px;text-align: center;" maxlength="2" value=""
												size="2"
												onkeyup='change_dateNyukinCopy(
														"${cr003_02Form.lblID_JtkshoriConfigMode}",
														"${cr003_02Form.lblID_BizDate_Gengo}",
														"${cr003_02Form.lblID_BizDate_Nen}",
														"${cr003_02Form.lblID_BizDate_Tsuki}",
														"${cr003_02Form.lblID_BizDate_PrevMonth_Gengo}",
														"${cr003_02Form.lblID_BizDate_PrevMonth_Nen}",
														"${cr003_02Form.lblID_BizDate_PrevMonth_Tsuki}")'/>
											<label id="Label1">年</label>
											<parts:select path="Dropdownlist2" id="Dropdownlist2"
												style="color:#003399;"
												onchange='change_dateNyukinCopy(
														"${cr003_02Form.lblID_JtkshoriConfigMode}",
														"${cr003_02Form.lblID_BizDate_Gengo}",
														"${cr003_02Form.lblID_BizDate_Nen}",
														"${cr003_02Form.lblID_BizDate_Tsuki}",
														"${cr003_02Form.lblID_BizDate_PrevMonth_Gengo}",
														"${cr003_02Form.lblID_BizDate_PrevMonth_Nen}",
														"${cr003_02Form.lblID_BizDate_PrevMonth_Tsuki}")'>
												<parts:codeListOption categoryCode="00003" />
											</parts:select>
											<label id="Label2">月</label>
											<parts:select path="Dropdownlist3" id="Dropdownlist3"
												style="color:#003399;"
												onchange='change_dateNyukinCopy(
														"${cr003_02Form.lblID_JtkshoriConfigMode}",
														"${cr003_02Form.lblID_BizDate_Gengo}",
														"${cr003_02Form.lblID_BizDate_Nen}",
														"${cr003_02Form.lblID_BizDate_Tsuki}",
														"${cr003_02Form.lblID_BizDate_PrevMonth_Gengo}",
														"${cr003_02Form.lblID_BizDate_PrevMonth_Nen}",
														"${cr003_02Form.lblID_BizDate_PrevMonth_Tsuki}")'>
												<parts:codeListOption categoryCode="00004" />
											</parts:select>
											<label id="Label3">日</label>
										</div>
									</div>
									<div class="item-input">
										<div>
											<label id="Label11">受託者勘定処理年月</label>
										</div>
										<div>
											<parts:select path="Dropdownlist4" id="Dropdownlist4"
												style="color:#003399;"
												onchange="setHdnJtkshoriCopy()">
												<parts:codeListOption categoryCode="00002" />
											</parts:select>
											<parts:hidden path="hdnDropdownlist4" id="hdnDropdownlist4" value=""></parts:hidden>
											<c:if test='${cr003_02Form.lblID_JtkshoriConfigMode == "3"}'>
												<parts:text path="Textbox2" id="Textbox2"
													style="width:30px;text-align: center;" maxlength="2" value=""
													size="2" />
											</c:if>
											<c:if test='${cr003_02Form.lblID_JtkshoriConfigMode != "3"}'>
												<parts:text path="Textbox2" id="Textbox2"
													style="width:30px;text-align: center;" maxlength="2" value=""
													size="2" tabindex="-1"/>
											</c:if>
											<label id="Label4">年</label>
											<parts:select path="Dropdownlist5" id="Dropdownlist5"
												style="color:#003399;"
												onchange="setHdnJtkshoriCopy()">
												<parts:codeListOption categoryCode="00003" />
											</parts:select>
											<parts:hidden path="hdnDropdownlist5" id="hdnDropdownlist5" value=""></parts:hidden>
											<label id="Label5">月</label>
										</div>
									</div>
									<div class="item-input">
										<div>
											<label id="Label10">送金日</label>
										</div>
										<div style="white-space:nowrap">
											<parts:select path="Dropdownlist6" id="Dropdownlist6"
												style="color:#003399;">
												<parts:codeListOption categoryCode="00002" />
											</parts:select>
											<parts:text path="Textbox3" id="Textbox3"
												style="width:30px;text-align: center;" maxlength="2" value=""
												size="2" />
											<label id="Label6">年</label>
											<parts:select path="Dropdownlist7" id="Dropdownlist7"
												style="color:#003399;">
												<parts:codeListOption categoryCode="00003" />
											</parts:select>
											<label id="Label7">月</label>
											<parts:select path="Dropdownlist8" id="Dropdownlist8"
												style="color:#003399;">
												<parts:codeListOption categoryCode="00004" />
											</parts:select>
											<label id="Label8">日</label>
										</div>
									</div>
								</div>
								<br />
								<div class="report_a_line">
									<div class="item-input" align="center">
										<div>
											<label id="Label9">送金日番号</label>
										</div>
										<div>
											<parts:text path="ID_Soshin_Copy" id="ID_Soshin_Copy"
												style="text-align: right;" maxlength="3" size="3" value="" />
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="Buttons" style="clear:both;">
						<parts:button id="btnCopy" value="一括"  onclick="click_copyBtn()"/>
					</div>
				</div>
				<div style="clear: both;">
					<div class="reportDate">
						報告年月日：
						<parts:dlabel path="lblID_Date_Report" />
					</div>
					<div class="status_1">
						ステータス： <br />
						<span class="status" style="color: red; font-weight: bold;">
							<c:if test="${cr003_02Form.getErrFromCopy() == false }">
								<c:if test="${cr003_02Form.getErrCount() != '0' }">
									<parts:errors path="*" cssClass="Error" /><br />
								</c:if>
							</c:if>
							<parts:dlabel htmlEscape="false" path="lblMessage" />
						</span>
					</div>
				</div>
				<jsp:include page="/jsp/cr003_02_paging.jsp" />
			</c:if>
		</div>
	</div>
	</parts:form><%@ include file="/jsp/incFooter.jsp"%>
</body>
</html>