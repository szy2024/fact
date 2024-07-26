//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Um001_01Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/28 | 秋澤　修司            | 新規作成
// 2.0.0   | 2017/10/06 | 林　晃平              | H29年追加開発案件対応
//==================================================================================================
package jp.go.jfc.partnernet.um001.um001_01.service;

import java.math.BigDecimal;
import java.sql.Timestamp;

import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.common.PNCommonMessageConstants;
import jp.go.jfc.partnernet.common.dao.PnUserDAO;
import jp.go.jfc.partnernet.common.dao.PnUserEntity;
import jp.go.jfc.partnernet.common.dao.TenpoDAO;
import jp.go.jfc.partnernet.common.dao.TenpoEntity;
import jp.go.jfc.partnernet.pnfw.common.PNDateUtils;
import jp.go.jfc.partnernet.pnfw.common.PNFormatUtils;
import jp.go.jfc.partnernet.pnfw.common.PNJpCalendarUtils;
import jp.go.jfc.partnernet.pnfw.exception.PNServiceException;
import jp.go.jfc.partnernet.pnfw.exception.PNSystemException;
import jp.go.jfc.partnernet.pnfw.service.PNBaseService;
import jp.go.jfc.partnernet.um001.common.Um001Constants;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.fujitsu.crust.common.CFWBeanUtils;
import com.fujitsu.crust.common.CFWPasswordUtil;
import com.fujitsu.crust.dao.exception.CFWDuplicateKeyException;

/**
 * <pre>
 * このクラスはUm001_01のサービスクラスです。
 * </pre>
 *
 * @author 林　晃平
 * @version 2.0.0
 */
public class Um001_01ServiceImpl extends PNBaseService implements Um001_01Service {

    /** Logger */
    private static final Log log = LogFactory.getLog(Um001_01ServiceImpl.class);

    /** CFWJpCalendarUtils */
    @Autowired
    PNJpCalendarUtils jpCalendarUtils;

    /** pnuserdao */
    @Autowired
    private PnUserDAO pnuserdao;

    /** tenpodao */
    @Autowired
    private TenpoDAO tenpodao;

    /**
     * Um001_01Serviceのregist
     *
     * @param inDto Um001_01DTO
     * @return Um001_01DTO
     */
    @Override
    public Um001_01DTO regist(Um001_01DTO inDto) {

        PnUserEntity pnUserEntity = new PnUserEntity();
        TenpoEntity tenpoEntity = new TenpoEntity();
        Um001_01DTO outDto = new Um001_01DTO();

        // 利用者ID重複チェック
        // DAOへのパラメータに検索条件を設定（PNUserEntity)
        // 　・DTO.利用者ID → 利用者ID

        // 単テーブルアクセス定義の「利用者データのNo1. 利用者登録件数取得」を実行し、登録件数を取得する。

        // 登録件数の判定
        // 　登録件数　＞　０　の場合、エラーとする。
        // 　業務エラー：PNServiceException
        // 　メッセージID：PM3010E : 入力された利用者IDは既に登録済みの為指定できません
        pnUserEntity.setLogonID(inDto.getLogonID());
        Long cntPnUser = pnuserdao.countByCondition(pnUserEntity);
        if (PNCommonConstants.RECORD_COUNT_ZERO < cntPnUser) {
            throw new PNServiceException(PNCommonMessageConstants.PM3010E);
        }

        // 扱店存在チェック。
        String roleCode = inDto.getRoleCode();

        // 権限種別が受託者 または 計数管理担当者 または Ｈ方式受託者 または 管理者 または 地方機構
        // または 系統受託者 または 系統Ｈ方式受託者の場合
        if (PNCommonConstants.ROLECODE_JUTAKUSHA.equals(roleCode)
                || PNCommonConstants.ROLECODE_KEISUUKANRITANTOUSHA.equals(roleCode)
                || PNCommonConstants.ROLECODE_HHOUSHIKIJUTAKUSHA.equals(roleCode)
                || PNCommonConstants.ROLECODE_KANRISHA.equals(roleCode)
                || PNCommonConstants.ROLECODE_CHIHOUKIKOU.equals(roleCode)
                || PNCommonConstants.ROLECODE_KEITOUJUTAKUSHA.equals(roleCode)
                || PNCommonConstants.ROLECODE_KEITOUHHOUSHIKIJUTAKUSHA.equals(roleCode)) {
            // DAOへのパラメータに検索条件を設定（TenpoEntity)
            // 　・DTO.扱店　→　機関コード

            // 単テーブルアクセス定義の「店舗のNo1.扱店登録件数取得」を実行し、登録件数を取得する。

            // 登録件数の確認
            // 　登録件数　＝　０　の場合、エラーとする。
            // 　業務エラー：PNServiceException
            // 　メッセージID：PM3390E : 指定された扱店コードは金融機関店舗マスターに存在しません
            tenpoEntity.setCode_Organization(inDto.getCode_Organization());
            Long cntTenpo = tenpodao.countByCondition(tenpoEntity);
            if (PNCommonConstants.RECORD_COUNT_ZERO == cntTenpo) {
                throw new PNServiceException(PNCommonMessageConstants.PM3390E);
            }

        }
        // 権限種別が農林中金（本店） または 農林中金（支店）の場合
        else if (PNCommonConstants.ROLECODE_NOURINHONTEN.equals(roleCode)
                || PNCommonConstants.ROLECODE_NOURINSHITEN.equals(roleCode)) {
            // DAOへのパラメータに検索条件を設定（TenpoEntity)
            // 権限種別が農林中金（本店）の場合
            if (PNCommonConstants.ROLECODE_NOURINHONTEN.equals(roleCode)) {
                // ・'958'　　 →　店舗コード
                inDto.setCode_Tenpo(Um001Constants.TENPO_CODE_NOURINHONTEN);
            }
            // 　・DTO.扱店　→　機関コード
            // 　・DTO.店舗　→　店舗コード
            tenpoEntity.setCode_Organization(inDto.getCode_Organization());
            tenpoEntity.setCode_Tenpo(inDto.getCode_Tenpo());

            // 単テーブルアクセス定義の「店舗のNo1.扱店登録件数取得」を実行し、登録件数を取得する。

            // 登録件数の確認
            // 　登録件数　＝　０　の場合、エラーとする。
            // 　業務エラー：PNServiceException
            Long cntTenpo = tenpodao.countByCondition(tenpoEntity);
            if (PNCommonConstants.RECORD_COUNT_ZERO == cntTenpo) {
                // 権限種別が農林中金（本店）の場合
                if (PNCommonConstants.ROLECODE_NOURINHONTEN.equals(roleCode)) {
                    // メッセージID：PM3390E : 指定された扱店コードは金融機関店舗マスターに存在しません
                    throw new PNServiceException(PNCommonMessageConstants.PM3390E);
                }
                // 権限種別が農林中金（支店）の場合
                else if (PNCommonConstants.ROLECODE_NOURINSHITEN.equals(roleCode)) {
                    // メッセージID：PM3940E : 指定された扱店コードまたは店舗コードは金融機関店舗マスターに存在しません
                    throw new PNServiceException(PNCommonMessageConstants.PM3940E);
                }
            }

        }

        // 利用者データの登録
        // 利用者データの登録内容の編集
        // 　DTO.パスワードをSHA-256にてハッシュ化する。
        String hashValue = CFWPasswordUtil.createHashVal(inDto.getPassword());

        // 　DTO.利用開始日（元号）＋（年）＋（月）＋（日）を和暦→西暦変換する。
        int startMonth = Integer.parseInt(inDto.getDate_UseStartMonth());
        int startDay = Integer.parseInt(inDto.getDate_UseStartDate());
        String inGengo = inDto.getDate_UseStartGengo();
        String inYear = inDto.getDate_UseStartYear();
        String inMonth = PNFormatUtils.intFormat(startMonth, PNFormatUtils.FormatPattern.ZeroMinusPrefix, 2);
        String inDay = PNFormatUtils.intFormat(startDay, PNFormatUtils.FormatPattern.ZeroMinusPrefix, 2);
        String startDate = jpCalendarUtils.toSeireki(inGengo, inYear, inMonth, inDay);

        // 　最終ログオン日時の初期設定日付（1900/01/01 00:00:00）を求める。
        Timestamp initTimestamp = new Timestamp(PNDateUtils.toDate(Um001Constants.INIT_TIMESTAMP,
                PNDateUtils.DATE_PATTERN_YYYYMMDDHHMMSSMMM).getTime());
        // 　パスワード変更日時の初期設定日付（システム日時）を取得する。
        Timestamp initLastChgTimestamp = new Timestamp(PNDateUtils.getSystemDate().getTime());

        // DAOへのパラメータに利用者情報の登録内容を設定する。(PNUserEntity)
        // 　DTOの同名項目を設定する。
        // 　上記で編集した内容で上書きする。
        CFWBeanUtils.copyProperties(pnUserEntity, inDto);
        pnUserEntity.setNum_PwdRetryCnt(BigDecimal.ZERO);
        pnUserEntity.setFlag_FirstLogon(BigDecimal.ONE);
        pnUserEntity.setFlag_ForceChgPwdFistLogon(new BigDecimal(inDto.getFlag_ForceChgPwdFistLogon()));
        pnUserEntity.setFlag_ForceChgPwdRoutine(new BigDecimal(inDto.getFlag_ForceChgPwdRoutine()));
        pnUserEntity.setNum_PwdRetryCntMax(new BigDecimal(inDto.getNum_PwdRetryCntMax()));

        // 　・西暦変換した利用開始日　→　利用開始日
        pnUserEntity.setDate_UseStart(PNDateUtils.toSqlDate(PNDateUtils.toDate(startDate,
                PNDateUtils.DATE_PATTERN_YYYYMMDD)));

        // 　・ハッシュ化したパスワード　→　パスワード
        pnUserEntity.setPassword(hashValue);

        // 　・初期設定日付（システム日付）　→　パスワード変更日時
        pnUserEntity.setDateTime_LastChgPwd(initLastChgTimestamp);

        // 　・初期設定日付（1900/01/01 00:00:00）　→　最終ログオン日時
        pnUserEntity.setDateTime_LastLogon(initTimestamp);

        // 単テーブルアクセス定義の「利用者データのNo2.利用者登録」を実行し、利用者データを新規登録する。
        try {
            pnuserdao.insert(pnUserEntity);
        }
        catch (CFWDuplicateKeyException e) {
            log.error("利用者データデータ挿入時にエラーが発生しました", e);
            throw new PNSystemException(e);
        }
        CFWBeanUtils.copyProperties(outDto, pnUserEntity);

        return outDto;
    }
}