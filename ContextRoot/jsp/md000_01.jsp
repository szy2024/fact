<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/jsp/incTop.jsp" %>

<%--================================================================================================
 * Project Name : パートナーネット開発
 * System Name  : パートナーネット
 * File Name    : md000_01.jsp
 *
 * <<Modification History>>
 * Version | Date       | Updated By            | Content
 * --------+------------+-----------------------+---------------------------------------------------
 * 1.0.0   | 2015/07/01 | 小林　浩二            | 新規作成
 * 2.0.0   | 2017/09/25 | 林　晃平              | H29年追加開発案件対応
================================================================================================--%>
<html>
	<%@ include file="/jsp/incHeader.jsp"%>
	<head>
		<title><parts:message code="title.screenName"/></title>

<script lang="JavaScript">
<!--
<%--
- 検索ボタン押下時の処理
--%>
    function click_searchBtn1() {
        executeAction('../../md000/md000_01/Md000_01Search1.form');
    }

    function click_searchBtn2() {
        executeAction('../../md000/md000_01/Md000_01Search2.form');
    }

    function click_clearBtn() {
        executeAction('../../md000/md000_01/Md000_01Clear.form');
    }

//-->
</script>

		<%-- ﾊﾟｰﾄﾅｰﾈｯﾄ用ｶｽﾀﾏｲｽﾞ (CSSﾌｧｲﾙ名をﾊﾟｰﾄﾅｰﾈｯﾄ用に変更) --%>
		<link href="<%= request.getContextPath() %>/css/Jikko_Mod.css" type="text/css" rel="stylesheet" />
	</head>
	<body>
		<parts:form modelAttribute="md000_01Form"  id="Form1" method="post">
			<%@ include file="/jsp/incCommonHidden.jsp" %>
			<%@ include file="/jsp/incHeaderArea.jsp" %>
			<div id="main_scroll_area">
			<div class="header">
				<div class="title">
					<label id="lblTitle" class="Title"><parts:message code="title.screenName"/></label>
				</div>
			</div>
			<div class="main">
				<div class="subTitle">
					取消・修正対象報告書の検索
				</div>
				<div class="greeting">
					<label id="lblInfo1" class=""> まずは1又は 2で取消や修正をする報告書を検索してください。</label>
				</div>
				<div class="Error" style="color:red;margin-top:10px;margin-bottom:10px;font-weight:bold;font-size:11px;">
					<parts:errors path="*" cssClass="Error" /><br />
				</div>
				<div style="margin-top: 20px;">
					<label id="lblInfo2" class="">1. 貸付実行報告書、貸付受入払出・充当報告書、元利金受入・充当報告書、<br />&nbsp;&nbsp;&nbsp;
																			繰上償還受入・充当報告書、代位弁済金払込・充当報告書、立替金受入・充当報告書</label>
					<div style="margin-top: 10px; margin-bottom: 5px; margin-left: 17px;">
						<label id="lblInfo3" class="">融資番号を入力した後で「検索」ボタンを押してください。</label>
					</div>
					<p>
						<parts:table cssClass="tbl2" border="1" cellspacing="1" cellpadding="1" width="300">
							<tr>
								<td class="recordHeader1" align="center"><font face="MS UI Gothic">支店</font>
								</td>
								<td class="recordHeader2" align="center" style="padding-right:5px;"><font face="MS UI Gothic" >扱店</font>
								</td>
								<td class="recordHeader1" align="center"><font face="MS UI Gothic">店舗</font>
								</td>
								<td class="recordHeader1" align="center"><font face="MS UI Gothic">年度</font>
								</td>
								<td class="recordHeader1" align="center"><font face="MS UI Gothic">方式資金</font>
								</td>
								<td class="recordHeader1" align="center"><font face="MS UI Gothic">番号</font>
								</td>
								<td class="recordHeader1" align="center"><font face="MS UI Gothic">枝番</font>
								</td>
							</tr>
							<tr>
								<!-- 支店 -->
								<td style="padding: 2px;">
									<parts:select path="drpID_Code_KoukoShiten" id="drpID_Code_KoukoShiten">
										<parts:options items="${md000_01Form.KOUKOSHITEN_CODE_PULLDOWN_LIST}" />
									</parts:select>
								</td>
								<!-- 扱店コード -->
								<td style="padding: 2px;">
									<parts:text path="txtID_Code_Organization" id="txtID_Code_Organization" style="text-align: center;" maxlength="4" size="6" tabindex="-1" readonly="true" />
								</td>
								<!-- 店舗コード -->
								<td style="padding: 2px;">
									<parts:text path="txtID_Code_Tenpo" id="txtID_Code_Tenpo" style="text-align: right;" maxlength="3" size="6" />
								</td>
								<!-- 年度 -->
								<td style="padding: 2px;">
									<parts:text path="txtID_Year" id="txtID_Year" style="text-align: right;" maxlength="3" size="4" />
								</td>
								<!-- 方式資金 -->
								<td style="padding: 2px;">
									<parts:text path="txtID_Kubun_Hoshiki" id="txtID_Kubun_Hoshiki" style="text-align: right;" maxlength="2" size="8" />
								</td>
								<!-- 番号 -->
								<td style="padding: 2px;">
									<parts:text path="txtID_ID_Ringi" id="txtID_ID_Ringi" style="text-align: right;" maxlength="5" size="6" />
								</td>
								<!-- 枝番 -->
								<td style="padding: 2px;">
									<parts:text path="txtID_ID_RingiBranch" id="txtID_ID_RingiBranch" style="text-align: right;" maxlength="3" size="4" />
								</td>
							</tr>
						</parts:table>
					</p>
				</div>
				<parts:button style="display:none;" id="btnSearch" />
				<parts:button style="display:none;" id="btnClear" />
				<parts:button id="btnSearch2" value="検索"  onclick="click_searchBtn1();"/>
				<parts:button id="btnClear2" value="クリア" onclick="click_clearBtn();" />
				<div style="margin-top: 20px;">
					<label id="lblInfo4" class="">
						2. 仮受金（一般口）受入、留置期間利息・代弁遅延損害金受入充当報告書、<br>&nbsp;&nbsp;&nbsp;
						資金交付依頼予定表（月間）、資金交付依頼書（週間）<br>&nbsp;&nbsp;&nbsp;
						包括委任状等の交付依頼、（根）抵当権抹消に係る報告書<br>
					</label>
					<!-- 報告書種別プルダウン -->
					<p style="margin-left:10px">
						報告書種別：
						<parts:select path="drpID_DataCode" id="drpID_DataCode">
							<parts:options items="${md000_01Form.DATACODE_PULLDOWN_LIST}" />
						</parts:select>
					</p>
				</div>
				<p style="margin-left:20px">
				<parts:button id="btnKariukeSerch" value="検索" onclick="click_searchBtn2();"/>
				</p>
			</div>
		</div>
		</parts:form><%@ include file="/jsp/incFooter.jsp"%>
	</body>
</html>