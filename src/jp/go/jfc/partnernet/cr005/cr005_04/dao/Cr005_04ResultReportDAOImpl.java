//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr005_04ResultReportDAOImpl
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/14 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr005.cr005_04.dao;

import java.util.List;

import jp.go.jfc.partnernet.pnfw.dao.PNBaseDAO;
import jp.go.jfc.partnernet.pnfw.dbaccess.PNSqlBuilder;

/**
 * <pre>
 * このクラスはCr005_04ResultReportDAOの実装クラスです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public class Cr005_04ResultReportDAOImpl extends
		PNBaseDAO<Cr005_04ResultReportEntity> implements
		Cr005_04ResultReportDAO {

	/**
	 * 検索結果件数を取得します。
	 *
	 * @param inEntity
	 *            Cr005_04ResultReportEntity
	 * @return 該当件数
	 * @see jp.go.jfc.partnernet.cr005.cr005_04.dao.Cr005_04ResultReportDAO#countByCondition(jp.go.jfc.partnernet.cr005.cr005_04.dao.Cr005_04ResultReportEntity)
	 */
	@Override
	public long countByCondition(Cr005_04ResultReportEntity inEntity) {
		PNSqlBuilder sql = new PNSqlBuilder();
		makeSqlSelectCount(sql);
		makeSqlWhere(sql, inEntity);
		return executeCountResult(sql);
	}

	/**
	 * 条件検索をします。（一括検索用）
	 *
	 * @param inEntity
	 *            Cr005_04ResultReportEntity
	 * @return List&lt;Cr005_04ResultReportEntity&gt;
	 * @see jp.go.jfc.partnernet.cr005.cr005_04.dao.Cr005_04ResultReportDAO#findByCondition(jp.go.jfc.partnernet.cr005.cr005_04.dao.Cr005_04ResultReportEntity)
	 */
	@Override
	public List<Cr005_04ResultReportEntity> findByCondition(
			Cr005_04ResultReportEntity inEntity) {
		PNSqlBuilder sql = new PNSqlBuilder();
		makeSqlSelect(sql);
		makeSqlWhere(sql, inEntity);
		makeSqlOrderby(sql, inEntity);
		return executeListResult(sql, Cr005_04ResultReportEntity.class);
	}

	/**
	 * 条件検索をします。（逐次検索用）
	 *
	 * @param inEntity
	 *            Cr005_04ResultReportEntity
	 * @param offset
	 *            取得開始位置
	 * @param length
	 *            取得開始位置からの取得件数
	 * @return List&lt;Cr005_04ResultReportEntity&gt;
	 * @see jp.go.jfc.partnernet.cr005.cr005_04.dao.Cr005_04ResultReportDAO#findByCondition(jp.go.jfc.partnernet.cr005.cr005_04.dao.Cr005_04ResultReportEntity,
	 *      int, int)
	 */
	@Override
	public List<Cr005_04ResultReportEntity> findByCondition(
			Cr005_04ResultReportEntity inEntity, int offset, int length) {
		PNSqlBuilder sql = new PNSqlBuilder();
		makeSqlSelect(sql);
		makeSqlWhere(sql, inEntity);
		makeSqlOrderby(sql, inEntity);
		return executeListResult(sql, Cr005_04ResultReportEntity.class, offset,
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
		// ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
		sql.append("SELECT");
		sql.append(" ReportHistory.ID_Credit");
		sql.append(" , ReportHistory.Date_Report");
		sql.append(" , ReportHistory.Time_Report");
		sql.append(" , ReportHistory.Status");
		sql.append(" , ReportHistory.DataCode");
		sql.append(" , ReportName.RyakusyouName_Report");
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
	 *            Cr005_04ResultReportEntity
	 */
	private void makeSqlWhere(PNSqlBuilder sql,
			Cr005_04ResultReportEntity inEntity) {

		/*
		 * １．FROM句、WHERE句の設定 　　（１）ＦＲＯＭ句の設定 　　　　　報告書履歴データ　LEFT OUTER JOIN
		 * 　　　　　報告書種別テーブル ON　報告書履歴データ[データコード] = 報告書種別テーブル[データコード]
		 * 
		 * 　　（２）ＷＨＥＲＥ句 　　　　　公庫支店コード＝入力引数の公庫支店コード指定 かつ 　　　　　扱店コード＝入力引数の扱店コード指定 かつ
		 * 　　　　　店舗コード＝入力引数の店舗コード指定 かつ 　　　　　年度＝入力引数の年度指定 かつ 　　　　　方式資金＝入力引数の方式資金指定
		 * かつ 　　　　　稟議番号＝入力引数の番号指定 かつ 　　　　　稟議番号枝番＝入力引数の枝番指定 かつ
		 * 　　　　　取消済フラグ＝入力引数の取消済フラグ指定
		 * 
		 * ２．その他 　　先頭１件のみ取得する
		 */

		// ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
		sql.append(" FROM ReportHistory  LEFT OUTER JOIN ReportName ON ReportHistory.DataCode = ReportName.DataCode ");
		sql.whereEqual("ReportHistory.Code_KoukoShiten",
				inEntity.getCr005_04_Code_KoukoShiten());
		sql.whereEqual("ReportHistory.Code_Organization",
				inEntity.getCr005_04_Code_Organization());
		sql.whereEqual("ReportHistory.Code_Tenpo",
				inEntity.getCr005_04_Code_Tenpo());
		sql.whereEqual("ReportHistory.Year", inEntity.getCr005_04_Year());
		sql.whereEqual("ReportHistory.Code_HoshikiShikin",
				inEntity.getCr005_04_Code_HoshikiShikin());
		sql.whereEqual("ReportHistory.ID_Ringi",
				inEntity.getCr005_04_ID_Ringi());
		sql.whereEqual("ReportHistory.ID_RingiBranch",
				inEntity.getCr005_04_ID_RingiBranch());
		sql.whereEqual("ReportHistory.Flag_Torikeshizumi", inEntity
				.getCr005_04_Flag_Torikeshizumi().toString());

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
	 *            Cr005_04ResultReportEntity
	 */
	private void makeSqlOrderby(PNSqlBuilder sql,
			Cr005_04ResultReportEntity inEntity) {
		// ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
		sql.append(" ORDER BY");
		sql.append(" Date_Report DESC");
		sql.append(" ,Time_Report DESC");
		// ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
	}
}