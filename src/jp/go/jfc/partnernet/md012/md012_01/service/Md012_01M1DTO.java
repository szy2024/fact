//==================================================================================================
// Project Name : 農林パートナーネット
// System Name  : JFC Partner Net
// Class Name   : Md012_01M1DTO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/09/15 | 木村　しのぶ          | 新規作成（H29年追加開発案件対応）
//==================================================================================================
package jp.go.jfc.partnernet.md012.md012_01.service;

import jp.go.jfc.partnernet.pnfw.service.dto.PNBaseDTO;

/**
 * <pre>
 * このクラスはmd012_01のDTOクラスです。
 * </pre>
 *
 * @author 木村　しのぶ
 * @version 2.0.0
 */
public class Md012_01M1DTO extends PNBaseDTO {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 包括委任状数量 */
    private String txtID_Su_HokatsuInin;
    /** 現在事項一部証明書数量 */
    private String txtID_Su_GenzaiJiko;
    /** 印鑑証明書数量 */
    private String txtID_Su_InkanShohmei;
    /** 変更抄本数量 */
    private String txtID_Su_HenkoShohhon;
    /** 新閉鎖謄本数量 */
    private String txtID_Su_SinHeisa;
    /** 旧閉鎖抄本数量 */
    private String txtID_Su_KyuHeisa;
    /** 閉鎖事項全部証明書数量 */
    private String txtID_Su_HeisaJiko;
    /** 至急発行チェックボックス */
    private String chkID_ShikyuHakko;

    /**
     * <pre>
     * コンストラクター。
     * </pre>
     *
     */
    public Md012_01M1DTO() {
        // Controller及びServiceでのインスタンス生成の為
    }

    /**
     * <pre>
     * コンストラクター。
     * 引数のDTOの中身を取得しセットします。
     * </pre>
     *
     * @param orig
     *            設定元DTO
     * @throws Exception
     *             例外
     */
    public Md012_01M1DTO(Md012_01M1DTO orig) {
        super(orig);
    }

    /**
     * 包括委任状数量を取得します。
     *
     * @return 包括委任状数量
     */
    public String getTxtID_Su_HokatsuInin() {
        return txtID_Su_HokatsuInin;
    }

    /**
     * 包括委任状数量を設定します。
     *
     * @param txtid_su_hokatsuinin
     *            包括委任状数量
     */
    public void setTxtID_Su_HokatsuInin(String txtID_Su_HokatsuInin) {
        this.txtID_Su_HokatsuInin = txtID_Su_HokatsuInin;
    }

    /**
     * 現在事項一部証明書数量を取得します。
     *
     * @return 現在事項一部証明書数量
     */
    public String getTxtID_Su_GenzaiJiko() {
        return txtID_Su_GenzaiJiko;
    }

    /**
     * 現在事項一部証明書数量を設定します。
     *
     * @param txtid_su_genzaijiko
     *            現在事項一部証明書数量
     */
    public void setTxtID_Su_GenzaiJiko(String txtid_su_genzaijiko) {
        this.txtID_Su_GenzaiJiko = txtid_su_genzaijiko;
    }

    /**
     * 印鑑証明書数量を取得します。
     *
     * @return 印鑑証明書数量
     */
    public String getTxtID_Su_InkanShohmei() {
        return txtID_Su_InkanShohmei;
    }

    /**
     * 印鑑証明書数量を設定します。
     *
     * @param txtid_su_inkanshohmei
     *            印鑑証明書数量
     */
    public void setTxtID_Su_InkanShohmei(String txtid_su_inkanshohmei) {
        this.txtID_Su_InkanShohmei = txtid_su_inkanshohmei;
    }

    /**
     * 変更抄本数量を取得します。
     *
     * @return 変更抄本数量
     */
    public String getTxtID_Su_HenkoShohhon() {
        return txtID_Su_HenkoShohhon;
    }

    /**
     * 変更抄本数量を設定します。
     *
     * @param txtid_su_henkoshohon
     *            変更抄本数量
     */
    public void setTxtID_Su_HenkoShohhon(String txtid_su_henkoshohon) {
        this.txtID_Su_HenkoShohhon = txtid_su_henkoshohon;
    }

    /**
     * 新閉鎖謄本数量を取得します。
     *
     * @return 新閉鎖謄本数量
     */
    public String getTxtID_Su_SinHeisa() {
        return txtID_Su_SinHeisa;
    }

    /**
     * 新閉鎖謄本数量を設定します。
     *
     * @param txtid_su_sinheisa
     *            新閉鎖謄本数量
     */
    public void setTxtID_Su_SinHeisa(String txtid_su_sinheisa) {
        this.txtID_Su_SinHeisa = txtid_su_sinheisa;
    }

    /**
     * 旧閉鎖抄本数量を取得します。
     *
     * @return 旧閉鎖抄本数量
     */
    public String getTxtID_Su_KyuHeisa() {
        return txtID_Su_KyuHeisa;
    }

    /**
     * 旧閉鎖抄本数量を設定します。
     *
     * @param txtid_su_kyuheisa
     *            旧閉鎖抄本数量
     */
    public void setTxtID_Su_KyuHeisa(String txtid_su_kyuheisa) {
        this.txtID_Su_KyuHeisa = txtid_su_kyuheisa;
    }

    /**
     * 閉鎖事項全部証明書数量を取得します。
     *
     * @return 閉鎖事項全部証明書数量
     */
    public String getTxtID_Su_HeisaJiko() {
        return txtID_Su_HeisaJiko;
    }

    /**
     * 閉鎖事項全部証明書数量を設定します。
     *
     * @param txtid_su_heisajiko
     *            閉鎖事項全部証明書数量
     */
    public void setTxtID_Su_HeisaJiko(String txtid_su_heisajiko) {
        this.txtID_Su_HeisaJiko = txtid_su_heisajiko;
    }

    /**
     * 至急発行チェックボックスを取得します。
     *
     * @return 至急発行チェックボックス
     */
    public String getChkID_ShikyuHakko() {
        return chkID_ShikyuHakko;
    }

    /**
     * 至急発行チェックボックスを設定します。
     *
     * @param chkid_shikyuhakko
     *            至急発行チェックボックス
     */
    public void setChkID_ShikyuHakko(String chkid_shikyuhakko) {
        this.chkID_ShikyuHakko = chkid_shikyuhakko;
    }

}