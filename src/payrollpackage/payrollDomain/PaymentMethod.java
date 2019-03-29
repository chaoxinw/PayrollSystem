package payrollpackage.payrollDomain;

import payrollpackage.generalTransactions.Paycheck;

public abstract class PaymentMethod {
	public abstract void pay(Paycheck pc);
}
