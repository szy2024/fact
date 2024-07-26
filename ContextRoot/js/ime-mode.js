/**
 * IMEモードを切り替えます。
 * 
 * @param propertyName 要素のプロパティ属性
 * @param imeMode IMEモード
 */
function imeModeChange(propertyName, imeMode){
	document.getElementsByName(propertyName).item(0).style.imeMode = imeMode;
	document.getElementsByName(propertyName).item(0).focus();
	document.getElementsByName(propertyName).item(0).select();
}
