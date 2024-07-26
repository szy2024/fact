//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se010_02YakujoHraikomiDAOImpl
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/19 | 堀　大輔            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se010.se010_02.dao;

import java.util.List;

import jp.go.jfc.partnernet.pnfw.dao.PNBaseDAO;
import jp.go.jfc.partnernet.pnfw.dbaccess.PNSqlBuilder;

/**
 * <pre>
 * このクラスはSe010_02YakujoHraikomiDAOの実装クラスです。
 * </pre>
 *
 * @author 堀　大輔
 * @version 1.0.0
 */
public class Se010_02YakujoHaraikomiDAOImpl extends PNBaseDAO<Se010_02YakujoHaraikomiEntity> implements
		Se010_02YakujoHaraikomiDAO {

	/**
	 * 検索結果件数を取得します。
	 *
	 * @param inEntity Se010_02YakujoHaraikomiEntity
	 * @return 該当件数
	 * @see jp.go.jfc.partnernet.se010.se010_02.dao.Se010_02YakujoHaraikomiDAO#countByCondition(jp.go.jfc.partnernet.se010.se010_02.dao.Se010_02YakujoHaraikomiEntity)
	 */
	@Override
	public long countByCondition(Se010_02YakujoHaraikomiEntity inEntity) {
		PNSqlBuilder sql = new PNSqlBuilder();
		makeSqlSelectCount(sql);
		makeSqlWhere(sql, inEntity);
		return executeCountResult(sql);
	}

	/**
	 * 条件検索をします。（一括検索用）
	 *
	 * @param inEntity Se010_02YakujoHaraikomiEntity
	 * @return List&lt;Se010_02YakujoHaraikomiEntity&gt;
	 * @see jp.go.jfc.partnernet.se010.se010_02.dao.Se010_02YakujoHaraikomiDAO#findByCondition(jp.go.jfc.partnernet.se010.se010_02.dao.Se010_02YakujoHaraikomiEntity)
	 */
	@Override
	public List<Se010_02YakujoHaraikomiEntity> findByCondition(Se010_02YakujoHaraikomiEntity inEntity) {
		PNSqlBuilder sql = new PNSqlBuilder();
		makeSqlSelect(sql);
		makeSqlWhere(sql, inEntity);
		makeSqlOrderby(sql, inEntity);
		return executeListResult(sql, Se010_02YakujoHaraikomiEntity.class);
	}

	/**
	 * 条件検索をします。（逐次検索用）
	 *
	 * @param inEntity Se010_02YakujoHaraikomiEntity
	 * @param offset 取得開始位置
	 * @param length 取得開始位置からの取得件数
	 * @return List&lt;Se010_02YakujoHaraikomiEntity&gt;
	 * @see jp.go.jfc.partnernet.se010.se010_02.dao.Se010_02YakujoHaraikomiDAO#findByCondition(jp.go.jfc.partnernet.se010.se010_02.dao.Se010_02YakujoHaraikomiEntity,
	 *      int, int)
	 */
	@Override
	public List<Se010_02YakujoHaraikomiEntity> findByCondition(Se010_02YakujoHaraikomiEntity inEntity,
			int offset, int length) {
		PNSqlBuilder sql = new PNSqlBuilder();
		makeSqlSelect(sql);
		makeSqlWhere(sql, inEntity);
		makeSqlOrderby(sql, inEntity);
		return executeListResult(sql, Se010_02YakujoHaraikomiEntity.class, offset, length);
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
		sql.append(" Date_Haraikomi ");
	}

	/**
	 *
	 * <pre>
	 * sqlの検索条件部分を作成します。
	 * </pre>
	 *
	 * @param sql PNSqlBuilder
	 * @param inEntity Se010_02YakujoHaraikomiEntity
	 */
	private void makeSqlWhere(PNSqlBuilder sql, Se010_02YakujoHaraikomiEntity inEntity) {

		/*
		 * １．FROM句、WHERE句の設定 　債権管理番号 = 稟議データから取得した債権管理番号 　払込年月日 < 入力された繰上償還日 約定期日 = '1'
		 *
		 * ２．その他　補足事項 　　先頭1件のデータのみ取得する。
		 */

		sql.append("FROM ");
		sql.append(" Yakujo ");
		sql.append("WHERE ");
		sql.append(" ID_Credit = ? ", inEntity.getID_Credit());
		sql.append("AND ");
		sql.append(" Date_Haraikomi < ? ", inEntity.getStrDateKuriageShokan());
		sql.append("AND ");
		sql.append(" Kubun_YakujoKijitsu  = '1' ");
	}

	/**
	 *
	 * <pre>
	 * sqlのorder by句部分を作成します。
	 * </pre>
	 *
	 * @param sql PNSqlBuilder
	 * @param inEntity Se010_02YakujoHaraikomiEntity
	 */
	private void makeSqlOrderby(PNSqlBuilder sql, Se010_02YakujoHaraikomiEntity inEntity) {
		sql.append(" ORDER BY ");
		sql.append("Date_Haraikomi DESC");
	}
}