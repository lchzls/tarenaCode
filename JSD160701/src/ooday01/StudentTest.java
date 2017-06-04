package ooday01;

public class StudentTest {
	public static void main(String[] args) {
		

//创建学生对象
	Student zs = new Student();
	//给成员变量赋值
	zs.name ="zhangsan";
	zs.age = 25;
	zs.address = "河北廊坊";
	//调用方法
	zs.study();
	zs.sayHi();
	
}
}