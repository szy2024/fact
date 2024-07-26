<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/jsp/incTop.jsp" %>
<%--================================================================================================
 * Project Name : パートナーネット開発
 * System Name  : パートナーネット
 * File Name    : md004_04.jsp
 *
 * <<Modification History>>
 * Version | Date       | Updated By            | Content
 * --------+------------+-----------------------+---------------------------------------------------
 * 1.0.0   | 2015/07/01 | 小林　浩二            | 新規作成
================================================================================================--%>

<html>
	<%@ include file="/jsp/incHeader.jsp"%>
	<head>
		<title><parts:message code="title.screenName"/></title>
		<link href="<%= request.getContextPath() %>/css/md004.css" type="text/css" rel="stylesheet" />
				<script lang="JavaScript">
				<!--
				<%-- 送信ボタン押下時の処理 --%>
				function click_sendBtn() {
					executeAction('../../md004/md004_02/Md004_02Create.form');
			    }
				<%-- 戻る押下時の処理 --%>
				function click_backBtn() {
					executeAction('../../md004/md004_02/Md004_02Back.form');
				}
		//-->
		</script>
	</head>
	<body>
		<parts:form modelAttribute="md004_02Form" id="Form1" method="post">
			<%@ include file="/jsp/incCommonHidden.jsp" %>
            <%@ include file="/jsp/incHeaderArea.jsp" %>
            <div id="main_scroll_area">
			<%@ taglib prefix="pn" uri="http://partnernet.jfc.go.jp/tags/pn" %>
			<div class="header">
				<div class="title">
					<span class="Title" id="lblTitle"><parts:message code="title.screenName"/></span>
				</div>
			</div>
			<div class="main">
				<div class="greeting">
					取消対象報告書が確定しました。<br />
					以下の報告書の登録を行います。内容をご確認のうえ「登録」ボタンを押してください。
				</div>

				<div class="buttons">
					<div style="display:none;">
						<parts:button id="btnUpdate" />
						<parts:button id="btnBack" title="繰上償還受入・充当報告書の取消・修正の入力画面へ戻る" />
					</div>
					<parts:button id="btnUpdate2" value="登録" onclick="clearTextFormat();click_sendBtn();" />
					<parts:button id="btnBack2" value="戻る" title="繰上償還受入・充当報告書の取消・修正の入力画面へ戻る" onclick="click_backBtn();" />
				</div>
				<div class="status">
						<div style="color:red;font-weight:bold;">
							<parts:errors path="*" cssClass="Error" />
						</div>
					<div style="color:Black;">
						<parts:dlabel path="lblComment" />
					</div>
				</div>
				<label id="lblComment">以下の内容でデータを更新します。</label>
				<div class="reportDate">報告年月日：
					<fmt:parseDate value="${md004_02Form.lblID_Date_Report}" var="ID_Date_Report" pattern="yyyyMMdd" />
					<fmt:formatDate value="${ID_Date_Report}" pattern="yyyy年MM月dd日(E)"/>
				</div>
				<div align="center">
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
									<div class="item-output">
										<div>
											<label id="Label1">顧客名</label>
										</div>
										<div>
											<parts:dlabel path="lblID_Name_Customer_Red" />
										</div>
									</div>
									<div class="item-output">
										<div>
											<label id="Label2">扱店名</label></div>
										<div>
											<parts:dlabel path="lblID_Name_Organization_Red" />
										</div>
									</div>
								</div>
								<div class="report_a_line">
									<div class="item-output">
										<div>
											<label id="Label3">公庫支店</label>
										</div>
										<div>
											<parts:dlabel path="lblID_Code_KoukoShiten_Red" />
										</div>
									</div>
									<div class="item-output">
										<div>
											<label id="Label4">扱店</label></div>
										<div>
											<parts:dlabel path="lblID_Code_Organization_Red" />
										</div>
									</div>
									<div class="item-output">
										<div>
											<label id="Label5">店舗</label>
										</div>
										<div>
											<parts:dlabel path="lblID_Code_Tenpo_Red" />
										</div>
									</div>
									<div class="item-output">
										<div>
											<label id="Label6">年度</label>
										</div>
										<div>
											<pn:printWareki date="${md004_02Form.lblID_Year_Red}" pattern='GY' />
										</div>
									</div>
									<div class="item-output">
										<div>
											<label id="Label7">方式資金</label>
										</div>
										<div>
											<parts:dlabel path="lblID_Code_HoshikiShikin_Red" />
										</div>
									</div>
									<div class="item-output">
										<div>
											<label id="Label8">番号</label>
										</div>
										<div>
											<parts:dlabel path="lblID_ID_Ringi_Red" />
										</div>
									</div>
									<div class="item-output">
										<div>
											<label id="Label9">枝番</label>
										</div>
										<div>
											<parts:dlabel path="lblID_ID_RingiBranch_Red" />
										</div>
									</div>
								</div>
								<div class="report_a_line">
									<div class="item-output">
										<div>
											<label id="Label10">償還後第1回払込期日</label>
										</div>
										<div>
											<pn:printWareki date='${md004_02Form.lblID_Date_FirstHaraikomiAfterKurisho_Red}' pattern='GYMD'/>
										</div>
									</div>
									<div class="item-output">
										<div>
											<label id="Label11">入金日</label></div>
										<div>
											<pn:printWareki date='${md004_02Form.lblID_Date_Nyukin_Red}' pattern='GYMD'/>
										</div>
									</div>
									<div class="item-output">
										<div>
											<label id="Label12">繰償事由コード</label>
										</div>
										<div>
											<parts:dlabel path="lblID_Code_Kurishojiyu_Red" />
										</div>
									</div>
								</div>
								<div class="report_a_line">
									<div class="item-output">
										<div>
											<label id="Label13">利息(円)</label>
										</div>
										<div class="styleMoney" style="text-align: right;">
											<parts:dlabel path="lblID_M_KurishoRisoku_Red" />
										</div>
									</div>
									<div class="item-output">
										<div>
											<label id="Label14">元金(円)</label></div>
										<div class="styleMoney" style="text-align: right;">
											<parts:dlabel path="lblID_M_KurishoGankin_Red" />
										</div>
									</div>
									<div class="item-output">
										<div>
											<label id="Label15">控除利息(円)</label></div>
										<div class="styleMoney" style="text-align: right;">
											<parts:dlabel path="lblID_M_KojoRisoku_Red" />
										</div>
									</div>
									<div class="item-output">
										<div>
											<label id="Label16">繰上償還手数料(円)</label></div>
										<div class="styleMoney" style="text-align: right;">
											<parts:dlabel path="lblID_M_KurishoCommission_Red" />
										</div>
									</div>
								</div>
								<div class="report_a_line">
									<div class="item-output">
										<div>
											<label id="Label17">仮受金からの充当額(円)</label>
										</div>
										<div class="styleMoney" style="text-align: right;">
											<parts:dlabel path="lblID_M_KariukeIppanJuto_Red" />
										</div>
									</div>
									<div class="item-output">
										<div>
											<label id="Label18">送金額(円)</label>
										</div>
										<div class="styleMoney" style="text-align: right;">
											<parts:dlabel path="lblID_M_Sokin_Red" />
										</div>
									</div>
									<div class="item-output">
										<div>
											<label id="Label19">繰償後残元金(円)</label>
										</div>
										<div class="styleMoney" style="text-align: right;">
											<parts:dlabel path="lblID_M_ZanGankinAfterKurisho_Red" />
										</div>
									</div>
								</div>
								<div class="report_a_line">
									<div class="item-output">
										<div>
											<label id="Label20">受託者勘定処理年月</label></div>
										<div>
											<pn:printWareki date='${md004_02Form.lblID_Date_JtkShori_Red}' pattern='GYM'/>
										</div>
									</div>
									<div class="item-output">
										<div>
											<label id="Label21">送金日</label>
										</div>
										<div>
											<pn:printWareki date='${md004_02Form.lblID_Date_Sokin_Red}' pattern='GYMD'/>
										</div>
									</div>
									<div class="item-output">
										<div>
											<label id="Label22">送金日番号</label></div>
										<div>
											<parts:dlabel path="lblID_ID_Sokinbi_Red" /></div>
									</div>
									<div class="item-output">
										<div>&nbsp;</div>
										<div>
											<span>
												<parts:checkbox value="1" path="chkID_ID_After_Daiibensai_Red" id="chkID_ID_After_Daiibensai_Red" style="text-align: right;" name="chkID_ID_After_Daiibensai_Red" disabled="true" />
												<label for="chkID_ID_After_Daiibensai_Red">代弁履行後の作成</label>
											</span>
										</div>
									</div>
								</div>
								<div class="report_a_line">
									<div class="teikishokan">
										<fieldset id="teiki_Red">
											<legend style="font-size: 9pt; color: #0066ff;" align="left">◆定期償還の場合</legend>
											<div class="item-output">
												<parts:table>
													<tr>
														<td>
															<label id="La23">払込期日</label><br />
															<pn:printWareki date='${md004_02Form.lblID_Date_Haraikomi1_Red}' pattern='GYMD'/><br />
															<pn:printWareki date='${md004_02Form.lblID_Date_Haraikomi2_Red}' pattern='GYMD'/><br />
															<pn:printWareki date='${md004_02Form.lblID_Date_Haraikomi3_Red}' pattern='GYMD'/><br />
															<pn:printWareki date='${md004_02Form.lblID_Date_Haraikomi4_Red}' pattern='GYMD'/>
														</td>
														<td class="styleMoney">
															<label id="La24">払込元金(円)</label><br />
															<div style="text-align: right;"><parts:dlabel path="lblID_M_HaraikomiGankin1_Red" />円</div>
															<div style="text-align: right;"><parts:dlabel  path="lblID_M_HaraikomiGankin2_Red" />円</div>
															<div style="text-align: right;"><parts:dlabel  path="lblID_M_HaraikomiGankin3_Red" />円</div>
															<div style="text-align: right;"><parts:dlabel  path="lblID_M_HaraikomiGankin4_Red" />円</div>
														</td>
													</tr>
												</parts:table>
											</div>
										</fieldset>
									</div>
									<div>
										<fieldset id="gankin_Red">
											<legend style="font-size: 9pt; color: #0066ff;" align="left">◆元金均等償還・期限固定の場合</legend>
											<div class="item-output">
												<div>
													<label id="Label25">繰償後元金均等額(円)</label>
												</div>
												<div class="styleMoney" style="text-align: right;">
													<parts:dlabel path="lblID_M_GankinKintoAfterKurisho_Red" />
												</div>
											</div>
											<div class="item-output">
												<div>
													<label id="Label26">繰償後元金不均等額(円)</label></div>
												<div class="styleMoney" style="text-align: right;">
													<parts:dlabel  path="lblID_M_GankinFukintoAfterKurisho_Red" />
												</div>
											</div>
											<div class="item-output">
												<div>
													<label id="Label27">調整コード</label></div>
												<div>
													<span id="rdoID_Code_chosei_Red">
														<span>
															<parts:radioButton path="rdoID_Code_chosei_Red" id="rdoID_Code_chosei_Red" value="1" name="rdoID_Code_chosei_Red" disabled="true"/>
															<label for="rdoID_Code_chosei_Red_0">初回</label>
														</span>
														<span>
															<parts:radioButton path="rdoID_Code_chosei_Red" id="rdoID_Code_chosei_Red" value="2" name="rdoID_Code_chosei_Red" disabled="true" />
															<label for="rdoID_Code_chosei_Red_1">最終回</label>
														</span>
														<span>
															<parts:radioButton path="rdoID_Code_chosei_Red" id="rdoID_Code_chosei_Red" value="" name="rdoID_Code_chosei_Red" disabled="true" />
															<label for="rdoID_Code_chosei_Red_2">なし</label>
														</span>
													</span></div>
											</div>
										</fieldset>
									</div>
								</div>
							</div>
						</div>
					</div>
					</logic:equal>
					<logic:equal path="BlackArea" value="true">
					<div id="pnl_Mod">
					<div class="page-break"><br/></div>
						<div class="report">
							<div class="shusei">
								<parts:dlabel path="lblID_Head" />
							</div>
							<div align="center">
								<div class="report_a_line">
									<div class="item-output">
										<div>
											<label id="Label28">顧客名</label>
										</div>
										<div>
											<parts:dlabel path="lblID_Name_Customer" />
										</div>
									</div>
									<div class="item-output">
										<div>
											<label id="Label29">扱店名</label></div>
										<div>
											<parts:dlabel path="lblID_Name_Organization" />
										</div>
									</div>
								</div>
								<div class="report_a_line">
									<div class="item-output">
										<div>
											<label id="Label30">公庫支店</label>
										</div>
										<div>
											<parts:dlabel path="lblID_Code_KoukoShiten" />
										</div>
									</div>
									<div class="item-output">
										<div>
											<label id="Label31">扱店</label>
										</div>
										<div>
											<parts:dlabel path="lblID_Code_Organization" />
										</div>
									</div>
									<div class="item-output">
										<div>
											<label id="Label32">店舗</label>
										</div>
										<div>
											<parts:dlabel path="lblID_Code_Tenpo" />
										</div>
									</div>
									<div class="item-output">
										<div>
											<label id="Label33">年度</label>
										</div>
										<div>
											<pn:printWareki date="${md004_02Form.lblID_Year}" pattern='GY' />
										</div>
									</div>
									<div class="item-output">
										<div>
											<label id="Label34">方式資金</label>
										</div>
										<div>
											<parts:dlabel path="lblID_Code_HoshikiShikin" />
										</div>
									</div>
									<div class="item-output">
										<div>
											<label id="Label35">番号</label>
										</div>
										<div>
											<parts:dlabel path="lblID_ID_Ringi" />
										</div>
									</div>
									<div class="item-output">
										<div>
											<label id="Label36">枝番</label>
										</div>
										<div>
											<parts:dlabel path="lblID_ID_RingiBranch" />
										</div>
									</div>
								</div>
								<div class="report_a_line">
									<div class="item-output">
										<div>
											<label id="Label37">償還後第1回払込期日</label>
										</div>
										<div>
											<pn:printWareki date='${md004_02Form.lblID_Date_FirstHaraikomiAfterKurisho}' pattern='GYMD'/>
										</div>
									</div>
									<div class="item-output">
										<div>
											<label id="Label38">入金日</label>
										</div>
										<div>
											<pn:printWareki date='${md004_02Form.lblID_Date_Nyukin}' pattern='GYMD'/>
										</div>
									</div>
									<div class="item-output">
										<div>
											<label id="Label39">繰償事由コード</label>
										</div>
										<div>
											<parts:dlabel path="lblID_Code_Kurishojiyu" />
										</div>
									</div>
								</div>
								<div class="report_a_line">
									<div class="item-output">
										<div>
											<label id="Label40">利息(円)</label></div>
										<div class="styleMoney" style="text-align: right;">
											<parts:dlabel path="lblID_M_KurishoRisoku" />
										</div>
									</div>
									<div class="item-output">
										<div>
											<label id="Label41">元金(円)</label></div>
										<div class="styleMoney" style="text-align: right;">
											<parts:dlabel path="lblID_M_KurishoGankin" />
										</div>
									</div>
									<div class="item-output">
										<div>
											<label id="Label42">控除利息(円)</label></div>
										<div class="styleMoney" style="text-align: right;">
											<parts:dlabel path="lblID_M_KojoRisoku" />
										</div>
									</div>
									<div class="item-output">
										<div>
											<label id="Label43">繰上償還手数料(円)</label></div>
										<div class="styleMoney" style="text-align: right;">
											<parts:dlabel path="lblID_M_KurishoCommission" />
										</div>
									</div>
								</div>
								<div class="report_a_line">
									<div class="item-output">
										<div>
											<label id="Label44">仮受金からの充当額(円)</label></div>
										<div class="styleMoney" style="text-align: right;">
											<parts:dlabel path="lblID_M_KariukeIppanJuto" />
										</div>
									</div>
									<div class="item-output">
										<div>
											<label id="Label45">送金額(円)</label></div>
										<div class="styleMoney" style="text-align: right;">
											<parts:dlabel path="lblID_M_Sokin" />
										</div>
									</div>
									<div class="item-output">
										<div>
											<label id="Label46">繰償後残元金(円)</label></div>
										<div class="styleMoney" style="text-align: right;">
											<parts:dlabel path="lblID_M_ZanGankinAfterKurisho" />
										</div>
									</div>
								</div>
								<div class="report_a_line">
									<div class="item-output">
										<div>
											<label id="Label20">受託者勘定処理年月</label>
										</div>
										<div>
											<pn:printWareki date='${md004_02Form.lblID_Date_JtkShori}' pattern='GYM'/>
										</div>
									</div>
									<div class="item-output">
										<div>
											<label id="Label48">送金日</label></div>
										<div>
											<pn:printWareki date='${md004_02Form.lblID_Date_Sokin}' pattern='GYMD'/>
										</div>
									</div>
									<div class="item-output">
										<div>
											<label id="Label49">送金日番号</label>
										</div>
										<div>
											<parts:dlabel path="lblID_ID_Sokinbi" />
										</div>
									</div>
									<div class="item-output">
										<div>&nbsp;</div>
										<div>
											<span>
												<parts:checkbox path="chkID_ID_After_Daiibensai" id="chkID_ID_After_Daiibensai" value="1" style="text-align: right;" name="chkID_ID_After_Daiibensai" disabled="true"/>
												<label for="chkID_ID_After_Daiibensai">代弁履行後の作成</label>
											</span>
										</div>
									</div>
								</div>
								<div class="report_a_line">
									<div class="teikishokan">
										<fieldset id="teiki">
											<legend style="font-size: 9pt; color: #0066ff;" align="left">◆定期償還の場合</legend>
											<div class="item-output">
												<parts:table>
													<tr>
														<td>
															<label id="La50">払込期日</label><br />
															<pn:printWareki date='${md004_02Form.lblID_Date_Haraikomi1}' pattern='GYMD'/><br />
															<pn:printWareki date='${md004_02Form.lblID_Date_Haraikomi2}' pattern='GYMD'/><br />
															<pn:printWareki date='${md004_02Form.lblID_Date_Haraikomi3}' pattern='GYMD'/><br />
															<pn:printWareki date='${md004_02Form.lblID_Date_Haraikomi4}' pattern='GYMD'/>
														</td>
														<td class="styleMoney">
															<label id="Label23">払込元金(円)</label><br />
															<div style="text-align: right;"><parts:dlabel path="lblID_M_HaraikomiGankin1" />円</div>
															<div style="text-align: right;"><parts:dlabel path="lblID_M_HaraikomiGankin2" />円</div>
															<div style="text-align: right;"><parts:dlabel path="lblID_M_HaraikomiGankin3" />円</div>
															<div style="text-align: right;"><parts:dlabel path="lblID_M_HaraikomiGankin4" />円</div>
														</td>
													</tr>
												</parts:table>
											</div>
										</fieldset>
									</div>
									<div>
										<fieldset id="gankin">
											<legend style="font-size: 9pt; color: #0066ff;" align="left">◆元金均等償還・期限固定の場合</legend>
											<div class="item-output">
												<div>
													<label id="Label52">繰償後元金均等額(円)</label></div>
												<div class="styleMoney" style="text-align: right;">
													<parts:dlabel path="lblID_M_GankinKintoAfterKurisho" />
												</div>
											</div>
											<div class="item-output">
												<div>
													<label id="Label53">繰償後元金不均等額(円)</label></div>
												<div class="styleMoney" style="text-align: right;">
													<parts:dlabel path="lblID_M_GankinFukintoAfterKurisho" />
												</div>
											</div>
											<div class="item-output">
												<div>
													<label id="Label54">調整コード</label></div>
												<div>
													<span id="rdoID_Code_chosei">
														<span>
															<parts:radioButton path="rdoID_Code_chosei" id="rdoID_Code_chosei" value="1" name="rdoID_Code_chosei" disabled="true" />
															<label for="rdoID_Code_chosei_0">初回</label></span>
														<span>
															<parts:radioButton path="rdoID_Code_chosei" id="rdoID_Code_chosei" value="2" name="rdoID_Code_chosei" disabled="true" />
															<label for="rdoID_Code_chosei_1">最終回</label></span>
														<span>
															<parts:radioButton path="rdoID_Code_chosei" id="rdoID_Code_chosei" value="" name="rdoID_Code_chosei" disabled="true" />
															<label for="rdoID_Code_chosei_2">なし</label></span>
													</span></div>
											</div>
										</fieldset>
									</div>
								</div>
							</div>
						</div>
					</div>
				</logic:equal>
				</div>
			</div>
		</div>
		</parts:form><%@ include file="/jsp/incFooter.jsp"%>
	</body>
</html>