package entity;

import java.io.Serializable;

public class Course implements Serializable {

	private Integer courseId;
	private String name;
	private Integer days;
	
	//���⽫getCourseId�������ĳ�getId
	
	//get������ֱ�Ӷ�Ӧ��������bean���ԣ���ǰ��������������Ϊ��������id���ԣ���id����bean����
	//ȥ��get����ʣ�µĵ�������ĸСд���õ��ĵ��ʾ���bean����
	public Integer getId() {
		return courseId;
	}
	//���⽫setCourseId�������ĳ�setId
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
