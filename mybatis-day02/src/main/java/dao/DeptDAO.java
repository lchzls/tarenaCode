package dao;

import java.util.List;
import java.util.Map;

import entity.Dept;

public interface DeptDAO {

	/*
	 * Ҫ��2��
������Ҫ��sqlIdһ��
��������Ҫ��parameterTypeһ��
��������Ҫ��resultTypeһ��
	 */
	public void save(Dept dept);
	public List<Dept> findAll();
	public Dept findById(int id);
	public Map<String,Object> findById2(int id);
	public void delete(int id);
	public void update(Dept dept);
}
