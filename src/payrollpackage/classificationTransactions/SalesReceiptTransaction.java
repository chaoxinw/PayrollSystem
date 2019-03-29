package payrollpackage.classificationTransactions;
import java.util.Date;

import payrollpackage.classifications.CommissionedClassification;
import payrollpackage.classifications.SalesReceipt;
import payrollpackage.payrollDatabase.PayrollDatabase;
import payrollpackage.payrollDomain.Employee;
import payrollpackage.payrollDomain.PaymentClassification;
import payrollpackage.payrollDomain.Transaction;

public class SalesReceiptTransaction extends Transaction {
	
	private Date itsDate;
	private double itsAmount;
	private int itsEmpid;
	
	public SalesReceiptTransaction(Date date, double amount, int empid) {
		this.itsDate = date;
		this.itsAmount = amount;
		this.itsEmpid = empid;
	}
	
	public void execute() {
		Employee e = PayrollDatabase.getEmployee(itsEmpid);
		if (!e.equals(null)) {
			PaymentClassification pc = e.getClassification();
			//if the employee is paid on hourly basis -- hourly classification
			if (pc instanceof CommissionedClassification) {
				CommissionedClassification cc = (CommissionedClassification) pc;
				cc.addSalesReceipt(new SalesReceipt(itsDate, itsAmount));
			} else {
				throw new Error("Tried to add salesreceipt to non-commissioned employee");
			}
		} else {
			throw new Error("No such employee");
		}
	}
}
