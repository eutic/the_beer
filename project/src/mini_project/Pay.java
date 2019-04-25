package mini_project;


public class Pay extends EmployeeId {

	private String yearmonth;    //년월
	private int amount;          //급여
	private int deduct;          //공제금액
	private int money;           //실지급액

	
	public Pay(int location, int empno, String yearmonth, int amount, int deduct, int money) {
		super(location, empno);
		this.yearmonth = yearmonth;
		this.amount = amount;
		this.deduct = deduct;
		this.money = money;
	}

	public String getYearmonth() {
		return yearmonth;
	}

	public void setYearmonth(String yearmonth) {
		this.yearmonth = yearmonth;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getDeduct() {
		return deduct;
	}

	public void setDeduct(int deduct) {
		this.deduct = deduct;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	@Override
	public int getNumbering(int loc) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		return "Pay [getLocation()=" + getLocation() + ", getEmpno()=" + getEmpno() + ", yearmonth=" + yearmonth
				+ ", amount=" + amount + ", deduct=" + deduct + ", money=" + money + "]";
	}

	
}
