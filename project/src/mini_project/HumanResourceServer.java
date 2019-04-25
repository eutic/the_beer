package mini_project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class HumanResourceServer {

	
	EmployeeClient ec = new EmployeeClient();
	PayClient pc = new PayClient();
	DeptClient dc = new DeptClient();
	JobposClient jc = new JobposClient();
	
	List<Employee> ls_emp = ec.em.employees;
	List<Department> ls_dept = dc.ds.depts;
	List<JobPosition> ls_jobpos = jc.js.jobposes;
	
	Scanner scanner = new Scanner(System.in);
	
	
	   //급여관리 호출
		public void pay_management() {
			//pc.pay_main(dc.ds.depts);
			pc.pay_main(ls_emp,ls_dept);
		}
	
	   //인사관리 호출
		public void emp_management() {
			ec.emp_main(ls_dept,ls_jobpos);
		}	

	   //부서코드관리 호출
		public void dept_management() {
			dc.dapt_main();
		}	
		
	   //직급코드관리 호출
		public void jobpos_management() {
			jc.jobpos_main();
		}			

	   //현황관리 호출
		public void report_management() {
			System.out.println("작업 진행 중입니다.");
		}			
		
}
