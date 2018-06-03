<%--
  Created by IntelliJ IDEA.
  User: Kingsley
  Date: 2018/6/3
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>欢迎登录红杉科技物料管理系统</title>
    <link href="${ctx}/css/login.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="${ctx}/js/jquery-1.8.3.min.js"></script>


</head>

<body>
<% String loginFailed = (null != request.getAttribute("loginFailed") ?
        request.getAttribute("loginFailed").toString() : ""); %>
<div class="main-login">

    <div class="login-content">
        <h2>用户登录</h2>

        <form action="login" method="post" id="login-form" name="login-form">
            <div class="login-info">
                <span class="user">&nbsp;</span>
                <input name="username" id="username" type="text" value="" class="login-input"/>
            </div>
            <div class="login-info">
                <span class="pwd">&nbsp;</span>
                <input name="password" id="password" type="password" value="" class="login-input"/>
            </div>
            <div class="login-oper">
                <span class="hidden tips">用户名或密码错误，请重新输入</span>
            </div>
            <div class="login-oper">
                <input name="" type="submit" value="登 录" class="login-btn"/>
                <input name="" type="submit" value="重 置" class="login-reset"/>
            </div>
        </form>
    </div>

</div>
<script type="text/javascript">
    var loginFailed = '<%=loginFailed%>';
    if (loginFailed) {
        $(".hidden").css('display', 'block');
    }
</script>
<script type="text/javascript">
    window.history.forward();
</script>

</body>
</html>
