<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/jsp/incTop.jsp" %>
<%@ taglib prefix="pn" uri="http://partnernet.jfc.go.jp/tags/pn"%>

<%--================================================================================================
 * Project Name : パートナーネット開発
 * System Name  : パートナーネット
 * File Name    : se011_01.jsp
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
		<script lang="JavaScript">
<!--
			<%-- 共通ページング処理 --%>
				function click_pageNo() {
				    executeAction('../../se011/se011_01/Se011_01Pageing.form');
				}

				function click_prePage() {
				    executeAction('../../se011/se011_01/Se011_01Pageing.form');
				}

				function click_nextPage() {
				    executeAction('../../se011/se011_01/Se011_01Pageing.form');
}
//-->
		</script>



		<link href="<%=request.getContextPath()%>/css/se011.css" type="text/css" rel="stylesheet" />
	</head>
	<body>
		<parts:form modelAttribute="se011_01Form" action="./Se011_01Init.form" id="form1" method="post"  onsubmit="return false;">
			<%@ include file="/jsp/incCommonHidden.jsp" %>
			<%@ include file="/jsp/incHeaderArea.jsp" %>
			<div id="main_scroll_area">
			<div class="header">
				<div class="title">
					<label id="lblTitle"><parts:message code="title.screenName"/></label>
				</div>
			</div>
			<div class="main">
			    <div style="color:red;margin-top:10px;margin-bottom:10px;">
					<parts:errors path="*" cssClass="Error" />
			    </div><br />
					<table width="95%">
						<tr>
							<td align="left">
								<paging:table path="se011_01M1Table" pageNoClick="click_pageNo();return false;" prePageClick="click_prePage();return false;" nextPageClick="click_nextPage();return false;" maxPageAnchor="11" basePosition="6">
									<div>
										<parts:table border="1" cellpadding="2" id="se011_01M1Table" cssStyle="line-height:1.0em;width:95%;">
											<paging:head sort="false">
												<tr class="dtgHeader" style="white-space:nowrap;text-align:center;background-color:#ccffcc;">
													<td style="width:220px;white-space:nowrap;padding-right:2px;">
														顧客名称
													</td>
													<td style="width:40px;white-space:nowrap;padding-right:2px;">
														公庫<br />支店
													</td>
													<td style="white-space:nowrap;padding-right:2px;">
														扱店
													</td>
													<td style="white-space:nowrap;padding-right:2px;">
														店舗
													</td>
													<td style="white-space:nowrap;padding-right:2px;">
														年度
													</td>
													<td style="white-space:nowrap;padding-right:2px;">
														方式<br />資金
													</td>
													<td style="white-space:nowrap;width:36px;padding-right:2px;">
														番号
													</td>
													<td style="white-space:nowrap;padding-right:2px;">
														枝番
													</td>
													<td style="white-space:nowrap;padding-right:2px;">
														払込期日
													</td>
													<td style="white-space:nowrap;width:85px;padding-right:2px;">
														約定元金
													</td>
													<td style="white-space:nowrap;width:85px;padding-right:2px;">
														約定利息
													</td>
													<td style="white-space:nowrap;width:85px;padding-right:2px;">
														貸付金残高
													</td>
													<td style="white-space:nowrap;display:none;padding-right:2px;">
														ID_Credit
													</td>
													<td style="white-space:nowrap;display:none;padding-right:2px;">
														Index
													</td>
												</tr>
											</paging:head>
											<paging:record>
												<tr style="width:220px;white-space:nowrap;">
													<td>
														<parts:dlabel path="ID_Name_Customer" />
													</td>
													<td style="width:40px;white-space:nowrap;">
														<parts:dlabel path="ID_Name_KoukoShiten" />
													</td>
													<td class="YushiNo">
														<parts:dlabel path="ID_Code_Organization" />
													</td>
													<td class="YushiNo">
														<parts:dlabel path="ID_Code_Tenpo" />
													</td>
													<td class="YushiNo">
														<pn:printWareki date="${record.ID_Year}" pattern="GY"/>
													</td>
													<td class="YushiNo">
														<parts:dlabel path="ID_Kubun_HoshikiShikin" />
													</td>
													<td class="YushiNo" style="width:36px;">
														<parts:dlabel path="ID_ID_Ringi" />
													</td>
													<td class="YushiNo">
														<parts:dlabel path="ID_ID_RingiBranch" />
													</td>
													<td class="YushiNo">
														<pn:printWareki date="${record.ID_Date_Haraikomi}" pattern="GYMD"/>
													</td>
													<td class="Kingaku" style="width:85px;">
														<parts:dlabel path="ID_M_YakujoGankin" />
													</td>
													<td class="Kingaku" style="width:85px;">
														<parts:dlabel path="ID_M_YakujoRisoku" />
													</td>
													<td class="Kingaku" style="width:85px;">
														<parts:dlabel path="ID_M_KashitsukeZandaka" />
													</td>
													<td style="display:none;">
														<parts:dlabel path="ID_ID_Credit" />
													</td>
													<td style="display:none;">
														<parts:dlabel path="ArrayListIndex" />
													</td>
												</tr>
											</paging:record>
										</parts:table>
									</div>
								</paging:table>
							</td>
						</tr>
					</table>
			</div>
		</div>
		</parts:form><%@ include file="/jsp/incFooter.jsp"%>
	</body>
</html>