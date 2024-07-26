//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md006_02ResultsDataDAOImpl
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/14 | 堀　大輔            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.md006.md006_02.dao;

import java.util.List;

import jp.go.jfc.partnernet.pnfw.dao.PNBaseDAO;
import jp.go.jfc.partnernet.pnfw.dbaccess.PNSqlBuilder;

/**
 * <pre>
 * このクラスはMd006_02ResultsDataDAOの実装クラスです。
 * </pre>
 *
 * @author 矢嶋　洋
 * @version 1.0.0
 */
public class Md006_02ResultsDataDAOImpl extends PNBaseDAO<Md006_02ResultsDataEntity> implements
        Md006_02ResultsDataDAO {

    /**
     * 検索結果件数を取得します。
     * @param inEntity Md006_02ResultsDataEntity
     * @return 該当件数
     * @see jp.go.jfc.partnernet.md006.md006_02.dao.Md006_02ResultsDataDAO#countByCondition(jp.go.jfc.partnernet.md006.md006_02.dao.Md006_02ResultsDataEntity)
     */
    @Override
    public long countByCondition(Md006_02ResultsDataEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelectCount(sql);
        makeSqlWhere(sql, inEntity);
        return executeCountResult(sql);
    }

    /**
     * 条件検索をします。（一括検索用）
     * @param inEntity Md006_02ResultsDataEntity
     * @return List&lt;Md006_02ResultsDataEntity&gt;
     * @see jp.go.jfc.partnernet.md006.md006_02.dao.Md006_02ResultsDataDAO#findByCondition(jp.go.jfc.partnernet.md006.md006_02.dao.Md006_02ResultsDataEntity)
     */
    @Override
    public List<Md006_02ResultsDataEntity> findByCondition(Md006_02ResultsDataEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Md006_02ResultsDataEntity.class);
    }

    /**
     * 条件検索をします。（逐次検索用）
     * @param inEntity Md006_02ResultsDataEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Md006_02ResultsDataEntity&gt;
     * @see jp.go.jfc.partnernet.md006.md006_02.dao.Md006_02ResultsDataDAO#findByCondition(jp.go.jfc.partnernet.md006.md006_02.dao.Md006_02ResultsDataEntity,
     *      int, int)
     */
    @Override
    public List<Md006_02ResultsDataEntity> findByCondition(Md006_02ResultsDataEntity inEntity, int offset,
            int length) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Md006_02ResultsDataEntity.class, offset, length);
    }

    /**
     *
     * <pre>
     * sqlのselect句（カウント取得用）を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     */
    private void makeSqlSelectCount(PNSqlBuilder sql) {
        sql.append("SELECT");
        sql.append(" COUNT(1) ");
    }

    /**
     *
     * <pre>
     * sqlのselect句部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     */
    private void makeSqlSelect(PNSqlBuilder sql) {
        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        sql.append("SELECT");
        sql.append(" TR.Date_Report AS ID_Date_Report ");
        sql.append(" ,TR.Name_Customer AS ID_Name_Customer ");
        sql.append(" ,TR.Name_Organization AS ID_Name_Organization ");
        sql.append(" ,TR.Code_KoukoShiten AS ID_Code_KoukoShiten ");
        sql.append(" ,TR.Code_Organization AS Code_Organization ");
        sql.append(" ,TR.Code_Tenpo AS ID_Code_Tenpo ");
        sql.append(" ,TR.Year AS ID_Year ");
        sql.append(" ,TR.Code_HoshikiShikin AS ID_Code_HoshikiShikin ");
        sql.append(" ,TR.ID_Ringi AS ID_ID_Ringi ");
        sql.append(" ,TR.ID_RingiBranch AS ID_ID_RingiBranch ");
        sql.append(" ,TR.Code_TatekaekinShurui AS ID_Code_TatekaekinShurui ");
        sql.append(" ,TR.Date_KoukoTatekae AS ID_Date_KoukoTatekae ");
        sql.append(" ,TR.Date_Nyukin AS ID_Date_Nyukin ");
        sql.append(" ,TR.M_TatekaeRisoku AS ID_M_TatekaeRisoku ");
        sql.append(" ,TR.M_Tatekae AS ID_M_Tatekae ");
        sql.append(" ,TR.M_Kei AS ID_M_Kei ");
        sql.append(" ,TR.M_KariukeIppanJuto AS ID_M_KariukeIppanJuto ");
        sql.append(" ,TR.M_Sokin AS ID_M_Sokin ");
        sql.append(" ,TR.M_TatekaeZanAfterUkeire AS ID_M_TatekaeZanAfterUkeire ");
        sql.append(" ,TR.Date_Jtkshori AS ID_Date_Jtkshori ");
        sql.append(" ,TR.Date_Sokin AS ID_Date_Sokin ");
        sql.append(" ,TR.ID_Sokinbi AS ID_ID_Sokinbi ");
        sql.append(" ,TR.ID_Report AS ID_ID_Report ");
        sql.append(" ,TR.Time_Report AS ID_Time_Report ");
        sql.append(" ,TR.UserID AS ID_UserID ");
        sql.append(" ,TR.ID_Denso AS ID_ID_Denso ");
        sql.append(" ,TR.DataCode AS ID_DataCode ");
        sql.append(" ,TR.ID_History AS ID_ID_History ");
        sql.append(" ,TR.Status AS ID_Status ");
        sql.append(" ,TR.Type_Process AS ID_Type_Process ");
        sql.append(" ,TR.Flag_Torikeshizumi AS ID_Flag_Torikeshizumi ");
        sql.append(" ,TR.Code_Error AS ID_Code_Error ");
        sql.append(" ,TR.ErrorMessage AS ID_ErrorMessage ");
        sql.append(" ,TR.ID_Credit AS ID_ID_Credit ");
        sql.append(" ,TR.Keep_ID_History AS ID_Keep_ID_History ");
        sql.append(" ,TR.Keep_Flag_Kj AS ID_Keep_Flag_Kj ");
        sql.append(" ,TR.Keep_M_TatekaeZanAfterUkeire AS ID_Keep_TatekaeZanAfterUkeire ");
        sql.append(" ,TR.Data_LastUpDate AS ID_Data_LastUpDate ");
        sql.append(" ,TR.Keep_ID_Karibarai AS ID_ID_Karibarai ");
        sql.append(" ,TR.Keep_Code_HonShiten AS ID_Code_HonShiten ");
        sql.append(" ,KM.M_KaribaraiZanAfterSeisan AS ID_M_KaribaraiZanAfterSeisan ");
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }

    /**
     *
     * <pre>
     * sqlの検索条件部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Md006_02ResultsDataEntity
     */
    private void makeSqlWhere(PNSqlBuilder sql, Md006_02ResultsDataEntity inEntity) {

        /*
         * １．FROM句の設定 　　　立替金受入・充当報告書取消・修正ビュー TR　LEFT OUTER JOIN 　　　　　　　　仮払金勘定明細データ KM　ON 　　　　　　　　TR.公庫支店 =
         * KM.公庫支店コード AND TR.扱店 = KM.扱店コード AND TR.店舗 = KM.店舗コード AND TR.年度 = KM.年度 AND TR.番号 = KM.稟議番号 AND
         * TR.枝番 = KM.稟議番号枝番 AND TR.公庫立替日 = KM.仮受仮払日（公庫立替日） AND TR.仮受仮払番号 = KM.仮受仮払番号 AND TR.本支店コード =
         * KM.本支店コード
         * 
         * ２．WHERE句の設定 　　　　TR.報告書番号　＝　指定された報告書番号 　　　　TR.扱店　＝　ログインユーザの扱店コード
         */

        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        sql.append("FROM TatekaeReportModView TR ");
        sql.append("LEFT OUTER JOIN KanjoMeisai KM ");
        sql.append("ON TR.Code_Organization = KM.Code_Organization ");
        sql.append("AND TR.Code_Tenpo = KM.Code_Tenpo ");
        sql.append("AND TR.Year = KM.Year ");
        sql.append("AND TR.ID_Ringi = KM.ID_Ringi ");
        sql.append("AND TR.ID_RingiBranch = KM.ID_RingiBranch ");
        sql.append("AND TR.Date_KoukoTatekae = KM.Date_Karibarai ");
        sql.append("AND TR.Keep_ID_Karibarai = KM.ID_Karibarai ");
        sql.append("AND TR.Keep_Code_HonShiten = KM.Code_HonShiten ");

        sql.where("TR.ID_Report = ?", inEntity.getID_Report());
        sql.where("TR.Code_Organization = ?", inEntity.getCode_Organization());
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }

    /**
     *
     * <pre>
     * sqlのorder by句部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Md006_02ResultsDataEntity
     */
    private void makeSqlOrderby(PNSqlBuilder sql, Md006_02ResultsDataEntity inEntity) {
        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }
}