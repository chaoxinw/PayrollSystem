package payrollpackage.generalTransactions;

import payrollpackage.classifications.SalariedClassification;
import payrollpackage.payrollDomain.PaymentClassification;
import payrollpackage.payrollDomain.PaymentSchedule;
import payrollpackage.schedules.MonthlySchedule;

public class AddSalariedEmployee extends AddEmployeeTransaction{

	private double itsSalary;
	
	public AddSalariedEmployee(int empid, String name, String address, double salary) {
		super(empid, name, address);
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
