<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/jsp/incTop.jsp" %>
<%@ taglib prefix="pn" uri="http://partnernet.jfc.go.jp/tags/pn"%>

<%--================================================================================================
 * Project Name : パートナーネット開発
 * System Name  : パートナーネット
 * File Name    : se002_01.jsp
 *
 * <<Modification History>>
 * Version | Date       | Updated By            | Content
 * --------+------------+-----------------------+---------------------------------------------------
 * 1.0.0   | 2015/07/01 | 澤田　健一            | 新規作成
================================================================================================--%>

<html>
	<%@ include file="/jsp/incHeader.jsp"%>
	<head>
		<title><parts:message code="title.screenName"/></title>
		<link href="<%=request.getContextPath()%>/css/se002.css" type="text/css" rel="stylesheet" />
	</head>
	<body>
		<parts:form modelAttribute="se002_01Form" action="./Se002_01Init.form" id="form1" method="post"  onsubmit="return false;">
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
					<span id="se002_ID01_Results_UC_lblError" class="errorMessage">
						<parts:errors path="*" cssClass="Error" />
					</span>
				</div>

			<div class="lblSubTitle">実行未了</div>
<div id="tbl1">
	<paging:table path="se002_01M1Table" pagingDisplay="false">
		<div>
			<parts:table border="1" id="se002_01M1Table" cssStyle="line-height:1.0em;">
				<paging:head sort="false" sortClick="">
					<tr class="dtgHeader" style="white-space:nowrap;">
						<td style="width:200px;white-space:nowrap;">
							顧客名
						</td>
						<td style="width:70px;white-space:nowrap;">
							公庫<br />支店
						</td>
						<td style="white-space:nowrap;">
							扱店
						</td>
						<td style="white-space:nowrap;">
							店舗
						</td>
						<td style="white-space:nowrap;">
							年度
						</td>
						<td style="white-space:nowrap;">
							方式<br />資金
						</td>
						<td style="white-space:nowrap;display:none;">
							資金
						</td>
						<td style="white-space:nowrap;">
							番号
						</td>
						<td style="white-space:nowrap;">
							枝番
						</td>
						<td style="white-space:nowrap;">
							貸付<br />決定日
						</td>
						<td style="white-space:nowrap;">
							貸付決定額
						</td>
						<td style="white-space:nowrap;">
							貸付実行<br />予定日
						</td>
						<td style="white-space:nowrap;display:none;">
							貸付実行額
						</td>
						<td style="white-space:nowrap;display:none;">
							資金払出未了額
						</td>
						<td style="white-space:nowrap;">
							貸付実行<br />期限
						</td>
						<td style="white-space:nowrap;display:none;">
							資金払出期限
						</td>
						<%-- td style="white-space:nowrap;display:none;">
							<parts:dlabel path="ArrayListIndex">Index</parts:dlabel>
						</td--%>
					</tr>
				</paging:head>
				<paging:record>
					<tr style="white-space:nowrap;">
						<td style="width:200px;">
							<parts:dlabel path="ID_Name_Customer" />
						</td>
						<td style="width:70px;">
							<parts:dlabel path="ID_Name_KoukoShiten" />
						</td>
						<td>
							<parts:dlabel path="ID_Code_Organization" />
						</td>
						<td>
							<parts:dlabel path="ID_Code_Tenpo" />
						</td>
						<td>
							<pn:printWareki date="${record.ID_Year}" pattern="GY"/>
						</td>
						<td>
							<parts:dlabel path="ID_Kubun_Hoshiki" />
						</td>
						<td style="display:none;">
							<parts:dlabel path="ID_Kubun_Shikin" />
						</td>
						<td>
							<parts:dlabel path="ID_ID_Ringi" />
						</td>
						<td>
							<parts:dlabel path="ID_ID_RingiBranch" />
						</td>
						<td>
							<pn:printWareki date="${record.ID_Date_JuriKetteikisan}" pattern="GYMD"/>
						</td>
						<td class="mKettei">
							<parts:dlabel path="ID_M_Kettei" />
						</td>
						<td>
							<pn:printWareki date="${record.ID_Shinko_Kanri_Date_Jikko}" pattern="GYMD"/>
						</td>
						<td class="mKashitsuke" style="display:none;">
							<parts:dlabel path="ID_M_Kashitsuke" />
						</td>
						<td class="mKashitsukeukeireZan" style="display:none;">
							<parts:dlabel path="ID_M_KashitsukeukeireZan" />
						</td>
						<td>
							<pn:printWareki date="${record.ID_Date_JikkoKigen}" pattern="GYMD"/>
						</td>
						<td style="display:none;">
							<parts:dlabel path="ID_Date_HaraidashiKigen" />
						</td>
						<%--td style="display:none;">
							<parts:dlabel path="ArrayListIndex" />
						</td--%>
					</tr>
				</paging:record>
			</parts:table>
		</div>
	</paging:table>
</div>
<div style="font-size: 1em;font-weight: bold;padding: 5px 5px 0px 20px;color: #FF0000;">
	<parts:dlabel path="lblNoDataJikko" />
</div>
<br />
<div class="lblSubTitle">払出未了</div>
<div id="tbl2">
	<paging:table path="se002_01M2Table" pagingDisplay="false">
		<div>
			<parts:table id="se002_01M2Table" border="1" cssStyle="line-height:1.0em;">
				<paging:head sort="false" sortClick="">
					<tr class="dtgHeader" style="white-space:nowrap;">
						<td style="width:200px;white-space:nowrap;">
							顧客名
						</td>
						<td style="width:70px;white-space:nowrap;">
							公庫<br />支店
						</td>
						<td>
							扱店
						</td>
						<td>
							店舗
						</td>
						<td>
							年度
						</td>
						<td>
							方式<br />資金
						</td>
						<td style="display:none;">
							資金
						</td>
						<td>
							番号
						</td>
						<td>
							枝番
						</td>
						<td style="display:none;">
							貸付決定日
						</td>
						<td style="display:none;">
							貸付決定額
						</td>
						<td>
							貸付<br />実行日
						</td>
						<td>
							貸付実行額
						</td>
						<td>
							資金払出<br />未了額
						</td>
						<td style="display:none;">
							貸付実行期限
						</td>
						<td>
							資金払出<br />期限
						</td>
						<%--td style="display:none;">
							<parts:dlabel path="ArrayListIndex">Index</parts:dlabel>
						</td--%>
					</tr>
				</paging:head>
				<paging:record>
					<tr style="white-space:nowrap;">
						<td style="white-space:nowrap;width:200px;">
							<parts:dlabel path="ID_Name_Customer" />
						</td>
						<td style="white-space:nowrap;width:70px;">
							<parts:dlabel path="ID_Name_KoukoShiten" />
						</td>
						<td style="white-space:nowrap;">
							<parts:dlabel path="ID_Code_Organization" />
						</td>
						<td style="white-space:nowrap;">
							<parts:dlabel path="ID_Code_Tenpo" />
						</td>
						<td style="white-space:nowrap;">
							<pn:printWareki date="${record.ID_Year}" pattern="GY"/>
						</td>
						<td style="white-space:nowrap;">
							<parts:dlabel path="ID_Kubun_Hoshiki" />
						</td>
						<td style="white-space:nowrap;display:none;">
							<parts:dlabel path="ID_Kubun_Shikin" />
						</td>
						<td style="white-space:nowrap;">
							<parts:dlabel path="ID_ID_Ringi" />
						</td>
						<td style="white-space:nowrap;">
							<parts:dlabel path="ID_ID_RingiBranch" />
						</td>
						<td class="mKettei" style="white-space:nowrap;display:none;">
							<parts:dlabel path="ID_M_Kettei" />
						</td>
						<td style="white-space:nowrap;">
							<pn:printWareki date="${record.ID_Date_Jikko}" pattern="GYMD"/>
						</td>
						<td class="mKashitsuke" style="white-space:nowrap;">
							<parts:dlabel path="ID_M_Kashitsuke" />
						</td>
						<td class="mKashitsukeukeireZan" style="white-space:nowrap;">
							<parts:dlabel path="ID_M_KashitsukeukeireZan" />
						</td>
						<td style="white-space:nowrap;display:none;">
							<parts:dlabel path="ID_Date_JikkoKigen" />
						</td>
						<td style="white-space:nowrap;">
							<pn:printWareki date="${record.ID_Shinko_Kanri_Date_Jikko}" pattern="GYMD"/>
						</td>
						<%--td style="display:none;">
							<parts:dlabel path="ArrayListIndex" />
						</td--%>
					</tr>
				</paging:record>
			</parts:table>
		</div>
	</paging:table>
	<div style="font-size: 1em;font-weight: bold;padding: 5px 5px 0px 20px;color: #FF0000;"><parts:dlabel path="lblNoDataHaraidashi"  /></div>
</div>
			<br />
		</div>
		</div>
		</parts:form><%@ include file="/jsp/incFooter.jsp"%>

	</body>
</html>