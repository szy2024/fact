//==================================================================================================
// Project Name : 農林パートナーネット
// System Name  : JFC Partner Net
// Class Name   : md011_01M1DTO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/09/15 | 林　晃平              | 新規作成（H29年追加開発案件対応）
//==================================================================================================
package jp.go.jfc.partnernet.md011.md011_01.service;

import java.sql.Timestamp;

import jp.go.jfc.partnernet.pnfw.service.dto.PNBaseDTO;

/**
 * <pre>
 * このクラスはmd011_01のDTOクラスです。
 * </pre>
 *
 * @author 林　晃平
 * @version 2.0.0
 */
public class Md011_01M1DTO extends PNBaseDTO {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 依頼予定額 */
    private String txtID_M_Yotei;
    /** 資金交付金残高見込額（指定交付日の前日現在） */
    private String txtID_M_ZanMikomi;
    /** 元金充当額（外数） */
    private String txtID_M_Ganju_GaiSu;
    /** 差引資金交付依頼額 */
    private String lblID_M_Sashihiki_Irai;
    /** 備考 */
    private String txtID_M_Biko;
    /** 更新日時 */
    private Timestamp DateTime_Update;

    /**
     * <pre>
     * コンストラクター。
     * </pre>
     *
     */
    public Md011_01M1DTO() {
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
    public Md011_01M1DTO(Md011_01M1DTO orig) {
        super(orig);
    }

    /**
     * 依頼予定額を取得します。
     * @return 依頼予定額
     */
    public String getTxtID_M_Yotei() {
        return txtID_M_Yotei;
    }

    /**
     * 依頼予定額を設定します。
     * @param txtID_M_Yotei 依頼予定額
     */
    public void setTxtID_M_Yotei(String txtID_M_Yotei) {
        this.txtID_M_Yotei = txtID_M_Yotei;
    }

    /**
     * 資金交付金残高見込額（指定交付日の前日現在）を取得します。
     * @return 資金交付金残高見込額（指定交付日の前日現在）
     */
    public String getTxtID_M_ZanMikomi() {
        return txtID_M_ZanMikomi;
    }

    /**
     * 資金交付金残高見込額（指定交付日の前日現在）を設定します。
     * @param txtID_M_ZanMikomi 資金交付金残高見込額（指定交付日の前日現在）
     */
    public void setTxtID_M_ZanMikomi(String txtID_M_ZanMikomi) {
        this.txtID_M_ZanMikomi = txtID_M_ZanMikomi;
    }

    /**
     * 元金充当額（外数）を取得します。
     * @return 元金充当額（外数）
     */
    public String getTxtID_M_Ganju_GaiSu() {
        return txtID_M_Ganju_GaiSu;
    }

    /**
     * 元金充当額（外数）を設定します。
     * @param txtID_M_Ganju_GaiSu 元金充当額（外数）
     */
    public void setTxtID_M_Ganju_GaiSu(String txtID_M_Ganju_GaiSu) {
        this.txtID_M_Ganju_GaiSu = txtID_M_Ganju_GaiSu;
    }

    /**
     * 差引資金交付依頼額を取得します。
     * @return 差引資金交付依頼額
     */
    public String getLblID_M_Sashihiki_Irai() {
        return lblID_M_Sashihiki_Irai;
    }

    /**
     * 差引資金交付依頼額を設定します。
     * @param lblID_M_Sashihiki_Irai 差引資金交付依頼額
     */
    public void setLblID_M_Sashihiki_Irai(String lblID_M_Sashihiki_Irai) {
        this.lblID_M_Sashihiki_Irai = lblID_M_Sashihiki_Irai;
    }

    /**
     * 備考を取得します。
     * @return 備考
     */
    public String getTxtID_M_Biko() {
        return txtID_M_Biko;
    }

    /**
     * 備考を設定します。
     * @param txtID_M_Biko 備考
     */
    public void setTxtID_M_Biko(String txtID_M_Biko) {
        this.txtID_M_Biko = txtID_M_Biko;
    }

    /**
     * 更新日時を取得します。
     * @return 更新日時
     */
    public Timestamp getDateTime_Update() {
        return DateTime_Update;
    }

    /**
     * 更新日時を設定します。
     * @param DateTime_Update 更新日時
     */
    public void setDateTime_Update(Timestamp DateTime_Update) {
        this.DateTime_Update = DateTime_Update;
    }
}