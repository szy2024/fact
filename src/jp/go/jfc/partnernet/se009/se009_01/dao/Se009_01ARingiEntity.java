//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se009_01ARingiEntity
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/24 | 青本　信吉            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se009.se009_01.dao;

import java.math.BigDecimal;

import jp.go.jfc.partnernet.pnfw.dao.entity.PNBaseEntity;

/**
 * <pre>
 * このクラスはSe009_01ARingiDAOのEntityクラスです。
 * </pre>
 *
 * @author 青本　信吉
 * @version 1.0.0
 */
public class Se009_01ARingiEntity extends PNBaseEntity {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /**
     * 債権管理番号を取得します。
     * @return 債権管理番号
     */
    public BigDecimal getID_Credit() {
        return (BigDecimal) getValue("ID_Credit");
    }

    /**
     *
     * 債権管理番号を設定します。
     * @param ID_Credit 債権管理番号
     */
    public void setID_Credit(BigDecimal ID_Credit) {
        setValue("ID_Credit", ID_Credit);
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
     * 最新変更年月日を取得します。
     * @return 最新変更年月日
     */
    public String getDate_SaishinHenko() {
        return (String) getValue("Date_SaishinHenko");
    }

    /**
     * 最新変更年月日を設定します。
     * @param Date_SaishinHenko 最新変更年月日
     */
    public void setDate_SaishinHenko(String Date_SaishinHenko) {
        setValue("Date_SaishinHenko", Date_SaishinHenko);
    }

    /**
     * 償還期限年月を取得します。
     * @return 償還期限年月
     */
    public String getDate_ShokanKigen() {
        return (String) getValue("Date_ShokanKigen");
    }

    /**
     * 償還期限年月を設定します。
     * @param Date_ShokanKigen 償還期限年月
     */
    public void setDate_ShokanKigen(String Date_ShokanKigen) {
        setValue("Date_ShokanKigen", Date_ShokanKigen);
    }

    /**
     * 特利区分を取得します。
     * @return 特利区分
     */
    public String getKubun_Tokuri() {
        return (String) getValue("Kubun_Tokuri");
    }

    /**
     * 特利区分を設定します。
     * @param Kubun_Tokuri 特利区分
     */
    public void setKubun_Tokuri(String Kubun_Tokuri) {
        setValue("Kubun_Tokuri", Kubun_Tokuri);
    }

    /**
     * 農協コードを取得します。
     * @return 農協コード
     */
    public String getCode_Noukyou() {
        return (String) getValue("Code_Noukyou");
    }

    /**
     * 農協コードを設定します。
     * @param Code_Noukyou 農協コード
     */
    public void setCode_Noukyou(String Code_Noukyou) {
        setValue("Code_Noukyou", Code_Noukyou);
    }

    /**
     * 利用者の扱店コードを取得します。
     * @return 利用者の扱店コード
     */
    public String getUser_Code_Organization() {
        return (String) getValue("user_Code_Organization");
    }

    /**
     * 利用者の扱店コードを設定します。
     * @param user_Code_Organization 利用者の扱店コード
     */
    public void setUser_Code_Organization(String user_Code_Organization) {
        setValue("user_Code_Organization", user_Code_Organization);
    }

    /**
     * 利用者の権限種別を取得します。
     * @return 利用者の権限種別
     */
    public String getUser_RoleCode() {
        return (String) getValue("user_RoleCode");
    }

    /**
     * 利用者の権限種別を設定します。
     * @param user_RoleCode 利用者の権限種別
     */
    public void setUser_RoleCode(String user_RoleCode) {
        setValue("user_RoleCode", user_RoleCode);
    }

}