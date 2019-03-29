package payrollpackage.affiliationTransactions;

import payrollpackage.affiliations.UnionAffiliation;
import payrollpackage.payrollDatabase.PayrollDatabase;
import payrollpackage.payrollDomain.Affiliation;
import payrollpackage.payrollDomain.Employee;

public class ChangeMemberTransaction extends ChangeAffiliationTransaction {
	
	private int itsMemberId;
	private double itsDues;
	
	public ChangeMemberTransaction(int empid, int memberId, double dues) {
		super(empid);
		this.itsMemberId = memberId;
		this.itsDues = dues;
	}

	@Override
	public void recordMembership(Employee e) {
		// TODO Auto-generated method stub
		PayrollDatabase.addUnionMember(itsMemberId, e);
		
	}

	@Override
	public Affiliation getAffiliation() {
		// TODO Auto-generated method stub
		return new UnionAffiliation(itsMemberId, itsDues);
	}
	
	

}
