//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se005_01M1DTO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/28 | 田旗　秀樹            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se005.se005_01.service;

import jp.go.jfc.partnernet.pnfw.service.dto.PNBaseDTO;

/**
 * <pre>
 * このクラスはSe005_01のDTOクラスです。
 * </pre>
 *
 * @author 田旗　秀樹
 * @version 1.0.0
 */
public class Se005_01M1DTO extends PNBaseDTO {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 顧客名 */
    private String ID_Expr2;
    /** 公庫支店名 */
    private String ID_Expr1;
    /** 扱店 */
    private String ID_Code_Organization;
    /** 店舗 */
    private String ID_Code_Tenpo;
    /** 年度 */
    private String ID_Year;
    /** 方式資金 */
    private String ID_Expr3;
    /** 番号 */
    private String ID_ID_Ringi;
    /** 枝番 */
    private String ID_ID_RingiBranch;
    /** 農協コード */
    private String ID_Code_Noukyou;
    /** 貸付実行日 */
    private String ID_Date_Jikko;
    /** 貸付金額 */
    private String ID_M_Kashitsuke;
    /** 資金使途名 */
    private String ID_Code_ShikinShito;
    /** 利率 */
    private String ID_Riritsu;
    /** 特利コード */
    private String ID_Kubun_Tokuri;
    /** 特利 */
    private String ID_Tokuri;
    /** 指標率 */
    private String ID_Shihyoritsu;
    /** 据置期限 */
    private String ID_Date_SueokiKigen;
    /** 償還期限 */
    private String ID_Date_ShokanKigen;
    /** 元利金払込日 */
    private String ID_Date_GanrikinHaraiKomi;
    /** 償還方法 */
    private String ID_Code_ShokanHouhou;
    /** 調整コード */
    private String ID_Kubun_GankinFukintogaku;
    /** 元利金又は元金均等額 */
    private String ID_M_Fukin;
    /** 貸付金残高 */
    private String ID_M_KashitsukeZandaka;
    /** 債権管理番号 */
    private String ID_ID_Credit;
    /** 行番号 */
    private String array_list_index;

    /**
     * <pre>
     * コンストラクター。
     * </pre>
     *
     */
    public Se005_01M1DTO() {
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
    public Se005_01M1DTO(Se005_01M1DTO orig) {
        super(orig);
    }

    /**
     * 顧客名を取得します。
     * @return 顧客名
     */
    public String getID_Expr2() {
        return ID_Expr2;
    }

    /**
     * 顧客名を設定します。
     * @param ID_Expr2 顧客名
     */
    public void setID_Expr2(String ID_Expr2) {
        this.ID_Expr2 = ID_Expr2;
    }

    /**
     * 公庫支店名を取得します。
     * @return 公庫支店名
     */
    public String getID_Expr1() {
        return ID_Expr1;
    }

    /**
     * 公庫支店名を設定します。
     * @param ID_Expr1 公庫支店名
     */
    public void setID_Expr1(String ID_Expr1) {
        this.ID_Expr1 = ID_Expr1;
    }

    /**
     * 扱店を取得します。
     * @return 扱店
     */
    public String getID_Code_Organization() {
        return ID_Code_Organization;
    }

    /**
     * 扱店を設定します。
     * @param ID_Code_Organization 扱店
     */
    public void setID_Code_Organization(String ID_Code_Organization) {
        this.ID_Code_Organization = ID_Code_Organization;
    }

    /**
     * 店舗を取得します。
     * @return 店舗
     */
    public String getID_Code_Tenpo() {
        return ID_Code_Tenpo;
    }

    /**
     * 店舗を設定します。
     * @param ID_Code_Tenpo 店舗
     */
    public void setID_Code_Tenpo(String ID_Code_Tenpo) {
        this.ID_Code_Tenpo = ID_Code_Tenpo;
    }

    /**
     * 年度を取得します。
     * @return 年度
     */
    public String getID_Year() {
        return ID_Year;
    }

    /**
     * 年度を設定します。
     * @param ID_Year 年度
     */
    public void setID_Year(String ID_Year) {
        this.ID_Year = ID_Year;
    }

    /**
     * 方式資金を取得します。
     * @return 方式資金
     */
    public String getID_Expr3() {
        return ID_Expr3;
    }

    /**
     * 方式資金を設定します。
     * @param ID_Expr3 方式資金
     */
    public void setID_Expr3(String ID_Expr3) {
        this.ID_Expr3 = ID_Expr3;
    }

    /**
     * 番号を取得します。
     * @return 番号
     */
    public String getID_ID_Ringi() {
        return ID_ID_Ringi;
    }

    /**
     * 番号を設定します。
     * @param ID_ID_Ringi 番号
     */
    public void setID_ID_Ringi(String ID_ID_Ringi) {
        this.ID_ID_Ringi = ID_ID_Ringi;
    }

    /**
     * 枝番を取得します。
     * @return 枝番
     */
    public String getID_ID_RingiBranch() {
        return ID_ID_RingiBranch;
    }

    /**
     * 枝番を設定します。
     * @param ID_ID_RingiBranch 枝番
     */
    public void setID_ID_RingiBranch(String ID_ID_RingiBranch) {
        this.ID_ID_RingiBranch = ID_ID_RingiBranch;
    }

    /**
     * 農協コードを取得します。
     * @return 農協コード
     */
    public String getID_Code_Noukyou() {
        return ID_Code_Noukyou;
    }

    /**
     * 農協コードを設定します。
     * @param ID_Code_Noukyou 農協コード
     */
    public void setID_Code_Noukyou(String ID_Code_Noukyou) {
        this.ID_Code_Noukyou = ID_Code_Noukyou;
    }

    /**
     * 貸付実行日を取得します。
     * @return 貸付実行日
     */
    public String getID_Date_Jikko() {
        return ID_Date_Jikko;
    }

    /**
     * 貸付実行日を設定します。
     * @param ID_Date_Jikko 貸付実行日
     */
    public void setID_Date_Jikko(String ID_Date_Jikko) {
        this.ID_Date_Jikko = ID_Date_Jikko;
    }

    /**
     * 貸付金額を取得します。
     * @return 貸付金額
     */
    public String getID_M_Kashitsuke() {
        return ID_M_Kashitsuke;
    }

    /**
     * 貸付金額を設定します。
     * @param string 貸付金額
     */
    public void setID_M_Kashitsuke(String string) {
        this.ID_M_Kashitsuke = string;
    }

    /**
     * 資金使途名を取得します。
     * @return 資金使途名
     */
    public String getID_Code_ShikinShito() {
        return ID_Code_ShikinShito;
    }

    /**
     * 資金使途名を設定します。
     * @param ID_Code_ShikinShito 資金使途名
     */
    public void setID_Code_ShikinShito(String ID_Code_ShikinShito) {
        this.ID_Code_ShikinShito = ID_Code_ShikinShito;
    }

    /**
     * 利率を取得します。
     * @return 利率
     */
    public String getID_Riritsu() {
        return ID_Riritsu;
    }

    /**
     * 利率を設定します。
     * @param ID_Riritsu 利率
     */
    public void setID_Riritsu(String ID_Riritsu) {
        this.ID_Riritsu = ID_Riritsu;
    }

    /**
     * 特利コードを取得します。
     * @return 特利コード
     */
    public String getID_Kubun_Tokuri() {
        return ID_Kubun_Tokuri;
    }

    /**
     * 特利コードを設定します。
     * @param ID_Kubun_Tokuri 特利コード
     */
    public void setID_Kubun_Tokuri(String ID_Kubun_Tokuri) {
        this.ID_Kubun_Tokuri = ID_Kubun_Tokuri;
    }

    /**
     * 特利を取得します。
     * @return 特利
     */
    public String getID_Tokuri() {
        return ID_Tokuri;
    }

    /**
     * 特利を設定します。
     * @param ID_Tokuri 特利
     */
    public void setID_Tokuri(String ID_Tokuri) {
        this.ID_Tokuri = ID_Tokuri;
    }

    /**
     * 指標率を取得します。
     * @return 指標率
     */
    public String getID_Shihyoritsu() {
        return ID_Shihyoritsu;
    }

    /**
     * 指標率を設定します。
     * @param ID_Shihyoritsu 指標率
     */
    public void setID_Shihyoritsu(String ID_Shihyoritsu) {
        this.ID_Shihyoritsu = ID_Shihyoritsu;
    }

    /**
     * 据置期限を取得します。
     * @return 据置期限
     */
    public String getID_Date_SueokiKigen() {
        return ID_Date_SueokiKigen;
    }

    /**
     * 据置期限を設定します。
     * @param ID_Date_SueokiKigen 据置期限
     */
    public void setID_Date_SueokiKigen(String ID_Date_SueokiKigen) {
        this.ID_Date_SueokiKigen = ID_Date_SueokiKigen;
    }

    /**
     * 償還期限を取得します。
     * @return 償還期限
     */
    public String getID_Date_ShokanKigen() {
        return ID_Date_ShokanKigen;
    }

    /**
     * 償還期限を設定します。
     * @param ID_Date_ShokanKigen 償還期限
     */
    public void setID_Date_ShokanKigen(String ID_Date_ShokanKigen) {
        this.ID_Date_ShokanKigen = ID_Date_ShokanKigen;
    }

    /**
     * 元利金払込日を取得します。
     * @return 元利金払込日
     */
    public String getID_Date_GanrikinHaraiKomi() {
        return ID_Date_GanrikinHaraiKomi;
    }

    /**
     * 元利金払込日を設定します。
     * @param ID_Date_GanrikinHaraiKomi 元利金払込日
     */
    public void setID_Date_GanrikinHaraiKomi(String ID_Date_GanrikinHaraiKomi) {
        this.ID_Date_GanrikinHaraiKomi = ID_Date_GanrikinHaraiKomi;
    }

    /**
     * 償還方法を取得します。
     * @return 償還方法
     */
    public String getID_Code_ShokanHouhou() {
        return ID_Code_ShokanHouhou;
    }

    /**
     * 償還方法を設定します。
     * @param ID_Code_ShokanHouhou 償還方法
     */
    public void setID_Code_ShokanHouhou(String ID_Code_ShokanHouhou) {
        this.ID_Code_ShokanHouhou = ID_Code_ShokanHouhou;
    }

    /**
     * 調整コードを取得します。
     * @return 調整コード
     */
    public String getID_Kubun_GankinFukintogaku() {
        return ID_Kubun_GankinFukintogaku;
    }

    /**
     * 調整コードを設定します。
     * @param ID_Kubun_GankinFukintogaku 調整コード
     */
    public void setID_Kubun_GankinFukintogaku(String ID_Kubun_GankinFukintogaku) {
        this.ID_Kubun_GankinFukintogaku = ID_Kubun_GankinFukintogaku;
    }

    /**
     * 元利金又は元金均等額を取得します。
     * @return 元利金又は元金均等額
     */
    public String getID_M_Fukin() {
        return ID_M_Fukin;
    }

    /**
     * 元利金又は元金均等額を設定します。
     * @param string 元利金又は元金均等額
     */
    public void setID_M_Fukin(String string) {
        this.ID_M_Fukin = string;
    }

    /**
     * 貸付金残高を取得します。
     * @return 貸付金残高
     */
    public String getID_M_KashitsukeZandaka() {
        return ID_M_KashitsukeZandaka;
    }

    /**
     * 貸付金残高を設定します。
     * @param string 貸付金残高
     */
    public void setID_M_KashitsukeZandaka(String string) {
        this.ID_M_KashitsukeZandaka = string;
    }

    /**
     * 債権管理番号を取得します。
     * @return 債権管理番号
     */
    public String getID_ID_Credit() {
        return ID_ID_Credit;
    }

    /**
     * 債権管理番号を設定します。
     * @param ID_ID_Credit 債権管理番号
     */
    public void setID_ID_Credit(String ID_ID_Credit) {
        this.ID_ID_Credit = ID_ID_Credit;
    }

    /**
     * 行番号を取得します。
     * @return メッセージ
     */
    public String getArray_list_index() {
        return array_list_index;
    }

    /**
     * 行番号を設定します。
     * @param errormessage メッセージ
     */
    public void setArray_list_index(String array_list_index) {
        this.array_list_index = array_list_index;
    }

}