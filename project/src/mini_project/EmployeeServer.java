package mini_project;


import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class EmployeeServer {

	ExceptionMethod ex = new ExceptionMethod(); // 예외처리
	List<Employee> employees = new ArrayList<>();
	CommonMethod cm = new CommonMethod(); // 코드
	
	Scanner scanner = new Scanner(System.in);

	public EmployeeServer() { // 기본생성자

		// 저장된 파일을 읽어서 Class 필드에 binding함
		read_data_file_emp();

//		employees.add(new Employee(1, 1021, "050", "티비사운드", "950323", "10", "서울시", "01085738363"));
//		employees.add(new Employee(1, 1001, "050", "사운드바", "950323", "10", "서울시", "01085738363"));
//		employees.add(new Employee(1, 1002, "100", "너구리", "950323", "20", "서울시", "01085738363"));
//		employees.add(new Employee(1, 1003, "200", "사자", "950323", "30", "서울시", "01012345611"));
//		employees.add(new Employee(1, 1004, "300", "도깨비", "950323", "40", "서울시", "01078676546"));
//		employees.add(new Employee(1, 1005, "400", "고양이", "950323", "50", "서울시", "01068456487"));
//		employees.add(new Employee(1, 1006, "500", "호랑이", "950323", "60", "서울시", "01068456487"));
//		employees.add(new Employee(1, 1007, "600", "돼지", "950323", "70", "서울시", "01068456487"));
//		employees.add(new Employee(1, 1008, "700", "병아리", "950323", "80", "서울시", "01068456487"));
//		employees.add(new Employee(1, 1009, "800", "얼룩말", "950323", "90", "서울시", "01068456487"));
//		employees.add(new Employee(1, 1010, "900", "토끼", "950323", "30", "서울시", "01068456487"));
//		employees.add(new Employee(1, 1011, "050", "용", "950323", "40", "서울시", "01068456487"));
//		employees.add(new Employee(1, 1012, "100", "원숭이", "950323", "50", "서울시", "01068456487"));
//		employees.add(new Employee(1, 1013, "200", "닭", "950323", "60", "서울시", "01068456487"));
//		employees.add(new Employee(1, 1014, "300", "다람쥐", "950323", "70", "서울시", "01068456487"));
//		employees.add(new Employee(1, 1015, "400", "거울", "950323", "80", "서울시", "01068456487"));
//		employees.add(new Employee(1, 1016, "500", "공기청정기", "950323", "90", "서울시", "01085738363"));
//		employees.add(new Employee(1, 1017, "600", "티비이", "950323", "90", "서울시", "01068456487"));
//		employees.add(new Employee(1, 1018, "600", "책상", "950323", "90", "서울시", "01068456487"));
//		employees.add(new Employee(1, 1019, "600", "수분팩", "950323", "90", "서울시", "01068456487"));
//		employees.add(new Employee(1, 1020, "600", "풋크림", "950323", "90", "서울시", "01068456487"));

	}

	public void add(List<?> obj, List<?> obj2) throws ExceptionNumberType { // 등록
		List<?> list  = (List)obj;   //부서
		List<?> list2 = (List)obj2;	//직급
		
		while (true) {

			System.out.println("1.본점  2.지점  [0]이전메뉴");

			int location = parseInt(scanner.nextLine());

			if (location == 0) {
				break;
			}			

		    cm.dept_list(list, true);
		    System.out.println();
		    System.out.print("부서코드 >");
			String dept = scanner.nextLine();
			ex.validateNumberType("부서코드", dept);
			ex.validateDigitsOfNumber("부서코드", 3, dept);
		

			System.out.print("성명 >");
			String name = scanner.nextLine();
			ex.validateKorean(name);

			System.out.print("주민번호. >");
			String regno = scanner.nextLine();
			ex.validateNumberType("주민번호", regno);
			ex.validateDigitsOfNumber("주민번호", 13, regno);
		
			
			cm.jobpos_list(list2, true);
			System.out.println();
		 	System.out.print("직급코드 >");
			String joppos = scanner.nextLine();
			ex.validateNumberType("직급코드", joppos);
			ex.validateDigitsOfNumber("직급코드", 2, joppos);
			
			
			System.out.print("주소 >");
			String addr = scanner.nextLine();
			ex.validateKorean(addr);

			System.out.print("연락처 >");
			String phone = scanner.nextLine();
			ex.validateNumberType("연락처", phone);
	
			
			Employee emplo = new Employee();

			emplo.setLocation(location);
			emplo.setEmpno(cm.getNewEmpno(employees,location));
			emplo.setDept(dept);
			emplo.setName(name);
			emplo.setRegno(regno);
			emplo.setJoppos(joppos);
			emplo.setAddr(addr);
			emplo.setPhone(phone);

			employees.add(emplo);
		}

	} // while

	// 기본 조회(사번순)
	public void list() {
		System.out.println("1.지점번호순  2.사번순  [0]이전메뉴");
		int type = scanner.nextInt();

		if (type == 0) {
			return;
		}

		Collections.sort(employees, new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				// TODO Auto-generated method stub

				int sortLocation = o1.getLocation() - o2.getLocation();
				int sortEmpno = o1.getEmpno() - o2.getEmpno();

				if (type == 1) {
					return sortLocation;
				} else {
					return sortEmpno;
				}
			}
		});

		for (int i = 0; i < employees.size(); i++) {
			System.out.println(employees.get(i));
		}
	}

	public void edit() throws ExceptionNumberType { // 수정
		int num1 = 0;
		System.out.println("수정할 직원의 사번을 입력하세요. [0]이전메뉴");
		int num = scanner.nextInt();

		if (num == 0) {
			return;
		}
		boolean run = false;
		for (int i = 0; i < employees.size(); i++) {
			if (employees.get(i).getEmpno() == num) {
				System.out.println(employees.get(i));
				num1 = i;
				run = true;
				break;
			}
		}
		if (!run) {
			System.out.println("사번이 없습니다.");
			return;
		}

		System.out.println("수정항목을 선택해주세요. [0]이전메뉴");
		System.out.println("1.사번 2.부서 및 직급 3.성명 4.주민번호 6.주소 7.연락처");
		int input = scanner.nextInt();

		input = scanner.nextInt();

		if (input == 0) {
			return;
		}

		switch (input) {
		case 1:
			System.out.println("새로운 사번을 입력하세요.>");
			String inkey = scanner.nextLine();
			
			ex.validateNumberType("사번", inkey);
			ex.validateDigitsOfNumber("사번", 3, inkey);
			int empno = Integer.parseInt(inkey);
			employees.get(num1).setEmpno(empno);
			break;

		case 2:
			System.out.println("1.부서이동 2.직급변경 [0]이전메뉴");
			int input1 = scanner.nextInt();
			switch (input1) {

			case 0:
				if (input1 == 0) {
					return;
				}

			case 1:
				System.out.println("부서를 입력하세요.>");
				String dept = scanner.nextLine();
				ex.validateNumberType("부서", dept);
				ex.validateDigitsOfNumber("부서", 3, dept);
				employees.get(num1).setDept(dept);
				
				break;

			case 2:
				System.out.println("직급을 입력하세요.>");
				String joppos = scanner.nextLine();
				ex.validateNumberType("직급", joppos);
				ex.validateDigitsOfNumber("직급", 2, joppos);
				employees.get(num1).setJoppos(joppos);
				break;

			}
		case 3:
			System.out.println("새로운 이름을 입력하세요.>");
			String name = scanner.nextLine();			
			employees.get(num1).setName(name);
			break;
		case 4:
			System.out.println("새로운 주민번호를 입력하세요.>");
			String regno = scanner.nextLine();
			ex.validateNumberType("주민번호", regno);
			ex.validateDigitsOfNumber("주민번호", 13, regno);
			employees.get(num1).setRegno(regno);
			break;
		case 5:
			System.out.println("새로운 주소를 입력하세요.>");
			String addr = scanner.nextLine();
			employees.get(num1).setAddr(addr);
			break;
		case 6:
			System.out.println("새로운 연락처를 입력하세요.>");
			String phone = scanner.nextLine();
			ex.validateNumberType("연락처", phone);
			ex.validateDigitsOfNumber("연락처", 13, phone);
			employees.get(num1).setPhone(phone);
			break;

		}
	}

	public void delete() { // 삭제

		System.out.print("삭제할 직원의 사번을 입력하세요. [0]이전메뉴");
		int input = parseInt(scanner.nextLine());
		if (input == 0) {
			return;
		}

		for (int i = 0; i < employees.size(); i++) {
			if (input == employees.get(i).getEmpno()) {
				employees.remove(i);
				break;
			}
		}
	}

	// 파일로 저장된 자료를 읽어 emp class의 필드로 binding함
	public void read_data_file_emp() {

		String fpath = "D:\\data\\";

		try {
			FileReader fr = new FileReader(fpath + "emp.dat");
			BufferedReader br = new BufferedReader(fr);

			String linebuf = "";
			while ((linebuf = br.readLine()) != null) {

				String[] arrbuf = linebuf.split("\t");

				int Location = Integer.parseInt(arrbuf[0]);
				int Empno = Integer.parseInt(arrbuf[1]);
				String dept = arrbuf[2];
				String name = arrbuf[3];
				String regno = arrbuf[4];
				String joppos = arrbuf[5];
				String addr = arrbuf[6];
				String phone = arrbuf[7];

				employees.add(new Employee(Location, Empno, dept, name, regno, joppos, addr, phone));

			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Employee class의 필드 자료들을 파일로 저장함.
	public void write_date_file_emp() {

		String fpath = "D:\\data\\";

		if (employees == null) {
			System.out.println("자료 Instance가 없습니다.");
			return;
		}

		try {

			FileWriter fw = new FileWriter(fpath + "emp.dat");
			BufferedWriter bw = new BufferedWriter(fw);

			Iterator<Employee> iter = employees.iterator();

			while (iter.hasNext()) {
				EmployeeId ep = iter.next();

				String sb = "";
				sb += ((Employee) ep).getLocation() + "\t";
				sb += ((Employee) ep).getEmpno() + "\t";
				sb += ((Employee) ep).getDept() + "\t";
				sb += ((Employee) ep).getName() + "\t";
				sb += ((Employee) ep).getRegno() + "\t";
				sb += ((Employee) ep).getJoppos() + "\t";
				sb += ((Employee) ep).getAddr() + "\t";
				sb += ((Employee) ep).getPhone() + "\r\n";

				bw.write(sb);
			}
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
