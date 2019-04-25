package mini_project;

import java.util.Scanner;

public class JobposClient {
//	public static void main(String[] args) {
		
	JobposServer js = new JobposServer();
	
	public void jobpos_main() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("[직급코드관리] 1.등록\t2.조회\t3.수정\t4.삭제\t 9.저장\t 0.종료");
			try {
				int input = Integer.parseInt(scanner.nextLine());
				switch (input) {
				case 1:
					js.add();
					break;
				case 2:
					System.out.println("1. 직급 코드별 조회 \t 2. 직급 이름별 조회");
					int in = Integer.parseInt(scanner.nextLine());
					if (in == 1) {
						js.list(1);
					} else if (in == 2) {
						js.list(2);
					} else {
						break;
					}
					break;
				case 3:
					js.modify();
					break;
				case 4:
					js.delete();
					break;
				case 9:
					js.write_date_file_jobpos();
					break;
				case 0:
					System.out.println("직급 관리를 종료합니다.");
					return;
				default:
					break;
				}
			} catch (NumberFormatException e) {
				System.err.println("적합한 숫자를 입력하세요");
			} catch (ExceptionNumberType | ExceptionKorean e) {
				System.err.println(e.getMessage());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
