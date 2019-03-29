package payrollpackage.payrollDomain;

import payrollpackage.generalTransactions.Paycheck;

public abstract class PaymentClassification {
	public abstract double calculatePay(Paycheck pc);
}
