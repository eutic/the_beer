package mini_project;


public class ExceptionNegativeNumber extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	private int input;

	public ExceptionNegativeNumber(String message, int input) {
		super(message);
		// TODO Auto-generated constructor stub
		this.input = input;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return super.getMessage() + " 양수의 숫자값을 입력하세요. [입력값 : " + input+"]";
	}

}
