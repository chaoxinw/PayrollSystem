package payrollpackage.classificationTransactions;

import payrollpackage.classifications.HourlyClassification;
import payrollpackage.payrollDomain.PaymentClassification;
import payrollpackage.payrollDomain.PaymentSchedule;
import payrollpackage.schedules.WeeklySchedule;

public class ChangeHourlyTransaction extends ChangeClassificationTransaction {
	private double itsHourlyRate;
	
	public ChangeHourlyTransaction(int empid, double hourlyRate) {
		super(empid);
		this.itsHourlyRate = hourlyRate;
	}
	
	@Override
	public PaymentClassification getClassification() {
		return new HourlyClassification(itsHourlyRate);
	}
	
	@Override
	public PaymentSchedule getSchedule() {
		return new WeeklySchedule();
	}

}
