//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr001_02AringiDAOImpl
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/11 | 田旗　秀樹            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr001.cr001_02.dao;

import java.util.List;

import jp.go.jfc.partnernet.pnfw.dao.PNBaseDAO;
import jp.go.jfc.partnernet.pnfw.dbaccess.PNSqlBuilder;

/**
 * <pre>
 * このクラスはCr001_02AringiDAOの実装クラスです。
 * </pre>
 *
 * @author 田旗　秀樹
 * @version 1.0.0
 */
public class Cr001_02AringiDAOImpl extends PNBaseDAO<Cr001_02AringiEntity>
		implements Cr001_02AringiDAO {

	/**
	 * 検索結果件数を取得します。
	 *
	 * @param inEntity
	 *            Cr001_02AringiEntity
	 * @return 該当件数
	 * @see jp.go.jfc.partnernet.cr001.cr001_02.dao.Cr001_02AringiDAO#countByCondition(jp.go.jfc.partnernet.cr001.cr001_02.dao.Cr001_02AringiEntity)
	 */
	@Override
	public long countByCondition(Cr001_02AringiEntity inEntity) {
		PNSqlBuilder sql = new PNSqlBuilder();
		makeSqlSelectCount(sql);
		makeSqlWhere(sql, inEntity);
		return executeCountResult(sql);
	}

	/**
	 * 条件検索をします。（一括検索用）
	 *
	 * @param inEntity
	 *            Cr001_02AringiEntity
	 * @return List&lt;Cr001_02AringiEntity&gt;
	 * @see jp.go.jfc.partnernet.cr001.cr001_02.dao.Cr001_02AringiDAO#findByCondition(jp.go.jfc.partnernet.cr001.cr001_02.dao.Cr001_02AringiEntity)
	 */
	@Override
	public List<Cr001_02AringiEntity> findByCondition(
			Cr001_02AringiEntity inEntity) {
		PNSqlBuilder sql = new PNSqlBuilder();
		makeSqlSelect(sql);
		makeSqlWhere(sql, inEntity);
		makeSqlOrderby(sql, inEntity);
		return executeListResult(sql, Cr001_02AringiEntity.class);
	}

	/**
	 * 条件検索をします。（逐次検索用）
	 *
	 * @param inEntity
	 *            Cr001_02AringiEntity
	 * @param offset
	 *            取得開始位置
	 * @param length
	 *            取得開始位置からの取得件数
	 * @return List&lt;Cr001_02AringiEntity&gt;
	 * @see jp.go.jfc.partnernet.cr001.cr001_02.dao.Cr001_02AringiDAO#findByCondition(jp.go.jfc.partnernet.cr001.cr001_02.dao.Cr001_02AringiEntity,
	 *      int, int)
	 */
	@Override
	public List<Cr001_02AringiEntity> findByCondition(
			Cr001_02AringiEntity inEntity, int offset, int length) {
		PNSqlBuilder sql = new PNSqlBuilder();
		makeSqlSelect(sql);
		makeSqlWhere(sql, inEntity);
		makeSqlOrderby(sql, inEntity);
		return executeListResult(sql, Cr001_02AringiEntity.class, offset,
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
		sql.append("SELECT");
		sql.append(" COUNT(*) AS LineNum ");
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
	 *            Cr001_02AringiEntity
	 */
	private void makeSqlWhere(PNSqlBuilder sql, Cr001_02AringiEntity inEntity) {

		/*
		 * １．WHERE句の設定 　　　①債権管理番号　＝　画面の債権管理番号 　　　②引数の更新日時が空白以外の場合、
		 * 　　　　　最新更新日時　＝　引数の更新日時 　　　　上記以外の場合 　　　　　最新更新日時　IS　NULL
		 */

		sql.append(" FROM ");
		sql.append(" Aringi ");
		sql.append(" WHERE ");
		sql.append(" ID_Credit = ?", inEntity.getID_Credit());
		if (null != inEntity.getData_LastUpDate()
				&& 0 < inEntity.getData_LastUpDate().trim().length()) {
			// 引数の更新日時が空白以外の場合
			sql.append(" AND TO_CHAR(Data_LastUpDate, 'YYYYMMDD') = ?",
					inEntity.getData_LastUpDate());
			// １つ前に更新した時の更新日時　---引数の更新日時が空白以外の場合

		} else {
			// 引数の更新日時が空白の場合
			sql.append(" AND Data_LastUpDate IS NULL ");
		}
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
	 *            Cr001_02AringiEntity
	 */
	private void makeSqlOrderby(PNSqlBuilder sql, Cr001_02AringiEntity inEntity) {
	}
}