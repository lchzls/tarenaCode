package entity;

public class Emp2 {

	//属性名和字段名不一样
	private Integer empNo;
	private String name;
	private Integer age;
	public Integer getEmpNo() {
		return empNo;
	}
	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Emp2 [empNo=" + empNo + ", name=" + name + ", age=" + age + "]";
	}
	
	
}
