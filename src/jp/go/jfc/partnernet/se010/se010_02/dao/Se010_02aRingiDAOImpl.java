//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se010_02aRingiDAOImpl
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
 * このクラスはSe010_02aRingiDAOの実装クラスです。
 * </pre>
 *
 * @author 堀　大輔
 * @version 1.0.0
 */
public class Se010_02aRingiDAOImpl extends PNBaseDAO<Se010_02aRingiEntity> implements Se010_02aRingiDAO {

	/**
	 * 検索結果件数を取得します。
	 *
	 * @param inEntity Se010_02aRingiEntity
	 * @return 該当件数
	 * @see jp.go.jfc.partnernet.se010.se010_02.dao.Se010_02aRingiDAO#countByCondition(jp.go.jfc.partnernet.se010.se010_02.dao.Se010_02aRingiEntity)
	 */
	@Override
	public long countByCondition(Se010_02aRingiEntity inEntity) {
		PNSqlBuilder sql = new PNSqlBuilder();
		makeSqlSelectCount(sql);
		makeSqlWhere(sql, inEntity);
		return executeCountResult(sql);
	}

	/**
	 * 条件検索をします。（一括検索用）
	 *
	 * @param inEntity Se010_02aRingiEntity
	 * @return List&lt;Se010_02aRingiEntity&gt;
	 * @see jp.go.jfc.partnernet.se010.se010_02.dao.Se010_02aRingiDAO#findByCondition(jp.go.jfc.partnernet.se010.se010_02.dao.Se010_02aRingiEntity)
	 */
	@Override
	public List<Se010_02aRingiEntity> findByCondition(Se010_02aRingiEntity inEntity) {
		PNSqlBuilder sql = new PNSqlBuilder();
		makeSqlSelect(sql);
		makeSqlWhere(sql, inEntity);
		makeSqlOrderby(sql, inEntity);
		return executeListResult(sql, Se010_02aRingiEntity.class);
	}

	/**
	 * 条件検索をします。（逐次検索用）
	 *
	 * @param inEntity Se010_02aRingiEntity
	 * @param offset 取得開始位置
	 * @param length 取得開始位置からの取得件数
	 * @return List&lt;Se010_02aRingiEntity&gt;
	 * @see jp.go.jfc.partnernet.se010.se010_02.dao.Se010_02aRingiDAO#findByCondition(jp.go.jfc.partnernet.se010.se010_02.dao.Se010_02aRingiEntity,
	 *      int, int)
	 */
	@Override
	public List<Se010_02aRingiEntity> findByCondition(Se010_02aRingiEntity inEntity, int offset, int length) {
		PNSqlBuilder sql = new PNSqlBuilder();
		makeSqlSelect(sql);
		makeSqlWhere(sql, inEntity);
		makeSqlOrderby(sql, inEntity);
		return executeListResult(sql, Se010_02aRingiEntity.class, offset, length);
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
		sql.append(" ID_Credit, ");
		sql.append(" Code_ShokanHonShiten, ");
		sql.append(" Code_Organization, ");
		sql.append(" Code_Tenpo, ");
		sql.append(" Year, ");
		sql.append(" Kubun_Hoshiki, ");
		sql.append(" Kubun_Shikin, ");
		sql.append(" ID_Ringi, ");
		sql.append(" ID_RingiBranch, ");
		sql.append(" Date_Jikko, ");
		sql.append(" Riritsu, ");
		sql.append(" Tokuri, ");
		sql.append(" Date_TokuriYuko, ");
		sql.append(" Code_ShokanHouhou, ");
		sql.append(" Kubun_KurishoTesuryo, ");
		sql.append(" Kubun_KinriSeidoSentaku, ");
		sql.append(" Date_ShokanKigen, ");
		sql.append(" Date_SueokiKigen ");
	}

	/**
	 *
	 * <pre>
	 * sqlの検索条件部分を作成します。
	 * </pre>
	 *
	 * @param sql PNSqlBuilder
	 * @param inEntity Se010_02aRingiEntity
	 */
	private void makeSqlWhere(PNSqlBuilder sql, Se010_02aRingiEntity inEntity) {

		/*
		 * １．FROM句、WHERE句の設定 　所管本支店コード = 入力された所管本支店コード 　店舗コード = 入力された店舗コード 　年度 = 入力された年度を西暦変換したもの 　方式区分 =
		 * 入力された方式資金の1桁目 　資金区分 = 入力された方式資金の2桁目 　稟議番号 = 入力された番号（稟議番号） 　稟議番号枝番 = 入力された枝番（稟議番号枝番） 貸付実行日 <> '0'
		 * 貸付実行日 IS NOT NULL 貸付実行日 <> '' 条変起案中区分 = 0 (取引停止案件コード IS NULL または　取引停止案件コード = '')
		 */
		sql.append("FROM ");
		sql.append(" aRingi ");
		sql.append("WHERE ");
		sql.append(" Code_ShokanHonShiten = ? ", inEntity.getCode_ShokanHonShiten());
		sql.append("AND ");
		sql.append(" Code_Organization = ? ", inEntity.getCode_Organization());
		sql.append("AND ");
		sql.append(" Code_Tenpo = ? ", inEntity.getCode_Tenpo());
		sql.append("AND ");
		sql.append(" Year = ? ", inEntity.getYear());
		sql.append("AND ");
		sql.append(" Kubun_Hoshiki = ? ", inEntity.getKubun_Hoshiki());
		sql.append("AND ");
		sql.append(" Kubun_Shikin = ? ", inEntity.getKubun_Shikin());
		sql.append("AND ");
		sql.append(" ID_Ringi = ? ", inEntity.getID_Ringi());
		sql.append("AND ");
		sql.append(" ID_RingiBranch = ? ", inEntity.getID_RingiBranch());

		// 貸付実行日 <> '0' かつ
		// 貸付実行日 IS NOT NULL かつ
		// 変起案中区分 = 0 かつ
		// (取引停止案件コード IS NULL または 取引停止案件コード = '')
		sql.append("AND ");
		sql.append(" Date_Jikko <> '0' ");
		sql.append("AND ");
		sql.append(" Date_Jikko IS NOT NULL ");
		sql.append("AND ");
		sql.append(" Kubun_JohenKianchu = '0' ");
		sql.append("AND ");
		sql.append(" (Code_TorihikiTeishi IS NULL OR  Code_TorihikiTeishi = '') ");
	}

	/**
	 *
	 * <pre>
	 * sqlのorder by句部分を作成します。
	 * </pre>
	 *
	 * @param sql PNSqlBuilder
	 * @param inEntity Se010_02aRingiEntity
	 */
	private void makeSqlOrderby(PNSqlBuilder sql, Se010_02aRingiEntity inEntity) {
		// ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
		// ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
	}
}