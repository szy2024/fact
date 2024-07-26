//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se006_04DTO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/01 | 田旗　秀樹            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se006.se006_04.service;

import jp.go.jfc.partnernet.pnfw.service.dto.PNBaseDTO;

/**
 * <pre>
 * このクラスはSe006_04のDTOクラスです。
 * </pre>
 *
 * @author 田旗　秀樹
 * @version 1.0.0
 */
public class Se006_04DTO extends PNBaseDTO {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 履歴番号 */
    private String ID_ID_History;

    /** エラーメッセージ */
    private String lblErrorMsg;

    /**
     * <pre>
     * コンストラクター。
     * </pre>
     *
     */
    public Se006_04DTO() {
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
    public Se006_04DTO(Se006_04DTO orig) {
        super(orig);
    }

    /**
     * <pre>
     * 履歴番号を取得します。
     * </pre>
     *
     * @return 履歴番号
     */
    public String getID_ID_History() {
        return ID_ID_History;
    }

    /**
     * <pre>
     * 履歴番号を設定します。
     * </pre>
     *
     * @param ID_ID_History 履歴番号
     */
    public void setID_ID_History(String ID_ID_History) {
        this.ID_ID_History = ID_ID_History;
    }

    /**
     * エラーメッセージを取得します。
     * @return エラーメッセージ
     */
    public String getLblErrorMsg() {
        return lblErrorMsg;
    }

    /**
     * エラーメッセージを設定します。
     * @param lblErrorMsg エラーメッセージ
     */
    public void setLblErrorMsg(String lblErrorMsg) {
        this.lblErrorMsg = lblErrorMsg;
    }

}