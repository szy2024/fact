<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/jsp/incTop.jsp"%>
<%@ taglib prefix="pn" uri="http://partnernet.jfc.go.jp/tags/pn"%>

<%--================================================================================================
 * Project Name : パートナーネット開発
 * System Name  : パートナーネット
 * File Name    : se012_01.jsp
 *
 * <<Modification History>>
 * Version | Date       | Updated By            | Content
 * --------+------------+-----------------------+---------------------------------------------------
 * 1.0.0   | 2017/9/12  | 宮郷 慎之介           | 新規作成
================================================================================================--%>
<html>
<%@ include file="/jsp/incHeader.jsp"%>

<head>
<title><parts:message code="title.screenName" /></title>
<link href="<%=request.getContextPath()%>/css/se012.css" type="text/css"
	rel="stylesheet" />
<script lang="JavaScript">
<!--

	<%-- 検索ボタン押下処理 --%>
	function click_searchBtn() {
		executeAction('../../se012/se012_01/Se012_01Search.form');
	}
	<%-- 業務委託手数料通知へのアンカークリック処理 --%>
	function click_ancrTaisho(selectedindex) {
		document.forms[0].elements["selectedindex"].value = selectedindex;
		executeAction('../../se012/se012_01/Se012_01Anctaisho.form');
	}
	<%-- ページング処理 --%>
	function click_pageNo() {
		executeAction('../../se012/se012_01/Se012_01Pageing.form');
	}

	function click_prePage() {
		executeAction('../../se012/se012_01/Se012_01Pageing.form');
	}

	function click_nextPage() {
		executeAction('../../se012/se012_01/Se012_01Pageing.form');
	}

	<%-- 非表示設定 --%>
	function initSetVisible() {

		<%-- 店舗コード --%>
		var ele = document.getElementById("txtid_srccode_tenpo");

		if(ele != null) {
			document.getElementById("srccode_tenpo").style.visibility = ele.style.visibility;
		}
		else {
			document.getElementById("srccode_tenpo").style.visibility = "hidden";
		}

		<%-- 未加盟店検索 --%>
		var ele = document.getElementById("chkid_searchmikameiten");

		if(ele != null) {
			document.getElementById("src_mikameiten").style.visibility = ele.style.visibility;
		}
		else {
			document.getElementById("src_mikameiten").style.visibility = "hidden";
		}

		<%-- 店舗列 --%>
		var ele = document.getElementById("flgunneededtenpo");

		if(ele.value == "1") {
			dispNone("hiddenHCol1");
			dispNone("hiddenHCol2");
			dispNone("hiddenDCol1");
			dispNone("hiddenDCol2");
		}
	}

	function dispNone(id){
		ele = document.getElementById(id)
		if ( ele != null ) {
			ele.style.display = "none";
		}
	}

//-->
</script>
</head>

<body onload = "initSetVisible();">
	<parts:form modelAttribute="se012_01Form" action="./Se012_01Init.form"
		id="form1" method="post" onsubmit="return false;">
		<%@ include file="/jsp/incCommonHidden.jsp"%>
		<%@ include file="/jsp/incHeaderArea.jsp"%>
		<div id="main_scroll_area" style="height: 600px">
			<parts:hidden path="selectedindex" />
			<parts:hidden path="flgunneededtenpo" />
			<div class="header">
				<div class="title">
					<label id="lblTitle"><parts:message code="title.screenName" /></label>
				</div>
			</div>

			<div class="main">

				<%-- エラーメッセージ --%>
				<div class="status">
					<span id="lblError" class="errorMessage">
						<parts:errors path="*"/><span id="lblError"></span>
					</span>
				</div>

				<parts:table border="0" cssStyle="margin-bottom: 20px;">
					<col width="60px" />
					<col width="80px" />
					<col width="60px" />
					<col width="80px" />
					<col width="80px" />
					<col width="60px" />
					<parts:tr>
						<td colspan="6"><parts:message code="lbl_PromptingInput" /></td>
					</parts:tr>

					<parts:tr>
						<%-- 検索条件扱店コード --%>
						<td class="serachController" colspan="2" id="srccode_organization">
							<label class="se012_01Label"><parts:message code="lbl_txtid_srccode_organization" /></label>
							<!-- 計数管理担当者・管理者以外 -->
							<logic:notEqual path="commonInfo.RoleCode" value="20">
								<logic:notEqual path="commonInfo.RoleCode" value="40">
									<parts:text path="txtid_srccode_organization" size="8" maxlength="4" tabindex="-1" />
								</logic:notEqual>
							</logic:notEqual>
							<!-- 計数管理担当者 -->
							<logic:equal path="commonInfo.RoleCode" value="20">
								<parts:text path="txtid_srccode_organization" size="8" maxlength="4" />
							</logic:equal>
							<!-- 管理者 -->
							<logic:equal path="commonInfo.RoleCode" value="40">
								<parts:text path="txtid_srccode_organization" size="8" maxlength="4" />
							</logic:equal>
						</td>

						<%-- 検索条件店舗コード --%>
						<td class="serachController"  colspan="2" id="srccode_tenpo">
							<label class="se012_01Label"><parts:message code="lbl_txtid_srccode_tenpo" /></label>
							<parts:text path="txtid_srccode_tenpo" size="6" maxlength="3" />
						</td>

						<%-- 未加盟店検索 --%>
						<td class="serachController"  colspan="2" id="src_mikameiten">
							<label class="se012_01Label_2"><parts:message code="lbl_chkid_searchmikameiten" /></label>
							<parts:checkbox path="chkid_searchmikameiten" value="1"/>
						</td>
					</parts:tr>
					<parts:tr>
						<td class="td_padding" />
					</parts:tr>

					<%-- 検索開始年月 --%>
					<parts:tr>
						<td colspan="6">
						<parts:message code="lbl_drpid_searchstartym_year" />
							<parts:select path="drpid_searchstartym_year"
								style="width:50px;margin:0px 4px"
								items="${se012_01Form.ym_searchstart_year_pulldown_list}"></parts:select>
							<parts:message code="lbl_for_year" />
							<parts:select path="drpid_searchstartym_month"
								style="width:50px;margin:0px 4px"
								items="${se012_01Form.ym_searchstart_month_pulldown_list}"></parts:select>
							<parts:message code="lbl_for_month" /></td>
					</parts:tr>
					<parts:tr>
						<td class="td_padding" />
					</parts:tr>

					<%-- 検索終了年月 --%>
					<parts:tr>
						<td colspan="6"><parts:message
								code="lbl_drpid_searchendym_year" />
							<parts:select path="drpid_searchendym_year"
								style="width:50px;margin:0px 4px"
								items="${se012_01Form.ym_searchend_year_pulldown_list}"></parts:select>
							<parts:message code="lbl_for_year" /> <parts:select
								path="drpid_searchendym_month" style="width:50px;margin:0px 4px"
								items="${se012_01Form.ym_searchend_month_pulldown_list}"></parts:select>
							<parts:message code="lbl_for_month" /></td>
					</parts:tr>

					<%-- 検索ボタン --%>
					<parts:tr>
						<td><parts:button id="btnSearch" onclick="click_searchBtn();">
								<parts:message code="btnsearch" />
							</parts:button></td>
					</parts:tr>
				</parts:table>

				<parts:tr id="se012_01M1Table">
					<%-- 検索結果 ヘッダー --%>
					<paging:table path="se012_01M1Table"
						pageNoClick="click_pageNo();return false;"
						prePageClick="click_prePage();return false;"
						nextPageClick="click_nextPage();return false;" maxPageAnchor="5"
						basePosition="3"
						width="550px">

						<div class="header_wrap">
							<parts:table id="headerTbl" width="510px" border="0" cellspacing="0" cellpadding="0" cssStyle="table-layout:fixed;">
								<paging:head sort="false">
									<col width="50px" />
									<col width="100px" />
									<col id="hiddenHCol1" width="50px" />
									<col id="hiddenHCol2" width="100px" />
									<col width="100px" />
									<col width="100px" />
									<tr align="center">
										<td><parts:message code="lbl_organization" /><br/><parts:message code="lbl_code" /></td>
										<td><parts:message code="lblid_name_organization" /></td>
										<td><parts:message code="lbl_tenpo" /><br/><parts:message code="lbl_code" /></td>
										<td><parts:message code="lblid_name_tenpo" /></td>
										<td><parts:message code="lblid_date_jyohoteikyo" /></td>
										<td><parts:message code="ancid_date_taisho" /></td>
									</tr>
								</paging:head>
							</parts:table>
						</div>

						<%-- 検索結果 --%>
						<div class="wrap" style="height: 240px; width: 550px; margin: 0px;">
							<parts:table id="tbody1"  width="510px" border="0" cellpadding="0" cellspacing="0" cssStyle="table-layout:fixed; margin:0px;">
								<col width="50px" />
								<col width="100px" />
								<col id="hiddenDCol1" width="50px" />
								<col id="hiddenDCol2" width="100px" />
								<col width="100px" />
								<col width="100px" />

								<paging:record  evenNumberCssClass="rEven" oddNumberCssClass="rOdd">
									<tr class="${rStyle}" align="center">
										<td><parts:dlabel path="lblid_code_organization"/></td>
										<td><parts:dlabel path="lblid_name_organization"/></td>
										<td><parts:dlabel path="lblid_code_tenpo"/></td>
										<td><parts:dlabel path="lblid_name_tenpo"/></td>
										<td><parts:dlabel path="lblid_date_jyohoteikyo"/></td>
										<td>
											<parts:link href="JavaScript:void(0);" onclick="click_ancrTaisho(${index});">
												<parts:dlabel path="ancid_date_taisho"/>
											</parts:link>
										</td>
									</tr>
								</paging:record>
							</parts:table>
						</div>
					</paging:table>
				</parts:tr>
			</div>
		</div>
	</parts:form><%@ include file="/jsp/incFooter.jsp"%>
</body>
</html>