//==================================================================================================
// $Id: $
// Project Name :
// System Name  : サンプルソース
// Class Name   : M001UserInfoTblEntity.java
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2010/10/05 | 富士通)安納  理裕     | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.common.dao;

import java.util.Date;
import java.util.Set;

import jp.go.jfc.partnernet.pnfw.dao.entity.PNSingleTableEntity;

import com.google.common.collect.ImmutableSet;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 富士通)
 * @version 1.0.0
 */
public class M001UserInfoTblEntity extends PNSingleTableEntity {

    /** プライマリキー */
    private static final Set<String> PRIMARY_KEYS = ImmutableSet.of("JOBNET_ID");

    /** column list */
    private static final String[] COLUMN_LIST = new String[]{"USER_ID", "PASSWORD", "USER_NAME",
            "COMPANY_NAME", "CREATE_ID", "CREATE_DATE", "UPDATE_ID", "UPDATE_DATE"};

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /**
     * ユーザIDを取得します。
     * @return ユーザID
     */
    public String getUser_id() {
        return (String) getValue("USER_ID");
    }

    /**
     * ユーザIDを設定します。
     * @param user_id ユーザID
     */
    public void setUser_id(String user_id) {
        setValue("USER_ID", user_id);
    }

    /**
     * パスワードを取得します。
     * @return パスワード
     */
    public String getPassword() {
        return (String) getValue("PASSWORD");
    }

    /**
     * パスワードを設定します。
     * @param password パスワード
     */
    public void setPassword(String password) {
        setValue("PASSWORD", password);
    }

    /**
     * ユーザ名を取得します。
     * @return ユーザ名
     */
    public String getUser_name() {
        return (String) getValue("USER_NAME");
    }

    /**
     * ユーザ名を設定します。
     * @param user_name ユーザ名
     */
    public void setUser_name(String user_name) {
        setValue("USER_NAME", user_name);
    }

    /**
     * 会社名を取得します。
     * @return 会社名
     */
    public String getCompany_name() {
        return (String) getValue("COMPANY_NAME");
    }

    /**
     * 会社名を設定します。
     * @param company_name 会社名
     */
    public void setCompany_name(String company_name) {
        setValue("COMPANY_NAME", company_name);
    }

    /**
     * 登録IDを取得します。
     *
     * @return 登録ID
     */
    public String getCreate_id() {
        return (String) getValue("CREATE_ID");
    }

    /**
     * 登録IDを設定します。
     *
     * @param create_id 登録ID
     */
    public void setCreate_id(String create_id) {
        setValue("CREATE_ID", create_id);
    }

    /**
     * 登録日時を取得します。
     *
     * @return 登録日時
     */
    public Date getCreate_date() {
        return (Date) getValue("CREATE_DATE");
    }

    /**
     * 登録日時を設定します。
     *
     * @param create_date 登録日時
     */
    public void setCreate_date(Date create_date) {
        setValue("CREATE_DATE", create_date);
    }

    /**
     * 更新IDを取得します。
     *
     * @return 更新ID
     */
    public String getUpdate_id() {
        return (String) getValue("UPDATE_ID");
    }

    /**
     * 更新IDを設定します。
     *
     * @param update_id 更新ID
     */
    public void setUpdate_id(String update_id) {
        setValue("UPDATE_ID", update_id);
    }

    /**
     * 更新日時を取得します。
     *
     * @return 更新日時
     */
    public Date getUpdate_date() {
        return (Date) getValue("UPDATE_DATE");
    }

    /**
     * 更新日時を設定します。
     *
     * @param update_date 更新日時
     */
    public void setUpdate_date(Date update_date) {
        setValue("UPDATE_DATE", update_date);
    }

    /**
     * column list is returned.
     * @return column list
     */
    public String[] getColumnList() {
        return COLUMN_LIST;
    }

    @Override
    public Set<String> getPrimaryKeys() {
        return PRIMARY_KEYS;
    }
}
