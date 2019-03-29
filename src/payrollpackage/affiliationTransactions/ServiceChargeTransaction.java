package payrollpackage.affiliationTransactions;
import java.util.Date;

import payrollpackage.affiliations.ServiceCharge;
import payrollpackage.affiliations.UnionAffiliation;
import payrollpackage.payrollDatabase.PayrollDatabase;
import payrollpackage.payrollDomain.Affiliation;
import payrollpackage.payrollDomain.Employee;
import payrollpackage.payrollDomain.Transaction;

public class ServiceChargeTransaction extends Transaction {
	private int itsMemberId;
	private Date itsDate;
	private double itsCharge;
	
	public ServiceChargeTransaction(int memberId, Date date, double charge) {
		this.itsMemberId = memberId;
		this.itsDate = date;
		this.itsCharge = charge;
	}
	
	public void execute() {
		Employee e = PayrollDatabase.getUnionMember(itsMemberId);
		Affiliation af = e.getAffiliation();
		if (af instanceof UnionAffiliation) {
			UnionAffiliation uaf = (UnionAffiliation) af;
			uaf.addServiceCharge(new ServiceCharge(itsDate, itsCharge));
		}
	}

}
