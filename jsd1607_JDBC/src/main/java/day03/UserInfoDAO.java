package day03;

import java.util.List;

import day01.UserInfo;

/*
 * DAO数据连接对象：
DAO泛指一个层次的类
DAO层是在业务逻辑层与数据库之间的层次
作用是让业务逻辑对数据库的操作完全面向对象化，并且对数据库的具体操作透明。
使得业务逻辑层的类只需要关注业务操作即可。
 */

public interface UserInfoDAO {

	/**
	 * 将给定的UserInfo实例表示的用户记录进行保存
	 */
	public boolean save(UserInfo userinfo);
	
	//根据用户名查询用户信息
	public UserInfo findByName(String username);
	
	/*
	 * 查询所有用户信息
	 * 
	 */
	public List<UserInfo> findAll();
	
	/*
	 * 分页查看用户信息
	 * pageSize每页显示的条目数
	 * page显示的页数
	 * 
	 */
	public List<UserInfo> findAllByPage(int pagesize,int page);
	
	/*
	 * 修改给定的用户信息
	 */
	public boolean update(UserInfo userinfo);
	
	/*
	 * 转账业务需要的修改用户操作
	 * 在一个业务中完毕，两个用户信息都修改成功则表示成功，否则修改失败
	 * 
	 */
	public boolean updateForTransfor(UserInfo u1,UserInfo u2);
	
	public boolean deleteById(int id);
	
	public void showAccout(UserInfo userinfo);
}
