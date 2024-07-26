//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se006_16ResultDataEntity
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/10/05 | 百々　諒馬            | H29年追加開発案件対応
//==================================================================================================
package jp.go.jfc.partnernet.se006.se006_16.dao;

import jp.go.jfc.partnernet.pnfw.dao.entity.PNBaseEntity;

/**
 * <pre>
 * このクラスはSe006_16ResultDataDAOのEntityクラスです。
 * </pre>
 *
 * @author 百々　諒馬
 * @version 2.0.0
 */
public class Se006_16ResultDataEntity extends PNBaseEntity {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /**
     * 履歴番号を取得します。
     * @return 履歴番号
     */
    public String getID_History() {
        return (String)getValue("ID_History");
    }

    /**
     * 履歴番号を設定します。
     * @param ID_History 履歴番号
     */
    public void setID_History(String ID_History) {
        setValue("ID_History", ID_History);
    }

    /**
     * 報告書番号を取得します。
     * @return 報告書番号
     */
    public String getID_Report() {
        return (String)getValue("ID_Report");
    }

    /**
     * 報告書番号を設定します。
     * @param ID_Report 報告書番号
     */
    public void setID_Report(String ID_Report) {
        setValue("ID_Report", ID_Report);
    }

    /**
     * 扱店コードを取得します。
     * @return 扱店コード
     */
    public String getCode_Organization() {
        return (String)getValue("Code_Organization");
    }

    /**
     * 扱店コードを設定します。
     * @param Code_Organization 扱店コード
     */
    public void setCode_Organization(String Code_Organization) {
        setValue("Code_Organization", Code_Organization);
    }

    /**
     * 店舗コードを取得します。
     * @return 店舗コード
     */
    public String getCode_Tenpo() {
        return (String)getValue("Code_Tenpo");
    }

    /**
     * 店舗コードを設定します。
     * @param Code_Tenpo 店舗コード
     */
    public void setCode_Tenpo(String Code_Tenpo) {
        setValue("Code_Tenpo", Code_Tenpo);
    }

    /**
     * 報告年月日を取得します。
     *
     * @return 報告年月日
     */
    public String getDate_Report() {
        return (String)getValue("Date_Report");
    }

    /**
     * 報告年月日を設定します。
     *
     * @param Date_Report
     *            報告年月日
     */
    public void setDate_Report(String Date_Report) {
        setValue("Date_Report", Date_Report);
    }

    /**
     * 包括委任状数量を取得します。
     * @return 包括委任状数量
     */
    public Integer getSu_HokatsuInin() {
        return (Integer)getValue("Su_HokatsuInin");
    }

    /**
     * 包括委任状数量を設定します。
     * @param Su_HokatsuInin 包括委任状数量
     */
    public void setSu_HokatsuInin(Integer Su_HokatsuInin) {
        setValue("Su_HokatsuInin", Su_HokatsuInin);
    }

    /**
     * 現在事項一部証明書数量を取得します。
     * @return 現在事項一部証明書数量
     */
    public Integer getSu_GenzaiJiko() {
        return (Integer)getValue("Su_GenzaiJiko");
    }

    /**
     * 現在事項一部証明書数量を設定します。
     * @param Su_GenzaiJiko 現在事項一部証明書数量
     */
    public void setSu_GenzaiJiko(Integer Su_GenzaiJiko) {
        setValue("Su_GenzaiJiko", Su_GenzaiJiko);
    }

    /**
     * 印鑑証明書数量を取得します。
     * @return 印鑑証明書数量
     */
    public Integer getSu_InkanShohmei() {
        return (Integer)getValue("Su_InkanShohmei");
    }

    /**
     * 印鑑証明書数量を設定します。
     * @param Su_InkanShohmei 印鑑証明書数量
     */
    public void setSu_InkanShohmei(Integer Su_InkanShohmei) {
        setValue("Su_InkanShohmei", Su_InkanShohmei);
    }

    /**
     * 変更抄本数量を取得します。
     * @return 変更抄本数量
     */
    public Integer getSu_HenkoShohhon() {
        return (Integer)getValue("Su_HenkoShohhon");
    }

    /**
     * 変更抄本数量を設定します。
     * @param Su_HenkoShohhon 変更抄本数量
     */
    public void setSu_HenkoShohhon(Integer Su_HenkoShohhon) {
        setValue("Su_HenkoShohhon", Su_HenkoShohhon);
    }

    /**
     * 新閉鎖謄本数量を取得します。
     * @return 新閉鎖謄本数量
     */
    public Integer getSu_SinHeisa() {
        return (Integer)getValue("Su_SinHeisa");
    }

    /**
     * 新閉鎖謄本数量を設定します。
     * @param Su_SinHeisa 新閉鎖謄本数量
     */
    public void setSu_SinHeisa(Integer Su_SinHeisa) {
        setValue("Su_SinHeisa", Su_SinHeisa);
    }

    /**
     * 旧閉鎖抄本数量を取得します。
     * @return 旧閉鎖抄本数量
     */
    public Integer getSu_KyuHeisa() {
        return (Integer)getValue("Su_KyuHeisa");
    }

    /**
     * 旧閉鎖抄本数量を設定します。
     * @param Su_KyuHeisa 旧閉鎖抄本数量
     */
    public void setSu_KyuHeisa(Integer Su_KyuHeisa) {
        setValue("Su_KyuHeisa", Su_KyuHeisa);
    }

    /**
     * 閉鎖事項全部証明書数量を取得します。
     * @return 閉鎖事項全部証明書数量
     */
    public Integer getSu_HeisaJiko() {
        return (Integer)getValue("Su_HeisaJiko");
    }

    /**
     * 閉鎖事項全部証明書数量を設定します。
     * @param Su_HeisaJiko 閉鎖事項全部証明書数量
     */
    public void setSu_HeisaJiko(Integer Su_HeisaJiko) {
        setValue("Su_HeisaJiko", Su_HeisaJiko);
    }

    /**
     * 至急発行フラグを取得します。
     * @return 至急発行フラグ
     */
    public String getFlag_ShikyuHakko() {
        return (String)getValue("Flag_ShikyuHakko");
    }

    /**
     * 至急発行フラグを設定します。
     * @param Flag_ShikyuHakko 至急発行フラグ
     */
    public void setFlag_ShikyuHakko(String Flag_ShikyuHakko) {
        setValue("Flag_ShikyuHakko", Flag_ShikyuHakko);
    }

}