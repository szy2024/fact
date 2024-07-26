<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/jsp/incTop.jsp" %>
<html lang="true">
<head>
<%@ include file="/jsp/incHeader.jsp" %>
<title>同一ファイルエラー</title>
<script lang="JavaScript">
<!--
    function forward_login() {
        location.href = '<%=request.getContextPath()%>' + '/cm001/cm001_01/Cm001_01Init.form';
    }
//-->
</script></head>
<body>
	<center>
		<div style="color:red">
				 ファイルの出力に失敗しました。<br>
				同一のファイルが既に存在しています。<br>
		</div><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
        <parts:button id="fwdLoginBtn" onclick="forward_logon()">
			<parts:message code="button.fwdLogon"/>
		</parts:button>
	</center>
</body>
</html>
