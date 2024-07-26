
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/jsp/incTop.jsp"%>

<%--================================================================================================
 * Project Name : パートナーネット開発
 * System Name  : パートナーネット
 * File Name    : md008_03.jsp
 *
 * <<Modification History>>
 * Version | Date       | Updated By            | Content
 * --------+------------+-----------------------+---------------------------------------------------
 * 1.0.0   | 2015/07/01 | ○○　○○            | 新規作成
================================================================================================--%>

<html>
	<%@ include file="/jsp/incHeader.jsp"%>
	<head>
		<title><parts:message code="title.screenName"/></title>
        <script lang="JavaScript">
        <!--
            <%-- 戻るボタン処理 --%>
            function click_backBtn() {
                executeAction('../../md008/md008_03/Md008_03Ok.form');
            }
        //-->
        </script>



		<link href="<%=request.getContextPath()%>/css/md008.css" type="text/css" rel="stylesheet" />
	</head>
	<body>
        <parts:form modelAttribute="md008_03Form" action="./Md008_03Init.form" id="form1" method="post"  onsubmit="return false;">
			<%@ include file="/jsp/incCommonHidden.jsp" %>
			<%@ include file="/jsp/incHeaderArea.jsp" %>
			<div id="main_scroll_area">
			<div class="header">
				<div class="title">
					<label id="lblTitle" class="Title"><parts:message code="title.screenName"/></label>
				</div>
			</div>
			<div class="main">
				<p align="center"><b>データ登録完了</b><br /></p>
				<p align="center"><font face="MS UI Gothic">データの登録が完了しました。<br />
						［OK］ボタンをクリックしてください。</font></p>
				<p align="center">
					<parts:button id="btnOK" value="OK" title="仮受金（一般口）受入報告書の作成画面へ戻る" onclick="click_backBtn();" />
				</p>
			</div>
		</div>
		</parts:form><%@ include file="/jsp/incFooter.jsp"%>
	</body>
</html>