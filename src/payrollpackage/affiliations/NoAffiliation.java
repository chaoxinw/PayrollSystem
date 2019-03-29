package payrollpackage.affiliations;

import payrollpackage.generalTransactions.Paycheck;
import payrollpackage.payrollDomain.Affiliation;

public class NoAffiliation extends Affiliation {
	
	public NoAffiliation() {}

	@Override
	public double calculateDeductions(Paycheck pc) {
		// TODO Auto-generated method stub
		return 0;
	}

}
