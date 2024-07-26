/**
 * Enterキーによるタブ遷移
 *
 * 引数：e オブジェクト
 */
function focusAction() {
	// ブラウザの種類
    var userAgent = navigator.userAgent;
    // InternetExplorerの場合
    if (userAgent.indexOf("MSIE") != -1) {
        // キー押下のイベントがEnterの場合
        if (window.event.keyCode == 13) {
            var type = event.srcElement.type;
            // 押下されたフィールドの種類がテキストまたはパスワードの場合
            if (type == "text" || type == "password") {
            	// キー押下のイベントをタブ遷移に置き換えます。
                window.event.keyCode = 9;
            }
        }
    }
}
