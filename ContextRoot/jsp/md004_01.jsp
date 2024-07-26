<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/jsp/incTop.jsp" %>
<%--================================================================================================
 * Project Name : パートナーネット開発
 * System Name  : パートナーネット
 * File Name    : md004_03.jsp
 *
 * <<Modification History>>
 * Version | Date       | Updated By            | Content
 * --------+------------+-----------------------+---------------------------------------------------
 * 1.0.0   | 2015/07/01 | 小林　浩二            | 新規作成
================================================================================================--%>

<html>
	<head>
	<%@ include file="/jsp/incHeader.jsp"%>
		<title><parts:message code="title.screenName"/></title>
		<link href="<%= request.getContextPath() %>/css/md004.css"  type="text/css" rel="stylesheet" />
		<script language="JavaScript" type="text/javascript" src="<%= request.getContextPath() %>/js/ptncommon.js"></script>
		<script lang="JavaScript">
				<!--
				<%-- 送信ボタン押下時の処理 --%>
				function click_sendBtn() {
					executeAction('../../md004/md004_01/Md004_01Send.form');
			    }
				<%-- 戻る押下時の処理 --%>
				function click_backBtn() {
					executeAction('../../md000/md000_02/Md000_02Return.form');
				}
		//-->
		</script>
	</head>
	<body onload="initTextFormat()">
		<parts:form modelAttribute="md004_01Form"  id="Form1" method="post">
			<%@ include file="/jsp/incCommonHidden.jsp" %>
			<%@ include file="/jsp/incHeaderArea.jsp" %>
			<div id="main_scroll_area">
			<%@ taglib prefix="pn" uri="http://partnernet.jfc.go.jp/tags/pn" %>
			<div class="header">
				<div class="title">
					<span class="Title" id="lblTitle"><parts:message code="title.screenName"/></span>
				</div>
			</div>
			<div class="help">
				<a href="#" onclick="openNewWindow('<%= request.getContextPath() %>/help/main_md004.html', false, false, false, 'width=800', 'height=500', false)">
					<font class="help">ヘルプ</font>
				</a>
			</div>
			<div class="main">
				<div class="greeting">
					<label id="lblDataMsg">
					取消対象報告書を用意しました。
					<br />
					変更があれば下欄「受託者勘定処理年月」を入力し、「送信」ボタンを押してください。<br /></label>
					取消・修正対象報告書の一覧画面に戻る場合には「戻る」ボタンを押してください。
				</div>
				<!-- 操作ボタン -->
				<div class="buttons">
					<div style="display:none;">
						<parts:button id="btnUpdate" />
						<parts:button id="btnBack" title="取消・修正対象報告書の一覧画面へ戻る" />
					</div>
					<parts:button id="btnUpdate2" value="送信" onclick="clearTextFormat();click_sendBtn();" />
					<parts:button id="btnBack2" value="戻る" title="取消・修正対象報告書の一覧画面へ戻る" onclick="click_backBtn();" /><br />
				</div>
				<div class="reportDate">
					報告年月日：
				    <fmt:parseDate value="${md004_01Form.getID_Date_Report()}" var="ID_Date_Report" pattern="yyyyMMdd" />
					<fmt:formatDate value="${ID_Date_Report}" pattern="yyyy年MM月dd日(E)"/>
				</div>
				<div class="status">ステータス：
					<br />
					<div style="color:red;font-weight:bold;">
						<parts:errors path="*" cssClass="Error" />
					</div>
				</div>
				<div align="center">
					<%-- 取消用データ表示領域 --%>
					<logic:equal path="RedArea" value="true">
						<div id="pnl_Red" style="padding-bottom: 15px;">
						<div class="page-break"><br/></div>
							<div class="report">
								<div class="kousei-aka">
									<parts:dlabel path="lblID_Head_Red"/>
									<logic:equal path="lblID_Head_Red2"  value="true">
										<label id="lblID_Head_Red2" style="color:red;">赤</label>
									</logic:equal>
								</div>
								<div align="center">
									<div class="report_a_line">
										<div class="item-output-cust">
											<div>顧客名</div>
											<div><parts:text path="txtID_Name_Customer_Red" id="txtID_Name_Customer_Red" maxlength="40" size="50" tabindex="-1" readonly="true" /></div>
										</div>
										<div class="item-output-org">
											<div>扱店名</div>
											<div><parts:text path="txtID_Name_Organization_Red" id="txtID_Name_Organization_Red" maxlength="40" size="50" tabindex="-1" readonly="true" /></div>
										</div>
									</div>
									<div class="report_a_line">
										<div class="item-output">
											<div>公庫支店</div>
											<div><parts:text path="txtID_Code_KoukoShiten_Red" id="txtID_Code_KoukoShiten_Red" style="text-align: center;" maxlength="2" size="2" tabindex="-1" readonly="true" /></div>
										</div>
										<div class="item-output">
											<div>扱店</div>
											<div><parts:text path="txtID_Code_Organization_Red" id="txtID_Code_Organization_Red" style="text-align: center;" maxlength="4" size="4" tabindex="-1" readonly="true" /></div>
										</div>
										<div class="item-output">
											<div>店舗</div>
											<div><parts:text path="txtID_Code_Tenpo_Red" id="txtID_Code_Tenpo_Red" style="text-align: center;" maxlength="3" size="3" tabindex="-1" readonly="true" /></div>
										</div>
										<div class="item-output">
											<div>年度</div>
											<div><input type= "text" class="protect" style="text-align: center;" maxlength="4" size="4" tabindex="-1" readonly value="<pn:printWareki date='${md004_01Form.getTxtID_Year_Red()}' pattern='GY'/>"/></div>
										</div>
										<div class="item-output">
											<div>方式資金</div>
											<div><parts:text path="txtID_Code_HoshikiShikin_Red" id="txtID_Code_HoshikiShikin_Red" style="text-align: center;" maxlength="2" size="2" tabindex="-1" readonly="true" /></div>
										</div>
										<div class="item-output">
											<div>番号</div>
											<div><parts:text path="txtID_ID_Ringi_Red" id="txtID_ID_Ringi_Red" style="text-align: center;" maxlength="5" size="5" tabindex="-1" readonly="true" /></div>
										</div>
										<div class="item-output">
											<div>枝番</div>
											<div><parts:text path="txtID_ID_RingiBranch_Red" id="txtID_ID_RingiBranch_Red" style="text-align: center;" maxlength="3" size="3" tabindex="-1" readonly="true" /></div>
										</div>
									</div>
									<div class="report_a_line">
										<div class="item-output">
											<div>償還後第1回払込期日</div>
											<div><input type= "text" class="protect" style="text-align: center;" maxlength="9" size="10" tabindex="-1" readonly value="<pn:printWareki date='${md004_01Form.getTxtDate_FirstHaraikomiAfterKuris_Red()}' pattern='GYMD'/>"/></div>
										</div>
										<div class="item-output">
											<div>入金日</div>
											<div><input type= "text" class="protect" style="text-align: center;" maxlength="9" size="10" tabindex="-1" readonly value="<pn:printWareki date='${md004_01Form.getTxtID_Date_Nyukin_Red()}' pattern='GYMD'/>"/></div>
										</div>
										<div class="item-output">
											<div>繰償事由コード</div>
											<div><parts:text path="txtID_Code_Kurishojiyu_Red" id="txtID_Code_Kurishojiyu_Red" style="text-align: center;" maxlength="2" size="2" tabindex="-1" readonly="true" /></div>
										</div>
									</div>
									<div class="report_a_line">
										<div class="item-output">
											<div>利息(円)</div>
											<div><parts:text path="txtID_M_KurishoRisoku_Red" id="txtID_M_KurishoRisoku_Red" style="text-align: right;" maxlength="11" size="15" tabindex="-1" readonly="true" cssClass="format-number" /></div>
										</div>
										<div class="item-output">
											<div>元金(円)</div>
											<div>
												<parts:text path="txtID_M_KurishoGankin_Red" id="txtID_M_KurishoGankin_Red" style="text-align: right;" maxlength="11" size="15" tabindex="-1" readonly="true" cssClass="format-number" /></div>
										</div>
										<div class="item-output">
											<div>控除利息(円)</div>
											<div><parts:text path="txtID_M_KojoRisoku_Red" id="txtID_M_KojoRisoku_Red" style="text-align: right;" maxlength="11" size="15" tabindex="-1" readonly="true" cssClass="format-number" /></div>
										</div>
										<div class="item-output">
											<div>繰上償還手数料(円)</div>
											<div><parts:text path="txtID_M_KurishoCommission_Red" id="txtID_M_KurishoCommission_Red" style="text-align: right;" maxlength="11" size="15" tabindex="-1" readonly="true" cssClass="format-number" /></div>
										</div>
									</div>
									<div class="report_a_line">
										<div class="item-output">
											<div>仮受金からの充当額(円)</div>
											<div><parts:text path="txtID_M_KariukeIppanJuto_Red" id="txtID_M_KariukeIppanJuto_Red" style="text-align: right;" maxlength="11" size="15" tabindex="-1" readonly="true" cssClass="format-number" /></div>
										</div>
										<div class="item-output">
											<div>送金額(円)</div>
											<div class="styleMoney"><parts:text path="txtID_M_Sokin_Red" id="txtID_M_Sokin_Red" style="text-align: right;" maxlength="11" size="15" tabindex="-1" readonly="true" cssClass="format-number" /></div>
										</div>
										<div class="item-output">
											<div>繰償後残元金(円)</div>
											<div class="styleMoney"><parts:text path="txtID_M_ZanGankinAfterKurisho_Red" id="txtID_M_ZanGankinAfterKurisho_Red" style="text-align: right;" maxlength="11" size="15" tabindex="-1" readonly="true" cssClass="format-number" /></div>
										</div>
									</div>
									<div class="report_a_line">
										<div class="item-output">
											<div>受託者勘定処理年月</div>
											<div><input type= "text" class="protect" style="text-align: center;" maxlength="6" size="6" tabindex="-1" readonly value="<pn:printWareki date='${md004_01Form.getTxtID_Date_JtkShori_Red()}' pattern='GYM'/>"/></div>
										</div>
										<div class="item-output">
											<div>送金日</div>
											<div><input type= "text" class="protect" style="text-align: center;" maxlength="9" size="10" tabindex="-1" readonly value="<pn:printWareki date='${md004_01Form.getTxtID_Date_Sokin_Red()}' pattern='GYMD'/>"/></div>
										</div>
										<div class="item-output">
											<div>送金日番号</div>
											<div><parts:text path="txtID_ID_Sokinbi_Red" id="txtID_ID_Sokinbi_Red" style="text-align: right;" maxlength="3" size="3" tabindex="-1" readonly="true" /></div>
										</div>
										<div class="item-output">
											<div>&nbsp;</div>
											<div>
												<span>
													<parts:checkbox value="1" path="chkID_ID_After_Daiibensai_Red" id="chkID_ID_After_Daiibensai_Red" style="text-align: right;" name="chkID_ID_After_Daiibensai_Red" disabled="true"/>
													<label for="chkID_ID_After_Daiibensai_Red">代弁履行後の作成</label>
												</span>
											</div>
										</div>
									</div>
									<div class="report_a_line">
										<div class="teikishokan">
											<fieldset id="teiki_Red" style="float:left">
												<legend style="font-size: 9pt; color: #0066ff;" align="left">◆定期償還の場合</legend>
												<div class="item-output">
													<parts:table>
														<tr>
															<td style="padding-right:2px">払込期日</td>
															<td style="padding-right:2px" >払込元金(円)</td>
														</tr>
														<tr>
															<td><!-- 払込期日１〜４ -->
																<input type= "text" class="protect" style="text-align: center;" maxlength="9" size="10" tabindex="-1" readonly value="<pn:printWareki date='${md004_01Form.getTxtID_Date_Haraikomi1_Red()}' pattern='GYMD'/>"/><br />
																<input type= "text" class="protect" style="text-align: center;" maxlength="9" size="10" tabindex="-1" readonly value="<pn:printWareki date='${md004_01Form.getTxtID_Date_Haraikomi2_Red()}' pattern='GYMD'/>"/><br />
																<input type= "text" class="protect" style="text-align: center;" maxlength="9" size="10" tabindex="-1" readonly value="<pn:printWareki date='${md004_01Form.getTxtID_Date_Haraikomi3_Red()}' pattern='GYMD'/>"/><br />
																<input type= "text" class="protect" style="text-align: center;" maxlength="9" size="10" tabindex="-1" readonly value="<pn:printWareki date='${md004_01Form.getTxtID_Date_Haraikomi4_Red()}' pattern='GYMD'/>"/>
															</td>
															<td><!-- 払込元金１〜４ -->
																<parts:text path="txtID_M_HaraikomiGankin1_Red" id="txtID_M_HaraikomiGankin1_Red" style="text-align: right;" maxlength="11" size="15" tabindex="-1" readonly="true" cssClass="format-number" /><br />
																<parts:text path="txtID_M_HaraikomiGankin2_Red" id="txtID_M_HaraikomiGankin2_Red" style="text-align: right;" maxlength="11" size="15" tabindex="-1" readonly="true" cssClass="format-number" /><br />
																<parts:text path="txtID_M_HaraikomiGankin3_Red" id="txtID_M_HaraikomiGankin3_Red" style="text-align: right;" maxlength="11" size="15" tabindex="-1" readonly="true" cssClass="format-number" /><br />
																<parts:text path="txtID_M_HaraikomiGankin4_Red" id="txtID_M_HaraikomiGankin4_Red" style="text-align: right;" maxlength="11" size="15" tabindex="-1" readonly="true" cssClass="format-number" />
															</td>
														</tr>
													</parts:table>
												</div>
											</fieldset>
											<fieldset id="gankin_Red">
												<legend style="font-size: 9pt; color: #0066ff;" align="left">◆元金均等償還・期限固定の場合</legend>
												<div class="item-output">
													<div>繰償後元金均等額(円)</div>
													<div><parts:text path="txtID_M_GankinKintoAfterKurisho_Red" id="txtID_M_GankinKintoAfterKurisho_Red" style="text-align: right;" maxlength="11" size="15" tabindex="-1" readonly="true" cssClass="format-number" /></div>
												</div>
												<div class="item-output">
													<div>繰償後元金不均等額(円)</div>
													<div><parts:text path="txtID_M_GankinFukintoAfterKurisho_Red" id="txtID_M_GankinFukintoAfterKurisho_Red" style="text-align: right;" maxlength="11" size="15" tabindex="-1" readonly="true" cssClass="format-number" /></div>
												</div>
												<div class="item-clear">
													<div class="item-output">調整コード<br />
														<span id="rdoID_Code_chosei_Red">
															<span>
																<parts:radioButton path="rdoID_Code_chosei_Red" id="rdoID_Code_chosei_Red_0" value="1" name="rdoID_Code_chosei_Red"  disabled="true"/>
																<label for="rdoID_Code_chosei_Red_0">初回</label></span>
															<span>
																<parts:radioButton path="rdoID_Code_chosei_Red" id="rdoID_Code_chosei_Red_1" value="2" name="rdoID_Code_chosei_Red"  disabled="true"/>
																<label for="rdoID_Code_chosei_Red_1">最終回</label></span>
															<span>
																<parts:radioButton path="rdoID_Code_chosei_Red" id="rdoID_Code_chosei_Red_2" value="" name="rdoID_Code_chosei_Red"  disabled="true"/>
																<label for="rdoID_Code_chosei_Red_2">なし</label></span>
														</span>
													</div>
												</div>
											</fieldset>
										</div>
									</div>
									<div class="report_a_line">
										<div class="item-input">
											<div>受託者勘定処理年月</div>
											<div>
												<parts:select path="drpID_Date_Jtkshori_Gengo_Red" id="drpID_Date_Jtkshori_Gengo_Red" style="color:#003399;" tabindex="1">
													<parts:codeListOption categoryCode="00002" />
												</parts:select>
												<parts:text path="txtID_Date_Jtkshori_Nen_Red" id="txtID_Date_Jtkshori_Nen_Red" style="width:30px;text-align: center;" maxlength="2" tabindex="2" size="2" />
												<label id="lblDateJtkshoriNen_Red">年</label>
												<parts:select path="drpID_Date_Jtkshori_Tsuki_Red" id="drpID_Date_Jtkshori_Tsuki_Red" style="color:#003399;" tabindex="3">
													<parts:codeListOption categoryCode="00003" />
												</parts:select>
												<label id="lblDateJtkshoriTsuki_Red">月</label>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</logic:equal>
					<%-- 修正用用データ表示領域 --%>
					<logic:equal path="BlackArea" value="true">
						<div id="pnl_Mod">
						<div class="page-break"><br/></div>
							<div class="report">
								<div class="shusei">
									<label id="lblID_Head"><parts:dlabel path="lblID_Head"/></label>
								</div>
								<div align="center">
									<div class="report_a_line">
										<div class="item-output-cust">
											<div> 顧客名</div>
											<div><parts:text path="txtID_Name_Customer" id="txtID_Name_Customer" maxlength="40" size="50" tabindex="-1" readonly="true" /></div>
										</div>
										<div class="item-output-org">
											<div>扱店名</div>
											<div><parts:text path="txtID_Name_Organization" id="txtID_Name_Organization" maxlength="40" size="50" tabindex="-1" readonly="true" /></div>
										</div>
									</div>
									<div class="report_a_line">
										<div class="item-output">
											<div>公庫支店</div>
											<div><parts:text path="txtID_Code_KoukoShiten" id="txtID_Code_KoukoShiten" style="text-align: center;" maxlength="2" size="2" tabindex="-1" readonly="true" /></div>
										</div>
										<div class="item-output">
											<div>扱店</div>
											<div><parts:text path="txtID_Code_Organization" id="txtID_Code_Organization" style="text-align: center;" maxlength="4" size="4" tabindex="-1" readonly="true" /></div>
										</div>
										<div class="item-output">
											<div>店舗</div>
											<div><parts:text path="txtID_Code_Tenpo" id="txtID_Code_Tenpo" style="text-align: center;" maxlength="3" size="3" tabindex="-1" readonly="true" /></div>
										</div>
										<div class="item-output">
											<div>年度</div>
                                            <div><input type= "text" class="protect" style="text-align: center;" maxlength="4" size="4" tabindex="-1" readonly value="<pn:printWareki date='${md004_01Form.getTxtID_Year()}' pattern='GY'/>"/></div>
										</div>
										<div class="item-output">
											<div>方式資金</div>
											<div><parts:text path="txtID_Code_HoshikiShikin" id="txtID_Code_HoshikiShikin" style="text-align: center;" maxlength="2" size="2" tabindex="-1" readonly="true" /></div>
										</div>
										<div class="item-output">
											<div>番号</div>
											<div><parts:text path="txtID_ID_Ringi" id="txtID_ID_Ringi" style="text-align: center;" maxlength="5" size="5" tabindex="-1" readonly="true" /></div>
										</div>
										<div class="item-output">
											<div>枝番</div>
											<div><parts:text path="txtID_ID_RingiBranch" id="txtID_ID_RingiBranch" style="text-align: center;" maxlength="3" size="3" tabindex="-1" readonly="true" /></div>
										</div>
									</div>
									<div class="report_a_line">
										<div class="item-input">
											<div>償還後第1回払込期日</div>
											<div>
												<parts:select path="drpDate_FirstHaraikomiAfterKuris_Gengo" id="drpDate_FirstHaraikomiAfterKuris_Gengo" style="color:#003399;" tabindex="4">
													<parts:codeListOption categoryCode="00002" />
												</parts:select>
												<parts:text path="txtDate_FirstHaraikomiAfterKuris_Nen" id="txtDate_FirstHaraikomiAfterKuris_Nen" style="width:30px;text-align: center;" maxlength="2" tabindex="4" size="2" />
												<label id="lblDateFirstHaraikomiAfterKurisho_Nen">年</label>
												<parts:select path="drpDate_FirstHaraikomiAfterKuris_Tsuki" id="drpDate_FirstHaraikomiAfterKuris_Tsuki" style="color:#003399;" tabindex="4">
													<parts:codeListOption categoryCode="00003" />
												</parts:select>
												<label id="lblDateFirstHaraikomiAfterKurisho_Tsuki">月</label>
												<parts:select path="drpDate_FirstHaraikomiAfterKuris_Bi" id="drpDate_FirstHaraikomiAfterKuris_Bi" style="color:#003399;" tabindex="4">
													<parts:codeListOption categoryCode="00004" />
												</parts:select>
												<label id="lblDateFirstHaraikomiAfterKurisho_Bi">日</label></div>
										</div>
										<div class="item-input">
											<div>入金日</div>
											<div>
												<parts:select path="drpID_Date_Nyukin_Gengo" id="drpID_Date_Nyukin_Gengo" style="color:#003399;" tabindex="4">
													<parts:codeListOption categoryCode="00002" />
												</parts:select>
												<parts:text path="txtID_Date_Nyukin_Nen" id="txtID_Date_Nyukin_Nen" style="width:30px;text-align: center;" maxlength="2" tabindex="4" size="2" />
												<label id="lblDateNyukin_Nen">年</label>
												<parts:select path="drpID_Date_Nyukin_Tsuki" id="drpID_Date_Nyukin_Tsuki" style="color:#003399;" tabindex="4">
													<parts:codeListOption categoryCode="00003" />
												</parts:select>
												<label id="lblDateNyukin_Tsuki">月</label>
												<parts:select path="drpID_Date_Nyukin_Bi" id="drpID_Date_Nyukin_Bi" style="color:#003399;" tabindex="4">
													<parts:codeListOption categoryCode="00004" />
												</parts:select>
												<label id="lblDateNyukin_Bi">日</label></div>
										</div>
										<div class="item-input">
											<div>繰償事由コード</div>
											<div>
												<parts:select path="drpID_Code_Kurishojiyu" id="drpID_Code_Kurishojiyu" style="color:#003399;" tabindex="4">
													<parts:options items="${md004_01Form.getCODE_KURISHOJIYU_PULL_LIST()}" />
												</parts:select>
											</div>
										</div>
									</div>
									<div class="report_a_line">
										<div class="item-input">
											<div>利息(円)</div>
											<div><parts:text path="txtID_M_KurishoRisoku" id="txtID_M_KurishoRisoku" style="text-align: right;" maxlength="11" size="15" tabindex="4" cssClass="format-number" /></div>
										</div>
										<div class="item-input">
											<div>元金(円)</div>
											<div><parts:text path="txtID_M_KurishoGankin" id="txtID_M_KurishoGankin" style="text-align: right;" maxlength="11" size="15" tabindex="4" cssClass="format-number" /></div>
										</div>
										<div class="item-input">
											<div>控除利息(円)</div>
											<div><parts:text path="txtID_M_KojoRisoku" id="txtID_M_KojoRisoku" style="text-align: right;" maxlength="11" size="15" tabindex="4" cssClass="format-number" /></div>
										</div>
										<div class="item-input">
											<div>繰上償還手数料(円)</div>
											<div><parts:text path="txtID_M_KurishoCommission" id="txtID_M_KurishoCommission" style="text-align: right;" maxlength="11" size="15" tabindex="4" cssClass="format-number" /></div>
										</div>
									</div>
									<div class="report_a_line">
										<div class="item-input">
											<div>仮受金からの充当額(円)</div>
											<div>
												<parts:text path="txtID_M_KariukeIppanJuto" id="txtID_M_KariukeIppanJuto" style="text-align: right;" maxlength="11" size="15" tabindex="4" cssClass="format-number" /></div>
										</div>
										<div class="item-output">
											<div>送金額(円)</div>
											<div class="styleMoney"><parts:text path="txtID_M_Sokin" id="txtID_M_Sokin" style="text-align: right;" maxlength="11" size="15" tabindex="-1" readonly="true" cssClass="format-number" /></div>
										</div>
										<div class="item-output">
											<div>繰償後残元金(円)</div>
											<div class="styleMoney"><parts:text path="txtID_M_ZanGankinAfterKurisho" id="txtID_M_ZanGankinAfterKurisho" style="text-align: right;" maxlength="11" size="15" tabindex="-1" readonly="true" cssClass="format-number" /></div>
										</div>
									</div>
									<div class="report_a_line">
										<div class="item-output">
											<div>受託者勘定処理年月</div>
											<div><input type= "text" class="protect" style="text-align: center;" maxlength="6" size="6" tabindex="-1" readonly value="<pn:printWareki date='${md004_01Form.getTxtID_Date_Jtkshori()}' pattern='GYM'/>"/></div>
										</div>
										<div class="item-input">
											<div>送金日</div>
											<div>
												<parts:select path="drpID_Date_Sokin_Gengo" id="drpID_Date_Sokin_Gengo" style="color:#003399;" tabindex="4">
													<parts:codeListOption categoryCode="00002" />
												</parts:select>
												<parts:text path="txtID_Date_Sokin_Nen" id="txtID_Date_Sokin_Nen" style="width:30px;text-align: center;" maxlength="2" tabindex="4" size="2" />
												<label id="lblDateSokin_Nen">年</label>
													<parts:select path="drpID_Date_Sokin_Tsuki" id="drpID_Date_Sokin_Tsuki" style="color:#003399;" tabindex="4">
													<parts:codeListOption categoryCode="00003" />
												</parts:select>
												<label id="lblDateSokin_Tsuki">月</label>
												<parts:select path="drpID_Date_Sokin_Bi" id="drpID_Date_Sokin_Bi" style="color:#003399;" tabindex="4">
													<parts:codeListOption categoryCode="00004" />
												</parts:select>
												<label id="lblDateSokin_Bi">日</label>
											</div>
										</div>
										<div class="item-input">
											<div>送金日番号</div>
											<div><parts:text path="txtID_ID_Sokinbi" id="txtID_ID_Sokinbi" style="text-align: right;" maxlength="3" size="3" tabindex="4" /></div>
										</div>
										<div class="item-input">
											<div>&nbsp;</div>
											<div>
												<span>
													<parts:checkbox value="1" path="chkID_ID_After_Daiibensai" id="chkID_ID_After_Daiibensai" style="text-align: right;" name="chkID_ID_After_Daiibensai" tabindex="4" />
													<label for="chkID_ID_After_Daiibensai">代弁履行後の作成</label>
												</span>
											</div>
										</div>
									</div>
									<div class="report_a_line">
										<div class="teikishokan">
											<fieldset id="teiki" style="float:left">
												<legend id="legend_teiki" align="left">◆定期償還の場合</legend>
												<div class="item-input">
													<parts:table>
														<tr>
															<td style="padding-right:2px">払込期日</td>
															<td style="padding-right:2px">払込元金(円)</td>
														</tr>
														<tr>
															<td><!-- 払込期日１ -->
																<parts:select path="drpID_Date_Haraikomi1_Gengo" id="drpID_Date_Haraikomi1_Gengo" style="color:#003399;" tabindex="4">
																	<parts:codeListOption categoryCode="00002" />
																</parts:select>
																<parts:text path="txtID_Date_Haraikomi1_Nen" id="txtID_Date_Haraikomi1_Nen" style="width:30px;text-align: center;" maxlength="2" tabindex="5" size="2" />
																<label id="lblDateHaraikomi1_Nen">年</label>
																<parts:select path="drpID_Date_Haraikomi1_Tsuki" id="drpID_Date_Haraikomi1_Tsuki" style="color:#003399;" tabindex="6">
																	<parts:codeListOption categoryCode="00003" />
																</parts:select>
																<label id="lblDateHaraikomi1_Tsuki">月</label>
																<parts:select path="drpID_Date_Haraikomi1_Bi" id="drpID_Date_Haraikomi1_Bi" style="color:#003399;" tabindex="7">
																	<parts:codeListOption categoryCode="00004" />
																</parts:select>
																<label id="lblDateHaraikomi1_Bi">日</label><br /> <!-- 払込期日２ -->
																<parts:select path="drpID_Date_Haraikomi2_Gengo" id="drpID_Date_Haraikomi2_Gengo" style="color:#003399;" tabindex="9">
																	<parts:codeListOption categoryCode="00002" />
																</parts:select>
																<parts:text path="txtID_Date_Haraikomi2_Nen" id="txtID_Date_Haraikomi2_Nen" style="width:30px;text-align: center;" maxlength="2" tabindex="10" size="2" />
																<label id="lblDateHaraikomi2_Nen">年</label>
																<parts:select path="drpID_Date_Haraikomi2_Tsuki" id="drpID_Date_Haraikomi2_Tsuki" style="color:#003399;" tabindex="11">
																	<parts:codeListOption categoryCode="00003" />
																</parts:select>
																<label id="lblDateHaraikomi2_Tsuki">月</label>
																<parts:select path="drpID_Date_Haraikomi2_Bi" id="drpID_Date_Haraikomi2_Bi" style="color:#003399;" tabindex="12">
																	<parts:codeListOption categoryCode="00004" />
																</parts:select>
																<label id="lblDateHaraikomi2_Bi">日</label><br /> <!-- 払込期日３ -->
																<parts:select path="drpID_Date_Haraikomi3_Gengo" id="drpID_Date_Haraikomi3_Gengo" style="color:#003399;" tabindex="14">
																	<parts:codeListOption categoryCode="00002" />
																</parts:select>
																<parts:text path="txtID_Date_Haraikomi3_Nen" id="txtID_Date_Haraikomi3_Nen" style="width:30px;text-align: center;" maxlength="2" tabindex="15" size="2" />
																<label id="lblDateHaraikomi3_Nen">年</label>
																<parts:select path="drpID_Date_Haraikomi3_Tsuki" id="drpID_Date_Haraikomi3_Tsuki" style="color:#003399;" tabindex="16">
																	<parts:codeListOption categoryCode="00003" />
																</parts:select>
																<label id="lblDateHaraikomi3_Tsuki">月</label>
																<parts:select path="drpID_Date_Haraikomi3_Bi" id="drpID_Date_Haraikomi3_Bi" style="color:#003399;" tabindex="17">
																	<parts:codeListOption categoryCode="00004" />
																</parts:select>
																<label id="lblDateHaraikomi3_Bi">日</label><br /> <!-- 払込期日４ -->
																<parts:select path="drpID_Date_Haraikomi4_Gengo" id="drpID_Date_Haraikomi4_Gengo" style="color:#003399;" tabindex="19">
																	<parts:codeListOption categoryCode="00002" />
																</parts:select>
																<parts:text path="txtID_Date_Haraikomi4_Nen" id="txtID_Date_Haraikomi4_Nen" style="width:30px;text-align: center;" maxlength="2" tabindex="20" size="2" />
																<label id="lblDateHaraikomi4_Nen">年</label>
																<parts:select path="drpID_Date_Haraikomi4_Tsuki" id="drpID_Date_Haraikomi4_Tsuki" style="color:#003399;" tabindex="21">
																	<parts:codeListOption categoryCode="00003" />
																</parts:select>
																<label id="lblDateHaraikomi4_Tsuki">月</label>
																<parts:select path="drpID_Date_Haraikomi4_Bi" id="drpID_Date_Haraikomi4_Bi" style="color:#003399;" tabindex="22">
																	<parts:codeListOption categoryCode="00004" />
																</parts:select>
																<label id="lblDateHaraikomi4_Bi">日</label>
															</td>
															<td><!-- 払込元金１〜４ -->
																<parts:text path="txtID_M_HaraikomiGankin1" id="txtID_M_HaraikomiGankin1" style="text-align: right;" maxlength="11" size="15" tabindex="8" cssClass="format-number" /><br />
																<parts:text path="txtID_M_HaraikomiGankin2" id="txtID_M_HaraikomiGankin2" style="text-align: right;" maxlength="11" size="15" tabindex="13" cssClass="format-number" /><br />
																<parts:text path="txtID_M_HaraikomiGankin3" id="txtID_M_HaraikomiGankin3" style="text-align: right;" maxlength="11" size="15" tabindex="18" cssClass="format-number" /><br />
																<parts:text path="txtID_M_HaraikomiGankin4" id="txtID_M_HaraikomiGankin4" style="text-align: right;" maxlength="11" size="15" tabindex="23" cssClass="format-number" />
															</td>
														</tr>
													</parts:table>
												</div>
											</fieldset>
											<fieldset id="gankin">
												<legend id="legend_gankin" align="left">◆元金均等償還・期限固定の場合</legend>
												<div class="item-input">
													<div>繰償後元金均等額(円)</div>
													<div><parts:text path="txtID_M_GankinKintoAfterKurisho" id="txtID_M_GankinKintoAfterKurisho" style="text-align: right;" maxlength="11" size="15" tabindex="24" cssClass="format-number" /></div>
												</div>
												<div class="item-input">
													<div>繰償後元金不均等額(円)</div>
													<div><parts:text path="txtID_M_GankinFukintoAfterKurisho" id="txtID_M_GankinFukintoAfterKurisho" style="text-align: right;" maxlength="11" size="15" tabindex="24" cssClass="format-number" /></div>
												</div>
												<div class="item-clear">
													<div class="item-input">調整コード<br />
														<span id="rdoID_Code_chosei" tabindex="24">
															<span>
																<parts:radioButton path="rdoID_Code_chosei" id="rdoID_Code_chosei" value="1" name="rdoID_Code_chosei" />
																<label for="rdoID_Code_chosei_0">初回</label>
															</span>
															<span>
																<parts:radioButton path="rdoID_Code_chosei" id="rdoID_Code_chosei" value="2" name="rdoID_Code_chosei" />
																<label for="rdoID_Code_chosei_1">最終回</label>
															</span>
															<span>
																<parts:radioButton path="rdoID_Code_chosei" id="rdoID_Code_chosei" value="" name="rdoID_Code_chosei" />
																<label for="rdoID_Code_chosei_2">なし</label></span>
														</span>
													</div>
												</div>
											</fieldset>
										</div>
									</div>
									<div class="report_a_line">
										<div class="item-input">
											<div>受託者勘定処理年月</div>
											<div>
												<parts:select path="drpID_Date_Jtkshori_Gengo" id="drpID_Date_Jtkshori_Gengo" style="color:#003399;" tabindex="24">
													<parts:codeListOption categoryCode="00002" />
												</parts:select>
												<parts:text path="txtID_Date_Jtkshori_Nen" id="txtID_Date_Jtkshori_Nen" style="width:30px;text-align: center;" maxlength="2" tabindex="24" size="2" />
												<label id="lblDateJtkshoriNen">年</label>
												<parts:select path="drpID_Date_Jtkshori_Tsuki" id="drpID_Date_Jtkshori_Tsuki" style="color:#003399;" tabindex="24">
													<parts:codeListOption categoryCode="00003" />
												</parts:select>
												<label id="lblDateJtkshoriTsuki2">月</label>
											</div>
										</div>
									</div>
								</div>
							</div> <!-- 報告書一枚終わり -->
						</div>
					</logic:equal>
					<br />
				</div>
			</div>
		</div>
		</parts:form><%@ include file="/jsp/incFooter.jsp"%>
	</body>
</html>