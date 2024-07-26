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
	<parts:form modelAttribute="cm002_02Form">
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
					<parts:tr>
						<td>
							<parts:link cssClass="anc_menu" id="ancrcr00101" href="javascript:void(0)" onclick="executeAction('../../cr001/cr001_01/Cr001_01Init.form');">
								<parts:message code="ancrcr00101"/>
							</parts:link>
						</td>
					</parts:tr>
					<parts:tr>
						<td>
							<parts:link cssClass="anc_menu" id="ancrcr00201" href="javascript:void(0)" onclick="executeAction('../../cr002/cr002_01/Cr002_01Init.form');">
								<parts:message code="ancrcr00201"/>
							</parts:link>
						</td>
					</parts:tr>
					<parts:tr>
						<td>
							<parts:link cssClass="anc_menu" id="ancrcr00301" href="javascript:void(0)" onclick="executeAction('../../cr003/cr003_01/Cr003_01Init.form');">
								<parts:message code="ancrcr00301"/>
							</parts:link>
						</td>
					</parts:tr>
					<parts:tr>
						<td>
							<parts:link cssClass="anc_menu" id="ancrcr00401" href="javascript:void(0)" onclick="executeAction('../../cr004/cr004_01/Cr004_01Init.form');">
								<parts:message code="ancrcr00401"/>
							</parts:link>
						</td>
					</parts:tr>
					<parts:tr>
						<td>
							<parts:link cssClass="anc_menu" id="ancrcr00501" href="javascript:void(0)" onclick="executeAction('../../cr005/cr005_01/Cr005_01Init.form');">
								<parts:message code="ancrcr00501"/>
							</parts:link>
						</td>
					</parts:tr>
					<parts:tr>
						<td>
							<parts:link cssClass="anc_menu" id="ancrcr00601" href="javascript:void(0)" onclick="executeAction('../../cr006/cr006_01/Cr006_01Init.form');">
								<parts:message code="ancrcr00601"/>
							</parts:link>
						</td>
					</parts:tr>
					<parts:tr>
						<td>
							<parts:link cssClass="anc_menu" id="ancrcr00801" href="javascript:void(0)" onclick="executeAction('../../cr008/cr008_01/Cr008_01Init.form');">
								<parts:message code="ancrcr00801"/>
							</parts:link>
						</td>
					</parts:tr>
					<parts:tr>
						<td>
							<parts:link cssClass="anc_menu" id="ancrcr00901" href="javascript:void(0)" onclick="executeAction('../../cr009/cr009_01/Cr009_01Init.form');">
								<parts:message code="ancrcr00901"/>
							</parts:link>
						</td>
					</parts:tr>
					<parts:tr>
						<td>
							<parts:link cssClass="anc_menu" id="ancrcr01001" href="javascript:void(0)" onclick="executeAction('../../cr010/cr010_01/Cr010_01Init.form');">
								<parts:message code="ancrcr01001"/>
							</parts:link>
						</td>
					</parts:tr>
					<parts:tr>
						<td>
							<parts:link cssClass="anc_menu" id="ancrcr01101" href="javascript:void(0)" onclick="executeAction('../../cr011/cr011_01/Cr011_01Init.form');">
								<parts:message code="ancrcr01101"/>
							</parts:link>
						</td>
					</parts:tr>
					<parts:tr>
						<td>
							<parts:link cssClass="anc_menu" id="ancrcr01201" href="javascript:void(0)" onclick="executeAction('../../cr012/cr012_01/Cr012_01Init.form');">
								<parts:message code="ancrcr01201"/>
							</parts:link>
						</td>
					</parts:tr>
					<parts:tr>
						<td>
							<parts:link cssClass="anc_menu" id="ancrcr01301" href="javascript:void(0)" onclick="executeAction('../../cr013/cr013_01/Cr013_01Init.form');">
								<parts:message code="ancrcr01301"/>
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
