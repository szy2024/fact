//==================================================================================================
// Project Name : CrustFramework-web
// System Name  : Crust
// Class Name   : cfw-calendar-common.js
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2014/03/31 | 富士通)草水 博喜      | 新規作成
// 1.0.1   | 2014/09/11 | 富士通)草水 博喜      | 西暦→和暦変換時に特定の年で、変換ミスが発生していたのを修正。
// 1.1.0   | 2018/12/17 | 富士通)林　晃平       | 農林PN元号対応
//==================================================================================================

/**
 * <pre>
 * カレンダーから西暦の日付を入力します。
 * ※ボタン表示タイプ
 * </pre>
 *
 * @param fDate
 *            日付を入力するフィールドID
 */
function calendar1Field_Button(fDate) {

	$('#' + fDate).datepicker({
		showOn : "button",
		buttonImage : "../../image/icon_calendar_2.gif",
		buttonImageOnly : true,
		dateFormat : 'yy/mm/dd'
	});
}

/**
 * <pre>
 * カレンダーから西暦の日付を入力します。
 * ※ボタン表示タイプ
 * </pre>
 *
 * @param fDate
 *            日付を入力するフィールドID
 */
function calendar1Field_Button_en(fDate) {

	$('#' + fDate).datepicker({
		showOn : "button",
		buttonImage : "../../image/icon_calendar_2.gif",
		buttonImageOnly : true
	});
	setLangEN(fDate);
}

/**
 * カレンダーから西暦の日付を入力します。
 *
 * @param fDate
 *            日付を入力するフィールドID
 */
function calendar1Field(fDate) {
	$('#' + fDate).datepicker({
		dateFormat : 'yy/mm/dd'
	});
}

/**
 * カレンダーから西暦の日付を入力します。
 *
 * @param fDate
 *            日付を入力するフィールドID
 */
function calendar1Field_en(fDate) {
	$('#' + fDate).datepicker({
		dateFormat : 'yy/mm/dd'
	});
	setLangEN(fDate);
}

/**
 * 指定したロケールのカレンダーから西暦の日付を3つの分かれたインプットフィールドに入力します。
 * ※ボタンを表示する為に、hiddenタグを作成し、idをdummy引数に指定して下さい。
 *
 * @param fYear
 *            年を入力するフィールドID
 * @param fMonth
 *            月を入力するフィールドID
 * @param fDay
 *            日にちを入力するフィールドID
 * @param dummy
 *            ボタンを表示するhiddenのフィールドID
 */
function calendar3Field_Button(fYear, fMonth, fDay, dummy) {
	$('#' + dummy).datepicker({
		showOn : "button",
		buttonImage : "../../image/icon_calendar_2.gif",
		buttonImageOnly : true,
		dateFormat : 'yy/mm/dd',
		onClose : function(dateText, picker) {
			$('#' + fYear).val(dateText.split("/")[0]);
			$('#' + fMonth).val(dateText.split("/")[1]);
			$('#' + fDay).val(dateText.split("/")[2]);
		},
		beforeShow : function() {
			fieldJoin_seireki(fYear, fMonth, fDay, dummy, '/');
		}
	});
}

/**
 * 指定したロケールのカレンダーから西暦の日付を3つの分かれたインプットフィールドに入力します。
 * ※ボタンを表示する為に、hiddenタグを作成し、idをdummy引数に指定して下さい。
 *
 * @param fYear
 *            年を入力するフィールドID
 * @param fMonth
 *            月を入力するフィールドID
 * @param fDay
 *            日にちを入力するフィールドID
 * @param dummy
 *            ボタンを表示するhiddenのフィールドID
 */
function calendar3Field_Button_en(fYear, fMonth, fDay, dummy) {
	$('#' + dummy).datepicker({
		showOn : "button",
		buttonImage : "../../image/icon_calendar_2.gif",
		buttonImageOnly : true,
		onClose : function(dateText, picker) {
			$('#' + fYear).val(dateText.split("/")[0]);
			$('#' + fMonth).val(dateText.split("/")[1]);
			$('#' + fDay).val(dateText.split("/")[2]);
		},
		beforeShow : function() {
			fieldJoin_seireki(fYear, fMonth, fDay, dummy, '/');
		}
	});
	setLangEN(dummy);
}

/**
 * カレンダーから和暦の日付を入力します。
 *
 * @param fEra
 *            元号を入力するフィールドID
 * @param fYear
 *            年を入力するフィールドID
 * @param fMonth
 *            月を入力するフィールドID
 * @param fDay
 *            日にちを入力するフィールドID
 * @param dummy
 *            ボタンを表示するhiddenのフィールドID
 */
function calendar4Field_wareki(fEra, fYear, fMonth, fDay, dummy) {
	$('#' + dummy).datepicker({
		showOn : "button",
		buttonImage : "../../image/icon_calendar_2.gif",
		buttonImageOnly : true,
		dateFormat : 'yy/mm/dd',
		onClose : function(dateText, picker) {
			var array = convertWareki(dateText);
			setEra(fEra, array[1]);
			$('#' + fYear).val(array[2]);
			$('#' + fMonth).val(dateText.split('/')[1]);
			$('#' + fDay).val(dateText.split('/')[2]);
		},
		beforeShow : function() {
			join_wareki(fEra, fYear, fMonth, fDay, dummy, '/');
		}
	});
}

/**
 * <pre>
 * DatePickerのロケールを英語に変更します。
 * </pre>
 *
 * @param target
 */
function setLangEN(target) {
	$('#' + target).datepicker("option", $.datepicker.regional['']);
	$('#' + target).datepicker("option", "dateFormat", "yy/mm/dd");
}

/**
 * <pre>
 * 元号フィールドに元号を設定します。
 * </pre>
 *
 * @param fEra
 * @param eraName
 */
function setEra(fEra, eraName) {
	var nodeType = $('#' + fEra)[0].nodeName;
	var eraId = '#' + fEra;
	switch (nodeType) {
	case 'SELECT':
		var options = $(eraId).children();
		for (var i = 0; i < options.length; i++) {
			if (options.eq(i).text() == eraName) {
				$(eraId).val(options.eq(i).val());
				break;
			}
		}

		break;
	case 'INPUT':
		$(eraId).val(eraName);
		break;

	default:
		break;
	}
}

/**
 * <pre>
 * 分割入力フィールドの値を結合して一つの西暦の日付にし、
 * ダミーフィールドに設定します。
 * </pre>
 *
 * @param fYear
 *            年フィールド
 * @param fMonth
 *            月フィールド
 * @param fDay
 *            日フィールド
 * @param dummy
 *            ボタン表示用ダミーフィールド
 * @param sep
 *            セパレート文字
 */
function fieldJoin_seireki(fYear, fMonth, fDay, dummy, sep) {
	$('#' + dummy).val(
			$('#' + fYear).val() + sep + $('#' + fMonth).val() + sep
					+ $('#' + fDay).val());
}

/**
 * <pre>
 * 分割入力フィールドの値を結合して一つの西暦の日付にし、
 * ダミーフィールドに設定します。
 * </pre>
 *
 * @param fYear
 *            年フィールド
 * @param fMonth
 *            月フィールド
 * @param fDay
 *            日フィールド
 * @param dummy
 *            ボタン表示用ダミーフィールド
 * @param sep
 *            セパレート文字
 */
function join_wareki(fEra, fYear, fMonth, fDay, dummy, sep) {

	var nodeType = $('#' + fEra)[0].nodeName;
	var eraId = '#' + fEra;
	var val = '';
	switch (nodeType) {
	case 'SELECT':

		val = $("select[name='" + fEra + "'] option:selected").text();

		break;
	case 'INPUT':
		val = $(eraId).val();
		break;

	default:
		break;
	}

	var year = warekiToSeireki(val, $('#' + fYear).val());

	$('#' + dummy).val(
			year + sep + $('#' + fMonth).val() + sep + $('#' + fDay).val());
}

/**
 * 年号と年数を保持する配列。
 */
var japaneseCalendarTable = new Array();
// [DEL] Ver 1.1.0 - START
//japaneseCalendarTable.push(new Array("18680908", "19120729", "M", "明治"));
//japaneseCalendarTable.push(new Array("19120730", "19261224", "T", "大正"));
//japaneseCalendarTable.push(new Array("19261225", "19890107", "S", "昭和"));
//japaneseCalendarTable.push(new Array("19890108", "99999999", "H", "平成"));
// [DEL] Ver 1.1.0 - END

// [ADD] Ver 1.1.0 - START
/**
 * 年号と年数を保持する配列作成済みフラグ。
 */
var japaneseCalendarTableFlg = false;
// [ADD] Ver 1.1.0 - END

// [ADD] Ver 1.1.0 - START
/**
 * 年号と年数を保持する配列を作成する。
 */
function setCalendar() {

	// 配列の作成は1度だけ
	if (japaneseCalendarTableFlg == false) {

		japaneseCalendarTable = new Array();

		// JSPのHIDDEN項目から元号情報を取得する
		var value = document.getElementsByName("calendarInfo");

		// 元号情報を設定する
		for (var i = 0; i < value.length; i++) {

			var data = value[i].value.split(",");
			// 0:開始年月日 1:終了年月日 2:元号英 3:元号和
			japaneseCalendarTable.push(new Array(data[0], data[1], data[2], data[3]));

		}

		japaneseCalendarTableFlg = true;
	}
}
// [ADD] Ver 1.1.0 - END

/**
 *
 * 西暦から和暦に変換します。
 *
 * @param date
 *            選択したカレンダー日付
 * @returns {Array} 年号記号[0], 年号[1], 年数[2]
 */
function convertWareki(date) {

	var _date = date;

	if (date.indexOf('/') != -1) {
		_date = date.split('/').join("");
	}

	for (var i = 0; i < japaneseCalendarTable.length; i++) {
		var sDate = japaneseCalendarTable[i][0];
		var eDate = japaneseCalendarTable[i][1];

		if (sDate <= _date && _date <= eDate) {
			var sYear = parseInt(sDate.substring(0, 4));
			var dateYear = parseInt(_date.substring(0, 4));
			var japaneseCalendarYear = dateYear - sYear + 1;

			var japaneseCalendar = new Array(3);
			japaneseCalendar[0] = japaneseCalendarTable[i][2];
			japaneseCalendar[1] = japaneseCalendarTable[i][3];
			japaneseCalendar[2] = japaneseCalendarYear;

			return japaneseCalendar;
		}
	}

	return new Array(3);
}

/**
 * <pre>
 * 和暦から西暦に変換します。
 * </pre>
 *
 * @param fEra
 *            元号
 * @param fYear
 *            和暦年
 * @returns 西暦年
 */
function warekiToSeireki(fEra, fYear) {

// [ADD] Ver 1.1.0 - START
	// 和暦テーブルを作成する
	setCalendar();
// [ADD] Ver 1.1.0 - END

	for (var i = 0; i < japaneseCalendarTable.length; i++) {

		var era = japaneseCalendarTable[i][2];
		var eraJp = japaneseCalendarTable[i][3];

		if (era == fEra || eraJp == fEra) {

			var sDate = japaneseCalendarTable[i][0].substring(0, 4);

			var year = eval(sDate) + eval(fYear) - 1;

			return year;
		}
	}
	return '';
}
