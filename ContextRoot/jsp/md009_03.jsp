<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/jsp/incTop.jsp"%>
<%--================================================================================================
 * Project Name : パートナーネット開発
 * System Name  : パートナーネット
 * File Name    : md009_03.jsp
 *
 * <<Modification History>>
 * Version | Date       | Updated By            | Content
 * --------+------------+-----------------------+---------------------------------------------------
 * 1.0.0   | 2015/07/01 | 松井　元気            | 新規作成
================================================================================================--%>
<html>
    <%@ include file="/jsp/incHeader.jsp"%>
    <head>
        <title><parts:message code="title.screenName"/></title>
        <script lang="JavaScript">
		<!--
			<%-- 登録ボタン押下時の処理 --%>
			function click_okBtn() {
				executeAction('../../md009/md009_03/Md009_03Ok.form');
			}
		//-->
		</script>
        <link href="<%=request.getContextPath()%>/css/md009.css" type="text/css" rel="stylesheet" />
    </head>
    <body>
        <parts:form modelAttribute="md009_03Form" action="./Md009_03Init.form" id="form1" method="post"  onsubmit="return false;">
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
                    <parts:button id="btnOK" value="OK"
                    title="仮受金受入充当・留置期間利息・代弁遅延損害金受入充当報告書の作成画面へ戻る"  onclick="click_okBtn();"/>
                </p>
            </div>
        </div>
        </parts:form><%@ include file="/jsp/incFooter.jsp"%>
    </body>
</html>