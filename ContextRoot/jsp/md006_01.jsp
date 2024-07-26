    <%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/jsp/incTop.jsp" %>
<%--================================================================================================
 * Project Name : パートナーネット開発
 * System Name  : パートナーネット
 * File Name    : md006_01.jsp
 *
 * <<Modification History>>
 * Version | Date       | Updated By            | Content
 * --------+------------+-----------------------+---------------------------------------------------
 * 1.0.0   | 2015/07/01 | 矢嶋　洋              | 新規作成
================================================================================================--%>

<html>
	<%@ include file="/jsp/incHeader.jsp"%>
	<head>
    <script lang="JavaScript">
    <!--
    <%--
    - 検索ボタン押下時の処理
    --%>
    function click_updateBtn() {
        executeAction('../../md006/md006_01/Md006_01Send.form');
    }

    function click_backBtn() {
        executeAction('../../md000/md000_02/Md000_02Return.form');
    }

    //-->
    </script>

		<title><parts:message code="title.screenName"/></title>
		<link href="<%=request.getContextPath()%>/css/md006.css" type="text/css" rel="stylesheet" />
		<script language="JavaScript" type="text/javascript" src="<%= request.getContextPath() %>/js/ptncommon.js"></script>
	</head>
	<body onload="initTextFormat()">
        <parts:form modelAttribute="md006_01Form" id="Form1" method="post">
			<%@ include file="/jsp/incCommonHidden.jsp" %>
			<%@ include file="/jsp/incHeaderArea.jsp" %>
			<div id="main_scroll_area">
			<%@ taglib prefix="pn" uri="http://partnernet.jfc.go.jp/tags/pn" %>
			<div class="header">
				<div class="title"><label id="lblTitle" class="Title"><parts:message code="title.screenName"/></label></div>
			</div>
			<div class="help">
				<a href="#" onclick="openNewWindow('<%= request.getContextPath() %>/help/main_md006.html', false, false, false, 'width=800', 'height=500', false)">
					<font class="help">ヘルプ</font>
				</a>
			</div>
			<div class="main">
				<parts:table id="infoArea">
					<div class="greeting" style="white-space:nowrap">
						<label id="lblDataMsg">取消対象報告書を用意しました。&#13;&#10;&#9;&#9;&#9;&#9;&#9;&#9;&#9;&#9;変更があれば下欄「受託者勘定処理年月」を入力し、<br></label>
						<label id="lblDataMsg">「送信」ボタンを押してください。</label>
					</div>
				</parts:table>
				<div class="greeting">
					取消・修正対象報告書の一覧画面に戻る場合には「戻る」ボタンを押してください。
				</div>
				<!-- 操作ボタン -->
				<div class="buttons">
					<div style="display:none;">
						<parts:button id="btnBack" />
						<parts:button id="btnUpdate" />
					</div>
					<parts:button id="btnUpdate2" value="送信"  onclick="clearTextFormat();click_updateBtn();" />
					<parts:button id="btnBack2" value="戻る"  onclick="click_backBtn();" title="取消・修正対象報告書の一覧画面へ戻る" />
				</div>
				<!-- -------------------- -->
				<!-- status               -->
				<!-- -------------------- -->
				<div class="reportDate">報告年月日：
				<!--	<div class="Error"> -->
				<!--		<parts:dlabel path="lblID_Date_Report" /> -->
				<!--	</div></div> -->
				    <fmt:parseDate value="${md006_01Form.lblID_Date_Report}" var="ID_Date_Report" pattern="yyyyMMdd" />
                    <fmt:formatDate value="${ID_Date_Report}" pattern="yyyy年MM月dd日(E)"/>
                </div>
				<div class="status">ステータス：
					<br />
					<div style="color:red;font-weight:bold;">
                        <parts:errors path="*" /><span id="lblError"><parts:dlabel path="lblErr"/></span>
						<parts:dlabel path="lblMessage"/>
					</div>
				</div>
				<div align="center">
					<%-- 取消用データ表示領域 --%>
					<div id="pnl_Red" style="padding-bottom: 15px;">
					<parts:tr id="formRedArea">
					<div class="page-break"><br/></div>
						<!-- 報告書一枚(borderで囲んである,複数可) -->
						<!-- 実装時はASP.NETのユーザコントロールよびだし -->
						<!-- ジャンプ用アンカー(名前) -->
						<div class="report">
							<div class="kousei-aka">
								<!-- <parts:dlabel path="redAreaTitle"/></div>  -->
								<!-- ジャンプ用アンカー(名前) -->
								<parts:tr id="redAreaTitle1">更正　<span style="color:red;">赤</span></parts:tr>
                                <parts:tr id="redAreaTitle2">取消内容</parts:tr>
                            </div>
							<div align="center"><!-- 出力用 --> <!-- 報告書の一行分(複数可) -->
								<div class="report_a_line"><!-- 入力用 --> <!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 --> 顧客名</div>
										<div><!-- 値 -->
											<parts:text path="txtID_Name_Customer_Red" id="txtID_Name_Customer_Red" style="text-align:left;" maxlength="40" size="50" tabindex="-1" readonly="true" /></div>
									</div> <!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 --> 扱店名</div>
										<div><!-- 値 -->
											<parts:text path="txtID_Name_Organization_Red" id="txtID_Name_Organization_Red" style="text-align:left;" maxlength="40" size="50" tabindex="-1" readonly="true" /></div>
									</div>
								</div>
								<div class="report_a_line"><!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 --> 公庫支店</div>
										<div><!-- 値 -->
											<parts:text path="txtID_Code_KoukoShiten_Red" id="txtID_Code_KoukoShiten_Red" style="text-align: center;" maxlength="2" size="2" tabindex="-1" readonly="true" /></div>
									</div> <!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 --> 扱店</div>
										<div><!-- 値 -->
											<parts:text path="txtID_Code_Organization_Red" id="txtID_Code_Organization_Red" style="text-align: center;" maxlength="4" size="4" tabindex="-1" readonly="true" /></div>
									</div> <!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 --> 店舗</div>
										<div><!-- 値 -->
											<parts:text path="txtID_Code_Tenpo_Red" id="txtID_Code_Tenpo_Red" style="text-align: center;" maxlength="3" size="3" tabindex="-1" readonly="true" /></div>
									</div> <!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 --> 年度</div>
										<div><!-- 値 -->
										<!-- 	<parts:text path="txtID_Year_Red" id="txtID_Year_Red" style="text-align: center;" maxlength="4" size="4" tabindex="-1" readonly="true" /></div> -->
										  <input type= "text" class="protect" style="text-align: center;" maxlength="4" size="4" tabindex="-1" readonly value="<pn:printWareki date='${md006_01Form.txtID_Year_Red}' pattern='GY'/>"/></div>
									</div> <!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 --> 方式資金</div>
										<div><!-- 値 -->
											<parts:text path="txtID_Code_HoshikiShikin_Red" id="txtID_Code_HoshikiShikin_Red" style="text-align: center;" maxlength="2" size="2" tabindex="-1" readonly="true" /></div>
									</div> <!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 --> 番号</div>
										<div><!-- 値 -->
											<parts:text path="txtID_ID_Ringi_Red" id="txtID_ID_Ringi_Red" style="text-align: center;" maxlength="5" size="5" tabindex="-1" readonly="true" /></div>
									</div> <!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 --> 枝番</div>
										<div><!-- 値 -->
											<parts:text path="txtID_ID_RingiBranch_Red" id="txtID_ID_RingiBranch_Red" style="text-align: center;" maxlength="3" size="3" tabindex="-1" readonly="true" /></div>
									</div> <!-- 出力用 -->
								</div> <!-- 報告書の一行分(複数可) -->
								<div class="report_a_line"><!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 --> 入金日</div>
										<div><!-- 値 -->
										<!-- 	<parts:text path="txtID_Date_Nyukin_Red" id="txtID_Date_Nyukin_Red" style="text-align: right;" maxlength="9" size="9" tabindex="-1" readonly="true" /></div>  -->
										<!--   <input type= "text"  style="text-align: right;" maxlength="9" size="9" tabindex="-1" readonly="true" value = "<pn:printWareki  date='<parts:dlabel path=txtID_Date_Nyukin_Red />' pattern='GYMD'/>"</div> -->
										<input type= "text" class="protect" style="text-align: center;" maxlength="14" size="11" readonly value="<pn:printWareki date='${md006_01Form.txtID_Date_Nyukin_Red}' pattern='GYMD'/>"/></div>
									</div> <!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 --> 立替金利息(円)</div>
										<div><!-- 値 -->
											<parts:text path="txtID_M_TatekaeRisoku_Red" id="txtID_M_TatekaeRisoku_Red" style="text-align: right;" maxlength="11" size="15" readonly="true" cssClass="format-number" /></div>
									</div> <!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 --> 立替金(円)</div>
										<div><!-- 値 -->
											<parts:text path="txtID_M_Tatekae_Red" id="txtID_M_Tatekae_Red" style="text-align: right;" maxlength="11" size="15" readonly="true" cssClass="format-number" /></div>
									</div> <!-- 出力用 -->
								</div> <!-- 報告書の一行分(複数可) --> <!-- 出力用 -->
								<div class="item-output">
									<div><!-- 項目名 --> 仮受金(一般口)からの充当額(円)</div>
									<div><!-- 値 -->
										<parts:text path="txtID_M_KariukeIppanJuto_Red" id="txtID_M_KariukeIppanJuto_Red" style="text-align: right;" maxlength="11" size="15" readonly="true" cssClass="format-number" /></div>
								</div>
								<div class="report_a_line"><!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 --> 立替金の種類</div>
										<div><!-- 値 -->
										<!--	<parts:text path="txtID_Code_TatekaekinShurui_Red" id="txtID_Code_TatekaekinShurui_Red" style="text-align: center;" maxlength="10" size="10" tabindex="-1" readonly="true" /></div>-->
										<input type= "text" class="protect" style="text-align: center;" maxlength="10" size="10" readonly value="<parts:codeName code='${md006_01Form.txtID_Code_TatekaekinShurui_Red}' categoryCode='00006'/>"/></div>
									</div> <!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 --> 公庫立替日</div>
										<div><!-- 値 -->
										<!--  <parts:text path="txtID_Date_KoukoTatekae_Red" id="txtID_Date_KoukoTatekae_Red" style="text-align: center;" maxlength="14" size="11" readonly="true" /></div> -->
                                        <!--   <input type= "text"  style="text-align: center;" maxlength="14" size="11" readonly="true" value = "<pn:printWareki date='${txtID_Date_KoukoTatekae_Red}' pattern='GYMD'/>"/></div> -->
                                        <input type= "text" class="protect" style="text-align: center;" maxlength="14" size="11" readonly value="<pn:printWareki date='${md006_01Form.txtID_Date_KoukoTatekae_Red}' pattern='GYMD'/>"/></div>
									</div> <!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 --> 計(円)</div>
										<div><!-- 値 -->
											<parts:text path="txtID_M_Kei_Red" id="txtID_M_Kei_Red" style="text-align: right;" maxlength="11" size="15" tabindex="-1" readonly="true"  cssClass="format-number"/></div>
									</div> <!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 --> 送金額(円)</div>
										<div><!-- 値 -->
											<parts:text path="txtID_M_Sokin_Red" id="txtID_M_Sokin_Red" style="text-align: right;" maxlength="11" size="15" tabindex="-1" readonly="true" cssClass="format-number" /></div>
									</div> <!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 --> 受入後立替金残高(円)</div>
										<div><!-- 値 -->
											<parts:text path="txtID_M_TatekaeZanAfterUkeire_Red" id="txtID_M_TatekaeZanAfterUkeire_Red" style="text-align: right;" maxlength="11" size="15" tabindex="-1" readonly="true" cssClass="format-number" /></div>
									</div> <!-- 入力用 -->
								</div> <!-- 報告書の一行分(複数可) -->
								<div class="report_a_line"><!-- 入力用 -->
									<div class="item-output">
										<div>受託者勘定処理年月</div>
										<div>
										<!--	<parts:text path="txtID_Date_Jtkshori_Red" id="txtID_Date_Jtkshori_Red" style="text-align: center;" maxlength="6" size="6" tabindex="-1" readonly="true" /></div> -->
                                        <!--  <input type= "text"  style="text-align: center;" maxlength="6" size="6" tabindex="-1" readonly="true" value = "<pn:printWareki date='${txtID_Date_Jtkshori_Red}' pattern='GYMD'/>"/></div> -->
									   <input type= "text" class="protect" style="text-align: center;" maxlength="6" size="6" tabindex="-1"  readonly value="<pn:printWareki date='${md006_01Form.txtID_Date_Jtkshori_Red}' pattern='GYM'/>"/></div>
									</div>
									<div class="item-output">
										<div>送金日</div>
										<div>
										<!-- <parts:text path="txtID_Date_Sokin_Red" id="txtID_Date_Sokin_Red" style="text-align: center;" maxlength="8" size="8" readonly="true" /></div> -->
                                        <!-- <input type= "text"  style="text-align: center;" maxlength="8" size="8" readonly="true" value = "<pn:printWareki date='${txtID_Date_Sokin_Red}' pattern='GYMD'/>"/></div> -->
                                        <input type= "text" class="protect" style="text-align: center;" maxlength="8" size="8" readonly value="<pn:printWareki date='${md006_01Form.txtID_Date_Sokin_Red}' pattern='GYMD'/>"/></div>
									</div>
									<div class="item-output">
										<div>送金日番号</div>
										<div>
											<parts:text path="txtID_ID_Sokinbi_Red" id="txtID_ID_Sokinbi_Red" style="text-align: center;" maxlength="3" size="3" readonly="true" /></div>
									</div> <!-- 入力用 -->
								</div> <!-- 報告書の一行分(複数可) -->
								<div class="report_a_line"><!-- 入力用 -->
									<div class="item-input">
										<div>受託者勘定処理年月</div>
										<div>
											<parts:select path="drpID_Date_Jtkshori_Gengou_Red" id="drpID_Date_Jtkshori_Gengou_Red" style="color:#003399;">
											     <parts:codeListOption categoryCode="00002"/>
											</parts:select>
											<parts:text path="txtID_Date_Jtkshori_Year_Red" id="txtID_Date_Jtkshori_Year_Red" style="width:30px;text-align: center;" maxlength="2" size="2" />
											<label id="lblDateJtkshori_Year_Red">年</label>
											<parts:select path="drpID_Date_Jtkshori_Month_Red" id="drpID_Date_Jtkshori_Month_Red" style="color:#003399;">
												<parts:codeListOption categoryCode="00003"/>
											</parts:select>
											<label id="lblDateJtkshori_Month_Red">月</label></div>
									</div>
								</div>
							</div>
						</div> <!-- 報告書一枚終わり -->
						<div></div>
						<div></div>
					</parts:tr>
					</div>
					<%-- 修正用データ表示領域 --%>
					<div id="pnl_Mod">
					<parts:tr id="formBlackArea">
					<div class="page-break"><br/></div>
						<!-- 報告書一枚(borderで囲んである,複数可) -->
						<!-- ジャンプ用アンカー(名前) -->
						<div class="report">
							<div class="shusei">
								<parts:dlabel path="blackAreaTitle"/></div>
							<div align="center"><!-- 報告書の一行分(複数可) -->
								<div class="report_a_line"><!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 --> 顧客名</div>
										<div><!-- 値 -->
											<parts:text path="txtID_Name_Customer" id="txtID_Name_Customer" maxlength="40" size="50" tabindex="-1" readonly="true" /></div>
									</div> <!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 --> 扱店名</div>
										<div><!-- 値 -->
											<parts:text path="txtID_Name_Organization" id="txtID_Name_Organization" maxlength="40" size="50" tabindex="-1" readonly="true" /></div>
									</div>
								</div> <!-- 報告書の一行分(複数可) -->
								<div class="report_a_line"><!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 --> 公庫支店</div>
										<div><!-- 値 -->
											<parts:text path="txtID_Code_KoukoShiten" id="txtID_Code_KoukoShiten" style="text-align: center;" maxlength="2" size="2" tabindex="-1" readonly="true" /></div>
									</div> <!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 --> 扱店</div>
										<div><!-- 値 -->
											<parts:text path="txtID_Code_Organization" id="txtID_Code_Organization" style="text-align: center;" maxlength="4" size="4" tabindex="-1" readonly="true" /></div>
									</div> <!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 --> 店舗</div>
										<div><!-- 値 -->
											<parts:text path="txtID_Code_Tenpo" id="txtID_Code_Tenpo" style="text-align: center;" maxlength="3" size="3" tabindex="-1" readonly="true" /></div>
									</div> <!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 --> 年度</div>
										<div><!-- 値 -->
										<!-- 	<parts:text path="txtID_Year" id="txtID_Year" style="text-align: center;" maxlength="4" size="4" tabindex="-1" readonly="true" /></div> -->
								        <input type= "text" class="protect" style="text-align: center;" maxlength="4" size="4" tabindex="-1" readonly value="<pn:printWareki date='${md006_01Form.txtID_Year}' pattern='GY'/>"/></div>
									</div> <!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 --> 方式資金</div>
										<div><!-- 値 -->
											<parts:text path="txtID_Code_HoshikiShikin" id="txtID_Code_HoshikiShikin" style="text-align: center;" maxlength="2" size="2" tabindex="-1" readonly="true" /></div>
									</div> <!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 --> 番号</div>
										<div><!-- 値 -->
											<parts:text path="txtID_ID_Ringi" id="txtID_ID_Ringi" style="text-align: center;" maxlength="5" size="5" tabindex="-1" readonly="true" /></div>
									</div> <!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 --> 枝番</div>
										<div><!-- 値 -->
											<parts:text path="txtID_ID_RingiBranch" id="txtID_ID_RingiBranch" style="text-align: center;" maxlength="3" size="3" tabindex="-1" readonly="true" /></div>
									</div> <!-- 出力用 -->
								</div> <!-- 報告書の一行分(複数可) -->
								<div class="report_a_line"><!-- 出力用 -->
									<div class="item-input">
										<div><!-- 項目名 --> 入金日</div>
										<div><!-- 値 -->
											<parts:select path="drpID_Date_Nyukin_Gengou" id="drpID_Date_Nyukin_Gengou">
												<parts:codeListOption categoryCode="00002"/>
											</parts:select>
											<parts:text path="txtID_Date_Nyukin_Year" id="txtID_Date_Nyukin_Year" style="width:30px;text-align: center;" maxlength="2" size="2" />年
											<parts:select path="drpID_Date_Nyukin_Month" id="drpID_Date_Nyukin_Month">
												<parts:codeListOption categoryCode="00003"/>
											</parts:select>月
											<parts:select path="drpID_Date_Nyukin_Day" id="drpID_Date_Nyukin_Day">
												<parts:codeListOption categoryCode="00004"/>
											</parts:select>日
										</div>
									</div> <!-- 出力用 -->
									<div class="item-input">
										<div><!-- 項目名 --> 立替金利息(円)</div>
										<div><!-- 値 -->
											<parts:text path="txtID_M_TatekaeRisoku" id="txtID_M_TatekaeRisoku" style="text-align: right;" maxlength="11" size="15" cssClass="format-number" /></div>
									</div> <!-- 出力用 -->
									<div class="item-input">
										<div><!-- 項目名 --> 立替金(円)</div>
										<div><!-- 値 -->
											<parts:text path="txtID_M_Tatekae" id="txtID_M_Tatekae" style="text-align: right;" maxlength="11" size="15" cssClass="format-number" /></div>
									</div>
									<div class="item-input">
										<div><!-- 項目名 --> 仮受金(一般口)からの充当額(円)</div>
										<div><!-- 値 -->
											<parts:text path="txtID_M_KariukeIppanJuto" id="txtID_M_KariukeIppanJuto" style="text-align: right;" maxlength="11" size="15" cssClass="format-number" /></div>
									</div>
								</div> <!-- 報告書の一行分(複数可) -->
								<div class="report_a_line"><!-- 出力用 --> <!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 --> 立替金の種類</div>
										<div><!-- 値 -->
											<!--<parts:text path="txtID_Code_TatekaekinShurui" id="txtID_Code_TatekaekinShurui" style="text-align: center;" maxlength="14" size="11" tabindex="-1" readonly="true" /></div> -->
									       <input type= "text" class="protect" style="text-align: center;" maxlength="10" size="10" readonly value="<parts:codeName code='${md006_01Form.txtID_Code_TatekaekinShurui}' categoryCode='00006'/>"/></div>
									</div>
									<div class="item-output">
										<div><!-- 項目名 --> 公庫立替日</div>
										<div><!-- 値 -->
										<!-- <parts:text path="txtID_Date_KoukoTatekae" id="txtID_Date_KoukoTatekae" style="text-align: center;" maxlength="14" size="11" tabindex="-1" readonly="true" /></div> -->
                                        <!-- <input type= "text"  style="text-align: center;" maxlength="14" size="11" tabindex="-1" readonly="true" value = "<pn:printWareki date='${txtID_Date_KoukoTatekae}' pattern='GYMD'/>"/></div> -->
                                        <input type= "text" class="protect" style="text-align: center;" maxlength="14" size="11" tabindex="-1" readonly value="<pn:printWareki date='${md006_01Form.txtID_Date_KoukoTatekae}' pattern='GYMD'/>"/></div>
									</div> <!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 --> 計(円)</div>
										<div><!-- 値 -->
											<parts:text path="txtID_M_Kei" id="txtID_M_Kei" style="text-align: right;" maxlength="11" size="15" tabindex="-1" readonly="true" cssClass="format-number" /></div>
									</div> <!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 --> 送金額(円)</div>
										<parts:text path="txtID_M_Sokin" id="txtID_M_Sokin" style="text-align: right;" maxlength="11" size="15" tabindex="-1" readonly="true" cssClass="format-number" />
										<div><!-- 値 --></div>
									</div> <!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 --> 受入後立替金残高(円)</div>
										<div><!-- 値 -->
											<parts:text path="txtID_M_TatekaeZanAfterUkeire" id="txtID_M_TatekaeZanAfterUkeire" style="text-align: right;" maxlength="11" size="15" tabindex="-1" readonly="true" cssClass="format-number" /></div>
									</div> <!-- 出力用 -->
								</div> <!-- 報告書の一行分(複数可) -->
								<div class="report_a_line"><!-- 入力用 -->
									<div class="item-output">
										<div>受託者勘定処理年月</div>
										<div>
										<!-- <parts:text path="txtID_Date_Jtkshori" id="txtID_Date_Jtkshori" style="text-align: center;" maxlength="6" size="6" tabindex="-1" readonly="true" /></div> -->
                                        <!-- <input type= "text"  style="text-align: center;" maxlength="6" size="6" tabindex="-1" readonly="true" value = "<pn:printWareki date='${txtID_Date_Jtkshori}' pattern='GYMD'/>"/></div> -->
                                        <input type= "text" class="protect" style="text-align: center;" maxlength="6" size="6" tabindex="-1" readonly value="<pn:printWareki date='${md006_01Form.txtID_Date_Jtkshori}' pattern='GYM'/>"/></div>
									</div> <!-- 入力用 -->
									<div class="item-input">
										<div>送金日</div>
										<div>
											<parts:select path="drpID_Date_Sokin_Gengou" id="drpID_Date_Sokin_Gengou" style="color:#003399;">
												<parts:option value=""></parts:option>
												<parts:codeListOption categoryCode="00002"/>
											</parts:select>
											<parts:text path="txtID_Date_Sokin_Year" id="txtID_Date_Sokin_Year" style="width:30px;text-align: center;" maxlength="2" size="2" />
											<label id="lblDate_Sokin_Year">年</label>
											<parts:select path="drpID_Date_Sokin_Month" id="drpID_Date_Sokin_Month" style="color:#003399;">
												<parts:codeListOption categoryCode="00003"/>
											</parts:select>
											<label id="lblDate_Sokin_Month">月</label>
											<parts:select path="drpID_Date_Sokin_Day" id="drpID_Date_Sokin_Day" style="color:#003399;">
												<parts:codeListOption categoryCode="00004"/>
											</parts:select>
											<label id="lblDate_Sokin_Day">日</label></div>
									</div>
									<div class="item-input">
										<div>送金日番号</div>
										<div>
											<parts:text path="txtID_ID_Sokinbi" id="txtID_ID_Sokinbi" style="text-align: center;" maxlength="3" size="3" /></div>
									</div> <!-- 入力用 -->
								</div>
								<div class="report_a_line"><!-- 入力用 -->
									<div class="item-input">
										<div>受託者勘定処理年月</div>
										<div>
											<parts:select path="drpID_Date_Jtkshori_Gengou" id="drpID_Date_Jtkshori_Gengou" style="color:#003399;">
												<parts:codeListOption categoryCode="00002"/>
											</parts:select>
											<parts:text path="txtID_Date_Jtkshori_Year" id="txtID_Date_Jtkshori_Year" style="width:30px;text-align: center;" maxlength="2" size="2" />
											<label id="lblDateJtkshori_Year">年</label>
											<parts:select path="drpID_Date_Jtkshori_Month" id="drpID_Date_Jtkshori_Month" style="color:#003399;">
												<parts:codeListOption categoryCode="00003"/>
											</parts:select>
											<label id="lblDateJtkshori_Month">月</label></div>
									</div>
								</div> <!-- 報告書の一行分(複数可) -->
							</div>
						</div>
						<div></div>
					</parts:tr>
					</div>
					<br />
				</div>
			</div>
		</div>
		</parts:form><%@ include file="/jsp/incFooter.jsp"%>
	</body>
</html>