//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se010_01HaraidashiEntity
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/24 | 堀　大輔            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se010.se010_01.dao;

import jp.go.jfc.partnernet.pnfw.dao.entity.PNBaseEntity;

/**
 * <pre>
 * このクラスはSe010_01HaraidashiDAOのEntityクラスです。
 * </pre>
 *
 * @author 堀　大輔
 * @version 1.0.0
 */
public class Se010_01HaraidashiEntity extends PNBaseEntity {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

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
     * 繰上償還日を取得します。
     * @return 繰上償還日
     */
    public String getStrDateKuriageShokan() {
        return (String) getValue("strDateKuriageShokan");
    }

    /**
     * 繰上償還日を設定します。
     * @param strDateKuriageShokan 繰上償還日
     */
    public void setStrDateKuriageShokan(String strDateKuriageShokan) {
        setValue("strDateKuriageShokan", strDateKuriageShokan);
    }

    /**
     * 貸付受入金残高を取得します。
     * @return 貸付受入金残高
     */
    public java.math.BigDecimal getM_KashitsukeukeireZan() {
        return (java.math.BigDecimal) getValue("M_KashitsukeukeireZan");
    }

    /**
     * 貸付受入金残高を設定します。
     * @param M_KashitsukeukeireZan 貸付受入金残高
     */
    public void setM_KashitsukeukeireZan(java.math.BigDecimal M_KashitsukeukeireZan) {
        setValue("M_KashitsukeukeireZan", M_KashitsukeukeireZan);
    }
}