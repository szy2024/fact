//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr005_01Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/14 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr005.cr005_01.service;

import java.util.LinkedHashMap;
import java.util.List;

import jp.go.jfc.partnernet.pnfw.exception.PNSystemException;
import jp.go.jfc.partnernet.pnfw.service.PNBaseService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;

import jp.go.jfc.partnernet.cr005.cr005_01.dao.Cr005_01KoukoShitenDAO;
import jp.go.jfc.partnernet.cr005.cr005_01.dao.Cr005_01KoukoShitenEntity;

/**
 * <pre>
 * このクラスはcr005_01のサービスクラスです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public class Cr005_01ServiceImpl extends PNBaseService implements Cr005_01Service {

    /** Log */
    private static Log log = LogFactory.getLog(Cr005_01ServiceImpl.class);

    /** cr005_01koukoshitendao */
    @Autowired
    private Cr005_01KoukoShitenDAO cr005_01koukoshitendao;

    /**
     * Cr005_01ServiceのgetSyokanHonShitenData
     *
     * @param inDto Cr005_01DTO
     * @return Cr005_01DTO
     */
    @Override
    public Cr005_01DTO getSyokanHonShitenData(Cr005_01DTO inDto) {

        Cr005_01DTO outDto = new Cr005_01DTO();
        Cr005_01KoukoShitenEntity inEntity = new Cr005_01KoukoShitenEntity();
        List<Cr005_01KoukoShitenEntity> outEntityList;

        // 公庫支店のプルダウンリスト取得
        outEntityList = cr005_01koukoshitendao.findByCondition(inEntity);

        // 取得データを公庫支店名プルダウンリストに設定する。
        // ※プルダウンリストは　String[0]にコード、String[1]に文言を設定する。
        LinkedHashMap<String, String> lMap = new LinkedHashMap<String, String>();

        // 　公庫支店コード、公庫支店名の順にString配列に詰め、Listに格納
        for (Cr005_01KoukoShitenEntity xEntity : outEntityList) {
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