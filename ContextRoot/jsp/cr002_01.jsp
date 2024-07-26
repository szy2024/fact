
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/jsp/incTop.jsp"%>
<%@ taglib prefix="pn" uri="http://partnernet.jfc.go.jp/tags/pn"%>
<%@ page import="jp.go.jfc.partnernet.common.PNCommonConstants"%>
<%--================================================================================================
 * Project Name : パートナーネット開発
 * System Name  : パートナーネット
 * File Name    : cr002_01.jsp
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
		<script language="JavaScript" type="text/javascript" src="<%= request.getContextPath() %>/js/ptncommon.js"></script>
		<script lang="JavaScript">
		//<!--
			<%--
			- 送信ボタン押下時の処理
			--%>
			function click_sendBtn() {
				executeAction('../../cr002/cr002_01/Cr002_01Send.form');
			}

			<%--
            - 払出元金充当日変更時の処理
            --%>
            function change_dateHaraidashiJuto( index, JtkshoriConfigMode, bizDateGengo,
                    bizDateNen, bizDateTsuki, bizDatePrevMonthGengo, bizDatePrevMonthNen, bizDatePrevMonthTsuki) {

                <%-- 払出元金充当日 取得 --%>
                haraidashiGengo = document.getElementsByName(
                        'cr002_01M1Table.recordList[' + index + '].ID_Date_HaraidashiJuto_Gengo')[0].value;
                haraidashiNen = document.getElementsByName(
                        'cr002_01M1Table.recordList[' + index + '].ID_Date_HaraidashiJuto_Nen')[0].value;
                haraidashiTsuki = document.getElementsByName(
                        'cr002_01M1Table.recordList[' + index + '].ID_Date_HaraidashiJutoTsuki_Candidate')[0].value;

                <%-- 受託者勘定処理年月 隠しフィールド取得 --%>
                hdnJtkGengo = document.getElementById('hdnID_Date_Jtkshori_Gengo' + index);
                hdnJtkTsuki = document.getElementById('hdnID_Date_JtkshoriTsuki_Candidate' + index);

                <%-- 日付形式チェック --%>
                if ( !chkDate( haraidashiNen, haraidashiTsuki) ) {
                    return;
                }

                <%-- 和暦→西暦変換 --%>
                haraidashiYYYY = warekiToSeireki( haraidashiGengo, haraidashiNen)
                bizDateYYYY = warekiToSeireki( bizDateGengo, bizDateNen)

                <%-- 月差分計算 ： 業務日付 - 払出元金充当日 --%>
                dm = diffMonth( bizDateYYYY, bizDateTsuki, haraidashiYYYY, haraidashiTsuki);

                <%-- 受託者勘定処理年月設定 --%>
                if ( JtkshoriConfigMode == <%=PNCommonConstants.JTKSHORI_CONFIGMODE_1%>
                   || JtkshoriConfigMode == <%=PNCommonConstants.JTKSHORI_CONFIGMODE_3%>) {
                    <%-- 受託者勘定処理年月設定モードが 1（決算期かつ第1～4営業日）または --%>
                    <%-- 受託者勘定処理年月設定モードが 3（通常期かつ第1～10営業日）の場合 --%>
                    if ( 2 <= dm ) {
                        <%-- 払出元金充当日が業務日付の前々月以前の場合 --%>
                        <%-- 業務日付の前月を設定 --%>
                        setDateJtkshori( index, bizDatePrevMonthGengo, bizDatePrevMonthNen, bizDatePrevMonthTsuki);

                    }
                    else {
                        <%-- 上記以外 払出元金充当日 を設定 --%>
                        setDateJtkshori( index, haraidashiGengo, haraidashiNen, haraidashiTsuki);

                    }

                }
                else if ( JtkshoriConfigMode == <%=PNCommonConstants.JTKSHORI_CONFIGMODE_2%>
                   || JtkshoriConfigMode == <%=PNCommonConstants.JTKSHORI_CONFIGMODE_4%>) {
                    <%-- 受託者勘定処理年月設定モードが 2（決算期かつ第5～最終営業日）または --%>
                    <%-- 受託者勘定処理年月設定モードが 4（通常期かつ第11～最終営業日）の場合 --%>

                    <%-- 業務日付を設定--%>
                    setDateJtkshori( index, bizDateGengo, bizDateNen, bizDateTsuki);

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
            function setDateJtkshori( index, gengo, nen, tsuki) {

                <%-- 受託者勘定処理年月 取得 --%>
                jtkGengo = document.getElementsByName(
                        'cr002_01M1Table.recordList[' + index + '].ID_Date_Jtkshori_Gengo')[0];
                jtkNen = document.getElementsByName(
                        'cr002_01M1Table.recordList[' + index + '].ID_Date_Jtkshori_Nen')[0];
                jtkTsuki = document.getElementsByName(
                        'cr002_01M1Table.recordList[' + index + '].ID_Date_JtkshoriTsuki_Candidate')[0];

                hdnJtkGengo = document.getElementById('hdnID_Date_Jtkshori_Gengo' + index);
                hdnJtkTsuki = document.getElementById('hdnID_Date_JtkshoriTsuki_Candidate' + index);

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
                        'cr002_01M1Table.recordList[' + index + '].ID_Date_Jtkshori_Gengo')[0].value;
                jtkTsuki = document.getElementsByName(
                        'cr002_01M1Table.recordList[' + index + '].ID_Date_JtkshoriTsuki_Candidate')[0].value;

                document.getElementById('hdnID_Date_Jtkshori_Gengo' + index).value = jtkGengo;
                document.getElementById('hdnID_Date_JtkshoriTsuki_Candidate' + index).value = jtkTsuki;

            }
		//-->
	    </script>
	</head>
	<body onload="initTextFormat()">
		<parts:form modelAttribute="cr002_01Form" action="./Cr002_01Init.form" id="Form1" method="post" onsubmit="return false;">
			<%@ include file="/jsp/incCommonHidden.jsp"%>
			<%@ include file="/jsp/incHeaderArea.jsp"%>
			<div id="main_scroll_area">
			<div class="header">
				<div class="title">
						<span class="Title" id="lblTitle"><parts:message code="title.screenName"/></span>
				</div>
            </div>
			<div class="help">
				<a href="#" onclick="openNewWindow('<%= request.getContextPath() %>/help/main_cr002.html', false, false, false, 'width=800', 'height=500', false)">
					<font class="help">ヘルプ</font>
				</a>
			</div>
			<div class="main">
				<div class="greeting"><label id="lblDataMsg">登録予定案件の一覧です。今回報告する案件の「選択」チェックボックスをチェックし、<br>必要な項目を入力したうえで「送信」ボタンを押してください。</label></div>
				<!-- 操作ボタン -->
				<div class="buttons">
					<div style="display:none;">
						<parts:button id="btnUpdate" />
					</div>&nbsp;
					<div style="display:none;">
						<parts:button id="btnBack" />
					</div>
					<parts:button id="btnUpdate2" value="送信" onclick="clearTextFormat();click_sendBtn();" />
					<parts:button id="btnBack2" value="戻る" cssStyle="display:none;"/><br />
				</div>
				<div class="reportDate">報告年月日：
					<%-- parts:dlabel path="txtID_Date_Report" />--%>
					<fmt:parseDate value="${cr002_01Form.txtID_Date_Report}" var="ID_Date_Report" pattern="yyyyMMdd" />
                    <fmt:formatDate value="${ID_Date_Report}" pattern="yyyy年MM月dd日(E)"/>
				</div>
				<!--
					ステータスはエラーメッセージを出す際に
					エラー発生報告書へのジャンプ用アンカー(リンク)を埋め込む
				-->
				<div class="status_1">ステータス：
					<div style="color:red;font-weight:bold;">
						<parts:errors path="*" cssClass="Error" />
						<parts:dlabel path="lblMessage" />
					</div>
				</div>
				<div>
					<%-- parts:dlabel path="lblConnectHeader" />--%>
				</div>
				<paging:table path="cr002_01M1Table" paging="false" pagingDisplay="false">
					<div>
						<parts:table id="cr002_01M1Table"  cssStyle="border-style:none;">
							<paging:record>
								<tr>
									<td style="border-style:none;">
										<!-- 報告書一枚(borderで囲んである,複数可) -->
										<!-- 実装時はASP.NETのユーザコントロールよびだし -->
										<div class="report">
											<div align="center">
												<!-- 報告書の一行分(複数可) -->
												<div class="report_a_line">
													<!-- 出力用 -->
													<div class="item-output">
														<div><!-- 項目名 --> 案件：
															<parts:dlabel path="lblIndex" />
															<parts:dlabel path="ID_Create_NG" />
														</div>
													</div>
												</div>
												<div class="report_a_line">
													<!-- 入力用 -->
													<div class="item-input">
														<div><!-- 項目名 --> 選択</div>
														<div><!-- フォーム -->
															<parts:checkbox path="chkUpdate" id="chkUpdate" value = "1"></parts:checkbox></div>
													</div>
													<!-- 出力用 -->
													<div class="item-output">
														<div><!-- 項目名 --> 顧客名</div>
														<div><!-- 値 -->
															<parts:text path="ID_Name_Customer" id="ID_Name_Customer" maxlength="40" size="50" tabindex="-1" readonly="true" />
														</div>
													</div>
													<!-- 出力用 -->
													<div class="item-output">
														<div><!-- 項目名 --> 扱店名</div>
														<div><!-- 値 -->
															<parts:text path="ID_Name_Organization" id="ID_Name_Organization" maxlength="40" size="50" tabindex="-1" readonly="true" />
														</div>
													</div>
												</div>
												<!-- 報告書の一行分(複数可) -->
												<div class="report_a_line">
													<!-- 出力用 -->
													<div class="item-output">
														<div><!-- 項目名 --> 公庫支店</div>
														<div><!-- 値 -->
															<parts:text path="ID_Code_ShokanHonShiten" id="ID_Code_ShokanHonShiten" style="text-align:center;" maxlength="2" size="2" tabindex="-1" readonly="true" />
														</div>
													</div>
													<!-- 出力用 -->
													<div class="item-output">
														<div><!-- 項目名 --> 扱店</div>
														<div><!-- 値 -->
															<parts:text path="ID_Code_Organization" id="ID_Code_Organization" style="text-align:center;" maxlength="4" size="4" tabindex="-1" readonly="true" />
														</div>
													</div>
													<!-- 出力用 -->
													<div class="item-output">
														<div><!-- 項目名 --> 店舗</div>
														<div><!-- 値 -->
															<parts:text path="ID_Code_Tenpo" id="ID_Code_Tenpo" style="text-align:center;" maxlength="3" size="3" tabindex="-1" readonly="true" />
														</div>
													</div>
													<!-- 出力用 -->
													<div class="item-output">
														<div><!-- 項目名 --> 年度</div>
														<div><!-- 値 -->
															<%-- parts:text path="ID_Year" id="ID_Year" style="text-align:center;" maxlength="3" size="3" tabindex="-1" readonly="true" />--%>
															 <input type= "text" class="protect" style="text-align: center;" maxlength="3" size="3" tabindex="-1" readonly value="<pn:printWareki date='${record.ID_Year}' pattern='GY'/>"/>
														</div>
													</div>
													<!-- 出力用 -->
													<div class="item-output">
														<div><!-- 項目名 --> 方式資金</div>
														<div><!-- 値 -->
															<parts:text path="ID_Code_HoshikiShikin" id="ID_Code_HoshikiShikin" style="text-align:center;" maxlength="2" size="2" tabindex="-1" readonly="true" />
														</div>
													</div>
													<!-- 出力用 -->
													<div class="item-output">
														<div><!-- 項目名 --> 番号</div>
														<div><!-- 値 -->
															<parts:text path="ID_ID_Ringi" id="ID_ID_Ringi" style="text-align:center;" maxlength="5" size="5" tabindex="-1" readonly="true" />
														</div>
													</div>
													<!-- 出力用 -->
													<div class="item-output">
														<div><!-- 項目名 --> 枝番</div>
														<div><!-- 値 -->
															<parts:text path="ID_ID_RingiBranch" id="ID_ID_RingiBranch" style="text-align:center;" maxlength="3" size="3" tabindex="-1" readonly="true" />
														</div>
													</div>
													<!-- 出力用 -->
													<div class="item-output">
														<div><!-- 項目名 --> 資金使途</div>
														<div><!-- 値 -->
															<parts:text path="ID_Code_ShikinShito" id="ID_Code_ShikinShito" style="text-align:center;" maxlength="4" size="4" tabindex="-1" readonly="true" />
														</div>
													</div>
													<!-- 出力用 -->
													<div class="item-output">
														<div><!-- 項目名 --> 事業別</div>
														<div><!-- 値 -->
															<parts:text path="ID_Code_Jigyobetsu" id="ID_Code_Jigyobetsu" style="text-align:center;" maxlength="2" size="2" tabindex="-1" readonly="true" />
														</div>
													</div>
												</div>
												<!-- 報告書の一行分(複数可) -->
												<div class="report_a_line">
													<!-- 出力用 -->
													<div class="item-output">
														<div><!-- 項目名 --> 利率(％)</div>
														<div><!-- 値 -->
															<parts:text path="ID_Riritsu" id="ID_Riritsu" style="text-align:center;" maxlength="5" size="6" tabindex="-1" readonly="true" />
														</div>
													</div>
													<!-- 出力用 -->
													<div class="item-output">
														<div><!-- 項目名 --> 特利区分</div>
														<div><!-- 値 -->
															<parts:text path="ID_Kubun_Tokuri" id="ID_Kubun_Tokuri" style="text-align:center;" maxlength="1" size="1" tabindex="-1" readonly="true" />
														</div>
													</div>
													<!-- 出力用 -->
													<div class="item-output">
														<div><!-- 項目名 --> 特利(％)</div>
														<div><!-- 値 -->
															<parts:text path="ID_Tokuri" id="ID_Tokuri" style="text-align:center;" maxlength="5" size="6" tabindex="-1" readonly="true" />
														</div>
													</div>
													<!-- 出力用 -->
													<div class="item-output">
														<div><!-- 項目名 --> 据置期限</div>
														<div><!-- 値 -->
															<%-- parts:text path="ID_Date_SueokiKigen" id="ID_Date_SueokiKigen" style="text-align:center;" maxlength="6" size="6" tabindex="-1" readonly="true" />--%>
															<input type= "text" class="protect" style="text-align: center;" maxlength="6" size="6" tabindex="-1" readonly value="<pn:printWareki date='${record.ID_Date_SueokiKigen}' pattern='GYM'/>"/>
														</div>
													</div>
													<!-- 出力用 -->
													<div class="item-output">
														<div><!-- 項目名 --> 償還期限</div>
														<div><!-- 値 -->
															<%-- parts:text path="ID_Date_ShokanKigen" id="ID_Date_ShokanKigen" style="text-align:center;" maxlength="6" size="6" tabindex="-1" readonly="true" />--%>
															<input type= "text" class="protect" style="text-align: center;" maxlength="6" size="6" tabindex="-1" readonly value="<pn:printWareki date='${record.ID_Date_ShokanKigen}' pattern='GYM'/>"/>
														</div>
													</div>
													<!-- 出力用 -->
													<div class="item-output">
														<div><!-- 項目名 --> 元利金払込日</div>
														<div><!-- 値 -->
															<parts:text path="ID_Date_GanrikinHaraiKomi" id="ID_Date_GanrikinHaraiKomi" style="text-align:center;" maxlength="5" size ="5" tabindex="-1" readonly="true" />
														</div>
													</div>
													<!-- 出力用 -->
													<div class="item-output">
														<div><!-- 項目名 --> 貸付実行日</div>
														<div><!-- 値 -->
															<%-- parts:text path="ID_Date_Jikko" id="ID_Date_Jikko" style="text-align:center;" maxlength="8" size="8" tabindex="-1" readonly="true" />--%>
															<input type= "text" class="protect" style="text-align: center;" maxlength="9" size="10" tabindex="-1" readonly value="<pn:printWareki date='${record.ID_Date_Jikko}' pattern='GYMD'/>"/>
														</div>
													</div>
												</div>
												<!-- 報告書の一行分(複数可) -->
												<div class="report_a_line">
													<!-- 出力用 -->
													<div class="item-output">
														<div>貸付実行金額(円)</div>
														<div>
															<parts:text path="ID_M_Kashitsuke" id="ID_M_Kashitsuke" style="text-align:right;" maxlength="11"  size="15" tabindex="-1" readonly="true" cssClass="format-number" />
														</div>
													</div>
													<!-- 出力用 -->
													<div class="item-output">
														<div>貸付実行時の資金交付額(円)</div>
														<div>
															<parts:text path="ID_M_ShikinKofu" id="ID_M_ShikinKofu" style="text-align:right;" maxlength="11" size="15"  tabindex="-1" readonly="true" cssClass="format-number"/>
														</div>
													</div>
													<!-- 出力用 -->
													<div class="item-output">
														<div>貸付実行時の貸付受入金受入額(円)</div>
														<div>
															<parts:text path="ID_M_KashitsukeUkeire" id="ID_M_KashitsukeUkeire" style="text-align:right;" maxlength="11" size="15"  tabindex="-1" readonly="true" cssClass="format-number"/>
														</div>
													</div>
													<!-- 出力用 -->
													<div class="item-output">
														<div>貸付受入金残高(円)</div>
														<div>
															<parts:text path="ID_M_KashitsukeukeireZan" id="ID_M_KashitsukeukeireZan" style="text-align:right;" maxlength="11" size="15"  tabindex="-1" readonly="true" cssClass="format-number"/>
														</div>
													</div>
												</div>
												<!-- 報告書の一行分(複数可) -->
												<div class="report_a_line">
													<!-- 入力用 -->
													<div class="item-input">
														<div>
															<!-- 項目名 -->
															払出元金充当日
														</div>
														<div>
															<!-- 値 -->
															<parts:select path="ID_Date_HaraidashiJuto_Gengo"
																id="ID_Date_HaraidashiJuto_Gengo" style="color:#003399;"
																onchange='change_dateHaraidashiJuto( ${index},
																  "${cr002_01Form.lblID_JtkshoriConfigMode}",
																  "${cr002_01Form.lblID_BizDate_Gengo}",
																  "${cr002_01Form.lblID_BizDate_Nen}",
																  "${cr002_01Form.lblID_BizDate_Tsuki}",
																  "${cr002_01Form.lblID_BizDate_PrevMonth_Gengo}",
																  "${cr002_01Form.lblID_BizDate_PrevMonth_Nen}",
																  "${cr002_01Form.lblID_BizDate_PrevMonth_Tsuki}")'>
																<parts:codeListOption categoryCode="00002" />
															</parts:select>
															<parts:text path="ID_Date_HaraidashiJuto_Nen"
																id="ID_Date_HaraidashiJuto_Nen"
																style="width:30px;text-align:center;" maxlength="2"
																size="2"
																onkeyup='change_dateHaraidashiJuto( ${index},
																  "${cr002_01Form.lblID_JtkshoriConfigMode}",
																  "${cr002_01Form.lblID_BizDate_Gengo}",
																  "${cr002_01Form.lblID_BizDate_Nen}",
																  "${cr002_01Form.lblID_BizDate_Tsuki}",
																  "${cr002_01Form.lblID_BizDate_PrevMonth_Gengo}",
																  "${cr002_01Form.lblID_BizDate_PrevMonth_Nen}",
																  "${cr002_01Form.lblID_BizDate_PrevMonth_Tsuki}")' />

															<label id="lblDateHaraidashiJutoNen">年</label>

															<parts:select
																path="ID_Date_HaraidashiJutoTsuki_Candidate"
																id="ID_Date_HaraidashiJutoTsuki_Candidate"
																style="color:#003399;"
																onchange='change_dateHaraidashiJuto( ${index},
																  "${cr002_01Form.lblID_JtkshoriConfigMode}",
																  "${cr002_01Form.lblID_BizDate_Gengo}",
																  "${cr002_01Form.lblID_BizDate_Nen}",
																  "${cr002_01Form.lblID_BizDate_Tsuki}",
																  "${cr002_01Form.lblID_BizDate_PrevMonth_Gengo}",
																  "${cr002_01Form.lblID_BizDate_PrevMonth_Nen}",
																  "${cr002_01Form.lblID_BizDate_PrevMonth_Tsuki}")'>
																<parts:codeListOption categoryCode="00003" />

															</parts:select>
															<label id="lblDateHaraidashiJutoTsuki">月</label>
															<parts:select path="ID_Date_HaraidashiJutoBi_Candidate"
																id="ID_Date_HaraidashiJutoBi_Candidate"
																style="color:#003399;"
																onchange='change_dateHaraidashiJuto( ${index},
																  "${cr002_01Form.lblID_JtkshoriConfigMode}",
																  "${cr002_01Form.lblID_BizDate_Gengo}",
																  "${cr002_01Form.lblID_BizDate_Nen}",
																  "${cr002_01Form.lblID_BizDate_Tsuki}",
																  "${cr002_01Form.lblID_BizDate_PrevMonth_Gengo}",
																  "${cr002_01Form.lblID_BizDate_PrevMonth_Nen}",
																  "${cr002_01Form.lblID_BizDate_PrevMonth_Tsuki}")'>
																<parts:codeListOption categoryCode="00004" />
															</parts:select>
															<label id="lblDateHaraidashiJutoBi">日</label>
														</div>
													</div>
													<div class="item-input">
														<div>
															<!-- 項目名 -->
															受託者勘定処理年月
														</div>
														<div>
															<parts:select path="ID_Date_Jtkshori_Gengo"
																id="ID_Date_Jtkshori_Gengo" style="color:#003399;"
																onchange="setHdnJtkshori(${index})">
																<parts:codeListOption categoryCode="00002" />
															</parts:select>
															<parts:hidden path="hdnID_Date_Jtkshori_Gengo"
																id="hdnID_Date_Jtkshori_Gengo${index}" value=""></parts:hidden>
															<c:if test='${cr002_01Form.lblID_JtkshoriConfigMode == "3"}'>
																<parts:text path="ID_Date_Jtkshori_Nen"
																	id="ID_Date_Jtkshori_Nen"
																	style="width:30px;text-align:center;" maxlength="2"
																	size="2" />
															</c:if>
															<c:if test='${cr002_01Form.lblID_JtkshoriConfigMode != "3"}'>
																<parts:text path="ID_Date_Jtkshori_Nen"
																	id="ID_Date_Jtkshori_Nen"
																	style="width:30px;text-align:center;" maxlength="2"
																	size="2" tabindex="-1" />
															</c:if>
															<label id="lblDateJtkshoriNen">年</label>
															<parts:select path="ID_Date_JtkshoriTsuki_Candidate"
																id="ID_Date_JtkshoriTsuki_Candidate"
																style="color:#003399;"
																onchange="setHdnJtkshori(${index})">
																<parts:codeListOption categoryCode="00003" />
															</parts:select>
															<parts:hidden path="hdnID_Date_JtkshoriTsuki_Candidate"
																id="hdnID_Date_JtkshoriTsuki_Candidate${index}" value=""></parts:hidden>
															<label id="lblDateJtkshoriTsuki">月</label>
														</div>
													</div>
													<!-- 入力用 -->
													<div class="item-input">
														<div>
															<!-- 項目名 -->
															資金払出額(円)
														</div>
														<div>
															<!-- 値 -->
															<parts:text path="ID_M_Haraidashi" id="ID_M_Haraidashi" style="text-align:right;" maxlength="11" size="15" cssClass="format-number" />
														</div>
													</div>
													<!-- 入力用 -->
													<div class="item-input">
														<div>
															<!-- 項目名 -->
															元金充当額(円)
														</div>
														<div>
															<!-- 値 -->
															<parts:text path="ID_M_Ganju" id="ID_M_Ganju" style="text-align:right;" maxlength="11" size="15" cssClass="format-number" />
														</div>
													</div>
												</div>
												<fieldset>
													<legend style="font-size: 9pt" align="left">
														元金充当の場合</legend>
													<!-- 報告書の一行分(複数可) -->
													<div class="report_a_line">
														<!-- 出力用 -->
														<div class="item-output">
															<div>
																<!-- 項目名 -->
																元金充当後貸付金残高(円)
															</div>
															<div>
																<!-- 値 -->
																<parts:text path="ID_M_KashitsukeZandakaAfterGanju" id="ID_M_KashitsukeZandakaAfterGanju" style="text-align:right;" maxlength="11" size="14" tabindex="-1" readonly="true" cssClass="format-number"/>
															</div>
														</div>
														<!-- 出力用 -->
														<div class="item-output">
															<div>
																<!-- 項目名 -->
																元金充当後第１回約定日
															</div>
															<div>
																<!-- 値 -->
																<%-- parts:text path="ID_Date_FirstYakujoAfterGanju" id="ID_Date_FirstYakujoAfterGanju" style="text-align:center;" maxlength="8" size="8" tabindex="-1" readonly="true" />--%>
																<input type= "text" class="protect" style="text-align: center;" maxlength="8" size="8" tabindex="-1" readonly value="<pn:printWareki date='${record.ID_Date_FirstYakujoAfterGanju}' pattern='GYMD'/>"/>
															</div>
														</div>
														<!-- 入力用 -->
														<div class="item-input">
															<div>
																<!-- 項目名 -->
																繰償事由コード
															</div>
															<div>
																<!-- 値 -->
																<parts:select path="ID_Code_KurishoJiyu" id="ID_Code_KurishoJiyu" style="color:#003399;">
																	<parts:options items="${cr002_01Form.CODE_KURISHOJIYU_PULLDOWN_LIST}" />
																</parts:select>
															</div>
														</div>
													</div>
													<!-- 報告書の一行分(複数可) -->
													<div class="report_a_line">
														<fieldset>
															<legend style="font-size: 9pt" align="left">
																期限固定償還の場合</legend>
															<!-- 入力用 -->
															<div class="item-input">
																<div>
																	<!-- 項目名 -->
																	元金充当後の元金均等額(円)
																</div>
																<div>
																	<!-- 値 -->
																	<parts:text path="ID_M_GankinKintoAfterGanju" id="ID_M_GankinKintoAfterGanju" style="text-align:right;" maxlength="11" size="15" cssClass="format-number"/>
																</div>
															</div>
															<!-- 入力用 -->
															<div class="item-input">
																<div>
																	<!-- 項目名 -->
																	元金充当後の元金不均等額(円)
																</div>
																<div>
																	<!-- 値 -->
																	<parts:text path="ID_M_GankinFukintoAfterGanju" id="ID_M_GankinFukintoAfterGanju" style="text-align:right;" maxlength="11" size="15" cssClass="format-number"/>
																</div>
															</div>
															<!-- 入力用 -->
															<div class="item-input">
																<div>
																	<!-- 項目名 -->
																	調整コード
																</div>
																<div>
																	<!-- 値 -->
																	<span id="ID_Code_Chosei_Candidate" style="color: #003399;">
																		<span>
																	 		<parts:radioButton path="ID_Code_Chosei" value="1">初回</parts:radioButton>
																			<parts:radioButton path="ID_Code_Chosei" value="2">最終回</parts:radioButton>
																			<parts:radioButton path="ID_Code_Chosei" value="">なし</parts:radioButton>
																		</span>
																	</span>
																</div>
															</div>
														</fieldset>
													</div>
													<!-- 隠し項目用 -->
													<!-- 報告書履歴・データコード（非表示) -->
													<div style="display: none;">
														<parts:text path="ID_DataCode" id="ID_DataCode" />
													</div>
													<!-- 隠し項目おしまい -->
												</fieldset>
											</div>
										</div> <!-- 報告書一枚終わり -->
									</td>
								</tr>
							</paging:record>
						</parts:table>
					</div>
				</paging:table>
			</div>
		</div>
		</parts:form><%@ include file="/jsp/incFooter.jsp"%>
	</body>
</html>