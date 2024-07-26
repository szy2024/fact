<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/jsp/incTop.jsp"%>
<%@ taglib prefix="pn" uri="http://partnernet.jfc.go.jp/tags/pn"%>

<%--================================================================================================
 * Project Name : パートナーネット開発
 * System Name  : パートナーネット
 * File Name    : md002_03.jsp
 *
 * <<Modification History>>
 * Version | Date       | Updated By            | Content
 * --------+------------+-----------------------+---------------------------------------------------
 * 1.0.0   | 2015/07/01 | 澤田　健一            | 新規作成
================================================================================================--%>

<html>
	<%@ include file="/jsp/incHeader.jsp"%>
	<head>
		<title><parts:message code="title.screenName"/></title>



		<link href="<%=request.getContextPath()%>/css/ukeireharaidashi_Mod.css" type="text/css" rel="stylesheet" />
		<script language="JavaScript" type="text/javascript" src="<%=request.getContextPath()%>ptncommon.js"></script>
		<script lang="JavaScript">
				<!--
				<%--
				- 送信ボタン押下時の処理
				--%>
			    function click_sendBtn() {
			        executeAction('../../md002/md002_01/Md002_01Send.form');
			    }
			    <%--
			    戻る押下時の処理
			    --%>
			    function click_backBtn() {
					executeAction('../../md000/md000_02/Md000_02Return.form');
			    }
		//-->
		</script>
	</head>
	<body onload="initTextFormat()">
		<parts:form modelAttribute="md002_01Form" action="./md002_01Init.form" id="Form1" method="post" onsubmit="return false;">
			<%@ include file="/jsp/incCommonHidden.jsp" %>
			<%@ include file="/jsp/incHeaderArea.jsp" %>
			<div id="main_scroll_area">
			<div class="header">
				<div class="title">
					<span class="Title" id="lblTitle"><parts:message code="title.screenName"/></span>
				</div>
			</div>
			<div class="help">
				<a href="#" onclick="openNewWindow('<%= request.getContextPath() %>/help/main_md002.html', false, false, false, 'width=800', 'height=500', false)">
					<font class="help">ヘルプ</font>
				</a>
			</div>
			<div class="main">
				<div class="greeting">
					<label id="lblDataMsg">取消対象報告書を用意しました。&#13;&#10;&#9;&#9;&#9;&#9;&#9;&#9;&#9;&#9;変更があれば下欄「受託者勘定処理年月」を入力し、「送信」ボタンを押してください。</label>
				</div>
				<div class="greeting">
					取消・修正対象報告書の一覧画面に戻る場合には「戻る」ボタンを押してください。
				</div>
				<!-- 操作ボタン -->
				<div class="buttons">
					<div style="display:none;">
						<parts:button id="btnUpdate" />
						<parts:button id="btnBack" />
					</div>
					<parts:button id="btnUpdate2" value="送信" onclick="clearTextFormat();click_sendBtn();" />
					<parts:button id="btnBack2" value="戻る" title="取消・修正対象報告書の一覧画面へ戻る" onclick="click_backBtn();" />
				</div>
				<!-- -------------------- -->
				<!-- status               -->
				<!-- -------------------- -->
				<div class="reportDate">報告年月日：
					<%-- parts:dlabel path="lblID_Date_Report" />--%>
					<fmt:parseDate value="${md002_01Form.lblID_Date_Report}" var="ID_Date_Report" pattern="yyyyMMdd" />
                    <fmt:formatDate value="${ID_Date_Report}" pattern="yyyy年MM月dd日(E)"/>
				</div>
				<div class="status">ステータス：
					<br />
					<div style="color:red;font-weight:bold;">
						<parts:errors path="*" cssClass="Error" />
					</div>
				</div>
				<div id="pnl_Red" style="margin-bottom:15px;">
				<parts:table id="formRedArea">
					<div class="page-break"><br/></div>
					<div class="report" style="height:524px"><!-- 報告書の一行分(複数可) --><parts:link id="" href=""></parts:link>
						<div class="kousei-aka">
							<parts:dlabel path="red_Area"></parts:dlabel>
							<%-- label id="lblID_Head_Red">取消内容</label>&nbsp;--%>
							<logic:equal path="lblID_Head_Red2"  value="Visible">
								<label id="lblID_Head_Red2" style="color:red;">赤</label>
							</logic:equal>
						</div>
						<!-- ジャンプ用アンカー(名前) -->
						<div align="center">
							<div class="report_a_line"><!-- 出力用 -->
								<div class="item-output">
									<div><!-- 項目名 --> 顧客名</div>
									<div><!-- 値 -->
										<parts:text path="txtID_Name_Customer_Red" id="txtID_Name_Customer_Red" maxlength="40" size="50" tabindex="-1" readonly="true" /></div>
								</div> <!-- 出力用 -->
								<div class="item-output">
									<div><!-- 項目名 --> 扱店名</div>
									<div><!-- 値 -->
										<parts:text path="txtID_Name_Organization_Red" id="txtID_Name_Organization_Red" maxlength="40" size="50" tabindex="-1" readonly="true" /></div>
								</div>
							</div> <!-- 報告書の一行分(複数可) -->
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
										<input type= "text" class="protect" style="text-align: center;" maxlength="4" size="4" tabindex="-1" readonly value="<pn:printWareki date='${md002_01Form.txtID_Year_Red}' pattern='GY'/>"/></div>
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
								<div class="item-output">
									<div><!-- 項目名 --> 資金使途</div>
									<div><!-- 値 -->
										<parts:text path="txtID_Code_ShikinShito_Red" id="txtID_Code_ShikinShito_Red" style="text-align: center;" maxlength="4" size="4" tabindex="-1" readonly="true" /></div>
								</div> <!-- 出力用 -->
								<div class="item-output">
									<div><!-- 項目名 --> 事業別</div>
									<div><!-- 値 -->
										<parts:text path="txtID_Code_Jigyobetsu_Red" id="txtID_Code_Jigyobetsu_Red" style="text-align: center;" maxlength="2" size="2" tabindex="-1" readonly="true" /></div>
								</div>
							</div> <!-- 報告書の一行分(複数可) -->
							<div class="report_a_line"><!-- 出力用 -->
								<div class="item-output">
									<div><!-- 項目名 --> 利率(%)</div>
									<div><!-- 値 -->
										<parts:text path="txtID_Riritsu_Red" id="txtID_Riritsu_Red" style="text-align: center;" maxlength="5" size="6" tabindex="-1" readonly="true" /></div>
								</div> <!-- 出力用 -->
								<div class="item-output">
									<div><!-- 項目名 --> 特利区分</div>
									<div><!-- 値 -->
										<parts:text path="txtID_Kubun_Tokuri_Red" id="txtID_Kubun_Tokuri_Red" style="text-align: center;" maxlength="1" size="1" tabindex="-1" readonly="true" /></div>
								</div> <!-- 出力用 -->
								<div class="item-output">
									<div><!-- 項目名 --> 特利(%)</div>
									<div><!-- 値 -->
										<parts:text path="txtID_Tokuri_Red" id="txtID_Tokuri_Red" style="text-align: center;" maxlength="5" size="6" tabindex="-1" readonly="true" /></div>
								</div> <!-- 出力用 -->
								<div class="item-output">
									<div><!-- 項目名 --> 据置期限</div>
									<div><!-- 値 -->
										<input type= "text" class="protect" style="text-align: center;" maxlength="6" size="6" tabindex="-1" readonly value="<pn:printWareki date='${md002_01Form.txtID_Date_SueokiKigen_Red}' pattern='GYM'/>"/></div>
								</div> <!-- 出力用 -->
								<div class="item-output">
									<div><!-- 項目名 --> 償還期限</div>
									<div><!-- 値 -->
										<input type= "text" class="protect" style="text-align: center;" maxlength="6" size="6" tabindex="-1" readonly value="<pn:printWareki date='${md002_01Form.txtID_Date_ShokanKigen_Red}' pattern='GYM'/>"/></div>
								</div> <!-- 出力用 -->
								<div class="item-output">
									<div><!-- 項目名 --> 元利金払込日</div>
									<div><!-- 値 -->
										<parts:text path="txtID_Date_GanrikinHaraikomi_Red" id="txtID_Date_GanrikinHaraikomi_Red" style="text-align: center;" maxlength="5" size="5" tabindex="-1" readonly="true" /></div>
								</div> <!-- 出力用 -->
								<div class="item-output">
									<div><!-- 項目名 --> 貸付実行日</div>
									<div><!-- 値 -->
										<input type= "text" class="protect" style="text-align: center;" maxlength="9" size="10" tabindex="-1" readonly value="<pn:printWareki date='${md002_01Form.txtID_Date_Kashitsukejikko_Red}' pattern='GYMD'/>"/></div>
								</div>
							</div> <!-- 報告書の一行分(複数可) -->
							<div class="report_a_line"><!-- 出力用 -->
								<div class="item-output">
									<div><!-- 項目名 --> 貸付実行金額(円)</div>
									<div><!-- 値 -->
										<parts:text path="txtID_M_Kashitsuke_Red" id="txtID_M_Kashitsuke_Red" style="text-align: right;" maxlength="11" size="15" tabindex="-1" readonly="true" cssClass="format-number"/></div>
								</div> <!-- 出力用 -->
								<div class="item-output">
									<div><!-- 項目名 --> 貸付実行時の資金交付額(円)</div>
									<div><!-- 値 -->
										<parts:text path="txtID_M_ShikinKofu_Red" id="txtID_M_ShikinKofu_Red" style="text-align: right;" maxlength="11" size="15" tabindex="-1" readonly="true" cssClass="format-number"/></div>
								</div> <!-- 出力用 -->
								<div class="item-output">
									<div><!-- 項目名 --> 貸付実行時の貸付受入金受入額(円)</div>
									<div><!-- 値 -->
										<parts:text path="txtID_M_KashitsukeUkeire_Red" id="txtID_M_KashitsukeUkeire_Red" style="text-align: right;" maxlength="11" size="15" tabindex="-1" readonly="true" cssClass="format-number"/></div>
								</div> <!-- 出力用 -->
								<div class="item-output">
									<div><!-- 項目名 --> 貸付受入金残高(円)</div>
									<div><!-- 値 -->
										<parts:text path="txtID_M_KashitsukeukeireZan_Red" id="txtID_M_KashitsukeukeireZan_Red" style="text-align: right;" maxlength="11" size="15" tabindex="-1" readonly="true" cssClass="format-number"/></div>
								</div>
							</div>
							<div class="report_a_line"><!-- 出力用 -->
								<div class="item-output">
									<div><!-- 項目名 --> 受託者勘定処理年月</div>
									<div><!-- 値 -->
										<input type= "text" class="protect" style="text-align: center;" maxlength="6" size="6" tabindex="-1" readonly value="<pn:printWareki date='${md002_01Form.txtID_Date_Jtkshori_Red}' pattern='GYM'/>"/></div>
								</div> <!-- 出力用 -->
								<div class="item-output">
									<div><!-- 項目名 --> 払出・元金充当日</div>
									<div><!-- 値 -->
										<input type= "text" class="protect" style="text-align: center;" maxlength="9" size="10" tabindex="-1" readonly value="<pn:printWareki date='${md002_01Form.txtID_Date_HaraidashiJuto_Red}' pattern='GYMD'/>"/></div>
								</div> <!-- 出力用 -->
								<div class="item-output">
									<div><!-- 項目名 --> 資金払出額(円)</div>
									<div><!-- 値 -->
										<parts:text path="txtID_M_Haraidashi_Red" id="txtID_M_Haraidashi_Red" style="text-align: right;" maxlength="11" size="15" tabindex="-1" readonly="true" cssClass="format-number"/></div>
								</div> <!-- 出力用 -->
								<div class="item-output">
									<div><!-- 項目名 --> 元金充当額(円)</div>
									<div><!-- 値 -->
										<parts:text path="txtID_M_Ganju_Red" id="txtID_M_Ganju_Red" style="text-align: right;" maxlength="11" size="15" tabindex="-1" readonly="true" cssClass="format-number"/></div>
								</div>
							</div>
							<div class="report_a_line"><!-- 出力用 -->
								<fieldset>
									<legend style="font-size: 9pt;" align="left">元金充当の場合</legend>
									<div class="item-output">
										<div><!-- 項目名 --> 元金充当後貸付金残高(円)</div>
										<div><!-- 値 -->
											<parts:text path="txtID_M_KashitsukeZandakaAfterGanju_Red" id="txtID_M_KashitsukeZandakaAfterGanju_Red" style="text-align: right;" maxlength="11" size="15" tabindex="-1" readonly="true" cssClass="format-number"/></div>
									</div>
									<div class="item-output">
										<div><!-- 項目名 --> 元金充当後第１回約定日</div>
										<div><!-- 値 -->
											<input type= "text" class="protect" style="text-align: center;" maxlength="9" size="10" tabindex="-1" readonly value="<pn:printWareki date='${md002_01Form.txtID_Date_FirstYakujoAfterGanju_Red}' pattern='GYMD'/>"/></div>
									</div> <!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 --> 繰償事由コード</div>
										<div><!-- 値 -->
											<parts:text path="txtID_Code_KurishoJiyu_Red" id="txtID_Code_KurishoJiyu_Red" style="text-align: center;" maxlength="2" size="2" tabindex="-1" readonly="true" /></div>
									</div>
									<div class="report_a_line">
										<fieldset>
											<legend style="font-size: 9pt;" align="left">期限固定償還の場合</legend>
											<div class="item-output">
												<div><!-- 項目名 --> 元金充当後の元金均等額(円)</div>
												<div><!-- 値 -->
													<parts:text path="txtID_M_GankinKintoAfterGanju_Red" id="txtID_M_GankinKintoAfterGanju_Red" style="text-align: right;" maxlength="11" size="15" tabindex="-1" readonly="true" cssClass="format-number"/></div>
											</div>
											<div class="item-output">
												<div><!-- 項目名 --> 元金充当後の元金不均等額(円)</div>
												<div><!-- 値 -->
													<parts:text path="txtID_M_GankinFukintoAfterGanju_Red" id="txtID_M_GankinFukintoAfterGanju_Red" style="text-align: right;" maxlength="11" size="15" tabindex="-1" readonly="true" cssClass="format-number"/></div>
											</div>
											<div class="item-output">
												<div><!-- 項目名 --> 調整コード</div>
												<div><!-- 値 -->
													<span id="rdoID_Code_Chosei_Red" style="color:#003399;">
														<parts:radioButton path="rdoID_Code_Chosei_Red" value="1" disabled="true">初回</parts:radioButton>
														<parts:radioButton path="rdoID_Code_Chosei_Red" value="2" disabled="true">最終回</parts:radioButton>
														<parts:radioButton path="rdoID_Code_Chosei_Red" value="" disabled="true">なし</parts:radioButton>
													</span>
												</div>
											</div>
										</fieldset>
									</div>
								</fieldset>
							</div>
							<div class="report_a_line"><!-- 入力用 -->
								<div class="item-input">
									<div>受託者勘定処理年月</div>
									<div>
										<parts:select path="ID_Date_Jtkshori_Gengo_Red" id="ID_Date_Jtkshori_Gengo_Red" style="color:#003399;">
											<parts:codeListOption categoryCode="00002" />
										</parts:select>
										<parts:text path="ID_Date_Jtkshori_Nen_Red" id="ID_Date_Jtkshori_Nen_Red" style="width:30px;text-align: center;" maxlength="2" size="2" />
										<label id="lblDateJtkshoriNen_Red">年</label>
										<parts:select path="drpID_Date_JtkshoriTsuki_Red" id="drpID_Date_JtkshoriTsuki_Red" style="color:#003399;">
											<parts:codeListOption categoryCode="00003" />
										</parts:select>
										<label id="lblDateJtkshoriTsuki_Red">月</label>
									</div>
								</div>
							</div>
						</div> <!-- 報告書一枚終わり -->
					</div>
				</parts:table>
				</div>
				<div id="pnl_Mod">
				<parts:table id="formBlackArea">
					<div class="page-break"><br/></div>
					<div class="report" style="height:524px"><!-- 報告書の一行分(複数可) --><parts:link id="" href=""></parts:link>
						<div class="shusei">
							<parts:dlabel path="brack_Area"></parts:dlabel>
							<%-- label id="lblID_Head">修正内容</label>--%>
						</div>
						<!--DIV class="reportDate">報告年月日：yyyy年 mm月 dd日</DIV -->
						<div align="center">
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
										<input type= "text" class="protect" style="text-align: center;" maxlength="4" size="4" tabindex="-1" readonly value="<pn:printWareki date='${md002_01Form.txtID_Year}' pattern='GY'/>"/></div>
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
								<div class="item-output">
									<div><!-- 項目名 --> 資金使途</div>
									<div><!-- 値 -->
										<parts:text path="txtID_Code_ShikinShito" id="txtID_Code_ShikinShito" style="text-align: center;" maxlength="4" size="4" tabindex="-1" readonly="true" /></div>
								</div> <!-- 出力用 -->
								<div class="item-output">
									<div><!-- 項目名 --> 事業別</div>
									<div><!-- 値 -->
										<parts:text path="txtID_Code_Jigyobetsu" id="txtID_Code_Jigyobetsu" style="text-align: center;" maxlength="2" size="2" tabindex="-1" readonly="true" /></div>
								</div>
							</div> <!-- 報告書の一行分(複数可) -->
							<div class="report_a_line"><!-- 出力用 -->
								<div class="item-output">
									<div><!-- 項目名 --> 利率(%)</div>
									<div><!-- 値 -->
										<parts:text path="txtID_Riritsu" id="txtID_Riritsu" style="text-align: center;" maxlength="5" size="6" tabindex="-1" readonly="true" /></div>
								</div> <!-- 出力用 -->
								<div class="item-output">
									<div><!-- 項目名 --> 特利区分</div>
									<div><!-- 値 -->
										<parts:text path="txtID_Kubun_Tokuri" id="txtID_Kubun_Tokuri" style="text-align: center;" maxlength="1" size="1" tabindex="-1" readonly="true" /></div>
								</div> <!-- 出力用 -->
								<div class="item-output">
									<div><!-- 項目名 --> 特利(%)</div>
									<div><!-- 値 -->
										<parts:text path="txtID_Tokuri" id="txtID_Tokuri" style="text-align: center;" maxlength="5" size="6" tabindex="-1" readonly="true" /></div>
								</div> <!-- 出力用 -->
								<div class="item-output">
									<div><!-- 項目名 --> 据置期限</div>
									<div><!-- 値 -->
										<input type= "text" class="protect" style="text-align: center;" maxlength="6" size="6" tabindex="-1" readonly value="<pn:printWareki date='${md002_01Form.txtID_Date_SueokiKigen}' pattern='GYM'/>"/></div>
								</div> <!-- 出力用 -->
								<div class="item-output">
									<div><!-- 項目名 --> 償還期限</div>
									<div><!-- 値 -->
										<input type= "text" class="protect" style="text-align: center;" maxlength="6" size="6" tabindex="-1" readonly value="<pn:printWareki date='${md002_01Form.txtID_Date_ShokanKigen}' pattern='GYM'/>"/></div>
								</div> <!-- 出力用 -->
								<div class="item-output">
									<div><!-- 項目名 --> 元利金払込日</div>
									<div><!-- 値 -->
										<parts:text path="txtID_Date_GanrikinHaraikomi" id="txtID_Date_GanrikinHaraikomi" style="text-align: center;" maxlength="5" size="5" tabindex="-1" readonly="true" /></div>
								</div> <!-- 出力用 -->
								<div class="item-output">
									<div><!-- 項目名 --> 貸付実行日</div>
									<div><!-- 値 -->
										<input type= "text" class="protect" style="text-align: center;" maxlength="9" size="10" tabindex="-1" readonly value="<pn:printWareki date='${md002_01Form.txtID_Date_Jikko}' pattern='GYMD'/>"/></div>
								</div>
							</div> <!-- 報告書の一行分(複数可) -->
							<div class="report_a_line"><!-- 出力用 -->
								<div class="item-output">
									<div><!-- 項目名 --> 貸付実行金額(円)</div>
									<div><!-- 値 -->
										<parts:text path="txtID_M_Kashitsuke" id="txtID_M_Kashitsuke" style="text-align: right;" maxlength="11" size="15" tabindex="-1" readonly="true" cssClass="format-number"/></div>
								</div> <!-- 出力用 -->
								<div class="item-output">
									<div><!-- 項目名 --> 貸付実行時の資金交付額(円)</div>
									<div><!-- 値 -->
										<parts:text path="txtID_M_ShikinKofu" id="txtID_M_ShikinKofu" style="text-align: right;" maxlength="11" size="15" tabindex="-1" readonly="true" cssClass="format-number"/></div>
								</div> <!-- 出力用 -->
								<div class="item-output">
									<div><!-- 項目名 --> 貸付実行時の貸付受入金受入額(円)</div>
									<div><!-- 値 -->
										<parts:text path="txtID_M_KashitsukeUkeire" id="txtID_M_KashitsukeUkeire" style="text-align: right;" maxlength="11" size="15" tabindex="-1" readonly="true" cssClass="format-number"/></div>
								</div> <!-- 出力用 -->
								<div class="item-output">
									<div><!-- 項目名 --> 貸付受入金残高(円)</div>
									<div><!-- 値 -->
										<parts:text path="txtID_M_KashitsukeukeireZan" id="txtID_M_KashitsukeukeireZan" style="text-align: right;" maxlength="11" size="15" tabindex="-1" readonly="true" cssClass="format-number"/></div>
								</div>
							</div>
							<div class="report_a_line"><!-- 出力用 -->
								<div class="item-output">
									<div><!-- 項目名 --> 受託者勘定処理年月</div>
									<div><!-- 値 -->
										<input type= "text" class="protect" style="text-align: center;" maxlength="6" size="6" tabindex="-1" readonly value="<pn:printWareki date='${md002_01Form.txtID_Date_Jtkshori}' pattern='GYM'/>"/></div>
								</div> <!-- 出力用 -->
								<div class="item-input">
									<div><!-- 項目名 --> 払出・元金充当日</div>
									<div><!-- 値 -->
										<parts:select path="ID_Date_HaraidashiJuto_Gengo" id="ID_Date_HaraidashiJuto_Gengo" style="color:#003399;">
											<parts:codeListOption categoryCode="00002" />
										</parts:select>
										<parts:text path="ID_Date_HaraidashiJuto_Nen" id="ID_Date_HaraidashiJuto_Nen" style="width:30px;text-align: center;" maxlength="2" size="2" />
										<label id="lblDateHaraidashiJutoNen">年</label>
										<parts:select path="drpID_Date_HaraidashiJutoTsuki" id="drpID_Date_HaraidashiJutoTsuki" style="color:#003399;">
											<parts:codeListOption categoryCode="00003" />
										</parts:select>
										<label id="lblDateHaraidashiJutoTsuki">月</label>
										<parts:select path="lblDateHaraidashiJutoBi" id="lblDateHaraidashiJutoBi" style="color:#003399;">
											<parts:codeListOption categoryCode="00004" />
										</parts:select>
										<label id="lblDateHaraidashiJutoBi">日</label>
									</div>
								</div> <!-- 出力用 -->
								<div class="item-input">
									<div><!-- 項目名 --> 資金払出額(円)</div>
									<div><!-- 値 -->
										<parts:text path="txtID_M_Haraidashi" id="txtID_M_Haraidashi" style="text-align: right;" maxlength="11" size="15" cssClass="format-number"/></div>
								</div> <!-- 出力用 -->
								<div class="item-input">
									<div><!-- 項目名 --> 元金充当額(円)</div>
									<div><!-- 値 -->
										<parts:text path="txtID_M_Ganju" id="txtID_M_Ganju" style="text-align: right;" maxlength="11" size="15" cssClass="format-number"/></div>
								</div>
							</div>
							<div class="report_a_line"><!-- 出力用 -->
								<fieldset>
									<legend style="font-size: 9pt;" align="left">元金充当の場合</legend>
									<div class="item-output">
										<div><!-- 項目名 --> 元金充当後貸付金残高(円)</div>
										<div><!-- 値 -->
											<parts:text path="txtID_M_KashitsukeZandakaAfterGanju" id="txtID_M_KashitsukeZandakaAfterGanju" style="text-align: right;" maxlength="11" size="15" tabindex="-1" readonly="true" cssClass="format-number"/></div>
									</div>
									<div class="item-output">
										<div><!-- 項目名 --> 元金充当後第１回約定日</div>
										<div><!-- 値 -->
											<input type= "text" class="protect" style="text-align: center;" maxlength="9" size="10" tabindex="-1" readonly value="<pn:printWareki date='${md002_01Form.txtID_Date_FirstYakujoAfterGanju}' pattern='GYMD'/>"/></div>

									</div> <!-- 出力用 -->
									<div class="item-input">
										<div><!-- 項目名 --> 繰償事由コード</div>
										<div><!-- 値 -->
											<parts:select path="drpID_Code_KurishoJiyu" id="drpID_Code_KurishoJiyu" style="color:#003399;text-align: center;">
												<parts:options items="${md002_01Form.CODE_KURISHOJIYU_PULLDOWN_LIST}" />
											</parts:select>
										</div>
									</div>
									<div class="report_a_line">
										<fieldset>
											<legend style="font-size: 9pt;" align="left">期限固定償還の場合</legend>
											<div class="item-input">
												<div><!-- 項目名 --> 元金充当後の元金均等額(円)</div>
												<div><!-- 値 -->
													<parts:text path="txtID_M_GankinKintoAfterGanju" id="txtID_M_GankinKintoAfterGanju" style="text-align: right;" maxlength="11" size="15" cssClass="format-number"/></div>
											</div>
											<div class="item-input">
												<div><!-- 項目名 --> 元金充当後の元金不均等額(円)</div>
												<div><!-- 値 -->
													<parts:text path="txtID_M_GankinFukintoAfterGanju" id="txtID_M_GankinFukintoAfterGanju" style="text-align: right;" maxlength="11" size="15" cssClass="format-number"/></div>
											</div>
											<div class="item-input">
												<div><!-- 項目名 --> 調整コード</div>
												<div><!-- 値 -->
													<span id="rdoID_Code_Chosei" style="color:#003399;">
														<parts:radioButton path="rdoID_Code_Chosei" value="1">初回</parts:radioButton>
														<parts:radioButton path="rdoID_Code_Chosei" value="2">最終回</parts:radioButton>
														<parts:radioButton path="rdoID_Code_Chosei" value="">なし</parts:radioButton>
													</span>
												</div>
											</div>
										</fieldset>
									</div>
								</fieldset>
							</div>
							<div class="report_a_line"><!-- 入力用 -->
								<div class="item-input">
									<div>受託者勘定処理年月</div>
									<div>
										<parts:select path="ID_Date_Jtkshori_Gengo" id="ID_Date_Jtkshori_Gengo" style="color:#003399;">
											<parts:codeListOption categoryCode="00002" />
										</parts:select>
										<parts:text path="ID_Date_Jtkshori_Nen" id="ID_Date_Jtkshori_Nen" style="width:30px;text-align: center;" maxlength="2" size="2" />
										<label id="lblDateJtkshoriNen">年</label>
										<parts:select path="drpID_Date_JtkshoriTsuki" id="drpID_Date_JtkshoriTsuki" style="color:#003399;">
											<parts:codeListOption categoryCode="00003" />
										</parts:select>
										<label id="lblDateJtkshoriTsuki">月</label>
									</div>
								</div>
							</div>
						</div>
					</div>
				</parts:table>
				</div>
				<br />
			</div>
		</div>
		</parts:form><%@ include file="/jsp/incFooter.jsp"%>
	</body>
</html>