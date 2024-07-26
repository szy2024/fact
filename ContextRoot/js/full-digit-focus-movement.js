//==================================================================================================
// Project Name : CrustFramework-web
// System Name  : Crust
// Class Name   : full-digit-focus-movement.js
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2014/03/31 | 富士通                | 新規作成
// 1.0.1   | 2014/08/01 | 富士通                | 制御キー押下時にフォーカスが移動しない様に修正
//==================================================================================================

// フォーカス遷移を行うか判断するための前回入力値
var gNextFocusOldValue = new Array();

/**
 * フル桁フォーカス遷移
 *
 * @param element フォームの要素
 * @param maxLength 最大桁数
 * @param name 次にフォーカスを当てるフィールドID
 */
function nextFocus(element, maxLength, name) {
	var old = gNextFocusOldValue[element.id];
	if (element.value != old) {
		if (window.event.keyCode != 9 && window.event.keyCode != 16) {
			if (maxLength == element.value.length) {
				document.all[name].focus();
			}
		}
	}

	gNextFocusOldValue[element.id] = element.value;
}
