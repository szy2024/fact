//==================================================================================================
// Project Name : 農林パートナーネット
// System Name  : JFC Partner Net
// Class Name   : Se012_01ResultsDataDAOImpl
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/09/25 | 宮郷　慎之介          | 新規作成（H29年追加開発案件対応）
//==================================================================================================
package jp.go.jfc.partnernet.se012.se012_01.dao;

import java.util.List;

import org.hsqldb.lib.StringUtil;

import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.pnfw.common.PNCommonInfoHolder;
import jp.go.jfc.partnernet.pnfw.dao.PNBaseDAO;
import jp.go.jfc.partnernet.pnfw.dbaccess.PNSqlBuilder;
import jp.go.jfc.partnernet.se012.common.Se012Constants;

/**
 * <pre>
 * このクラスはSe012_01ResultsDataDAOの実装クラスです。
 * </pre>
 *
 * @author 宮郷　慎之介
 * @version 2.0.0
 */
public class Se012_01ResultsDataDAOImpl extends
        PNBaseDAO<Se012_01ResultsDataEntity> implements Se012_01ResultsDataDAO {

    /**
     * 検索結果件数を取得します。
     *
     * @param inEntity
     *            Se012_01ResultsDataEntity
     * @return 該当件数
     * @see jp.go.jfc.partnernet.se012.se012_01.dao.Se012_01ResultsDataDAO#
     * countByCondition(jp.go.jfc.partnernet.se012.se012_01.dao.Se012_01ResultsDataEntity)
     */
    @Override
    public long countByCondition(Se012_01ResultsDataEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelectCount(sql);
        makeSqlSelect(sql, inEntity);
        makeSqlWhere(sql, inEntity);
        makeSqlSelectCountTerminal(sql);
        return executeCountResult(sql);
    }

    /**
     * 条件検索をします。（一括検索用）
     *
     * @param inEntity
     *            Se012_01ResultsDataEntity
     * @return List&lt;Se012_01ResultsDataEntity&gt;
     * @see jp.go.jfc.partnernet.se012.se012_01.dao.Se012_01ResultsDataDAO
     * #findByCondition(jp.go.jfc.partnernet.se012.se012_01.dao.Se012_01ResultsDataEntity)
     */
    @Override
    public List<Se012_01ResultsDataEntity> findByCondition(
            Se012_01ResultsDataEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql, inEntity);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Se012_01ResultsDataEntity.class);
    }

    /**
     * 条件検索をします。（逐次検索用）
     *
     * @param inEntity
     *            Se012_01ResultsDataEntity
     * @param offset
     *            取得開始位置
     * @param length
     *            取得開始位置からの取得件数
     * @return List&lt;Se012_01ResultsDataEntity&gt;
     * @see jp.go.jfc.partnernet.se012.se012_01.dao.Se012_01ResultsDataDAO
     * #findByCondition(jp.go.jfc.partnernet.se012.se012_01.dao.Se012_01ResultsDataEntity,
     *      int, int)
     */
    @Override
    public List<Se012_01ResultsDataEntity> findByCondition(
            Se012_01ResultsDataEntity inEntity, int offset, int length) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql, inEntity);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Se012_01ResultsDataEntity.class, offset,
                length);
    }

    /**
     *
     * <pre>
     * sqlのselect句（カウント取得用）を作成します。
     * </pre>
     *
     * @param sql
     *            PNSqlBuilder
     */
    private void makeSqlSelectCount(PNSqlBuilder sql) {
        sql.append("SELECT");
        sql.append(" COUNT(*) ");
        sql.append(" FROM ( ");
    }

    /**
    *
    * <pre>
    * sqlのselect句（カウント取得用）を作成します。
    * </pre>
    *
    * @param sql
    *            PNSqlBuilder
    */
    private void makeSqlSelectCountTerminal(PNSqlBuilder sql) {
        sql.append(")");
    }

    /**
     *
     * <pre>
     * sqlのselect句部分を作成します。
     * </pre>
     *
     * @param sql
     *            PNSqlBuilder
     */
    private void makeSqlSelect(PNSqlBuilder sql,
            Se012_01ResultsDataEntity inEntity) {
        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        String roleCode = PNCommonInfoHolder.getCommonInfo().getRoleCode();

        sql.append("SELECT * FROM( ");
        sql.append("SELECT ");
        sql.append("    CASE GI.Code_Organization ");
        sql.append("     WHEN ? THEN GI.Code_H_Oraganization ", Se012Constants.CODE_ORGANIZATION_9937);
        sql.append("     ELSE           GI.Code_Organization ");
        sql.append("END Code_Organization ");
        sql.append(",CASE GI.Code_Organization  ");
        sql.append("    WHEN ? THEN HOName.Name_Organization ", Se012Constants.CODE_ORGANIZATION_9937);
        sql.append("     ELSE          OName.Name_Organization ");
        sql.append("END Name_Organization ");
        if ((roleCode.equals(PNCommonConstants.ROLECODE_NOURINHONTEN)
                || roleCode.equals(PNCommonConstants.ROLECODE_NOURINSHITEN)
                || roleCode.equals(PNCommonConstants.ROLECODE_KEISUUKANRITANTOUSHA)
                || roleCode.equals(PNCommonConstants.ROLECODE_KANRISHA))
                && (StringUtil.isEmpty(inEntity.getCode_tenpo()) == false)) {
            // 権限種別が 農林中金(本店)、農林中金(支店)、計数管理担当者、管理者 のどれかかつ
            // 店舗コードが設定されている場合
            // 農林中金 店舗指定
            sql.append(",? Code_Tenpo ", inEntity.getCode_tenpo());
        }
        else {
            // その他の場合
            sql.append(",GI.Code_Tenpo ");
        }
        sql.append(",TName.Name_Tenpo ");
        sql.append(",GI.Date_JyohoTeikyo ");
        sql.append(",GI.Date_Taisho  ");
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }

    /**
     *
     * <pre>
     * sqlの検索条件部分を作成します。
     * </pre>
     *
     * @param sql
     *            PNSqlBuilder
     * @param inEntity
     *            Se012_01ResultsDataEntity
     */
    private void makeSqlWhere(PNSqlBuilder sql,
            Se012_01ResultsDataEntity inEntity) {

        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        // ログインユーザの権限種別取得
        String roleCode = PNCommonInfoHolder.getCommonInfo().getRoleCode();

        // FROM句
        sql.append("FROM ( ");
        sql.append("    SELECT ");
        sql.append("        GI.Code_Organization ");
        sql.append("        ,GI.Code_Tenpo ");
        sql.append("        ,GI.Code_H_Oraganization ");
        sql.append("        ,GI.Date_JyohoTeikyo ");
        sql.append("        ,GI.Date_Taisho ");
        sql.append("        ,GI.Doctype ");
        sql.append("    FROM GyomuitakuIndex GI ");
        sql.append("    LEFT OUTER JOIN TENPOKANRI TK ");
        sql.append("    ON GI.Code_Tenpo = TK.Code_KoTenpo ");
        sql.append("    WHERE TK.Code_KoTenpo IS NULL ");
        sql.append("    UNION ALL ");
        // 子店舗データから親店舗データを偽造
        sql.append("    SELECT  ");
        sql.append("        GI.Code_Organization ");
        sql.append("        ,TK.Code_Oyatenpo Code_Tenpo ");
        sql.append("        ,GI.Code_H_Oraganization ");
        sql.append("        ,GI.Date_JyohoTeikyo ");
        sql.append("        ,GI.Date_Taisho ");
        sql.append("        ,GI.Doctype ");
        sql.append("    FROM GyomuitakuIndex GI ");
        sql.append("    JOIN TENPOKANRI TK ");
        sql.append("    ON GI.Code_Tenpo = TK.Code_KoTenpo ");
        sql.append(") GI ");
        // 扱店名取得
        sql.append("LEFT JOIN TenpoNameView OName ");
        sql.append("ON GI.Code_Organization = OName.Code_Organization ");
        // Ｈ金融機関名取得
        sql.append("LEFT JOIN TenpoNameView HOName ");
        sql.append("ON GI.Code_Organization = ? ", Se012Constants.CODE_ORGANIZATION_9937);
        sql.append("AND GI.Code_H_Oraganization = HOName.Code_Organization ");
        // 店舗名取得
        if ((roleCode.equals(PNCommonConstants.ROLECODE_NOURINHONTEN)
                || roleCode.equals(PNCommonConstants.ROLECODE_NOURINSHITEN)
                || roleCode.equals(PNCommonConstants.ROLECODE_KEISUUKANRITANTOUSHA)
                || roleCode.equals(PNCommonConstants.ROLECODE_KANRISHA))
                && (StringUtil.isEmpty(inEntity.getCode_tenpo()) == false)) {
            // 権限種別が 農林中金(本店)、農林中金(支店)、計数管理担当者、管理者 のどれかかつ
            // 店舗コードが設定されている場合
            // 農林中金 店舗指定
            sql.append("LEFT JOIN( ");
            sql.append("    SELECT ");
            sql.append("        TKMV.Code_Organization ");
            sql.append("        ,TENPO.Code_Tenpo ");
            sql.append("        ,TENPO.Name_Tenpo ");
            sql.append("    FROM TenpoFukaMinView TKMV ");
            sql.append("    LEFT JOIN TENPO ");
            sql.append("    ON TKMV.Code_TenpoFukaMIN = Tenpo.Code_TenpoFuka ");
            sql.append("    AND TKMV.Code_Tenpo = Tenpo.Code_Tenpo ");
            sql.append("    AND TKMV.Code_Organization = Tenpo.Code_Organization ");
            sql.append("    WHERE TKMV.Code_Tenpo = ? ", inEntity.getCode_tenpo());
            sql.append(")TName ");
            sql.append("ON GI.Code_Organization = TName.Code_Organization ");
        }
        else {
            // その他の場合
            sql.append("LEFT JOIN( ");
            sql.append("    SELECT ");
            sql.append("        TKMV.Code_Organization ");
            sql.append("        ,TENPO.Code_Tenpo ");
            sql.append("        ,TENPO.Name_Tenpo ");
            sql.append("    FROM TenpoFukaMinView TKMV ");
            sql.append("    LEFT JOIN TENPO ");
            sql.append("    ON TKMV.Code_TenpoFukaMIN = Tenpo.Code_TenpoFuka ");
            sql.append("    AND TKMV.Code_Tenpo = Tenpo.Code_Tenpo ");
            sql.append("    AND TKMV.Code_Organization = Tenpo.Code_Organization ");
            sql.append(")TName ");
            sql.append("ON GI.Code_Organization = TName.Code_Organization ");
            sql.append("AND GI.Code_Tenpo = TName.Code_Tenpo ");

        }

        // WHERE句
        // 情報提供日
        sql.append("WHERE GI.Date_JyohoTeikyo <= ? ", inEntity.getDate_business());
        // 検索開始年月
        if (StringUtil.isEmpty(inEntity.getSearch_start_date()) == false) {
            sql.append("AND GI.Date_Taisho >= ? ", inEntity.getSearch_start_date());
        }
        // 検索終了年月
        if (StringUtil.isEmpty(inEntity.getSearch_end_date()) == false) {
            sql.append("AND GI.Date_Taisho <= ? ", inEntity.getSearch_end_date());
        }
        // 未加盟店検索
        if (StringUtil.isEmpty(inEntity.getSearch_mikameiten())) {
            sql.append("AND EXISTS(SELECT * FROM PN_USER PU WHERE PU.CODE_ORGANIZATION = GI.CODE_ORGANIZATION) ");
        }
        else {
            sql.append("AND NOT EXISTS(SELECT * FROM PN_USER PU WHERE PU.CODE_ORGANIZATION = GI.CODE_ORGANIZATION) ");
        }

        if ((roleCode.equals(PNCommonConstants.ROLECODE_NOURINHONTEN)
                || roleCode.equals(PNCommonConstants.ROLECODE_NOURINSHITEN)
                || roleCode.equals(PNCommonConstants.ROLECODE_KEISUUKANRITANTOUSHA)
                || roleCode.equals(PNCommonConstants.ROLECODE_KANRISHA))
                && (StringUtil.isEmpty(inEntity.getCode_tenpo()) == false)) {
            // 権限種別が 農林中金(本店)、農林中金(支店)、計数管理担当者、管理者 のどれかかつ
            // 店舗コードが設定されている場合
            // 農林中金 店舗指定

            if (StringUtil.isEmpty(inEntity.getCode_organization()) == false) {
                sql.append("AND GI.CODE_ORGANIZATION = ? ", inEntity.getCode_organization());
            }

            sql.append("AND GI.CODE_TENPO = ? ", inEntity.getCode_tenpo());
        }
        else if ((roleCode.equals(PNCommonConstants.ROLECODE_HHOUSHIKIJUTAKUSHA))
                && (StringUtil.isEmpty(inEntity.getCode_organization()) == false
                && StringUtil.isEmpty(inEntity.getCode_h_oraganization()) == false)) {
            // 権限種別が Ｈ方式受託者 かつ Ｈ金融機関コードが設定されている場合
            // Ｈ方式データ
            sql.append("AND ((GI.CODE_ORGANIZATION = ? ", inEntity.getCode_h_oraganization());
            sql.append("        AND GI.DOCTYPE < 60) ");
            sql.append("      OR (GI.CODE_ORGANIZATION = ? ", Se012Constants.CODE_ORGANIZATION_9937);
            sql.append("       AND GI.CODE_H_ORAGANIZATION = ? ", inEntity.getCode_h_oraganization());
            sql.append("       AND GI.DOCTYPE >= 60)) ");
        }
        else {
            // その他の場合
            if (StringUtil.isEmpty(inEntity.getCode_organization()) == false) {
                sql.append("AND (GI.CODE_ORGANIZATION = ? ", inEntity.getCode_organization());
                if (roleCode.equals(PNCommonConstants.ROLECODE_JUTAKUSHA)
                        || roleCode.equals(PNCommonConstants.ROLECODE_KEISUUKANRITANTOUSHA)
                        || roleCode.equals(PNCommonConstants.ROLECODE_KANRISHA)
                        || roleCode.equals(PNCommonConstants.ROLECODE_KEITOUJUTAKUSHA)
                        || roleCode.equals(PNCommonConstants.ROLECODE_KEITOUHHOUSHIKIJUTAKUSHA)) {
                    // 権限種別が 受託者、計数管理担当者、管理者、系統受託者、系統Ｈ方式受託者 なら Ｈ方式Excelデータも含める
                    sql.append("    OR (GI.CODE_ORGANIZATION = ? ", Se012Constants.CODE_ORGANIZATION_9937);
                    sql.append("     AND GI.CODE_H_ORAGANIZATION = ? ", inEntity.getCode_organization());
                    sql.append("     AND GI.DOCTYPE >= 60) ");
                }
                sql.append(" ) ");
            }
        }
        sql.append(" ) ");
        sql.append("GROUP BY  ");
        sql.append("Code_Organization ");
        sql.append(",Name_Organization ");
        sql.append(",Code_Tenpo  ");
        sql.append(",Name_Tenpo  ");
        sql.append(",Date_JyohoTeikyo  ");
        sql.append(",Date_Taisho ");
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }

    /**
     *
     * <pre>
     * sqlのorder by句部分を作成します。
     * </pre>
     *
     * @param sql
     *            PNSqlBuilder
     * @param inEntity
     *            Se012_01ResultsDataEntity
     */
    private void makeSqlOrderby(PNSqlBuilder sql,
            Se012_01ResultsDataEntity inEntity) {
        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        sql.append("ORDER BY ");
        sql.append(" Code_Organization ASC ");
        sql.append(",Code_Tenpo ASC ");
        sql.append(",Date_Taisho DESC ");
        sql.append(",Date_Jyohoteikyo DESC ");
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }
}