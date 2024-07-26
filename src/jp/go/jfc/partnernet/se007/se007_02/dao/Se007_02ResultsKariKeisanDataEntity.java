//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se007_02ResultsKariKeisanDataEntity
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/10 | 田旗　秀樹            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se007.se007_02.dao;

import jp.go.jfc.partnernet.pnfw.dao.entity.PNBaseEntity;

/**
 * <pre>
 * このクラスはSe007_02ResultsKariKeisanDataDAOのEntityクラスです。
 * </pre>
 *
 * @author 田旗　秀樹
 * @version 1.0.0
 */
public class Se007_02ResultsKariKeisanDataEntity extends PNBaseEntity {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

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
     * ステータスを取得します。
     * @return ステータス
     */
    public java.math.BigDecimal getStatus() {
        return (java.math.BigDecimal) getValue("Status");
    }

    /**
     * ステータスを設定します。
     * @param Status ステータス
     */
    public void setStatus(java.math.BigDecimal Status) {
        setValue("Status", Status);
    }

    /**
     * 取消済フラグを取得します。
     * @return 取消済フラグ
     */
    public java.math.BigDecimal getFlag_Torikeshizumi() {
        return (java.math.BigDecimal) getValue("Flag_Torikeshizumi");
    }

    /**
     * 取消済フラグを設定します。
     * @param Flag_Torikeshizumi 取消済フラグ
     */
    public void setFlag_Torikeshizumi(java.math.BigDecimal Flag_Torikeshizumi) {
        setValue("Flag_Torikeshizumi", Flag_Torikeshizumi);
    }

    /**
     * COUNTを取得します。
     * @return COUNT
     */
    public String getCOUNT() {
        return (String) getValue("COUNT");
    }

    /**
     * COUNTを設定します。
     * @param COUNT COUNT
     */
    public void setCOUNT(String COUNT) {
        setValue("COUNT", COUNT);
    }

}