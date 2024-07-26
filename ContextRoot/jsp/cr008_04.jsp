<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/jsp/incTop.jsp"%>
<%@ page import="jp.go.jfc.partnernet.common.PNCommonConstants" %>

<%--================================================================================================
 * Project Name : パートナーネット開発
 * System Name  : パートナーネット
 * File Name    : cr008_04.jsp
 *
 * <<Modification History>>
 * Version | Date       | Updated By            | Content
 * --------+------------+-----------------------+---------------------------------------------------
 * 1.0.0   | 2015/09/16 | 石川　真理            | 新規作成
 * 2.0.0   | 2017/11/30 | 嶋田　美保            | 委託貸付報告等における機能改善対応
================================================================================================--%>

<html>
    <%@ include file="/jsp/incHeader.jsp"%>
    <head>
        <title><parts:message code="title.screenName"/></title>
        <link href="<%=request.getContextPath()%>/css/cr008.css" type="text/css" rel="stylesheet" />
        <script lang="JavaScript">
        <!--
        <%-- 送信ボタン押下時の処理    --%>
            function click_sendBtn() {
                executeAction('../../cr008/cr008_04/Cr008_04Send.form');
            }
        <%-- 戻るボタン押下時の処理    --%>
            function click_backBtn() {
                executeAction('../../cr008/cr008_04/Cr008_04Back.form');
            }
        <%-- 入金日変更時の処理    --%>
            function change_dateNyukin( JtkshoriConfigMode, bizDateGengo,
                    bizDateNen, bizDateTsuki, bizDatePrevMonthGengo, bizDatePrevMonthNen, bizDatePrevMonthTsuki) {

                <%-- 入金日 取得 --%>
                nyukinGengo = document.getElementById('drpID_Date_Nyukin_Gengou').value;
                nyukinNen = document.getElementById('txtID_Date_Nyukin_Year').value;
                nyukinTsuki = document.getElementById('drpID_Date_Nyukin_Month').value;

                <%-- 受託者勘定処理年月 隠しフィールド取得 --%>
                hdnJtkGengo = document.getElementById('hdnID_Date_Jtkshori_Gengo');
                hdnJtkTsuki = document.getElementById('hdnID_Date_JtkshoriTsuki_Candidate');

                <%-- 日付形式チェック --%>
                if ( !chkDate( nyukinNen, nyukinTsuki) ) {

                    return;
                }

                <%-- 和暦→西暦変換 --%>
                nyukinYYYY = warekiToSeireki( nyukinGengo, nyukinNen)

                bizDateYYYY = warekiToSeireki( bizDateGengo, bizDateNen)

                <%-- 月差分計算 ： 業務日付 - 入金日  --%>
                dm = diffMonth( bizDateYYYY, bizDateTsuki, nyukinYYYY, nyukinTsuki);

                <%-- 受託者勘定処理年月設定 --%>
                if ( JtkshoriConfigMode == <%=PNCommonConstants.JTKSHORI_CONFIGMODE_1%>
                    || JtkshoriConfigMode == <%=PNCommonConstants.JTKSHORI_CONFIGMODE_3%>) {
                    <%-- 受託者勘定処理年月設定モードが 1（決算期かつ第1～4営業日）または --%>
                    <%-- 受託者勘定処理年月設定モードが 3（通常期かつ第1～10営業日）の場合 --%>
                    if ( 2 <= dm ) {
                        <%-- 入金日が業務日付の前々月以前の場合 --%>
                        <%-- 業務日付の前月を設定 --%>
                        setDateJtkshori( bizDatePrevMonthGengo, bizDatePrevMonthNen, bizDatePrevMonthTsuki);

                    }
                    else {
                        <%-- 上記以外 入金日 を設定 --%>
                        setDateJtkshori( nyukinGengo, nyukinNen, nyukinTsuki);

                    }

                }
                else if ( JtkshoriConfigMode == <%=PNCommonConstants.JTKSHORI_CONFIGMODE_2%>
                    || JtkshoriConfigMode == <%=PNCommonConstants.JTKSHORI_CONFIGMODE_4%>) {
                    <%-- 受託者勘定処理年月設定モードが 2（決算期かつ第5～最終営業日）または --%>
                    <%-- 受託者勘定処理年月設定モードが 4（通常期かつ第11～最終営業日）の場合 --%>

                    <%-- 業務日付を設定--%>
                    setDateJtkshori( bizDateGengo, bizDateNen, bizDateTsuki);

                }

            }

            <%-- 月差分計算 --%>
            function diffMonth( y1, m1, y2, m2) {
                return (y1 - y2) * 12 + (m1 - m2) * 1;

            }

            <%-- 日付形式チェック --%>
            function chkDate( year, month) {

                strYear = String(year)
                strMonth = String(month)

                <%-- 未入力チェック --%>
                if ( strYear.length == 0 ) {
                    return false;
                }

                if ( strMonth.length == 0 ) {
                    return false;
                }

                <%-- 数値属性チェック --%>
                if( strYear.match(/^\d*$/) == null ){
                    return false;
                }

                if( strMonth.match(/^\d*$/) == null ){
                    return false;
                }

                <%-- 数値範囲チェック --%>
                if ( !( 1 <= year && year <= 99 )) {
                    return false;
                }

                if ( !( 1 <= month && month <= 12 )) {
                    return false;
                }

                return true;

            }

            <%-- 受託者勘定処理年月 元号、年、月設定 --%>
            function setDateJtkshori( gengo, nen, tsuki) {

                <%-- 受託者勘定処理年月 取得 --%>
                jtkGengo = document.getElementById('drpID_Date_Jtkshori_Gengou');
                jtkNen = document.getElementById('txtID_Date_Jtkshori_Year');
                jtkTsuki = document.getElementById('drpID_Date_Jtkshori_Month');

                hdnJtkGengo = document.getElementById('hdnID_Date_Jtkshori_Gengo');
                hdnJtkTsuki = document.getElementById('hdnID_Date_JtkshoriTsuki_Candidate');

                <%-- 受託者勘定処理年月（元号）--%>
                jtkGengo.value = gengo;
                hdnJtkGengo.value = gengo;

                <%-- 受託者勘定処理年月（年）--%>
                jtkNen.value = nen;

                <%-- 受託者勘定処理年月（月）--%>
                jtkTsuki.value = tsuki;
                hdnJtkTsuki.value = tsuki;

            }

            <%-- 受託者勘定処理年月 隠しフィールド設定 --%>
            function setHdnJtkshori() {

            	<%-- 受託者勘定処理年月 取得 --%>
                jtkGengo = document.getElementById('drpID_Date_Jtkshori_Gengou').value;
                jtkTsuki = document.getElementById('drpID_Date_Jtkshori_Month').value;

                document.getElementById('hdnID_Date_Jtkshori_Gengo').value = jtkGengo;
                document.getElementById('hdnID_Date_JtkshoriTsuki_Candidate').value = jtkTsuki;

            }

        //-->
        </script>
        <script lang="JavaScript" type="text/javascript" src="<%= request.getContextPath() %>/js/ptncommon.js">
                <!--
                //-->
        </script>
    </head>
    <body onload="initTextFormat()">
        <parts:form modelAttribute="cr008_04Form" id="Form1" method="post">
            <%@ include file="/jsp/incCommonHidden.jsp" %>
            <%@ include file="/jsp/incHeaderArea.jsp" %>
            <div id="main_scroll_area">
            <div>
                <div class="header">
                    <div class="title">
                        <label id="lblTitle" class="title"><parts:message code="title.screenName"/></label>
                    </div>
                </div>
                <div class="help">
                    <%-- <parts:link id="HelpLink">
                        <font class="help">ヘルプ</font>
                    </parts:link> --%>
                    <a href="#" onclick="openNewWindow('<%= request.getContextPath() %>/help/main_cr008.html', false, false, false, 'width=800', 'height=500', false)">
                        <font class="help">ヘルプ</font>
                    </a>
                </div>
                <div class="main">
                    <parts:table id="infoArea" width="500px">
                        <!-- <div class="greeting"> -->
                            必要な項目を入力したうえで「送信」ボタンを押してください。
                        <!-- </div> -->
                    </parts:table>
                    <div class="buttons">
                        <parts:button id="btnID_Send" value="送信" title="送信" onclick="clearTextFormat();click_sendBtn();"/>
                        <parts:button id="btnBack" value="戻る" title="戻る" onclick="click_backBtn();"/>
                    </div>
                    <div class="reportDate">報告年月日：
                        <parts:dlabel path="txtID_Date_Report" />
                    </div>
                    <div class="status">
                        ステータス：
                        <div style="color:red;font-weight:bold;">
                            <parts:errors path="*" />
                        </div>
                    </div>
                    <parts:table id="editArea">
                     <parts:tr>
                     <td>
                        <div class="report">
                            <!-- 報告書の一行分(複数可) -->
                            <div align="center">
                                <div class="report_a_line">
                                    <!-- 出力用 -->
                                    <div class="item-output">
                                        <div><!-- 項目名 --> 顧客名</div>
                                        <div><!-- 値 -->
                                            <parts:text path="txtID_Name_Customer" id="txtID_Name_Customer" style="text-align:left;" maxlength="40" size="50" tabindex="-1" readonly="true" />
                                        </div>
                                    </div>
                                    <!-- 出力用 -->
                                    <div class="item-output">
                                        <div><!-- 項目名 --> 扱店名：</div>
                                        <div><!-- 値 -->
                                            <parts:text path="txtID_Name_Organization" id="txtID_Name_Organization" style="text-align:left;" maxlength="40" size="50" tabindex="-1" readonly="true" />
                                        </div>
                                    </div>
                                </div>
                                <!-- 報告書の一行分(複数可) -->
                                <div class="report_a_line">
                                    <!-- 入力用 -->
                                    <div class="item-output">
                                        <div><!-- 項目名 --> 公庫支店</div>
                                        <div><!-- 値 -->
                                            <parts:text path="txtID_Code_ShokanHonShiten" id="txtID_Code_ShokanHonShiten" style="text-align:center;" maxlength="2" size="2" tabindex="-1" readonly="true" />
                                        </div>
                                    </div>
                                    <!-- 出力用 -->
                                    <div class="item-output">
                                        <div><!-- 項目名 --> 扱店</div>
                                        <div><!-- 値 -->
                                            <parts:text path="txtID_Code_Organization" id="txtID_Code_Organization" style="text-align:center;" maxlength="4" size="4" tabindex="-1" readonly="true" />
                                        </div>
                                    </div>
                                    <!-- 出力用 -->
                                    <div class="item-output">
                                        <div><!-- 項目名 --> 店舗</div>
                                        <div><!-- 値 -->
                                            <parts:text path="txtID_Code_Tenpo" id="txtID_Code_Tenpo" style="text-align:center;" maxlength="3" size="3" tabindex="-1" readonly="true" />
                                        </div>
                                    </div>
                                    <!-- 入力用 -->
                                    <div class="item-output">
                                        <div><!-- 項目名 --> 年度</div>
                                        <div><!-- 値 -->
                                            <parts:text path="txtID_Year" id="txtID_Year" style="text-align:center;" maxlength="3" size="3" tabindex="-1" readonly="true" />
                                        </div>
                                    </div>
                                    <!-- 入力用 -->
                                    <div class="item-output">
                                        <div><!-- 項目名 --> 方式資金</div>
                                        <div><!-- 値 -->
                                            <parts:text path="txtID_Code_HoshikiShikin" id="txtID_Code_HoshikiShikin" style="text-align:center;" maxlength="2" size="2" tabindex="-1" readonly="true" />
                                        </div>
                                    </div>
                                    <!-- 入力用 -->
                                    <div class="item-output">
                                        <div><!-- 項目名 --> 番号</div>
                                        <div><!-- 値 -->
                                            <parts:text path="txtID_ID_Ringi" id="txtID_ID_Ringi" style="text-align:center;" maxlength="5" size="5" tabindex="-1" readonly="true" />
                                        </div>
                                    </div>
                                    <!-- 入力用 -->
                                    <div class="item-output">
                                        <div><!-- 項目名 --> 枝番</div>
                                        <div><!-- 値 -->
                                            <parts:text path="txtID_ID_RingiBranch" id="txtID_ID_RingiBranch" style="text-align:center;" maxlength="3" size="3" tabindex="-1" readonly="true" />
                                        </div>
                                    </div>
                                </div>
                                <!-- 報告書の一行分(複数可) -->
                                <div class="report_a_line">
                                    <!-- 入力用 -->
                                    <div class="item-input">
                                        <div><!-- 項目名 --> 入金日</div>
                                        <div><!-- 値 -->
                                            <parts:select path="drpID_Date_Nyukin_Gengou" id="drpID_Date_Nyukin_Gengou" style="color:#003399;"
                                                onchange='change_dateNyukin(
                                                    "${cr008_04Form.lblID_JtkshoriConfigMode}",
                                                    "${cr008_04Form.lblID_BizDate_Gengo}",
                                                    "${cr008_04Form.lblID_BizDate_Nen}",
                                                    "${cr008_04Form.lblID_BizDate_Tsuki}",
                                                    "${cr008_04Form.lblID_BizDate_PrevMonth_Gengo}",
                                                    "${cr008_04Form.lblID_BizDate_PrevMonth_Nen}",
                                                    "${cr008_04Form.lblID_BizDate_PrevMonth_Tsuki}")'>
                                                <parts:codeListOption categoryCode="00002" />
                                            </parts:select>
                                            <parts:text path="txtID_Date_Nyukin_Year" id="txtID_Date_Nyukin_Year" style="width:30px;text-align: center;" maxlength="2" size="2" cssClass="format-0padding"
                                                onkeyup='change_dateNyukin(
                                                    "${cr008_04Form.lblID_JtkshoriConfigMode}",
                                                    "${cr008_04Form.lblID_BizDate_Gengo}",
                                                    "${cr008_04Form.lblID_BizDate_Nen}",
                                                    "${cr008_04Form.lblID_BizDate_Tsuki}",
                                                    "${cr008_04Form.lblID_BizDate_PrevMonth_Gengo}",
                                                    "${cr008_04Form.lblID_BizDate_PrevMonth_Nen}",
                                                    "${cr008_04Form.lblID_BizDate_PrevMonth_Tsuki}")'/>年
                                            <parts:select path="drpID_Date_Nyukin_Month" id="drpID_Date_Nyukin_Month" style="color:#003399;"
                                                onchange='change_dateNyukin(
                                                    "${cr008_04Form.lblID_JtkshoriConfigMode}",
                                                    "${cr008_04Form.lblID_BizDate_Gengo}",
                                                    "${cr008_04Form.lblID_BizDate_Nen}",
                                                    "${cr008_04Form.lblID_BizDate_Tsuki}",
                                                    "${cr008_04Form.lblID_BizDate_PrevMonth_Gengo}",
                                                    "${cr008_04Form.lblID_BizDate_PrevMonth_Nen}",
                                                    "${cr008_04Form.lblID_BizDate_PrevMonth_Tsuki}")'>
                                                <parts:codeListOption categoryCode="00003" />
                                            </parts:select>月
                                            <parts:select path="drpID_Date_Nyukin_Day" id="drpID_Date_Nyukin_Day" style="color:#003399;"
                                                onchange='change_dateNyukin(
                                                    "${cr008_04Form.lblID_JtkshoriConfigMode}",
                                                    "${cr008_04Form.lblID_BizDate_Gengo}",
                                                    "${cr008_04Form.lblID_BizDate_Nen}",
                                                    "${cr008_04Form.lblID_BizDate_Tsuki}",
                                                    "${cr008_04Form.lblID_BizDate_PrevMonth_Gengo}",
                                                    "${cr008_04Form.lblID_BizDate_PrevMonth_Nen}",
                                                    "${cr008_04Form.lblID_BizDate_PrevMonth_Tsuki}")'>
                                                <parts:codeListOption categoryCode="00004" />
                                            </parts:select>日
                                        </div>
                                    </div>
                                    <!-- 入力用 -->
                                    <div class="item-input">
                                        <div>仮受金(一般口)受入額(円)</div>
                                        <div class="styleMoney">
                                            <parts:text path="txtID_M_KariukeIppanUkeire" id="txtID_M_KariukeIppanUkeire" style="text-align: right;" maxlength="11" size="15" cssClass="format-number" /><!-- 値 -->
                                        </div>
                                    </div>
                                </div>
                                <!-- 報告書の一行分(複数可) -->
                                <div class="report_a_line">
                                    <!-- 入力用 -->
                                    <div class="item-input">
                                        <div><!-- 項目名 --> 受託者勘定処理年月</div>
                                        <div><!-- 値 -->
                                            <parts:select path="drpID_Date_Jtkshori_Gengou" id="drpID_Date_Jtkshori_Gengou" style="color:#003399;"
                                                onchange="setHdnJtkshori()">
                                                <parts:codeListOption categoryCode="00002" />
                                            </parts:select>
                                            <parts:hidden path="hdnID_Date_Jtkshori_Gengo" id="hdnID_Date_Jtkshori_Gengo" value=""></parts:hidden>
                                            <c:if test='${cr008_04Form.lblID_JtkshoriConfigMode == "3"}'>
                                                <parts:text path="txtID_Date_Jtkshori_Year" id="txtID_Date_Jtkshori_Year" style="width:30px;text-align: center;"
                                                  maxlength="2" size="2" cssClass="format-0padding" />年
                                            </c:if>
                                            <c:if test='${cr008_04Form.lblID_JtkshoriConfigMode != "3"}'>
                                                <parts:text path="txtID_Date_Jtkshori_Year" id="txtID_Date_Jtkshori_Year" style="width:30px;text-align: center;"
                                                  maxlength="2" size="2" cssClass="format-0padding" tabindex="-1"/>年
                                            </c:if>
                                            <parts:select path="drpID_Date_Jtkshori_Month" id="drpID_Date_Jtkshori_Month" style="color:#003399;"
                                                onchange="setHdnJtkshori()">
                                                <parts:codeListOption categoryCode="00003" />
                                            </parts:select>
                                            <parts:hidden path="hdnID_Date_JtkshoriTsuki_Candidate" id="hdnID_Date_JtkshoriTsuki_Candidate" value=""></parts:hidden>月
                                        </div>
                                    </div>
                                    <!-- 入力用 -->
                                    <div class="item-input">
                                        <div><!-- 項目名 --> 送金年月日</div>
                                        <div><!-- 値 -->
                                            <parts:select path="drpID_Date_Sokin_Gengou" id="drpID_Date_Sokin_Gengou" style="color:#003399;">
                                                <parts:codeListOption categoryCode="00002" />
                                            </parts:select>
                                            <parts:text path="txtID_Date_Sokin_Year" id="txtID_Date_Sokin_Year" style="width:30px;text-align: center;" maxlength="2" size="2" cssClass="format-0padding" />年
                                            <parts:select path="drpID_Date_Sokin_Month" id="drpID_Date_Sokin_Month" style="color:#003399;">
                                                <parts:codeListOption categoryCode="00003" />
                                            </parts:select>月
                                            <parts:select path="drpID_Date_Sokin_Day" id="drpID_Date_Sokin_Day" style="color:#003399;">
                                                <parts:codeListOption categoryCode="00004" />
                                            </parts:select>日
                                        </div>
                                    </div>
                                    <div class="item-input">
                                        <div><!-- 項目名 --> 送金日番号</div>
                                        <div><!-- 値 -->
                                            <parts:text path="txtID_Code_Sokin" id="txtID_Code_Sokin" style="text-align:center;" maxlength="3" size="3"/>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        <!-- 報告書一枚終わり -->
                        </div>
                    </td>
                    </parts:tr>
                    </parts:table>
                </div>
            </div>
        </div>
        </parts:form><%@ include file="/jsp/incFooter.jsp"%>
    </body>
</html>