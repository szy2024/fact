<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ようこそ</title>
<script type="text/JavaScript">
open("./cm001/cm001_01/Cm001_01Init.form"
		, "pn_window"
		, "width=1080,height=640,location=yes,menubar=yes,resizable=yes,scrollbars=no,status=yes,left=0,top=0");
(window.open("", "_self").opener = window).close();

function goLogon() {
	window.open("./cm001/cm001_01/Cm001_01Init.form"
			, "pn_window"
			, "width=1080,height=640,location=yes,menubar=yes,scrollbars=no,resizable=yes,status=yes");
	(window.open("", "_self").opener = window).close();
}
</script>
</head>
<body>
<a href="JavaScript:goLogon();">ログオン</a>
</body>
</html>
