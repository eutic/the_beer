package mini_project;
/*
 *   
 * 
 */

public class ExceptionDigitsOfNumber extends RuntimeException {
	private static final long serialVersionUID = 6L;
	
	private String input;

	
	public ExceptionDigitsOfNumber(String message, String input) {
		super(message);
		this.input = input;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return super.getMessage() + " 자릿수 확인하세요. [입력값 : " + input+"]";
	}
}
