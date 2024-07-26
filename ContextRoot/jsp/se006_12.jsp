<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/jsp/incTop.jsp" %>
<%@ taglib prefix="pn" uri="http://partnernet.jfc.go.jp/tags/pn"%>
<%--================================================================================================
 * Project Name : パートナーネット開発
 * System Name  : パートナーネット
 * File Name    : se006_12.jsp
 *
 * <<Modification History>>
 * Version | Date       | Updated By            | Content
 * --------+------------+-----------------------+---------------------------------------------------
 * 1.0.0   | 2015/07/01 | 西本　比呂            | 新規作成
================================================================================================--%>

<html>
	<%@ include file="/jsp/incHeader.jsp"%>
	<head>
		<title><parts:message code="title.screenName"/></title>
			<script lang="JavaScript">
			<!--
		    	<%-- 戻るボタン処理 --%>
			    function click_backBtn() {
			        executeAction('../../se006/se006_13/Se006_13Back.form');
			    }
				//-->
			 </script>
		<link href="<%= request.getContextPath() %>/css/se006.css" type="text/css" rel="stylesheet" />
	</head>
	<body>
		<parts:form modelAttribute="se006_12Form" action="./se006_12Init.form" id="form1" method="post" onsubmit="return false;">
			<%@ include file="/jsp/incCommonHidden.jsp" %>
			<%@ include file="/jsp/incHeaderArea.jsp" %>
			<div id="main_scroll_area">
			<div class="header">
				<div class="title">
					<label id="lblTitle" class="Title"><parts:message code="title.screenName"/></label><br />
				</div>
			</div>
			<div class="main">
				<div class="status">
					<span id="se006_ID12_Detail_UC_lblError" class="errorMessage">
						<parts:errors path="*"/>
					</span>
				</div>
				<p>
					<parts:button id="btnBack" value="戻る" onclick="click_backBtn()" />
				</p>
								<div class="status">
					<span class="errorMessage">
						<parts:dlabel path="lblMessage" />
					</span>
				</div>
				<parts:table id="se006_12Table" cssStyle="border-style:none;background-color:#ffffff;width: 100%;">
				<div>
<div id="report">
	<div class="report" style="margin-top:0px;"><!-- 報告書の一枚分 -->
		<div class="report_a_line"><!-- 報告書の一行分(複数可) -->
			<div class="item-output"><!-- 出力用 -->
				<div><!-- 項目名 -->
					<label id="Label1">報告書番号</label></div>
				<div><!-- 値 -->
					<parts:dlabel path="lblID_ID_Report" /></div>
			</div>
			<div class="item-output"><!-- 出力用 -->
				<div><!-- 項目名 -->
					<label id="Label2">報告年月日</label></div>
				<div><!-- 値 -->
                    <pn:printWareki date="${se006_12Form.getLblID_Date_Report()}" pattern="GYMD" />
				</div>
			</div>
			<div class="item-output"><!-- 出力用 -->
				<div><!-- 項目名 -->
					<label id="Label3">報告時分秒</label></div>
				<div><!-- 値 -->
					<parts:dlabel path="lblID_Time_Report" /></div>
			</div>
		</div> <!-- 報告書の一行分(複数可) -->
		<div class="report_a_line"><!-- 報告書の一行分(複数可) -->
			<div class="item-output">
				<div><!-- 項目名 -->
					<label id="Label4">顧客名</label></div>
				<div><!-- 値 -->
					<parts:dlabel path="lblID_Name_Customer" /></div>
			</div> <!-- 出力用 -->
			<div class="item-output-cust"><!-- 出力用 -->
				<div><!-- 項目名 -->
					<label id="Label5">扱店名：</label></div>
				<div><!-- 値 -->
					<parts:dlabel path="lblID_Name_Organization" /></div>
			</div>
		</div> <!-- 報告書の一行分(複数可) -->
		<div class="report_a_line"><!-- 報告書の一枚分 -->
			<div class="item-output"><!-- 出力用 -->
				<div><!-- 項目名 -->
					<label id="Label6">公庫支店</label></div>
				<div><!-- 値 -->
					<parts:dlabel path="lblID_Code_KoukoShiten" /></div>
			</div> <!-- 出力用 -->
			<div class="item-output">
				<div><!-- 項目名 -->
					<label id="Label7">扱店</label></div>
				<div><!-- 値 -->
					<parts:dlabel path="lblID_Code_Organization" /></div>
			</div> <!-- 出力用 -->
			<div class="item-output">
				<div><!-- 項目名 -->
					<label id="Label8">店舗</label></div>
				<div><!-- 値 -->
					<parts:dlabel path="lblID_Code_Tenpo" /></div>
			</div> <!-- 出力用 -->
			<div class="item-output">
				<div><!-- 項目名 -->
					<label id="Label9">年度</label></div>
				<div><!-- 値 -->
                   <pn:printWareki date="${se006_12Form.getLblID_Year()}" pattern="GY" />
                </div>
			</div> <!-- 出力用 -->
			<div class="item-output">
				<div><!-- 項目名 -->
					<label id="Label10">方式資金</label></div>
				<div><!-- 値 -->
					<parts:dlabel path="lblID_Code_HoshikiShikin" /></div>
			</div> <!-- 出力用 -->
			<div class="item-output">
				<div><!-- 項目名 -->
					<label id="Label11">番号</label></div>
				<div><!-- 値 -->
					<parts:dlabel path="lblID_ID_Ringi" /></div>
			</div> <!-- 出力用 -->
			<div class="item-output">
				<div><!-- 項目名 -->
					<label id="Label12">枝番</label></div>
				<div><!-- 値 -->
					<parts:dlabel path="lblID_ID_RingiBranch" /></div>
			</div>
		</div> <!-- 報告書の一行分(複数可) -->
		<div class="report_a_line"><!-- 報告書の一行分(複数可) -->
			<div class="item-output">
				<div><!-- 項目名 -->
					<label id="Label13">入金日</label></div>
				<div><!-- 値 -->
                    <pn:printWareki date="${se006_12Form.getLblID_Date_Nyukin()}" pattern="GYMD" />
				</div>
			</div> <!-- 出力用 -->
			<div class="item-output">
				<div><!-- 項目名 -->
					<label id="Label14">仮受金(一般口)受入額</label></div>
				<div class="styleMoney"><!-- 値 -->
					<parts:dlabel path="lblID_M_KariukeIppanUkeire" /></div>
			</div> <!-- 出力用 -->
		</div> <!-- 報告書の一行分(複数可) -->
		<div class="report_a_line"><!-- 報告書の一行分(複数可) -->
			<div class="item-output"><!-- 出力用 -->
				<div><!-- 項目名 -->
					<label id="Label15">受託者勘定処理年月</label></div>
				<div><!-- 値 -->
                    <pn:printWareki date="${se006_12Form.getID_Date_Jtkshori()}" pattern="GYM" />
				</div>
			</div> <!-- 出力用 -->
			<div class="item-output"><!-- 出力用 -->
				<div><!-- 項目名 -->
					<label id="Label16">送金年月日</label></div>
				<div><!-- 値 -->
                    <pn:printWareki date="${se006_12Form.getID_Date_Sokin()}" pattern="GYMD" />
				</div>
			</div> <!-- 出力用 -->
			<div class="item-output"><!-- 出力用 -->
				<div><!-- 項目名 -->
					<label id="Label17">送金日番号</label></div>
				<div><!-- 値 -->
					<parts:dlabel path="ID_ID_Sokinbi" /></div>
			</div> <!-- 出力用 -->
		</div> <!-- 報告書の一行分(複数可) -->
	</div> <!-- 報告書一枚終わり -->
</div>
				</div>
				</parts:table>
			</div>
		</div>
		</parts:form><%@ include file="/jsp/incFooter.jsp"%>

	</body>
</html>