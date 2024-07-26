//==================================================================================================
// Project Name : 農林パートナーネット
// System Name  : JFC Partner Net
// Class Name   : Md011_01Form
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/09/15 | 林　晃平              | 新規作成（H29年追加開発案件対応）
//==================================================================================================
package jp.go.jfc.partnernet.md011.md011_01.web;

import java.util.LinkedHashMap;
import java.util.List;

import jp.go.jfc.partnernet.md011.md011_01.service.Md011_01M1DTO;
import jp.go.jfc.partnernet.pnfw.web.common.PNPagingTable;
import jp.go.jfc.partnernet.pnfw.web.common.PNPagingTableSerial;
import jp.go.jfc.partnernet.pnfw.web.form.PNBaseForm;

//import com.fujitsu.PNfw.web.common.PNPagingTableMemory;

/**
 * <pre>
 * このクラスはmd011_01のFormクラスです。
 * </pre>
 *
 * @author 林　晃平
 * @version 2.0.0
 */
public class Md011_01Form extends PNBaseForm {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 資金交付依頼 */
    private PNPagingTable<Md011_01M1DTO> md011_01m1Table = new PNPagingTableSerial<Md011_01M1DTO>("md011_01m1Table");
    /** メッセージＩＤ */
    private String lblMessageID;
    /** 指定交付日（年） */
    private String drpID_ShiteiKofuYear;
    /** 指定交付日（月） */
    private String drpID_ShiteiKofuMonth;
    /** 指定交付日（日） */
    private String drpID_ShiteiKofuDate;
    /** 報告書番号 */
    private String lblID_Report;
    /** 操作選択 */
    private String lblID_OperationSelect;
    /** 検索条件_支店 */
    private String lblID_Keep_Code_KoukoShiten;
    /** 検索条件_扱店 */
    private String lblID_Keep_Code_Organization;
    /** 検索条件_店舗 */
    private String lblID_Keep_Code_Tenpo;
    /** 検索条件_年度 */
    private String lblID_Keep_Year;
    /** 検索条件_方式資金 */
    private String lblID_Keep_Kubun_Hoshiki;
    /** 検索条件_番号 */
    private String lblID_Keep_ID_Ringi;
    /** 検索条件_枝番 */
    private String lblID_Keep_ID_RingiBranch;
    /** 検索条件_報告書種別 */
    private String lblID_Keep_DataCode;
    /** 指定交付日（年）_プルダウンリスト */
    private LinkedHashMap<String, Object> SHITEIKOHU_YEAR_PULLDOWN_LIST;
    /** 指定交付日（月）_プルダウンリスト */
    private LinkedHashMap<String, Object> SHITEIKOHU_MONTH_PULLDOWN_LIST;
    /** 指定交付日（日）_プルダウンリスト */
    private LinkedHashMap<String, Object> SHITEIKOHU_DATE_PULLDOWN_LIST;
    /** 履歴番号 */
    private String lblID_History;
    /** 扱店名 */
    private String lblID_Name_Organization;
    /** 扱店 */
    private String lblID_Code_Organization;
    /** 店舗 */
    private String lblID_Code_Tenpo;
    /** 更新日時 */
    private java.sql.Timestamp lblID_DateTime_Update;
    /** 報告書番号 */
    private String ID_Report;
    /** 履歴番号 */
    private String ID_History;
    /** 資金交付依頼明細一覧 */
    private List<Md011_01M1DTO> MEISAI_LIST;
    /** 処理モード */
    private String processMode;
    /** 更新済フラグ */
    private String lblID_Flag_Koushinzumi;
    /** 初期表示時刻 */
    private String lblID_InitDispTime;
    /** 退避指定交付日 */
    private String lblID_Keep_ShiteiKofu;

    /**
     * 資金交付依頼を取得します。
     * @return 資金交付依頼
     */
    public PNPagingTable<Md011_01M1DTO> getMd011_01m1Table() {
        return md011_01m1Table;
    }

    /**
     * 資金交付依頼を設定します。
     * @param md011_01m1Table 資金交付依頼
     */
    public void setMd011_01m1Table(PNPagingTable<Md011_01M1DTO> md011_01m1Table) {
        this.md011_01m1Table = md011_01m1Table;
    }

    /**
     * 資金交付依頼テーブルレコードを取得します。
     * @return 資金交付依頼テーブル
     */
    public List<Md011_01M1DTO> getMd011_01m1TableRecord() {
        return getMd011_01m1Table().getRecordList();
    }

    /**
     * メッセージＩＤを取得します。
     * @return メッセージＩＤ
     */
    public String getLblMessageID() {
        return lblMessageID;
    }

    /**
     * メッセージＩＤを設定します。
     * @param lblMessageID メッセージＩＤ
     */
    public void setLblMessageID(String lblMessageID) {
        this.lblMessageID = lblMessageID;
    }

    /**
     * 指定交付日（年）を取得します。
     * @return 指定交付日（年）
     */
    public String getDrpID_ShiteiKofuYear() {
        return drpID_ShiteiKofuYear;
    }

    /**
     * 指定交付日（年）を設定します。
     * @param drpID_ShiteiKofuYear 指定交付日（年）
     */
    public void setDrpID_ShiteiKofuYear(String drpID_ShiteiKofuYear) {
        this.drpID_ShiteiKofuYear = drpID_ShiteiKofuYear;
    }

    /**
     * 指定交付日（月）を取得します。
     * @return 指定交付日（月）
     */
    public String getDrpID_ShiteiKofuMonth() {
        return drpID_ShiteiKofuMonth;
    }

    /**
     * 指定交付日（月）を設定します。
     * @param drpID_ShiteiKofuMonth 指定交付日（月）
     */
    public void setDrpID_ShiteiKofuMonth(String drpID_ShiteiKofuMonth) {
        this.drpID_ShiteiKofuMonth = drpID_ShiteiKofuMonth;
    }

    /**
     * 指定交付日（日）を取得します。
     * @return 指定交付日（日）
     */
    public String getDrpID_ShiteiKofuDate() {
        return drpID_ShiteiKofuDate;
    }

    /**
     * 指定交付日（日）を設定します。
     * @param drpID_ShiteiKofuDate 指定交付日（日）
     */
    public void setDrpID_ShiteiKofuDate(String drpID_ShiteiKofuDate) {
        this.drpID_ShiteiKofuDate = drpID_ShiteiKofuDate;
    }

    /**
     * 報告書番号を取得します。
     * @return 報告書番号
     */
    public String getLblID_Report() {
        return lblID_Report;
    }

    /**
     * 報告書番号を設定します。
     * @param lblID_Report 報告書番号
     */
    public void setLblID_Report(String lblID_Report) {
        this.lblID_Report = lblID_Report;
    }

    /**
     * 操作選択を取得します。
     * @return 操作選択
     */
    public String getLblID_OperationSelect() {
        return lblID_OperationSelect;
    }

    /**
     * 操作選択を設定します。
     * @param lblID_OperationSelect 操作選択
     */
    public void setLblID_OperationSelect(String lblID_OperationSelect) {
        this.lblID_OperationSelect = lblID_OperationSelect;
    }

    /**
     * 検索条件_支店を取得します。
     * @return 検索条件_支店
     */
    public String getLblID_Keep_Code_KoukoShiten() {
        return lblID_Keep_Code_KoukoShiten;
    }

    /**
     * 検索条件_支店を設定します。
     * @param lblID_Keep_Code_KoukoShiten 検索条件_支店
     */
    public void setLblID_Keep_Code_KoukoShiten(String lblID_Keep_Code_KoukoShiten) {
        this.lblID_Keep_Code_KoukoShiten = lblID_Keep_Code_KoukoShiten;
    }

    /**
     * 検索条件_扱店を取得します。
     * @return 検索条件_扱店
     */
    public String getLblID_Keep_Code_Organization() {
        return lblID_Keep_Code_Organization;
    }

    /**
     * 検索条件_扱店を設定します。
     * @param lblID_Keep_Code_Organization 検索条件_扱店
     */
    public void setLblID_Keep_Code_Organization(String lblID_Keep_Code_Organization) {
        this.lblID_Keep_Code_Organization = lblID_Keep_Code_Organization;
    }

    /**
     * 検索条件_店舗を取得します。
     * @return 検索条件_店舗
     */
    public String getLblID_Keep_Code_Tenpo() {
        return lblID_Keep_Code_Tenpo;
    }

    /**
     * 検索条件_店舗を設定します。
     * @param lblID_Keep_Code_Tenpo 検索条件_店舗
     */
    public void setLblID_Keep_Code_Tenpo(String lblID_Keep_Code_Tenpo) {
        this.lblID_Keep_Code_Tenpo = lblID_Keep_Code_Tenpo;
    }

    /**
     * 検索条件_年度を取得します。
     * @return 検索条件_年度
     */
    public String getLblID_Keep_Year() {
        return lblID_Keep_Year;
    }

    /**
     * 検索条件_年度を設定します。
     * @param lblID_Keep_Year 検索条件_年度
     */
    public void setLblID_Keep_Year(String lblID_Keep_Year) {
        this.lblID_Keep_Year = lblID_Keep_Year;
    }

    /**
     * 検索条件_方式資金を取得します。
     * @return 検索条件_方式資金
     */
    public String getLblID_Keep_Kubun_Hoshiki() {
        return lblID_Keep_Kubun_Hoshiki;
    }

    /**
     * 検索条件_方式資金を設定します。
     * @param lblID_Keep_Kubun_Hoshiki 検索条件_方式資金
     */
    public void setLblID_Keep_Kubun_Hoshiki(String lblID_Keep_Kubun_Hoshiki) {
        this.lblID_Keep_Kubun_Hoshiki = lblID_Keep_Kubun_Hoshiki;
    }

    /**
     * 検索条件_番号を取得します。
     * @return 検索条件_番号
     */
    public String getLblID_Keep_ID_Ringi() {
        return lblID_Keep_ID_Ringi;
    }

    /**
     * 検索条件_番号を設定します。
     * @param lblID_Keep_ID_Ringi 検索条件_番号
     */
    public void setLblID_Keep_ID_Ringi(String lblID_Keep_ID_Ringi) {
        this.lblID_Keep_ID_Ringi = lblID_Keep_ID_Ringi;
    }

    /**
     * 検索条件_枝番を取得します。
     * @return 検索条件_枝番
     */
    public String getLblID_Keep_ID_RingiBranch() {
        return lblID_Keep_ID_RingiBranch;
    }

    /**
     * 検索条件_枝番を設定します。
     * @param lblID_Keep_ID_RingiBranch 検索条件_枝番
     */
    public void setLblID_Keep_ID_RingiBranch(String lblID_Keep_ID_RingiBranch) {
        this.lblID_Keep_ID_RingiBranch = lblID_Keep_ID_RingiBranch;
    }

    /**
     * 検索条件_報告書種別を取得します。
     * @return 検索条件_報告書種別
     */
    public String getLblID_Keep_DataCode() {
        return lblID_Keep_DataCode;
    }

    /**
     * 検索条件_報告書種別を設定します。
     * @param lblID_Keep_DataCode 検索条件_報告書種別
     */
    public void setLblID_Keep_DataCode(String lblID_Keep_DataCode) {
        this.lblID_Keep_DataCode = lblID_Keep_DataCode;
    }

    /**
     * 指定交付日（年）_プルダウンリストを取得します。
     * @return 指定交付日（年）_プルダウンリスト
     */
    public LinkedHashMap<String, Object> getSHITEIKOHU_YEAR_PULLDOWN_LIST() {
        return SHITEIKOHU_YEAR_PULLDOWN_LIST;
    }

    /**
     * 指定交付日（年）_プルダウンリストを設定します。
     * @param SHITEIKOHU_YEAR_PULLDOWN_LIST 指定交付日（年）_プルダウンリスト
     */
    public void setSHITEIKOHU_YEAR_PULLDOWN_LIST(LinkedHashMap<String, Object> SHITEIKOHU_YEAR_PULLDOWN_LIST) {
        this.SHITEIKOHU_YEAR_PULLDOWN_LIST = SHITEIKOHU_YEAR_PULLDOWN_LIST;
    }

    /**
     * 指定交付日（月）_プルダウンリストを取得します。
     * @return 指定交付日（月）_プルダウンリスト
     */
    public LinkedHashMap<String, Object> getSHITEIKOHU_MONTH_PULLDOWN_LIST() {
        return SHITEIKOHU_MONTH_PULLDOWN_LIST;
    }

    /**
     * 指定交付日（月）_プルダウンリストを設定します。
     * @param SHITEIKOHU_MONTH_PULLDOWN_LIST 指定交付日（月）_プルダウンリスト
     */
    public void setSHITEIKOHU_MONTH_PULLDOWN_LIST(LinkedHashMap<String, Object> SHITEIKOHU_MONTH_PULLDOWN_LIST) {
        this.SHITEIKOHU_MONTH_PULLDOWN_LIST = SHITEIKOHU_MONTH_PULLDOWN_LIST;
    }

    /**
     * 指定交付日（日）_プルダウンリストを取得します。
     * @return 指定交付日（日）_プルダウンリスト
     */
    public LinkedHashMap<String, Object> getSHITEIKOHU_DATE_PULLDOWN_LIST() {
        return SHITEIKOHU_DATE_PULLDOWN_LIST;
    }

    /**
     * 指定交付日（日）_プルダウンリストを設定します。
     * @param SHITEIKOHU_DATE_PULLDOWN_LIST 指定交付日（日）_プルダウンリスト
     */
    public void setSHITEIKOHU_DATE_PULLDOWN_LIST(LinkedHashMap<String, Object> SHITEIKOHU_DATE_PULLDOWN_LIST) {
        this.SHITEIKOHU_DATE_PULLDOWN_LIST = SHITEIKOHU_DATE_PULLDOWN_LIST;
    }

    /**
     * 報告書番号を取得します。
     * @return 報告書番号
     */
    public String getID_Report() {
        return ID_Report;
    }

    /**
     * 報告書番号を設定します。ID_History
     * @param ID_Report 報告書番号
     */
    public void setID_Report(String ID_Report) {
        this.ID_Report = ID_Report;
    }

    /**
     * 報告書履歴番号を取得します。
     * @return 報告書履歴番号
     */
    public String getID_History() {
        return ID_History;
    }

    /**
     * 報告書履歴番号を設定します。
     * @param ID_History 報告書履歴番号
     */
    public void setID_History(String ID_History) {
        this.ID_History = ID_History;
    }

    /**
     * 履歴番号を取得します。
     * @return 履歴番号
     */
    public String getLblID_History() {
        return lblID_History;
    }

    /**
     * 履歴番号を設定します。
     * @param lblID_History 履歴番号
     */
    public void setLblID_History(String lblID_History) {
        this.lblID_History = lblID_History;
    }

    /**
     * 扱店名を取得します。
     * @return 扱店名
     */
    public String getLblID_Name_Organization() {
        return lblID_Name_Organization;
    }

    /**
     * 扱店名を設定します。
     * @param lblID_Name_Organization 扱店名
     */
    public void setLblID_Name_Organization(String lblID_Name_Organization) {
        this.lblID_Name_Organization = lblID_Name_Organization;
    }

    /**
     * 扱店を取得します。
     * @return 扱店
     */
    public String getLblID_Code_Organization() {
        return lblID_Code_Organization;
    }

    /**
     * 扱店を設定します。
     * @param lblID_Code_Organization 扱店
     */
    public void setLblID_Code_Organization(String lblID_Code_Organization) {
        this.lblID_Code_Organization = lblID_Code_Organization;
    }

    /**
     * 店舗を取得します。
     * @return 店舗
     */
    public String getLblID_Code_Tenpo() {
        return lblID_Code_Tenpo;
    }

    /**
     * 店舗を設定します。
     * @param lblID_Code_Tenpo 店舗
     */
    public void setLblID_Code_Tenpo(String lblID_Code_Tenpo) {
        this.lblID_Code_Tenpo = lblID_Code_Tenpo;
    }

    /**
     * 更新日時を取得します。
     * @return 更新日時
     */
    public java.sql.Timestamp getLblID_DateTime_Update() {
        return lblID_DateTime_Update;
    }

    /**
     * 更新日時を設定します。
     * @param lblID_DateTime_Update 更新日時
     */
    public void setLblID_DateTime_Update(java.sql.Timestamp lblID_DateTime_Update) {
        this.lblID_DateTime_Update = lblID_DateTime_Update;
    }

    /**
     * 資金交付依頼明細一覧を取得します。
     *
     * @return 資金交付依頼明細一覧
     */
    public List<Md011_01M1DTO> getMEISAI_LIST() {
        return MEISAI_LIST;
    }

    /**
     * 資金交付依頼明細一覧を設定します。
     *
     * @param MEISAI_LIST 資金交付依頼明細一覧
     */
    public void setMEISAI_LIST(List<Md011_01M1DTO> MEISAI_LIST) {
        this.MEISAI_LIST = MEISAI_LIST;
    }

    /**
     * 処理モードを取得します。
     * @return 処理モード
     */
    public String getProcessMode() {
        return processMode;
    }

    /**
     * 処理モードを設定します。
     * @param processMode 処理モード
     */
    public void setProcessMode(String processMode) {
        this.processMode = processMode;
    }

    /**
     * 更新済フラグを取得します。
     * @return 更新済フラグ
     */
    public String getLblID_Flag_Koushinzumi() {
        return lblID_Flag_Koushinzumi;
    }

    /**
     * 更新済フラグを設定します。
     * @param lblID_Flag_Koushinzumi 更新済フラグ
     */
    public void setLblID_Flag_Koushinzumi(String lblID_Flag_Koushinzumi) {
        this.lblID_Flag_Koushinzumi = lblID_Flag_Koushinzumi;
    }

    /**
     * 初期表示時刻を取得します。
     * @return 初期表示時刻
     */
    public String getLblID_InitDispTime() {
        return lblID_InitDispTime;
    }

    /**
     * 初期表示時刻を設定します。
     * @param lblID_InitDispTime 初期表示時刻
     */
    public void setLblID_InitDispTime(String lblID_InitDispTime) {
        this.lblID_InitDispTime = lblID_InitDispTime;
    }

    /**
     * 退避指定交付日を取得します。
     * @return 退避指定交付日
     */
    public String getLblID_Keep_ShiteiKofu() {
        return lblID_Keep_ShiteiKofu;
    }

    /**
     * 退避指定交付日を設定します。
     * @param lblID_Keep_ShiteiKofu 退避指定交付日
     */
    public void setLblID_Keep_ShiteiKofu(String lblID_Keep_ShiteiKofu) {
        this.lblID_Keep_ShiteiKofu = lblID_Keep_ShiteiKofu;
    }

}