<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/jsp/incTop.jsp" %>
<html lang="true">
<head>
<%@ include file="/jsp/incHeader.jsp" %>
<title>不正操作エラー</title>
<script lang="JavaScript">
<!--
    function forward_logon() {
        location.href = '<%=request.getContextPath()%>' + '/example/demo00001/Demo00001Init.form';
    }
//-->
</script>
</head>
<body>
	<center>
		<div style="color:red">
				 操作が正しくありません。ブラウザの戻るボタンを使用しないでください。<br>
		</div><br><br><br><br><br><br><br><br><br><br><br><br><br><br>


        <parts:button id="fwdLoginBtn" onclick="forward_logon()">
			<parts:message code="button.fwdLogon"/>
		</parts:button>
	</center>
</body>
</html>
