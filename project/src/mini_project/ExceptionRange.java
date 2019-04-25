package mini_project;

public class ExceptionRange extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5L;

	private String input; 
	public ExceptionRange(String message, String deptName) {
		super(message);
		this.input = deptName;
		// TODO Auto-generated constructor stub
	}

//	public RangeException(String dept, String deptName) {
//		// TODO Auto-generated constructor stub
//		super(dept);
//		this.input = deptName;
//	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return super.getMessage() + "코드의 범위를 0부터 "
				+ "10000사이로 입력하세요. 현재값 : " + input;
	}
	
	

}
