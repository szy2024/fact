//==================================================================================================
// Project Name : パートナーネットシステム開発
// System Name  : パートナーネットシステム
// Class Name   : Md005_02ResultsDataEntity
//
// <<Modification History>>
// Version | Date       | Updated By            | Content
// --------+------------+-----------------------+---------------------------------------------------
// 1.0.0   | 2015/10/05 | 小菱　忠雄            | 新規作成
//==================================================================================================
package jp.go.jfc.partnernet.md005.md005_02.dao;

import jp.go.jfc.partnernet.pnfw.dao.entity.PNBaseEntity;

/**
 * <pre>
 * このクラスはMd005_02ResultsDataDAOのEntityクラスです。
 * </pre>
 *
 * @author 小菱　忠雄
 * @version 1.0.0
 */
public class Md005_02ResultsDataEntity extends PNBaseEntity {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	/**
	 * 報告書番号を取得します。
	 *
	 * @return 報告書番号
	 */
	public String getID_ID_Report() {
		return (String) getValue("ID_ID_Report");
	}

	/**
	 * 報告書番号を設定します。
	 *
	 * @param ID_ID_Report
	 *            報告書番号
	 */
	public void setID_ID_Report(String ID_ID_Report) {
		setValue("ID_ID_Report", ID_ID_Report);
	}

	/**
	 * 報告年月日を取得します。
	 *
	 * @return 報告年月日
	 */
	public String getID_Date_Report() {
		return (String) getValue("ID_Date_Report");
	}

	/**
	 * 報告年月日を設定します。
	 *
	 * @param ID_Date_Report
	 *            報告年月日
	 */
	public void setID_Date_Report(String ID_Date_Report) {
		setValue("ID_Date_Report", ID_Date_Report);
	}

	/**
	 * 扱店名を取得します。
	 *
	 * @return 扱店名
	 */
	public String getID_Name_Organization() {
		return (String) getValue("ID_Name_Organization");
	}

	/**
	 * 扱店名を設定します。
	 *
	 * @param ID_Name_Organization
	 *            扱店名
	 */
	public void setID_Name_Organization(String ID_Name_Organization) {
		setValue("ID_Name_Organization", ID_Name_Organization);
	}

	/**
	 * 顧客名を取得します。
	 *
	 * @return 顧客名
	 */
	public String getID_Name_Customer() {
		return (String) getValue("ID_Name_Customer");
	}

	/**
	 * 顧客名を設定します。
	 *
	 * @param ID_Name_Customer
	 *            顧客名
	 */
	public void setID_Name_Customer(String ID_Name_Customer) {
		setValue("ID_Name_Customer", ID_Name_Customer);
	}

	/**
	 * 公庫支店を取得します。
	 *
	 * @return 公庫支店
	 */
	public String getID_Code_KoukoShiten() {
		return (String) getValue("ID_Code_KoukoShiten");
	}

	/**
	 * 公庫支店を設定します。
	 *
	 * @param ID_Code_KoukoShiten
	 *            公庫支店
	 */
	public void setID_Code_KoukoShiten(String ID_Code_KoukoShiten) {
		setValue("ID_Code_KoukoShiten", ID_Code_KoukoShiten);
	}

	/**
	 * 扱店を取得します。
	 *
	 * @return 扱店
	 */
	public String getID_Code_Organization() {
		return (String) getValue("ID_Code_Organization");
	}

	/**
	 * 扱店を設定します。
	 *
	 * @param ID_Code_Organization
	 *            扱店
	 */
	public void setID_Code_Organization(String ID_Code_Organization) {
		setValue("ID_Code_Organization", ID_Code_Organization);
	}

	/**
	 * 店舗を取得します。
	 *
	 * @return 店舗
	 */
	public String getID_Code_Tenpo() {
		return (String) getValue("ID_Code_Tenpo");
	}

	/**
	 * 店舗を設定します。
	 *
	 * @param ID_Code_Tenpo
	 *            店舗
	 */
	public void setID_Code_Tenpo(String ID_Code_Tenpo) {
		setValue("ID_Code_Tenpo", ID_Code_Tenpo);
	}

	/**
	 * 年度を取得します。
	 *
	 * @return 年度
	 */
	public String getID_Year() {
		return (String) getValue("ID_Year");
	}

	/**
	 * 年度を設定します。
	 *
	 * @param ID_Year
	 *            年度
	 */
	public void setID_Year(String ID_Year) {
		setValue("ID_Year", ID_Year);
	}

	/**
	 * 方式資金を取得します。
	 *
	 * @return 方式資金
	 */
	public String getID_Code_HoshikiShikin() {
		return (String) getValue("ID_Code_HoshikiShikin");
	}

	/**
	 * 方式資金を設定します。
	 *
	 * @param ID_Code_HoshikiShikin
	 *            方式資金
	 */
	public void setID_Code_HoshikiShikin(String ID_Code_HoshikiShikin) {
		setValue("ID_Code_HoshikiShikin", ID_Code_HoshikiShikin);
	}

	/**
	 * 番号を取得します。
	 *
	 * @return 番号
	 */
	public String getID_ID_Ringi() {
		return (String) getValue("ID_ID_Ringi");
	}

	/**
	 * 番号を設定します。
	 *
	 * @param ID_ID_Ringi
	 *            番号
	 */
	public void setID_ID_Ringi(String ID_ID_Ringi) {
		setValue("ID_ID_Ringi", ID_ID_Ringi);
	}

	/**
	 * 枝番を取得します。
	 *
	 * @return 枝番
	 */
	public String getID_ID_RingiBranch() {
		return (String) getValue("ID_ID_RingiBranch");
	}

	/**
	 * 枝番を設定します。
	 *
	 * @param ID_ID_RingiBranch
	 *            枝番
	 */
	public void setID_ID_RingiBranch(String ID_ID_RingiBranch) {
		setValue("ID_ID_RingiBranch", ID_ID_RingiBranch);
	}

	/**
	 * 充当対象払込期日を取得します。
	 *
	 * @return 充当対象払込期日
	 */
	public String getID_Date_JutoTaisho() {
		return (String) getValue("ID_Date_JutoTaisho");
	}

	/**
	 * 充当対象払込期日を設定します。
	 *
	 * @param ID_Date_JutoTaisho
	 *            充当対象払込期日
	 */
	public void setID_Date_JutoTaisho(String ID_Date_JutoTaisho) {
		setValue("ID_Date_JutoTaisho", ID_Date_JutoTaisho);
	}

	/**
	 * 代弁金払込日を取得します。
	 *
	 * @return 代弁金払込日
	 */
	public String getID_Date_DaibenkinHaraikomi() {
		return (String) getValue("ID_Date_DaibenkinHaraikomi");
	}

	/**
	 * 代弁金払込日を設定します。
	 *
	 * @param ID_Date_DaibenkinHaraikomi
	 *            代弁金払込日
	 */
	public void setID_Date_DaibenkinHaraikomi(String ID_Date_DaibenkinHaraikomi) {
		setValue("ID_Date_DaibenkinHaraikomi", ID_Date_DaibenkinHaraikomi);
	}

	/**
	 * 遅延損害金を取得します。
	 *
	 * @return 遅延損害金
	 */
	public String getID_M_ChienSongai() {
		return (String) getValue("ID_M_ChienSongai");
	}

	/**
	 * 遅延損害金を設定します。
	 *
	 * @param ID_M_ChienSongai
	 *            遅延損害金
	 */
	public void setID_M_ChienSongai(String ID_M_ChienSongai) {
		setValue("ID_M_ChienSongai", ID_M_ChienSongai);
	}

	/**
	 * 利息(約定利息)を取得します。
	 *
	 * @return 利息(約定利息)
	 */
	public String getID_M_Risoku() {
		return (String) getValue("ID_M_Risoku");
	}

	/**
	 * 利息(約定利息)を設定します。
	 *
	 * @param ID_M_Risoku
	 *            利息(約定利息)
	 */
	public void setID_M_Risoku(String ID_M_Risoku) {
		setValue("ID_M_Risoku", ID_M_Risoku);
	}

	/**
	 * 元金(約定元金)を取得します。
	 *
	 * @return 元金(約定元金)
	 */
	public String getID_M_Gankin() {
		return (String) getValue("ID_M_Gankin");
	}

	/**
	 * 元金(約定元金)を設定します。
	 *
	 * @param ID_M_Gankin
	 *            元金(約定元金)
	 */
	public void setID_M_Gankin(String ID_M_Gankin) {
		setValue("ID_M_Gankin", ID_M_Gankin);
	}

	/**
	 * 計を取得します。
	 *
	 * @return 計
	 */
	public String getID_M_Kei() {
		return (String) getValue("ID_M_Kei");
	}

	/**
	 * 計を設定します。
	 *
	 * @param ID_M_Kei
	 *            計
	 */
	public void setID_M_Kei(String ID_M_Kei) {
		setValue("ID_M_Kei", ID_M_Kei);
	}

	/**
	 * 仮受金(一般口)からの充当額を取得します。
	 *
	 * @return 仮受金(一般口)からの充当額
	 */
	public String getID_M_KariukeIppanJuto() {
		return (String) getValue("ID_M_KariukeIppanJuto");
	}

	/**
	 * 仮受金(一般口)からの充当額を設定します。
	 *
	 * @param ID_M_KariukeIppanJuto
	 *            仮受金(一般口)からの充当額
	 */
	public void setID_M_KariukeIppanJuto(String ID_M_KariukeIppanJuto) {
		setValue("ID_M_KariukeIppanJuto", ID_M_KariukeIppanJuto);
	}

	/**
	 * 代弁金充当後残元金を取得します。
	 *
	 * @return 代弁金充当後残元金
	 */
	public String getID_M_ZanGanAfterDaibenJuto() {
		return (String) getValue("ID_M_ZanGanAfterDaibenJuto");
	}

	/**
	 * 代弁金充当後残元金を設定します。
	 *
	 * @param ID_M_ZanGanAfterDaibenJuto
	 *            代弁金充当後残元金
	 */
	public void setID_M_ZanGanAfterDaibenJuto(String ID_M_ZanGanAfterDaibenJuto) {
		setValue("ID_M_ZanGanAfterDaibenJuto", ID_M_ZanGanAfterDaibenJuto);
	}

	/**
	 * 繰上償還手数料を取得します。
	 *
	 * @return 繰上償還手数料
	 */
	public String getID_M_KurishoCommission() {
		return (String) getValue("ID_M_KurishoCommission");
	}

	/**
	 * 繰上償還手数料を設定します。
	 *
	 * @param ID_M_KurishoCommission
	 *            繰上償還手数料
	 */
	public void setID_M_KurishoCommission(String ID_M_KurishoCommission) {
		setValue("ID_M_KurishoCommission", ID_M_KurishoCommission);
	}

	/**
	 * 送金額を取得します。
	 *
	 * @return 送金額
	 */
	public String getID_M_Sokin() {
		return (String) getValue("ID_M_Sokin");
	}

	/**
	 * 送金額を設定します。
	 *
	 * @param ID_M_Sokin
	 *            送金額
	 */
	public void setID_M_Sokin(String ID_M_Sokin) {
		setValue("ID_M_Sokin", ID_M_Sokin);
	}

	/**
	 * 送金日を取得します。
	 *
	 * @return 送金日
	 */
	public String getID_Date_Sokin() {
		return (String) getValue("ID_Date_Sokin");
	}

	/**
	 * 送金日を設定します。
	 *
	 * @param ID_Date_Sokin
	 *            送金日
	 */
	public void setID_Date_Sokin(String ID_Date_Sokin) {
		setValue("ID_Date_Sokin", ID_Date_Sokin);
	}

	/**
	 * 送金日番号を取得します。
	 *
	 * @return 送金日番号
	 */
	public String getID_ID_Sokinbi() {
		return (String) getValue("ID_ID_Sokinbi");
	}

	/**
	 * 送金日番号を設定します。
	 *
	 * @param ID_ID_Sokinbi
	 *            送金日番号
	 */
	public void setID_ID_Sokinbi(String ID_ID_Sokinbi) {
		setValue("ID_ID_Sokinbi", ID_ID_Sokinbi);
	}

	/**
	 * 受託者勘定処理年月を取得します。
	 *
	 * @return 受託者勘定処理年月
	 */
	public String getID_Date_Jtkshori() {
		return (String) getValue("ID_Date_Jtkshori");
	}

	/**
	 * 受託者勘定処理年月を設定します。
	 *
	 * @param ID_Date_Jtkshori
	 *            受託者勘定処理年月
	 */
	public void setID_Date_Jtkshori(String ID_Date_Jtkshori) {
		setValue("ID_Date_Jtkshori", ID_Date_Jtkshori);
	}

	/**
	 * 貸付金残高（非表示）を取得します。
	 *
	 * @return 貸付金残高（非表示）
	 */
	public String getID_M_KashitsukeZandaka() {
		return (String) getValue("ID_M_KashitsukeZandaka");
	}

	/**
	 * 貸付金残高（非表示）を設定します。
	 *
	 * @param ID_M_KashitsukeZandaka
	 *            貸付金残高（非表示）
	 */
	public void setID_M_KashitsukeZandaka(String ID_M_KashitsukeZandaka) {
		setValue("ID_M_KashitsukeZandaka", ID_M_KashitsukeZandaka);
	}

	/**
	 * 報告時分秒（非表示）を取得します。
	 *
	 * @return 報告時分秒（非表示）
	 */
	public String getID_Time_Report() {
		return (String) getValue("ID_Time_Report");
	}

	/**
	 * 報告時分秒（非表示）を設定します。
	 *
	 * @param ID_Time_Report
	 *            報告時分秒（非表示）
	 */
	public void setID_Time_Report(String ID_Time_Report) {
		setValue("ID_Time_Report", ID_Time_Report);
	}

	/**
	 * ユーザID（非表示）を取得します。
	 *
	 * @return ユーザID（非表示）
	 */
	public String getID_User_ID() {
		return (String) getValue("ID_User_ID");
	}

	/**
	 * ユーザID（非表示）を設定します。
	 *
	 * @param ID_User_ID
	 *            ユーザID（非表示）
	 */
	public void setID_User_ID(String ID_User_ID) {
		setValue("ID_User_ID", ID_User_ID);
	}

	/**
	 * 伝送番号（非表示）を取得します。
	 *
	 * @return 伝送番号（非表示）
	 */
	public String getID_ID_Denso() {
		return (String) getValue("ID_ID_Denso");
	}

	/**
	 * 伝送番号（非表示）を設定します。
	 *
	 * @param ID_ID_Denso
	 *            伝送番号（非表示）
	 */
	public void setID_ID_Denso(String ID_ID_Denso) {
		setValue("ID_ID_Denso", ID_ID_Denso);
	}

	/**
	 * データコードを取得します。
	 *
	 * @return データコード
	 */
	public String getID_DataCode() {
		return (String) getValue("ID_DataCode");
	}

	/**
	 * データコードを設定します。
	 *
	 * @param ID_DataCode
	 *            データコード
	 */
	public void setID_DataCode(String ID_DataCode) {
		setValue("ID_DataCode", ID_DataCode);
	}

	/**
	 * 履歴番号（非表示）を取得します。
	 *
	 * @return 履歴番号（非表示）
	 */
	public String getID_ID_History() {
		return (String) getValue("ID_ID_History");
	}

	/**
	 * 履歴番号（非表示）を設定します。
	 *
	 * @param ID_ID_History
	 *            履歴番号（非表示）
	 */
	public void setID_ID_History(String ID_ID_History) {
		setValue("ID_ID_History", ID_ID_History);
	}

	/**
	 * ステータス（非表示）を取得します。
	 *
	 * @return ステータス（非表示）
	 */
	public String getID_Status() {
		return (String) getValue("ID_Status");
	}

	/**
	 * ステータス（非表示）を設定します。
	 *
	 * @param ID_Status
	 *            ステータス（非表示）
	 */
	public void setID_Status(String ID_Status) {
		setValue("ID_Status", ID_Status);
	}

	/**
	 * 処理種別を取得します。
	 *
	 * @return 処理種別
	 */
	public String getID_Type_Process() {
		return (String) getValue("ID_Type_Process");
	}

	/**
	 * 処理種別を設定します。
	 *
	 * @param ID_Type_Process
	 *            処理種別
	 */
	public void setID_Type_Process(String ID_Type_Process) {
		setValue("ID_Type_Process", ID_Type_Process);
	}

	/**
	 * 取消済みフラグ（非表示）を取得します。
	 *
	 * @return 取消済みフラグ（非表示）
	 */
	public String getID_Flag_Torikeshizumi() {
		return (String) getValue("ID_Flag_Torikeshizumi");
	}

	/**
	 * 取消済みフラグ（非表示）を設定します。
	 *
	 * @param ID_Flag_Torikeshizumi
	 *            取消済みフラグ（非表示）
	 */
	public void setID_Flag_Torikeshizumi(String ID_Flag_Torikeshizumi) {
		setValue("ID_Flag_Torikeshizumi", ID_Flag_Torikeshizumi);
	}

	/**
	 * エラー番号（非表示）を取得します。
	 *
	 * @return エラー番号（非表示）
	 */
	public String getID_Code_Error() {
		return (String) getValue("ID_Code_Error");
	}

	/**
	 * エラー番号（非表示）を設定します。
	 *
	 * @param ID_Code_Error
	 *            エラー番号（非表示）
	 */
	public void setID_Code_Error(String ID_Code_Error) {
		setValue("ID_Code_Error", ID_Code_Error);
	}

	/**
	 * エラーメッセージ（非表示）を取得します。
	 *
	 * @return エラーメッセージ（非表示）
	 */
	public String getID_ErrorMessage() {
		return (String) getValue("ID_ErrorMessage");
	}

	/**
	 * エラーメッセージ（非表示）を設定します。
	 *
	 * @param ID_ErrorMessage
	 *            エラーメッセージ（非表示）
	 */
	public void setID_ErrorMessage(String ID_ErrorMessage) {
		setValue("ID_ErrorMessage", ID_ErrorMessage);
	}

	/**
	 * 退避貸付金残高（非表示）を取得します。
	 *
	 * @return 退避貸付金残高（非表示）
	 */
	public String getID_Keep_M_KashitsukeZan() {
		return (String) getValue("ID_Keep_M_KashitsukeZan");
	}

	/**
	 * 退避貸付金残高（非表示）を設定します。
	 *
	 * @param ID_Keep_M_KashitsukeZan
	 *            退避貸付金残高（非表示）
	 */
	public void setID_Keep_M_KashitsukeZan(String ID_Keep_M_KashitsukeZan) {
		setValue("ID_Keep_M_KashitsukeZan", ID_Keep_M_KashitsukeZan);
	}

	/**
	 * 退避約定元金を取得します。
	 *
	 * @return 退避約定元金
	 */
	public String getID_Keep_M_YakujoGankin() {
		return (String) getValue("ID_Keep_M_YakujoGankin");
	}

	/**
	 * 退避約定元金を設定します。
	 *
	 * @param ID_Keep_M_YakujoGankin
	 *            退避約定元金
	 */
	public void setID_Keep_M_YakujoGankin(String ID_Keep_M_YakujoGankin) {
		setValue("ID_Keep_M_YakujoGankin", ID_Keep_M_YakujoGankin);
	}

	/**
	 * 退避約定利息を取得します。
	 *
	 * @return 退避約定利息
	 */
	public String getID_Keep_M_YakujoRisoku() {
		return (String) getValue("ID_Keep_M_YakujoRisoku");
	}

	/**
	 * 退避約定利息を設定します。
	 *
	 * @param ID_Keep_M_YakujoRisoku
	 *            退避約定利息
	 */
	public void setID_Keep_M_YakujoRisoku(String ID_Keep_M_YakujoRisoku) {
		setValue("ID_Keep_M_YakujoRisoku", ID_Keep_M_YakujoRisoku);
	}

	/**
	 * 退避償還期限（非表示）を取得します。
	 *
	 * @return 退避償還期限（非表示）
	 */
	public String getID_Keep_Date_ShokanKigen() {
		return (String) getValue("ID_Keep_Date_ShokanKigen");
	}

	/**
	 * 退避償還期限（非表示）を設定します。
	 *
	 * @param ID_Keep_Date_ShokanKigen
	 *            退避償還期限（非表示）
	 */
	public void setID_Keep_Date_ShokanKigen(String ID_Keep_Date_ShokanKigen) {
		setValue("ID_Keep_Date_ShokanKigen", ID_Keep_Date_ShokanKigen);
	}

	/**
	 * 原本番号(非表示)を取得します。
	 *
	 * @return 原本番号(非表示)
	 */
	public String getID_ID_Master() {
		return (String) getValue("ID_ID_Master");
	}

	/**
	 * 原本番号(非表示)を設定します。
	 *
	 * @param ID_ID_Master
	 *            原本番号(非表示)
	 */
	public void setID_ID_Master(String ID_ID_Master) {
		setValue("ID_ID_Master", ID_ID_Master);
	}

	/**
	 * 電子署名付データ（非表示）を取得します。
	 *
	 * @return 電子署名付データ（非表示）
	 */
	public String getID_SignData() {
		return (String) getValue("ID_SignData");
	}

	/**
	 * 電子署名付データ（非表示）を設定します。
	 *
	 * @param ID_SignData
	 *            電子署名付データ（非表示）
	 */
	public void setID_SignData(String ID_SignData) {
		setValue("ID_SignData", ID_SignData);
	}

	/**
	 * 債権管理番号（非表示）を取得します。
	 *
	 * @return 債権管理番号（非表示）
	 */
	public String getID_ID_Credit() {
		return (String) getValue("ID_ID_Credit");
	}

	/**
	 * 債権管理番号（非表示）を設定します。
	 *
	 * @param ID_ID_Credit
	 *            債権管理番号（非表示）
	 */
	public void setID_ID_Credit(String ID_ID_Credit) {
		setValue("ID_ID_Credit", ID_ID_Credit);
	}

	/**
	 * 顧客コード（非表示）を取得します。
	 *
	 * @return 顧客コード（非表示）
	 */
	public String getID_Code_Customer() {
		return (String) getValue("ID_Code_Customer");
	}

	/**
	 * 顧客コード（非表示）を設定します。
	 *
	 * @param ID_Code_Customer
	 *            顧客コード（非表示）
	 */
	public void setID_Code_Customer(String ID_Code_Customer) {
		setValue("ID_Code_Customer", ID_Code_Customer);
	}

	/**
	 * 退避請求繰償還利息を取得します。
	 *
	 * @return 退避請求繰償還利息
	 */
	public String getKeep_Seikyu_M_SeiKuriRisoku() {
		return (String) getValue("Keep_Seikyu_M_SeiKuriRisoku");
	}

	/**
	 * 退避請求繰償還利息を設定します。
	 *
	 * @param Keep_Seikyu_M_SeiKuriRisoku
	 *            退避請求繰償還利息
	 */
	public void setKeep_Seikyu_M_SeiKuriRisoku(String Keep_Seikyu_M_SeiKuriRisoku) {
		setValue("Keep_Seikyu_M_SeiKuriRisoku", Keep_Seikyu_M_SeiKuriRisoku);
	}

	/**
	 * 最新データ更新日付（非表示）を取得します。
	 *
	 * @return 最新データ更新日付（非表示）
	 */
	public String getData_LastUpDate() {
		return (String) getValue("Data_LastUpDate");
	}

	/**
	 * 最新データ更新日付（非表示）を設定します。
	 *
	 * @param Data_LastUpDate
	 *            最新データ更新日付（非表示）
	 */
	public void setData_LastUpDate(String Data_LastUpDate) {
		setValue("Data_LastUpDate", Data_LastUpDate);
	}

	/**
	 * 退避履歴番号（非表示）を取得します。
	 *
	 * @return 退避履歴番号（非表示）
	 */
	public String getID_Keep_ID_History() {
		return (String) getValue("ID_Keep_ID_History");
	}

	/**
	 * 退避履歴番号（非表示）を設定します。
	 *
	 * @param ID_Keep_ID_History
	 *            退避履歴番号（非表示）
	 */
	public void setID_Keep_ID_History(String ID_Keep_ID_History) {
		setValue("ID_Keep_ID_History", ID_Keep_ID_History);
	}

	/**
	 * 退避実行済みフラグ（非表示）を取得します。
	 *
	 * @return 退避実行済みフラグ（非表示）
	 */
	public String getID_Keep_Flag_Kj() {
		return (String) getValue("ID_Keep_Flag_Kj");
	}

	/**
	 * 退避実行済みフラグ（非表示）を設定します。
	 *
	 * @param ID_Keep_Flag_Kj
	 *            退避実行済みフラグ（非表示）
	 */
	public void setID_Keep_Flag_Kj(String ID_Keep_Flag_Kj) {
		setValue("ID_Keep_Flag_Kj", ID_Keep_Flag_Kj);
	}

	/**
	 * 扱店別稟議データより取得した償還期限年月（非表示）を取得します。
	 *
	 * @return 扱店別稟議データより取得した償還期限年月（非表示）
	 */
	public String getID_aRingi_Date_ShokanKigen() {
		return (String) getValue("ID_aRingi_Date_ShokanKigen");
	}

	/**
	 * 扱店別稟議データより取得した償還期限年月（非表示）を設定します。
	 *
	 * @param ID_aRingi_Date_ShokanKigen
	 *            扱店別稟議データより取得した償還期限年月（非表示）
	 */
	public void setID_aRingi_Date_ShokanKigen(String ID_aRingi_Date_ShokanKigen) {
		setValue("ID_aRingi_Date_ShokanKigen", ID_aRingi_Date_ShokanKigen);
	}

	/**
	 * 退避請求繰償還元金を取得します。
	 *
	 * @return 退避請求繰償還元金
	 */
	public String getKeep_Seikyu_M_SeiKuriGankin() {
		return (String) getValue("Keep_Seikyu_M_SeiKuriGankin");
	}

	/**
	 * 退避請求繰償還元金を設定します。
	 *
	 * @param Keep_Seikyu_M_SeiKuriGankin
	 *            退避請求繰償還元金
	 */
	public void setKeep_Seikyu_M_SeiKuriGankin(String Keep_Seikyu_M_SeiKuriGankin) {
		setValue("Keep_Seikyu_M_SeiKuriGankin", Keep_Seikyu_M_SeiKuriGankin);
	}

}