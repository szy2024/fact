<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/jsp/incTop.jsp" %>
<html>
<head>
<%@ include file="/jsp/incHeader.jsp" %>
<title><parts:message code="title.screenName"/></title>

<%-- styleシート読込 --%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/cm002.css" type="text/css" />

</head>
<body>
	<parts:form modelAttribute="cm002_03Form" id="Form1" method="post">
		<%@ include file="/jsp/incCommonHidden.jsp" %>
		<%@ include file="/jsp/incHeaderArea.jsp" %>
		<div id="main_scroll_area">
		<%-- 業務エリア --%>
			<div class="header">
				<div class="title Title">
					<parts:message code="title.screenName"/>
				</div>
			</div>


			<div class="main">
				<div class="greeting">
					<parts:message code="caption"/>
				</div>
			<parts:table cssClass="menu_list">
				<parts:tr id="anc_se001_01">
					<td>
						<parts:link cssClass="anc_menu" id="ancrse00101" href="javascript:void(0)" onclick="executeAction('../../se001/se001_01/Se001_01Init.form');">
							<parts:message code="ancrse00101"/>
						</parts:link>
					</td>
				</parts:tr>
				<parts:tr id="anc_se002_01">
					<td>
						<parts:link cssClass="anc_menu" id="ancrse00201" href="javascript:void(0)" onclick="executeAction('../../se002/se002_01/Se002_01Init.form');">
							<parts:message code="ancrse00201"/>
						</parts:link>
					</td>
				</parts:tr>
				<parts:tr id="anc_se003_01">
					<td>
						<parts:link cssClass="anc_menu" id="ancrse00301" href="javascript:void(0)" onclick="executeAction('../../se003/se003_01/Se003_01Init.form');">
							<parts:message code="ancrse00301"/>
						</parts:link>
					</td>
				</parts:tr>
				<parts:tr id="anc_se004_01">
					<td>
						<parts:link cssClass="anc_menu" id="ancrse00401" href="javascript:void(0)" onclick="executeAction('../../se004/se004_01/Se004_01Init.form');">
							<parts:message code="ancrse00401"/>
						</parts:link>
					</td>
				</parts:tr>
				<parts:tr id="anc_se005_01">
					<td>
						<parts:link cssClass="anc_menu" id="ancrse00501" href="javascript:void(0)" onclick="executeAction('../../se005/se005_01/Se005_01Init.form');">
							<parts:message code="ancrse00501"/>
						</parts:link>
					</td>
				</parts:tr>
				<parts:tr id="anc_se006_01">
					<td>
						<parts:link cssClass="anc_menu" id="ancrse00601" href="javascript:void(0)" onclick="executeAction('../../se006/se006_01/Se006_01Init.form');">
							<parts:message code="ancrse00601"/>
						</parts:link>
					</td>
				</parts:tr>
				<parts:tr id="anc_se008_01">
					<td>
						<parts:link cssClass="anc_menu" id="ancrse00801" href="javascript:void(0)" onclick="executeAction('../../se008/se008_01/Se008_01Init.form');">
							<parts:message code="ancrse00801"/>
						</parts:link>
					</td>
				</parts:tr>
				<parts:tr id="anc_se007_01">
					<td>
						<parts:link cssClass="anc_menu" id="ancrse00701" href="javascript:void(0)" onclick="executeAction('../../se007/se007_01/Se007_01Init.form');">
							<parts:message code="ancrse00701"/>
						</parts:link>
					</td>
				</parts:tr>
				<parts:tr id="anc_se009_01">
					<td>
						<parts:link cssClass="anc_menu" id="ancrse00901" href="javascript:void(0)" onClick="executeAction('../../se009/se009_01/Se009_01Init.form');">
							<parts:message code="ancrse00901"/>
						</parts:link>
					</td>
				</parts:tr>
				<parts:tr id="anc_se010_01">
					<td>
						<parts:link cssClass="anc_menu" id="ancrse01001" href="javascript:void(0)" onclick="executeAction('../../se010/se010_01/Se010_01Init.form');">
							<parts:message code="ancrse01001"/>
						</parts:link>
					</td>
				</parts:tr>
				<parts:tr id="anc_se011_01">
					<td>
						<parts:link cssClass="anc_menu" id="ancrse01101" href="javascript:void(0)" onclick="executeAction('../../se011/se011_01/Se011_01Init.form');">
							<parts:message code="ancrse01101"/>
						</parts:link>
					</td>
				</parts:tr>
				<parts:tr id="anc_se012_01">
					<td>
						<parts:link cssClass="anc_menu" id="ancrse01201" href="javascript:void(0)" onclick="executeAction('../../se012/se012_01/Se012_01Init.form');">
							<parts:message code="ancrse01201"/>
						</parts:link>
					</td>
				</parts:tr>
				<parts:tr id="anc_se013_01">
					<td>
						<parts:link cssClass="anc_menu" id="ancrse01301" href="javascript:void(0)" onclick="executeAction('../../se013/se013_01/Se013_01Init.form');">
							<parts:message code="ancrse01301"/>
						</parts:link>
					</td>
				</parts:tr>
				<parts:tr id="anc_se014_01">
					<td>
						<parts:link cssClass="anc_menu" id="ancrse01401" href="javascript:void(0)" onclick="executeAction('../../se014/se014_01/Se014_01Init.form');">
							<parts:message code="ancrse01401"/>
						</parts:link>
					</td>
				</parts:tr>
				<parts:tr id="anc_se015_01">
					<td>
						<parts:link cssClass="anc_menu" id="ancrse01501" href="javascript:void(0)" onclick="executeAction('../../se015/se015_01/Se015_01Init.form');">
							<parts:message code="ancrse01501"/>
						</parts:link>
					</td>
				</parts:tr>
				<parts:tr id="anc_se016_01">
					<td>
						<parts:link cssClass="anc_menu" id="ancrse01601" href="javascript:void(0)" onclick="executeAction('../../se016/se016_01/Se016_01Init.form');">
							<parts:message code="ancrse01601"/>
						</parts:link>
					</td>
				</parts:tr>
			</parts:table>
			</div>
		</div>
	</parts:form>
	<%@ include file="/jsp/incFooter.jsp" %>
</body>
</html>
