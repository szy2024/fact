//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr004_04ResultSeikyu2DAOImpl
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/25 | 佐藤　晃            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr004.cr004_04.dao;

import java.util.List;

import jp.go.jfc.partnernet.pnfw.dao.PNBaseDAO;
import jp.go.jfc.partnernet.pnfw.dbaccess.PNSqlBuilder;

/**
 * <pre>
 * このクラスはCr004_04ResultSeikyu2DAOの実装クラスです。
 * </pre>
 *
 * @author 佐藤　晃
 * @version 1.0.0
 */
public class Cr004_04ResultSeikyu2DAOImpl extends
		PNBaseDAO<Cr004_04ResultSeikyu2Entity> implements
		Cr004_04ResultSeikyu2DAO {

	/**
	 * 検索結果件数を取得します。
	 *
	 * @param inEntity
	 *            Cr004_04ResultSeikyu2Entity
	 * @return 該当件数
	 * @see jp.go.jfc.partnernet.cr004.cr004_04.dao.Cr004_04ResultSeikyu2DAO#countByCondition(jp.go.jfc.partnernet.cr004.cr004_04.dao.Cr004_04ResultSeikyu2Entity)
	 */
	@Override
	public long countByCondition(Cr004_04ResultSeikyu2Entity inEntity) {
		PNSqlBuilder sql = new PNSqlBuilder();
		makeSqlSelectCount(sql);
		makeSqlWhere(sql, inEntity);
		return executeCountResult(sql);
	}

	/**
	 * 条件検索をします。（一括検索用）
	 *
	 * @param inEntity
	 *            Cr004_04ResultSeikyu2Entity
	 * @return List&lt;Cr004_04ResultSeikyu2Entity&gt;
	 * @see jp.go.jfc.partnernet.cr004.cr004_04.dao.Cr004_04ResultSeikyu2DAO#findByCondition(jp.go.jfc.partnernet.cr004.cr004_04.dao.Cr004_04ResultSeikyu2Entity)
	 */
	@Override
	public List<Cr004_04ResultSeikyu2Entity> findByCondition(
			Cr004_04ResultSeikyu2Entity inEntity) {
		PNSqlBuilder sql = new PNSqlBuilder();
		makeSqlSelect(sql);
		makeSqlWhere(sql, inEntity);
		makeSqlOrderby(sql, inEntity);
		return executeListResult(sql, Cr004_04ResultSeikyu2Entity.class);
	}

	/**
	 * 条件検索をします。（逐次検索用）
	 *
	 * @param inEntity
	 *            Cr004_04ResultSeikyu2Entity
	 * @param offset
	 *            取得開始位置
	 * @param length
	 *            取得開始位置からの取得件数
	 * @return List&lt;Cr004_04ResultSeikyu2Entity&gt;
	 * @see jp.go.jfc.partnernet.cr004.cr004_04.dao.Cr004_04ResultSeikyu2DAO#findByCondition(jp.go.jfc.partnernet.cr004.cr004_04.dao.Cr004_04ResultSeikyu2Entity,
	 *      int, int)
	 */
	@Override
	public List<Cr004_04ResultSeikyu2Entity> findByCondition(
			Cr004_04ResultSeikyu2Entity inEntity, int offset, int length) {
		PNSqlBuilder sql = new PNSqlBuilder();
		makeSqlSelect(sql);
		makeSqlWhere(sql, inEntity);
		makeSqlOrderby(sql, inEntity);
		return executeListResult(sql, Cr004_04ResultSeikyu2Entity.class,
				offset, length);
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
		sql.append(" COUNT(1) ");
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
		// ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
		sql.append("SELECT");
		sql.append(" A.Date_Haraikomi ");
		sql.append(" ,A.M_YakujoGankin ");
		sql.append(" ,A.M_YakujoRisoku ");
		sql.append(" ,A.M_SeiKuriGankin ");
		sql.append(" ,A.M_SeiKuriRisoku ");
		sql.append(" ,A.M_NinKuriRisoku ");
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
	 *            Cr004_04ResultSeikyu2Entity
	 */
	private void makeSqlWhere(PNSqlBuilder sql,
			Cr004_04ResultSeikyu2Entity inEntity) {

		/*
		 * １．FROM句、WHERE句の設定 　　　　債権管理番号＝入力引数の債権管理番号指定　かつ 　　　　払込年月日＝入力引数の払込年月日指定
		 * 
		 * ２．その他 　　　　先頭１件のみ取得する
		 */

		// ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
		sql.append(" FROM");
		sql.append(" Seikyu A ");
		sql.append(" WHERE");
		sql.append(" A.ID_Credit = ? ", inEntity.getCr004_04_ID_Credit());
		sql.append(" AND A.Date_Haraikomi =  ? ",
				inEntity.getCr004_04_Date_Haraikomi());
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
	 *            Cr004_04ResultSeikyu2Entity
	 */
	private void makeSqlOrderby(PNSqlBuilder sql,
			Cr004_04ResultSeikyu2Entity inEntity) {
		// ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
		sql.append("ORDER BY ");
		sql.append("  A.Date_Haraikomi ASC ");
		// ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
	}
}