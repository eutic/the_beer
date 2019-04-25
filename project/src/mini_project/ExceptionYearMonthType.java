package mini_project;


public class ExceptionYearMonthType extends RuntimeException {
	private static final long serialVersionUID = 4L;
	
	private String input;


	public ExceptionYearMonthType(String message, String input) {
		super(message);
		this.input = input;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return super.getMessage() + " 년월을 바르게 입력하세요. [입력값 : " + input+"]";
	}
}
