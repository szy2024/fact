
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/jsp/incTop.jsp" %>
<%@ page import="jp.go.jfc.partnernet.common.PNCommonMessageConstants" %>
<%@ page import="jp.go.jfc.partnernet.pnfw.common.PNMessageUtils" %>

<%--================================================================================================
 * Project Name : パートナーネット開発
 * System Name  : パートナーネット
 * File Name    : cr013_01.jsp
 *
 * <<Modification History>>
 * Version | Date       | Updated By            | Content
 * --------+------------+-----------------------+---------------------------------------------------
 * 2.0.0   | 2017/09/07 | 木村　しのぶ          | 新規作成（H29年追加開発案件対応）
================================================================================================--%>

<html>
	<%@ include file="/jsp/incHeader.jsp"%>
	<head>
		<title><parts:message code="title.screenName"/></title>
		<link href="<%=request.getContextPath()%>/css/cr013.css" type="text/css" rel="stylesheet" />
		<script lang="JavaScript" type="text/javascript">
		<!--
		<%-- 登録ボタン押下時の処理 --%>
		function click_updateBtn() {
		       if (confirm("<%=PNMessageUtils.getString(PNCommonMessageConstants.PM1120I)%>")) {
			 	executeAction('../../cr013/cr013_01/Cr013_01Update.form');
		       }
		}

		<%-- ファイル変更時の処理 --%>
        function onchange_fileBtn() {
            document.getElementById("btnUpdate2").disabled = "";    //ボタンの有効化
        }

		//-->
		</script>
	</head>
	<body onload = "initTextFormat()">
		<parts:form modelAttribute="cr013_01Form" action="./Cr013_01Init.form" id="Form1" method="post"  enctype="multipart/form-data" onsubmit="return false;">
			<%@ include file="/jsp/incCommonHidden.jsp" %>
			<%@ include file="/jsp/incHeaderArea.jsp" %>
			<div id="main_scroll_area">
				<div class="header">
					<div class="title">
						<label id="lblTitle" class="title"><parts:message code="title.screenName"/></label>
					</div>
				</div>
				<div class="main">
                    <parts:table id="infoArea" width="100%">
                        <div class="greeting" style="width: 100%">
							「ファイルの選択」ボタンを押して報告するファイルを指定した後、「登録」ボタンを押してください。<BR>
							・本日、登録されたデータは、本日17時をもって修正及び取消を締切ります。<BR>
							・修正あるいは取消が必要となった場合は、公庫本店までご連絡のうえ、修正したファイルを添付あるいは取消の登録を行ってください。
                        </div>
                    </parts:table>
					<parts:table width="80%">
						<logic:notEqual path="flgDisp" value="">
							<div class="buttons">
								<parts:button id="btnUpdate2" value="登録" title="登録" onclick="click_updateBtn();" />
							</div>
						</logic:notEqual>
						<div style="color:red;font-weight:bold;">
							<parts:errors path="*"/>
						</div>
						<logic:notEqual path="flgDisp" value="">
							<BR>
							<parts:table  cssClass="cr13List" >
								<tr>
									<td class="itemName">
										<span>発信者</span>
									</td>
									<td class="item" >
										<parts:dlabel path="lblID_Name_Organizat"  />
									</td>
								</tr>
								<tr>
									<td class="itemName">
										<span>発信日</span>
									</td>
									<td class="item">
										<parts:dlabel path="lblID_SendDate_Report"  />
									</td>
								</tr>
								<tr>
									<td class="itemName">
										<span>添付ファイル</span>
									</td>
									<td class="item" >
										<parts:file path="fileUpload" size="80" onchange="onchange_fileBtn();" />
									</td>
								</tr>
							</parts:table >
						</logic:notEqual>
					</parts:table>
				</div>
			</div>
		</parts:form><%@ include file="/jsp/incFooter.jsp"%>
	</body>
</html>