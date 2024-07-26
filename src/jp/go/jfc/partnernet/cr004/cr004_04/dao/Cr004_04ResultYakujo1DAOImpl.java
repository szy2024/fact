//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr004_04ResultYakujo1DAOImpl
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
import jp.go.jfc.partnernet.cr004.common.Cr004Constants;

/**
 * <pre>
 * このクラスはCr004_04ResultYakujo1DAOの実装クラスです。
 * </pre>
 *
 * @author 佐藤　晃
 * @version 1.0.0
 */
public class Cr004_04ResultYakujo1DAOImpl extends
		PNBaseDAO<Cr004_04ResultYakujo1Entity> implements
		Cr004_04ResultYakujo1DAO {

	/**
	 * 検索結果件数を取得します。
	 *
	 * @param inEntity
	 *            Cr004_04ResultYakujo1Entity
	 * @return 該当件数
	 * @see jp.go.jfc.partnernet.cr004.cr004_04.dao.Cr004_04ResultYakujo1DAO#countByCondition(jp.go.jfc.partnernet.cr004.cr004_04.dao.Cr004_04ResultYakujo1Entity)
	 */
	@Override
	public long countByCondition(Cr004_04ResultYakujo1Entity inEntity) {
		PNSqlBuilder sql = new PNSqlBuilder();
		makeSqlSelectCount(sql);
		makeSqlWhere(sql, inEntity);
		return executeCountResult(sql);
	}

	/**
	 * 条件検索をします。（一括検索用）
	 *
	 * @param inEntity
	 *            Cr004_04ResultYakujo1Entity
	 * @return List&lt;Cr004_04ResultYakujo1Entity&gt;
	 * @see jp.go.jfc.partnernet.cr004.cr004_04.dao.Cr004_04ResultYakujo1DAO#findByCondition(jp.go.jfc.partnernet.cr004.cr004_04.dao.Cr004_04ResultYakujo1Entity)
	 */
	@Override
	public List<Cr004_04ResultYakujo1Entity> findByCondition(
			Cr004_04ResultYakujo1Entity inEntity) {
		PNSqlBuilder sql = new PNSqlBuilder();
		makeSqlSelect(sql);
		makeSqlWhere(sql, inEntity);
		makeSqlOrderby(sql, inEntity);
		return executeListResult(sql, Cr004_04ResultYakujo1Entity.class);
	}

	/**
	 * 条件検索をします。（逐次検索用）
	 *
	 * @param inEntity
	 *            Cr004_04ResultYakujo1Entity
	 * @param offset
	 *            取得開始位置
	 * @param length
	 *            取得開始位置からの取得件数
	 * @return List&lt;Cr004_04ResultYakujo1Entity&gt;
	 * @see jp.go.jfc.partnernet.cr004.cr004_04.dao.Cr004_04ResultYakujo1DAO#findByCondition(jp.go.jfc.partnernet.cr004.cr004_04.dao.Cr004_04ResultYakujo1Entity,
	 *      int, int)
	 */
	@Override
	public List<Cr004_04ResultYakujo1Entity> findByCondition(
			Cr004_04ResultYakujo1Entity inEntity, int offset, int length) {
		PNSqlBuilder sql = new PNSqlBuilder();
		makeSqlSelect(sql);
		makeSqlWhere(sql, inEntity);
		makeSqlOrderby(sql, inEntity);
		return executeListResult(sql, Cr004_04ResultYakujo1Entity.class,
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
		sql.append("SELECT ");
		sql.append(" A.Date_Haraikomi ");
		sql.append(" ,A.M_YakujoGankin ");
		sql.append(" ,A.M_YakujoRisoku ");
		sql.append(" ,A.M_SeiKuriRisoku ");

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
	 *            Cr004_04ResultYakujo1Entity
	 */
	private void makeSqlWhere(PNSqlBuilder sql,
			Cr004_04ResultYakujo1Entity inEntity) {

		/*
		 * １．FROM句、WHERE句の設定 　　入力引数の約定検索指定で条件を切り替える。
		 * 　　（１）　入力引数の約定検索条件指定＝０（払込年月日＜約定検索日付） 　　　　債権管理番号＝入力引数の債権管理番号指定　かつ
		 * 　　　　払込年月日＜入力引数の払込年月日指定　かつ 　　　　約定期日区分＝"1"
		 * 　　（２）　入力引数の約定検索条件＝１（払込年月日≧約定検索日付） 　　　　債権管理番号＝入力引数の債権管理番号指定　かつ
		 * 　　　　払込年月日≧入力引数の払込年月日指定　かつ 　　　　約定期日区分＝"1"
		 * 　　（３）　入力引数の約定検索条件＝２（払込年月日＞約定検索日付） 　　　　債権管理番号＝入力引数の債権管理番号指定　かつ
		 * 　　　　払込年月日＞入力引数の払込年月日指定　かつ 　　　　約定期日区分＝"1" ２．その他
		 * 　　入力引数の約定検索でソート順を切り替える。 　　・約定検索条件＝０（払込年月日＜約定検索日付）の場合、"DESC"
		 * 　　・約定検索条件＝１（払込年月日≧約定検索日付）の場合、"ASC" 　　・約定検索条件＝２（払込年月日＞約定検索日付）の場合、"ASC"
		 */

		// ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
		sql.append(" FROM");
		sql.append(" Yakujo A ");
		sql.append(" WHERE");

		if (Cr004Constants.KIND_SEARCHYAKUJO_0.equals(inEntity
				.getCr004_04_ID_Kind_SearchYakujo())) {
			sql.append(" A.ID_Credit = ? ", inEntity.getCr004_04_ID_Credit());
			sql.append(" AND A.Date_Haraikomi < ? ",
					inEntity.getCr004_04_Date_Haraikomi());
			sql.append(" AND A.Kubun_YakujoKijitsu = '1' ");

		} else if (Cr004Constants.KIND_SEARCHYAKUJO_1.equals(inEntity
				.getCr004_04_ID_Kind_SearchYakujo())) {
			sql.append(" A.ID_Credit = ? ", inEntity.getCr004_04_ID_Credit());
			sql.append(" AND A.Date_Haraikomi >= ? ",
					inEntity.getCr004_04_Date_Haraikomi());
			sql.append(" AND A.Kubun_YakujoKijitsu = '1' ");

		} else if (Cr004Constants.KIND_SEARCHYAKUJO_2.equals(inEntity
				.getCr004_04_ID_Kind_SearchYakujo())) {
			sql.append(" A.ID_Credit = ? ", inEntity.getCr004_04_ID_Credit());
			sql.append(" AND A.Date_Haraikomi > ? ",
					inEntity.getCr004_04_Date_Haraikomi());
			sql.append(" AND A.Kubun_YakujoKijitsu = '1' ");

		}
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
	 *            Cr004_04ResultYakujo1Entity
	 */
	private void makeSqlOrderby(PNSqlBuilder sql,
			Cr004_04ResultYakujo1Entity inEntity) {
		// ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
		if (Cr004Constants.KIND_SEARCHYAKUJO_0.equals(inEntity
				.getCr004_04_ID_Kind_SearchYakujo())) {
			sql.append(" ORDER BY ");
			sql.append(" A.Date_Haraikomi DESC");

		} else if (Cr004Constants.KIND_SEARCHYAKUJO_1.equals(inEntity
				.getCr004_04_ID_Kind_SearchYakujo())) {
			sql.append(" ORDER BY ");
			sql.append(" A.Date_Haraikomi ASC");

		} else if (Cr004Constants.KIND_SEARCHYAKUJO_2.equals(inEntity
				.getCr004_04_ID_Kind_SearchYakujo())) {
			sql.append(" ORDER BY ");
			sql.append(" A.Date_Haraikomi ASC");

		}
		// ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
	}
}