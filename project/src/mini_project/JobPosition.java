package mini_project;

public class JobPosition {

	private String jobpos;	//직급코드

	private String jobposName;	//직급이름

	public JobPosition() {
	}

	public JobPosition(String jobpos, String jobposName) {
		super();
		this.jobpos = jobpos;
		this.jobposName = jobposName;
	}

	public String getJobpos() {
		return jobpos;
	}

	public void setJobpos(String jobpos) {
		this.jobpos = jobpos;
	}

	public String getJobposName() {
		return jobposName;
	}

	public void setJobposName(String jobposName) {
		this.jobposName = jobposName;
	}

	@Override
	public String toString() {
		return "JobPosition [jobpos=" + jobpos + ", jobposName=" + jobposName + "]";
	}

	public void add(String jobpos2) {
		// TODO Auto-generated method stub

	}

}