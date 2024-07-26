package jp.go.jfc.partnernet.common;

public class PNCommonStringUtils {

    /**
     *
     * <pre>
     * 引数のString配列を結合します。
     * </pre>
     *
     * @param 文字列配列
     * @return 結合文字列
     */
    public static String concatString(String... param) {

        StringBuffer sb = new StringBuffer();
        for (String str : param) {
            sb.append(str);
        }

        return sb.toString();
    }

    /**
     *
     * <pre>
     * 引数のStringオブジェクトがNULLの場合空白のStringオブジェクトを返します。
     * </pre>
     *
     * @param 文字列
     * @return 文字列
     */
    public static String encNullToBrank(String param) {
        if (param == null) {
            param = "";
        }
        return param;
    }

    /**
     *
     * <pre>
     * 引数のStringオブジェクトがNULL又は空の場合、'0'の文字列を返します。
     * </pre>
     *
     * @param 文字列
     * @return 文字列
     */
    public static String encNulltoZero(String param) {
        if (param == null || param.length() == 0) {
            param = "0";
        }
        return param;
    }

}
