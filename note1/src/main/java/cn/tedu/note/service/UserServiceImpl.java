package cn.tedu.note.service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.tedu.note.dao.UserDao;
import cn.tedu.note.entity.User;
import cn.tedu.note.util.Utils;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	public User login(String name, String password) throws UserNameException, PasswordException {
        
		if(name==null||name.trim().isEmpty()){
			throw new UserNameException("名不为空");
		}
		String reg = "^\\w{3,10}$";
		if(!name.matches(reg)){
			throw new UserNameException("不合规");
		}
		if(password==null||password.trim().isEmpty()){
			throw new PasswordException("密码不为空");
		}
		if(!password.matches(reg)){
			throw new PasswordException("不合规");
		}
		//以上是检查参数的合理性
		
		User user = userDao.findUserByName(name);
		if(user==null){
			throw new UserNameException("用户不存在");
		}
		String md5 = Utils.crypt(password);
	//	System.out.println(md5);
	//	System.out.println(user);
		
			
		if(user.getPassword().equals(md5)){
			//业务处理，登录成功，返回业务信息
			String token = UUID.randomUUID().toString();
			user.setToken(token);
			Map<String,Object> data = 
					new HashMap<String,Object>();
			data.put("id", user.getId());
			data.put("token", token);
			userDao.updateUser(data);
			return user;
		}
		
		 throw new PasswordException("密码错误");
		
		
	}

	
	
	//@Transactional
	/*
	 * 默认情况下，不写是默认下面的这些属性。
	 * @Transactional(readOnly=false,rollbackFor=RuntimeException.class,
	 * propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
	 */
	public User regist(String name, String nick, String password, String confirm)
			throws UserNameException, PasswordException {
		
		//对参数进行判断是否满足条件
		if(name==null||name.trim().isEmpty()){
			throw new UserNameException("用户名不为空");
		}
		String reg = "^\\w{3,10}$";
		if(!name.matches(reg)){
			throw new UserNameException("用户名不合规");
		}
		if(nick==null||nick.trim().isEmpty()){
			throw new UserNameException("昵称不为空");
		}
		if(!nick.matches(reg)){
			throw new UserNameException("昵称不合规");
		}
		if(password==null||password.trim().isEmpty()){
			throw new PasswordException("密码不为空");
		}
		if(!password.matches(reg)){
			throw new PasswordException("密码不合规");
		}
		if(!password.equals(confirm)){
			throw new PasswordException("确认不一致");
		}
		name = name.trim();
		User one = userDao.findUserByName(name);
		if(one!=null){
			throw new UserNameException("用户名已注册");
		}
		String id = UUID.randomUUID().toString();
		String token = "";
		String pwd = Utils.crypt(password);
		User user = new User(id,name,pwd,token,nick);
		userDao.saveUser(user);
		//String s = null;
		//s.length();  //故意添加这两行代码，因此会报空指针异常，而加了事务管理，则这里一旦失败，就会执行撤销
		//操作，所以，再次测试，应该在数据库中是不会插入注册信息的。若将事务注解注释，则尽管出现空指针异常，数据库还是插入了注册信息。
		return user;
	}

	//写程序时要避免空指针异常，所以，参数都要进行判断，任何时候拿到任何一个变量，都要去判断它是否为空。否则，调用这个变量的方法时，
	//就很有可能报空指针异常。
	public boolean checkToken(String userId, String token) {
		if(userId==null||userId.trim().isEmpty()){
			return false;
		}
		if(token==null||token.trim().isEmpty()){
			return false;
		}
		User user = userDao.findUserById(userId);
		if(user==null){
			return false;
		}
		return token.equals(user.getToken());
	}

}
