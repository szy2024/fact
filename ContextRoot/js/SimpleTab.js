//--------------------------------------------------------------------
// SimpleTabクラス
//--------------------------------------------------------------------
// 概要：タブ名に対応した頁を表示する。
//--------------------------------------------------------------------
// V1.0        2009/09/04    新規作成
//--------------------------------------------------------------------
// Name                Type     Note                          Required
// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
// strTabNameArray     Array    タブ名一覧                        必須
// strPageNameArray    Array    タブに対応する頁名一覧            必須
//--------------------------------------------------------------------
function SimpleTab(strTabNameArray, strPageNameArray){
    var owner = this;
    
    for(var i=0; i<strTabNameArray.length; i++){
        var objTab = document.getElementById(strTabNameArray[i]);
        var objPage = document.getElementById(strPageNameArray[i]);
        // 初期画面設定
        if(objTab.className!=="active"){
            objPage.style.display="none";
        }
        // タブをクリックした時の処理を登録
        owner.changePage(objTab, strTabNameArray, strPageNameArray);
    }
}


SimpleTab.prototype = {
    // タブ押下時のページ切り替え
    changePage: function(objTab, strTabNameArray, strPageNameArray) {
        objTab.onclick = function() {
        	setTab(objTab, strTabNameArray, strPageNameArray);
        };
    }
};

function setTab(objTab, strTabNameArray, strPageNameArray) {
	for(var i=0; i<strTabNameArray.length; i++){
	    var objTabName = document.getElementById(strTabNameArray[i]);
	    var objPageName = document.getElementById(strPageNameArray[i]);
	    if(objTabName===objTab){
	        // 選択されたタブを選択状態にする
	        objTabName.className="active";
	        // 選択されたタブのフォーカスを外す
	        objTabName.firstChild.blur();
	        // 選択されたページを表示する
	        objPageName.style.display="block";
	    } else {
	        // 非選択の各タブを非選択状態にする
	        objTabName.className="passive";
	        // 非選択の各ページを非表示にする
	        objPageName.style.display="none";
	    }
	}
}
