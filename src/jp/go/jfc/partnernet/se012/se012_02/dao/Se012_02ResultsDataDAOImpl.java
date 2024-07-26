//==================================================================================================
// Project Name : 農林パートナーネット
// System Name  : JFC Partner Net
// Class Name   : Se012_02ResultsDataDAOImpl
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 2.0.0   | 2017/10/05 | 宮郷　慎之介          | 新規作成（H29年追加開発案件対応）
//==================================================================================================
package jp.go.jfc.partnernet.se012.se012_02.dao;

import java.util.List;

import org.hsqldb.lib.StringUtil;

import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.pnfw.common.PNCommonInfoHolder;
import jp.go.jfc.partnernet.pnfw.dao.PNBaseDAO;
import jp.go.jfc.partnernet.pnfw.dbaccess.PNSqlBuilder;
import jp.go.jfc.partnernet.se012.common.Se012Constants;

/**
 * <pre>
 * このクラスはSe012_02ResultsDataDAOの実装クラスです。
 * </pre>
 *
 * @author 宮郷　慎之介
 * @version 2.0.0
 */
public class Se012_02ResultsDataDAOImpl extends PNBaseDAO<Se012_02ResultsDataEntity> implements Se012_02ResultsDataDAO {

    /**
     * 検索結果件数を取得します。
     * @param inEntity Se012_02ResultsDataEntity
     * @return 該当件数
     * @see jp.go.jfc.partnernet.se012.se012_02.dao.Se012_02ResultsDataDAO
     * #countByCondition(jp.go.jfc.partnernet.se012.se012_02.dao.Se012_02ResultsDataEntity)
     */
    @Override
    public long countByCondition(Se012_02ResultsDataEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelectCount(sql);
        makeSqlWhere(sql, inEntity);
        return executeCountResult(sql);
    }

    /**
     * 条件検索をします。（一括検索用）
     * @param inEntity Se012_02ResultsDataEntity
     * @return List&lt;Se012_02ResultsDataEntity&gt;
     * @see jp.go.jfc.partnernet.se012.se012_02.dao.Se012_02ResultsDataDAO
     * #findByCondition(jp.go.jfc.partnernet.se012.se012_02.dao.Se012_02ResultsDataEntity)
     */
    @Override
    public List<Se012_02ResultsDataEntity> findByCondition(Se012_02ResultsDataEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Se012_02ResultsDataEntity.class);
    }

    /**
     * 条件検索をします。（逐次検索用）
     * @param inEntity Se012_02ResultsDataEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Se012_02ResultsDataEntity&gt;
     * @see jp.go.jfc.partnernet.se012.se012_02.dao.Se012_02ResultsDataDAO
     * #findByCondition(jp.go.jfc.partnernet.se012.se012_02.dao.Se012_02ResultsDataEntity, int, int)
     */
    @Override
    public List<Se012_02ResultsDataEntity> findByCondition(Se012_02ResultsDataEntity inEntity,
            int offset, int length) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Se012_02ResultsDataEntity.class,
                offset, length);
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
        sql.append("SELECT ");
        sql.append(" GI.DISP_DOCNAME ");
        sql.append(" ,GI.DOCNAME ");
        sql.append(" ,GI.FILEPATH ");
        sql.append(" ,GI.DOCTYPE ");
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }

    /**
     *
     * <pre>
     * sqlの検索条件部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Se012_02ResultsDataEntity
     */
    private void makeSqlWhere(PNSqlBuilder sql, Se012_02ResultsDataEntity inEntity) {
        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        // ログインユーザの権限種別取得
        String roleCode = PNCommonInfoHolder.getCommonInfo().getRoleCode();

        /* FROM句 */
        sql.append(" FROM GYOMUITAKUINDEX GI ");
        if ((roleCode.equals(PNCommonConstants.ROLECODE_NOURINHONTEN)
                || roleCode.equals(PNCommonConstants.ROLECODE_NOURINSHITEN)
                || roleCode.equals(PNCommonConstants.ROLECODE_KEISUUKANRITANTOUSHA)
                || roleCode.equals(PNCommonConstants.ROLECODE_KANRISHA))
                && (StringUtil.isEmpty(inEntity.getCode_tenpo()) == false)) {
            // 権限種別が 農林中金(本店)、農林中金(支店)、計数管理担当者、管理者 のどれかかつ
            // 店舗コードが設定されている場合
            sql.append(" LEFT JOIN  TENPOKANRI TK ");
            sql.append(" ON GI.CODE_TENPO = TK.CODE_KOTENPO ");
        }

        /* WHERE句 */
        // 情報提供日
        sql.append(" WHERE GI.DATE_JYOHOTEIKYO = ? ", inEntity.getDate_jyohoteikyo());
        // 対象年月
        sql.append(" AND GI.DATE_TAISHO = ? ", inEntity.getDate_taisho());

        if ((roleCode.equals(PNCommonConstants.ROLECODE_NOURINHONTEN)
                || roleCode.equals(PNCommonConstants.ROLECODE_NOURINSHITEN)
                || roleCode.equals(PNCommonConstants.ROLECODE_KEISUUKANRITANTOUSHA)
                || roleCode.equals(PNCommonConstants.ROLECODE_KANRISHA))
                && (StringUtil.isEmpty(inEntity.getCode_tenpo()) == false)) {
            // 権限種別が 農林中金(本店)、農林中金(支店)、計数管理担当者、管理者 のどれかかつ
            // 店舗コードが設定されている場合

            if (StringUtil.isEmpty(inEntity.getCode_organization()) == false) {
                // 扱店コードが設定されている場合
                sql.append(" AND GI.CODE_ORGANIZATION = ? ", inEntity.getCode_organization());
            }
            sql.append(" AND (GI.CODE_TENPO = ? ", inEntity.getCode_tenpo());
            sql.append("       OR TK.CODE_OYATENPO = ?) ", inEntity.getCode_tenpo());
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
                sql.append(" AND (GI.CODE_ORGANIZATION = ? ", inEntity.getCode_organization());
                if (roleCode.equals(PNCommonConstants.ROLECODE_JUTAKUSHA)
                        || roleCode.equals(PNCommonConstants.ROLECODE_KEISUUKANRITANTOUSHA)
                        || roleCode.equals(PNCommonConstants.ROLECODE_KANRISHA)
                        || roleCode.equals(PNCommonConstants.ROLECODE_KEITOUJUTAKUSHA)
                        || roleCode.equals(PNCommonConstants.ROLECODE_KEITOUHHOUSHIKIJUTAKUSHA)) {
                    // 権限種別が 受託者、計数管理担当者、管理者、系統受託者、系統Ｈ方式受託者 なら Ｈ方式Excelデータも含める
                    sql.append("     OR (GI.CODE_ORGANIZATION = ? ", Se012Constants.CODE_ORGANIZATION_9937);
                    sql.append("     AND GI.CODE_H_ORAGANIZATION = ? ", inEntity.getCode_organization());
                    sql.append("     AND GI.DOCTYPE >= 60) ");
                }
            }
            sql.append(" ) ");
        }

        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }

    /**
     *
     * <pre>
     * sqlのorder by句部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Se012_02ResultsDataEntity
     */
    private void makeSqlOrderby(PNSqlBuilder sql, Se012_02ResultsDataEntity inEntity) {
        // ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
        sql.append(" ORDER BY ");
        sql.append(" GI.DOCTYPE ");
        sql.append(" ,GI.CODE_ORGANIZATION ");
        sql.append(" ,GI.CODE_TENPO ");
        sql.append(" ,GI.CODE_H_ORAGANIZATION ");
        // ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
    }
}