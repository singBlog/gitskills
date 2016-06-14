package com.rss;

public enum EnumEd {
	
	PEOPLE_COOKIE("people_cookie"),
	PAGENO_COOKIE("pageno_cookie"),
	BACK_COOKIE("back_cookie"),
	API_LOGIN_QQ_COOKIE("api_login_qq_cookie"),
	CURRICULUM_COOKIE("curriculum_cookie"),
	API_LOGIN_QQ_URL("api_login_qq_url");
	
	
	private String attr;

	EnumEd(String attr){
		this.attr = attr;
	}
	
	/*public String toString() {
		// TODO Auto-generated method stub
		return attr;
	}*/
	
	
	
}
