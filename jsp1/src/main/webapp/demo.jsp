<%@page pageEncoding="utf-8"%>
<!-- 1.先写HTML -->
<!doctype html>
<html>
 <head>
  <meta charset="utf-8">
  <title>第一个JSP</title>
 </head>
 <body>
   <!-- 2.再写java -->
   <!-- 2.3jsp声明(声明方法) -->
   <%!
     public int pf(int n){
	   return n*n;
   }
   %>
   <ul>
     <!-- 2.1jsp脚本（完整的代码段） -->
     <%
       for(int i=0;i<10;i++){
    %>
       <!-- 2.2jsp表达式（输出变量） -->
       <li><%=pf(i) %></li>
    <% 	   
       }
     %>
   </ul>
   
   <!-- 引入date.jsp，相当于将date.jsp中的内容复制到此处 -->
   <%@include file="date.jsp" %>
 </body>
</html>