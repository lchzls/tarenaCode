package dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import entity.Emp;
import entity.Emp2;

/*
 * Mapperӳ����
 */


//����˸�ע��(@MyRepository)��ӳ�������ŻᱻMapperScannerConfigurerɨ��
public interface EmpDAO {
	public void save(Emp emp);
	public List<Emp> findAll();
	public Emp findById(int id);
	public void modify(Emp emp);
	public void delete(int id);
	public Map<String,Object> findById2(int id);
	public Emp2 findById3(int id);
	
}
