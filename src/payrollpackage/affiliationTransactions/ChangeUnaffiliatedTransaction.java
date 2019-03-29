package payrollpackage.affiliationTransactions;

import payrollpackage.affiliations.NoAffiliation;
import payrollpackage.affiliations.UnionAffiliation;
import payrollpackage.payrollDatabase.PayrollDatabase;
import payrollpackage.payrollDomain.Affiliation;
import payrollpackage.payrollDomain.Employee;

public class ChangeUnaffiliatedTransaction extends ChangeAffiliationTransaction {
	
	public ChangeUnaffiliatedTransaction(int empid) {
		super(empid);
	}

	@Override
	public void recordMembership(Employee e) {
		// TODO Auto-generated method stub
		Affiliation af = e.getAffiliation();
		if (af instanceof UnionAffiliation) {
			UnionAffiliation uf = (UnionAffiliation) af;
			int memberId = e.getEmpid();
			PayrollDatabase.removeUnionMember(memberId);
		}
	}

	@Override
	public Affiliation getAffiliation() {
		// TODO Auto-generated method stub
		return new NoAffiliation();
	}
	
	

}
