/**
 * 入力できない文字(952文字)
 * (SJIS 0x8740から0x87FF 及び 0xED40以降)
 * PGEMの1行当たりの文字数に引っかかるため複数行に分割
 * 
 */
var disableChars ="";
//var disableChars ="①②③④⑤⑥⑦⑧⑨⑩⑪⑫⑬⑭⑮⑯⑰⑱⑲⑳ⅠⅡⅢⅣⅤⅥⅦⅧⅨⅩ" +
//	"・㍉㌔㌢㍍㌘㌧㌃㌶㍑㍗㌍㌦㌣㌫㍊㌻㎜㎝㎞㎎㎏㏄㎡・・・・・・・・㍻〝〟№㏍" +
//	"℡㊤㊥・㊧㊨㈱㈲㈹㍾㍽㍼≒≡∫∮∑√⊥∠∟⊿∵∩∪・・・・・・・・・・・・" +
//	"・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・" +
//	"・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・" +
//	"・・・・・・・・・・纊褜鍈銈蓜俉炻昱棈鋹曻彅丨仡仼伀伃伹佖侒侊侚侔俍偀倢俿" +
//	"倞偆偰偂傔僴僘兊兤冝冾凬刕劜劦勀勛匀匇匤卲厓厲叝﨎咜咊咩哿喆坙坥垬埈埇﨏塚" +
//	"增墲夋奓奛奝澵妤妺孖寀甯寘寬尞岦岺峵崧嵓﨑嵂嵭嶸嶹巐弡弴彧德忞恝悅悊惞惕愠" +
//	"惲愑愷愰憘戓抦揵摠撝擎敎昀昕昻昉昮昞昤晥晗晙晴晳暙暠暲暿曺朎朗杦枻桒柀栁桄" +
//	"棏﨓楨﨔榘槢樰橫橆橳橾櫢櫤毖氿汜沆汯泚洄涇浯涖涬淏淸淲淼渹湜渧渼溿澈澵濵瀅" +
//	"瀇瀨炅炫焏焄煜煆煇凞燁燾犱犾猤猪獷玽珉珖珣珒琇珵琦琪琩琮瑢璉璟甁畯皂皜皞皛" +
//	"皦益睆劯砡硎硤硺礰礼神祥禔福禛竑竧靖竫箞精絈絜綷綠緖繒罇羡羽茁荢荿菇菶葈蒴" +
//	"蕓蕙蕫﨟薰蘒﨡蠇裵・訷詹誧誾諟諸諶譓譿賰賴贒赶﨣軏﨤逸遧郞都鄕鄧釚釗釞釭釮" +
//	"釤釥鈆鈐鈊鈺鉀鈼鉎鉙鉑鈹鉧銧鉷鉸鋧鋗鋙鋐﨧鋕鋠鋓錥錡鋻﨨錞鋿錝錂鍰鍗鎤鏆鏞" +
//	"鏸鐱鑅鑈閒隆﨩隝隯霳霻靃靍靏靑靕顗顥飯飼餧館馞驎髙髜魵魲鮏鮱鮻鰀鵰鵫鶴鸙黑" +
//	"・・ⅰⅱⅲⅳⅴⅵⅶⅷⅸⅹ￢￤＇＂ⅰⅱⅲⅳⅴⅵⅶⅷⅸⅹⅠⅡⅢⅣⅤⅥⅦⅧⅨⅩ￢" +
//	"￤＇＂㈱№℡∵纊褜鍈銈蓜俉炻昱棈鋹曻彅丨仡仼伀伃伹佖侒侊侚侔俍偀倢俿倞偆偰" +
//	"偂傔僴僘兊兤冝冾凬刕劜劦樰勛匀匇匤卲厓厲叝﨎咜咊咩哿喆坙坥垬埈埇﨏塚增墲夋" +
//	"奓奛奝奣妤妺孖寀甯寘寬尞岦岺峵崧嵓﨑嵂嵭嶸嶹巐弡弴彧德忞恝悅悊惞惕愠惲愑愷" +
//	"愰憘戓抦揵摠撝擎敎昀昕昻昉昮昞昤晥晗晙晴晳暙暠暲暿曺朎朗杦枻桒柀栁桄棏﨓楨" +
//	"﨔榘槢樰橫橆橳橾櫢櫤毖氿汜沆汯泚洄涇浯涖涬淏淸淲淼渹湜渧渼溿澈澵濵瀅瀇瀨炅" +
//	"炫焏焄煜煆煇凞燁燾犱犾猤猪獷玽珉珖珣珒琇珵琦琪琩琮瑢璉璟甁畯皂皜皞皛皦益睆" +
//	"劯砡硎硤硺礰礼神祥禔福禛竑竧靖霳箞精絈絜綷綠緖繒罇羡羽茁荢荿菇菶葈蒴蕓蕙蕫" +
//	"﨟薰蘒﨡蠇裵訒訷詹誧誾諟諸諶譓譿賰賴贒赶﨣軏﨤逸遧郞都鄕鄧釚釗釞釭釮釤釥鈆" +
//	"鈐鈊鈺鉀鈼鉎鉙鉑鈹鉧銧鉷鉸鋧鋗鋙鋐﨧鋕鋠鋓錥錡鋻﨨錞鋿錝錂鍰鍗鎤鏆鏞鏸鐱鑅" +
//	"鑈閒隆﨩隝隯霳霻靃靍靏靑靕顗顥飯飼餧館馞驎髙髜魵魲鮏鮱鮻鰀鵰鵫鶴鸙黑∥～－" +
//	"￠￡￢";

	/**
	 * 年号テーブルです。
	 */
	var DATE_TABLE = [
		[0,1,12,32],
		[99,1989,1,8],
		[64,1926,12,25],
		[15,1912,7,30],
		[45,1868,9,8]
	];

	/**
	 * 半角カタカナ文字データテーブルです。
	 * @modelguid {FAFE6656-F924-41EA-BEE9-41649F0C089A}
	 */
	var HANKAKU_KATAKANA = "";
//	var HANKAKU_KATAKANA = [
//		"ｧ","ｨ","ｩ","ｪ","ｫ",
//		"ｬ","ｭ","ｮ","ｯ","ｰ",
//
//		"ｱ","ｵ",
//		"ﾅ","ﾆ","ﾇ","ﾈ","ﾉ",
//		"ﾗ","ﾘ","ﾙ","ﾚ","ﾛ",
//		"ﾏ","ﾐ","ﾑ","ﾒ","ﾓ",
//		"ﾔ","ﾕ","ﾖ","ﾝ",
//
//		"ｶ","ｷ","ｸ","ｹ","ｺ",
//		"ｻ","ｼ","ｽ","ｾ","ｿ",
//		"ﾀ","ﾁ","ﾂ","ﾃ","ﾄ",
//		"ﾊ","ﾋ","ﾌ","ﾍ","ﾎ",
//		"ｳ","ﾜ","ｦ","ｲ","ｴ",
//
//		"ｶﾞ","ｷﾞ","ｸﾞ","ｹﾞ","ｺﾞ",
//		"ｻﾞ","ｼﾞ","ｽﾞ","ｾﾞ","ｿﾞ",
//		"ﾀﾞ","ﾁﾞ","ﾂﾞ","ﾃﾞ","ﾄﾞ",
//		"ﾊﾞ","ﾋﾞ","ﾌﾞ","ﾍﾞ","ﾎﾞ",
//		"ｳﾞ","ﾜﾞ","ｦﾞ","ｲﾞ","ｴﾞ",
//		"ﾊﾟ","ﾋﾟ","ﾌﾟ","ﾍﾟ","ﾎﾟ",
//
//		"｡","｢","｣","､","･","ﾞ","ﾟ",
//		"ｰ","(",")",".","-",
//
//		"0","1","2","3","4","5","6","7","8","9",
//
//		"a","b","c","d","e","f","g",
//		"h","i","j","k","l","m","n",
//		"o","p","q","r","s","t","u",
//		"v","w","x","y","z",
//		"A","B","C","D","E","F","G",
//		"H","I","J","K","L","M","N",
//		"O","P","Q","R","S","T","U",
//		"V","W","X","Y","Z",
//	];

	/**
	 * 全角カタカナ文字データテーブル。
	 * @modelguid 7238F7B7-39DD-47D4-99E5-0C0CFE7FE4F5
	 */
	var ZENKAKU_KATAKANA = "";
//	var ZENKAKU_KATAKANA = [
//		"ァ","ィ","ゥ","ェ","ォ",
//		"ャ","ュ","ョ","ッ","ー",
//
//		"ア","オ",
//		"ナ","ニ","ヌ","ネ","ノ",
//		"ラ","リ","ル","レ","ロ",
//		"マ","ミ","ム","メ","モ",
//		"ヤ","ユ","ヨ","ン",
//
//		"カ","キ","ク","ケ","コ",
//		"サ","シ","ス","セ","ソ",
//		"タ","チ","ツ","テ","ト",
//		"ハ","ヒ","フ","ヘ","ホ",
//		"ウ","ワ","ヲ","イ","エ",
//
//		"ガ","ギ","グ","ゲ","ゴ",
//		"ザ","ジ","ズ","ゼ","ゾ",
//		"ダ","ヂ","ヅ","デ","ド",
//		"バ","ビ","ブ","ベ","ボ",
//		"ヴ","\u30f7","\u30fa","\u30f8","\u30f9",
//		"パ","ピ","プ","ペ","ポ",
//
//		"。","「","」","、","・","゛","゜",
//		"ー","（","）","．","－",
//
//		"０","１","２","３","４","５","６","７","８","９",
//		"ａ","ｂ","ｃ","ｄ","ｅ","ｆ","ｇ",
//		"ｈ","ｉ","ｊ","ｋ","ｌ","ｍ","ｎ",
//		"ｏ","ｐ","ｑ","ｒ","ｓ","ｔ","ｕ",
//		"ｖ","ｗ","ｘ","ｙ","ｚ",
//		"Ａ","Ｂ","Ｃ","Ｄ","Ｅ","Ｆ","Ｇ",
//		"Ｈ","Ｉ","Ｊ","Ｋ","Ｌ","Ｍ","Ｎ",
//		"Ｏ","Ｐ","Ｑ","Ｒ","Ｓ","Ｔ","Ｕ",
//		"Ｖ","Ｗ","Ｘ","Ｙ","Ｚ"
//	];



/**
 * エラーメッセージ蓄積用
 */
var errorMessage = "";


/**
 * 項目タイプと属性を指定して入力値をチェックします。
 * 正常な場合trueを返します。
 * 
 * @param fieldType   フォーマット
 * @param fieldName   name属性
 * @param nFieldName  項目名（メッセージ表示）
 * @param maxLength   指定桁数(-1の場合、指定桁数チェックはしない)
 * @param isRequired  必須チェック
 * @param isFullField フル桁チェック
 * @param isIntegerLen   整数部桁チェック
 * @param fracLength  小数以下の桁数(-1の場合、小数以下の桁数チェックはしない)
 * @param min         最小値
 * @param max         最大値
 */
function checkField(fieldType, fieldName, nFieldName, maxLength, isRequired, isFullField, isIntegerLen, fracLength, min, max){
	// JSチェック
	if (isJsCheck()) {
		return;
	}
	var chk_flg = true;

	var item = "document.getElementById('" + fieldName +"').style.backgroundColor='white'";
	eval(item);

	var arraiSize;
	var baseName;
	var isArray = true;
	var count = "document.getElementById('" + fieldName +"').length";
	count = eval(count);

	// 配列でないものはcountを1とする。
	if ((typeof count) == "undefined"){
		 count = 1;
		isArray = false;
	} else {
		baseName = fieldName;
	}

	for (arraySize = 0; arraySize < count; arraySize++){
		// fieldNameは項目名
		if (isArray) {
			fieldName = baseName + "[" + arraySize + "]";
		}
		var fieldValue = "document.getElementById('" + fieldName + "').value";
		// strは項目値
		str = eval(fieldValue);
		
		// 項目固有のチェックから行う。
		chk_flg = checkFieldOnly(fieldType, str, fieldName, nFieldName);
		if (!chk_flg) {
			return false;
		}
		// 数字項目は値の変更があるかもしれないので再度取得する。
		if (fieldType == "HS") {
			str = eval(fieldValue);
		}

		// 共通的なチェックを行う。
		// 必須入力チェック
		if (isRequired) {
			if (!Required_chk(str)) {
				setErrorMessage("errors.required", fieldName, nFieldName);
				return false;
			}
		}
		
		// 指定桁数チェック
		if (maxLength != -1 || fracLength != -1) {
			// 数値項目は小数桁を分けてチェック
			if (fieldType == "HS" || fieldType == "HD") {
				if(!NumLengthCheck(str, maxLength, fracLength, isIntegerLen, fieldName, nFieldName)){
					return false;
				}
			// 文字列の最大桁数チェック
			} else if (!MaxLength_chk(fieldType, str, fieldName, nFieldName, maxLength)) {
				setErrorMessage("errors.maxlength", fieldName, nFieldName, maxLength);
				return false;
			}
		}
		
		// フル桁入力チェック
		// maxLengthが-1でなく、isFullFieldがtrueの時
		if (maxLength != -1 && isFullField) {
			if (fieldType == "HS") {
				// 小数部の桁数が指定されている場合の考慮
				var strLength = parseLength(str,maxLength);
				if(fracLength != -1){
					strLength += fracLength;
				}
				if (!FullField_chk(str, strLength) ) {
					setErrorMessage("errors.fulllength", fieldName, nFieldName, maxLength);
					return false;
				}
			} else {
				if (!FullField_chk(str, maxLength)) {
					setErrorMessage("errors.fulllength", fieldName, nFieldName, maxLength);
					return false;
				}
			}
		}

		// 数値範囲チェック
		if (fieldType == "HS") {
			if (!isNumArea(fieldName, nFieldName, min, max)) {
				setErrorMessage("errors.minus_number", fieldName, nFieldName);
				return false;
			}
		}
	}
	return chk_flg;
}

/**
 * 和暦日付のチェックを行います。
 * 
 * 正常な場合trueを返します。
 * @param gengo 元号項目のname属性
 * @param year  年項目のname属性
 * @param month 月項目のname属性
 * @param day   日項目のname属性
 */
function checkWarekiDateField(gengo, year, month, day, nFieldName){
	if (isJsCheck()){
		return;
	}
	var chk_flg = true;
	
	// 背景色を白にします。
	eval("document.getElementById('" + year + "').style.backgroundColor='white'");
	eval("document.getElementById('" + month + "').style.backgroundColor='white'");
	eval("document.getElementById('" + day + "').style.backgroundColor='white'");
	eval("document.getElementById('" + gengo + "').style.backgroundColor='white'");

	var yearVal = eval("document.getElementById('" + year + "').value");
	var monthVal = eval("document.getElementById('" + month + "').value");
	var dayVal = eval("document.getElementById('" + day + "').value");
	var gengoVal = eval("document.getElementById('" + gengo + "').value");

	// 入力された値が２桁以上の場合
	if (2 < yearVal.length || 2 < monthVal.length || 2 < dayVal.length) {
		chk_flg = false;
	}
	
	// 空白を取り除きます。
	yearVal = yearVal.replace(/^\s+|\s+$/g, "");
	monthVal = monthVal.replace(/^\s+|\s+$/g, "");
	dayVal = dayVal.replace(/^\s+|\s+$/g, "");
	
	// 年月日のいずれかが空の場合
	if (yearVal == "" && monthVal == "" && dayVal == "" && gengoVal == "") {
		return true;
	} else if (yearVal == "" || monthVal == "" || dayVal == "" || gengoVal == "") {
		chk_flg = false;
	} else {
		// 元号のチェック
		if (gengoVal == "H" || gengoVal == "平成") {
			if ( !checkDate(yearVal, monthVal, dayVal, 1) ) chk_flg = false;
		} else if (gengoVal == "S" || gengoVal == "昭和") {
			if ( !checkDate(yearVal, monthVal, dayVal, 2) ) chk_flg = false;
		} else if (gengoVal == "T" || gengoVal == "大正") {
			if ( !checkDate(yearVal, monthVal, dayVal, 3) ) chk_flg = false;
		} else if (gengoVal == "M" || gengoVal == "明治") {
			if ( !checkDate(yearVal, monthVal, dayVal, 4) ) chk_flg = false;
		} else {
			chk_flg = false;
		}
	}
	// フラグがfalseの場合、エラーを設定します
	if (!chk_flg) {
		setErrorMessage("errors.date", gengo, nFieldName);
		setErrorField(year);
		setErrorField(month);
		setErrorField(day);
	}

	return chk_flg;
}

/**
 * 蓄積したエラーメッセージを返します。
 * 
 * @param fieldName エラー項目のid属性
 */
function flushErrorMessage(fieldName){
	// メッセージエリアに蓄積したエラーメッセージを書き込みます
	var item = "document.getElementById('"+fieldName+"').innerHTML = '"+errorMessage+"';";
	eval(item);
	// エラーメッセージを蓄積している変数の中身をクリアします
	errorMessage = "";
	var messageArea = "document.getElementById('"+fieldName+"').innerHTML";
	// メッセージエリアにエラーメッセージが書き込まれている場合true、書き込まれていない場合false
	if (eval(messageArea) != "") {
		return true;
	} else {
		return false;
	}
}



/**
 * デバッグモードを返します。
 * 
 * javascriptによるチェックを行わない場合
 */
function isJsCheck(){
	//return ( eval("document.getElementById('jscheck')") != undefined );

	var modeFlag = eval("document.getElementById('jscheck').value");
	return "true" != modeFlag;
}

/**
 * 項目タイプを指定して入力値をチェックします。
 * 
 * @param fieldType   フォーマット
 * @param str         入力文字列
 * @param fieldName   name属性
 * @param nFieldName  項目名（メッセージ表示）
 * @returns {Boolean} 正常true : 異常false
 */
function checkFieldOnly(fieldType, str, fieldName, nFieldName){
	var chk_flg = true;
	switch (fieldType){
		case "HN":
			// 半角数字
			if (!Suji_chk(str, fieldName, nFieldName)) {
				setErrorMessage("errors.numeric", fieldName, nFieldName);
				chk_flg = false;
			}
			break;
		case "HS":
			// 半角数値
			if (!Num_chk(str, fieldName, nFieldName)) {
				setErrorMessage("errors.minus_number", fieldName, nFieldName);
				chk_flg = false;
			}
			break;
		case "HD":
			// 半角小数付数値
			if (!Num_chk(str, fieldName, nFieldName)) {
				setErrorMessage("errors.decimal", fieldName, nFieldName);
				chk_flg = false;
			}
			break;
		case "HA":
			// 半角英字
			if (!HankakuEi_chk(str, fieldName, nFieldName)) {
				setErrorMessage("errors.alpha", fieldName, nFieldName);
				chk_flg = false;
			}
			break;
		case "HE":
			// 半角英数字
			if (!Eisu_chk(str, fieldName, nFieldName)) {
				setErrorMessage("errors.alpha_numeric", fieldName, nFieldName);
				chk_flg = false;
			}
			break;
		case "HH":
			// 半角英数記号
			if (!Eisukigou_chk(str, fieldName, nFieldName)) {
				setErrorMessage("errors.alpha_numeric_sigin", fieldName, nFieldName);
				chk_flg = false;
			}
			break;
		case "ZH":
			// 全角ひらがな
			if (!ZenkakuHiragana_chk(str, fieldName, nFieldName)) {
				setErrorMessage("errors.hiragana", fieldName, nFieldName);
				chk_flg = false;
			}
			break;
		case "ZK":
			// 全角カタカナ
			if (!ZenkakuKatakana_chk(str, fieldName, nFieldName)) {
				setErrorMessage("errors.katakana", fieldName, nFieldName);
				chk_flg = false;
			}
			break;
		case "ZZ":
			// 全角文字
			if (!Zenkaku_chk(str, fieldName, nFieldName)) {
				setErrorMessage("errors.full_character", fieldName, nFieldName);
				chk_flg = false;
			}
			break;
		case "TL":
			// 電話番号（６桁～１４桁）
			if (!TellNumberLong_chk(str, fieldName, nFieldName)) {
				setErrorMessage("errors.tel_number", fieldName, nFieldName);
				chk_flg = false;
			}
			break;
		case "TS":
			// 電話番号（３桁～９桁）
			if (!TellNumberShort_chk(str, fieldName, nFieldName)) {
				setErrorMessage("errors.tel_number_short", fieldName, nFieldName);
				chk_flg = false;
			}
			break;
		case "FX":
			// FAX番号
			if (!FAXNumber_chk(str, fieldName, nFieldName)) {
				setErrorMessage("errors.fax_number", fieldName, nFieldName);
				chk_flg = false;
			}
			break;
		case "ZP":
			// 郵便番号
			if (!ZipNumber_chk(str, fieldName, nFieldName)) {
				setErrorMessage("errors.zip_code", fieldName, nFieldName);
				chk_flg = false;
			}
			break;
		case "DD":
			// 日付（YYYYMMDD）
			if (!Date_chk_yyyymmdd(str, fieldName, nFieldName)) {
				setErrorMessage("errors.date", fieldName, nFieldName);
				chk_flg = false;
			}
			break;
		case "DS":
			// 日付（YYYY/MM/DD）
			if (!Date_chk_yyyymmdd_separate(str, fieldName, nFieldName)) {
				setErrorMessage("errors.date_separate", fieldName, nFieldName);
				chk_flg = false;
			}
			break;
		default:
			break;
	}
	if (chk_flg == true) {
		setNoErrorField(fieldName);
	}
	return chk_flg;
}

/**
 * 必須入力チェックをします。
 * 
 * @param str  入力文字列
 * @returns {Boolean} 正常true : 異常false
 */
function Required_chk(str){
	if (str.length == 0) {
		return false;
	} else {
		return true;
	}
}

/**
 * 桁数チェックをします。
 * 
 * @param str 入力文字列
 * @param maxLength 入力された値の全体桁数
 * @param fracLength 小数部最大桁数
 * @param isInteger 整数部桁数チェックのフラグ
 * @param fieldName フィールドID
 * @param nFieldName 項目名（メッセージ表示）
 * @returns {Boolean} 指定の桁数よりも少ない場合true : 指定の桁数よりも大きい場合false
 */
function NumLengthCheck(str, maxLength, fracLength, isInteger, fieldName, nFieldName){
	// 入力無しの場合
	if (str.length == 0) {
		return true;
	}
	// 整数部桁数のチェックを行う場合
	if (isInteger) {
		// 指定された全体の桁数に符号と小数点の桁数を加えます
		var appointMaxLength = parseLength(str, maxLength);
		integerLen = str.indexOf(".") + 1;
		// 指定された全体の桁数と指定された小数部桁数から、指定の整数部桁数を求めます
		var appointIntegerMaxLen = appointMaxLength;
		// 指定の小数部桁数が有る場合、全体の桁数から小数部桁数を引きます
		if (fracLength != -1) {
			appointIntegerMaxLen = appointMaxLength - fracLength;
		}
		
		// 整数部桁数が指定の桁数よりも大きい場合、エラー
		if (appointIntegerMaxLen < integerLen) {
			setErrorMessage("errors.maxlength", fieldName, nFieldName, appointIntegerMaxLen);
			return false;
		}
	}
	
	// 小数部桁数のチェックを行う場合
	if (fracLength > -1) {
		// 小数部桁数
		var decimalLen = str.length - (str.indexOf(".") + 1);
		if (str.indexOf(".") == -1) {
			decimalLen = -1;
		}
		// 小数部桁数が指定の桁数よりも大きい場合、エラー
		if (fracLength < decimalLen) {
			setErrorMessage("errors.maxlength", fieldName, nFieldName, fracLength);
			return false;
		}
	}
	
	// 整数部と小数部の両方の桁数のチェックを行う場合
	if (fracLength > -1 && isInteger) {
		// 指定された全体の桁数に符号と小数点の桁数を加えます
		var appointMaxLength = parseLength(str, maxLength);
		// 指定された全体の桁数と指定された小数部桁数から、指定の整数部桁数を求めます
		var appointIntegerMaxLen = appointMaxLength;
		// 指定の小数部桁数が有る場合、全体の桁数から小数部桁数を引きます
		if (fracLength != -1) {
			appointIntegerMaxLen = appointMaxLength - fracLength;
		}
		var integerLen = str.indexOf(".") + 1;
		
		// 整数部桁数が指定の桁数よりも大きい場合、エラー
		if (appointIntegerMaxLen < integerLen) {
			setErrorMessage("errors.maxlength", fieldName, nFieldName, appointIntegerMaxLen);
			return false;
		}
		// 小数部桁数
		var decimalLen = str.length - (str.indexOf(".") + 1);
		if (str.indexOf(".") == -1) {
			decimalLen = -1;
		}
		
		// 小数部桁数が指定の桁数よりも大きい場合、エラー
		if (fracLength < decimalLen) {
			setErrorMessage("errors.maxlength", fieldName, nFieldName, fracLength);
			return false;
		}
	}
}

/**
 * 最大入力文字数を超えていないかチェックします。
 * 
 * @param fieldType    フォーマット
 * @param str          入力文字列
 * @param fieldName    name属性
 * @param nFieldName   項目名（メッセージ表示）
 * @param maxLength    最大入力文字数
 * @returns {Boolean}  最大入力文字数以下の場合true : 最大入力文字数よりも大きい場合false
 */
function MaxLength_chk(fieldType, str, fieldName, nFieldName, maxLength){
	if (str.length == 0) {
		return true;
	}
	// 全角1文字は2文字分と数える
	var count = 0;
	for (i=0; i<str.length; i++) {
		n = escape(str.charAt(i));
		if (n.length < 4) {
			count++;
		} else {
			count += 2;
		}
	}
	if (count > maxLength) {
		return false;
	}

	return true;
}

/**
 * フル桁入力チェックをします。
 * 未入力時にはチェックしません。
 * 
 * @param str         入力文字列
 * @param length      指定桁数
 * @returns {Boolean} 入力文字列の桁数が、指定桁数の場合true : 指定桁数ではない場合false
 */
function FullField_chk(str, length){
	// 入力されていない場合はチェックしない
	if (str.length == 0) {
		return true;
	}
	// 全角1文字は2文字分と数える
	var count = 0;
	for (i=0; i<str.length; i++) {
		n = escape(str.charAt(i));
		if (n.length < 4) count++;
		else count+=2;
	}
	if (count == length) {
		return true;
	}
	return false;
}

/**
 * 数値項目の最小値、最大値のチェックを行います。
 * 
 * @param fieldName   name属性
 * @param nFieldName  項目名（メッセージ表示）
 * @param min         最小値
 * @param max         最大値
 * @returns {Boolean} 最大値(最小値)より大きい（小さい）場合false : 最大値(最小値)より小さい（大きい）場合true
 */
function isNumArea(fieldName, nFieldName, min, max){
	var num = eval("document.getElementById('" + fieldName + "').value");
	if(num != ""){
		if (num < min || num > max) {
			return false;
		}
	}
	return true;
}

/**
 * 和暦日付の妥当性をチェックします。
 * 
 * @param year        年
 * @param month       月
 * @param day         日
 * @param gengo       元号 
 * @returns {Boolean} ture/false
 */
function checkDate(year, month, day, gengo){
	
	// 半角数字でない場合はエラー
	if (!isSujiAll(year) || !isSujiAll(month) || !isSujiAll(day)) {
		return false;
	}
	// ゼロサプレス
	var deleteZeroYear = getDeleteZeroValue(year);
	var deleteZeroMonth = getDeleteZeroValue(month);
	var deleteZeroDay = getDeleteZeroValue(day);
	// 数値に変換します
	var yearVal = parseInt(deleteZeroYear);
	var monthVal = parseInt(deleteZeroMonth);
	var dayVal = parseInt(deleteZeroDay);

	
	// 前元号の終了と次元号の開始が同じ月日で、それを許容する特殊な場合
	// 明治の終了と大正の開始
	if (gengo == 4 && yearVal == 45 && monthVal == 7 && dayVal == 30){
		return true;
	}else if (gengo == 3 && yearVal == 1 && monthVal == 7 && dayVal == 30){
		return true;
	}
	// 大正の終了と昭和の開始
	if (gengo == 3 && yearVal == 15 && monthVal == 12 && dayVal == 25){
		return true;
	}else if (gengo == 2 && yearVal == 1 && monthVal == 12 && dayVal == 25){
		return true;
	}
	
	// 年の範囲をチェック
	if ( yearVal < 1 || yearVal > DATE_TABLE[gengo][0]) {
		return false;
	}
	// 月日の範囲をチェック
    // 開始年の場合
    if (yearVal == 1) {
    	if ((monthVal < DATE_TABLE[gengo][2]) 
    			|| (DATE_TABLE[gengo][2] == monthVal && dayVal < DATE_TABLE[gengo][3])) {
    		
    		return false;
    	}
    } 
    // 最終年の場合
    if (yearVal == DATE_TABLE[gengo][0]) {
    	// 月が最終月より大きいか、月が最終月で日が最終日以上の場合エラー
    	if ((DATE_TABLE[(gengo-1)][2] < monthVal) 
    			|| (DATE_TABLE[(gengo-1)][2] == monthVal && DATE_TABLE[(gengo-1)][3] <= dayVal)) {

    		return false;
    	}
    }
    // 存在しない日付の場合、エラー
	var sYear = yearVal + (parseInt(DATE_TABLE[gengo][1]) - 1);
	var sMonth = monthVal;
	var sDay = dayVal;
	if (!hasDate(sYear, sMonth, sDay)) {
		return false;
	}
	
	return true;
}

/**
 *  エラーメッセージを蓄積します。
 * 
 * @param errorCode   エラーコード
 * @param fieldName   name属性
 * @param nFieldName  項目名（メッセージ表示）
 * @param literal     置き換え文字
 */
function setErrorMessage(errorCode, fieldName, nFieldName, literal){
	if (errorMessage != "") {
		errorMessage = errorMessage + "<br>";
	}
	errorMessage = errorMessage + getMessage(errorCode,nFieldName, literal);
	setErrorField(fieldName);
}




/**
 * 半角数字(0～9)のチェックをします。
 * 
 * @param str         入力文字列 
 * @param fieldName   name属性
 * @param nFieldName  項目名（メッセージ表示）
 * @returns {Boolean} 半角数字だけの場合true : 半角数字以外の場合false
 */
function Suji_chk(str, fieldName, nFieldName){
	// 入力無しの場合
	if (str.length == 0) {
		return true;
	}
	// 数字（０～９）以外の場合
	if (!isSujiAll(str)) {
		return false;
	}
	
	return true;
}

/**
 * 半角数値のチェックをします。
 * 
 * @param str         入力文字列 
 * @param fieldName   name属性
 * @param nFieldName  項目名（メッセージ表示）
 * @returns {Boolean} 半角数値の場合true : 半角数値以外の場合false
 */
function Num_chk(str, fieldName, nFieldName){
	// 入力されていない場合
	if (str.length == 0) {
		return true;
	}
	// 先頭一文字目をチェックします
	var c = str.charCodeAt(0);
	var hugoFlug = false;
	// 数字「0～9」、ハイフン「-」 以外の場合、エラー
	if ((isSuji(c) || c==0x002D)) {
		if (c==0x002D) {
			hugoFlug = true;
		}
	} else {
		return hugoFlug;
	}
	
	var tenFlug = false;
	// ２文字目以降をチェックします
	for (i = 1; i <str.length; i++) {
		c = str.charCodeAt(i);
		// 数字「0～9」、小数点「.」以外の場合、エラー 
		if (!(isSuji(c) || c==0x002E)){
			return false;
		}
		// 小数点「.」だった場合
		if (c==0x002E) {
			// 小数点「.」が複数入力されていただった場合、エラー
			if (tenFlug) {
				return false;
				
			// はじめて小数点「.」が登場した場合
			} else if (!tenFlug) {
				tenFlug = true;
			}
			// 符号の後に小数点「-.1」の場合エラー
			if (i == 1 && hugoFlug) {
				return false;
			}
		}
	}
	// 最後の１文字が数字以外の場合、エラー
	if (!isSuji(str.charCodeAt(str.length - 1))) {
		return false;
	}
	return true;
}

/**
 * 半角英字のチェックをします。
 * 
 * @param str         入力文字列 
 * @param fieldName   name属性
 * @param nFieldName  項目名（メッセージ表示）
 * @returns {Boolean} 空白、英字、改行の場合true : 空白、英字、改行以外の場合false
 */
function HankakuEi_chk(str, fieldName, nFieldName){
	if (str.length == 0) {
		return true;
	}
	flg = false;
	for (i=0; i<str.length; i++) {
		var chkChar  = str.substring(i,i+1);
		var chkUnicodeChar = escape(chkChar).substring(2, 6);
		c = str.charCodeAt(i);
		
		// 空白、英字（A-Za-z）
		if ((c == 0x0020 || c >= 0x0041 && c <= 0x005a) || (c >= 0x0061 && c <= 0x007a)) {
			flg = true;
		// 改行
		} else if ("A" == chkUnicodeChar || "D" == chkUnicodeChar) {
			flg = true;
		} else {
			return false;
		}
	}
	return flg;
}

/**
 * 半角英数字のチェックをします。
 * 
 * @param str         入力文字列 
 * @param fieldName   name属性
 * @param nFieldName  項目名（メッセージ表示）
 * @returns {Boolean} 空白、英字、数字、改行の場合true : 空白、英字、数字、改行以外の場合false
 */
function Eisu_chk(str, fieldName, nFieldName){
	
	if (str.length == 0) {
		return true;
	}
	flg = false;
	for (i = 0; i < str.length; i++) {
		var chkChar  = str.substring(i,i+1);
		var chkUnicodeChar = escape(chkChar).substring(2, 6);
		c = str.charCodeAt(i);
		// 空白、英数(0-9A-Za-z)の場合は正常、それ以外はエラー
		if ((c == 0x0020 || c >=0x0030 && c <= 0x0039) 
				|| (c >= 0x0041 && c <= 0x005a) 
				|| (c >= 0x0061 && c <= 0x007a)) {
			
			flg = true;
		// 改行
		} else if ("A" == chkUnicodeChar || "D" == chkUnicodeChar) {
			flg = true;
		}else {
			return false;
		}
	}
	return flg;
}

/**
 * 半角英数記号のチェックをします。
 * 
 * @param str         入力文字列 
 * @param fieldName   name属性
 * @param nFieldName  項目名（メッセージ表示）
 * @returns {Boolean} 空白、英字、数字、記号、改行の場合true : 空白、英字、数字、記号、改行以外の場合false
 */
function Eisukigou_chk(str, fieldName, nFieldName){
	
	if (str.length == 0) {
		return true;
	}
	flg = false;
	for (i = 0; i < str.length; i++) {
		var chkChar  = str.substring(i,i+1);
		var chkUnicodeChar = escape(chkChar).substring(2, 6);
		c = str.charCodeAt(i);
		// 英数(0-9A-Za-z)
		if ((c >=0x0030 && c <= 0x0039) || (c >= 0x0041 && c <= 0x005a) || (c >= 0x0061 && c <= 0x007a)) {
			flg = true;
		}
		// 空白、記号[!"#$%&'()*+,-./:;<=>?@[\]^_`{|}~]
		else if (((c>=0x0020)&&(c<=0x002F)) || ((c>=0x003A)&&(c<=0x0040)) || ((c>=0x005B)&&(c<=0x0060)) || ((c>=0x007B)&&(c<=0x007E))) {
			flg = true;
		}
		// 改行
		else if ("A" == chkUnicodeChar || "D" == chkUnicodeChar) {
			flg = true;
		} else {
			flg = false;
			break;
		}
	}
	return flg;
}

/**
 * 全角ひらがなのチェックをします。
 * 
 * @param str         入力文字列
 * @param fieldName   name属性
 * @param nFieldName  項目名（メッセージ表示）
 * @returns {Boolean} ひらがな、全角空白、改行の場合true : ひらがな、全角空白、改行以外の場合false
 */
function ZenkakuHiragana_chk(str, fieldName, nFieldName){
	// 入力文字が無い場合
    if (str.length == 0) {
        return true;
    }
    for (i = 0; i < str.length; i++) {
    	chkChar  = str.substring(i,i+1);
		var chkUnicodeChar = escape(chkChar).substring(2, 6);
		// 全角ひらがな、全角空白、改行、以外の場合
    	if (!(("3041" <= chkUnicodeChar && chkUnicodeChar <= "3094") 
    			|| ("3099" <= chkUnicodeChar && chkUnicodeChar <= "309E") 
    			|| ("3000" == chkUnicodeChar) 
    			|| ("A" == chkUnicodeChar)
    			|| ("D" == chkUnicodeChar))){
    		
    		return false;
        }
    }
    return true;
}

/**
 * 全角カタカナのチェックをします。
 * 
 * @param str         入力文字列
 * @param fieldName   name属性
 * @param nFieldName  項目名（メッセージ表示）
 * @returns {Boolean} カタカナ、全角空白、改行の場合true : カタカナ、全角空白、改行以外の場合false
 */
function ZenkakuKatakana_chk(str, fieldName, nFieldName){
	// 入力文字が無い場合
    if (str.length == 0) {
        return true;
    }
    
    for (i = 0; i < str.length; i++) {
    	var chkChar  = str.substring(i,i+1);
		var chkUnicodeChar = escape(chkChar).substring(2, 6);
		// 全角カタカナ、全角空白、改行、以外の場合
    	if (!(("30A1" <= chkUnicodeChar && chkUnicodeChar <= "30FE") 
    			|| ("3000" == chkUnicodeChar) 
    			|| ("A" == chkUnicodeChar)
    			|| ("D" == chkUnicodeChar))){
    		
    		return false;
        }
    }
    return true;
}

/**
 * 全角文字のチェックをします。
 * 
 * @param str         入力文字列
 * @param fieldName   name属性
 * @param nFieldName  項目名（メッセージ表示）
 * @returns {Boolean} 全角文字の場合true : 全角文字以外の場合false
 */
function Zenkaku_chk(str, fieldName, nFieldName){

	// 入力不可文字のチェック
//	if (!disableChars_chk(str)){
//		setErrorMessage("MSGJX-00003", fieldName, nFieldName);
//		return false;
//	}
	if (str.length == 0) {
		return true;
	}
	var flg = true;
	for (i = 0; i < str.length; i++) {
		var chkChar  = str.substring(i,i+1);
		var chkUnicodeChar = escape(chkChar).substring(2, 6);
		c = str.charCodeAt(i);
		
		// 半角英数(0-9A-Za-z)
		if ((c >=0x0030 && c <= 0x0039) || (c >= 0x0041 && c <= 0x005a) || (c >= 0x0061 && c <= 0x007a)) {
			flg = false;
			break;
		}
		// 半角空白、半角記号[!"#$%&'()*+,-./:;<=>?@[\]^_`{|}~]
		else if (((c>=0x0020)&&(c<=0x002F)) || ((c>=0x003A)&&(c<=0x0040)) || ((c>=0x005B)&&(c<=0x0060)) || ((c>=0x007B)&&(c<=0x007E))) {
			flg = false;
			break;
		}
		// 半角カタカナ
		else if (0xFF61 <= c && c <= 0xFF9F) {
			flg = false;
			break;
		}
	}
	return flg;
}

/**
 * 電話番号（６桁～１４桁） のチェックを行います。
 * 
 * @param str          入力文字列
 * @param fieldName    name属性
 * @param nFieldName   項目名（メッセージ表示）
 * @returns {Boolean}  電話番号の形式が正しい場合true : 電話番号の形式が正しくないfalse
 */
function TellNumberLong_chk(str, fieldName, nFieldName) {
	if (str.length == 0) {
		return true;
	}
	if (str.match(/^0[0-9]{1,4}-[0-9]{1,4}-[0-9]{1,4}$/)) {
		return true;
	}
	
	return false;
}

/**
 * 電話番号（３桁～９桁） のチェックを行います。
 * 
 * @param str          入力文字列
 * @param fieldName    name属性
 * @param nFieldName   項目名（メッセージ表示）
 * @returns {Boolean}  電話番号の形式が正しい場合true : 電話番号の形式が正しくないfalse
 */
function TellNumberShort_chk(str, fieldName, nFieldName) {
	if (str.length == 0) {
		return true;
	}
	if (str.match(/^[0-9]{1,4}-[0-9]{1,4}$/)) {
		return true;
	}
	
	return false;
}

/**
 * FAX番号のチェックを行います。
 * 
 * @param str          入力文字列
 * @param fieldName    name属性
 * @param nFieldName   項目名（メッセージ表示）
 * @returns {Boolean}  FAX番号の形式が正しい場合true : FAX番号の形式が正しくないfalse
 */
function FAXNumber_chk(str, fieldName, nFieldName) {
	if (str.length == 0) {
		return true;
	}
	if (str.match(/^0[0-9]{1,4}-[0-9]{1,4}-[0-9]{1,4}$/)) {
		return true;
	}
	
	return false;
}

/**
 * 郵便番号のチェックを行います。
 * 
 * @param str          入力文字列
 * @param fieldName    name属性
 * @param nFieldName   項目名（メッセージ表示）
 * @returns {Boolean}  郵便番号の形式が正しい場合true : 郵便番号の形式が正しくないfalse
 */
function ZipNumber_chk(str, fieldName, nFieldName) {
	if (str.length == 0) {
		return true;
	}
	if (str.match(/^[0-9]{3}-[0-9]{4}$/)) {
		return true;
	}
	
	return false;
}

/**
 * 日付（YYYYMMDD）のチェックを行います。
 * 
 * @param str          入力文字列
 * @param fieldName    name属性
 * @param nFieldName   項目名（メッセージ表示）
 * @returns {Boolean}  日付が正しい場合true : 日付が正しくない場合false
 */
function Date_chk_yyyymmdd(str, fieldName, nFieldName){
	// 入力が無い場合
	if (str.length == 0) {
		return true;
	}
	// ８桁以外の場合、エラー
	if (str.length != 8) {
		return false;
	}
	// 半角数字以外の場合、エラー
	if (!isSujiAll(str)) {
		return false;
	}
	// 年月日に分けます
	var year = str.substring(0, 4);
	var month = str.substring(4, 6);
	var day = str.substring(6, 8);
	
	// 日付の妥当性をチェックします
	var yearVal = parseInt(year);
	var monthVal = parseInt(month);
	var dayVal = parseInt(day);
	if (!hasDate (yearVal, monthVal, dayVal)) {
		return false;
	}
	
    return true;
}

/**
 * 日付（YYYY/MM/DD）のチェックを行います。
 * 
 * @param str          入力文字列
 * @param fieldName    name属性
 * @param nFieldName   項目名（メッセージ表示）
 * @returns {Boolean}  日付が正しい場合true : 日付が正しくない場合false
 */
function Date_chk_yyyymmdd_separate(str, fieldName, nFieldName){
	// 入力が無い場合
	if (str.length == 0) {
		return true;
	}
	// １０桁以上の場合、エラー
	if (10 < str.length) {
		return false;
	}
	// 半角数字、「/」以外の場合、エラー
	for (i=0; i<str.length; i++) {
		c = str.charCodeAt(i);
		if (!isSuji(c) && c != 0x2f) {
			return false;
		}
	}
	// 最後の一文字が区切り文字だった場合、エラー
	if (str.lastIndexOf("/", str.length -1) == str.length -1) {
		return false;
	}
	// 年月日に分けます
	var dateArray = new Array(3); 
	dateArray = str.split("/");
	// 年{４桁}、月{１桁か２桁以外}、日{１桁か２桁以外}の場合、エラー
	if (dateArray[0].length != 4
			|| (dateArray[1].length < 1 || 2 < dateArray[1].length) 
			|| (dateArray[2].length < 1 || 2 < dateArray[2].length)) {

		return false;
	}
	var year = getDeleteZeroValue(dateArray[0]);
	var month = getDeleteZeroValue(dateArray[1]);
	var day = getDeleteZeroValue(dateArray[2]);
	// 日付の妥当性をチェックします
	var yearVal = parseInt(year);
	var monthVal = parseInt(month);
	var dayVal = parseInt(day);
	if (!hasDate(yearVal, monthVal, dayVal)) {
		return false;
	}
	
	return true;
}

/**
 * 日付の妥当性をチェックします。
 * 
 * @param yearVal     年
 * @param monthVal    月
 * @param dayVal      日
 * @returns {Boolean} 存在する日付の場合true : 存在しない日付の場合false
 */
function hasDate (yearVal, monthVal, dayVal) {
	
	// 年の範囲をチェック
	if (yearVal < 1 || 9999 < yearVal) {
        return false;
    }
	// 月の範囲をチェック
	if (monthVal < 1 || 12 < monthVal) {
        return false;
    }
	// 日の範囲をチェック
    if (dayVal < 1 || 31 < dayVal) {
        return false;
    }
    // ３０日までしかない月が３１日だった場合、エラー
    if (dayVal == 31 && (monthVal == 4 || monthVal == 6 
    		|| monthVal == 9 || monthVal == 11)){ 
    	
        return false;
    }
    // ２月が２９日より多い場合、エラー
    if (monthVal == 2 && dayVal > 29) {
        return false;
    }
    // ２月２９日であり、うるう年ではない場合、エラー
    if (monthVal == 2 && dayVal == 29) {
    	if(!((yearVal % 4 == 0) && 
    			(yearVal % 100 != 0 || yearVal % 400 == 0))) {
    		
    		return false;
    	}
    }
    
    return true;
}

/**
 * 桁数変換を行います。
 * 
 * @param str        入力文字列
 * @param maxLength  入力最大桁数
 * @returns          変換された入力最大桁数
 */
function parseLength(str, maxLength){
	var plusLen = 0;
	// 小数点が付いてる場合
	if ((str.indexOf(".")) > -1) {
		maxLength = maxLength + 1;
	}
	// マイナスの値の場合
	if (str.charAt(0) == '-') {
		maxLength = maxLength + 1;
	}
	return maxLength;
}

/**
 * エラーではないフィールドの背景色をクリアします。
 * 
 * @param fieldName name属性
 */
function setNoErrorField(fieldName){
	var item = "document.getElementById('" + fieldName +"').style.backgroundColor=''";
	eval(item);
}

/**
 * エラーフィールドの背景色をピンクにします。
 * 
 * @param fieldName name属性
 */
function setErrorField(fieldName){
	var item = "document.getElementById('" + fieldName +"').style.backgroundColor='pink'";
	eval(item);
}



/**
 * 数字(０～９)の妥当性をチェックします。
 * 
 * @param c  入力文字（一文字）
 * @returns　　数字の場合true : 数字以外の場合false
 */
function isSuji(c){
	flg = false;
	if (c >=0x0030 && c <= 0x0039) {
		flg = true;
	}
	return flg;
}

/**
 * 数字(０～９)の妥当性をチェックします。
 * 
 * @param str  入力文字列
 * @returns　　数字の場合true : 数字以外の場合false
 */
function isSujiAll(str){
	for (i=0; i<str.length; i++) {
		c = str.charCodeAt(i);
		if (c < 0x0030 || 0x0039 < c) {
			return false;
		}
	}
	return true;
}

/**
 * ゼロサプレスした値を返します。
 * 
 * @param str  入力文字列
 * @returns　　    ゼロサプレスした値
 */
function deleteZero(str){
	// ゼロが含まれない場合は無条件にリターン
	if (str.indexOf("0") == -1) {
		return str;
	} else if (str.indexOf("0") == 0) {
		// 1文字目が0の時
		return getDeleteZeroValue(str);
	} else if (str.indexOf("0") == 1) {
		// 2文字目が0の時(符号がある場合)
		if (str.charAt(0) == "-") {
			fugou = str.substring(0,1);
			str = getDeleteZeroValue(str.substring(1,str.length));
			str = fugou + str;
		}
	}
	return str;
}

/**
* ゼロを削除します
*/
function getDeleteZeroValue(str){
	while(str.indexOf("0") == 0) {
		// 長さが1の時はそのままリターン
		if (str.length == 1) {
			return str;
			break;
		} else {
			str = str.substring(1, str.length);
		}
	}
	return str;
}



/**
 * 全角文字のチェックを行います。
 * 入力不可文字が含まれるとfalseを返します。
 */
//function disableChars_chk(str){
//	for (i=0; i<str.length; i++) {
//		if (disableChars.indexOf(str.charAt(i)) > -1
//		// "・"は除外
//		&& str.charCodeAt(i) != 12539
//		// "≒"は除外
//		&& str.charCodeAt(i) != 8786
//		// "≡"は除外
//		&& str.charCodeAt(i) != 8801
//		// "∫"は除外
//		&& str.charCodeAt(i) != 8747
//		// "√"は除外
//		&& str.charCodeAt(i) != 8730
//		// "⊥"は除外
//		&& str.charCodeAt(i) != 8869
//		// "∠"は除外
//		&& str.charCodeAt(i) != 8736
//		// "∩"は除外
//		&& str.charCodeAt(i) != 8745
//		// "∪"は除外
//		&& str.charCodeAt(i) != 8746
//		// "∵"は除外
//		&& str.charCodeAt(i) != 8757)
//			return false;
//	}
//	return true;
//}

