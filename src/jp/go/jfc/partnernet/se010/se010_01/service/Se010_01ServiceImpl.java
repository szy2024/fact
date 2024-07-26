//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se010_01Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/24 | 堀　大輔              | 新規作成
// 2.0.0   | 2019/01/30 | 坂　竜太              | 農林PN元号対応
// 4.0.0   | 2020/11/27 | 三好　一功            | 基盤更改等に伴うパートナーネットシステムの更改
//==================================================================================================
package jp.go.jfc.partnernet.se010.se010_01.service;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;

import jp.go.jfc.partnernet.common.PNCommonComponents;
import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.common.PNCommonDBComponents;
import jp.go.jfc.partnernet.common.PNCommonMessageConstants;
import jp.go.jfc.partnernet.pnfw.common.PNDateUtils;
import jp.go.jfc.partnernet.pnfw.exception.PNServiceException;
import jp.go.jfc.partnernet.pnfw.exception.PNSystemException;
import jp.go.jfc.partnernet.pnfw.service.PNBaseService;
import jp.go.jfc.partnernet.se010.common.Se010Constants;
import jp.go.jfc.partnernet.se010.se010_01.dao.Se010_01HaraidashiDAO;
import jp.go.jfc.partnernet.se010.se010_01.dao.Se010_01HaraidashiEntity;
import jp.go.jfc.partnernet.se010.se010_01.dao.Se010_01KoukoShitenDAO;
import jp.go.jfc.partnernet.se010.se010_01.dao.Se010_01KoukoShitenEntity;
import jp.go.jfc.partnernet.se010.se010_01.dao.Se010_01KurishoJiyuDAO;
import jp.go.jfc.partnernet.se010.se010_01.dao.Se010_01KurishoJiyuEntity;
import jp.go.jfc.partnernet.se010.se010_01.dao.Se010_01NyukinHistoryDAO;
import jp.go.jfc.partnernet.se010.se010_01.dao.Se010_01NyukinHistoryEntity;
import jp.go.jfc.partnernet.se010.se010_01.dao.Se010_01SeikyuDAO;
import jp.go.jfc.partnernet.se010.se010_01.dao.Se010_01SeikyuEntity;
import jp.go.jfc.partnernet.se010.se010_01.dao.Se010_01YakujoDAO;
import jp.go.jfc.partnernet.se010.se010_01.dao.Se010_01YakujoEntity;
import jp.go.jfc.partnernet.se010.se010_01.dao.Se010_01aRingiDAO;
import jp.go.jfc.partnernet.se010.se010_01.dao.Se010_01aRingiEntity;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <pre>
 * このクラスはSe010_01のサービスクラスです。
 * </pre>
 *
 * @author 坂　竜太
 * @version 2.0.0
 */
public class Se010_01ServiceImpl extends PNBaseService implements Se010_01Service {

    /** se010_01koukoshitendao */
    @Autowired
    private Se010_01KoukoShitenDAO se010_01koukoshitendao;

    /** se010_01kurishojiyudao */
    @Autowired
    private Se010_01KurishoJiyuDAO se010_01kurishojiyudao;

    /** se010_01aringidao */
    @Autowired
    private Se010_01aRingiDAO se010_01aringidao;

    /** se010_01haraidashidao */
    @Autowired
    private Se010_01HaraidashiDAO se010_01haraidashidao;

    /** se010_01yakujodao */
    @Autowired
    private Se010_01YakujoDAO se010_01yakujodao;

    /** se010_01nyukinhistorydao */
    @Autowired
    private Se010_01NyukinHistoryDAO se010_01nyukinhistorydao;

    /** se010_01seikyudao */
    @Autowired
    private Se010_01SeikyuDAO se010_01seikyudao;

    /** db common component */
    @Autowired
    PNCommonDBComponents pnCommonDBComponents;

    /**
     * Se010_01ServiceのgetkoukoShitenCodeNameMap
     *
     * @param inDto Se010_01DTO
     * @return Se010_01DTO
     */
    @Override
    public Se010_01DTO getKoukoShitenCodeNameMap(Se010_01DTO inDto) {

        Se010_01DTO outDto = new Se010_01DTO();

        // 公庫支店のプルダウンマップ取得
        // Se010_01KoukoShitenDAO.findByCondition
        Se010_01KoukoShitenEntity inEntity = new Se010_01KoukoShitenEntity();
        List<Se010_01KoukoShitenEntity> outEntityList = se010_01koukoshitendao.findByCondition(inEntity);

        // 取得データをマップに設定する。※プルダウンマップは　key にコード、valueに支店名を設定する。
        LinkedHashMap<String, String> koukoShitenCodeNameMap = new LinkedHashMap<String, String>();
        for (Se010_01KoukoShitenEntity entity : outEntityList) {
            koukoShitenCodeNameMap.put(entity.getCode_KoukoShiten(), entity.getName_KoukoShiten());
        }
        outDto.setKoukoShitenCodeNameMap(koukoShitenCodeNameMap);

        return outDto;
    }

    /**
     * Se010_01ServiceのgetKurishoJiyuCodeMap
     *
     * @param inDto Se010_01DTO
     * @return Se010_01DTO
     */
    @Override
    public Se010_01DTO getKurishoJiyuCodeMap(Se010_01DTO inDto) {

        Se010_01DTO outDto = new Se010_01DTO();

        // 繰償事由コードのプルダウンマップ取得
        // Se010_01KurishoJiyuDAO.findByCondition
        Se010_01KurishoJiyuEntity inEntity = new Se010_01KurishoJiyuEntity();
        List<Se010_01KurishoJiyuEntity> outEntityList = se010_01kurishojiyudao.findByCondition(inEntity);

        // 取得データマップに設定する。※プルダウンマップは　key にコード、valueに支店名を設定する。
        LinkedHashMap<String, String> kurishoJiyuCodeMap = new LinkedHashMap<String, String>();
        for (Se010_01KurishoJiyuEntity entity : outEntityList) {
            kurishoJiyuCodeMap.put(entity.getCode_KurishoJiyu(), entity.getCode_KurishoJiyu());
        }
        outDto.setKurishoJiyuCodeMap(kurishoJiyuCodeMap);

        return outDto;
    }

    /**
     * Se010_01ServiceのvalidateKurishoKeisan
     *
     * @param inDto Se010_01DTO
     * @return Se010_01DTO
     */
    @Override
    public Se010_01DTO validateKurishoKeisan(Se010_01DTO inDto) {

        Se010_01DTO outDto = new Se010_01DTO();

        // 各整合性チェックを行う

        // 繰上償還額
        BigDecimal bKuriageShokan = new BigDecimal(inDto.getTxtID_M_KuriageShokan());

        // 繰償事由コード上1桁目
        String jiyuCode = "";
        if (!StringUtils.isEmpty(inDto.getDrpID_Code_KurishoJiyu())) {
            jiyuCode = inDto.getDrpID_Code_KurishoJiyu().substring(0, 1);
        }

        // 繰上償還日をYYYYMMDD形式に加工
// [UPD] Ver 2.0.0 - START
//        String strDateKuriageShokan = PNCommonComponents.dateFmtJC_Gyy(inDto
//                .getDrpID_Date_KuriageShokan_Wareki() + inDto.getTxtID_Date_KuriageShokan_Year())
//                + String.format("%02d", Integer.parseInt(inDto.getDrpID_Date_KuriageShokan_Month()))
//                + String.format("%02d", Integer.parseInt(inDto.getDrpID_Date_KuriageShokan_Date()));
        String strDateKuriageShokan = PNCommonComponents.dateFmtJC_Gyymmdd(PNCommonComponents.concatString(
                inDto.getDrpID_Date_KuriageShokan_Wareki(), inDto.getTxtID_Date_KuriageShokan_Year(),
                String.format("%02d", Integer.parseInt(inDto.getDrpID_Date_KuriageShokan_Month())),
                String.format("%02d", Integer.parseInt(inDto.getDrpID_Date_KuriageShokan_Date()))), "");
// [UPD] Ver 2.0.0 - END
        // 繰上償還日のチェックを行う。

        // ① 繰上償還日が実在する日かチェックする。
        // 　1. 実在しない日の場合エラーとする。
        if (!PNCommonComponents.checkDate(strDateKuriageShokan)) {
            // メッセージID：PM3140E
            String[] message = new String[]{"繰上償還日は実在する日"};
            throw new PNServiceException(PNCommonMessageConstants.PM3140E, message, false);
        }

        // ② 非営業日かチェックする。
        // 　1. 対象日が土曜、または日曜の場合
        // 　2. 共通部品のPNCommonComponents.chkBusinessDay()呼び出し、NULLが返却された（非営業日）場合
        if (null == PNCommonComponents.chkWeekEndHolidays(strDateKuriageShokan)
                || null == pnCommonDBComponents.chkBusinessDay(strDateKuriageShokan)) {
            // メッセージID：PM3140E
            String[] message = new String[]{"繰上償還日は営業日"};
            throw new PNServiceException(PNCommonMessageConstants.PM3140E, message, false);
        }

        // 繰償後第一回払込期日をYYYYMMDD形式に加工
// [UPD] Ver 2.0.0 - START
//        String strDateFirstHaraikomiAfterKuriS = PNCommonComponents.dateFmtJC_Gyy(inDto
//                .getDrpID_Date_FirstHaraikomiAfterKuriS_Wareki()
//                + inDto.getTxtID_Date_FirstHaraikomiAfterKuriS_Year())
//                + String.format("%02d",
//                        Integer.parseInt(inDto.getDrpID_Date_FirstHaraikomiAfterKuriS_Month()))
//                + String.format("%02d", Integer.parseInt(inDto.getDrpID_Date_FirstHaraikomiAfterKuriS_Date()));
        String strDateFirstHaraikomiAfterKuriS = PNCommonComponents.dateFmtJC_Gyymmdd(PNCommonComponents.concatString(
                inDto.getDrpID_Date_FirstHaraikomiAfterKuriS_Wareki(), inDto.getTxtID_Date_FirstHaraikomiAfterKuriS_Year(),
                String.format("%02d", Integer.parseInt(inDto.getDrpID_Date_FirstHaraikomiAfterKuriS_Month())),
                String.format("%02d", Integer.parseInt(inDto.getDrpID_Date_FirstHaraikomiAfterKuriS_Date()))), "");
// [UPD] Ver 2.0.0 - END
        // 繰償後第一回払込期日のチェックを行う。

        // ① 繰償後第一回払込期日が実在する日かチェックする。
        // 　1. 実在しない日の場合エラーとする。
        if (!PNCommonComponents.checkDate(strDateFirstHaraikomiAfterKuriS)) {
            // メッセージID：PM3140E
            String[] message = new String[]{"繰償後第一回払込期日は実在する日"};
            throw new PNServiceException(PNCommonMessageConstants.PM3140E, message, false);
        }

        // ② 繰償後第一回払込期日 < 繰上償還日の場合エラーとする。
        if (0 < strDateKuriageShokan.compareTo(strDateFirstHaraikomiAfterKuriS)) {
            // 　メッセージID：PM3170E
            String[] message = new String[]{"繰償後第一回払込期に繰上償還日以前"};
            throw new PNServiceException(PNCommonMessageConstants.PM3170E, message, false);
        }

        // 農協対応：農協の扱店別稟議データの存在チェック（扱店コード（画面入力）に9937を指定した場合）
        // Se010_01aRingiEntityの農協コードに入力された扱店コードを設定する。
        Se010_01aRingiEntity inARringi = new Se010_01aRingiEntity();
        inARringi.setCode_ShokanHonShiten(inDto.getDrpID_Code_ShokanHonShiten());
        inARringi.setCode_Organization(inDto.getTxtID_Code_Organization());
        inARringi.setCode_Tenpo(inDto.getTxtID_Code_Tenpo());
        inARringi.setYear(inDto.getTxtID_Year());
        inARringi.setKubun_Hoshiki(inDto.getTxtID_HoshikiShikin().substring(0, 1));
        inARringi.setKubun_Shikin(inDto.getTxtID_HoshikiShikin().substring(1));
        inARringi.setID_Ringi(inDto.getTxtID_ID_Ringi());
        inARringi.setID_RingiBranch(inDto.getTxtID_ID_RingiBranch());

        if (PNCommonConstants.CODE_NOUKYOU_9937.equals(inDto.getTxtID_Code_Organization())) {

            inARringi.setCode_Noukyou(inDto.getUser_Code_Organization());

            // Se0010_01aRingiDAO.findByCondition
            // 取得条件
            // 　テーブル：「aRingi」
            // 条件
            // 　　1, 公庫支店コード：入力された公庫支店コード
            // 　　2, 扱店コード：入力された扱店コード
            // 　　3, 店舗コード：入力された店舗コード
            // 　　4, 年度：入力された年度
            // 　　5, 方式区分：入力された方式資金1桁目
            // 　　6, 資金区分：入力された方式資金2桁目
            // 　　7, 番号：入力された番号
            // 　　8, 枝番：入力された枝番

            List<Se010_01aRingiEntity> listARingi = se010_01aringidao.findByCondition(inARringi);

            // 　・取得したリストのサイズが0：処理を継続
            if (null != listARingi && 0 == listARingi.size()) {
                // 処理を継続
            } else if (null != listARingi && 1 == listARingi.size()) {
                // ・取得した扱店別稟議データの農協コードがnull または空の場合、エラーとする
                if (StringUtils.isEmpty(listARingi.get(0).getCode_Noukyou())) {
                    // メッセージID：PM3100E
                    throw new PNServiceException(PNCommonMessageConstants.PM3100E);
                }
            } else {
                // 上記以外、エラー(データ不整合)とする
                // データが2件以上
                // メッセージID：PM9010E
                throw new PNSystemException(PNCommonMessageConstants.PM9010E);
            }
        }

        inARringi.setCode_Noukyou(null);
        inARringi.setUser_Code_Organization(inDto.getUser_Code_Organization());
        inARringi.setUser_RoleId(inDto.getUser_RoleId());

        // 扱店別稟議データの取得（後のエラーチェックで使用するため）
        // Se0010_01aRingiEntityにDTOから取得した「利用者の扱店コード」「利用者の権限種別」を設定する。
        // Se0010_01aRingiDAO.findByCondition
        // 取得条件
        // 　テーブル：「aRingi」
        // 条件
        // 　　1, 公庫支店コード：入力された公庫支店コード
        // 　　2, 扱店コード：入力された扱店コード
        // 　　3, 店舗コード：入力された店舗コード
        // 　　4, 年度：入力された年度
        // 　　5, 方式区分：入力された方式資金1桁目
        // 　　6, 資金区分：入力された方式資金2桁目
        // 　　7, 番号：入力された番号
        // 　　8, 枝番：入力された枝番

        List<Se010_01aRingiEntity> listARingi = se010_01aringidao.findByCondition(inARringi);

        // ・検索結果がゼロ件の場合、エラーとする
        if (null == listARingi || 0 == listARingi.size()) {
            // 　メッセージID：PM9060E
            throw new PNServiceException(PNCommonMessageConstants.PM9060E);
        }

        // 稟議データ取得
        Se010_01aRingiEntity aRingi = listARingi.get(0);

        // ・貸付実行日 >= 繰上償還日の場合、エラーとする。
        if (0 >= strDateKuriageShokan.compareTo(aRingi.getDate_Jikko())) {
            // 　メッセージID：PM3170E
            String[] message = new String[]{"繰上償還日に実行年月日以前"};
            throw new PNServiceException(PNCommonMessageConstants.PM3170E, message, false);
        }

        // 直近の払出データから「貸付受入金残高」を取得する。
        // Se010_01HaraidashiDAO.findByCondition
        Se010_01HaraidashiEntity inHaraidashi = new Se010_01HaraidashiEntity();
        inHaraidashi.setID_Credit(aRingi.getID_Credit());
        inHaraidashi.setStrDateKuriageShokan(strDateKuriageShokan);

        // 　テーブル：「Haraidashi」
        // 条件
        // 　　1, 債権管理番号 = 債権管理番号(扱店別稟議データより)
        // 　　2, 払出充当年月日 <= 繰上償還日(画面入力)
        // 　　3. 更正処理区分 = 0 (更正処理されていない)
        // ソート
        // 　　1, 計数管理処理番号 (降順)
        // 　上記、検索結果の最初の１レコード目を対象とする。

        List<Se010_01HaraidashiEntity> listHaraidashi = se010_01haraidashidao.findByCondition(inHaraidashi,
                0, 1);

        // 下記の条件に当てはまる場合、エラーとする
        // 　1. 取得データが0件だった場合、エラーとする。
        if (null == listHaraidashi || 0 == listHaraidashi.size()) {
            // 　メッセージID：PM3730E
            throw new PNServiceException(PNCommonMessageConstants.PM3730E);
        }

        Se010_01HaraidashiEntity haraidashi = listHaraidashi.get(0);

// [ADD] Ver 4.0.0 - START
		// 「実行年月日」＞＝2022/04/01の場合かつ、「貸付受入金残高」＞0の場合、エラーとする。
		if (PNCommonConstants.BASE_DATE_DEDUCT_INTEREST.compareTo(aRingi.getDate_Jikko()) <= 0
				&& BigDecimal.ZERO.compareTo(haraidashi.getM_KashitsukeukeireZan()) < 0) {
			// メッセージID：PM3000E
			String[] message = new String[] {
					"本案件は貸付受入金残高があるため、繰上償還利息の計算ができません。日本政策金融公庫へご連絡ください。"
					};
			throw new PNServiceException(PNCommonMessageConstants.PM3000E, message, false);
		}
// [ADD] Ver 4.0.0 - END

        // 繰上償還額のチェックを行う。
        // ① 約定データから約定前残高を取得する。
        // Se010_01YakujoEntityの対象日に繰償後第一回払込期日（画面入力）を設定する。
        Se010_01YakujoEntity inYakujo = new Se010_01YakujoEntity();

        inYakujo.setID_Credit(aRingi.getID_Credit());
        inYakujo.setStrDate_KurishoTaisho(strDateFirstHaraikomiAfterKuriS);

        // 　テーブル：「Yakujo」
        // 条件
        // 　　1, 債権管理番号 = 債権管理番号(扱店別稟議データより)
        // 　　2, 払込年月日 = 繰償後第一回払込期日（画面入力）

        List<Se010_01YakujoEntity> listYakujo = se010_01yakujodao.findByCondition(inYakujo);

        // 　1. 取得データが0件だった場合、エラーとする。
        if (null == listYakujo || 0 == listYakujo.size()) {
            // 　メッセージID：PM3150E
            String[] message = new String[]{"約定日が取得できません。正しい繰償後第一回払込期日"};
            throw new PNServiceException(PNCommonMessageConstants.PM3150E, message, false);
        }

        Se010_01YakujoEntity yakujo = listYakujo.get(0);

        // ② ①で取得した約定前残高 - 上で取得した直近払出データ貸付金残高 < 繰上償還額の場合エラーとする。
        if (0 > (yakujo.getM_ZandakaBeforeYakujo().subtract(haraidashi.getM_KashitsukeukeireZan()))
                .compareTo(bKuriageShokan)) {
            // 　メッセージID：PM3180E
            String[] message = new String[]{"繰上償還額が貸付金残高"};
            throw new PNServiceException(PNCommonMessageConstants.PM3180E, message, false);
        }

        // 入金履歴データから繰償後第１回払込期日(同日含む)以降の入金履歴データ[払込年月日]を持ち
        // (約定元金 ＞ 0 or 約定利息 > 0)を満たす入金履歴レコード件数を取得する。
        // Se010_01NyukinHistoryDAO.countByCondition
        // 　テーブル：「NyukinHistory」
        // 条件
        // 　　1, 債権管理番号 = 債権管理番号(扱店別稟議データより)
        // 　　2, 払込年月日 >= 繰償後第一回払込期日（画面入力）
        // 　　3. 約定元金 > '0' OR 約定利息 > '0'

        Se010_01NyukinHistoryEntity inNyukinHistory = new Se010_01NyukinHistoryEntity();
        inNyukinHistory.setID_Credit(aRingi.getID_Credit());
        inNyukinHistory.setDate_Haraikomi(strDateFirstHaraikomiAfterKuriS);

        // 　1. 取得データが0件以外だった場合、エラーとする。
        if (0 != se010_01nyukinhistorydao.countByCondition(inNyukinHistory)) {
            // 　メッセージID：PM3650E
            throw new PNServiceException(PNCommonMessageConstants.PM3650E);
        }

        // ----------------- 既存 GetKisanbi Start -----------------
        // 直近の払込期日を取得する。
        // 繰上償還日＞払込期日となる直近の約定データ「払込期日」の取得
        // Se010_01YakujoEntityの対象日Toに繰上償還日（画面入力）を設定する。
        // Se010_01YakujoDAO.findByCondition
        // 　テーブル：「Yakujo」
        // 条件
        // 　　1, 債権管理番号 = 債権管理番号(扱店別稟議データより)
        // 　　2, 払込年月日 < 繰償後第一回払込期日（画面入力）
        // 　　3. 約定期日 = '1'

        inYakujo.setID_Credit(aRingi.getID_Credit());
        inYakujo.setStrDate_KurishoTaisho(null);
        inYakujo.setStrDate_KurishoTaishoTo(strDateFirstHaraikomiAfterKuriS);

        listYakujo = se010_01yakujodao.findByCondition(inYakujo);

        String lastHaraikomiDate = "";

        // 上記データが存在する場合、直近払込期日に取得した約定データの払込期日を直近払込期日に適用する。
        if (null != listYakujo && 0 < listYakujo.size()) {
            lastHaraikomiDate = listYakujo.get(0).getDate_Haraikomi();
        } else {
            // 上記データが存在しない場合、扱店別稟議データの貸付実行日を直近払込期日に適用する。
            lastHaraikomiDate = aRingi.getDate_Jikko();
        }
        // ----------------- 既存 GetKisanbi End -----------------

        // 約定データ「払込期日」の非営業日チェック
        // 非営業日の場合
        if (null == pnCommonDBComponents.chkBusinessDay(lastHaraikomiDate)) {
            // ・共通部品のPNCommonComponents.getCalculateBusinessDay()より翌営業日を求める。
            // ・求めた翌営業日が繰上償還日と同日であった場合
            if (strDateKuriageShokan.equals(pnCommonDBComponents
                    .getCalculateBusinessDay(lastHaraikomiDate, 1))) {
                // 利息計算共通処理をコールせず、0円とするフラグを立てる。
            }
        }

        // ★手数料計算ありの場合
        if (Se010Constants.CALC_TESURYO.equals(inDto.getRadioID_Tesuryo())) {

            // 入力された繰償事由コードの1桁目が2または4の場合
            if (-1 != "24".indexOf(jiyuCode)) {

                // 請求データの取得を行う。
                // Se010_01SeikyuEntityの繰償後第一回払込期日Toに繰償後第一回払込期日（画面入力）を設定する。
                // Se010_01SeikyuDAO.countByCondition
                Se010_01SeikyuEntity inSeikyu = new Se010_01SeikyuEntity();

                // 　テーブル：「Seikyu」
                // 条件
                // 　　1, 債権管理番号 = 債権管理番号(扱店別稟議データより)
                // 　　2, 払込年月日 < 繰償後第一回払込期日（画面入力）
                // 　　3. 請求繰上償還元金 > '0' OR 請求繰上償還利息 > '0'
                inSeikyu.setID_Credit(aRingi.getID_Credit());
                inSeikyu.setStrDate_KurishoTaishoTo(strDateFirstHaraikomiAfterKuriS);

                // (請求データ[払込期日] < 繰償後第一回払込期日) かつ
                // (請求データ[請求繰上償還元金] > 0 or 請求データ[請求繰上償還利息] > 0)の
                // データが存在する場合エラーとする。
                if (0 != se010_01seikyudao.countByCondition(inSeikyu)) {
                    // メッセージID：PM9060E
                    throw new PNServiceException(PNCommonMessageConstants.PM9060E);
                }

                // Se010_01SeikyuEntityの繰償後第一回払込期日Toをnullを設定する。
                inSeikyu.setStrDate_KurishoTaishoTo(null);
                // 繰償後第一回払込期日に繰償後第一回払込期日（画面入力）を設定する。
                inSeikyu.setStrDate_KurishoTaisho(strDateFirstHaraikomiAfterKuriS);

                // 　テーブル：「Seikyu」
                // 条件
                // 　　1, 債権管理番号 = 債権管理番号((2)で取得した扱店別稟議データより)
                // 　　2, 払込年月日 = 繰償後第一回払込期日（画面入力）
                // 　　3. 請求繰上償還元金 > '0' OR 請求繰上償還利息 > '0'

                List<Se010_01SeikyuEntity> listSeikyu = se010_01seikyudao.findByCondition(inSeikyu);

                // (請求データ[払込期日] = 繰償後第一回払込期日) かつ
                // (請求データ[請求繰上償還元金] > 0 or 請求データ[請求繰上償還利息] > 0)の
                // データが存在しない場合エラーとする。
                if (null == listYakujo || 0 == listSeikyu.size()) {
                    String[] message = new String[]{"請求データ"};
                    throw new PNServiceException(PNCommonMessageConstants.PM3190E, message, false);
                }
                // 取得した請求繰上償還元金 < 繰上償還額(画面入力) の場合エラーとする。
                if (0 < bKuriageShokan.compareTo(listSeikyu.get(0).getM_SeiKuriGankin())) {
                    // メッセージID：PM9060E
                    throw new PNServiceException(PNCommonMessageConstants.PM9060E);
                }
            }

            // 1, 免除対象額（画面入力）が繰上償還額（画面入力）以下でない場合エラーとする
            if (!StringUtils.isEmpty(inDto.getTxtID_M_MenjoTaisho())) {
                BigDecimal bMenjoTaisyo = new BigDecimal(inDto.getTxtID_M_MenjoTaisho());
                if (0 < bMenjoTaisyo.compareTo(bKuriageShokan)) {
                    // メッセージID：PM3710E
                    throw new PNServiceException(PNCommonMessageConstants.PM3710E);
                }
            }

            // 2, 償還方法（扱店別稟議）の上一桁 = 2 かつ 繰償事由コード（画面入力）上一桁 = 1,2,5（期間固定）の場合
            if ('2' == aRingi.getCode_ShokanHouhou().charAt(0) && -1 != "125".indexOf(jiyuCode)) {
                // ・元金均等額が未入力　または　0円の場合
                if (StringUtils.isEmpty(inDto.getTxtID_M_Gankinkinto())
                        || "0".equals(inDto.getTxtID_M_Gankinkinto())) {
                    // メッセージID：PM3660E
                    throw new PNServiceException(PNCommonMessageConstants.PM3660E);
                }
                // ・元金不均等額が未入力の場合
                if (StringUtils.isEmpty(inDto.getTxtID_M_Gankinfukinto())) {
                    // メッセージID：PM3130E
                    String[] key = new String[]{"txtID_M_Gankinfukinto"};
                    throw new PNServiceException(PNCommonMessageConstants.PM3120E, key);
                }
            }
            // 　3. 2条件以外の場合
            else {
                // ・元金均等額が入力されている場合
                if (!StringUtils.isEmpty(inDto.getTxtID_M_Gankinkinto())) {
                    // メッセージID：PM3130E
                    String[] key = new String[]{"txtID_M_Gankinkinto"};
                    throw new PNServiceException(PNCommonMessageConstants.PM3130E, key);
                }
                // ・元金不均等額が入力されている　かつ　0円以外の場合
                if (!StringUtils.isEmpty(inDto.getTxtID_M_Gankinfukinto())
                        && !"0".equals(inDto.getTxtID_M_Gankinkinto())) {
                    // メッセージID：PM3130E
                    String[] key = new String[]{"txtID_M_Gankinfukinto"};
                    throw new PNServiceException(PNCommonMessageConstants.PM3130E, key);
                }
            }

            // 　4. 元金不均等額が入力されており、調整コードが「なし」or「全未選択」の場合エラーとする。
            if (!StringUtils.isEmpty(inDto.getTxtID_M_Gankinfukinto())
                    && !"0".equals(inDto.getTxtID_M_Gankinfukinto())) {
                if (!Se010Constants.CHOSEI_FIRST.equals(inDto.getRadioID_Code_Chosei())
                        && !Se010Constants.CHOSEI_LAST.equals(inDto.getRadioID_Code_Chosei())) {
                    // メッセージID：PM3670E
                    throw new PNServiceException(PNCommonMessageConstants.PM3670E);
                }
            }
            // 　5. 元金不均等額が入力されておらず、調整コードが「初回」or「最終回」の場合エラーとする。
            else {
                if (Se010Constants.CHOSEI_FIRST.equals(inDto.getRadioID_Code_Chosei())
                        || Se010Constants.CHOSEI_LAST.equals(inDto.getRadioID_Code_Chosei())) {
                    // メッセージID：PM3680E
                    throw new PNServiceException(PNCommonMessageConstants.PM3680E);
                }
            }

            // 　6. 免除額関連のチェックを行う。
            // 免除対象額が入力されている場合
            if (!StringUtils.isEmpty(inDto.getTxtID_M_MenjoTaisho())) {
                // 償還方法が元金均等かつ期間固定の場合
                if ('2' == aRingi.getCode_ShokanHouhou().charAt(0) && -1 != "125".indexOf(jiyuCode)) {
                    // 免除後元金均等額が未入力または0円の場合エラーとする。
                    if (StringUtils.isEmpty(inDto.getTxtID_M_MenjogoGankinkinto())
                            || "0".equals(inDto.getTxtID_M_MenjogoGankinkinto())) {
                        // メッセージID：PM3660E
                        throw new PNServiceException(PNCommonMessageConstants.PM3660E);
                    }
                    // 免除後元金不均等額が未入力の場合エラーとする。
                    if (StringUtils.isEmpty(inDto.getTxtID_M_MenjogoGankinfukinto())) {
                        // メッセージID：PM3120E
                        String[] key = new String[]{"txtID_M_MenjogoGankinfukinto"};
                        throw new PNServiceException(PNCommonMessageConstants.PM3120E, key);
                    }
                }
                // 上記以外
                else {
                    // 免除後元金均等額が入力されておりかつ0円でない場合エラーとする。
                    if (!StringUtils.isEmpty(inDto.getTxtID_M_MenjogoGankinkinto())
                            && !"0".equals(inDto.getTxtID_M_MenjogoGankinkinto())) {
                        // メッセージID：PM3130E
                        String[] key = new String[]{"txtID_M_MenjogoGankinkinto"};
                        throw new PNServiceException(PNCommonMessageConstants.PM3130E, key);
                    }
                    // 免除後元金不均等額が入力されておりかつ0円でない場合エラーとする。
                    if (!StringUtils.isEmpty(inDto.getTxtID_M_MenjogoGankinfukinto())
                            && !"0".equals(inDto.getTxtID_M_MenjogoGankinfukinto())) {
                        // メッセージID：PM3130E
                        String[] key = new String[]{"txtID_M_MenjogoGankinfukinto"};
                        throw new PNServiceException(PNCommonMessageConstants.PM3130E, key);
                    }
                }
            }
            // 免除対象額が入力されていない場合
            else {
                // 免除後元金均等額が入力されておりかつ0円でない場合エラーとする。
                if (!StringUtils.isEmpty(inDto.getTxtID_M_MenjogoGankinkinto())
                        && !"0".equals(inDto.getTxtID_M_MenjogoGankinkinto())) {
                    // メッセージID：PM3130E
                    String[] key = new String[]{"txtID_M_MenjogoGankinkinto"};
                    throw new PNServiceException(PNCommonMessageConstants.PM3130E, key);
                }
                // 免除後元金不均等額が入力されておりかつ0円でない場合エラーとする。
                if (!StringUtils.isEmpty(inDto.getTxtID_M_MenjogoGankinfukinto())
                        && !"0".equals(inDto.getTxtID_M_MenjogoGankinfukinto())) {
                    // メッセージID：PM3130E
                    String[] key = new String[]{"txtID_M_MenjogoGankinfukinto"};
                    throw new PNServiceException(PNCommonMessageConstants.PM3130E, key);
                }
            }

            // 　7. 調整コードのチェックを行う。
            // 免除後元金不均等額が入力されている場合
            if (!StringUtils.isEmpty(inDto.getTxtID_M_MenjogoGankinfukinto())
                    && !"0".equals(inDto.getTxtID_M_MenjogoGankinfukinto())) {
                // 調整コードが「なし」 or 全未選択の場合エラーとする。
                if (!Se010Constants.CHOSEI_FIRST.equals(inDto.getRadioID_Code_Chosei_Menjogo())
                        && !Se010Constants.CHOSEI_LAST.equals(inDto.getRadioID_Code_Chosei_Menjogo())) {
                    // メッセージID：PM3690E
                    throw new PNServiceException(PNCommonMessageConstants.PM3690E);
                }
            }
            // 免除後元金不均等額が入力されていない場合
            else {
                // 調整コードが「初回」または「最終回」が選択されている場合エラーとする。
                if (Se010Constants.CHOSEI_FIRST.equals(inDto.getRadioID_Code_Chosei_Menjogo())
                        || Se010Constants.CHOSEI_LAST.equals(inDto.getRadioID_Code_Chosei_Menjogo())) {
                    // メッセージID：PM3700E
                    throw new PNServiceException(PNCommonMessageConstants.PM3700E);
                }
            }

            // 　8. 元金均等額・元金不均等額のチェック。
            int nowShokanNum = 0;
            // 　- 償還方法（扱店別稟議）の上一桁 = 2 かつ 繰償事由コード（画面入力）上一桁 = 1,2,5（期間固定）の場合
            if ('2' == aRingi.getCode_ShokanHouhou().charAt(0) && -1 != "125".indexOf(jiyuCode)) {
                // 　　 *繰上償還期日 = 繰償後第一回払込期日
                String strShokanKijitu = strDateFirstHaraikomiAfterKuriS;
                // 　　 *償還期限年月 = 繰上償還期限(稟議)
                String strShokanKigen = aRingi.getDate_ShokanKigen();
                // 　　 *据置期限年月 = 据置期限年月(稟議)※空の場合「0」をセットする
                String strSueokiKigen = aRingi.getDate_SueokiKigen();
                if (StringUtils.isEmpty(strSueokiKigen)) {
                    strSueokiKigen = "0";
                }
                int shokanMonths = 0;
                // (a) (「据置期限年月」が空または０)　または　(「据置期限年月」≦「償還対象期日」)の場合
                if ("0".equals(strSueokiKigen)
                        || 0 >= strSueokiKigen.compareTo(strShokanKijitu.substring(0, 6))) {
                    // 償還月数残 = (「償還期限年月」－「繰償後第一回払込期日」)
                    shokanMonths = getMonths(strShokanKijitu.substring(0, 6), strShokanKigen);
                } else {
                    // 償還月数残 = (「償還期限年月」－「据置期限年月」)
                    shokanMonths = getMonths(strSueokiKigen, strShokanKigen);
                }
                // 現在の償還回数を求める。
                if (-1 != "1246".indexOf(aRingi.getCode_ShokanHouhou().substring(1))) {
                    // 現在の償還回数 = (「償還月数残」 × (償還方法コードの下一桁 / 12))
                    // 償還方法コードの下一桁
                    double yearlyNum = Double.parseDouble(aRingi.getCode_ShokanHouhou().substring(1));
                    nowShokanNum = (int) (shokanMonths * (yearlyNum / 12));
                    // （※据置期限より繰上償還期日が未来の場合+1する）
                    if (0 < strShokanKijitu.substring(0, 6).compareTo(strSueokiKigen)) {
                        nowShokanNum++;
                    }
                } else if (aRingi.getCode_ShokanHouhou().endsWith("B")) {
                    nowShokanNum = shokanMonths * (12 / 12);
                    // （※据置期限より繰上償還期日が未来の場合+1する）
                    if (0 < strShokanKijitu.substring(0, 6).compareTo(strSueokiKigen)) {
                        nowShokanNum++;
                    }
                }

                if (StringUtils.isEmpty(inDto.getTxtID_M_MenjoTaisho())) {
                    // *元金不均等額（画面入力）＞０円の場合
                    if (!StringUtils.isEmpty(inDto.getTxtID_M_Gankinfukinto())
                            && !"0".equals(inDto.getTxtID_M_Gankinfukinto())) {
                        long yakujomaeZandaka = Long.parseLong(inDto.getTxtID_M_Gankinkinto())
                                * (nowShokanNum - 1) + Long.parseLong(inDto.getTxtID_M_KuriageShokan())
                                + Long.parseLong(inDto.getTxtID_M_Gankinfukinto());

                        if (0 != yakujo.getM_ZandakaBeforeYakujo()
                                .compareTo(new BigDecimal(yakujomaeZandaka))) {
                            String[] message = new String[]{"元金均等額または元金不均等額は正しい値"};
                            throw new PNServiceException(PNCommonMessageConstants.PM3140E, message, false);
                        }
                    }
                    // *元金不均等額（画面入力）＝０円の場合
                    else {
                        long yakujomaeZandaka = Long.parseLong(inDto.getTxtID_M_Gankinkinto()) * nowShokanNum
                                + Long.parseLong(inDto.getTxtID_M_KuriageShokan());

                        if (0 != yakujo.getM_ZandakaBeforeYakujo()
                                .compareTo(new BigDecimal(yakujomaeZandaka))) {
                            String[] message = new String[]{"元金均等額または元金不均等額は正しい値"};
                            throw new PNServiceException(PNCommonMessageConstants.PM3140E, message, false);
                        }
                    }
                }
            }

            // 　 ・ 「一部免除ありの免除対象額」が入力ありの場合
            if (!StringUtils.isEmpty(inDto.getTxtID_M_MenjoTaisho())
                    && !"0".equals(inDto.getTxtID_M_MenjoTaisho())) {
                // 　- 償還方法（扱店別稟議）の上一桁 = 2 かつ 繰償事由コード（画面入力）上一桁 = 1,2,5（期間固定）の場合
                if ('2' == aRingi.getCode_ShokanHouhou().charAt(0) && -1 != "125".indexOf(jiyuCode)) {

                    // 免除後の貸付金残高取得　= 約定データ「約定金残高」 - 免除対象額（画面入力）
                    long lMenjogoKashitukeukeireZan = yakujo.getM_ZandakaBeforeYakujo()
                            .subtract(new BigDecimal(inDto.getTxtID_M_MenjoTaisho())).longValue();

                    // 元金不均等額（画面入力）＞０円の場合
                    if (!StringUtils.isEmpty(inDto.getTxtID_M_MenjogoGankinfukinto())
                            && !"0".equals(inDto.getTxtID_M_MenjogoGankinfukinto())) {

                        // (a) 免除後の貸付金残高 = 元金均等額(画面入力) × (現在の償還回数-1) + 繰上償還額(画面入力) - 免除対象額(画面入力) +
                        long menjogoKashitukeukeireZan = Long
                                .parseLong(inDto.getTxtID_M_MenjogoGankinkinto())
                                * (nowShokanNum - 1)
                                + (Long.parseLong(inDto.getTxtID_M_KuriageShokan()) - Long.parseLong(inDto
                                        .getTxtID_M_MenjoTaisho()))
                                + Long.parseLong(inDto.getTxtID_M_MenjogoGankinfukinto());

                        // 元金不均等額(画面入力)でない場合エラーとする。
                        if (lMenjogoKashitukeukeireZan != menjogoKashitukeukeireZan) {
                            String[] message = new String[]{"免除後元金均等額または免除後元金不均等額は正しい値"};
                            throw new PNServiceException(PNCommonMessageConstants.PM3140E, message, false);
                        }
                    }
                    // 元金不均等額（画面入力）＝０円の場合
                    else {
                        // (a) 免除後の貸付金残高=元金均等額(画面入力)×現在の償還回数＋繰上償還額（画面入力）-免除対象額(画面入力)でない場合エラーとする。
                        long menjogoKashitukeukeireZan = Long
                                .parseLong(inDto.getTxtID_M_MenjogoGankinkinto())
                                * nowShokanNum
                                + (Long.parseLong(inDto.getTxtID_M_KuriageShokan()) - Long.parseLong(inDto
                                        .getTxtID_M_MenjoTaisho()));

                        // 元金不均等額(画面入力)でない場合エラーとする。
                        if (lMenjogoKashitukeukeireZan != menjogoKashitukeukeireZan) {
                            String[] message = new String[]{"免除後元金均等額または免除後元金不均等額は正しい値"};
                            throw new PNServiceException(PNCommonMessageConstants.PM3140E, message, false);
                        }
                    }
                }
            }

        }

        // ★手数料計算なしの場合
        else {
            // tesuryo 0

        }

        return outDto;
    }

    /**
     * from-To の残り月数を求める
     *
     * @param from yyyyMM
     * @param to yyyyMM
     * @return
     */
    private int getMonths(String from, String to) {
        int month = 0;
        Calendar calFrom = DateUtils.toCalendar(PNDateUtils.toDate(from + "01", "yyyyMMdd"));
        Calendar calTo = DateUtils.toCalendar(PNDateUtils.toDate(to + "01", "yyyyMMdd"));

        while (calFrom.before(calTo)) {
            calFrom.add(Calendar.MONTH, 1);
            month++;

        }
        return month;
    }
}