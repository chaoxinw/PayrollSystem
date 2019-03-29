package payrollpackage.affiliations;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

import payrollpackage.generalTransactions.Paycheck;
import payrollpackage.payrollDomain.Affiliation;

public class UnionAffiliation extends Affiliation {
	private int itsMemberId;
	private double itsDues;
	private ArrayList<ServiceCharge> itsServiceCharges = new ArrayList<ServiceCharge>();
	
	public UnionAffiliation(int memberId, double dues) {
		this.itsMemberId = memberId;
		this.itsDues = dues;
	}
	
	public double calculateDeductions(Paycheck pc) {
		double totalDues = 0;
		
		//int fridays = numberOfFridaysInPayPeriod(pc.getPayPeriodStartDate(), pc.getPayPeriodEndDate());
		int fridays = 1;
		totalDues = itsDues * fridays + calculateServiceCharges(pc);
		return totalDues;
	}
	
	
	public double calculateServiceCharges(Paycheck pc) {
		double totalPay = 0;
		Date payPeriod = pc.getItsPayDate();
		
		Iterator<ServiceCharge> itr = itsServiceCharges.iterator();
		while (itr.hasNext()) {
			ServiceCharge sc = itr.next();
			if (isInPayPeriod(sc, payPeriod)) {
				totalPay += sc.getAmount();
			}
		}
		return totalPay;
	}
	
	public boolean isInPayPeriod(ServiceCharge sc, Date payPeriod) {
		Date payPeriodEndDate = payPeriod;
		
		Date date2 = new Date();
		Calendar c = Calendar.getInstance(); 
		c.setTime(payPeriod); 
		c.add(Calendar.DATE, -5);
		date2 = c.getTime();
		
		Date payPeriodStartDate = date2;
		Date serviceChargeDate = sc.getDate();
		return (serviceChargeDate.after(payPeriodStartDate) && serviceChargeDate.before(payPeriodEndDate));
	}
	
	public void addServiceCharge(ServiceCharge sc) {
		itsServiceCharges.add(sc);
	}
	
}
