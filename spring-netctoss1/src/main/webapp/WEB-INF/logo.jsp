<%@page pageEncoding="utf-8"%>
<!-- EL默认从4个隐含对象中取值 :
page、request、session、application
不包括cookie,并且cookie不是隐含对象
若使用EL从cookie中取值，语法如下：
cookie.参数名.value
其中单词cookie和value固定，参数名有变化
-->

<img src="images/logo.png" alt="logo" class="left"/>
<%--<span>欢迎您，${cookie.adminCode.value }</span> --%>
<span>欢迎您，${adminCode }</span>  <%--EL表达式首先看page有无adminCode值，再看request、再看session，
当发现session中存有adminCode值时，可以使用${adminCode }，相当于session.getAttribute("adminCode") --%> 
<a href="/netctoss/logout.do">[退出]</a> 
 