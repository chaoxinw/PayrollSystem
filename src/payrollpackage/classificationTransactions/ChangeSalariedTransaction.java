package payrollpackage.classificationTransactions;

import payrollpackage.classifications.SalariedClassification;
import payrollpackage.payrollDomain.PaymentClassification;
import payrollpackage.payrollDomain.PaymentSchedule;
import payrollpackage.schedules.MonthlySchedule;

public class ChangeSalariedTransaction extends ChangeClassificationTransaction {
	private double itsSalary;
	
	public ChangeSalariedTransaction(int empid, double salary) {
		super(empid);
		this.itsSalary = salary;
	}

	@Override
	public PaymentClassification getClassification() {
		// TODO Auto-generated method stub
		return new SalariedClassification(itsSalary);
	}

	@Override
	public PaymentSchedule getSchedule() {
		// TODO Auto-generated method stub
		return new MonthlySchedule();
	}
	


}
