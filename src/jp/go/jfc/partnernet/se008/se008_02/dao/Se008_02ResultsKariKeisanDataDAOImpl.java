//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se008_02ResultsKariKeisanDataDAOImpl
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/10 | 田旗　秀樹            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se008.se008_02.dao;

import java.util.List;

import jp.go.jfc.partnernet.pnfw.dao.PNBaseDAO;
import jp.go.jfc.partnernet.pnfw.dbaccess.PNSqlBuilder;

/**
 * <pre>
 * このクラスはSe008_02ResultsKariKeisanDataDAOの実装クラスです。
 * </pre>
 *
 * @author 田旗　秀樹
 * @version 1.0.0
 */
public class Se008_02ResultsKariKeisanDataDAOImpl extends
		PNBaseDAO<Se008_02ResultsKariKeisanDataEntity> implements
		Se008_02ResultsKariKeisanDataDAO {

	/**
	 * 検索結果件数を取得します。
	 *
	 * @param inEntity
	 *            Se008_02ResultsKariKeisanDataEntity
	 * @return 該当件数
	 * @see jp.go.jfc.partnernet.se008.se008_02.dao.Se008_02ResultsKariKeisanDataDAO#countByCondition(jp.go.jfc.partnernet.se008.se008_02.dao.Se008_02ResultsKariKeisanDataEntity)
	 */
	@Override
	public long countByCondition(Se008_02ResultsKariKeisanDataEntity inEntity) {
		PNSqlBuilder sql = new PNSqlBuilder();
		makeSqlSelectCount(sql);
		makeSqlWhere(sql, inEntity);
		return executeCountResult(sql);
	}

	/**
	 * 条件検索をします。（一括検索用）
	 *
	 * @param inEntity
	 *            Se008_02ResultsKariKeisanDataEntity
	 * @return List&lt;Se008_02ResultsKariKeisanDataEntity&gt;
	 * @see jp.go.jfc.partnernet.se008.se008_02.dao.Se008_02ResultsKariKeisanDataDAO#findByCondition(jp.go.jfc.partnernet.se008.se008_02.dao.Se008_02ResultsKariKeisanDataEntity)
	 */
	@Override
	public List<Se008_02ResultsKariKeisanDataEntity> findByCondition(
			Se008_02ResultsKariKeisanDataEntity inEntity) {
		PNSqlBuilder sql = new PNSqlBuilder();
		makeSqlSelect(sql);
		makeSqlWhere(sql, inEntity);
		makeSqlOrderby(sql, inEntity);
		return executeListResult(sql, Se008_02ResultsKariKeisanDataEntity.class);
	}

	/**
	 * 条件検索をします。（逐次検索用）
	 *
	 * @param inEntity
	 *            Se008_02ResultsKariKeisanDataEntity
	 * @param offset
	 *            取得開始位置
	 * @param length
	 *            取得開始位置からの取得件数
	 * @return List&lt;Se008_02ResultsKariKeisanDataEntity&gt;
	 * @see jp.go.jfc.partnernet.se008.se008_02.dao.Se008_02ResultsKariKeisanDataDAO#findByCondition(jp.go.jfc.partnernet.se008.se008_02.dao.Se008_02ResultsKariKeisanDataEntity,
	 *      int, int)
	 */
	@Override
	public List<Se008_02ResultsKariKeisanDataEntity> findByCondition(
			Se008_02ResultsKariKeisanDataEntity inEntity, int offset, int length) {
		PNSqlBuilder sql = new PNSqlBuilder();
		makeSqlSelect(sql);
		makeSqlWhere(sql, inEntity);
		makeSqlOrderby(sql, inEntity);
		return executeListResult(sql,
				Se008_02ResultsKariKeisanDataEntity.class, offset, length);
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
		// sql.append(" COUNT(1) ");
		sql.append(" COUNT(*) AS COUNT");
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
	private void makeSqlSelect(PNSqlBuilder sql) {
		sql.append("SELECT ");
		sql.append(" COUNT(*) AS COUNT");
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
	 *            Se008_02ResultsKariKeisanDataEntity
	 */
	private void makeSqlWhere(PNSqlBuilder sql,
			Se008_02ResultsKariKeisanDataEntity inEntity) {

		/*
		 * １．WHERE句の設定 　　　債権管理番号　＝　Se008_02ResultsDataDAOで取得した債権管理番号
		 * 　　　ステータスが'2'以外 　　　取消済フラグ　＝　'0'
		 */

		sql.append(" FROM ");
		sql.append(" ReportHistory ");
		sql.append(" WHERE ");
		sql.append(" (ReportHistory.ID_Credit = ? ", inEntity.getID_Credit());
		sql.append(" ) AND (NOT (ReportHistory.Status =  2 )) ");
		sql.append(" AND (ReportHistory.Flag_Torikeshizumi = 0 )");
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
	 *            Se008_02ResultsKariKeisanDataEntity
	 */
	private void makeSqlOrderby(PNSqlBuilder sql,
			Se008_02ResultsKariKeisanDataEntity inEntity) {

	}
}