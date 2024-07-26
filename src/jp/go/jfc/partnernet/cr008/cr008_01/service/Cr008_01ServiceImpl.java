//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr008_01Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/08/31 | 石川　真理            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr008.cr008_01.service;

import java.util.LinkedHashMap;
import java.util.List;

import jp.go.jfc.partnernet.cr008.cr008_01.dao.Cr008_01KoukoShitenDAO;
import jp.go.jfc.partnernet.cr008.cr008_01.dao.Cr008_01KoukoShitenEntity;
import jp.go.jfc.partnernet.pnfw.exception.PNSystemException;
import jp.go.jfc.partnernet.pnfw.service.PNBaseService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <pre>
 * このクラスはCr008_01のサービスクラスです。
 * </pre>
 *
 * @author 石川　真理
 * @version 1.0.0
 */
public class Cr008_01ServiceImpl extends PNBaseService implements Cr008_01Service {

    /** Log */
    private static Log log = LogFactory.getLog(Cr008_01ServiceImpl.class);

    /** cr008_01koukoshitendao */
    @Autowired
    private Cr008_01KoukoShitenDAO cr008_01koukoshitendao;

    /**
     * Cr008_01ServiceのgetSyokanHonShitenData
     *
     * @param inDto Cr008_01DTO
     * @return Cr008_01DTO
     */
    @Override
    public Cr008_01DTO getSyokanHonShitenData(Cr008_01DTO inDto) {

        Cr008_01DTO outDto = new Cr008_01DTO();
        Cr008_01KoukoShitenEntity inEntity = new Cr008_01KoukoShitenEntity();
        List<Cr008_01KoukoShitenEntity> outEntityList;

        // 公庫支店のプルダウンリスト取得
        outEntityList = cr008_01koukoshitendao.findByCondition(inEntity);

        // 取得データを公庫支店名プルダウンリストに設定する。
        // ※プルダウンリストは　String[0]にコード、String[1]に文言を設定する。
        LinkedHashMap<String, String> lMap = new LinkedHashMap<String, String>();

        // 　公庫支店コード、公庫支店名の順にString配列に詰め、Listに格納
        for (Cr008_01KoukoShitenEntity xEntity : outEntityList) {
            lMap.put(xEntity.getCode_KoukoShiten(), xEntity.getName_KoukoShiten());
        }

        // 取得した公庫支店データのサイズが０の場合、システムエラーとする
        if (0 == lMap.size()) {
            log.error("公庫支店データが取得できません");
            throw new PNSystemException();
        }

        outDto.setShokanHonShitenLIST(lMap);

        return outDto;
    }

}