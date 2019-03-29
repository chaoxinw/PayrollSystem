package payrollpackage.generalTransactions;
import java.util.Date;

public class Paycheck {
	
	private Date itsPayDate;
	private double itsGrossPay;
	private double itsDeduction;
	private double itsNetPay;
	
	
	public Paycheck(Date payDate) {
		this.itsPayDate = payDate;
	}


	public double getItsGrossPay() {
		return itsGrossPay;
	}


	public void setItsGrossPay(double itsGrossPay) {
		this.itsGrossPay = itsGrossPay;
	}


	public double getItsDeduction() {
		return itsDeduction;
	}


	public void setItsDeduction(double itsDeduction) {
		this.itsDeduction = itsDeduction;
	}


	public double getItsNetPay() {
		return itsNetPay;
	}


	public void setItsNetPay(double itsNetPay) {
		this.itsNetPay = itsNetPay;
	}


	public Date getItsPayDate() {
		return itsPayDate;
	}
	
	

}
