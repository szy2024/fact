//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md002_01CandidateDataDAOImpl
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/17 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.md002.md002_01.dao;

import java.util.List;

import jp.go.jfc.partnernet.pnfw.dao.PNBaseDAO;
import jp.go.jfc.partnernet.pnfw.dbaccess.PNSqlBuilder;

/**
 * <pre>
 * このクラスはMd002_01CandidateDataDAOの実装クラスです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public class Md002_01CandidateDataDAOImpl extends PNBaseDAO<Md002_01CandidateDataEntity> implements
        Md002_01CandidateDataDAO {

    /**
     * 検索結果件数を取得します。
     * @param inEntity Md002_01CandidateDataEntity
     * @return 該当件数
     * @see jp.go.jfc.partnernet.md002.md002_01.dao.Md002_01CandidateDataDAO#countByCondition(jp.go.jfc.partnernet.md002.md002_01.dao.Md002_01CandidateDataEntity)
     */
    @Override
    public long countByCondition(Md002_01CandidateDataEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelectCount(sql);
        makeSqlWhere(sql, inEntity);
        return executeCountResult(sql);
    }

    /**
     * 条件検索をします。（一括検索用）
     * @param inEntity Md002_01CandidateDataEntity
     * @return List&lt;Md002_01CandidateDataEntity&gt;
     * @see jp.go.jfc.partnernet.md002.md002_01.dao.Md002_01CandidateDataDAO#findByCondition(jp.go.jfc.partnernet.md002.md002_01.dao.Md002_01CandidateDataEntity)
     */
    @Override
    public List<Md002_01CandidateDataEntity> findByCondition(Md002_01CandidateDataEntity inEntity) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Md002_01CandidateDataEntity.class);
    }

    /**
     * 条件検索をします。（逐次検索用）
     * @param inEntity Md002_01CandidateDataEntity
     * @param offset 取得開始位置
     * @param length 取得開始位置からの取得件数
     * @return List&lt;Md002_01CandidateDataEntity&gt;
     * @see jp.go.jfc.partnernet.md002.md002_01.dao.Md002_01CandidateDataDAO#findByCondition(jp.go.jfc.partnernet.md002.md002_01.dao.Md002_01CandidateDataEntity,
     *      int, int)
     */
    @Override
    public List<Md002_01CandidateDataEntity> findByCondition(Md002_01CandidateDataEntity inEntity,
            int offset, int length) {
        PNSqlBuilder sql = new PNSqlBuilder();
        makeSqlSelect(sql);
        makeSqlWhere(sql, inEntity);
        makeSqlOrderby(sql, inEntity);
        return executeListResult(sql, Md002_01CandidateDataEntity.class, offset, length);
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
    }

    /**
     *
     * <pre>
     * sqlの検索条件部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Md002_01CandidateDataEntity
     */
    private void makeSqlWhere(PNSqlBuilder sql, Md002_01CandidateDataEntity inEntity) {
    }

    /**
     *
     * <pre>
     * sqlのorder by句部分を作成します。
     * </pre>
     *
     * @param sql PNSqlBuilder
     * @param inEntity Md002_01CandidateDataEntity
     */
    private void makeSqlOrderby(PNSqlBuilder sql, Md002_01CandidateDataEntity inEntity) {
    }
}