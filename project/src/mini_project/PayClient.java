package mini_project;

import java.util.List;
import java.util.Scanner;


public class PayClient {

//	public static void main(String[] args) {

	//List<Department> obj
	
	public void pay_main(List<?> obj, List<?> obj2) {	
		PayServer ps = new PayServer();
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			try {
				System.out.println("[급여관리] 1.등록  2.조회  3.수정  4.삭제  5.월급여처리  9.저장  0.종료");
				int in = Integer.parseInt(scanner.nextLine());
				switch (in) {
				case 1:   //급여등록
					ps.pay_add();
					break;
				case 2:   //급여조회
					System.out.println("사번,년월기준 : 1.오름순  2.내림순");
				    int in1 = Integer.parseInt(scanner.nextLine());
					ps.pay_view(in1);
					break;
				case 3:   //급여수정
					ps.pay_update();
					break;
				case 4:   //급여삭제
					ps.pay_delete();
					break;
				case 5:   //급여
					ps.pay_process(obj,obj2);
					break;
				case 9:   //급여저장
					ps.write_date_file();
					ps.write_date_file1();
					break;
				case 0:  //종료
					System.out.println("[급여관리] 종료합니다.");
					return;
				default:
					break;
				}
			}
			catch (NumberFormatException e) {
				System.out.println("적합한 숫자를 입력하세요.!!!");
			}
			catch (ExceptionNegativeNumber | ExceptionYearMonthType |
				   ExceptionNumberType | ExceptionDigitsOfNumber |
				   ExceptionKorean e) {
				System.out.println(e.getMessage());
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		
		}
	}
}
