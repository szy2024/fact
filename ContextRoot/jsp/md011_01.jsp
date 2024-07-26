
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/jsp/incTop.jsp" %>
<%@ page import="jp.go.jfc.partnernet.common.PNCommonMessageConstants" %>
<%@ page import="jp.go.jfc.partnernet.pnfw.common.PNMessageUtils" %>

<%--================================================================================================
 * Project Name : パートナーネット開発
 * System Name  : パートナーネット
 * File Name    : md011_01.jsp
 *
 * <<Modification History>>
 * Version | Date       | Updated By            | Content
 * --------+------------+-----------------------+---------------------------------------------------
 * 2.0.0   | 2017/09/05 | 林　晃平              | 新規作成（H29年追加開発案件対応）
================================================================================================--%>

<html>
	<%@ include file="/jsp/incHeader.jsp"%>
	<head>
		<title><parts:message code="title.screenName"/></title>
		<link href="<%=request.getContextPath()%>/css/md011.css" type="text/css" rel="stylesheet" />
		<script lang="JavaScript">
		<!--
			 <%-- 登録ボタン押下時の処理 --%>
			 function click_updateBtn(processMode) {
				if (processMode == 3 ) {
					// 取消の場合
					if (confirm("<%=PNMessageUtils.getString(PNCommonMessageConstants.PM1140I)%>")) {
						clearTextFormat();
						executeAction('../../md011/md011_01/Md011_01Update.form');
					}
				} else {
					// 修正の場合
					if (confirm("<%=PNMessageUtils.getString(PNCommonMessageConstants.PM1130I)%>")) {
						clearTextFormat();
						executeAction('../../md011/md011_01/Md011_01Update.form');
					}
				}

			 }

			 <%-- 戻るボタン押下時の処理 --%>
			function click_backBtn() {
				executeAction('../../md011/md011_01/Md011_01Back.form');
			}

			<%-- 差引資金交付依頼額の算出 --%>
			function calcSashihikiIrai() {
				tmpYotei = 0;
				tmpGanju = 0;

				eYotei = document.getElementById('txtID_M_Yotei');
				eGanju = document.getElementById('txtID_M_ZanMikomi');

				yotei = eYotei.value.replace(/,/g,"");
				ganju = eGanju.value.replace(/,/g,"");

				if ( chkMoney(yotei) ) {
					tmpYotei = yotei
				}

				if ( chkMoney(ganju) ) {
					tmpGanju = ganju
				}

				rslt = tmpYotei - tmpGanju

				eYotei = yotei;
				eGanju = ganju;
				document.getElementById('lblID_M_Sashihiki_Irai').innerHTML =
					String(rslt).replace( /(\d)(?=(\d\d\d)+(?!\d))/g, '$1,');

			}

			<%-- 金額妥当性チェック --%>
			function chkMoney(txt) {
				if ( isNaN(txt) ) {
					return false;
				}

				if ( Math.round(txt) != txt ) {
					return false;
				}

				if ( txt < 0 || 999999999999 < txt ) {
					return false;
				}

				return true;

			}
		//-->
		</script>
	</head>
	<body onload = "initTextFormat();calcSashihikiIrai();">
		<parts:form modelAttribute="md011_01Form" action="./Md011_01Init.form" id="Form1" method="post" onsubmit="return false;">
			<%@ include file="/jsp/incCommonHidden.jsp" %>
			<%@ include file="/jsp/incHeaderArea.jsp" %>
			<div id="main_scroll_area">
				<div class="header">
					<div class="title">
						<label id="lblTitle" class="title"><parts:message code="title.screenName"/></label>
					</div>
				</div>
				<div class="main">
					<%-- 該当データなしの場合 --%>
					<logic:equal value="" path="processMode">
						<div class="buttons">
							<parts:button id="btnUBack2" value="戻る" title="取消・修正対象報告書の一覧画面へ戻る" onclick="clearTextFormat();click_backBtn();" />
						</div>
						<div style="color:red;font-weight:bold;">
							<parts:errors path="*"/>
						</div>
					</logic:equal>
					<%-- 該当データありの場合 --%>
					<logic:notEqual value="" path="processMode">
						<parts:table id="infoArea" width="700px">
							<div class="greeting">
								<logic:equal value="3" path="processMode">
									以下の報告書の取消を行います。内容をご確認のうえ「登録」ボタンを押してください。
								</logic:equal>
								<logic:equal value="4" path="processMode">
									以下の報告書の修正を行います。内容をご確認のうえ「登録」ボタンを押してください。
								</logic:equal>
							</div>
						</parts:table>
						<div class="buttons">
							<parts:button id="btnUpdate2" value="登録" title="登録" onclick="click_updateBtn(${md011_01Form.getProcessMode()});" />
							<parts:button id="btnUBack2" value="戻る" title="取消・修正対象報告書の一覧画面へ戻る" onclick="clearTextFormat();click_backBtn();" />
						</div>
						<div>
							指定交付日
							<parts:select path="drpID_ShiteiKofuYear" id="drpID_ShiteiKofuYear" class="drpDate"><parts:options items="${md011_01Form.SHITEIKOHU_YEAR_PULLDOWN_LIST}" /></parts:select>年
							<parts:select path="drpID_ShiteiKofuMonth" id="drpID_ShiteiKofuMonth" class="drpDate"><parts:options items="${md011_01Form.SHITEIKOHU_MONTH_PULLDOWN_LIST}" /></parts:select>月
							<parts:select path="drpID_ShiteiKofuDate" id="drpID_ShiteiKofuDate" class="drpDate"><parts:options items="${md011_01Form.SHITEIKOHU_DATE_PULLDOWN_LIST}" /></parts:select>日
						</div>
						<div class="note" style="color:red">
							登録期限：指定交付日（毎週水曜日。非営業日の場合には、その翌営業日。）の３営業日前の正午
						</div>
						<logic:equal value="4" path="processMode">
							次のとおり資金の交付を依頼します。
						</logic:equal>
						<div style="color:red;font-weight:bold;">
							<parts:errors path="*"/>
						</div>
						<div class="moneyUnit">
							（金額単位：円）
						</div>
						<paging:table path="md011_01m1Table" pagingDisplay="false">
							<parts:table cssClass="md011List">
								<%-- テーブル ヘッダ領域 --%>
								<paging:head>
									<tr align="center">
										<th class="kofuHeader"  colspan="2">区　分</th>
										<th class="iraiHeader" >依　頼　額</th>
										<th class="ganjuHeader">元金充当額<br>（外数）</th>
									</tr>
								</paging:head>
								<%-- テーブル 明細部 --%>
								<paging:record>
									<tr align="center" height="50px">
										<td colspan="2" style="text-align:left;">
											<div class="kbnItem">
												（１） 資金払出予定額
											</div>
										</td>
										<td>
											<parts:text path="txtID_M_Yotei" id="txtID_M_Yotei" maxlength="12" size="20" cssClass="format-number" cssStyle=";text-align:right;" onchange="calcSashihikiIrai()"/>
										</td>
										<td>
											<parts:text path="txtID_M_Ganju_GaiSu" id="txtID_M_Ganju_GaiSu" maxlength="12" size="20" cssClass="format-number" cssStyle="text-align:right;"/>
										</td>
									</tr>
									<tr align="center" height="50px">
										<td colspan="2" style="text-align:left;">
											<div class="kbnItem">
												（２） 指定交付日の前日現在の<br>　　　資金交付金残高見込額
											</div>
										</td>
										<td class="iraiItem">
											<parts:text path="txtID_M_ZanMikomi" id="txtID_M_ZanMikomi" maxlength="12" size="20" cssClass="format-number" cssStyle=";text-align:right;" onchange="calcSashihikiIrai()"/>
										</td>
										<td></td>
									</tr>

									<tr align="center" height="50px">
										<td colspan="2" style="text-align:left;">
											<div class="kbnItem">
												差引資金交付依頼額<br>　　　（１）－（２）
											</div>
										</td>
										<td align="right">
											<label id="lblID_M_Sashihiki_Irai" class="labelMoney">0</label>
										</td>
										<td></td>
									</tr>
								</paging:record>
							</parts:table>
						</paging:table>
						<paging:table path="md011_01m1Table" pagingDisplay="false">
							<parts:table cssClass="md011List">
								<paging:record>
									<tr>
										<td style="width:150px">
											備　考
										</td>
										<td style="padding:2px 4px">
											<parts:textarea path="txtID_M_Biko" id="txtID_M_Biko"  cols="64" rows="4" />
										</td>
									</tr>
								</paging:record>
							</parts:table>
						</paging:table>
						<logic:equal value="4" path="processMode">
							<div class="note">
							（入力上の注意点）
							</div>
							<div class="note">
								<ol class="list">
									<li>１　元金充当（貸付受入金からの繰上償還）は資金払出予定額には含めず、外数として所定の欄に入力してください。</li>
									<li>２　資金交付依頼予定表で計上していた予定額の交付依頼が不要になった場合は、次のことを備考欄に記入の上、<br>　　資金払出予定額欄にゼロを入力してください。</li>
								</ol>
								<div style="margin-left:30px">
									<ol class="list">
										<li>（1） 交付依頼が延期になった場合は、延期理由及び交付予定日</li>
										<li>（2） 交付依頼が不要になった場合は、その理由</li>
										<li>（3） 前倒しで交付を受けた場合は、交付日</li>
									</ol>
								</div>
							</div>
						</logic:equal>
					</logic:notEqual>
				</div>
			</div>
		</parts:form><%@ include file="/jsp/incFooter.jsp"%>
	</body>
</html>