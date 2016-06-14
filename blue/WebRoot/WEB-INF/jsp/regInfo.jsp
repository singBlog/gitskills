<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <style>
			body,input {
				margin: 0px 0;
				padding: 0;
				font: 12px Arial, Sans-Serif;
				line-height: 1.4em;
			}
			form input{height:25px;}
			#log{margin:15px 55px;}
			form{padding:0;margin:0;}
			
			#log form .user,#log form .pass{width:200px;}
			#log form .code{width:60px;}
			
			.username,.password,.varcode,.codeimg,.sub{padding:8px 0;}
			.error{padding:4px 0;}
			.codeimg,.sub,.error{padding-left:55px;}
			.sub input{width:60px;}
			
			.error{color:red;}
			
			a{text-decoration:underline;}
			a:link,a:visited{color:#075181;}
			a:hover{color:red;}
		</style>
    <style type="text/css">
    	#userinfo{margin:10px 30px;padding:0;font-size:12px;color:#333;}
    	#userinfo form{margin:0;padding:0;}
    	#userinfo input,#userinfo textarea{font-size:12px;color:#666;}
    	#userinfo textarea{overflow:auto;}
    	#userinfo .info,#userinfo .userNum{padding:7px 0;}
    	#userinfo .inf{width:212px;border:none;border-bottom:1px solid #999;}
    	#userinfo .btn{width:60px;color:#000;}
    	#userinfo .userNum span{color:#075181;padding:0 10px;}
    	#userinfo .error,#userinfo .sub{padding-top:10px;}
    	#userinfo .error{color:red;}
    </style>
  </head>
  <body>
  	<script type="text/javascript" src="<s:url value='decorators/js/jquery/jquery-latest.js'/>"></script>
  	<script type="text/javascript" src="<s:url value='myjs/ProfileJs.js'/>"></script>
  	<script type="text/javascript" src="<s:url value='myjs/ReplyPart_public.js'/>"></script>
  	<div id="userinfo">
  		<form action="#" method="post">
  			<div class="info">账　　号：  <input type="text" id="username" maxlength="10" value="" class="inf"/></div>
  			<div class="info">姓　　名： <input type="text" id="realname" maxlength="10" value="" class="inf"/></div>
  			<div class="info">密　　码： <input type="password" id="password" maxlength="10" value="" class="inf"/></div>
  			<div class="info">确认密码： <input type="password" id="conf_password" maxlength="10" value="" class="inf"/></div>
  			<div class="info">博客名称：  <input type="text" id="blogName" maxlength="10" value="" class="inf"/></div>
  			<div class="info">博客签名：  <input type="text" id="blogSign" maxlength="10" value="" class="inf"/></div>
  			<div class="info">家　　乡：  <input type="text" id="birthplace" maxlength="10" value="" class="inf"/></div>
  			<div class="info">现　　居：  <input type="text" id="liveplace" maxlength="10" value="" class="inf"/></div>
  			<div class="info">邮　　箱：  <input type="text" id="email" maxlength="30" value="" class="inf"/></div>
  			
  			<!-- 生日 性别  -->
  			
  			<div class="userNum">
		   		个人简介：&nbsp;已用<span>0</span> 未用<span>100</span>总共<span>100</span><br>
		   	</div>
  			<div class="txt">
  					<textarea id="reply" style="width:280px;height:70px;" onkeydown="checkword(100)" onkeyup="checkword(100)" onchange="checkword(100)">${INFO.userInfo.introduce}</textarea>
  			</div>
  			<div class="error"></div>
  			<div class="sub"><input type="submit" value="注册" class="btn" onclick="return regUserInfo();"/></div>
  		</form>
  	</div>
  	<script type="text/javascript">
  	$(function(){
  	
  	 });
  	</script>
  </body>
</html>