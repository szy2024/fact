<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@ page import="org.apache.commons.lang3.StringUtils" %>
<%@ page import="jp.go.jfc.partnernet.pnfw.common.PNConstants" %>

<meta http-equiv="x-ua-compatible" content="IE=7" >
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript" lang="JavaScript" src="<%=request.getContextPath()%>/js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" lang="JavaScript" src="<%=request.getContextPath()%>/js/jquery-ui-1.10.4.min.js"></script>
<script type="text/javascript" lang="JavaScript" src="<%=request.getContextPath()%>/js/jquery.json-2.4.min.js"></script>
<script type="text/javascript" lang="JavaScript" src="<%=request.getContextPath()%>/js/i18n/jquery.ui.datepicker-ja.js"></script>
<script type="text/javascript" lang="JavaScript" src="<%=request.getContextPath()%>/js/cfw-calendar-common.js"></script>
<script type="text/javascript" lang="JavaScript" src="<%=request.getContextPath()%>/js/ime-mode.js"></script>
<script type="text/javascript" lang="JavaScript" src="<%=request.getContextPath()%>/js/cfw-common.js"></script>
<script type="text/javascript" lang="JavaScript" src="<%=request.getContextPath()%>/js/SimpleTab.js"></script>
<script type="text/javascript" lang="JavaScript" src="<%=request.getContextPath()%>/js/restrain-Return.js"></script>
<script type="text/javascript" lang="JavaScript" src="<%=request.getContextPath()%>/js/onkey-Enter.js"></script>
<script type="text/javascript" lang="JavaScript" src="<%=request.getContextPath()%>/js/full-digit-focus-movement.js"></script>
<script type="text/javascript" lang="JavaScript" src="<%=request.getContextPath()%>/js/checkField.js"></script>
<script type="text/javascript" lang="JavaScript" src="<%=request.getContextPath()%>/js/getMessage.js"></script>
<script type="text/javascript" lang="JavaScript" src="<%=request.getContextPath()%>/js/textbox_formatter.js"></script>

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/cfw-common.css" type="text/css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/myStyle.css" type="text/css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/tab.css" type="text/css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" type="text/css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style_detail.css" type="text/css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style_form.css" type="text/css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style_list.css" type="text/css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style_search.css" type="text/css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/calendar.css" type="text/css" />

<%-- IEでのモーダルポップアップ内POST結果をポップアップ内に表示させるための定義 --%>
<base target="_self">

<script type="text/javascript" lang="JavaScript">
<!--

    // onload処理
    window.onload = commonOnloadProcess;

    <%--
     * ウィンドウIDを取得します。
    --%>
    function getWindowID() {
        return "${windowID}";
    }

    <%--
     * 画面を閉じます
    --%>
    <logic:equal path="windowCloseFlgKey" value="true">
    function closeWindow() {
        window.close();
    }
    </logic:equal>
     <%--
     * 子画面を閉じます
    --%>
    <logic:equal path="childWindowCloseFlgKey" value="true">
    function closeChiledWindow() {
        callBack();
    }
    </logic:equal>


    <%--
    * onload時に確認ダイアログを表示します
   --%>
    <logic:equal path="confirmKey" value="true">
    function showConfirm() {
        if (confirm("${confirmMsgKey}")) {
            <logic:notEmpty path="confirmOkPathKey">
                $('#alreadyConfirmFlag').value = "true";
                document.forms[0].alreadyConfirmFlag.value = "true";
                executeAction('${confirmOkPathKey}');
            </logic:notEmpty>
        } else {
            <logic:notEmpty path="confirmClPathKey">
                $('#alreadyConfirmFlag').value = "true";
                executeAction('${confirmClPathKey}');
            </logic:notEmpty>
        }
    }
   </logic:equal>

//-->
</script>
