package com.internousdev.olive.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.olive.dao.DestinationInfoDAO;
import com.opensymphony.xwork2.ActionSupport;

public class CreateDestinationCompleteAction extends ActionSupport implements SessionAware{

	private Map<String,Object> session;

	public String execute() {

		//セッションタイムアウト
		if(! session.containsKey("tempUserId")&&! session.containsKey("userId")) {
			return "sessionTimeout";
		}

		String result = ERROR;

		//宛先情報の入力が確認出来ればDAO→insert
		DestinationInfoDAO destinationInfoDAO = new DestinationInfoDAO();

		int count = destinationInfoDAO.createDestination(
				session.get("userId").toString(),
				session.get("familyName").toString(),
				session.get("firstName").toString(),
				session.get("familyNameKana").toString(),
				session.get("firstNameKana").toString(),
				session.get("email").toString(),
				session.get("telNumber").toString(),
				session.get("userAddress").toString()
				);

		if(count > 0) {
			result = SUCCESS;
		}

		//DBに登録済みのためセッションから削除
		session.remove("familyName");
		session.remove("firstName");
		session.remove("familyNameKana");
		session.remove("firstNameKana");
		session.remove("email");
		session.remove("telNumber");
		session.remove("userAddress");

		return result;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
