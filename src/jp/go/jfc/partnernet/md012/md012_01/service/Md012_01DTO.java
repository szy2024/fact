//==================================================================================================
// Project Name : 農林パートナーネット
// System Name  : JFC Partner Net
// Class Name   : Md012_01DTO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/09/15 | 木村　しのぶ          | 新規作成（H29年追加開発案件対応）
//==================================================================================================
package jp.go.jfc.partnernet.md012.md012_01.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import jp.go.jfc.partnernet.pnfw.service.dto.PNBaseDTO;

/**
 * <pre>
 * このクラスはMd012_01のDTOクラスです。
 * </pre>
 *
 * @author 木村　しのぶ
 * @version 2.0.0
 */
public class Md012_01DTO extends PNBaseDTO {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 報告年月日 */
    private String lblID_Date_Report;
    /** 報告書番号 */
    private String lblID_Report;
    /** 報告時分秒 */
    private String lblID_Time_Report;
    /** 処理モード */
    private String lblID_ProcessMode;
    /** 検索条件_報告書種別 */
    private String lblID_Keep_DataCode;
    /** 検索条件_検索タイプ */
    private String lblID_Keep_SearchType;
    /** 扱店名 */
    private String lblID_Name_Organization;
    /** 扱店 */
    private String lblID_Code_Organization;
    /** 店舗 */
    private String lblID_Code_Tenpo;
    /** 履歴番号 */
    private String lblID_History;
    /** 更新日時 */
    private Timestamp lblID_DateTime_Update;
    /** 明細リスト */
    private List<Md012_01M1DTO> MEISAI_LIST = new ArrayList<Md012_01M1DTO>();
    /** データ取得件数 */
    private int dataCount;

    /**
     * <pre>
     * コンストラクター。
     * </pre>
     *
     */
    public Md012_01DTO() {
        // Controller及びServiceでのインスタンス生成の為
    }

    /**
     * <pre>
     * コンストラクター。
     * 引数のDTOの中身を取得しセットします。
     * </pre>
     *
     * @param orig
     *            設定元DTO
     * @throws Exception
     *             例外
     */
    public Md012_01DTO(Md012_01DTO orig) {
        super(orig);
    }

    /**
     * 報告年月日を取得します。
     *
     * @return 報告年月日
     */
    public String getLblID_Date_Report() {
        return lblID_Date_Report;
    }

    /**
     * 報告年月日を設定します。
     *
     * @param lblid_date_report
     *            報告年月日
     */
    public void setLblID_Date_Report(String lblid_date_report) {
        this.lblID_Date_Report = lblid_date_report;
    }

    /**
     * 報告書番号を取得します。
     *
     * @return 報告書番号
     */
    public String getLblID_Report() {
        return lblID_Report;
    }

    /**
     * 報告書番号を設定します。
     *
     * @param lblid_report
     *            報告書番号
     */
    public void setLblID_Report(String lblid_report) {
        this.lblID_Report = lblid_report;
    }

    /**
     * 報告時分秒を取得します。
     *
     * @return 報告時分秒
     */
    public String getLblID_Time_Report() {
        return lblID_Time_Report;
    }

    /**
     * 報告時分秒を設定します。
     *
     * @param lblid_time_report
     *            報告時分秒
     */
    public void setLblID_Time_Report(String lblid_time_report) {
        this.lblID_Time_Report = lblid_time_report;
    }

    /**
     * 操作選択を取得します。
     *
     * @return 操作選択
     */
    public String getLblID_ProcessMode() {
        return lblID_ProcessMode;
    }

    /**
     * 操作選択を設定します。
     *
     * @param lblid_ProcessMode
     *            操作選択
     */
    public void setLblID_ProcessMode(String lblid_ProcessMode) {
        this.lblID_ProcessMode = lblid_ProcessMode;
    }

    /**
     * 検索条件_報告書種別を取得します。
     *
     * @return 検索条件_報告書種別
     */
    public String getLblID_Keep_DataCode() {
        return lblID_Keep_DataCode;
    }

    /**
     * 検索条件_報告書種別を設定します。
     *
     * @param lblID_keep_datacode
     *            検索条件_報告書種別
     */
    public void setLblID_Keep_DataCode(String lblID_keep_datacode) {
        this.lblID_Keep_DataCode = lblID_keep_datacode;
    }

    /**
     * 検索条件_検索タイプを取得します。
     *
     * @return 検索条件_検索タイプ
     */
    public String getLblID_Keep_SearchType() {
        return lblID_Keep_SearchType;
    }

    /**
     * 検索条件_検索タイプを設定します。
     *
     * @param lblID_Keep_SearchType
     *            検索条件_検索タイプ
     */
    public void setLblID_Keep_SearchType(String lblID_Keep_SearchType) {
        this.lblID_Keep_SearchType = lblID_Keep_SearchType;
    }

    /**
     * 扱店名を取得します。
     *
     * @return 扱店名
     */
    public String getLblID_Name_Organization() {
        return lblID_Name_Organization;
    }

    /**
     * 扱店名を設定します。
     *
     * @param lblid_name_organization
     *            扱店名
     */
    public void setLblID_Name_Organization(String lblid_name_organization) {
        this.lblID_Name_Organization = lblid_name_organization;
    }

    /**
     * 扱店を取得します。
     *
     * @return 扱店
     */
    public String getLblID_Code_Organization() {
        return lblID_Code_Organization;
    }

    /**
     * 扱店を設定します。
     *
     * @param lblid_code_organization
     *            扱店
     */
    public void setLblID_Code_Organization(String lblid_code_organization) {
        this.lblID_Code_Organization = lblid_code_organization;
    }

    /**
     * 店舗を取得します。
     *
     * @return 店舗
     */
    public String getLblID_Code_Tenpo() {
        return lblID_Code_Tenpo;
    }

    /**
     * 店舗を設定します。
     *
     * @param lblid_code_tenpo
     *            店舗
     */
    public void setLblID_Code_Tenpo(String lblid_code_tenpo) {
        this.lblID_Code_Tenpo = lblid_code_tenpo;
    }

    /**
     * 履歴番号を取得します。
     *
     * @return 履歴番号
     */
    public String getLblID_History() {
        return lblID_History;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param lblid_history
     *            履歴番号
     */
    public void setLblID_History(String lblid_history) {
        this.lblID_History = lblid_history;
    }

    /**
     * 更新日時を取得します。
     *
     * @return 更新日時
     */
    public Timestamp getLblID_DateTime_Update() {
        return lblID_DateTime_Update;
    }

    /**
     * 更新日時を設定します。
     *
     * @param timestamp
     *            更新日時
     */
    public void setLblID_DateTime_Update(Timestamp timestamp) {
        this.lblID_DateTime_Update = timestamp;
    }

    /**
     * 明細リストを取得します。
     *
     * @return 明細リスト
     */
    public java.util.List<Md012_01M1DTO> getMEISAI_LIST() {
        return MEISAI_LIST;
    }

    /**
     * 明細リストを設定します。
     *
     * @param meisai_List
     *            明細リスト
     */
    public void setMEISAI_LIST(java.util.List<Md012_01M1DTO> meisai_List) {
        MEISAI_LIST = meisai_List;
    }

    /**
     * データ取得件数を取得します。
     *
     * @return データ取得件数
     */
    public int getDataCount() {
        return dataCount;
    }

    /**
     * データ取得件数を設定します。
     *
     * @param dataCount
     *            データ取得件数
     */
    public void setDataCount(int dataCount) {
        this.dataCount = dataCount;
    }

}