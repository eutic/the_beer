package mini_project;

/*
 *  작성자 : 이충현 (ver 1.3)
 *  수정 2019.01.28 20:00
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import static java.lang.Integer.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DeptServer {

	ExceptionMethod em = new ExceptionMethod();
	
	List<Department> depts = new ArrayList<>(); // 입력순
	Scanner scanner = new Scanner(System.in);
	// 기능수행
	
	public DeptServer() {
		//저장된 파일을 읽어서 Class 필드에 binding함
		read_data_file_depts();
//		write_date_file_depts();
//		read_data_file1(); 
	}
//	DeptServer() {
//	
//
//	}

//	public void print() {
//		Department[] departments = new Department[10];
//	}
	// 1.부서 추가 add
	void add() throws ExceptionNumberType, ExceptionNumberType {
		
		
		while (true) {
			System.out.println("부서 코드 >");
			String dept = scanner.nextLine();
			em.validateDigitsOfNumber("부서코드", 3, dept);
			em.validateNumberType(dept, dept);
			
			System.out.println("부서 이름>");
			String deptName = scanner.nextLine();
			
			
			depts.add(new Department(dept, deptName));
			
			System.out.println("이전메뉴[0],계속[아무키]: ");
			dept = scanner.nextLine();
			
			if (dept.equals("0")) break;
		}
	}
	// 2.부서 조회
		void list(int sort_type) {
			
			order(sort_type);
			
			
			for (int i = 0; i < depts.size(); i++) {
				System.out.println(depts.get(i));
			}
		}
		private void order(int type) {
			// sort
			Collections.sort(depts, new Comparator<Department>() {

				public int compare(Department o1, Department o2) {
					if (type == 1) {
						return (((Department) o1).getDept()).compareTo(((Department) o2).getDept());
					} else {
						return (((Department) o1).getDeptName()).compareTo(((Department) o2).getDeptName());
					}
				}

			});
		}
	//3. 수정
	void adjust() throws ExceptionNumberType {
		Scanner scanner = new Scanner(System.in);

		System.out.println();

		System.out.println("수정할 부서 코드를 입력하세요.");
		String num = scanner.nextLine();

		System.out.println("1.부서코드 수정 2.부서명 수정");
		int input = Integer.parseInt(scanner.nextLine());

		int num1 = 0;

		switch (input) {
		case 1: // 코드
			System.out.println("변경할 코드 번호를 입력하세요");
			String dept = scanner.nextLine();
			for (Department department : depts) {
				if (department.getDept().equals(num)) {
					department.setDept(dept);
				}
			}
			em.validateNumberType("변경 직급 코드", dept);
			em.validateDigitsOfNumber("직급 코드", 3, dept);
			break;

		case 2: // 부서명
			System.out.println("변경할 부서명을 입력하세요");
			String deptName = scanner.nextLine();

			for (int i = 0; i < depts.size(); i++) {
				if (depts.get(i).getDept().equals(num)) {
					num1 = i;
				}
			}
			depts.get(num1).setDeptName(deptName);
			em.validateKorean(deptName);
			break;
		default:
			break;
		}
	}
	// 4.부서 삭제
	void delete() {
		System.out.println("삭제할 부서의 코드를 입력하세요 >");
		String input = scanner.nextLine();
		for (int i = 0; i < depts.size(); i++) {
			if (input.equals(depts.get(i).getDept())) {
				System.out.println(i+" "+depts.get(i).getDept());
				depts.remove(i);
				break;
			}
		}
	}
	
	//*******
	public void read_data_file_depts() {
		
		String fpath="D:\\data\\";
		
		try {
			FileReader fr = new FileReader(fpath+"depts.dat");
			BufferedReader br = new BufferedReader(fr);
			
			String linebuf = "";
			while((linebuf=br.readLine())!=null) {
				
				String[] arrbuf = linebuf.split("\t");
				
				String dept = arrbuf[0];
				String deptName = arrbuf[1];
				
				depts.add(new Department(dept, deptName));
				
			}
		    br.close();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}	
	//Pay class의 필드 자료들을 파일로 저장함.
	public void write_data_file_depts() {
		
		String fpath="D:\\data\\";
		
		if (depts==null) {
			System.out.println("자료 Instance가 없습니다.");
			return;
		}
		
		try {
			
			FileWriter fw = new FileWriter(fpath+"depts.dat");
			BufferedWriter bw = new BufferedWriter(fw);
			
			Iterator<Department> iter = depts.iterator();
			
			while(iter.hasNext()) {
				Department dept = iter.next();
				
				String sb="";
				sb+=((Department)dept).getDept()+"\t";
				sb+=((Department)dept).getDeptName()+"\r\n";
				
				
				bw.write(sb);
			}			
			bw.close();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void write_date_file_depts() {
		// TODO Auto-generated method stub
		depts.add(new Department("050", "경영기획실"));
		depts.add(new Department("100", "관리실"));
		depts.add(new Department("200", "총무팀"));
		depts.add(new Department("300", "구매팀"));
		depts.add(new Department("400", "회계팀"));
		depts.add(new Department("500", "자금팀"));
		depts.add(new Department("600", "생산팀"));
		depts.add(new Department("700", "QC/QA팀"));
		depts.add(new Department("800", "연구소"));
		depts.add(new Department("900", "원가팀"));
	}
	
}
