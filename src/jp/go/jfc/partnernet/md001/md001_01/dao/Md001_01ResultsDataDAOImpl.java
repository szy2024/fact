//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md001_01ResultsDataDAOImpl
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/24 | 田旗　秀樹            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.md001.md001_01.dao;

import java.util.List;

import jp.go.jfc.partnernet.pnfw.dao.PNBaseDAO;
import jp.go.jfc.partnernet.pnfw.dbaccess.PNSqlBuilder;

/**
 * <pre>
 * このクラスはMd001_01ResultsDataDAOの実装クラスです。
 * </pre>
 *
 * @author 田旗　秀樹
 * @version 1.0.0
 */
public class Md001_01ResultsDataDAOImpl extends PNBaseDAO<Md001_01ResultsDataEntity> implements
        Md001_01ResultsDataDAO {

    /**
     * 検索結果件数を取得します。
     *
     * @param inEntity Md001_01ResultsDataEntity
     * @return 該当件数
     * @see jp.go.jfc.partnernet.md001.md001_01.dao.Md001_01ResultsDataDAO#countByCondition(jp.go.jfc.partnernet.md001.md001_01.dao.Md001_01ResultsDataEntity)
     */
    @Override
    public long countByCondition(Md001_01ResultsDataEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelectCount(sql);
        makeSqlWhere(sql, inEntity);
        return executeCountResult(sql);
    }

    /**
     * 条件検索をします。（一括検索用）
     *
     * @param inEntity Md001_01ResultsDataEntity
     * @return List&lt;Md001_01ResultsDataEntity&gt;
     * @see jp.go.jfc.partnernet.md001.md001_01.dao.Md001_01ResultsDataDAO#findByCondition(jp.go.jfc.partnernet.md001.md001_01.dao.Md001_01ResultsDataEntity)
     */
    @Override
    public List<Md001_01ResultsDataEntity> findByCondition(Md001_01ResultsDataEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Md001_01ResultsDataEntity.class);
    }

    /**
     * 条件検索をします。（逐次検索用）
     *
     * @param inEntity Md001_01ResultsDataEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Md001_01ResultsDataEntity&gt;
     * @see jp.go.jfc.partnernet.md001.md001_01.dao.Md001_01ResultsDataDAO#findByCondition(jp.go.jfc.partnernet.md001.md001_01.dao.Md001_01ResultsDataEntity,
     *      int, int)
     */
    @Override
    public List<Md001_01ResultsDataEntity> findByCondition(Md001_01ResultsDataEntity inEntity, int offset,
            int length) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Md001_01ResultsDataEntity.class, offset, length);
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
        sql.append("SELECT");
        sql.append("   KJ.Date_Report AS ID_Date_Report");
        sql.append(" , KJ.ID_Report AS ID_ID_Report");
        sql.append(" , KJ.Date_Report AS ID_Date_Report");
        sql.append(" , KJ.ErrorMessage AS ID_ErrorMessage");
        sql.append(" , KJ.Name_Customer AS ID_Name_Customer");
        sql.append(" , KJ.Name_Organization AS ID_Name_Organization");
        sql.append(" , KJ.Code_KoukoShiten AS ID_Code_KoukoShiten");
        sql.append(" , KJ.Code_Organization AS ID_Code_Organization");
        sql.append(" , KJ.Code_Tenpo AS ID_Code_Tenpo");
        sql.append(" , KJ.Year AS ID_Year");
        sql.append(" , KJ.Code_HoshikiShikin AS ID_Code_HoshikiShikin");
        sql.append(" , KJ.ID_Ringi AS ID_ID_Ringi");
        sql.append(" , KJ.ID_RingiBranch AS ID_ID_RingiBranch");
        sql.append(" , KJ.Code_ShikinShito AS ID_Code_ShikinShito");
        sql.append(" , KJ.Code_Jigyobetsu AS ID_Code_Jigyobetsu");
        sql.append(" , KJ.Riritsu AS ID_Riritsu");
        sql.append(" , KJ.Code_TokuriKubun AS ID_Kubun_Tokuri");
        sql.append(" , KJ.Tokuri AS ID_Tokuri");
        sql.append(" , KJ.Date_SueokiKigen AS ID_Date_SueokiKigen");
        sql.append(" , KJ.Date_ShokanKigen AS ID_Date_ShokanKigen");
        sql.append(" , KJ.Date_GanrikinHaraikomi AS ID_Date_GanrikinHaraikomi");
        sql.append(" , KJ.Date_Jtkshori AS ID_Date_Jtkshori");
        sql.append(" , KJ.Date_Jtkshori_Inpit AS ID_Date_Jtkshori_Inpit");
        sql.append(" , KJ.Date_Kashitsukejikko AS ID_Date_Kashitsukejikko");
        sql.append(" , KJ.M_Kashitsuke AS ID_M_Kashitsuke");
        sql.append(" , KJ.M_ShikinKofu AS ID_M_ShikinKofu");
        sql.append(" , KJ.M_KashitukeUkeire AS ID_M_KashitukeUkeire");
        sql.append(" , KJ.ID_History AS ID_ID_History");
        sql.append(" , KJ.Type_Process AS ID_Type_Process");
        sql.append(" , KJ.Flag_Torikeshizumi AS ID_Flag_Torikeshizumi");
        sql.append(" , KJ.Code_Error AS ID_Code_Error");
        sql.append(" , KJ.ID_Credit AS ID_ID_Credit");
        sql.append(" , KJ.ID_Denso AS ID_ID_Denso");
        sql.append(" , KJ.Count_Kashitsuke AS ID_Count_Kashitsuke");
        sql.append(" , KJ.Status AS ID_Status");
        sql.append(" , KJ.DataCode AS ID_DataCode");
        sql.append(" , KJ.UserID AS ID_UserID");
        sql.append(" , KJ.Time_Report AS ID_Time_Report");
        sql.append(" , KJ.aRingi_Flag_Kj AS ID_aRingi_Flag_Kj");
        sql.append(" , KJ.Code_Customer AS ID_Code_Customer");
        sql.append(" , KJ.Date_JuriKisan AS ID_Date_JuriKisan");
        sql.append(" , KJ.Date_KetteiKisan AS ID_Date_KetteiKisan");
        sql.append(" , KJ.Keep_Date_ShokanKigen AS ID_Keep_Date_ShokanKigen");
        sql.append(" , KJ.Keep_ID_History AS ID_Keep_ID_History");
        sql.append(" , KJ.Keep_Flag_Kj AS ID_Keep_Flag_Kj");
        sql.append(" , KJ.aRingi_Date_ShokanKigen AS ID_aRingi_Date_ShokanKigen");
        sql.append(" , KJ.aRingi_Riritsu AS ID_aRingi_Riritsu");
        sql.append(" , KJ.aRingi_Tokuri AS ID_aRingi_Tokuri");
        sql.append(" , KJ.Data_LastUpDate AS ID_Data_LastUpDate");
    }

    /**
     *
     * <pre>
     * sqlの検索条件部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Md001_01ResultsDataEntity
     */
    private void makeSqlWhere(PNSqlBuilder sql, Md001_01ResultsDataEntity inEntity) {

        /*
         * １．WHERE句の設定 　　扱店　＝　ログインユーザの扱店コード 　　報告書番号　＝　指定された報告書番号
         */

        sql.append(" FROM");
        sql.append(" KashitukeJikkoModView KJ ");
        sql.append(" WHERE ");
        sql.append(" KJ.Code_Organization = ?", inEntity.getCode_Organization());
        if (null != inEntity.getCode_Organization()) {
            sql.append(" AND ");
        }
        sql.append(" KJ.ID_Report = ?", inEntity.getID_Report());
    }

    /**
     *
     * <pre>
     * sqlのorder by句部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Md001_01ResultsDataEntity
     */
    private void makeSqlOrderby(PNSqlBuilder sql, Md001_01ResultsDataEntity inEntity) {
    }
}