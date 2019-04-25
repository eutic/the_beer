package mini_project;


public class Employee extends EmployeeId {

	
	public Employee() {
		super();
	}


	@Override
	public int getNumbering(int loc) {
		// TODO Auto-generated method stub
		return 0;
	}


	private String dept; // 부서코드
	private String name; // 성명
	private String regno; // 주민번호
	private String joppos; // 직급코드
	private String addr; // 집주소
	private String phone; // 핸드폰번호

	public Employee(int location, int empno, String dept, String name, String regno, String joppos, String addr, String phone) {
		super(location, empno);
		this.dept = dept;
		this.name = name;
		this.regno = regno;
		this.joppos = joppos;
		this.addr = addr;
		this.phone = phone;
	}


	
	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegno() {
		return regno;
	}

	public void setRegno(String regno) {
		this.regno = regno;
	}

	public String getJoppos() {
		return joppos;
	}

	public void setJoppos(String joppos) {
		this.joppos = joppos;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		
		
		return "[지점번호="+ getLocation() +","+ "사번=" + getEmpno() + ", " + "부서=" + this.dept + ", 성명=" + this.name + ", 주민번호=" + this.regno + ", 직급="
				+ this.joppos + ", 주소=" + this.addr + ", " + "연락처=" + this.phone + "]";
	}

}
