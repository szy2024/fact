//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md005_02ResultsDataDAOImpl
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/10/05 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.md005.md005_02.dao;

import java.util.List;

import jp.go.jfc.partnernet.pnfw.dao.PNBaseDAO;
import jp.go.jfc.partnernet.pnfw.dbaccess.PNSqlBuilder;

/**
 * <pre>
 * このクラスはMd005_02ResultsDataDAOの実装クラスです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public class Md005_02ResultsDataDAOImpl extends
		PNBaseDAO<Md005_02ResultsDataEntity> implements Md005_02ResultsDataDAO {

	/**
	 * 検索結果件数を取得します。
	 *
	 * @param inEntity
	 *            Md005_02ResultsDataEntity
	 * @return 該当件数
	 * @see jp.go.jfc.partnernet.md005.md005_02.dao.Md005_02ResultsDataDAO#countByCondition(jp.go.jfc.partnernet.md005.md005_02.dao.Md005_02ResultsDataEntity)
	 */
	@Override
	public long countByCondition(Md005_02ResultsDataEntity inEntity) {
		PNSqlBuilder sql = new PNSqlBuilder();
		makeSqlSelectCount(sql);
		makeSqlWhere(sql, inEntity);
		return executeCountResult(sql);
	}

	/**
	 * 条件検索をします。（一括検索用）
	 *
	 * @param inEntity
	 *            Md005_02ResultsDataEntity
	 * @return List&lt;Md005_02ResultsDataEntity&gt;
	 * @see jp.go.jfc.partnernet.md005.md005_02.dao.Md005_02ResultsDataDAO#findByCondition(jp.go.jfc.partnernet.md005.md005_02.dao.Md005_02ResultsDataEntity)
	 */
	@Override
	public List<Md005_02ResultsDataEntity> findByCondition(
			Md005_02ResultsDataEntity inEntity) {
		PNSqlBuilder sql = new PNSqlBuilder();
		makeSqlSelect(sql);
		makeSqlWhere(sql, inEntity);
		makeSqlOrderby(sql, inEntity);
		return executeListResult(sql, Md005_02ResultsDataEntity.class);
	}

	/**
	 * 条件検索をします。（逐次検索用）
	 *
	 * @param inEntity
	 *            Md005_02ResultsDataEntity
	 * @param offset
	 *            取得開始位置
	 * @param length
	 *            取得開始位置からの取得件数
	 * @return List&lt;Md005_02ResultsDataEntity&gt;
	 * @see jp.go.jfc.partnernet.md005.md005_02.dao.Md005_02ResultsDataDAO#findByCondition(jp.go.jfc.partnernet.md005.md005_02.dao.Md005_02ResultsDataEntity,
	 *      int, int)
	 */
	@Override
	public List<Md005_02ResultsDataEntity> findByCondition(
			Md005_02ResultsDataEntity inEntity, int offset, int length) {
		PNSqlBuilder sql = new PNSqlBuilder();
		makeSqlSelect(sql);
		makeSqlWhere(sql, inEntity);
		makeSqlOrderby(sql, inEntity);
		return executeListResult(sql, Md005_02ResultsDataEntity.class, offset,
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
		sql.append(" ID_Report AS ID_ID_Report ");
		sql.append(",Date_Report AS ID_Date_Report ");
		sql.append(",Name_Organization AS ID_Name_Organization ");
		sql.append(",Name_Customer AS ID_Name_Customer ");
		sql.append(",Code_KoukoShiten AS ID_Code_KoukoShiten ");
		sql.append(",Code_Organization AS ID_Code_Organization ");
		sql.append(",Code_Tenpo AS ID_Code_Tenpo ");
		sql.append(",Year AS ID_Year ");
		sql.append(",Code_HoshikiShikin AS ID_Code_HoshikiShikin ");
		sql.append(",ID_Ringi AS ID_ID_Ringi ");
		sql.append(",ID_RingiBranch AS ID_ID_RingiBranch ");
		sql.append(",Date_JutoTaisho AS ID_Date_JutoTaisho ");
		sql.append(",Date_DaibenkinHaraikomi AS ID_Date_DaibenkinHaraikomi ");
		sql.append(",M_ChienSongai AS ID_M_ChienSongai ");
		sql.append(",M_Risoku AS ID_M_Risoku ");
		sql.append(",M_Gankin AS ID_M_Gankin ");
		sql.append(",M_Kei AS ID_M_Kei ");
		sql.append(",M_KariukeIppanJuto AS ID_M_KariukeIppanJuto ");
		sql.append(",M_ZanGanAfterDaibenJuto AS ID_M_ZanGanAfterDaibenJuto ");
		sql.append(",M_KurishoCommission AS ID_M_KurishoCommission ");
		sql.append(",M_Sokin AS ID_M_Sokin ");
		sql.append(",Date_Sokin AS ID_Date_Sokin ");
		sql.append(",ID_Sokinbi AS ID_ID_Sokinbi ");
		sql.append(",Date_Jtkshori AS ID_Date_Jtkshori ");
		sql.append(",M_KashitsukeZandaka AS ID_M_KashitsukeZandaka ");
		sql.append(",Time_Report AS ID_Time_Report ");
		sql.append(",UserID AS ID_User_ID ");
		sql.append(",ID_Denso AS ID_ID_Denso ");
		sql.append(",DataCode AS ID_DataCode ");
		sql.append(",ID_History AS ID_ID_History ");
		sql.append(",Status AS ID_Status ");
		sql.append(",Type_Process AS ID_Type_Process ");
		sql.append(",Flag_Torikeshizumi AS ID_Flag_Torikeshizumi ");
		sql.append(",Code_Error AS ID_Code_Error ");
		sql.append(",ErrorMessage AS ID_ErrorMessage ");
		sql.append(",Keep_M_KashitsukeZan AS ID_Keep_M_KashitsukeZan ");
		sql.append(",Keep_M_YakujoGankin AS ID_Keep_M_YakujoGankin ");
		sql.append(",Keep_M_YakujoRisoku AS ID_Keep_M_YakujoRisoku ");
		sql.append(",Keep_Date_ShokanKigen AS ID_Keep_Date_ShokanKigen ");
		sql.append(",ID_Credit AS ID_ID_Credit ");
		sql.append(",Code_Customer AS ID_Code_Customer ");
		sql.append(",Keep_Seikyu_M_SeiKuriRisoku ");
		sql.append(",Data_LastUpDate ");
		sql.append(",Keep_ID_History AS ID_Keep_ID_History ");
		sql.append(",Keep_Flag_Kj AS ID_Keep_Flag_Kj ");
		sql.append(",aRingi_Date_ShokanKigen AS ID_aRingi_Date_ShokanKigen ");
		sql.append(",Keep_Seikyu_M_SeiKuriGankin ");
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
	 *            Md005_02ResultsDataEntity
	 */
	private void makeSqlWhere(PNSqlBuilder sql,
			Md005_02ResultsDataEntity inEntity) {

		/*
		 * １．WHERE句の設定 　　報告書番号　＝　指定された報告書番号
		 */

		sql.append("FROM ");
		sql.append(" DaibensaiReportModView ");
		sql.append("WHERE ");
		sql.append(" Code_Organization = ?", inEntity.getID_Code_Organization());
		sql.append(" AND ID_Report = ?", inEntity.getID_ID_Report());
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
	 *            Md005_02ResultsDataEntity
	 */
	private void makeSqlOrderby(PNSqlBuilder sql,
			Md005_02ResultsDataEntity inEntity) {
	}
}