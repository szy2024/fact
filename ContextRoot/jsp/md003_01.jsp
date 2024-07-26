
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/jsp/incTop.jsp"%>
<%@ taglib prefix="pn" uri="http://partnernet.jfc.go.jp/tags/pn"%>

<%--================================================================================================
 * Project Name : パートナーネット開発
 * System Name  : パートナーネット
 * File Name    : md003_03.jsp
 *
 * <<Modification History>>
 * Version | Date       | Updated By            | Content
 * --------+------------+-----------------------+---------------------------------------------------
 * 1.0.0   | 2015/07/01 | ○○　○○            | 新規作成
 * 2.0.0   | 2019/01/11 | 林　晃平              | 農林PN元号対応
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
			    function click_sendBtn() {
			        executeAction('../../md003/md003_01/Md003_01Send.form');
			    }
				<%-- 戻るボタン処理 --%>
				function click_backBtn() {
			        executeAction('../../md003/md003_01/Md003_01Back.form');
				}

//-->
		</script>



		<link href="<%=request.getContextPath()%>/css/gju_Mod.css" type="text/css" rel="stylesheet" />
		<!-- 2005/03/28 add start SCRIPTタグ追加 -->
		<script language="JavaScript" type="text/javascript" src="<%= request.getContextPath() %>/js/ptncommon.js"></script>
		<!-- 2005/03/28 add end -->
	</head>
	<body onload="initTextFormat();">
		<parts:form modelAttribute="md003_01Form" action="./Md003_01Init.form"  id="Form1" method="post"  onsubmit="return false;">
			<%@ include file="/jsp/incCommonHidden.jsp" %>
			<%@ include file="/jsp/incHeaderArea.jsp" %>
			<div id="main_scroll_area">
			<div class="header">
				<div class="title">
					<span class="Title" id="lblTitle"><parts:message code="title.screenName"/></span>
				</div>
			</div>
			<div class="help">
				<a href="#" onclick="openNewWindow('<%= request.getContextPath() %>/help/main_md003.html', false, false, false, 'width=800', 'height=500', false)">
					<font class="help">ヘルプ</font>
				</a>
			</div>
			<div class="main">
				<div class="greeting">
					<label id="lblDataMsg">取消対象報告書を用意しました。変更があれば下欄「受託者勘定処理年月」を入力し、「送信」ボタンを押してください。</label>
				</div>
				<div class="greeting">
					取消・修正対象報告書の一覧画面に戻る場合には「戻る」ボタンを押してください。
				</div>
				<!-- 操作ボタン -->
				<div class="buttons">
					<div style="display:none;">
						<parts:button id="btnBack" />
						<parts:button id="btnUpdate" />
					</div>
					<parts:button id="btnUpdate2" value="送信" onclick="clearTextFormat();click_sendBtn()" />
					<parts:button id="btnBack2" value="戻る" title="取消・修正対象報告書の一覧画面へ戻る" onclick="clearTextFormat();click_backBtn()" />

				</div>
				<!-- -------------------- -->
				<!-- status               -->
				<!-- -------------------- -->
				<div class="reportDate">報告年月日：
					<fmt:parseDate value="${md003_01Form.lblID_Date_Report}"
						var="lblID_Date_Report" pattern="yyyyMMdd" />
					<fmt:formatDate value="${lblID_Date_Report}"
						pattern="yyyy年MM月dd日(E)" />
				</div>
				<div class="status">ステータス：<br />
	                <div class="lblErr" style="color: red; font-weight: bold;">
	                    <parts:errors path="*" cssClass="Error" />
	                </div>
					<parts:dlabel path="lblMessage" />
				</div>
				<%-- 取消用データ表示領域 --%>
				<parts:table id="pnl" cssStyle="border-style:none;">
					<parts:tr id="pnl_Red" cssStyle="border-style:none;">
						<td>
							<div class="page-break"><br/></div>
							<div id="pnl_Red" >
							<!-- 報告書一枚(borderで囲んである,複数可) -->
							<!-- 実装時はASP.NETのユーザコントロールよびだし -->
							<!-- ジャンプ用アンカー(名前) --><a name=""></a>
								<div class="report" style="height:522px">
									<div class="kousei-aka" align="center">
										<parts:dlabel path="lblID_Head_Red"/>
										<logic:equal path="lblID_Head_Red2"  value="Visible">
											<label id="lblID_Head_Red2" style="color:red;">赤</label>
										</logic:equal>
									</div>
									<!-- ジャンプ用アンカー(名前) -->
									<div align="center"><!-- 出力用 --> <!-- 報告書の一行分(複数可) -->
										<div class="report_a_line"><!-- 入力用 --> <!-- 出力用 -->
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
													<input type= "text" class="protect" style="text-align: center;" maxlength="4" size="4" tabindex="-1" readonly value="<pn:printWareki date='${md003_01Form.txtID_Year_Red}' pattern='GY'/>"/></div>
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
												<div><!-- 項目名 --> 貸付実行日</div>
												<div><!-- 値 -->
													<input type= "text" class="protect" style="text-align: center;" maxlength="9" size="10" tabindex="-1" readonly value="<pn:printWareki date='${md003_01Form.txtID_Date_KashitsukeJikko_Red}' pattern='GYMD'/>"/></div>
											</div>
										</div> <!-- 報告書の一行分(複数可) -->
										<div class="report_a_line"><!-- 出力用 -->
											<div class="item-output">
												<div><!-- 項目名 --> 貸付金額</div>
												<div><!-- 値 -->
													<parts:text path="txtID_M_Kashitsuke_Red" cssClass="format-number" id="txtID_M_Kashitsuke_Red" style="text-align: right;" maxlength="11" size="15" tabindex="-1" readonly="true" /></div>
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
											</div> <!-- 出力用 -->
											<div class="item-output">
												<div><!-- 項目名 --> 利率(％)</div>
												<div><!-- 値 -->
													<parts:text path="txtID_Riritsu_Red" id="txtID_Riritsu_Red" style="text-align: center;" maxlength="5" size="6" tabindex="-1" readonly="true" /></div>
											</div> <!-- 出力用 -->
											<div class="item-output">
												<div><!-- 項目名 --> 特利区分</div>
												<div><!-- 値 -->
													<parts:text path="txtID_Code_TokuriKubun_Red" id="txtID_Code_TokuriKubun_Red" style="text-align: center;" maxlength="1" size="1" tabindex="-1" readonly="true" /></div>
											</div> <!-- 出力用 -->
											<div class="item-output">
												<div><!-- 項目名 --> 特利(％)</div>
												<div><!-- 値 -->
													<parts:text path="txtID_Tokuri_Red" id="txtID_Tokuri_Red" style="text-align: center;" maxlength="5" size="6" tabindex="-1" readonly="true" /></div>
											</div> <!-- 出力用 -->
											<div class="item-output">
												<div><!-- 項目名 --> 償還方法</div>
												<div><!-- 値 -->
													<parts:text path="txtID_Code_Shokan_Red" id="txtID_Code_Shokan_Red" style="text-align: center;" maxlength="2" size="2" tabindex="-1" readonly="true" /></div>
											</div> <!-- 出力用 -->
											<div class="item-output">
												<div><!-- 項目名 --> 据置期限</div>
												<div><!-- 値 -->
													<input type= "text" class="protect" style="text-align: center;" maxlength="6" size="6" tabindex="-1" readonly value="<pn:printWareki date='${md003_01Form.txtID_Date_SueokiKigen_Red}' pattern='GYM'/>"/></div>
											</div>
										</div> <!-- 報告書の一行分(複数可) -->
										<div class="report_a_line"><!-- 出力用 -->
											<div class="item-output">
												<div><!-- 項目名 --> 償還期限</div>
												<div><!-- 値 -->
													<input type= "text" class="protect" style="text-align: center;" maxlength="6" size="6" tabindex="-1" readonly value="<pn:printWareki date='${md003_01Form.txtID_Date_ShokanKigen_Red}' pattern='GYM'/>"/></div>
											</div> <!-- 出力用 -->
											<div class="item-output">
												<div><!-- 項目名 --> 元利金払込日</div>
												<div><!-- 値 -->
													<parts:text path="txtID_Date_GanrikinHaraikomi_Red" id="txtID_Date_GanrikinHaraikomi_Red" style="text-align: center;" maxlength="5" size="5" tabindex="-1" readonly="true" /></div>
											</div> <!-- 出力用 -->
											<div class="item-output">
												<div><!-- 項目名 --> 元利又は元金均等額(円)</div>
												<div><!-- 値 -->
													<parts:text path="txtID_M_GankinKinto_Red" cssClass="format-number" id="txtID_M_GankinKinto_Red" style="text-align: right;" maxlength="11" size="15" tabindex="-1" readonly="true" /></div>
											</div> <!-- 出力用 -->
											<div class="item-output">
												<div><!-- 項目名 --> 払込前残元金(円)</div>
												<parts:text path="txtID_M_KashitsukeZandaka_Red" cssClass="format-number" id="txtID_M_KashitsukeZandaka_Red" style="text-align: right;" maxlength="11" size="15" tabindex="-1" readonly="true" />
												<div><!-- 値 --></div>
											</div> <!-- 出力用 -->
											<div class="item-output">
												<div><!-- 項目名 --> 払込期日</div>
												<div><!-- 値 -->
													<input type= "text" class="protect" style="text-align: center;" maxlength="9" size="10" tabindex="-1" readonly value="<pn:printWareki date='${md003_01Form.txtID_Date_Haraikomi_Red}' pattern='GYMD'/>"/></div>
											</div> <!-- 出力用 -->
											<div class="item-output">
												<div><!-- 項目名 --> 払込金額(円)</div>
												<div><!-- 値 -->
													<parts:text path="txtID_M_Haraikomi_Red" cssClass="format-number" id="txtID_M_Haraikomi_Red" style="text-align: right;" maxlength="11" size="15" tabindex="-1" readonly="true" /></div>
											</div>
										</div> <!-- 報告書の一行分(複数可) -->
										<div class="report_a_line"><!-- 出力用 -->
											<div class="item-output">
												<div><!-- 項目名 --> 控除利息(円)</div>
												<parts:text path="txtID_M_KojoRisoku_Red" cssClass="format-number" id="txtID_M_KojoRisoku_Red" style="text-align: right;" maxlength="11" size="15" tabindex="-1" readonly="true" />
												<div><!-- 値 --></div>
											</div> <!-- 出力用 -->
											<div class="item-output">
												<div><!-- 項目名 --> 差引払込額(円)</div>
												<div><!-- 値 -->
													<parts:text path="txtID_M_SashihikiHaraikomi_Red" cssClass="format-number" id="txtID_M_SashihikiHaraikomi_Red" style="text-align: right;" maxlength="11" size="15" tabindex="-1" readonly="true" /></div>
											</div> <!-- 出力用 -->
											<div class="item-output">
												<div><!-- 項目名 --> 払込後残元金(円)</div>
												<div><!-- 値 -->
													<parts:text path="txtID_M_ZangankinAfterHaraikomi_Red" cssClass="format-number" id="txtID_M_ZangankinAfterHaraikomi_Red" style="text-align: right;" maxlength="11" size="15" tabindex="-1" readonly="true" /></div>
											</div> <!-- 入力用 -->
											<div class="item-output">
												<div>約定利息(円)</div>
												<div>
													<parts:text path="txtID_M_YakujoRisoku_Red" cssClass="format-number" id="txtID_M_YakujoRisoku_Red" style="text-align: right;" maxlength="11" size="15" readonly="true" /></div>
											</div> <!-- 入力用 -->
											<div class="item-output">
												<div>約定元金(円)</div>
												<div>
													<parts:text path="txtID_M_YakujoGankin_Red" cssClass="format-number" id="txtID_M_YakujoGankin_Red" style="text-align: right;" maxlength="11" size="15" readonly="true" /></div>
											</div>
										</div> <!-- 報告書の一行分(複数可) -->
										<div class="report_a_line"><!-- 入力用 -->
											<div class="item-output">
												<div>遅延損害金(円)</div>
												<div>
													<parts:text path="txtID_M_ChienSongai_Red" cssClass="format-number" id="txtID_M_ChienSongai_Red" style="text-align: right;" maxlength="11" size="15" readonly="true" /></div>
											</div> <!-- 入力用 -->
											<div class="item-output">
												<div>違約金(円)</div>
												<div>
													<parts:text path="txtID_M_Iyaku_Red" cssClass="format-number" id="txtID_M_Iyaku_Red" style="text-align: right;" maxlength="11" size="15" readonly="true" /></div>
											</div> <!-- 入力用 -->
											<div class="item-output">
												<div>違約金(利子軽減分)(円)</div>
												<div>
													<parts:text path="txtID_M_IyakuRishikeigen_Red" cssClass="format-number" id="txtID_M_IyakuRishikeigen_Red" style="text-align: right;" maxlength="11" size="15" readonly="true" /></div>
											</div> <!-- 入力用 -->
											<div class="item-output">
												<div>仮受金からの充当額(円)</div>
												<div>
													<parts:text path="txtID_M_KariukeIppanJuto_Red" cssClass="format-number" id="txtID_M_KariukeIppanJuto_Red" style="text-align: right;" maxlength="11" size="15" readonly="true" /></div>
											</div>
										</div> <!-- 報告書の一行分(複数可) -->
										<div class="report_a_line"><!-- 入力用 -->
											<div class="item-output">
												<div>入金日</div>
												<div>
													<input type= "text" class="protect" style="text-align: center;" maxlength="9" size="10" tabindex="-1" readonly value="<pn:printWareki date='${md003_01Form.txtID_Date_Nyukin_Red}' pattern='GYMD'/>"/></div>
											</div>
											<div class="item-output">
												<div>受託者勘定処理年月</div>
												<div>
													<input type= "text" class="protect" style="text-align: center;" maxlength="6" size="6" tabindex="-1" readonly value="<pn:printWareki date='${md003_01Form.txtID_Date_Jtkshori_Red}' pattern='GYM'/>"/></div>
											</div>
										</div> <!-- 入力用 -->
										<div class="item-output">
											<div>送金日</div>
											<div>
												<input type= "text" class="protect" style="text-align: center;" maxlength="9" size="10" tabindex="-1" readonly value="<pn:printWareki date='${md003_01Form.txtID_Date_Sokin_Red}' pattern='GYMD'/>"/></div>
										</div>
										<div class="report_a_line"><!-- 入力用 -->
											<div class="item-output">
												<div>送金日番号</div>
												<div>
													<parts:text path="txtID_ID_Sokinbi_Red" id="txtID_ID_Sokinbi_Red" style="text-align: right;" maxlength="3" size="3" readonly="true" /></div>
											</div> <!-- 入力用 -->
											<div class="item-output">
												<div>&nbsp;</div>
												<div><!-- 項目名 -->
													<span disabled="true">
														<parts:checkbox path="ckhAfter_Daibensai_Red" id="ckhAfter_Daibensai_Red" value = "1" style="text-align: right;" name="ckhAfter_Daibensai_Red" disabled="true" />
													<label for="ckhAfter_Daibensai_Red">代弁履行後の作成</label></span>
												</div>
											</div>
										</div>
										<div class="report_a_line"><!-- 入力用 -->
											<div class="item-input">
												<div>受託者勘定処理年月</div>
												<div>
													<parts:select path="ID_Date_Jtkshori_Gengo_Red" id="ID_Date_Jtkshori_Gengo_Red" style="color:#003399;">
														<parts:codeListOption categoryCode='00002'/>
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
									</div>
								</div> <!-- 報告書一枚終わり -->
								<div></div>
								<div></div>
							</div>
						</td>
					</parts:tr>

				<%-- 修正用データ表示領域 --%>
					<parts:tr id="pnl_Mod" cssStyle="border-style:none;">
						<td>
							<div class="page-break"><br/></div>
							<div id="pnl_Mod">
							<!-- 報告書一枚(borderで囲んである,複数可) -->
							<!-- ジャンプ用アンカー(名前) -->
								<div class="report" style="height:522px">
									<div class="shusei" align="center">
										<label id="lblID_Head"><parts:dlabel path="lblID_Head"/></label>
									</div>
									<!-- 報告書の一行分(複数可) -->
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
												<input type= "text" class="protect" style="text-align: center;" maxlength="4" size="4" tabindex="-1" readonly value="<pn:printWareki date='${md003_01Form.txtID_Year}' pattern='GY'/>"/></div>
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
											<div><!-- 項目名 --> 貸付実行日</div>
											<div><!-- 値 -->
												<input type= "text" class="protect" style="text-align: center;" maxlength="9" size="10" tabindex="-1" readonly value="<pn:printWareki date='${md003_01Form.txtID_Date_kashitsukeJikko}' pattern='GYMD'/>"/></div>
										</div>
									</div> <!-- 報告書の一行分(複数可) -->
									<div class="report_a_line"><!-- 出力用 -->
										<div class="item-output">
											<div><!-- 項目名 --> 貸付金額</div>
											<div><!-- 値 -->
												<parts:text path="txtID_M_Kashitsuke" cssClass="format-number" id="txtID_M_Kashitsuke" style="text-align: right;" maxlength="11" size="15" tabindex="-1" readonly="true" /></div>
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
										</div> <!-- 出力用 -->
										<div class="item-output">
											<div><!-- 項目名 --> 利率(％)</div>
											<div><!-- 値 -->
												<parts:text path="txtID_Riritsu" id="txtID_Riritsu" style="text-align: center;" maxlength="5" size="6" tabindex="-1" readonly="true" /></div>
										</div> <!-- 出力用 -->
										<div class="item-output">
											<div><!-- 項目名 --> 特利区分</div>
											<div><!-- 値 -->
												<parts:text path="txtID_Kubun_Tokuri" id="txtID_Kubun_Tokuri" style="text-align: center;" maxlength="1" size="1" tabindex="-1" readonly="true" /></div>
										</div> <!-- 出力用 -->
										<div class="item-output">
											<div><!-- 項目名 --> 特利(％)</div>
											<div><!-- 値 -->
												<parts:text path="txtID_Tokuri" id="txtID_Tokuri" style="text-align: center;" maxlength="5" size="6" tabindex="-1" readonly="true" /></div>
										</div> <!-- 出力用 -->
										<div class="item-output">
											<div><!-- 項目名 --> 償還方法</div>
											<div><!-- 値 -->
												<parts:text path="txtID_Code_Shokan" id="txtID_Code_Shokan" style="text-align: center;" maxlength="2" size="2" tabindex="-1" readonly="true" /></div>
										</div> <!-- 出力用 -->
										<div class="item-output">
											<div><!-- 項目名 --> 据置期限</div>
											<div><!-- 値 -->
												<input type= "text" class="protect" style="text-align: center;" maxlength="6" size="6" tabindex="-1" readonly value="<pn:printWareki date='${md003_01Form.txtID_Date_SueokiKigen}' pattern='GYM'/>"/></div>
										</div>
									</div> <!-- 報告書の一行分(複数可) -->
									<div class="report_a_line"><!-- 出力用 -->
										<div class="item-output">
											<div><!-- 項目名 --> 償還期限</div>
											<div><!-- 値 -->
												<input type= "text" class="protect" style="text-align: center;" maxlength="6" size="6" tabindex="-1" readonly value="<pn:printWareki date='${md003_01Form.txtID_Date_ShokanKigen}' pattern='GYM'/>"/></div>
										</div> <!-- 出力用 -->
										<div class="item-output">
											<div><!-- 項目名 --> 元利金払込日</div>
											<div><!-- 値 -->
												<parts:text path="txtID_Date_GanrikinHaraikomi" id="txtID_Date_GanrikinHaraikomi" style="text-align: center;" maxlength="5" size="5" tabindex="-1" readonly="true" /></div>
										</div> <!-- 出力用 -->
										<div class="item-output">
											<div><!-- 項目名 --> 元利又は元金均等額(円)</div>
											<div><!-- 値 -->
												<parts:text path="txtID_M_GankinKinto" cssClass="format-number" id="txtID_M_GankinKinto" style="text-align: right;" maxlength="11" size="15" tabindex="-1" readonly="true" /></div>
										</div> <!-- 出力用 -->
										<div class="item-output">
											<div><!-- 項目名 --> 払込前残元金(円)</div>
												<parts:text path="txtID_M_KashitsukeZandaka" cssClass="format-number" id="txtID_M_KashitsukeZandaka" style="text-align: right;" maxlength="11" size="15" tabindex="-1" readonly="true" />
											<div><!-- 値 --></div>
										</div> <!-- 出力用 -->
										<div class="item-output">
											<div><!-- 項目名 --> 払込期日</div>
											<div><!-- 値 -->
												<input type= "text" class="protect" style="text-align: center;" maxlength="9" size="10" tabindex="-1" readonly value="<pn:printWareki date='${md003_01Form.txtID_Date_Haraikomi}' pattern='GYMD'/>"/></div>
										</div> <!-- 出力用 -->
										<div class="item-output">
											<div><!-- 項目名 --> 払込金額(円)</div>
											<div><!-- 値 -->
												<parts:text path="txtID_M_Haraikomi" cssClass="format-number" id="txtID_M_Haraikomi" style="text-align: right;" maxlength="11" size="15" tabindex="-1" readonly="true" /></div>
										</div>
									</div> <!-- 報告書の一行分(複数可) -->
									<div class="report_a_line"><!-- 出力用 -->
										<div class="item-output">
											<div><!-- 項目名 --> 控除利息(円)</div>
											<parts:text path="txtID_M_KojoRisoku" cssClass="format-number" id="txtID_M_KojoRisoku" style="text-align: right;" maxlength="11" size="15" tabindex="-1" />
											<div><!-- 値 --></div>
										</div> <!-- 出力用 -->
										<div class="item-output">
											<div><!-- 項目名 --> 差引払込額(円)</div>
											<div><!-- 値 -->
												<parts:text path="txtID_M_SashihikiHaraikomi" cssClass="format-number" id="txtID_M_SashihikiHaraikomi" style="text-align: right;" maxlength="11" size="15" tabindex="-1" readonly="true" /></div>
										</div> <!-- 出力用 -->
										<div class="item-output">
											<div><!-- 項目名 --> 払込後残元金(円)</div>
											<div><!-- 値 -->
												<parts:text path="txtID_M_ZangankinAfterHaraikomi" cssClass="format-number" id="txtID_M_ZangankinAfterHaraikomi" style="text-align: right;" maxlength="11" size="15" tabindex="-1" readonly="true" /></div>
										</div> <!-- 入力用 -->
										<div class="item-input">
											<div>約定利息(円)</div>
											<div>
												<parts:text path="txtID_M_YakujoRisoku" cssClass="format-number" id="txtID_M_YakujoRisoku" style="text-align: right;" maxlength="11" size="15" /></div>
										</div> <!-- 入力用 -->
										<div class="item-input">
											<div>約定元金(円)</div>
											<div>
												<parts:text path="txtID_M_YakujoGankin" cssClass="format-number" id="txtID_M_YakujoGankin" style="text-align: right;" maxlength="11" size="15" /></div>
										</div>
									</div> <!-- 報告書の一行分(複数可) -->
									<div class="report_a_line"><!-- 入力用 -->
										<div class="item-input">
											<div>遅延損害金(円)</div>
											<div>
												<parts:text path="txtID_M_ChienSongai" cssClass="format-number" id="txtID_M_ChienSongai" style="text-align: right;" maxlength="11" size="15" /></div>
										</div> <!-- 入力用 -->
										<div class="item-input">
											<div>違約金(円)</div>
											<div>
												<parts:text path="txtID_M_Iyaku" cssClass="format-number" id="txtID_M_Iyaku" style="text-align: right;" maxlength="11" size="15" /></div>
										</div> <!-- 入力用 -->
										<div class="item-input">
											<div>違約金(利子軽減分)(円)</div>
											<div>
												<parts:text path="txtID_M_IyakuRishikeigen" cssClass="format-number" id="txtID_M_IyakuRishikeigen" style="text-align: right;" maxlength="11" size="15" /></div>
										</div> <!-- 入力用 -->
										<div class="item-input">
											<div>仮受金からの充当額(円)</div>
											<div>
												<parts:text path="txtID_M_KariukeIppanJuto" cssClass="format-number" id="txtID_M_KariukeIppanJuto" style="text-align: right;" maxlength="11" size="15" /></div>
										</div>
									</div> <!-- 報告書の一行分(複数可) -->
									<div class="report_a_line"><!-- 入力用 -->
										<div class="item-input">
											<div>入金日</div>
											<div>
												<parts:select path="ID_Date_Nyukin_Gengo" id="ID_Date_Nyukin_Gengo" style="color:#003399;">
													<parts:codeListOption categoryCode='00002'/>
												</parts:select>
												<parts:text path="ID_Date_Nyukin_Nen" id="ID_Date_Nyukin_Nen" style="width:30px;text-align: center;" maxlength="2" size="2" />
												<label id="lblDateNyukinNen">年</label>
												<parts:select path="drpID_Date_NyukinTsuki" id="drpID_Date_NyukinTsuki" style="color:#003399;">
													<parts:codeListOption categoryCode="00003" />
												</parts:select>
												<label id="lblDateNyukinTsuki">月</label>
												<parts:select path="drpID_Date_NyukinBi" id="drpID_Date_NyukinBi" style="color:#003399;">
													<parts:codeListOption categoryCode="00004" />
												</parts:select>
												<label id="lblDateNyukinBi">日</label></div>
										</div>
										<div class="item-output">
											<div>受託者勘定処理年月</div>
											<div>
												<input type= "text" class="protect" style="text-align: center;" maxlength="6" size="6" tabindex="-1" readonly value="<pn:printWareki date='${md003_01Form.txtID_Date_Jtkshori}' pattern='GYM'/>"/></div>
										</div> <!-- 入力用 -->
										<div class="item-input">
											<div>送金日</div>
											<div>
												<parts:select path="ID_Date_Sokin_Gengo" id="ID_Date_Sokin_Gengo" style="color:#003399;">
<%-- [UPD] Ver 2.0.0 - START --%>
<%-- 												<parts:option value=""></parts:option> --%>
<%-- 												<parts:option value="S">S</parts:option> --%>
<%-- 												<parts:option value="H">H</parts:option> --%>
													<parts:codeListOption categoryCode='00002'/>
<%-- [UPD] Ver 2.0.0 - END --%>
												</parts:select>
												<parts:text path="ID_Date_Sokin_Nen" id="ID_Date_Sokin_Nen" style="width:30px;text-align: center;" maxlength="2" size="2" />
												<label id="lblDate_SokinNen">年</label>
												<parts:select path="drpID_Date_SokinTsuki" id="drpID_Date_SokinTsuki" style="color:#003399;">
													<parts:codeListOption categoryCode="00003" />
												</parts:select>
												<label id="lblDate_SokinTsuki">月</label>
												<parts:select path="drpID_Date_SokinBi" id="drpID_Date_SokinBi" style="color:#003399;">
													<parts:codeListOption categoryCode="00004" />
												</parts:select>
												<label id="lblDate_SokinBi">日</label></div>
										</div>
									</div> <!-- 報告書一枚終わり -->
									<div class="report_a_line"><!-- 入力用 -->
										<div class="item-input">
											<div>送金日番号</div>
											<div>
												<parts:text path="txtID_ID_Sokinbi" id="txtID_ID_Sokinbi" style="text-align: right;" maxlength="3" size="3" /></div>
										</div> <!-- 入力用 -->
										<div class="item-input">
											<div>&nbsp;</div>
											<div><!-- 項目名 -->
												<span>
													<parts:checkbox path="ckhAfter_Daibensai" id="ckhAfter_Daibensai" value = "1" style="text-align: right;" name="ckhAfter_Daibensai" />
													<label for="ckhAfter_Daibensai">代弁履行後の作成</label></span>
											</div>
										</div>
									</div>
									<div class="report_a_line"><!-- 入力用 -->
										<div class="item-input">
											<div>受託者勘定処理年月</div>
											<div>
												<parts:select path="ID_Date_Jtkshori_Gengo" id="ID_Date_Jtkshori_Gengo" style="color:#003399;">
													<parts:codeListOption categoryCode='00002'/>
												</parts:select>
												<parts:text path="ID_Date_Jtkshori_Nen" id="ID_Date_Jtkshori_Nen" style="width:30px;text-align: center;" maxlength="2" size="2" />
												<label id="lblDateJtkshoriNen">年</label>
												<parts:select path="drpID_Date_JtkshoriTsuki" id="drpID_Date_JtkshoriTsuki" style="color:#003399;">
													<parts:codeListOption categoryCode="00003" />
												</parts:select>
												<label id="lblDateJtkshoriTsuki">月</label></div>
										</div>
									</div>
								</div>
							</div>
							<div></div>
						</td>
					</parts:tr>
					<br />
				</parts:table>
			</div>
		</div>
		</parts:form><%@ include file="/jsp/incFooter.jsp"%>
	</body>
</html>