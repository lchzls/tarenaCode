<!-- 本jsp并不独立使用，而是被其他jsp引用 -->
<!-- 
  pageEncoding:设置此文件的编码，在tomcat读取此文件时使用
  contentType:tomcat调用此jsp给浏览器拼网页时，通知浏览器输出的格式及编码 
  import:将指定的类引入到jsp上使用
 -->
<%@page pageEncoding="utf-8" 
   contentType="text/html;charset=utf-8" 
   import="java.util.*,java.text.*"%>
<!doctype html>
<html>
<head>
</head>
<body>
  <%
    Date date = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    String time = sdf.format(date);
  %>
  <p><%=time %></p>
</body>
</html>
