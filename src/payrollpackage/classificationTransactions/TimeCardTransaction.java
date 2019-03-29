package payrollpackage.classificationTransactions;
import java.util.Date;

import payrollpackage.classifications.HourlyClassification;
import payrollpackage.classifications.TimeCard;
import payrollpackage.payrollDatabase.PayrollDatabase;
import payrollpackage.payrollDomain.Employee;
import payrollpackage.payrollDomain.PaymentClassification;
import payrollpackage.payrollDomain.Transaction;

public class TimeCardTransaction extends Transaction {
	private int itsEmpid;
	private Date itsDate;
	private double itsHours;
	
	public TimeCardTransaction(Date date, double hours, int empid) {
		this.itsDate = date;
		this.itsHours = hours;
		this.itsEmpid = empid;
	}
	
	public void execute() {
		Employee e = PayrollDatabase.getEmployee(itsEmpid);
		if (!e.equals(null)) {
			PaymentClassification pc = e.getClassification();
			//if the employee is paid on hourly basis -- hourly classification
			if (pc instanceof HourlyClassification) {
				HourlyClassification hc = (HourlyClassification) pc;
				hc.addTimeCard(new TimeCard(itsDate, itsHours));
			} else {
				throw new Error("Tried to add timecard to non-hourly employee");
			}
		} else {
			throw new Error("No such employee");
		}
	}

}
