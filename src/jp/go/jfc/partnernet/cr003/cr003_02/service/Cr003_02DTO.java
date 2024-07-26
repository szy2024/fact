//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr003_02DTO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/13 | 小菱　忠雄            | 新規作成
// 2.0.0   | 2017/11/29 | 林　晃平              | 委託貸付報告等における機能改善対応
//==================================================================================================
package jp.go.jfc.partnernet.cr003.cr003_02.service;

import java.math.BigDecimal;
import java.util.List;

import jp.go.jfc.partnernet.pnfw.service.dto.PNBaseDTO;

/**
 * <pre>
 * このクラスはCr003_02のDTOクラスです。
 * </pre>
 *
 * @author 林　晃平
 * @version 2.0.0
 */
public class Cr003_02DTO extends PNBaseDTO {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** メッセージ２ */
    private String lblMessage2;
    /** 一括入力入金日（元号） */
    private String Dropdownlist1;
    /** 一括入力入金日（年） */
    private String Textbox1;
    /** 一括入力入金日（月） */
    private String Dropdownlist2;
    /** 一括入力入金日（日） */
    private String Dropdownlist3;
    /** 一括入力受託者勘定処理年月(元号) */
    private String Dropdownlist4;
    /** 一括入力受託者勘定処理年月(年) */
    private String Textbox2;
    /** 一括入力受託者勘定処理年月(月) */
    private String Dropdownlist5;
    /** 一括入力送金日（元号） */
    private String Dropdownlist6;
    /** 一括入力送金日（年） */
    private String Textbox3;
    /** 一括入力送金日（月） */
    private String Dropdownlist7;
    /** 一括入力送金日（日） */
    private String Dropdownlist8;
    /** 一括入力送金日番号 */
    private String ID_Soshin_Copy;
    /** 報告年月日 */
    private String lblID_Date_Report;
    /** ステータス */
    private String lblError;
    /** メッセージ */
    private String lblMessage;
    /** 明細 */
    private List<Cr003_02M1DTO> MEISAI_AnkenLIST;
    /** 払込期日 */
    private String Cr003_02Date_Haraikomi;
    /** 債権管理番号（請求データ検索用） */
    private String Cr003_02Seikyu_ID_Credit;
    /** 払込期日（請求データ検索用） */
    private String Cr003_02Seikyu_Date_Haraikomi;
    /** 約定元金 */
    private java.math.BigDecimal M_YakujoGankin;
    /** 債権管理番号(顧客検索用） */
    private String Cr003_02aCustomer_Code_Customer;
    /** 扱店コード（顧客検索用） */
    private String Cr003_02aCustomer_Code_Organization;
    /** 機関コード(金融機関検索用） */
    private String Cr003_02Tenpo_Code_Organization;
    /** データ件数 */
    private BigDecimal Cr003_02Count;
    /** 受託者勘定処理年月設定モード */
    private String lblID_JtkshoriConfigMode;
    /** 業務日付（元号） */
    private String lblID_BizDate_Gengo;
    /** 業務日付（年） */
    private String lblID_BizDate_Nen;
    /** 業務日付（月） */
    private String lblID_BizDate_Tsuki;
    /** 前月業務日付（元号） */
    private String lblID_BizDate_PrevMonth_Gengo;
    /** 前月業務日付（年） */
    private String lblID_BizDate_PrevMonth_Nen;
    /** 前月業務日付（月） */
    private String lblID_BizDate_PrevMonth_Tsuki;

    /**
     * <pre>
     * コンストラクター。
     * </pre>
     *
     */
    public Cr003_02DTO() {
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
    public Cr003_02DTO(Cr003_02DTO orig) {
        super(orig);
    }

    /**
     * メッセージ２を取得します。
     * @return メッセージ２
     */
    public String getLblMessage2() {
        return lblMessage2;
    }

    /**
     * メッセージ２を設定します。
     * @param lblMessage2 メッセージ２
     */
    public void setLblMessage2(String lblMessage2) {
        this.lblMessage2 = lblMessage2;
    }

    /**
     * 一括入力入金日（元号）を取得します。
     * @return 一括入力入金日（元号）
     */
    public String getDropdownlist1() {
        return Dropdownlist1;
    }

    /**
     * 一括入力入金日（元号）を設定します。
     * @param Dropdownlist1 一括入力入金日（元号）
     */
    public void setDropdownlist1(String Dropdownlist1) {
        this.Dropdownlist1 = Dropdownlist1;
    }

    /**
     * 一括入力入金日（年）を取得します。
     * @return 一括入力入金日（年）
     */
    public String getTextbox1() {
        return Textbox1;
    }

    /**
     * 一括入力入金日（年）を設定します。
     * @param Textbox1 一括入力入金日（年）
     */
    public void setTextbox1(String Textbox1) {
        this.Textbox1 = Textbox1;
    }

    /**
     * 一括入力入金日（月）を取得します。
     * @return 一括入力入金日（月）
     */
    public String getDropdownlist2() {
        return Dropdownlist2;
    }

    /**
     * 一括入力入金日（月）を設定します。
     * @param Dropdownlist2 一括入力入金日（月）
     */
    public void setDropdownlist2(String Dropdownlist2) {
        this.Dropdownlist2 = Dropdownlist2;
    }

    /**
     * 一括入力入金日（日）を取得します。
     * @return 一括入力入金日（日）
     */
    public String getDropdownlist3() {
        return Dropdownlist3;
    }

    /**
     * 一括入力入金日（日）を設定します。
     * @param Dropdownlist3 一括入力入金日（日）
     */
    public void setDropdownlist3(String Dropdownlist3) {
        this.Dropdownlist3 = Dropdownlist3;
    }

    /**
     * 一括入力受託者勘定処理年月(元号)を取得します。
     * @return 一括入力受託者勘定処理年月(元号)
     */
    public String getDropdownlist4() {
        return Dropdownlist4;
    }

    /**
     * 一括入力受託者勘定処理年月(元号)を設定します。
     * @param Dropdownlist4 一括入力受託者勘定処理年月(元号)
     */
    public void setDropdownlist4(String Dropdownlist4) {
        this.Dropdownlist4 = Dropdownlist4;
    }

    /**
     * 一括入力受託者勘定処理年月(年)を取得します。
     * @return 一括入力受託者勘定処理年月(年)
     */
    public String getTextbox2() {
        return Textbox2;
    }

    /**
     * 一括入力受託者勘定処理年月(年)を設定します。
     * @param Textbox2 一括入力受託者勘定処理年月(年)
     */
    public void setTextbox2(String Textbox2) {
        this.Textbox2 = Textbox2;
    }

    /**
     * 一括入力受託者勘定処理年月(月)を取得します。
     * @return 一括入力受託者勘定処理年月(月)
     */
    public String getDropdownlist5() {
        return Dropdownlist5;
    }

    /**
     * 一括入力受託者勘定処理年月(月)を設定します。
     * @param Dropdownlist5 一括入力受託者勘定処理年月(月)
     */
    public void setDropdownlist5(String Dropdownlist5) {
        this.Dropdownlist5 = Dropdownlist5;
    }

    /**
     * 一括入力送金日（元号）を取得します。
     * @return 一括入力送金日（元号）
     */
    public String getDropdownlist6() {
        return Dropdownlist6;
    }

    /**
     * 一括入力送金日（元号）を設定します。
     * @param Dropdownlist6 一括入力送金日（元号）
     */
    public void setDropdownlist6(String Dropdownlist6) {
        this.Dropdownlist6 = Dropdownlist6;
    }

    /**
     * 一括入力送金日（年）を取得します。
     * @return 一括入力送金日（年）
     */
    public String getTextbox3() {
        return Textbox3;
    }

    /**
     * 一括入力送金日（年）を設定します。
     * @param Textbox3 一括入力送金日（年）
     */
    public void setTextbox3(String Textbox3) {
        this.Textbox3 = Textbox3;
    }

    /**
     * 一括入力送金日（月）を取得します。
     * @return 一括入力送金日（月）
     */
    public String getDropdownlist7() {
        return Dropdownlist7;
    }

    /**
     * 一括入力送金日（月）を設定します。
     * @param Dropdownlist7 一括入力送金日（月）
     */
    public void setDropdownlist7(String Dropdownlist7) {
        this.Dropdownlist7 = Dropdownlist7;
    }

    /**
     * 一括入力送金日（日）を取得します。
     * @return 一括入力送金日（日）
     */
    public String getDropdownlist8() {
        return Dropdownlist8;
    }

    /**
     * 一括入力送金日（日）を設定します。
     * @param Dropdownlist8 一括入力送金日（日）
     */
    public void setDropdownlist8(String Dropdownlist8) {
        this.Dropdownlist8 = Dropdownlist8;
    }

    /**
     * 一括入力送金日番号を取得します。
     * @return 一括入力送金日番号
     */
    public String getID_Soshin_Copy() {
        return ID_Soshin_Copy;
    }

    /**
     * 一括入力送金日番号を設定します。
     * @param ID_Soshin_Copy 一括入力送金日番号
     */
    public void setID_Soshin_Copy(String ID_Soshin_Copy) {
        this.ID_Soshin_Copy = ID_Soshin_Copy;
    }

    /**
     * 報告年月日を取得します。
     * @return 報告年月日
     */
    public String getLblID_Date_Report() {
        return lblID_Date_Report;
    }

    /**
     * 報告年月日を設定します。
     * @param lblID_Date_Report 報告年月日
     */
    public void setLblID_Date_Report(String lblID_Date_Report) {
        this.lblID_Date_Report = lblID_Date_Report;
    }

    /**
     * ステータスを取得します。
     * @return ステータス
     */
    public String getLblError() {
        return lblError;
    }

    /**
     * ステータスを設定します。
     * @param lblError ステータス
     */
    public void setLblError(String lblError) {
        this.lblError = lblError;
    }

    /**
     * メッセージを取得します。
     * @return メッセージ
     */
    public String getLblMessage() {
        return lblMessage;
    }

    /**
     * メッセージを設定します。
     * @param lblMessage メッセージ
     */
    public void setLblMessage(String lblMessage) {
        this.lblMessage = lblMessage;
    }

    /**
     * 明細を取得します。
     * @return 明細
     */
    public List<Cr003_02M1DTO> getMEISAI_AnkenLIST() {
        return MEISAI_AnkenLIST;
    }

    /**
     * 明細を設定します。
     * @param MEISAI_AnkenLIST 明細
     */
    public void setMEISAI_AnkenLIST(List<Cr003_02M1DTO> MEISAI_AnkenLIST) {
        this.MEISAI_AnkenLIST = MEISAI_AnkenLIST;
    }

    /**
     * 払込期日を取得します。
     * @return 払込期日
     */
    public String getCr003_02Date_Haraikomi() {
        return Cr003_02Date_Haraikomi;
    }

    /**
     * 払込期日を設定します。
     * @param Cr003_02Date_Haraikomi 払込期日
     */
    public void setCr003_02Date_Haraikomi(String Cr003_02Date_Haraikomi) {
        this.Cr003_02Date_Haraikomi = Cr003_02Date_Haraikomi;
    }

    /**
     * 債権管理番号（請求データ検索用）を取得します。
     * @return 債権管理番号（請求データ検索用）
     */
    public String getCr003_02Seikyu_ID_Credit() {
        return Cr003_02Seikyu_ID_Credit;
    }

    /**
     * 債権管理番号（請求データ検索用）を設定します。
     * @param Cr003_02Seikyu_ID_Credit 債権管理番号（請求データ検索用）
     */
    public void setCr003_02Seikyu_ID_Credit(String Cr003_02Seikyu_ID_Credit) {
        this.Cr003_02Seikyu_ID_Credit = Cr003_02Seikyu_ID_Credit;
    }

    /**
     * 払込期日（請求データ検索用）を取得します。
     * @return 払込期日（請求データ検索用）
     */
    public String getCr003_02Seikyu_Date_Haraikomi() {
        return Cr003_02Seikyu_Date_Haraikomi;
    }

    /**
     * 払込期日（請求データ検索用）を設定します。
     * @param Cr003_02Seikyu_Date_Haraikomi 払込期日（請求データ検索用）
     */
    public void setCr003_02Seikyu_Date_Haraikomi(String Cr003_02Seikyu_Date_Haraikomi) {
        this.Cr003_02Seikyu_Date_Haraikomi = Cr003_02Seikyu_Date_Haraikomi;
    }

    /**
     * 約定元金を取得します。
     * @return 約定元金
     */
    public java.math.BigDecimal getM_YakujoGankin() {
        return M_YakujoGankin;
    }

    /**
     * 約定元金を設定します。
     * @param M_YakujoGankin 約定元金
     */
    public void setM_YakujoGankin(java.math.BigDecimal M_YakujoGankin) {
        this.M_YakujoGankin = M_YakujoGankin;
    }

    /**
     * 債権管理番号(顧客検索用）を取得します。
     * @return 債権管理番号(顧客検索用）
     */
    public String getCr003_02aCustomer_Code_Customer() {
        return Cr003_02aCustomer_Code_Customer;
    }

    /**
     * 債権管理番号(顧客検索用）を設定します。
     * @param Cr003_02aCustomer_ID_Credit 債権管理番号(顧客検索用）
     */
    public void setCr003_02aCustomer_Code_Customer(String Cr003_02aCustomer_Code_Customer) {
        this.Cr003_02aCustomer_Code_Customer = Cr003_02aCustomer_Code_Customer;
    }

    /**
     * 扱店コード（顧客検索用）を取得します。
     * @return 扱店コード（顧客検索用）
     */
    public String getCr003_02aCustomer_Code_Organization() {
        return Cr003_02aCustomer_Code_Organization;
    }

    /**
     * 扱店コード（顧客検索用）を設定します。
     * @param Cr003_02aCustomer_Code_Organization 扱店コード（顧客検索用）
     */
    public void setCr003_02aCustomer_Code_Organization(String Cr003_02aCustomer_Code_Organization) {
        this.Cr003_02aCustomer_Code_Organization = Cr003_02aCustomer_Code_Organization;
    }

    /**
     * 機関コード(金融機関検索用）を取得します。
     * @return 機関コード(金融機関検索用）
     */
    public String getCr003_02Tenpo_Code_Organization() {
        return Cr003_02Tenpo_Code_Organization;
    }

    /**
     * 機関コード(金融機関検索用）を設定します。
     * @param Cr003_02Tenpo_Code_Organization 機関コード(金融機関検索用）
     */
    public void setCr003_02Tenpo_Code_Organization(String Cr003_02Tenpo_Code_Organization) {
        this.Cr003_02Tenpo_Code_Organization = Cr003_02Tenpo_Code_Organization;
    }

    /**
     * データ件数を取得します。
     * @return データ件数
     */
    public BigDecimal getCr003_02Count() {
        return Cr003_02Count;
    }

    /**
     * データ件数を設定します。
     * @param Cr003_02Count データ件数
     */
    public void setCr003_02Count(BigDecimal Cr003_02Count) {
        this.Cr003_02Count = Cr003_02Count;
    }

    /**
     * 受託者勘定処理年月設定モードを取得します。
     *
     * @return 受託者勘定処理年月設定モード
     */
    public String getLblID_JtkshoriConfigMode() {
        return lblID_JtkshoriConfigMode;
    }

    /**
     * 受託者勘定処理年月設定モードを設定します。
     *
     * @param lblID_JtkshoriConfigMode 受託者勘定処理年月設定モード
     */
    public void setLblID_JtkshoriConfigMode(String lblID_JtkshoriConfigMode) {
        this.lblID_JtkshoriConfigMode = lblID_JtkshoriConfigMode;
    }

    /**
     * 業務日付（元号）を取得します。
     *
     * @return 業務日付（元号）
     */
    public String getLblID_BizDate_Gengo() {
        return lblID_BizDate_Gengo;
    }

    /**
     * 業務日付（元号）を設定します。
     *
     * @param lblID_BizDate_Gengo 業務日付（元号）
     */
    public void setLblID_BizDate_Gengo(String lblID_BizDate_Gengo) {
        this.lblID_BizDate_Gengo = lblID_BizDate_Gengo;
    }

    /**
     * 業務日付（年）を取得します。
     *
     * @return 業務日付（年）
     */
    public String getLblID_BizDate_Nen() {
        return lblID_BizDate_Nen;
    }

    /**
     * 業務日付（年）を設定します。
     *
     * @param lblID_BizDate_Nen 業務日付（年）
     */
    public void setLblID_BizDate_Nen(String lblID_BizDate_Nen) {
        this.lblID_BizDate_Nen = lblID_BizDate_Nen;
    }

    /**
     * 業務日付（月）を取得します。
     *
     * @return 業務日付（月）
     */
    public String getLblID_BizDate_Tsuki() {
        return lblID_BizDate_Tsuki;
    }

    /**
     * 業務日付（月）を設定します。
     *
     * @param lblID_BizDate_Tsuki 業務日付（月）
     */
    public void setLblID_BizDate_Tsuki(String lblID_BizDate_Tsuki) {
        this.lblID_BizDate_Tsuki = lblID_BizDate_Tsuki;
    }

    /**
     * 前月業務日付（元号）を取得します。
     *
     * @return 前月業務日付（元号）
     */
    public String getLblID_BizDate_PrevMonth_Gengo() {
        return lblID_BizDate_PrevMonth_Gengo;
    }

    /**
     * 前月業務日付（元号）を設定します。
     *
     * @param lblID_BizDate_PrevMonth_Gengo 前月業務日付（元号）
     */
    public void setLblID_BizDate_PrevMonth_Gengo(String lblID_BizDate_PrevMonth_Gengo) {
        this.lblID_BizDate_PrevMonth_Gengo = lblID_BizDate_PrevMonth_Gengo;
    }

    /**
     * 前月業務日付（年）を取得します。
     *
     * @return 前月業務日付（年）
     */
    public String getLblID_BizDate_PrevMonth_Nen() {
        return lblID_BizDate_PrevMonth_Nen;
    }

    /**
     * 前月業務日付（年）を設定します。
     *
     * @param lblID_BizDate_PrevMonth_Nen 前月業務日付（年）
     */
    public void setLblID_BizDate_PrevMonth_Nen(String lblID_BizDate_PrevMonth_Nen) {
        this.lblID_BizDate_PrevMonth_Nen = lblID_BizDate_PrevMonth_Nen;
    }

    /**
     * 前月業務日付（月）を取得します。
     *
     * @return 前月業務日付（月）
     */
    public String getLblID_BizDate_PrevMonth_Tsuki() {
        return lblID_BizDate_PrevMonth_Tsuki;
    }

    /**
     * 前月業務日付（月）を設定します。
     *
     * @param lblID_BizDate_PrevMonth_Tsuki 前月業務日付（月）
     */
    public void setLblID_BizDate_PrevMonth_Tsuki(String lblID_BizDate_PrevMonth_Tsuki) {
        this.lblID_BizDate_PrevMonth_Tsuki = lblID_BizDate_PrevMonth_Tsuki;
    }
}