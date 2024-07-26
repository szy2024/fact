//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Um001_02Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/31 | 松井　元気            | 新規作成
// 2.0.0   | 2017/10/06 | 林　晃平              | H29年追加開発案件対応
//==================================================================================================
package jp.go.jfc.partnernet.um001.um001_02.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jp.go.jfc.partnernet.common.PNCommonMessageConstants;
import jp.go.jfc.partnernet.common.dao.PnUserDAO;
import jp.go.jfc.partnernet.common.dao.PnUserEntity;
import jp.go.jfc.partnernet.pnfw.common.PNDateUtils;
import jp.go.jfc.partnernet.pnfw.exception.PNServiceException;
import jp.go.jfc.partnernet.pnfw.exception.PNSystemException;
import jp.go.jfc.partnernet.pnfw.service.PNBaseService;
import jp.go.jfc.partnernet.um001.common.Um001Constants;
import jp.go.jfc.partnernet.um001.um001_02.dao.Um001_02PnUserDAO;
import jp.go.jfc.partnernet.um001.um001_02.dao.Um001_02PnUserEntity;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.fujitsu.crust.common.CFWBeanUtils;
import com.fujitsu.crust.dao.exception.CFWDuplicateKeyException;
import com.fujitsu.crust.dao.exception.CFWFindParameterException;
import com.fujitsu.crust.dao.exception.CFWForUpdateException;

/**
 * <pre>
 * このクラスはUm001_02のサービスクラスです。
 * </pre>
 *
 * @author 林　晃平
 * @version 2.0.0
 */
public class Um001_02ServiceImpl extends PNBaseService implements Um001_02Service {

    /** Logger */
    private static final Log log = LogFactory.getLog(Um001_02ServiceImpl.class);

    /** um001_02pnuserdao */
    @Autowired
    private Um001_02PnUserDAO um001_02PnUserDAO;

    /** pnuserdao */
    @Autowired
    private PnUserDAO pnUserDAO;

    /**
     * Um001_02ServiceのcountUserList
     *
     * @param inDto Um001_02DTO
     * @return Um001_02DTO
     */
    @Override
    public Um001_02DTO countUserList(Um001_02DTO inDto) {

        Um001_02DTO outDto = new Um001_02DTO();
        // 画面にて指定された検索条件に該当する総件数を取得する。
        // 　DAOへのパラメータに検索条件を設定（PNUserEntity)
        // 　　・DTO.検索扱店 → 扱店コード
        // 　　・DTO.検索利用者ID　→　利用者ID
        Um001_02PnUserEntity inEntity = new Um001_02PnUserEntity();
        inEntity.setCode_Organization(inDto.getSrcCode_Organization());
        inEntity.setLogonID(inDto.getSrcLogonID());

        // 　DAOを呼び出し、画面で入力された検索キーの該当件数を取得する
        // 　Um001_02PnUserDAO.countByCondition(Entity)
        // ■単DAO呼出し：Um001_02PnUserDAO.countByCondition(Entity)
        long hitCount = um001_02PnUserDAO.countByCondition(inEntity);

        // ヒット件数の返却
        // 　DAO結果件数　→　DTO.利用者一覧ヒット件数
        // 　呼び出し元に復帰する
        outDto.setUserListHitCount(new Long(hitCount).intValue());

        return outDto;
    }

    /**
     * Um001_02ServiceのgetUserList
     *
     * @param inDto Um001_02DTO
     * @return Um001_02DTO
     */
    @Override
    public Um001_02DTO getUserList(Um001_02DTO inDto) {

        Um001_02DTO outDto = new Um001_02DTO();

        // 検索条件に該当し、指定ページに表示する利用者一覧データを取得する。
        // 　※ページ位置はフレームワークにて自動で設定される
        // 　DAOへのパラメータに検索条件を設定（PNUserEntity)
        // 　　・DTO.検索扱店 → 扱店コード
        // 　　・DTO.検索利用者ID　→　利用者ID
        Um001_02PnUserEntity inEntity = new Um001_02PnUserEntity();
        inEntity.setCode_Organization(inDto.getSrcCode_Organization());
        inEntity.setLogonID(inDto.getSrcLogonID());

        // 　画面で入力された検索キーの該当データを取得する。
        // 　　・Um001_02PnUserDAO.countByCondition(Entity, オフセット, リミット)
        List<Um001_02PnUserEntity> userEntityList = new ArrayList<Um001_02PnUserEntity>();
        userEntityList = um001_02PnUserDAO.findByCondition(inEntity, inDto.getOffset(), inDto.getLength());

        // 返却値の編集
        // 　DAOより取得した利用者一覧リスト全件のステータスを判定しoutDto.利用者一覧に設定する。
        List<Um001_02M1DTO> outUserList = new ArrayList<Um001_02M1DTO>(userEntityList.size());
        for (Um001_02PnUserEntity entity : userEntityList) {
            Um001_02M1DTO outUser = new Um001_02M1DTO();
            CFWBeanUtils.copyProperties(outUser, entity);

            if (entity.getNum_PwdRetryCnt().intValue() > entity.getNum_PwdRetryCntMax().intValue()) {

                // ・Entity.パスワード試行回数　＞　Entity.パスワード試行回数（最大）　の場合
                // 　　"1 : ロック（試行回数オーバー）" →　ステータス
                outUser.setStatus(Um001Constants.STATUS_LOCK_OVER);
                outUser.setStatusName("ロック（試行回数オーバー）");

            }
            else if (0 < entity.getDate_UseStart().compareTo(PNDateUtils.getSystemDate())) {

                // ・Entity.利用開始日　＜　システム日時
                // 　　"2 : 利用開始前"　→　ステータス
                outUser.setStatus(Um001Constants.STATUS_USE_BEFORE);
                outUser.setStatusName("利用開始前");

            }
            else if ((entity.getFlag_ForceChgPwdRoutine().intValue() == Um001Constants.FLAG_FORCECHGPWDROUTINE_1)
                    && (entity.getFlag_FirstLogon().intValue() != Um001Constants.FLAG_FIRSTLOGON_1)
                    && (0 > PNDateUtils
                            .addDays(entity.getDateTime_LastChgPwd(), entity.getNum_PwdValidDays())
                            .compareTo(PNDateUtils.getSystemDate()))) {

                // ・Entity.パスワード定期変更強制フラグ　＝　"1 : する"
                // 　　かつ　Entity.初回ログオンフラグ ≠　"1 : 初回" ※初回以外
                // 　　かつ　（Entity.パスワード最終変更日時　＋　パスワード有効日数）　＞　システム日時
                // 　　"3 : パスワード期限切れ"　→　ステータス
                outUser.setStatus(Um001Constants.STATUS_EXPIRATION);
                outUser.setStatusName("パスワード期限切れ");

            }
            else {

                // ・上記以外
                // 　　"0 : 利用中"　→　ステータス　※一覧画面は空白表示
                outUser.setStatus(Um001Constants.STATUS_USE);
                outUser.setStatusName("");

            }

            outUserList.add(outUser);

        }

        // 利用者一覧の返却
        // 　DAO結果リスト　→　DTO.利用者一覧
        // 　呼び出し元に復帰する
        outDto.setUserList(outUserList);
        return outDto;
    }

    /**
     * Um001_02ServiceのupdateCurrentPage
     *
     * @param inDto Um001_02DTO
     * @return Um001_02DTO
     */
    @Override
    public Um001_02DTO updateCurrentPage(Um001_02DTO inDto) {

        Um001_02DTO outDto = new Um001_02DTO();
        int updateCount = 0;
        int deleteCount = 0;

        // 利用者一覧（現在ページ）の各行の操作オプションの状態により、利用者データのアカウントロック解除、
        // もしくは物理削除を行う。
        // 利用者一覧をinDtoから取得する。（inDto.利用者一覧　→　利用者一覧）
        List<Um001_02M1DTO> userList = inDto.getUserList();

        // 利用者一覧がなくなるまで繰り返す。
        for (Um001_02M1DTO user : userList) {

            if (null == user.getOptOperation()) {

                // ・利用者一覧.操作オプション　＝　null　の場合、
                // 　何もせず、次の利用者に移動する。
                continue;

            }
            else if (Um001Constants.OPT_DELETE == user.getOptOperation()) {

                // ・利用者一覧.操作オプション　＝　"1 : 削除"　の場合、
                // 　削除対象レコードを排他する。
                // 　・DAOへのパラメータを設定（PNUserEntity)
                // 　　利用者一覧.利用者ID　→　利用者ID
                PnUserEntity inEntity = new PnUserEntity();
                inEntity.setLogonID(user.getLogonID());

                // ■単DAO呼出し：【排他読み込み】
                // 　・単テーブルアクセス定義の「No1. 排他読み込み」を実行し、削除対象レコードを排他する。
                try {
                    pnUserDAO.findByPrimaryKeyForUpdate(inEntity);
                }
                catch (CFWForUpdateException e) {
                    // 　　排他エラー(CFWForUpdateException)が発生した場合、エラーメッセージを設定し
                    // 　　業務エラーを発生させる。
                    // 　　　・業務エラー：PNServiceException
                    // 　　　・メッセージ：PM9020E : 他のユーザによってデータが更新されています。しばらく
                    // 　　　　時間をおいてから操作してください。
                    throw new PNServiceException(PNCommonMessageConstants.PM9020E, e);
                }
                catch (CFWFindParameterException e) {
                    log.error("利用者データ削除前の排他読み込みにてエラーが発生", e);
                    throw new PNSystemException(e);
                }

                // ■単DAO呼出し：【削除】
                // 　物理削除する。
                // 　・DAOへのパラメータを設定（PNUserEntity）
                // 　　利用者一覧.利用者ID　→　利用者ID
                // 　・単テーブルアクセス定義の「No2. 利用者削除」を実行し、対象レコードを削除する。
                try {
                    pnUserDAO.delete(inEntity);
                    deleteCount++;
                }
                catch (CFWFindParameterException e) {
                    log.error("利用者データの削除にてエラーが発生", e);
                    throw new PNSystemException(e);
                }

            }
            else if (Um001Constants.OPT_LOCK_CLEAR == user.getOptOperation()) {

                // ・操作オプション　＝　"2 : ロック解除" の場合、
                // 　更新対象理コードを排他する。
                // 　・DAOへのパラメータを設定（PNUserEntity)
                // 　　・利用者一覧.利用者ID　→　利用者ID
                // 　　・0（固定）　→　パスワード試行回数
                PnUserEntity inEntity = new PnUserEntity();
                inEntity.setLogonID(user.getLogonID());
                inEntity.setNum_PwdRetryCnt(BigDecimal.ZERO);

                // ■単DAO呼出し：【排他読み込み】
                // 　・単テーブルアクセス定義の「No1. 排他読み込み」を実行し、更新対象レコードを排他する。
                try {
                    pnUserDAO.findByPrimaryKeyForUpdate(inEntity);
                    updateCount++;
                }
                catch (CFWForUpdateException e) {
                    // 　　排他エラー(CFWForUpdateException)が発生した場合、エラーメッセージを設定し
                    // 　　業務エラーを発生させる。
                    // 　　　・業務エラー：PNServiceException
                    // 　　　・メッセージ：PM9020E : 他のユーザによってデータが更新されています。しばらく
                    // 　　　　時間をおいてから操作してください。
                    throw new PNServiceException(PNCommonMessageConstants.PM9020E, e);
                }
                catch (CFWFindParameterException e) {
                    log.error("利用者データ更新前の排他読み込みにてエラーが発生", e);
                    throw new PNSystemException(e);
                }

                // ■単DAO呼出し：【更新】
                // 　利用者データを更新する。
                // 　・単テーブルアクセス定義の「No3. アカウントロック解除」を実行し、対象レコードを更新する。
                try {
                    pnUserDAO.update(inEntity);
                }
                catch (CFWDuplicateKeyException e) {
                    log.error("利用者データの更新にてエラーが発生");
                    throw new PNSystemException(e);
                }
                catch (CFWFindParameterException e) {
                    log.error("利用者データの更新にてエラーが発生", e);
                    throw new PNSystemException(e);
                }
            }
        }

        // 返却用DTOを返却情報を設定し、呼び出し元に復帰する。
        // 　削除件数　→　DTO.削除件数
        // 　更新件数　→　DTO.更新件数
        outDto.setDeleteCount(deleteCount);
        outDto.setUpdateCount(updateCount);

        return outDto;
    }

}