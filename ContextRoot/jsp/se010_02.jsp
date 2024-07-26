
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/jsp/incTop.jsp"%>

<%--================================================================================================
 * Project Name : パートナーネット開発
 * System Name  : パートナーネット
 * File Name    : se010_02.jsp
 *
 * <<Modification History>>
 * Version | Date       | Updated By            | Content
 * --------+------------+-----------------------+---------------------------------------------------
 * 1.0.0   | 2015/07/01 | 堀　大輔              | 新規作成
================================================================================================--%>

<html>
<%@ include file="/jsp/incHeader.jsp"%>
<head>
<title><parts:message code="title.screenName"/></title>
<link href="<%=request.getContextPath()%>/css/se010.css" type="text/css" rel="stylesheet" />
<script lang="JavaScript">
<!--
    <%-- 戻るボタン押下時の処理	--%>
    function click_backBtn() {
        executeAction('../se010_02/Se010_02Back.form');
    }
//-->
</script>
</head>
<body>
<parts:form modelAttribute="se010_02Form" method="post">
<%@ include file="/jsp/incCommonHidden.jsp" %>
<%@ include file="/jsp/incHeaderArea.jsp" %>
<div id="main_scroll_area">
	<div class="header">
		<div class="title">
			<label id="lblTitle" class="Title"><parts:message code="title.screenName"/></label>
		</div>
	</div>
	<div class="main">
		<%--
		<div class="status">
			<span id="se010_ID02_Results_UC_lblError" class="errorMessage" style="color:red;margin-top:12px;margin-bottom:12px;font-weight:bold;">
				<parts:dlabel path="lblError" /><br />
			</span>
		</div>
		--%>

		<p>
			<label id="Label1" class="subTitle">結果</label>
		</p>
		<span>
			<parts:table id="tblResult">
				<tr>
					<td><parts:message code="yushiNo"/></td>
					<td><span><parts:dlabel path="yushiNo" /></span></td>
				</tr>
				<tr>
					<td><parts:message code="dateKuriageShokan"/></td>
					<td><span><parts:dlabel path="dateKuriageShokan" formatType="date" formatPattern="warekiJpZeroSuppress" /></span></td>
				</tr>
				<tr>
					<td><parts:message code="kuriageShokan"/></td>
					<td><span><parts:dlabel path="kuriageShokan" formatType="number" formatPattern="integer" /></span>円</td>
				</tr>
				<tr>
					<td><parts:message code="dateKurishoTaishokijitsu"/></td>
					<td><span><parts:dlabel path="dateKurishoTaishokijitsu" formatType="date" formatPattern="warekiJpZeroSuppress" /></span></td>
				</tr>
				<tr>
					<td><parts:message code="kurishojiRiritsu"/></td>
					<td><span><parts:dlabel path="kurishojiRiritsu" /></span>％</td>
				</tr>
				<tr>
					<td><parts:message code="kurishoJiyu"/></td>
					<td><span><parts:dlabel path="kurishoJiyu" /></span></td>
				</tr>
				<tr>
					<td colspan="2">◆元金均等償還の場合(期間固定)</td>
				</tr>
				<tr>
					<td><parts:message code="gankinkinto"/></td>
					<td><span><parts:dlabel path="gankinkinto" formatType="number" formatPattern="integer" /></span>円</td>
				</tr>
				<tr>
					<td><parts:message code="gankinfukinto"/></td>
					<td><span><parts:dlabel path="gankinfukinto" formatType="number" formatPattern="integer" /></span>円</td>
				</tr>
				<tr>
					<td><parts:message code="codeChosei"/></td>
					<td><span><parts:message code="codeChosei.${se010_02Form.codeChosei}"/></span></td>
				</tr>
				<tr>
					<td colspan="2">◆一部免除ありの場合</td>
				</tr>
				<tr>
					<td><parts:message code="menjoTaisho"/></td>
					<td><span><parts:dlabel path="menjoTaisho" formatType="number" formatPattern="integer" /></span>円</td>
				</tr>
				<tr>
					<td colspan="2">◆元金均等償還の場合(期間固定)</td>
				</tr>
				<tr>
					<td><parts:message code="menjogoGankinkinto"/></td>
					<td><span><parts:dlabel path="menjogoGankinkinto" formatType="number" formatPattern="integer" /></span>円</td>
				</tr>
				<tr>
					<td><parts:message code="menjogoGankinfukinto"/></td>
					<td><span><parts:dlabel path="menjogoGankinfukinto" formatType="number" formatPattern="integer" /></span>円</td>
				</tr>
				<tr>
					<td><parts:message code="codeChoseiMenjogo"/></td>
					<td><span><parts:message code="codeChosei.${se010_02Form.codeChoseiMenjogo}"/></span></td>
				</tr>
				<tr>
					<td class="risoku"><parts:message code="kurishoRisoku"/></td>
					<td class="risoku"><span><parts:dlabel path="kurishoRisoku" formatType="number" formatPattern="integer" /></span>円</td>
				</tr>
				<tr>
					<td class="risoku"><parts:message code="kurishoTesuryo"/></td>
					<td class="risoku"><span><parts:dlabel path="kurishoTesuryo" formatType="number" formatPattern="integer" /></span>円</td>
				</tr>
			</parts:table>
		</span>
		<span>
			<parts:button id="btnBack" value="戻る" onclick="click_backBtn();"/>
		</span>
	</div>
</div>
</parts:form><%@ include file="/jsp/incFooter.jsp"%>
</body>
</html>