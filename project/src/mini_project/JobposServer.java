package mini_project;

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

public class JobposServer {

	ExceptionMethod em = new ExceptionMethod();

	List<JobPosition> jobposes = new ArrayList<>(); // 입력순
	Scanner scanner = new Scanner(System.in);
	// 기능수행

	JobposServer() {
		read_data_file_jobpos();
//		jobposes.add(new JobPosition("10", "대표이사"));
//		jobposes.add(new JobPosition("20", "전무"));
//		jobposes.add(new JobPosition("30", "상무"));
//		jobposes.add(new JobPosition("40", "이사"));
//		jobposes.add(new JobPosition("50", "부장"));
//		jobposes.add(new JobPosition("60", "차장"));
//		jobposes.add(new JobPosition("70", "과장"));
//		jobposes.add(new JobPosition("80", "대리"));
//		jobposes.add(new JobPosition("90", "사원"));

	}


	// 1.직급 조회 list
	void list(int sort_type) {

		order(sort_type);

		for (int i = 0; i < jobposes.size(); i++) {
			System.out.println(jobposes.get(i));
		}
	}

	// 2.직급 추가 add
	void add() throws NumberFormatException, ExceptionNumberType   {
		
		while (true) {
			System.out.print("직급 코드 >");
			String jobpos = scanner.nextLine();
			em.validateDigitsOfNumber("직급 코드", 2, jobpos);
			
			System.out.print("직급 이름 >");
			String jobposName = scanner.nextLine();
			em.validateKorean(jobposName);
			
			jobposes.add(new JobPosition(jobpos, jobposName));
			
			System.out.println("이전메뉴[0], 계속[아무키] : ");
			jobpos = scanner.nextLine();
			
			if (jobpos.equals("0"))
				break;
		}
	}
	
	private void order(int type) {
		// sort
		Collections.sort(jobposes, new Comparator<JobPosition>() {

			public int compare(JobPosition o1, JobPosition o2) {
				if (type == 1) {
					return (((JobPosition) o1).getJobpos()).compareTo(((JobPosition) o2).getJobpos());
				} else {
					return (((JobPosition) o1).getJobposName()).compareTo(((JobPosition) o2).getJobposName());
				}
			}

		});

	}

	// 3. 직급 수정 modify
	void modify() throws ExceptionNumberType {
		Scanner scanner = new Scanner(System.in);

		System.out.println();

		System.out.println("수정할 코드를 입력하세요.");
		String num = scanner.nextLine();

		System.out.println("1.직급코드 수정 2.직급이름 수정");
		int input = Integer.parseInt(scanner.nextLine());

		int num1 = 0;

		switch (input) {
		case 1: // 코드
			System.out.println("변경할 코드 번호를 입력하세요");
			String jobpos = scanner.nextLine();
			for (JobPosition jobPosition : jobposes) {
				if (jobPosition.getJobpos().equals(num)) {
					jobPosition.setJobpos(jobpos);
				}
			}
			em.validateDigitsOfNumber("직급 코드", 2, jobpos);
			break;

		case 2: // 직급 이름
			System.out.println("변경할 직급명을 입력하세요");
			String jobposName = scanner.nextLine();

			for (int i = 0; i < jobposes.size(); i++) {
				if (jobposes.get(i).getJobpos().equals(num)) {
					num1 = i;
				}
			}
			jobposes.get(num1).setJobposName(jobposName);
			em.validateKorean(jobposName);
			break;
		default:
			break;
		}
	}

	// 4.직급 삭제 delete
	void delete() {
		System.out.print("삭제할 부서의 코드를 입력하세요 >");
		String input = scanner.nextLine();
		for (int i = 0; i < jobposes.size(); i++) {
			if (input.equals(jobposes.get(i).getJobpos())) {
				System.out.println(i + " " + jobposes.get(i).getJobpos());
				jobposes.remove(i);
				break;
			}
		}
	}
		
		//파일로 저장된 자료를 읽어 Pay class의 필드로 binding함 
		public void read_data_file_jobpos() {
			
			String fpath="D:\\data\\";
			
			try {
				FileReader fr = new FileReader(fpath+"jobpos.dat");
				BufferedReader br = new BufferedReader(fr);
				
				String linebuf = "";
				while((linebuf=br.readLine())!=null) {
					
					String[] arrbuf = linebuf.split("\t");
					
					String Jobpos = arrbuf[0];
					String Jobposname = arrbuf[1];
					
					jobposes.add(new JobPosition(Jobpos,Jobposname));
					
				}
			    br.close();
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
		//Pay class의 필드 자료들을 파일로 저장함.
		public void write_date_file_jobpos() {
			
			String fpath="D:\\data\\";
			
			if (jobposes==null) {
				System.out.println("자료 Instance가 없습니다.");
				return;
			}
			
			try {
				
				FileWriter fw = new FileWriter(fpath+"jobpos.dat");
				BufferedWriter bw = new BufferedWriter(fw);
				
				Iterator<JobPosition> iter = jobposes.iterator();
				
				while(iter.hasNext()) {
					JobPosition jp = iter.next();
					
					String sb="";
					sb+=jp.getJobpos()+"\t";
					sb+=jp.getJobposName()+"\r\n";
				
					
					bw.write(sb);
				}			
				bw.close();
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}

