package day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

import day02.DBUtil;
import day03.UserInfoDAO;
import day03.UserInfoDAOImp;

/*
 * 用户管理系统
 * 功能：1.注册新用户 2.用户登录 3.修改用户信息 4.查看用户余额  
 * 5.显示所有用户信息（不含有用户密码信息） 6.转账  7.注销 
 */
public class UserService {

	private UserInfo userInfo;  //表示当前登录的用户
	private UserInfoDAO userInfoDAO; //通过这个userInfoDAO去调用其中的方法
	
	//保持好习惯，如果定义了成员变量(如对象），就要在构造函数中初始化
	public UserService(){
	
		userInfo = new UserInfo(); //要记得初始化，否则会报空指针异常
		/*
		 * 将来，这里不会直接new这个DAO的实现类而是靠工厂反射一个实例回来。
		 * 若使用spring框架，DAO的初始化也是靠spring注入实例。这些都可以达到业务层与DAO层解耦的目的。
		 */
		userInfoDAO = new UserInfoDAOImp(); //忘记初始化new，报空指针异常！
	}
	
	public void start(){
		
		try {
			Scanner scanner = new Scanner(System.in);
			while(true){
				System.out.println("欢迎登录用户管理系统");	
				System.out.println("1.注册新用户");	
				System.out.println("2.用户登录 ");	
				System.out.println("3.修改用户信息");	
				System.out.println("4.查看用户余额 ");	
				System.out.println("5.显示所有用户信息");	
				System.out.println("6.转账");	
				System.out.println("7.注销");	
				System.out.println("请输入序号来进行相应操作");
				int index = Integer.parseInt(scanner.next());
				switch(index){
				case 1:
					reg();
					break;
				case 2:
					login();
					break;
				case 3:
					update();
					break;
				case 4:
					showAccout();
					break;
				case 5:
					showAllUser();
					break;
				case 6:
					transforAccount();
					break;	
				case 7:
					logout();
					break;	
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
    //转账
	private void transforAccount(){
		/*
		 * 转账业务:
		 * 首先必须是登陆用户
		 * 要求用户输入转入账号的用户名
		 * 然后在输出转出的金额
		 * 该金额必须小于等于当前用户的余额
		 * 然后执行SQL语句，将当前用户的余额
		 * 与转入账户的余额进行相应的修改。
		 * 最终通知当前用户转账操作是否成功。
		 */
		if(userInfo==null){
			System.out.println("请先登陆");
			return;
		}
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入转入账号的用户名:");
		String inUser = scanner.nextLine();
		UserInfo userinfo2 = userInfoDAO.findByName(inUser);
		if(userinfo2==null){
			System.out.println("对不起，"+userinfo2+"不存在！");
			return ;
		}
		System.out.println("您当前余额为:"+this.userInfo.getAccount());
		double money = 0; 
		//使用break和continue来实现循环输入，直到满足条件。continue的作用是跳到本次循环的末尾
		while(true){
			System.out.println("请输入转出金额:");
			money = Double.parseDouble(scanner.nextLine());
			if(money>this.userInfo.getAccount()){
				System.out.println("余额金额不足。");
				continue;
			}
			break;
		}
		try {
			/*
			 * JDBC默认是自动提交事务的，即:
			 * 每当执行一条DML操作后，就自动执行COMMIT。
			 * 若希望执行控制事务，需要先取消自动提交事务，然后在控制事务。
			 * 事务的控制是Connection管理的
			 */
			userInfo.setAccount(userInfo.getAccount()-money);
			userinfo2.setAccount(userinfo2.getAccount()+money);
			boolean f  = userInfoDAO.updateForTransfor(userInfo, userinfo2);
			
			if(f){
				System.out.println("转账成功");
			}else{
				System.out.println("转账失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}
	
	
//	1.注册新用户
	private void reg(){
		
		Scanner scan = new Scanner(System.in);
		System.out.println("欢迎注册");
//		请注意，这里的输入用户名，通过调用函数返回用户名，保证该用户名第一次注册
		System.out.println("请输入用户名");
		String username = getUserName();
		System.out.println("请输入密码");
		String password = scan.next();
		System.out.println("请输入邮箱");
		String email = scan.next();
		System.out.println("请输入昵称");
		String nickname = scan.next();
		System.out.println("请输入余额");
		int account = Integer.parseInt(scan.next());
		
		try {
        	UserInfo userinfo =
					new UserInfo(1,username,password,email,nickname,account);
			boolean tf  = userInfoDAO.save(userinfo);
			if(tf){
				System.out.println("注册成功！");
				System.out.println("id:"+userinfo.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//保证用户名唯一，若输入的用户名不唯一，则一直输入，保证注册时用户名不重复
	private String getUserName(){
		
		try {
			Scanner scanner = new Scanner(System.in);
			while(true){
				
				String username = scanner.next();
				UserInfo userinfo = userInfoDAO.findByName(username);
				if(userinfo!=null){
					System.out.println("该用户已存在");
				}else{
					return username;
				}	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	
	/* 2.用户登录 
	 * 要求用户输入用户名和密码
	 * 根据用户输入的用户名和密码查询userinfo表
	 * 若可以查询出该用户记录，则创建一个UserInfo实例，并将
	 * 查询出的该用户信息设置到这个实例上，然后将该实例赋给UserService的属性
	 * userInfo上表示其登录成功。
	 * */
	private void login(){
		Scanner scan = new Scanner(System.in);
		System.out.println("欢迎登录");
		System.out.println("请输入用户名");//最好这里也用nextLine()，保持习惯
		String username = scan.nextLine();
		System.out.println("请输入密码");
//		String password = scan.next(); 输入密码为aa' or '1'='1一直报错，原因，next()会忽略空格！
		String password = scan.nextLine(); 
		
		try {
			userInfo = userInfoDAO.findByName(username);
			if(userInfo!=null&&userInfo.getPassword().equals(password)){
				System.out.println("欢迎你！");
			}else{
				System.out.println("登录失败");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
//	 3.修改用户信息（需要登录后才可操作):修改用户信息只能修改当前登录用户的密码、邮箱、昵称
	private void update(){
		if(userInfo==null){
			System.out.println("请先登录，再更新");
		}else{
			
			try {
				Scanner scan = new Scanner(System.in);
				System.out.println("欢迎进入修改操作");
				System.out.println("请输入修改后的密码");
				String password = scan.next();
				System.out.println("请输入修改后的邮箱");
				String  email= scan.next();
				System.out.println("请输入修改后的昵称");
				String nickname = scan.next();
				userInfo.setPassword(password);
				userInfo.setEmail(email);
				userInfo.setNickname(nickname);
				boolean f = userInfoDAO.update(userInfo);
				if(f){
					System.out.println("修改用户成功");
				}else{
					System.out.println("修改用户失败");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		}
		
	}
	
//	4.查看用户余额 
	private void showAccout(){
		if(userInfo==null){
			System.out.println("请先登录，再更新");
			return;
		}
		try {
			userInfoDAO.showAccout(userInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	

//	5.显示所有用户信息,仅显示所有用户名的用户名、邮箱、昵称，余额	
	private void showAllUser(){

		try {
			List<UserInfo> list = userInfoDAO.findAll();
			for(UserInfo user:list){
				System.out.println(user.getUsername()+","
			    +user.getEmail()+","+user.getNickname()+","
				+user.getAccount());	
			}
			System.out.println("已显示所有用户信息");
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
//	6.注销(登出操作，需要登录后才可操作）
	private void logout(){
		
		if(userInfo!=null){
			userInfo = null;
			System.out.println("注销完毕");
		}else{
			System.out.println("登录后才可以注销");
		}
		
	}
	
	public static void main(String[] args) {
		
		try {
			UserService userService = new UserService();
			userService.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
