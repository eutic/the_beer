package mini_project;

import java.util.List;

import javax.tools.Tool;

/*
 *   작성자 : 박승호 (ver 1.3)
 * 
 */
public class CommonMethod {

	
	//부서코드의 부서명
	public String dept_desc(String code, List<?> obj) {
		
		String rtv = "";
		for (int i=0;i<obj.size();i++) {
			if(code == ((List<Department>)obj).get(i).getDept()) {
				rtv = ((List<Department>)obj).get(i).getDeptName();
				break;
			}
		}
		return rtv;
	}	

	
	
	//부서코드, 부서명 List 
	public String[][] dept_list(List<?> obj, boolean dp) {
		
		int rows = obj.size();

		String[][] rtv = new String[rows][2]; 

		for (int i=0;i<obj.size();i++) {
			rtv[i][0] = ((List<Department>)obj).get(i).getDept();
			rtv[i][1] = ((List<Department>)obj).get(i).getDeptName();
		}
		
		if (dp) {
			System.out.println("\t\t*-- 부서 List --*");
			for(int i=0;i<rtv.length;i++) {
				System.out.println("\t\t"+rtv[i][0]+" "+rtv[i][1]);
			}
		}		
		return rtv;
	}		
	
	
	//직책코드의 직책명
	public String jobpos_desc(String code, List<?> obj) {
		
		String rtv = "";
		for (int i=0;i<obj.size();i++) {
			if(code == ((List<JobPosition>)obj).get(i).getJobpos()) {
				rtv = ((List<JobPosition>)obj).get(i).getJobposName();
				break;
			}
		}
		return rtv;
	}	
	
	
	//직책코드, 직책명 List
	public String[][] jobpos_list(List<?> obj, boolean dp) {
		
		int rows = obj.size();

		String[][] rtv = new String[rows][2]; 
		
		for (int i=0;i<obj.size();i++) {
			rtv[i][0] = ((List<JobPosition>)obj).get(i).getJobpos();
			rtv[i][1] = ((List<JobPosition>)obj).get(i).getJobposName();
		}
		
		if (dp) {
			System.out.println("\t\t*-- 직책 List --*");
			for(int i=0;i<rtv.length;i++) {
				System.out.println("\t\t"+rtv[i][0]+" "+rtv[i][1]);
			}
		}
		
		return rtv;
	}		

	//사번 자동부여
	public int getNewEmpno(List<?> obj,int loc) {
		
		int max_empno=0;
		
		for (int i=0;i<obj.size();i++) {
			if (loc == ((Employee)obj.get(i)).getLocation()) {
				if (max_empno < ((Employee)obj.get(i)).getEmpno()) 
					max_empno = ((Employee)obj.get(i)).getEmpno();
			}
		}
		
		if(max_empno==0) max_empno = loc * 1000;
		
		max_empno++;
		
		return max_empno;
	}
	
}
