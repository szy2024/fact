//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se004_01Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/16 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se004.se004_01.service;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

import jp.go.jfc.partnernet.common.PNCommonComponents;
import jp.go.jfc.partnernet.common.PNCommonMessageConstants;
import jp.go.jfc.partnernet.pnfw.common.PNCommonInfo;
import jp.go.jfc.partnernet.pnfw.common.PNCommonInfoHolder;
import jp.go.jfc.partnernet.pnfw.common.PNJpCalendarUtils;
import jp.go.jfc.partnernet.pnfw.common.PNMessageInfo;
import jp.go.jfc.partnernet.pnfw.service.PNBaseService;
import jp.go.jfc.partnernet.se004.se004_01.dao.Se004_01KoukoShitenDAO;
import jp.go.jfc.partnernet.se004.se004_01.dao.Se004_01KoukoShitenEntity;
import jp.go.jfc.partnernet.se004.se004_01.dao.Se004_01ResultDataDAO;
import jp.go.jfc.partnernet.se004.se004_01.dao.Se004_01ResultDataEntity;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * <pre>
 * このクラスはSe004_01のサービスクラスです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public class Se004_01ServiceImpl extends PNBaseService implements
		Se004_01Service {

	/** se004_01koukoshitendao */
	@Autowired
	private Se004_01KoukoShitenDAO se004_01koukoshitendao;

	/** se004_01resultdatadao */
	@Autowired
	private Se004_01ResultDataDAO se004_01resultdatadao;

	@Autowired
	PNJpCalendarUtils jpCalendarUtils;

	/**
	 * Se004_01ServiceのgetSyokanHonShitenData
	 *
	 * @param inDto
	 *            Se004_01DTO
	 * @return Se004_01DTO
	 */
	@Override
	public Se004_01DTO getSyokanHonShitenData(Se004_01DTO inDto) {

		Se004_01DTO outDto = new Se004_01DTO();

		// 公庫支店のプルダウンリスト取得
		Se004_01KoukoShitenEntity inEntity = new Se004_01KoukoShitenEntity();
		List<Se004_01KoukoShitenEntity> outEntityList = se004_01koukoshitendao
				.findByCondition(inEntity);

		// 取得データを公庫支店名プルダウンリストに設定する。　　　　　※プルダウンリストは　String[0]にコード、String[1]に文言を設定する。
		// 　公庫支店コード、公庫支店名の順にString配列に詰め、Listに格納
		// Entity⇒DTOに転記
		LinkedHashMap<String, String> mapShokanHonShiten = new LinkedHashMap<String, String>();

		for (Se004_01KoukoShitenEntity entity : outEntityList) {
			mapShokanHonShiten.put(entity.getCode_KoukoShiten(),
					entity.getName_KoukoShiten());
		}

		outDto.setShokanHonShitenLIST(mapShokanHonShiten);

		return outDto;
	}

	/**
	 * Se004_01ServiceのgetResultData
	 *
	 * @param inDto
	 *            Se004_01DTO
	 * @return Se004_01DTO
	 */
	@Override
	public Se004_01DTO getResultData(Se004_01DTO inDto) {

		Se004_01ResultDataEntity inEntity = new Se004_01ResultDataEntity();

		// エラーリストの初期化
		LinkedList<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();

		// 受渡情報の取得
		// 扱店別稟議データ検索の検索条件を設定
		// 　複数テーブルアクセス定義の「Se004_01ResultDataDAO」を参照し、条件を設定する。
		// 　　　公庫支店コード：入力された公庫支店コード
		inEntity.setCode_ShokanHonShiten(inDto.getDrpID_Code_ShokanHonShiten());
		// 　　　扱店コード：入力された扱店コード
		inEntity.setCode_Organization(inDto.getTxtID_Code_Organization());
		// 　　　店舗コード：入力された店舗コード
		inEntity.setCode_Tenpo(inDto.getTxtID_Code_Tenpo());
		// 　　　年度（西暦）：入力された年度を西暦に変換し設定
		inEntity.setYear(PNCommonComponents.dateFmtJC_Gyy(inDto.getTxtID_Year()));
		String strHousiki = "";
		String strShikin = "";
		if (null != inDto.getTxtID_Kubun_Hoshiki()
				&& 0 < inDto.getTxtID_Kubun_Hoshiki().trim().length()) {
			// 　　　方式区分：入力された方式資金の１文字目を設定
			strHousiki = inDto.getTxtID_Kubun_Hoshiki().substring(0, 1);
			// 　　　資金区分：入力された方式資金の２文字目を設定
			strShikin = inDto.getTxtID_Kubun_Hoshiki().substring(1, 2);
		}
		// 　　　方式区分：入力された方式資金の１文字目を設定
		inEntity.setKubun_Hoshiki(strHousiki);
		// 　　　資金区分：入力された方式資金の２文字目を設定
		inEntity.setKubun_Shikin(strShikin);
		// 　　　番号　　　：入力された番号　　
		inEntity.setID_Ringi(inDto.getTxtID_ID_Ringi());
		// 　　　枝番　　　：入力れされた枝番（値が空文字の場合は０を設定）
		inEntity.setID_RingiBranch(PNCommonComponents.cnvNulltoBlank(inDto
				.getTxtID_ID_RingiBranch()));

		List<Se004_01ResultDataEntity> outEntityList = se004_01resultdatadao
				.findByCondition(inEntity);

		// 検索結果の判定
		if (0 != outEntityList.size()) {
			// 　　データが取得できた場合、取得した農協コードがログオンユーザの扱店コードと一致しない場合エラーとする。
			PNCommonInfo commonInfo = PNCommonInfoHolder.getCommonInfo();
			for (Se004_01ResultDataEntity outEntity : outEntityList) {
				if (!outEntity.getCode_Noukyou().equals(
						commonInfo.getCode_Organization())) {
					// 　　　メッセージ：PM3100E
					// メッセージを追加して継続
					bizErrors.add(new PNMessageInfo(
							PNCommonMessageConstants.PM3100E, new String[0],
							false));
					break;
				}
			}
		}

		// エラー情報をControllerに返却
		inDto.setBizErrors(bizErrors);

		// 　　データが取得できなかった場合、無処理

		return inDto;
	}

}