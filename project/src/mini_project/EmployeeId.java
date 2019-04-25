package mini_project;

public abstract class EmployeeId {
	private int location; // 본점1 , 지점2 
	private int empno;    //  사번
	  
	 
	public EmployeeId() {}
	 
	public EmployeeId(int location, int empno) {
		this.location = location;
		this.empno = empno;
	}
	
	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	
	//사원번호 Numbering
	public abstract int getNumbering(int loc);	
	
}
