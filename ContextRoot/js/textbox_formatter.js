/* ================================================================================================================= */
/* 概要：テキストボックスのフォーマット設定                                                                          */
/* 詳細：特定のclassを設定することにより、フォーカス時・フォーカスアウト時にフォーマットの設定・解除を行う。         */
/*       対応するclass及びフォーマットは下記                                                                         */
/*                                                                                                                   */
/*       format-number   ：3桁カンマ区切り形式(例：123,456,789、-987,654,321)                                        */
/*       format-money    ：金額形式(例：\123,456,789)                                                                */
/*       format-date     ：yyyy/MM/dd形式(例：2014/08/15)                                                            */
/*       format-jdate    ：yyyy年MM月dd日形式(例：2014年08月15日)                                                    */
/*       format-time     ：時刻形式(HH:MMまたはHH:MM:SS)(例：09:25)                                                  */
/*       format-pointX   ：小数点形式(例：少数第2位の場合 123.45)                                                    */
/*                         Xは少数第何位までかを表す。                                                               */
/*                         (例：少数第2位の場合 format-point2)                                                       */
/*       format-0padding ：ゼロパティング形式(例：maxlength=3の場合 001)                                             */
/*                                                                                                                   */
/* ================================================================================================================= */


/* ================================================================================================================= */
/* CSSクラス名                                                                                                       */
/* ================================================================================================================= */
/// 3桁カンマ区切り形式
var CLASS_NUMBER = "format-number";
/// 金額形式
var CLASS_MONEY = "format-money";
/// yyyy/MM/dd形式
var CLASS_DATE = "format-date";
/// yyyy年mm月dd日形式
var CLASS_JDATE = "format-jdate";
/// 時刻形式
var CLASS_TIME = "format-time";
/// 小数点形式
var CLASS_POINT = "format-point";
/// ゼロパティング形式
var CLASS_PADDING = "format-0padding";

/* ================================================================================================================= */
/* 定数                                                                                                              */
/* ================================================================================================================= */
/// ゼロサプレス結果での空文字でのデフォルト値
var STR_SAP_DEF_VALUE = "0";
/// \マーク
var STR_YEN = "\\";
/// -マーク
var STR_MINUS = "\-";
/// 日付チェック桁数
var INT_DATE_LEN = 8;
/// 時刻チェック最大桁数
var INT_TIME_MAX_LEN = 6;
/// 時刻チェック最小桁数
var INT_TIME_MIN_LEN = 3;
/// ゼロ詰め文字
var STR_ADD_ZERO = "0";
/// ゼロパディング文字
var STR_PADING_ZERO = "0";
/// maxlengh属性名
var STR_ATTR_MAX_LENGTH = "maxlength";
/// int型最大値
var INT_MAX_VALUE = 2147483647;

/* ================================================================================================================= */
/* 共通関数                                                                                                          */
/* ================================================================================================================= */

/**
 * 初期設定
 */
function initTextFormat() {
	/// 3桁カンマ区切り形式初期設定
	initNumberFormat();

	/// 金額形式初期設定
	initMoneyFormat();

	/// yyyy/MM/dd形式初期設定
	initDateFormat();

	/// yyyy年MM月dd日形式初期設定
	initJdateFormat();

	/// 時刻形式初期設定
	initTimeFormat();

	/// 小数点形式初期設定
	initPointFormat();

	/// ゼロパティング形式初期設定
	initPaddingFormat();

	/// テキストボックス最大桁数超過時のツールチップ非表示設定
	document.getElementsByTagName('FORM')[0].noValidate = true;

}


/**
 * 全てのフォーマットを設定
 */
function setTextFormat() {
	/// 全項目3桁カンマ区切り形式設定
	setAllNumberFormat();

	/// 全項目金額形式設定
	setAllMoneyFormat();

	/// 全項目yyyy/MM/dd形式設定
	setAllDateFormat();

	/// 全項目yyyy年MM月dd日設定
	setAllJdateFormat();

	/// 全項目時刻設定
	setAllTimeFormat();

	/// 全項目小数点形式
	setAllPointFormat();

	/// 全項目ゼロパティング形式設定
	setAllPaddingFormat();
}


/**
 * 全てのフォーマットを除去
 */
function clearTextFormat() {
	/// 全項目3桁カンマ区切り形式除去
	clearAllNumberFormat();

	/// 全項目金額形式除去
	clearAllMoneyFormat();

	/// 全項目yyyy/MM/dd形式除去
	clearAllDateFormat();

	/// 全項目yyyy年MM月dd日形式除去
	clearAllJdateFormat();

	/// 全項目時刻形式除去
	clearAllTimeFormat();

	/// 全項目小数点形式除去
	clearAllPointFormat();
}


/**
 * ダイアログ表示時コントローラー呼び出し前処理
 */
function onPushConfirmBefore() {
	/// 全てのフォーマットを除去
	clearTextFormat();
}


/**
 * ダイアログ表示時コントローラー呼び出し後処理
 */
function onPushConfirmAfter() {
	/// 全てのフォーマットを設定
	setTextFormat();
}


/* ================================================================================================================= */
/* format-number：3桁カンマ区切り形式                                                                                */
/* ================================================================================================================= */

/**
 * 3桁カンマ区切り形式初期設定
 * <BR>
 * 対象のCSSクラスが指定された項目に、フォーカスイン/アウトの処理を追加し、カンマ編集します。
 */
function initNumberFormat() {

	/// 対象CSSクラスがあるか確認
	if ($('.' + CLASS_NUMBER)[0]) {

		/// ファンクションをバインド
		$('.' + CLASS_NUMBER).bind({

			/// フォーカスイン時0
			focus: function(){

				/// 3桁カンマ区切り形式除去結果を反映
				$(this).val(clearNumberFormat($(this).val())).select();
			},

			/// フォーカスアウト時
			blur: function(){

				/// 3桁カンマ区切り形式設定結果を反映
				$(this).val(setNumberFormat($(this).val()));
			}
		});

		/// 全項目3桁カンマ区切り形式設定
		setAllNumberFormat();
	}
}

/**
 * 3桁カンマ区切り形式除去
 * <BR>
 * 数字文字列が3桁カンマ区切り形式の場合にカンマを削除します。
 * @param val 対象文字列
 * @return カンマを削除した文字列
 */
function clearNumberFormat(val) {

	var retVal = val;

	/// 入力データがマイナス数値形式の場合
	var minusFlg = false;
	if( val.match( /^\-([1-9]\d{0,2}(,\d{3})*)$/ ) ){
		minusFlg = true;
		val = val.replace( /^\-/, "");
	}

	/// 入力データが3桁カンマ区切り形式の場合(ゼロサプレスされている前提)
	if( val.match( /^([1-9]\d{0,2}(,\d{3})*)$/ ) ){
		/// 入力データからカンマを除去
		retVal = val.replace( /,/g, '');
	}

	/// 入力データがマイナス数値形式の場合、符号再設定
	if(minusFlg){
		retVal = STR_MINUS + retVal;
	}

	return retVal;
}

/**
 * 3桁カンマ区切り形式設定
 * <BR>
 * 数字文字列をカンマ編集します。
 * @param val 対象文字列
 * @return カンマを編集した文字列
 */
function setNumberFormat(val) {

	/// 返却値
	var retVal = val;

	/// ゼロサプレス後文字
	var supVal = "";

	/// 入力データがマイナス数値形式の場合
	var minusFlg = false;
	if( val.match( /^\-[0-9]+$|^\-0+[0-9]+$/)){
		/// 先頭のマイナス符号を除去
		val = val.replace( /^\-/, "");
		minusFlg = true;
	}

	/// ゼロサプレス後の入力データが3桁カンマ区切り形式の場合は正常値として扱う
	/// ゼロサプレスを実施
	var tmpVal = val.replace( /^0+([0-9,]+)/, "$1" );
	/// ゼロサプレス後の入力データが3桁カンマ区切り形式の場合
	if( tmpVal.match( /^([0-9]\d{0,2}(,\d{3})*)$/ ) ){
		/// 入力データからカンマを除去
		val = val.replace( /,/g, '');
	}

	/// 数値チェック
	if (val != "" && val.match(/[^0-9]+/) == null) {

		/// ゼロサプレス実行
		supVal = val.replace( /^0+([0-9]+)/, "$1" );

		/// ゼロサプレスした結果があるか確認
		if (supVal != "") {

			/// カンマ編集
			retVal = supVal.replace( /(\d)(?=(\d{3})+(?!\d))/g, '$1,' );

			/// 入力データがマイナス数値形式の場合
			if(minusFlg){
				/// マイナス符号再設定
				retVal = STR_MINUS + retVal;
			}

		} else {

			/// 返却値を0に設定
			retVal = STR_SAP_DEF_VALUE;
		}
	}

	return retVal;
}

/**
 * 全項目3桁カンマ区切り形式除去
 * <BR>
 * 対象のCSSクラスが指定された全ての項目から、カンマを削除します。
 */
function clearAllNumberFormat() {
	/// 対象CSSクラスがあるか確認
	if ($('.' + CLASS_NUMBER)[0]) {

		/// 対象CSSクラスがある全項目に対して処理を実行
		$('.' + CLASS_NUMBER).each(function(){

			/// 3桁カンマ区切り形式除去結果を反映
			$(this).val(clearNumberFormat($(this).val()));
		});
	}
}

/**
 * 全項目3桁カンマ区切り形式設定
 * <BR>
 * 対象のCSSクラスが指定された全ての項目をカンマ編集します。
 */
function setAllNumberFormat() {

	/// 対象CSSクラスがあるか確認
	if ($('.' + CLASS_NUMBER)[0]) {

		/// 対象CSSクラスがある全項目に対して処理を実行
		$('.' + CLASS_NUMBER).each(function(){

			/// 3桁カンマ区切り形式設定結果を反映
			$(this).val(setNumberFormat($(this).val()));
		});
	}
}


/* ================================================================================================================= */
/* format-money：金額形式                                                                                            */
/* ================================================================================================================= */

/**
 * 金額形式初期設定
 * <BR>
 * 対象のCSSクラスが指定された項目に、フォーカスイン/アウトの処理を追加し、￥カンマ編集します。
 */
function initMoneyFormat() {

	/// 対象CSSクラスがあるか確認
	if ($('.' + CLASS_MONEY)[0]) {

		/// ファンクションをバインド
		$('.' + CLASS_MONEY).bind({

			/// フォーカスイン時0
			focus: function(){

				/// 金額形式除去結果を反映
				$(this).val(clearMoneyFormat($(this).val())).select();
			},

			/// フォーカスアウト時
			blur: function(){

				/// 金額形式設定結果を反映
				$(this).val(setMoneyFormat($(this).val()));
			}
		});

		/// 全項目金額形式設定
		setAllMoneyFormat();
	}
}

/**
 * 金額形式除去
 * <BR>
 * 数字文字列が金額形式の場合に、￥マーク(先頭１文字)およびカンマを削除します。
 * @param val 対象文字列
 * @return ￥マークおよびカンマを削除した文字列
 */
function clearMoneyFormat(val) {

	var retVal = val;

	/// 入力データが金額形式(先頭￥マーク＋０、または￥マーク＋３桁カンマ形式)の場合
	/// ※￥マーク以降の数値は、ゼロサプレスされている前提
	if( val.match( /^\\[0]$|^\\([1-9]\d{0,2}(,\d{3})*)$/ ) ){
		/// 入力データからカンマと￥マークを除去
		retVal = val.replace( /[,\\]/g, '');
	}

	return retVal;
}

/**
 * 金額形式設定
 * <BR>
 * 数字文字列を先頭￥マーク＋カンマ編集します。
 * @param val 対象文字列
 * @return 先頭￥マーク＋カンマを編集した文字列
 */
function setMoneyFormat(val) {

	/// 返却値
	var retVal = val;

	/// 先頭￥マーク削除＋ゼロサプレス後の入力データが3桁カンマ区切り形式の場合は正常値として扱う
	/// 先頭￥マーク削除
	var tmpVal = val.replace( /^\\/, "");
	/// ゼロサプレス
	tmpVal = tmpVal.replace( /^0+([0-9,]+)/, "$1" );
	/// 先頭￥マーク削除＋ゼロサプレス後の入力データが全て数字の場合
	if(tmpVal.match(/[^0-9]+/) == null){
		val = tmpVal;

	/// 先頭￥マーク削除＋ゼロサプレス後の入力データが3桁カンマ区切り形式の場合
	}else if( tmpVal.match( /^([0-9]\d{0,2}(,\d{3})*)$/ ) ){
		/// 入力データからカンマを除去
		val = tmpVal.replace( /,/g, '');
	}

	/// 数値チェック
	if (val != "" && val.match(/[^0-9]+/) == null) {

		/// カンマ編集を実行
		retVal = setNumberFormat(val);

		/// \マークを付与
		retVal = STR_YEN + retVal;
	}

	return retVal;
}

/**
 * 全項目金額形式除去
 * <BR>
 * 対象のCSSクラスが指定された全ての項目から、￥マークおよびカンマを削除します。
 */
function clearAllMoneyFormat() {

	/// 対象CSSクラスがあるか確認
	if ($('.' + CLASS_MONEY)[0]) {

		/// 対象CSSクラスがある全項目に対して処理を実行
		$('.' + CLASS_MONEY).each(function(){

			/// 金額形式除去結果を反映
			$(this).val(clearMoneyFormat($(this).val()));
		});
	}
}

/**
 * 全項目金額形式設定
 * <BR>
 * 対象のCSSクラスが指定された全ての項目を￥マーク＋カンマ編集します。
 */
function setAllMoneyFormat() {

	/// 対象CSSクラスがあるか確認
	if ($('.' + CLASS_MONEY)[0]) {

		/// 対象CSSクラスがある全項目に対して処理を実行
		$('.' + CLASS_MONEY).each(function(){

			/// 金額形式設定結果を反映
			$(this).val(setMoneyFormat($(this).val()));
		});
	}
}


/* ================================================================================================================= */
/* format-date：yyyy/MM/dd形式                                                                                       */
/* ================================================================================================================= */

/**
 * yyyy/MM/dd形式初期設定
 * <BR>
 * 対象のCSSクラスが指定された項目に、フォーカスイン/アウトの処理を追加し、日付編集します。
 */
function initDateFormat() {

	/// 対象CSSクラスがあるか確認
	if ($('.' + CLASS_DATE)[0]) {

		/// ファンクションをバインド
		$('.' + CLASS_DATE).bind({

			/// フォーカスイン時0
			focus: function(){

				/// yyyy/MM/dd形式除去結果を反映
				$(this).val(clearDateFormat($(this).val())).select();
			},

			/// フォーカスアウト時
			blur: function(){

				/// yyyy/MM/dd形式設定結果を反映
				$(this).val(setDateFormat($(this).val()));
			}
		});

		/// 全項目yyyy/MM/dd形式設定
		setAllDateFormat();
	}
}

/**
 * yyyy/MM/dd形式除去
 * <BR>
 * 入力データがyyyy/MM/dd形式の場合、数字文字列から全ての'/'を削除します。
 * @param val 対象文字列
 * @return '/'を削除した文字列
 */
function clearDateFormat(val) {

	var retVal = val;

	/// 入力データがyyyy/MM/dd形式の場合
	if( val.match(/\d{4}\/\d{2}\/\d{2}/) ){
		/// 入力データから'/'を除去
		retVal = val.replace( /[\/]/g, '');
	}

	return retVal;
}

/**
 * yyyy/MM/dd形式設定
 * <BR>
 * 数字文字列を日付形式(YYYY/MM/DD)に編集します。
 * @param val 対象文字列
 * @return 日付形式に編集した文字列
 */
function setDateFormat(val) {

	/// 返却値
	var retVal = val;

	/// 数値チェック及び桁数チェック
	if (val != "" && val.match(/[^0-9]+/) == null
			&& val.length == INT_DATE_LEN) {

		/// 4桁/2桁/2桁で変換
		retVal = val.replace( /(\d{4})(\d{2})(\d{2})/, '$1/$2/$3' );
	}

	return retVal;
}

/**
 * 全項目yyyy/MM/dd形式除去
 * <BR>
 * 対象のCSSクラスが指定された全ての項目から、'/'を削除します。
 */
function clearAllDateFormat() {

	/// 対象CSSクラスがあるか確認
	if ($('.' + CLASS_DATE)[0]) {

		/// 対象CSSクラスがある全項目に対して処理を実行
		$('.' + CLASS_DATE).each(function(){

			/// yyyy/MM/dd形式除去結果を反映
			$(this).val(clearDateFormat($(this).val()));
		});
	}
}

/**
 * 全項目yyyy/MM/dd形式設定
 * <BR>
 * 対象のCSSクラスが指定された全ての項目を日付形式(YYYY/MM/DD)編集します。
 */
function setAllDateFormat() {

	/// 対象CSSクラスがあるか確認
	if ($('.' + CLASS_DATE)[0]) {

		/// 対象CSSクラスがある全項目に対して処理を実行
		$('.' + CLASS_DATE).each(function(){

			/// yyyy/MM/dd形式設定結果を反映
			$(this).val(setDateFormat($(this).val()));
		});
	}
}


/* ================================================================================================================= */
/* format-jdate：yyyy年MM月dd日形式                                                                                  */
/* ================================================================================================================= */

/**
 * yyyy年MM月dd日形式初期設定
 * <BR>
 * 対象のCSSクラスが指定された項目に、フォーカスイン/アウトの処理を追加し、日付編集します。
 */
function initJdateFormat() {

	/// 対象CSSクラスがあるか確認
	if ($('.' + CLASS_JDATE)[0]) {

		/// ファンクションをバインド
		$('.' + CLASS_JDATE).bind({

			/// フォーカスイン時0
			focus: function(){

				/// yyyy年MM月dd日形式除去結果を反映
				$(this).val(clearJdateFormat($(this).val())).select();
			},

			/// フォーカスアウト時
			blur: function(){

				/// yyyy年MM月dd日形式設定結果を反映
				$(this).val(setJdateFormat($(this).val()));
			}
		});

		/// 全項目yyyy年MM月dd日形式設定
		setAllJdateFormat();
	}
}

/**
 * yyyy年MM月dd日形式除去
 * <BR>
 * 数字文字列がyyyy年MM月dd日形式の場合に、'年'・'月'・'日'を削除します。
 * @param val 対象文字列
 * @return '年'・'月'・'日'を削除した文字列
 */
function clearJdateFormat(val) {

	var retVal = val;

	/// 入力データがyyyy年MM月dd日形式の場合
	if( val.match(/\d{4}年\d{2}月\d{2}日/) ){
		/// 入力データから'年'・'月'・'日'を除去した値を返却
		retVal = val.replace( /[年月日]/g, '');
	}

	return retVal;

}

/**
 * yyyy年MM月dd日形式設定
 * <BR>
 * 数字文字列を日付形式(YYYY年MM月DD日)に編集します。
 * @param val 対象文字列
 * @return 日付形式に編集した文字列
 */
function setJdateFormat(val) {

	/// 返却値
	var retVal = val;

	/// 数値チェック及び桁数チェック
	if (val != "" && val.match(/[^0-9]+/) == null
			&& val.length == INT_DATE_LEN) {

		/// 4桁年2桁月2桁日で変換
		retVal = val.replace( /(\d{4})(\d{2})(\d{2})/, '$1年$2月$3日' );
	}

	return retVal;
}

/**
 * 全項目yyyy年MM月dd日形式除去
 * <BR>
 * 対象のCSSクラスが指定された全ての項目から、'年'・'月'・'日'を削除します。
 */
function clearAllJdateFormat() {

	/// 対象CSSクラスがあるか確認
	if ($('.' + CLASS_JDATE)[0]) {

		/// 対象CSSクラスがある全項目に対して処理を実行
		$('.' + CLASS_JDATE).each(function(){

			/// yyyy年MM月dd日形式除去結果を反映
			$(this).val(clearJdateFormat($(this).val()));
		});
	}
}

/**
 * 全項目yyyy年MM月dd日形式設定
 * <BR>
 * 対象のCSSクラスが指定された全ての項目を日付形式(YYYY年MM月DD日)に編集します。
 */
function setAllJdateFormat() {

	/// 対象CSSクラスがあるか確認
	if ($('.' + CLASS_JDATE)[0]) {

		/// 対象CSSクラスがある全項目に対して処理を実行
		$('.' + CLASS_JDATE).each(function(){

			/// yyyy年MM月dd日形式設定結果を反映
			$(this).val(setJdateFormat($(this).val()));
		});
	}
}


/* ================================================================================================================= */
/* format-time：時刻形式(HH:MMまたはHH:MM:SS)                                                                        */
/* ================================================================================================================= */

/**
 * 時刻形式初期設定
 * <BR>
 * 対象のCSSクラスが指定された項目に、フォーカスイン/アウトの処理を追加し、時刻編集します。
 */
function initTimeFormat() {

	/// 対象CSSクラスがあるか確認
	if ($('.' + CLASS_TIME)[0]) {

		/// ファンクションをバインド
		$('.' + CLASS_TIME).bind({

			/// フォーカスイン時0
			focus: function(){

				/// 時刻形式形式除去結果を反映
				$(this).val(clearTimeFormat($(this).val())).select();
			},

			/// フォーカスアウト時
			blur: function(){

				/// 時刻形式設定結果を反映
				$(this).val(setTimeFormat($(this).val()));
			}
		});

		/// 全項目時刻形式設定
		setAllTimeFormat();
	}
}

/**
 * 時刻形式除去
 * <BR>
 * 数字文字列からコロンを削除します。
 * @param val 対象文字列
 * @return コロンを削除した文字列
 */
function clearTimeFormat(val) {

	var retVal = val;

	/// 入力データが、HH:MMまたはHH:MM:SSの場合
	if( val.match(/^\d{2}:\d{2}$/) || val.match(/^\d{2}:\d{2}:\d{2}$/) ){
		/// ':'を除去した値を返却
		retVal = val.replace( /:/g, '');
	}

	return retVal;
}

/**
 * 時刻形式設定
 * <BR>
 * 数字文字列を時刻形式(HH:MMまたはHH:MM:SS)に編集します。
 * 3桁未満・6桁を超える文字列が指定された場合は、編集を行いません。
 * @param val 対象文字列
 * @return 時刻形式に編集した文字列
 */
function setTimeFormat(val) {

	/// 返却値
	var retVal = val;
	/// 桁数を取得
	var valLen = val.length;

	/// 妥当性チェック用
	var tmpVal = val;
	/// 入力データが、(H)H:MMまたは(H)H:MM:SSの場合
	if( val.match(/^\d{1,2}:\d{2}$/) || val.match(/^\d{1,2}:\d{2}:\d{2}$/) ){
		/// 入力データから':'を除去
		tmpVal = val.replace( /:/g, '');
		/// 桁数を更新
		valLen = tmpVal.length;
	}

	/// 数値チェック及び桁数チェック
	if (tmpVal != "" && tmpVal.match(/[^0-9]+/) == null
			&& valLen <= INT_TIME_MAX_LEN && valLen >= INT_TIME_MIN_LEN) {

		/// 0パディング後の値
		var padVal = "";

		/// 桁数が3桁・5桁は0パディング
		if (valLen == 3) {

			/// 4桁でゼロパディング
			padVal = setPaddingFormat(tmpVal, 4);
		} else if (valLen == 5) {

			/// 6桁でゼロパディング
			padVal = setPaddingFormat(tmpVal, 6);
		} else {

			/// そのまま設定
			padVal = val;
		}

		/// コロン編集
		retVal = padVal.replace( /(\d)(?=(\d{2})+(?!\d))/g, '$1:' );
	}

	return retVal;
}

/**
 * 全項目時刻形式除去
 * <BR>
 * 対象のCSSクラスが指定された全ての項目からコロンを削除します。
 */
function clearAllTimeFormat() {

	/// 対象CSSクラスがあるか確認
	if ($('.' + CLASS_TIME)[0]) {

		/// 対象CSSクラスがある全項目に対して処理を実行
		$('.' + CLASS_TIME).each(function(){

			/// 時刻形式除去結果を反映
			$(this).val(clearTimeFormat($(this).val()));
		});
	}
}

/**
 * 全項目時刻形式設定
 * <BR>
 * 対象のCSSクラスが指定された全ての項目を時刻形式編集します。
 */
function setAllTimeFormat() {

	/// 対象CSSクラスがあるか確認
	if ($('.' + CLASS_TIME)[0]) {

		/// 対象CSSクラスがある全項目に対して処理を実行
		$('.' + CLASS_TIME).each(function(){

			/// 時刻形式設定結果を反映
			$(this).val(setTimeFormat($(this).val()));
		});
	}
}


/* ================================================================================================================= */
/* format-pointX：小数点形式                                                                                         */
/* ================================================================================================================= */

/**
 * 小数点形式初期設定
 * <BR>
 * 対象のCSSクラスが指定された項目に、フォーカスイン/アウトの処理を追加し、カンマドット編集します。
 */
function initPointFormat() {

	/// 対象CSSクラスがあるか確認
	if ($('input[class*="' + CLASS_POINT + '"]')[0]) {

		/// 対象CSSクラスがある全項目に対して処理を実行
		$('input[class*="' + CLASS_POINT + '"]').each(function(){

			/// クラス情報
			var classVal = $(this).get(0).className;

			/// 小数点位置切り出し位置
			var getIndex = classVal.indexOf(CLASS_POINT) + CLASS_POINT.length;

			/// 小数点位置
			var position = "";

			/// 切り出し位置がクラス情報文字数より小さいか確認
			if (getIndex < classVal.length) {

				/// 小数点位置を設定
				position = classVal.substr(getIndex, 1);
			}

			/// ファンクションをバインド
			$(this).bind({

				/// フォーカスイン時0
				focus: function(){

					/// 小数点形式除去結果を反映
					$(this).val(clearPointFormat($(this).val())).select();
				},

				/// フォーカスアウト時
				blur: function(){

					/// 小数点形式設定結果を反映
					$(this).val(setPointFormat($(this).val(), position));
				}
			});
		});

		/// 全項目小数点設定
		setAllPointFormat();
	}
}

/**
 * 小数点形式除去
 * <BR>
 * 数字文字列3桁カンマ区切り形式＋小数部の場合にカンマを削除します。
 * @param val 対象文字列
 * @return カンマを削除した文字列
 */
function clearPointFormat(val) {

	var retVal = val;

	/// 入力データが3桁カンマ区切り形式＋小数部の場合
	if( val.match( /^([1-9]\d{0,2}(,\d{3})*)\.\d+$/ ) ){
		/// 入力データからカンマを除去
		retVal = val.replace( /,/g, '');
	}

	return retVal;
}

/**
 * 小数点形式設定
 * <BR>
 * 整数部数字文字列カンマ編集し、小数部数字文字列を桁数で補完除去します。
 * @param val 対象文字列
 * @param position 小数部位置
 * @return カンマとドットを編集した文字列
 */
function setPointFormat(val, position) {

	/// 返却値
	var retVal = val;

	/// ドット分割データ
	var sepData;

	/// 整数部内容
	var intData;

	/// 小数部内容
	var degData;

	/// ゼロ詰め内容
	var addZero;

	/// ゼロサプレス後の入力データが3桁カンマ区切り＋小数部(任意)形式の場合は正常値として扱う
	/// ゼロサプレスを実施
	var tmpVal = val.replace( /^0+([0-9,]+)/, "$1" );
	/// ゼロサプレス後の入力データが3桁カンマ区切り＋小数部(任意)形式の場合
	if( tmpVal.match( /^([1-9]\d{0,2}(,\d{3})*)\.{0,1}\d*$/ ) ){
		/// 入力データからカンマを除去
		val = val.replace( /,/g, '');
	}

	/// 数値ドットチェック 及び 小数部位置数値チェック
	if (val != "" && val.match(/[^0-9\.]+/) == null
			&& position != "" && position.match(/[^0-9]+/) == null) {

		/// ドットでデータを分割
		sepData = val.split(".");

		/// 分割したデータの要素数が2以下か確認
		if (sepData.length <= 2) {

			/// 整数部をカンマ編集
			intData = setNumberFormat("0" + sepData[0]);

			/// 小数部
			degData = "";

			/// 小数部データがあるか確認
			if (sepData.length != 1) {

				/// 小数部を設定
				degData = sepData[1];
			}

			/// 小数部桁数が指定少数位置より小さいか確認
			if (degData.length < position) {

				/// ゼロ詰め内容を初期化
				addZero = "";

				/// 最大桁数
				for (var i = 0; i < position; i++) {

					/// ゼロを追加
					addZero = addZero + STR_ADD_ZERO;
				}

				/// ゼロを付与した内容を小数部に設定
				degData = (degData + addZero).slice(0, position);

			/// 小数部桁数が指定少数位置より大きいか確認
			} else if (degData.length > position) {

				/// 指定少数位置で、データをカット
				degData = degData.slice(0, position);
			}

			/// 返却値に整数部＋．＋小数部を設定
			retVal = intData + "." + degData;
		}
	}

	return retVal;
}

/**
 * 全項目小数点形式除去
 * <BR>
 * 対象のCSSクラスが指定された全ての項目からカンマを削除します。
 */
function clearAllPointFormat() {

	/// 対象CSSクラスがあるか確認
	if ($('input[class*="' + CLASS_POINT + '"]')[0]) {

		/// 対象CSSクラスがある全項目に対して処理を実行
		$('input[class*="' + CLASS_POINT + '"]').each(function(){

			/// 少数点形式除去結果を反映
			$(this).val(clearPointFormat($(this).val()));
		});
	}
}

/**
 * 全項目小数点設定
 * <BR>
 * 対象のCSSクラスが指定された全ての項目を小数点形式編集します。
 */
function setAllPointFormat() {

	/// 対象CSSクラスがあるか確認
	if ($('input[class*="' + CLASS_POINT + '"]')[0]) {

		/// 対象CSSクラスがある全項目に対して処理を実行
		$('input[class*="' + CLASS_POINT + '"]').each(function(){

			/// クラス情報
			var classVal = $(this).get(0).className;

			/// 小数点位置切り出し位置
			var getIndex = classVal.indexOf(CLASS_POINT) + CLASS_POINT.length;

			/// 小数点位置
			var position = "";

			/// 切り出し位置がクラス情報文字数より小さいか確認
			if (getIndex < classVal.length) {

				/// 小数点位置を設定
				position = classVal.substr(getIndex, 1);
			}

			/// 小数点形式設定結果を反映
			$(this).val(setPointFormat($(this).val(), position));
		});
	}
}


/* ================================================================================================================= */
/* format-padding ：ゼロパティング形式                                                                               */
/* ================================================================================================================= */

/**
 * ゼロパティング形式初期設定
 * <BR>
 * 対象のCSSクラスが指定された項目に、フォーカスアウトの処理を追加し、ゼロパディング編集します。
 */
function initPaddingFormat() {

	/// 対象CSSクラスがあるか確認
	if ($("." + CLASS_PADDING)[0]) {

		/// ファンクションをバインド
		$("." + CLASS_PADDING).bind({

			/// フォーカスアウト時
			blur: function(){

				/// ゼロパティング形式設定結果を反映
				$(this).val(setPaddingFormat($(this).val(), $(this).attr(STR_ATTR_MAX_LENGTH)));
			}
		});

		/// 全項目ゼロパディング形式設定
		setAllPaddingFormat();
	}
}

/**
 * ゼロパティング形式設定
 * <BR>
 * 数字文字列を最大件数でゼロパディング編集します。
 * @param val 対象文字列
 * @param maxlength 最大桁数
 * @return ゼロパディング形式に編集した文字列
 */
function setPaddingFormat(val, maxlength) {

	/// 返却値
	var retVal = val;

	/// パディング文字
	var padding = "";

	/// 数値チェック 及び
	/// maxlength属性チェック(空文字の場合、int型の最大値:2147483647)
	if (val != "" && val.match(/[^0-9]+/) == null
			&& maxlength != null && maxlength != INT_MAX_VALUE) {

		/// 最大桁数
		for (var i = 0; i < maxlength; i++) {

			/// ゼロを追加
			padding = padding + STR_PADING_ZERO;
		}

		/// ゼロパディング
		retVal = ( padding + val ).slice( -1 * maxlength );
	}

	return retVal;
}

/**
 * 全項目ゼロパディング形式設定
 * <BR>
 * 対象のCSSクラスが指定された全ての項目をゼロパディング編集します。
 */
function setAllPaddingFormat() {

	/// 対象CSSクラスがあるか確認
	if ($("." + CLASS_PADDING)[0]) {

		/// 対象CSSクラスがある全項目に対して処理を実行
		$("." + CLASS_PADDING).each(function(){

			/// ゼロパティング形式設定結果を反映
			$(this).val(setPaddingFormat($(this).val(), $(this).attr(STR_ATTR_MAX_LENGTH)));
		});
	}
}

