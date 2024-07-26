
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/jsp/incTop.jsp"%>

<%--================================================================================================
 * Project Name : パートナーネット開発
 * System Name  : パートナーネット
 * File Name    : cr008_05.jsp
 *
 * <<Modification History>>
 * Version | Date       | Updated By            | Content
 * --------+------------+-----------------------+---------------------------------------------------
 * 1.0.0   | 2015/10/01 | 石川　真理            | 新規作成
================================================================================================--%>

<html>
	<%@ include file="/jsp/incHeader.jsp"%>
	<head>
		<title><parts:message code="title.screenName"/></title>
		<link href="<%=request.getContextPath()%>/css/cr008.css" type="text/css" rel="stylesheet" />
		<script lang="JavaScript">
		<!--
		<%-- 登録ボタン押下時の処理	--%>
	    function click_updateBtn() {
	        executeAction('../../cr008/cr008_05/Cr008_05Create.form');
	    }
		<%-- 戻るボタン押下時の処理	--%>
	    function click_backBtn() {
	        executeAction('../../cr008/cr008_05/Cr008_05Back.form');
	    }
		//-->
		</script>
	</head>
	<body>
		<parts:form modelAttribute="cr008_05Form" id="Form1" method="post">
			<%@ include file="/jsp/incCommonHidden.jsp" %>
			<%@ include file="/jsp/incHeaderArea.jsp" %>
			<div id="main_scroll_area">
			<div class="header">
				<div class="title">
					<label id="lblTitle" class="Title"><parts:message code="title.screenName"/></label><br />
				</div>
			</div>
			<div class="main">
				<div class="greeting">
					以下の報告書の登録を行います。内容をご確認のうえ「登録」ボタンを押してください。
				</div>
				<div class="greeting">
					仮受金（一般口）受入報告書の作成の入力画面へ戻る場合には「戻る」ボタンを押してください。
				</div>
				<div class="buttons">
					<parts:button id="btnUpdate" value="登録" onclick="click_updateBtn();"/>
					<parts:button id="btnBack" value="戻る" title="戻る" onclick="click_backBtn();" />
				</div>
				<div class="reportDate">報告年月日：
					<parts:dlabel path="lblID_Date_Report" />
				</div>
				<div class="status">
					<div style="color:red;font-weight:bold;">
<%-- 						<parts:dlabel path="lblErr" /></div>
				</div>
				<div class="status">
					<div style="color:red;font-weight:bold;">
						<parts:dlabel path="lblMessage" /></div> --%>
						<parts:errors path="*" />
					</div>
				</div>
				<div id="report">
					<div class="report"><!-- 報告書の一枚分 -->
						<div align="center">
							<div class="report_a_line"><!-- 報告書の一行分(複数可) -->
								<div class="item-output"><!-- 出力用 -->
									<div><!-- 項目名 -->
										<label id="Label2">顧客名</label></div>
									<div><!-- 値 -->
										<parts:dlabel path="lblID_Name_Customer" /></div>
								</div>
								<div class="item-output"><!-- 出力用 -->
									<div><!-- 項目名 -->
										<label id="Label1">扱店名：</label></div>
									<div align="left"><!-- 値 -->
										<parts:dlabel path="lblID_Name_Organization" /></div>
								</div>
							</div> <!-- 報告書の一行分(複数可) -->
							<div class="report_a_line"><!-- 報告書の一枚分 -->
								<div class="item-output"><!-- 出力用 -->
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
										<parts:dlabel path="lblID_Year" /></div>
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
							<div class="report_a_line"><!-- 報告書の一行分(複数可) --> <!-- 出力用 -->
								<div class="item-output">
									<div><!-- 項目名 -->
										<label id="Label10">入金日</label></div>
									<div><!-- 値 -->
										<parts:dlabel path="lblID_Date_Nyukin" /></div>
								</div> <!-- 出力用 -->
								<div class="item-output">
									<div><!-- 項目名 -->
										<label id="Label11">仮受金(一般口)受入額</label></div>
									<div class="styleMoney"><!-- 値 -->
										<parts:dlabel path="lblID_M_KariukeIppanUkeire" formatType="number" formatPattern="integer"/></div>
								</div> <!-- 出力用 -->
							</div> <!-- 報告書の一行分(複数可) -->
							<div class="report_a_line"><!-- 報告書の一行分(複数可) -->
								<div class="item-output"><!-- 出力用 -->
									<div><!-- 項目名 -->
										<label id="Label12">受託者勘定処理年月</label></div>
									<div><!-- 値 -->
										<parts:dlabel path="lblID_Date_Jtkshori" /></div>
								</div> <!-- 出力用 -->
								<div class="item-output"><!-- 出力用 -->
									<div><!-- 項目名 -->
										<label id="Label13">送金年月日</label></div>
									<div><!-- 値 -->
										<parts:dlabel path="lblID_Date_Sokin" /></div>
								</div> <!-- 出力用 -->
								<div class="item-output"><!-- 出力用 -->
									<div><!-- 項目名 -->
										<label id="Label14">送金日番号</label></div>
									<div><!-- 値 -->
										<parts:dlabel path="lblID_Code_Sokin" /></div>
								</div> <!-- 出力用 -->
							</div> <!-- 報告書の一行分(複数可) -->
						</div>
					</div> <!-- 報告書一枚終わり -->
				</div>
				<br />
				<%-- <parts:textarea path="sign_data" id="sign_data" style="visibility: hidden;" /> --%>
			</div>
		</div>
		</parts:form><%@ include file="/jsp/incFooter.jsp"%>
	</body>
</html>