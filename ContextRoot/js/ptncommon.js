/**
 *  Title           ptncommon.js
 *  Created     	2005/03/28
 */

var win;

/**
 *  関数名：OpenWin
 *  概要　：ヘルプウィンドウを開く
 *  引数　：url_name   ヘルプファイルのパス
 *  　　　：window_id  ウィンドウのターゲット
 *  備考　：ヘルプウィンドウが表示されていない場合は、top=0/left=0の位置に表示
 *  　　　：ヘルプウィンドウが表示されている場合は、既存のウィンドウの位置に表示
 */

function OpenWin(url_name, window_id){

	var file_path;
	var target_id;
	var strTemp;
	var nSizeWidth;	//幅
	var nSizeHeight;	//高さ

	file_path = url_name;
	target_id = window_id;
	if (!file_path) return;
	
	//画面の解像度を取得
	nSizeWidth = 0;
	nSizeHeight = 0;
	nSizeWidth = screen.width;
	nSizeHeight = screen.height;



	//幅と高さを半分に設定する。
	nSizeWidth = nSizeWidth / 3;
	nSizeHeight = nSizeHeight / 2;

	strTemp = "left=0,top=0,width=" + nSizeWidth +",height=" + nSizeHeight + ",toolbar=no,scrollbars=yes,status=no,resizable=no,menubar=no,location=no";
	
	if (!(window.parent.get_Value())){
		window.parent.set_Value(
				window.open(file_path, target_id, strTemp)

		// ウインドウオープンの際の初期表示位置の指定
		// IEのプロパティleft、topで指定しているので使用しない
		// window.parent.move_Disp('0','0');
	);
		
	}else{
		window.parent.set_Value(window.open(file_path, target_id));
	}
	window.parent.win.focus();
}

/**
 *  関数名：set_Value
 *  概要　：オブジェクトセット関数
 *  引数　：objwin  ウィンドウオブジェクト
 *  備考　：
 */
function set_Value(objwin){
	win = objwin;
}	

/**
 *  関数名：get_Value
 *  概要　：オブジェクト取得関数
 *  引数　：なし
 *  備考　：
 */
function get_Value(){
	// オブジェクトが存在しないまたは画面が閉じている場合
	if (!win || win.closed){
		return false;
	}
	else{
		return true;
	}
}

/**
 *  関数名：move_Disp
 *  概要　：画面移動用関数
 *  引数　：なし
 *  備考　：未使用
 */
/*
function move_Disp(x,y){
	win.moveTo(x,y);
}	
*/

/**
 *  関数名：close_subWin
 *  概要　：サブウィンドウクローズ関数
 *  引数　：なし
 *  備考　：ヘルプファイル内に記述
 */
function close_subWin(){
    window.parent.close();
}

/**
 *  関数名：win_close
 *  概要　：親ウィンドウクローズ時にサブウインドウを閉じる
 *  引数　：なし
 *  備考　：
 */
function win_close(){

	// サブウインドウのオブジェクトが存在する場合
	if (win){
		win.close();
	}
}

