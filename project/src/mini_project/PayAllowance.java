package mini_project;

public class PayAllowance {
	String jobpos;
	int    baseamt;    //기본급
	int    jobposamt;  //직책수당
	
	
	public PayAllowance(String jobpos, int baseamt, int jobposamt) {
		this.jobpos = jobpos;
		this.baseamt = baseamt;
		this.jobposamt = jobposamt;
	}

	public String getJobpos() {
		return jobpos;
	}

	public void setJobpos(String jobpos) {
		this.jobpos = jobpos;
	}

	public int getBaseamt() {
		return baseamt;
	}

	public void setBaseamt(int baseamt) {
		this.baseamt = baseamt;
	}

	public int getJobposamt() {
		return jobposamt;
	}

	public void setJobposamt(int jobposamt) {
		this.jobposamt = jobposamt;
	}

	@Override
	public String toString() {
		return "PayAllowance [jobpos=" + jobpos + ", baseamt=" + baseamt + ", jobposamt=" + jobposamt + "]";
	}
	
	
}
