package mini_project;

import java.util.Scanner;

public class HumanResourceClient {
	public static void main(String[] args) {
		
	    HumanResourceServer hrs = new HumanResourceServer();
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			try {
				display_menu();
				int in = Integer.parseInt(scanner.nextLine());
				switch (in) {
				case 1:   //인사관리
					hrs.emp_management();
					break;
				case 2:   //급여관리
					hrs.pay_management();
					break;
				case 3:   //부서코드관리
					hrs.dept_management();
					break;
				case 4:   //직급코드관리
					hrs.jobpos_management();
					break;
				case 5:   //현황관리
					hrs.report_management();
					break;
				case 0:  //종료
					System.out.println("[Human Resource Management System]을 종료합니다. Thank you!!!");
					return;
				default:
					break;
				}				
				
			}
			catch (NumberFormatException e) {
				System.out.println("적합한 숫자를 입력하세요.!!!");
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void display_menu() {
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("\t\t\t+----------------------------------+");
		System.out.println("\t\t\t| Human Resource Management System |");
		System.out.println("\t\t\t+----------------------------------+");
		System.out.println("\t\t\t|                  [ Made by 3조 ] |");
		System.out.println("\t\t\t|                                  |");
		System.out.println("\t\t\t|         1.인사관리               |");   
		System.out.println("\t\t\t|                                  |");
		System.out.println("\t\t\t|         2.급여관리               |");
		System.out.println("\t\t\t|                                  |");
		System.out.println("\t\t\t|         3.부서코드관리           |");
		System.out.println("\t\t\t|                                  |");
		System.out.println("\t\t\t|         4.직급코드관리           |");
		System.out.println("\t\t\t|                                  |");
		System.out.println("\t\t\t|         5.현황관리               |");
		System.out.println("\t\t\t|                                  |");
		System.out.println("\t\t\t|         0.종료                   |");
		System.out.println("\t\t\t|                                  |");
		System.out.println("\t\t\t+----------------------------------+");
		System.out.println("\t\t\t| 선택 번호를 입력하세요.          |");
		System.out.println("\t\t\t+----------------------------------+");
		
	}
	
}
