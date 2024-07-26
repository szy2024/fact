//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Ut001_03Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/03 | 譚　暁玉            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.ut001.ut001_03.service;

import java.util.ArrayList;
import java.util.List;

import jp.go.jfc.partnernet.pnfw.service.PNBaseService;
import jp.go.jfc.partnernet.ut001.ut001_03.dao.Ut001_03KinriJyohoDAO;
import jp.go.jfc.partnernet.ut001.ut001_03.dao.Ut001_03KinriJyohoEntity;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.fujitsu.crust.common.CFWBeanUtils;

/**
 * <pre>
 * このクラスはUt001_03のサービスクラスです。
 * </pre>
 *
 * @author 譚　暁玉
 * @version 1.0.0
 */
public class Ut001_03ServiceImpl extends PNBaseService implements Ut001_03Service {

    /** Log */
    private static Log log = LogFactory.getLog(Ut001_03ServiceImpl.class);

    /** ut001_03kinrijyohodao */
    @Autowired
    private Ut001_03KinriJyohoDAO ut001_03kinrijyohodao;

    /**
     * Ut001_03Serviceのresult
     *
     * @param inDto Ut001_03DTO
     * @return Ut001_03DTO
     */
    @Override
    public Ut001_03DTO result(Ut001_03DTO inDto) {

        Ut001_03DTO outDto = new Ut001_03DTO();

        // 複数DAOへのパラメータを初期化する（Ut001_03KinriJyohoEntity）
        Ut001_03KinriJyohoEntity inEntity = new Ut001_03KinriJyohoEntity();
        List<Ut001_03KinriJyohoEntity> kinriJyohoEntityList = new ArrayList<Ut001_03KinriJyohoEntity>();
        kinriJyohoEntityList = ut001_03kinrijyohodao.findByCondition(inEntity);
        // Ut001_03KinriJyohoDAO.findByCondition
        // 金利情報一覧を設定します。
        // 　結果を返却用DTOにセットする
        List<Ut001_03M1DTO> outEntityList = new ArrayList<Ut001_03M1DTO>();
        for (Ut001_03KinriJyohoEntity entity : kinriJyohoEntityList) {
            Ut001_03M1DTO outList = new Ut001_03M1DTO();
            CFWBeanUtils.copyProperties(outList, entity);
            // 　Entity改定日　→　DTO改定日
            outList.setID_DateTime_DocUpdate(entity.getID_DateTime_DocUpdate());
            // 　Entity通知標題　→　DTO金利情報ファイル
            outList.setID_ID_DocName(entity.getID_DocName());
            // 　Entity文書ファイル名　→　DTO文書ファイル名
            outList.setID_DocFileName(entity.getID_DocFileName());
            outEntityList.add(outList);
            log.debug("outList:" + outList.getID_ID_DocName());
        }
        outDto.setKinriJyohoList(outEntityList);
        log.debug("outEntityList:" + outEntityList);

        return outDto;
    }

}