//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr005_03M1DTO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/14 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr005.cr005_03.service;

import jp.go.jfc.partnernet.pnfw.service.dto.PNBaseDTO;

/**
 * <pre>
 * このクラスはcr005_03のDTOクラスです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public class Cr005_03M1DTO extends PNBaseDTO {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 融資番号 */
    private String ID_Code_Yuushi;
    /** 貸付先コード */
    private String ID_Code_Customer;
    /** 実行年月日 */
    private String ID_Date_Jikko;
    /** 取引停止案件コード */
    private String ID_Code_TorihikiTeishi;
    /** 条変起案中区分 */
    private String ID_Kubun_JohenKianchu;
    /** 債権管理番号 */
    private String ID_ID_Credit;
    /** 所管本支店コード */
    private String Code_ShokanHonShiten;
    /** 扱店コード */
    private String Code_Organization;
    /** 店舗コード */
    private String Code_Tenpo;
    /** 年度 */
    private String Year;
    /** 方式区分 */
    private String Kubun_Hoshiki;
    /** 資金区分 */
    private String Kubun_Shikin;
    /** 稟議番号 */
    private String ID_Ringi;
    /** 稟議番号枝番 */
    private String ID_RingiBranch;
    /** 貸付先名称 */
    private String Name_Customer;
    /** 金融機関名称 */
    private String Name_Organization;

    /**
     * <pre>
     * コンストラクター。
     * </pre>
     *
     */
    public Cr005_03M1DTO() {
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
    public Cr005_03M1DTO(Cr005_03M1DTO orig) {
        super(orig);
    }

    /**
     * 融資番号を取得します。
     * @return 融資番号
     */
    public String getID_Code_Yuushi() {
        return ID_Code_Yuushi;
    }

    /**
     * 融資番号を設定します。
     * @param ID_Code_Yuushi 融資番号
     */
    public void setID_Code_Yuushi(String ID_Code_Yuushi) {
        this.ID_Code_Yuushi = ID_Code_Yuushi;
    }
    /**
     * 貸付先コードを取得します。
     * @return 貸付先コード
     */
    public String getID_Code_Customer() {
        return ID_Code_Customer;
    }

    /**
     * 貸付先コードを設定します。
     * @param ID_Code_Customer 貸付先コード
     */
    public void setID_Code_Customer(String ID_Code_Customer) {
        this.ID_Code_Customer = ID_Code_Customer;
    }
    /**
     * 実行年月日を取得します。
     * @return 実行年月日
     */
    public String getID_Date_Jikko() {
        return ID_Date_Jikko;
    }

    /**
     * 実行年月日を設定します。
     * @param ID_Date_Jikko 実行年月日
     */
    public void setID_Date_Jikko(String ID_Date_Jikko) {
        this.ID_Date_Jikko = ID_Date_Jikko;
    }
    /**
     * 取引停止案件コードを取得します。
     * @return 取引停止案件コード
     */
    public String getID_Code_TorihikiTeishi() {
        return ID_Code_TorihikiTeishi;
    }

    /**
     * 取引停止案件コードを設定します。
     * @param ID_Code_TorihikiTeishi 取引停止案件コード
     */
    public void setID_Code_TorihikiTeishi(String ID_Code_TorihikiTeishi) {
        this.ID_Code_TorihikiTeishi = ID_Code_TorihikiTeishi;
    }
    /**
     * 条変起案中区分を取得します。
     * @return 条変起案中区分
     */
    public String getID_Kubun_JohenKianchu() {
        return ID_Kubun_JohenKianchu;
    }

    /**
     * 条変起案中区分を設定します。
     * @param ID_Kubun_JohenKianchu 条変起案中区分
     */
    public void setID_Kubun_JohenKianchu(String ID_Kubun_JohenKianchu) {
        this.ID_Kubun_JohenKianchu = ID_Kubun_JohenKianchu;
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
     * 所管本支店コードを取得します。
     * @return 所管本支店コード
     */
    public String getCode_ShokanHonShiten() {
        return Code_ShokanHonShiten;
    }

    /**
     * 所管本支店コードを設定します。
     * @param Code_ShokanHonShiten 所管本支店コード
     */
    public void setCode_ShokanHonShiten(String Code_ShokanHonShiten) {
        this.Code_ShokanHonShiten = Code_ShokanHonShiten;
    }
    /**
     * 扱店コードを取得します。
     * @return 扱店コード
     */
    public String getCode_Organization() {
        return Code_Organization;
    }

    /**
     * 扱店コードを設定します。
     * @param Code_Organization 扱店コード
     */
    public void setCode_Organization(String Code_Organization) {
        this.Code_Organization = Code_Organization;
    }
    /**
     * 店舗コードを取得します。
     * @return 店舗コード
     */
    public String getCode_Tenpo() {
        return Code_Tenpo;
    }

    /**
     * 店舗コードを設定します。
     * @param Code_Tenpo 店舗コード
     */
    public void setCode_Tenpo(String Code_Tenpo) {
        this.Code_Tenpo = Code_Tenpo;
    }
    /**
     * 年度を取得します。
     * @return 年度
     */
    public String getYear() {
        return Year;
    }

    /**
     * 年度を設定します。
     * @param Year 年度
     */
    public void setYear(String Year) {
        this.Year = Year;
    }
    /**
     * 方式区分を取得します。
     * @return 方式区分
     */
    public String getKubun_Hoshiki() {
        return Kubun_Hoshiki;
    }

    /**
     * 方式区分を設定します。
     * @param Kubun_Hoshiki 方式区分
     */
    public void setKubun_Hoshiki(String Kubun_Hoshiki) {
        this.Kubun_Hoshiki = Kubun_Hoshiki;
    }
    /**
     * 資金区分を取得します。
     * @return 資金区分
     */
    public String getKubun_Shikin() {
        return Kubun_Shikin;
    }

    /**
     * 資金区分を設定します。
     * @param Kubun_Shikin 資金区分
     */
    public void setKubun_Shikin(String Kubun_Shikin) {
        this.Kubun_Shikin = Kubun_Shikin;
    }
    /**
     * 稟議番号を取得します。
     * @return 稟議番号
     */
    public String getID_Ringi() {
        return ID_Ringi;
    }

    /**
     * 稟議番号を設定します。
     * @param ID_Ringi 稟議番号
     */
    public void setID_Ringi(String ID_Ringi) {
        this.ID_Ringi = ID_Ringi;
    }
    /**
     * 稟議番号枝番を取得します。
     * @return 稟議番号枝番
     */
    public String getID_RingiBranch() {
        return ID_RingiBranch;
    }

    /**
     * 稟議番号枝番を設定します。
     * @param ID_RingiBranch 稟議番号枝番
     */
    public void setID_RingiBranch(String ID_RingiBranch) {
        this.ID_RingiBranch = ID_RingiBranch;
    }
    /**
     * 貸付先名称を取得します。
     * @return 貸付先名称
     */
    public String getName_Customer() {
        return Name_Customer;
    }

    /**
     * 貸付先名称を設定します。
     * @param Name_Customer 貸付先名称
     */
    public void setName_Customer(String Name_Customer) {
        this.Name_Customer = Name_Customer;
    }
    /**
     * 金融機関名称を取得します。
     * @return 金融機関名称
     */
    public String getName_Organization() {
        return Name_Organization;
    }

    /**
     * 金融機関名称を設定します。
     * @param Name_Organization 金融機関名称
     */
    public void setName_Organization(String Name_Organization) {
        this.Name_Organization = Name_Organization;
    }

}