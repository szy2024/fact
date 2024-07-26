//==================================================================================================
// Project Name : 農林パートナーネット
// System Name  : JFC Partner Net
// Class Name   : se014_01DTO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/10/17 | 宮郷　慎之介          | 新規作成（H29年追加開発案件対応）
//==================================================================================================
package jp.go.jfc.partnernet.se014.se014_01.service;

import java.util.LinkedHashMap;

import jp.go.jfc.partnernet.pnfw.service.dto.PNBaseDTO;

/**
 * <pre>
 * このクラスはse014_01のDTOクラスです。
 * </pre>
 *
 * @author 宮郷　慎之介
 * @version 2.0.0
 */
public class Se014_01DTO extends PNBaseDTO {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 集計対象年月（年） */
    private String drpid_yg_shukeitaishoyear;
    /** 集計対象年月（月） */
    private String drpid_yg_shukeitaishomonth;
    /** 資金交付依頼ラジオボタン */
    private String rdoid_shikinkofu;
    /** 集計対象年月日（年） */
    private String drpid_ys_shukeitaishoyear;
    /** 集計対象年月日（月） */
    private String drpid_ys_shukeitaishomonth;
    /** 集計対象年月日（日） */
    private String drpid_ys_shukeitaishodate;
    /** 集計対象年月（年）_プルダウンリスト */
    private LinkedHashMap<String, Object> yg_shukeitaisho_year_pulldown_list;
    /** 集計対象年月（月）_プルダウンリスト */
    private LinkedHashMap<String, Object> yg_shukeitaisho_month_pulldown_list;
    /** 集計対象年月日（年）_プルダウンリスト */
    private LinkedHashMap<String, Object> ys_shukeitaisho_year_pulldown_list;
    /** 集計対象年月日（月）_プルダウンリスト */
    private LinkedHashMap<String, Object> ys_shukeitaisho_month_pulldown_list;
    /** 集計対象年月日（日）_プルダウンリスト */
    private LinkedHashMap<String, Object> ys_shukeitaisho_date_pulldown_list;
    /** ダウンロードファイルパス */
    private String download_filepath;

    /**
     * <pre>
     * コンストラクター。
     * </pre>
     *
     */
    public Se014_01DTO() {
        // Controller及びServiceでのインスタンス生成の為
    }

    /**
     * <pre>
     * コンストラクター。
     * 引数のDTOの中身を取得しセットします。
     * </pre>
     *
     * @param orig 設定元DTO
     * @throws Exception 例外
     */
    public Se014_01DTO(Se014_01DTO orig) {
        super(orig);
    }

    /**
     * 集計対象年月（年）を取得します。
     * @return 集計対象年月（年）
     */
    public String getDrpid_yg_shukeitaishoyear() {
        return drpid_yg_shukeitaishoyear;
    }

    /**
     * 集計対象年月（年）を設定します。
     * @param drpid_yg_shukeitaishoyear 集計対象年月（年）
     */
    public void setDrpid_yg_shukeitaishoyear(String drpid_yg_shukeitaishoyear) {
        this.drpid_yg_shukeitaishoyear = drpid_yg_shukeitaishoyear;
    }

    /**
     * 集計対象年月（月）を取得します。
     * @return 集計対象年月（月）
     */
    public String getDrpid_yg_shukeitaishomonth() {
        return drpid_yg_shukeitaishomonth;
    }

    /**
     * 集計対象年月（月）を設定します。
     * @param drpid_yg_shukeitaishomonth 集計対象年月（月）
     */
    public void setDrpid_yg_shukeitaishomonth(String drpid_yg_shukeitaishomonth) {
        this.drpid_yg_shukeitaishomonth = drpid_yg_shukeitaishomonth;
    }

    /**
     * 資金交付依頼ラジオボタンを取得します。
     * @return 資金交付依頼ラジオボタン
     */
    public String getRdoid_shikinkofu() {
        return rdoid_shikinkofu;
    }

    /**
     * 資金交付依頼ラジオボタンを設定します。
     * @param rdoid_shikinkofu 資金交付依頼ラジオボタン
     */
    public void setRdoid_shikinkofu(String rdoid_shikinkofu) {
        this.rdoid_shikinkofu = rdoid_shikinkofu;
    }

    /**
     * 集計対象年月日（年）を取得します。
     * @return 集計対象年月日（年）
     */
    public String getDrpid_ys_shukeitaishoyear() {
        return drpid_ys_shukeitaishoyear;
    }

    /**
     * 集計対象年月日（年）を設定します。
     * @param drpid_ys_shukeitaishoyear 集計対象年月日（年）
     */
    public void setDrpid_ys_shukeitaishoyear(String drpid_ys_shukeitaishoyear) {
        this.drpid_ys_shukeitaishoyear = drpid_ys_shukeitaishoyear;
    }

    /**
     * 集計対象年月日（月）を取得します。
     * @return 集計対象年月日（月）
     */
    public String getDrpid_ys_shukeitaishomonth() {
        return drpid_ys_shukeitaishomonth;
    }

    /**
     * 集計対象年月日（月）を設定します。
     * @param drpid_ys_shukeitaishomonth 集計対象年月日（月）
     */
    public void setDrpid_ys_shukeitaishomonth(String drpid_ys_shukeitaishomonth) {
        this.drpid_ys_shukeitaishomonth = drpid_ys_shukeitaishomonth;
    }

    /**
     * 集計対象年月日（日）を取得します。
     * @return 集計対象年月日（日）
     */
    public String getDrpid_ys_shukeitaishodate() {
        return drpid_ys_shukeitaishodate;
    }

    /**
     * 集計対象年月日（日）を設定します。
     * @param drpid_ys_shukeitaishodate 集計対象年月日（日）
     */
    public void setDrpid_ys_shukeitaishodate(String drpid_ys_shukeitaishodate) {
        this.drpid_ys_shukeitaishodate = drpid_ys_shukeitaishodate;
    }

    /**
     * 集計対象年月（年）_プルダウンリストを取得します。
     * @return 集計対象年月（年）_プルダウンリスト
     */
    public LinkedHashMap<String, Object> getYg_shukeitaisho_year_pulldown_list() {
        return yg_shukeitaisho_year_pulldown_list;
    }

    /**
     * 集計対象年月（年）_プルダウンリストを設定します。
     * @param yg_shukeitaisho_year_pulldown_list 集計対象年月（年）_プルダウンリスト
     */
    public void setYg_shukeitaisho_year_pulldown_list(
            LinkedHashMap<String, Object> yg_shukeitaisho_year_pulldown_list) {
        this.yg_shukeitaisho_year_pulldown_list = yg_shukeitaisho_year_pulldown_list;
    }

    /**
     * 集計対象年月（月）_プルダウンリストを取得します。
     * @return 集計対象年月（月）_プルダウンリスト
     */
    public LinkedHashMap<String, Object> getYg_shukeitaisho_month_pulldown_list() {
        return yg_shukeitaisho_month_pulldown_list;
    }

    /**
     * 集計対象年月（月）_プルダウンリストを設定します。
     * @param yg_shukeitaisho_month_pulldown_list 集計対象年月（月）_プルダウンリスト
     */
    public void setYg_shukeitaisho_month_pulldown_list(
            LinkedHashMap<String, Object> yg_shukeitaisho_month_pulldown_list) {
        this.yg_shukeitaisho_month_pulldown_list = yg_shukeitaisho_month_pulldown_list;
    }

    /**
     * 集計対象年月日（年）_プルダウンリストを取得します。
     * @return 集計対象年月日（年）_プルダウンリスト
     */
    public LinkedHashMap<String, Object> getYs_shukeitaisho_year_pulldown_list() {
        return ys_shukeitaisho_year_pulldown_list;
    }

    /**
     * 集計対象年月日（年）_プルダウンリストを設定します。
     * @param ys_shukeitaisho_year_pulldown_list 集計対象年月日（年）_プルダウンリスト
     */
    public void setYs_shukeitaisho_year_pulldown_list(
            LinkedHashMap<String, Object> ys_shukeitaisho_year_pulldown_list) {
        this.ys_shukeitaisho_year_pulldown_list = ys_shukeitaisho_year_pulldown_list;
    }

    /**
     * 集計対象年月日（月）_プルダウンリストを取得します。
     * @return 集計対象年月日（月）_プルダウンリスト
     */
    public LinkedHashMap<String, Object> getYs_shukeitaisho_month_pulldown_list() {
        return ys_shukeitaisho_month_pulldown_list;
    }

    /**
     * 集計対象年月日（月）_プルダウンリストを設定します。
     * @param ys_shukeitaisho_month_pulldown_list 集計対象年月日（月）_プルダウンリスト
     */
    public void setYs_shukeitaisho_month_pulldown_list(
            LinkedHashMap<String, Object> ys_shukeitaisho_month_pulldown_list) {
        this.ys_shukeitaisho_month_pulldown_list = ys_shukeitaisho_month_pulldown_list;
    }

    /**
     * 集計対象年月日（日）_プルダウンリストを取得します。
     * @return 集計対象年月日（日）_プルダウンリスト
     */
    public LinkedHashMap<String, Object> getYs_shukeitaisho_date_pulldown_list() {
        return ys_shukeitaisho_date_pulldown_list;
    }

    /**
     * 集計対象年月日（日）_プルダウンリストを設定します。
     * @param ys_shukeitaisho_date_pulldown_list 集計対象年月日（日）_プルダウンリスト
     */
    public void setYs_shukeitaisho_date_pulldown_list(
            LinkedHashMap<String, Object> ys_shukeitaisho_date_pulldown_list) {
        this.ys_shukeitaisho_date_pulldown_list = ys_shukeitaisho_date_pulldown_list;
    }

    /**
     * ダウンロードファイルパスを取得します。
     * @return ダウンロードファイルパス
     */
    public String getDownload_filepath() {
        return download_filepath;
    }

    /**
     * ダウンロードファイルパスを設定します。
     * @param download_filepath ダウンロードファイルパス
     */
    public void setDownload_filepath(String download_filepath) {
        this.download_filepath = download_filepath;
    }
}