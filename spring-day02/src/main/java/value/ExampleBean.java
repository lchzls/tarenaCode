package value;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class ExampleBean {

	private String name;
	private int age;
	private List<String> cities;
	private Set<String> interests;
	private Map<String,Double> score;
	private Properties db;
	
	
	
	
	
	public Properties getDb() {
		return db;
	}

	public void setDb(Properties db) {
		System.out.println("setDb");
		this.db = db;
	}

	public Map<String, Double> getScore() {
		return score;
	}

	public void setScore(Map<String, Double> score) {
		System.out.println("setScore()");
		this.score = score;
	}

	public ExampleBean() {
		System.out.println("ExampleBean()");
	}

	public Set<String> getInterests() {
		return interests;
	}
	
	public void setInterests(Set<String> interests) {
		System.out.println("setInterests()");
		this.interests = interests;
	}
	
	
	
	public List<String> getCities() {
		return cities;
	}
	
	public void setCities(List<String> cities) {
		System.out.println("setCities()");
		this.cities = cities;
	}



	

	@Override
	public String toString() {
		return "ExampleBean [name=" + name + ", age=" + age + ", cities=" + cities + ", interests=" + interests
				+ ", score=" + score + ", db=" + db + "]";
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		System.out.println("setName()");
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		System.out.println("setAge()");
		this.age = age;
	}

	
}
