package payrollpackage.classifications;

import payrollpackage.generalTransactions.Paycheck;
import payrollpackage.payrollDomain.PaymentClassification;

public class SalariedClassification extends PaymentClassification {
	private double itsSalary;
	
	public SalariedClassification(double salary) {
		this.itsSalary = salary;
	}

	@Override
	public double calculatePay(Paycheck pc) {
		// TODO Auto-generated method stub
		return itsSalary;
	}

}
