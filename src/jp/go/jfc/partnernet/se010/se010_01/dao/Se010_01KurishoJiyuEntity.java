//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se010_01KurishoJiyuEntity
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/24 | 堀　大輔              | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se010.se010_01.dao;

import jp.go.jfc.partnernet.pnfw.dao.entity.PNBaseEntity;

/**
 * <pre>
 * このクラスはSe010_01KurishoJiyuDAOのEntityクラスです。
 * </pre>
 *
 * @author 堀　大輔
 * @version 1.0.0
 */
public class Se010_01KurishoJiyuEntity extends PNBaseEntity {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /**
     * 繰上償還事由コードを取得します。
     * @return 繰上償還事由コード
     */
    public String getCode_KurishoJiyu() {
        return (String) getValue("Code_KurishoJiyu");
    }

    /**
     * 繰上償還事由コードを設定します。
     * @param Code_KoukoShiten 繰上償還事由コード
     */
    public void setCode_KurishoJiyu(String Code_KurishoJiyu) {
        setValue("Code_KurishoJiyu", Code_KurishoJiyu);
    }

    /**
     * 繰上償還事由名称を取得します。
     * @return 繰上償還事由名称
     */
    public String getName_KurishoJiyu() {
        return (String) getValue("Name_KurishoJiyu");
    }

    /**
     * 繰上償還事由名称を設定します。
     * @param Name_KoukoShiten 繰上償還事由名称
     */
    public void setName_KurishoJiyu(String Name_KurishoJiyu) {
        setValue("Name_KurishoJiyu", Name_KurishoJiyu);
    }

}