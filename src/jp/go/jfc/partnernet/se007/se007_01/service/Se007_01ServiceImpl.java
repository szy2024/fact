//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se007_01Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/09 | 田旗　秀樹            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se007.se007_01.service;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

import jp.go.jfc.partnernet.common.PNCommonComponents;
import jp.go.jfc.partnernet.common.PNCommonMessageConstants;
import jp.go.jfc.partnernet.common.dao.KoukoshitenDAO;
import jp.go.jfc.partnernet.common.dao.KoukoshitenEntity;
import jp.go.jfc.partnernet.pnfw.common.PNCommonInfo;
import jp.go.jfc.partnernet.pnfw.common.PNCommonInfoHolder;
import jp.go.jfc.partnernet.pnfw.common.PNMessageInfo;
import jp.go.jfc.partnernet.pnfw.service.PNBaseService;
import jp.go.jfc.partnernet.se007.se007_01.dao.Se007_01ResultDataDAO;
import jp.go.jfc.partnernet.se007.se007_01.dao.Se007_01ResultDataEntity;

import org.springframework.beans.factory.annotation.Autowired;

import com.fujitsu.crust.common.CFWBeanUtils;

/**
 * <pre>
 * このクラスはse007_01のサービスクラスです。
 * </pre>
 *
 * @author 田旗　秀樹
 * @version 1.0.0
 */
public class Se007_01ServiceImpl extends PNBaseService implements Se007_01Service {

    /** koukoshitendao */
    @Autowired
    private KoukoshitenDAO koukoshitendao;

    /** se007_01getresultdatadao */
    @Autowired
    private Se007_01ResultDataDAO se007_01getresultdatadao;

    /**
     * Se007_01ServiceのgetKoukoshitenCodeCoulumList
     *
     * @param inDto Se007_01DTO
     * @return Se007_01DTO
     */
    @Override
    public Se007_01DTO getKoukoshitenCodeCoulumList(Se007_01DTO inDto) {

        Se007_01DTO outDto = new Se007_01DTO();

        // 検索条件を設定
        // 単テーブルアクセス定義の「公庫支店名テーブル　公庫支店コードプルダウンリスト取得」を参照し、条件を設定する。
        // KoukoShutenDAO.findByCondition
        KoukoshitenEntity inEntity = new KoukoshitenEntity();
        CFWBeanUtils.copyProperties(inEntity, inDto);
        List<KoukoshitenEntity> outEntityList = koukoshitendao.findByCondition(inEntity);

        // Entity⇒DTOに転記
        LinkedHashMap<String, String> lMap = new LinkedHashMap<String, String>();

        for (KoukoshitenEntity outEntity : outEntityList) {
            lMap.put(outEntity.getCode_KoukoShiten(), outEntity.getName_KoukoShiten());
        }
        outDto.setKOUKOSHITEN_CODE_PULLDOWN_LIST(lMap);
        return outDto;
    }

    /**
     * Se007_01ServiceのgetResultData
     *
     * @param inDto Se007_01DTO
     * @return Se007_01DTO
     */
    @Override
    public Se007_01DTO getResultData(Se007_01DTO inDto) {

        Se007_01ResultDataEntity inEntity = new Se007_01ResultDataEntity();

        // エラーリストの初期化
        LinkedList<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();

        // 受渡情報の取得
        // 扱店別稟議データ検索の検索条件を設定
        // 　複数テーブルアクセス定義の「Se007_01ResultDataDAO」を参照し、条件を設定する。
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
        if (null != inDto.getTxtID_Hoshikishikin()) {
            // 　　　方式区分：入力された方式資金の１文字目を設定
            strHousiki = inDto.getTxtID_Hoshikishikin().substring(0, 1);
            // 　　　資金区分：入力された方式資金の２文字目を設定
            strShikin = inDto.getTxtID_Hoshikishikin().substring(1, 2);
        }
        inEntity.setKubun_Hoshiki(strHousiki);
        inEntity.setKubun_Shikin(strShikin);
        // 　　　番号　　　：入力された番号　　
        inEntity.setID_Ringi(inDto.getTxtID_ID_Ringi());
        // 　　　枝番　　　：入力れされた枝番（値が空文字の場合は０を設定）
        inEntity.setID_RingiBranch(PNCommonComponents.cnvNulltoZero(inDto.getTxtID_ID_RingiBranch()));

        List<Se007_01ResultDataEntity> outEntityList = se007_01getresultdatadao.findByCondition(inEntity);

        // 検索結果の判定
        if (0 < outEntityList.size()) {
            PNCommonInfo commonInfo = PNCommonInfoHolder.getCommonInfo();
            // 　　データが取得できた場合、取得した農協コードがログオンユーザの扱店コードと一致しない場合エラーとする。
            for (Se007_01ResultDataEntity outEntity : outEntityList) {
                if (!outEntity.getCode_Noukyou().equals(commonInfo.getCode_Organization())) {
                    // 　　　メッセージ：PM3100E
                    // メッセージを追加して継続
                    bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM3100E, new String[0], false));
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