//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr004_03ResultDataDAO
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/18 | 佐藤　晃              | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr004.cr004_03.dao;

import java.util.List;

/**
 * <pre>
 * Cr004_03ResultDataDAOインタフェースです。
 * </pre>
 *
 * @author 佐藤　晃
 * @version 1.0.0
 */
public interface Cr004_03ResultDataDAO {

	/**
	 *
	 * <pre>
	 * 検索結果件数を取得します。
	 * </pre>
	 *
	 * @param inEntity
	 *            Cr004_03ResultDataEntity
	 * @return long
	 */
	long countByCondition(Cr004_03ResultDataEntity inEntity);

	/**
	 *
	 * <pre>
	 * 条件検索をします。（一括検索用）
	 * </pre>
	 *
	 * @param inEntity
	 *            Cr004_03ResultDataEntity
	 * @return List&lt;Cr004_03ResultDataEntity&gt;
	 */
	List<Cr004_03ResultDataEntity> findByCondition(
			Cr004_03ResultDataEntity inEntity);

	/**
	 *
	 * <pre>
	 * 条件検索をします。（逐次検索用）
	 * </pre>
	 *
	 * @param inEntity
	 *            Cr004_03ResultDataEntity
	 * @param offset
	 *            取得開始位置
	 * @param length
	 *            取得開始位置からの取得件数
	 * @return List&lt;Cr004_03ResultDataEntity&gt;
	 */
	List<Cr004_03ResultDataEntity> findByCondition(
			Cr004_03ResultDataEntity inEntity, int offset, int length);

}