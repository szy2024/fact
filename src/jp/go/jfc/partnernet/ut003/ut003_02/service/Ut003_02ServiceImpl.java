//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Ut003_02Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/10/02 | 譚　暁玉              | 新規作成
// 2.0.0   | 2019/01/11 | 林　晃平              | 農林PN元号対応
//==================================================================================================
package jp.go.jfc.partnernet.ut003.ut003_02.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jp.go.jfc.partnernet.common.PNCommonMessageConstants;
import jp.go.jfc.partnernet.common.dao.TsuchijimuDAO;
import jp.go.jfc.partnernet.common.dao.TsuchijimuEntity;
import jp.go.jfc.partnernet.pnfw.common.PNFormatUtils;
import jp.go.jfc.partnernet.pnfw.common.PNJpCalendarUtils;
import jp.go.jfc.partnernet.pnfw.exception.PNServiceException;
import jp.go.jfc.partnernet.pnfw.exception.PNSystemException;
import jp.go.jfc.partnernet.pnfw.service.PNBaseService;
import jp.go.jfc.partnernet.ut003.ut003_02.dao.Ut003_02GetResultDataDAO;
import jp.go.jfc.partnernet.ut003.ut003_02.dao.Ut003_02GetResultDataEntity;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.fujitsu.crust.common.CFWBeanUtils;
import com.fujitsu.crust.dao.exception.CFWFindParameterException;
import com.fujitsu.crust.dao.exception.CFWForUpdateException;

/**
 * <pre>
 * このクラスはut003_02のサービスクラスです。
 * </pre>
 *
 * @author 林　晃平
 * @version 2.0.0
 */
public class Ut003_02ServiceImpl extends PNBaseService implements Ut003_02Service {

    /** Logger */
    private static Log log = LogFactory.getLog(Ut003_02ServiceImpl.class);

    /** ut003_02getresultdatadao */
    @Autowired
    private Ut003_02GetResultDataDAO ut003_02getresultdatadao;

    /** tsuchijimudao */
    @Autowired
    private TsuchijimuDAO tsuchijimudao;

    /** PNJpCalendarUtils */
    @Autowired
    PNJpCalendarUtils jpCalendarUtils;

    /**
     * Ut003_02ServiceのgetHitCount
     *
     * @param inDto Ut003_02DTO
     * @return Ut003_02DTO
     */
    @Override
    public Ut003_02DTO getHitCount(Ut003_02DTO inDto) {

        Ut003_02DTO outDto = new Ut003_02DTO();

        // 受渡情報の取得
        Ut003_02GetResultDataEntity inEntity = new Ut003_02GetResultDataEntity();

        // 全体件数の取得
        // 　複数テーブルアクセス定義の「Ut003_02GetResultsDataDAO」を参照し、条件を設定する。
        // 　H(固定)+和暦→西暦に変換する。
        // 　検索開始/終了年月日の値を設定する。
        // Ut003_02GetResultsDataDAO.countByCondition
// [UPD] Ver 2.0.0 - START
//        String searchStartDate = jpCalendarUtils.toSeireki(Ut003Constants.GENGO_HEISEI,
//                inDto.getID_SearchStartYear(),
//                PNFormatUtils.toZeroPadding(inDto.getID_SearchStartMonth(), 2),
//                PNFormatUtils.toZeroPadding(inDto.getID_SearchStartDate(), 2));
        String searchStartDate = jpCalendarUtils.toSeireki(inDto.getID_SearchStartGengo(),
                inDto.getID_SearchStartYear(),
                PNFormatUtils.toZeroPadding(inDto.getID_SearchStartMonth(), 2),
                PNFormatUtils.toZeroPadding(inDto.getID_SearchStartDate(), 2));
// [UPD] Ver 2.0.0 - END
// [UPD] Ver 2.0.0 - START
//        String searchEndDate = jpCalendarUtils.toSeireki(Ut003Constants.GENGO_HEISEI,
//                inDto.getID_SearchEndYear(), PNFormatUtils.toZeroPadding(inDto.getID_SearchEndMonth(), 2),
//                PNFormatUtils.toZeroPadding(inDto.getID_SearchEndDate(), 2));
        String searchEndDate = jpCalendarUtils.toSeireki(inDto.getID_SearchEndGengo(),
                inDto.getID_SearchEndYear(),
                PNFormatUtils.toZeroPadding(inDto.getID_SearchEndMonth(), 2),
                PNFormatUtils.toZeroPadding(inDto.getID_SearchEndDate(), 2));
// [UPD] Ver 2.0.0 - END
        inEntity.setID_SearchStartDate(searchStartDate);
        inEntity.setID_SearchEndDate(searchEndDate);
        long hitCount = ut003_02getresultdatadao.countByCondition(inEntity);

        // 検索結果を取得(Entity→DTOに設定)
        // 　・取得件数を設定する。
        outDto.setTsuchijimuHitCount(new Long(hitCount).intValue());

        return outDto;
    }

    /**
     * Ut003_02ServiceのgetResultData
     *
     * @param inDto Ut003_02DTO
     * @return Ut003_02DTO
     */
    @Override
    public Ut003_02DTO getResultData(Ut003_02DTO inDto) {

        Ut003_02DTO outDto = new Ut003_02DTO();

        // 受渡情報の取得
        Ut003_02GetResultDataEntity inEntity = new Ut003_02GetResultDataEntity();
        List<Ut003_02GetResultDataEntity> resultEntityList = new ArrayList<Ut003_02GetResultDataEntity>();

        // 該当ページのデータを取得する。
        // 　複数テーブルアクセス定義の「Ut003_02GetResultsDataDAO」を参照し、条件を設定する。
        // 　H(固定)+和暦→西暦に変換する。
        // 　検索開始/終了年月日の値を設定する。
        // Ut003_02GetResultsDataDAO.findByCondition(Entity,offset,limit)
// [UPD] Ver 2.0.0 - START
//        String searchStartDate = jpCalendarUtils.toSeireki(Ut003Constants.GENGO_HEISEI,
//                inDto.getID_SearchStartYear(),
//                PNFormatUtils.toZeroPadding(inDto.getID_SearchStartMonth(), 2),
//                PNFormatUtils.toZeroPadding(inDto.getID_SearchStartDate(), 2));
        String searchStartDate = jpCalendarUtils.toSeireki(inDto.getID_SearchStartGengo(),
                inDto.getID_SearchStartYear(),
                PNFormatUtils.toZeroPadding(inDto.getID_SearchStartMonth(), 2),
                PNFormatUtils.toZeroPadding(inDto.getID_SearchStartDate(), 2));
// [UPD] Ver 2.0.0 - END
// [UPD] Ver 2.0.0 - START
//        String searchEndDate = jpCalendarUtils.toSeireki(Ut003Constants.GENGO_HEISEI,
//                inDto.getID_SearchEndYear(), PNFormatUtils.toZeroPadding(inDto.getID_SearchEndMonth(), 2),
//                PNFormatUtils.toZeroPadding(inDto.getID_SearchEndDate(), 2));
        String searchEndDate = jpCalendarUtils.toSeireki(inDto.getID_SearchEndGengo(),
                inDto.getID_SearchEndYear(),
                PNFormatUtils.toZeroPadding(inDto.getID_SearchEndMonth(), 2),
                PNFormatUtils.toZeroPadding(inDto.getID_SearchEndDate(), 2));
// [UPD] Ver 2.0.0 - END
        inEntity.setID_SearchStartDate(searchStartDate);
        inEntity.setID_SearchEndDate(searchEndDate);
        resultEntityList = ut003_02getresultdatadao.findByCondition(inEntity, inDto.getOffset(),
                inDto.getLength());

        // 検索結果を取得(Entity→DTOに設定)
        // 　・明細項目（Ｍ１）を一覧取得件数分設定する。
        List<Ut003_02M1DTO> outTuchijimuList = new ArrayList<Ut003_02M1DTO>(resultEntityList.size());
        for (Ut003_02GetResultDataEntity entity : resultEntityList) {
            Ut003_02M1DTO outTuchijimu = new Ut003_02M1DTO();
            CFWBeanUtils.copyProperties(outTuchijimu, entity);
            outTuchijimuList.add(outTuchijimu);
        }

        outDto.setTsuchiJimuRenrakuList(outTuchijimuList);

        return outDto;
    }

    /**
     * Ut003_02Serviceのdelete
     *
     * @param inDto Ut003_02DTO
     * @return Ut003_02DTO
     */
    @Override
    public Ut003_02DTO delete(Ut003_02DTO inDto) {

        Ut003_02DTO outDto = new Ut003_02DTO();

        // 通知・事務連絡情報テーブルを削除する
        // 　単テーブルアクセス定義の「TsuchiJimuDAO」排他読込を参照し、条件を設定する。

        // TsuchiJimuDAO.findByPrimaryKeyForUpdate
        // TsuchiJimuEntity inEntity = new TsuchiJimuEntity();
        // try {
        // TsuchiJimuEntity outEntity = tsuchijimudao.findByPrimaryKeyForUpdate(inEntity);
        //
        // if (outEntity == null) {
        // throw new PNServiceException(メッセージID ,new String[0]);
        // }
        // // すでに更新されているかチェック処理を記述
        //
        // } catch (CFWFindParameterException fpe) {
        // // 検索条件値エラー
        // throw new PNSystemException("検索に必要なパラメータが未設定です", fpe);
        //
        // } catch (CFWForUpdateException fue) {
        // // 排他エラー
        // throw new PNServiceException(メッセージID, new String[0], fue);
        //
        // }
        // 排他失敗の時、業務エラーとする。

        TsuchijimuEntity inEntity = new TsuchijimuEntity();
        inEntity.setID_Data(new BigDecimal(inDto.getTsuchiJimuRenraku().getID_Data()));
        try {
            tsuchijimudao.findByPrimaryKeyForUpdate(inEntity);
        } catch (CFWForUpdateException e) {
            // ・業務エラー：PNServiceException
            // ・メッセージ：PM9020E : 他のユーザによってデータが更新されています。しばらく時間をおいてから操作してください。
            throw new PNServiceException(PNCommonMessageConstants.PM9020E, e);
        } catch (CFWFindParameterException e) {
            log.error("通知・事務連絡情報テーブル削除前の排他読み込みにてエラーが発生");
            throw new PNSystemException(e);
        }

        // TsuchiJimuDAO.delete
        try {
            tsuchijimudao.delete(inEntity);
        } catch (CFWFindParameterException e) {
            log.error("通知・事務連絡情報テーブルの削除処理にてエラーが発生");
            throw new PNSystemException(e);
        }

        return outDto;
    }

}