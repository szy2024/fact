<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/jsp/incTop.jsp"%>
<%@ taglib prefix="pn" uri="http://partnernet.jfc.go.jp/tags/pn"%>
<%--================================================================================================
 * Project Name : パートナーネット開発
 * System Name  : パートナーネット
 * File Name    : se003_02.jsp
 *
 * <<Modification History>>
 * Version | Date       | Updated By            | Content
 * --------+------------+-----------------------+---------------------------------------------------
 * 1.0.0   | 2015/07/01 | 西本　比呂            | 新規作成
====================================================================================================--%>

<html>
	<%@ include file="/jsp/incHeader.jsp"%>
	<head>
		<title><parts:message code="title.screenName"/></title>
		 <script lang="JavaScript">
//<!--
		    <%-- 戻るボタン処理 --%>
		    function click_backBtn() {
		        executeAction('../../se003/se003_02/Se003_02Back.form');
		    }
//-->
		 </script>
		 <link href="<%= request.getContextPath() %>/css/se003.css" type="text/css" rel="stylesheet" />
	</head>
	<body>
		<parts:form modelAttribute="se003_02Form" action="./Se003_02Init.form" id="Form1" method="post">
			<%@ include file="/jsp/incCommonHidden.jsp" %>
			<%@ include file="/jsp/incHeaderArea.jsp" %>
			<div id="main_scroll_area">
			<div class="header">
				<div class="title">
					<label id="lblTitle" class="Title"><parts:message code="title.screenName"/></label>
				</div>
			</div>
			<div class="main">
	            <div class="status" style="color: red; font-weight: bold;">
	                <parts:errors path="*" cssClass="Error" />
	            </div>
				<div>
					<parts:button id="btnBack" value="戻る"  onclick="click_backBtn()"></parts:button>
				</div>
				<br />
				<%--- 注意喚起メッセージ --%>
				<div class="infoMessage">
					<parts:dlabel path="lblError" htmlEscape="false" />
				</div>
				<div style="border:none;">
					<parts:table cssClass="ringi" id="se003_02Table">
					<parts:tr>
						<td style="border:none; text-align:left;" >
						<parts:table cssClass="ringi">
							<tr>
								<td class="Header" Rowspan="2" style="white-space:nowrap;">公庫支店名</td>
								<td class="Header" Rowspan="2" style="white-space:nowrap;">扱店</td>
								<td class="Header" Rowspan="2" style="white-space:nowrap;">店舗</td>
								<td class="Header" Colspan="4" style="white-space:nowrap;">融資番号</td>
								<td class="Header" Rowspan="2" style="white-space:nowrap;">貸付金額(円)</td>
								<td class="Header" Rowspan="2" style="white-space:nowrap;">資金使途名</td>
								<td class="Header" Rowspan="2" style="white-space:nowrap;">繰償手数料</td>
							</tr>
							<tr>
								<td class="Header" style="white-space:nowrap;">年度</td>
								<td class="Header" style="white-space:nowrap;">方式資金</td>
								<td class="Header" style="white-space:nowrap;">番号</td>
								<td class="Header" style="white-space:nowrap;">枝番</td>
							</tr>
							<tr>
								<td class="DataCell" style="white-space:nowrap;">
									<parts:dlabel path="ID_ID_Name_KoukoShiten" />
								</td>
								<td class="DataCell" style="white-space:nowrap;">
									<parts:dlabel path="ID_Code_Organization" />
								</td>
								<td class="DataCell" style="white-space:nowrap;">
									<parts:dlabel path="ID_Code_Tenpo" />
								</td>
								<td class="DataCell" style="white-space:nowrap;">
									<pn:printWareki date="${se003_02Form.ID_Year}" pattern="GY" />
									<!-- <parts:dlabel path="ID_Year" /> -->
								</td>
								<td class="DataCell" style="white-space:nowrap;">
									<parts:dlabel path="ID_Kubun_Hoshiki" />
								</td>
								<td class="DataCell" style="white-space:nowrap;">
									<parts:dlabel path="ID_ID_Ringi" />
								</td>
								<td class="DataCell" style="white-space:nowrap;">
									<parts:dlabel path="ID_ID_RingiBranch" />
								</td>
								<td class="DataCell" style="white-space:nowrap;">
									<div class="ringiMoney">
										<parts:dlabel path="ID_M_Kashitsuke" />
									</div>
								</td>
								<td class="DataCell" style="white-space:nowrap;">
									<parts:dlabel path="ID_Name_ShikinShito" />
								</td>
								<td class="DataCell" style="white-space:nowrap;">
									<parts:dlabel path="ID_Kubun_KurishoTesuryo" />
								</td>
							</tr>
						</parts:table>
						<parts:table cssClass="ringi">
							<tr>
								<td class="Header" style="white-space:nowrap;">金利制度の選択</td>
								<td class="Header" style="white-space:nowrap;">利率(%)</td>
								<td class="Header" style="white-space:nowrap;">特利コード</td>
								<td class="Header" style="white-space:nowrap;">特利(%)</td>
								<td class="Header" style="white-space:nowrap;">指標率(%)</td>
								<td class="Header" style="white-space:nowrap;">据置期限</td>
								<td class="Header" style="white-space:nowrap;">償還期限</td>
								<td class="Header" style="white-space:nowrap;">元利金払込日</td>
								<td class="Header" style="white-space:nowrap;">償還方法コード</td>
								<td class="Header" style="white-space:nowrap;">元金不均等額区分</td>
							</tr>
							<tr>
								<td class="DataCell" style="white-space:nowrap;">
									<parts:dlabel path="ID_Kubun_KinriSeidoSentaku" />
								</td>
								<td class="DataCell" style="white-space:nowrap;">
									<parts:dlabel path="ID_Riritsu" />
								</td>
								<td class="DataCell" style="white-space:nowrap;">
									<parts:dlabel path="ID_Kubun_Tokuri" />
								</td>
								<td class="DataCell" style="white-space:nowrap;">
									<parts:dlabel path="ID_Tokuri" />
								</td>
								<td class="DataCell" style="white-space:nowrap;">
									<parts:dlabel path="ID_Shihyoritsu" />
								</td>
								<td class="DataCell" style="white-space:nowrap;">
									<pn:printWareki date="${se003_02Form.ID_Date_SueokiKigen}" pattern="GYM" />
									<!-- <parts:dlabel path="ID_Date_SueokiKigen" /> -->
								</td>
								<td class="DataCell" style="white-space:nowrap;">
									<pn:printWareki date="${se003_02Form.ID_Date_ShokanKigen}" pattern="GYM" />
									<!-- <parts:dlabel path="ID_Date_ShokanKigen" /> -->
								</td>
								<td class="DataCell" style="white-space:nowrap;">
									<parts:dlabel path="ID_Date_GanrikinHaraiKomi" />
								</td>
								<td class="DataCell" style="white-space:nowrap;">
									<parts:dlabel path="ID_Code_ShokanHouhou" />
								</td>
								<td class="DataCell" style="white-space:nowrap;">
									<parts:dlabel path="ID_Kubun_GankinFukintogaku" />
								</td>
							</tr>
						</parts:table>
						<parts:table cssClass="ringi">
							<tr>
								<td class="Header" style="white-space:nowrap;">元利又は元金均等額(円)</td>
								<td class="Header" style="white-space:nowrap;">元金不均等額(円)</td>
								<td class="Header" style="white-space:nowrap;">貸付決定日</td>
								<td class="Header" style="white-space:nowrap;">貸付実行日</td>
								<td class="Header" style="white-space:nowrap;">貸付実行額(円)</td>
								<td class="Header" style="white-space:nowrap;">貸付金現在残高(円)</td>
							</tr>
							<tr>
								<td class="DataCell" style="white-space:nowrap;">
									<div class="ringiMoney">
										<parts:dlabel path="ID_M_Fukin" />
									</div>
								</td>
								<td class="DataCell" style="white-space:nowrap;">
									<div class="ringiMoney">
										<parts:dlabel path="ID_M_GankinFukinto" />
									</div>
								</td>
								<td class="DataCell" style="white-space:nowrap;">
									<pn:printWareki date="${se003_02Form.ID_Date_KetteiKisan}" pattern="GYMD" />
									<!-- <parts:dlabel path="ID_Date_KetteiKisan" />  -->
								</td>
								<td class="DataCell" style="white-space:nowrap;">
									<pn:printWareki date="${se003_02Form.ID_Date_Jikko}" pattern="GYMD" />
									<!-- <parts:dlabel path="ID_Date_Jikko" /> -->
								</td>
								<td class="DataCell" style="white-space:nowrap;">
									<div class="ringiMoney">
										<parts:dlabel path="ID_M_KashitsukeJikko" />
									</div>
								</td>
								<td class="DataCell" style="white-space:nowrap;">
									<div class="ringiMoney">
										<parts:dlabel path="ID_M_KashitsukeZandaka" />
									</div>
								</td>
							</tr>
						</parts:table>
						<br />
						<parts:table id= "grdResults">
							<hr />
							<br />
							<parts:tr>
								<td  style="border:none; text-align:left;">
									<paging:table path="Se003_02M1Table" paging="false" pagingDisplay="false" >
										<parts:table cssClass="haraidashi" border="none">
											<paging:head>
												<tr class="dtgHeader" style="white-space:nowrap;">
													<td class="recordHeader" style="white-space:nowrap;">払出日</td>
													<td class="recordHeader" style="white-space:nowrap;">区分</td>
													<td class="recordHeader" style="white-space:nowrap;">払出額</td>
													<td class="recordHeader" style="white-space:nowrap;">払出累計額</td>
													<td class="recordHeader" style="white-space:nowrap;">繰償額</td>
													<td class="recordHeader" style="white-space:nowrap;">繰償累計額</td>
													<td class="recordHeader" style="white-space:nowrap;">受入金残高</td>
												</tr>
											</paging:head>
											<paging:record>
												<tr style="white-space:nowrap;">
													<td style="white-space:nowrap;">
														<pn:printWareki date="${record.ID_Date_HaraidashiJuto}" pattern="GYMD" />
														<!-- <parts:dlabel path="ID_Date_HaraidashiJuto" /> -->
													</td>
													<td style="white-space:nowrap;">
														<parts:dlabel path="ID_Kubun_Haraidashi" htmlEscape="false" />
													</td>
													<td class="moneyWidth" style="white-space:nowrap;">
														<parts:dlabel path="ID_M_Haraidashi" />
													</td>
													<td class="moneyWidth" style="white-space:nowrap;">
														<parts:dlabel path="ID_M_HaraidashiRuikei" />
													</td>
													<td class="moneyWidth" style="white-space:nowrap;">
														<parts:dlabel path="ID_M_Kurisho" />
													</td>
													<td class="moneyWidth" style="white-space:nowrap;">
														<parts:dlabel path="ID_M_KurishoRuikei" />
													</td>
													<td class="moneyWidth" style="white-space:nowrap;">
														<parts:dlabel path="ID_M_KashitsukeukeireZan" />
													</td>
												</tr>
											</paging:record>
										</parts:table>
									</paging:table>
								</td>
							</parts:tr>
						</parts:table>
						<br />
						<parts:table id="rptDetails_YakuteiNyukin">
							<hr  />
							<parts:tr>
								<td style="border:none; text-align:left;">
								<paging:table  path="Se003_02M2Table" paging="false" pagingDisplay="false">
									<div>
										<paging:record>
													<parts:table cssClass="nyukinYakujo">
														<tr class="dtgHeader" style="white-space:nowrap;">
															<td class="recordHeader" style="white-space:nowrap;">払込日付</td>
															<td class="recordHeader" style="white-space:nowrap;">約定利息(円)</td>
															<td class="recordHeader" style="white-space:nowrap;">約定元金(円)</td>
															<td class="recordHeader" style="white-space:nowrap;">繰上償還利息(円)</td>
															<td class="recordHeader" style="white-space:nowrap;">繰上償還元金(円)</td>
															<td class="recordHeader" style="white-space:nowrap;">利子助成額(円)</td>
															<td class="recordHeader" style="white-space:nowrap;">約定前残高(円)</td>
														</tr>
														<tr>
															<td style="white-space:nowrap;">
																<pn:printWareki date="${record.ID_Y_Date_Haraikomi}" pattern="GYMD" />
																<!-- <parts:dlabel path="ID_Y_Date_Haraikomi" /> -->
															</td>
															<td class="moneyWidth" style="white-space:nowrap;">
																<div class="moneyWidth">
																	<parts:dlabel path="ID_Y_M_YakujoRisoku" />
																</div>
															</td>
															<td class="moneyWidth" style="white-space:nowrap;">
																<div class="moneyWidth">
																	<parts:dlabel path="ID_Y_M_YakujoGankin" />
																</div>
															</td>
															<td class="moneyWidth" style="white-space:nowrap;">
																<div class="moneyWidth">
																	<parts:dlabel path="ID_Y_M_SeiKuriRisoku" />
																</div>
															</td>
															<td class="moneyWidth" style="white-space:nowrap;">
																<div class="moneyWidth">
																	<parts:dlabel path="ID_Y_M_SeiKuriGankin" />
																</div>
															</td>
															<td class="moneyWidth" style="white-space:nowrap;">
																<div class="moneyWidth">
																	<parts:dlabel path="ID_Y_M_RishiJosei" />
																</div>
															</td>
															<td class="moneyWidth" style="white-space:nowrap;">
																<div class="moneyWidth">
																	<parts:dlabel path="ID_Y_M_ZandakaBeforeYakujo" />
																</div>
															</td>
														</tr>
													</parts:table>
													<parts:table id="grdResults_Nyukin" border="0" cssClass="nyukinYakujo">
														<tr class="dtgHeader" style="white-space:nowrap;">
															<td class="recordHeader" style="white-space:nowrap;">
																入金日
															</td>
															<td class="recordHeader" style="white-space:nowrap;">
																約定利息(円)
															</td>
															<td class="recordHeader" style="white-space:nowrap;">
																約定元金(円)
															</td>
															<td class="recordHeader" style="white-space:nowrap;">
																任意繰上<br />償還利息(円)
															</td>
															<td class="recordHeader" style="white-space:nowrap;">
																任意繰上<br />償還元金(円)
															</td>
															<td class="recordHeader" style="white-space:nowrap;">
																請求繰上<br />償還利息(円)
															</td>
															<td class="recordHeader" style="white-space:nowrap;">
																請求繰上<br />償還元金(円)
															</td>
															<td class="recordHeader" style="white-space:nowrap;">
																遅延損害金<br />等(円)
															</td>
															<td class="recordHeader" style="white-space:nowrap;display:none;">
																違約金(円)
															</td>
															<td class="recordHeader" style="white-space:nowrap;display:none;">
																転用違約金(円)
															</td>
															<td class="recordHeader" style="white-space:nowrap;display:none;">
																棚上遅延損害金(円)
															</td>
															<td class="recordHeader" style="white-space:nowrap;display:none;">
																確定遅損金(円)
															</td>
															<td class="recordHeader" style="white-space:nowrap;">
																区分
															</td>
															<td class="recordHeader" style="white-space:nowrap;display:none;">
																払込年月日
															</td>
															<td class="recordHeader" style="white-space:nowrap;display:none;">
																債権管理番号
															</td>
														</tr>
													<!-- FOREACH_S -->
 													<c:forEach var="obj" items="${record.getTbl_se003_02M2DTO()}" varStatus="status">
														<tr style="white-space:nowrap;">
															<td style="white-space:nowrap;">
																<pn:printWareki date="${obj.getID_N_Date_Nyukin()}" pattern="GYMD" />
																<!-- <parts:dlabel path="ID_N_Date_Nyukin" /> -->
															</td>
															<td class="moneyWidth" style="white-space:nowrap;">
																 <c:out value="${obj.getID_N_M_YakujoRisoku()}" />
															</td>
															<td class="moneyWidth" style="white-space:nowrap;">
																<c:out value="${obj.getID_N_M_YakujoGankin()}" />
															</td>
															<td class="moneyWidth" style="white-space:nowrap;">
																<c:out value="${obj.getID_N_M_NinKuriRisoku()}" />
															</td>
															<td class="moneyWidth" style="white-space:nowrap;">
																<c:out value="${obj.getID_N_M_NinKuriGankin()}" />
															</td>
															<td class="moneyWidth" style="white-space:nowrap;">
																<c:out value="${obj.getID_N_M_SeiKuriRisoku()}" />
															</td>
															<td class="moneyWidth" style="white-space:nowrap;">
																<c:out value="${obj.getID_N_M_SeiKuriGankin()}" />
															</td>
															<td class="moneyWidth" style="white-space:nowrap;">
																<c:out value="${obj.getID_N_M_ChienSongai()}" />
															</td>
															<td style="white-space:nowrap;display:none;">
																<c:out value="${obj.getID_N_M_Iyaku()}" />
															</td>
															<td style="white-space:nowrap;display:none;">
																<c:out value="${obj.getID_N_M_TenyoIyaku()}" />
															</td>
															<td style="white-space:nowrap;display:none;">
																<c:out value="${obj.getID_N_M_TanaageChienSongai()}" />
															</td>
															<td style="white-space:nowrap;display:none;">
																<c:out value="${obj.getID_N_M_ThisChienSongai()}" />
															</td>
															<td style="white-space:nowrap;">
																<c:out value="${obj.getID_N_Kubun_Nyukin()}" />
															</td>
															<td style="white-space:nowrap;display:none;">
																<c:out value="${obj.getID_N_Date_Haraikomi()}" />
															</td>
															<td style="white-space:nowrap;display:none;">
																<c:out value="${obj.getID_N_ID_Credit()}" />
															</td>
														</tr>
													</c:forEach>
													<!-- FOREACH_E -->
												</parts:table>
											<br />
										</paging:record>
									</div>
								</paging:table>
								</td>
							</parts:tr>
						</parts:table>
						</td>
					</parts:tr>
				</parts:table>
				</div>
			</div>
		</div>
		</parts:form><%@ include file="/jsp/incFooter.jsp"%>
	</body>
</html>