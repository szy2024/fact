<%@page import="com.fujitsu.crust.web.util.CFWRequestUtils"%>
<%@page import="com.fujitsu.crust.web.session.CFWWindowSession"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%-- ダウンロード --%>
<logic:equal path="CFW_downloadFlag" value="true" >
	<parts:form modelAttribute="" method="post" action="../../common/Download.form" onsubmit="return false;" id="downloadForm">
        <%@ include file="/jsp/incCommonHidden.jsp"%>
        <input type="hidden" id="downloadInfo"></input>
    </parts:form>
	<%
		CFWWindowSession winSession = CFWRequestUtils.getWindowSession(request);
        if (winSession != null) {
            Object obj = winSession.getAttribute("CFW_downloadFiles");
            pageContext.setAttribute("pCFW_downloadFiles", obj);
        }
	%>

	<script type="text/javascript">
    function fileDownload() {
        var downloadForm = document.getElementById('downloadForm');
        var info = document.getElementById('downloadInfo');
    <c:forEach var="filePath" items="${pCFW_downloadFiles}" varStatus="status">
        info.name = 'targetFrame${status.index}';
        downloadForm.action = '../../common/Download.form';
            downloadForm.myparameterkey.value = '${status.index}';
            downloadForm.encoding = document.forms[0].encoding;
            <%-- downloadForm.target = info.name; --%>
            downloadForm.submit();
    </c:forEach>
    }
    setTimeout('fileDownload()', 0);
    </script>
</logic:equal>
