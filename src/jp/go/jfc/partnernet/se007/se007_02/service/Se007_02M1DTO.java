//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se007_02M1DTO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/10 | 田旗　秀樹            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se007.se007_02.service;

import org.springframework.format.annotation.NumberFormat;

import jp.go.jfc.partnernet.pnfw.service.dto.PNBaseDTO;

/**
 * <pre>
 * このクラスはse007_02のDTOクラスです。
 * </pre>
 *
 * @author 田旗　秀樹
 * @version 1.0.0
 */
public class Se007_02M1DTO extends PNBaseDTO {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 回 */
    private String ArrayListIndex;
    /** 払込期日年月日 */
    private String ID_Date_Haraikomi;
    /** 約定利息 */
    @NumberFormat(pattern = "#,###")
    private java.math.BigDecimal ID_YakujoRisoku;
    /** 約定元金 */
    @NumberFormat(pattern = "#,###")
    private java.math.BigDecimal ID_YakujoGankin;
    /** 払込後の貸付金残高 */
    @NumberFormat(pattern = "#,###")
    private java.math.BigDecimal ID_HaraikomigoKashitsukeZandaka;
    /** 利子助成額 */
    @NumberFormat(pattern = "#,###")
    private java.math.BigDecimal ID_M_RishiJosei;
    /** 控除利息 */
    @NumberFormat(pattern = "#,###")
    private java.math.BigDecimal ID_M_KojoRisoku;

    /**
     * <pre>
     * コンストラクター。
     * </pre>
     *
     */
    public Se007_02M1DTO() {
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
    public Se007_02M1DTO(Se007_02M1DTO orig) {
        super(orig);
    }

    /**
     * 回を取得します。
     * @return 回
     */
    public String getArrayListIndex() {
        return ArrayListIndex;
    }

    /**
     * 回を設定します。
     * @param ArrayListIndex 回
     */
    public void setArrayListIndex(String ArrayListIndex) {
        this.ArrayListIndex = ArrayListIndex;
    }

    /**
     * 払込期日年月日を取得します。
     * @return 払込期日年月日
     */
    public String getID_Date_Haraikomi() {
        return ID_Date_Haraikomi;
    }

    /**
     * 払込期日年月日を設定します。
     * @param ID_Date_Haraikomi 払込期日年月日
     */
    public void setID_Date_Haraikomi(String ID_Date_Haraikomi) {
        this.ID_Date_Haraikomi = ID_Date_Haraikomi;
    }

    /**
     * 約定利息を取得します。
     * @return 約定利息
     */
    public java.math.BigDecimal getID_YakujoRisoku() {
        return ID_YakujoRisoku;
    }

    /**
     * 約定利息を設定します。
     * @param ID_YakujoRisoku 約定利息
     */
    public void setID_YakujoRisoku(java.math.BigDecimal ID_YakujoRisoku) {
        this.ID_YakujoRisoku = ID_YakujoRisoku;
    }

    /**
     * 約定元金を取得します。
     * @return 約定元金
     */
    public java.math.BigDecimal getID_YakujoGankin() {
        return ID_YakujoGankin;
    }

    /**
     * 約定元金を設定します。
     * @param ID_YakujoGankin 約定元金
     */
    public void setID_YakujoGankin(java.math.BigDecimal ID_YakujoGankin) {
        this.ID_YakujoGankin = ID_YakujoGankin;
    }

    /**
     * 払込後の貸付金残高を取得します。
     * @return 払込後の貸付金残高
     */
    public java.math.BigDecimal getID_HaraikomigoKashitsukeZandaka() {
        return ID_HaraikomigoKashitsukeZandaka;
    }

    /**
     * 払込後の貸付金残高を設定します。
     * @param ID_HaraikomigoKashitsukeZandaka 払込後の貸付金残高
     */
    public void setID_HaraikomigoKashitsukeZandaka(java.math.BigDecimal ID_HaraikomigoKashitsukeZandaka) {
        this.ID_HaraikomigoKashitsukeZandaka = ID_HaraikomigoKashitsukeZandaka;
    }

    /**
     * 利子助成額を取得します。
     * @return 利子助成額
     */
    public java.math.BigDecimal getID_M_RishiJosei() {
        return ID_M_RishiJosei;
    }

    /**
     * 利子助成額を設定します。
     * @param ID_M_RishiJosei 利子助成額
     */
    public void setID_M_RishiJosei(java.math.BigDecimal ID_M_RishiJosei) {
        this.ID_M_RishiJosei = ID_M_RishiJosei;
    }

    /**
     * 控除利息を取得します。
     * @return 控除利息
     */
    public java.math.BigDecimal getID_M_KojoRisoku() {
        return ID_M_KojoRisoku;
    }

    /**
     * 控除利息を設定します。
     * @param ID_M_KojoRisoku 控除利息
     */
    public void setID_M_KojoRisoku(java.math.BigDecimal ID_M_KojoRisoku) {
        this.ID_M_KojoRisoku = ID_M_KojoRisoku;
    }

}