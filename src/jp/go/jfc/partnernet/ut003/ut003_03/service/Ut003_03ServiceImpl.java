//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Ut003_03Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/10/02 | 譚　暁玉              | 新規作成
// 2.0.0   | 2019/01/11 | 林　晃平              | 農林PN元号対応
//==================================================================================================
package jp.go.jfc.partnernet.ut003.ut003_03.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jp.go.jfc.partnernet.common.PNCommonMessageConstants;
import jp.go.jfc.partnernet.common.dao.KinrijyohoDAO;
import jp.go.jfc.partnernet.common.dao.KinrijyohoEntity;
import jp.go.jfc.partnernet.pnfw.common.PNFormatUtils;
import jp.go.jfc.partnernet.pnfw.common.PNJpCalendarUtils;
import jp.go.jfc.partnernet.pnfw.exception.PNServiceException;
import jp.go.jfc.partnernet.pnfw.exception.PNSystemException;
import jp.go.jfc.partnernet.pnfw.service.PNBaseService;
import jp.go.jfc.partnernet.ut003.ut003_03.dao.Ut003_03GetResultDataDAO;
import jp.go.jfc.partnernet.ut003.ut003_03.dao.Ut003_03GetResultDataEntity;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.fujitsu.crust.common.CFWBeanUtils;
import com.fujitsu.crust.dao.exception.CFWFindParameterException;
import com.fujitsu.crust.dao.exception.CFWForUpdateException;

/**
 * <pre>
 * このクラスはut003_03のサービスクラスです。
 * </pre>
 *
 * @author 林　晃平
 * @version 2.0.0
 */
public class Ut003_03ServiceImpl extends PNBaseService implements Ut003_03Service {

    /** Logger */
    private static Log log = LogFactory.getLog(Ut003_03ServiceImpl.class);

    /** ut003_03getresultdatadao */
    @Autowired
    private Ut003_03GetResultDataDAO ut003_03getresultdatadao;

    /** kinrijyohodao */
    @Autowired
    private KinrijyohoDAO kinrijyohodao;

    /** PNJpCalendarUtils */
    @Autowired
    PNJpCalendarUtils jpCalendarUtils;

    /**
     * Ut003_03ServiceのgetHitCount
     *
     * @param inDto Ut003_03DTO
     * @return Ut003_03DTO
     */
    @Override
    public Ut003_03DTO getHitCount(Ut003_03DTO inDto) {

        Ut003_03DTO outDto = new Ut003_03DTO();

        // 受渡情報の取得
        Ut003_03GetResultDataEntity inEntity = new Ut003_03GetResultDataEntity();

        // 全体件数の取得
        // 　複数テーブルアクセス定義の「Ut003_03GetResultsDataDAO」を参照し、条件を設定する。
        // 　H(固定)+和暦→西暦に変換する。
        // 　検索開始/終了年月日の値を設定する。
        // Ut003_03GetResultsDataDAO.countByCondition
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
        long hitCount = ut003_03getresultdatadao.countByCondition(inEntity);

        // 検索結果を取得(Entity→DTOに設定)
        // 　・取得件数を設定する。
        outDto.setKinrijyohoHitCount(new Long(hitCount).intValue());

        return outDto;
    }

    /**
     * Ut003_03ServiceのgetResultData
     *
     * @param inDto Ut003_03DTO
     * @return Ut003_03DTO
     */
    @Override
    public Ut003_03DTO getResultData(Ut003_03DTO inDto) {

        Ut003_03DTO outDto = new Ut003_03DTO();

        // 受渡情報の取得
        Ut003_03GetResultDataEntity inEntity = new Ut003_03GetResultDataEntity();
        List<Ut003_03GetResultDataEntity> resultEntityList = new ArrayList<Ut003_03GetResultDataEntity>();

        // 該当ページのデータを取得する。
        // 　複数テーブルアクセス定義の「Ut003_03GetResultsDataDAO」を参照し、条件を設定する。
        // 　H(固定)+和暦→西暦に変換する。
        // 　検索開始/終了年月日の値を設定する。
        // Ut003_03GetResultsDataDAO.findByCondition(Entity,offset,limit)
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
        resultEntityList = ut003_03getresultdatadao.findByCondition(inEntity, inDto.getOffset(),
                inDto.getLength());

        // 検索結果を取得(Entity→DTOに設定)
        // 　・明細項目（Ｍ１）を一覧取得件数分設定する。
        List<Ut003_03M1DTO> outKinrijyohoList = new ArrayList<Ut003_03M1DTO>(resultEntityList.size());
        for (Ut003_03GetResultDataEntity entity : resultEntityList) {
            Ut003_03M1DTO outKinrijyoho = new Ut003_03M1DTO();
            CFWBeanUtils.copyProperties(outKinrijyoho, entity);
            outKinrijyohoList.add(outKinrijyoho);
        }

        outDto.setKinriJyohoList(outKinrijyohoList);

        return outDto;
    }

    /**
     * Ut003_03Serviceのdelete
     *
     * @param inDto Ut003_03DTO
     * @return Ut003_03DTO
     */
    @Override
    public Ut003_03DTO delete(Ut003_03DTO inDto) {

        Ut003_03DTO outDto = new Ut003_03DTO();

        // 金利改定情報テーブルを削除する
        // 　単テーブルアクセス定義の「KinriJyohoDAO」排他読込を参照し、条件を設定する。

        // KinriJyohoDAO.findByPrimaryKeyForUpdate
        // KinriJyohoEntity inEntity = new KinriJyohoEntity();
        // try {
        // KinriJyohoEntity outEntity = kinrijyohodao.findByPrimaryKeyForUpdate(inEntity);
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

        KinrijyohoEntity inEntity = new KinrijyohoEntity();
        inEntity.setID_Data(new BigDecimal(inDto.geKinriJyoho().getID_Data()));
        try {
            kinrijyohodao.findByPrimaryKeyForUpdate(inEntity);
        } catch (CFWForUpdateException e) {
            // ・業務エラー：PNServiceException
            // ・メッセージ：PM9020E : 他のユーザによってデータが更新されています。しばらく時間をおいてから操作してください。
            throw new PNServiceException(PNCommonMessageConstants.PM9020E, e);
        } catch (CFWFindParameterException e) {
            log.error("金利改定情報テーブル削除前の排他読み込みにてエラーが発生");
            throw new PNSystemException(e);
        }

        // KinrijyohoDAO.delete
        try {
            kinrijyohodao.delete(inEntity);
        } catch (CFWFindParameterException e) {
            log.error("金利改定情報テーブルの削除処理にてエラーが発生");
            throw new PNSystemException(e);
        }

        return outDto;
    }

}