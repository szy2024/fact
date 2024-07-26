//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Ut004_01TsuchiJimuEntity
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/03 | 譚　暁玉            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.ut004.ut004_01.dao;

import java.math.BigDecimal;

import jp.go.jfc.partnernet.pnfw.dao.entity.PNBaseEntity;

/**
 * <pre>
 * このクラスはUt004_01TsuchiJimuDAOのEntityクラスです。
 * </pre>
 *
 * @author 譚　暁玉
 * @version 1.0.0
 */
public class Ut004_01TsuchiJimuEntity extends PNBaseEntity {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /**
     * 新データ番号を取得します。
     * @return 新データ番号
     */
    public BigDecimal getID_Data_New() {
        return (BigDecimal) getValue("ID_Data_New");
    }

    /**
     * 新データ番号を設定します。
     * @param ID_Data_New 新データ番号
     */
    public void setID_Data_New(BigDecimal ID_Data_New) {
        setValue("ID_Data_New", ID_Data_New);
    }

}