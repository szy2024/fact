
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/jsp/incTop.jsp" %>
<%@ page import="jp.go.jfc.partnernet.common.PNCommonMessageConstants" %>
<%@ page import="jp.go.jfc.partnernet.pnfw.common.PNMessageUtils" %>

<%--================================================================================================
 * Project Name : パートナーネット開発
 * System Name  : パートナーネット
 * File Name    : cr010_01.jsp
 *
 * <<Modification History>>
 * Version | Date       | Updated By            | Content
 * --------+------------+-----------------------+---------------------------------------------------
 * 2.0.0   | 2017/08/10 | 林　晃平              | 新規作成（H29年追加開発案件対応）
================================================================================================--%>

<html>
	<%@ include file="/jsp/incHeader.jsp"%>
	<head>
		<title><parts:message code="title.screenName"/></title>
		<link href="<%=request.getContextPath()%>/css/cr010.css" type="text/css" rel="stylesheet" />
		<script lang="JavaScript" type="text/javascript">
		<!--
		 <%-- 登録ボタン押下時の処理 --%>
		 function click_updateBtn() {
		        if (confirm("<%=PNMessageUtils.getString(PNCommonMessageConstants.PM1120I)%>")) {
		        	clearTextFormat();
				 	executeAction('../../cr010/cr010_01/Cr010_01Update.form');
		        }
		 }

		<%-- 初期表示時の合計算出 --%>
		function initSum() {
			sumIrai();
			sumGanju();
		}

		<%-- 依頼予定額合計の算出 --%>
		function sumIrai() {
			sum = 0;
			for ( i = 0; i < 6; i++ ) {
				e = document.getElementById('txtID_Irai' + i)
				n = e.value.replace(/,/g,"");
				if ( chkMoney(n) ) {
					e.value = n;
					sum += Number(n);
				}
			}

			document.getElementById('iraiSum').innerHTML = String(sum).replace( /(\d)(?=(\d\d\d)+(?!\d))/g, '$1,');
			initTextFormat();

		}

		<%-- 元金充当額（外数）合計の算出 --%>
		function sumGanju() {
			sum = 0;
			for ( i = 0; i < 6; i++ ) {
				e = document.getElementById('txtID_Ganju' + i)
				n = e.value.replace(/,/g,"");
				if ( chkMoney(n) ) {
					e.value = n;
					sum += Number(n);
				}
			}

			document.getElementById('ganjuSum').innerHTML = String(sum).replace( /(\d)(?=(\d\d\d)+(?!\d))/g, '$1,');
			initTextFormat();

		}

		<%-- 金額妥当性チェック --%>
		function chkMoney(txt) {

			<%-- 数値チェック --%>
			if ( isNaN(txt) ) {
				return false;
			}

			<%-- 整数値チェック --%>
			if ( Math.round(txt) != txt ) {
				return false;
			}

			<%-- 数値範囲チェック --%>
			if ( txt < 0 || 999999999999999 < txt ) {
				return false;
			}

			return true;

		}

		<%-- 交付日変更時の依頼予定額、元金充当額設定処理 --%>
		function changeKofuDate(index) {

			<%-- 交付日 --%>
			e1 = document.getElementById('drpID_KofuDateDate' + index)

			<%-- 交付日が未選択の場合、処理終了 --%>
			if ( e1.value.length == 0 ) {
				return;
			}

			<%-- 依頼予定額 --%>
			e2 = document.getElementById('txtID_Irai' + index)

			<%-- 元金充当額（外数） --%>
			e3 = document.getElementById('txtID_Ganju' + index)

			<%-- 依頼予定額が空白の場合、"0"を設定 --%>
			if ( e2.value.length == 0 ) {
				e2.value = 0;

			}

			<%-- 元金充当額（外数）が空白の場合、"0"を設定 --%>
			if ( e3.value.length == 0 ) {
				e3.value = 0;

			}

		}


		//-->
		</script>
	</head>
	<body onload = "initTextFormat();initSum();">
		<parts:form modelAttribute="cr010_01Form" action="./Cr010_01Init.form" id="Form1" method="post" onsubmit="return false;">
			<%@ include file="/jsp/incCommonHidden.jsp" %>
			<%@ include file="/jsp/incHeaderArea.jsp" %>
			<div id="main_scroll_area">
				<div class="header">
					<div class="title">
						<label id="lblTitle" class="title"><parts:message code="title.screenName"/></label>
					</div>
				</div>
				<div class="main">
					<parts:table id="infoArea" width="400px">
						<div class="greeting" style="width: 100%">
							必要な項目を入力したうえで「登録」ボタンを押下してください。
						</div>
					</parts:table>
					<div class="buttons">
						<parts:button id="btnUpdate" value="登録" title="登録" onclick="click_updateBtn();" />
					</div>
					<div class="reportDate">
						<parts:dlabel path="lblID_KofuIraiYear" />年
						<parts:dlabel path="lblID_KofuIraiMonth" />月分
					</div>
					<div class="note" style="color:red">
					登録期限：毎月25日（25日が非営業日の場合には、その前営業日。）の３営業日前の正午
					</div>
					<div style="color:red;font-weight:bold;">
						<parts:errors path="*"/>
					</div>
					<div class="moneyUnit">
						（金額単位：円）
					</div>
					<paging:table path="cr010_01m1Table" pagingDisplay="false">
						<parts:table cssClass="cr010List">
							<%-- テーブル ヘッダ領域 --%>
							<paging:head>
								<tr align="center">
									<th class="kofuHeader" >交付日</th>
									<th class="iraiHeader" >依頼予定額</th>
									<th class="ganjuHeader">元金充当額（外数）</th>
								</tr>
							</paging:head>
							<%-- テーブル 明細部 --%>
							<paging:record>
								<tr align="center">
									<td class="kofuItem">
										<span class="kofuMonth"><parts:dlabel path="lblID_KofuDateMonth"/>月</span>
										<parts:select path="drpID_KofuDateDate" id="drpID_KofuDateDate${index}" onchange="changeKofuDate(${index})">
											<parts:options items="${cr010_01Form.cr010_01m1Table.recordList[0].KOFU_DATE_PULLDOWN}" />
										</parts:select>日
									</td>
									<td class="iraiItem">
										<parts:text path="txtID_Irai" id="txtID_Irai${index}" maxlength="12"  size="20" cssClass="format-number" cssStyle="text-align:right;" onchange="sumIrai()"/>
									</td>
									<td class="ganjuItem">
										<parts:text path="txtID_Ganju" id="txtID_Ganju${index}" maxlength="12" size="20" cssClass="format-number" cssStyle="text-align:right;" onchange="sumGanju()"/>
									</td>
								</tr>
								<c:if test="${index == 5}">
									<tr align="center">
										<td class="kofuItem">
											計
										</td>
										<td class="iraiItem" align="right">
											<label id="iraiSum" class="labelMoney">0</label>
										</td>
										<td class="ganjuItem" align="right">
											<label id="ganjuSum" class="labelMoney">0</label>
										</td>
									</tr>
								</c:if>
							</paging:record>
						</parts:table>
					</paging:table>
					<div class="note">
					（入力上の注意点）
					</div>
					<div class="note">
					元金充当（貸付受入金からの繰上償還）は依頼予定額には含めず、外数として所定の欄に入力してください。
					</div>
				</div>
			</div>
		</parts:form><%@ include file="/jsp/incFooter.jsp"%>
	</body>
</html>