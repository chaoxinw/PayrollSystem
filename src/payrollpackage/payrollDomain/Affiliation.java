package payrollpackage.payrollDomain;

import payrollpackage.generalTransactions.Paycheck;

public abstract class Affiliation {
	public abstract double calculateDeductions(Paycheck pc);
}
