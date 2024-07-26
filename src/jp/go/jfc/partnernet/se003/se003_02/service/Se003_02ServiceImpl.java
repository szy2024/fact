//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Se003_02Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/16 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.se003.se003_02.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import jp.go.jfc.partnernet.common.PNCommonComponents;
import jp.go.jfc.partnernet.common.PNCommonMessageConstants;
import jp.go.jfc.partnernet.common.PNCommonUtils;
import jp.go.jfc.partnernet.pnfw.common.PNMessageInfo;
import jp.go.jfc.partnernet.pnfw.common.PNMessageUtils;
import jp.go.jfc.partnernet.pnfw.service.PNBaseService;
import jp.go.jfc.partnernet.se003.common.Se003Constants;
import jp.go.jfc.partnernet.se003.se003_02.dao.Se003_02HaraidashiDataDAO;
import jp.go.jfc.partnernet.se003.se003_02.dao.Se003_02HaraidashiDataEntity;
import jp.go.jfc.partnernet.se003.se003_02.dao.Se003_02NyukinHistoryDataDAO;
import jp.go.jfc.partnernet.se003.se003_02.dao.Se003_02NyukinHistoryDataEntity;
import jp.go.jfc.partnernet.se003.se003_02.dao.Se003_02ResultDataDAO;
import jp.go.jfc.partnernet.se003.se003_02.dao.Se003_02ResultDataEntity;
import jp.go.jfc.partnernet.se003.se003_02.dao.Se003_02YakujoDataDAO;
import jp.go.jfc.partnernet.se003.se003_02.dao.Se003_02YakujoDataEntity;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * <pre>
 * このクラスはSe003_02のサービスクラスです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public class Se003_02ServiceImpl extends PNBaseService implements Se003_02Service {

    /** se003_02getresultdatadao */
    @Autowired
    private Se003_02ResultDataDAO se003_02getresultdatadao;

    /** se003_02getharaidashidatadao */
    @Autowired
    private Se003_02HaraidashiDataDAO se003_02getharaidashidatadao;

    /** se003_02getyakujodatadao */
    @Autowired
    private Se003_02YakujoDataDAO se003_02getyakujodatadao;

    /** se003_02getnyukinhistorydatadao */
    @Autowired
    private Se003_02NyukinHistoryDataDAO se003_02getnyukinhistorydatadao;

    /**
     * Se003_02ServiceのgetResultData
     *
     * @param inDto Se003_02DTO
     * @return Se003_02DTO
     */
    @Override
    public Se003_02DTO getResultData(Se003_02DTO inDto) {

        // エラーリスト
        LinkedList<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();
        // エラーリスト初期化
        bizErrors.clear();

        // 受渡情報の取得
        // 自画面の全項目及び払出明細エリア、払込明細エリア初期化
        Se003_02DTO outDto = new Se003_02DTO();
        Se003_02ResultDataEntity inEntity = new Se003_02ResultDataEntity();
        Se003_02HaraidashiDataEntity inEntity2 = new Se003_02HaraidashiDataEntity();
        Se003_02YakujoDataEntity inEntity3 = new Se003_02YakujoDataEntity();
        Se003_02NyukinHistoryDataEntity inEntity4 = new Se003_02NyukinHistoryDataEntity();

        // 扱店別稟議データ取得の検索条件を設定
        // 　複数テーブルアクセス定義の「Se003_02GetResultDataDAO」を参照し、条件を設定する。
        // 　　・公庫支店コード：ＤＴＯ値のまま
        inEntity.setCode_ShokanHonShiten(inDto.getSe003_02Code_ShokanHonShiten());
        // 　　・扱店コード：ＤＴＯ値のまま。
        inEntity.setCode_Organization(inDto.getSe003_02Code_Organization());
        // 　　・店舗コード：ＤＴＯ値のまま。
        inEntity.setCode_Tenpo(inDto.getSe003_02Code_Tenpo());
        // 　　・年度：ＤＴＯの年度値を和暦→西暦変換（共通処理）し設定。
        inEntity.setYear(PNCommonComponents.dateFmtJC_Gyy(inDto.getSe003_02Year().toUpperCase()));
        // 　　・方式区分：ＤＴＯの方式資金値１文字目を設定。
        inEntity.setKubun_Hoshiki(inDto.getSe003_02Kubun_Hoshiki().substring(0, 1));
        // 　　・資金区分：ＤＴＯの方式資金値２文字目を設定。
        inEntity.setKubun_Shikin(inDto.getSe003_02Kubun_Hoshiki().substring(1, 2));
        // 　　・入力番号：ＤＴＯ値のまま。
        inEntity.setID_Ringi(inDto.getSe003_02ID_Ringi());
        // 　　・入力枝番：ＤＴＯ値のまま。但し、値が空文字の場合は０を設定する。
        inEntity.setID_RingiBranch(PNCommonComponents.cnvNulltoZero(inDto.getSe003_02ID_RingiBranch()));

        List<Se003_02ResultDataEntity> outEntityList = se003_02getresultdatadao.findByCondition(inEntity);

        // 取得結果の判定
        // 　　取得件数が０件の場合、データ無のメッセージを編集し、以降の処理は行わない。
        // 　　メッセージ：PTN_SE003_010
        if (0 == outEntityList.size()) {
            // エラー内容設定
            bizErrors.add(new PNMessageInfo(PNCommonMessageConstants.PM9060E, new String[0], false));
            outDto.setBizErrors(bizErrors);
            return outDto;
        }

        Se003_02ResultDataEntity outEntity = outEntityList.get(0);

        // 検索結果を取得(Entity→DTOに設定)
        // 　以下の項目を設定する。
        // 　　・公庫支店名：公庫支店名を設定
        outDto.setID_ID_Name_KoukoShiten(outEntity.getName_KoukoShiten());
        // 　　・扱店：扱店コードを設定
        outDto.setID_Code_Organization(outEntity.getCode_Organization());
        // 　　・店舗：店舗コードを設定
        outDto.setID_Code_Tenpo(outEntity.getCode_Tenpo());
        // 　　・年度：年度を和暦に変換（共通処置）し設定。　※年の頭０はサプレスする（H05　→　H5)
        outDto.setID_Year(outEntity.getYear());
        // 　　・方式資金：方式区分と資金区分を連結して設定
        String strHoshikiKubun = PNCommonComponents.concatString(outEntity.getKubun_Hoshiki(),
                outEntity.getKubun_Shikin());
        outDto.setID_Kubun_Hoshiki(strHoshikiKubun);
        // 　　・番号：稟議番号を設定
        outDto.setID_ID_Ringi(outEntity.getID_Ringi());
        // 　　・枝番：稟議番号枝番を設定
        if (false == "0".equals(outEntity.getID_RingiBranch())) {
            outDto.setID_ID_RingiBranch(outEntity.getID_RingiBranch());
        }
        // 　　・貸付金額：貸付金額を設定
        outDto.setID_M_Kashitsuke(outEntity.getM_Kashitsuke());
        // 　　・資金使途名：資金使途名を設定 最大15桁
        outDto.setID_Name_ShikinShito(PNCommonComponents.cutNameShikinShito(outEntity.getName_ShikinShito()));
        // 　　・繰償手数料：繰上償還手数料区分を設定
        outDto.setID_Kubun_KurishoTesuryo(outEntity.getKubun_KurishoTesuryo());
        // 　　・金利制度の選択：金利制度の選択区分を設定
        outDto.setID_Kubun_KinriSeidoSentaku(outEntity.getKubun_KinriSeidoSentaku());
        // 　　・利率：利率を設定
        BigDecimal bdRiritsu = new BigDecimal(outEntity.getRiritsu());
        bdRiritsu = PNCommonComponents.mathPercent1000(PNCommonComponents.cnvNulltoZero(bdRiritsu));
        outDto.setID_Riritsu(bdRiritsu.toString());
        // 　　・特利コード：特利区分を設定
        outDto.setID_Kubun_Tokuri(outEntity.getKubun_Tokuri());
        // 　　・特利：特利を設定
        BigDecimal bdTokuri = new BigDecimal(outEntity.getTokuri());
        bdTokuri = PNCommonComponents.mathPercent1000(PNCommonComponents.cnvNulltoZero(bdTokuri));
        outDto.setID_Tokuri(bdTokuri.toString());
        // 　　・指標率：指標率を設定
        BigDecimal bdShihyoritsu = new BigDecimal(outEntity.getShihyoritsu());
        bdShihyoritsu = PNCommonComponents.mathPercent1000(PNCommonComponents.cnvNulltoZero(bdShihyoritsu));
        outDto.setID_Shihyoritsu(bdShihyoritsu.toString());
        // 　　・据置期限：据置期限年月を和暦に変換し設定。　※年、月の頭０はサプレスする（H05.01　→　H5.1)
        outDto.setID_Date_SueokiKigen(outEntity.getDate_SueokiKigen());
        // 　　・償還期限：償還期限（年月）を和暦に変換し設定。　※年、月の頭０はサプレスする（H05.01　→　H5.1)
        outDto.setID_Date_ShokanKigen(outEntity.getDate_ShokanKigen());
        // 　　・元利金払込日：元利金払込年月日を和暦に変換し設定。　※月、日の頭０はサプレスする（0105　→　1.5)
        outDto.setID_Date_GanrikinHaraiKomi(PNCommonComponents.dateFmtAD_MMDD(outEntity
                .getDate_GanrikinHaraiKomi()));
        // 　　・償還方法コード：償還方法コードを設定
        outDto.setID_Code_ShokanHouhou(outEntity.getCode_ShokanHouhou());
        // 　　・元金不均等額区分：元金不均等額区分を設定
        outDto.setID_Kubun_GankinFukintogaku(outEntity.getKubun_GankinFukintogaku());
        // 　　・元利又は元金均等額：賦金を設定
        outDto.setID_M_Fukin(outEntity.getM_Fukin());
        // 　　・元金不均等額：元金不均等額を設定
        outDto.setID_M_GankinFukinto(outEntity.getM_GankinFukinto());
        // 　　・貸付決定日：決定起算年月日を設定。　※年、月、日の頭０はサプレスする（H05.01.05　→　H5.1.5)
        outDto.setID_Date_KetteiKisan(outEntity.getDate_KetteiKisan());
        // 　　・貸付実行日：実行年月日を設定　※年、月、日の頭０はサプレスする（H05.01.05　→　H5.1.5)
        outDto.setID_Date_Jikko(outEntity.getDate_Jikko());
        // 　　・貸付実行額：貸付金額
        outDto.setID_M_KashitsukeJikko(outEntity.getM_Kashitsuke());
        // 　　・貸付金現在残高：貸付金残高を設定
        outDto.setID_M_KashitsukeZandaka(outEntity.getM_KashitsukeZandaka());

        // 払出データ取得の検索条件を設定
        // 　複数テーブルアクセス定義の「Se003_02GetHaraidashiDataDAO」を参照し、条件を設定する。
        // 　　・債権管理番号：扱店別稟議データ取得で取得した債権管理番号のまま。
        inEntity2.setID_Credit(outEntity.getID_Credit());

        List<Se003_02HaraidashiDataEntity> outEntityList2 = se003_02getharaidashidatadao
                .findByCondition(inEntity2);

        // 検索結果を取得(Entity→DTOに設定)
        List<Se003_02M1DTO> haraidashiLIST = new ArrayList<Se003_02M1DTO>(outEntityList2.size());
        BigDecimal bdZero = new BigDecimal(Se003Constants.STR_ZERO);

        // 　以下の払出明細（Ｍ１）項目を取得件数分設定する。
        for (Se003_02HaraidashiDataEntity outEntity2 : outEntityList2) {

            Se003_02M1DTO se003_02M1DTO = new Se003_02M1DTO();

            // 　　・払出日：払出充当年月日を設定。
            se003_02M1DTO.setID_Date_HaraidashiJuto(outEntity2.getDate_HaraidashiJuto());
            // 　　・区分：
            // 　　　　払出額＞０の場合、”払出”を編集する。
            // 　　　　繰上償還額＞０の場合、”繰償”を編集する。
            // 　　　　2項目共編集する場合、項目間に改行コードを入れ、２行で表示する様編集する。
            if (0 < (PNCommonComponents.cnvNulltoZero(outEntity2.getM_Haraidashi())).compareTo(bdZero)
                    && 0 < (PNCommonComponents.cnvNulltoZero(outEntity2.getM_Kurisho())).compareTo(bdZero)) {
                se003_02M1DTO.setID_Kubun_Haraidashi(Se003Constants.KUBUN_HARAIDASHI_HARAIDASHI_KURISYO);
            } else if (0 < (PNCommonComponents.cnvNulltoZero(outEntity2.getM_Haraidashi())).compareTo(bdZero)) {
                se003_02M1DTO.setID_Kubun_Haraidashi(Se003Constants.KUBUN_HARAIDASHI_HARAIDASHI);
            } else if (0 < (PNCommonComponents.cnvNulltoZero(outEntity2.getM_Kurisho())).compareTo(bdZero)) {
                se003_02M1DTO.setID_Kubun_Haraidashi(Se003Constants.KUBUN_HARAIDASHI_KURISYO);
            }
            // 　　・払出額：払出額を設定。
            se003_02M1DTO.setID_M_Haraidashi(outEntity2.getM_Haraidashi());
            // 　　・払出累計額：払出累計額を設定。
            se003_02M1DTO.setID_M_HaraidashiRuikei(outEntity2.getM_HaraidashiRuikei());
            // 　　・償還額：繰上償還額を設定。
            se003_02M1DTO.setID_M_Kurisho(outEntity2.getM_Kurisho());
            // 　　・繰償累計額：繰上償還累計額を設定。
            se003_02M1DTO.setID_M_KurishoRuikei(outEntity2.getM_KurishoRuikei());
            // 　　・貸受金残高：貸付受入金残高を設定。
            se003_02M1DTO.setID_M_KashitsukeukeireZan(outEntity2.getM_KashitsukeukeireZan());
            haraidashiLIST.add(se003_02M1DTO);
        }

        outDto.setMEISAI_HaraidashiLIST(haraidashiLIST);

        // 約定データ取得の検索条件を設定
        // 　複数テーブルアクセス定義の「Se003_02GetYakujoDataDAO」を参照し、条件を設定する。
        // 　　・債権管理番号：扱店別稟議データ取得で取得した債権管理番号のまま。
        inEntity3.setID_Credit(outEntity.getID_Credit());

        List<Se003_02YakujoDataEntity> outEntityList3 = se003_02getyakujodatadao.findByCondition(inEntity3);

        // 検索結果を取得(Entity→DTOに設定)
        List<Se003_02M2DTO> haraikomiLIST = new ArrayList<Se003_02M2DTO>(outEntityList3.size());

        List<Se003_02NyukinHistoryDataEntity> outEntityList4 = null;

        // 　以下の払込明細（Ｍ２）項目を取得件数分設定する。
        for (int i = 0; i < outEntityList3.size(); i++) {

            Se003_02M2DTO se003_02M2DTO = new Se003_02M2DTO();

            // 　　・払込日付：払込年月日を設定
            se003_02M2DTO.setID_Y_Date_Haraikomi(outEntityList3.get(i).getDate_Haraikomi());
            // 　　・約定利息：約定利息を設定
            se003_02M2DTO.setID_Y_M_YakujoRisoku(outEntityList3.get(i).getM_YakujoRisoku());
            // 　　・約定元金：約定元金を設定
            se003_02M2DTO.setID_Y_M_YakujoGankin(outEntityList3.get(i).getM_YakujoGankin());
            // 　　・繰上償還利息：繰償利息計を設定
            se003_02M2DTO.setID_Y_M_SeiKuriRisoku(outEntityList3.get(i).getM_KurishoRisoku_Kei());
            // 　　・繰上償還元金：繰償元金計を設定
            se003_02M2DTO.setID_Y_M_SeiKuriGankin(outEntityList3.get(i).getM_KurishoGankin_Kei());
            // 　　・利子助成額：利子助成額を設定
            se003_02M2DTO.setID_Y_M_RishiJosei(outEntityList3.get(i).getM_RishiJosei());
            // 　　・約定前残高：約定前残高を設定
            se003_02M2DTO.setID_Y_M_ZandakaBeforeYakujo(outEntityList3.get(i).getM_ZandakaBeforeYakujo());

            // 　　取得した約定データに対応する入金履歴データ取得の検索条件を設定
            // 　　　複数テーブルアクセス定義の「Se003_02GetNyukinHistoryDataDAO」を参照し、条件を設定する。
            // 　　　　・債権管理番号：約定データ取得で取得した債権管理番号のまま。
            inEntity4.setID_Credit(outEntityList3.get(i).getID_Credit());
            // 　　　　・払込年月日：約定データ取得で取得した払込年月日のまま。
            inEntity4.setDate_Haraikomi(outEntityList3.get(i).getDate_Haraikomi());

            outEntityList4 = se003_02getnyukinhistorydatadao.findByCondition(inEntity4);

            List<Se003_02M2DTO> outDTONyukinList = new ArrayList<Se003_02M2DTO>(outEntityList4.size());

            if (0 != outEntityList4.size()) {

                for (Se003_02NyukinHistoryDataEntity outEntity4 : outEntityList4) {

                    Se003_02M2DTO nyukinMeisai = new Se003_02M2DTO();

                    // 　　検索結果を取得(Entity→DTOに設定)
                    // 　　　以下の払込明細（Ｍ２）項目を取得件数分設定する。
                    // 　　　　・入金日：入金年月日を設定
                    nyukinMeisai.setID_N_Date_Nyukin(outEntity4.getDate_Nyukin());
                    // 　　　　・約定利息：約定利息を設定
                    nyukinMeisai.setID_N_M_YakujoRisoku(PNCommonUtils.addComma(PNCommonUtils
                            .encNulltoZeroBig(outEntity4.getM_YakujoRisoku())));
                    // 　　　　・約定元金：約定元金を設定
                    nyukinMeisai.setID_N_M_YakujoGankin(PNCommonUtils.addComma(PNCommonUtils
                            .encNulltoZeroBig(outEntity4.getM_YakujoGankin())));
                    // 　　　　・任意繰上償還利息：任意繰上償還利息を設定
                    nyukinMeisai.setID_N_M_NinKuriRisoku(PNCommonUtils.addComma(PNCommonUtils
                            .encNulltoZeroBig(outEntity4.getM_NinKuriRisoku())));
                    // 　　　　・任意繰上償還元金：任意繰上償還元金を設定
                    nyukinMeisai.setID_N_M_NinKuriGankin(PNCommonUtils.addComma(PNCommonUtils
                            .encNulltoZeroBig(outEntity4.getM_NinKuriGankin())));
                    // 　　　　・請求繰上償還利息：請求繰上償還利息を設定
                    nyukinMeisai.setID_N_M_SeiKuriRisoku(PNCommonUtils.addComma(PNCommonUtils
                            .encNulltoZeroBig(outEntity4.getM_SeiKuriRisoku())));
                    // 　　　　・請求繰上償還元金：請求繰上償還元金を設定
                    nyukinMeisai.setID_N_M_SeiKuriGankin(PNCommonUtils.addComma(PNCommonUtils
                            .encNulltoZeroBig(outEntity4.getM_SeiKuriGankin())));
                    // 　　　　・遅延損害金等：遅延損害金＋違約金＋転用違約金＋棚上遅延損害金＋今回発生遅延損害金の計算値を設定
                    java.math.BigDecimal bdChienSongai = outEntity4.getM_ChienSongai()
                            .add(outEntity4.getM_Iyaku()).add(outEntity4.getM_TenyoIyaku())
                            .add(outEntity4.getM_TanaageChienSongai()).add(outEntity4.getM_ThisChienSongai());
                    nyukinMeisai.setID_N_M_ChienSongai(PNCommonUtils.addComma(PNCommonUtils
                            .encNulltoZeroBig(bdChienSongai)));
                    // 　　　　・違約金：違約金を設定
                    nyukinMeisai.setID_N_M_Iyaku(PNCommonUtils.addComma(PNCommonUtils
                            .encNulltoZeroBig(outEntity4.getM_Iyaku())));
                    // 　　　　・転用違約金：転用違約金を設定
                    nyukinMeisai.setID_N_M_TenyoIyaku(outEntity4.getM_TenyoIyaku().toString());
                    // 　　　　・棚上遅延損害金：棚上遅延損害金を設定
                    nyukinMeisai
                            .setID_N_M_TanaageChienSongai(outEntity4.getM_TanaageChienSongai().toString());
                    // 　　　　・今回発生遅延損害金：今回発生遅延損害金を設定
                    nyukinMeisai.setID_N_M_ThisChienSongai(outEntity4.getM_ThisChienSongai().toString());
                    // 　　　　・区分：
                    // 　　　　　　代位弁済金納付区分が１（代弁納付）の場合、”代位弁済”を編集する。以外の場合、”充当”を編集する。
                    if (PNCommonComponents.cnvNulltoBlank(outEntity4.getKubun_DaibeNoufu()).equals("1")) {
                        nyukinMeisai.setID_N_Kubun_Nyukin(Se003Constants.KUBUN_NYUKIN_DAIBEN);
                    } else {
                        nyukinMeisai.setID_N_Kubun_Nyukin(Se003Constants.KUBUN_NYUKIN_JUTO);
                    }
                    // 　　　　・払込年月日：払込年月日を設定
                    nyukinMeisai.setID_N_Date_Haraikomi(outEntity4.getDate_Haraikomi());
                    outDTONyukinList.add(nyukinMeisai);
                }

            }
            // 払込明細に対する入金情報をテーブルへ設定
            se003_02M2DTO.setTbl_se003_02M2DTO(outDTONyukinList);
            haraikomiLIST.add(se003_02M2DTO);

        }

        outDto.setMEISAI_HaraikomiLIST(haraikomiLIST);

        // メッセージ編集
        String strMsgHead0 = "";
        String strMsgHead1 = "";
        String strMsgHead2 = "";
        String strMsgHead3 = "";

        // ①実行日
        String jikko = "";
        // ②償還期限年月日
        String shokan = "";
        // ③特利有効年月日
        String tokuri = "";

        // 　（１）条変起案中のメッセージ編集
        // 　　扱店別稟議データ「条変起案中区分」＝９の場合、メッセージ（PN_SE003_11_00)のメッセージを取得する。
        if (PNCommonComponents.cnvNulltoBlank(outEntity.getKubun_JohenKianchu()).equals(
                Se003Constants.STR_NINE)) {
            strMsgHead0 = PNCommonComponents.concatString(
                    PNMessageUtils.getString(PNCommonMessageConstants.PM3560E), Se003Constants.CODE_KAIGYO);
        }

        // 　（２）特利区分によるメッセージ編集
        // 　　扱店別稟議データ「特利区分」＝９又は８の場合、以下の条件にてメッセージを編集する。
        if (PNCommonComponents.cnvNulltoBlank(outEntity.getKubun_Tokuri()).equals(Se003Constants.STR_EIGHT)
                || PNCommonComponents.cnvNulltoBlank(outEntity.getKubun_Tokuri()).equals(
                        Se003Constants.STR_NINE)) {

            // 　　①実行日を編集する。
            // 　　　　扱店別稟議データ「実行年月日」を　yyyy.m.d　形式で編集する。
            jikko = outEntity.getDate_Jikko();

            // 　　②償還期限年月日を編集する。
            // 　　　　扱店別稟議データ「償還期限（年月）」＋扱店別稟議データ「元利金払込月日」の日付
            String ganrikinHaraiKomi = outEntity.getDate_GanrikinHaraiKomi();
            if (null == ganrikinHaraiKomi || "".equals(ganrikinHaraiKomi)) {
                shokan = PNCommonComponents.concatString(outEntity.getDate_ShokanKigen(), "");
            } else {
                shokan = PNCommonComponents.concatString(outEntity.getDate_ShokanKigen(),
                        ganrikinHaraiKomi.substring(2));
            }

            // 　　③特利有効年月日を編集する。（但し、扱店別稟議データ「特利有効年月日」データが無い場合、空文字を編集する）
            // 　　　　償還期限年月日＞扱店別稟議データ「特利有効年月日」の場合、特利有効年月日を扱店別稟議データ「特利有効年月日」とする。
            // 　　　　上記以外の場合、特利有効年月日を償還期限年月日とする。
            // 　　　　取得した特利有効年月日を yyyy.m.d 形式で編集する。
            if (null != outEntity.getDate_TokuriYuko()) {
                if (0 < shokan.compareTo(outEntity.getDate_TokuriYuko())) {
                    tokuri = outEntity.getDate_TokuriYuko();
                } else {
                    tokuri = shokan;
                }
            }

            // 　　④①～③を元にメッセージを編集する。
            // 　　　※１　本メッセージは、「①」＋エラーコード（PTN_SE000_001）を結合して編集する。
            strMsgHead1 = PNCommonComponents.concatString("①",
                    PNMessageUtils.getString(PNCommonMessageConstants.PM3500E), Se003Constants.CODE_KAIGYO);

            // 　　　※２　本メッセージは、「②本案件の利子助成対象期間は」＋日付※３＋「～」＋日付※４＋「です。」を
            if (null != tokuri && false == "".equals(tokuri) && 8 == tokuri.length()) {
                strMsgHead2 = PNCommonComponents.concatString("②本案件の利子助成対象期間は",
                        PNCommonComponents.dateFmtAD_YYYYMMDD(jikko), "～",
                        PNCommonComponents.dateFmtAD_YYYYMMDD(tokuri), "です。", Se003Constants.CODE_KAIGYO);
            } else if (null != tokuri && false == "".equals(tokuri) && 6 == tokuri.length()) {
                strMsgHead2 = PNCommonComponents.concatString("②本案件の利子助成対象期間は",
                        PNCommonComponents.dateFmtAD_YYYYMMDD(jikko), "～",
                        PNCommonComponents.dateFmtAD_YYYYMM(tokuri), "です。", Se003Constants.CODE_KAIGYO);
            }

            // 　　　※３　実行日を編集する。　　　　　　　　(例）　「・・期間は2015.1.10～2015.10.1です。」
            // 　　　※４　特利有効年月日を編集する。

            // 　（３）償還方法コードによるメッセージ編集（扱店別稟議データ「償還方法コード」の１文字目が１の場合のみ行う）
            if (PNCommonComponents.cnvNulltoBlank(outEntity.getCode_ShokanHouhou()).substring(0, 1)
                    .equals("1")) {

                // 　　　償還期限年月日（（２）②の日付）＞扱店別稟議データ「特利有効年月日」の場合
                if (0 < shokan.compareTo(PNCommonComponents.cnvNulltoBlank(outEntity.getDate_TokuriYuko()))) {
                    // 　　　「③元利均等額は利子助成対象期間経過後のものです」を編集する。（※１）
                    // 　　　　※１　本メッセージは、「③」＋エラーコード（PTN_SE000_003）を結合して編集する
                    strMsgHead3 = PNCommonComponents.concatString("③",
                            PNMessageUtils.getString(PNCommonMessageConstants.PM3520E),
                            Se003Constants.CODE_KAIGYO);
                } else {
                    // 　　　　※２　本メッセージは、「③」＋エラーコード（PTN_SE000_004）を結合して編集する。
                    // 　　　上記以外の場合、「③元利均等額は利子助成前の利率で計算した金額になっています。」を編集する。（※２）
                    strMsgHead3 = PNCommonComponents.concatString("③",
                            PNMessageUtils.getString(PNCommonMessageConstants.PM3530E),
                            Se003Constants.CODE_KAIGYO);
                }

            }

        }

        // 　（４）メッセージ表示設定
        // 　　（１）～（３）で編集したメッセージをメッセージエリアに表示する。（最大で４行のメッセージ
        outDto.setLblError(PNCommonComponents
                .concatString(strMsgHead0, strMsgHead1, strMsgHead2, strMsgHead3));

        return outDto;
    }
}
