package day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCDemo5 {

  public static void main(String[] args) {
	
	  try {
		  Class.forName("oracle.jdbc.driver.OracleDriver");
		  Connection conn = 
				  DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
	      Statement state = conn.createStatement();
	      Scanner scan = new Scanner(System.in);
	      System.out.println("输入每页显示的条数");
	      int size = scan.nextInt();
	      System.out.println("输入显示第几页");
	      int page = scan.nextInt();
	      int start = (page-1)*size+1;
	      int end = page*size;
	      System.out.println(start+","+end);
	     String sql =  "select * from "
	     		+ "(select rownum rn,t.* "
	     		+ "from(select empno,ename,sal,job,deptno from emp_lch order by sal desc) t "
	     		+ "where rownum<="+end+") "
	     		+ "where rn>="+start;
	     
	      ResultSet  rs  = state.executeQuery(sql);
	      while(rs.next()){
	    	 
	    	  int empno = rs.getInt("empno");
	    	  String ename = rs.getString("ename");
	    	  double sal = rs.getDouble("sal");
	    	  String job = rs.getString("job");
	    	  int deptno = rs.getInt("deptno");
	    	  System.out.println(empno+","+ename+","+sal+","+job+","+deptno);
	      }
		  conn.close();
		  state.close();
	  } catch (Exception e) {
		e.printStackTrace();
	}
	
	  
}
}
