//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md001_01KinriHenkanDataEntity
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/11 | 田旗　秀樹            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.md001.md001_01.dao;

import jp.go.jfc.partnernet.pnfw.dao.entity.PNBaseEntity;

/**
 * <pre>
 * このクラスはMd001_01KinriHenkanDataDAOのEntityクラスです。
 * </pre>
 *
 * @author 青本　信吉
 * @version 1.0.0
 */
public class Md001_01KinriHenkanDataEntity extends PNBaseEntity {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /**
     * 資金使途コードを取得します。
     * @return 資金使途コード
     */
    public String getCode_ShikinShito() {
        return (String) getValue("Code_ShikinShito");
    }

    /**
     * 資金使途コードを設定します。
     * @param Code_ShikinShito 資金使途コード
     */
    public void setCode_ShikinShito(String Code_ShikinShito) {
        setValue("Code_ShikinShito", Code_ShikinShito);
    }

    /**
     * 事業別コードを取得します。
     * @return 事業別コード
     */
    public String getCode_Jigyoubetsu() {
        return (String) getValue("Code_Jigyoubetsu");
    }

    /**
     * 事業別コードを設定します。
     * @param Code_Jigyoubetsu 事業別コード
     */
    public void setCode_Jigyoubetsu(String Code_Jigyoubetsu) {
        setValue("Code_Jigyoubetsu", Code_Jigyoubetsu);
    }

    /**
     * 受理開始年月日を取得します。
     * @return 受理開始年月日
     */
    public String getDate_JuriStart() {
        return (String) getValue("Date_JuriStart");
    }

    /**
     * 受理開始年月日を設定します。
     * @param Date_JuriStart 受理開始年月日
     */
    public void setDate_JuriStart(String Date_JuriStart) {
        setValue("Date_JuriStart", Date_JuriStart);
    }

    /**
     * 受理終了年月日を取得します。
     * @return 受理終了年月日
     */
    public String getDate_JuriEnd() {
        return (String) getValue("Date_JuriEnd");
    }

    /**
     * 受理終了年月日を設定します。
     * @param Date_JuriEnd 受理終了年月日
     */
    public void setDate_JuriEnd(String Date_JuriEnd) {
        setValue("Date_JuriEnd", Date_JuriEnd);
    }

    /**
     * 借入主体コードを取得します。
     * @return 借入主体コード
     */
    public String getCode_KariireShutai() {
        return (String) getValue("Code_KariireShutai");
    }

    /**
     * 借入主体コードを設定します。
     * @param Code_KariireShutai 借入主体コード
     */
    public void setCode_KariireShutai(String Code_KariireShutai) {
        setValue("Code_KariireShutai", Code_KariireShutai);
    }

    /**
     * 貸付先コードを取得します。
     * @return 貸付先コード
     */
    public String getCode_Customer() {
        return (String) getValue("Code_Customer");
    }

    /**
     * 貸付先コードを設定します。
     * @param Code_Customer 貸付先コード
     */
    public void setCode_Customer(String Code_Customer) {
        setValue("Code_Customer", Code_Customer);
    }

    /**
     * 金利呼称細目コードを取得します。
     * @return 金利呼称細目コード
     */
    public String getCode_KinriKoshoSaimoku() {
        return (String) getValue("Code_KinriKoshoSaimoku");
    }

    /**
     * 金利呼称細目コードを設定します。
     * @param Code_KinriKoshoSaimoku 金利呼称細目コード
     */
    public void setCode_KinriKoshoSaimoku(String Code_KinriKoshoSaimoku) {
        setValue("Code_KinriKoshoSaimoku", Code_KinriKoshoSaimoku);
    }

    /**
     * 金利呼称コードを取得します。
     * @return 金利呼称コード
     */
    public String getCode_KinriKosho() {
        return (String) getValue("Code_KinriKosho");
    }

    /**
     * 金利呼称コードを設定します。
     * @param Code_KinriKosho 金利呼称コード
     */
    public void setCode_KinriKosho(String Code_KinriKosho) {
        setValue("Code_KinriKosho", Code_KinriKosho);
    }

}