package payrollpackage.classifications;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

import payrollpackage.generalTransactions.Paycheck;
import payrollpackage.payrollDomain.PaymentClassification;

public class HourlyClassification extends PaymentClassification {
	private double itsHourlyRate;
	private ArrayList<TimeCard> itsTimeCards = new ArrayList<TimeCard>();
	
	public HourlyClassification(double hourlyRate) {
		this.itsHourlyRate = hourlyRate;
	}
	
	
	public double getHourlyRate() {
		return itsHourlyRate;
	}


	public double calculatePay(Paycheck pc) {
		double totalPay = 0;
		Date payPeriod = pc.getItsPayDate();
		
		Iterator<TimeCard> itr = itsTimeCards.iterator();
		while (itr.hasNext()) {
			TimeCard tc = itr.next();
			if (isInPayPeriod(tc, payPeriod)) {
				totalPay += calculatePayForTimeCard(tc);
			}
		}
		return totalPay;
	}
	
	public boolean isInPayPeriod(TimeCard tc, Date payPeriod) {
		Date payPeriodEndDate = payPeriod;
		
		Date date2 = new Date();
		Calendar c = Calendar.getInstance(); 
		c.setTime(payPeriod); 
		c.add(Calendar.DATE, -5);
		date2 = c.getTime();
		
		Date payPeriodStartDate = date2;
		Date timeCardDate = tc.getDate();
		return (timeCardDate.after(payPeriodStartDate) && timeCardDate.before(payPeriodEndDate));
	}
	
	public double calculatePayForTimeCard(TimeCard tc) {
		double hours = tc.getHours();
		double overtime = Math.max(0.0, hours - 8.0);
		double straightTime = hours - overtime;
		return straightTime * itsHourlyRate + overtime * itsHourlyRate * 1.5;
	}
	
	public void addTimeCard(TimeCard tc) {
		itsTimeCards.add(tc);
	}
	
}
