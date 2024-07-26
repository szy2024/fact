//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Ut001_04Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/03 | 譚　暁玉            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.ut001.ut001_04.service;

import java.util.ArrayList;
import java.util.List;

import jp.go.jfc.partnernet.pnfw.service.PNBaseService;
import jp.go.jfc.partnernet.ut001.ut001_04.dao.Ut001_04YoryoManualDAO;
import jp.go.jfc.partnernet.ut001.ut001_04.dao.Ut001_04YoryoManualEntity;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.fujitsu.crust.common.CFWBeanUtils;

/**
 * <pre>
 * このクラスはUt001_04のサービスクラスです。
 * </pre>
 *
 * @author 譚　暁玉
 * @version 1.0.0
 */
public class Ut001_04ServiceImpl extends PNBaseService implements Ut001_04Service {

    /** Log */
    private static Log log = LogFactory.getLog(Ut001_04ServiceImpl.class);
    /** ut001_04yoryomanualdao */
    @Autowired
    private Ut001_04YoryoManualDAO ut001_04yoryomanualdao;

    /**
     * Ut001_04Serviceのresult
     *
     * @param inDto Ut001_04DTO
     * @return Ut001_04DTO
     */
    @Override
    public Ut001_04DTO result(Ut001_04DTO inDto) {

        Ut001_04DTO outDto = new Ut001_04DTO();

        // 複数DAOへパラメータを初期化する（Ut001_04YoryoManualEntity)
        Ut001_04YoryoManualEntity inEntity = new Ut001_04YoryoManualEntity();
        List<Ut001_04YoryoManualEntity> yoryoManualEntityList = new ArrayList<Ut001_04YoryoManualEntity>();
        yoryoManualEntityList = ut001_04yoryomanualdao.findByCondition(inEntity);
        // Ut001_04YoryoManualDAO.findByCondition
        // 要領・マニュアル名を設定する。
        // 　結果を返却用DTOにセットする
        List<Ut001_04M1DTO> outEntityList = new ArrayList<Ut001_04M1DTO>();
        for (Ut001_04YoryoManualEntity entity : yoryoManualEntityList) {
            Ut001_04M1DTO outList = new Ut001_04M1DTO();
            CFWBeanUtils.copyProperties(outList, entity);
            // 　Entity改正日　→　DTO改正日
            outList.setID_DateTime_DocUpdate(entity.getID_DateTime_DocUpdate());
            // 　Entity通知標題　→　DTO要領・マニュアル名
            outList.setID_ID_DocName(entity.getID_DocName());
            // 　Entity文書ファイル名　→　DTO文書ファイル名
            outList.setID_DocFileName(entity.getID_DocFileName());
            outEntityList.add(outList);
            log.debug("outList:" + outList.getID_ID_DocName());
        }
        outDto.setYoryoList(outEntityList);
        log.debug("outEntityList:" + outEntityList);

        return outDto;
    }

}