//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Ut003_04DTO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/10/02 | 譚　暁玉              | 新規作成
// 2.0.0   | 2019/01/11 | 林　晃平              | 農林PN元号対応
//==================================================================================================
package jp.go.jfc.partnernet.ut003.ut003_04.service;

import jp.go.jfc.partnernet.pnfw.service.dto.PNBaseDTO;

/**
 * <pre>
 * このクラスはut003_04のDTOクラスです。
 * </pre>
 *
 * @author 林　晃平
 * @version 2.0.0
 */
public class Ut003_04DTO extends PNBaseDTO {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 要領・マニュアル文書一覧 */
    private java.util.List<Ut003_04M1DTO> yoryoManualList = new java.util.ArrayList<Ut003_04M1DTO>(0);
    /** 金利改定情報文書 */
    private Ut003_04M1DTO yoryoManual = new Ut003_04M1DTO();
// [ADD] Ver 2.0.0 - START
    /** 検索開始元号 */
    private String ID_SearchStartGengo;
// [ADD] Ver 2.0.0 - END
    /** 検索開始年(和暦) */
    private String ID_SearchStartYear;
    /** 検索開始月 */
    private String ID_SearchStartMonth;
    /** 検索開始日 */
    private String ID_SearchStartDate;
// [ADD] Ver 2.0.0 - START
    /** 検索終了元号 */
    private String ID_SearchEndGengo;
// [ADD] Ver 2.0.0 - END
    /** 検索終了年(和暦) */
    private String ID_SearchEndYear;
    /** 検索終了月 */
    private String ID_SearchEndMonth;
    /** 検索終了日 */
    private String ID_SearchEndDate;
    /** 要領・マニュアル文書一覧該当件数 */
    private int yoryomanualHitCount;

    /**
     * <pre>
     * コンストラクター。
     * </pre>
     *
     */
    public Ut003_04DTO() {
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
    public Ut003_04DTO(Ut003_04DTO orig) {
        super(orig);
    }

    /**
     * 要領・マニュアル文書一覧を取得します。
     * @return 要領・マニュアル文書一覧
     */
    public java.util.List<Ut003_04M1DTO> getYoryoManualList() {
        return yoryoManualList;
    }

    /**
     * 要領・マニュアル文書一覧を設定します。
     * @param YoryoManualList 要領・マニュアル文書一覧
     */
    public void setYoryoManualList(java.util.List<Ut003_04M1DTO> yoryoManualList) {
        this.yoryoManualList = yoryoManualList;
    }

    /**
     * 要領・マニュアル文書を取得します。
     * @return 要領・マニュアル文書
     */
    public Ut003_04M1DTO getYoryoManual() {
        return yoryoManual;
    }

    /**
     * 要領・マニュアル文書を設定します。
     * @param yoryoManual 要領・マニュアル文書
     */
    public void setYoryoManual(Ut003_04M1DTO yoryoManual) {
        this.yoryoManual = yoryoManual;
    }

// [ADD] Ver 2.0.0 - START
    /**
     * 検索開始元号を取得します。
     * @return 検索開始元号
     */
    public String getID_SearchStartGengo() {
        return ID_SearchStartGengo;
    }

    /**
     * 検索開始元号を設定します。
     * @param ID_SearchStartGengo 検索開始元号
     */
    public void setID_SearchStartGengo(String ID_SearchStartGengo) {
        this.ID_SearchStartGengo = ID_SearchStartGengo;
    }
// [ADD] Ver 2.0.0 - END

    /**
     * 検索開始年(和暦)を取得します。
     * @return 検索開始年(和暦)
     */
    public String getID_SearchStartYear() {
        return ID_SearchStartYear;
    }

    /**
     * 検索開始年(和暦)を設定します。
     * @param ID_SearchStartYear 検索開始年(和暦)
     */
    public void setID_SearchStartYear(String ID_SearchStartYear) {
        this.ID_SearchStartYear = ID_SearchStartYear;
    }

    /**
     * 検索開始月を取得します。
     * @return 検索開始月
     */
    public String getID_SearchStartMonth() {
        return ID_SearchStartMonth;
    }

    /**
     * 検索開始月を設定します。
     * @param ID_SearchStartMonth 検索開始月
     */
    public void setID_SearchStartMonth(String ID_SearchStartMonth) {
        this.ID_SearchStartMonth = ID_SearchStartMonth;
    }

    /**
     * 検索開始日を取得します。
     * @return 検索開始日
     */
    public String getID_SearchStartDate() {
        return ID_SearchStartDate;
    }

    /**
     * 検索開始日を設定します。
     * @param ID_SearchStartDate 検索開始日
     */
    public void setID_SearchStartDate(String ID_SearchStartDate) {
        this.ID_SearchStartDate = ID_SearchStartDate;
    }

// [ADD] Ver 2.0.0 - START
    /**
     * 検索終了元号を取得します。
     * @return 検索終了元号
     */
    public String getID_SearchEndGengo() {
        return ID_SearchEndGengo;
    }

    /**
     * 検索終了元号を設定します。
     * @param ID_SearchEndGengo 検索終了元号
     */
    public void setID_SearchEndGengo(String ID_SearchEndGengo) {
        this.ID_SearchEndGengo = ID_SearchEndGengo;
    }
// [ADD] Ver 2.0.0 - END

    /**
     * 検索終了年(和暦)を取得します。
     * @return 検索終了年(和暦)
     */
    public String getID_SearchEndYear() {
        return ID_SearchEndYear;
    }

    /**
     * 検索終了年(和暦)を設定します。
     * @param ID_SearchEndYear 検索終了年(和暦)
     */
    public void setID_SearchEndYear(String ID_SearchEndYear) {
        this.ID_SearchEndYear = ID_SearchEndYear;
    }

    /**
     * 検索終了月を取得します。
     * @return 検索終了月
     */
    public String getID_SearchEndMonth() {
        return ID_SearchEndMonth;
    }

    /**
     * 検索終了月を設定します。
     * @param ID_SearchEndMonth 検索終了月
     */
    public void setID_SearchEndMonth(String ID_SearchEndMonth) {
        this.ID_SearchEndMonth = ID_SearchEndMonth;
    }

    /**
     * 検索終了日を取得します。
     * @return 検索終了日
     */
    public String getID_SearchEndDate() {
        return ID_SearchEndDate;
    }

    /**
     * 検索終了日を設定します。
     * @param ID_SearchEndDate 検索終了日
     */
    public void setID_SearchEndDate(String ID_SearchEndDate) {
        this.ID_SearchEndDate = ID_SearchEndDate;
    }

    /**
     * 要領・マニュアル文書一覧該当件数を取得します。
     * @param yoryomanualHitCount 要領・マニュアル文書一覧該当件数
     */
    public void setYoryomanualHitCount(int yoryomanualHitCount) {
        this.yoryomanualHitCount = yoryomanualHitCount;
    }

    /**
     * 要領・マニュアル文書一覧該当件数を取得します。
     * @return 要領・マニュアル文書一覧情報該当件数
     */
    public int getYoryomanualHitCount() {
        return yoryomanualHitCount;
    }

}