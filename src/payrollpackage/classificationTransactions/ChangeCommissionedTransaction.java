package payrollpackage.classificationTransactions;

import payrollpackage.classifications.CommissionedClassification;
import payrollpackage.payrollDomain.PaymentClassification;
import payrollpackage.payrollDomain.PaymentSchedule;
import payrollpackage.schedules.BiweeklySchedule;

public class ChangeCommissionedTransaction extends ChangeClassificationTransaction {
	private double itsSalary;
	private double itsCommissionRate;
	
	public ChangeCommissionedTransaction(int empid, double salary, double commissionRate) {
		super(empid);
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
