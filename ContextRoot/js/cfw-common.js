//==================================================================================================
// Project Name : CrustFramework-web
// System Name  : Crust
// Class Name   : cfw-common.js
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2014/03/31 | 富士通)草水 博喜      | 新規作成
// 1.0.1   | 2014/07/01 | 富士通)草水 博喜      | 子画面に親画面のFormを引き継ぐinheritパラメーターを付加する子画面起動*Inheritメソッドを追加
//==================================================================================================

// onload処理
window.onload = commonOnloadProcess;
// onUnload処理
// document.onUnload = closeWindow;

// 画面情報を保持するオブジェクト
var screens = new Array();
// ダブルポスト制御
var isSubmitted = false;

/** 親画面のFormを継承する場合のgetパラメーター */
var CONST_INHERIT_NEWSESSION = "newSession=true&inherit=true&windowID=";


/**
 * モーダルダイアログで開かれた子画面から呼び出し元のwindowを取得します。
 */
function getParent() {
	if (!opener) {
		opener = window.dialogArguments;
	}
	return opener;
}

/**
 * ブラウザの閉じるボタンで全ての画面を閉じます。
 */
function closeWindow() {
	if (screens != null) {
		// 子画面を閉じます。
		for (var i = 0; i < screens.length; i++) {
			screens[i].close();
		}
	}
}

/**
 * フォーム内の閉じるボタンで全ての画面を閉じます。
 */
function closeButtonWindow() {
	if (screens != null) {
		// 子画面を閉じます。
		for (var i = 0; i < screens.length; i++) {
			screens[i].close();
		}
		// 親画面を閉じます。
		window.close();
	} else {
		// 親画面を閉じます。
		window.close();
	}
}

/**
 * 共通onload処理
 */
function commonOnloadProcess() {

	// 画面を閉じる処理
	try {
		closeWindow();
	} catch (err) {
	}

	// 子画面を閉じる処理
	try {
		closeChiledWindow();
	} catch (err) {
	}

	// onload時に確認ダイアログを表示
	try {
		showConfirm();
	} catch (err) {
	}

	// ファイルダウンロード
	try {
		fileDownload();
	} catch (err) {
	}

	// 画面個別のonload処理
	try {
		onloadProcess();
	} catch (err) {
	}

}

/**
 * Controller処理を呼び出します。
 */
function executeAction(actionPath) {
	if (isSubmitted) {
		return false;
	}
	document.forms[0].action = actionPath;
	document.forms[0].submit();
	isSubmitted = true;
	window.status = "処理中です。しばらくお待ちください。";
	return true;
}

/**
 * ポップアップを開きます。
 *
 * @param path
 *            ウィンドウのパス
 * @param existsAdressBar
 *            アドレスバーの有無
 * @param existsMenuBar
 *            メニューバーの有無
 * @param existsStatusBar
 *            ステータスバーの有無
 * @param width
 *            ウィンドウの横サイズ
 * @param height
 *            ウィンドウの縦サイズ
 * @param existsResize
 *            リサイズの有無
 */
function openNewWindow(path, existsAdressBar, existsMenuBar, existsStatusBar,
		width, height, existsResize) {

	// 表示サイズ（縦×横）を設定します
	var widthSize = width + ",";
	var heightSize = height + ",";

	var adressBar = "location=no,";
	var menuBar = "menubar=no,";
	var statusBar = "status=no,";
	var resizable = "resizable=no,";

	// アドレスバー表示の有無を判断します
	if (existsAdressBar) {
		adressBar = "location=yes,";
	}
	// メニューバー表示の有無を判断します
	if (existsMenuBar) {
		menuBar = "menubar=yes,";
	}
	// ステータスバー表示の有無を判断します
	if (existsStatusBar) {
		statusBar = "status=yes,";
	}
	// リサイズの可否を判断します
	if (existsResize) {
		resizable = "resizable=yes,";
	}

	// スクロールバー
	var scrollBar = "scrollbars=yes";

	// 表示項目を設定します
	var options = widthSize + heightSize + adressBar + menuBar + statusBar
			+ resizable + scrollBar;
	// 画面IDを取得します
	var windowId = "";
	try {
		windowId = getWindowID();
	} catch (err) {
	}
	// path変数に「?」があるかどうかを判定します
	if (path.indexOf('?') != -1) {
		path = path + "&";
	} else {
		path = path + "?";
	}
	path = path + "newSession=true&windowID=" + windowId;
	// 小窓を開きます
	screens.push(window.open(path, "_blank", options));
}

/**
 * モーダルダイアログでウィンドウを開きます。
 *
 * @param path
 *            パス
 * @param existsStatusBar
 *            ステータスバーの有無
 * @param existsScrollBar
 *            スクロールバー有無
 * @param width
 *            ウィンドウの横サイズ
 * @param height
 *            ウィンドウの縦サイズ
 * @param existsResize
 *            リサイズの有無
 */
function openModalDialog(path, existsStatusBar, existsScrollBar, width, height,
		existsResize) {

	// 表示サイズ（縦×横）を設定します
	var widthSize = width + ";";
	var heightSize = height + ";";

	var statusBar = "status:no;";
	var scrollBar = "scroll:no;";
	var resizables = "resizable=no;minimize=no;maximize=no;";

	// ステータスバー表示の有無を判断します
	if (existsStatusBar) {
		statusBar = "status:yes;";
	}
	// リサイズの可否を判断します
	if (existsResize) {
		resizables = "resizable=yes;minimize=no;maximize=yes;";
	}

	// スクロールバー表示の有無を判断します
	if (existsScrollBar) {
		scrollBar = "scroll:yes";
	}

	// 表示項目を設定します
	var options = widthSize + heightSize + statusBar + resizables + scrollBar;
	// 画面IDを取得します
	var windowId = getWindowID();
	// path変数に「?」があるかどうかを判定します
	if (path.indexOf('?') != -1) {
		path = path + "&";
	} else {
		path = path + "?";
	}
	path = path + "newSession=true&windowID=" + windowId;
	// 小窓を開きます
	screens.push(window.showModalDialog(path, this, options));

}

/**
 * サイズ大のウィンドウを開きます
 *
 * @param path
 *            パス
 * @param adressBar
 *            アドレスバーの有無
 * @param statusBar
 *            ステータスバーの有無
 * @param menuBar
 *            メニューバーの有無
 */
function largeWindow(path, adressBar, statusBar, menuBar) {
	var width = "width=1012";
	var height = "height=650";
	openNewWindow(path, adressBar, menuBar, statusBar, width, height);
}

/**
 * サイズ大のモーダルダイアログを開きます
 *
 * @param path
 *            パス
 * @param statusBar
 *            ステータスバーの有無
 * @param scrollBar
 *            スクロールバーの有無
 */
function largeModalDialog(path, statusBar, scrollBar) {
	var width = "dialogWidth=1012px";
	var height = "dialogHeight=650px";
	openModalDialog(path, statusBar, scrollBar, width, height);
}

/**
 * サイズ大のメニューバー無しウィンドウを開きます。
 *
 * @param path
 *            パス
 */
function largeNoneMenuWindow(path) {

	// 表示項目を設定します
	var options = "width=1012, height=650, location=yes, status=yes, menubar=no";
	// 画面IDを取得します
	var windowId = getWindowID();
	// path変数に「?」があるかどうかを判定します
	if (path.indexOf('?') != -1) {
		path = path + "&";
	} else {
		path = path + "?";
	}
	path = path + "newSession=true&windowID=" + windowId;
	// 小窓を開きます
	screens.push(window.open(path, "_blank", options));
}

/**
 * サイズ中のウィンドウを開きます
 *
 * @param path
 *            パス
 * @param adressBar
 *            アドレスバーの有無
 * @param statusBar
 *            ステータスバーの有無
 * @param menuBar
 *            メニューバーの有無
 */
function middleWindow(path, adressBar, statusBar, menuBar) {
	var width = "width=800";
	var height = "height=600";
	openNewWindow(path, adressBar, menuBar, statusBar, width, height);
}

/**
 * サイズ中のモーダルダイアログを開きます
 *
 * @param path
 *            パス
 * @param statusBar
 *            ステータスバーの有無
 * @param scrollBar
 *            スクロールバーの有無
 */
function middleModalDialog(path, statusBar, scrollBar) {
	var width = "dialogWidth=800px";
	var height = "dialogHeight=600px";
	openModalDialog(path, statusBar, scrollBar, width, height);
}

/**
 * サイズ中のメニューバー無しウィンドウを開きます。
 *
 * @param path
 *            パス
 */
function middleNoneMenuWindow(path) {

	// 表示項目を設定します
	var options = "width=800, height=600, location=yes, status=yes, menubar=no";
	// 画面IDを取得します
	var windowId = getWindowID();
	// path変数に「?」があるかどうかを判定します
	if (path.indexOf('?') != -1) {
		path = path + "&";
	} else {
		path = path + "?";
	}
	path = path + "newSession=true&windowID=" + windowId;
	// 小窓を開きます
	screens.push(window.open(path, "_blank", options));
}

/**
 * サイズ小のウィンドウを開きます
 *
 * @param path
 *            パス
 * @param adressBar
 *            アドレスバーの有無
 * @param statusBar
 *            ステータスバーの有無
 * @param menuBar
 *            メニューバーの有無
 */
function smallWindow(path, adressBar, statusBar, menuBar) {
	var width = "width=640";
	var height = "height=480";
	openNewWindow(path, adressBar, menuBar, statusBar, width, height);
}

/**
 * サイズ小のモーダルダイアログを開きます
 *
 * @param path
 *            パス
 * @param statusBar
 *            ステータスバーの有無
 * @param scrollBar
 *            スクロールバーの有無
 */
function smallModalDialog(path, statusBar, scrollBar) {
	var width = "dialogWidth=640px";
	var height = "dialogHeight=480px";
	openModalDialog(path, statusBar, scrollBar, width, height);
}

/**
 * サイズ小のメニューバー無しウィンドウを開きます。
 *
 * @param path
 *            パス
 */
function smallNoneMenuWindow(path) {

	// 表示項目を設定します
	var options = "width=640, height=480, location=yes, status=yes, menubar=no";
	// 画面IDを取得します
	var windowId = getWindowID();
	// path変数に「?」があるかどうかを判定します
	if (path.indexOf('?') != -1) {
		path = path + "&";
	} else {
		path = path + "?";
	}
	path = path + "newSession=true&windowID=" + windowId;
	// 小窓を開きます
	screens.push(window.open(path, "_blank", options));
}

/**
 * ポップアップを開きます。
 * 親画面の画面IDとpathに指定したURL(Contoroller)の画面IDが同一の場合、親のFormを引き継ぎます。
 * ※入力補助画面など、親画面から子画面へFormを受け渡す必要がある場合、こちらを使用してください。
 *
 * @param path ウィンドウのパス
 * @param existsAdressBar アドレスバーの有無
 * @param existsMenuBar メニューバーの有無
 * @param existsStatusBar ステータスバーの有無
 * @param width ウィンドウの横サイズ
 * @param height ウィンドウの縦サイズ
 * @param existsResize リサイズの有無
 */
function openNewWindowInherit(path, existsAdressBar, existsMenuBar, existsStatusBar, width, height, existsResize) {

    // 表示サイズ（縦×横）を設定します
    var widthSize = width + ",";
    var heightSize = height + ",";

    var adressBar = "location=no,";
    var menuBar = "menubar=no,";
    var statusBar = "status=no,";
    var resizable = "resizable=no,";

    // アドレスバー表示の有無を判断します
    if(existsAdressBar){
        adressBar = "location=yes,";
    }
    // メニューバー表示の有無を判断します
    if(existsMenuBar){
        menuBar = "menubar=yes,";
    }
    // ステータスバー表示の有無を判断します
    if(existsStatusBar){
        statusBar = "status=yes,";
    }
    // リサイズの可否を判断します
    if(existsResize){
    	resizable = "resizable=yes,";
    }

    // スクロールバー
    var scrollBar = "scrollbars=yes";

    // 表示項目を設定します
    var options =   widthSize + heightSize + adressBar + menuBar + statusBar + resizable + scrollBar;
    // 画面IDを取得します
    var windowId = "";
    try {
        windowId = getWindowID();
    } catch (err) {
    }
    // path変数に「?」があるかどうかを判定します
    if (path.indexOf('?') != -1) {
        path = path + "&";
    } else {
        path = path + "?";
    }
    path = path + CONST_INHERIT_NEWSESSION + windowId;
    // 小窓を開きます
    screens.push(window.open(path, "_blank", options));
}

/**
 * モーダルダイアログでウィンドウを開きます。
 * 親画面の画面IDとpathに指定したURL(Contoroller)の画面IDが同一の場合、親のFormを引き継ぎます。
 * ※入力補助画面など、親画面から子画面へFormを受け渡す必要がある場合、こちらを使用してください。
 *
 * @param path パス
 * @param existsStatusBar ステータスバーの有無
 * @param existsScrollBar スクロールバー有無
 * @param width ウィンドウの横サイズ
 * @param height ウィンドウの縦サイズ
 * @param existsResize リサイズの有無
 */
function openModalDialogInherit(path, existsStatusBar, existsScrollBar, width, height, existsResize) {

    // 表示サイズ（縦×横）を設定します
    var widthSize = width + ";";
    var heightSize = height + ";";

    var statusBar = "status:no;";
    var scrollBar = "scroll:no;";
    var resizables = "resizable=no;minimize=no;maximize=no;";

    // ステータスバー表示の有無を判断します
    if(existsStatusBar) {
        statusBar = "status:yes;";
    }
    // リサイズの可否を判断します
    if(existsResize){
    	resizables = "resizable=yes;minimize=no;maximize=yes;";
    }

    // スクロールバー表示の有無を判断します
    if(existsScrollBar) {
        scrollBar = "scroll:yes";
    }


    // 表示項目を設定します
    var options =   widthSize + heightSize + statusBar + resizables + scrollBar ;
    // 画面IDを取得します
    var windowId = getWindowID();
    // path変数に「?」があるかどうかを判定します
    if (path.indexOf('?') != -1) {
        path = path + "&";
    } else {
        path = path + "?";
    }
    path = path + CONST_INHERIT_NEWSESSION + windowId;
    // 小窓を開きます
    screens.push(window.showModalDialog(path, this, options));

}

/**
 * サイズ大のウィンドウを開きます
 * 親画面の画面IDとpathに指定したURL(Contoroller)の画面IDが同一の場合、親のFormを引き継ぎます。
 * ※入力補助画面など、親画面から子画面へFormを受け渡す必要がある場合、こちらを使用してください。
 *
 * @param path パス
 * @param adressBar アドレスバーの有無
 * @param statusBar ステータスバーの有無
 * @param menuBar メニューバーの有無
 */
function largeWindowInherit(path, adressBar, statusBar, menuBar) {
    var width  = "width=1012";
    var height = "height=650";
    openNewWindowInherit(path, adressBar, menuBar, statusBar, width, height);
}

/**
 * サイズ大のモーダルダイアログを開きます
 * ※入力補助画面など、親画面から子画面へFormを受け渡す必要がある場合、こちらを使用してください。
 *
 * @param path パス
 * @param statusBar ステータスバーの有無
 * @param scrollBar スクロールバーの有無
 */
function largeModalDialogInherit(path, statusBar, scrollBar) {
    var width  = "dialogWidth=1012px";
    var height = "dialogHeight=650px";
    openModalDialogInherit(path, statusBar, scrollBar, width, height);
}

/**
 * サイズ大のメニューバー無しウィンドウを開きます。
 * 親画面の画面IDとpathに指定したURL(Contoroller)の画面IDが同一の場合、親のFormを引き継ぎます。
 * ※入力補助画面など、親画面から子画面へFormを受け渡す必要がある場合、こちらを使用してください。
 *
 * @param path パス
 */
function largeNoneMenuWindowInherit(path) {

    // 表示項目を設定します
    var options = "width=1012, height=650, location=yes, status=yes, menubar=no";
    // 画面IDを取得します
    var windowId = getWindowID();
    // path変数に「?」があるかどうかを判定します
    if (path.indexOf('?') != -1) {
        path = path + "&";
    } else {
        path = path + "?";
    }
    path = path + CONST_INHERIT_NEWSESSION + windowId;
    // 小窓を開きます
    screens.push(window.open(path, "_blank", options));
}

/**
 * サイズ中のウィンドウを開きます
 * 親画面の画面IDとpathに指定したURL(Contoroller)の画面IDが同一の場合、親のFormを引き継ぎます。
 * ※入力補助画面など、親画面から子画面へFormを受け渡す必要がある場合、こちらを使用してください。
 *
 * @param path パス
 * @param adressBar アドレスバーの有無
 * @param statusBar ステータスバーの有無
 * @param menuBar メニューバーの有無
 */
function middleWindowInherit(path, adressBar, statusBar, menuBar) {
    var width  = "width=800";
    var height = "height=600";
    openNewWindowInherit(path, adressBar, menuBar, statusBar, width, height);
}

/**
 * サイズ中のモーダルダイアログを開きます
 * ※入力補助画面など、親画面から子画面へFormを受け渡す必要がある場合、こちらを使用してください。
 *
 * @param path パス
 * @param statusBar ステータスバーの有無
 * @param scrollBar スクロールバーの有無
 */
function middleModalDialogInherit(path, statusBar, scrollBar) {
    var width  = "dialogWidth=800px";
    var height = "dialogHeight=600px";
    openModalDialogInherit(path, statusBar, scrollBar, width, height);
}

/**
 * サイズ中のメニューバー無しウィンドウを開きます。
 * 親画面の画面IDとpathに指定したURL(Contoroller)の画面IDが同一の場合、親のFormを引き継ぎます。
 * ※入力補助画面など、親画面から子画面へFormを受け渡す必要がある場合、こちらを使用してください。
 *
 * @param path パス
 */
function middleNoneMenuWindowInherit(path) {

    // 表示項目を設定します
    var options = "width=800, height=600, location=yes, status=yes, menubar=no";
    // 画面IDを取得します
    var windowId = getWindowID();
    // path変数に「?」があるかどうかを判定します
    if (path.indexOf('?') != -1) {
        path = path + "&";
    } else {
        path = path + "?";
    }
    path = path + CONST_INHERIT_NEWSESSION + windowId;
    // 小窓を開きます
    screens.push(window.open(path, "_blank", options));
}

/**
 * サイズ小のウィンドウを開きます
 * 親画面の画面IDとpathに指定したURL(Contoroller)の画面IDが同一の場合、親のFormを引き継ぎます。
 * ※入力補助画面など、親画面から子画面へFormを受け渡す必要がある場合、こちらを使用してください。
 *
 * @param path パス
 * @param adressBar アドレスバーの有無
 * @param statusBar ステータスバーの有無
 * @param menuBar メニューバーの有無
 */
function smallWindowInherit(path, adressBar, statusBar, menuBar) {
    var width  = "width=640";
    var height = "height=480";
    openNewWindowInherit(path, adressBar, menuBar, statusBar, width, height);
}

/**
 * サイズ小のモーダルダイアログを開きます
 * 親画面の画面IDとpathに指定したURL(Contoroller)の画面IDが同一の場合、親のFormを引き継ぎます。
 * ※入力補助画面など、親画面から子画面へFormを受け渡す必要がある場合、こちらを使用してください。
 *
 * @param path パス
 * @param statusBar ステータスバーの有無
 * @param scrollBar スクロールバーの有無
 */
function smallModalDialogInherit(path, statusBar, scrollBar) {
    var width  = "dialogWidth=640px";
    var height = "dialogHeight=480px";
    openModalDialogInherit(path, statusBar, scrollBar, width, height);
}

/**
 * サイズ小のメニューバー無しウィンドウを開きます。
 * 親画面の画面IDとpathに指定したURL(Contoroller)の画面IDが同一の場合、親のFormを引き継ぎます。
 * ※入力補助画面など、親画面から子画面へFormを受け渡す必要がある場合、こちらを使用してください。
 *
 * @param path パス
 */
function smallNoneMenuWindowInherit(path) {

    // 表示項目を設定します
    var options = "width=640, height=480, location=yes, status=yes, menubar=no";
    // 画面IDを取得します
    var windowId = getWindowID();
    // path変数に「?」があるかどうかを判定します
    if (path.indexOf('?') != -1) {
        path = path + "&";
    } else {
        path = path + "?";
    }
    path = path + CONST_INHERIT_NEWSESSION + windowId;
    // 小窓を開きます
    screens.push(window.open(path, "_blank", options));
}
