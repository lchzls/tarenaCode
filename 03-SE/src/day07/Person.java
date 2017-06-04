package day07;

import java.io.Serializable;
import java.util.List;

/**
 * 该类用于测试作为对象进行对象流的读写操作
 * @author adminitartor
 *
 */
public class Person implements Serializable{
	/**
	 * 序列化版本号
	 * 当一个类实现了Sericalizable接口后，该类
	 * 会有一个常量表示这个类的版本号，版本号影响
	 * 这对象反序列化的结果。
	 * 建议自行维护版本号(自己定义该常量并给定值)，若
	 * 不指定，编译器会根据当前类的结构生成一个版本号，
	 * 结构不变版本号不变，但是结构变了(属性类型，名字
	 * 变化等)都会导致版本号改变。
	 * 
	 * 反序列化对象时，会检查该对象的版本号与当前类
	 * 现在的版本号是否一致，一致这可以还原，不一致则
	 * 反序列化失败。
	 * 版本号一致时，就算反序列化的对象与当前类的结构
	 * 有出入，也会采取兼容模式，即:仍然有的属性就进行
	 * 还原，没有的属性则被忽略。
	 * 
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int age;
	private String gender;
	/*
	 * transient关键字的作用是修饰一个属性
	 * 那么当这个类的某个实例进行序列化时，该属性
	 * 不会被包含在序列化后的字节中，从而达到了
	 * 对象“瘦身”的目的
	 */
	private transient List<String> otherInfo; 
	
	public Person(){
		
	}

	public Person(String name, int age, String gender, List<String> otherInfo) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.otherInfo = otherInfo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<String> getOtherInfo() {
		return otherInfo;
	}

	public void setOtherInfo(List<String> otherInfo) {
		this.otherInfo = otherInfo;
	}

	public String toString() {
		return name+","+age+","+
	           gender+","+otherInfo;
	}
}







