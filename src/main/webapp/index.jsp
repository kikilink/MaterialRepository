<%@ page import="com.newbee.material.repo.util.common.Constants" %>
<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<!-- 立即请求/main -->
<%
    Object loginAttr = request.getSession().getAttribute(Constants.USER_SESSION);
    if (null == loginAttr) {
%>
<jsp:forward page="login-page"/>
<%
} else {
%>
<jsp:forward page="main"/>
<%
    }
%>