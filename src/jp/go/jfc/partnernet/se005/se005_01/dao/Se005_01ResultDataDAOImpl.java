//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se005_01GetResultDataDAOImpl
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/28 | 田旗　秀樹            | 新規作成
// 2.0.0   | 2017/11/08 | 林　晃平              | H29年追加開発案件対応
//==================================================================================================
package jp.go.jfc.partnernet.se005.se005_01.dao;

import java.util.List;

import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.pnfw.common.PNCommonInfo;
import jp.go.jfc.partnernet.pnfw.common.PNCommonInfoHolder;
import jp.go.jfc.partnernet.pnfw.dao.PNBaseDAO;
import jp.go.jfc.partnernet.pnfw.dbaccess.PNSqlBuilder;

/**
 * <pre>
 * このクラスはSe005_01GetResultDataDAOの実装クラスです。
 * </pre>
 *
 * @author 林　晃平
 * @version 2.0.0
 */
public class Se005_01ResultDataDAOImpl extends PNBaseDAO<Se005_01ResultDataEntity> implements
        Se005_01ResultDataDAO {

    /**
     * 検索結果件数を取得します。
     *
     * @param inEntity Se005_01GetResultDataEntity
     * @return 該当件数
     * @see jp.go.jfc.partnernet.se005.se005_01.dao.Se005_01ResultDataDAO#countByCondition(jp.go.jfc.partnernet.se005.se005_01.dao.Se005_01ResultDataEntity)
     */
    @Override
    public long countByCondition(Se005_01ResultDataEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelectCount(sql);
        makeSqlWhere(sql, inEntity);
        return executeCountResult(sql);
    }

    /**
     * 条件検索をします。（一括検索用）
     *
     * @param inEntity Se005_01GetResultDataEntity
     * @return List&lt;Se005_01GetResultDataEntity&gt;
     * @see jp.go.jfc.partnernet.se005.se005_01.dao.Se005_01ResultDataDAO#findByCondition(jp.go.jfc.partnernet.se005.se005_01.dao.Se005_01ResultDataEntity)
     */
    @Override
    public List<Se005_01ResultDataEntity> findByCondition(Se005_01ResultDataEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Se005_01ResultDataEntity.class);
    }

    /**
     * 条件検索をします。（逐次検索用）
     *
     * @param inEntity Se005_01GetResultDataEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Se005_01GetResultDataEntity&gt;
     * @see jp.go.jfc.partnernet.se005.se005_01.dao.Se005_01ResultDataDAO#findByCondition(jp.go.jfc.partnernet.se005.se005_01.dao.Se005_01ResultDataEntity,
     *      int, int)
     */
    @Override
    public List<Se005_01ResultDataEntity> findByCondition(Se005_01ResultDataEntity inEntity, int offset,
            int length) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Se005_01ResultDataEntity.class, offset, length);
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
        sql.append("SaikenIchiran2.Expr2");
        sql.append(",replace(SaikenIchiran2.Expr1,'支店','') as Expr1");
        sql.append(",SaikenIchiran2.Code_Organization");
        sql.append(",SaikenIchiran2.Code_Tenpo");
        sql.append(",SaikenIchiran2.Year");
        sql.append(",SaikenIchiran2.Expr3");
        sql.append(",SaikenIchiran2.ID_Ringi");
        sql.append(",SaikenIchiran2.ID_RingiBranch");
        sql.append(",SaikenIchiran2.Code_Noukyou");
        sql.append(",SaikenIchiran2.Date_Jikko");
        sql.append(",SaikenIchiran2.M_Kashitsuke");
        sql.append(",SaikenIchiran2.Code_ShikinShito");
        sql.append(",SaikenIchiran2.Riritsu");
        sql.append(",SaikenIchiran2.Kubun_Tokuri");
        sql.append(",SaikenIchiran2.Tokuri");
        sql.append(",SaikenIchiran2.Shihyoritsu");
        sql.append(",SaikenIchiran2.Date_SueokiKigen");
        sql.append(",SaikenIchiran2.Date_ShokanKigen");
        sql.append(",SaikenIchiran2.Date_GanrikinHaraiKomi");
        sql.append(",SaikenIchiran2.Code_ShokanHouhou");
        sql.append(",SaikenIchiran2.M_Fukin");
        sql.append(",SaikenIchiran2.Kubun_GankinFukintogaku");
        sql.append(",SaikenIchiran2.M_KashitsukeZandaka");
        sql.append(",SaikenIchiran2.ID_Credit");

    }

    /**
     *
     * <pre>
     * sqlの検索条件部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Se005_01GetResultDataEntity
     */
    private void makeSqlWhere(PNSqlBuilder sql, Se005_01ResultDataEntity inEntity) {

        sql.append(" FROM SaikenIchiran2 ");

        // 権限種別を取得
        String roleCode = "";
        PNCommonInfo commonInfo = PNCommonInfoHolder.getCommonInfo();
        if (null != commonInfo) {
            roleCode = commonInfo.getRoleCode();
        }

        /*
         * １．FROM句、WHERE句の設定 入力引数のログインユーザ権限種別によって抽出条件を変更する。 （１）受託者の場合 債権一覧照会ビュー「扱店コード」＝入力引数のログインユーザ扱店コード　又は
         * （債権一覧照会ビュー「扱店コード」＝9937 かつ 債権一覧照会ビュー「農協コード」＝入力引数のログインユーザ扱店コード）
         *
         * （２）計数管理担当者、管理者の場合 　　　　　債権一覧照会ビュー「扱店コード」＝入力引数のログインユーザ扱店コード
         *
         * 　　（３）Ｈ方式受託者の場合 　　　　　債権一覧照会ビュー「扱店コード」＝9937　かつ 　　　　　債権一覧照会ビュー「農協コード」＝入力引数のログインユーザ扱店コード
         *
         * ２．その他　補足事項 　　オフセット、リミットを指定して、データを取得する。
         */
        if (PNCommonConstants.ROLECODE_JUTAKUSHA.equals(roleCode)) {
            sql.append("WHERE SaikenIchiran2.Code_Organization = ?", commonInfo.getCode_Organization());
            sql.append(" OR (SaikenIchiran2.Code_Organization = '9937' AND SaikenIchiran2.Code_Noukyou = ?)",
                    commonInfo.getCode_Organization());
        }
        else if (PNCommonConstants.ROLECODE_KEISUUKANRITANTOUSHA.equals(roleCode)
                || PNCommonConstants.ROLECODE_KANRISHA.equals(roleCode)) {
            // 扱店コードを入れない
        }
        else if (PNCommonConstants.ROLECODE_HHOUSHIKIJUTAKUSHA.equals(roleCode)
                || PNCommonConstants.ROLECODE_KEITOUHHOUSHIKIJUTAKUSHA.equals(roleCode)) {
            sql.whereEqual("SaikenIchiran2.Code_Organization", "9937");
            sql.whereEqual("SaikenIchiran2.Code_Noukyou", commonInfo.getCode_Organization());
        }
    }

    /**
     *
     * <pre>
     * sqlのorder by句部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Se005_01GetResultDataEntity
     */
    private void makeSqlOrderby(PNSqlBuilder sql, Se005_01ResultDataEntity inEntity) {
        sql.append(" ORDER BY ");
        sql.append(" SaikenIchiran2.Code_ShokanHonShiten ASC, ");
        sql.append(" SaikenIchiran2.Code_Organization ASC, ");
        sql.append(" SaikenIchiran2.Code_Tenpo ASC, ");
        sql.append(" SaikenIchiran2.Name_Customer_KANA ASC ");
    }
}