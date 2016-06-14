package com.action;

import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import persist.user.Login;
import persist.user.UserInfo;

import com.googlecode.jsonplugin.annotations.JSON;
import com.interceptor.ACI;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.server.UserServer;
import com.tools.Chinese;
import com.tools.MD5;

@SuppressWarnings("serial")
public class UserInfoAction extends ActionSupport{
	
	private final Log log=LogFactory.getLog(getClass());
	
	private int uid;
	private String realName;
	
	private String username;
	
	private String password;
	private String confPassword;
	private String birthPlace;
	private String livePlace;
	private String email;
	private String introduce;
	//
	 private String blogName;
     private String blogSign;
	//
	
	
	private String tips;
	
	
	@Autowired UserServer userServer;


	public String editUserInfo() throws Exception {
		return SUCCESS;
	}
	
	
   public String regUserInfo() throws Exception {
		
		System.out.println("111111");
		System.out.println("111111");
		System.out.println("111111");
		System.out.println("111111");
		System.out.println("111111");
		System.out.println("111111");
		
		return SUCCESS;
	}

/**********************************/	
	public boolean public_validation(){
		if(!ACI.intercept()){
			tips="no_login";return false;
		}
		if(realName.length()>10||realName.length()<2){
			tips="姓名长度不正确,2-10位";
			return false;
		}
		if(!Pattern.matches("\\w{8,15}",password.trim())){
			tips="密码长度为8-15位,且不能为中文和特殊符号";
			return false;
		}
		if(!Pattern.matches("\\w{8,15}",confPassword.trim())){
			tips="确认密码长度为8-15位,且不能为中文和特殊符号";
			return false;
		}
		if(!password.equals(confPassword)){
			tips="密码两次输入不一致";
			return false;
		}
		if(birthPlace.length()>10||birthPlace.length()<4){
			tips="家乡长度不正确,4-10位.如:湖北武汉";
			return false;
		}
		if(livePlace.length()>10||livePlace.length()<4){
			tips="现居地长度不正确,4-10位.如:湖北广水";
			return false;
		}
		if(!Pattern.matches("[0-9a-zA-Z_\\-\\.]+@[0-9a-zA-Z_\\-]+(\\.[0-9a-zA-Z_\\-]+)*",email.trim())){
			tips="邮箱格式不正确";return false;
		}
		if(introduce.length()>100||introduce.length()<10){
			tips="个人简介长度不正确,最少10个字";
			return false;
		}
		return true;
	}
	@SuppressWarnings("unchecked")
	public void validateRegUserInfo() {
		
		
		
		UserInfo infoByLoginName = userServer.getInfoByLoginName(username);
		
		if (infoByLoginName != null) {
			tips="101010";
		}
		else {
			password = MD5.code(password);//MD5加密
			UserInfo us= new UserInfo();
				us.setBirthPlace(birthPlace);
				us.setLivePlace(livePlace);
				us.setEmail(email);
				us.setIntroduce(introduce);
				us.setRealName(username);
				us.setBlogName(blogName);
				us.setBlogSign(blogSign);
				
				Login login = new Login();
				login.setPassword(password);
				login.setUsername(username);
				login.setUserInfo(us);
				
				
				userServer.save(login);
				
				UserInfo  s = userServer.getInfoByLoginName(username);
				Login login2 = userServer.login(username);
				login2.setUserInfo(s);
				Map session=ActionContext.getContext().getSession();
				session.put("LOGIN", login2);
				
				
//				Login login2 = userServer.login(username);
//				
//				if (login2 != null) {
//					Integer loginid = login2.getId();
//					UserInfo ifno2 = userServer.getInfoByLoginName(username);
//					Integer userifnfoid = ifno2.getId();
//					UserInfo upinfo = new UserInfo();
//				
//					ifno2.setl
//				}
				tips = "000000";
		}
	}

	@SuppressWarnings("unchecked")
	public void validateEditUserInfo() {
		boolean mark=false;
		if(public_validation()){
			Login login=userServer.login(uid);
			UserInfo us=login.getUserInfo();
			us.setRealName(realName);
			if(!password.equals("iloveyou")){
				login.setPassword(MD5.code(password));//MD5加密
				mark=true;
			}
			us.setBirthPlace(birthPlace);
			us.setLivePlace(livePlace);
			us.setEmail(email);
			us.setIntroduce(introduce);
			us.setLogin(login);
			us.setBlogName(blogName);
			us.setBlogSign(blogSign);
			login.setUserInfo(us);
			
			userServer.update(login);
			tips="ok";
			log.error("用户{"+login.getUsername()+"}修改资料成功");
			
			if(mark){//更改密码后退出当前用户
				log.error("用户{"+login.getUsername()+"}修改密码成功");
			
				Map session=ActionContext.getContext().getSession();
				session.remove("LOGIN");
			}
		}
	}
	
/*********************************/	
	@JSON(serialize=false)
	public int getUid() {
		return uid;
	}
	
	public void setUid(int uid) {
		this.uid = uid;
	}
	@JSON(serialize=false)
	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = Chinese.toChinese(realName);
	}
	@JSON(serialize=false)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = Chinese.toChinese(password);
	}
	@JSON(serialize=false)
	public String getConfPassword() {
		return confPassword;
	}
	public void setConfPassword(String confPassword) {
		this.confPassword = confPassword;
	}
	@JSON(serialize=false)
	public String getBirthPlace() {
		return birthPlace;
	}
	public void setBirthPlace(String birthPlace) {
		this.birthPlace = Chinese.toChinese(birthPlace);
	}
	@JSON(serialize=false)
	public String getLivePlace() {
		return livePlace;
	}
	public void setLivePlace(String livePlace) {
		this.livePlace = Chinese.toChinese(livePlace);
	}
	@JSON(serialize=false)
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	@JSON(serialize=false)
	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = Chinese.toChinese(introduce);
	}
	
	//*****************************
    @JSON(serialize=false)
    public String getBlogName() {
		return blogName;
	}

	public void setBlogName(String blogName) {
		this.blogName = Chinese.toChinese(blogName);
	}
	
	@JSON(serialize=false)
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = Chinese.toChinese (username);
	}
	
	@JSON(serialize=false)
	public String getBlogSign() {
		return blogSign;
	}

	public void setBlogSign(String blogSign) {
		this.blogSign = Chinese.toChinese(blogSign);
	}
	//*****************************

/*****************************/
	public String getTips() {
		return tips;
	}
	public void setTips(String tips) {
		this.tips = tips;
	}
	
}
