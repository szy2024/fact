//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Cr004_02Service
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/09/14 | 佐藤 晃               | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.cr004.cr004_02.service;

import java.util.ArrayList;
import java.util.List;

import jp.go.jfc.partnernet.common.PNCommonConstants;
import jp.go.jfc.partnernet.cr004.common.Cr004Constants;
import jp.go.jfc.partnernet.cr004.cr004_02.dao.Cr004_02ResultDataDAO;
import jp.go.jfc.partnernet.cr004.cr004_02.dao.Cr004_02ResultDataEntity;
import jp.go.jfc.partnernet.cr008.common.Cr008Constants;
import jp.go.jfc.partnernet.pnfw.service.PNBaseService;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <pre>
 * このクラスはCr004_02のサービスクラスです。
 * </pre>
 *
 * @author 佐藤　晃
 * @version 1.0.0
 */
public class Cr004_02ServiceImpl extends PNBaseService implements Cr004_02Service {

    /** cr004_02resultdatadao */
    @Autowired
    private Cr004_02ResultDataDAO cr004_02resultdatadao;

    /**
     * Cr004_02Serviceの郵便番号変換
     *
     *
     * 郵便番号桁＞３の場合、「〒」＋郵便番号先頭３桁＋「-」(半角ハイフン)＋郵便番号４文字以降を編集する。 郵便番号桁≦３の場合。 郵便番号値をそのまま返す。
     *
     * @param DBから取得した郵便番号
     * @return 変換後郵便番号
     */
    private String convPostCode(String inPost) {

        String outPost = "";

        if (null != inPost) {
            outPost = inPost;
            // 　　　　　※１　郵便番号桁＞３の場合、「〒」＋郵便番号先頭３桁＋「-」(半角ハイフン)＋郵便番号４文字以降を編集する。
            // 　　　　　　　　 郵便番号桁≦３の場合。郵便番号値をそのまま編集する。
            if (Cr008Constants.POST_LENGTH < inPost.length()) {
                String postFront = inPost.substring(0, Cr008Constants.POST_LENGTH);
                String postBack = inPost.substring(Cr008Constants.POST_LENGTH);
                outPost = Cr008Constants.POST_MARK + postFront + Cr008Constants.STR_HYPHEN + postBack
                        + PNCommonConstants.HALF_CHAR_SPACE;
            }
        }

        return outPost;
    }

    /**
     * Cr004_02ServiceのgetResultData
     *
     * @param inDto Cr004_02DTO
     * @return Cr004_02DTO
     */
    @Override
    public Cr004_02DTO getResultData(Cr004_02DTO inDto) {

        Cr004_02DTO outDto = new Cr004_02DTO();
        Cr004_02ResultDataEntity inEntity = new Cr004_02ResultDataEntity();

        // 顧客候補検索（一覧取得）の検索条件を設定
        // 　複数テーブルアクセス定義の「Cr004_02ResultsDataDAO」を参照し、条件を設定する。
        // 　・顧客名入力値にDTOの顧客名入力値を設定
        // 　・ログインユーザ扱店コードにDTOのログインユーザ扱店コードを設定
        // CFWBeanUtils.copyProperties(inEntity, inDto);
        inEntity.setCr004_02_In_Name_Customer(inDto.getLblSearchCustomer());
        inEntity.setCr004_02_Code_Organization(inDto.getCr004_02_Code_Organizaion());

        List<Cr004_02ResultDataEntity> outEntityList = new ArrayList<Cr004_02ResultDataEntity>();

        outEntityList = cr004_02resultdatadao.findByCondition(inEntity);

        List<Cr004_02M1DTO> userList = new ArrayList<Cr004_02M1DTO>(outEntityList.size());

        // 検索結果を取得(Entity→DTOに設定)
        // 　・以下の明細項目（Ｍ１）を一覧取得件数分設定する。

        if (0 != outEntityList.size()) {
            for (Cr004_02ResultDataEntity xEntity : outEntityList) {
                Cr004_02M1DTO userInfo = new Cr004_02M1DTO();
                StringBuilder strMeisaiAddress = new StringBuilder(Cr004Constants.ADDRESS_LENGTH);

                // 　　顧客名
                userInfo.setID_Name_Customer(xEntity.getName_Customer());
                // 郵便番号編集
                String strPost = convPostCode(xEntity.getID_Postcode());
                // 　　住所 ：郵便番号、都道府県等を連結して編集
                // 　　　　　「郵便番号（※１）」+「都道府県名」+「市区郡町村名」+（改行コード）＋「大字通称名」+「字名丁目」+(改行コード)＋「補助住所」

                // 都道府県
                String strTodofuken = "";
                if (null != xEntity.getName_Todofuken()) {
                    strTodofuken = xEntity.getName_Todofuken();
                }

                // 市区群町村名
                String strShikugunchoson = "";
                if (null != xEntity.getName_Shikugunchoson()) {
                    strShikugunchoson = xEntity.getName_Shikugunchoson();
                }

                // 郵便番号 ＋ 都道府県名 ＋ 市区群町村名を結合
                String strCustomerAddress1 = strPost + strTodofuken + strShikugunchoson;
                strMeisaiAddress.append(strCustomerAddress1);

                if (!StringUtils.isEmpty(strCustomerAddress1)) {
                    // 郵便番号 ＋ 都道府県名 ＋ 市区群町村名が空でない場合、改行付与
                    strMeisaiAddress.append(PNCommonConstants.STR_BR);
                }

                // 大字通称名
                String strName_OazaTsusho = "";
                if (null != xEntity.getName_OazaTsusho()) {
                    strName_OazaTsusho = xEntity.getName_OazaTsusho();
                }

                // 字名丁目
                String strAzameiChome = "";
                if (null != xEntity.getName_AzameiChome()) {
                    strAzameiChome = xEntity.getName_AzameiChome();
                }

                // 大字通称 ＋ 字名丁目を結合
                String strCustomerAddress2 = strName_OazaTsusho + strAzameiChome;
                strMeisaiAddress.append(strCustomerAddress2);

                if (!StringUtils.isEmpty(strCustomerAddress2)) {
                    // 大字通称 ＋ 字名丁目が空でない場合、改行付与
                    strMeisaiAddress.append(PNCommonConstants.STR_BR);
                }

                // 補助住所
                String strAddr_Hojo = "";
                if (null != xEntity.getAddr_Hojo()) {
                    strAddr_Hojo = xEntity.getAddr_Hojo();
                }
                strMeisaiAddress.append(strAddr_Hojo);

                userInfo.setID_CustomerAddress(strMeisaiAddress.toString());

                // 　　扱店コード
                userInfo.setID_Code_Organization(xEntity.getCode_Organization());

                // 　　貸付先コード
                userInfo.setID_Code_Customer(xEntity.getCode_Customer());

                userList.add(userInfo);
            }
        }

        outDto.setMEISAI_LIST1(userList);
        return outDto;
    }
}