//==================================================================================================
// Project Name : 農林パートナーネット
// System Name  : JFC Partner Net
// Class Name   : Se014_01Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/10/17 | 宮郷　慎之介          | 新規作成（H29年追加開発案件対応）
// 3.0.0   | 2019/01/11 | 林　晃平              | 農林PN元号対応
//==================================================================================================
package jp.go.jfc.partnernet.se014.se014_01.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.go.jfc.partnernet.common.PNCommonComponents;
import jp.go.jfc.partnernet.pnfw.common.PNDateUtils;
import jp.go.jfc.partnernet.pnfw.common.PNFormatUtils;
import jp.go.jfc.partnernet.pnfw.common.PNResourceBundle;
import jp.go.jfc.partnernet.pnfw.exception.PNSystemException;
import jp.go.jfc.partnernet.pnfw.service.PNBaseService;
import jp.go.jfc.partnernet.se014.common.Se014Constants;
import jp.go.jfc.partnernet.se014.se014_01.dao.Se014_01KofuDateListDAO;
import jp.go.jfc.partnernet.se014.se014_01.dao.Se014_01KofuDateListEntity;
import jp.go.jfc.partnernet.se014.se014_01.dao.Se014_01SumMonthDAO;
import jp.go.jfc.partnernet.se014.se014_01.dao.Se014_01SumMonthEntity;
import jp.go.jfc.partnernet.se014.se014_01.dao.Se014_01SumWeekDAO;
import jp.go.jfc.partnernet.se014.se014_01.dao.Se014_01SumWeekEntity;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <pre>
 * このクラスはse014_01のサービスクラスです。
 * </pre>
 *
 * @author 林　晃平
 * @version 3.0.0
 */
public class Se014_01ServiceImpl extends PNBaseService implements Se014_01Service {

    /** 集計表形式 明細開始行 */
    private static final int M_MEISAI_START_ROW_SHUKEI = 3;

    /** データ形式 明細開始行 */
    private static final int M_MEISAI_START_ROW_DATA = 2;

    /** 合計_依頼予定額 計算開始列 */
    private static final int M_SUM_IRAI_SHIKINKOFU_START_COL = 5;

    /** 集計Excel一時ファイルディレクトリ */
    private static final String TMP_FILE_DIRECTORY = "download.path.Tmp";

    /** FileUtil ファイルセパレータ */
    private static final String FILESEPARATOR_PROPERTY_NAME = "separateCharacter.path";

    /** ファイル名 資金交付依頼予定表（月間）集計表形式 */
    private static final String FILE_NAME_YG_SHUKEITAISHO_SHUKEI = "月間集計表形式";

    /** ファイル名 資金交付依頼予定表（月間）データ形式 */
    private static final String FILE_NAME_YG_SHUKEITAISHO_DATA = "月間データ形式";

    /** ファイル名 資金交付依頼書（週間）集計表形式 */
    private static final String FILE_NAME_YS_SHUKEITAISHO_SHUKEI = "週間集計表形式";

    /** ファイル名 資金交付依頼書（週間）データ形式 */
    private static final String FILE_NAME_YS_SHUKEITAISHO_DATA = "週間データ形式";

    /** Excelファイル拡張子 */
    private static final String FILE_EXTENSION = ".xlsx";

    /** シート名 資金交付依頼予定表（月間）集計表形式 */
    private static final String SHEET_NAME_YG_SHUKEITAISHO_SHUKEI = "月間集計表形式";

    /** シート名 資金交付依頼予定表（月間）データ形式 */
    private static final String SHEET_NAME_YG_SHUKEITAISHO_DATA = "月間データ形式";

    /** シート名 資金交付依頼書（週間）集計表形式 */
    private static final String SHEET_NAME_YS_SHUKEITAISHO_SHUKEI = "週間集計表形式";

    /** シート名 資金交付依頼書（週間）データ形式 */
    private static final String SHEET_NAME_YS_SHUKEITAISHO_DATA = "週間データ形式";

    /** ヘッダータイトルフォーマット 資金交付依頼予定表（月間）集計表形式 */
    private static final String HEADERTITLE_FORMAT_YG_SHUKEITAISHO_SHUKEI =
            "資金交付依頼予定表（月間）　%s　月間計画（単位：円）";

    /** ヘッダータイトルフォーマット 資金交付依頼書（週間）集計表形式 */
    private static final String HEADERTITLE_FORMAT_YS_SHUKEITAISHO_SHUKEI =
            "資金交付依頼書（週間）　交付日：%s （単位：円）";

    /** se014_01kofudatelistdao */
    @Autowired
    private Se014_01KofuDateListDAO se014_01kofudatelistdao;

    /** se014_01summonthdao */
    @Autowired
    private Se014_01SumMonthDAO se014_01summonthdao;

    /** se014_01sumweekdao */
    @Autowired
    private Se014_01SumWeekDAO se014_01sumweekdao;

    /**
     * Excelのセルプロパティ設定クラス
     * @author 宮郷　慎之介
     */
    private class CellProperty {

        /** 書式設定 標準 ヘッダータイトル用 */
        public static final int FORMAT_STANDARD_HEADERTITLE = 1;
        /** 書式設定 標準 */
        public static final int FORMAT_STANDARD = 2;
        /** 書式設定 標準 ヘッダー用 */
        public static final int FORMAT_STANDARD_HEADER = 3;
        /** 書式設定 標準 ヘッダー用 中央 */
        public static final int FORMAT_STANDARD_HEADER_CENTER_ALIGN = 4;
        /** 書式設定 文字列 右詰め */
        public static final int FORMAT_STRING_RIGHT_ALIGN = 5;
        /** 書式設定 文字列 中央 */
        public static final int FORMAT_STRING_CENTER_ALIGN = 6;
        /** 書式設定 文字列 左詰め */
        public static final int FORMAT_STRING_LEFT_ALIGN = 7;
        /** 書式設定 数値 */
        public static final int FORMAT_NUM = 8;
        /** 書式設定 日付 */
        public static final int FORMAT_DATE = 9;
        /** 書式設定 日付 ヘッダー用 */
        public static final int FORMAT_DATE_HEADER = 10;

        /** 標準スタイル ヘッダータイトル用 */
        private final CellStyle STYLE_STANDARD_HEADERTITLE;
        /** 標準スタイル */
        private final CellStyle STYLE_STANDARD;
        /** 標準スタイル ヘッダー用 */
        private final CellStyle STYLE_STANDARD_HEADER;
        /** 標準スタイル ヘッダー用 中央揃え */
        private final CellStyle STYLE_STANDARD_HEADER_CENTER_ALIGN;
        /** 文字列スタイル 右詰め */
        private final CellStyle STYLE_STRING_RIGHT_ALIGN;
        /** 文字列スタイル 中央揃え */
        private final CellStyle STYLE_STRING_CENTER_ALIGN;
        /** 文字列スタイル 左詰め */
        private final CellStyle STYLE_STRING_LEFT_ALIGN;
        /** 整数スタイル */
        private final CellStyle STYLE_NUM;
        /** 日付スタイル */
        private final CellStyle STYLE_DATE;
        /** 日付スタイル ヘッダー用 */
        private final CellStyle STYLE_DATE_HEADER;

        /**
         * コンストラクタ
         * @param book
         */
        public CellProperty(Workbook book) {

            // フォント作成
            Font font = book.createFont();
            font.setFontName("ＭＳ Ｐゴシック");
            font.setFontHeightInPoints((short)11);

            // フォーマット作成
            DataFormat format = book.createDataFormat();

            // 標準スタイル ヘッダータイトル用 の設定
            CellStyle style_standard_headerTitle = book.createCellStyle();
            style_standard_headerTitle.setVerticalAlignment(VerticalAlignment.CENTER);
            style_standard_headerTitle.setAlignment(HorizontalAlignment.LEFT);
            style_standard_headerTitle.setFont(font);
            this.STYLE_STANDARD_HEADERTITLE = style_standard_headerTitle;

            // 標準スタイル ヘッダー用 の設定
            CellStyle style_standard = book.createCellStyle();
            style_standard.cloneStyleFrom(style_standard_headerTitle);
            setBorder(style_standard, BorderStyle.THIN);
            this.STYLE_STANDARD = style_standard;

            // 標準スタイル ヘッダー用 の設定
            CellStyle style_standard_header = book.createCellStyle();
            style_standard_header.cloneStyleFrom(style_standard);
            style_standard_header.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            ((XSSFCellStyle)style_standard_header).setFillForegroundColor(
                    new XSSFColor(new java.awt.Color(217, 217, 217)));
            style_standard_header.setWrapText(true);
            this.STYLE_STANDARD_HEADER = style_standard_header;

            // 標準スタイル ヘッダー用 中央揃え の設定
            CellStyle style_standard_header_center_align = book.createCellStyle();
            style_standard_header_center_align.cloneStyleFrom(style_standard_header);
            style_standard_header_center_align.setAlignment(HorizontalAlignment.CENTER);
            this.STYLE_STANDARD_HEADER_CENTER_ALIGN = style_standard_header_center_align;

            // 文字列用スタイル 右詰め の設定
            CellStyle style_string_right_align = book.createCellStyle();
            setBorder(style_string_right_align, BorderStyle.THIN);
            style_string_right_align.setVerticalAlignment(VerticalAlignment.CENTER);
            style_string_right_align.setAlignment(HorizontalAlignment.RIGHT);
            style_string_right_align.setFont(font);
            style_string_right_align.setDataFormat(format.getFormat("text"));
            this.STYLE_STRING_RIGHT_ALIGN = style_string_right_align;

            // 文字列用スタイル 中央揃え の設定
            CellStyle style_string_center_align = book.createCellStyle();
            style_string_center_align.cloneStyleFrom(style_string_right_align);
            style_string_center_align.setAlignment(HorizontalAlignment.CENTER);
            this.STYLE_STRING_CENTER_ALIGN = style_string_center_align;

            // 文字列用スタイル 左詰め の設定
            CellStyle style_string_left_align = book.createCellStyle();
            style_string_left_align.cloneStyleFrom(style_string_right_align);
            style_string_left_align.setAlignment(HorizontalAlignment.LEFT);
            this.STYLE_STRING_LEFT_ALIGN = style_string_left_align;

            // 整数用スタイル の設定
            CellStyle style_num = book.createCellStyle();
            setBorder(style_num, BorderStyle.THIN);
            style_num.setVerticalAlignment(VerticalAlignment.CENTER);
            style_num.setAlignment(HorizontalAlignment.RIGHT);
            style_num.setFont(font);
            style_num.setDataFormat(format.getFormat("#,##0"));
            this.STYLE_NUM = style_num;

            // 日付用スタイル の設定
            CellStyle style_date = book.createCellStyle();
            setBorder(style_date, BorderStyle.THIN);
            style_date.setVerticalAlignment(VerticalAlignment.CENTER);
            style_date.setAlignment(HorizontalAlignment.RIGHT);
            style_date.setFont(font);
            style_date.setDataFormat(format.getFormat("yyyy/m/d"));
            this.STYLE_DATE = style_date;

            // 日付用スタイル ヘッダー用 の設定
            CellStyle style_date_header = book.createCellStyle();
            style_date_header.cloneStyleFrom(style_date);
            style_date_header.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            ((XSSFCellStyle)style_date_header).setFillForegroundColor(
                    new XSSFColor(new java.awt.Color(217, 217, 217)));
            this.STYLE_DATE_HEADER = style_date_header;
        }

        /**
         * セルの設定を行います。（値設定）
         * @param cell
         * @param formatType
         * @param value
         */
        public void setCellProperty_Value(Cell cell, int formatType, Object value) {

            switch (formatType) {
            case FORMAT_STANDARD_HEADERTITLE:
                cell.setCellStyle(STYLE_STANDARD_HEADERTITLE);
                if (value != null) {
                    cell.setCellValue(value.toString());
                }
                break;
            case FORMAT_STANDARD:
                cell.setCellStyle(STYLE_STANDARD);
                if (value != null) {
                    cell.setCellValue(value.toString());
                }
                break;
            case FORMAT_STANDARD_HEADER:
                cell.setCellStyle(STYLE_STANDARD_HEADER);
                if (value != null) {
                    cell.setCellValue(value.toString());
                }
                break;
            case FORMAT_STANDARD_HEADER_CENTER_ALIGN:
                cell.setCellStyle(STYLE_STANDARD_HEADER_CENTER_ALIGN);
                if (value != null) {
                    cell.setCellValue(value.toString());
                }
                break;
            case FORMAT_STRING_RIGHT_ALIGN:
                cell.setCellStyle(STYLE_STRING_RIGHT_ALIGN);
                if (value != null) {
                    cell.setCellValue(value.toString());
                }
                break;
            case FORMAT_STRING_CENTER_ALIGN:
                cell.setCellStyle(STYLE_STRING_CENTER_ALIGN);
                if (value != null) {
                    cell.setCellValue(value.toString());
                }
                break;
            case FORMAT_STRING_LEFT_ALIGN:
                cell.setCellStyle(STYLE_STRING_LEFT_ALIGN);
                if (value != null) {
                    cell.setCellValue(value.toString());
                }
                break;
            case FORMAT_NUM:
                cell.setCellStyle(STYLE_NUM);
                if (value != null) {
                    if (value.getClass() == String.class) {
                        cell.setCellValue(String.valueOf(value));
                    }
                    else {
                        BigDecimal bdValue = new BigDecimal(value.toString());
                        cell.setCellValue(bdValue.doubleValue());
                    }
                }
                break;
            case FORMAT_DATE:
                cell.setCellStyle(STYLE_DATE);
                if (value != null) {
                    cell.setCellValue(PNCommonComponents.strToCal(value.toString()));
                }
                break;
            case FORMAT_DATE_HEADER:
                cell.setCellStyle(STYLE_DATE_HEADER);
                if (value != null) {
                    cell.setCellValue(PNCommonComponents.strToCal(value.toString()));
                }
                break;
            }
        }

        /**
         * セルの設定を行います。（数式設定）
         * ※セルの書式は数値型固定
         * @param cell
         * @param formatType
         * @param formula
         */
        public void setCellProperty_Formula(Cell cell, Object value) {
            cell.setCellStyle(STYLE_NUM);
            cell.setCellType(CellType.NUMERIC);
            if (value != null) {
                cell.setCellFormula(value.toString());
            }
        }

        /**
         * 罫線の設定
         * @param style
         * @param border
         */
        private void setBorder(CellStyle style, BorderStyle border) {
            style.setBorderBottom(border);
            style.setBorderTop(border);
            style.setBorderLeft(border);
            style.setBorderRight(border);
        }
    }

    /**
     * Se014_01ServiceのexcelOut
     *
     * @param inDto Se014_01DTO
     * @return Se014_01DTO
     */
    @Override
    public Se014_01DTO excelOut(Se014_01DTO inDto) {

        Se014_01DTO outDto = new Se014_01DTO();

        // ■資金交付依頼予定表（月間）集計表形式　または　資金交付依頼予定表（月間）データ形式を選択した場合
        if (inDto.getRdoid_shikinkofu().equals(Se014Constants.RDOID_YG_SHUKEITAISHO_SHUKEI)
                || inDto.getRdoid_shikinkofu().equals(Se014Constants.RDOID_YG_SHUKEITAISHO_DATA)) {

            // 　　集計対象年月の編集
            // 　　集計対象年月のパラメータを取得し、連結後、共通機能を使用し西暦日付（YYYYMM）に変換する。
// [UPD] Ver 3.0.0 - START
//            String year = "";
//            String month = "";
//            String strShukeiDate = "";
//            // 　　　集計対象年月（年） Se014_01DTO.drpID_YG_ShukeiTaishoYear
//            year = String.format("%04d", Integer.parseInt(inDto.getDrpid_yg_shukeitaishoyear()));
//            // 　　　集計対象年月（月） Se014_01DTO.drpID_YG_ShukeiTaishoMonth
//            month = String.format("%02d", Integer.parseInt(inDto.getDrpid_yg_shukeitaishomonth()));
//            // 連結
//            strShukeiDate = PNCommonComponents.concatString(year, month);
            String strShukeiDate = PNCommonComponents.dateFmtJC_Gyymm(
                    PNCommonComponents.concatString(
                            inDto.getDrpid_yg_shukeitaishoyear(),
                            PNFormatUtils.toZeroPadding(inDto.getDrpid_yg_shukeitaishomonth(), 2)),
                    "");
// [UPD] Ver 3.0.0 - END

            // 交付日リストを取得
            String[] dateKofuList = getDateKofuList(strShukeiDate);

            // 明細データを取得
            List<Map<String, Object>> outMeisaiDataList = getMeisaiData(inDto, strShukeiDate, dateKofuList);

            // Excel作成
            Workbook book = null;
            try {
                // ブック作成
                book = new XSSFWorkbook();

                // シート作成
                // シート名取得
                String sheetName = "";
                if (inDto.getRdoid_shikinkofu().equals(Se014Constants.RDOID_YG_SHUKEITAISHO_SHUKEI)) {
                    // 　　　　　■資金交付依頼予定表（月間）集計表形式を選択した場合
                    sheetName = SHEET_NAME_YG_SHUKEITAISHO_SHUKEI;
                }
                else if (inDto.getRdoid_shikinkofu().equals(Se014Constants.RDOID_YG_SHUKEITAISHO_DATA)) {
                    // 　　　　　■資金交付依頼予定表（月間）データ形式を選択した場合■
                    sheetName = SHEET_NAME_YG_SHUKEITAISHO_DATA;
                }
                Sheet sheet = book.createSheet(sheetName);

                // ウィンドウ枠の固定設定
                if (inDto.getRdoid_shikinkofu().equals(Se014Constants.RDOID_YG_SHUKEITAISHO_SHUKEI)) {
                    // 　　　　　■資金交付依頼予定表（月間）集計表形式を選択した場合
                    // 先頭２行を固定
                    sheet.createFreezePane(0, 2);
                }
                else if (inDto.getRdoid_shikinkofu().equals(Se014Constants.RDOID_YG_SHUKEITAISHO_DATA)) {
                    // 　　　　　■資金交付依頼予定表（月間）データ形式を選択した場合■
                    // 先頭１行を固定
                    sheet.createFreezePane(0, 1);
                }

                // Row、Cell、行番号、列番号を宣言
                Row row = null;
                Cell cell = null;
                int rowNumber = 0;
                int colNumber = 0;

                // セルプロパティクラスインスタンス生成
                CellProperty cellProperty = new CellProperty(book);

                // ==================================================
                // 　　　ヘッダ1設定
                // ==================================================
                if (inDto.getRdoid_shikinkofu().equals(Se014Constants.RDOID_YG_SHUKEITAISHO_SHUKEI)) {
                    // 　　　　　■資金交付依頼予定表（月間）集計表形式を選択した場合
                    // Row作成
                    row = sheet.createRow(rowNumber++);
                    colNumber = 0;
                    // 　　　　各セルに表示位置、表示形式、フォント、フォントサイズ、文字色、背景色、罫線を設定する。
                    // 　　　　キー："hdr1_Title"
                    // ヘッダータイトル文字列取得
                    String strHeaderTitle = String.format(HEADERTITLE_FORMAT_YG_SHUKEITAISHO_SHUKEI,
                            PNCommonComponents.dateFmtJC_Kanzi_YYYYMM(strShukeiDate));
                    cell = row.createCell(colNumber++);
                    cellProperty.setCellProperty_Value(cell, CellProperty.FORMAT_STANDARD_HEADERTITLE, strHeaderTitle);
                    // セル結合
                    sheet.addMergedRegion(new CellRangeAddress(row.getRowNum(), row.getRowNum(), 0, 4));
                }

                // ==================================================
                // 　　　ヘッダ2設定
                // ==================================================
                // Row作成
                row = sheet.createRow(rowNumber++);
                colNumber = 0;
                // 　　　　各セルに表示位置、表示形式、フォント、フォントサイズ、文字色、背景色、罫線を設定する。
                // 　　　　キー："hdr2_Number"
                cell = row.createCell(colNumber++);
                cellProperty.setCellProperty_Value(cell,
                        CellProperty.FORMAT_STANDARD_HEADER, "No.");

                // 　　　　キー："hdr2_Code_Organization"
                cell = row.createCell(colNumber++);
                cellProperty.setCellProperty_Value(cell,
                        CellProperty.FORMAT_STANDARD_HEADER, "金融機関コード");

                // 　　　　キー："hdr2_Name_Organization"
                cell = row.createCell(colNumber++);
                cellProperty.setCellProperty_Value(cell,
                        CellProperty.FORMAT_STANDARD_HEADER, "受託者名");

                // 　　　　キー："hdr2_Sum_Irai_ShikinKofu"
                cell = row.createCell(colNumber++);
                cellProperty.setCellProperty_Value(cell,
                        CellProperty.FORMAT_STANDARD_HEADER, "合計_依頼予定額");

                // 　　　　キー："hdr2_Irai_ShikinKofu"
                if (outMeisaiDataList.size() != 0) {
                    for (int i = 0; i < dateKofuList.length; i++) {
                        cell = row.createCell(colNumber++);
                        cellProperty.setCellProperty_Value(cell,
                                CellProperty.FORMAT_DATE_HEADER, dateKofuList[i]);
                    }
                }

                // 　　　　キー："hdr2_Sum_Ganju"
                cell = row.createCell(colNumber++);
                cellProperty.setCellProperty_Value(cell,
                        CellProperty.FORMAT_STANDARD_HEADER, "合計_元金充当額（外数）");

                // 　　　　キー："hdr2_Ganju"
                if (outMeisaiDataList.size() != 0) {
                    for (int i = 0; i < dateKofuList.length; i++) {
                        cell = row.createCell(colNumber++);
                        cellProperty.setCellProperty_Value(cell,
                                CellProperty.FORMAT_DATE_HEADER, dateKofuList[i]);
                    }
                }

                // ==================================================
                // 　　　明細部設定
                // ==================================================
                if (outMeisaiDataList.size() == 0) {
                    // 明細データが無い場合
                    // 空明細データ行を作成
                    // Row作成
                    row = sheet.createRow(rowNumber++);
                    colNumber = 0;
                    // 　　　　各セルに表示位置、表示形式、フォント、フォントサイズ、文字色、背景色、罫線を設定する。
                    // 　　　　　キー："M_Number"
                    cell = row.createCell(colNumber++);
                    cellProperty.setCellProperty_Value(cell, CellProperty.FORMAT_STANDARD, "");

                    // 　　　　　キー："M_Code_Organization"
                    cell = row.createCell(colNumber++);
                    cellProperty.setCellProperty_Value(cell, CellProperty.FORMAT_STANDARD, "");

                    // 　　　　　キー："M_Name_Organization"
                    cell = row.createCell(colNumber++);
                    cellProperty.setCellProperty_Value(cell, CellProperty.FORMAT_STANDARD, "");

                    // 　　　　　キー："M_Sum_Irai_ShikinKofu"
                    cell = row.createCell(colNumber++);
                    cellProperty.setCellProperty_Value(cell, CellProperty.FORMAT_STANDARD, "");

                    // 　　　　　キー："M_Sum_Ganju"
                    cell = row.createCell(colNumber++);
                    cellProperty.setCellProperty_Value(cell, CellProperty.FORMAT_STANDARD, "");
                }
                else {
                    // 　　　　Entityの件数分ループ
                    for (Map<String, Object> outMeisaiData : outMeisaiDataList) {
                        // Row作成
                        row = sheet.createRow(rowNumber++);
                        colNumber = 0;
                        // 　　　　各セルに表示位置、表示形式、フォント、フォントサイズ、文字色、背景色、罫線を設定する。
                        // 　　　　　キー："M_Number"
                        cell = row.createCell(colNumber++);
                        cellProperty.setCellProperty_Value(cell,
                                CellProperty.FORMAT_STRING_RIGHT_ALIGN,
                                outMeisaiData.get("Number"));

                        // 　　　　　キー："M_Code_Organization"
                        cell = row.createCell(colNumber++);
                        cellProperty.setCellProperty_Value(cell,
                                CellProperty.FORMAT_STRING_LEFT_ALIGN,
                                outMeisaiData.get("Code_Organization"));

                        // 　　　　　キー："M_Name_Organization"
                        cell = row.createCell(colNumber++);
                        cellProperty.setCellProperty_Value(cell,
                                CellProperty.FORMAT_STRING_LEFT_ALIGN,
                                outMeisaiData.get("Name_Organization"));

                        // 　　　　　キー："M_Sum_Irai_ShikinKofu"
                        cell = row.createCell(colNumber++);
                        cellProperty.setCellProperty_Formula(cell,
                                outMeisaiData.get("M_Sum_Irai_ShikinKofu"));

                        // 　　　　　キー："M_Irai_ShikinKofu"
                        for (int i = 1; i <= dateKofuList.length; i++) {
                            // 交付日リスト行数分、列を作成
                            cell = row.createCell(colNumber++);
                            String key = PNCommonComponents.concatString("M_Irai_ShikinKofu", String.valueOf(i));
                            if (outMeisaiData.containsKey(key)) {
                                cellProperty.setCellProperty_Value(cell,
                                        CellProperty.FORMAT_NUM, outMeisaiData.get(key));
                            }
                            else {
                                cellProperty.setCellProperty_Value(cell,
                                        CellProperty.FORMAT_NUM, "");
                            }
                        }
                        // 　　　　　キー："M_Sum_Ganju"
                        cell = row.createCell(colNumber++);
                        cellProperty.setCellProperty_Formula(cell,
                                outMeisaiData.get("M_Sum_Ganju"));

                        // 　　　　　キー："M_Ganju"
                        for (int i = 1; i <= dateKofuList.length; i++) {
                            // 交付日リスト行数分、列を作成
                            cell = row.createCell(colNumber++);
                            String key = PNCommonComponents.concatString("M_Ganju",
                                    String.valueOf(i));
                            if (outMeisaiData.containsKey(key)) {
                                cellProperty.setCellProperty_Value(cell,
                                        CellProperty.FORMAT_NUM, outMeisaiData.get(key));
                            }
                            else {
                                cellProperty.setCellProperty_Value(cell,
                                        CellProperty.FORMAT_NUM, "");
                            }
                        }
                    }
                }
                // ==================================================
                // フッタ設定
                // ==================================================
                // Row作成
                row = sheet.createRow(rowNumber++);
                colNumber = 0;
                // 　　　　各セルに表示位置、表示形式、フォント、フォントサイズ、文字色、背景色、罫線を設定する。
                // 　　　キー："ftr_Blank1"
                cell = row.createCell(colNumber++);
                cellProperty.setCellProperty_Value(cell,
                        CellProperty.FORMAT_STRING_CENTER_ALIGN, "");

                // 　　　キー："ftr_Sum"
                cell = row.createCell(colNumber++);
                cellProperty.setCellProperty_Value(cell,
                        CellProperty.FORMAT_STRING_CENTER_ALIGN, "合計");

                // 　　　キー："ftr_Blank2"
                cell = row.createCell(colNumber++);
                cellProperty.setCellProperty_Value(cell,
                        CellProperty.FORMAT_STRING_CENTER_ALIGN, "");

                // 　　　キー："ftr_Sum_Irai_ShikinKofu"
                // フッタ_合計_依頼予定額 計算式を作成
                int ftr_Sum_Irai_ShikinKofu_col = M_SUM_IRAI_SHIKINKOFU_START_COL - 1;
                String ftr_Sum_Irai_ShikinKofu_Formula = createSumFormula(
                        ftr_Sum_Irai_ShikinKofu_col
                        , row.getRowNum() - ((outMeisaiDataList.size() == 0) ? 0 : outMeisaiDataList.size() - 1)
                        , ftr_Sum_Irai_ShikinKofu_col
                        , row.getRowNum());
                cell = row.createCell(colNumber++);
                cellProperty.setCellProperty_Formula(cell, ftr_Sum_Irai_ShikinKofu_Formula);

                // 　　　キー："ftr_Irai_ShikinKofu"
                // フッタ_依頼予定額 計算式を作成
                if (outMeisaiDataList.size() != 0) {
                    for (int i = 0; i < dateKofuList.length; i++) {
                        // 交付日リスト行数分、列を作成
                        int ftr_Irai_ShikinKofu_col = M_SUM_IRAI_SHIKINKOFU_START_COL + i;
                        String ftr_Irai_ShikinKofu_Formula = createSumFormula(
                                ftr_Irai_ShikinKofu_col
                                , row.getRowNum() - outMeisaiDataList.size() + 1
                                , ftr_Irai_ShikinKofu_col
                                , row.getRowNum());
                        cell = row.createCell(colNumber++);
                        cellProperty.setCellProperty_Formula(cell, ftr_Irai_ShikinKofu_Formula);
                    }
                }

                // 　　　キー："ftr_Sum_Ganju"
                // フッタ_合計_元金充当額（外数） 計算式を作成
                int ftr_Sum_Ganju_col = ftr_Sum_Irai_ShikinKofu_col + dateKofuList.length + 1;
                String ftr_Sum_Ganju_Formula = createSumFormula(
                        ftr_Sum_Ganju_col
                        , row.getRowNum() - ((outMeisaiDataList.size() == 0) ? 0 : outMeisaiDataList.size() - 1)
                        , ftr_Sum_Ganju_col
                        , row.getRowNum());
                cell = row.createCell(colNumber++);
                cellProperty.setCellProperty_Formula(cell, ftr_Sum_Ganju_Formula);

                // 　　　キー："ftr_Ganju"
                // フッタ_元金充当額（外数） 計算式を作成
                if (outMeisaiDataList.size() != 0) {
                    for (int i = 0; i < dateKofuList.length; i++) {
                        // 交付日リスト行数分、列を作成
                        int ftr_Ganju_col = ftr_Sum_Ganju_col + 1 + i;
                        String ftr_Ganju_Formula = createSumFormula(
                                ftr_Ganju_col
                                , row.getRowNum() - outMeisaiDataList.size() + 1
                                , ftr_Ganju_col
                                , row.getRowNum());
                        cell = row.createCell(colNumber++);
                        cellProperty.setCellProperty_Formula(cell, ftr_Ganju_Formula);
                    }
                }

                // 列幅を設定
                sheet.setColumnWidth(0, 5120);
                sheet.setColumnWidth(1, 5120);
                sheet.setColumnWidth(2, 6400);
                // 残列数分ループ start
                for (int i = 3; i <= colNumber - 1; i++) {
                    sheet.setColumnWidth(i, 6400);
                }

                // Excel出力
                outDto.setDownload_filepath(execOutputExcel(inDto, book));

            }
            catch (IOException e) {
                // システムエラー
                throw new PNSystemException(e);
            }
            finally {
                // ブッククローズ
                IOUtils.closeQuietly(book);
            }
        }
        else if (inDto.getRdoid_shikinkofu().equals(Se014Constants.RDOID_YS_SHUKEITAISHO_SHUKEI)
                || inDto.getRdoid_shikinkofu().equals(Se014Constants.RDOID_YS_SHUKEITAISHO_DATA)) {
            // ■資金交付依頼書（週間）集計表形式　または　資金交付依頼書（週間）データ形式を選択した場合

            // 　　集計対象年月日の編集
            // 　　集計対象年月日のパラメータを取得し、連結後、共通機能を使用し西暦日付（YYYYMMDD）に変換する。
// [UPD] Ver 3.0.0 - START
//            String year = "";
//            String month = "";
//            String day = "";
//            String strShukeiDate = "";
//            // 　　　集計対象年月日（年） Se014_01DTO.drpID_YS_ShukeiTaishoYear
//            year = String.format("%04d", Integer.parseInt(inDto.getDrpid_ys_shukeitaishoyear()));
//            // 　　　集計対象年月日（月） Se014_01DTO.drpID_YS_ShukeiTaishoMonth
//            month = String.format("%02d", Integer.parseInt(inDto.getDrpid_ys_shukeitaishomonth()));
//            // 　　　集計対象年月日（日） Se014_01DTO.drpID_YS_ShukeiTaishoDate
//            day = String.format("%02d", Integer.parseInt(inDto.getDrpid_ys_shukeitaishodate()));
//            // 連結
//            strShukeiDate = PNCommonComponents.concatString(year, month, day);
            String strShukeiDate = PNCommonComponents.dateFmtJC_Gyymmdd(
                    PNCommonComponents.concatString(
                            inDto.getDrpid_ys_shukeitaishoyear(),
                            PNFormatUtils.toZeroPadding(inDto.getDrpid_ys_shukeitaishomonth(), 2),
                            PNFormatUtils.toZeroPadding(inDto.getDrpid_ys_shukeitaishodate(), 2)),
                    "");
// [UPD] Ver 3.0.0 - END

            // 明細データを取得
            List<Map<String, Object>> outMeisaiDataList = getMeisaiData(inDto, strShukeiDate);

            // Excel作成
            Workbook book = null;
            try {
                // ブック作成
                book = new XSSFWorkbook();

                // シート作成
                // シート名取得
                String sheetName = "";
                if (inDto.getRdoid_shikinkofu().equals(Se014Constants.RDOID_YS_SHUKEITAISHO_SHUKEI)) {
                    // 　　　　　■資金交付依頼書（週間）集計表形式を選択した場合
                    sheetName = SHEET_NAME_YS_SHUKEITAISHO_SHUKEI;
                }
                else if (inDto.getRdoid_shikinkofu().equals(Se014Constants.RDOID_YS_SHUKEITAISHO_DATA)) {
                    // 　　　　　■資金交付依頼書（週間）データ形式を選択した場合■
                    sheetName = SHEET_NAME_YS_SHUKEITAISHO_DATA;
                }
                Sheet sheet = book.createSheet(sheetName);

                // ウィンドウ枠の固定設定
                if (inDto.getRdoid_shikinkofu().equals(Se014Constants.RDOID_YS_SHUKEITAISHO_SHUKEI)) {
                    // 　　　　　■資金交付依頼書（週間）集計表形式を選択した場合
                    // 先頭２行を固定
                    sheet.createFreezePane(0, 2);
                }
                else if (inDto.getRdoid_shikinkofu().equals(Se014Constants.RDOID_YS_SHUKEITAISHO_DATA)) {
                    // 　　　　　■資金交付依頼書（週間）データ形式を選択した場合■
                    // 先頭１行を固定
                    sheet.createFreezePane(0, 1);
                }

                // Row、Cell、行番号、列番号を宣言
                Row row = null;
                Cell cell = null;
                int rowNumber = 0;
                int colNumber = 0;

                // セルプロパティクラスインスタンス生成
                CellProperty cellProperty = new CellProperty(book);

                if (inDto.getRdoid_shikinkofu().equals(Se014Constants.RDOID_YS_SHUKEITAISHO_SHUKEI)) {
                    // 　■資金交付依頼書（週間）集計表形式を選択した場合
                    // 　　　週間集計用のデータコレクションを作成する。
                    // 　　　合計算出用のエクセル関数を設定
                    // 　　　・フッタ合計関数の設定

                    // ==================================================
                    // 　　　ヘッダ1設定
                    // ==================================================
                    // Row作成
                    row = sheet.createRow(rowNumber++);
                    colNumber = 0;
                    // 　　　　各セルに表示位置、表示形式、フォント、フォントサイズ、文字色、背景色、罫線を設定する。
                    // 　　　　キー："hdr1_Title"
                    // ヘッダータイトル文字列取得
                    String strHeaderTitle = String.format(HEADERTITLE_FORMAT_YS_SHUKEITAISHO_SHUKEI,
                            PNCommonComponents.dateFmtJC_Slash_YYYYMMDD(strShukeiDate));
                    cell = row.createCell(colNumber++);
                    cellProperty.setCellProperty_Value(cell, CellProperty.FORMAT_STANDARD_HEADERTITLE, strHeaderTitle);
                    // セル結合
                    sheet.addMergedRegion(new CellRangeAddress(row.getRowNum(), row.getRowNum(), 0, 4));

                    // ==================================================
                    // 　　　ヘッダ2設定
                    // ==================================================
                    // Row作成
                    row = sheet.createRow(rowNumber++);
                    colNumber = 0;
                    // 　　　　各セルに表示位置、表示形式、フォント、フォントサイズ、文字色、背景色、罫線を設定する。
                    // 　　　　キー："hdr2_Number"
                    cell = row.createCell(colNumber++);
                    cellProperty.setCellProperty_Value(cell,
                            CellProperty.FORMAT_STANDARD_HEADER, "No.");

                    // 　　　　キー："hdr2_Code_Organization"
                    cell = row.createCell(colNumber++);
                    cellProperty.setCellProperty_Value(cell,
                            CellProperty.FORMAT_STANDARD_HEADER, "金融機関コード");

                    // 　　　　キー："hdr2_Name_Organization"
                    cell = row.createCell(colNumber++);
                    cellProperty.setCellProperty_Value(cell,
                            CellProperty.FORMAT_STANDARD_HEADER, "受託者名");

                    // 　　　　キー："hdr2_Sum_Sashihiki_ShikinKoufu_Irai"
                    cell = row.createCell(colNumber++);
                    cellProperty.setCellProperty_Value(cell,
                            CellProperty.FORMAT_STANDARD_HEADER, "差引交付依頼額の合計");

                    // 　　　　キー："hdr2_Ganju"
                    cell = row.createCell(colNumber++);
                    cellProperty.setCellProperty_Value(cell,
                            CellProperty.FORMAT_STANDARD_HEADER, "元金充当額（外数）");

                    // ==================================================
                    // 　　　明細部設定
                    // ==================================================
                    if (outMeisaiDataList.size() == 0) {
                        // 明細データが無い場合
                        // 空明細データ行を作成
                        // Row作成
                        row = sheet.createRow(rowNumber++);
                        colNumber = 0;
                        // 各セルに表示位置、表示形式、フォント、フォントサイズ、文字色、背景色、罫線を設定する。
                        // 　　　　　キー："M_Number"
                        cell = row.createCell(colNumber++);
                        cellProperty.setCellProperty_Value(cell, CellProperty.FORMAT_STANDARD, "");

                        // 　　　　　キー："M_Code_Organization"
                        cell = row.createCell(colNumber++);
                        cellProperty.setCellProperty_Value(cell, CellProperty.FORMAT_STANDARD, "");

                        // 　　　　　キー："M_Name_Organization"
                        cell = row.createCell(colNumber++);
                        cellProperty.setCellProperty_Value(cell, CellProperty.FORMAT_STANDARD, "");

                        // 　　　　　キー："M_Sum_Sashihiki_ShikinKoufu_Irai"
                        cell = row.createCell(colNumber++);
                        cellProperty.setCellProperty_Value(cell, CellProperty.FORMAT_STANDARD, "");

                        // 　　　　　キー："M_Ganju"
                        cell = row.createCell(colNumber++);
                        cellProperty.setCellProperty_Value(cell, CellProperty.FORMAT_STANDARD, "");
                    }
                    else {
                        // 　　　　Entityの件数分ループ
                        for (Map<String, Object> outMeisaiData : outMeisaiDataList) {
                            // Row作成
                            row = sheet.createRow(rowNumber++);
                            colNumber = 0;
                            // 各セルに表示位置、表示形式、フォント、フォントサイズ、文字色、背景色、罫線を設定する。
                            // 　　　　　キー："M_Number"
                            cell = row.createCell(colNumber++);
                            cellProperty.setCellProperty_Value(cell,
                                    CellProperty.FORMAT_STRING_RIGHT_ALIGN, outMeisaiData.get("Number"));

                            // 　　　　　キー："M_Code_Organization"
                            cell = row.createCell(colNumber++);
                            cellProperty.setCellProperty_Value(cell,
                                    CellProperty.FORMAT_STRING_LEFT_ALIGN, outMeisaiData.get("Code_Organization"));

                            // 　　　　　キー："M_Name_Organization"
                            cell = row.createCell(colNumber++);
                            cellProperty.setCellProperty_Value(cell,
                                    CellProperty.FORMAT_STRING_LEFT_ALIGN, outMeisaiData.get("Name_Organization"));

                            // 　　　　　キー："M_Sum_Sashihiki_ShikinKoufu_Irai"
                            cell = row.createCell(colNumber++);
                            cellProperty.setCellProperty_Value(cell,
                                    CellProperty.FORMAT_NUM, outMeisaiData.get("M_Sum_Sashihiki_ShikinKoufu_Irai"));

                            // 　　　　　キー："M_Ganju"
                            cell = row.createCell(colNumber++);
                            cellProperty.setCellProperty_Value(cell,
                                    CellProperty.FORMAT_NUM, outMeisaiData.get("M_Ganju_Gaisu"));
                        }
                    }

                    // ==================================================
                    // 　　　フッタ設定
                    // ==================================================
                    // Row作成
                    row = sheet.createRow(rowNumber++);
                    colNumber = 0;
                    // 　　　　各セルに表示位置、表示形式、フォント、フォントサイズ、文字色、背景色、罫線を設定する。
                    // 　　　　キー："ftr_Blank1"
                    cell = row.createCell(colNumber++);
                    cellProperty.setCellProperty_Value(cell,
                            CellProperty.FORMAT_STRING_CENTER_ALIGN, "");

                    // 　　　　キー："ftr_Sum"
                    cell = row.createCell(colNumber++);
                    cellProperty.setCellProperty_Value(cell,
                            CellProperty.FORMAT_STRING_CENTER_ALIGN, "合計");

                    // 　　　　キー："ftr_Blank2"
                    cell = row.createCell(colNumber++);
                    cellProperty.setCellProperty_Value(cell,
                            CellProperty.FORMAT_STRING_CENTER_ALIGN, "");

                    // 　　　　キー："ftr_Sum_Sashihiki_ShikinKoufu_Irai"
                    cell = row.createCell(colNumber++);
                    String ftr_Sum_Sashihiki_ShikinKoufu_Irai_Formula = createSumFormula(
                            colNumber
                            , row.getRowNum() - ((outMeisaiDataList.size() == 0) ? 0 : outMeisaiDataList.size() - 1)
                            , colNumber
                            , row.getRowNum());
                    cellProperty.setCellProperty_Formula(cell, ftr_Sum_Sashihiki_ShikinKoufu_Irai_Formula);

                    // 　　　　キー："ftr_Ganju_Gaisu"
                    cell = row.createCell(colNumber++);
                    String ftr_Ganju_Gaisu_Formula = createSumFormula(
                            colNumber
                            , row.getRowNum() - ((outMeisaiDataList.size() == 0) ? 0 : outMeisaiDataList.size() - 1)
                            , colNumber
                            , row.getRowNum());
                    cellProperty.setCellProperty_Formula(cell, ftr_Ganju_Gaisu_Formula);

                    // 列幅を設定
                    sheet.setColumnWidth(0, 5120);
                    sheet.setColumnWidth(1, 5120);
                    sheet.setColumnWidth(2, 6400);
                    sheet.setColumnWidth(3, 6400);
                    sheet.setColumnWidth(4, 6400);
                }
                else if (inDto.getRdoid_shikinkofu().equals(Se014Constants.RDOID_YS_SHUKEITAISHO_DATA)) {
                    // 　■資金交付依頼書（週間）データ形式を選択した場合
                    // 　　　週間集計用のデータコレクションを作成する。
                    // 　　　合計算出用のエクセル関数を設定
                    // 　　　・フッタ合計関数の設定

                    // ==================================================
                    // 　　　ヘッダ設定
                    // ==================================================
                    // Row作成
                    row = sheet.createRow(rowNumber++);
                    colNumber = 0;
                    // 　　　　各セルに表示位置、表示形式、フォント、フォントサイズ、文字色、背景色、罫線を設定する。
                    // 　　　　キー："hdr_Kofu"
                    cell = row.createCell(colNumber++);
                    cellProperty.setCellProperty_Value(cell,
                            CellProperty.FORMAT_STANDARD_HEADER_CENTER_ALIGN, "交付日");

                    // 　　　　キー："hdr_Number"
                    cell = row.createCell(colNumber++);
                    cellProperty.setCellProperty_Value(cell,
                            CellProperty.FORMAT_STANDARD_HEADER, "No.");

                    // 　　　　キー："hdr_Code_Organization"
                    cell = row.createCell(colNumber++);
                    cellProperty.setCellProperty_Value(cell,
                            CellProperty.FORMAT_STANDARD_HEADER, "金融機関コード");

                    // 　　　　キー："hdr_Name_Organization"
                    cell = row.createCell(colNumber++);
                    cellProperty.setCellProperty_Value(cell,
                            CellProperty.FORMAT_STANDARD_HEADER, "受託者名");

                    // 　　　　キー："hdr_ShikinHaraidashi_Yotei"
                    cell = row.createCell(colNumber++);
                    cellProperty.setCellProperty_Value(cell,
                            CellProperty.FORMAT_STANDARD_HEADER, "資金払出予定額");

                    // 　　　　キー："hdr_ShikinKoufu_ZandakaMikomi"
                    cell = row.createCell(colNumber++);
                    cellProperty.setCellProperty_Value(cell,
                            CellProperty.FORMAT_STANDARD_HEADER, PNCommonComponents.concatString(
                                    "資金交付日の前日時点の",
                                    System.getProperty("line.separator"),
                                    "資金交付金残高見込額"));

                    // 　　　　キー："hdr_Sashihiki_ShikinKoufu_Irai"
                    cell = row.createCell(colNumber++);
                    cellProperty.setCellProperty_Value(cell,
                            CellProperty.FORMAT_STANDARD_HEADER, "差引交付依頼額");

                    // 　　　　キー："hdr_Ganju"
                    cell = row.createCell(colNumber++);
                    cellProperty.setCellProperty_Value(cell,
                            CellProperty.FORMAT_STANDARD_HEADER, "元金充当額（外数）");

                    // ==================================================
                    // 　　　明細部設定
                    // ==================================================
                    if (outMeisaiDataList.size() == 0) {
                        // 明細データが無い場合
                        // 空明細データ行を作成
                        // Row作成
                        row = sheet.createRow(rowNumber++);
                        colNumber = 0;
                        // 各セルに表示位置、表示形式、フォント、フォントサイズ、文字色、背景色、罫線を設定する。
                        // 　　　　　キー："M_Kofu"
                        cell = row.createCell(colNumber++);
                        cellProperty.setCellProperty_Value(cell, CellProperty.FORMAT_STANDARD, "");

                        // 　　　　　キー："M_Number"
                        cell = row.createCell(colNumber++);
                        cellProperty.setCellProperty_Value(cell, CellProperty.FORMAT_STANDARD, "");

                        // 　　　　　キー："M_Code_Organization"
                        cell = row.createCell(colNumber++);
                        cellProperty.setCellProperty_Value(cell, CellProperty.FORMAT_STANDARD, "");

                        // 　　　　　キー："M_Name_Organization"
                        cell = row.createCell(colNumber++);
                        cellProperty.setCellProperty_Value(cell, CellProperty.FORMAT_STANDARD, "");

                        // 　　　　　キー："M_ShikinHaraidashi_Yotei"
                        cell = row.createCell(colNumber++);
                        cellProperty.setCellProperty_Value(cell, CellProperty.FORMAT_STANDARD, "");

                        // 　　　　　キー："M_ShikinKoufu_ZandakaMikomi"
                        cell = row.createCell(colNumber++);
                        cellProperty.setCellProperty_Value(cell, CellProperty.FORMAT_STANDARD, "");

                        // 　　　　　キー："M_Sashihiki_ShikinKoufu_Irai"
                        cell = row.createCell(colNumber++);
                        cellProperty.setCellProperty_Value(cell, CellProperty.FORMAT_STANDARD, "");

                        // 　　　　　キー："M_Ganju"
                        cell = row.createCell(colNumber++);
                        cellProperty.setCellProperty_Value(cell, CellProperty.FORMAT_STANDARD, "");
                    }
                    else {
                        // 　　　　Entityの件数分ループ
                        for (Map<String, Object> outMeisaiData : outMeisaiDataList) {
                            // Row作成
                            row = sheet.createRow(rowNumber++);
                            colNumber = 0;
                            // 各セルに表示位置、表示形式、フォント、フォントサイズ、文字色、背景色、罫線を設定する。
                            // 　　　　　キー："M_Kofu"
                            cell = row.createCell(colNumber++);
                            cellProperty.setCellProperty_Value(cell,
                                    CellProperty.FORMAT_DATE, outMeisaiData.get("Date_Kofu"));

                            // 　　　　　キー："M_Number"
                            cell = row.createCell(colNumber++);
                            cellProperty.setCellProperty_Value(cell,
                                    CellProperty.FORMAT_STRING_RIGHT_ALIGN, outMeisaiData.get("Number"));

                            // 　　　　　キー："M_Code_Organization"
                            cell = row.createCell(colNumber++);
                            cellProperty.setCellProperty_Value(cell,
                                    CellProperty.FORMAT_STRING_LEFT_ALIGN, outMeisaiData.get("Code_Organization"));

                            // 　　　　　キー："M_Name_Organization"
                            cell = row.createCell(colNumber++);
                            cellProperty.setCellProperty_Value(cell,
                                    CellProperty.FORMAT_STRING_LEFT_ALIGN, outMeisaiData.get("Name_Organization"));

                            // 　　　　　キー："M_ShikinHaraidashi_Yotei"
                            cell = row.createCell(colNumber++);
                            cellProperty.setCellProperty_Value(cell,
                                    CellProperty.FORMAT_NUM, outMeisaiData.get("M_Yotei"));

                            // 　　　　　キー："M_ShikinKoufu_ZandakaMikomi"
                            cell = row.createCell(colNumber++);
                            cellProperty.setCellProperty_Value(cell,
                                    CellProperty.FORMAT_NUM, outMeisaiData.get("M_ZanMikomi"));

                            // 　　　　　キー："M_Sashihiki_ShikinKoufu_Irai"
                            cell = row.createCell(colNumber++);
                            cellProperty.setCellProperty_Value(cell,
                                    CellProperty.FORMAT_NUM, outMeisaiData.get("M_Sum_Sashihiki_ShikinKoufu_Irai"));

                            // 　　　　　キー："M_Ganju"
                            cell = row.createCell(colNumber++);
                            cellProperty.setCellProperty_Value(cell,
                                    CellProperty.FORMAT_NUM, outMeisaiData.get("M_Ganju_Gaisu"));

                        }
                    }

                    // ==================================================
                    // 　　　フッタ設定
                    // ==================================================
                    // Row作成
                    row = sheet.createRow(rowNumber++);
                    colNumber = 0;
                    // 　　　　各セルに表示位置、表示形式、フォント、フォントサイズ、文字色、背景色、罫線を設定する。
                    // 　　　　キー："ftr_Blank1"
                    cell = row.createCell(colNumber++);
                    cellProperty.setCellProperty_Value(cell,
                            CellProperty.FORMAT_STRING_CENTER_ALIGN, "");

                    // 　　　　キー："ftr_Blank2"
                    cell = row.createCell(colNumber++);
                    cellProperty.setCellProperty_Value(cell,
                            CellProperty.FORMAT_STRING_CENTER_ALIGN, "");

                    // 　　　　キー："ftr_Sum"
                    cell = row.createCell(colNumber++);
                    cellProperty.setCellProperty_Value(cell,
                            CellProperty.FORMAT_STRING_CENTER_ALIGN, "合計");

                    // 　　　　キー："ftr_Blank3"
                    cell = row.createCell(colNumber++);
                    cellProperty.setCellProperty_Value(cell,
                            CellProperty.FORMAT_STRING_CENTER_ALIGN, "");

                    // 　　　　キー："ftr_ShikinHaraidashi_Yotei"
                    cell = row.createCell(colNumber++);
                    String ftr_ShikinHaraidashi_Yotei_Formula = createSumFormula(
                            colNumber
                            , row.getRowNum() - ((outMeisaiDataList.size() == 0) ? 0 : outMeisaiDataList.size() - 1)
                            , colNumber
                            , row.getRowNum());
                    cellProperty.setCellProperty_Formula(cell, ftr_ShikinHaraidashi_Yotei_Formula);

                    // 　　　　キー："ftr_ShikinKoufu_ZandakaMikomi"
                    cell = row.createCell(colNumber++);
                    String ftr_ShikinKoufu_ZandakaMikomi_Formula = createSumFormula(
                            colNumber
                            , row.getRowNum() - ((outMeisaiDataList.size() == 0) ? 0 : outMeisaiDataList.size() - 1)
                            , colNumber
                            , row.getRowNum());
                    cellProperty.setCellProperty_Formula(cell, ftr_ShikinKoufu_ZandakaMikomi_Formula);

                    // 　　　　キー："ftr_Sashihiki_ShikinKoufu_Irai"
                    cell = row.createCell(colNumber++);
                    String ftr_Sashihiki_ShikinKoufu_Irai_Formula = createSumFormula(
                            colNumber
                            , row.getRowNum() - ((outMeisaiDataList.size() == 0) ? 0 : outMeisaiDataList.size() - 1)
                            , colNumber
                            , row.getRowNum());
                    cellProperty.setCellProperty_Formula(cell, ftr_Sashihiki_ShikinKoufu_Irai_Formula);

                    // 　　　　キー："ftr_Ganju"
                    cell = row.createCell(colNumber++);
                    String ftr_Ganju_Gaisu_Formula = createSumFormula(
                            colNumber
                            , row.getRowNum() - ((outMeisaiDataList.size() == 0) ? 0 : outMeisaiDataList.size() - 1)
                            , colNumber
                            , row.getRowNum());
                    cellProperty.setCellProperty_Formula(cell, ftr_Ganju_Gaisu_Formula);

                    // 列幅を設定
                    sheet.setColumnWidth(0, 5120);
                    sheet.setColumnWidth(1, 5120);
                    sheet.setColumnWidth(2, 5120);
                    sheet.setColumnWidth(3, 6400);
                    sheet.setColumnWidth(4, 6400);
                    sheet.setColumnWidth(5, 6400);
                    sheet.setColumnWidth(6, 6400);
                    sheet.setColumnWidth(7, 6400);
                }

                // Excel出力
                outDto.setDownload_filepath(execOutputExcel(inDto, book));
            }
            catch (IOException e) {
                // システムエラー
                throw new PNSystemException(e);
            }
            finally {
                // ブッククローズ
                IOUtils.closeQuietly(book);
            }
        }

        return outDto;
    }

    /**
     * セル列番号からセル列英字に変換
     * @param colNo セル列番号
     * @return セル列英字
     */
    private String changeColString(int colNo) {
        int n = colNo;
        StringBuilder buf = new StringBuilder();
        while (n > 0) {
            buf.append((char)((n - 1) % 26 + 'A'));
            n = (n - 1) / 26;
        }
        return buf.reverse().toString();
    }

    /**
     * 合計計算式を作成
     * @param startCol
     * @param startRow
     * @param endCol
     * @param endRow
     * @return
     */
    private String createSumFormula(int startCol, int startRow, int endCol, int endRow) {
        return PNCommonComponents.concatString(
                "SUM("
                , changeColString(startCol)
                , String.valueOf(startRow)
                , ":"
                , changeColString(endCol)
                , String.valueOf(endRow)
                , ")");
    }

    /**
     * 交付日リスト取得
     * @param strShukeiDate
     * @return String[]
     */
    private String[] getDateKofuList(String strShukeiDate) {
        String[] dateKofuList = new String[0];

        // 　交付日リストの取得
        Se014_01KofuDateListEntity inKDLEntity = new Se014_01KofuDateListEntity();
        // 　　検索用パラメータをEntityへ設定
        // 　　　集計対象年月 ⇒ Se014_01Se014_01KofuDateListEntity.Date_Shukei_Taisho
        inKDLEntity.setDate_shukei_taisho(strShukeiDate);

        List<Se014_01KofuDateListEntity> outKDLEntityList = se014_01kofudatelistdao.findByCondition(inKDLEntity);

        // 　　結果Entityを交付日リストに転記
        if (outKDLEntityList.size() == 0) {
            // 　　　■Entityの件数　＝　0　の場合エラーとする。
            return dateKofuList;
        }

        // 交付日リスト
        dateKofuList = new String[outKDLEntityList.size()];

        // 　　　Entityの件数分ループ
        for (int i = 0; i < outKDLEntityList.size(); i++) {
            // 　　　交付日　Se014_01KofuDateListEntity.Date_Kofu ⇒ 交付日リスト
            dateKofuList[i] = outKDLEntityList.get(i).getDate_kofu();
        }

        return dateKofuList;
    }

    private List<Map<String, Object>> getMeisaiData(Se014_01DTO inDto, String strShukeiDate) {
        return getMeisaiData(inDto, strShukeiDate, new String[0]);
    }

    /**
     * 明細データを作成
     * @param inDto
     * @return
     */
    private List<Map<String, Object>> getMeisaiData(Se014_01DTO inDto, String strShukeiDate, String[] dateKofuList) {

        List<Map<String, Object>> meisaiDataList = new ArrayList<Map<String, Object>>();

        // ■資金交付依頼予定表（月間）集計表形式　または　資金交付依頼予定表（月間）データ形式を選択した場合
        if (inDto.getRdoid_shikinkofu().equals(Se014Constants.RDOID_YG_SHUKEITAISHO_SHUKEI)
                || inDto.getRdoid_shikinkofu().equals(Se014Constants.RDOID_YG_SHUKEITAISHO_DATA)) {

            // 　月間集計データの取得
            Se014_01SumMonthEntity inSMEntity = new Se014_01SumMonthEntity();
            // 　　検索用パラメータをEntityへ設定
            // 　　　集計対象年月 ⇒ Se014_01SumMonthEntity.Date_Shukei_Taisho
            inSMEntity.setDate_shukei_taisho(strShukeiDate);
            // 　　　交付日リスト ⇒ Se014_01SumMonthEntity.Date_Kofu
            inSMEntity.setList_date_kofu(dateKofuList);

            // 　　Se014_01SumMonthDAO.findByCondition
            List<Se014_01SumMonthEntity> outSMEntityList = se014_01summonthdao.findByCondition(inSMEntity);

            if (outSMEntityList.size() == 0) {
                // 　　■Entityの件数　＝　0　の場合、空の明細データを返す。
                return meisaiDataList;
            }

            // 　　　明細データコレクションを作成する。
            int count = 0;
            int meisaiStartRow = 0;
            if (inDto.getRdoid_shikinkofu().equals(Se014Constants.RDOID_YG_SHUKEITAISHO_SHUKEI)) {
                // 　　　　　■資金交付依頼予定表（月間）集計表形式を選択した場合
                meisaiStartRow = M_MEISAI_START_ROW_SHUKEI;
            }
            else if (inDto.getRdoid_shikinkofu().equals(Se014Constants.RDOID_YG_SHUKEITAISHO_DATA)) {
                // 　　　　　■資金交付依頼予定表（月間）データ形式を選択した場合
                meisaiStartRow = M_MEISAI_START_ROW_DATA;
            }

            for (Se014_01SumMonthEntity outSMEntity : outSMEntityList) {
                // Entityから値がnullの項目を削除
                outSMEntity.deleteSettingNullValue();
                // EntityからMapを作成
                Map<String, Object> outData = outSMEntity.getData();

                // 合計_依頼予定額 計算式を作成
                int m_sum_irai_shikinkofu_end_col = M_SUM_IRAI_SHIKINKOFU_START_COL + dateKofuList.length - 1;
                String m_sum_irai_shikinkofu_formula = createSumFormula(
                        M_SUM_IRAI_SHIKINKOFU_START_COL
                        , meisaiStartRow + count
                        , m_sum_irai_shikinkofu_end_col
                        , meisaiStartRow + count);

                // 合計_元金充当額（外数） 計算式を作成
                int m_sum_ganju_start_col = m_sum_irai_shikinkofu_end_col + 2;
                int m_sum_ganju_end_col = m_sum_ganju_start_col + dateKofuList.length - 1;
                String m_sum_ganju_formula = createSumFormula(
                        m_sum_ganju_start_col
                        , meisaiStartRow + count
                        , m_sum_ganju_end_col
                        , meisaiStartRow + count);

                // データMapにナンバーを追加
                outData.put("Number", ++count);
                // データMapに合計_依頼予定額 を追加
                outData.put("M_Sum_Irai_ShikinKofu", m_sum_irai_shikinkofu_formula);
                // データMapに合計_元金充当額（外数）を追加
                outData.put("M_Sum_Ganju", m_sum_ganju_formula);
                // データコレクションに追加
                meisaiDataList.add(outData);
            }
        }
        else if (inDto.getRdoid_shikinkofu().equals(Se014Constants.RDOID_YS_SHUKEITAISHO_SHUKEI)
                || inDto.getRdoid_shikinkofu().equals(Se014Constants.RDOID_YS_SHUKEITAISHO_DATA)) {
            // ■資金交付依頼書（週間）集計表形式　または　資金交付依頼書（週間）データ形式を選択した場合

            // 　週間集計表形式の取得
            // 　　検索用パラメータをEntityへ設定
            Se014_01SumWeekEntity inEntity = new Se014_01SumWeekEntity();
            // 　　　集計対象年月日 ⇒ Se014_01SumWeekEntity.Date_Shukei_Taisho
            inEntity.setDate_shukei_taisho(strShukeiDate);

            List<Se014_01SumWeekEntity> outSWEntityList = se014_01sumweekdao.findByCondition(inEntity);
            if (outSWEntityList.size() == 0) {
                // 　　■Entityの件数　＝　0　の場合、空の明細データを返す。
                return meisaiDataList;
            }

            // 　　　明細データコレクションを作成する。
            int count = 0;
            for (Se014_01SumWeekEntity outSWEntity : outSWEntityList) {
                // EntityからMapを作成
                Map<String, Object> outData = outSWEntity.getData();
                // データMapにナンバーを追加
                outData.put("Number", ++count);
                // データMapに 差引交付依頼額の合計 を追加
                BigDecimal bd_M_yotei = outSWEntity.getM_yotei();
                BigDecimal bd_M_zanmikomi = outSWEntity.getM_zanmikomi();
                BigDecimal bd_Sashihiki_ShikinKoufu_Irai = bd_M_yotei.subtract(bd_M_zanmikomi);
                outData.put("M_Sum_Sashihiki_ShikinKoufu_Irai", bd_Sashihiki_ShikinKoufu_Irai);
                // データコレクションに追加
                meisaiDataList.add(outData);
            }
        }

        return meisaiDataList;
    }

    /**
     * Excel出力
     * @param inDto
     * @param book
     * @throws IOException
     */
    private String execOutputExcel(Se014_01DTO inDto, Workbook book) throws IOException {

        final Log log = LogFactory.getLog(Se014_01ServiceImpl.class);

        // ファイルパス取得
        // ディレクトリ名取得
        String outputFileDirectory = PNResourceBundle.getApplicationProperty(TMP_FILE_DIRECTORY);
        // ファイル名取得
        String outputFileName = "";
        // ファイル名に使用するシステム日付取得
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String strSysdate = sdf.format((PNDateUtils.getSystemDate()));
        // ファイル名作成
        if (inDto.getRdoid_shikinkofu().equals(Se014Constants.RDOID_YG_SHUKEITAISHO_SHUKEI)) {
            // 　　　　　■資金交付依頼予定表（月間）集計表形式を選択した場合
            outputFileName = PNCommonComponents.concatString(
                    FILE_NAME_YG_SHUKEITAISHO_SHUKEI
                    , strSysdate);
        }
        else if (inDto.getRdoid_shikinkofu().equals(Se014Constants.RDOID_YG_SHUKEITAISHO_DATA)) {
            // 　　　　　■資金交付依頼予定表（月間）データ形式を選択した場合
            outputFileName = PNCommonComponents.concatString(
                    FILE_NAME_YG_SHUKEITAISHO_DATA
                    , strSysdate);
        }
        else if (inDto.getRdoid_shikinkofu().equals(Se014Constants.RDOID_YS_SHUKEITAISHO_SHUKEI)) {
            // 　　　　　■資金交付依頼書（週間）集計表形式を選択した場合
            outputFileName = PNCommonComponents.concatString(
                    FILE_NAME_YS_SHUKEITAISHO_SHUKEI
                    , strSysdate);
        }
        else if (inDto.getRdoid_shikinkofu().equals(Se014Constants.RDOID_YS_SHUKEITAISHO_DATA)) {
            // 　　　　　■資金交付依頼書（週間）データ形式を選択した場合
            outputFileName = PNCommonComponents.concatString(
                    FILE_NAME_YS_SHUKEITAISHO_DATA
                    , strSysdate);
        }
        // ファイルパス作成
        String outputFilePath = PNCommonComponents.concatString(outputFileDirectory,
                PNResourceBundle.getFileUtilsProperty(FILESEPARATOR_PROPERTY_NAME),
                outputFileName,
                FILE_EXTENSION);

        // 出力先ディレクトリが存在するかチェック
        File outputDir = new File(outputFilePath).getParentFile();
        if (!outputDir.exists()) {
            // ファイルを格納するディレクトリが存在しない場合、ディレクトリを作成する
            outputDir.mkdirs();
        }

        // 出力ストリーム宣言
        BufferedOutputStream output = null;
        try {
            // 出力ストリームインスタンス生成
            output = new BufferedOutputStream(new FileOutputStream(outputFilePath));

            // 出力
            book.write(output);

            return outputFilePath;
        }
        catch (IOException e) {
            log.error("Excelファイル作成時にエラー", e);
            throw e;
        }
        finally {
            // 出力ストリームクローズ
            IOUtils.closeQuietly(output);
        }
    }
}