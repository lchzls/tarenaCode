package entity;

public class Dept {

	private Integer id;
	private String deptName;
	private String loc;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	@Override
	public String toString() {
		return "Dept [id=" + id + ", deptName=" + deptName + ", loc=" + loc + "]";
	}
	
	
}
