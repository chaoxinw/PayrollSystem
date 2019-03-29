package payrollpackage.generalTransactions;

import payrollpackage.classifications.HourlyClassification;
import payrollpackage.payrollDomain.PaymentClassification;
import payrollpackage.payrollDomain.PaymentSchedule;
import payrollpackage.schedules.WeeklySchedule;

public class AddHourlyEmployee extends AddEmployeeTransaction{
	private double itsHourlyRate;
	
	public AddHourlyEmployee(int empid, String name, String address, double hourlyRate) {
		super(empid, name, address);
		this.itsHourlyRate = hourlyRate;
	}
	
	@Override
	public PaymentClassification getClassification() {
		// TODO Auto-generated method stub
		return new HourlyClassification(itsHourlyRate);
	}

	@Override
	public PaymentSchedule getSchedule() {
		// TODO Auto-generated method stub
		return new WeeklySchedule();
	}

}
