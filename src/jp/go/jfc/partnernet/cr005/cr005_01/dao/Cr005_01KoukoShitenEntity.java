//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr005_01KoukoShitenEntity
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/14 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr005.cr005_01.dao;

import jp.go.jfc.partnernet.pnfw.dao.entity.PNBaseEntity;

/**
 * <pre>
 * このクラスはCr005_01KoukoShitenDAOのEntityクラスです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public class Cr005_01KoukoShitenEntity extends PNBaseEntity {
    
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /**
     * 公庫支店コードを取得します。
     * @return 公庫支店コード
     */
    public String getCode_KoukoShiten() {
        return (String) getValue("Code_KoukoShiten");
    }

    /**
     * 公庫支店コードを設定します。
     * @param Code_KoukoShiten 公庫支店コード
     */
    public void setCode_KoukoShiten(String Code_KoukoShiten) {
        setValue("Code_KoukoShiten", Code_KoukoShiten);
    }

    /**
     * 公庫支店名を取得します。
     * @return 公庫支店名
     */
    public String getName_KoukoShiten() {
        return (String) getValue("Name_KoukoShiten");
    }

    /**
     * 公庫支店名を設定します。
     * @param Name_KoukoShiten 公庫支店名
     */
    public void setName_KoukoShiten(String Name_KoukoShiten) {
        setValue("Name_KoukoShiten", Name_KoukoShiten);
    }

}