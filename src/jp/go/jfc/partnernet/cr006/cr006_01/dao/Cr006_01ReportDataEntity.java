//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr006_01ReportDataEntity
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/24 | 田旗　秀樹            | 新規作成
// 2.0.0   | 2017/11/30 | 林　晃平              | 委託貸付報告等における機能改善対応
//==================================================================================================
package jp.go.jfc.partnernet.cr006.cr006_01.dao;

import jp.go.jfc.partnernet.pnfw.dao.entity.PNBaseEntity;

/**
 * <pre>
 * このクラスはCr006_01ReportDataDAOのEntityクラスです。
 * </pre>
 *
 * @author 林　晃平
 * @version 2.0.0
 */
public class Cr006_01ReportDataEntity extends PNBaseEntity {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /**
     * 貸付先名称を取得します。
     * 
     * @return 貸付先名称
     */
    public String getName_Customer() {
        return (String)getValue("Name_Customer");
    }

    /**
     * 貸付先名称を設定します。
     * 
     * @param Name_Customer 貸付先名称
     */
    public void setName_Customer(String Name_Customer) {
        setValue("Name_Customer", Name_Customer);
    }

    /**
     * 仮受仮払年月日を取得します。
     * 
     * @return 仮受仮払年月日
     */
    public String getDate_Karibarai() {
        return (String)getValue("Date_Karibarai");
    }

    /**
     * 仮受仮払年月日を設定します。
     * 
     * @param Date_Karibarai 仮受仮払年月日
     */
    public void setDate_Karibarai(String Date_Karibarai) {
        setValue("Date_Karibarai", Date_Karibarai);
    }

    /**
     * 仮受仮払勘定科目コードを取得します。
     * 
     * @return 仮受仮払勘定科目コード
     */
    public String getCode_KanjoKamoku() {
        return (String)getValue("Code_KanjoKamoku");
    }

    /**
     * 仮受仮払勘定科目コードを設定します。
     * 
     * @param Code_KanjoKamoku 仮受仮払勘定科目コード
     */
    public void setCode_KanjoKamoku(String Code_KanjoKamoku) {
        setValue("Code_KanjoKamoku", Code_KanjoKamoku);
    }

    /**
     * 当初仮受仮払額を取得します。
     * 
     * @return 当初仮受仮払額
     */
    public java.math.BigDecimal getM_ToshoKaribarai() {
        return (java.math.BigDecimal)getValue("M_ToshoKaribarai");
    }

    /**
     * 当初仮受仮払額を設定します。
     * 
     * @param M_ToshoKaribarai 当初仮受仮払額
     */
    public void setM_ToshoKaribarai(java.math.BigDecimal M_ToshoKaribarai) {
        setValue("M_ToshoKaribarai", M_ToshoKaribarai);
    }

    /**
     * 仮受仮払精算後残高を取得します。
     * 
     * @return 仮受仮払精算後残高
     */
    public java.math.BigDecimal getM_KaribaraiZanAfterSeisan() {
        return (java.math.BigDecimal)getValue("M_KaribaraiZanAfterSeisan");
    }

    /**
     * 仮受仮払精算後残高を設定します。
     * 
     * @param M_KaribaraiZanAfterSeisan 仮受仮払精算後残高
     */
    public void setM_KaribaraiZanAfterSeisan(java.math.BigDecimal M_KaribaraiZanAfterSeisan) {
        setValue("M_KaribaraiZanAfterSeisan", M_KaribaraiZanAfterSeisan);
    }

    /**
     * 所管本支店コードを取得します。
     * 
     * @return 所管本支店コード
     */
    public String getCode_ShokanHonShiten() {
        return (String)getValue("Code_ShokanHonShiten");
    }

    /**
     * 所管本支店コードを設定します。
     * 
     * @param Code_ShokanHonShiten 所管本支店コード
     */
    public void setCode_ShokanHonShiten(String Code_ShokanHonShiten) {
        setValue("Code_ShokanHonShiten", Code_ShokanHonShiten);
    }

    /**
     * 扱店コードを取得します。
     * 
     * @return 扱店コード
     */
    public String getCode_Organization() {
        return (String)getValue("Code_Organization");
    }

    /**
     * 扱店コードを設定します。
     * 
     * @param Code_Organization 扱店コード
     */
    public void setCode_Organization(String Code_Organization) {
        setValue("Code_Organization", Code_Organization);
    }

    /**
     * 店舗コードを取得します。
     * 
     * @return 店舗コード
     */
    public String getCode_Tenpo() {
        return (String)getValue("Code_Tenpo");
    }

    /**
     * 店舗コードを設定します。
     * 
     * @param Code_Tenpo 店舗コード
     */
    public void setCode_Tenpo(String Code_Tenpo) {
        setValue("Code_Tenpo", Code_Tenpo);
    }

    /**
     * 年度を取得します。
     * 
     * @return 年度
     */
    public String getYear() {
        return (String)getValue("Year");
    }

    /**
     * 年度を設定します。
     * 
     * @param Year 年度
     */
    public void setYear(String Year) {
        setValue("Year", Year);
    }

    /**
     * 方式区分を取得します。
     * 
     * @return 方式区分
     */
    public String getKubun_Hoshiki() {
        return (String)getValue("Kubun_Hoshiki");
    }

    /**
     * 方式区分を設定します。
     * 
     * @param Kubun_Hoshiki 方式区分
     */
    public void setKubun_Hoshiki(String Kubun_Hoshiki) {
        setValue("Kubun_Hoshiki", Kubun_Hoshiki);
    }

    /**
     * 資金区分を取得します。
     * 
     * @return 資金区分
     */
    public String getKubun_Shikin() {
        return (String)getValue("Kubun_Shikin");
    }

    /**
     * 資金区分を設定します。
     * 
     * @param Kubun_Shikin 資金区分
     */
    public void setKubun_Shikin(String Kubun_Shikin) {
        setValue("Kubun_Shikin", Kubun_Shikin);
    }

    /**
     * 稟議番号を取得します。
     * 
     * @return 稟議番号
     */
    public String getID_Ringi() {
        return (String)getValue("ID_Ringi");
    }

    /**
     * 稟議番号を設定します。
     * 
     * @param ID_Ringi 稟議番号
     */
    public void setID_Ringi(String ID_Ringi) {
        setValue("ID_Ringi", ID_Ringi);
    }

    /**
     * 稟議番号枝番を取得します。
     * 
     * @return 稟議番号枝番
     */
    public String getID_RingiBranch() {
        return (String)getValue("ID_RingiBranch");
    }

    /**
     * 稟議番号枝番を設定します。
     * 
     * @param ID_RingiBranch 稟議番号枝番
     */
    public void setID_RingiBranch(String ID_RingiBranch) {
        setValue("ID_RingiBranch", ID_RingiBranch);
    }

    /**
     * 貸付先コードを取得します。
     * 
     * @return 貸付先コード
     */
    public String getID_Code_Customer() {
        return (String)getValue("ID_Code_Customer");
    }

    /**
     * 貸付先コードを設定します。
     * 
     * @param ID_Code_Customer 貸付先コード
     */
    public void setID_Code_Customer(String ID_Code_Customer) {
        setValue("ID_Code_Customer", ID_Code_Customer);
    }

    /**
     * 債権管理番号を取得します。
     * 
     * @return 債権管理番号
     */
    public String getID_Credit() {
        return (String)getValue("ID_Credit");
    }

    /**
     * 債権管理番号を設定します。
     * 
     * @param ID_Credit 債権管理番号
     */
    public void setID_Credit(String ID_Credit) {
        setValue("ID_Credit", ID_Credit);
    }

    /**
     * 本支店コードを取得します。
     * 
     * @return 本支店コード
     */
    public String getCode_HonShiten() {
        return (String)getValue("Code_HonShiten");
    }

    /**
     * 本支店コードを設定します。
     * 
     * @param Code_HonShiten 本支店コード
     */
    public void setCode_HonShiten(String Code_HonShiten) {
        setValue("Code_HonShiten", Code_HonShiten);
    }

    /**
     * 仮受仮払番号を取得します。
     * 
     * @return 仮受仮払番号
     */
    public String getID_Karibarai() {
        return (String)getValue("ID_Karibarai");
    }

    /**
     * 仮受仮払番号を設定します。
     * 
     * @param ID_Karibarai 仮受仮払番号
     */
    public void setID_Karibarai(String ID_Karibarai) {
        setValue("ID_Karibarai", ID_Karibarai);
    }

}