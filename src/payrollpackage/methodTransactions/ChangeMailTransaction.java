package payrollpackage.methodTransactions;

import payrollpackage.methods.MailMethod;
import payrollpackage.payrollDomain.PaymentMethod;

public class ChangeMailTransaction extends ChangeMethodTransaction {
	private String itsAddress;
	
	public ChangeMailTransaction(int empid, String address) {
		super(empid);
		this.itsAddress = address;
	}

	@Override
	public PaymentMethod getMethod() {
		// TODO Auto-generated method stub
		return new MailMethod(itsAddress);
	}
	
	

}
