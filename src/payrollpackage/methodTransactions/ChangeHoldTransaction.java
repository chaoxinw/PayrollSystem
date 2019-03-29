package payrollpackage.methodTransactions;

import payrollpackage.methods.HoldMethod;
import payrollpackage.payrollDomain.PaymentMethod;

public class ChangeHoldTransaction extends ChangeMethodTransaction {
	
	public ChangeHoldTransaction(int empid) {
		super(empid);
	}

	@Override
	public PaymentMethod getMethod() {
		// TODO Auto-generated method stub
		return new HoldMethod();
	}
	
	

}
