//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr006_01Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/24 | 田旗　秀樹            | 新規作成
// 2.0.0   | 2017/11/30 | 林　晃平              | 委託貸付報告等における機能改善対応
//==================================================================================================
package jp.go.jfc.partnernet.cr006.cr006_01.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import jp.go.jfc.partnernet.common.PNCommonComponents;
import jp.go.jfc.partnernet.common.PNCommonUtils;
import jp.go.jfc.partnernet.cr006.common.Cr006Constants;
import jp.go.jfc.partnernet.cr006.cr006_01.dao.Cr006_01ReportDataDAO;
import jp.go.jfc.partnernet.cr006.cr006_01.dao.Cr006_01ReportDataEntity;
import jp.go.jfc.partnernet.cr006.cr006_01.dao.Cr006_01YushiBangoDAO;
import jp.go.jfc.partnernet.cr006.cr006_01.dao.Cr006_01YushiBangoEntity;
import jp.go.jfc.partnernet.pnfw.common.PNCommonInfo;
import jp.go.jfc.partnernet.pnfw.common.PNCommonInfoHolder;
import jp.go.jfc.partnernet.pnfw.common.PNMessageInfo;
import jp.go.jfc.partnernet.pnfw.service.PNBaseService;

import org.springframework.beans.factory.annotation.Autowired;

import com.fujitsu.crust.common.CFWBeanUtils;

/**
 * <pre>
 * このクラスはCr006_01のサービスクラスです。
 * </pre>
 *
 * @author 林　晃平
 * @version 2.0.0
 */
public class Cr006_01ServiceImpl extends PNBaseService implements Cr006_01Service {

    /** cr006_01reportdatadao */
    @Autowired
    private Cr006_01ReportDataDAO cr006_01reportdatadao;

    /** cr006_01yushibangodao */
    @Autowired
    private Cr006_01YushiBangoDAO cr006_01yushibangodao;

    /** エラーリスト */
    LinkedList<PNMessageInfo> bizErrors = new LinkedList<PNMessageInfo>();

    /**
     * Cr006_01ServiceのgetReportData
     *
     * @param inDto Cr006_01DTO
     * @return Cr006_01DTO
     */
    @Override
    public Cr006_01DTO getReportData(Cr006_01DTO inDto) {

        // 受渡情報の取得
        // 報告対象一覧明細エリア初期化
        Cr006_01DTO outDto = new Cr006_01DTO();
        Cr006_01ReportDataEntity inEntity = new Cr006_01ReportDataEntity();

        // エラーリスト初期化
        bizErrors.clear();

        // DTO⇒Entityに転記
        CFWBeanUtils.copyProperties(inEntity, inDto);

        // 立替金受入・充当報告書作成ビューにて報告対象一覧を収集
        // 複数テーブルアクセス定義の「Cr006_01ReportDataDAO」を参照し、条件を設定する。
        // 入力引数の扱店コード
        String code_Organization = "";
        PNCommonInfo commonInfo = PNCommonInfoHolder.getCommonInfo();
        if (null != commonInfo) {
            code_Organization = commonInfo.getCode_Organization();
        }
        // 抽出条件設定
        inEntity.setCode_Organization(code_Organization);

        // DAOを呼出し、対象データを抽出する。
        List<Cr006_01ReportDataEntity> outEntityList = cr006_01reportdatadao.findByCondition(inEntity);

        // 取得結果の判定
        // 抽出結果件数をDTO項目に設定
        // 抽出結果件数が１件以上の場合、DTO項目を更新
        List<Cr006_01M1DTO> reportHistoryList = new ArrayList<Cr006_01M1DTO>(outEntityList.size());
        int i = 0;
        for (Cr006_01ReportDataEntity outEntity : outEntityList) {

            Cr006_01M1DTO reportHistory = new Cr006_01M1DTO();

            // Cr006_01DTO.顧客名
            reportHistory.setID_Name_Customer(outEntity.getName_Customer());
            // Cr006_01DTO.立替日
            reportHistory.setID_Date_Karibarai(outEntity.getDate_Karibarai());

            // Cr006_01DTO.立替金の種類
            String strKanjoKamokuCode = replaceKanjoKamoku(outEntity);
            reportHistory.setID_Code_KanjoKamoku(strKanjoKamokuCode);

            // Cr006_01DTO.公庫立替金額(円)
            reportHistory.setID_M_ToshoKaribarai(PNCommonUtils.addComma(outEntity.getM_ToshoKaribarai()));
            // Cr006_01DTO.現在の立替金残高(円)
            reportHistory.setID_M_KaribaraiZanAfterSeisan(PNCommonUtils.addComma(outEntity
                    .getM_KaribaraiZanAfterSeisan()));
            // Cr006_01DTO.公庫支店
            reportHistory.setID_Code_KoukoShiten(outEntity.getCode_ShokanHonShiten());
            // Cr006_01DTO.扱店
            reportHistory.setID_Code_Organization(outEntity.getCode_Organization());
            // Cr006_01DTO.店舗
            reportHistory.setID_Code_Tenpo(outEntity.getCode_Tenpo());
            // Cr006_01DTO.年度
            reportHistory.setID_Year(PNCommonComponents.cnvNulltoBlank(outEntity.getYear()));
            // Cr006_01DTO.方式資金
            String strHoshikiShikin = PNCommonComponents.concatString(
                    PNCommonComponents.cnvNulltoBlank(outEntity.getKubun_Hoshiki()),
                    PNCommonComponents.cnvNulltoBlank(outEntity.getKubun_Shikin()));
            reportHistory.setID_Code_HoshikiShikin(PNCommonComponents.cnvNulltoBlank(strHoshikiShikin));
            // Cr006_01DTO.番号
            reportHistory.setID_ID_Ringi(outEntity.getID_Ringi());
            // Cr006_01DTO.枝番
            reportHistory.setID_ID_RingiBranch(outEntity.getID_RingiBranch());
            // Cr006_01DTO.貸付先コード
            reportHistory.setID_Code_Customer(outEntity.getID_Code_Customer());
            // Cr006_01DTO.債権管理番号
            reportHistory.setID_ID_Credit(outEntity.getID_Credit());
            // Cr006_01DTO.本支店コード
            reportHistory.setID_Code_HonShiten(outEntity.getCode_HonShiten());
            // Cr006_01DTO.仮受仮払番号
            reportHistory.setID_ID_Karibarai(outEntity.getID_Karibarai());
            // Cr006_01DTO.仮受仮払勘定科目コード
            reportHistory.setCode_KanjoKamoku(outEntity.getCode_KanjoKamoku());
            // Cr006_01DTO.Index（行番号）
            reportHistory.setArrayListIndex(Integer.toString(i++));

            // 明細に追加
            reportHistoryList.add(reportHistory);

        }

        // DTOにセット
        outDto.setReportList(reportHistoryList);

        // 返却
        return outDto;
    }

    /**
     * Cr006_01ServiceのgetYushiBango
     *
     * @param inDto Cr006_01DTO
     * @return Cr006_01DTO
     */
    @Override
    public Cr006_01DTO getYushiBango(Cr006_01DTO inDto) {

        Cr006_01DTO outDto = new Cr006_01DTO();

        // 扱店別稟議データにて融資番号を取得
        // 　　複数テーブルアクセス定義の「Cr006_01YushiBangoDAO」を参照し、条件を設定する。
        Cr006_01YushiBangoEntity inEntity = new Cr006_01YushiBangoEntity();
        // 貸付先コード
        inEntity.setCode_Customer(inDto.getID_Code_Customer());
        // 公庫支店
        inEntity.setCode_KoukoShiten(inDto.getID_Code_KoukoShiten());
        // 扱店
        inEntity.setCode_Organization(inDto.getID_Code_Organization());
        // 店舗
        inEntity.setCode_Tenpo(inDto.getID_Code_Tenpo());
        List<Cr006_01YushiBangoEntity> outEntityList = cr006_01yushibangodao.findByCondition(inEntity);

        // 　　取得結果の判定
        // 　　　　抽出結果件数が１件以上の場合、１件目のデータをDTO項目に設定
        if (outEntityList != null && !outEntityList.isEmpty()) {

            // Cr006_01YushiBangoEntity.債権管理番号 ⇒ Cr006_01DTO.債権管理番号
            outDto.setID_ID_Credit(outEntityList.get(0).getID_Credit());
            // Cr006_01YushiBangoEntity.年度 ⇒ Cr006_01DTO.年度
            outDto.setID_Year(outEntityList.get(0).getYear());
            // Cr006_01YushiBangoEntity.方式区分＋Cr006_01YushiBangoEntity.資金区分 ⇒ Cr006_01DTO.方式資金
            outDto.setID_Code_HoshikiShikin(PNCommonComponents.concatString(
                    PNCommonComponents.cnvNulltoBlank(outEntityList.get(0).getKubun_Hoshiki()),
                    PNCommonComponents.cnvNulltoBlank(outEntityList.get(0).getKubun_Shikin())));
            // Cr006_01YushiBangoEntity.稟議番号 ⇒ Cr006_01DTO.番号
            outDto.setID_ID_Ringi(outEntityList.get(0).getID_Ringi());
            // Cr006_01YushiBangoEntity.稟議番号枝番 ⇒ Cr006_01DTO.枝番
            outDto.setID_ID_RingiBranch(outEntityList.get(0).getID_RingiBranch());

        }

        return outDto;
    }

    private String replaceKanjoKamoku(Cr006_01ReportDataEntity outEntity) {

        String strKjkmkCd = outEntity.getCode_KanjoKamoku();
        // 勘定科目一覧作成
        Map<String, Object> mpKjkmk = new HashMap<String, Object>(211);
        mpKjkmk.put(Cr006Constants.CODE_KANJOKAMOKU_108010101, "1");
        mpKjkmk.put(Cr006Constants.CODE_KANJOKAMOKU_108010103, "1");
        mpKjkmk.put(Cr006Constants.CODE_KANJOKAMOKU_108010105, "1");
        mpKjkmk.put(Cr006Constants.CODE_KANJOKAMOKU_108010106, "1");
        mpKjkmk.put(Cr006Constants.CODE_KANJOKAMOKU_108010108, "1");
        mpKjkmk.put(Cr006Constants.CODE_KANJOKAMOKU_108010110, "1");
        mpKjkmk.put(Cr006Constants.CODE_KANJOKAMOKU_108010201, "2");
        mpKjkmk.put(Cr006Constants.CODE_KANJOKAMOKU_108010301, "3");

        return (String)mpKjkmk.get(strKjkmkCd);

    }

}