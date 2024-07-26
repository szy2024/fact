<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/jsp/incTop.jsp" %>
<html lang="true">
<head>
<%@ include file="/jsp/incHeader.jsp" %>
<title>ログアウト</title>
<script lang="JavaScript">
<!--
    function forward_login() {
        location.href = '<%=request.getContextPath()%>' + '/cm001/cm001_01/Cm001_01Init.form';
    }
//-->
</script>
</head>
<body>
	<center>
		<br><br><br><br><br><br><div style="color:red">
				ログアウトしました。<br>
				再度システムをご利用する場合は、再度ログインを行ってください。<br>
		</div><br><br><br><br><br><br><br><br>
		<parts:button id="fwdLoginBtn" onclick="forward_logon()">
			<parts:message code="button.fwdLogon"/>
		</parts:button>
	</center>
</body>
</html>
