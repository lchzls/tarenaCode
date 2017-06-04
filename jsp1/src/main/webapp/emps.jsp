<%@page pageEncoding="utf-8"
   import="java.util.*,entity.*" %>
<html>
 <head>
   <meta charset="utf-8">
   <title>员工查询使用</title>
 </head>
 <body>
  <table border="1" width="40%" cellspacing="0">
    <tr>
     <td>编号</td>
     <td>姓名</td>
     <td>职位</td>
     <td>薪资</td>
    </tr>
    <%
    //转发时Servlet将数据绑定到request上，并将request转发给了jsp，所以此处可以直接通过request获得绑定的数据 
    	List<Emp> list = (List<Emp>)request.getAttribute("emps");
    if(list!=null){
    	for(Emp e:list){
    %>
    	<tr>
    		<td><%=e.getEmpno() %></td>
    		<td><%=e.getEname() %></td>
    		<td><%=e.getJob() %></td>
    		<td><%=e.getSal() %></td>
    	</tr>
    <% 
    	}
    }
    %>
  </table>
 </body>
</html>