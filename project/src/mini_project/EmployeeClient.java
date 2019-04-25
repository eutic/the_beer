package mini_project;

import java.util.List;
import java.util.Scanner;
import java.io.IOException;


public class EmployeeClient {

	// public static void main(String[] args) {

	EmployeeServer em = new EmployeeServer();

	public void emp_main(List<?> obj, List<?> obj2) {

		Scanner scanner = new Scanner(System.in);

		while (true) {
			try {
				System.out.println("[인사관리] 1.등록  2.조회  3.수정  4.삭제  9.저장  0.종료");
				int input = scanner.nextInt();
				switch (input) {
				case 0: // 종료
					System.out.println("[인사관리] 종료합니다.");
					return;
				case 1: // 등록
					em.add(obj, obj2);
					break;
				case 2: // 조회
					em.list();
					break;
				case 3: // 수정
					em.edit();
					break;
				case 4:
					em.delete();
					break;
				case 9: // 저장
					em.write_date_file_emp();
				default:
					break;
				}
//			} catch (NumberFormatException e) {
//				System.out.println("적합한 숫자를 입력하세요.");
			} catch (NullPointerException e) {
				System.out.println("데이터가 없습니다.");
			} catch ( ExceptionNumberType | ExceptionDigitsOfNumber | ExceptionKorean e) {
				System.out.println(e.getMessage());
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
}
