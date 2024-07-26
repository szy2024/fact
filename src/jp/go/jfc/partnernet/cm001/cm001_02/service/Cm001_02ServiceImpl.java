//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cm001_02Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/07/09 | 秋澤　修司            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cm001.cm001_02.service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import jp.go.jfc.partnernet.cm001.common.Cm001Constants;
import jp.go.jfc.partnernet.common.dao.PnUserDAOImpl;
import jp.go.jfc.partnernet.common.dao.PnUserEntity;
import jp.go.jfc.partnernet.pnfw.common.PNDateUtils;
import jp.go.jfc.partnernet.pnfw.exception.PNSystemException;
import jp.go.jfc.partnernet.pnfw.service.PNBaseService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.fujitsu.crust.common.CFWBeanUtils;
import com.fujitsu.crust.common.CFWPasswordUtil;
import com.fujitsu.crust.dao.exception.CFWDuplicateKeyException;
import com.fujitsu.crust.dao.exception.CFWFindParameterException;

/**
 * <pre>
 * このクラスはcm001_02のサービスクラスです。
 * </pre>
 *
 * @author 秋澤　修司
 * @version 1.0.0
 */
public class Cm001_02ServiceImpl extends PNBaseService implements Cm001_02Service {
    /** Log */
    private static Log log = LogFactory.getLog(Cm001_02ServiceImpl.class);

    /** pnuserdao */
    @Autowired
    private PnUserDAOImpl pnuserdao;

    /**
     * Cm001_02Serviceのupdate
     *
     * @param inDto Cm001_02DTO
     * @return Cm001_02DTO
     */
    @Override
    public Cm001_02DTO update(Cm001_02DTO inDto) {
        log.debug("@@@@update");

        Cm001_02DTO outDto = new Cm001_02DTO();

        // パスワードをSHA-256でハッシュ化する。
        // 　・DTO.パスワード
        String hashValue = CFWPasswordUtil.createHashVal(inDto.getPasswordNew());

        // パスワード変更をの利用者データに反映する。
        // PNUserEntityに更新更新値をセットする。
        PnUserEntity inEntity = new PnUserEntity();
        // 　・DTO.利用者ID　→　利用者ID
        inEntity.setLogonID(inDto.getLogonID());
        // 　・パスワード（SHA-256でハッシュ化済み）　→　パスワード
        inEntity.setPassword(hashValue);
        // 　・システム日時　→　パスワード変更日時
        inEntity.setDateTime_LastChgPwd(new Timestamp(PNDateUtils.getSystemDate().getTime()));
        // 　・0（初回以外）　 →　初回ログオンフラグ
        inEntity.setFlag_FirstLogon(BigDecimal.ZERO);

        // 単テーブルアクセス定義の「No1. パスワード更新」を実行し、パスワードを更新する。
        try {
            pnuserdao.update(inEntity);
        } catch (CFWFindParameterException e) {
            log.fatal("利用者データ.パスワード更新時にエラー発生", e);
            throw new PNSystemException(e);
        } catch (CFWDuplicateKeyException e) {
            log.fatal("利用者データ.パスワード更新時にエラー発生", e);
            throw new PNSystemException(e);
        }

        // 返却値を設定し、呼び出し元に復帰する
        // 　・InDTO　→　OutDto
        CFWBeanUtils.copyProperties(outDto, inDto);
        // 　・パスワード（SHA-256でハッシュ化済み）　→　OutDTO.パスワード
        outDto.setPasswordNew(hashValue);

        // パスワード有効期限メッセージの設定
        // 利用者情報を取得する
        PnUserEntity outEntity = new PnUserEntity();

        try {
            outEntity = pnuserdao.findByPrimaryKey(inEntity);
        } catch (CFWFindParameterException e) {
            log.error("利用者情報読み込み時にエラー発生", e);
            throw new PNSystemException(e);
        }

        // PNUserEntity.パスワード定期変更強制フラグ ＝ "1:する" の場合
        if (Cm001Constants.FLAG_FORCECHGPWDROUTINE_1
                .equals(outEntity.getFlag_ForceChgPwdRoutine().toString())) {
            // 　　 - パスワード有効期限を設定
            // 　　　 - パスワード期限残存日数を設定
            Date pwdValid = PNDateUtils.addDays(outEntity.getDateTime_LastChgPwd(), outEntity
                    .getNum_PwdValidDays().intValue());
            long pwdRemainDay = (pwdValid.getTime() - PNDateUtils.getSystemDate().getTime())
                    / Cm001Constants.ON_DATE_TIME;
            // 　　　 - DTO.パスワード有効期限メッセージ に 「パスワード期限残存日数」 を設定する
            outDto.setPasswordValidMsg(pwdRemainDay + "日");
            log.debug("-----------------------------------------------------------");
            log.debug("有効期限=" + pwdValid);
            log.debug("システム日時=" + PNDateUtils.getSystemDate());
            log.debug("パスワード期限=" + pwdRemainDay);
            log.debug("-----------------------------------------------------------");
        } else {
            outDto.setPasswordValidMsg("");
        }

        return outDto;
    }

}