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
 * �û�����ϵͳ
 * ���ܣ�1.ע�����û� 2.�û���¼ 3.�޸��û���Ϣ 4.�鿴�û����  
 * 5.��ʾ�����û���Ϣ���������û�������Ϣ�� 6.ת��  7.ע�� 
 */
public class UserService {

	private UserInfo userInfo;  //��ʾ��ǰ��¼���û�
	private UserInfoDAO userInfoDAO; //ͨ�����userInfoDAOȥ�������еķ���
	
	//���ֺ�ϰ�ߣ���������˳�Ա����(����󣩣���Ҫ�ڹ��캯���г�ʼ��
	public UserService(){
	
		userInfo = new UserInfo(); //Ҫ�ǵó�ʼ��������ᱨ��ָ���쳣
		/*
		 * ���������ﲻ��ֱ��new���DAO��ʵ������ǿ���������һ��ʵ��������
		 * ��ʹ��spring��ܣ�DAO�ĳ�ʼ��Ҳ�ǿ�springע��ʵ������Щ�����Դﵽҵ�����DAO������Ŀ�ġ�
		 */
		userInfoDAO = new UserInfoDAOImp(); //���ǳ�ʼ��new������ָ���쳣��
	}
	
	public void start(){
		
		try {
			Scanner scanner = new Scanner(System.in);
			while(true){
				System.out.println("��ӭ��¼�û�����ϵͳ");	
				System.out.println("1.ע�����û�");	
				System.out.println("2.�û���¼ ");	
				System.out.println("3.�޸��û���Ϣ");	
				System.out.println("4.�鿴�û���� ");	
				System.out.println("5.��ʾ�����û���Ϣ");	
				System.out.println("6.ת��");	
				System.out.println("7.ע��");	
				System.out.println("�����������������Ӧ����");
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
	
	
    //ת��
	private void transforAccount(){
		/*
		 * ת��ҵ��:
		 * ���ȱ����ǵ�½�û�
		 * Ҫ���û�����ת���˺ŵ��û���
		 * Ȼ�������ת���Ľ��
		 * �ý�����С�ڵ��ڵ�ǰ�û������
		 * Ȼ��ִ��SQL��䣬����ǰ�û������
		 * ��ת���˻�����������Ӧ���޸ġ�
		 * ����֪ͨ��ǰ�û�ת�˲����Ƿ�ɹ���
		 */
		if(userInfo==null){
			System.out.println("���ȵ�½");
			return;
		}
		Scanner scanner = new Scanner(System.in);
		System.out.println("������ת���˺ŵ��û���:");
		String inUser = scanner.nextLine();
		UserInfo userinfo2 = userInfoDAO.findByName(inUser);
		if(userinfo2==null){
			System.out.println("�Բ���"+userinfo2+"�����ڣ�");
			return ;
		}
		System.out.println("����ǰ���Ϊ:"+this.userInfo.getAccount());
		double money = 0; 
		//ʹ��break��continue��ʵ��ѭ�����룬ֱ������������continue����������������ѭ����ĩβ
		while(true){
			System.out.println("������ת�����:");
			money = Double.parseDouble(scanner.nextLine());
			if(money>this.userInfo.getAccount()){
				System.out.println("�����㡣");
				continue;
			}
			break;
		}
		try {
			/*
			 * JDBCĬ�����Զ��ύ����ģ���:
			 * ÿ��ִ��һ��DML�����󣬾��Զ�ִ��COMMIT��
			 * ��ϣ��ִ�п���������Ҫ��ȡ���Զ��ύ����Ȼ���ڿ�������
			 * ����Ŀ�����Connection�����
			 */
			userInfo.setAccount(userInfo.getAccount()-money);
			userinfo2.setAccount(userinfo2.getAccount()+money);
			boolean f  = userInfoDAO.updateForTransfor(userInfo, userinfo2);
			
			if(f){
				System.out.println("ת�˳ɹ�");
			}else{
				System.out.println("ת��ʧ��");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}
	
	
//	1.ע�����û�
	private void reg(){
		
		Scanner scan = new Scanner(System.in);
		System.out.println("��ӭע��");
//		��ע�⣬����������û�����ͨ�����ú��������û�������֤���û�����һ��ע��
		System.out.println("�������û���");
		String username = getUserName();
		System.out.println("����������");
		String password = scan.next();
		System.out.println("����������");
		String email = scan.next();
		System.out.println("�������ǳ�");
		String nickname = scan.next();
		System.out.println("���������");
		int account = Integer.parseInt(scan.next());
		
		try {
        	UserInfo userinfo =
					new UserInfo(1,username,password,email,nickname,account);
			boolean tf  = userInfoDAO.save(userinfo);
			if(tf){
				System.out.println("ע��ɹ���");
				System.out.println("id:"+userinfo.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//��֤�û���Ψһ����������û�����Ψһ����һֱ���룬��֤ע��ʱ�û������ظ�
	private String getUserName(){
		
		try {
			Scanner scanner = new Scanner(System.in);
			while(true){
				
				String username = scanner.next();
				UserInfo userinfo = userInfoDAO.findByName(username);
				if(userinfo!=null){
					System.out.println("���û��Ѵ���");
				}else{
					return username;
				}	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	
	/* 2.�û���¼ 
	 * Ҫ���û������û���������
	 * �����û�������û����������ѯuserinfo��
	 * �����Բ�ѯ�����û���¼���򴴽�һ��UserInfoʵ��������
	 * ��ѯ���ĸ��û���Ϣ���õ����ʵ���ϣ�Ȼ�󽫸�ʵ������UserService������
	 * userInfo�ϱ�ʾ���¼�ɹ���
	 * */
	private void login(){
		Scanner scan = new Scanner(System.in);
		System.out.println("��ӭ��¼");
		System.out.println("�������û���");//�������Ҳ��nextLine()������ϰ��
		String username = scan.nextLine();
		System.out.println("����������");
//		String password = scan.next(); ��������Ϊaa' or '1'='1һֱ����ԭ��next()����Կո�
		String password = scan.nextLine(); 
		
		try {
			userInfo = userInfoDAO.findByName(username);
			if(userInfo!=null&&userInfo.getPassword().equals(password)){
				System.out.println("��ӭ�㣡");
			}else{
				System.out.println("��¼ʧ��");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
//	 3.�޸��û���Ϣ����Ҫ��¼��ſɲ���):�޸��û���Ϣֻ���޸ĵ�ǰ��¼�û������롢���䡢�ǳ�
	private void update(){
		if(userInfo==null){
			System.out.println("���ȵ�¼���ٸ���");
		}else{
			
			try {
				Scanner scan = new Scanner(System.in);
				System.out.println("��ӭ�����޸Ĳ���");
				System.out.println("�������޸ĺ������");
				String password = scan.next();
				System.out.println("�������޸ĺ������");
				String  email= scan.next();
				System.out.println("�������޸ĺ���ǳ�");
				String nickname = scan.next();
				userInfo.setPassword(password);
				userInfo.setEmail(email);
				userInfo.setNickname(nickname);
				boolean f = userInfoDAO.update(userInfo);
				if(f){
					System.out.println("�޸��û��ɹ�");
				}else{
					System.out.println("�޸��û�ʧ��");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		}
		
	}
	
//	4.�鿴�û���� 
	private void showAccout(){
		if(userInfo==null){
			System.out.println("���ȵ�¼���ٸ���");
			return;
		}
		try {
			userInfoDAO.showAccout(userInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	

//	5.��ʾ�����û���Ϣ,����ʾ�����û������û��������䡢�ǳƣ����	
	private void showAllUser(){

		try {
			List<UserInfo> list = userInfoDAO.findAll();
			for(UserInfo user:list){
				System.out.println(user.getUsername()+","
			    +user.getEmail()+","+user.getNickname()+","
				+user.getAccount());	
			}
			System.out.println("����ʾ�����û���Ϣ");
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
//	6.ע��(�ǳ���������Ҫ��¼��ſɲ�����
	private void logout(){
		
		if(userInfo!=null){
			userInfo = null;
			System.out.println("ע�����");
		}else{
			System.out.println("��¼��ſ���ע��");
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
