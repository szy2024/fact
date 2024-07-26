//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Ut002_01Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/14 | 譚　暁玉            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.ut002.ut002_01.service;

import java.math.BigDecimal;

import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.common.PNCommonDBComponents;
import jp.go.jfc.partnernet.common.PNCommonMessageConstants;
import jp.go.jfc.partnernet.common.dao.NewsDAO;
import jp.go.jfc.partnernet.common.dao.NewsEntity;
import jp.go.jfc.partnernet.pnfw.common.PNDateUtils;
import jp.go.jfc.partnernet.pnfw.dao.exception.PNForUpdateException;
import jp.go.jfc.partnernet.pnfw.exception.PNServiceException;
import jp.go.jfc.partnernet.pnfw.exception.PNSystemException;
import jp.go.jfc.partnernet.pnfw.service.PNBaseService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <pre>
 * このクラスはut002_01のサービスクラスです。
 * </pre>
 *
 * @author 譚　暁玉
 * @version 1.0.0
 */
public class Ut002_01ServiceImpl extends PNBaseService implements Ut002_01Service {

    /** Logger */
    private final Log log = LogFactory.getLog(Ut002_01ServiceImpl.class);

    @Autowired
    private NewsDAO newsDao;

    /** PNCommonDBComponent */
    @Autowired
    PNCommonDBComponents pnCommonDBComponents;

    /**
     * Ut002_01ServiceのgetNews
     *
     * @param inDto Ut002_01DTO
     * @return Ut002_01DTO
     */
    @Override
    public Ut002_01DTO getNews(Ut002_01DTO inDto) {

        Ut002_01DTO outDto = new Ut002_01DTO();

        NewsEntity inEntity = new NewsEntity();
        inEntity.setID_InfoType(new BigDecimal(inDto.getDrpID_ID_InfoType()));
        NewsEntity outEntity = null;
        try {

            outEntity = newsDao.findByPrimaryKey(inEntity);

        } catch (Exception e) {
            // その他エラーはシステムエラー
            log.error(e.getMessage());
            throw new PNSystemException(PNCommonMessageConstants.PM9990E, e);
        }

        if (outEntity == null) {
            // 該当がない場合
            outDto.setTxtID_ID_InfoContents("");
            outDto.setDateTime_InfoUpdate(null);
            outDto.setDateTime_Update(null);
        } else {
            // 該当がある場合
            outDto.setTxtID_ID_InfoContents(outEntity.getID_InfoContents());
            outDto.setDateTime_InfoUpdate(outEntity.getDateTime_InfoUpdate());
            outDto.setDateTime_Update(outEntity.getDateTime_Update());
        }

        return outDto;
    }

    /**
     * Ut002_01ServiceのupdateNews
     *
     * @param inDto Ut002_01DTO
     * @return Ut002_01DTO
     */
    @Override
    public Ut002_01DTO updateNews(Ut002_01DTO inDto) {

        Ut002_01DTO outDto = new Ut002_01DTO();

        // 業務日付の取得（共通部品）
        String gyomuYmd = pnCommonDBComponents.getPNBusinessDay(PNCommonConstants.KUBUN_PN_ONLINE);

        // NewsEntityに検索条件を設定
        NewsEntity inEntity = new NewsEntity();
        inEntity.setID_InfoType(new BigDecimal(inDto.getDrpID_ID_InfoType()));

        // お知らせデータの排他読込
        NewsEntity newsEntity = null;
        try {
            newsEntity = newsDao.findByPrimaryKeyForUpdate(inEntity);
        } catch (PNForUpdateException e) {
            log.error("排他エラー", e);
            throw new PNServiceException(PNCommonMessageConstants.PM9020E, e);
        } catch (Exception e) {
            log.error("その他ＤＢエラー", e);
            throw new PNSystemException(PNCommonMessageConstants.PM9990E, e);
        }

        // 該当有無の判定
        if (newsEntity != null) {

            // 　　該当ありの場合
            newsEntity.setID_InfoContents(inDto.getTxtID_ID_InfoContents());
            if ("".equals(inDto.getTxtID_ID_InfoContents())) {
                // お知らせ内容がブランクの場合はnull値で登録日付を更新する。
                newsEntity.setDateTime_InfoUpdate(null);
            } else {
                // お知らせ内容がブランク以外の場合は業務日付で登録日付を更新する。
                newsEntity.setDateTime_InfoUpdate(PNDateUtils.toSqlDate(PNDateUtils.toDate(gyomuYmd,
                        PNDateUtils.DATE_PATTERN_YYYYMMDD)));
            }
            // NewsDAO.update
            try {
                newsDao.update(newsEntity);
            } catch (Exception e) {
                log.error("お知らせデータの更新に失敗しました。", e);
                throw new PNSystemException(PNCommonMessageConstants.PM9990E, e);
            }

        } else {

            // 　　該当なしの場合
            newsEntity = new NewsEntity();
            newsEntity.setID_InfoType(new BigDecimal(inDto.getDrpID_ID_InfoType()));
            newsEntity.setID_InfoContents(inDto.getTxtID_ID_InfoContents());
            if ("".equals(inDto.getTxtID_ID_InfoContents())) {
                // お知らせ内容がブランクの場合はnull値で登録日付を更新する。
                newsEntity.setDateTime_InfoUpdate(null);
            } else {
                // お知らせ内容がブランク以外の場合は業務日付で登録日付を更新する。
                newsEntity.setDateTime_InfoUpdate(PNDateUtils.toSqlDate(PNDateUtils.toDate(gyomuYmd,
                        PNDateUtils.DATE_PATTERN_YYYYMMDD)));
            }
            // NewsDAO.insert
            try {
                newsDao.insert(newsEntity);
            } catch (Exception e) {
                log.error("お知らせデータの登録に失敗しました。", e);
                throw new PNSystemException(PNCommonMessageConstants.PM9990E, e);
            }

        }

        // 返却値設定
        outDto.setDrpID_ID_InfoType(newsEntity.getID_InfoType().intValue());
        outDto.setTxtID_ID_InfoContents(newsEntity.getID_InfoContents());
        outDto.setDateTime_InfoUpdate(newsEntity.getDateTime_InfoUpdate());
        outDto.setDateTime_Update(newsEntity.getDateTime_Update());

        // 呼出し元への復帰
        return outDto;

    }
}