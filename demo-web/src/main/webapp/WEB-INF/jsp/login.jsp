<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String BASE_PATH = "/";
    String path = request.getContextPath();
    String CONTEXT = request.getScheme() + "://"
        + request.getServerName() + ":" + request.getServerPort()
        + path + "/";
	request.setAttribute("CONTEXT",CONTEXT);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   	    <base href="<%=CONTEXT%>">
		<title>登陆页面</title>	
		<link rel="stylesheet" href="assets/css/core.css" />
		<link rel="stylesheet" href="assets/css/menu.css" />
		<link rel="stylesheet" href="assets/css/amazeui.css" />
		<link rel="stylesheet" href="assets/css/component.css" />
		<link rel="stylesheet" href="assets/css/page/form.css" />
  </head>
  <body>
		<div class="account-pages">
			<div class="wrapper-page">
				<div class="text-center">
	                <a href="index.html" class="logo"><span>Admin<span>to</span></span></a>
	            </div>
	            
	            <div class="m-t-40 card-box">
	            	<div class="text-center">
	                    <h4 class="text-uppercase font-bold m-b-0">Sign In</h4>
	                </div>
	                <div class="panel-body">
	                	<form class="am-form" action="login" method="post">
	                		<div class="am-g">
	                			<div class="am-form-group">
							      <input type="text" name="loginName" class="am-radius"  placeholder="登陆名称">
							    </div>
							
							    <div class="am-form-group form-horizontal m-t-20">
							      <input type="password" name="password" class="am-radius"  placeholder="密码">
							    </div>
							    
							    <div class="am-form-group ">
		                           	<label style="font-weight: normal;color: #999;">
								        <input type="checkbox"  name="rememberMe" class="remeber"> Remember me
								    </label>
		                        </div>
		                        
		                       <div class="am-form-group ">
		                        	<button type="submit" class="am-btn am-btn-primary am-radius" style="width: 100%;/* height: 100%*/;">Log In</button>
		                        </div>
		                        
		                        <div class="am-form-group ">
		                        <a href="page-recoverpw.html" class="text-muted"><i class="fa fa-lock m-r-5"></i> Forgot your password?</a>
		                        </div>
	                		</div>

	                	</form>
							
	                </div>
	            </div>
			</div>
		</div>
	</body>
	
</html>
