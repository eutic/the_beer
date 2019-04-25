package mini_project;
/*
 *   공통 예외처리 Method class임
 *   
 *   
 * 
 */
public class ExceptionMethod {

	// 예외처리 -------------------------
		
		//음수값Check 예외 -- Exception
		public void validateNegativeNumber(String msg, int input) throws ExceptionNegativeNumber {
			if (input < 0) throw new ExceptionNegativeNumber(msg, input);
		}

		//문자숫자값Check 예외 -- Exception
		public void validateNumberType(String msg, String input) throws ExceptionNumberType {
			for(int i=0;i<input.length();i++) {
				char ch = input.charAt(i);
				if('0'>ch||ch>'9') throw new ExceptionNumberType(msg, input);  
			}
		}
		
		//자릿수 Check 예외, 매개변수 digits는 자릿수 값(ex, 4자리이면 4) -- RuntimeException
		public void validateDigitsOfNumber(String msg, int digits, String input) throws ExceptionDigitsOfNumber {
			if(input.trim().length() != digits) {
				msg += "[" + digits +"자리]";
				throw new ExceptionDigitsOfNumber(msg, input);
			}
		}
		
				
		//YearMonth Check 예외 -- RuntimeException
		public void validateYearMonth(String msg, String input) throws ExceptionYearMonthType {
			
			if (input.trim().length() < 6) throw new ExceptionYearMonthType(msg, input);
			
			int imonth = Integer.parseInt(input.substring(4, 6).trim());
			
			if (1>imonth||imonth>12) throw new ExceptionYearMonthType(msg, input);

		}

		//한글Check 예외 --  RuntimeException
		public void validateKorean(String msg) throws ExceptionKorean {
			for(int i=0;i<msg.length();i++) {
				char ch = msg.charAt(i);
				if ('가'>ch||ch>'힣') throw new ExceptionKorean(msg);
			}
		}

	
}
