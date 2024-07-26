//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se015_01ResultDataEntity
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/10/24 | 嶋田　美保            | H29年追加開発案件対応
//==================================================================================================
package jp.go.jfc.partnernet.se015.se015_01.dao;

import jp.go.jfc.partnernet.pnfw.dao.entity.PNBaseEntity;

/**
 * <pre>
 * このクラスはSe015_01ResultDataDAOのEntityクラスです。
 * </pre>
 *
 * @author 嶋田　美保
 * @version 2.0.0
 */
public class Se015_01ResultDataEntity extends PNBaseEntity {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /**
     * 集計開始年月日を取得します。
     *
     * @return 集計開始年月日
     */
    public String getDate_ShukeiStart() {
        return (String)getValue("Date_ShukeiStart");
    }

    /**
     * 集計開始年月日を設定します。
     *
     * @param Date_ShukeiStart 集計開始年月日
     */
    public void setDate_ShukeiStart(String Date_ShukeiStart) {
        setValue("Date_ShukeiStart", Date_ShukeiStart);
    }

    /**
     * 集計終了年月日を取得します。
     *
     * @return 集計終了年月日
     */
    public String getDate_ShukeiEnd() {
        return (String)getValue("Date_ShukeiEnd");
    }

    /**
     * 集計終了年月日を設定します。
     *
     * @param Date_ShukeiEnd 集計終了年月日
     */
    public void setDate_ShukeiEnd(String Date_ShukeiEnd) {
        setValue("Date_ShukeiEnd", Date_ShukeiEnd);
    }

    /**
     * 扱店を取得します。
     *
     * @return 扱店
     */
    public String getCode_Organization() {
        return (String)getValue("Code_Organization");
    }

    /**
     * 扱店を設定します。
     *
     * @param Code_Organization 扱店
     */
    public void setCode_Organization(String Code_Organization) {
        setValue("Code_Organization", Code_Organization);
    }

    /**
     * 店舗を取得します。
     *
     * @return 店舗
     */
    public String getCode_Tenpo() {
        return (String)getValue("Code_Tenpo");
    }

    /**
     * 店舗を設定します。
     *
     * @param Code_Tenpo 店舗
     */
    public void setCode_Tenpo(String Code_Tenpo) {
        setValue("Code_Tenpo", Code_Tenpo);
    }

    /**
     * 金融機関名称を取得します。
     *
     * @return 金融機関名称
     */
    public String getName_Organization() {
        return (String)getValue("Name_Organization");
    }

    /**
     * 金融機関名称を設定します。
     *
     * @param Name_Organization 金融機関名称
     */
    public void setName_Organization(String Name_Organization) {
        setValue("Name_Organization", Name_Organization);
    }

    /**
     * 店舗名称を取得します。
     *
     * @return 店舗名称
     */
    public String getName_Tenpo() {
        return (String)getValue("Name_Tenpo");
    }

    /**
     * 店舗名称を設定します。
     *
     * @param Name_Tenpo 店舗名称
     */
    public void setName_Tenpo(String Name_Tenpo) {
        setValue("Name_Tenpo", Name_Tenpo);
    }

    /**
     * 包括委任状数量を取得します。
     *
     * @return 包括委任状数量
     */
    public Integer getSu_HokatsuInin() {
        return (Integer)getValue("Su_HokatsuInin");
    }

    /**
     * 包括委任状数量を設定します。
     *
     * @param Su_HokatsuInin 包括委任状数量
     */
    public void setSu_HokatsuInin(Integer Su_HokatsuInin) {
        setValue("Su_HokatsuInin", Su_HokatsuInin);
    }

    /**
     * 現在事項一部証明書数量を取得します。
     *
     * @return 現在事項一部証明書数量
     */
    public Integer getSu_GenzaiJiko() {
        return (Integer)getValue("Su_GenzaiJiko");
    }

    /**
     * 現在事項一部証明書数量を設定します。
     *
     * @param Su_GenzaiJiko 現在事項一部証明書数量
     */
    public void setSu_GenzaiJiko(Integer Su_GenzaiJiko) {
        setValue("Su_GenzaiJiko", Su_GenzaiJiko);
    }

    /**
     * 印鑑証明書数量を取得します。
     *
     * @return 印鑑証明書数量
     */
    public Integer getSu_InkanShohmei() {
        return (Integer)getValue("Su_InkanShohmei");
    }

    /**
     * 印鑑証明書数量を設定します。
     *
     * @param Su_InkanShohmei 印鑑証明書数量
     */
    public void setSu_InkanShohmei(Integer Su_InkanShohmei) {
        setValue("Su_InkanShohmei", Su_InkanShohmei);
    }

    /**
     * 変更抄本数量を取得します。
     *
     * @return 変更抄本数量
     */
    public Integer getSu_HenkoShohhon() {
        return (Integer)getValue("Su_HenkoShohhon");
    }

    /**
     * 変更抄本数量を設定します。
     *
     * @param Su_HenkoShohhon 変更抄本数量
     */
    public void setSu_HenkoShohhon(Integer Su_HenkoShohhon) {
        setValue("Su_HenkoShohhon", Su_HenkoShohhon);
    }

    /**
     * 新閉鎖謄本数量を取得します。
     *
     * @return 新閉鎖謄本数量
     */
    public Integer getSu_SinHeisa() {
        return (Integer)getValue("Su_SinHeisa");
    }

    /**
     * 新閉鎖謄本数量を設定します。
     *
     * @param Su_SinHeisa 新閉鎖謄本数量
     */
    public void setSu_SinHeisa(Integer Su_SinHeisa) {
        setValue("Su_SinHeisa", Su_SinHeisa);
    }

    /**
     * 旧閉鎖抄本数量を取得します。
     *
     * @return 旧閉鎖抄本数量
     */
    public Integer getSu_KyuHeisa() {
        return (Integer)getValue("Su_KyuHeisa");
    }

    /**
     * 旧閉鎖抄本数量を設定します。
     *
     * @param Su_KyuHeisa 旧閉鎖抄本数量
     */
    public void setSu_KyuHeisa(Integer Su_KyuHeisa) {
        setValue("Su_KyuHeisa", Su_KyuHeisa);
    }

    /**
     * 閉鎖事項全部証明書数量を取得します。
     *
     * @return 閉鎖事項全部証明書数量
     */
    public Integer getSu_HeisaJiko() {
        return (Integer)getValue("Su_HeisaJiko");
    }

    /**
     * 閉鎖事項全部証明書数量を設定します。
     *
     * @param Su_HeisaJiko 閉鎖事項全部証明書数量
     */
    public void setSu_HeisaJiko(Integer Su_HeisaJiko) {
        setValue("Su_HeisaJiko", Su_HeisaJiko);
    }

    /**
     * 至急発行フラグを取得します。
     *
     * @return 至急発行フラグ
     */
    public String getFlag_ShikyuHakko() {
        return (String)getValue("Flag_ShikyuHakko");
    }

    /**
     * 至急発行フラグを設定します。
     *
     * @param Flag_ShikyuHakko 至急発行フラグ
     */
    public void setFlag_ShikyuHakko(String Flag_ShikyuHakko) {
        setValue("Flag_ShikyuHakko", Flag_ShikyuHakko);
    }

}