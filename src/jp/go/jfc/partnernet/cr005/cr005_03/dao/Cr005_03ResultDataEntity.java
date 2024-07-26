//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr005_03ResultDataEntity
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/14 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr005.cr005_03.dao;

import jp.go.jfc.partnernet.pnfw.dao.entity.PNBaseEntity;

/**
 * <pre>
 * このクラスはCr005_03ResultDataDAOのEntityクラスです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public class Cr005_03ResultDataEntity extends PNBaseEntity {
    
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /**
     * 貸付先コード入力値を取得します。
     * @return 貸付先コード入力値
     */
    public String getCr005_03_In_Code_Customer() {
        return (String) getValue("Cr005_03_In_Code_Customer");
    }

    /**
     * 貸付先コード入力値を設定します。
     * @param Cr005_03_In_Code_Customer 貸付先コード入力値
     */
    public void setCr005_03_In_Code_Customer(String Cr005_03_In_Code_Customer) {
        setValue("Cr005_03_In_Code_Customer", Cr005_03_In_Code_Customer);
    }

    /**
     * ログインユーザ扱店コードを取得します。
     * @return ログインユーザ扱店コード
     */
    public String getCr005_03_Code_Organization() {
        return (String) getValue("Cr005_03_Code_Organization");
    }

    /**
     * ログインユーザ扱店コードを設定します。
     * @param Cr005_03_Code_Organization ログインユーザ扱店コード
     */
    public void setCr005_03_Code_Organization(String Cr005_03_Code_Organization) {
        setValue("Cr005_03_Code_Organization", Cr005_03_Code_Organization);
    }

    /**
     * 所管本支店コードを取得します。
     * @return 所管本支店コード
     */
    public String getCode_ShokanHonShiten() {
        return (String) getValue("Code_ShokanHonShiten");
    }

    /**
     * 所管本支店コードを設定します。
     * @param Code_ShokanHonShiten 所管本支店コード
     */
    public void setCode_ShokanHonShiten(String Code_ShokanHonShiten) {
        setValue("Code_ShokanHonShiten", Code_ShokanHonShiten);
    }

    /**
     * 扱店コードを取得します。
     * @return 扱店コード
     */
    public String getCode_Organization() {
        return (String) getValue("Code_Organization");
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
        return (String) getValue("Code_Tenpo");
    }

    /**
     * 店舗コードを設定します。
     * @param Code_Tenpo 店舗コード
     */
    public void setCode_Tenpo(String Code_Tenpo) {
        setValue("Code_Tenpo", Code_Tenpo);
    }

    /**
     * 年度を取得します。
     * @return 年度
     */
    public String getYear() {
        return (String) getValue("Year");
    }

    /**
     * 年度を設定します。
     * @param Year 年度
     */
    public void setYear(String Year) {
        setValue("Year", Year);
    }

    /**
     * 方式区分を取得します。
     * @return 方式区分
     */
    public String getKubun_Hoshiki() {
        return (String) getValue("Kubun_Hoshiki");
    }

    /**
     * 方式区分を設定します。
     * @param Kubun_Hoshiki 方式区分
     */
    public void setKubun_Hoshiki(String Kubun_Hoshiki) {
        setValue("Kubun_Hoshiki", Kubun_Hoshiki);
    }

    /**
     * 資金区分を取得します。
     * @return 資金区分
     */
    public String getKubun_Shikin() {
        return (String) getValue("Kubun_Shikin");
    }

    /**
     * 資金区分を設定します。
     * @param Kubun_Shikin 資金区分
     */
    public void setKubun_Shikin(String Kubun_Shikin) {
        setValue("Kubun_Shikin", Kubun_Shikin);
    }

    /**
     * 稟議番号を取得します。
     * @return 稟議番号
     */
    public String getID_Ringi() {
        return (String) getValue("ID_Ringi");
    }

    /**
     * 稟議番号を設定します。
     * @param ID_Ringi 稟議番号
     */
    public void setID_Ringi(String ID_Ringi) {
        setValue("ID_Ringi", ID_Ringi);
    }

    /**
     * 稟議番号枝番を取得します。
     * @return 稟議番号枝番
     */
    public String getID_RingiBranch() {
        return (String) getValue("ID_RingiBranch");
    }

    /**
     * 稟議番号枝番を設定します。
     * @param ID_RingiBranch 稟議番号枝番
     */
    public void setID_RingiBranch(String ID_RingiBranch) {
        setValue("ID_RingiBranch", ID_RingiBranch);
    }

    /**
     * 貸付先コードを取得します。
     * @return 貸付先コード
     */
    public String getCode_Customer() {
        return (String) getValue("Code_Customer");
    }

    /**
     * 貸付先コードを設定します。
     * @param Code_Customer 貸付先コード
     */
    public void setCode_Customer(String Code_Customer) {
        setValue("Code_Customer", Code_Customer);
    }

    /**
     * 実行年月日を取得します。
     * @return 実行年月日
     */
    public String getDate_Jikko() {
        return (String) getValue("Date_Jikko");
    }

    /**
     * 実行年月日を設定します。
     * @param Date_Jikko 実行年月日
     */
    public void setDate_Jikko(String Date_Jikko) {
        setValue("Date_Jikko", Date_Jikko);
    }

    /**
     * 取引停止案件コードを取得します。
     * @return 取引停止案件コード
     */
    public String getCode_TorihikiTeishi() {
        return (String) getValue("Code_TorihikiTeishi");
    }

    /**
     * 取引停止案件コードを設定します。
     * @param Code_TorihikiTeishi 取引停止案件コード
     */
    public void setCode_TorihikiTeishi(String Code_TorihikiTeishi) {
        setValue("Code_TorihikiTeishi", Code_TorihikiTeishi);
    }

    /**
     * 条変起案中区分を取得します。
     * @return 条変起案中区分
     */
    public String getKubun_JohenKianchu() {
        return (String) getValue("Kubun_JohenKianchu");
    }

    /**
     * 条変起案中区分を設定します。
     * @param Kubun_JohenKianchu 条変起案中区分
     */
    public void setKubun_JohenKianchu(String Kubun_JohenKianchu) {
        setValue("Kubun_JohenKianchu", Kubun_JohenKianchu);
    }

    /**
     * 債権管理番号を取得します。
     * @return 債権管理番号
     */
    public String getID_Credit() {
        return (String) getValue("ID_Credit");
    }

    /**
     * 債権管理番号を設定します。
     * @param ID_Credit 債権管理番号
     */
    public void setID_Credit(String ID_Credit) {
        setValue("ID_Credit", ID_Credit);
    }

    /**
     * 貸付先名称を取得します。
     * @return 貸付先名称
     */
    public String getName_Customer() {
        return (String) getValue("Name_Customer");
    }

    /**
     * 貸付先名称を設定します。
     * @param Name_Customer 貸付先名称
     */
    public void setName_Customer(String Name_Customer) {
        setValue("Name_Customer", Name_Customer);
    }

    /**
     * 金融機関名称を取得します。
     * @return 金融機関名称
     */
    public String getName_Organization() {
        return (String) getValue("Name_Organization");
    }

    /**
     * 金融機関名称を設定します。
     * @param Name_Organization 金融機関名称
     */
    public void setName_Organization(String Name_Organization) {
        setValue("Name_Organization", Name_Organization);
    }

}