document.onkeydown = commonOnkeydownProcess;

function commonOnkeydownProcess() {
    
    if (navigator.appName == "Microsoft Internet Explorer") { 
        
        // 【onKeyDown】イベントが発生時した【INPUTタグ】情報を取得します
        var element = event.srcElement;
        
        // 押下されたキーが【ALT＋←】の場合 
        if (event.keyCode == 0x25 && event.altKey == true) { 
            return false ;
        }
        
        // イベント発生項目が【text】、【password】、【textarea】、【file】の場合
        if (element.type == "text" ||  element.type == "password" || element.type == "textarea" || element.type == "file") {
            // 押下されたキーが【ENTERキー】の場合
            if (element.type != "textarea" && event.keyCode == 13) {
                return false;
            // 非活性状態で押下されたキーが【back space】の場合
            } else if (element.readOnly != "" && event.keyCode == 8) {
                return false;
            }
            return true;
        }
        
        // 押下されたキーが【back space】の場合
        if (event.keyCode == 8) { 
            return false;
        }
    }
}
