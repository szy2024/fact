//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se009_01KoukoShitenEntity
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/24 | 青本　信吉            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se009.se009_01.dao;

import jp.go.jfc.partnernet.pnfw.dao.entity.PNBaseEntity;

/**
 * <pre>
 * このクラスはSe009_01KoukoShitenDAOのEntityクラスです。
 * </pre>
 *
 * @author 青本　信吉
 * @version 1.0.0
 */
public class Se009_01KoukoShitenEntity extends PNBaseEntity {
    
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