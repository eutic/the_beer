package mini_project;

/*
 *  작성자 : 이충현 (ver 1.3)
 *  수정 2019.01.28 18:00
 */
import java.util.Scanner;

public class DeptClient {
	
	
//	public static void main(String[] args) {
		
	
	DeptServer ds = new DeptServer();

	public void dapt_main() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("[부서관리] 1. 등록 \t 2. 조회 \t 3. 수정 \t 4. 삭제 \t 9. 저장 \t 0. 종료");
			try {

				int input = Integer.parseInt(scanner.nextLine());
				switch (input) {
				case 1:
					ds.add();
					break;
				case 2:
					System.out.println("1. 코드순 조회 \t 2. 부서명순 조회 \t");
					int in = Integer.parseInt(scanner.nextLine());
					//1,2 아니면 skip if문 추가
					if (in == 1) {
						ds.list(1);
					} else if (in ==2){
						ds.list(2);
					} else {
						break;
					}
					break;
				case 3:
					ds.adjust();
					break;
				case 4:
					ds.delete();
					break;
				case 9:   //저장
					ds.write_data_file_depts();
					break;
				case 0:
					return;
				default:
					break;
				}
			} catch (NumberFormatException e) {
				System.err.println("적합한 숫자를 입력하세요");
			} catch (ExceptionNumberType | ExceptionKorean | ExceptionDigitsOfNumber e) {
				System.err.println(e.getMessage());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
//}