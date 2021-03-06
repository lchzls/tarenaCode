package entity;

import java.io.Serializable;

public class Course implements Serializable {

	private Integer courseId;
	private String name;
	private Integer days;
	
	//故意将getCourseId方法名改成getId
	
	//get方法所直接对应的属性是bean属性，当前方法会让我们以为此类中有id属性，则id就是bean属性
	//去掉get并将剩下的单词首字母小写，得到的单词就是bean属性
	public Integer getId() {
		return courseId;
	}
	//故意将setCourseId方法名改成setId
	public void setId(Integer courseId) {
		this.courseId = courseId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getDays() {
		return days;
	}
	public void setDays(Integer days) {
		this.days = days;
	}
	
	
	
}
