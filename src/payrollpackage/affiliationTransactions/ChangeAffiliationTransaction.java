package payrollpackage.affiliationTransactions;

import payrollpackage.generalTransactions.ChangeEmployeeTransaction;
import payrollpackage.payrollDomain.Affiliation;
import payrollpackage.payrollDomain.Employee;

public abstract class ChangeAffiliationTransaction extends ChangeEmployeeTransaction {
	
	public ChangeAffiliationTransaction(int empid) {
		super(empid);
	}
	
	public abstract void recordMembership(Employee e);
	public abstract Affiliation getAffiliation();
	
	public void change(Employee e) {
		recordMembership(e);
		e.setAffiliation(getAffiliation());
	}

}
