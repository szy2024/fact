//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr006_01M1DTO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/24 | 田旗　秀樹            | 新規作成
// 2.0.0   | 2017/11/30 | 林　晃平              | 委託貸付報告等における機能改善対応
//==================================================================================================
package jp.go.jfc.partnernet.cr006.cr006_01.service;

import jp.go.jfc.partnernet.pnfw.service.dto.PNBaseDTO;

/**
 * <pre>
 * このクラスはCr006_01のDTOクラスです。
 * </pre>
 *
 * @author 林　晃平
 * @version 2.0.0
 */
public class Cr006_01M1DTO extends PNBaseDTO {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 選択 */
    private String ID_ChkSelect;
    /** 顧客名 */
    private String ID_Name_Customer;
    /** 立替日 */
    private String ID_Date_Karibarai;
    /** 立替金の種類 */
    private String ID_Code_KanjoKamoku;
    /** 公庫立替金額(円) */
    private String ID_M_ToshoKaribarai;
    /** 現在の立替金残高(円) */
    private String ID_M_KaribaraiZanAfterSeisan;
    /** 債権管理番号 */
    private String ID_ID_Credit;
    /** 公庫支店 */
    private String ID_Code_KoukoShiten;
    /** 扱店 */
    private String ID_Code_Organization;
    /** 店舗 */
    private String ID_Code_Tenpo;
    /** 年度 */
    private String ID_Year;
    /** 方式資金 */
    private String ID_Code_HoshikiShikin;
    /** 番号 */
    private String ID_ID_Ringi;
    /** 枝番 */
    private String ID_ID_RingiBranch;
    /** 貸付先コード */
    private String ID_Code_Customer;
    /** 本支店コード */
    private String ID_Code_HonShiten;
    /** 仮受仮払番号 */
    private String ID_ID_Karibarai;
    /** 仮受仮払勘定科目コード */
    private String Code_KanjoKamoku;
    /** Index */
    private String ArrayListIndex;

    /**
     * <pre>
     * コンストラクター。
     * </pre>
     *
     */
    public Cr006_01M1DTO() {
        // Controller及びServiceでのインスタンス生成の為
    }

    /**
     * <pre>
     * コンストラクター。
     * 引数のDTOの中身を取得しセットします。
     * </pre>
     *
     * @param orig 設定元DTO
     * @throws Exception 例外
     */
    public Cr006_01M1DTO(Cr006_01M1DTO orig) {
        super(orig);
    }

    /**
     * 選択を取得します。
     * 
     * @return 選択
     */
    public String getID_ChkSelect() {
        return ID_ChkSelect;
    }

    /**
     * 選択を設定します。
     * 
     * @param ID_ChkSelect 選択
     */
    public void setID_ChkSelect(String ID_ChkSelect) {
        this.ID_ChkSelect = ID_ChkSelect;
    }

    /**
     * 顧客名を取得します。
     * 
     * @return 顧客名
     */
    public String getID_Name_Customer() {
        return ID_Name_Customer;
    }

    /**
     * 顧客名を設定します。
     * 
     * @param ID_Name_Customer 顧客名
     */
    public void setID_Name_Customer(String ID_Name_Customer) {
        this.ID_Name_Customer = ID_Name_Customer;
    }

    /**
     * 立替日を取得します。
     * 
     * @return 立替日
     */
    public String getID_Date_Karibarai() {
        return ID_Date_Karibarai;
    }

    /**
     * 立替日を設定します。
     * 
     * @param ID_Date_Karibarai 立替日
     */
    public void setID_Date_Karibarai(String ID_Date_Karibarai) {
        this.ID_Date_Karibarai = ID_Date_Karibarai;
    }

    /**
     * 立替金の種類を取得します。
     * 
     * @return 立替金の種類
     */
    public String getID_Code_KanjoKamoku() {
        return ID_Code_KanjoKamoku;
    }

    /**
     * 立替金の種類を設定します。
     * 
     * @param ID_Code_KanjoKamoku 立替金の種類
     */
    public void setID_Code_KanjoKamoku(String ID_Code_KanjoKamoku) {
        this.ID_Code_KanjoKamoku = ID_Code_KanjoKamoku;
    }

    /**
     * 公庫立替金額(円)を取得します。
     * 
     * @return 公庫立替金額(円)
     */
    public String getID_M_ToshoKaribarai() {
        return ID_M_ToshoKaribarai;
    }

    /**
     * 公庫立替金額(円)を設定します。
     * 
     * @param ID_M_ToshoKaribarai 公庫立替金額(円)
     */
    public void setID_M_ToshoKaribarai(String ID_M_ToshoKaribarai) {
        this.ID_M_ToshoKaribarai = ID_M_ToshoKaribarai;
    }

    /**
     * 現在の立替金残高(円)を取得します。
     * 
     * @return 現在の立替金残高(円)
     */
    public String getID_M_KaribaraiZanAfterSeisan() {
        return ID_M_KaribaraiZanAfterSeisan;
    }

    /**
     * 現在の立替金残高(円)を設定します。
     * 
     * @param ID_M_KaribaraiZanAfterSeisan 現在の立替金残高(円)
     */
    public void setID_M_KaribaraiZanAfterSeisan(String ID_M_KaribaraiZanAfterSeisan) {
        this.ID_M_KaribaraiZanAfterSeisan = ID_M_KaribaraiZanAfterSeisan;
    }

    /**
     * 債権管理番号を取得します。
     * 
     * @return 債権管理番号
     */
    public String getID_ID_Credit() {
        return ID_ID_Credit;
    }

    /**
     * 債権管理番号を設定します。
     * 
     * @param ID_ID_Credit 債権管理番号
     */
    public void setID_ID_Credit(String ID_ID_Credit) {
        this.ID_ID_Credit = ID_ID_Credit;
    }

    /**
     * 公庫支店を取得します。
     * 
     * @return 公庫支店
     */
    public String getID_Code_KoukoShiten() {
        return ID_Code_KoukoShiten;
    }

    /**
     * 公庫支店を設定します。
     * 
     * @param ID_Code_KoukoShiten 公庫支店
     */
    public void setID_Code_KoukoShiten(String ID_Code_KoukoShiten) {
        this.ID_Code_KoukoShiten = ID_Code_KoukoShiten;
    }

    /**
     * 扱店を取得します。
     * 
     * @return 扱店
     */
    public String getID_Code_Organization() {
        return ID_Code_Organization;
    }

    /**
     * 扱店を設定します。
     * 
     * @param ID_Code_Organization 扱店
     */
    public void setID_Code_Organization(String ID_Code_Organization) {
        this.ID_Code_Organization = ID_Code_Organization;
    }

    /**
     * 店舗を取得します。
     * 
     * @return 店舗
     */
    public String getID_Code_Tenpo() {
        return ID_Code_Tenpo;
    }

    /**
     * 店舗を設定します。
     * 
     * @param ID_Code_Tenpo 店舗
     */
    public void setID_Code_Tenpo(String ID_Code_Tenpo) {
        this.ID_Code_Tenpo = ID_Code_Tenpo;
    }

    /**
     * 年度を取得します。
     * 
     * @return 年度
     */
    public String getID_Year() {
        return ID_Year;
    }

    /**
     * 年度を設定します。
     * 
     * @param ID_Year 年度
     */
    public void setID_Year(String ID_Year) {
        this.ID_Year = ID_Year;
    }

    /**
     * 方式資金を取得します。
     * 
     * @return 方式資金
     */
    public String getID_Code_HoshikiShikin() {
        return ID_Code_HoshikiShikin;
    }

    /**
     * 方式資金を設定します。
     * 
     * @param ID_Code_HoshikiShikin 方式資金
     */
    public void setID_Code_HoshikiShikin(String ID_Code_HoshikiShikin) {
        this.ID_Code_HoshikiShikin = ID_Code_HoshikiShikin;
    }

    /**
     * 番号を取得します。
     * 
     * @return 番号
     */
    public String getID_ID_Ringi() {
        return ID_ID_Ringi;
    }

    /**
     * 番号を設定します。
     * 
     * @param ID_ID_Ringi 番号
     */
    public void setID_ID_Ringi(String ID_ID_Ringi) {
        this.ID_ID_Ringi = ID_ID_Ringi;
    }

    /**
     * 枝番を取得します。
     * 
     * @return 枝番
     */
    public String getID_ID_RingiBranch() {
        return ID_ID_RingiBranch;
    }

    /**
     * 枝番を設定します。
     * 
     * @param ID_ID_RingiBranch 枝番
     */
    public void setID_ID_RingiBranch(String ID_ID_RingiBranch) {
        this.ID_ID_RingiBranch = ID_ID_RingiBranch;
    }

    /**
     * 貸付先コードを取得します。
     * 
     * @return 貸付先コード
     */
    public String getID_Code_Customer() {
        return ID_Code_Customer;
    }

    /**
     * 貸付先コードを設定します。
     * 
     * @param ID_Code_Customer 貸付先コード
     */
    public void setID_Code_Customer(String ID_Code_Customer) {
        this.ID_Code_Customer = ID_Code_Customer;
    }

    /**
     * 本支店コードを取得します。
     * 
     * @return 本支店コード
     */
    public String getID_Code_HonShiten() {
        return ID_Code_HonShiten;
    }

    /**
     * 本支店コードを設定します。
     * 
     * @param ID_Code_HonShiten 本支店コード
     */
    public void setID_Code_HonShiten(String ID_Code_HonShiten) {
        this.ID_Code_HonShiten = ID_Code_HonShiten;
    }

    /**
     * 仮受仮払番号を取得します。
     * 
     * @return 仮受仮払番号
     */
    public String getID_ID_Karibarai() {
        return ID_ID_Karibarai;
    }

    /**
     * 仮受仮払番号を設定します。
     * 
     * @param ID_ID_Karibarai 仮受仮払番号
     */
    public void setID_ID_Karibarai(String ID_ID_Karibarai) {
        this.ID_ID_Karibarai = ID_ID_Karibarai;
    }

    /**
     * 仮受仮払勘定科目コードを取得します。
     * 
     * @return 仮受仮払勘定科目コード
     */
    public String getCode_KanjoKamoku() {
        return Code_KanjoKamoku;
    }

    /**
     * 仮受仮払勘定科目コードを設定します。
     * 
     * @param Code_KanjoKamoku 仮受仮払勘定科目コード
     */
    public void setCode_KanjoKamoku(String Code_KanjoKamoku) {
        this.Code_KanjoKamoku = Code_KanjoKamoku;
    }

    /**
     * Indexを取得します。
     * 
     * @return Index
     */
    public String getArrayListIndex() {
        return ArrayListIndex;
    }

    /**
     * Indexを設定します。
     * 
     * @param ArrayListIndex Index
     */
    public void setArrayListIndex(String ArrayListIndex) {
        this.ArrayListIndex = ArrayListIndex;
    }

}