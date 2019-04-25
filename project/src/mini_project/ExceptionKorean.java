package mini_project;
/*
 * 
 * 
 */

public class ExceptionKorean extends RuntimeException {
	private static final long serialversionUID = 2L;
	
	private String input;

		public ExceptionKorean(String message) {
			super(message);
		}

		@Override
		public String getMessage() {
			// TODO Auto-generated method stub
			return "한글값으로 입력하세요. [입력값 : "+super.getMessage() + "]";
		}
	
}
