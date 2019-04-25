package mini_project;


public class ExceptionNumberType extends Exception {
	private static final long serialVersionUID = 3L;
	
	private String input;

	
	public ExceptionNumberType(String message, String input) {
		super(message);
		this.input = input;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return super.getMessage() + " 숫자값으로 입력하세요. [입력값 : " + input+"]";
	}
}
