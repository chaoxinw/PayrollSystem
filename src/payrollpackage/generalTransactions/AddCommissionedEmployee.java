package payrollpackage.generalTransactions;

import payrollpackage.classifications.CommissionedClassification;
import payrollpackage.payrollDomain.PaymentClassification;
import payrollpackage.payrollDomain.PaymentSchedule;
import payrollpackage.schedules.BiweeklySchedule;

public class AddCommissionedEmployee extends AddEmployeeTransaction {
	private double itsSalary;
	private double itsCommissionRate;
	
	public AddCommissionedEmployee(int empid, String name, String address, double salary, double commissionRate) {
		super(empid, name, address);
		this.itsSalary = salary;
		this.itsCommissionRate = commissionRate;
	}
	
	@Override
	public PaymentClassification getClassification() {
		// TODO Auto-generated method stub
		return new CommissionedClassification(itsSalary, itsCommissionRate);
	}

	@Override
	public PaymentSchedule getSchedule() {
		// TODO Auto-generated method stub
		return new BiweeklySchedule();
	}

}
