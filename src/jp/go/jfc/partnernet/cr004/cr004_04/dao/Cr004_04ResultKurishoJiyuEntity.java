//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr004_04ResultKurishoJiyuEntity
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/25 | 佐藤　晃            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr004.cr004_04.dao;

import jp.go.jfc.partnernet.pnfw.dao.entity.PNBaseEntity;

/**
 * <pre>
 * このクラスはCr004_04ResultKurishoJiyuDAOのEntityクラスです。
 * </pre>
 *
 * @author 佐藤　晃
 * @version 1.0.0
 */
public class Cr004_04ResultKurishoJiyuEntity extends PNBaseEntity {
    
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
     * @param Code_KurishoJiyu 繰上償還事由コード
     */
    public void setCode_KurishoJiyu(String Code_KurishoJiyu) {
        setValue("Code_KurishoJiyu", Code_KurishoJiyu);
    }

}