//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se004_01ResultDataEntity
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/16 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se004.se004_01.dao;

import jp.go.jfc.partnernet.pnfw.dao.entity.PNBaseEntity;

/**
 * <pre>
 * このクラスはSe004_01ResultDataDAOのEntityクラスです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public class Se004_01ResultDataEntity extends PNBaseEntity {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /**
     * 公庫支店コードを取得します。
     * @return 公庫支店コード
     */
    public String getCode_ShokanHonShiten() {
        return (String) getValue("Code_ShokanHonShiten");
    }

    /**
     * 公庫支店コードを設定します。
     * @param Code_ShokanHonShiten 公庫支店コード
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
     * 年度(西暦)を取得します。
     * @return 年度(西暦)
     */
    public String getYear() {
        return (String) getValue("Year");
    }

    /**
     * 年度(西暦)を設定します。
     * @param Year 年度(西暦)
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

}