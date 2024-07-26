//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md004_02PreviousYakujoData3DAOImpl
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/10/02 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.md004.md004_02.dao;

import java.util.List;

import jp.go.jfc.partnernet.pnfw.dao.PNBaseDAO;
import jp.go.jfc.partnernet.pnfw.dbaccess.PNSqlBuilder;

/**
 * <pre>
 * このクラスはMd004_02PreviousYakujoData3DAOの実装クラスです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public class Md004_02PreviousYakujoData3DAOImpl extends PNBaseDAO<Md004_02PreviousYakujoData3Entity>
		implements Md004_02PreviousYakujoData3DAO {

	/**
	 * 検索結果件数を取得します。
	 * @param inEntity Md004_02PreviousYakujoData3Entity
	 * @return 該当件数
	 * @see jp.go.jfc.partnernet.md004.md004_02.dao.Md004_02PreviousYakujoData3DAO#countByCondition(jp.go.jfc.partnernet.md004.md004_02.dao.Md004_02PreviousYakujoData3Entity)
	 */
	@Override
	public long countByCondition(Md004_02PreviousYakujoData3Entity inEntity) {
		PNSqlBuilder sql = new PNSqlBuilder();
		makeSqlSelectCount(sql);
		makeSqlWhere(sql, inEntity);
		return executeCountResult(sql);
	}

	/**
	 * 条件検索をします。（一括検索用）
	 * @param inEntity Md004_02PreviousYakujoData3Entity
	 * @return List&lt;Md004_02PreviousYakujoData3Entity&gt;
	 * @see jp.go.jfc.partnernet.md004.md004_02.dao.Md004_02PreviousYakujoData3DAO#findByCondition(jp.go.jfc.partnernet.md004.md004_02.dao.Md004_02PreviousYakujoData3Entity)
	 */
	@Override
	public List<Md004_02PreviousYakujoData3Entity> findByCondition(Md004_02PreviousYakujoData3Entity inEntity) {
		PNSqlBuilder sql = new PNSqlBuilder();
		makeSqlSelect(sql);
		makeSqlWhere(sql, inEntity);
		makeSqlOrderby(sql, inEntity);
		return executeListResult(sql, Md004_02PreviousYakujoData3Entity.class);
	}

	/**
	 * 条件検索をします。（逐次検索用）
	 * @param inEntity Md004_02PreviousYakujoData3Entity
	 * @param offset 取得開始位置
	 * @param length 取得開始位置からの取得件数
	 * @return List&lt;Md004_02PreviousYakujoData3Entity&gt;
	 * @see jp.go.jfc.partnernet.md004.md004_02.dao.Md004_02PreviousYakujoData3DAO#findByCondition(jp.go.jfc.partnernet.md004.md004_02.dao.Md004_02PreviousYakujoData3Entity,
	 *      int, int)
	 */
	@Override
	public List<Md004_02PreviousYakujoData3Entity> findByCondition(
			Md004_02PreviousYakujoData3Entity inEntity, int offset, int length) {
		PNSqlBuilder sql = new PNSqlBuilder();
		makeSqlSelect(sql);
		makeSqlWhere(sql, inEntity);
		makeSqlOrderby(sql, inEntity);
		return executeListResult(sql, Md004_02PreviousYakujoData3Entity.class, offset, length);
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
		sql.append(" Date_Haraikomi");
		sql.append(", M_YakujoGankin AS ID_M_YakujoGankin");
		sql.append(", M_YakujoRisoku AS ID_M_YakujoRisoku");
		sql.append(", M_SeiKuriRisoku AS ID_M_SeiKuriRisoku ");
	}

	/**
	 *
	 * <pre>
	 * sqlの検索条件部分を作成します。
	 * </pre>
	 *
	 * @param sql PNSqlBuilder
	 * @param inEntity Md004_02PreviousYakujoData3Entity
	 */
	private void makeSqlWhere(PNSqlBuilder sql, Md004_02PreviousYakujoData3Entity inEntity) {

		/*
		 * １．WHERE句の設定 　　債権管理番号　＝　指定された債権管理番号 　　払込年月日　＜　指定された払込年月日 　　約定期日区分　＝　’１’
		 *
		 * ２．その他 　　1件のみ取得する。
		 */
		sql.append("FROM Yakujo ");
		/*
		 * １．WHERE句の設定 　　債権管理番号 = 指定した債権管理番号 　　払込年月日 >= 一時変数の入金日２ 　　約定期日区分＝’１’ 　 ２．その他 　　１件のみ検索する。
		 */
		sql.whereEqual("ID_Credit", inEntity.getID_Credit().toString());
		sql.append(" AND Date_Haraikomi < ? ", inEntity.getDate_Haraikomi());
		sql.whereEqual("Kubun_Yakujokijitsu", "1");

	}

	/**
	 *
	 * <pre>
	 * sqlのorder by句部分を作成します。
	 * </pre>
	 *
	 * @param sql PNSqlBuilder
	 * @param inEntity Md004_02PreviousYakujoData3Entity
	 */
	private void makeSqlOrderby(PNSqlBuilder sql, Md004_02PreviousYakujoData3Entity inEntity) {
		sql.append(" ORDER BY Date_Haraikomi DESC");
	}
}