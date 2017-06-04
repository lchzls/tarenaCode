package dao;

import java.util.List;
import java.util.Map;

import entity.Dept;

public interface DeptDAO {

	/*
	 * 要求2：
方法名要与sqlId一致
参数类型要和parameterType一致
返回类型要与resultType一致
	 */
	public void save(Dept dept);
	public List<Dept> findAll();
	public Dept findById(int id);
	public Map<String,Object> findById2(int id);
	public void delete(int id);
	public void update(Dept dept);
}
