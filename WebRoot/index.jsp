<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String code=request.getParameter("code");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html class="ui-page-login">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <meta name="apple-mobile-web-app-status-bar-style" content="black"/>
    <title>登录页面</title>
    <link href="css/mui.min.css" rel="stylesheet" />
    <style type="text/css">
        .login-content{
            position: absolute;
            top: 30%;
            width: 90%;
            left: 50%;
            margin-left: -45%;
            border-radius: 10px;
            padding: 0 25px;
            background-color: #fff;
        }
        .ui-page-login,  body {
            width: 100%;
            height: 100%;
            margin: 0;
            padding: 0;
        }
        .ui-page-login{
            background-image: url("images/login-bg.jpg");
            background-size: 100% 100%;
        }
        .login-content{
            position: absolute;
            top: 30%;
            width: 90%;
            left: 50%;
            margin-left: -45%;
            border-radius: 10px;
            padding: 0 25px;
            background-color: #fff;
        }
        .login-logo{
            text-align: center;
            margin-top: -37px;
        }
        .login-logo img{
            border: 1px solid #fb4746;
            border-radius: 50%;
        }
        .ipttxt-row{
            margin-top: 12px;
            display: flex;
            justify-content: space-between;
        }
        .ipttxt-row label{
            width: 20%;
        }
        .ipttxt-row .mui-input{
            width: 80%;
            border: 1px solid #fb4746;
            border-radius: 30px;
            margin-bottom: 0;
            background-color: transparent;
        }
        .ipttxt-row .mui-input::placeholder{ font-size: 14px;}
        .link-area{
            margin-top: 12px;
            margin-bottom: 15px;
            text-align: right;
        }
        .link-area a{
            color: #fb4746;
            font-size: 14px;
        }
        .mui-btn-login{
            padding: 10px 0;
            background-color: #ff7776;
            border: 1px solid #fb4746;
            border-radius: 30px;
            color: #fff;
        }
    </style>
    <script type="text/javascript">
    function df(){
    alert("sd");
    alert("sd1");
    }
    </script>
</head>
<body class="ui-page-login">
    <header class="mui-bar mui-bar-transparent">
        <a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left"></a>
    </header>
    <div class="login-content">
        <div class="login-logo"><img src="images/default.gif"/></div>
        <form id="login-form" action="test" method="get">
            <div class="ipttxt-row">
                <label><img src="images/accout.png"/></label>
                <input id="account" type="text" class="mui-input" placeholder="账号" name="account"/>
            </div>
            <div class="ipttxt-row">
                <label><img src="images/password.png"/></label>
                <input id="password" type="password" class="mui-input" placeholder="密码" name="password"/>
                <input type="hidden" id="code" value=<%=code %> name="code"/>
            </div>
            <div class="link-area">
                <a href="forget_password.html">忘记密码?</a>
            </div>
             <div class="">
            <input type="button" id="login" class="mui-btn mui-btn-block mui-btn-login" value="登录" onclick="df()"/>
        </div>
        </form>
        
    </div>
</body>
</html>
