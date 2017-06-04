package cn.tedu.note.dao;


import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.tedu.note.entity.User;


public interface UserDao {
	void saveUser(User user);
	User findUserById(String id);
	User findUserByName(String name);
	public int updateUser(Map<String, Object> user);
}
