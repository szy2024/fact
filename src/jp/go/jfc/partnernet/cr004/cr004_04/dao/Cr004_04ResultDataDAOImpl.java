//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr004_04ResultDataDAOImpl
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
 * このクラスはCr004_04ResultDataDAOの実装クラスです。
 * </pre>
 *
 * @author 佐藤　晃
 * @version 1.0.0
 */
public class Cr004_04ResultDataDAOImpl extends
		PNBaseDAO<Cr004_04ResultDataEntity> implements Cr004_04ResultDataDAO {

	/**
	 * 検索結果件数を取得します。
	 *
	 * @param inEntity
	 *            Cr004_04ResultDataEntity
	 * @return 該当件数
	 * @see jp.go.jfc.partnernet.cr004.cr004_04.dao.Cr004_04ResultDataDAO#countByCondition(jp.go.jfc.partnernet.cr004.cr004_04.dao.Cr004_04ResultDataEntity)
	 */
	@Override
	public long countByCondition(Cr004_04ResultDataEntity inEntity) {
		PNSqlBuilder sql = new PNSqlBuilder();
		makeSqlSelectCount(sql);
		makeSqlWhere(sql, inEntity);
		return executeCountResult(sql);
	}

	/**
	 * 条件検索をします。（一括検索用）
	 *
	 * @param inEntity
	 *            Cr004_04ResultDataEntity
	 * @return List&lt;Cr004_04ResultDataEntity&gt;
	 * @see jp.go.jfc.partnernet.cr004.cr004_04.dao.Cr004_04ResultDataDAO#findByCondition(jp.go.jfc.partnernet.cr004.cr004_04.dao.Cr004_04ResultDataEntity)
	 */
	@Override
	public List<Cr004_04ResultDataEntity> findByCondition(
			Cr004_04ResultDataEntity inEntity) {
		PNSqlBuilder sql = new PNSqlBuilder();
		makeSqlSelect(sql);
		makeSqlWhere(sql, inEntity);
		makeSqlOrderby(sql, inEntity);
		return executeListResult(sql, Cr004_04ResultDataEntity.class);
	}

	/**
	 * 条件検索をします。（逐次検索用）
	 *
	 * @param inEntity
	 *            Cr004_04ResultDataEntity
	 * @param offset
	 *            取得開始位置
	 * @param length
	 *            取得開始位置からの取得件数
	 * @return List&lt;Cr004_04ResultDataEntity&gt;
	 * @see jp.go.jfc.partnernet.cr004.cr004_04.dao.Cr004_04ResultDataDAO#findByCondition(jp.go.jfc.partnernet.cr004.cr004_04.dao.Cr004_04ResultDataEntity,
	 *      int, int)
	 */
	@Override
	public List<Cr004_04ResultDataEntity> findByCondition(
			Cr004_04ResultDataEntity inEntity, int offset, int length) {
		PNSqlBuilder sql = new PNSqlBuilder();
		makeSqlSelect(sql);
		makeSqlWhere(sql, inEntity);
		makeSqlOrderby(sql, inEntity);
		return executeListResult(sql, Cr004_04ResultDataEntity.class, offset,
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
		sql.append(" A.Name_Customer ");
		sql.append(" ,A.Name_Organization ");
		sql.append(" ,A.Code_ShokanHonShiten ");
		sql.append(" ,A.Code_Organization ");
		sql.append(" ,A.Code_Tenpo ");
		sql.append(" ,A.Year ");
		sql.append(" ,A.Code_HoshikiShikin ");
		sql.append(" ,A.ID_Ringi ");
		sql.append(" ,A.ID_RingiBranch ");
		sql.append(" ,A.Date_FirstHaraikomiAfterKuriS ");
		sql.append(" ,A.Date_Nyukin ");
		sql.append(" ,A.Code_Kurishojiyu ");
		sql.append(" ,A.M_KurishoRisoku ");
		sql.append(" ,A.M_KurishoGankin ");
		sql.append(" ,A.M_KariukeIppanJuto ");
		sql.append(" ,A.M_KojoRisoku ");
		sql.append(" ,A.M_Sokin ");
		sql.append(" ,A.M_ZanGankinAfterKurisho ");
		sql.append(" ,A.M_KurishoCommission ");
		sql.append(" ,A.Date_Haraikomi1 ");
		sql.append(" ,A.M_HaraikomiGankin1 ");
		sql.append(" ,A.Date_Haraikomi2 ");
		sql.append(" ,A.M_HaraikomiGankin2 ");
		sql.append(" ,A.Date_Haraikomi3 ");
		sql.append(" ,A.M_HaraikomiGankin3 ");
		sql.append(" ,A.Date_Haraikomi4 ");
		sql.append(" ,A.M_HaraikomiGankin4 ");
		sql.append(" ,A.M_GankinKintoAfterKurisho ");
		sql.append(" ,A.M_GankinFukintoAfterKurisho ");
		sql.append(" ,A.Code_chosei ");
		sql.append(" ,A.Date_JtkShori ");
		sql.append(" ,A.Date_Sokin ");
		sql.append(" ,A.ID_Sokinbi ");
		sql.append(" ,A.ID_After_Daiibensai_Red ");
		sql.append(" ,A.ID_History ");
		sql.append(" ,A.ID_Report ");
		sql.append(" ,A.Date_Report ");
		sql.append(" ,A.Time_Report ");
		sql.append(" ,A.Status ");
		sql.append(" ,A.ID_Master ");
		sql.append(" ,A.DataCode ");
		sql.append(" ,A.Type_Process ");
		sql.append(" ,A.Flag_Torikeshizumi ");
		sql.append(" ,A.UserID ");
		sql.append(" ,A.ID_Denso ");
		sql.append(" ,A.ID_Credit ");
		sql.append(" ,A.Code_Customer ");
		sql.append(" ,A.Data_LastUpDate ");
		sql.append(" ,A.Code_Jusho ");
		sql.append(" ,A.Kubun_KurishoTesuryo ");
		sql.append(" ,A.Code_ShokanHouhou ");
		sql.append(" ,A.M_Fukin ");
		sql.append(" ,A.M_GankinFukinto ");
		sql.append(" ,A.Kubun_GankinFukintogaku ");
		sql.append(" ,A.M_KashitsukeZandaka ");
		sql.append(" ,A.Date_SueokiKigen ");
		sql.append(" ,A.Date_ShokanKigen ");
		sql.append(" ,A.Tokuri ");
		sql.append(" ,A.Riritsu ");
		sql.append(" ,A.Date_TokuriYuko ");
		sql.append(" ,A.Date_Jikko ");
		sql.append(" ,A.Date_GanrikinHaraiKomi ");
		sql.append(" ,A.M_KashitsukeUkeire ");
		sql.append(" ,A.ID_KeisuKanriShori ");
		sql.append(" ,A.Date_KessanSeiri ");
		sql.append(" ,A.M_YakujoGankin_Seikyu ");
		sql.append(" ,A.M_YakujoRisoku_Seikyu ");
		sql.append(" ,A.M_YakujoGankin_Yakujo ");
		sql.append(" ,A.M_YakujoRisoku_Yakujo ");
		sql.append(" ,A.M_SeiKuriGankin_Seikyu ");
		sql.append(" ,A.M_SeiKuriRisoku_Seikyu ");
		sql.append(" ,A.M_NinKuriRisoku_Yakujo ");
		sql.append(" ,A.M_NinKuriGankinKei_Nyukin ");
		sql.append(" ,A.M_NinKuriRisokuKei_Nyukin ");
		sql.append(" ,A.Kubun_JohenKianchu ");
		sql.append(" ,A.Date_SaishinHenko ");
		sql.append(" ,A.Kubun_JutoJunjoHenko ");
		sql.append(" ,A.Kubun_Tokuri ");
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
	 *            Cr004_04ResultDataEntity
	 */
	private void makeSqlWhere(PNSqlBuilder sql,
			Cr004_04ResultDataEntity inEntity) {

		/*
		 * １．FROM句、WHERE句の設定 　　（１）入力引数の債権管理番号指定の値がＮＵＬＬでない場合
		 * 　　　　債権管理番号＝入力引数の債権管理番号指定
		 * 
		 * 　　（２）入力引数の債権管理番号の値がＮＵＬＬの場合 　　　　公庫支店コード＝入力引数の公庫支店コード指定　かつ
		 * 　　　　扱店コード＝入力引数の扱店コード指定　かつ 　　　　店舗コード＝入力引数の店舗コード指定　かつ
		 * 　　　　年度＝入力引数の年度指定　かつ 　　　　方式資金＝入力引数の方式資金指定　かつ 　　　　稟議番号＝番号指定　かつ
		 * 　　　　稟議番号枝番＝枝番指定
		 */

		// ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
		sql.append(" FROM ");
		// sql.append(" DaibensaiReportView A ");
		sql.append(" KURISHO_VIEW A ");
		if (null != inEntity.getCr004_04_ID_Credit()) {

			sql.whereEqual(" A.ID_Credit ", inEntity.getCr004_04_ID_Credit());

		} else {

			sql.whereEqual(" A.Code_ShokanHonShiten ",
					inEntity.getCr004_04_Code_ShokanHonShiten());
			sql.whereEqual(" A.Code_Organization ",
					inEntity.getCr004_04_Code_Organization());
			sql.whereEqual(" A.Code_Tenpo ", inEntity.getCr004_04_Code_Tenpo());
			sql.whereEqual(" A.Year ", inEntity.getCr004_04_Year());
			sql.whereEqual(" A.Code_HoshikiShikin ",
					inEntity.getCr004_04_Code_HoshikiShikin());
			sql.whereEqual(" A.ID_Ringi ", inEntity.getCr004_04_ID_Ringi());
			sql.whereEqual(" A.ID_RingiBranch ",
					inEntity.getCr004_04_ID_RingiBranch());
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
	 *            Cr004_04ResultDataEntity
	 */
	private void makeSqlOrderby(PNSqlBuilder sql,
			Cr004_04ResultDataEntity inEntity) {
		// ============ ↓↓↓↓個別実装部分↓↓↓↓ ============
		// ============ ↑↑↑↑個別実装部分↑↑↑↑ ============
	}
}