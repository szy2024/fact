
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/jsp/incTop.jsp"%>
<%@ taglib prefix="pn" uri="http://partnernet.jfc.go.jp/tags/pn"%>

<%--================================================================================================
 * Project Name : パートナーネット開発
 * System Name  : パートナーネット
 * File Name    : cr006_03.jsp
 *
 * <<Modification History>>
 * Version | Date       | Updated By            | Content
 * --------+------------+-----------------------+---------------------------------------------------
 * 1.0.0   | 2015/07/01 | 橋本　亮　            | 新規作成
================================================================================================--%>

<html>
	<%@ include file="/jsp/incHeader.jsp"%>
	<head>
		<title><parts:message code="title.screenName"/></title>

<script lang="JavaScript">
//<!--
				<%--
				登録ボタン押下時の処理
				--%>
				function click_torokuBtn() {
					executeAction('../../cr006/cr006_03/Cr006_03Send.form');
				}

				<%--
				戻る押下時の処理
				--%>
				function click_backBtn() {
					executeAction('../../cr006/cr006_03/Cr006_03Back.form');
				}

//-->
</script>

		<link href="<%=request.getContextPath()%>/css/cr006.css" type="text/css" rel="stylesheet" />
		<script language="JavaScript" type="text/javascript" src="<%= request.getContextPath() %>/js/ptncommon.js"></script>
	</head>
	<body onload="initTextFormat()">
		<parts:form id="Form1" modelAttribute="cr006_03Form" action="./Cr006_03Init.form" method="post" onsubmit="return false;">
			<%@ include file="/jsp/incCommonHidden.jsp" %>
			<%@ include file="/jsp/incHeaderArea.jsp" %>
			<div id="main_scroll_area">
			<div class="header">
				<div class="title">
					<span class="Title" id="lblTitle"><parts:message code="title.screenName"/></span>
				</div>
			</div>
			<div class="main">
				<div class="greeting">以下の報告書の登録を行います。内容をご確認のうえ「登録」ボタンを押してください。
				</div>
				<div class="greeting">立替金受入・充当報告書の作成の入力画面へ戻る場合には「戻る」ボタンを押してください。
				</div>
				<div class="buttons"><parts:button id="btnID_Send2" value="登録" onclick="click_torokuBtn();"/>
					<parts:button id="btnBack" value="戻る" title="戻る" onclick="click_backBtn()" /></div>
				<div class="reportDate">報告年月日：
					<parts:dlabel path="lblID_Date_Report" /></div>
				<div class="status">
					<div style="color:red;font-weight:bold;">
						<parts:errors path="*" cssClass="Error" />
					</div>
				</div>
				<div id="report1">
					<div align="center">
									<div class="report" style="overflow:hidden; ">
							<div class="report_a_line"><!-- 出力用 -->
								<div class="item-output">
									<div><!-- 項目名 -->
										<label id="Label2">顧客名</label></div>
									<div><!-- 値 -->
										<parts:dlabel path="lblID_Name_Customer" /></div>
								</div> <!-- 出力用 -->
								<div class="item-output">
									<div><!-- 項目名 -->
										<label id="Label1">扱店名</label></div>
									<div><!-- 値 -->
										<parts:dlabel path="lblID_Name_Organization" /></div>
								</div>
							</div> <!-- 報告書の一行分(複数可) -->
							<div class="report_a_line"><!-- 出力用 -->
								<div class="item-output">
									<div><!-- 項目名 -->
										<label id="Label3">公庫支店</label></div>
									<div><!-- 値 -->
										<parts:dlabel path="lblID_Code_KoukoShiten" /></div>
								</div> <!-- 出力用 -->
								<div class="item-output">
									<div><!-- 項目名 -->
										<label id="Label4">扱店</label></div>
									<div><!-- 値 -->
										<parts:dlabel path="lblID_Code_Organization" /></div>
								</div> <!-- 出力用 -->
								<div class="item-output">
									<div><!-- 項目名 -->
										<label id="Label5">店舗</label></div>
									<div><!-- 値 -->
										<parts:dlabel path="lblID_Code_Tenpo" /></div>
								</div> <!-- 出力用 -->
								<div class="item-output">
									<div><!-- 項目名 -->
										<label id="Label6">年度</label></div>
									<div><!-- 値 -->
										<pn:printWareki date='${cr006_03Form.lblID_Year}' pattern='GY'/></div>
									</div> <!-- 出力用 -->
								<div class="item-output">
									<div><!-- 項目名 -->
										<label id="Label7">方式資金</label></div>
									<div><!-- 値 -->
										<parts:dlabel path="lblID_Code_HoshikiShikin" /></div>
								</div> <!-- 出力用 -->
								<div class="item-output">
									<div><!-- 項目名 -->
										<label id="Label8">番号</label></div>
									<div><!-- 値 -->
										<parts:dlabel path="lblID_ID_Ringi" /></div>
								</div> <!-- 出力用 -->
								<div class="item-output">
									<div><!-- 項目名 -->
										<label id="Label9">枝番</label></div>
									<div><!-- 値 -->
										<parts:dlabel path="lblID_ID_RingiBranch" /></div>
								</div>
							</div> <!-- 報告書の一行分(複数可) -->
							<div class="report_a_line"><!-- 出力用 -->
								<div class="item-output">
									<div><!-- 項目名 -->
										<label id="Label10">入金日</label></div>
									<div><!-- 値 -->
										<pn:printWareki date='${cr006_03Form.lblID_Date_Nyukin}' pattern='GYMD'/></div>
								</div> <!-- 出力用 -->
								<div class="item-output">
									<div><!-- 項目名 -->
										<label id="Label11">立替金利息(円)</label></div>
									<div class="styleMoney" ><!-- 値 -->
										<parts:dlabel path="lblID_M_TatekaeRisoku" /></div>
								</div> <!-- 出力用 -->
								<div class="item-output">
									<div><!-- 項目名 -->
										<label id="Label12">立替金(円)</label></div>
									<div class="styleMoney" ><!-- 値 -->
										<parts:dlabel path="lblID_M_Tatekae" /></div>
								</div> <!-- 出力用 -->
								<div class="item-output">
									<div><!-- 項目名 -->
										<label id="Label13">仮受金(一般口)からの充当額(円)</label></div>
									<div class="styleMoney" style="width:165px;"><!-- 値 -->
										<parts:dlabel path="lblID_M_KariukeIppanJuto" /></div>
								</div>
							</div> <!-- 報告書の一行分(複数可) -->
							<div class="report_a_line"><!-- 出力用 -->
								<div class="item-output">
									<div><!-- 項目名 -->
										<label id="Label14">立替金の種類</label></div>
									<div><!-- 値 -->
										<parts:codeName code='${cr006_03Form.lblID_Code_TatekaekinShurui}' categoryCode='00006'/></div>
								</div> <!-- 出力用 -->
								<div class="item-output">
									<div><!-- 項目名 -->
										<label id="Label15">公庫立替日</label></div>
									<div><!-- 値 -->
										<pn:printWareki date='${cr006_03Form.lblID_Date_KoukoTatekae}' pattern='GYMD'/></div>
								</div> <!-- 出力用 -->
								<div class="item-output">
									<div><!-- 項目名 -->
										<label id="Label16">計(円)</label></div>
									<div class="styleMoney" ><!-- 値 -->
										<parts:dlabel path="lblID_M_Kei" /></div>
								</div>
							</div> <!-- 報告書の一行分(複数可) -->
							<div class="report_a_line"><!-- 出力用 -->
								<div class="item-output">
									<div><!-- 項目名 -->
										<label id="Label17">送金額(円)</label></div>
									<div class="styleMoney" ><!-- 値 -->
										<parts:dlabel path="lblID_M_Sokin" /></div>
								</div> <!-- 出力用 -->
								<div class="item-output">
									<div><!-- 項目名 -->
										<label id="Label18">受入後立替金残高(円)</label></div>
									<div class="styleMoney" style="width:115px;" ><!-- 値 -->
										<parts:dlabel path="lblID_M_TatekaeZanAfterUkeire" /></div>
								</div> <!-- 出力用 -->
							</div> <!-- 報告書の一行分(複数可) -->
							<div class="report_a_line"><!-- 出力用 -->
								<div class="item-output">
									<div><!-- 項目名 -->
										<label id="Label19">受託者勘定処理年月</label></div>
									<div><!-- 値 -->
										<pn:printWareki date='${cr006_03Form.lblID_Date_Jtkshori}' pattern='GYM'/></div>
								</div> <!-- 出力用 -->
								<div class="item-output">
									<div><!-- 項目名 -->
										<label id="Label20">送金年月日</label></div>
									<div><!-- 値 -->
										<pn:printWareki date='${cr006_03Form.lblID_Date_Sokin}' pattern='GYMD'/></div>
								</div> <!-- 出力用 -->
								<div class="item-output">
									<div><!-- 項目名 -->
										<label id="Label21">送金日番号</label></div>
									<div><!-- 値 -->
										<parts:dlabel path="lblID_ID_Sokinbi" /></div>
								</div>
							</div>
						</div> <!-- 報告書一枚終わり -->
			</div>
						</div>
			</div>
		</div>
		</parts:form><%@ include file="/jsp/incFooter.jsp"%>
	</body>
</html>