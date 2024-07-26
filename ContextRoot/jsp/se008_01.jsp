<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%--================================================================================================
 * Project Name : パートナーネット開発
 * System Name  : パートナーネット
 * File Name    : se008_01.jsp
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



		<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/se008.css" />
		<script lang="JavaScript">
		<!--
		<%-- 検索ボタン押下時の処理 --%>
		    function click_searchBtn() {
		        executeAction('../../se008/se008_01/Se008_01Search.form');
		    }
		//-->
		</script>
	</head>
	<body>
		<parts:form modelAttribute="se008_01Form" action="./Se008_01Init.form" id="form1" method="post" onsubmit="return false;">
			<%@ include file="/jsp/incCommonHidden.jsp" %>
			<%@ include file="/jsp/incHeaderArea.jsp" %>
			<div id="main_scroll_area">
			<div class="header">
				<div class="title">
					<label id="lblTitle" class="Title"><parts:message code="title.screenName"/></label>
				</div>
			</div>
			<div class="main">
				<div class="greeting">
					回収予定債権を検索するために、回収予定日付を入力のうえ検索ボタンを押してください。<br />
					入力可能な日付は本日より翌月末日までです。
				</div>
                <div class="status" style="color:red;margin-top:12px;margin-bottom:12px;font-weight:bold;">
                    <parts:errors path="*" cssClass="Error" />
                </div>
				<span>
					<p>検索開始年月日：
						<parts:select id="searchStartYear" path="searchStartYear">
							<parts:options items="${se008_01Form.searchStartYear_PulldownList}" />
						</parts:select>年
						<parts:select id="searchStartMonth" path="searchStartMonth">
							<parts:options items="${se008_01Form.searchStartMonth_PulldownList}" />
						</parts:select>月
						<parts:select path="searchStartDate" id="searchStartDate">
							<parts:option value="01">01</parts:option>
							<parts:option value="02">02</parts:option>
							<parts:option value="03">03</parts:option>
							<parts:option value="04">04</parts:option>
							<parts:option value="05">05</parts:option>
							<parts:option value="06">06</parts:option>
							<parts:option value="07">07</parts:option>
							<parts:option value="08">08</parts:option>
							<parts:option value="09">09</parts:option>
							<parts:option value="10">10</parts:option>
							<parts:option value="11">11</parts:option>
							<parts:option value="12">12</parts:option>
							<parts:option value="13">13</parts:option>
							<parts:option value="14">14</parts:option>
							<parts:option value="15">15</parts:option>
							<parts:option value="16">16</parts:option>
							<parts:option value="17">17</parts:option>
							<parts:option value="18">18</parts:option>
							<parts:option value="19">19</parts:option>
							<parts:option value="20">20</parts:option>
							<parts:option value="21">21</parts:option>
							<parts:option value="22">22</parts:option>
							<parts:option value="23">23</parts:option>
							<parts:option value="24">24</parts:option>
							<parts:option value="25">25</parts:option>
							<parts:option value="26">26</parts:option>
							<parts:option value="27">27</parts:option>
							<parts:option value="28">28</parts:option>
							<parts:option value="29">29</parts:option>
							<parts:option value="30">30</parts:option>
							<parts:option value="31">31</parts:option>
						</parts:select>日
					</p>
					<p>検索終了年月日：
						<parts:select id="searchEndYear" path="searchEndYear">
							<parts:options items="${se008_01Form.searchEndYear_PulldownList}" />
						</parts:select>年
						<parts:select id="searchEndMonth" path="searchEndMonth">
							<parts:options items="${se008_01Form.searchEndMonth_PulldownList}" />
						</parts:select>月
						<parts:select path="searchEndDate" id="searchEndDate">
							<parts:option value="01">01</parts:option>
							<parts:option value="02">02</parts:option>
							<parts:option value="03">03</parts:option>
							<parts:option value="04">04</parts:option>
							<parts:option value="05">05</parts:option>
							<parts:option value="06">06</parts:option>
							<parts:option value="07">07</parts:option>
							<parts:option value="08">08</parts:option>
							<parts:option value="09">09</parts:option>
							<parts:option value="10">10</parts:option>
							<parts:option value="11">11</parts:option>
							<parts:option value="12">12</parts:option>
							<parts:option value="13">13</parts:option>
							<parts:option value="14">14</parts:option>
							<parts:option value="15">15</parts:option>
							<parts:option value="16">16</parts:option>
							<parts:option value="17">17</parts:option>
							<parts:option value="18">18</parts:option>
							<parts:option value="19">19</parts:option>
							<parts:option value="20">20</parts:option>
							<parts:option value="21">21</parts:option>
							<parts:option value="22">22</parts:option>
							<parts:option value="23">23</parts:option>
							<parts:option value="24">24</parts:option>
							<parts:option value="25">25</parts:option>
							<parts:option value="26">26</parts:option>
							<parts:option value="27">27</parts:option>
							<parts:option value="28">28</parts:option>
							<parts:option value="29">29</parts:option>
							<parts:option value="30">30</parts:option>
							<parts:option value="31">31</parts:option>
						</parts:select>日
					</p>
				</span>
				<span>
					<parts:button id="ID_Send" value="検索" onclick="click_searchBtn();"></parts:button>
				</span>
			</div>
		</div>
		</parts:form><%@ include file="/jsp/incFooter.jsp"%>
	</body>
</html>