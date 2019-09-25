package com.internousdev.olive.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.olive.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class CreateDestinationConfirmAction extends ActionSupport implements SessionAware{

	private String familyName;
	private String firstName;
	private String familyNameKana;
	private String firstNameKana;
	private String email;
	private String telNumber;
	private String userAddress;
	private Map<String, Object> session;
	private List<String> familyNameErrorList;
	private List<String> firstNameErrorList;
	private List<String> familyNameKanaErrorList;
	private List<String> firstNameKanaErrorList;
	private List<String> emailErrorList;
	private List<String> telNumberErrorList;
	private List<String> userAddressErrorList;

	public String execute() {

		//セッションタイムアウト
		if(! session.containsKey("tempUserId")&&! session.containsKey("userId")) {
			return "sessionTimeout";
		}

		String result =ERROR;

		//入力内容のチェック
		InputChecker inputChecker = new InputChecker();

		familyNameErrorList=inputChecker.doCheck("姓", familyName, 1, 16, true, true, true, false, false, false);
		firstNameErrorList=inputChecker.doCheck("名", firstName, 1, 16, true, true, true, false, false, false);
		familyNameKanaErrorList=inputChecker.doCheck("姓ふりがな", familyNameKana, 1, 16,false, false, true, false, false, false );
		firstNameKanaErrorList=inputChecker.doCheck("名ふりがな", firstNameKana, 1, 16, false, false, true, false, false, false);
		userAddressErrorList=inputChecker.doCheck("住所", userAddress, 10, 50, true, true, true, true, true, false);
		telNumberErrorList=inputChecker.doCheck("電話番号", telNumber, 10, 13, false, false, false, true, false, false);
		emailErrorList=inputChecker.doCheckForEmail("メールアドレス", email, 10, 32);

		// 情報保存（CreateDestinationComplete後はsession消去）
		session.put("familyName", familyName);
		session.put("firstName", firstName);
		session.put("familyNameKana", familyNameKana);
		session.put("firstNameKana", firstNameKana);
		session.put("email", email);
		session.put("telNumber", telNumber);
		session.put("userAddress", userAddress);

		//エラーリストから対象エラーを検出
		if(familyNameErrorList.size()>0
				||firstNameErrorList.size()>0
				||familyNameKanaErrorList.size()>0
				||firstNameKanaErrorList.size()>0
				||emailErrorList.size()>0
				||telNumberErrorList.size()>0
				||userAddressErrorList.size()>0
				){
			result =ERROR;
		}else {
			result =SUCCESS;
		}

		return result;

	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFamilyNameKana() {
		return familyNameKana;
	}

	public void setFamilyNameKana(String familyNameKana) {
		this.familyNameKana = familyNameKana;
	}

	public String getFirstNameKana() {
		return firstNameKana;
	}

	public void setFirstNameKana(String firstNameKana) {
		this.firstNameKana = firstNameKana;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelNumber() {
		return telNumber;
	}

	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public List<String> getFamilyNameErrorList() {
		return familyNameErrorList;
	}

	public void setFamilyNameErrorList(List<String> familyNameErrorList) {
		this.familyNameErrorList = familyNameErrorList;
	}

	public List<String> getFirstNameErrorList() {
		return firstNameErrorList;
	}

	public void setFirstNameErrorList(List<String> firstNameErrorList) {
		this.firstNameErrorList = firstNameErrorList;
	}

	public List<String> getFamilyNameKanaErrorList() {
		return familyNameKanaErrorList;
	}

	public void setFamilyNameKanaErrorList(List<String> familyNameKanaErrorList) {
		this.familyNameKanaErrorList = familyNameKanaErrorList;
	}

	public List<String> getFirstNameKanaErrorList() {
		return firstNameKanaErrorList;
	}

	public void setFirstNameKanaErrorList(List<String> firstNameKanaErrorList) {
		this.firstNameKanaErrorList = firstNameKanaErrorList;
	}

	public List<String> getEmailErrorList() {
		return emailErrorList;
	}

	public void setEmailErrorList(List<String> emailErrorList) {
		this.emailErrorList = emailErrorList;
	}

	public List<String> getTelNumberErrorList() {
		return telNumberErrorList;
	}

	public void setTelNumberErrorList(List<String> telNumberErrorList) {
		this.telNumberErrorList = telNumberErrorList;
	}

	public List<String> getUserAddressErrorList() {
		return userAddressErrorList;
	}

	public void setUserAddressErrorList(List<String> userAddressErrorList) {
		this.userAddressErrorList = userAddressErrorList;
	}

}