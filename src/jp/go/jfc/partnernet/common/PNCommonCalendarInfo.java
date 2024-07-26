//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : PNCommonCalendarInfo
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.1.0   | 2018/12/17 | 林　晃平              | 新規作成(農林PN元号対応)
//==================================================================================================
package jp.go.jfc.partnernet.common;

import java.util.ArrayList;

/**
 * <pre>
 * 元号情報
 * </pre>
 *
 * @author 富士通)林　晃平
 * @version 1.1.0
 */
public class PNCommonCalendarInfo {

    /**
     * 元号基本情報リスト
     */
    private ArrayList<PNCommonCalendarGengoInfo> gengoInfoList;

    /**
     * 境界情報リスト
     */
    private ArrayList<PNCommonCalendarBorderInfo> borderInfoList;

    /**
     * 初期元号
     */
    private String initGengo;

    /**
     * 元号基本情報リストを取得します。
     *
     * @return 元号基本情報リスト
     */
    public ArrayList<PNCommonCalendarGengoInfo> getGengoInfoList() {
        return gengoInfoList;
    }

    /**
     * 元号基本情報リストを設定します。
     *
     * @param gengoInfoList
     *            元号基本情報リスト
     */
    public void setGengoInfoList(ArrayList<PNCommonCalendarGengoInfo> gengoInfoList) {
        this.gengoInfoList = gengoInfoList;
    }

    /**
     * 境界情報リストを取得します。
     *
     * @return 境界情報リスト
     */
    public ArrayList<PNCommonCalendarBorderInfo> getBorderInfoList() {
        return borderInfoList;
    }

    /**
     * 境界情報リストを設定します。
     *
     * @param borderInfoList
     *            境界情報リスト
     */
    public void setBorderInfoList(ArrayList<PNCommonCalendarBorderInfo> borderInfoList) {
        this.borderInfoList = borderInfoList;
    }

    /**
     * 初期元号を取得します。
     *
     * @return 初期元号
     */
    public String getInitGengo() {
        return initGengo;
    }

    /**
     * 初期元号を設定します。
     *
     * @param initGengo
     *            初期元号
     */
    public void setInitGengo(String initGengo) {
        this.initGengo = initGengo;
    }

    /**
     * 元号基本情報内部クラス
     */
    public class PNCommonCalendarGengoInfo {

        /**
         * 元号和名
         */
        private String eraJp;

        /**
         * 元号英名
         */
        private String eraEn;

        /**
         * 開始年
         */
        private String startYear;

        /**
         * 開始月
         */
        private String startMonth;

        /**
         * 開始日
         */
        private String startDay;

        /**
         * 終了年
         */
        private String endYear;

        /**
         * 終了和年
         */
        private String endEraYear;

        /**
         * 終了月
         */
        private String endMonth;

        /**
         * 終了日
         */
        private String endDay;

        /**
         * 元号和名を取得します。
         *
         * @return 元号和名
         */
        public String getEraJp() {
            return eraJp;
        }

        /**
         * 元号和名を設定します。
         *
         * @param eraJp
         *            元号和名
         */
        public void setEraJp(String eraJp) {
            this.eraJp = eraJp;
        }

        /**
         * 元号英名を取得します。
         *
         * @return 元号英名
         */
        public String getEraEn() {
            return eraEn;
        }

        /**
         * 元号英名を設定します。
         *
         * @param eraEn
         *            元号英名
         */
        public void setEraEn(String eraEn) {
            this.eraEn = eraEn;
        }

        /**
         * 開始年を取得します。
         *
         * @return 開始年
         */
        public String getStartYear() {
            return startYear;
        }

        /**
         * 開始年を設定します。
         *
         * @param startYear
         *            開始年
         */
        public void setStartYear(String startYear) {
            this.startYear = startYear;
        }

        /**
         * 開始月を取得します。
         *
         * @return 開始月
         */
        public String getStartMonth() {
            return startMonth;
        }

        /**
         * 開始月を設定します。
         *
         * @param startMonth
         *            開始月
         */
        public void setStartMonth(String startMonth) {
            this.startMonth = startMonth;
        }

        /**
         * 開始日を取得します。
         *
         * @return 開始日
         */
        public String getStartDay() {
            return startDay;
        }

        /**
         * 開始日を設定します。
         *
         * @param startDay
         *            開始日
         */
        public void setStartDay(String startDay) {
            this.startDay = startDay;
        }

        /**
         * 終了年を取得します。
         *
         * @return 終了年
         */
        public String getEndYear() {
            return endYear;
        }

        /**
         * 終了年を設定します。
         *
         * @param endYear
         *            終了年
         */
        public void setEndYear(String endYear) {
            this.endYear = endYear;
        }

        /**
         * 終了和年を取得します。
         *
         * @return 終了和年
         */
        public String getEndEraYear() {
            return endEraYear;
        }

        /**
         * 終了和年を設定します。
         *
         * @param endEraYear
         *            終了和年
         */
        public void setEndEraYear(String endEraYear) {
            this.endEraYear = endEraYear;
        }

        /**
         * 終了月を取得します。
         *
         * @return 終了月
         */
        public String getEndMonth() {
            return endMonth;
        }

        /**
         * 終了月を設定します。
         *
         * @param endMonth
         *            終了月
         */
        public void setEndMonth(String endMonth) {
            this.endMonth = endMonth;
        }

        /**
         * 終了日を取得します。
         *
         * @return 終了日
         */
        public String getEndDay() {
            return endDay;
        }

        /**
         * 終了日を設定します。
         *
         * @param endDay
         *            終了日
         */
        public void setEndDay(String endDay) {
            this.endDay = endDay;
        }
    }

    /**
     * 境界情報内部クラス
     */
    public class PNCommonCalendarBorderInfo {

        /**
         * 元号
         */
        private String era;

        /**
         * 年
         */
        private String year;

        /**
         * 変換元号年
         */
        private String conv;

        /**
         * 元号を取得します。
         *
         * @return 元号
         */
        public String getEra() {
            return era;
        }

        /**
         * 元号を設定します。
         *
         * @param era
         *            元号
         */
        public void setEra(String era) {
            this.era = era;
        }

        /**
         * 年を取得します。
         *
         * @return 年
         */
        public String getYear() {
            return year;
        }

        /**
         * 年を設定します。
         *
         * @param year
         */
        public void setYear(String year) {
            this.year = year;
        }

        /**
         * 変換元号年を取得します。
         * 
         * @return 変換元号年
         */
        public String getConv() {
            return conv;
        }

        /**
         * 変換元号年を設定します。
         * 
         * @param conv
         */
        public void setConv(String conv) {
            this.conv = conv;
        }
    }
}
