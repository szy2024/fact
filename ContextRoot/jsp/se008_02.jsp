<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="pn" uri="http://partnernet.jfc.go.jp/tags/pn"%>
<%--================================================================================================
 * Project Name : パートナーネット開発
 * System Name  : パートナーネット
 * File Name    : se008_02.jsp
 *
 * <<Modification History>>
 * Version | Date       | Updated By            | Content
 * --------+------------+-----------------------+---------------------------------------------------
 * 1.0.0   | 2015/07/08 | 木村　しのぶ          | 新規作成
================================================================================================--%>
<%@ include file="/jsp/incTop.jsp" %>
<html>
	<%@ include file="/jsp/incHeader.jsp"%>
<head>
		<title><parts:message code="title.screenName"/></title>



        <link href="<%=request.getContextPath()%>/css/se008.css" type="text/css" rel="stylesheet" />
        <script lang="JavaScript">
		<!--
		    <%-- 戻るボタン処理 --%>
		    function click_backBtn() {
		        executeAction('../../se008/se008_02/Se008_02Back.form');
		    }

		    function deleteMessage() {
		    	$("#waitMessage").css("display", "none");
		    }


		//-->
		</script>
	</head>
	<body onload="deleteMessage()">
		<parts:form modelAttribute="se008_02Form" action="./Se008_02Init.form" id="Form1" method="post">
			<%@ include file="/jsp/incCommonHidden.jsp" %>
			<%@ include file="/jsp/incHeaderArea.jsp" %>
			<div id="main_scroll_area">
			<div class="header">
				<div class="title">
					<label id="lblTitle" class="Title"><parts:message code="title.screenName"/></label>
				</div>
			</div>
			<div class="main">
				<div class="status">
					<span id="se008_ID02_Result_UC_lblError" class="errorMessage">
						<parts:errors path="*" cssClass="Error" /><parts:dlabel path="lblError" />
					</span>
				</div>
				<p>
					<parts:button id="btnBack" value="戻る" onclick="click_backBtn()"></parts:button>
					<span id="waitMessage">　　検索していますので、しばらくお待ちください。</span>
				</p>
				<paging:table path="se008_02M1Table" paging="false" pagingDisplay="false">
					<div>
						<parts:table id="Results" border="1" cssStyle="line-height:1.0em;">
							<paging:head sort="false">
								<tr>
									<td class="recordHeader">
										顧客名
									</td>
									<td class="recordHeader">
										公庫支店名
									</td>
									<td class="recordHeader">
										扱店
									</td>
									<td class="recordHeader">
										店舗
									</td>
									<td class="recordHeader">
										年度
									</td>
									<td class="recordHeader">
										方式<br  />
										資金
									</td>
									<td class="recordHeader">
										番号
									</td>
									<td class="recordHeader">
										枝番
									</td>
									<td class="recordHeader">
										払込期日
									</td>
									<td class="recordHeader">
										約定利息
									</td>
									<td class="recordHeader">
										約定元金
									</td>
									<td class="recordHeader">
										控除利息
									</td>
									<td class="recordHeader">
										請求繰上償還元金
									</td>
									<td class="recordHeader">
										請求繰上償還利息
									</td>
									<td class="recordHeader">
										任意繰上償還利息
									</td>
								</tr>
							</paging:head>
							<paging:record>
								<tr>
									<td style="width:10em">
										<parts:dlabel path="ID_Name_Customer" />
									</td>
									<td style="width:5em">
										<parts:dlabel path="ID_Name_KoukoShiten" />
									</td>
									<td>
										<parts:dlabel path="ID_Code_Organization" />
									</td>
									<td class="YushiNo">
										<parts:dlabel path="ID_Code_Tenpo" />
									</td>
									<td class="YushiNo">
										<pn:printWareki date="${record.ID_Year}" pattern="GY" />
									</td>
									<td class="YushiNo">
										<parts:dlabel path="ID_Kubun_HoshikiShikin" />
									</td>
									<td class="YushiNo">
										<parts:dlabel path="ID_ID_Ringi" />
									</td>
									<td class="YushiNo">
										<parts:dlabel path="ID_ID_RingiBranch" />
									</td>
									<td class="YushiNo">
										<pn:printWareki date="${record.ID_Date_Haraikomi}" pattern="GYMD" />
									</td>
									<td class="moneyStyle"  align="right">
										<parts:dlabel path="ID_M_YakujoRisoku" />
									</td>
									<td class="moneyStyle" align="right">
										<parts:dlabel path="ID_M_YakujoGankin" />
									</td>
									<td class="moneyStyle" align="right">
										<parts:dlabel path="ID_M_KojoRisoku" />
									</td>
									<td class="moneyStyle" align="right">
										<parts:dlabel path="ID_M_SeiKuriGankin" />
									</td>
									<td class="moneyStyle" align="right">
										<parts:dlabel path="ID_M_SeiKuriRisoku" />
									</td>
									<td class="moneyStyle" align="right">
										<parts:dlabel path="ID_M_NinKuriRisoku" />
									</td>
								</tr>
								<!--合計行  -->
								<logic:equal path="totalDisplayFlg" value="1">
									<tr>
										<td colspan="9" align="right">
											合計
										</td>
										<td class="moneyStyle">
											<parts:dlabel path="lblID_M_YakujoRisokuKEI" />
										</td>
										<td class="moneyStyle">
											<parts:dlabel path="lblID_M_YakujoGankinKEI" />
										</td>
										<td class="moneyStyle">
											<parts:dlabel path="lblID_M_KojoRisokuKEI" />
										</td>
										<td class="moneyStyle">
											<parts:dlabel path="lblID_M_SeiKuriGankinKEI" />
										</td>
										<td class="moneyStyle">
											<parts:dlabel path="lblID_M_SeiKuriRisokuKEI" />
										</td>
										<td class="moneyStyle">
											<parts:dlabel path="lblID_M_NiniRisokuKEI" />
										</td>
									</tr>
								</logic:equal>
							</paging:record>
						</parts:table>
					</div>
				</paging:table>
				<br>
			</div>
		</div>
		</parts:form><%@ include file="/jsp/incFooter.jsp"%>
	</body>
</html>