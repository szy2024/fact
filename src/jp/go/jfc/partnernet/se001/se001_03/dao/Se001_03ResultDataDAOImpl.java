//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se001_03getResuluDataDAOImpl
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/13 | 小菱　忠雄            | 新規作成
// 2.0.0   | 2017/11/08 | 林　晃平              | H29年追加開発案件対応
//==================================================================================================
package jp.go.jfc.partnernet.se001.se001_03.dao;

import java.util.List;

import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.pnfw.common.PNCommonInfo;
import jp.go.jfc.partnernet.pnfw.common.PNCommonInfoHolder;
import jp.go.jfc.partnernet.pnfw.dao.PNBaseDAO;
import jp.go.jfc.partnernet.pnfw.dbaccess.PNSqlBuilder;

/**
 * <pre>
 * このクラスはSe001_03getResuluDataDAOの実装クラスです。
 * </pre>
 *
 * @author 林　晃平
 * @version 2.0.0
 */
public class Se001_03ResultDataDAOImpl extends PNBaseDAO<Se001_03ResultDataEntity> implements
        Se001_03ResultDataDAO {

    /**
     * 検索結果件数を取得します。
     * @param inEntity Se001_03getResultDataEntity
     * @return 該当件数
     * @see jp.go.jfc.partnernet.se001.se001_03.dao.Se001_03ResultDataDAO#countByCondition(jp.go.jfc.partnernet.se001.se001_03.dao.Se001_03ResultDataEntity)
     */
    @Override
    public long countByCondition(Se001_03ResultDataEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelectCount(sql);
        makeSqlWhere(sql, inEntity);
        return executeCountResult(sql);
    }

    /**
     * 条件検索をします。（一括検索用）
     * @param inEntity Se001_03getResultDataEntity
     * @return List&lt;Se001_03getResultDataEntity&gt;
     * @see jp.go.jfc.partnernet.se001.se001_03.dao.Se001_03ResultDataDAO#findByCondition(jp.go.jfc.partnernet.se001.se001_03.dao.Se001_03ResultDataEntity)
     */
    @Override
    public List<Se001_03ResultDataEntity> findByCondition(Se001_03ResultDataEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Se001_03ResultDataEntity.class);
    }

    /**
     * 条件検索をします。（逐次検索用）
     * @param inEntity Se001_03getResultDataEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Se001_03getResultDataEntity&gt;
     * @see jp.go.jfc.partnernet.se001.se001_03.dao.Se001_03ResultDataDAO#findByCondition(jp.go.jfc.partnernet.se001.se001_03.dao.Se001_03ResultDataEntity,
     *      int, int)
     */
    @Override
    public List<Se001_03ResultDataEntity> findByCondition(Se001_03ResultDataEntity inEntity, int offset,
            int length) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Se001_03ResultDataEntity.class, offset, length);
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
        sql.append("SELECT ");
        sql.append("CustomerInfoSearch2.ID_Postcode,");
        sql.append("CustomerInfoSearch2.Name_Shikugunchoson,");
        sql.append("CustomerInfoSearch2.Name_Todofuken,");
        sql.append("CustomerInfoSearch2.Name_OazaTsusho,");
        sql.append("CustomerInfoSearch2.Name_AzameiChome,");
        sql.append("CustomerInfoSearch2.Addr_Hojo,");
        sql.append("CustomerInfoSearch2.ID_Credit,");
        sql.append("CustomerInfoSearch2.Code_ShokanHonShiten,");
        sql.append("CustomerInfoSearch2.Code_Organization,");
        sql.append("CustomerInfoSearch2.Code_Tenpo,");
        sql.append("CustomerInfoSearch2.Year,");
        sql.append("CustomerInfoSearch2.Kubun_Hoshiki,");
        sql.append("CustomerInfoSearch2.Kubun_Shikin,");
        sql.append("CustomerInfoSearch2.ID_Ringi,");
        sql.append("CustomerInfoSearch2.ID_RingiBranch,");
        sql.append("CustomerInfoSearch2.Code_Customer,");
        sql.append("CustomerInfoSearch2.Date_Jikko,");
        sql.append("CustomerInfoSearch2.M_Kashitsuke,");
        sql.append("CustomerInfoSearch2.Kubun_KurishoTesuryo,");
        sql.append("CustomerInfoSearch2.Kubun_KinriSeidoSentaku,");
        sql.append("CustomerInfoSearch2.Riritsu,");
        sql.append("CustomerInfoSearch2.Kubun_Tokuri,");
        sql.append("CustomerInfoSearch2.Tokuri,");
        sql.append("CustomerInfoSearch2.Date_SueokiKigen,");
        sql.append("CustomerInfoSearch2.Date_ShokanKigen,");
        sql.append("CustomerInfoSearch2.Date_GanrikinHaraiKomi,");
        sql.append("CustomerInfoSearch2.Code_ShokanHouhou,");
        sql.append("CustomerInfoSearch2.M_Fukin,");
        sql.append("CustomerInfoSearch2.M_KashitsukeZandaka,");
        sql.append("CustomerInfoSearch2.Kubun_JutoJunjoHenko,");
        sql.append("CustomerInfoSearch2.Name_Customer,");
        sql.append("CustomerInfoSearch2.Code_ShikinShito,");
        sql.append("CustomerInfoSearch2.Code_Jusho,");
        sql.append("CustomerInfoSearch2.Name_Organization,");
        sql.append("CustomerInfoSearch2.Name_ShikinShito,");
        sql.append("CustomerInfoSearch2.Name_KoukoShiten,");
        sql.append("CustomerInfoSearch2.Name_Customer_KANA,");
        sql.append("CustomerInfoSearch2.Code_Noukyou,");
        sql.append("CustomerInfoSearch2.Date_TokuriYuko,");
        sql.append("CustomerInfoSearch2.Shihyoritsu ");
    }

    /**
     *
     * <pre>
     * sqlの検索条件部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Se001_03getResultDataEntity
     */
    private void makeSqlWhere(PNSqlBuilder sql, Se001_03ResultDataEntity inEntity) {

        /*
         * １．FROM句、WHERE句の設定 　　ログインユーザによって抽出条件を変更する。 　　
         *
         * 　　（２）Ｈ方式受託者の場合 　　　　貸付先コード＝貸付先コード選択値 かつ 　　　　扱店コード＝9937　かつ　農協コード＝扱店コード選択値
         */

        sql.append("FROM CustomerInfoSearch2 ");

        // 権限種別を取得
        String roleCode = "";
        PNCommonInfo commonInfo = PNCommonInfoHolder.getCommonInfo();
        if (null != commonInfo) {
            roleCode = commonInfo.getRoleCode();
        }

        // ①ユーザ権限＝計数管理担当者、管理者、受託者
        // 貸付先コード＝貸付先コード選択値
        if (PNCommonConstants.ROLECODE_KEISUUKANRITANTOUSHA.equals(roleCode)
                || PNCommonConstants.ROLECODE_KANRISHA.equals(roleCode)
                || PNCommonConstants.ROLECODE_JUTAKUSHA.equals(roleCode)) {
            // 貸付先コード＝貸付先コード選択値 かつ
            // (扱店コード＝扱店コード選択値 又は
            // (扱店コード＝9937　かつ　農協コード＝扱店コード選択値))
            sql.where("CustomerInfoSearch2.Code_Customer = ?", inEntity.getSe001_03_In_Code_Customer());
            sql.append(" AND (CustomerInfoSearch2.Code_Organization = ?",
                    inEntity.getSe001_03_In_Code_Organization());
            sql.append(" OR (CustomerInfoSearch2.Code_Organization = ?", PNCommonConstants.CODE_NOUKYOU_9937);
            sql.append(" AND " + " CustomerInfoSearch2.Code_Noukyou = ?))", commonInfo.getCode_Organization());

            // ②ユーザ権限＝H方式受託者
        }
        else if (PNCommonConstants.ROLECODE_HHOUSHIKIJUTAKUSHA.equals(roleCode)
                || PNCommonConstants.ROLECODE_KEITOUHHOUSHIKIJUTAKUSHA.equals(roleCode)) {
            // 貸付先コード＝貸付先コード選択値 かつ
            // 扱店コード＝9937　かつ
            // 農協コード＝扱店コード選択値
            sql.where("CustomerInfoSearch2.Code_Customer = ?", inEntity.getSe001_03_In_Code_Customer());
            sql.where("CustomerInfoSearch2.Code_Organization = ?", PNCommonConstants.CODE_NOUKYOU_9937);
            sql.where("CustomerInfoSearch2.Code_Noukyou = ?", inEntity.getSe001_03_In_Code_Organization());
        }

    }

    /**
     *
     * <pre>
     * sqlのorder by句部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Se001_03getResultDataEntity
     */
    private void makeSqlOrderby(PNSqlBuilder sql, Se001_03ResultDataEntity inEntity) {
        sql.append(" ORDER BY CustomerInfoSearch2.Date_Jikko ASC, CustomerInfoSearch2.ID_Credit ASC");
    }
}