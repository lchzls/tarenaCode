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
			throw new UserNameException("����Ϊ��");
		}
		String reg = "^\\w{3,10}$";
		if(!name.matches(reg)){
			throw new UserNameException("���Ϲ�");
		}
		if(password==null||password.trim().isEmpty()){
			throw new PasswordException("���벻Ϊ��");
		}
		if(!password.matches(reg)){
			throw new PasswordException("���Ϲ�");
		}
		//�����Ǽ������ĺ�����
		
		User user = userDao.findUserByName(name);
		if(user==null){
			throw new UserNameException("�û�������");
		}
		String md5 = Utils.crypt(password);
	//	System.out.println(md5);
	//	System.out.println(user);
		
			
		if(user.getPassword().equals(md5)){
			//ҵ������¼�ɹ�������ҵ����Ϣ
			String token = UUID.randomUUID().toString();
			user.setToken(token);
			Map<String,Object> data = 
					new HashMap<String,Object>();
			data.put("id", user.getId());
			data.put("token", token);
			userDao.updateUser(data);
			return user;
		}
		
		 throw new PasswordException("�������");
		
		
	}

	
	
	//@Transactional
	/*
	 * Ĭ������£���д��Ĭ���������Щ���ԡ�
	 * @Transactional(readOnly=false,rollbackFor=RuntimeException.class,
	 * propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
	 */
	public User regist(String name, String nick, String password, String confirm)
			throws UserNameException, PasswordException {
		
		//�Բ��������ж��Ƿ���������
		if(name==null||name.trim().isEmpty()){
			throw new UserNameException("�û�����Ϊ��");
		}
		String reg = "^\\w{3,10}$";
		if(!name.matches(reg)){
			throw new UserNameException("�û������Ϲ�");
		}
		if(nick==null||nick.trim().isEmpty()){
			throw new UserNameException("�ǳƲ�Ϊ��");
		}
		if(!nick.matches(reg)){
			throw new UserNameException("�ǳƲ��Ϲ�");
		}
		if(password==null||password.trim().isEmpty()){
			throw new PasswordException("���벻Ϊ��");
		}
		if(!password.matches(reg)){
			throw new PasswordException("���벻�Ϲ�");
		}
		if(!password.equals(confirm)){
			throw new PasswordException("ȷ�ϲ�һ��");
		}
		name = name.trim();
		User one = userDao.findUserByName(name);
		if(one!=null){
			throw new UserNameException("�û�����ע��");
		}
		String id = UUID.randomUUID().toString();
		String token = "";
		String pwd = Utils.crypt(password);
		User user = new User(id,name,pwd,token,nick);
		userDao.saveUser(user);
		//String s = null;
		//s.length();  //������������д��룬��˻ᱨ��ָ���쳣���������������������һ��ʧ�ܣ��ͻ�ִ�г���
		//���������ԣ��ٴβ��ԣ�Ӧ�������ݿ����ǲ������ע����Ϣ�ġ���������ע��ע�ͣ��򾡹ܳ��ֿ�ָ���쳣�����ݿ⻹�ǲ�����ע����Ϣ��
		return user;
	}

	//д����ʱҪ�����ָ���쳣�����ԣ�������Ҫ�����жϣ��κ�ʱ���õ��κ�һ����������Ҫȥ�ж����Ƿ�Ϊ�ա����򣬵�����������ķ���ʱ��
	//�ͺ��п��ܱ���ָ���쳣��
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
