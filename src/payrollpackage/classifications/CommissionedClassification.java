package payrollpackage.classifications;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

import payrollpackage.generalTransactions.Paycheck;
import payrollpackage.payrollDomain.PaymentClassification;

public class CommissionedClassification extends PaymentClassification {
	private double itsSalary;
	private double itsCommissionRate;
	private ArrayList<SalesReceipt> itsSalesReceipts;
	
	public CommissionedClassification(double salary, double commissionRate) {
		this.itsSalary = salary;
		this.itsCommissionRate = commissionRate;
	}
	
	public double calculatePay(Paycheck pc) {
		double totalPay = 0;
		Date payPeriod = pc.getItsPayDate();
		
		Iterator<SalesReceipt> itr = itsSalesReceipts.iterator();
		while (itr.hasNext()) {
			SalesReceipt sr = itr.next();
			if (isInPayPeriod(sr, payPeriod)) {
				totalPay += calculatePayForSalesReceipt(sr);
			}
		}
		return totalPay + itsSalary;
	}
	
	public boolean isInPayPeriod(SalesReceipt sc, Date payPeriod) {
		Date payPeriodEndDate = payPeriod;
		
		Date date2 = new Date();
		Calendar c = Calendar.getInstance(); 
		c.setTime(payPeriod); 
		c.add(Calendar.DATE, - 12);
		date2 = c.getTime();
		
		Date payPeriodStartDate = date2;
		Date salesReceiptDate = sc.getDate();
		return (salesReceiptDate.after(payPeriodStartDate) && salesReceiptDate.before(payPeriodEndDate));
	}
	
	public double calculatePayForSalesReceipt(SalesReceipt sc) {
		double amount = sc.getAmount();
		return amount * itsCommissionRate;
	}
	
	public void addSalesReceipt(SalesReceipt sr) {
		itsSalesReceipts.add(sr);
	}

}
