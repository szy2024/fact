
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/jsp/incTop.jsp" %>

<%--================================================================================================
 * Project Name : パートナーネット開発
 * System Name  : パートナーネット
 * File Name    : md006_02.jsp
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
        executeAction('../../md006/md006_02/Md006_02Create.form');
    }

    function click_backBtn() {
        executeAction('../../md006/md006_02/Md006_02Back.form');
    }

    //-->
    </script>
		<title><parts:message code="title.screenName"/></title>




		<link href="<%=request.getContextPath()%>/css/md006.css" type="text/css" rel="stylesheet" />
	</head>
	<body>
		<parts:form modelAttribute="md006_02Form" id="Form1" method="post">
			<%@ include file="/jsp/incCommonHidden.jsp" %>
			<%@ include file="/jsp/incHeaderArea.jsp" %>
			<div id="main_scroll_area">
			<%@ taglib prefix="pn" uri="http://partnernet.jfc.go.jp/tags/pn" %>
			<div class="header">
				<div class="title">
					<label id="lblTitle" class="Title"><parts:message code="title.screenName"/></label>
				</div>
			</div>
			<div class="main">

				<div class="greeting">
					取消対象報告書が確定しました。<br />
					以下の報告書の登録を行います。内容をご確認のうえ「登録」ボタンを押してください。
				</div>
				<div class="greeting">
					<parts:dlabel path="lblBack" />
				</div>
				<div class="buttons">
					<div style="display:none;">
						<parts:button id="btnUpdate" />
						<parts:button id="btnBack" />
					</div>
					<parts:button id="btnUpdate2" value="登録"  onclick="clearTextFormat();click_updateBtn();" />
					<parts:button id="btnBack2" value="戻る"  onclick="click_backBtn();" title="立替金受入・充当報告書の取消・修正の入力画面へ戻る" />
				</div>
				<div class="status">
					<div style="color:red;font-weight:bold;">
						<parts:errors path="*" /><span id="lblError"><parts:dlabel path="lblError" /></span>
					</div>
				</div>
				<div class="reportDate">報告年月日：
				<!--	<div class="Error"> -->
				<!--		<parts:dlabel path="lblID_Date_Report" /> -->
				<!--	</div> -->
					<fmt:parseDate value="${md006_02Form.lblID_Date_Report}" var="ID_Date_Report" pattern="yyyyMMdd" />
                    <fmt:formatDate value="${ID_Date_Report}" pattern="yyyy年MM月dd日(E)"/>
				</div>
				<div align="center">
					<div id="pnl_Red" style="padding-bottom: 15px;">
					<parts:tr id="formRedArea">
					<div class="page-break"><br/></div>
						<!-- 報告書一枚(borderで囲んである,複数可) -->
						<!-- 実装時はASP.NETのユーザコントロールよびだし -->
						<!-- ジャンプ用アンカー(名前) -->
						<div class="report">
							<div class="kousei-aka">
							<!--  	<parts:dlabel path="redAreaTitle"/></div>&nbsp; -->
							<!--	<label id="lblID_Head_Red2" style="color:red;">赤</label></div> <!-- ジャンプ用アンカー(名前) -->
					           <parts:tr id="redAreaTitle1">更正　<span style="color:red;">赤</span></parts:tr>
                               <parts:tr id="redAreaTitle2">取消内容</parts:tr>
                            </div>
							<div align="center"><!-- 出力用 --> <!-- 報告書の一行分(複数可) -->
								<div class="report_a_line"><!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 -->
											<label id="Label17">顧客名</label></div>
										<div><!-- 値 -->
											<parts:dlabel path="lblID_Name_Customer_Red" /></div>
									</div> <!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 -->
											<label id="Label24">扱店名</label></div>
										<div><!-- 値 -->
											<parts:dlabel path="lblID_Name_Organization_Red" /></div>
									</div>
								</div> <!-- 報告書の一行分(複数可) -->
								<div class="report_a_line"><!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 -->
											<label id="Label26">公庫支店</label></div>
										<div><!-- 値 -->
											<parts:dlabel path="lblID_Code_KoukoShiten_Red" /></div>
									</div> <!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 -->
											<label id="Label28">扱店</label></div>
										<div><!-- 値 -->
											<parts:dlabel path="lblID_Code_Organization_Red" /></div>
									</div> <!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 -->
											<label id="Label30">店舗</label></div>
										<div><!-- 値 -->
											<parts:dlabel path="lblID_Code_Tenpo_Red" /></div>
									</div> <!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 -->
											<label id="Label32">年度</label></div>
										<div><!-- 値 -->
										<!-- 	<parts:dlabel path="lblID_Year_Red" /></div> -->
											<pn:printWareki date="${md006_02Form.lblID_Year_Red}" pattern='GY' /></div>
									</div> <!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 -->
											<label id="Label34">方式資金</label></div>
										<div><!-- 値 -->
											<parts:dlabel path="lblID_Kubun_HoshikiShikin_Red" /></div>
									</div> <!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 -->
											<label id="Label36">番号</label></div>
										<div><!-- 値 -->
											<parts:dlabel path="lblID_ID_Ringi_Red" /></div>
									</div> <!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 -->
											<label id="Label38">枝番</label></div>
										<div><!-- 値 -->
											<parts:dlabel path="lblID_ID_RingiBranch_Red" /></div>
									</div>
								</div> <!-- 報告書の一行分(複数可) -->
								<div class="report_a_line"><!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 -->
											<label id="Label40">入金日</label></div>
										<div><!-- 値 -->
										<!-- 	<parts:dlabel path="lblID_Date_Nyukin_Red" /></div> -->
											<pn:printWareki date='${md006_02Form.lblID_Date_Nyukin_Red}' pattern='GYMD'/></div>
									</div> <!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 -->
											<label id="Label44">立替金利息(円)</label></div>
										<div class="styleMoney"><!-- 値 -->
											<parts:dlabel formatType="number" formatPattern="integer"  path="lblID_M_TatekaeRisoku_Red"/></div>
									</div> <!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 -->
											<label id="Label46">立替金(円)</label></div>
										<div class="styleMoney"><!-- 値 -->
											<parts:dlabel formatType="number" formatPattern="integer" path="lblID_M_Tatekae_Red"  /></div>
									</div>
									<div class="item-output">
										<div><!-- 項目名 -->
											<label id="Label52">仮受金(一般口)からの充当額(円)</label></div>
										<div class="styleMoney"><!-- 値 -->
											<parts:dlabel path="lblID_M_KariukeIppanJuto_Red"  /></div>
									</div>
								</div> <!-- 報告書の一行分(複数可) -->
								<div class="report_a_line"><!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 -->
											<label id="Label48">立替金の種類</label></div>
										<div><!-- 値 -->
										<!--	<parts:dlabel path="lblID_Code_TatekaekinShurui_Red" /></div> -->
											<parts:codeName code='${md006_02Form.lblID_Code_TatekaekinShurui_Red}' categoryCode='00006'/></div>
									</div> <!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 -->
											<label id="Label50">公庫立替日</label></div>
										<div><!-- 値 -->
										<!-- 	<parts:dlabel path="lblID_Date_KoukoTatekae_Red" /></div> -->
										<pn:printWareki date='${md006_02Form.lblID_Date_KoukoTatekae_Red}' pattern='GYMD'/></div>
									</div> <!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 -->
											<label id="Label23">計(円)</label></div>
										<div class="styleMoney"><!-- 値 -->
											<parts:dlabel formatType="number" formatPattern="integer" path="lblID_M_Kei_Red"/></div>
									</div> <!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 -->
											<label id="Label54">送金額(円)</label></div>
										<div class="styleMoney"><!-- 値 -->
											<parts:dlabel formatType="number" formatPattern="integer" path="lblID_M_Sokin_Red"/></div>
									</div> <!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 -->
											<label id="Label56">受入後立替金残高(円)</label></div>
										<div class="styleMoney"><!-- 値 -->
											<parts:dlabel formatType="number" formatPattern="integer" path="lblID_M_TatekaeZanAfterUkeire_Red"/></div>
									</div>
								</div> <!-- 報告書の一行分(複数可) -->
								<div class="report_a_line"><!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 -->
											<label id="Label58">受託者勘定処理年月</label></div>
										<div><!-- 値 -->
										<!-- 	<parts:dlabel path="lblID_Date_Jtkshori_Red" /></div> -->
										<pn:printWareki date='${md006_02Form.lblID_Date_Jtkshori_Red}' pattern='GYM'/></div>
									</div> <!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 -->
											<label id="Label60">送金年月日</label></div>
										<div><!-- 値 -->
										<!-- 	<parts:dlabel path="lblID_Date_Sokin_Red" /></div> -->
										<pn:printWareki date='${md006_02Form.lblID_Date_Sokin_Red}' pattern='GYMD'/></div>
									</div> <!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 -->
											<label id="Label62">送金日番号</label></div>
										<div><!-- 値 -->
											<parts:dlabel path="lblID_ID_Sokinbi_Red" /></div>
									</div>
								</div>
							</div> <!-- 報告書一枚終わり -->
						</div>
						</parts:tr>
					</div>
					<div id="pnl_Mod">
					<parts:tr id="formBlackArea">
					<div class="page-break"><br/></div>
						<div class="report"><!-- 報告書の一行分(複数可) -->
							<div class="shusei">
								<parts:dlabel path="blackAreaTitle"/></div>
							<div align="center"><!-- 報告書の一行分(複数可) -->
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
										<!-- 	<parts:dlabel path="lblID_Year" /></div> -->
										<pn:printWareki date='${md006_02Form.lblID_Year}' pattern='GY'/></div>
									</div> <!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 -->
											<label id="Label7">方式資金</label></div>
										<div><!-- 値 -->
											<parts:dlabel path="lblID_Kubun_HoshikiShikin" /></div>
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
										<!-- 	<parts:dlabel path="lblID_Date_Nyukin" /></div> -->
										<pn:printWareki date='${md006_02Form.lblID_Date_Nyukin}' pattern='GYMD'/></div>
									</div> <!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 -->
											<label id="Label12">立替金利息(円)</label></div>
										<div class="styleMoney"><!-- 値 -->
											<parts:dlabel formatType="number" formatPattern="integer"  path="lblID_M_TatekaeRisoku"/></div>
									</div> <!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 -->
											<label id="Label13">立替金(円)</label></div>
										<div class="styleMoney"><!-- 値 -->
											<parts:dlabel formatType="number" formatPattern="integer" path="lblID_M_Tatekae"/></div>
									</div>
									<div class="item-output">
										<div><!-- 項目名 -->
											<label id="Label16">仮受金(一般口)からの充当額(円)</label></div>
										<div class="styleMoney"><!-- 値 -->
											<parts:dlabel path="lblID_M_KariukeIppanJuto"/></div>
									</div>
								</div> <!-- 報告書の一行分(複数可) -->
								<div class="report_a_line"><!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 -->
											<label id="Label14">立替金の種類</label></div>
										<div><!-- 値 -->
										<!-- 	<parts:dlabel path="lblID_Code_TatekaekinShurui" /></div> -->
										<parts:codeName code='${md006_02Form.lblID_Code_TatekaekinShurui}' categoryCode='00006'/></div>
									</div> <!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 -->
											<label id="Label15">公庫立替日</label></div>
										<div><!-- 値 -->
										<!-- 	<parts:dlabel path="lblID_Date_KoukoTatekae" /></div> -->
										<pn:printWareki date='${md006_02Form.lblID_Date_KoukoTatekae}' pattern='GYMD'/></div>
									</div> <!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 -->
											<label id="Label25">計(円)</label></div>
										<div class="styleMoney"><!-- 値 -->
											<parts:dlabel formatType="number" formatPattern="integer" path="lblID_M_Kei"/></div>
									</div> <!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 -->
											<label id="Label18">送金額(円)</label></div>
										<div class="styleMoney"><!-- 値 -->
											<parts:dlabel formatType="number" formatPattern="integer" path="lblID_M_Sokin"/></div>
									</div> <!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 -->
											<label id="Label19">受入後立替金残高(円)</label></div>
										<div class="styleMoney"><!-- 値 -->
											<parts:dlabel formatType="number" formatPattern="integer" path="lblID_M_TatekaeZanAfterUkeire" /></div>
									</div>
								</div> <!-- 報告書の一行分(複数可) -->
								<div class="report_a_line"><!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 -->
											<label id="Label20">受託者勘定処理年月</label></div>
										<div><!-- 値 -->
										<!-- 	<parts:dlabel path="lblID_Date_Jtkshori" /></div> -->
										<pn:printWareki date='${md006_02Form.lblID_Date_Jtkshori}' pattern='GYM'/></div>
									</div> <!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 -->
											<label id="Label21">送金年月日</label></div>
										<div><!-- 値 -->
										<!-- 	<parts:dlabel path="lblID_Date_Sokin" /></div> -->
										<pn:printWareki date='${md006_02Form.lblID_Date_Sokin}' pattern='GYMD'/></div>
									</div> <!-- 出力用 -->
									<div class="item-output">
										<div><!-- 項目名 -->
											<label id="Label22">送金日番号</label></div>
										<div><!-- 値 -->
											<parts:dlabel path="lblID_ID_Sokinbi" /></div>
									</div>
								</div>
							</div>
						</div> <!-- 報告書一枚終わり -->
						</parts:tr>
					</div>
				</div>
			</div>
		</div>
		</parts:form><%@ include file="/jsp/incFooter.jsp"%>
	</body>
</html>