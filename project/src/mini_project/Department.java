package mini_project;

/*
 *  작성자 : 이충현 (ver 1.0)
 */

public class Department {
	
	private String dept; // 부서코드
	
	private String deptName; // 부서명
	
	public Department() {
		
	}
	
	public Department(String dept, String deptName) {
		super();
		this.dept = dept;
		this.deptName = deptName;
	}

	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Override
	public String toString() {
		return "Department [dept=" + dept + ", deptName=" + deptName + "]";
	}

	public void add(String dept2) {
		// TODO Auto-generated method stub
		
	}
	
}
	

