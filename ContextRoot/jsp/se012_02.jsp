<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/jsp/incTop.jsp"%>
<%@ taglib prefix="pn" uri="http://partnernet.jfc.go.jp/tags/pn"%>

<%--================================================================================================
 * Project Name : パートナーネット開発
 * System Name  : パートナーネット
 * File Name    : se012_02.jsp
 *
 * <<Modification History>>
 * Version | Date       | Updated By            | Content
 * --------+------------+-----------------------+---------------------------------------------------
 * 2.0.0   | 2017/10/05 | 宮郷　慎之介          | 新規作成（H29年追加開発案件対応）
================================================================================================--%>
<html>
<%@ include file="/jsp/incHeader.jsp"%>

<head>
<title><parts:message code="title.screenName" /></title>
<link href="<%=request.getContextPath()%>/css/se012.css" type="text/css"
    rel="stylesheet" />
<script lang="JavaScript">
<!--

    <%-- 戻るボタン処理 --%>
    function click_backBtn() {
        executeAction('../../se012/se012_02/Se012_02Back.form');
    }
    <%-- ダウンロードボタン処理 --%>
    function click_downloadBtn(selectedindex) {
        document.forms[0].elements["selectedindex"].value = selectedindex;
        executeAction('../../se012/se012_02/Se012_02Download.form');
    }
    <%-- 非表示設定 --%>
    function initSetVisible() {
        var ele = document.getElementById("Se012_02M1Table");

        if(ele != null) {
            document.getElementById("Se012_02M1TableArea").style.visibility = ele.style.visibility;
        }
        else {
            document.getElementById("Se012_02M1TableArea").style.visibility = "hidden";
        }
    }

//-->
</script>
</head>

<body onload = "initSetVisible();">
    <parts:form modelAttribute="se012_02Form" action="./Se012_02Init.form"
        id="form1" method="post" onsubmit="return false;">
        <%@ include file="/jsp/incCommonHidden.jsp"%>
        <%@ include file="/jsp/incHeaderArea.jsp"%>
        <div id="main_scroll_area" style="height: 600px">
            <parts:hidden path="selectedindex" />
            <div class="header">
                <div class="title">
                    <label id="lblTitle"><parts:message code="title.screenName" /></label>
                </div>
            </div>

            <div class="main">
                <%-- エラーラベル --%>
                <div class="status">
                    <span id="lblError" class="errorMessage">
                        <parts:errors path="*" cssClass="Error" /><br />
                    </span>
                </div>
                <%-- 戻るボタン --%>
                <div style="margin-left: 20px;">
                    <parts:button path="btnBack" id="btnBack" value="戻る" onclick="click_backBtn()" ></parts:button>
                </div>

                <div id="Se012_02M1TableArea">
                    <%-- 扱店・店舗ラベル --%>
                    <div style="margin-left: 20px;">
                        <span><parts:dlabel path="lblid_name_organization"/></span>
                        <span style="margin-left:5px;"><parts:dlabel path="lblid_name_tenpo"/></span>
                    </div>
                    <div id="Se012_02M1Table">
                        <%-- 検索結果ヘッダーテーブル --%>
                        <div class="header_wrap" style="width:910px">
                            <parts:table id="Se012_02headerTbl" width="910px" border="0" cellspacing="0" cellpadding="0" cssStyle="table-layout:fixed;">
                                <col width="110px" align="center"/>
                                <col width="680px"/>
                                <col width="120px"/>
                                <%-- 情報提供日ROW --%>
                                <tr id="JyohoteikyoDateRow">
                                    <td style="background-color:#ccffcc"><parts:message code="lblid_date_jyohoteikyo"/></td>
                                    <td colspan="2"><parts:dlabel path="lblid_date_jyohoteikyo"></parts:dlabel></td>
                                </tr>
                                <%-- 対象年月ROW --%>
                                <tr id="TaishoDateRow">
                                    <td style="background-color:#ccffcc"><parts:message code="lblid_date_taisho"/></td>
                                    <td  colspan="2"><parts:dlabel path="lblid_date_taisho"></parts:dlabel></td>
                                </tr>
                            </parts:table>
                        </div>
                        <%-- 検索結果テーブル --%>
                        <paging:table path="Se012_02M1Table" paging="false" pagingDisplay="false">
                            <div class="wrap" style="height: 370px; width: 945px; margin: 0px;">
                                <parts:table id="tbody1"  width="910px" border="0" cellpadding="0" cellspacing="0" cssStyle="table-layout:fixed; margin:0px;">
                                    <col width="110px" align="center"/>
                                    <col width="680px"/>
                                    <col width="120px"/>
                                    <paging:record  evenNumberCssClass="rEven" oddNumberCssClass="rOdd">
                                        <tr class="${rStyle}" style="width:910px">
                                            <c:if test="${index == 0}">
                                                <td rowspan="200" style="background-color:#ccffcc"><parts:message code="lblid_m1_disp_docname"/></td>
                                            </c:if>
                                            <td style="border-right-style:none;"><parts:dlabel path="lblid_m1_disp_docname"/></td>
                                            <td align="center" style="border-left-style:none;padding-left:0px;">
                                                <parts:button path="m1_btndownload" id="m1_btndownload" value="ダウンロード" onclick="click_downloadBtn(${index})"></parts:button>
                                            </td>
                                        </tr>
                                    </paging:record>
                                </parts:table>
                            </div>
                        </paging:table>
                    </div>
                </div>
            </div>
        </div>
    </parts:form>
    <%@ include file="/jsp/incDownloadArea.jsp"%>
    <%@ include file="/jsp/incFooter.jsp"%>
</body>
</html>