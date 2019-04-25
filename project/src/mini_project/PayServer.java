package mini_project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/*
 *   작성자 : 박승호 (ver 1.2)
 * 
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class PayServer {
	
	ExceptionMethod em = new ExceptionMethod();
	CommonMethod cm = new CommonMethod();
	
	List<EmployeeId> emppay = new ArrayList<EmployeeId>();
	List<PayAllowance> payallow = new ArrayList<PayAllowance>();
	
	Scanner scanner = new Scanner(System.in);

	DeptServer ds = new DeptServer();
	
	public PayServer() {
		//저장된 파일을 읽어서 Class 필드에 binding함
		read_data_file();  
		read_data_file1(); 
	}

	
	 //급여처리
	public void pay_process(List<?> obj, List<?> obj2) throws ExceptionNumberType {
//		System.out.println("pay_process");
		
		List<?> list  = (List)obj;   //? Object
		List<?> list2 = (List)obj2;
		
		if (list.size() <= 0 ) {
			System.out.println("등록된 사원자료가 없습니다. 확인하세요.!!!");
			return;
		}


		
		if (obj instanceof List) {
			if (list.get(0) instanceof Employee) {
			} else {
				System.out.println("Employee Type과 처리할 Instance가 맞지 않습니다. 확인하세요.!!!");
				return;
			}
		}

		
		System.out.println("급여처리 할 년월(yyyymm) : ");
		String yearmonth = scanner.nextLine();
		em.validateNumberType("년월", yearmonth);
		em.validateYearMonth("",yearmonth);
	
		System.out.println("인센티브[%]를 적용할까요?[y]");
		String yn = scanner.nextLine();
		int incent=100;
		if (yn.equals("y")||yn.equals("Y")) {
			System.out.println("인센티브[%] : ");
			incent = scanner.nextInt();
		}
		
		if (pay_ym_exists(yearmonth))  pay_ym_exists_del(yearmonth);
		
		Iterator<Employee> iter = (Iterator<Employee>)list.iterator();
		
		while(iter.hasNext()) {
			Employee ep = iter.next();
			
			int loc = ep.getLocation();
			int empno = ep.getEmpno();
			
			int baseamt=0;
			int jobposamt=0;
			
			for(PayAllowance pa : payallow) {
				if (ep.getJoppos().equals(pa.getJobpos())) {
					
					//System.out.println(ep.getJoppos() +"  "+ pa.getJobpos());
					
					baseamt = pa.getBaseamt();
					jobposamt = pa.getJobposamt();
				}
			}
				
			int amt = (baseamt + jobposamt)* incent/100;
			int deduct = (int)(amt * 0.1f);
			
			emppay.add(new Pay(loc,empno,yearmonth,amt,deduct,amt-deduct));
			
		}		
			
	}
	
	//해당 급여를 처리할 년월에 이미 처리한 자료가 있는지 Confirm
	public boolean pay_ym_exists(String ym) {
		boolean rtv = false;
		
		for(int i=0; i<emppay.size(); i++) {
			if(ym.equals(((Pay)emppay.get(i)).getYearmonth())) {
				rtv = true;
				break;
			}
		}
		
		return rtv;
	}
	
	//해당 급여를 처리할 년월에 이미 처리한 자료를 제거
	public void pay_ym_exists_del(String ym) {
		
		for(int i=0; i<emppay.size(); i++) {
			if(ym.equals(((Pay)emppay.get(i)).getYearmonth())) {
				emppay.remove(i);
			}
		}		
		
	}
	
	
    //급여등록
	public void pay_add() throws ExceptionNegativeNumber, ExceptionNumberType {
		while (true) {
			System.out.println("사번 : ");
			String inKey = scanner.nextLine();
			em.validateDigitsOfNumber("사번",4,inKey);
			int empno = Integer.parseInt(inKey);
			
			System.out.println("본점 1, 지점 2 : ");
			inKey = scanner.nextLine();
			int loc = Integer.parseInt(inKey);
			
			for(int i=1;i<=12;i++) {  //1~12월
				System.out.println("년월(yyyymm) : ");
				String yearmonth = scanner.nextLine();
				em.validateNumberType("년월", yearmonth);
				em.validateYearMonth("",yearmonth);
				
				System.out.println("급여금액 : ");
				inKey = scanner.nextLine();
				int amt = Integer.parseInt(inKey);
				em.validateNegativeNumber("급여금액",amt);
				
				System.out.println("공제금액 : ");
				inKey = scanner.nextLine();
				int deduct = Integer.parseInt(inKey);
				em.validateNegativeNumber("공제금액",deduct);
				
				emppay.add(new Pay(loc,empno,yearmonth,amt,deduct,amt-deduct));
				
				System.out.println("이전단계[0], 다음월 등록계속[아무키]: ");
				inKey = scanner.nextLine();
				
				if (inKey.equals("0")) break;
			}
			
			System.out.println("이전메뉴[0],계속[아무키]: ");
			inKey = scanner.nextLine();
			
			if (inKey.equals("0")) break;
			
		}
		
	}
	
	//급여조회
	public void pay_view(int sort_type) {
		
		//-------------Sorting--------------------------------------
		Collections.sort(emppay, new Comparator<EmployeeId>() {

			@Override
			public int compare(EmployeeId o1, EmployeeId o2) {
				// TODO Auto-generated method stub
				String tstr1, tstr2;
				
				tstr1 = getSortValue(((Pay)o1).getEmpno()) + ((Pay)o1).getYearmonth();
				tstr2 = getSortValue(((Pay)o2).getEmpno()) + ((Pay)o2).getYearmonth();
				
				if (sort_type == 1) {  //오름차순
					return tstr1.compareTo(tstr2);
				} else { //내림차순
					return tstr2.compareTo(tstr1);
				}
				
			}
		});
		//---------------------------------------------------------		
			
		for(EmployeeId rec : emppay) {
			System.out.println(rec);
		}
		
	}	

	public String getSortValue(int str) {

		return String.valueOf(str);
	}
	
	
	public void pay_update() throws ExceptionNegativeNumber, ExceptionNumberType {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println();
		while (true) {
			
			System.out.println("수정할 사번과 년월을 입력하세요. 이전메뉴[0]: ");
			System.out.println("사번 : ");
			int uempno = Integer.parseInt(scanner.nextLine());
			if (uempno == 0) break;
			
			System.out.println("년월 : ");
			String uym = scanner.nextLine();
			if (uym.equals("0")) break;
			
			Iterator<EmployeeId> iter = emppay.iterator();
			
			while(iter.hasNext()) {
				EmployeeId ep = iter.next();
				
				if(ep.getEmpno() == uempno && uym.equals(((Pay)ep).getYearmonth())) {
					int camt = ((Pay)ep).getAmount();
					int cddt = ((Pay)ep).getDeduct();
					
					System.out.println("1.년월  2.급여액  3.공제액");
					System.out.println("수정 항목을 선택해 주세요: ");
					int uno = Integer.parseInt(scanner.nextLine());
					
					switch(uno) {
					case 1: //년월
						System.out.println("변경 년월 : ");
						String cym = scanner.nextLine();
						em.validateNumberType("변경 년월", cym);
						((Pay)ep).setYearmonth(cym);
						break;
					case 2: //급여액
						System.out.println("변경 급여액 : ");
						camt = Integer.parseInt(scanner.nextLine());
						((Pay)ep).setAmount(camt);
						break;
					case 3: //공제액
						System.out.println("변경 공제액 : ");
						cddt = Integer.parseInt(scanner.nextLine());
						((Pay)ep).setDeduct(cddt);
						break;
					default:
						break;
					}
					//지급액은 자동연산
					((Pay)ep).setMoney(camt-cddt);
					break;
				}
				
			}
			
			System.out.println("이전메뉴[0],계속[아무키]: ");
			String inKey = scanner.nextLine();
			if (inKey.equals("0")) break;
	
		}			
			
	}
		
	public void pay_delete() {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println();
		while (true) {
			
			System.out.println("삭제사번 또는 이전메뉴[0]: ");
			int dempno = Integer.parseInt(scanner.nextLine());
			if (dempno == 0) break;
			
			for(int i=0;i<emppay.size();i++) {
				System.out.println(i+"  "+emppay.get(i).getEmpno());
				if(emppay.get(i).getEmpno()==dempno) {
					System.out.println(i+"  "+emppay.get(i).getEmpno()+"  "+dempno);
					emppay.remove(i);
				}
			}
			
		}
		
	}
	
	//파일로 저장된 자료를 읽어 Pay class의 필드로 binding함 
	public void read_data_file() {
		
		String fpath="D:\\data\\";
		
		try {
			FileReader fr = new FileReader(fpath+"pay.dat");
			BufferedReader br = new BufferedReader(fr);
			
			String linebuf = "";
			while((linebuf=br.readLine())!=null) {
				
				String[] arrbuf = linebuf.split("\t");
				
				int Location = Integer.parseInt(arrbuf[0]);
				int Empno = Integer.parseInt(arrbuf[1]);
				String Yearmonth = arrbuf[2];
				int Amount = Integer.parseInt(arrbuf[3]);
				int Deduct = Integer.parseInt(arrbuf[4]);
				int Money = Integer.parseInt(arrbuf[5]);
				
				emppay.add(new Pay(Location,Empno,Yearmonth,Amount,Deduct,Money));
				
			}
		    br.close();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//파일로 저장된 자료를 읽어 PayAllowance class의 필드로 binding함 
	public void read_data_file1() {
		
		String fpath="D:\\data\\";
		
		try {
			FileReader fr = new FileReader(fpath+"payallow.dat");
			BufferedReader br = new BufferedReader(fr);
			
			String linebuf = "";
			while((linebuf=br.readLine())!=null) {
				
				String[] arrbuf = linebuf.split("\t");
				
				String jobpos = arrbuf[0];
				int baseamt = Integer.parseInt(arrbuf[1]);
				int jobposamt = Integer.parseInt(arrbuf[2]);
				
				payallow.add(new PayAllowance(jobpos, baseamt, jobposamt));
				
			}
		    br.close();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}	
	
	//Pay class의 필드 자료들을 파일로 저장함.
	public void write_date_file() {
		
		String fpath="D:\\data\\";
		
		if (emppay==null) {
			System.out.println("자료 Instance가 없습니다.");
			return;
		}
		
		try {
			
			FileWriter fw = new FileWriter(fpath+"pay.dat");
			BufferedWriter bw = new BufferedWriter(fw);
			
			Iterator<EmployeeId> iter = emppay.iterator();
			
			while(iter.hasNext()) {
				EmployeeId ep = iter.next();
				
				String sb="";
				sb+=((Pay)ep).getLocation()+"\t";
				sb+=((Pay)ep).getEmpno()+"\t";
				sb+=((Pay)ep).getYearmonth()+"\t";
				sb+=((Pay)ep).getAmount()+"\t";
				sb+=((Pay)ep).getDeduct()+"\t";
				sb+=((Pay)ep).getMoney()+"\r\n";
				
				bw.write(sb);
			}			
			bw.close();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	//PayAllowance class의 필드 자료들을 파일로 저장함.
	public void write_date_file1() {
		
		String fpath="D:\\data\\";
		
		if (payallow==null) {
			System.out.println("자료 Instance가 없습니다.");
			return;
		}
		
		try {
			
			FileWriter fw = new FileWriter(fpath+"payallow.dat");
			BufferedWriter bw = new BufferedWriter(fw);
			
			Iterator<PayAllowance> iter = payallow.iterator();
			
			while(iter.hasNext()) {
				PayAllowance pa = iter.next();
				
				String sb="";
				sb+=pa.getJobpos()+"\t";
				sb+=pa.getBaseamt()+"\t";
				sb+=pa.getJobposamt()+"\r\n";
				
				bw.write(sb);
			}			
			bw.close();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}	
	
	
	
	//삭제예정 ---------------------------------------------
	public void pay_add_batch() {

		
		payallow.add(new PayAllowance("10",100000,10000));
		payallow.add(new PayAllowance("20", 90000, 9000));
		payallow.add(new PayAllowance("30", 80000,8000));
		payallow.add(new PayAllowance("40",70000,7000));
		payallow.add(new PayAllowance("50",60000,6000));
		payallow.add(new PayAllowance("60",50000,5000));
		payallow.add(new PayAllowance("70",40000,4000));
		payallow.add(new PayAllowance("80",30000,3000));
		payallow.add(new PayAllowance("90",20000,2000));
			
	}
	
	
}



