package payrollpackage.affiliations;
import java.util.Date;

public class ServiceCharge {
	private Date itsDate;
	private double itsAmount;
	
	public ServiceCharge(Date date, double amount) {
		this.itsDate = date;
		this.itsAmount = amount;
	}

	public double getAmount() {
		return itsAmount;
	}

	public Date getDate() {
		return itsDate;
	}
	
	
}
