package com.internousdev.olive.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class CreateDestinationAction extends ActionSupport implements SessionAware{

	private Map<String,Object> session;
	private String backFlg;

	public String execute() {

		String ret=SUCCESS;

		//セッションタイムアウト
		if(! session.containsKey("tempUserId")&&! session.containsKey("userId")) {
			ret = "sessionTimeout";
		}

		//決済確認画面からの遷移時はセッション消去
		if(backFlg==null) {

			session.remove("familyName");
			session.remove("firstName");
			session.remove("familyNameKana");
			session.remove("firstNameKana");
			session.remove("email");
			session.remove("telNumber");
			session.remove("userAddress");

		}
		return ret;

	}

	public String getBackFlag() {
		return backFlg;
	}

	public void setBackFlg(String backFlg) {
		this.backFlg = backFlg;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}

}