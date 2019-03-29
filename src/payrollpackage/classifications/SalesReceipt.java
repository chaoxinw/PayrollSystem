package payrollpackage.classifications;
import java.util.Date;

public class SalesReceipt {
	private Date itsDate;
	private double itsAmount;
	
	public SalesReceipt(Date date, double amount) {
		this.itsDate = date;
		this.itsAmount = amount;
	}

	public Date getDate() {
		return itsDate;
	}

	public double getAmount() {
		return itsAmount;
	}
	
	
}
