//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se002_01ResultsDataEntity
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/28 | 田旗　秀樹            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se002.se002_01.dao;

import jp.go.jfc.partnernet.pnfw.dao.entity.PNBaseEntity;

/**
 * <pre>
 * このクラスはSe002_01ResultsDataDAOのEntityクラスです。
 * </pre>
 *
 * @author 田旗　秀樹
 * @version 1.0.0
 */
public class Se002_01ResultsDataEntity extends PNBaseEntity {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /**
     * 扱店を取得します。
     * @return 扱店
     */
    public String getCode_Organization() {
        return (String) getValue("Code_Organization");
    }

    /**
     * 扱店を設定します。
     * @param Code_Organization 扱店
     */
    public void setCode_Organization(String Code_Organization) {
        setValue("Code_Organization", Code_Organization);
    }

    /**
     * 未完結区分を取得します。
     * @return 未完結区分
     */
    public String getKubun_Mikanketsu() {
        return (String) getValue("Kubun_Mikanketsu");
    }

    /**
     * 未完結区分を設定します。
     * @param Kubun_Mikanketsu 未完結区分
     */
    public void setKubun_Mikanketsu(String Kubun_Mikanketsu) {
        setValue("Kubun_Mikanketsu", Kubun_Mikanketsu);
    }

    /**
     * ログインユーザ権限種別を取得します。
     * @param Se001_02_RoleCode ログインユーザ権限種別
     */
    public String getSe002_01_RoleCode() {
        return (String) getValue("setSe002_01_RoleCode");
    }

    /**
     * ログインユーザ権限種別を設定します。
     * @param Kubun_Mikanketsu 未完結区分
     */
    public void setSe002_01_RoleCode(String setSe002_01_RoleCode) {
        setValue("setSe002_01_RoleCode", setSe002_01_RoleCode);
    }

    /**
     * 顧客名を取得します。
     * @return 顧客名
     */
    public String getName_Customer() {
        return (String) getValue("Name_Customer");
    }

    /**
     * 顧客名を設定します。
     * @param Name_Customer 顧客名
     */
    public void setName_Customer(String Name_Customer) {
        setValue("Name_Customer", Name_Customer);
    }

    /**
     * 公庫支店を取得します。
     * @return 公庫支店
     */
    public String getName_KoukoShiten() {
        return (String) getValue("Name_KoukoShiten");
    }

    /**
     * 公庫支店を設定します。
     * @param Name_KoukoShiten 公庫支店
     */
    public void setName_KoukoShiten(String Name_KoukoShiten) {
        setValue("Name_KoukoShiten", Name_KoukoShiten);
    }

    /**
     * 店舗を取得します。
     * @return 店舗
     */
    public String getCode_Tenpo() {
        return (String) getValue("Code_Tenpo");
    }

    /**
     * 店舗を設定します。
     * @param Code_Tenpo 店舗
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
     * 方式を取得します。
     * @return 方式
     */
    public String getKubun_Hoshiki() {
        return (String) getValue("Kubun_Hoshiki");
    }

    /**
     * 方式を設定します。
     * @param Kubun_Hoshiki 方式
     */
    public void setKubun_Hoshiki(String Kubun_Hoshiki) {
        setValue("Kubun_Hoshiki", Kubun_Hoshiki);
    }

    /**
     * 資金を取得します。
     * @return 資金
     */
    public String getKubun_Shikin() {
        return (String) getValue("Kubun_Shikin");
    }

    /**
     * 資金を設定します。
     * @param Kubun_Shikin 資金
     */
    public void setKubun_Shikin(String Kubun_Shikin) {
        setValue("Kubun_Shikin", Kubun_Shikin);
    }

    /**
     * 番号を取得します。
     * @return 番号
     */
    public String getID_Ringi() {
        return (String) getValue("ID_Ringi");
    }

    /**
     * 番号を設定します。
     * @param ID_Ringi 番号
     */
    public void setID_Ringi(String ID_Ringi) {
        setValue("ID_Ringi", ID_Ringi);
    }

    /**
     * 枝番を取得します。
     * @return 枝番
     */
    public String getID_RingiBranch() {
        return (String) getValue("ID_RingiBranch");
    }

    /**
     * 枝番を設定します。
     * @param ID_RingiBranch 枝番
     */
    public void setID_RingiBranch(String ID_RingiBranch) {
        setValue("ID_RingiBranch", ID_RingiBranch);
    }

    /**
     * 貸付実行予定日（扱店別稟議データ）を取得します。
     * @return 貸付実行予定日（扱店別稟議データ）
     */
    public String getDate_Jikko() {
        return (String) getValue("Date_Jikko");
    }

    /**
     * 貸付実行予定日（扱店別稟議データ）を設定します。
     * @param Date_Jikko 貸付実行予定日（扱店別稟議データ）
     */
    public void setDate_Jikko(String Date_Jikko) {
        setValue("Date_Jikko", Date_Jikko);
    }

    /**
     * 貸付決定日を取得します。
     * @return 貸付決定日
     */
    public String getDate_JuriKetteikisan() {
        return (String) getValue("Date_JuriKetteikisan");
    }

    /**
     * 貸付決定日を設定します。
     * @param Date_JuriKetteikisan 貸付決定日
     */
    public void setDate_JuriKetteikisan(String Date_JuriKetteikisan) {
        setValue("Date_JuriKetteikisan", Date_JuriKetteikisan);
    }

    /**
     * 貸付決定額を取得します。
     * @return 貸付決定額
     */
    public java.math.BigDecimal getM_Kettei() {
        return (java.math.BigDecimal) getValue("M_Kettei");
    }

    /**
     * 貸付決定額を設定します。
     * @param M_Kettei 貸付決定額
     */
    public void setM_Kettei(java.math.BigDecimal M_Kettei) {
        setValue("M_Kettei", M_Kettei);
    }

    /**
     * 貸付実行額を取得します。
     * @return 貸付実行額
     */
    public java.math.BigDecimal getM_Kashitsuke() {
        return (java.math.BigDecimal) getValue("M_Kashitsuke");
    }

    /**
     * 貸付実行額を設定します。
     * @param M_Kashitsuke 貸付実行額
     */
    public void setM_Kashitsuke(java.math.BigDecimal M_Kashitsuke) {
        setValue("M_Kashitsuke", M_Kashitsuke);
    }

    /**
     * 資金払出未了額を取得します。
     * @return 資金払出未了額
     */
    public java.math.BigDecimal getM_KashitsukeukeireZan() {
        return (java.math.BigDecimal) getValue("M_KashitsukeukeireZan");
    }

    /**
     * 資金払出未了額を設定します。
     * @param M_KashitsukeukeireZan 資金払出未了額
     */
    public void setM_KashitsukeukeireZan(java.math.BigDecimal M_KashitsukeukeireZan) {
        setValue("M_KashitsukeukeireZan", M_KashitsukeukeireZan);
    }

    /**
     * 貸付実行期限を取得します。
     * @return 貸付実行期限
     */
    public String getDate_JikkoKigen() {
        return (String) getValue("Date_JikkoKigen");
    }

    /**
     * 貸付実行期限を設定します。
     * @param Date_JikkoKigen 貸付実行期限
     */
    public void setDate_JikkoKigen(String Date_JikkoKigen) {
        setValue("Date_JikkoKigen", Date_JikkoKigen);
    }

    /**
     * 資金払出期限を取得します。
     * @return 資金払出期限
     */
    public String getDate_HaraidashiKigen() {
        return (String) getValue("Date_HaraidashiKigen");
    }

    /**
     * 資金払出期限を設定します。
     * @param Date_HaraidashiKigen 資金払出期限
     */
    public void setDate_HaraidashiKigen(String Date_HaraidashiKigen) {
        setValue("Date_HaraidashiKigen", Date_HaraidashiKigen);
    }

    /**
     * 債権管理番号を取得します。
     * @return 債権管理番号
     */
    public java.math.BigDecimal getID_Credit() {
        return (java.math.BigDecimal) getValue("ID_Credit");
    }

    /**
     * 債権管理番号を設定します。
     * @param ID_Credit 債権管理番号
     */
    public void setID_Credit(java.math.BigDecimal ID_Credit) {
        setValue("ID_Credit", ID_Credit);
    }

    /**
     * 貸付実行予定日(進行管理データ)を取得します。
     * @return 貸付実行予定日(進行管理データ)
     */
    public String getShinko_Kanri_Date_Jikko() {
        return (String) getValue("Shinko_Kanri_Date_Jikko ");
    }

    /**
     * 貸付実行予定日(進行管理データ)を設定します。
     * @param Shinko_Kanri_Date_Jikko 貸付実行予定日(進行管理データ)
     */
    public void setShinko_Kanri_Date_Jikko(String Shinko_Kanri_Date_Jikko) {
        setValue("Shinko_Kanri_Date_Jikko ", Shinko_Kanri_Date_Jikko);
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

}